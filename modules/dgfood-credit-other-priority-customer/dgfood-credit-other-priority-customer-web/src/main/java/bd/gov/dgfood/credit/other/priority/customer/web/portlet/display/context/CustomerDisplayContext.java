package bd.gov.dgfood.credit.other.priority.customer.web.portlet.display.context;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

import bd.gov.dgfood.common.util.DateFormatterUtil;
import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer;
import bd.gov.dgfood.credit.other.priority.customer.service.SalesCustomerLocalServiceUtil;

public class CustomerDisplayContext {

	public CustomerDisplayContext(HttpServletRequest httpServletRequest, LiferayPortletRequest liferayPortletRequest,
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
		return portletURL;
	}

	public SearchContainer<SalesCustomer> getSearch(LinkedHashMap<String, Object> map) {

		List<SalesCustomer> customers = new ArrayList<>();

		ThemeDisplay themeDisplay = (ThemeDisplay) _renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String organizationName = ParamUtil.getString(_renderRequest, "organizationName");

		String keywords = ParamUtil.getString(_renderRequest, "keywords");

		int status = ParamUtil.getInteger(_renderRequest, "status", -1);
		Date fromDate = DateFormatterUtil.parseDate(ParamUtil.getString(_renderRequest, "startDate"));
		Date toDate = DateFormatterUtil.parseDate(ParamUtil.getString(_renderRequest, "endDate"));

		String userType = GetterUtil.getString(map.get("userType"));

		_log.debug("keywords ....... " + keywords);
		_log.debug("status ....... " + status);
		_log.debug("organizationName ....... " + organizationName);
		_log.debug("fromDate ....... " + fromDate);
		_log.debug("toDate ....... " + toDate);

		SearchContainer<SalesCustomer> searchContainer = new SearchContainer(_renderRequest, getPortletURL(), null,
				"there-are-no-sales-officeses");

		long startDate = 0;
		long endDate = 0;

		try {
			if (Validator.isNotNull(fromDate) && Validator.isNotNull(toDate)) {

				String fromDateStr = indexerDateFormat.format(fromDate);

				String toDateStr = indexerDateFormat.format(toDate);

				startDate = Long.valueOf(fromDateStr).longValue();
				endDate = Long.valueOf(toDateStr).longValue();

			}

			int total = 0;

			if (searchContainer.getStart() > 9999) {

				customers = SalesCustomerLocalServiceUtil.search(fromDate, toDate, status, userType, organizationName,
						searchContainer.getStart(), searchContainer.getEnd(), null);

				total = SalesCustomerLocalServiceUtil.searchCount(fromDate, toDate, status, userType, organizationName,
						searchContainer.getStart(), searchContainer.getEnd(), null);
			} else {

				Hits hits = SalesCustomerLocalServiceUtil.search(themeDisplay.getCompanyId(), startDate, endDate, status,
						userType, organizationName, searchContainer.getStart(), searchContainer.getEnd(), null);

				total = hits.getLength();
				for (Document document : hits.toList()) {
					long customerId = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

					try {
						SalesCustomer customer = SalesCustomerLocalServiceUtil.getSalesCustomer(customerId);

						customers.add(customer);
					} catch (Exception exception) {
						_log.error(exception + StringBundler.concat("Customer does not exist with PK : ", customerId));
						if (_log.isWarnEnabled()) {
							_log.warn(StringBundler.concat("Customer does not exist with PK : ", customerId));
						}
					}

				}

			}
			searchContainer.setResultsAndTotal(customers);

		} catch (NumberFormatException e) {
			_log.error(" NumberFormatException ..", e);

		} catch (PortalException e) {

			_log.error(" PortalException ..", e);
		} catch (Exception e) {

			_log.error(" Generic Exception ..", e);
		}

		return searchContainer;

	}

	private static SimpleDateFormat indexerDateFormat = new SimpleDateFormat(
			PropsUtil.get(PropsKeys.INDEX_DATE_FORMAT_PATTERN));

	private static final Log _log = LogFactoryUtil.getLog(CustomerDisplayContext.class);

	protected final LiferayPortletRequest _renderRequest;
	protected final LiferayPortletResponse _renderResponse;
	protected final HttpServletRequest request;
}
