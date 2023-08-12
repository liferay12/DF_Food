package bd.gov.dgfood.farmer.information.management.system.web.display.context;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

import bd.gov.dgfood.common.util.constants.ParameterConstants;
import bd.gov.dgfood.farmer.information.management.system.model.FarmerRegistration;
import bd.gov.dgfood.farmer.information.management.system.web.constants.FarmerInformationManagementSystemConstants;
import bd.gov.dgfood.farmer.information.management.system.web.util.FarmerManagementWebUtil;

public class FarmerRegistrationDisplayContext {

	public FarmerRegistrationDisplayContext(HttpServletRequest httpServletRequest,
			LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse) {

		_renderRequest = liferayPortletRequest;
		_renderResponse = liferayPortletResponse;
		request = httpServletRequest;

	}

	protected String getKeywords() {
		return ParamUtil.getString(_renderRequest, ParameterConstants.APPLICATION_NUMBER);
	}

	public String getDisplayStyle() {
		return "list";
	}

	public PortletURL getPortletURL() {
		PortletURL portletURL = _renderResponse.createRenderURL();
		return portletURL;
	}

	public int getTotalItems() {
		SearchContainer<?> searchContainer = getSearch();
		return searchContainer.getTotal();
	}

	public SearchContainer<?> getSearch() {

		SearchContainer<FarmerRegistration> searchContainer = new SearchContainer(_renderRequest,
				_renderResponse.createRenderURL(), null, "label-no-applications-found");

		return fetchApplicationsWithDyanamicQuery(searchContainer);
	}

	private SearchContainer<FarmerRegistration> fetchApplicationsWithDyanamicQuery(
			SearchContainer<FarmerRegistration> searchContainer) {

		int delta = ParamUtil.getInteger(_renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,
				FarmerInformationManagementSystemConstants.FARMER_REGISTRATION_DELTA);
		FarmerManagementWebUtil.fetchFarmerRegistrationApplications(_renderRequest);

		searchContainer.setResultsAndTotal((List<FarmerRegistration>) _renderRequest
				.getAttribute(FarmerInformationManagementSystemConstants.FARMER_REGISTRATION_APPLICATIONS_LIST));
		searchContainer.setDelta(delta);
		

		logger.debug(searchContainer.getTotal());
		logger.debug(searchContainer.getResults());
		
		return searchContainer;
	}

	private final Log logger = LogFactoryUtil.getLog(this.getClass());

	protected final LiferayPortletRequest _renderRequest;
	protected final LiferayPortletResponse _renderResponse;
	protected final HttpServletRequest request;
}
