package bd.gov.dgfood.foodgrain.license.resources;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.PrintWriter;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.common.util.OTPGenerationUtil;
import bd.gov.dgfood.foodgrain.license.constants.FoodGrainLicensePortletKeys;

/**
 * 
 * @author Abhijit Ande
 *
 *This Resource class is used to generate OTP, resend OTP & validate OTP entered by the user and send the appropriate response to JSP.
 */

@Component(immediate = true, property = {
		"javax.portlet.name=" + FoodGrainLicensePortletKeys.HOMESCREENFGLICENSE,
		"mvc.command.name=" + FoodGrainLicensePortletKeys.GENERATE_AND_VALIDATE_OTP_MVC_RESOURCE_COMMAND 
}, service = MVCResourceCommand.class)
public class GenerateAndValidateOTPResourceCommand extends BaseMVCResourceCommand {

	/**
	 * This method is used to generate OTP, resend OTP & validate OTP entered by the user and send the appropriate response to JSP. 
	 * 
	 * @param resourceRequest
	 * @param resourceResponse
	 * @return void
	 */
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		//vargetOTPForUser is defined in otp taglib. We are using for otp trigger
		if (ParamUtil.getString(resourceRequest, "action").equals("vargetOTPForUser")) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			JSONArray responseJsonArray = JSONFactoryUtil.createJSONArray();
			PrintWriter out = null;
			try {
				out = resourceResponse.getWriter();
				String contactNumber = ParamUtil.getString(resourceRequest, "contactNumber");
				int otpResendMaxAttemptsUser = ParamUtil.getInteger(resourceRequest, "otpResendMaxAttemptsUser");
				logger.debug("contactNumber: "+contactNumber+",otpResendMaxAttemptsUser: "+otpResendMaxAttemptsUser);
				jsonObject = OTPGenerationUtil.getOtpforUser(contactNumber, otpResendMaxAttemptsUser, resourceRequest);
				responseJsonArray.put(jsonObject);
				logger.debug("responseJsonArray :" + responseJsonArray.toString());
				out.print(responseJsonArray);
			} catch (Exception e) {
				logger.error("Errors Occured : " + e.getMessage());
				out.print(responseJsonArray);
			}
		}
		//verifyOtp is defined in otp taglib. We are using for otp verification
		if (ParamUtil.getString(resourceRequest, "action").equals("verifyOtp")) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			JSONArray responseJsonArray = JSONFactoryUtil.createJSONArray();

			logger.debug("Inside the java class: verifyOtp");
			PrintWriter out = null;
			try {
				out = resourceResponse.getWriter();
				// get the otp entered in the screen
				String userEnterdOtp = ParamUtil.getString(resourceRequest, "userEnterdOtp");
				logger.debug("userEnterdOtp :" + userEnterdOtp);
				jsonObject = OTPGenerationUtil.verifyOTP(userEnterdOtp, resourceRequest);
				responseJsonArray.put(jsonObject);
				logger.debug("responseJsonArray :" + responseJsonArray.toString());
				out.print(responseJsonArray);
			}
			catch (Exception e) {
				logger.error("Errors Occured : " + e.getMessage());
				out.print(responseJsonArray);
			}
		}

	}
	
	private Log logger = LogFactoryUtil.getLog(this.getClass());
}