package bd.gov.dgfood.food.friendly.program.web.internal.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.food.friendly.program.constants.FoodFriendlyProgramPortletKeys;

/**
 * It helps to show final status of FFPB registration processes with application
 * number
 * 
 * @author krishna
 *
 */
@Component(property = { "javax.portlet.name=" + FoodFriendlyProgramPortletKeys.FOOD_FRIENDLY_PROGRAM_ADMIN,
		"mvc.command.name=/ffpb_registration/final_page" }, service = MVCRenderCommand.class)
public class FinalPageMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		String applicationNumber = ParamUtil.getString(renderRequest, "applicationNumber");

		log.info(" FinalPageMVCRenderCommand......" + applicationNumber);

		renderRequest.setAttribute("applicationNumber", applicationNumber);

		return "/ffpb_registration/steps/final_step.jsp";
	}

	static final private Log log = LogFactoryUtil.getLog(FinalPageMVCRenderCommand.class);

}
