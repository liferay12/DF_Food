package bd.gov.dgfood.farmer.information.management.system.web.portlet.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.common.services.service.AddressLocalService;
import bd.gov.dgfood.common.services.service.AttachmentLocalService;
import bd.gov.dgfood.common.util.DateFormatterUtil;
import bd.gov.dgfood.common.util.constants.ParameterConstants;
import bd.gov.dgfood.common.util.constants.ParameterLabelConstants;
import bd.gov.dgfood.common.util.validator.DataValidationException;
import bd.gov.dgfood.common.util.validator.FormValidator;
import bd.gov.dgfood.farmer.information.management.system.exception.NoSuchFarmerRegistrationException;
import bd.gov.dgfood.farmer.information.management.system.model.FarmerRegistration;
import bd.gov.dgfood.farmer.information.management.system.service.FarmerRegistrationLocalService;
import bd.gov.dgfood.farmer.information.management.system.web.constants.FarmerInformationManagementSystemConstants;
import bd.gov.dgfood.farmer.information.management.system.web.constants.FarmerInformationManagementSystemPortletKeys;

@Component(immediate = true, property = {
		"javax.portlet.name=" + FarmerInformationManagementSystemPortletKeys.FARMERINFORMATIONMANAGEMENTSYSTEM,
		"mvc.command.name="
				+ FarmerInformationManagementSystemConstants.FARMER_REGISTRATION_STATUS_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class FarmerRegistrationStatusRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		try {

			String inputType = ParamUtil.getString(renderRequest, "inputType");
			String nationalId = ParamUtil.getString(renderRequest, ParameterConstants.NATIONAL_ID);
			String applicationNumber = ParamUtil.getString(renderRequest, ParameterConstants.APPLICATION_NUMBER);
			String dateOfBirth = ParamUtil.getString(renderRequest, ParameterConstants.DATE_OF_BIRTH);
			Date parsedDateOfBirth = DateFormatterUtil.parseDate(dateOfBirth);

			logger.debug(inputType);
			logger.debug(nationalId);
			logger.debug(applicationNumber);
			logger.debug(dateOfBirth);

			FarmerRegistration farmerRegistration = getfarmerRegistration(inputType, applicationNumber, nationalId,
					parsedDateOfBirth);

			if (Validator.isNull(farmerRegistration)) {
				throw new NoSuchFarmerRegistrationException("error-label-no-farmer-registration-found");
			}

			renderRequest.setAttribute("farmerRegistration", farmerRegistration);

		} catch (DataValidationException dataValidationException) {

			logger.error(dataValidationException.getMessage());
			if (logger.isDebugEnabled()) {
				dataValidationException.printStackTrace();
			}

			renderRequest.setAttribute("errorKey", dataValidationException.getMessage());
			SessionErrors.add(renderRequest, dataValidationException.getClass());

		} catch (NoSuchFarmerRegistrationException noSuchFarmerRegistrationException) {

			logger.error(noSuchFarmerRegistrationException.getMessage());
			if (logger.isDebugEnabled()) {
				noSuchFarmerRegistrationException.printStackTrace();
			}

			renderRequest.setAttribute("errorKey", noSuchFarmerRegistrationException.getMessage());
			SessionErrors.add(renderRequest, noSuchFarmerRegistrationException.getClass());

		} catch (Exception exception) {
			logger.error(exception.getMessage());
			if (logger.isDebugEnabled()) {
				exception.printStackTrace();
			}

			renderRequest.setAttribute("errorKey", exception.getMessage());
			SessionErrors.add(renderRequest, exception.getClass());
		}

		return FarmerInformationManagementSystemConstants.FARMER_REGISTRATION_STATUS_FORM_JSP;
	}

	protected FarmerRegistration getfarmerRegistration(String inputType, String applicationNumber, String nationalId,
			Date dateOfBirth) throws DataValidationException {
		FarmerRegistration farmerRegistration = null;

		if (Validator.isNull(inputType)) {
			throw new DataValidationException("error-label-input-type-can-not-be-blank");
		}

		Date before18YearsDate = Date
				.from(LocalDate.now().minusYears(18).atStartOfDay(ZoneId.systemDefault()).toInstant());
		FormValidator.validateInput(dateOfBirth, ParameterConstants.DATE_OF_BIRTH, true, null, before18YearsDate);

		if (inputType.equalsIgnoreCase(ParameterConstants.APPLICATION_NUMBER)) {

			FormValidator.validateInput(applicationNumber, ParameterLabelConstants.LABEL_APPLICATION_NUMBER, true, 0, 0,
					null);
			farmerRegistration = farmerRegistrationLocalService
					.fetchFarmerRegistrationByApplicationNumberDob(applicationNumber,dateOfBirth);

		} else if (inputType.equalsIgnoreCase(ParameterConstants.NATIONAL_ID)) {

			FormValidator.validateNationalId(nationalId, true, ParameterConstants.NATIONAL_ID);
			farmerRegistration = farmerRegistrationLocalService.fetchFarmerRegistrationByNationalIdDob(nationalId,dateOfBirth);

		} else {
			throw new DataValidationException("error-label-input-type-invalid-select");
		}

		return farmerRegistration;
	}

	private Log logger = LogFactoryUtil.getLog(this.getClass());

	@Reference
	protected AddressLocalService addressLocalService;

	@Reference
	protected AttachmentLocalService attachmentLocalService;

	@Reference
	protected FarmerRegistrationLocalService farmerRegistrationLocalService;

}
