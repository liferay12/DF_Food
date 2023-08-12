package bd.gov.dgfood.common.util.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * The purpose of this interface to list down all the unit constants.
 *
 * Accessibility : Throughout application
 *
 *
 * @author Ashish Singh
 * 
 */
public class UnitConstants {

	public static final String UNIT_MT = "mt";
	public static final String UNIT_BIGHA = "bigha";
	public static final String UNIT_HECTARE = "hectare";

	public static List<String> getCultivableLandUnitList() {
		List<String> cultivableLandUnitList = new ArrayList<String>();

		cultivableLandUnitList.add(UNIT_BIGHA);
		cultivableLandUnitList.add(UNIT_HECTARE);

		return cultivableLandUnitList;
	}
}
