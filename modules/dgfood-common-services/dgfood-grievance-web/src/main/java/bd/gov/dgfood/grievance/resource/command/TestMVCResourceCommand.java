package bd.gov.dgfood.grievance.resource.command;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.common.util.NotificationUtil;
import bd.gov.dgfood.common.util.constants.NotificationTemplateConstants;
import bd.gov.dgfood.grievance.constants.DgfoodGrievanceWebPortletKeys;

@Component(immediate = true, property = {
				"javax.portlet.name=" + DgfoodGrievanceWebPortletKeys.DGFOODGRIEVANCEWEB,
				"mvc.command.name=/test" }, service = MVCResourceCommand.class)

public class TestMVCResourceCommand implements MVCResourceCommand{
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		try {
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		_log.info("Testing....");
		
		Map<String, String> smsMap = new HashMap<String, String>();
		smsMap.put("APPLICATION_NUMBER", "12345");
		NotificationUtil.sendSMS(themeDisplay, "8600522665", NotificationTemplateConstants.FARMER_REGISTRATION_APPLICATION_SUBMITTED, smsMap);
		
//		NotificationUtil.sendMail(themeDisplay, "ashish.singh@liferay.com", NotificationTemplateConstants.FARMER_REGISTRATION_APPLICATION_SUBMITTED, smsMap);
//		
//		NotificationUtil.sendWebsiteNotification(themeDisplay, themeDisplay.getUserId(), NotificationTemplateConstants.FARMER_REGISTRATION_APPLICATION_SUBMITTED, smsMap);
	
		//ExcelReportGenerationUtil.generateModuleReportAndCount(resourceRequest, resourceResponse);
		}
		catch (Exception e) {
			e.printStackTrace();
			_log.error("Error - "+e.getMessage());
		}
		return false;
	}
	private static final Log _log = LogFactoryUtil.getLog(TestMVCResourceCommand.class);
}
