package bd.gov.dgfood.foodgrain.license.resources;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.common.util.constants.ParameterConstants;
import bd.gov.dgfood.common.util.validator.DataValidationException;
import bd.gov.dgfood.foodgrain.license.constants.FoodGrainLicensePortletKeys;
import bd.gov.dgfood.license.management.system.validator.FoodGrainLicenseValidator;

/**
 * 
 * @author Abhijit Ande
 *
 *This Resource class is used to validate the National ID entered by the user in DB and send the appropriate response to JSP.
 */

@Component(immediate = true, property = {
		"javax.portlet.name=" + FoodGrainLicensePortletKeys.HOMESCREENFGLICENSE,
		"mvc.command.name="+ FoodGrainLicensePortletKeys.VALIDATE_NATIONAL_ID_RESOURCE_COMMAND 
}, 
service = MVCResourceCommand.class)

public class ValidateNationalIdResouceCommand extends BaseMVCResourceCommand {

	
	/**
	 * This method is used to validate the National ID entered by the user in DB and send the appropriate response to JSP. 
	 * 
	 * @param resourceRequest
	 * @param resourceResponse
	 * @return boolean
	 */
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(resourceRequest);
		boolean isNationalIdExist = true;
		String nationalId = ParamUtil.getString(resourceRequest, ParameterConstants.NATIONAL_ID);

		try {
			FoodGrainLicenseValidator.validateUserForNewFGL(nationalId, serviceContext);
			isNationalIdExist = false;
		}catch(DataValidationException dataValidationException) {
			logger.error("Exception occured while validating NationalId: " + dataValidationException.getMessage());
			if (logger.isDebugEnabled()) {
				dataValidationException.printStackTrace();
			}
		}

		try {
			JSONObject nationalIdValidationReponse = JSONFactoryUtil.createJSONObject();
			nationalIdValidationReponse.put("isNationalIdExist", isNationalIdExist);
			resourceResponse.getWriter().write(nationalIdValidationReponse.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Log logger = LogFactoryUtil.getLog(this.getClass());
}
