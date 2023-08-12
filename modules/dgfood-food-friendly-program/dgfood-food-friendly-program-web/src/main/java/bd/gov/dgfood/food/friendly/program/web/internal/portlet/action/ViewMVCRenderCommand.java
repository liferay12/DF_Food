package bd.gov.dgfood.food.friendly.program.web.internal.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.food.friendly.program.constants.FoodFriendlyProgramPortletKeys;

/**
 * Main class helps to navigate to different pages dynamically based on browser
 * current friendly url path
 * 
 * @author krishna
 *
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + FoodFriendlyProgramPortletKeys.FOOD_FRIENDLY_PROGRAM_ADMIN, "mvc.command.name=/",
		"mvc.command.name=/uc_uno/view" }, service = MVCRenderCommand.class)
public class ViewMVCRenderCommand implements MVCRenderCommand {

	private static String DASHBOARD = "/dashboard";
	private static String ADD_FFPB = "/add-ffpb";
	private static String FFPB_LIST = "/ffpb-list";
	private static String FFPB_REVIEW_LIST = "/ffpb-review-list";
	private static String FFPB_DEALER_LINK = "/ffpb-dealer-link";

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		String mvcPath = "/view.jsp";

		ThemeDisplay display = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String siteName = display.getLayout().getFriendlyURL().toLowerCase();

		if (DASHBOARD.equals(siteName)) {
			mvcPath = "/ffpb_dashboard/dashboard.jsp";
		} else if (ADD_FFPB.equals(siteName)) {
			mvcPath = "/ffpb_registration/registration.jsp";
		} else if (FFPB_LIST.equals(siteName)) {
			mvcPath = "/ffpb_admin/ffpb_list.jsp";
			
		} else if (FFPB_REVIEW_LIST.equals(siteName)) {
			mvcPath = "/ffpb_admin/ffpb_review_list.jsp";
			
		} else if (FFPB_DEALER_LINK.equals(siteName)) {
			mvcPath = "/ffpb_dealer_link/list.jsp";
			renderRequest.getPortletSession().removeAttribute("linkIds");
		}

		_log.info(" >>>mvcPath>>>> " + mvcPath);

		return mvcPath;
	}

	private static final Log _log = LogFactoryUtil.getLog(ViewMVCRenderCommand.class);

}
