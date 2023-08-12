package bd.gov.dgfood.taglib.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowTaskManager;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.common.util.constants.CommonUtilPortletKeys;

/**
 * The purpose of this calss is to assign workflow to self when workflow of an
 * entity is assigned to self role
 * 
 * @author krishna
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + CommonUtilPortletKeys.FOOD_FRIENDLY_PROGRAM_ADMIN,
		"javax.portlet.name=" + CommonUtilPortletKeys.CREDIT_CASH_CUSTOMER_ADMIN,
		"javax.portlet.name=" + CommonUtilPortletKeys.OTHER_PRIORITY_CUSTOMER_ADMIN,
		"mvc.command.name=assignWorkflowTaskToUser" }, service = MVCResourceCommand.class)
public class AssignTaskMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long workflowTaskId = ParamUtil.getLong(resourceRequest, "workflowTaskId");

		long assigneeUserId = ParamUtil.getLong(resourceRequest, "assigneeUserId");
		String comment = ParamUtil.getString(resourceRequest, "assignTaskComment");

		_log.debug(" workflowTaskId......" + workflowTaskId);
		_log.debug(" assigneeUserId......" + assigneeUserId);
		_log.debug(" comment......" + comment);

		workflowTaskManager.assignWorkflowTaskToUser(themeDisplay.getCompanyId(), themeDisplay.getUserId(),
				workflowTaskId, assigneeUserId, comment, null, null);

		SessionMessages.add(resourceRequest, "requestProcessed", "");
	}

	private static final Log _log = LogFactoryUtil.getLog(AssignTaskMVCResourceCommand.class);

	@Reference
	protected WorkflowTaskManager workflowTaskManager;

}
