package bd.gov.dgfood.credit.other.priority.customer.web.portlet.util;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer;
import bd.gov.dgfood.credit.other.priority.customer.service.SalesCustomerLocalServiceUtil;

@Component(immediate = true, service = {})
public class SCUtil {

	public static long getSalesCustomerCode(long userId) {

		SalesCustomer salesCustomer = SalesCustomerLocalServiceUtil.getSalesCustomerByUserId(userId);
		long salesCustomerCode = salesCustomer != null ? salesCustomer.getSalesCustomerCode() : 0;

		return salesCustomerCode;

	}

}
