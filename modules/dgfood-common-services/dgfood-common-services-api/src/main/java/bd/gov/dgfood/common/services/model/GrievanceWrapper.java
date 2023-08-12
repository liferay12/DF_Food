/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package bd.gov.dgfood.common.services.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Grievance}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Grievance
 * @generated
 */
public class GrievanceWrapper
	extends BaseModelWrapper<Grievance>
	implements Grievance, ModelWrapper<Grievance> {

	public GrievanceWrapper(Grievance grievance) {
		super(grievance);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("grievanceId", getGrievanceId());
		attributes.put("grievanceNumber", getGrievanceNumber());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("grievanceCategory", getGrievanceCategory());
		attributes.put("userType", getUserType());
		attributes.put("userName", getUserName());
		attributes.put("userID", getUserID());
		attributes.put("mobileNumber", getMobileNumber());
		attributes.put("createDate", getCreateDate());
		attributes.put("complaintDetails", getComplaintDetails());
		attributes.put("attachmentId", getAttachmentId());
		attributes.put("status", getStatus());
		attributes.put("responseDetails", getResponseDetails());
		attributes.put("responseDate", getResponseDate());
		attributes.put("responseBy", getResponseBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long grievanceId = (Long)attributes.get("grievanceId");

		if (grievanceId != null) {
			setGrievanceId(grievanceId);
		}

		String grievanceNumber = (String)attributes.get("grievanceNumber");

		if (grievanceNumber != null) {
			setGrievanceNumber(grievanceNumber);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long grievanceCategory = (Long)attributes.get("grievanceCategory");

		if (grievanceCategory != null) {
			setGrievanceCategory(grievanceCategory);
		}

		Long userType = (Long)attributes.get("userType");

		if (userType != null) {
			setUserType(userType);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Long userID = (Long)attributes.get("userID");

		if (userID != null) {
			setUserID(userID);
		}

		String mobileNumber = (String)attributes.get("mobileNumber");

		if (mobileNumber != null) {
			setMobileNumber(mobileNumber);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String complaintDetails = (String)attributes.get("complaintDetails");

		if (complaintDetails != null) {
			setComplaintDetails(complaintDetails);
		}

		Long attachmentId = (Long)attributes.get("attachmentId");

		if (attachmentId != null) {
			setAttachmentId(attachmentId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String responseDetails = (String)attributes.get("responseDetails");

		if (responseDetails != null) {
			setResponseDetails(responseDetails);
		}

		Date responseDate = (Date)attributes.get("responseDate");

		if (responseDate != null) {
			setResponseDate(responseDate);
		}

		Long responseBy = (Long)attributes.get("responseBy");

		if (responseBy != null) {
			setResponseBy(responseBy);
		}
	}

	@Override
	public Grievance cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the attachment ID of this grievance.
	 *
	 * @return the attachment ID of this grievance
	 */
	@Override
	public long getAttachmentId() {
		return model.getAttachmentId();
	}

	/**
	 * Returns the company ID of this grievance.
	 *
	 * @return the company ID of this grievance
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the complaint details of this grievance.
	 *
	 * @return the complaint details of this grievance
	 */
	@Override
	public String getComplaintDetails() {
		return model.getComplaintDetails();
	}

	/**
	 * Returns the create date of this grievance.
	 *
	 * @return the create date of this grievance
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the grievance category of this grievance.
	 *
	 * @return the grievance category of this grievance
	 */
	@Override
	public long getGrievanceCategory() {
		return model.getGrievanceCategory();
	}

	/**
	 * Returns the grievance ID of this grievance.
	 *
	 * @return the grievance ID of this grievance
	 */
	@Override
	public long getGrievanceId() {
		return model.getGrievanceId();
	}

	/**
	 * Returns the grievance number of this grievance.
	 *
	 * @return the grievance number of this grievance
	 */
	@Override
	public String getGrievanceNumber() {
		return model.getGrievanceNumber();
	}

	/**
	 * Returns the group ID of this grievance.
	 *
	 * @return the group ID of this grievance
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the mobile number of this grievance.
	 *
	 * @return the mobile number of this grievance
	 */
	@Override
	public String getMobileNumber() {
		return model.getMobileNumber();
	}

	/**
	 * Returns the primary key of this grievance.
	 *
	 * @return the primary key of this grievance
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the response by of this grievance.
	 *
	 * @return the response by of this grievance
	 */
	@Override
	public long getResponseBy() {
		return model.getResponseBy();
	}

	/**
	 * Returns the response date of this grievance.
	 *
	 * @return the response date of this grievance
	 */
	@Override
	public Date getResponseDate() {
		return model.getResponseDate();
	}

	/**
	 * Returns the response details of this grievance.
	 *
	 * @return the response details of this grievance
	 */
	@Override
	public String getResponseDetails() {
		return model.getResponseDetails();
	}

	/**
	 * Returns the status of this grievance.
	 *
	 * @return the status of this grievance
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this grievance.
	 *
	 * @return the user ID of this grievance
	 */
	@Override
	public long getUserID() {
		return model.getUserID();
	}

	/**
	 * Returns the user name of this grievance.
	 *
	 * @return the user name of this grievance
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user type of this grievance.
	 *
	 * @return the user type of this grievance
	 */
	@Override
	public long getUserType() {
		return model.getUserType();
	}

	/**
	 * Returns the uuid of this grievance.
	 *
	 * @return the uuid of this grievance
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the attachment ID of this grievance.
	 *
	 * @param attachmentId the attachment ID of this grievance
	 */
	@Override
	public void setAttachmentId(long attachmentId) {
		model.setAttachmentId(attachmentId);
	}

	/**
	 * Sets the company ID of this grievance.
	 *
	 * @param companyId the company ID of this grievance
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the complaint details of this grievance.
	 *
	 * @param complaintDetails the complaint details of this grievance
	 */
	@Override
	public void setComplaintDetails(String complaintDetails) {
		model.setComplaintDetails(complaintDetails);
	}

	/**
	 * Sets the create date of this grievance.
	 *
	 * @param createDate the create date of this grievance
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the grievance category of this grievance.
	 *
	 * @param grievanceCategory the grievance category of this grievance
	 */
	@Override
	public void setGrievanceCategory(long grievanceCategory) {
		model.setGrievanceCategory(grievanceCategory);
	}

	/**
	 * Sets the grievance ID of this grievance.
	 *
	 * @param grievanceId the grievance ID of this grievance
	 */
	@Override
	public void setGrievanceId(long grievanceId) {
		model.setGrievanceId(grievanceId);
	}

	/**
	 * Sets the grievance number of this grievance.
	 *
	 * @param grievanceNumber the grievance number of this grievance
	 */
	@Override
	public void setGrievanceNumber(String grievanceNumber) {
		model.setGrievanceNumber(grievanceNumber);
	}

	/**
	 * Sets the group ID of this grievance.
	 *
	 * @param groupId the group ID of this grievance
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the mobile number of this grievance.
	 *
	 * @param mobileNumber the mobile number of this grievance
	 */
	@Override
	public void setMobileNumber(String mobileNumber) {
		model.setMobileNumber(mobileNumber);
	}

	/**
	 * Sets the primary key of this grievance.
	 *
	 * @param primaryKey the primary key of this grievance
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the response by of this grievance.
	 *
	 * @param responseBy the response by of this grievance
	 */
	@Override
	public void setResponseBy(long responseBy) {
		model.setResponseBy(responseBy);
	}

	/**
	 * Sets the response date of this grievance.
	 *
	 * @param responseDate the response date of this grievance
	 */
	@Override
	public void setResponseDate(Date responseDate) {
		model.setResponseDate(responseDate);
	}

	/**
	 * Sets the response details of this grievance.
	 *
	 * @param responseDetails the response details of this grievance
	 */
	@Override
	public void setResponseDetails(String responseDetails) {
		model.setResponseDetails(responseDetails);
	}

	/**
	 * Sets the status of this grievance.
	 *
	 * @param status the status of this grievance
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this grievance.
	 *
	 * @param userID the user ID of this grievance
	 */
	@Override
	public void setUserID(long userID) {
		model.setUserID(userID);
	}

	/**
	 * Sets the user name of this grievance.
	 *
	 * @param userName the user name of this grievance
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user type of this grievance.
	 *
	 * @param userType the user type of this grievance
	 */
	@Override
	public void setUserType(long userType) {
		model.setUserType(userType);
	}

	/**
	 * Sets the uuid of this grievance.
	 *
	 * @param uuid the uuid of this grievance
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected GrievanceWrapper wrap(Grievance grievance) {
		return new GrievanceWrapper(grievance);
	}

}