package bd.gov.dgfood.common.util.constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The purpose of this class is to mention gender constants
 *
 * Accessibility : Throughout application
 *
 * @author krishna
 * 
 */
public class GenderConstants {
	public static final int GENDER_MALE = 0;
	public static final int GENDER_FEMALE = 1;
	public static final int GENDER_OTHER = 2;

	public static final String LABEL_MALE = "male";

	public static final String LABEL_FEMALE = "female";

	public static final String LABEL_OTHER = "third-gender";

	public static String getGenderLabel(int status) {

		if (GENDER_MALE == status) {
			return LABEL_MALE;
		} else if (GENDER_FEMALE == status) {
			return LABEL_FEMALE;
		} else if (GENDER_OTHER == status) {
			return LABEL_OTHER;
		}
		return LABEL_MALE;

	}
	
	public static List<Integer> getGenderValues()
	{
		List<Integer> genderValuesList=new ArrayList<Integer>();
		
		genderValuesList.add(GENDER_MALE);
		genderValuesList.add(GENDER_FEMALE);
		genderValuesList.add(GENDER_OTHER);
		
		return genderValuesList;
	}
	
	public static Map<String, Integer> getGenderConstants()
	{
		Map<String, Integer> genderConstanstList=new HashMap<String, Integer>();
		
		genderConstanstList.put(LABEL_MALE, GENDER_MALE);
		genderConstanstList.put(LABEL_FEMALE, GENDER_FEMALE);
		genderConstanstList.put(LABEL_OTHER, GENDER_OTHER);
		
		return genderConstanstList;
	}

}
