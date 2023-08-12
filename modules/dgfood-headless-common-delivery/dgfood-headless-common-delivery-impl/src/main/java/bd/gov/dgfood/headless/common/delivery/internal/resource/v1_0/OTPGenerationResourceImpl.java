package bd.gov.dgfood.headless.common.delivery.internal.resource.v1_0;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationProviderUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;

import bd.gov.dgfood.common.util.DateFormatterUtil;
import bd.gov.dgfood.common.util.OTPGenerationUtil;
import bd.gov.dgfood.configuration.OTPConfiguration;
import bd.gov.dgfood.headless.common.delivery.dto.v1_0.OTPGeneration;
import bd.gov.dgfood.headless.common.delivery.resource.v1_0.OTPGenerationResource;

/**
 * This class is for generating the otp for mobile app users
 * @author Prarthana Jadhav
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0/otp-generation.properties", scope = ServiceScope.PROTOTYPE, service = OTPGenerationResource.class)
public class OTPGenerationResourceImpl extends BaseOTPGenerationResourceImpl {

	//This method is used to generate the first time otp.
	@Override
	public OTPGeneration getOTPNumber(@NotNull String mobileno) throws Exception {
		OTPGeneration OTPGenerationdata = new OTPGeneration();
		String errorMsg;
		int maxOtpVerifyCounter = 0;
		int maxOtpResendCounter = 0;
		long currentTime = System.currentTimeMillis();
		log.debug("currentTime: " + currentTime);
		String otpSent = OTPGenerationUtil.generateOtp(6, mobileno);
		log.debug("otpSent: "+otpSent);

		//setting the values in session so that we can validate in verfiy function
		HttpSession httpSession = _getHttpSession(contextHttpServletRequest);
		httpSession.setAttribute("otpSent", otpSent);
		httpSession.setAttribute("MobileNo", mobileno);
		httpSession.setAttribute("otpGeneratedTime", currentTime);
		httpSession.setAttribute("maxOtpVerifyCounter", maxOtpVerifyCounter);
		httpSession.setAttribute("maxOtpResendCounter", maxOtpResendCounter);

		if (Validator.isNotNull(otpSent) && otpSent.length() == 6) {
			errorMsg = "Success";
			OTPGenerationdata.setStatusCode(contextHttpServletResponse.SC_OK);
			OTPGenerationdata.setErrorMsg(errorMsg);
		} else {
			errorMsg = "Failure";
			OTPGenerationdata.setStatusCode(contextHttpServletResponse.SC_UNAUTHORIZED);
			OTPGenerationdata.setErrorMsg(errorMsg);
		}
		log.debug("OtpNum: " + otpSent + "errorCode: " + errorMsg);
		log.debug("OTPGenerationdata " + OTPGenerationdata.toString());
		return OTPGenerationdata;
	}

	//This method is used to generate and resend time otp.

	@Override
	public OTPGeneration resendOTPNumber(@NotNull String mobileno) throws Exception {
		OTPConfiguration otpConfiguration = ConfigurationProviderUtil.getSystemConfiguration(OTPConfiguration.class);
		OTPGeneration resendOTPNumberdata = new OTPGeneration();
		int maxOtpVerifyCounter = 0;
		HttpSession httpSession = _getHttpSession(contextHttpServletRequest);
		httpSession.setAttribute("maxOtpVerifyCounter", maxOtpVerifyCounter);
		int resentattempts = (int) httpSession.getAttribute("maxOtpResendCounter");
		httpSession.setAttribute("otpGeneratedTime", System.currentTimeMillis());
		log.debug("resentattempts: " + resentattempts);
		if (resentattempts<otpConfiguration.getOTPResendMaxAttempts()) {
			String otpSent = OTPGenerationUtil.generateOtp(6, mobileno);
			log.debug("otpSent: "+otpSent);
			resentattempts++;
			httpSession.setAttribute("maxOtpResendCounter", resentattempts);
			resendOTPNumberdata.setErrorMsg("OTP sent Successfully.");
			resendOTPNumberdata.setStatusCode(contextHttpServletResponse.SC_OK);
			resendOTPNumberdata.setIsLockOut(false);
			resendOTPNumberdata.setExceededResendMaxAttempt(false);
		} else {
			long currentTime = System.currentTimeMillis();
			String date = DateFormatterUtil.DateFormat(currentTime);
			resendOTPNumberdata
					.setErrorMsg("You have exceeded max number of Resend OTP attempts. Please try after 15 mins.");
			resendOTPNumberdata.setStatusCode(contextHttpServletResponse.SC_OK);
			resendOTPNumberdata.setLockOutTime(date);
			resendOTPNumberdata.setIsLockOut(true);
			resendOTPNumberdata.setExceededResendMaxAttempt(true);
		}
		return (resendOTPNumberdata);
	}

	private HttpSession _getHttpSession(HttpServletRequest httpServletRequest) {
		HttpServletRequest originalHttpServletRequest = portal.getOriginalServletRequest(httpServletRequest);

		return originalHttpServletRequest.getSession();
	}

	private Log log = LogFactoryUtil.getLog(this.getClass());

	@Reference
	protected Portal portal;
}