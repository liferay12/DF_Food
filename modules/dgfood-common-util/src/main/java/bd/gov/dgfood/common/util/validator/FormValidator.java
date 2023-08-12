package bd.gov.dgfood.common.util.validator;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.multipart.BinaryFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import bd.gov.dgfood.common.util.CategoryUtil;
import bd.gov.dgfood.common.util.constants.FileConstants;
import bd.gov.dgfood.common.util.constants.GenderConstants;
import bd.gov.dgfood.common.util.constants.ParameterConstants;
import bd.gov.dgfood.common.util.constants.ValidationConstants;
/**
 * This class is used for backend validation
 * 
 * @author Ashish Singh
 */
public class FormValidator {

	public static String CAN_NOT_BE_BLANK = "-can-not-be-blank";
	public static String SHOULD_NOT_BE_LESS_THAN = "-shouldn-not-be-less-than";
	public static String SHOULD_NOT_BE_GREATER_THAN = "-shouldn-not-be-greater-than";

	/**
	 * Validates the National Id. Conciders all required Natioanal Id Validations
	 * 
	 * @param nationalId
	 * @param isMandatory
	 * @param fildName
	 * @return
	 * @throws DataValidationException
	 */
	public static boolean validateNationalId(String nationalId, boolean isMandatory, String fildName)
			throws DataValidationException {
		log.debug("Validate the input nationalId: " + fildName);
		if (isMandatory && Validator.isNull(nationalId)) {
			throw new DataValidationException(fildName + CAN_NOT_BE_BLANK);
		}

		if (nationalId.length() != 10 && nationalId.length() != 17) {
			throw new DataValidationException(fildName + "-length-should-be-ten-or-seventeen");
		}

		return true;
	}

	/**
	 * Validates the Date Inputs.
	 * 
	 * @param input
	 * @param fieldName
	 * @param isMandatory
	 * @param minDate
	 * @param maxDate
	 * @return
	 * @throws DataValidationException
	 */
	public static boolean validateInput(Date input, String fieldName, boolean isMandatory, Date minDate, Date maxDate)
			throws DataValidationException {
		log.debug("Validate the input Date: " + input);
		if (isMandatory && Validator.isNull(input)) {

			throw new DataValidationException(fieldName + CAN_NOT_BE_BLANK);
		}

		if (Validator.isNotNull(minDate) && input.before(minDate)) {
			throw new DataValidationException(fieldName + "-can-not-be-before-date" + minDate);
		}

		if (Validator.isNotNull(maxDate) && input.after(maxDate)) {
			throw new DataValidationException(fieldName + "-can-not-be-after-date");
		}

		return true;
	}

	/**
	 * Validates Integer Inputs
	 * 
	 * @param input
	 * @param fieldName
	 * @param isMandatory
	 * @param minValue
	 * @param maxValue
	 * @return
	 * @throws DataValidationException
	 */
	public static boolean validateInput(int input, String fieldName, boolean isMandatory, long minValue, long maxValue)
			throws DataValidationException {
		log.debug("Validate the input int: " + input);
		if (isMandatory && input < 0 || input > maxValue) {
			throw new DataValidationException(fieldName + "-invalid-selection");
		}

		if (minValue >= 0 && input < minValue) {
			throw new DataValidationException(fieldName + SHOULD_NOT_BE_LESS_THAN + minValue);
		}

		if (maxValue > 0 && input > maxValue) {
			throw new DataValidationException(fieldName + SHOULD_NOT_BE_GREATER_THAN + maxValue);
		}
		return true;
	}

	/**
	 * Validates Inputs values of Float type
	 * 
	 * @param input
	 * @param fieldName
	 * @param isMandatory
	 * @param minValue
	 * @param maxValue
	 * @return
	 * @throws DataValidationException
	 */
	public static boolean validateInput(float input, String fieldName, boolean isMandatory, float minValue,
			float maxValue) throws DataValidationException {
		log.debug("Validate the input int: " + input);
		if (isMandatory && input < 0) {
			throw new DataValidationException(fieldName + "-invalid-selection");
		}

		if (minValue >= 0 && input < minValue) {
			throw new DataValidationException(fieldName + SHOULD_NOT_BE_LESS_THAN + minValue);
		}

		if (maxValue > 0 && input > maxValue) {
			throw new DataValidationException(fieldName + SHOULD_NOT_BE_GREATER_THAN + maxValue);
		}
		return true;
	}
	
