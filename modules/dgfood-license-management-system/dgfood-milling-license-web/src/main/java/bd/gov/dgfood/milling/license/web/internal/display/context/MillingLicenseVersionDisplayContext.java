package bd.gov.dgfood.milling.license.web.internal.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.LinkedHashMap;
import java.util.List;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import bd.gov.dgfood.milling.license.web.internal.search.MillingLicenseVersionRequestHelper;
import bd.gov.dgfood.milling.license.web.internal.search.MillingLicenseVersionSearch;

public class MillingLicenseVersionDisplayContext {

	public MillingLicenseVersionDisplayContext(RenderRequest renderRequest, RenderResponse renderResponse) {

		_renderRequest = renderRequest;
		_renderResponse = renderResponse;
		_millingLicenseVersionRequestHelper = new MillingLicenseVersionRequestHelper(renderRequest);
	}

	public List<DropdownItem> getActionItemsDropdownItems() {
		return DropdownItemListBuilder.add(dropdownItem -> {
			dropdownItem.putData("action", "deleteQuestions");
			dropdownItem.setIcon("trash");
			dropdownItem.setLabel(LanguageUtil.get(_millingLicenseVersionRequestHelper.getRequest(), "delete"));
			dropdownItem.setQuickAction(true);
		}).build();
	}

	public String getDisplayStyle() {
		return "list";
	}

	protected String getKeywords() {

		return ParamUtil.getString(_renderRequest, "keywords");
	}

	public PortletURL getPortletURL() {
		PortletURL portletURL = _renderResponse.createRenderURL();
		String delta = ParamUtil.getString(_renderRequest, "delta");

		if (Validator.isNotNull(delta)) {
			portletURL.setParameter("delta", delta);
		}

		String displayStyle = getDisplayStyle();

		if (Validator.isNotNull(displayStyle)) {
			portletURL.setParameter("displayStyle", displayStyle);
		}

		String keywords = getKeywords();

		if (Validator.isNotNull(keywords)) {
			portletURL.setParameter("keywords", keywords);
		}

		return portletURL;
	}

	public int getTotalItems() {
		SearchContainer<?> searchContainer = getSearch();
		return searchContainer.getTotal();
	}

	public SearchContainer<?> getSearch() {
//		if(_millingLicenseVersionSearch != null) 
//		{
//			return _millingLicenseVersionSearch;
//		}
//		
//		PortletURL portletURL = getPortletURL();
//		portletURL.setParameter("displayStyle", getDisplayStyle());
//		
//		_millingLicenseVersionSearch = new MillingLicenseVersionSearch(_renderRequest, portletURL);
//		
//		_log.info(" is search ... " + _millingLicenseVersionSearch.isSearch());
//
//		_millingLicenseVersionSearch.setEmptyResultsMessage("there-are-no-entries");
//
//		_populateWithDatabase(_millingLicenseVersionSearch);
//		//_populateWithSearchIndex(_fgLicenseVersionSearch);
//
//		return _millingLicenseVersionSearch;
		return null;
	}

	private void _populateWithDatabase(MillingLicenseVersionSearch millingLicenseVersionSearch) {

		LinkedHashMap<String, Object> params = new LinkedHashMap<>();

		_log.info(" status " + ParamUtil.getLong(_renderRequest, "status", -1));
		_log.info(" fromDate " + ParamUtil.getDate(_renderRequest, "fromDate",
				DateFormatFactoryUtil.getSimpleDateFormat("dd/MM/yyyy"), null));
		_log.info(" toDate ... " + ParamUtil.getDate(_renderRequest, "toDate",
				DateFormatFactoryUtil.getSimpleDateFormat("dd/MM/yyyy"), null));
		_log.info(" getKeywords " + getKeywords());

		params.put("status", ParamUtil.getLong(_renderRequest, "status", -1));
		params.put("fromDate", ParamUtil.getDate(_renderRequest, "fromDate",
				DateFormatFactoryUtil.getSimpleDateFormat("dd/MM/yyyy"), null));
		params.put("toDate", ParamUtil.getDate(_renderRequest, "toDate",
				DateFormatFactoryUtil.getSimpleDateFormat("dd/MM/yyyy"), null));

//		millingLicenseVersionSearch.setResultsAndTotal(MillingLicenseVersionLocalServiceUtil.findByKeyWords(0, getKeywords(),
//				millingLicenseVersionSearch.getStart(), millingLicenseVersionSearch.getEnd(), params, null));
	}

	private void _populateWithSearchIndex(MillingLicenseVersionSearch millingLicenseVersionSearch) {

//		try {
//
//			_log.info("_populateWithSearchIndex ");
//			
//			List<MillingLicenseVersion> entriesResults = null;
//
//			Indexer<FGLicenseVersion> indexer = IndexerRegistryUtil.getIndexer(FGLicenseVersion.class);
//
//			HttpServletRequest httpServletRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(_renderRequest));
//
//			SearchContext searchContext = SearchContextFactory.getInstance(httpServletRequest);
//
//			_log.info(" getKeywords " + getKeywords());
//			searchContext.setKeywords(getKeywords());
//			searchContext.setStart(millingLicenseVersionSearch.getStart());
//			searchContext.setEnd(millingLicenseVersionSearch.getEnd());
//
//			Hits hits = indexer.search(searchContext);
//
//			_log.info("Hits - "+hits.getLength());
//			
//			List<SearchResult> searchResults =
//					SearchResultUtil.getSearchResults(
//							hits, LocaleUtil.getDefault());
//
//			Stream<SearchResult> stream = searchResults.stream();
//
//			entriesResults = stream.map(this::_toMillingLicenseVersionOptional)
//					.filter(Optional::isPresent)
//					.map(Optional::get)
//					.collect(Collectors.toList());
//
//			millingLicenseVersionSearch.setResultsAndTotal(entriesResults);
//			
//		} catch (SearchException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

//	private Optional<MillingLicenseVersion> _toMillingLicenseVersionOptional(
//			SearchResult searchResult) {
//		try {
//			return Optional.of(MillingLicenseVersionLocalServiceUtil.getMillingLicenseVersion(searchResult.getClassPK()));
//		}
//		catch (Exception exception) {
//			if (_log.isWarnEnabled()) {
//				_log.warn("FGLicenseVersion search index is stale and contains entry " +searchResult.getClassPK(), exception);
//			}
//			return Optional.empty();
//		}
//	}

	private static final Log _log = LogFactoryUtil.getLog(MillingLicenseVersionDisplayContext.class);

	private MillingLicenseVersionSearch _millingLicenseVersionSearch;
	private final MillingLicenseVersionRequestHelper _millingLicenseVersionRequestHelper;
	private final RenderRequest _renderRequest;
	private final RenderResponse _renderResponse;
}
