package bd.gov.dgfood.headless.common.delivery.internal.resource.v1_0;

import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.Authenticator;
import com.liferay.portal.kernel.service.PasswordPolicyLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.persistence.PasswordPolicyUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

import bd.gov.dgfood.common.util.constants.CommonConstants;
import bd.gov.dgfood.headless.common.delivery.dto.v1_0.ChangePassword;
import bd.gov.dgfood.headless.common.delivery.dto.v1_0.ForgetPassword;
import bd.gov.dgfood.headless.common.delivery.dto.v1_0.UserResponse;
import bd.gov.dgfood.headless.common.delivery.resource.v1_0.UserResponseResource;



/**
 * @author DEV
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0/user-response.properties", scope = ServiceScope.PROTOTYPE, service = UserResponseResource.class)
public class UserResponseResourceImpl extends BaseUserResponseResourceImpl {

	@Override
	public UserResponse getLogin(String nid, String password, String lang) throws Exception {
		UserResponse userResponse = new UserResponse();
		int authResult = Authenticator.FAILURE;
		try {

			if (validateParam(nid, password)) {
				String authType = CompanyConstants.AUTH_TYPE_SN;
				Map<String, String[]> headerMap = new HashMap();

				Enumeration<String> headerNames = contextHttpServletRequest.getHeaderNames();
				while (headerNames.hasMoreElements()) {
					String name = headerNames.nextElement();

					Enumeration<String> headersEnum = contextHttpServletRequest.getHeaders(name);

					List<String> headers = new ArrayList<String>();

					while (headersEnum.hasMoreElements()) {
						String value = headersEnum.nextElement();

						headers.add(value);
					}

					headerMap.put(name, headers.toArray(new String[0]));
				}

				Map<String, String[]> parameterMap = contextHttpServletRequest.getParameterMap();
				Map<String, Object> resultsMap = new HashMap<>();

				if (Validator.isNull(authType)) {
					authType = contextCompany.getAuthType();
				}

				if (authType.equals(CompanyConstants.AUTH_TYPE_EA)) {
					authResult = UserLocalServiceUtil.authenticateByEmailAddress(contextCompany.getCompanyId(), nid,
							password, headerMap, parameterMap, resultsMap);
				} else if (authType.equals(CompanyConstants.AUTH_TYPE_SN)) {
					authResult = UserLocalServiceUtil.authenticateByScreenName(contextCompany.getCompanyId(), nid,
							password, headerMap, parameterMap, resultsMap);
				} else if (authType.equals(CompanyConstants.AUTH_TYPE_ID)) {
					authResult = UserLocalServiceUtil.authenticateByUserId(contextCompany.getCompanyId(),
							GetterUtil.getLong(nid), password, headerMap, parameterMap, resultsMap);
				}
				if (authResult == Authenticator.FAILURE) {
					userResponse.setApiStatus(authResult);
					userResponse.setMessage("Authontication failed");
					userResponse.setStatusCode(HttpServletResponse.SC_UNAUTHORIZED);
				} else if (authResult == Authenticator.DNE) {
					userResponse.setApiStatus(authResult);
					userResponse.setMessage("Authontication denied");
					userResponse.setStatusCode(HttpServletResponse.SC_FORBIDDEN);
				} else if (authResult == Authenticator.SUCCESS) {
					userResponse.setApiStatus(authResult);
					userResponse.setStatusCode(HttpServletResponse.SC_OK);
					userResponse.setMessage("Authontication Successful");
				}
				_log.info("Authentication result for " + nid + " : " + userResponse.getMessage());
			}
		} catch (Exception e) {
			userResponse.setApiStatus(authResult);
			userResponse.setStatusCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			userResponse.setMessage(e.getMessage());
			_log.error(e.getMessage());
			return userResponse;
		}

		return userResponse;
	}

	@Override
	public UserResponse postChangePassword(ChangePassword changePassword) throws Exception {

		UserResponse userResponse = new UserResponse();
		try {
			String nid = changePassword.getNid();
			String password = changePassword.getOldPassword();
			String newPassword = changePassword.getNewPassword();
			String confirmPassword = changePassword.getConfirmPassword();
			String lang = changePassword.getLang();
			String authType = CompanyConstants.AUTH_TYPE_SN;
			if (validateChangePassword(newPassword, confirmPassword)) {
				if (validateParam(nid, newPassword)) {
					User user = null;

					UserResponse apiResponse = getLogin(nid, password, lang);
					if (apiResponse.getStatusCode() == 200) {
						user = getUser(nid, authType, contextCompany.getCompanyId());
					} else {
						userResponse.setApiStatus(apiResponse.getApiStatus());
						userResponse.setMessage("Authontication failed");
						userResponse.setStatusCode(HttpServletResponse.SC_UNAUTHORIZED);
					}

					if (Validator.isNotNull(user)) {

						user = UserLocalServiceUtil.updatePassword(user.getUserId(), newPassword, confirmPassword,
								false); // UserLocalServiceUtil.updatepas
						UserLocalServiceUtil.checkLockout(user);
						if (Validator.isNotNull(user)) {
							userResponse.setApiStatus(HttpServletResponse.SC_ACCEPTED);
							userResponse.setStatusCode(HttpServletResponse.SC_OK);
							userResponse.setMessage("Password Changed Successful");
							return userResponse;
						}
					}
				}
			} else {
				userResponse.setApiStatus(Authenticator.FAILURE);
				userResponse.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
				userResponse.setMessage("Request Rejected");
				return userResponse;
			}
		} catch (Exception e) {
			userResponse.setApiStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			userResponse.setStatusCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			userResponse.setMessage(e.getMessage());
			_log.error(e.getMessage());
			return userResponse;
		}
		return userResponse;
	}

	@Override
	public UserResponse postForgetPassword(ForgetPassword forgetPassword) throws Exception {
		UserResponse userResponse = new UserResponse();
		try {
			String nid = forgetPassword.getNid();
			Date dob = forgetPassword.getDateOfBirth();
			String lng = forgetPassword.getLang();
			long mobileNo = forgetPassword.getMobileNumber();
			String authType = CompanyConstants.AUTH_TYPE_SN;
			if (validateNationalId(nid, true, CommonConstants.NATIONAL_ID) && validateForgetPassword(mobileNo, dob)) {
				User user = getUser(nid, authType, contextCompany.getCompanyId());
				Date userDob = user.getBirthday();
				if (dob.compareTo(userDob) == 0) {
					userResponse.setApiStatus(Authenticator.SUCCESS);
					userResponse.setStatusCode(HttpServletResponse.SC_OK);
					userResponse.setMessage("OTP send to your register mobile number");
					return userResponse;
				} else {
					userResponse.setApiStatus(Authenticator.DNE);
					userResponse.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
					userResponse.setMessage("Details not matched!");
					return userResponse;
				}
			} 
		} catch (Exception e) {
			userResponse.setApiStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			userResponse.setStatusCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			userResponse.setMessage(e.getMessage());
			_log.error(e.getMessage());
			return userResponse;

		}
		return userResponse;
	}

	public User getUser(String nationalId, String authType, long companyId) {
		try {
			User user = null;

			if (Validator.isNotNull(nationalId)) {

				if (authType.equals(CompanyConstants.AUTH_TYPE_EA)) {
					user = UserLocalServiceUtil.getUserByEmailAddress(companyId, nationalId);
				} else if (authType.equals(CompanyConstants.AUTH_TYPE_SN)) {
					user = UserLocalServiceUtil.getUserByScreenName(companyId, nationalId);
				} else if (authType.equals(CompanyConstants.AUTH_TYPE_ID)) {
					user = UserLocalServiceUtil.getUserById(Long.parseLong(nationalId));
				} else {
					throw new NoSuchUserException("User does not exist");
				}

				return user;
			}
		} catch (Exception exception) {
			_log.error(exception.getMessage());
		}

		return null;
	}

	public static boolean validateNationalId(String nationalId, boolean isMandatory, String fildName) throws Exception {
		_log.debug("Validate the input nationalId: " + fildName);
		if (isMandatory && Validator.isNull(nationalId)) {
			throw new Exception(fildName + "CAN_NOT_BE_BLANK");
		}

		if (nationalId.length() <= 10 || nationalId.length() >= 17) {
			throw new Exception(fildName + "-length-should-be-ten-or-seventeen");
		}

		return true;
	}

	private boolean validateParam(String nid, String password) throws Exception {
		if (Validator.isNotNull(nid) && Validator.isNotNull(password)) {
			boolean nidValid = validateNationalId(nid, true, CommonConstants.NATIONAL_ID);
			if (nidValid) {
				String regex = PasswordPolicyUtil.fetchByC_DP(contextCompany.getCompanyId(), true).getRegex();//"^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
				if (password.matches(regex)) {
					return true;
				} else {
					throw new Exception(
							"pasword should be contain at least 8 characters, one digit,one upper case alphabet,one lower case alphabet,one special character and doesn’t contain any white space. ");
				}
			}
		} else {
			throw new Exception("NationalId and Password can not be empty");
		}
		return false;
	}

	private boolean validateChangePassword(String newPassword, String confirmPassword) throws Exception {
		if (Validator.isNotNull(newPassword) && Validator.isNotNull(confirmPassword)) {
			if (newPassword.equals(confirmPassword))
				return true;
			else {
				throw new Exception("New Password and Confirm Password should be same");
			}
		} else {
			throw new Exception("New Password and Confirm Password can bot be empty");
		}
	}

	private boolean validateForgetPassword(long phoneNumber, Date dob) throws Exception {
		if (Validator.isNotNull(phoneNumber)) {
			int phoneNumberLnth = String.valueOf(phoneNumber).length();
			_log.info(phoneNumberLnth);
			if (phoneNumberLnth <= 10 && phoneNumberLnth >= 12) {
				throw new Exception("Phone Number should be 10 or 12 digit");
			}
		} else {
			throw new Exception("Phone Number can not be empty");
		}
		if (Validator.isNull(dob)) {
			throw new Exception("Date of Birth can not be empty");
		}
		return true;
	}

	private static final Log _log = LogFactoryUtil.getLog(UserResponseResourceImpl.class);
}