	/**
	 * Validates Inputs values of double type
	 * 
	 * @param input
	 * @param fieldName
	 * @param isMandatory
	 * @param minValue
	 * @param maxValue
	 * @return
	 * @throws DataValidationException
	 */
	public static boolean validateInput(double input, String fieldName, boolean isMandatory, float minValue,
			float maxValue) throws DataValidationException {
		log.debug("Validate the input int: " + input);
		if (isMandatory && input < 0) {
			throw new DataValidationException(fieldName + "-invalid-selection");
		}

		if (minValue >= 0 && input < minValue) {
			throw new DataValidationException(fieldName + SHOULD_NOT_BE_LESS_THAN + minValue);
		}

		if (maxValue > 0 && input > maxValue) {
			throw new DataValidationException(fieldName + SHOULD_NOT_BE_GREATER_THAN + maxValue);
		}
		return true;
	}

	/**
	 * Validates text inputs
	 * 
	 * @param input
	 * @param fieldName
	 * @param isMandatory
	 * @param minLength
	 * @param maxLength
	 * @param regex
	 * @return
	 * @throws DataValidationException
	 */
	public static boolean validateInput(String input, String fieldName, boolean isMandatory, int minLength,
			int maxLength, String regex) throws DataValidationException {

		log.debug("Validate the input String: " + input);

		if (isMandatory && Validator.isNull(input)) {
			throw new DataValidationException(fieldName + CAN_NOT_BE_BLANK);
		}

		if (minLength != 0 && !Validator.isNull(input) && String.valueOf(input).length() < minLength) {
			throw new DataValidationException(fieldName + SHOULD_NOT_BE_LESS_THAN + +minLength);
		}

		if (maxLength != 0 && !Validator.isNull(input) && String.valueOf(input).length() > maxLength) {
			throw new DataValidationException(fieldName + SHOULD_NOT_BE_GREATER_THAN + maxLength);
		}

		if (Validator.isNotNull(input) && !input.isEmpty() && Validator.isNotNull(regex)
				&& !Pattern.matches(regex, input)) {
			throw new DataValidationException(fieldName + "-invalid-format");
		}

		return true;
	}

	/**
	 * Validates the text values for a drop-down 
	 * 
	 * @param input
	 * @param fieldName
	 * @param isMandatory
	 * @param allowedValuesList
	 * @return
	 * @throws DataValidationException
	 */
	public static boolean validateInput(String input, String fieldName, boolean isMandatory,
			List<String> allowedValuesList) throws DataValidationException {

		log.debug("Validate the input String: " + input);

		if (isMandatory && Validator.isNull(input)) {
			throw new DataValidationException(fieldName + CAN_NOT_BE_BLANK);
		}

		if (Validator.isNotNull(allowedValuesList) && !allowedValuesList.contains(input)) {
			throw new DataValidationException(fieldName + "-invalid-selection");
		}

		return true;
	}
	
	/**
	 * Validated Integer values for a drop-down
	 * 
	 * @param input
	 * @param fieldName
	 * @param isMandatory
	 * @param allowedValuesList
	 * @return
	 * @throws DataValidationException
	 */
	public static boolean validateInput(int input, String fieldName, boolean isMandatory,
			List<Integer> allowedValuesList) throws DataValidationException {

		log.debug("Validate the input String: " + input);

		if (isMandatory && Validator.isNull(input)) {
			throw new DataValidationException(fieldName + CAN_NOT_BE_BLANK);
		}

		if (Validator.isNotNull(allowedValuesList) && !allowedValuesList.contains(input)) {
			throw new DataValidationException(fieldName + "-invalid-selection");
		}

		return true;
	}

	/**
	 * Validates Address Dropdown Fields
	 * 
	 * @param region
	 * @param destrict
	 * @param upazilla
	 * @param cityCorporationOrMunicipality
	 * @param unionOrWard
	 * @param postOffice
	 * @param zipCode
	 * @param villageOrRoad
	 * @param mouzaOrMoholla
	 * @param address
	 * @throws DataValidationException
	 */
	public static void validateAddress(long region, long destrict, long upazilla, long cityCorporationOrMunicipality,
			long unionOrWard, String postOffice, long zipCode, String villageOrRoad, String mouzaOrMoholla,
			String address) throws DataValidationException {

		log.debug("Validate address ");

		List<Long> addressCtaegorisIdList = new ArrayList<Long>();
		addressCtaegorisIdList.add(region);
		addressCtaegorisIdList.add(destrict);

		addressCtaegorisIdList.add(upazilla);
		addressCtaegorisIdList.add(unionOrWard);
		addressCtaegorisIdList.add(cityCorporationOrMunicipality);

		List<AssetCategory> addressAssetCategoriesList = CategoryUtil.fetchCategoriesList(addressCtaegorisIdList);

		validateAddressData(addressCtaegorisIdList, addressAssetCategoriesList, villageOrRoad, zipCode, postOffice,
				address, mouzaOrMoholla);

	}
	
