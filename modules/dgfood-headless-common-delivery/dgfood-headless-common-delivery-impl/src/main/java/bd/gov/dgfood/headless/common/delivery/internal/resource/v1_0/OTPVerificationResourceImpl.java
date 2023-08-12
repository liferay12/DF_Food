package bd.gov.dgfood.headless.common.delivery.internal.resource.v1_0;

import bd.gov.dgfood.common.util.OTPGenerationUtil;
import bd.gov.dgfood.common.util.constants.StatusConstants;
import bd.gov.dgfood.configuration.OTPConfiguration;
import bd.gov.dgfood.headless.common.delivery.dto.v1_0.OTPVerification;
import bd.gov.dgfood.headless.common.delivery.resource.v1_0.OTPVerificationResource;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.portlet.ResourceRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Response;

import org.jsoup.HttpStatusException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationProviderUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;

/**
 * This class is for verifying the otp sent via mobile app
 * @author Prarthana Jadhav
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0/otp-verification.properties", scope = ServiceScope.PROTOTYPE, service = OTPVerificationResource.class)
public class OTPVerificationResourceImpl extends BaseOTPVerificationResourceImpl {

	//This method is for verifying the otp entered
	@Override
	public OTPVerification verifyOTP(@NotNull String mobileno, @NotNull String otpval) throws Exception {
		OTPVerification otpVerificationdata=new OTPVerification();
		
		//Fetching details from OTP configuration of System Settings
		OTPConfiguration otpConfiguration = ConfigurationProviderUtil.getSystemConfiguration(OTPConfiguration.class);
		int otpExpiryTime = otpConfiguration.getOtpExpiryTime();
		int maxOtpVerifyAttempt = otpConfiguration.getMaxOtpVerifyAttempts();
		
		//fetching the details from session to compare and verify the results
		HttpSession httpSession = _getHttpSession(contextHttpServletRequest);
		String otpSent = (String) httpSession.getAttribute("otpSent");
		String mobile = (String) httpSession.getAttribute("MobileNo");
		int maxOtpVerifyCounter = (int) httpSession.getAttribute("maxOtpVerifyCounter");
		maxOtpVerifyCounter = maxOtpVerifyCounter + 1;
		httpSession.setAttribute("maxOtpVerifyCounter", maxOtpVerifyCounter);
		
		long otpGeneratedTime = (Long) httpSession.getAttribute("otpGeneratedTime");
		long diff = OTPGenerationUtil.timeDiffInMillies(otpGeneratedTime);
		log.debug("otpExpiryTime :" + otpExpiryTime + ", maxOtpVerifyAttempt " + maxOtpVerifyAttempt+ ",maxOtpVerifyCounter" + maxOtpVerifyCounter + ", diff: " + diff);
		// checking time less than 10 min for otp expire
		if (maxOtpVerifyCounter > maxOtpVerifyAttempt) {
			otpVerificationdata.setErrorMsg("You have exceeded max number of Verifying OTP the attempts.");
			otpVerificationdata.setStatusCode(contextHttpServletResponse.SC_OK);
			otpVerificationdata.setExceededVerifyMaxAttempt(true);
			otpVerificationdata.setIsOtpExpired(false);
		} else {
			if (Validator.isNotNull(otpSent) && Validator.isNotNull(otpval)) {
				if (diff < otpExpiryTime) {
					log.debug("diff :" + diff);
					if (otpSent.equalsIgnoreCase(otpval) && mobile.equals(mobileno)) {
						otpVerificationdata.setErrorMsg("OTP Matched");
						otpVerificationdata.setStatusCode(contextHttpServletResponse.SC_OK);
						otpVerificationdata.setIsOtpExpired(false);
						otpVerificationdata.setExceededVerifyMaxAttempt(false);

					} else {
						otpVerificationdata.setErrorMsg("Please enter a valid otp");
						otpVerificationdata.setStatusCode(contextHttpServletResponse.SC_OK);
						otpVerificationdata.setIsOtpExpired(false);
						otpVerificationdata.setExceededVerifyMaxAttempt(false);
					}
				} else {
					otpVerificationdata.setErrorMsg("OTP Expired");
					otpVerificationdata.setStatusCode(contextHttpServletResponse.SC_OK);
					otpVerificationdata.setIsOtpExpired(true);
					otpVerificationdata.setExceededVerifyMaxAttempt(false);
				}
			}
		}
		return (otpVerificationdata);
	}

	private HttpSession _getHttpSession(HttpServletRequest httpServletRequest) {
		HttpServletRequest originalHttpServletRequest = portal.getOriginalServletRequest(httpServletRequest);

		return originalHttpServletRequest.getSession();
	}

	private Log log = LogFactoryUtil.getLog(this.getClass());

	@Reference
	protected Portal portal;

}