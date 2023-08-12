package bd.gov.dgfood.food.friendly.program.web.internal.display.context;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.LinkedHashMap;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

import bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary;
import bd.gov.dgfood.food.friendly.program.service.FFPBeneficiaryLocalServiceUtil;

/**
 * Display context class which contains all the necessary methods to build a
 * search container
 * 
 * @author krishna
 * 
 */
public class FFPBDisplayContext {

	public FFPBDisplayContext(HttpServletRequest httpServletRequest, LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse) {

		_renderRequest = liferayPortletRequest;
		_renderResponse = liferayPortletResponse;
		request = httpServletRequest;

	}

	protected String getKeywords() {
		return ParamUtil.getString(_renderRequest, "keywords");
	}

	public String getDisplayStyle() {
		return "list";
	}

	public PortletURL getPortletURL() {
		PortletURL portletURL = _renderResponse.createRenderURL();

//		String delta = ParamUtil.getString(_renderRequest, "delta");
//
//		if (Validator.isNotNull(delta)) {
//			portletURL.setParameter("delta", delta);
//		}
//
//		String displayStyle = getDisplayStyle();
//
//		if (Validator.isNotNull(displayStyle)) {
//			portletURL.setParameter("displayStyle", displayStyle);
//		}
//
//		String keywords = getKeywords();
//
//		if (Validator.isNotNull(keywords)) {
//			portletURL.setParameter("keywords", keywords);
//		}

		return portletURL;
	}

	public int getTotalItems() {
		SearchContainer<?> searchContainer = getSearch();

		return searchContainer.getTotal();
	}

	public SearchContainer<?> getSearch() {

		LinkedHashMap<String, Object> params = new LinkedHashMap<>();

		params.put("cardNumber", ParamUtil.getString(_renderRequest, "cardNumber", null));
		params.put("nationalId", ParamUtil.getLong(_renderRequest, "nationalId"));
		params.put("status", ParamUtil.getInteger(_renderRequest, "status", -1));
		params.put("fromDate", ParamUtil.getDate(_renderRequest, "fromDate",
				DateFormatFactoryUtil.getSimpleDateFormat("dd/MM/yyyy"), null));
		params.put("toDate", ParamUtil.getDate(_renderRequest, "toDate",
				DateFormatFactoryUtil.getSimpleDateFormat("dd/MM/yyyy"), null));

		SearchContainer<FFPBeneficiary> searchContainer = new SearchContainer(_renderRequest,
				_renderResponse.createRenderURL(), null, "there-are-no-sales-officeses");

		searchContainer.setResultsAndTotal(FFPBeneficiaryLocalServiceUtil.findByKeyWords(0, getKeywords(),
				searchContainer.getStart(), searchContainer.getEnd(), params, null));

		return searchContainer;
	}

	private static final Log _log = LogFactoryUtil.getLog(FFPBDisplayContext.class);

	private SearchContainer<FFPBeneficiary> _searchContainer;
	protected final LiferayPortletRequest _renderRequest;
	protected final LiferayPortletResponse _renderResponse;
	protected final HttpServletRequest request;
}
