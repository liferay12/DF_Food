package bd.gov.dgfood.foodgrain.license.actions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.multipart.BinaryFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Base64;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MimeResponse.Copy;
import javax.portlet.PortletSession;
import javax.portlet.RenderURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.common.util.DLUploadUtil;
import bd.gov.dgfood.common.util.DateFormatterUtil;
import bd.gov.dgfood.common.util.constants.AddressConstants;
import bd.gov.dgfood.common.util.constants.DocumentLibraryConstants;
import bd.gov.dgfood.common.util.constants.ParameterConstants;
import bd.gov.dgfood.common.util.validator.DataValidationException;
import bd.gov.dgfood.foodgrain.license.constants.FoodGrainLicensePortletKeys;
import bd.gov.dgfood.foodgrain.license.dto.NationalID;
import bd.gov.dgfood.license.management.system.exception.InvalidFGLicenseInformationException;
import bd.gov.dgfood.license.management.system.model.FGLicenseInfo;
import bd.gov.dgfood.license.management.system.service.FGLicenseInfoLocalService;

/**
 * 
 * @author Abhijit Ande
 *
 *This Class is used to Submit the New Application Form Details filled by user.
 */

@Component(immediate = true,
property = {
		"javax.portlet.name=" + FoodGrainLicensePortletKeys.HOMESCREENFGLICENSE,
		"mvc.command.name=" + FoodGrainLicensePortletKeys.SUBMIT_NEW_FG_LICENSE_MVC_ACTION_COMMAND
},
service = MVCActionCommand.class
		)
public class SubmitNewFGLicenseMVCActionCommand extends BaseMVCActionCommand{


	/**
	 * This method is used to fetch the User Filled Details in Application Form JSP 
	 * from actionRequest and push it to DB using LocalService form data method.
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @return void
	 */
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
		long profilePhotographDocId = 0; 
		long tradeLicenseDocId = 0;
		long businessIdentificationNumberDocId = 0; 
		long taxIdentificationNumberDocId = 0;
		long bankStatementDocId = 0;

		//Food Grain License NID Information
		String nationalId = ParamUtil.getString(actionRequest, ParameterConstants.NATIONAL_ID);
		String emailAddress = ParamUtil.getString(actionRequest, ParameterConstants.EMAIL_ADDRESS);
		String mobileNumber = ParamUtil.getString(actionRequest, ParameterConstants.MOBILE_NUMBER);
		String dateOfBirth = ParamUtil.getString(actionRequest, ParameterConstants.DATE_OF_BIRTH);
		Date formattedDateOfBirth = DateFormatterUtil.parseDate(dateOfBirth);

		String sessionKey = ParameterConstants.FGL_SESSION_KEY + nationalId;
		NationalID nationalIdObj = getNationalIDDetailsFromSession(sessionKey, actionRequest, actionResponse);

		//Food Grain License Basic Information
		String applicantName = nationalIdObj.getApplicantName();
		String fatherName = nationalIdObj.getFatherName();
		String motherName = nationalIdObj.getMotherName();
		int gender = Integer.parseInt(nationalIdObj.getGender());

		//Permanent Address Information
		long permanentRegion = Long.parseLong(nationalIdObj.getAddress().getRegion().getKey());
		long permanentDistrict = Long.parseLong(nationalIdObj.getAddress().getDistrict() .getKey());
		long permanentUpazila = Long.parseLong(nationalIdObj.getAddress().getUpazila().getKey());
		long permanentCityMetropolis = Long.parseLong(nationalIdObj.getAddress().getCityMetropolis().getKey());
		long permanentCityCorporationOrMunicipality = Long.parseLong(nationalIdObj.getAddress().getCityCorporationOrMuncipalty().getKey());
		long permanentUnion = Long.parseLong(nationalIdObj.getAddress().getUnion().getKey());
		String permanentWard = nationalIdObj.getAddress().getWard();
		String permanentVillage = nationalIdObj.getAddress().getVillage();
		long permanentZipCode = nationalIdObj.getAddress().getZipCode();
		String permanentPostOffice = nationalIdObj.getAddress().getPostOffice();
		String permanentMouzaOrMoholla = nationalIdObj.getAddress().getMouzaOrMoholla();
		String permanentHouseAddress = nationalIdObj.getAddress().getHomeAddress();

		int maritalStatus = ParamUtil.getInteger(actionRequest, ParameterConstants.MARITAL_STATUS);

