package bd.gov.dgfood.taglib.util;

import com.liferay.portal.kernel.audit.AuditMessage;
import com.liferay.portal.kernel.audit.AuditRouterUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManager;

import java.io.Serializable;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.common.util.constants.CommonUtilPortletKeys;

/**
 * Admin Work flow tasks submission class, This class will be invoked once
 * admins review entity (Custom Entities) which is under workflow
 * 
 * @author krishna
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + CommonUtilPortletKeys.FOOD_FRIENDLY_PROGRAM_ADMIN,
		"javax.portlet.name=" + CommonUtilPortletKeys.FOODGRAINLICENSE,
		"javax.portlet.name=" + CommonUtilPortletKeys.CREDIT_CASH_CUSTOMER_ADMIN,
		"javax.portlet.name=" + CommonUtilPortletKeys.OTHER_PRIORITY_CUSTOMER_ADMIN,
		"javax.portlet.name=" + CommonUtilPortletKeys.FARMERINFORMATIONMANAGEMENTSYSTEM,
		"mvc.command.name=completeWorkflowTask" }, service = MVCActionCommand.class)
public class CompleteTaskMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long workflowTaskId = ParamUtil.getLong(actionRequest, "workflowTaskId");

		String transitionName = ParamUtil.getString(actionRequest, "transitionName");
		String comment = ParamUtil.getString(actionRequest, "comment");
		String reason = ParamUtil.getString(actionRequest, "reason");

		Map<String, Serializable> workflowContext = _getWorkflowContext(themeDisplay.getCompanyId(), workflowTaskId);

		ServiceContext serviceContext = (ServiceContext) workflowContext.get("serviceContext");

		serviceContext.setRequest(_portal.getHttpServletRequest(actionRequest));

		workflowContext.put(WorkflowConstants.CONTEXT_USER_ID, String.valueOf(themeDisplay.getUserId()));
		workflowContext.put("reason", reason);

		workflowTaskManager.completeWorkflowTask(themeDisplay.getCompanyId(), themeDisplay.getUserId(), workflowTaskId,
				transitionName, comment, workflowContext);

		String className = GetterUtil.getString(workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_NAME));

		String classPK = GetterUtil.getString(workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("workflowTaskId", workflowTaskId);
		jsonObject.put("comment", comment);
		jsonObject.put("reason", reason);

		AuditMessage auditMessage = new AuditMessage(transitionName.toUpperCase(), themeDisplay.getCompanyId(),
				themeDisplay.getUserId(), themeDisplay.getUser().getFullName(), className, classPK, comment,
				jsonObject);

		AuditRouterUtil.route(auditMessage);

	}

	/**
	 * converting string into map object
	 * 
	 * @param companyId
	 * @param workflowTaskId
	 * @return
	 * @throws Exception
	 */
	private Map<String, Serializable> _getWorkflowContext(long companyId, long workflowTaskId) throws Exception {

		WorkflowTask workflowTask = null;
		
	//	WorkflowTask workflowTask = workflowTaskManager.getWorkflowTask(workflowTaskId);

		WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(companyId,
				workflowTask.getWorkflowInstanceId());

		return workflowInstance.getWorkflowContext();
	}

	@Reference
	protected WorkflowTaskManager workflowTaskManager;

	@Reference
	private Portal _portal;

}
