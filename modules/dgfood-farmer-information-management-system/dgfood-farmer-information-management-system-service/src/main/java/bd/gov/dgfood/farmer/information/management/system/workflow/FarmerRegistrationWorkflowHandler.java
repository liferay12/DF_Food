package bd.gov.dgfood.farmer.information.management.system.workflow;

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

import bd.gov.dgfood.common.util.constants.StatusConstants;
import bd.gov.dgfood.farmer.information.management.system.model.FarmerRegistration;
import bd.gov.dgfood.farmer.information.management.system.service.FarmerRegistrationLocalService;
import bd.gov.dgfood.farmer.information.management.system.util.FarmerManagementUtil;


@Component
(
		immediate = true,
		property = {
				"model.class.name=bd.gov.dgfood.farmer.information.management.system.model.FarmerRegistration" 
		}, 
		service = WorkflowHandler.class
		)
public class FarmerRegistrationWorkflowHandler extends BaseWorkflowHandler<FarmerRegistration> {

	@Override
	public String getClassName() {
		return FarmerRegistration.class.getName();
	}

	@Override
	public String getType(Locale locale) {
		return _resourceActions.getModelResource(locale, getClassName());
	}

	@Override
	public FarmerRegistration updateStatus(int status, Map<String, Serializable> workflowContext)
			throws PortalException {

		long userId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
		long resourcePrimKey = GetterUtil
				.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

		ServiceContext serviceContext = (ServiceContext) workflowContext.get("serviceContext");

		long farmerRegistrationId = _farmerRegistrationLocalService.getFarmerRegistration(resourcePrimKey).getFarmerRegistrationId();
		
		FarmerRegistration farmerRegistration= _farmerRegistrationLocalService.updateStatus(userId, farmerRegistrationId, status, serviceContext);
		
		if(status==StatusConstants.STATUS_APPROVED)
		{
			farmerRegistration=FarmerManagementUtil.createFarmerUserAccount(farmerRegistration, serviceContext);
		}

		return farmerRegistration;
	}

	@Reference(unbind = "-")
	protected void setResourceActions(ResourceActions resourceActions) {

		_resourceActions = resourceActions;
	}

	private ResourceActions _resourceActions;

	@Reference(unbind = "-")
	protected void setFarmerRegistrationLocalService(FarmerRegistrationLocalService farmerRegistrationLocalService) {

		_farmerRegistrationLocalService = farmerRegistrationLocalService;
	}

	private FarmerRegistrationLocalService _farmerRegistrationLocalService;

}
