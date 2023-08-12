package bd.gov.dgfood.credit.other.priority.customer.web.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.credit.other.priority.customer.constants.CustomerPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" +CustomerPortletKeys.SALES_CUSTOMER_ALLOCATION,
		"mvc.command.name=/allocation/view"}, service = MVCRenderCommand.class)
public class ViewAllocationMVCRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// TODO Auto-generated method stub
		return null;
	}

}
