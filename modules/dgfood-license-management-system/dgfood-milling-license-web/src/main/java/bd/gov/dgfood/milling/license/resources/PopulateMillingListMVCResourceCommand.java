package bd.gov.dgfood.milling.license.resources;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.milling.license.constants.MillingLicensePortletKeys;
import bd.gov.dgfood.milling.license.web.internal.display.context.MillingLicenseDisplayContext;

/**
 * It helps to dynamically include a search container page with data grid with
 * out refreshing a page
 * 
 * @author krishna
 *
 */
@Component(property = { 
		"javax.portlet.name=" + MillingLicensePortletKeys.MILLINGLICENSE,
		"mvc.command.name=" + MillingLicensePortletKeys.POPULATE_MILLING_LIST_MVC_RESOURCE_COMMAND 
		}, 
service = MVCResourceCommand.class
)
public class PopulateMillingListMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		log.info(" ReviewListMVCResourceCommand............ ");

		MillingLicenseDisplayContext millingLicenseDisplayContext = new MillingLicenseDisplayContext(
				PortalUtil.getHttpServletRequest(resourceRequest), _portal.getLiferayPortletRequest(resourceRequest),
				_portal.getLiferayPortletResponse(resourceResponse));
//		resourceRequest.setAttribute("customSearchContainer", millingLicenseDisplayContext.getSearch());
		include(resourceRequest, resourceResponse, "/search/search_container.jsp");

	}

	@Reference
	private Portal _portal;

	private static Log log = LogFactoryUtil.getLog(PopulateMillingListMVCResourceCommand.class);
}
