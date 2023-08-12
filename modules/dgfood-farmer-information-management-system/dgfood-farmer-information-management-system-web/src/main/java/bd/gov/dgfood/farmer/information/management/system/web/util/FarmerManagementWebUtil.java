package bd.gov.dgfood.farmer.information.management.system.web.util;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;

import bd.gov.dgfood.common.util.DateFormatterUtil;
import bd.gov.dgfood.common.util.constants.ParameterConstants;
import bd.gov.dgfood.common.util.constants.PortletPreferencesConstants;
import bd.gov.dgfood.farmer.information.management.system.model.FarmerRegistration;
import bd.gov.dgfood.farmer.information.management.system.service.FarmerRegistrationLocalServiceUtil;
import bd.gov.dgfood.farmer.information.management.system.web.constants.FarmerInformationManagementSystemConstants;

/**
 * The purpose of this class is to load/fetch the requird parametres based on
 * configured Landing Page
 *
 * Accessibility : Farmer Information Management System
 *
 *
 * @author Ashish V
 * 
 */

public class FarmerManagementWebUtil {

	/**
	 * Fetch and set Location Asset Vocabulary for Address Dropdown fields
	 * 
	 * @param portletRequest
	 */
	public static void loadLocationAssetVocabulary(PortletRequest portletRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<AssetCategory> regionList = new ArrayList<AssetCategory>();
		try {

			AssetVocabulary regionVocabulary = AssetVocabularyLocalServiceUtil
					.getGroupVocabulary(themeDisplay.getScopeGroupId(), "Location");
			regionList = AssetCategoryLocalServiceUtil.getVocabularyCategories(0, regionVocabulary.getVocabularyId(),
					-1, -1, null);

			log.debug("Dropdown fetched successfully");
		} catch (PortalException e) {
			log.error("Error while fetching the asset categories: " + e.getMessage());
			if (log.isDebugEnabled()) {
				e.printStackTrace();
			}
		}

		portletRequest.setAttribute("regionList", regionList);
	}

	/**
	 * Fetch Farmer Registration Applications
	 * 
	 * @param portletRequest
	 */
	public static void fetchFarmerRegistrationApplications(PortletRequest portletRequest) {

		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);

		/* Search Container parameters */
		int currentPage = ParamUtil.getInteger(portletRequest, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(portletRequest, SearchContainer.DEFAULT_DELTA_PARAM,
				FarmerInformationManagementSystemConstants.FARMER_REGISTRATION_DELTA);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = start + delta;
		String orderByCol = ParamUtil.getString(portletRequest, "orderByCol", "createDate");
		String orderByType = ParamUtil.getString(portletRequest, "orderByType", "desc");
		OrderByComparator<FarmerRegistration> orderByComparator = OrderByComparatorFactoryUtil
				.create(FarmerRegistration.class.getSimpleName(), orderByCol, orderByType.equalsIgnoreCase("asc"));

		/* Search inputs Map */
		long unionOrWord = ParamUtil.getLong(portletRequest, ParameterConstants.UNION_OR_WARD, -1);
		int status = ParamUtil.getInteger(portletRequest, ParameterConstants.STATUS, -1);
		String nationalId = ParamUtil.getString(portletRequest, ParameterConstants.NATIONAL_ID);
		String applicationNumber = ParamUtil.getString(portletRequest, ParameterConstants.APPLICATION_NUMBER);
		String searchKeywords = ParamUtil.getString(portletRequest, "keywords");
		String fromDate = ParamUtil.getString(portletRequest, ParameterConstants.FROM_DATE);
		String toDate = ParamUtil.getString(portletRequest, ParameterConstants.TO_DATE);

		Map<String, Object> searchCriterionsMap = new HashMap<String, Object>();
		if (status != -1) {
			searchCriterionsMap.put(ParameterConstants.STATUS, status);
		}
		if (Validator.isNotNull(nationalId)) {
			searchCriterionsMap.put(ParameterConstants.NATIONAL_ID, nationalId);
		}
		if (Validator.isNotNull(applicationNumber)) {
			searchCriterionsMap.put(ParameterConstants.APPLICATION_NUMBER, applicationNumber);
		}

		Map<String, Object> addressCriterionsMap = new HashMap<String, Object>();
		if (unionOrWord != -1) {
			addressCriterionsMap.put("unionOrWard", unionOrWord);
		}

		log.debug(searchCriterionsMap);
		log.debug(addressCriterionsMap);

		List<FarmerRegistration> farmerRegistrationApplicationsList = FarmerRegistrationLocalServiceUtil
				.searchFarmerRegistrations(themeDisplay.getScopeGroupId(), searchCriterionsMap, addressCriterionsMap,
						searchKeywords, DateFormatterUtil.parseDate(fromDate), DateFormatterUtil.parseDate(toDate),
						start, end, orderByComparator);

		Long farmerRegistrationApplicationsCount = FarmerRegistrationLocalServiceUtil.searchFarmerRegistrationsCount(
				themeDisplay.getScopeGroupId(), searchCriterionsMap, addressCriterionsMap, searchKeywords,
				DateFormatterUtil.parseDate(fromDate), DateFormatterUtil.parseDate(toDate));

		log.debug(farmerRegistrationApplicationsList);
		log.debug(farmerRegistrationApplicationsCount);

		portletRequest.setAttribute(FarmerInformationManagementSystemConstants.FARMER_REGISTRATION_APPLICATIONS_LIST,
				farmerRegistrationApplicationsList);
		portletRequest.setAttribute(FarmerInformationManagementSystemConstants.FARMER_REGISTRATION_APPLICATIONS_COUNT,
				farmerRegistrationApplicationsCount.intValue());

	}

	/**
	 * Return List of Landing Pages
	 */
	public static List<String> getlandingPagesList() {
		List<String> landingPagesList = new ArrayList<String>();
		landingPagesList.add(PortletPreferencesConstants.STATUS_TRACKER_FORM);
		landingPagesList.add(PortletPreferencesConstants.FARMER_REGISTRATION_FORM);
		landingPagesList.add(PortletPreferencesConstants.REGISTRATION_APPLICATIONS_LIST_VIEW);
		landingPagesList.add(PortletPreferencesConstants.SALES_PROPOSAL_FORM);

		return Collections.unmodifiableList(landingPagesList);
	}

	/**
	 * Validates NationalId existance
	 */
	public static boolean isNationalIdExist(String nationalId) {
		FarmerRegistration farmerRegistration = FarmerRegistrationLocalServiceUtil
				.fetchFarmerRegistrationByNationalId(nationalId);
		if (Validator.isNotNull(farmerRegistration)) {
			return true;
		}

		return false;
	}

	static Log log = LogFactoryUtil.getLog(FarmerManagementWebUtil.class);
}
