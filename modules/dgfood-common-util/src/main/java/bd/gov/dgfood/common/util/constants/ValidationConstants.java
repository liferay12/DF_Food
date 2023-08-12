package bd.gov.dgfood.common.util.constants;

/**
 * The purpose of this interface to list down all regex constants.
 *
 * Accessibility : Throughout application
 *
 *
 * @author Ashish Singh
 * 
 */
public class ValidationConstants 
{
	public static final String REGEX_EMAIL_ADDRESS="^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
	public static final String REGEX_BANGLADESH_MOBILE_NUMBER="(^(\\+88|0088)?(01){1}[3456789]{1}(\\d){8})$";
	public static final String REGEX_ONLY_CHAR_WITH_SPACE="^[a-zA-Z\\s]*$";
	public static final String REGEX_ONLY_CHAR_WITHOUT_SPACE="^[a-zA-Z]*$";
	public static final String REGEX_ALPHA_NUMERIC_WITH_SPACE="^[a-zA-Z0-9\\s]*$";
	public static final String REGEX_ALPHA_NUMERIC_WITHOUT_SPACE="^[a-zA-Z0-9]*$";
	public static final String REGEX_ALPHA_NUMERIC_WITH_SPACE_AND_COMMA="^[a-zA-Z0-9\\s,]*$";
	public static final String REGEX_NUMERIC="^[0-9]*$";
}
