package bd.gov.dgfood.override.mvc.command.api;

import com.liferay.login.web.constants.LoginPortletKeys;
import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.UserActiveException;
import com.liferay.portal.kernel.exception.UserPasswordException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.SimpleDateFormat;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(property = { "javax.portlet.name=" + LoginPortletKeys.FAST_LOGIN,
		"javax.portlet.name=" + LoginPortletKeys.LOGIN, "mvc.command.name=/dg/login/forgot_password",
		"service.ranking:Integer=100" }, service = MVCActionCommand.class)

public class DGForgotPasswordMVCActionCommand extends BaseMVCActionCommand {
	
		@Override
		protected void doProcessAction(
				ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

			int step = ParamUtil.getInteger(actionRequest, "step");
			
			if(step == 1) {
				actionRequest.setAttribute(
						WebKeys.FORGOT_PASSWORD_REMINDER_USER, _getUser(actionRequest));
			}
			
			if(step == 2) {
				_updatePassword(actionRequest);
			}
			
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
			actionResponse.getRenderParameters().setValue("mvcPath", "/dg_forgot_password.jsp");
		}
		
		private User _getUser(ActionRequest actionRequest) {
			try {
				User user = null;

				ThemeDisplay themeDisplay =
					(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

				String authType = null;

				PortletPreferences portletPreferences =
					actionRequest.getPreferences();

				if (portletPreferences != null) {
					authType = portletPreferences.getValue("authType", null);
				}

				if (Validator.isNull(authType)) {
					Company company = themeDisplay.getCompany();

					authType = company.getAuthType();
				}
				
				String nationalId = ParamUtil.getString(actionRequest, "nationalId");
				String dateOfBirth = ParamUtil.getString(actionRequest, "dateOfBirth");
				
				_log.info("National ID : "+nationalId);
				_log.info("date of birth : "+dateOfBirth);

				if (Validator.isNotNull(nationalId)) {
					nationalId = ParamUtil.getString(actionRequest, "nationalId");

					if (authType.equals(CompanyConstants.AUTH_TYPE_EA)) {
						user = _userLocalService.getUserByEmailAddress(
							themeDisplay.getCompanyId(), nationalId);
					}
					else if (authType.equals(CompanyConstants.AUTH_TYPE_SN)) {
						user = _userLocalService.getUserByScreenName(
							themeDisplay.getCompanyId(), nationalId);
					}
					else if (authType.equals(CompanyConstants.AUTH_TYPE_ID)) {
						user = _userLocalService.getUserById(GetterUtil.getLong(nationalId));
					}
					else {
						throw new NoSuchUserException("User does not exist");
					}
	
					if (!user.isActive()) {
						throw new UserActiveException(
							"Inactive user " + user.getUuid());
					}
					
					SimpleDateFormat sdformat = new SimpleDateFormat("dd-MM-yyyy");
				      _log.info("User profile DOB is: " + user.getBirthday());
				      _log.info("User entered DOB is: " + sdformat.parse(dateOfBirth));
					
				      if(Validator.isNotNull(user.getBirthday()) && user.getBirthday().compareTo(sdformat.parse(dateOfBirth)) != 0) {
				    	  SessionErrors.add(actionRequest, "nid-dob-does-not-match");
				    	  throw new Exception();
				      }

					_userLocalService.checkLockout(user);
					
					_log.info("details are valid..setting password");
					PortletSession portletSession = actionRequest.getPortletSession();
					portletSession.setAttribute("userId", user.getUserId());
					
					return user;
				}
			}
			catch (Exception exception) {
				if (exception instanceof NoSuchUserException) {
					SessionErrors.add(actionRequest, exception.getClass());
					_log.error(exception.getMessage());
			   }
				exception.printStackTrace();
			}

			return null;
		}
		private User _updatePassword(ActionRequest actionRequest) {
			try {
				PortletSession portletSession = actionRequest.getPortletSession();
				long userId = 0; 
				
				if(Validator.isNull(portletSession.getAttribute("userId"))) {
					throw new NoSuchUserException("User does not exist");
				}
				userId  = (long)portletSession.getAttribute("userId");
				
				_log.info("inside _updatePassword");
				
				String password = ParamUtil.getString(actionRequest, "password");
				String confirmPassword = ParamUtil.getString(actionRequest, "confirmPassword");
				
				_log.info("password : "+password);
				_log.info("cnf password : "+confirmPassword);
				
				try {
					User user = _userLocalService.fetchUserById(userId);
					actionRequest.setAttribute(WebKeys.FORGOT_PASSWORD_REMINDER_USER, user);
					
					_userLocalService.updatePassword(userId, password, confirmPassword, false);
					
					actionRequest.setAttribute("password-changed-successfully", "password-changed-successfully");
					_log.info("password reset sucess...");
					portletSession.removeAttribute("userId");
					
				}
				catch (Exception exception) {
						if(exception instanceof UserPasswordException.MustNotBeEqualToCurrent) {
							SessionErrors.add(actionRequest, exception.getClass());
						}else {
							throw new Exception();
						}
						_log.error(exception.getMessage());
						exception.printStackTrace();
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		private static final Log _log = LogFactoryUtil.getLog(
			DGForgotPasswordMVCActionCommand.class);
		
		@Reference
		private UserLocalService _userLocalService;
		
		@Reference
		private Portal _portal;
	}
