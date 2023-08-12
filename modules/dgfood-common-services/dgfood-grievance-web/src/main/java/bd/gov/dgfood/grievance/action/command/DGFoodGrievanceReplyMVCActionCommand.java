package bd.gov.dgfood.grievance.action.command;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MimeResponse.Copy;
import javax.portlet.RenderURL;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.common.services.service.GrievanceLocalServiceUtil;
import bd.gov.dgfood.common.util.constants.ParameterConstants;
import bd.gov.dgfood.grievance.constants.DgfoodGrievanceWebPortletKeys;
import bd.gov.dgfood.grievance.resource.command.DGFoodGrievanceReplyMVCResourceCommand;

@Component(immediate = true, property = {
		"javax.portlet.name=" + DgfoodGrievanceWebPortletKeys.DGFOODGRIEVANCEWEB,
"mvc.command.name=/grievance/reply" }, service = MVCActionCommand.class)
public class DGFoodGrievanceReplyMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		long grievanceId = 0;
		String redirectURL = StringPool.BLANK;
		try {
			
			ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			grievanceId = ParamUtil.getLong(actionRequest, ParameterConstants.GRIEVANCE_ID);
			String responseDetails = ParamUtil.getString(actionRequest, ParameterConstants.RESPONSE_DETAILS);
			redirectURL = ParamUtil.getString(actionRequest, ParameterConstants.REDIRECT_URL);
			
			_log.info("grievanceId - "+grievanceId);
			_log.info("responseDetails - "+responseDetails);

			
			if(Validator.isNotNull(grievanceId) && Validator.isNotNull(responseDetails)) {
				GrievanceLocalServiceUtil.replyGrievance(themeDisplay, grievanceId, responseDetails);
			}
			
			SessionMessages.add(actionRequest, "label-grievance-reply-submitted-successfully");
			String mvcPath = "/success.jsp";
			actionResponse.setRenderParameter("mvcPath", mvcPath);
		}
		catch (Exception e) {
			e.printStackTrace();
			_log.error("Error - "+e.getMessage());
			String mvcPath = "/details.jsp";
			SessionErrors.add(actionRequest, "label-grievance-reply-submission-failed");
			
			RenderURL successPageURL=actionResponse.createRedirectURL(Copy.NONE);
			successPageURL.setParameter("mvcPath", mvcPath);
			successPageURL.setParameter("grievanceId", String.valueOf(grievanceId));
			successPageURL.setParameter("redirect", redirectURL);
			actionResponse.sendRedirect(successPageURL.toString());
		}
	}
	private static final Log _log = LogFactoryUtil.getLog(DGFoodGrievanceReplyMVCResourceCommand.class);
}
