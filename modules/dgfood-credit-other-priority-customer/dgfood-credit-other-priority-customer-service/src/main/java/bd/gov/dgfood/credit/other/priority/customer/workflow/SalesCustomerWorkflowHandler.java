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
import bd.gov.dgfood.credit.other.priority.customer.service.SalesCustomerLocalService;

@Component(immediate = true, service = WorkflowHandler.class)
public class SalesCustomerWorkflowHandler extends BaseWorkflowHandler<SalesCustomer> {

	@Override
	public String getClassName() {

		return SalesCustomer.class.getName();
	}

	@Override
	public String getType(Locale locale) {

		return _resourceActions.getModelResource(locale, getClassName());
	}

	@Override
	public SalesCustomer updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {
		long userId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
		long resourcePrimKey = GetterUtil
				.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

		ServiceContext serviceContext = (ServiceContext) workflowContext.get("serviceContext");

		long customerId = _salesCustomerLocalService.getSalesCustomer(resourcePrimKey).getSalesCustomerId();
		return _salesCustomerLocalService.updateStatus(userId, customerId, status, serviceContext);
	}

	@Reference(unbind = "-")
	protected void setResourceActions(ResourceActions resourceActions) {

		_resourceActions = resourceActions;
	}

	private ResourceActions _resourceActions;

	@Reference(unbind = "-")
	protected void setCustomerLocalService(SalesCustomerLocalService customerLocalService) {

		_salesCustomerLocalService = customerLocalService;
	}

	private SalesCustomerLocalService _salesCustomerLocalService;
}