package bd.gov.dgfood.farmer.information.management.system.validator;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.multipart.BinaryFile;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import bd.gov.dgfood.common.util.ConfigurationUtil;
import bd.gov.dgfood.common.util.constants.FileConstants;
import bd.gov.dgfood.common.util.constants.GenderConstants;
import bd.gov.dgfood.common.util.constants.MaritalStatusConstants;
import bd.gov.dgfood.common.util.constants.ParameterConstants;
import bd.gov.dgfood.common.util.constants.ParameterLabelConstants;
import bd.gov.dgfood.common.util.constants.SeasonConstants;
import bd.gov.dgfood.common.util.constants.ValidationConstants;
import bd.gov.dgfood.common.util.validator.DataValidationException;
import bd.gov.dgfood.common.util.validator.FormValidator;
import bd.gov.dgfood.configuration.BypassValidationConfiguration;

public class FarmerInformationValidator {

	public static boolean validateFarmerRegistrationData(boolean isHeadlessRequest, String nationalId,
			String emailAddress, String mobileNumber, Date dateOfBirth, String farmerName, String fatherName,
			String motherName, int gender, String krishiCardNumber, int maritalStatus, String cultivableLandSeason1Name,
			float cultivableLandSeason1Area, String cultivableLandSeason1Unit, String cultivableLandSeason2Name,
			float cultivableLandSeason2Area, String cultivableLandSeason2Unit, String cultivableLandSeason3Name,
			float cultivableLandSeason3Area, String cultivableLandSeason3Unit, String farmerCategory, String password,
			String remarks, long permanentRegion, long permanentZilla, long permanentUpazila,
			long permanentCityCorporationOrMunicipality, long permanentUnionOrWard, long permanentZipCode,
			String permanentPostOffice, String permanentVillageOrRoad, String permanentMouzaOrMoholla,
			String permanentHouseAddress, long presentRegion, long presentZilla, long presentUpazila,
			long presentCityCorporationOrMunicipality, long presentUnionOrWard, long presentZipCode,
			String presentPostOffice, String presentVillageOrRoad, String presentMouzaOrMoholla,
			String presentHouseAddress, BinaryFile profilePhotograph, BinaryFile krishiCard)
			throws DataValidationException {

		log.debug("Farmer Registration Data Validation");

		BypassValidationConfiguration bypassValidationConfiguration = ConfigurationUtil
				.getBypassValidationConfiguration();
		if (Validator.isNotNull(bypassValidationConfiguration)
				&& bypassValidationConfiguration.isFarmerRegistrationValidationDisabled()) {
			log.debug("Farmer Registration Validation disabled. Please enable it in System Configurations");
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
		FormValidator.validateInput(farmerName, ParameterConstants.FARMER_NAME, true, 0, 30,
				ValidationConstants.REGEX_ONLY_CHAR_WITH_SPACE);
		FormValidator.validateInput(fatherName, ParameterConstants.FATHER_NAME, true, 0, 30,
				ValidationConstants.REGEX_ONLY_CHAR_WITH_SPACE);
		FormValidator.validateInput(motherName, ParameterConstants.MOTHER_NAME, true, 0, 30,
				ValidationConstants.REGEX_ONLY_CHAR_WITH_SPACE);
		FormValidator.validateInput(gender, ParameterConstants.GENDER, true, GenderConstants.getGenderValues());
		FormValidator.validateInput(maritalStatus, ParameterConstants.MARITAL_STATUS, true,
				MaritalStatusConstants.getMaritalStatusValues());
		FormValidator.validateInput(krishiCardNumber, ParameterConstants.KRISHOK_CARD_NUMBER, false, 0, 20, null);

		FormValidator.validateInput(cultivableLandSeason1Name, ParameterConstants.CULTIVABLE_LAND_SEASON_1_NAME, false,
				0, 20, null);
		FormValidator.validateInput(cultivableLandSeason1Area, ParameterConstants.CULTIVABLE_LAND_SEASON_1_AREA, false,
				-1, -1);
		if (Validator.isNotNull(cultivableLandSeason1Area)) {
			FormValidator.validateInput(cultivableLandSeason1Unit, ParameterConstants.CULTIVABLE_LAND_SEASON_1_UNIT, true,
					0, 10, null);
		}

		FormValidator.validateInput(cultivableLandSeason1Name, ParameterConstants.CULTIVABLE_LAND_SEASON_2_NAME, false,
				0, 20, null);
		FormValidator.validateInput(cultivableLandSeason1Area, ParameterConstants.CULTIVABLE_LAND_SEASON_2_AREA, false,
				-1, -1);
		if (Validator.isNotNull(cultivableLandSeason1Area)) {
			FormValidator.validateInput(cultivableLandSeason1Unit, ParameterConstants.CULTIVABLE_LAND_SEASON_2_UNIT, true,
					0, 10, null);
		}

		FormValidator.validateInput(cultivableLandSeason1Name, ParameterConstants.CULTIVABLE_LAND_SEASON_3_NAME, false,
				0, 20, null);
		FormValidator.validateInput(cultivableLandSeason1Area, ParameterConstants.CULTIVABLE_LAND_SEASON_3_AREA, false,
				-1, -1);
		if (Validator.isNotNull(cultivableLandSeason1Area)) {
			FormValidator.validateInput(cultivableLandSeason1Unit, ParameterConstants.CULTIVABLE_LAND_SEASON_3_UNIT, true,
					0, 10, null);
		}

		FormValidator.validateInput(farmerCategory, ParameterConstants.FARMER_CATEGORY, false, 0, 0, null);
		FormValidator.validateInput(password, ParameterConstants.PASSWORD, true, 8, 32, null);

		FormValidator.validateAddress(permanentRegion, permanentZilla, permanentUpazila,
				permanentCityCorporationOrMunicipality, permanentUnionOrWard, permanentPostOffice, permanentZipCode,
				permanentVillageOrRoad, permanentMouzaOrMoholla, permanentHouseAddress);
		FormValidator.validateAddress(presentRegion, presentZilla, presentUpazila, presentCityCorporationOrMunicipality,
				presentUnionOrWard, presentPostOffice, presentZipCode, presentVillageOrRoad, presentMouzaOrMoholla,
				presentHouseAddress);

		if (!isHeadlessRequest) {
			validateFarmerRegistrationAttachments(profilePhotograph, krishiCard);
		}

		return true;

	}

	public static boolean validateFarmerRegistrationAttachments(BinaryFile profilePhotograph, BinaryFile krishiCard)
			throws DataValidationException {
		FormValidator.validateAttachment(profilePhotograph, FileConstants.JPG_JPEG_PNG, true, 0, FileConstants.TWO_MB,
				FileConstants.FILE_PROFILE_PHOTOGRAPH);
		FormValidator.validateAttachment(krishiCard, FileConstants.PDF_DOC_DOCX, false, 0, FileConstants.SIX_MB,
				FileConstants.FILE_KRISHI_CARD);

		return true;
	}

	public static boolean validateFarmerSalesProposalFormData(boolean isHeadlessRequest, String currentSeason,
			String foodgrainType, String krishiCardNumber, String pastProdDataSeason1Name,
			String pastProdDataSeason1Year, double pastProdDataSeason1Qty, String pastProdDataSeason1QtyUnit,
			String pastProdDataSeason2Name, String pastProdDataSeason2Year, double pastProdDataSeason2Qty,
			String pastProdDataSeason2QtyUnit, String pastProdDataSeason3Name, String pastProdDataSeason3Year,
			double pastProdDataSeason3Qty, String pastProdDataSeason3QtyUnit, String succeedingProdDataSeason1Name,
			String succeedingProdDataSeason1Year, double succeedingProdDataSeason1Qty,
			String succeedingProdDataSeason1QtyUnit, String succeedingProdDataSeason2Name,
			String succeedingProdDataSeason2Year, double succeedingProdDataSeason2Qty,
			String succeedingProdDataSeason2QtyUnit, String succeedingProdDataSeason3Name,
			String succeedingProdDataSeason3Year, double succeedingProdDataSeason3Qty,
			String succeedingProdDataSeason3QtyUnit, boolean isGrainProcuredInLast4Seasons,
			String foodgrainProcuredSeason1Name, String foodgrainProcuredSeason1Year,
			BinaryFile foodgrainProcuredSeason1WQSC, String foodgrainProcuredSeason2Name,
			String foodgrainProcuredSeason2Year, BinaryFile foodgrainProcuredSeason2WQSC,
			String foodgrainProcuredSeason3Name, String foodgrainProcuredSeason3Year,
			BinaryFile foodgrainProcuredSeason3WQSC, String foodgrainProcuredSeason4Name,
			String foodgrainProcuredSeason4Year, BinaryFile foodgrainProcuredSeason4WQSC,
			String cultivableLandSeason1RiceType, String cultivableLandSeason2RiceType,
			String cultivableLandSeason3RiceType, String bankAccountNumber, String bankName, String branchName,
			String routingCode) throws DataValidationException {

		log.debug("Farmer Registration Data Validation");

		BypassValidationConfiguration bypassValidationConfiguration = ConfigurationUtil
				.getBypassValidationConfiguration();
		if (Validator.isNotNull(bypassValidationConfiguration)
				&& bypassValidationConfiguration.isFarmerSalesProposalValidationDisabled()) {
			log.debug("Farmer Sales Proposal Validation disabled. Please enable it in System Configurations");
			return true;
		}

		FormValidator.validateInput(currentSeason, ParameterLabelConstants.LABEL_CURRENT_SEASON, true, 0, 30,
				ValidationConstants.REGEX_ALPHA_NUMERIC_WITH_SPACE);
		FormValidator.validateInput(foodgrainType, ParameterLabelConstants.LABEL_FOODGRAIN_TYPE, true, 0, 30,
				ValidationConstants.REGEX_ALPHA_NUMERIC_WITH_SPACE);
		FormValidator.validateInput(krishiCardNumber, ParameterLabelConstants.LABEL_KRISHOK_CARD_NUMBER, false, 0, 20,
				null);

		FormValidator.validateInput(pastProdDataSeason1Name,
				ParameterLabelConstants.LABEL_PAST_PROD_DATA_SEASON_1 + "-" + ParameterLabelConstants.LABEL_SEASON_NAME,
				false, SeasonConstants.getSeasonsList());
		FormValidator.validateInput(pastProdDataSeason1Year,
				ParameterLabelConstants.LABEL_PAST_PROD_DATA_SEASON_1 + "-" + ParameterLabelConstants.LABEL_YEAR, false,
				-1, 4, null);
		FormValidator.validateInput(pastProdDataSeason1Qty, ParameterLabelConstants.LABEL_PAST_PROD_DATA_SEASON_1 + "-"
				+ ParameterLabelConstants.LABEL_FOODGRAIN_QUANTITY, false, -1, -1);
		if (Validator.isNotNull(pastProdDataSeason1Qty)) {
			FormValidator.validateInput(pastProdDataSeason1QtyUnit,
					ParameterLabelConstants.LABEL_PAST_PROD_DATA_SEASON_1 + "-" + ParameterLabelConstants.LABEL_UNIT,
					false, -1, 10, null);
		}

		FormValidator.validateInput(pastProdDataSeason2Name,
				ParameterLabelConstants.LABEL_PAST_PROD_DATA_SEASON_2 + "-" + ParameterLabelConstants.LABEL_SEASON_NAME,
				false, SeasonConstants.getSeasonsList());
		FormValidator.validateInput(pastProdDataSeason2Year,
				ParameterLabelConstants.LABEL_PAST_PROD_DATA_SEASON_2 + "-" + ParameterLabelConstants.LABEL_YEAR, false,
				-1, 4, null);
		FormValidator.validateInput(pastProdDataSeason2Qty, ParameterLabelConstants.LABEL_PAST_PROD_DATA_SEASON_2 + "-"
				+ ParameterLabelConstants.LABEL_FOODGRAIN_QUANTITY, false, -1, -1);
		if (Validator.isNotNull(pastProdDataSeason2Qty)) {
			FormValidator.validateInput(pastProdDataSeason2QtyUnit,
					ParameterLabelConstants.LABEL_PAST_PROD_DATA_SEASON_2 + "-" + ParameterLabelConstants.LABEL_UNIT,
					false, -1, 10, null);
		}

		FormValidator.validateInput(pastProdDataSeason3Name,
				ParameterLabelConstants.LABEL_PAST_PROD_DATA_SEASON_3 + "-" + ParameterLabelConstants.LABEL_SEASON_NAME,
				false, SeasonConstants.getSeasonsList());
		FormValidator.validateInput(pastProdDataSeason3Year,
				ParameterLabelConstants.LABEL_PAST_PROD_DATA_SEASON_3 + "-" + ParameterLabelConstants.LABEL_YEAR, false,
				-1, 4, null);
		FormValidator.validateInput(pastProdDataSeason3Qty, ParameterLabelConstants.LABEL_PAST_PROD_DATA_SEASON_3 + "-"
				+ ParameterLabelConstants.LABEL_FOODGRAIN_QUANTITY, false, -1, -1);
		if (Validator.isNotNull(pastProdDataSeason3Qty)) {
			FormValidator.validateInput(pastProdDataSeason3QtyUnit,
					ParameterLabelConstants.LABEL_PAST_PROD_DATA_SEASON_3 + "-" + ParameterLabelConstants.LABEL_UNIT,
					false, -1, 10, null);
		}

		FormValidator.validateInput(succeedingProdDataSeason1Name,
				ParameterLabelConstants.LABEL_SUCCEEDING_PROD_DATA_SEASON_1 + "-"
						+ ParameterLabelConstants.LABEL_SEASON_NAME,
				false, SeasonConstants.getSeasonsList());
		FormValidator.validateInput(succeedingProdDataSeason1Year,
				ParameterLabelConstants.LABEL_SUCCEEDING_PROD_DATA_SEASON_1 + "-" + ParameterLabelConstants.LABEL_YEAR,
				false, -1, 4, null);
		FormValidator.validateInput(succeedingProdDataSeason1Qty,
				ParameterLabelConstants.LABEL_SUCCEEDING_PROD_DATA_SEASON_1 + "-"
						+ ParameterLabelConstants.LABEL_FOODGRAIN_QUANTITY,
				false, -1, -1);
		if (Validator.isNotNull(succeedingProdDataSeason1Qty)) {
			FormValidator.validateInput(succeedingProdDataSeason1QtyUnit,
					ParameterLabelConstants.LABEL_SUCCEEDING_PROD_DATA_SEASON_1 + "-"
							+ ParameterLabelConstants.LABEL_UNIT,
					false, -1, 10, null);
		}

		FormValidator.validateInput(succeedingProdDataSeason2Name,
				ParameterLabelConstants.LABEL_SUCCEEDING_PROD_DATA_SEASON_2 + "-"
						+ ParameterLabelConstants.LABEL_SEASON_NAME,
				false, SeasonConstants.getSeasonsList());
		FormValidator.validateInput(succeedingProdDataSeason2Year,
				ParameterLabelConstants.LABEL_SUCCEEDING_PROD_DATA_SEASON_2 + "-" + ParameterLabelConstants.LABEL_YEAR,
				false, -1, 4, null);
		FormValidator.validateInput(succeedingProdDataSeason2Qty,
				ParameterLabelConstants.LABEL_SUCCEEDING_PROD_DATA_SEASON_2 + "-"
						+ ParameterLabelConstants.LABEL_FOODGRAIN_QUANTITY,
				false, -1, -1);
		if (Validator.isNotNull(succeedingProdDataSeason2Qty)) {
			FormValidator.validateInput(succeedingProdDataSeason2QtyUnit,
					ParameterLabelConstants.LABEL_SUCCEEDING_PROD_DATA_SEASON_2 + "-"
							+ ParameterLabelConstants.LABEL_UNIT,
					false, -1, 10, null);
		}

		FormValidator.validateInput(succeedingProdDataSeason3Name,
				ParameterLabelConstants.LABEL_SUCCEEDING_PROD_DATA_SEASON_3 + "-"
						+ ParameterLabelConstants.LABEL_SEASON_NAME,
				false, SeasonConstants.getSeasonsList());
		FormValidator.validateInput(succeedingProdDataSeason3Year,
				ParameterLabelConstants.LABEL_SUCCEEDING_PROD_DATA_SEASON_3 + "-" + ParameterLabelConstants.LABEL_YEAR,
				false, -1, 4, null);
		FormValidator.validateInput(succeedingProdDataSeason3Qty,
				ParameterLabelConstants.LABEL_SUCCEEDING_PROD_DATA_SEASON_3 + "-"
						+ ParameterLabelConstants.LABEL_FOODGRAIN_QUANTITY,
				false, -1, -1);
		if (Validator.isNotNull(succeedingProdDataSeason3Qty)) {
			FormValidator.validateInput(succeedingProdDataSeason3QtyUnit,
					ParameterLabelConstants.LABEL_SUCCEEDING_PROD_DATA_SEASON_3 + "-"
							+ ParameterLabelConstants.LABEL_UNIT,
					false, -1, 10, null);
		}
		
		//TODO: Create Foodgrain Type Constant
		FormValidator.validateInput(cultivableLandSeason1RiceType,
				ParameterConstants.CULTIVABLE_LAND_SEASON_1_RICE_TYPE, false, null);
		FormValidator.validateInput(cultivableLandSeason2RiceType,
				ParameterConstants.CULTIVABLE_LAND_SEASON_2_RICE_TYPE, false, null);
		FormValidator.validateInput(cultivableLandSeason3RiceType,
				ParameterConstants.CULTIVABLE_LAND_SEASON_3_RICE_TYPE, false, null);

		if (isGrainProcuredInLast4Seasons) {
			FormValidator
					.validateInput(foodgrainProcuredSeason1Name,
							ParameterLabelConstants.LABEL_FOODGRAIN_PROCURED_SEASON_1 + "-"
									+ ParameterLabelConstants.LABEL_SEASON_NAME,
							true, SeasonConstants.getSeasonsList());
			FormValidator.validateInput(foodgrainProcuredSeason1Year,
					ParameterLabelConstants.LABEL_FOODGRAIN_PROCURED_SEASON_1 + "-"
							+ ParameterLabelConstants.LABEL_YEAR,
					false, -1, 4, null);

			FormValidator
					.validateInput(foodgrainProcuredSeason2Name,
							ParameterLabelConstants.LABEL_FOODGRAIN_PROCURED_SEASON_2 + "-"
									+ ParameterLabelConstants.LABEL_SEASON_NAME,
							true, SeasonConstants.getSeasonsList());
			FormValidator.validateInput(foodgrainProcuredSeason2Year,
					ParameterLabelConstants.LABEL_FOODGRAIN_PROCURED_SEASON_2 + "-"
							+ ParameterLabelConstants.LABEL_YEAR,
					false, -1, 4, null);

			FormValidator
					.validateInput(foodgrainProcuredSeason3Name,
							ParameterLabelConstants.LABEL_FOODGRAIN_PROCURED_SEASON_3 + "-"
									+ ParameterLabelConstants.LABEL_SEASON_NAME,
							true, SeasonConstants.getSeasonsList());
			FormValidator.validateInput(foodgrainProcuredSeason3Year,
					ParameterLabelConstants.LABEL_FOODGRAIN_PROCURED_SEASON_3 + "-"
							+ ParameterLabelConstants.LABEL_YEAR,
					false, -1, 4, null);

			FormValidator
					.validateInput(foodgrainProcuredSeason4Name,
							ParameterLabelConstants.LABEL_FOODGRAIN_PROCURED_SEASON_4 + "-"
									+ ParameterLabelConstants.LABEL_SEASON_NAME,
							true, SeasonConstants.getSeasonsList());
			FormValidator.validateInput(foodgrainProcuredSeason4Year,
					ParameterLabelConstants.LABEL_FOODGRAIN_PROCURED_SEASON_4 + "-"
							+ ParameterLabelConstants.LABEL_YEAR,
					false, -1, 4, null);
			if (!isHeadlessRequest) {
				FormValidator.validateAttachment(foodgrainProcuredSeason1WQSC, FileConstants.JPG_JPEG_PNG, false, 0,
						FileConstants.TWO_MB, FileConstants.FILE_WQSC);
				FormValidator.validateAttachment(foodgrainProcuredSeason2WQSC, FileConstants.JPG_JPEG_PNG, false, 0,
						FileConstants.TWO_MB, FileConstants.FILE_WQSC);
				FormValidator.validateAttachment(foodgrainProcuredSeason3WQSC, FileConstants.JPG_JPEG_PNG, false, 0,
						FileConstants.TWO_MB, FileConstants.FILE_WQSC);
				FormValidator.validateAttachment(foodgrainProcuredSeason4WQSC, FileConstants.JPG_JPEG_PNG, false, 0,
						FileConstants.TWO_MB, FileConstants.FILE_WQSC);
			}
		}

		FormValidator.validateInput(bankAccountNumber, ParameterLabelConstants.LABEL_ACCOUNT_NUMBER, true, 0, 30,
				ValidationConstants.REGEX_ALPHA_NUMERIC_WITH);
		FormValidator.validateInput(bankAccountNumber, ParameterLabelConstants.LABEL_BANK_NAME, true, 0, 30,
				ValidationConstants.REGEX_ALPHA_NUMERIC_WITH_SPACE);
		FormValidator.validateInput(branchName, ParameterLabelConstants.LABEL_BRANCH_NAME, true, 0, 30,
				ValidationConstants.REGEX_ALPHA_NUMERIC_WITH_SPACE);
		FormValidator.validateInput(routingCode, ParameterLabelConstants.LABEL_ROUTING_CODE, true, 0, 30,
				ValidationConstants.REGEX_ALPHA_NUMERIC_WITH);

		return true;
	}

	private static Log log = LogFactoryUtil.getLog(FarmerInformationValidator.class);
}
