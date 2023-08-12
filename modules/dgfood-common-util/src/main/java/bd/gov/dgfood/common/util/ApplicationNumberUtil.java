package bd.gov.dgfood.common.util;

/**
 * The purpose of this class is to mention application number related activities
 *
 * Accessibility : Throughout application
 *
 *
 * @author Ashish Singh
 * 
 */

public class ApplicationNumberUtil {

	/**
	 * The purpose of this class generate application number for all modules
	 *
	 */
	public static String generateApplicationNumber(long primarykey, String moduleName) {
		return moduleName + primarykey;
	}
}
