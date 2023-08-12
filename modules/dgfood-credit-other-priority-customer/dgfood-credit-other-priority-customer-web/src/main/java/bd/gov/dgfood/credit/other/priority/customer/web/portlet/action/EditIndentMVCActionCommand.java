package bd.gov.dgfood.credit.other.priority.customer.web.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.common.services.service.IndentLocalService;
import bd.gov.dgfood.common.util.DateFormatterUtil;
import bd.gov.dgfood.credit.other.priority.customer.constants.CustomerPortletKeys;
import bd.gov.dgfood.credit.other.priority.customer.exception.NoSuchSalesCustomerAllocationException;
import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerAllocation;
import bd.gov.dgfood.credit.other.priority.customer.service.SalesCustomerAllocationLocalServiceUtil;

@Component(immediate = true, property = {
		"javax.portlet.name=" + CustomerPortletKeys.SALES_CUSTOMER_ALLOCATION,
		"mvc.command.name=/indent/add_entry" }, service = MVCActionCommand.class)
public class EditIndentMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		double quantity = ParamUtil.getDouble(actionRequest, "quantity");
		long salesCustomerAllocationId = ParamUtil.getLong(actionRequest, "salesCustomerAllocationId");
		String quantityUnit = ParamUtil.getString(actionRequest, "quantityUnit");
		Date requiredDeliveryDate = DateFormatterUtil
				.parseDate(ParamUtil.getString(actionRequest, "requiredDeliveryDate"));

		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
		
		SalesCustomerAllocation salesCustomerAllocation = SalesCustomerAllocationLocalServiceUtil.fetchSalesCustomerAllocation(salesCustomerAllocationId);
		
		if(Validator.isNull(salesCustomerAllocation)) {
			throw new NoSuchSalesCustomerAllocationException();
		}
		
		indentLocalService.addIndent(salesCustomerAllocationId, SalesCustomerAllocation.class.getName(), quantity, quantityUnit, requiredDeliveryDate, serviceContext);

	}

	@Reference
	IndentLocalService indentLocalService;

}
