package bd.gov.dgfood.milling.license.web.internal.search;

import java.util.ArrayList;
import java.util.List;

//public class MillingLicenseVersionSearch extends SearchContainer<MillingLicenseVersion> {
public class MillingLicenseVersionSearch  {

	public static final String EMPTY_RESULTS_MESSAGE = "no-entries-were-found";

	public static List<String> headerNames = new ArrayList<String>() {
		{
			add("applicantName");
			add("create-date");
		}
	};

//	public MillingLicenseVersionSearch(PortletRequest portletRequest, PortletURL iteratorURL) {
//
//		super(portletRequest, new MillingLicenseVersionDisplayTerms(portletRequest),
//				new MillingLicenseVersionDisplayTerms(portletRequest), DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL,
//				headerNames, EMPTY_RESULTS_MESSAGE);
//	}

}