		//Present Address Information
		long presentRegion = ParamUtil.getLong(actionRequest,
				AddressConstants.ADDRESS_PRESENT + ParameterConstants.REGION);
		long presentDistrict = ParamUtil.getLong(actionRequest,
				AddressConstants.ADDRESS_PRESENT + ParameterConstants.ZILLA);
		long presentUpazila = ParamUtil.getLong(actionRequest,
				AddressConstants.ADDRESS_PRESENT + ParameterConstants.UPAZILA);
		long presentCityMetropolis = ParamUtil.getLong(actionRequest,
				AddressConstants.ADDRESS_PRESENT + ParameterConstants.CITY_METROPOLIS);
		long presentCityCorporationOrMunicipality = ParamUtil.getLong(actionRequest,
				AddressConstants.ADDRESS_PRESENT + ParameterConstants.CITY_CORPORATION_OR_MUNICIPALITY);
		long presentUnion = ParamUtil.getLong(actionRequest,
				AddressConstants.ADDRESS_PRESENT + ParameterConstants.UNION);
		String presentWard = ParamUtil.getString(actionRequest,
				AddressConstants.ADDRESS_PRESENT + ParameterConstants.WARD);
		String presentVillage = ParamUtil.getString(actionRequest,
				AddressConstants.ADDRESS_PRESENT + ParameterConstants.VILLAGE);
		long presentZipCode = ParamUtil.getLong(actionRequest,
				AddressConstants.ADDRESS_PRESENT + ParameterConstants.ZIP_CODE);
		String presentPostOffice = ParamUtil.getString(actionRequest,
				AddressConstants.ADDRESS_PRESENT + ParameterConstants.POST_OFFICE);
		String presentMouzaOrMoholla = ParamUtil.getString(actionRequest,
				AddressConstants.ADDRESS_PRESENT + ParameterConstants.MOUZA_OR_MOHOLLA);
		String presentHouseAddress = ParamUtil.getString(actionRequest,
				AddressConstants.ADDRESS_PRESENT + ParameterConstants.HOUSE_ADDRESS);

		//Trade License Information
		String tradeLicenseNo = ParamUtil.getString(actionRequest, ParameterConstants.TRADE_LICENSE_NUMBER);
		String tradeLicenseExpiryDate= ParamUtil.getString(actionRequest, ParameterConstants.TRADE_LICENSE_EXPIRY_DATE);
		Date formattedTradeLicenseExpiryDate = DateFormatterUtil.parseDate(tradeLicenseExpiryDate);
		String taxIdentificationNumber = ParamUtil.getString(actionRequest, ParameterConstants.TAX_IDENTIFICATION_NUMBER);
		String businessIdentificationNumber = ParamUtil.getString(actionRequest, ParameterConstants.BUSINESS_IDENTIFICATION_NUMBER);
		String tradeLicenseIssuerCode = ParamUtil.getString(actionRequest, ParameterConstants.TRADE_LICENSE_ISSUER_CODE);
		String tradeLicenseIssuerCity = ParamUtil.getString(actionRequest, ParameterConstants.TRADE_LICENSE_ISSUER_CITY);

		//Food Grain License Business Information
		String businessName = ParamUtil.getString(actionRequest, ParameterConstants.BUSINESS_NAME);
		String businessType = ParamUtil.getString(actionRequest, ParameterConstants.BUSINESS_TYPE);

		//Business Address Information
		long businessRegion = ParamUtil.getLong(actionRequest,
				AddressConstants.ADDRESS_BUSINESS + ParameterConstants.REGION);
		long businessDistrict = ParamUtil.getLong(actionRequest,
				AddressConstants.ADDRESS_BUSINESS + ParameterConstants.ZILLA);
		long businessUpazila = ParamUtil.getLong(actionRequest,
				AddressConstants.ADDRESS_BUSINESS + ParameterConstants.UPAZILA);
		long businessCityMetropolis = ParamUtil.getLong(actionRequest,
				AddressConstants.ADDRESS_BUSINESS + ParameterConstants.CITY_METROPOLIS);
		long businessCityCorporationOrMunicipality = ParamUtil.getLong(actionRequest,
				AddressConstants.ADDRESS_BUSINESS + ParameterConstants.CITY_CORPORATION_OR_MUNICIPALITY);
		long businessUnion = ParamUtil.getLong(actionRequest,
				AddressConstants.ADDRESS_BUSINESS + ParameterConstants.UNION);
		String businessWard = ParamUtil.getString(actionRequest,
				AddressConstants.ADDRESS_BUSINESS + ParameterConstants.WARD);
		String businessVillage = ParamUtil.getString(actionRequest,
				AddressConstants.ADDRESS_BUSINESS + ParameterConstants.VILLAGE);
		long businessZipCode = ParamUtil.getLong(actionRequest,
				AddressConstants.ADDRESS_BUSINESS + ParameterConstants.ZIP_CODE);
		String businessPostOffice = ParamUtil.getString(actionRequest,
				AddressConstants.ADDRESS_BUSINESS + ParameterConstants.POST_OFFICE);
		String businessMouzaOrMoholla = ParamUtil.getString(actionRequest,
				AddressConstants.ADDRESS_BUSINESS + ParameterConstants.MOUZA_OR_MOHOLLA);
		String businessHouseAddress = ParamUtil.getString(actionRequest,
				AddressConstants.ADDRESS_BUSINESS + ParameterConstants.HOUSE_ADDRESS);

