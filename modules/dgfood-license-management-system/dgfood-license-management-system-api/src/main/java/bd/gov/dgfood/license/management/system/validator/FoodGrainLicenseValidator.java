package bd.gov.dgfood.license.management.system.validator;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import bd.gov.dgfood.common.util.ConfigurationUtil;
import bd.gov.dgfood.common.util.constants.GenderConstants;
import bd.gov.dgfood.common.util.constants.MaritalStatusConstants;
import bd.gov.dgfood.common.util.constants.ParameterConstants;
import bd.gov.dgfood.common.util.constants.ValidationConstants;
import bd.gov.dgfood.common.util.validator.DataValidationException;
import bd.gov.dgfood.common.util.validator.FormValidator;
import bd.gov.dgfood.configuration.BypassValidationConfiguration;
import bd.gov.dgfood.license.management.system.service.FGLicenseInfoLocalServiceUtil;

public class FoodGrainLicenseValidator {

	/**
	 * 
	 * Validates FG License Form data.
	 */
	public static boolean validateFoodGrainLicenseData(String nationalId, String mobileNumber, Date dateOfBirth,
			String emailAddress, String password, String applicantName, int gender, int maritalStatus,
			String fatherName, String motherName, String tradeLicenseNo, Date tradeLicenseExpiryDate,
			String tradeLicenseIssuerCode, String tradeLicenseIssuerCity, String taxIdentificationNumber,
			String businessIdentificationNumber, long permanentRegion, long permanentDistrict, long permanentUpazilla,
			long permanentCityCorporationOrMunicipality, long permanentUnionOrWard, long permanentZipCode,
			String permanentPostOffice, String permanentVillageOrRoad, String permanentMouzaOrMoholla,
			String permanentHouseAddress, long presentRegion, long presentDistrict, long presentUpazilla,
			long presentCityCorporationOrMunicipality, long presentUnionOrWard, long presentZipCode,
			String presentPostOffice, String presentVillageOrRoad, String presentMouzaOrMoholla,
			String presentHouseAddress, String businessName, String businessType, long businessRegion,
			long businessDistrict, long businessUpazilla, long businessCityCorporationOrMunicipality,
			long businessUnionOrWard, long businessZipCode, String businessPostOffice, String businessVillageOrRoad,
			String businessMouzaOrMoholla, String businessHouseAddress) throws DataValidationException {

		BypassValidationConfiguration bypassValidationConfiguration = ConfigurationUtil
				.getBypassValidationConfiguration();
		if (Validator.isNotNull(bypassValidationConfiguration)
				&& bypassValidationConfiguration.isFoodGrainLicenseValidationDisabled()) {
			logger.debug("Food Grain License Validation disabled. Please enable it in System Configurations");
			return true;
		}

		Date before18YearsDate = Date
				.from(LocalDate.now().minusYears(18).atStartOfDay(ZoneId.systemDefault()).toInstant());

		FormValidator.validateNationalId(nationalId, true, ParameterConstants.NATIONAL_ID);
		FormValidator.validateInput(emailAddress, ParameterConstants.EMAIL_ADDRESS, false, 0, 30,
				ValidationConstants.REGEX_EMAIL_ADDRESS);
		FormValidator.validateInput(mobileNumber, ParameterConstants.MOBILE_NUMBER, true, 11, 15,
				ValidationConstants.REGEX_BANGLADESH_MOBILE_NUMBER);
		FormValidator.validateInput(dateOfBirth, ParameterConstants.DATE_OF_BIRTH, true, null, before18YearsDate);

		FormValidator.validateInput(applicantName, ParameterConstants.APPLICANT_NAME, true, 0, 30,
				ValidationConstants.REGEX_ONLY_CHAR_WITH_SPACE);
		FormValidator.validateInput(fatherName, ParameterConstants.FATHER_NAME, true, 0, 30,
				ValidationConstants.REGEX_ONLY_CHAR_WITH_SPACE);
		FormValidator.validateInput(motherName, ParameterConstants.MOTHER_NAME, true, 0, 30,
				ValidationConstants.REGEX_ONLY_CHAR_WITH_SPACE);
		FormValidator.validateInput(gender, ParameterConstants.GENDER, true, GenderConstants.getGenderValues());
		FormValidator.validateInput(maritalStatus, ParameterConstants.MARITAL_STATUS, true,
				MaritalStatusConstants.getMaritalStatusValues());
		FormValidator.validateInput(password, ParameterConstants.PASSWORD, true, 8, 32, null);

		FormValidator.validateInput(tradeLicenseNo, ParameterConstants.TRADE_LICENSE_NUMBER, true, 5, 20, null);
		FormValidator.validateInput(tradeLicenseExpiryDate, ParameterConstants.TRADE_LICENSE_EXPIRY_DATE, true, new Date(),
				null);
		FormValidator.validateInput(taxIdentificationNumber, ParameterConstants.TAX_IDENTIFICATION_NUMBER, true, 5, 20,
				null);
		FormValidator.validateInput(businessIdentificationNumber, ParameterConstants.BUSINESS_IDENTIFICATION_NUMBER,
				false, 5, 20, null);
		FormValidator.validateInput(tradeLicenseIssuerCode, ParameterConstants.TRADE_LICENSE_ISSUER_CODE, true, 5, 20,
				null);
		FormValidator.validateInput(tradeLicenseIssuerCity, ParameterConstants.TRADE_LICENSE_ISSUER_CITY, true, 3, 30,
				ValidationConstants.REGEX_ONLY_CHAR_WITH_SPACE);

		FormValidator.validateInput(businessName, ParameterConstants.BUSINESS_NAME, true, 3, 30,
				ValidationConstants.REGEX_ONLY_CHAR_WITH_SPACE);
		FormValidator.validateInput(businessType, ParameterConstants.BUSINESS_TYPE, true, 3, 30,
				ValidationConstants.REGEX_ONLY_CHAR_WITH_SPACE);

		FormValidator.validateAddress(permanentRegion, permanentDistrict, permanentUpazilla,
				permanentCityCorporationOrMunicipality, permanentUnionOrWard, permanentPostOffice, permanentZipCode,
				permanentVillageOrRoad, permanentMouzaOrMoholla, permanentHouseAddress);

		FormValidator.validateAddress(presentRegion, presentDistrict, presentUpazilla,
				presentCityCorporationOrMunicipality, presentUnionOrWard, presentPostOffice, presentZipCode,
				presentVillageOrRoad, presentMouzaOrMoholla, presentHouseAddress);

		FormValidator.validateAddress(businessRegion, businessDistrict, businessUpazilla,
				businessCityCorporationOrMunicipality, businessUnionOrWard, businessPostOffice, businessZipCode,
				businessVillageOrRoad, businessMouzaOrMoholla, businessHouseAddress);

		return true;
	}

