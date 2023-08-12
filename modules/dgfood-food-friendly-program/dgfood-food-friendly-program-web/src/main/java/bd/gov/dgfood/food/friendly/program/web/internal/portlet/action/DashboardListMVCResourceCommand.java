package bd.gov.dgfood.food.friendly.program.web.internal.portlet.action;

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

import bd.gov.dgfood.food.friendly.program.constants.FoodFriendlyProgramPortletKeys;
import bd.gov.dgfood.food.friendly.program.web.internal.display.context.FFPBDisplayContext;

/**
 * It helps to dynamically include a search container page with data grid with
 * out refreshing a page
 * 
 * @author krishna
 *
 */
@Component(property = { "javax.portlet.name=" + FoodFriendlyProgramPortletKeys.FOOD_FRIENDLY_PROGRAM_ADMIN,
		"mvc.command.name=/ffp/dashboard_list" }, service = MVCResourceCommand.class)
public class DashboardListMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		log.info(" ReviewListMVCResourceCommand............ ");

		FFPBDisplayContext ffpRegistrationDisplayContext = new FFPBDisplayContext(
				PortalUtil.getHttpServletRequest(resourceRequest), _portal.getLiferayPortletRequest(resourceRequest),
				_portal.getLiferayPortletResponse(resourceResponse));
		resourceRequest.setAttribute("customSearchContainer", ffpRegistrationDisplayContext.getSearch());
		include(resourceRequest, resourceResponse, "/search/search_container.jsp");

	}

	@Reference
	private Portal _portal;

	private static Log log = LogFactoryUtil.getLog(DashboardListMVCResourceCommand.class);
}