		try {

			long userFolderId = DLUploadUtil.getFoodGrainLicenseUserFolder(tradeLicenseNo, serviceContext);

			//Food Grain License Attachments
			String profilePhotograph = ParamUtil.getString(actionRequest, ParameterConstants.PROFILE_PHOTOGRAPH);

			BinaryFile profilePhotographDocument = DLUploadUtil.getNIDProfileBinaryFile(profilePhotograph);
			profilePhotographDocId = DLUploadUtil.addAttachment(userFolderId, profilePhotographDocument, null,
					null, DocumentLibraryConstants.PHOTOGRAPH, serviceContext).getAttachmentId();
			
			BinaryFile tradeLicenseNumberPhotocopy = DLUploadUtil.getBinaryFile(ParameterConstants.TRADE_LICENSE_DOCUMENT, actionRequest);
			tradeLicenseDocId = DLUploadUtil.addAttachment(userFolderId, tradeLicenseNumberPhotocopy, null,
					null, DocumentLibraryConstants.TRADE_LICENSE_DOC, serviceContext).getAttachmentId();

			BinaryFile businessIdentificationNumberPhotocopy = DLUploadUtil.getBinaryFile(ParameterConstants.BUSINESS_IDENTIFICATION_NUMBER_DOCUMENT, actionRequest);
			businessIdentificationNumberDocId = DLUploadUtil.addAttachment(userFolderId, businessIdentificationNumberPhotocopy, null,
					null, DocumentLibraryConstants.BUSINESS_IDENTIFICATION_DOC, serviceContext).getAttachmentId();

			BinaryFile taxIdentificationNumberPhotocopy = DLUploadUtil.getBinaryFile(ParameterConstants.TAX_IDENTIFICATION_NUMBER_DOCUMENT, actionRequest);
			taxIdentificationNumberDocId = DLUploadUtil.addAttachment(userFolderId, taxIdentificationNumberPhotocopy, null,
					null, DocumentLibraryConstants.TAX_IDENTIFICATION_DOC, serviceContext).getAttachmentId();

			BinaryFile bankStatementDocument = DLUploadUtil.getBinaryFile(ParameterConstants.BANK_STATEMENT_DOCUMENT, actionRequest);
			bankStatementDocId = DLUploadUtil.addAttachment(userFolderId, bankStatementDocument, null,
					null, DocumentLibraryConstants.BANK_STATEMENT_DOC, serviceContext).getAttachmentId();

		}catch(Exception e) {
			e.printStackTrace();
		}

		//Password Information
		String password = ParamUtil.getString(actionRequest, ParameterConstants.PASSWORD);
		String confirmPassword = ParamUtil.getString(actionRequest, ParameterConstants.CONFIRM_PASSWORD);

		if (!password.equals(confirmPassword)) {
			throw new Exception("Password and Confirm password must be match");
		}

