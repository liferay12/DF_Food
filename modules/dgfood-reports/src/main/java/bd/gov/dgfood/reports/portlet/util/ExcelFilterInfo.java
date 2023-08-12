package bd.gov.dgfood.reports.portlet.util;

import java.util.Date;

public class ExcelFilterInfo {
	
	private String userType;
	
	private int start;
	
	private int end;
	
	private Date endDate;

	private Date startDate;

	private String organizationName;
	
	private String applicationNumber;
	
	private String toDate;
	
	private String fromDate;
	
	private String moduleSheetName;
	
	private String moduleName;
	
	private int status;
	
	private long grievanceCategory;
	
	private long grievanceUser;
	
	private boolean isAdmin;
	
	private long userId;
	
	public long getuserId() {
		return userId;
	}

	public void setuserId(long userId) {
		this.userId = userId;
	}

	public boolean getisAdmin() {
		return isAdmin;
	}

	public void setisAdmin(boolean userType) {
		this.isAdmin = isAdmin;
	}
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getModuleSheetName() {
		return moduleSheetName;
	}

	public void setModuleSheetName(String moduleSheetName) {
		this.moduleSheetName = moduleSheetName;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}
	
}
