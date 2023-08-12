package bd.gov.dgfood.credit.other.priority.customer.web.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.credit.other.priority.customer.constants.CustomerPortletKeys;

/**
 * @author krishna
 */
@Component(
        immediate = true, property = {
        		"com.liferay.portlet.display-category=category.sample", 
        		"com.liferay.portlet.header-portlet-css=/css/main.css",
        		"com.liferay.portlet.instanceable=false", 
        		"javax.portlet.display-name=CreditCustomerAdminPortlet",
        		"javax.portlet.init-param.template-path=/",
        		"javax.portlet.init-param.view-template=/credit_sales_view.jsp",
        		"javax.portlet.name=" + CustomerPortletKeys.CREDIT_CUSTOMER_ADMIN,
        		"javax.portlet.resource-bundle=content.Language", 
        		"javax.portlet.security-role-ref=power-user,user",
        	}, service = Portlet.class)
public class CreditCustomerAdminPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		renderRequest.setAttribute("userType", CustomerPortletKeys.CREDIT);

//		ThemeDisplay display = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
//
//		String siteName = display.getLayout().getFriendlyURL().toLowerCase();
//
//		log.debug(" site... " + siteName);
//
//		if (Validator.isNotNull(_configuration)) {
//
//			renderRequest.setAttribute(CreditOtherPriorityConfiguration.class.getName(), _configuration);
//
//			if (_configuration.getCreditCustomerListPageURL().equalsIgnoreCase(siteName)) {
//				renderRequest.setAttribute("userType", CustomerPortletKeys.CREDIT);
//				log.debug(" userType... " + CustomerPortletKeys.CREDIT);
//			} else if (_configuration.getOtherPriorityCustomerListPageURL().equalsIgnoreCase(siteName)) {
//				renderRequest.setAttribute("userType", CustomerPortletKeys.OTHER_PRIORITY);
//				log.debug(" userType... " + CustomerPortletKeys.OTHER_PRIORITY);
//			}
//
//		}

		super.render(renderRequest, renderResponse);
	}

//	@Activate
//	@Modified
//	protected void activate(Map<String, Object> properties) {
//		_configuration = ConfigurableUtil.createConfigurable(CreditOtherPriorityConfiguration.class, properties);
//	}
//
//	private volatile CreditOtherPriorityConfiguration _configuration;

	private static Log log = LogFactoryUtil.getLog(CreditCustomerAdminPortlet.class);
}