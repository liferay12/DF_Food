package bd.gov.dgfood.grievance.resource.command;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.common.services.service.GrievanceLocalServiceUtil;
import bd.gov.dgfood.common.util.constants.ParameterConstants;
import bd.gov.dgfood.grievance.constants.DgfoodGrievanceWebPortletKeys;

@Component(immediate = true, property = {
				"javax.portlet.name=" + DgfoodGrievanceWebPortletKeys.DGFOODGRIEVANCEWEB,
				"mvc.command.name=/grievance/reply" }, service = MVCResourceCommand.class)

//This class is used to update reply details in grievances 
public class DGFoodGrievanceReplyMVCResourceCommand implements MVCResourceCommand{
	
	//This method is used to get to call the serveResource to update reply for grievances
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			long grievanceId = ParamUtil.getLong(resourceRequest, ParameterConstants.GRIEVANCE_ID);
			String responseDetails = ParamUtil.getString(resourceRequest, ParameterConstants.RESPONSE_DETAILS);
			
			_log.debug("grievanceId - "+grievanceId);
			_log.debug("responseDetails - "+responseDetails);
			
			if(Validator.isNotNull(grievanceId) && Validator.isNotNull(responseDetails)) {
				GrievanceLocalServiceUtil.replyGrievance(themeDisplay, grievanceId, responseDetails);
			}
			}
			catch (Exception e) {
				e.printStackTrace();
				_log.error("Error - "+e.getMessage());
			}
			return false;
	}
	private static final Log _log = LogFactoryUtil.getLog(DGFoodGrievanceReplyMVCResourceCommand.class);
}
