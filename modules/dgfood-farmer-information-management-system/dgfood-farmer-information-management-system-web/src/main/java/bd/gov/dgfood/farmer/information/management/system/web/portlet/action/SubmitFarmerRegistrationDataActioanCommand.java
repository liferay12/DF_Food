package bd.gov.dgfood.farmer.information.management.system.web.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.vulcan.multipart.BinaryFile;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.common.util.DLUploadUtil;
import bd.gov.dgfood.common.util.constants.AddressConstants;
import bd.gov.dgfood.common.util.constants.FileConstants;
import bd.gov.dgfood.common.util.constants.ParameterConstants;
import bd.gov.dgfood.common.util.validator.DataValidationException;
import bd.gov.dgfood.farmer.information.management.system.exception.FarmerRegistrationInternalErrorException;
import bd.gov.dgfood.farmer.information.management.system.model.FarmerRegistration;
import bd.gov.dgfood.farmer.information.management.system.service.FarmerRegistrationLocalService;
import bd.gov.dgfood.farmer.information.management.system.web.constants.FarmerInformationManagementSystemConstants;
import bd.gov.dgfood.farmer.information.management.system.web.constants.FarmerInformationManagementSystemPortletKeys;
import bd.gov.dgfood.farmer.information.management.system.web.util.FarmerManagementWebUtil;

@Component(immediate = true, property = {
		"javax.portlet.name=" + FarmerInformationManagementSystemPortletKeys.FARMERINFORMATIONMANAGEMENTSYSTEM,
		"mvc.command.name="
				+ FarmerInformationManagementSystemConstants.SUBMIT_FARMER_REGISTRATION_FORM_ACTION_COMMAND }, service = MVCActionCommand.class)
public class SubmitFarmerRegistrationDataActioanCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);

		// Get the NationalId information
		String nationalId = ParamUtil.getString(actionRequest, ParameterConstants.NATIONAL_ID);
		String emailAddress = ParamUtil.getString(actionRequest, ParameterConstants.EMAIL_ADDRESS);
		String mobileNumber = ParamUtil.getString(actionRequest, ParameterConstants.MOBILE_NUMBER);
		String dateOfBirth = ParamUtil.getString(actionRequest, ParameterConstants.DATE_OF_BIRTH);

		// Validate NID informatio in iferay DB
		if(FarmerManagementWebUtil.isNationalIdExist(nationalId))
		{
			throw new DataValidationException("National Id already exist");
		}

		// Get the Farmer Basic Information
		String farmerName = ParamUtil.getString(actionRequest, ParameterConstants.APPLICANT_NAME);
		String fatherName = ParamUtil.getString(actionRequest, ParameterConstants.FATHER_NAME);
		String motherName = ParamUtil.getString(actionRequest, ParameterConstants.MOTHER_NAME);
		int gender = ParamUtil.getInteger(actionRequest, ParameterConstants.GENDER);
		String krishiCardNumber = ParamUtil.getString(actionRequest, ParameterConstants.KRISHOK_CARD_NUMBER);
		int maritalStatus = ParamUtil.getInteger(actionRequest, ParameterConstants.MARITAL_STATUS);

		String farmerCategory = ParamUtil.getString(actionRequest, ParameterConstants.FARMER_CATEGORY);
		String remarks = ParamUtil.getString(actionRequest, ParameterConstants.REMARKS);

		String cultivableLandSeason1Name = ParamUtil.getString(actionRequest,
				ParameterConstants.CULTIVABLE_LAND_SEASON_1_NAME);
		float cultivableLandSeason1Area = ParamUtil.getFloat(actionRequest,
				ParameterConstants.CULTIVABLE_LAND_SEASON_1_AREA);
		String cultivableLandSeason1Unit = ParamUtil.getString(actionRequest,
				ParameterConstants.CULTIVABLE_LAND_SEASON_1_UNIT);
		String cultivableLandSeason2Name = ParamUtil.getString(actionRequest,
				ParameterConstants.CULTIVABLE_LAND_SEASON_2_NAME);
		float cultivableLandSeason2Area = ParamUtil.getFloat(actionRequest,
				ParameterConstants.CULTIVABLE_LAND_SEASON_2_AREA);
		String cultivableLandSeason2Unit = ParamUtil.getString(actionRequest,
				ParameterConstants.CULTIVABLE_LAND_SEASON_2_UNIT);
		String cultivableLandSeason3Name = ParamUtil.getString(actionRequest,
				ParameterConstants.CULTIVABLE_LAND_SEASON_3_NAME);
		float cultivableLandSeason3Area = ParamUtil.getFloat(actionRequest,
				ParameterConstants.CULTIVABLE_LAND_SEASON_3_AREA);
		String cultivableLandSeason3Unit = ParamUtil.getString(actionRequest,
				ParameterConstants.CULTIVABLE_LAND_SEASON_3_UNIT);

		// Get teh Farmer's Paramanent Address
		long permanentRegion = ParamUtil.getLong(actionRequest,
				AddressConstants.ADDRESS_PERMANENT + ParameterConstants.REGION);
		long permanentZilla = ParamUtil.getLong(actionRequest,
				AddressConstants.ADDRESS_PERMANENT + ParameterConstants.ZILLA);
		long permanentUpazila = ParamUtil.getLong(actionRequest,
				AddressConstants.ADDRESS_PERMANENT + ParameterConstants.UPAZILA);
		long permanentCityCorporationOrMunicipality = ParamUtil.getLong(actionRequest,
				AddressConstants.ADDRESS_PERMANENT + ParameterConstants.CITY_CORPORATION_OR_MUNICIPALITY);
		long permanentUnionOrWard = ParamUtil.getLong(actionRequest,
				AddressConstants.ADDRESS_PERMANENT + ParameterConstants.UNION_OR_WARD);
		long permanentZipCode = ParamUtil.getLong(actionRequest,
				AddressConstants.ADDRESS_PERMANENT + ParameterConstants.ZIP_CODE);
		String permanentPostOffice = ParamUtil.getString(actionRequest,
				AddressConstants.ADDRESS_PERMANENT + ParameterConstants.POST_OFFICE);
		String permanentVillageOrRoad = ParamUtil.getString(actionRequest,
				AddressConstants.ADDRESS_PERMANENT + ParameterConstants.VILLAGE_OR_ROAD);
		String permanentMouzaOrMoholla = ParamUtil.getString(actionRequest,
				AddressConstants.ADDRESS_PERMANENT + ParameterConstants.MOUZA_OR_MOHOLLA);
		String permanentHouseAddress = ParamUtil.getString(actionRequest,
				AddressConstants.ADDRESS_PERMANENT + ParameterConstants.HOUSE_ADDRESS);

		// Get teh Farmer's Present Address
		long presentRegion = ParamUtil.getLong(actionRequest,
				AddressConstants.ADDRESS_PRESENT + ParameterConstants.REGION);
		long presentZilla = ParamUtil.getLong(actionRequest,
				AddressConstants.ADDRESS_PRESENT + ParameterConstants.ZILLA);
		long presentUpazila = ParamUtil.getLong(actionRequest,
				AddressConstants.ADDRESS_PRESENT + ParameterConstants.UPAZILA);
		long presentCityCorporationOrMunicipality = ParamUtil.getLong(actionRequest,
				AddressConstants.ADDRESS_PRESENT + ParameterConstants.CITY_CORPORATION_OR_MUNICIPALITY);
		long presentUnionOrWard = ParamUtil.getLong(actionRequest,
				AddressConstants.ADDRESS_PRESENT + ParameterConstants.UNION_OR_WARD);
		long presentZipCode = ParamUtil.getLong(actionRequest,
				AddressConstants.ADDRESS_PRESENT + ParameterConstants.ZIP_CODE);
		String presentPostOffice = ParamUtil.getString(actionRequest,
				AddressConstants.ADDRESS_PRESENT + ParameterConstants.POST_OFFICE);
		String presentVillageOrRoad = ParamUtil.getString(actionRequest,
				AddressConstants.ADDRESS_PRESENT + ParameterConstants.VILLAGE_OR_ROAD);
		String presentMouzaOrMoholla = ParamUtil.getString(actionRequest,
				AddressConstants.ADDRESS_PRESENT + ParameterConstants.MOUZA_OR_MOHOLLA);
		String presentHouseAddress = ParamUtil.getString(actionRequest,
				AddressConstants.ADDRESS_PRESENT + ParameterConstants.HOUSE_ADDRESS);

		// Get the Farmer Files
		BinaryFile profilePhotograph = DLUploadUtil.getBinaryFile(FileConstants.FILE_PROFILE_PHOTOGRAPH, actionRequest);
		BinaryFile krishiCard = DLUploadUtil.getBinaryFile(FileConstants.FILE_KRISHI_CARD, actionRequest);

		// Password details for User creation
		String password = ParamUtil.getString(actionRequest, ParameterConstants.PASSWORD);
		String confirmPassword = ParamUtil.getString(actionRequest, ParameterConstants.CONFIRM_PASSWORD);

		if (!password.equals(confirmPassword)) {
			throw new Exception("Password and Confirm password must be match");
		}

		try {
			FarmerRegistration frmerRegistration = farmerRegistrationLocalService.addFarmerRegistrationFormData(false,
					nationalId, emailAddress, mobileNumber, dateOfBirth, farmerName, fatherName, motherName, gender,
					krishiCardNumber, maritalStatus, cultivableLandSeason1Name, cultivableLandSeason1Area,
					cultivableLandSeason1Unit, cultivableLandSeason2Name, cultivableLandSeason2Area,
					cultivableLandSeason2Unit, cultivableLandSeason3Name, cultivableLandSeason3Area,
					cultivableLandSeason3Unit, farmerCategory, password, remarks, permanentRegion, permanentZilla,
					permanentUpazila, permanentCityCorporationOrMunicipality, permanentUnionOrWard, permanentZipCode,
					permanentPostOffice, permanentVillageOrRoad, permanentMouzaOrMoholla, permanentHouseAddress,
					presentRegion, presentZilla, presentUpazila, presentCityCorporationOrMunicipality,
					presentUnionOrWard, presentZipCode, presentPostOffice, presentVillageOrRoad, presentMouzaOrMoholla,
					presentHouseAddress, profilePhotograph, krishiCard, themeDisplay.getScopeGroupId(), serviceContext);

			logger.debug(frmerRegistration);
			
			actionResponse.setRenderParameter(ParameterConstants.APPLICATION_NUMBER,
					frmerRegistration.getApplicationNumber());
			actionResponse.setRenderParameter("mvcPath",
					FarmerInformationManagementSystemConstants.FARMER_REGISTRATION_SUCCESS_JSP);

		} catch (DataValidationException dataValidationException) {

			logger.error(
					"Validation failed for submited Farmer Registration Data: " + dataValidationException.getMessage());
			if (logger.isDebugEnabled()) {
				dataValidationException.printStackTrace();
			}

			actionRequest.setAttribute("errorKey", dataValidationException.getMessage());
			SessionErrors.add(actionRequest, dataValidationException.getClass());
			actionResponse.setRenderParameter("mvcRenderCommand",
					FarmerInformationManagementSystemConstants.FARMER_REGISTRATION_FORM_RENDER_COMMAND);

		} catch (FarmerRegistrationInternalErrorException farmerRegistrationInternalErrorException) {
			logger.error("Internal error occured while stroing Farmerregistration data : "
					+ farmerRegistrationInternalErrorException.getMessage());
			if (logger.isDebugEnabled()) {
				farmerRegistrationInternalErrorException.printStackTrace();
			}

			actionRequest.setAttribute("errorKey", farmerRegistrationInternalErrorException.getMessage());
			SessionErrors.add(actionRequest, farmerRegistrationInternalErrorException.getClass());

			/* TODO: redirect to error Page */
			actionResponse.setRenderParameter("mvcRenderCommand",
					FarmerInformationManagementSystemConstants.FARMER_REGISTRATION_FORM_RENDER_COMMAND);
		} catch (Exception exception) {
			logger.error("Exception occured while added the Farmer Registration : " + exception.getMessage());
			if (logger.isDebugEnabled()) {
				exception.printStackTrace();
			}

			actionRequest.setAttribute("errorKey", exception.getMessage());
			SessionErrors.add(actionRequest, exception.getClass());

			/* TODO: redirect to error Page */
			actionResponse.setRenderParameter("mvcRenderCommand",
					FarmerInformationManagementSystemConstants.FARMER_REGISTRATION_FORM_RENDER_COMMAND);
		}

	}
	
	private Log logger = LogFactoryUtil.getLog(this.getClass());

	@Reference
	private FarmerRegistrationLocalService farmerRegistrationLocalService;

}