	/**
	 * Validates Address fields data
	 * 
	 * @param addressCtaegorisIdList
	 * @param addressAssetCategoriesList
	 * @param villageOrRoad
	 * @param zipCode
	 * @param postOffice
	 * @param address
	 * @param mouzaOrMoholla
	 * @throws DataValidationException
	 */
	private static void validateAddressData(List<Long> addressCtaegorisIdList,
			List<AssetCategory> addressAssetCategoriesList, String villageOrRoad, long zipCode, String postOffice,
			String address, String mouzaOrMoholla) throws DataValidationException {

		if (addressAssetCategoriesList.size() != addressCtaegorisIdList.size()) {
			throw new DataValidationException("invalid-address-value-selected");
		}

		validateInput(villageOrRoad, "village-or-road", true, 0, 0, ValidationConstants.REGEX_ALPHA_NUMERIC_WITH_SPACE);
		validateInput(postOffice, "post-office", true, 0, 0, ValidationConstants.REGEX_ALPHA_NUMERIC_WITH_SPACE);
		validateInput(address, "home-address", true, 0, 0, ValidationConstants.REGEX_ALPHA_NUMERIC_WITH_SPACE);
		validateInput(mouzaOrMoholla, "mouza-or-moholla", true, 0, 0,
				ValidationConstants.REGEX_ALPHA_NUMERIC_WITH_SPACE);

	}
	
	/**
	 * Validates Address Dropdown Fields
	 * 
	 * @param region
	 * @param district
	 * @param upazila
	 * @param cityMetropolis
	 * @param cityCorporationOrMunicipality
	 * @param union
	 * @param village
	 * @param ward
	 * @param zipCode
	 * @param postOffice
	 * @param mouzaOrMoholla
	 * @param address
	 * @throws DataValidationException
	 */
	public static void validateAddress(long region, long district, long upazila, long cityMetropolis, 
			long cityCorporationOrMunicipality, long union, String village, String ward, 
			int zipCode, String postOffice, String mouzaOrMoholla, String houseAddress) throws DataValidationException {

		log.debug("Validate address ");

		List<Long> addressCtaegorisIdList = new ArrayList<Long>();
		addressCtaegorisIdList.add(region);
		addressCtaegorisIdList.add(district);
		addressCtaegorisIdList.add(upazila);
		addressCtaegorisIdList.add(cityMetropolis);
		addressCtaegorisIdList.add(cityCorporationOrMunicipality);
		addressCtaegorisIdList.add(union);
		
		List<AssetCategory> addressAssetCategoriesList = CategoryUtil.fetchCategoriesList(addressCtaegorisIdList);

		validateAddressData(addressCtaegorisIdList, addressAssetCategoriesList, village, ward, zipCode, postOffice,
				mouzaOrMoholla, houseAddress);

	}

	/**
	 * Validates Address fields data
	 * 
	 * @param addressCtaegorisIdList
	 * @param addressAssetCategoriesList
	 * @param village
	 * @param ward
	 * @param zipCode
	 * @param postOffice
	 * @param mouzaOrMoholla
	 * @param address
	 * @throws DataValidationException
	 */
	private static void validateAddressData(List<Long> addressCtaegorisIdList,
			List<AssetCategory> addressAssetCategoriesList, String village, String ward, int zipCode,
			String postOffice, String mouzaOrMoholla, String houseAddress) throws DataValidationException {

		if (addressAssetCategoriesList.size() != addressCtaegorisIdList.size()) {
			log.debug(addressAssetCategoriesList.size());
			log.debug(addressAssetCategoriesList);
			log.debug(addressCtaegorisIdList.size());
			log.debug(addressCtaegorisIdList);
			throw new DataValidationException("invalid-address-value-selected");
		}

		validateInput(village, "village", true, 0, 0, ValidationConstants.REGEX_ONLY_CHAR_WITH_SPACE);
		validateInput(ward, "ward", true, 0, 0, ValidationConstants.REGEX_ALPHA_NUMERIC_WITH_SPACE);
		//validateInput(zipCode, "zip-code", true, 1, 6);
		validateInput(postOffice, "post-office", true, 0, 0, ValidationConstants.REGEX_ALPHA_NUMERIC_WITH_SPACE);
		validateInput(mouzaOrMoholla, "mouza-or-moholla", true, 0, 0, ValidationConstants.REGEX_ONLY_CHAR_WITH_SPACE);
		validateInput(houseAddress, "house-address", true, 0, 0, ValidationConstants.REGEX_ALPHA_NUMERIC_WITH_SPACE_AND_COMMA);
		
	}

