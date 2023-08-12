package bd.gov.dgfood.common.util.constants;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * The purpose of this interface to list down all season Constants
 *
 * Accessibility : Throughout application
 *
 *
 *@author Ashish V
 * 
 */
public class SeasonConstants {
	public static final String SEASON_AMON = "amon";
	public static final String SEASON_BORO = "boro";
	public static final String SEASON_WHEAT = "wheat";

	public static List<String> getSeasonsList() {
		List<String> seasonValuesList = new ArrayList<String>();

		seasonValuesList.add(SEASON_AMON);
		seasonValuesList.add(SEASON_BORO);
		seasonValuesList.add(SEASON_WHEAT);

		return seasonValuesList;
	}

	public static List<String> getCultivableLandSeasonList() {
		List<String> cultivableLandSeasonList = new ArrayList<String>();

		cultivableLandSeasonList.add(SEASON_AMON);
		cultivableLandSeasonList.add(SEASON_BORO);
		cultivableLandSeasonList.add(SEASON_WHEAT);

		return cultivableLandSeasonList;
	}

	public static List<String> getPastSeasonYearsList() {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);

		List<String> pastSeasonYearsList = new ArrayList<String>();

		pastSeasonYearsList.add(String.valueOf(currentYear - 1));
		pastSeasonYearsList.add(String.valueOf(currentYear - 2));

		return pastSeasonYearsList;
	}

	public static List<String> getSucceedingSeasonYearsList() {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		List<String> succeedingSeasonYearsList = new ArrayList<String>();

		succeedingSeasonYearsList.add(String.valueOf(currentYear));
		succeedingSeasonYearsList.add(String.valueOf(currentYear+1));

		return succeedingSeasonYearsList;
	}
}
