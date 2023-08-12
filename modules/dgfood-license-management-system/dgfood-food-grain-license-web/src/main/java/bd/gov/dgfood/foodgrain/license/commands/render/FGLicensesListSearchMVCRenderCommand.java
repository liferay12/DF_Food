package bd.gov.dgfood.foodgrain.license.commands.render;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.common.services.model.UserLocation;
import bd.gov.dgfood.common.services.service.UserLocationLocalService;
import bd.gov.dgfood.common.util.constants.DateConstants;
import bd.gov.dgfood.common.util.constants.ParameterConstants;
import bd.gov.dgfood.foodgrain.license.constants.FoodGrainLicenseConstants;
import bd.gov.dgfood.foodgrain.license.constants.FoodGrainLicensePortletKeys;
import bd.gov.dgfood.license.management.system.model.FGLicenseInfo;
import bd.gov.dgfood.license.management.system.service.FGLicenseInfoLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + FoodGrainLicensePortletKeys.FOODGRAIN_LICENSE_SEARCH_LIST,
		"mvc.command.name=" + FoodGrainLicenseConstants.DEFAULT_COMMAND, "mvc.command.name="
				+ FoodGrainLicenseConstants.FOODGRAIN_LICENSE_SEARCH_COMMAND, }, service = MVCRenderCommand.class)
public class FGLicensesListSearchMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		int delta = ParamUtil.get(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);
		int currentPage = ParamUtil.get(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR);
		int start = (currentPage > 0 ? currentPage - 1 : currentPage) * delta;
		int end = start + delta;

		Date fromDate = ParamUtil.getDate(renderRequest, ParameterConstants.FROM_DATE,
				new SimpleDateFormat(DateConstants.DD_MM_YYYY), null);
		Date toDate = ParamUtil.getDate(renderRequest, ParameterConstants.TO_DATE,
				new SimpleDateFormat(DateConstants.DD_MM_YYYY), null);

		String keywords = ParamUtil.getString(renderRequest, DisplayTerms.KEYWORDS);

		Map<String, Object> filterOptions = new HashMap<>();

		if (Validator.isNotNull(ParamUtil.getString(renderRequest, ParameterConstants.APPLICATION_NUMBER))) {
			filterOptions.put(ParameterConstants.APPLICATION_NUMBER,
					ParamUtil.getString(renderRequest, ParameterConstants.APPLICATION_NUMBER));

		}

		if (Validator.isNotNull(ParamUtil.getString(renderRequest, ParameterConstants.APPLICATION_TYPE))) {
			filterOptions.put(ParameterConstants.APPLICATION_TYPE,
					ParamUtil.getString(renderRequest, ParameterConstants.APPLICATION_TYPE));

		}

		Integer status = ParamUtil.getInteger(renderRequest, ParameterConstants.STATUS, WorkflowConstants.STATUS_ANY);
		if (status != WorkflowConstants.STATUS_ANY) {
			filterOptions.put(ParameterConstants.STATUS, status);
		}

		String upazila = ParamUtil.getString(renderRequest, ParameterConstants.UPAZILA);
		if (Validator.isNotNull(upazila)) {
			filterOptions.put(ParameterConstants.UPAZILA,
					ParamUtil.getString(renderRequest, ParameterConstants.UPAZILA));
		}
		logger.debug(upazila);

		String currentUserZilla = StringPool.NULL;
		List<UserLocation> userLocationsList = userLocationLocalService
				.getUserLocationsByUserId(themeDisplay.getUserId(), -1, -1);
		logger.debug(userLocationsList);
		UserLocation curentUserLocation = null;
		if (Validator.isNotNull(userLocationsList)) {
			curentUserLocation = userLocationsList.stream()
					.filter(userlocation -> ParameterConstants.ZILLA.equalsIgnoreCase(userlocation.getLocationType()))
					.findFirst().orElse(null);
		}
		if (Validator.isNotNull(curentUserLocation)) {
			currentUserZilla = curentUserLocation.getLocationCode();
		}

		logger.debug(currentUserZilla);

		List<FGLicenseInfo> fgLicenseInfosList = fgLicenseInfoLocalService.searchFGLicenseRecords(
				themeDisplay.getScopeGroupId(), filterOptions, ParameterConstants.ZILLA, currentUserZilla, keywords,
				fromDate, toDate, start, end, null);

		long fgLicenseInfosCount = fgLicenseInfoLocalService.searchFGLicenseRecordsCount(themeDisplay.getScopeGroupId(),
				filterOptions, ParameterConstants.ZILLA, currentUserZilla, keywords, fromDate, toDate);

		renderRequest.setAttribute(ParameterConstants.FOODGRAIN_LICENSE_LIST_PARAM, fgLicenseInfosList);
		renderRequest.setAttribute(ParameterConstants.FOODGRAIN_LICENSE_COUNT_PARAM, fgLicenseInfosCount);
		renderRequest.setAttribute(ParameterConstants.ZILLA, currentUserZilla);

		logger.debug(fgLicenseInfosCount);

		return FoodGrainLicenseConstants.FOODGRAIN_LICENSE_SEARCH_JSP;
	}

	@Reference
	private UserLocationLocalService userLocationLocalService;

	@Reference
	FGLicenseInfoLocalService fgLicenseInfoLocalService;

	private Log logger = LogFactoryUtil.getLog(this.getClass());
}