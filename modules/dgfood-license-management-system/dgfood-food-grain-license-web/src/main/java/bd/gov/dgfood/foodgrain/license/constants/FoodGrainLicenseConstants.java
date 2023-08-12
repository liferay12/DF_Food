package bd.gov.dgfood.foodgrain.license.constants;

/**
 * @author Ashish V
 */
public class FoodGrainLicenseConstants {

	/**
	 * This is a private constructor to hide the implicit public one
	 */
	private FoodGrainLicenseConstants() {
		super();
	}

	public static final String DEFAULT_COMMAND = "/";
	public static final String FOODGRAIN_LICENSE_SEARCH_COMMAND = "/foodgrainlicense/search/render";
	public static final String FOODGRAIN_LICENSE_DETAILS_COMMAND = "/foodgrainlicense/details/render";
	
	public static final String FOODGRAIN_LICENSE_SEARCH_JSP = "/jsp/fglicense-list/fglicense-search-filter.jsp";
	public static final String FOODGRAIN_LICENSE_DETAILS_JSP = "/jsp/fglicense-list/fglicense-details.jsp";

}