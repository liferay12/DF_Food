package bd.gov.dgfood.common.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.notifications.UserNotificationManagerUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.workflow.constants.MyWorkflowTasksConstants;
import com.liferay.portal.workflow.kaleo.KaleoWorkflowModelConverter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.common.services.model.UserLocation;
import bd.gov.dgfood.common.services.service.UserLocationLocalServiceUtil;

/**
 * The purpose of this class is to mention workflow activities
 *
 * Accessibility : Throughout application
 *
 *
 * @author Krishna
 * 
 */

public class WorkflowUtil {

	/**
	 * Assign workflow task to specific user by area and role
	 * 
	 * @param workflowContext
	 * @param role
	 * @param areaRoleId
	 * @return
	 */
	public static User assignToUser(Map<String, Serializable> workflowContext, String roleKey) {

		log.debug(" assignToUser called.... ");

		String locationCode = GetterUtil.getString(workflowContext.get("LOCATION_CODE"));

		long companyId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_COMPANY_ID));

		log.debug(" locationCode .... " + locationCode);

		Role role = RoleLocalServiceUtil.fetchRole(companyId, roleKey);

		if (role == null) {
			log.debug("Workflow not assigned to a User because No Role exist with Role key ....... " + roleKey);
			return null;
		}

		UserLocation location = UserLocationLocalServiceUtil.getUserLocationByRK_LC(roleKey, locationCode);

		User user = null;

		log.debug(" location....... " + location);

		if (location != null) {

			boolean userHasRole = UserLocalServiceUtil.hasRoleUser(role.getRoleId(), location.getUserId());

			if (!userHasRole) {
				log.debug(" User does not have role ....... " + roleKey);
				return null;
			}

			user = UserLocalServiceUtil.fetchUser(location.getUserId());
		}

		if (user != null) {

			workflowContext.put("ASSIGNEE_USER_ID", user.getUserId());
			log.debug("  workflow is assigned to  User : " + user.getFullName());

		}
		return user;

	}

	/**
	 * Assign workflow task to specific role
	 * 
	 * @param workflowContext
	 * @param role
	 * @return
	 */
	public static List<Role> assignToRoles(Map<String, Serializable> workflowContext, String roleName) {

		log.debug(" assignToRoles called.... ");

		List<Role> roles = new ArrayList<>();

		Role role = null;

		long companyId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_COMPANY_ID));

		role = RoleLocalServiceUtil.fetchRole(companyId, roleName);

		if (role == null) {

			role = RoleLocalServiceUtil.fetchRole(companyId, RoleConstants.PORTAL_CONTENT_REVIEWER);

		}

		if (role != null) {

			log.debug("  workflow is assigned to a role : " + role.getTitle());

			workflowContext.put("ASSIGNEE_ROLE_ID", role.getRoleId());
		}

		roles.add(role);

		return roles;

	}

	/**
	 * Get user by userId stored in workflowContext to send him notification
	 * 
	 * @param workflowContext
	 * @return
	 */
	public static User getUser(Map<String, Serializable> workflowContext) {

		log.debug(" Notification getUser called....");

		User user = null;

		long tassigneeUserId = GetterUtil.getLong(workflowContext.get("ASSIGNEE_USER_ID"));

		log.debug(" Notification tassigneeUserId : " + tassigneeUserId);

		user = UserLocalServiceUtil.fetchUser(tassigneeUserId);

		return user;
	}

	/**
	 * Get Role by roleId stored in workflowContext to send notification to Users
	 * having this roleId
	 * 
	 * @param workflowContext
	 * @param role
	 * @return
	 */
	public static List<Role> getRoles(Map<String, Serializable> workflowContext) {

		log.debug(" Notification getRole called....");

		List<Role> roles = new ArrayList<>();

		long tassigneeRoleId = GetterUtil.getLong(workflowContext.get("ASSIGNEE_ROLE_ID"));

		long companyId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_COMPANY_ID));

		log.debug(" Notification tassigneeRoleId : " + tassigneeRoleId);

		Role role = RoleLocalServiceUtil.fetchRole(tassigneeRoleId);

		if (role == null) {

			role = RoleLocalServiceUtil.fetchRole(companyId, RoleConstants.PORTAL_CONTENT_REVIEWER);
			log.debug(" Notification is assigned to a role :" + RoleConstants.PORTAL_CONTENT_REVIEWER);
		}

		roles.add(role);

		return roles;

	}

	/**
	 * This method will be called from Workflow context to notify end users about
	 * application status
	 * 
	 * @param mobileNumber
	 * @param message
	 */
	public static void sendUserNotification(int status, Map<String, Serializable> workflowContext) {
		log.info("<<<<<<<<<<<<<<< Send Email and SmS Notification to user >>>>>>>>>>>>>>>");
		log.info(">>>>>>>>>>>>>>> your application is " + WorkflowConstants.getStatusLabel(status));
		log.info(">>>>>>>>>>>>>>> workflowContext......." + workflowContext);
	}

	/**
	 * The purposee of this class is to send website notifications
	 */
	private static void doSendWebSiteNotification(long userId, JSONObject payloadJSON) {
		log.debug(" doSendWebSiteNotification..........");
		try {
			if (UserNotificationManagerUtil.isDeliver(userId, PortletKeys.MY_WORKFLOW_TASK, 0,
					MyWorkflowTasksConstants.NOTIFICATION_TYPE_MY_WORKFLOW_TASKS,
					UserNotificationDeliveryConstants.TYPE_WEBSITE)) {

				UserNotificationEventLocalServiceUtil.sendUserNotificationEvents(userId, PortletKeys.MY_WORKFLOW_TASK,
						UserNotificationDeliveryConstants.TYPE_WEBSITE, payloadJSON);
			}
		} catch (PortalException e) {
			log.error(" Workflow reminder not sent to user id " + userId + " with payload " + payloadJSON + " error :"
					+ e.getMessage());
		}
	}

	@Reference
	private static KaleoWorkflowModelConverter _kaleoWorkflowModelConverter;

	private static Log log = LogFactoryUtil.getLog(WorkflowUtil.class);
}
