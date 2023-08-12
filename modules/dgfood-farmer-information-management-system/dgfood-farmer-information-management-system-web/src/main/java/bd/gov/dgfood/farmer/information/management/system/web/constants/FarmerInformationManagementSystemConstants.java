package bd.gov.dgfood.farmer.information.management.system.web.constants;

/**
 * @author AshishV
 */
public class FarmerInformationManagementSystemConstants {

	/**
	 * Portlet Command names
	 */
	public static final String DEFAULT_COMMAND = "/";
	public static final String VALIDATE_CAPTCHA_RESOURCE_COMMAND = "/validate/captcha/resource";
	public static final String VALIDATE_NATIONAL_ID__RESOURCE_COMMAND = "/validate/nationalid/resource";
	public static final String GET_ASSET_CATEGORIES_RESOURCE_COMMAND = "/get/assetcategories/resource";
	public static final String FARMER_REGISTRATION_FORM_RENDER_COMMAND = "/form/farmerregistrationform/render";
	public static final String SUBMIT_FARMER_REGISTRATION_FORM_ACTION_COMMAND = "/submit/farmerregistrationform/action";
	public static final String FARMER_REGISTRATION_STATUS_RENDER_COMMAND = "/get/farmerregistrationstatuscheck/render";
	public static final String FARMER_REGISTRATIONS_SEARCH_RESOURCE_COMMAND = "/get/farmerregistrations/reqsource";
	public static final String FARMER_REGISTRATION_DETAILED_VIEW_RENDER_COMMAND = "/get/farmerregistrationdetailedview/render";
	public static final String WORKFLOW_TASK = "completeWorkflowTask";

	public static final String SUBMIT_SALES_PROPOSAL_FORM_ACTION_COMMAND = "/submit/farmersalesproposalform/action";

	/**
	 * Portlet JSP Pages
	 */
	public static final String FIMS_DEFAULT_JSP = "/view.jsp";
	public static final String FARMER_REGISTRATION_FORM_JSP = "/farmer-registration/farmer-registration-form.jsp";
	public static final String FARMER_REGISTRATION_SUCCESS_JSP = "/farmer-registration/farmer-registration-success.jsp";
	public static final String FARMER_REGISTRATION_ERROR_JSP = "/farmer-registration/farmer-registration-error.jsp";
	public static final String FARMER_REGISTRATION_STATUS_FORM_JSP = "/status-tracker/status-check-form.jsp";
	public static final String FARMER_REGISTRATION_STATUS_VIEW_JSP = "/status-tracker/application-status.jsp";
	public static final String FARMER_REGISTRATIONS_LIST_JSP = "/farmer-registration-search-filter/farmer-registrations-list.jsp";
	public static final String FARMER_REGISTRATIONS_SEARCH_CONTAINER_JSP = "/farmer-registration-search-filter/farmer-registrations-search-container.jsp";
	public static final String FARMER_REGISTRATION_DETAILED_VIEW_JSP = "/farmer-registration-search-filter/farmer-registration-detailed-view.jsp";

	public static final String SALES_PROPOSAL_FORM_JSP = "/sales-proposal/sales-proposal-form.jsp";
	public static final String SALES_PROPOSAL_SUCCESS_JSP = "/sales-proposal/sales-proposal-success.jsp";

	/**
	 * Portlet Search Container Constants
	 */
	public static final int FARMER_REGISTRATION_DELTA = 7;
	public static final String FARMER_REGISTRATION_APPLICATIONS_LIST = "farmerRegistrationApplicationsList";
	public static final String FARMER_REGISTRATION_APPLICATIONS_COUNT = "farmerRegistrationApplicationsCount";
}