package bd.gov.dgfood.foodgrain.license.constants;

/**
 * @author Abhijit Ande
 */
public class FoodGrainLicensePortletKeys {

	/**
	 * This is a private constructor to hide the implicit public one
	 */
	private FoodGrainLicensePortletKeys() {
		super();
	}

	public static final String FOODGRAIN_LICENSE_SEARCH_LIST = 
			"bd_gov_dgfood_foodgrain_license_web_FoodGrainLicenseSearchListPortlet";
	public static final String DASHBOARDFGLICENSE =
			"bd_gov_dgfood_foodgrain_license_web_DashboardFGLicensePortlet";
	public static final String FOODGRAINLICENSELIST =
			"bd_gov_dgfood_foodgrain_license_web_FoodGrainLicenseListPortlet";
	public static final String FOODGRAINLICENSE =
			"bd_gov_dgfood_foodgrain_license_web_FGLicensePortlet";
	public static final String HOMESCREENFGLICENSE =
			"bd_gov_dgfood_foodgrain_license_web_HomeScreenFGLicensePortlet";
	public static final String LANDINGFGLICENSE =
			"bd_gov_dgfood_foodgrain_license_web_LandingFGLicensePortlet";
	public static final String MYPROFILEFGLICENSE =
			"bd_gov_dgfood_foodgrain_license_web_MyProfileFGLicensePortlet";
	
	public static final String NEW_MILLING_MVC_RENDER_COMMAND = "/milling/screen/new";
	
	public static final String NAVIGATION_MVC_RENDER_COMMAND = "/navigation";
	
	public static final String CHANGE_LICENSE_MVC_RENDER_COMMAND = "/change-license";
	
	public static final String SUBMIT_NEW_FG_LICENSE_MVC_ACTION_COMMAND = "/submit/fglicense/form/new";
	public static final String SUBMIT_UPDATE_FG_LICENSE_MVC_ACTION_COMMAND = "/submit/fglicense/form/update";
	public static final String SUBMIT_RENEWAL_OR_DUPLICATE_FG_LICENSE_MVC_ACTION_COMMAND = "/submit/fglicense/form/renewal-duplicate";
	public static final String SUBMIT_PAYMENT_CHALLAN_FG_LICENSE_MVC_ACTION_COMMAND = "/submit/payment/challan/new";
	public static final String SUBMIT_PASSWORD_MVC_ACTION_COMMAND = "/submit/fglicense/form/new";
	
	public static final String NEW_FG_LICENSE_MVC_RENDER_COMMAND = "/fgLicense/screen/new";
	public static final String UPDATE_FG_LICENSE_MVC_RENDER_COMMAND = "/fgLicense/screen/update";
	public static final String RENEWAL_DUPLICATE_FG_LICENSE_MVC_RENDER_COMMAND = "/fgLicense/screen/renewal-duplicate";
	public static final String FG_LICENSE_STATUS_MVC_RENDER_COMMAND = "/fglicense/status/check";
	public static final String CHECK_FG_LICENSE_STATUS_MVC_RENDER_COMMAND = "/fgLicense/status/input";
	public static final String SELECT_FG_LICENSE_MVC_RENDER_COMMAND = "/fgLicense/select";
	
	public static final String DASHBOARD_SCREEN_FG_LICENSE_MVC_RENDER_COMMAND = "/fgLicense/screen/dashboard";
	public static final String FOOD_GRAIN_SCREEN_FG_LICENSE_MVC_RENDER_COMMAND = "/fgLicense/screen/foodgrain";
	public static final String LIST_LICENSES_MVC_RENDER_COMMAND = "/fgLicense/screen/list";
	public static final String VIEW_SINGLE_FG_LICENSE_MVC_RENDER_COMMAND = "/fgLicense/singleview";
	public static final String VIEW_SINGLE_FG_LICENSE_VERSION_MVC_RENDER_COMMAND = "/fgLicense-version/singleview";
	
	public static final String RETRIEVE_NATIONAL_ID_DETAILS_MVC_RESOURCE_COMMAND = "/validate/nid";
	public static final String POPULATE_ADDRESS_MVC_RESOURCE_COMMAND = "/populate/address";
	public static final String VERIFY_CAPTCHA_MVC_RESOURCE_COMMAND = "/verify/captcha";
	public static final String POPULATE_PROFILE_DETAILS_MVC_RESOURCE_COMMAND = "/populate/profile";
	public static final String POPULATE_NATIONAL_ID_DETAILS_MVC_RESOURCE_COMMAND = "/populate/nationalId";
	public static final String BUSINESS_DETAILS_MVC_RESOURCE_COMMAND = "/populate/business";
	public static final String POPULATE_FG_LICENSE_LIST_MVC_RESOURCE_COMMAND = "/populate/list";
	public static final String POPULATE_FG_LICENSE_VERSION_LIST_MVC_RESOURCE_COMMAND = "/populate/list";
	
	public static final String GET_ASSET_CATEGORIES_RESOURCE_COMMAND = "/get/assetcategories/resource";
	public static final String VALIDATE_NATIONAL_ID_RESOURCE_COMMAND = "/validate/nationalid/resource";
	public static final String GENERATE_AND_VALIDATE_OTP_MVC_RESOURCE_COMMAND = "vargetOTPForUser";
	
}