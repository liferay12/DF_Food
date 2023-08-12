package bd.gov.dgfood.farmer.information.management.system.web.portlet.render;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.common.services.model.Address;
import bd.gov.dgfood.common.services.model.Attachment;
import bd.gov.dgfood.common.services.service.AddressLocalService;
import bd.gov.dgfood.common.services.service.AttachmentLocalService;
import bd.gov.dgfood.common.util.CategoryUtil;
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
				+ FarmerInformationManagementSystemConstants.FARMER_REGISTRATION_DETAILED_VIEW_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class FarmerRegistrationDetailedViewRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		try {

			long farmerRegistrationId = ParamUtil.getLong(renderRequest, ParameterConstants.FARMER_REGISTRATION_ID);

			logger.debug(farmerRegistrationId);

			FarmerRegistration farmerRegistration = farmerRegistrationLocalService
					.fetchFarmerRegistration(farmerRegistrationId);

			if (Validator.isNull(farmerRegistration)) {
				throw new NoSuchFarmerRegistrationException("error-label-no-farmer-registration-found");
			}

			List<Address> farmerRegistrationAddressList = addressLocalService.getAddressListByClassNameAndClassPK(
					farmerRegistration.getFarmerRegistrationId(), FarmerRegistration.class.getName());

			Map<Long, AssetCategory> farmerRegistrationAddressCategories = CategoryUtil
					.getAddressCategories(farmerRegistrationAddressList);

			List<Attachment> farmerRegistrationAttachmentList = attachmentLocalService
					.getAttachmentsByClassPKAndClassName(farmerRegistration.getFarmerRegistrationId(),
							FarmerRegistration.class.getName());

			logger.debug(farmerRegistration);
			logger.debug(farmerRegistrationAddressList);
			logger.debug(farmerRegistrationAttachmentList);

			renderRequest.setAttribute("farmerRegistration", farmerRegistration);
			renderRequest.setAttribute("farmerRegistrationAddressList", farmerRegistrationAddressList);
			renderRequest.setAttribute("farmerRegistrationAddressCategories", farmerRegistrationAddressCategories);
			renderRequest.setAttribute("farmerRegistrationAttachmentList", farmerRegistrationAttachmentList);

			return FarmerInformationManagementSystemConstants.FARMER_REGISTRATION_DETAILED_VIEW_JSP;

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

		return FarmerInformationManagementSystemConstants.FARMER_REGISTRATIONS_LIST_JSP;
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
					.fetchFarmerRegistrationByApplicationNumberDob(applicationNumber, dateOfBirth);

		} else if (inputType.equalsIgnoreCase(ParameterConstants.NATIONAL_ID)) {

			FormValidator.validateNationalId(nationalId, true, ParameterConstants.NATIONAL_ID);
			farmerRegistration = farmerRegistrationLocalService.fetchFarmerRegistrationByNationalIdDob(nationalId,
					dateOfBirth);

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