	/**
	 * Validates whether the current user is already have License or applying as a
	 * new Guest user.
	 * 
	 * In case of Guest user return true only if there are no active FG License are
	 * available in the system.
	 * 
	 * In case of Logged-in user returns true only if the user is a Licensee and
	 * user don't have any License in pending state
	 * 
	 */
	public static boolean validateUserForNewFGL(String nationalId, ServiceContext serviceContext)
			throws DataValidationException {
		try {
			// TODO: Update the Role Id 0 with FGL Role Id
			if (Validator.isNotNull(serviceContext.getUserId())
					&& UserLocalServiceUtil.hasRoleUser(0, serviceContext.getUserId())) {

				long userActiveFGLicenseCount = FGLicenseInfoLocalServiceUtil
						.getPendingFGLicenseCountByNationalId(nationalId);
				if (userActiveFGLicenseCount > 0) {
					throw new DataValidationException("Curent user have one or more licenses in pending state");
				}

				return true;

			} else if (Validator.isNull(serviceContext.getUserId())
					|| !(PermissionCheckerFactoryUtil.getPermissionCheckerFactory()
							.create(UserLocalServiceUtil.getUser(serviceContext.getUserId())).isSignedIn())) {

				long userActiveFGLicenseCount = FGLicenseInfoLocalServiceUtil
						.getActiveFGLicenseCountByNationalId(nationalId);
				if (userActiveFGLicenseCount > 0) {
					throw new DataValidationException(
							"One or more active licenses are available with the National Id - " + nationalId);
				}
				return true;

			}
			throw new DataValidationException("Current user is not authorized to apply a new Foodgrain Licensee");
		} catch (PortalException portalException) {
			logger.error(
					"Exception occured while validating current user old FGL details: " + portalException.getMessage());
			if (logger.isDebugEnabled()) {
				portalException.printStackTrace();
			}
		}

		return false;
	}

	private static Log logger = LogFactoryUtil.getLog(FoodGrainLicenseValidator.class);
}