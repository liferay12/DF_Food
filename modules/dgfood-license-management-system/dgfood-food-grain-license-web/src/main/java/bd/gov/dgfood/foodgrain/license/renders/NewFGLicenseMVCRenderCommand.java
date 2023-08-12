package bd.gov.dgfood.foodgrain.license.renders;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.foodgrain.license.constants.FoodGrainLicensePortletKeys;

/**
 * 
 * @author Abhijit Ande
 *
 *This Render class is used to render the Food Grain License Application form on Button Click.
 */

@Component(immediate = true,
property = {
		"javax.portlet.name=" + FoodGrainLicensePortletKeys.HOMESCREENFGLICENSE,
		"mvc.command.name=" + FoodGrainLicensePortletKeys.NEW_FG_LICENSE_MVC_RENDER_COMMAND 
},
	service = MVCRenderCommand.class
)
public class NewFGLicenseMVCRenderCommand  implements MVCRenderCommand {

	/**
	 * This method is used to render the food grain license application form.
	 * 
	 * @param renderRequest
	 * @param renderResponse
	 * @return String
	 */
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		return "/jsp/fglicense_application/fgLicense_application.jsp";
	}
	
	private Log logger = LogFactoryUtil.getLog(this.getClass());
}
