package bd.gov.dgfood.credit.other.priority.customer.web.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.credit.other.priority.customer.constants.CustomerPortletKeys;

/**
 * Main class helps to navigate to different pages dynamically based on browser
 * current friendly url path
 * 
 * @author krishna
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + CustomerPortletKeys.CREDIT_CUSTOMER_ADMIN,
		"mvc.command.name=/", "mvc.command.name=/customer/view" }, service = MVCRenderCommand.class)
public class ViewMVCRenderCommand implements MVCRenderCommand {

	private static String DASHBOARD = "/dashboard";

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		_log.info(" ViewMVCRenderCommand>>>>>>>.");

		return "/credit_sales_view.jsp";
	}

	private static final Log _log = LogFactoryUtil.getLog(ViewMVCRenderCommand.class);

}
