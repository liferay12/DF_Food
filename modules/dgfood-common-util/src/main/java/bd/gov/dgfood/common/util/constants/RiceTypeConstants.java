package bd.gov.dgfood.common.util.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * The purpose of this interface to list down all rice type Constants
 *
 * Accessibility : Throughout application
 *
 *
 *@author Ashish Singh
 * 
 */
public class RiceTypeConstants {

	public static final String RICE_TYPE_ZINC = "zinc";

	public static List<String> getRiceTypeList() {
		List<String> riceTypeList = new ArrayList<String>();

		riceTypeList.add(RICE_TYPE_ZINC);

		return riceTypeList;
	}

	public static List<String> getCultivableLandRiceTypeList() {
		List<String> riceTypeList = new ArrayList<String>();

		riceTypeList.add(RICE_TYPE_ZINC);

		return riceTypeList;
	}

}
