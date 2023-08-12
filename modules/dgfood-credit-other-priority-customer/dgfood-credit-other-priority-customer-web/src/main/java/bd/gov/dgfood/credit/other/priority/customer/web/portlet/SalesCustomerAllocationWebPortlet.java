package bd.gov.dgfood.credit.other.priority.customer.web.portlet;


import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.Calendar;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.credit.other.priority.customer.constants.CustomerPortletKeys;
import bd.gov.dgfood.credit.other.priority.customer.service.SalesCustomerAllocationLocalServiceUtil;

/**
 * @author krishna
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=SalesCustomerAllocation", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.template-path=/META-INF/resources/",
		"javax.portlet.name=" + CustomerPortletKeys.SALES_CUSTOMER_ALLOCATION,
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.init-param.view-template=true",
		"javax.portlet.init-param.view-template=/customer/view_allocationlist", "javax.portlet.expiration-cache=0",
		"com.liferay.portlet.render-weight=50" }, service = Portlet.class)
public class SalesCustomerAllocationWebPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		renderRequest.setAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
//
//		SalesCustomerAllocationLocalServiceUtil.addEntry(themeDisplay.getUserId(), themeDisplay.getUser().getFullName(),
//				123456L, "Test", "Test", 2022, "DS01", "U001", "GOV12345678", "Rice", Double.valueOf(100), "MT",
//				Double.valueOf(10), "MT", 0L, "Aganagar");

		super.render(renderRequest, renderResponse);
	}

}
