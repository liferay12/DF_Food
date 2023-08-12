package bd.gov.dgfood.milling.license.resources;

import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.portal.kernel.captcha.CaptchaException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.milling.license.constants.MillingLicensePortletKeys;

@Component
(
		immediate = true, 
		property = { 
				"javax.portlet.name="+MillingLicensePortletKeys.MILLINGLICENSE, 
				"mvc.command.name="+MillingLicensePortletKeys.VERIFY_CAPTCHA_MVC_RESOURCE_COMMAND 
		},
		service = MVCResourceCommand.class 
		)
public class VerifyCaptchaMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException {
		
		logger.debug("Entered VerifyCaptchaMVCResourceCommand");
		
		JSONObject captchaValidationReponse=JSONFactoryUtil.createJSONObject();
		try
		{
			CaptchaUtil.check(resourceRequest);
			captchaValidationReponse.put("isCaptchaValid", true);
		}
		catch (CaptchaException captchaTextException) {
			logger.warn("Invalid captcha entered by the user");
			captchaValidationReponse.put("isCaptchaValid", false);
		}
		
		try
		{
			resourceResponse.getWriter().write(captchaValidationReponse.toString());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}

	private Log logger=LogFactoryUtil.getLog(this.getClass());
}