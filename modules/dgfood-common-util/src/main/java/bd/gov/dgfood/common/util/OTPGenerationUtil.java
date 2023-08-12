package bd.gov.dgfood.common.util;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationProviderUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;

import bd.gov.dgfood.configuration.OTPConfiguration;

/**
 * This class is used to generate OTP, verify the OTP entered by User and Send the OTP
 * @author Prarthana Jadhav
 *
 */

public class OTPGenerationUtil {

	// This method will return the generated otp and will parallely send the sms to the end user
	public static String generateOtp(int length, String mobileno) {
		int randomNo;
		String otp = "";
		for (int i = 0; i < length; i++) {
			// Generate random digit within 0-9
			randomNo = new Random().nextInt(9);
			otp = otp.concat(Integer.toString(randomNo));
		}
		log.debug("otp: " + otp);
		return otp;
	}

	// This method is used to get the otp based on max verify attempts and resend attempts of the user. The maxOtpVerifyAttempt,otpResendMaxAttempts,lockingtime all are system level configuration.
	public static JSONObject getOtpforUser(String contactNumber, int otpResendMaxAttemptsUser,
			ResourceRequest resourceRequest) {
		log.debug("Inside the java method: getOtpforUser");
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		try {
			OTPConfiguration otpConfiguration = ConfigurationProviderUtil
					.getSystemConfiguration(OTPConfiguration.class);
			int maxOtpVerifyAttempt = otpConfiguration.getMaxOtpVerifyAttempts();			
			int otpResendMaxAttempts = otpConfiguration.getOTPResendMaxAttempts();
			log.debug("otpResendMaxAttempts :" + otpResendMaxAttempts+", maxOtpVerifyAttempt :" + maxOtpVerifyAttempt);
			log.debug("contactNumber: " + contactNumber + " otpResendMaxAttemptsUser: " + otpResendMaxAttemptsUser);
			PortletSession session = resourceRequest.getPortletSession();
			if (otpResendMaxAttemptsUser <= 0) {
				log.debug("otpResendMaxAttemptsUser inside");
				long otpGeneratedTime = (Long) session.getAttribute("otpGeneratedTime");
				long diffInMillies = Math.abs(otpGeneratedTime - new Date().getTime());
				long diff = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);
				log.debug("diff :" + diff + ". otpGeneratedTime: " + otpGeneratedTime + ", diffInMillies: "
						+ diffInMillies + " loc: " + otpConfiguration.getLockOutTime());

				if (diff >= otpConfiguration.getLockOutTime()) {
					otpResendMaxAttemptsUser = otpResendMaxAttempts;
					log.debug("otpResendMaxAttemptsUser:" + otpResendMaxAttemptsUser + ", otpResendMaxAttempts: "
							+ otpResendMaxAttempts);					
					jsonObject.put("otpResendMaxAttemptsUser", otpResendMaxAttemptsUser);

				}
			} else if (Validator.isNotNull(contactNumber)) {
				String otp = OTPGenerationUtil.generateOtp(6, contactNumber);
				log.debug("otp: " + otp);
				session.setAttribute("otpGeneratedTime", System.currentTimeMillis());
				int otpLength = otp.length();
				log.debug("otpLength: " + otpLength);
				session.setAttribute("userOtp", otp);
				session.setAttribute("otpLength", otpLength);
				jsonObject.put("otpLength", otpLength);
			}
			log.info("jsonObject: "+jsonObject.toString());

		} catch (Exception e) {
			log.error("Errors Occured : " + e.getMessage());
			jsonObject.put("errorFlag", true);
			jsonObject.put("errorMsg", "The service is temporarily unavailable! Try again later. ");
		}
		return jsonObject;
	}

	//This method verifies the otp sent and entered by the user and based on this same the result is shared
	public static JSONObject verifyOTP(String userEnterdOtp, ResourceRequest resourceRequest) {
		log.debug("Inside the java class: verifyOtp");
		JSONObject responseJson = JSONFactoryUtil.createJSONObject();	
		try {
			OTPConfiguration otpConfiguration = ConfigurationProviderUtil
					.getSystemConfiguration(OTPConfiguration.class);
			// get the otp sent via mobile
			PortletSession session = resourceRequest.getPortletSession();
			String otpSent = session.getAttribute("userOtp").toString();
			log.debug("otpSent :" + otpSent+", userEnterdOtp :" + userEnterdOtp);
			// getting OtpCreatedTime as milisecond from session and converting into minute
			long otpGeneratedTime = (Long) session.getAttribute("otpGeneratedTime");
			long diff = timeDiffInMillies(otpGeneratedTime);
			int otpExpiryTime = otpConfiguration.getOtpExpiryTime();
			log.debug("otpExpiryTime :" + otpExpiryTime);
			// checking time less than 10 min for otp expire
			if (Validator.isNotNull(otpSent) && Validator.isNotNull(userEnterdOtp)) {
				if (diff < otpExpiryTime) {
					if (otpSent.equalsIgnoreCase(userEnterdOtp)) {
						responseJson.put("status", "ok");
					} else {
						responseJson.put("status", "notOK");
					}
				} else {
					responseJson.put("status", "timeout");
				}
			}

		} catch (Exception e) {
			log.error("Errors Occured : " + e.getMessage());
			responseJson.put("errorFlag", true);
			responseJson.put("errorMsg", "The service is temporarily unavailable! Try again later. ");
		}
		return responseJson;

	}

	public static long timeDiffInMillies(long otpGeneratedTime) {
		long diffInMillies = Math.abs(otpGeneratedTime - new Date().getTime());
		long diff = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);
		return diff;
	}
	private static Log log = LogFactoryUtil.getLog(OTPGenerationUtil.class);

}
