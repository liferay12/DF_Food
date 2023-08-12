package bd.gov.dgfood.credit.other.priority.customer.web.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.credit.other.priority.customer.constants.CustomerPortletKeys;

/**
 * @author krishna
 *
 */

@Component(immediate = true, property = { "javax.portlet.name=" + CustomerPortletKeys.OTHER_PRIORITY_CUSTOMER_ADMIN,
		"mvc.command.name=/", "mvc.command.name=/customer/view" }, service = MVCRenderCommand.class)
public class ViewOPMVCRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		return "/op_view.jsp";
	}

}
