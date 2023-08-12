package bd.gov.dgfood.milling.license.web.internal.display.context;

import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

public class MillingLicenseDisplayContext {

	public MillingLicenseDisplayContext(HttpServletRequest httpServletRequest, LiferayPortletRequest liferayPortletRequest,
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

//	public int getTotalItems() {
//		SearchContainer<?> searchContainer = getSearch();
//
//		return searchContainer.getTotal();
//	}

//	public SearchContainer<?> getSearch() {
//
//		SearchContainer<MillingLicense> searchContainer = new SearchContainer(_renderRequest,
//				_renderResponse.createRenderURL(), null, "there-are-no-sales-officeses");
//
//		return populateWithDynamicQuery(searchContainer);
//		//return populateWithSearchIndexer(searchContainer);
//	}
//
//	private SearchContainer<MillingLicense> populateWithDynamicQuery(SearchContainer<MillingLicense> searchContainer) {
//
//		LinkedHashMap<String, Object> params = new LinkedHashMap<>();
//		_log.info("Status - "+ParamUtil.getLong(_renderRequest, "status", -1));
//		int status = ParamUtil.getInteger(_renderRequest, "status", -1);
//		String fromDate = ParamUtil.getString(_renderRequest, "fromDate");
//		String toDate = ParamUtil.getString(_renderRequest, "toDate");
//		
//		params.put("status", status);
//		params.put("fromDate", DateFormatterUtil.parseDate(fromDate));
//		params.put("toDate", DateFormatterUtil.parseDate(toDate));
//
//		searchContainer.setResultsAndTotal(MillingLicenseLocalServiceUtil.findByKeyWords(0, getKeywords(),
//				searchContainer.getStart(), searchContainer.getEnd(), params, null));
//
//		_renderRequest.setAttribute("keywords", getKeywords());
//		_renderRequest.setAttribute("status", status);
//		_renderRequest.setAttribute("fromDate", fromDate);
//		_renderRequest.setAttribute("toDate", toDate);
//		_renderRequest.setAttribute("listSize", searchContainer.getTotal());
//		
//		return searchContainer;
//	}
//	
//	private SearchContainer<MillingLicense> populateWithSearchIndexer(SearchContainer<MillingLicense> searchContainer) {
//
//		try {
//
//			_log.info("_populateWithSearchIndex ");
//			
//			HttpServletRequest httpServletRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(_renderRequest));
//			SearchContext searchContext = SearchContextFactory.getInstance(httpServletRequest);
//			
//			searchContext.setAndSearch(false);
//			searchContext.setCompanyId(PortalUtil.getCompanyId(_renderRequest));
//			searchContext.setGroupIds(new long[] { -1L });
//			searchContext.setKeywords(getKeywords());
//			searchContext.setStart(searchContainer.getStart());
//			searchContext.setEnd(searchContainer.getEnd());
//			
//			QueryConfig queryConfig = searchContext.getQueryConfig();
//			queryConfig.setHighlightEnabled(false);
//			queryConfig.setScoreEnabled(false);
//			
//			Indexer<MillingLicense> indexer = IndexerRegistryUtil.getIndexer(MillingLicense.class);
//			
//			Hits hits = indexer.search(searchContext);
//			_log.info("Hits Length - "+hits.getLength());
//			List<Document> documents = hits.toList();
//			List<MillingLicense> entriesResults = new ArrayList<>(documents.size());
//			
//			List<SearchResult> searchResults =
//					SearchResultUtil.getSearchResults(
//							hits, LocaleUtil.getDefault());
//
//			Stream<SearchResult> stream = searchResults.stream();
//
//			entriesResults = stream.map(this::_toMillingLicenseOptional)
//					.filter(Optional::isPresent)
//					.map(Optional::get)
//					.collect(Collectors.toList());
//
//			searchContainer.setResultsAndTotal(entriesResults);
//		} catch (SearchException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return searchContainer;
//	}
//
//	private Optional<MillingLicense> _toMillingLicenseOptional(
//			SearchResult searchResult) {
//		try {
//			return Optional.of(MillingLicenseLocalServiceUtil.getMillingLicense(searchResult.getClassPK()));
//		}
//		catch (Exception exception) {
//			if (_log.isWarnEnabled()) {
//				_log.warn("Milling License search index is stale and contains entry " +searchResult.getClassPK(), exception);
//			}
//			return Optional.empty();
//		}
//	}
//
//	private static final Log _log = LogFactoryUtil.getLog(MillingLicenseDisplayContext.class);
//
//	private SearchContainer<MillingLicense> _searchContainer;
	protected final LiferayPortletRequest _renderRequest;
	protected final LiferayPortletResponse _renderResponse;
	protected final HttpServletRequest request;
}
