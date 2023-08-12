package bd.gov.dgfood.common.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.Conjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowLog;
import com.liferay.portal.kernel.workflow.WorkflowLogManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.workflow.kaleo.KaleoWorkflowModelConverter;
import com.liferay.portal.workflow.kaleo.model.KaleoInstance;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskAssignmentInstance;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceToken;
import com.liferay.portal.workflow.kaleo.runtime.util.WorkflowContextUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoInstanceLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoTaskAssignmentInstanceLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoTaskInstanceTokenLocalServiceUtil;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Workflow submission utility - This class determines wheather to allow current
 * user to perform review operation
 * 
 * @author krishna
 *
 */
@Component(immediate = true, service = {})
public class WorflowTaskSubmissionUtil {

	/**
	 * This method validates wheather workflow is assigned to current user
	 * 
	 * @param userId
	 * @param workflowTask
	 * @return
	 */
	public static boolean isAssignedToUser(long userId, WorkflowTask workflowTask) {

		return userId == workflowTask.getAssigneeUserId();
	}

	/**
	 * This method validates wheather workflow is assigned to current user role
	 * 
	 * @param userId
	 * @param workflowTask
	 * @return
	 */
	public static boolean isAssignedToRole(long userId, WorkflowTask workflowTask) {

		boolean isAssignedToRole = false;

		_log.debug(" userId ... " + userId);
		_log.debug(" KaleoTaskAssignmentInstance Id ... " + workflowTask.getWorkflowTaskId());

		List<KaleoTaskAssignmentInstance> kaleoTaskAssignmentInstances = KaleoTaskAssignmentInstanceLocalServiceUtil
				.getKaleoTaskAssignmentInstances(workflowTask.getWorkflowTaskId());

		_log.debug(" kaleoTaskAssignmentInstances size ... " + kaleoTaskAssignmentInstances.size());

		Optional<KaleoTaskAssignmentInstance> optional = kaleoTaskAssignmentInstances.stream()
				.filter(e -> !e.getCompleted()).filter(e -> e.getAssigneeClassName().equals(Role.class.getName()))
				.findAny();

		if (optional.isPresent()) {
			isAssignedToRole = RoleLocalServiceUtil.hasUserRole(userId, optional.get().getAssigneeClassPK());
		}

		return isAssignedToRole;
	}

	/**
	 * Return the transactions names defined in Workflow template (such as approve,
	 * reject,etc)
	 * 
	 * @param workflowTask
	 * @param display
	 * @return
	 * @throws PortalException
	 */
	public static List<String> getTransitionNames(WorkflowTask workflowTask, ThemeDisplay display)
			throws PortalException {

		return WorkflowTaskManagerUtil.getNextTransitionNames(display.getCompanyId(), display.getUserId(),
				workflowTask.getWorkflowTaskId());
	}

	public static String getTransitionMessage(String transitionName) {

		if (Validator.isNull(transitionName)) {
			return "proceed";
		}

		return HtmlUtil.escape(transitionName);
	}

	/**
	 * Create workflow task object
	 * 
	 * @param classPK
	 * @param className
	 * @return
	 */
	public static WorkflowTask getWorkflowTask(long classPK, String className) {

		WorkflowTask workflowTask = null;

		try {
			DynamicQuery dynamicQuery = KaleoTaskInstanceTokenLocalServiceUtil.dynamicQuery();
			Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

			conjunction.add(RestrictionsFactoryUtil.eq("className", className));
			conjunction.add(RestrictionsFactoryUtil.eq("classPK", classPK));
			conjunction.add(RestrictionsFactoryUtil.eq("completed", Boolean.FALSE));

			dynamicQuery.add(conjunction);
			_log.error(className);
			_log.error(classPK);
			
			List<KaleoTaskInstanceToken> instanceTokens = KaleoTaskInstanceTokenLocalServiceUtil
					.dynamicQuery(dynamicQuery);
			
			
			_log.error(instanceTokens);

			Optional<KaleoTaskInstanceToken> optional = instanceTokens.stream().findFirst();

			_log.error(optional);
			
			if (optional.isPresent()) {

				workflowTask = _kaleoWorkflowModelConverter.toWorkflowTask(optional.get(),
						WorkflowContextUtil.convert(optional.get().getWorkflowContext()));
			}

		} catch (Exception e) {
			_log.error(" WorkflowTask error " + e);
		}

		return workflowTask;
	}

	/**
	 * This method returns the comment given by approver during review processes
	 * 
	 * @param classPK
	 * @param className
	 * @return
	 */
	public static String getTaskComments(long classPK, String className) {

		try {
			DynamicQuery dynamicQuery = KaleoInstanceLocalServiceUtil.dynamicQuery();
			Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

			conjunction.add(RestrictionsFactoryUtil.eq("className", className));
			conjunction.add(RestrictionsFactoryUtil.eq("classPK", classPK));
			conjunction.add(RestrictionsFactoryUtil.eq("completed", Boolean.TRUE));

			dynamicQuery.add(conjunction);
			dynamicQuery.addOrder(OrderFactoryUtil.desc("classPK"));

			List<KaleoInstance> kaleoInstances = KaleoInstanceLocalServiceUtil.dynamicQuery(dynamicQuery);

			Optional<KaleoInstance> optional = kaleoInstances.stream().findFirst();

			if (optional.isPresent()) {

				Map<String, Serializable> map = WorkflowContextUtil.convert(optional.get().getWorkflowContext());

				_log.info(" getTaskComments .. " + map);

				String comments = (String) map.get(WorkflowConstants.CONTEXT_TASK_COMMENTS);

				return comments != null ? comments : StringPool.BLANK;

			}
		} catch (Exception e) {
			_log.error(" WorkflowTask error " + e);
		}

		return StringPool.BLANK;

	}

	private static final Log _log = LogFactoryUtil.getLog(WorflowTaskSubmissionUtil.class);

	@Reference(unbind = "-")
	protected void setKaleoWorkflowModelConverter(KaleoWorkflowModelConverter kaleoWorkflowModelConverter) {
		_kaleoWorkflowModelConverter = kaleoWorkflowModelConverter;
	}

	private static KaleoWorkflowModelConverter _kaleoWorkflowModelConverter;

}