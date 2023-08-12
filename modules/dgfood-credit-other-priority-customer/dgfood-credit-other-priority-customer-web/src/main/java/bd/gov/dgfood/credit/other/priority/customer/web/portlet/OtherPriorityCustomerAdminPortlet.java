package bd.gov.dgfood.credit.other.priority.customer.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.credit.other.priority.customer.constants.CustomerPortletKeys;

@Component(
			immediate = true, property = {
		"com.liferay.portlet.display-category=category.sample", 
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false", 
		"javax.portlet.display-name=OtherPriorityCustomerAdminPortlet",
		"javax.portlet.init-param.template-path=/", 
		"javax.portlet.init-param.view-template=/credit_sales_view.jsp",
		"javax.portlet.name=" + CustomerPortletKeys.OTHER_PRIORITY_CUSTOMER_ADMIN,
		"javax.portlet.resource-bundle=content.Language", 
		"javax.portlet.security-role-ref=power-user,user"
		
		}, service = Portlet.class)
public class OtherPriorityCustomerAdminPortlet extends MVCPortlet{


}
