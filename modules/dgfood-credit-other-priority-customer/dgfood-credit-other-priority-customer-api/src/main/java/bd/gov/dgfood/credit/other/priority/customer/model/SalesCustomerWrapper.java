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

package bd.gov.dgfood.credit.other.priority.customer.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SalesCustomer}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SalesCustomer
 * @generated
 */
public class SalesCustomerWrapper
	extends BaseModelWrapper<SalesCustomer>
	implements ModelWrapper<SalesCustomer>, SalesCustomer {

	public SalesCustomerWrapper(SalesCustomer salesCustomer) {
		super(salesCustomer);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("salesCustomerId", getSalesCustomerId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("userType", getUserType());
		attributes.put("mobileNumber", getMobileNumber());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("title", getTitle());
		attributes.put("contactPersonName", getContactPersonName());
		attributes.put(
			"contactPersonDesignation", getContactPersonDesignation());
		attributes.put("officeName", getOfficeName());
		attributes.put("organizationName", getOrganizationName());
		attributes.put("organizationType", getOrganizationType());
		attributes.put("gender", getGender());
		attributes.put("salesCustomerCode", getSalesCustomerCode());
		attributes.put("version", getVersion());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long salesCustomerId = (Long)attributes.get("salesCustomerId");

		if (salesCustomerId != null) {
			setSalesCustomerId(salesCustomerId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userType = (String)attributes.get("userType");

		if (userType != null) {
			setUserType(userType);
		}

		String mobileNumber = (String)attributes.get("mobileNumber");

		if (mobileNumber != null) {
			setMobileNumber(mobileNumber);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String contactPersonName = (String)attributes.get("contactPersonName");

		if (contactPersonName != null) {
			setContactPersonName(contactPersonName);
		}

		String contactPersonDesignation = (String)attributes.get(
			"contactPersonDesignation");

		if (contactPersonDesignation != null) {
			setContactPersonDesignation(contactPersonDesignation);
		}

		String officeName = (String)attributes.get("officeName");

		if (officeName != null) {
			setOfficeName(officeName);
		}

		String organizationName = (String)attributes.get("organizationName");

		if (organizationName != null) {
			setOrganizationName(organizationName);
		}

		String organizationType = (String)attributes.get("organizationType");

		if (organizationType != null) {
			setOrganizationType(organizationType);
		}

		Integer gender = (Integer)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		Long salesCustomerCode = (Long)attributes.get("salesCustomerCode");

		if (salesCustomerCode != null) {
			setSalesCustomerCode(salesCustomerCode);
		}

		Double version = (Double)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	@Override
	public SalesCustomer cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this sales customer.
	 *
	 * @return the company ID of this sales customer
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the contact person designation of this sales customer.
	 *
	 * @return the contact person designation of this sales customer
	 */
	@Override
	public String getContactPersonDesignation() {
		return model.getContactPersonDesignation();
	}

	/**
	 * Returns the contact person name of this sales customer.
	 *
	 * @return the contact person name of this sales customer
	 */
	@Override
	public String getContactPersonName() {
		return model.getContactPersonName();
	}

	/**
	 * Returns the create date of this sales customer.
	 *
	 * @return the create date of this sales customer
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this sales customer.
	 *
	 * @return the created by of this sales customer
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the email address of this sales customer.
	 *
	 * @return the email address of this sales customer
	 */
	@Override
	public String getEmailAddress() {
		return model.getEmailAddress();
	}

	/**
	 * Returns the gender of this sales customer.
	 *
	 * @return the gender of this sales customer
	 */
	@Override
	public int getGender() {
		return model.getGender();
	}

	/**
	 * Returns the group ID of this sales customer.
	 *
	 * @return the group ID of this sales customer
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the mobile number of this sales customer.
	 *
	 * @return the mobile number of this sales customer
	 */
	@Override
	public String getMobileNumber() {
		return model.getMobileNumber();
	}

	/**
	 * Returns the modified by of this sales customer.
	 *
	 * @return the modified by of this sales customer
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this sales customer.
	 *
	 * @return the modified date of this sales customer
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the office name of this sales customer.
	 *
	 * @return the office name of this sales customer
	 */
	@Override
	public String getOfficeName() {
		return model.getOfficeName();
	}

	/**
	 * Returns the organization name of this sales customer.
	 *
	 * @return the organization name of this sales customer
	 */
	@Override
	public String getOrganizationName() {
		return model.getOrganizationName();
	}

	/**
	 * Returns the organization type of this sales customer.
	 *
	 * @return the organization type of this sales customer
	 */
	@Override
	public String getOrganizationType() {
		return model.getOrganizationType();
	}

	/**
	 * Returns the primary key of this sales customer.
	 *
	 * @return the primary key of this sales customer
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sales customer code of this sales customer.
	 *
	 * @return the sales customer code of this sales customer
	 */
	@Override
	public long getSalesCustomerCode() {
		return model.getSalesCustomerCode();
	}

	/**
	 * Returns the sales customer ID of this sales customer.
	 *
	 * @return the sales customer ID of this sales customer
	 */
	@Override
	public long getSalesCustomerId() {
		return model.getSalesCustomerId();
	}

	/**
	 * Returns the status of this sales customer.
	 *
	 * @return the status of this sales customer
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this sales customer.
	 *
	 * @return the status by user ID of this sales customer
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this sales customer.
	 *
	 * @return the status by user name of this sales customer
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this sales customer.
	 *
	 * @return the status by user uuid of this sales customer
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this sales customer.
	 *
	 * @return the status date of this sales customer
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the title of this sales customer.
	 *
	 * @return the title of this sales customer
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this sales customer.
	 *
	 * @return the user ID of this sales customer
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user type of this sales customer.
	 *
	 * @return the user type of this sales customer
	 */
	@Override
	public String getUserType() {
		return model.getUserType();
	}

	/**
	 * Returns the user uuid of this sales customer.
	 *
	 * @return the user uuid of this sales customer
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this sales customer.
	 *
	 * @return the uuid of this sales customer
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the version of this sales customer.
	 *
	 * @return the version of this sales customer
	 */
	@Override
	public double getVersion() {
		return model.getVersion();
	}

	/**
	 * Returns <code>true</code> if this sales customer is approved.
	 *
	 * @return <code>true</code> if this sales customer is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this sales customer is denied.
	 *
	 * @return <code>true</code> if this sales customer is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this sales customer is a draft.
	 *
	 * @return <code>true</code> if this sales customer is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this sales customer is expired.
	 *
	 * @return <code>true</code> if this sales customer is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this sales customer is inactive.
	 *
	 * @return <code>true</code> if this sales customer is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this sales customer is incomplete.
	 *
	 * @return <code>true</code> if this sales customer is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this sales customer is pending.
	 *
	 * @return <code>true</code> if this sales customer is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this sales customer is scheduled.
	 *
	 * @return <code>true</code> if this sales customer is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this sales customer.
	 *
	 * @param companyId the company ID of this sales customer
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the contact person designation of this sales customer.
	 *
	 * @param contactPersonDesignation the contact person designation of this sales customer
	 */
	@Override
	public void setContactPersonDesignation(String contactPersonDesignation) {
		model.setContactPersonDesignation(contactPersonDesignation);
	}

	/**
	 * Sets the contact person name of this sales customer.
	 *
	 * @param contactPersonName the contact person name of this sales customer
	 */
	@Override
	public void setContactPersonName(String contactPersonName) {
		model.setContactPersonName(contactPersonName);
	}

	/**
	 * Sets the create date of this sales customer.
	 *
	 * @param createDate the create date of this sales customer
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this sales customer.
	 *
	 * @param createdBy the created by of this sales customer
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the email address of this sales customer.
	 *
	 * @param emailAddress the email address of this sales customer
	 */
	@Override
	public void setEmailAddress(String emailAddress) {
		model.setEmailAddress(emailAddress);
	}

	/**
	 * Sets the gender of this sales customer.
	 *
	 * @param gender the gender of this sales customer
	 */
	@Override
	public void setGender(int gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the group ID of this sales customer.
	 *
	 * @param groupId the group ID of this sales customer
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the mobile number of this sales customer.
	 *
	 * @param mobileNumber the mobile number of this sales customer
	 */
	@Override
	public void setMobileNumber(String mobileNumber) {
		model.setMobileNumber(mobileNumber);
	}

	/**
	 * Sets the modified by of this sales customer.
	 *
	 * @param modifiedBy the modified by of this sales customer
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this sales customer.
	 *
	 * @param modifiedDate the modified date of this sales customer
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the office name of this sales customer.
	 *
	 * @param officeName the office name of this sales customer
	 */
	@Override
	public void setOfficeName(String officeName) {
		model.setOfficeName(officeName);
	}

	/**
	 * Sets the organization name of this sales customer.
	 *
	 * @param organizationName the organization name of this sales customer
	 */
	@Override
	public void setOrganizationName(String organizationName) {
		model.setOrganizationName(organizationName);
	}

	/**
	 * Sets the organization type of this sales customer.
	 *
	 * @param organizationType the organization type of this sales customer
	 */
	@Override
	public void setOrganizationType(String organizationType) {
		model.setOrganizationType(organizationType);
	}

	/**
	 * Sets the primary key of this sales customer.
	 *
	 * @param primaryKey the primary key of this sales customer
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sales customer code of this sales customer.
	 *
	 * @param salesCustomerCode the sales customer code of this sales customer
	 */
	@Override
	public void setSalesCustomerCode(long salesCustomerCode) {
		model.setSalesCustomerCode(salesCustomerCode);
	}

	/**
	 * Sets the sales customer ID of this sales customer.
	 *
	 * @param salesCustomerId the sales customer ID of this sales customer
	 */
	@Override
	public void setSalesCustomerId(long salesCustomerId) {
		model.setSalesCustomerId(salesCustomerId);
	}

	/**
	 * Sets the status of this sales customer.
	 *
	 * @param status the status of this sales customer
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this sales customer.
	 *
	 * @param statusByUserId the status by user ID of this sales customer
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this sales customer.
	 *
	 * @param statusByUserName the status by user name of this sales customer
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this sales customer.
	 *
	 * @param statusByUserUuid the status by user uuid of this sales customer
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this sales customer.
	 *
	 * @param statusDate the status date of this sales customer
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the title of this sales customer.
	 *
	 * @param title the title of this sales customer
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this sales customer.
	 *
	 * @param userId the user ID of this sales customer
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user type of this sales customer.
	 *
	 * @param userType the user type of this sales customer
	 */
	@Override
	public void setUserType(String userType) {
		model.setUserType(userType);
	}

	/**
	 * Sets the user uuid of this sales customer.
	 *
	 * @param userUuid the user uuid of this sales customer
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this sales customer.
	 *
	 * @param uuid the uuid of this sales customer
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the version of this sales customer.
	 *
	 * @param version the version of this sales customer
	 */
	@Override
	public void setVersion(double version) {
		model.setVersion(version);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected SalesCustomerWrapper wrap(SalesCustomer salesCustomer) {
		return new SalesCustomerWrapper(salesCustomer);
	}

}