package bd.gov.dgfood.movement.contractor.portlet;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.PrintWriter;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.common.util.OTPGenerationUtil;
import bd.gov.dgfood.movement.contractor.constants.DgfoodMovementContractorWebPortletKeys;

/**
 * In this class we are checking on the OTP details. 
 * 
 * @author Prarthana Jadhav
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DgfoodMovementContractorWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DgfoodMovementContractorWebPortletKeys.DGFOODMOVEMENTCONTRACTORWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class DgfoodMovementContractorWebPortlet extends MVCPortlet {

	private static final Log logger = LogFactoryUtil.getLog(DgfoodMovementContractorWebPortlet.class);

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
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

}