		try{

			//Basic Information Storing
			FGLicenseInfo fgLicenseInfo	= fgLicenseInfoLocalService.addFGLicenseFormData( 
					nationalId, mobileNumber, formattedDateOfBirth, emailAddress, password, 
					applicantName, gender, maritalStatus, fatherName, motherName, 
					tradeLicenseNo, formattedTradeLicenseExpiryDate, tradeLicenseIssuerCode, 
					tradeLicenseIssuerCity, taxIdentificationNumber, businessIdentificationNumber, 
					permanentRegion, permanentDistrict, permanentUpazila, permanentCityCorporationOrMunicipality, 
					permanentUnion, permanentZipCode, permanentPostOffice, permanentVillage, 
					permanentMouzaOrMoholla, permanentHouseAddress, 
					presentRegion, presentDistrict, presentUpazila, presentCityCorporationOrMunicipality, 
					presentUnion, presentZipCode, presentPostOffice, presentVillage, 
					presentMouzaOrMoholla, presentHouseAddress, 
					businessName, businessType, businessRegion, businessDistrict, businessUpazila, 
					businessCityCorporationOrMunicipality, businessUnion, businessZipCode, businessPostOffice, 
					businessVillage, businessMouzaOrMoholla, businessHouseAddress, 
					profilePhotographDocId, tradeLicenseDocId, businessIdentificationNumberDocId, 
					taxIdentificationNumberDocId, bankStatementDocId, serviceContext);

			RenderURL successPageURL=actionResponse.createRedirectURL(Copy.NONE);
			successPageURL.setParameter(ParameterConstants.MVC_PATH, "/jsp/fglicense_application/fgLicense_application_success.jsp");
			successPageURL.setParameter(ParameterConstants.APPLICATION_NUMBER, fgLicenseInfo.getApplicationNumber());
			actionResponse.sendRedirect(successPageURL.toString());

			hideDefaultSuccessMessage(actionRequest);


		}catch (DataValidationException dataValidationException) {
			logger.error("Validation failed for submitted Food Grain License Data: " 
					+ dataValidationException.getMessage());
			if (logger.isDebugEnabled()) {
				dataValidationException.printStackTrace();
			}
			actionRequest.setAttribute("errorKey", dataValidationException.getMessage());
			SessionErrors.add(actionRequest, dataValidationException.getClass());
			actionResponse.setRenderParameter("mvcRenderCommand",
					FoodGrainLicensePortletKeys.NEW_FG_LICENSE_MVC_RENDER_COMMAND);

		}catch (InvalidFGLicenseInformationException invalidFGLicenseInformationException) {
			logger.error("Internal error occured while stroring Food Grain License "
					+ "Application data : "+ invalidFGLicenseInformationException.getMessage());
			if (logger.isDebugEnabled()) {
				invalidFGLicenseInformationException.printStackTrace();
			}
			String mvcPath = "/jsp/fglicense_application/fgLicense_application_error.jsp";
			actionRequest.setAttribute("errorKey", invalidFGLicenseInformationException.getMessage());
			SessionErrors.add(actionRequest, invalidFGLicenseInformationException.getClass());
			actionResponse.setRenderParameter(ParameterConstants.MVC_PATH, mvcPath);
		}catch (Exception exception) {
			logger.error("Exception occured while added the Food Grain License : " + exception.getMessage());
			if (logger.isDebugEnabled()) {
				exception.printStackTrace();
			}
			String mvcPath = "/jsp/fglicense_application/fgLicense_application_error.jsp";
			actionRequest.setAttribute("errorKey", exception.getMessage());
			SessionErrors.add(actionRequest, exception.getClass());
			actionResponse.setRenderParameter(ParameterConstants.MVC_PATH, mvcPath);
		}
	}

	/**
	 * This method is used to fetch the Session from PortletSession Object set from the NationalIDDetailsResource.
	 * 
	 * @param sessionKey
	 * @param actionRequest
	 * @param actionResponse
	 * @return NationalID
	 */

	private NationalID getNationalIDDetailsFromSession(String sessionKey, ActionRequest actionRequest, ActionResponse actionResponse) throws DataValidationException {

		//ObjectMapper instantiation
		ObjectMapper objectMapper = new ObjectMapper();
		NationalID nationalIdObj = null;

		try {

			String nationalIdDetails = (String) actionRequest.getPortletSession(true).getAttribute(sessionKey, PortletSession.PORTLET_SCOPE);

			if(Validator.isNull(nationalIdDetails)) {
				throw new DataValidationException("No Details Available. National ID Number is altered");
			}

			nationalIdObj = objectMapper.readValue(nationalIdDetails, NationalID.class);

		}catch (DataValidationException dataValidationException) {
			logger.error("Validation failed for submitted Food Grain License Data: " 
					+ dataValidationException.getMessage());
			if (logger.isDebugEnabled()) {
				dataValidationException.printStackTrace();
			}
			actionRequest.setAttribute("errorKey", dataValidationException.getMessage());
			SessionErrors.add(actionRequest, dataValidationException.getClass());
			actionResponse.setRenderParameter("mvcRenderCommand",
					FoodGrainLicensePortletKeys.NEW_FG_LICENSE_MVC_RENDER_COMMAND);

		}catch(JsonProcessingException jsonException) {
			logger.error("Exception occured while mapping json to object: " + jsonException.getMessage());
			if (logger.isDebugEnabled()) {
				jsonException.printStackTrace();
			}
		}

		return nationalIdObj;
	}

	private Log logger = LogFactoryUtil.getLog(this.getClass());

	@Reference 
	protected FGLicenseInfoLocalService fgLicenseInfoLocalService;
}