	/**
	 * Validates Attachament files
	 * 
	 * @param binaryFile
	 * @param extensionList
	 * @param isMandatory
	 * @param minSize
	 * @param maxSize
	 * @param category
	 * @throws DataValidationException
	 */
	public static void validateAttachment(BinaryFile binaryFile, List<String> extensionList, boolean isMandatory,
			long minSize, long maxSize, String category) throws DataValidationException {

		log.info("Validate the input String: " + category);
		if (!Validator.isNull(binaryFile)) {
			log.info(" ContentType " + binaryFile.getContentType());
			log.info(" getFileName " + binaryFile.getFileName());
			log.info(" getSize " + binaryFile.getSize());
			log.info(" getInputStream " + binaryFile.getInputStream());
		}

		if (isMandatory && Validator.isNull(binaryFile)) {
			throw new DataValidationException(category + CAN_NOT_BE_BLANK);
		}

		if (!Validator.isNull(binaryFile) && !Validator.isNull(binaryFile.getFileName())
				&& (binaryFile.getSize() <= 0 || Validator.isNull(binaryFile.getInputStream()))) {
			throw new DataValidationException(category + "file-size" + CAN_NOT_BE_BLANK);
		}

		if (minSize > 0 && !Validator.isNull(binaryFile) && binaryFile.getSize() < minSize) {
			throw new DataValidationException(category + SHOULD_NOT_BE_LESS_THAN + FileConstants.getSizeLabel(minSize));
		}
		if (!Validator.isNull(binaryFile)
				&& (Validator.isNull(binaryFile.getFileName()) || binaryFile.getFileName().isEmpty())) {
			throw new DataValidationException(category + "-title" + CAN_NOT_BE_BLANK);
		}

		if (Validator.isNull(category) || category.isEmpty()) {
			throw new DataValidationException(category + "-category" + CAN_NOT_BE_BLANK);
		}

		if (!Validator.isNull(binaryFile)
				&& (Validator.isNull(binaryFile.getContentType()) || binaryFile.getContentType().isEmpty())) {
			throw new DataValidationException(category + "-file-extension" + CAN_NOT_BE_BLANK + extensionList);
		}

		if (maxSize > 0 && Validator.isNotNull(binaryFile) && binaryFile.getSize() > maxSize) {
			throw new DataValidationException(category + "-file-size-should-not-be-exceed" + maxSize);
		}

		if (Validator.isNotNull(extensionList)) {

			Set<String> extensions = Validator.isNotNull(binaryFile)
					? MimeTypesUtil.getExtensions(binaryFile.getContentType())
					: null;

			if (Validator.isNotNull(extensions) && !extensions.isEmpty()
					&& !extensionList.stream().anyMatch(extension -> extensions.contains(extension))) {
				throw new DataValidationException(
						category + "-invalid-file-type-allowed-file-types-are" + extensionList);
			}

		}

	}

	/**
	 * Validates the List of attachments (use for multiple file inputs)
	 * 
	 * @param binaryFiles
	 * @param extensions
	 * @param isMandatory
	 * @param minSize
	 * @param maxSize
	 * @param fieldName
	 * @throws DataValidationException
	 */
	public static void validateAttachment(List<BinaryFile> binaryFiles, List<String> extensions, boolean isMandatory,
			long minSize, long maxSize, String fieldName) throws DataValidationException {

		for (BinaryFile binaryFile : binaryFiles) {
			validateAttachment(binaryFile, extensions, isMandatory, minSize, maxSize, fieldName);
		}

	}
	
	public static void validateNationalIdDetails(String applicantName, String fatherName, String motherName, int gender,
			long region, long district, long upazila, long cityMetropolis, long cityCorporationOrMunicipality, long union, 
			String village, String ward, int zipCode, String postOffice, String mouzaOrMoholla, String houseAddress)
			throws DataValidationException {
		
		validateInput(applicantName, ParameterConstants.APPLICANT_NAME, true, 0, 30,
				ValidationConstants.REGEX_ONLY_CHAR_WITH_SPACE);
		validateInput(fatherName, ParameterConstants.FATHER_NAME, true, 0, 30,
				ValidationConstants.REGEX_ONLY_CHAR_WITH_SPACE);
		validateInput(motherName, ParameterConstants.MOTHER_NAME, true, 0, 30,
				ValidationConstants.REGEX_ONLY_CHAR_WITH_SPACE);
		validateInput(gender, ParameterConstants.GENDER, true, GenderConstants.getGenderValues());
		
		validateAddress(region, district, upazila, cityMetropolis, cityCorporationOrMunicipality, union, village,
				ward, zipCode, postOffice, mouzaOrMoholla, houseAddress);
	}

	private static Log log = LogFactoryUtil.getLog(FormValidator.class);

}
