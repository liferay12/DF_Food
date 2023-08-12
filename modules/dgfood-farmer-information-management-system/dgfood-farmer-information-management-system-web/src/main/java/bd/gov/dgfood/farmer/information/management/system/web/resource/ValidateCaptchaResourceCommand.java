package bd.gov.dgfood.farmer.information.management.system.web.resource;

import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.portal.kernel.captcha.CaptchaException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.common.util.ConfigurationUtil;
import bd.gov.dgfood.configuration.BypassValidationConfiguration;
import bd.gov.dgfood.farmer.information.management.system.web.constants.FarmerInformationManagementSystemConstants;
import bd.gov.dgfood.farmer.information.management.system.web.constants.FarmerInformationManagementSystemPortletKeys;

@Component(immediate = true, property = {
		"javax.portlet.name=" + FarmerInformationManagementSystemPortletKeys.FARMERINFORMATIONMANAGEMENTSYSTEM,
		"mvc.command.name="
				+ FarmerInformationManagementSystemConstants.VALIDATE_CAPTCHA_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class ValidateCaptchaResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		logger.debug("Inside Captcha Resource Command");

		JSONObject captchaValidationReponse = JSONFactoryUtil.createJSONObject();

		try {
			BypassValidationConfiguration bypassValidationConfiguration = ConfigurationUtil
					.getBypassValidationConfiguration();
			if (Validator.isNull(bypassValidationConfiguration)
					|| !bypassValidationConfiguration.isCaptchaValidationDisabled()) {
				CaptchaUtil.check(resourceRequest);
			} else {
				logger.debug("Captcha Validation disabled. Please enable it in System Configurations");
			}
			captchaValidationReponse.put("isCaptchaValid", true);
		} catch (CaptchaException captchaTextException) {
			logger.warn("Invalid captcha entred by the user");
			captchaValidationReponse.put("isCaptchaValid", false);
		}

		try {
			resourceResponse.getWriter().write(captchaValidationReponse.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}

	private Log logger = LogFactoryUtil.getLog(this.getClass());
}
