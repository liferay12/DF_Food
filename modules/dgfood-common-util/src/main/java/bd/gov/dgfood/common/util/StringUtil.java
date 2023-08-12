package bd.gov.dgfood.common.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.Validator;

import bd.gov.dgfood.common.util.constants.GenderConstants;
import bd.gov.dgfood.common.util.constants.MaritalStatusConstants;

/**
 * The purpose of this class is to mention string related activities
 *
 * Accessibility : Throughout application
 *
 *
 *@author Ashish Singh
 * 
 */
public class StringUtil {

	/**
	 * The purpose of this method is to trim large strings
	 * 
	 */
	public static String trimLargeStringWithPunctuation(String string, int length) {
		if(Validator.isNotNull(string) && string.length() > length){
			string = string.substring(0, 10).concat("...");
		}
		return string;
	}
	
	/**
	 * The purpose of this method is to get gender labels
	 * 
	 */
	public static String getGenderString(long gender) {
		
		String genderString = StringPool.BLANK;
		
		if(gender == GenderConstants.GENDER_MALE) {
			genderString = GenderConstants.LABEL_MALE;
		}else if(gender == GenderConstants.GENDER_FEMALE) {
			genderString = GenderConstants.LABEL_FEMALE;
		}else {
			genderString = GenderConstants.LABEL_OTHER;
		}
		return genderString;
	}

	/**
	 * The purpose of this method is to get marital status labels
	 * 
	 */
	public static String getMaritalStatusString(long maritalStatus) {
		
		String maritalStatusString = StringPool.BLANK;

		if(maritalStatus == MaritalStatusConstants.MARITAL_STATUS_MARRIED) {
			maritalStatusString = MaritalStatusConstants.LABEL_MARRIED;
		}else if(maritalStatus == MaritalStatusConstants.MARITAL_STATUS_UNMARRIED) {
			maritalStatusString = MaritalStatusConstants.LABEL_UNMARRIED;
		}else if(maritalStatus == MaritalStatusConstants.MARITAL_STATUS_DIVORCED) {
			maritalStatusString = MaritalStatusConstants.LABEL_DIVORCED;
		}else if(maritalStatus == MaritalStatusConstants.MARITAL_STATUS_WIDOW) {
			maritalStatusString = MaritalStatusConstants.LABEL_WIDOW;
		}else {
			maritalStatusString = MaritalStatusConstants.LABEL_WIDOWER;
		}
		return maritalStatusString;
	}

}
