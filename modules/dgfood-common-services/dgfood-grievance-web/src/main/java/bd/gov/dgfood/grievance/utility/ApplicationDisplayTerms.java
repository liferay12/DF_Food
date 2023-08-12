package bd.gov.dgfood.grievance.utility;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletRequest;

import bd.gov.dgfood.common.util.constants.ParameterConstants;

public class ApplicationDisplayTerms extends DisplayTerms {
	
	private boolean all;
	
	private String fromDate;
	private String toDate;
	
	private int delta;
	
	private int status;
	private long grievanceCategory;
	private long grievanceUser;
	
	private long userID;
	/**
	 * This Constructor is used for intializing the class variables
	 */
	public ApplicationDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		status = ParamUtil.getInteger(portletRequest, ParameterConstants.STATUS);
		grievanceCategory = ParamUtil.getLong(portletRequest, ParameterConstants.GRIEVANCE_CATEGORY);
		grievanceUser = ParamUtil.getLong(portletRequest, ParameterConstants.GRIEVANCE_USER);
		all = ParamUtil.getBoolean(portletRequest, ParameterConstants.ALL);
		fromDate = ParamUtil.getString(portletRequest, ParameterConstants.FROM_DATE);
		toDate = ParamUtil.getString(portletRequest, ParameterConstants.TO_DATE);
		delta  = ParamUtil.getInteger(portletRequest, ParameterConstants.DELTA);
		userID = ParamUtil.getInteger(portletRequest, ParameterConstants.USER_ID);
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getGrievanceCategory() {
		return grievanceCategory;
	}

	public void setGrievanceCategory(long grievanceCategory) {
		this.grievanceCategory = grievanceCategory;
	}

	public long getGrievanceUser() {
		return grievanceUser;
	}

	public void setGrievanceUser(long grievanceUser) {
		this.grievanceUser = grievanceUser;
	}

	public boolean isAll() {
		return all;
	}

	public void setAll(boolean all) {
		this.all = all;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public int getDelta() {
		return delta;
	}

	public void setDelta(int delta) {
		this.delta = delta;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

}