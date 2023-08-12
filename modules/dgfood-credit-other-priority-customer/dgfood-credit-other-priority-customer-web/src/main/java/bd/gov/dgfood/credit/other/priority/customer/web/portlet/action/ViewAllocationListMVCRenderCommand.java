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
@Component(immediate = true, property = { "javax.portlet.name=" + CustomerPortletKeys.SALES_CUSTOMER_ALLOCATION,
		"mvc.command.name=/", "mvc.command.name=/customer/view_allocationlist" }, service = MVCRenderCommand.class)
public class ViewAllocationListMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		String mvcPath = "/allocation/view.jsp";

		_log.info(" >>>mvcPath>>>> " + mvcPath);

		return mvcPath;
	}

	private static final Log _log = LogFactoryUtil.getLog(ViewAllocationListMVCRenderCommand.class);

}
