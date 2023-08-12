package bd.gov.dgfood.milling.license.web.internal.search;

import java.util.ArrayList;
import java.util.List;

//public class MillingLicenseSearch extends SearchContainer<MillingLicense> {
public class MillingLicenseSearch  {

	public static final String EMPTY_RESULTS_MESSAGE = "no-entries-were-found";

	public static List<String> headerNames = new ArrayList<String>() {
		{
			add("applicantName");
			add("create-date");
		}
	};

//	public MillingLicenseSearch(PortletRequest portletRequest, PortletURL iteratorURL) {
//
//		super(portletRequest, new MillingLicenseDisplayTerms(portletRequest),
//				new MillingLicenseDisplayTerms(portletRequest), DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL,
//				headerNames, EMPTY_RESULTS_MESSAGE);
//	}

}
