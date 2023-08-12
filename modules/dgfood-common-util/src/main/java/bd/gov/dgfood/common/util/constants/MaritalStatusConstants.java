package bd.gov.dgfood.common.util.constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The purpose of this class is to mention marital status constants
 *
 * Accessibility : Throughout application
 * @author krishna
 *
 */
public class MaritalStatusConstants {

	public static final int MARITAL_STATUS_UNMARRIED = 0;
	public static final int MARITAL_STATUS_MARRIED = 1;
	public static final int MARITAL_STATUS_DIVORCED = 2;
	public static final int MARITAL_STATUS_WIDOW = 3;
	public static final int MARITAL_STATUS_WIDOWER = 4;

	public static final String LABEL_UNMARRIED = "unmarried";
	public static final String LABEL_MARRIED = "married";
	public static final String LABEL_DIVORCED = "divorced";
	public static final String LABEL_WIDOW = "widow";
	public static final String LABEL_WIDOWER = "widower";

	public static String getMaritalStatusLabel(int status) {

		if (MARITAL_STATUS_UNMARRIED == status) {
			return LABEL_UNMARRIED;
		} else if (MARITAL_STATUS_MARRIED == status) {
			return LABEL_MARRIED;
		} else if (MARITAL_STATUS_DIVORCED == status) {
			return LABEL_DIVORCED;
		} else if (MARITAL_STATUS_WIDOW == status) {
			return LABEL_WIDOW;
		} else if (MARITAL_STATUS_WIDOWER == status) {
			return LABEL_WIDOWER;
		}

		return LABEL_UNMARRIED;

	}
	
	public static List<Integer> getMaritalStatusValues()
	{
		List<Integer> maritalStatusValuesList=new ArrayList<Integer>();
		
		maritalStatusValuesList.add(MARITAL_STATUS_UNMARRIED);
		maritalStatusValuesList.add(MARITAL_STATUS_MARRIED);
		maritalStatusValuesList.add(MARITAL_STATUS_DIVORCED);
		maritalStatusValuesList.add(MARITAL_STATUS_WIDOW);
		maritalStatusValuesList.add(MARITAL_STATUS_WIDOWER);
		
		return maritalStatusValuesList;
	}
	
	public static Map<String, Integer> getMaritalStatusConstants()
	{
		Map<String, Integer> maritalStatusConstanstList=new HashMap<String, Integer>();
		
		maritalStatusConstanstList.put(LABEL_UNMARRIED, MARITAL_STATUS_UNMARRIED);
		maritalStatusConstanstList.put(LABEL_MARRIED, MARITAL_STATUS_MARRIED);
		maritalStatusConstanstList.put(LABEL_DIVORCED, MARITAL_STATUS_DIVORCED);
		maritalStatusConstanstList.put(LABEL_WIDOW, MARITAL_STATUS_WIDOW);
		maritalStatusConstanstList.put(LABEL_WIDOWER, MARITAL_STATUS_WIDOWER);
		
		return maritalStatusConstanstList;
	}

}
