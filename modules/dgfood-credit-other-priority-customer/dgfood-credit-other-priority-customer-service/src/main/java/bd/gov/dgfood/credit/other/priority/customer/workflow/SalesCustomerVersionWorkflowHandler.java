package bd.gov.dgfood.credit.other.priority.customer.workflow;

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

import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer;
import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerVersion;
import bd.gov.dgfood.credit.other.priority.customer.service.SalesCustomerVersionLocalService;

@Component(immediate = true, service = WorkflowHandler.class)
public class SalesCustomerVersionWorkflowHandler extends BaseWorkflowHandler<SalesCustomerVersion> {

	@Override
	public String getClassName() {

		return SalesCustomerVersion.class.getName();
	}

	@Override
	public String getType(Locale locale) {

		return _resourceActions.getModelResource(locale, getClassName());
	}

	@Override
	public SalesCustomerVersion updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {
		long userId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
		long resourcePrimKey = GetterUtil
				.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

		ServiceContext serviceContext = (ServiceContext) workflowContext.get("serviceContext");

		long salesCustomerVersionId = _salesCustomerVersionLocalService.getSalesCustomerVersion(resourcePrimKey).getSalesCustomerVersionId();
		return _salesCustomerVersionLocalService.updateStatus(userId, salesCustomerVersionId, status, serviceContext);
	}

	@Reference(unbind = "-")
	protected void setResourceActions(ResourceActions resourceActions) {

		_resourceActions = resourceActions;
	}

	private ResourceActions _resourceActions;

	@Reference(unbind = "-")
	protected void setSalesCustomerVersionLocalService(SalesCustomerVersionLocalService salesCustomerVersionLocalService) {

		_salesCustomerVersionLocalService = salesCustomerVersionLocalService;
	}

	private SalesCustomerVersionLocalService _salesCustomerVersionLocalService;
}