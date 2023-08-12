package bd.gov.dgfood.common.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ListTypeLocalServiceUtil;
import com.liferay.portal.kernel.service.PhoneLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Calendar;
import java.util.Date;

import bd.gov.dgfood.common.util.constants.GenderConstants;

/**
 * The purpose of this class is to create user related activities
 *
 * Accessibility : Throughout application
 *
 *
 *@author Ashish Singh
 * 
 */
public class UserAccountUtil {

	/**
	 * Cretaes the user account with the geven details
	 * 
	 * @param screenName
	 * @param emailAddress
	 * @param farmerName
	 * @param dateofBirth
	 * @param gender
	 * @param mobileNumber
	 * @param roleIds
	 * @param password
	 * @param userType
	 * @param serviceContext
	 * @return User
	 * @throws PortalException
	 */
	public static User createUserAccount(String screenName, String emailAddress, String farmerName, Date dateofBirth,
			int gender, String mobileNumber, long[] roleIds, String password, String userType,
			ServiceContext serviceContext) throws PortalException {

		User user = UserAccountUtil.isUserAccountAlreadyExist(screenName, serviceContext.getCompanyId());

		if (Validator.isNotNull(user)) {
			_log.error("A User with same screen name already exist : " + screenName);
			throw new PortalException("A User with same screen name already exist : " + screenName);
		}

		long[] groupIds = { serviceContext.getScopeGroupId() };

		Calendar dobCalendar = null;
		if (Validator.isNotNull(dateofBirth)) {
			dobCalendar = Calendar.getInstance();
			dobCalendar.setTime(dateofBirth);
		}

		if (Validator.isNotNull(screenName)) {
			user = UserLocalServiceUtil.addUser(UserLocalServiceUtil.getDefaultUserId(serviceContext.getCompanyId()),
					serviceContext.getCompanyId(), false, password, password, false, screenName, emailAddress,
					serviceContext.getLocale(), farmerName, StringPool.BLANK, userType, 0l, 0l,
					(gender == GenderConstants.GENDER_MALE), dobCalendar.get(Calendar.MONTH),
					dobCalendar.get(Calendar.DAY_OF_MONTH), dobCalendar.get(Calendar.YEAR), userType, groupIds, null,
					roleIds, null, false, new ServiceContext());
		} else {
			user = UserLocalServiceUtil.addUser(UserLocalServiceUtil.getDefaultUserId(serviceContext.getCompanyId()),
					serviceContext.getCompanyId(), false, password, password, true, StringPool.BLANK, emailAddress,
					serviceContext.getLocale(), farmerName, StringPool.BLANK, userType, 0l, 0l,
					(gender == GenderConstants.GENDER_MALE), dobCalendar.get(Calendar.MONTH),
					dobCalendar.get(Calendar.DAY_OF_MONTH), dobCalendar.get(Calendar.YEAR), userType, groupIds, null,
					roleIds, null, false, new ServiceContext());
		}

		if (Validator.isNull(user)) {
			throw new PortalException("Unable to create user account : " + screenName);
		}

		if (Validator.isNotNull(mobileNumber)) {
			UserAccountUtil.addUserPhoneDetails(user, mobileNumber, serviceContext);
		}

		return user;
	}

	/**
	 * Add Phone number for the given user
	 * 
	 * @param user
	 * @param mobileNumber
	 * @param serviceContext
	 * @return
	 */
	public static Phone addUserPhoneDetails(User user, String mobileNumber, ServiceContext serviceContext) {
		try {

			return PhoneLocalServiceUtil.addPhone(user.getUserId(), Contact.class.getName(), user.getContactId(),
					mobileNumber, null,
					ListTypeLocalServiceUtil
							.getListType("mobile-phone", "com.liferay.portal.kernel.model.Contact.phone")
							.getListTypeId(),
					true, serviceContext);
		} catch (Exception e) {
			_log.error("Error while adding phone" + e.getMessage());
			if (_log.isDebugEnabled()) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * returns User object for the given screen name, else returns null
	 * 
	 * @param screenName
	 * @param companyId
	 * @return User
	 */
	public static User isUserAccountAlreadyExist(String screenName, long companyId) {

		return UserLocalServiceUtil.fetchUserByScreenName(companyId, screenName);
	}

	private static Log _log = LogFactoryUtil.getLog(UserAccountUtil.class);
}
