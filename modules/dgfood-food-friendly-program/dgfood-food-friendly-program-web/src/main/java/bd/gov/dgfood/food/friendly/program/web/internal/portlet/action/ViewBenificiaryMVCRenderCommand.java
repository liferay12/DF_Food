package bd.gov.dgfood.food.friendly.program.web.internal.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.food.friendly.program.constants.FoodFriendlyProgramPortletKeys;
import bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary;
import bd.gov.dgfood.food.friendly.program.service.FFPBeneficiaryLocalServiceUtil;

/**
 * It helps naviagate to detail page of benificiary from which Admin can
 * initiate edit or submit workflow review
 * 
 * @author krishna
 *
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + FoodFriendlyProgramPortletKeys.FOOD_FRIENDLY_PROGRAM_ADMIN,
		"mvc.command.name=/ffpb_registration/view_ffpb",
		"mvc.command.name=/ffpb_admins/view_ffpb" }, service = MVCRenderCommand.class)
public class ViewBenificiaryMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		String mvcPath = "/ffpb_admin/ffpb_details.jsp";

		long ffpb_id = ParamUtil.getLong(renderRequest, "ffpb_id");

		String jsp = ParamUtil.getString(renderRequest, "jsp");
		
		_log.info(" jsp..... "+jsp);

		if (jsp != null && !jsp.isEmpty()) {
			mvcPath = jsp;
		}

		try {
			FFPBeneficiary ffpRegistration = FFPBeneficiaryLocalServiceUtil.getFFPBeneficiary(ffpb_id);
			renderRequest.setAttribute("ffpBeneficiary", ffpRegistration);
			if (ffpRegistration.getStatus() == WorkflowConstants.STATUS_PENDING) {
				renderRequest.setAttribute("workflowPending", true);
			}

		} catch (PortalException e) {
			SessionErrors.add(renderRequest, e.getClass());

			_log.error(" FFPB Details does not exist " + e);
		}

		return mvcPath;
	}

	private static final Log _log = LogFactoryUtil.getLog(ViewBenificiaryMVCRenderCommand.class);

}
