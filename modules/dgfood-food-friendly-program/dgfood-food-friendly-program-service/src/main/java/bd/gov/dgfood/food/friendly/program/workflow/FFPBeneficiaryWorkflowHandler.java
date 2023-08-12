package bd.gov.dgfood.food.friendly.program.workflow;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ResourceActions;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary;
import bd.gov.dgfood.food.friendly.program.service.FFPBeneficiaryLocalService;

@Component(immediate = true, service = WorkflowHandler.class)
public class FFPBeneficiaryWorkflowHandler extends BaseWorkflowHandler<FFPBeneficiary> {

	@Override
	public String getClassName() {
		return FFPBeneficiary.class.getName();
	}

	@Override
	public String getType(Locale locale) {
		return _resourceActions.getModelResource(locale, getClassName());
	}

	@Override
	public FFPBeneficiary updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {

		long userId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
		long resourcePrimKey = GetterUtil
				.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

		ServiceContext serviceContext = (ServiceContext) workflowContext.get("serviceContext");

		long beneficiaryId = _ffpBeneficiaryLocalService.getFFPBeneficiary(resourcePrimKey).getBeneficiaryId();

		return _ffpBeneficiaryLocalService.updateStatus(userId, beneficiaryId, status, serviceContext);
	}

	@Reference(unbind = "-")
	protected void setResourceActions(ResourceActions resourceActions) {

		_resourceActions = resourceActions;
	}

	private ResourceActions _resourceActions;

	@Reference(unbind = "-")
	protected void setFFPBeneficiaryLocalService(FFPBeneficiaryLocalService ffpBeneficiaryLocalService) {

		_ffpBeneficiaryLocalService = ffpBeneficiaryLocalService;
	}

	private FFPBeneficiaryLocalService _ffpBeneficiaryLocalService;

}
