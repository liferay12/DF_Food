package bd.gov.dgfood.farmer.information.management.system.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import bd.gov.dgfood.common.util.NotificationUtil;
import bd.gov.dgfood.common.util.UserAccountUtil;
import bd.gov.dgfood.common.util.constants.NotificationPlaceholderConstants;
import bd.gov.dgfood.common.util.constants.NotificationTemplateConstants;
import bd.gov.dgfood.common.util.constants.RoleConstants;
import bd.gov.dgfood.farmer.information.management.system.model.FarmerRegistration;
import bd.gov.dgfood.farmer.information.management.system.service.FarmerRegistrationLocalServiceUtil;

public class FarmerManagementUtil {

	/**
	 * Creates a portal user for the Farmer Registration application
	 * 
	 * @param farmerRegistration
	 * @param serviceContext
	 * @return FarmerRegistration
	 */
	public static FarmerRegistration createFarmerUserAccount(FarmerRegistration farmerRegistration,
			ServiceContext serviceContext) {

		logger.debug(farmerRegistration);

		if (Validator.isNull(farmerRegistration)) {
			logger.debug("Farmer record found null. User will not be created");
			return null;
		}

		try {
			Calendar dobCalendar = Calendar.getInstance();
			dobCalendar.setTime(farmerRegistration.getDateOfBirth());

			User user = UserAccountUtil.createUserAccount(farmerRegistration.getNationalId(),
					farmerRegistration.getEmailAddress(), farmerRegistration.getFarmerName(),
					farmerRegistration.getDateOfBirth(), farmerRegistration.getGender(),
					farmerRegistration.getMobileNumber(), getFarmerRoles(farmerRegistration.getCompanyId()),
					farmerRegistration.getPassword(), RoleConstants.FARMER, serviceContext);

			farmerRegistration.setUserId(user.getUserId());
			farmerRegistration.setModifiedDate(new Date());
			FarmerRegistrationLocalServiceUtil.updateFarmerRegistration(farmerRegistration);
			logger.info("Farmer Registration updated successfully");
		} catch (Exception e) {
			logger.error("Unable to create Farmer User account for " + farmerRegistration.getFarmerRegistrationId()
					+ ": " + e.getMessage());
			if (logger.isDebugEnabled()) {
				e.printStackTrace();
			}
		}
		return farmerRegistration;
	}

	/**
	 * returens the list of Farmer User role's ids
	 * 
	 * @param companyId
	 * @return Long[]
	 */
	public static long[] getFarmerRoles(long companyId) {
		try {
			Role farmerRole = RoleLocalServiceUtil.getRole(companyId, RoleConstants.FARMER);
			long[] farmerRoles = { farmerRole.getRoleId() };
			return farmerRoles;
		} catch (PortalException e) {
			logger.debug("Unable to fetch Farmer Role: " + e.getMessage());
			if (logger.isDebugEnabled()) {
				e.printStackTrace();
			}
		}

		return null;
	}
	
	/**
	 * Trigger notification on successful submission of Farmer registration application
	 * 
	 * @param farmerRegistration
	 * @param serviceContext
	 */
	public static void triggerRegistrationSubmissionNotification(FarmerRegistration farmerRegistration, ServiceContext serviceContext)
	{
		String notificationTemplateKey = NotificationTemplateConstants.FARMER_REGISTRATION_APPLICATION_SUBMITTED;
		
		Map<String, String> detailsMap = new HashMap<String, String>();
		detailsMap.put(NotificationPlaceholderConstants.APPLICATION_NUMBER, farmerRegistration.getApplicationNumber());
		detailsMap.put(NotificationPlaceholderConstants.APPLICANT_NAME, farmerRegistration.getFarmerName());
		
		NotificationUtil.invokeNotification(serviceContext, notificationTemplateKey, detailsMap, 
				0, farmerRegistration.getEmailAddress(), StringPool.BLANK, false);
	}

	private static Log logger = LogFactoryUtil.getLog(FarmerManagementUtil.class);
}
