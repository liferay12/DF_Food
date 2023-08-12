package bd.gov.dgfood.food.friendly.program.web.internal.portlet.action;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.food.friendly.program.constants.FoodFriendlyProgramPortletKeys;
import bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary;
import bd.gov.dgfood.food.friendly.program.service.FFPBeneficiaryLocalServiceUtil;

/**
 * It helps to validate duplicate NID in DB and to retrieve basic information
 * from NID server
 * 
 * @author krishna
 *
 */
@Component(property = { "javax.portlet.name=" + FoodFriendlyProgramPortletKeys.FOOD_FRIENDLY_PROGRAM_ADMIN,
		"mvc.command.name=/verify/nid" }, service = MVCResourceCommand.class)
public class NIDVerificationMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		try {
			HttpServletRequest httpServletRequest = _portal.getHttpServletRequest(resourceRequest);

			HttpServletResponse httpServletResponse = _portal.getHttpServletResponse(resourceResponse);

			// CaptchaUtil.check(resourceRequest);

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

			httpServletResponse.setContentType(ContentTypes.APPLICATION_JSON);

			long nationalId = ParamUtil.getLong(httpServletRequest, "nationalId");

			_log.info(" nationalId ... " + nationalId);

			String dob = ParamUtil.getString(httpServletRequest, "dob");

			String mobileNumber = ParamUtil.getString(httpServletRequest, "mobileNumber");

			String terms = ParamUtil.getString(httpServletRequest, "terms");

			FFPBeneficiary ffpRegistration = FFPBeneficiaryLocalServiceUtil.getBenificiaryByNationalId(nationalId);

			if (Validator.isNotNull(ffpRegistration)) {
				throw new Exception("National Id must not be duplicate ");
			}
			resourceResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE,
					String.valueOf(HttpServletResponse.SC_ACCEPTED));
			// ServletResponseUtil.write(httpServletResponse, jsonObject.toString());

		} catch (Exception e) {
			_log.error(e.getMessage());
			resourceResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE,
					String.valueOf(HttpServletResponse.SC_UNAUTHORIZED));

		}

	}

	private static final Log _log = LogFactoryUtil.getLog(NIDVerificationMVCResourceCommand.class);

	@Reference
	private Portal _portal;
}
