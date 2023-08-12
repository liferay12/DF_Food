package bd.gov.dgfood.farmer.information.management.system.web.resource;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.common.util.constants.ParameterConstants;
import bd.gov.dgfood.farmer.information.management.system.model.FarmerRegistration;
import bd.gov.dgfood.farmer.information.management.system.service.FarmerRegistrationLocalService;
import bd.gov.dgfood.farmer.information.management.system.web.constants.FarmerInformationManagementSystemConstants;
import bd.gov.dgfood.farmer.information.management.system.web.constants.FarmerInformationManagementSystemPortletKeys;

@Component(immediate = true, property = {
		"javax.portlet.name=" + FarmerInformationManagementSystemPortletKeys.FARMERINFORMATIONMANAGEMENTSYSTEM,
		"mvc.command.name="
				+ FarmerInformationManagementSystemConstants.VALIDATE_NATIONAL_ID__RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class ValidateNationalIdResouceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String nationalId = ParamUtil.getString(resourceRequest, ParameterConstants.NATIONAL_ID);
		String mobileNumber = ParamUtil.getString(resourceRequest, ParameterConstants.MOBILE_NUMBER);
		String dateOfBirth = ParamUtil.getString(resourceRequest, ParameterConstants.DATE_OF_BIRTH);

		logger.debug(nationalId);
		logger.debug(dateOfBirth);
		logger.debug(mobileNumber);

		FarmerRegistration farmerRegistration = farmerRegistrationLocalService.fetchFarmerRegistrationByNationalId(nationalId);

		JSONObject nationalIdValidationReponse = JSONFactoryUtil.createJSONObject();
		if (Validator.isNotNull(farmerRegistration)) {
			nationalIdValidationReponse.put("isNationalIdExist", true);
		} else {
			nationalIdValidationReponse.put("isNationalIdExist", false);
		}

		try {
			resourceResponse.getWriter().write(nationalIdValidationReponse.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Log logger = LogFactoryUtil.getLog(this.getClass());

	@Reference
	private FarmerRegistrationLocalService farmerRegistrationLocalService;

}
