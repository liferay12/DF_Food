package bd.gov.dgfood.grievance.utility;

import com.liferay.portal.kernel.dao.search.SearchContainer;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import bd.gov.dgfood.common.services.model.Grievance;
import bd.gov.dgfood.common.util.constants.CommonConstants;
import bd.gov.dgfood.common.util.constants.ParameterConstants;

public class ApplicationSearchContainer extends SearchContainer<Grievance> {
	public static final String EMPTY_RESULTS_MESSAGE = CommonConstants.NO_RECORD_FOUND;
	
	static List<String> headerNames = new ArrayList<String>();
	
	/**
	 * This static block is used for initializing the class variables 
	 */
	static {
		headerNames.add(ParameterConstants.STATUS);
		headerNames.add(ParameterConstants.GRIEVANCE_CATEGORY);
		headerNames.add(ParameterConstants.GRIEVANCE_USER);
		
		headerNames.add(ParameterConstants.FROM_DATE);
		headerNames.add(ParameterConstants.TO_DATE);
		
		headerNames.add(ParameterConstants.ALL);
		
		headerNames.add(ParameterConstants.DELTA);
		
		headerNames.add(ParameterConstants.USER_ID);
	}
	
	/**
	 * This Constructor is used for intializing the class variables
	 * @param iteratorURL
	 */
	public ApplicationSearchContainer(PortletRequest portletRequest, PortletURL iteratorURL) {
		super(portletRequest, new ApplicationDisplayTerms(portletRequest), new ApplicationDisplayTerms(portletRequest),
				DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headerNames, CommonConstants.NO_RECORD_FOUND);
		
		ApplicationDisplayTerms displayTerms = (ApplicationDisplayTerms) getDisplayTerms();
		
		this.setDelta(displayTerms.getDelta());

		iteratorURL.getRenderParameters().setValue(ParameterConstants.STATUS, String.valueOf(displayTerms.getStatus()));
		
		iteratorURL.getRenderParameters().setValue(ParameterConstants.GRIEVANCE_CATEGORY, String.valueOf(displayTerms.getGrievanceCategory()));
		iteratorURL.getRenderParameters().setValue(ParameterConstants.GRIEVANCE_USER, String.valueOf(displayTerms.getGrievanceUser()));
		
		iteratorURL.getRenderParameters().setValue(ParameterConstants.ALL, String.valueOf(displayTerms.isAll()));
		
		iteratorURL.getRenderParameters().setValue(ParameterConstants.FROM_DATE, displayTerms.getFromDate());
		iteratorURL.getRenderParameters().setValue(ParameterConstants.TO_DATE, displayTerms.getToDate());
		
		iteratorURL.getRenderParameters().setValue(ParameterConstants.DELTA, String.valueOf(displayTerms.getDelta()));
		iteratorURL.getRenderParameters().setValue(ParameterConstants.USER_ID, String.valueOf(displayTerms.getUserID()));
		
	}
}


