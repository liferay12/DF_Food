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

package bd.gov.dgfood.farmer.information.management.system.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FarmerRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FarmerRegistration
 * @generated
 */
public class FarmerRegistrationWrapper
	extends BaseModelWrapper<FarmerRegistration>
	implements FarmerRegistration, ModelWrapper<FarmerRegistration> {

	public FarmerRegistrationWrapper(FarmerRegistration farmerRegistration) {
		super(farmerRegistration);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("farmerRegistrationId", getFarmerRegistrationId());
		attributes.put("applicationNumber", getApplicationNumber());
		attributes.put("nationalId", getNationalId());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("mobileNumber", getMobileNumber());
		attributes.put("dateOfBirth", getDateOfBirth());
		attributes.put("farmerName", getFarmerName());
		attributes.put("fatherName", getFatherName());
		attributes.put("motherName", getMotherName());
		attributes.put("gender", getGender());
		attributes.put("maritalStatus", getMaritalStatus());
		attributes.put("krishokCardNumber", getKrishokCardNumber());
		attributes.put("cultivableLandSeason1", getCultivableLandSeason1());
		attributes.put("cultivableLandSeason2", getCultivableLandSeason2());
		attributes.put("cultivableLandSeason3", getCultivableLandSeason3());
		attributes.put("farmerCategory ", getFarmerCategory());
		attributes.put("password ", getPassword());
		attributes.put("remarks", getRemarks());
		attributes.put("businessCode", getBusinessCode());
		attributes.put("version", getVersion());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
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

		Long farmerRegistrationId = (Long)attributes.get(
			"farmerRegistrationId");

		if (farmerRegistrationId != null) {
			setFarmerRegistrationId(farmerRegistrationId);
		}

		String applicationNumber = (String)attributes.get("applicationNumber");

		if (applicationNumber != null) {
			setApplicationNumber(applicationNumber);
		}

		String nationalId = (String)attributes.get("nationalId");

		if (nationalId != null) {
			setNationalId(nationalId);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String mobileNumber = (String)attributes.get("mobileNumber");

		if (mobileNumber != null) {
			setMobileNumber(mobileNumber);
		}

		Date dateOfBirth = (Date)attributes.get("dateOfBirth");

		if (dateOfBirth != null) {
			setDateOfBirth(dateOfBirth);
		}

		String farmerName = (String)attributes.get("farmerName");

		if (farmerName != null) {
			setFarmerName(farmerName);
		}

		String fatherName = (String)attributes.get("fatherName");

		if (fatherName != null) {
			setFatherName(fatherName);
		}

		String motherName = (String)attributes.get("motherName");

		if (motherName != null) {
			setMotherName(motherName);
		}

		Integer gender = (Integer)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		Integer maritalStatus = (Integer)attributes.get("maritalStatus");

		if (maritalStatus != null) {
			setMaritalStatus(maritalStatus);
		}

		String krishokCardNumber = (String)attributes.get("krishokCardNumber");

		if (krishokCardNumber != null) {
			setKrishokCardNumber(krishokCardNumber);
		}

		Map<String, Serializable> cultivableLandSeason1 =
			(Map<String, Serializable>)attributes.get("cultivableLandSeason1");

		if (cultivableLandSeason1 != null) {
			setCultivableLandSeason1(cultivableLandSeason1);
		}

		Map<String, Serializable> cultivableLandSeason2 =
			(Map<String, Serializable>)attributes.get("cultivableLandSeason2");

		if (cultivableLandSeason2 != null) {
			setCultivableLandSeason2(cultivableLandSeason2);
		}

		Map<String, Serializable> cultivableLandSeason3 =
			(Map<String, Serializable>)attributes.get("cultivableLandSeason3");

		if (cultivableLandSeason3 != null) {
			setCultivableLandSeason3(cultivableLandSeason3);
		}

		String farmerCategory = (String)attributes.get("farmerCategory ");

		if (farmerCategory != null) {
			setFarmerCategory(farmerCategory);
		}

		String password = (String)attributes.get("password ");

		if (password != null) {
			setPassword(password);
		}

		String remarks = (String)attributes.get("remarks");

		if (remarks != null) {
			setRemarks(remarks);
		}

		String businessCode = (String)attributes.get("businessCode");

		if (businessCode != null) {
			setBusinessCode(businessCode);
		}

		Double version = (Double)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
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
	public FarmerRegistration cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the application number of this farmer registration.
	 *
	 * @return the application number of this farmer registration
	 */
	@Override
	public String getApplicationNumber() {
		return model.getApplicationNumber();
	}

	/**
	 * Returns the business code of this farmer registration.
	 *
	 * @return the business code of this farmer registration
	 */
	@Override
	public String getBusinessCode() {
		return model.getBusinessCode();
	}

	/**
	 * Returns the company ID of this farmer registration.
	 *
	 * @return the company ID of this farmer registration
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this farmer registration.
	 *
	 * @return the create date of this farmer registration
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this farmer registration.
	 *
	 * @return the created by of this farmer registration
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the cultivable land season1 of this farmer registration.
	 *
	 * @return the cultivable land season1 of this farmer registration
	 */
	@Override
	public Map<String, Serializable> getCultivableLandSeason1() {
		return model.getCultivableLandSeason1();
	}

	/**
	 * Returns the cultivable land season2 of this farmer registration.
	 *
	 * @return the cultivable land season2 of this farmer registration
	 */
	@Override
	public Map<String, Serializable> getCultivableLandSeason2() {
		return model.getCultivableLandSeason2();
	}

	/**
	 * Returns the cultivable land season3 of this farmer registration.
	 *
	 * @return the cultivable land season3 of this farmer registration
	 */
	@Override
	public Map<String, Serializable> getCultivableLandSeason3() {
		return model.getCultivableLandSeason3();
	}

	/**
	 * Returns the date of birth of this farmer registration.
	 *
	 * @return the date of birth of this farmer registration
	 */
	@Override
	public Date getDateOfBirth() {
		return model.getDateOfBirth();
	}

	/**
	 * Returns the email address of this farmer registration.
	 *
	 * @return the email address of this farmer registration
	 */
	@Override
	public String getEmailAddress() {
		return model.getEmailAddress();
	}

	/**
	 * Returns the farmer category of this farmer registration.
	 *
	 * @return the farmer category of this farmer registration
	 */
	@Override
	public String getFarmerCategory() {
		return model.getFarmerCategory();
	}

	/**
	 * Returns the farmer name of this farmer registration.
	 *
	 * @return the farmer name of this farmer registration
	 */
	@Override
	public String getFarmerName() {
		return model.getFarmerName();
	}

	/**
	 * Returns the farmer registration ID of this farmer registration.
	 *
	 * @return the farmer registration ID of this farmer registration
	 */
	@Override
	public long getFarmerRegistrationId() {
		return model.getFarmerRegistrationId();
	}

	/**
	 * Returns the father name of this farmer registration.
	 *
	 * @return the father name of this farmer registration
	 */
	@Override
	public String getFatherName() {
		return model.getFatherName();
	}

	/**
	 * Returns the gender of this farmer registration.
	 *
	 * @return the gender of this farmer registration
	 */
	@Override
	public int getGender() {
		return model.getGender();
	}

	/**
	 * Returns the group ID of this farmer registration.
	 *
	 * @return the group ID of this farmer registration
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the krishok card number of this farmer registration.
	 *
	 * @return the krishok card number of this farmer registration
	 */
	@Override
	public String getKrishokCardNumber() {
		return model.getKrishokCardNumber();
	}

	/**
	 * Returns the marital status of this farmer registration.
	 *
	 * @return the marital status of this farmer registration
	 */
	@Override
	public int getMaritalStatus() {
		return model.getMaritalStatus();
	}

	/**
	 * Returns the mobile number of this farmer registration.
	 *
	 * @return the mobile number of this farmer registration
	 */
	@Override
	public String getMobileNumber() {
		return model.getMobileNumber();
	}

	/**
	 * Returns the modified by of this farmer registration.
	 *
	 * @return the modified by of this farmer registration
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this farmer registration.
	 *
	 * @return the modified date of this farmer registration
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mother name of this farmer registration.
	 *
	 * @return the mother name of this farmer registration
	 */
	@Override
	public String getMotherName() {
		return model.getMotherName();
	}

	/**
	 * Returns the national ID of this farmer registration.
	 *
	 * @return the national ID of this farmer registration
	 */
	@Override
	public String getNationalId() {
		return model.getNationalId();
	}

	/**
	 * Returns the password of this farmer registration.
	 *
	 * @return the password of this farmer registration
	 */
	@Override
	public String getPassword() {
		return model.getPassword();
	}

	/**
	 * Returns the primary key of this farmer registration.
	 *
	 * @return the primary key of this farmer registration
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the remarks of this farmer registration.
	 *
	 * @return the remarks of this farmer registration
	 */
	@Override
	public String getRemarks() {
		return model.getRemarks();
	}

	/**
	 * Returns the status of this farmer registration.
	 *
	 * @return the status of this farmer registration
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this farmer registration.
	 *
	 * @return the status by user ID of this farmer registration
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this farmer registration.
	 *
	 * @return the status by user name of this farmer registration
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this farmer registration.
	 *
	 * @return the status by user uuid of this farmer registration
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this farmer registration.
	 *
	 * @return the status date of this farmer registration
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the user ID of this farmer registration.
	 *
	 * @return the user ID of this farmer registration
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this farmer registration.
	 *
	 * @return the user uuid of this farmer registration
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this farmer registration.
	 *
	 * @return the uuid of this farmer registration
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the version of this farmer registration.
	 *
	 * @return the version of this farmer registration
	 */
	@Override
	public double getVersion() {
		return model.getVersion();
	}

	/**
	 * Returns <code>true</code> if this farmer registration is approved.
	 *
	 * @return <code>true</code> if this farmer registration is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this farmer registration is denied.
	 *
	 * @return <code>true</code> if this farmer registration is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this farmer registration is a draft.
	 *
	 * @return <code>true</code> if this farmer registration is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this farmer registration is expired.
	 *
	 * @return <code>true</code> if this farmer registration is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this farmer registration is inactive.
	 *
	 * @return <code>true</code> if this farmer registration is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this farmer registration is incomplete.
	 *
	 * @return <code>true</code> if this farmer registration is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this farmer registration is pending.
	 *
	 * @return <code>true</code> if this farmer registration is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this farmer registration is scheduled.
	 *
	 * @return <code>true</code> if this farmer registration is scheduled; <code>false</code> otherwise
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
	 * Sets the application number of this farmer registration.
	 *
	 * @param applicationNumber the application number of this farmer registration
	 */
	@Override
	public void setApplicationNumber(String applicationNumber) {
		model.setApplicationNumber(applicationNumber);
	}

	/**
	 * Sets the business code of this farmer registration.
	 *
	 * @param businessCode the business code of this farmer registration
	 */
	@Override
	public void setBusinessCode(String businessCode) {
		model.setBusinessCode(businessCode);
	}

	/**
	 * Sets the company ID of this farmer registration.
	 *
	 * @param companyId the company ID of this farmer registration
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this farmer registration.
	 *
	 * @param createDate the create date of this farmer registration
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this farmer registration.
	 *
	 * @param createdBy the created by of this farmer registration
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the cultivable land season1 of this farmer registration.
	 *
	 * @param cultivableLandSeason1 the cultivable land season1 of this farmer registration
	 */
	@Override
	public void setCultivableLandSeason1(
		Map<String, Serializable> cultivableLandSeason1) {

		model.setCultivableLandSeason1(cultivableLandSeason1);
	}

	/**
	 * Sets the cultivable land season2 of this farmer registration.
	 *
	 * @param cultivableLandSeason2 the cultivable land season2 of this farmer registration
	 */
	@Override
	public void setCultivableLandSeason2(
		Map<String, Serializable> cultivableLandSeason2) {

		model.setCultivableLandSeason2(cultivableLandSeason2);
	}

	/**
	 * Sets the cultivable land season3 of this farmer registration.
	 *
	 * @param cultivableLandSeason3 the cultivable land season3 of this farmer registration
	 */
	@Override
	public void setCultivableLandSeason3(
		Map<String, Serializable> cultivableLandSeason3) {

		model.setCultivableLandSeason3(cultivableLandSeason3);
	}

	/**
	 * Sets the date of birth of this farmer registration.
	 *
	 * @param dateOfBirth the date of birth of this farmer registration
	 */
	@Override
	public void setDateOfBirth(Date dateOfBirth) {
		model.setDateOfBirth(dateOfBirth);
	}

	/**
	 * Sets the email address of this farmer registration.
	 *
	 * @param emailAddress the email address of this farmer registration
	 */
	@Override
	public void setEmailAddress(String emailAddress) {
		model.setEmailAddress(emailAddress);
	}

	/**
	 * Sets the farmer category of this farmer registration.
	 *
	 * @param farmerCategory  the farmer category of this farmer registration
	 */
	@Override
	public void setFarmerCategory(String farmerCategory) {
		model.setFarmerCategory(farmerCategory);
	}

	/**
	 * Sets the farmer name of this farmer registration.
	 *
	 * @param farmerName the farmer name of this farmer registration
	 */
	@Override
	public void setFarmerName(String farmerName) {
		model.setFarmerName(farmerName);
	}

	/**
	 * Sets the farmer registration ID of this farmer registration.
	 *
	 * @param farmerRegistrationId the farmer registration ID of this farmer registration
	 */
	@Override
	public void setFarmerRegistrationId(long farmerRegistrationId) {
		model.setFarmerRegistrationId(farmerRegistrationId);
	}

	/**
	 * Sets the father name of this farmer registration.
	 *
	 * @param fatherName the father name of this farmer registration
	 */
	@Override
	public void setFatherName(String fatherName) {
		model.setFatherName(fatherName);
	}

	/**
	 * Sets the gender of this farmer registration.
	 *
	 * @param gender the gender of this farmer registration
	 */
	@Override
	public void setGender(int gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the group ID of this farmer registration.
	 *
	 * @param groupId the group ID of this farmer registration
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the krishok card number of this farmer registration.
	 *
	 * @param krishokCardNumber the krishok card number of this farmer registration
	 */
	@Override
	public void setKrishokCardNumber(String krishokCardNumber) {
		model.setKrishokCardNumber(krishokCardNumber);
	}

	/**
	 * Sets the marital status of this farmer registration.
	 *
	 * @param maritalStatus the marital status of this farmer registration
	 */
	@Override
	public void setMaritalStatus(int maritalStatus) {
		model.setMaritalStatus(maritalStatus);
	}

	/**
	 * Sets the mobile number of this farmer registration.
	 *
	 * @param mobileNumber the mobile number of this farmer registration
	 */
	@Override
	public void setMobileNumber(String mobileNumber) {
		model.setMobileNumber(mobileNumber);
	}

	/**
	 * Sets the modified by of this farmer registration.
	 *
	 * @param modifiedBy the modified by of this farmer registration
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this farmer registration.
	 *
	 * @param modifiedDate the modified date of this farmer registration
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mother name of this farmer registration.
	 *
	 * @param motherName the mother name of this farmer registration
	 */
	@Override
	public void setMotherName(String motherName) {
		model.setMotherName(motherName);
	}

	/**
	 * Sets the national ID of this farmer registration.
	 *
	 * @param nationalId the national ID of this farmer registration
	 */
	@Override
	public void setNationalId(String nationalId) {
		model.setNationalId(nationalId);
	}

	/**
	 * Sets the password of this farmer registration.
	 *
	 * @param password  the password of this farmer registration
	 */
	@Override
	public void setPassword(String password) {
		model.setPassword(password);
	}

	/**
	 * Sets the primary key of this farmer registration.
	 *
	 * @param primaryKey the primary key of this farmer registration
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the remarks of this farmer registration.
	 *
	 * @param remarks the remarks of this farmer registration
	 */
	@Override
	public void setRemarks(String remarks) {
		model.setRemarks(remarks);
	}

	/**
	 * Sets the status of this farmer registration.
	 *
	 * @param status the status of this farmer registration
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this farmer registration.
	 *
	 * @param statusByUserId the status by user ID of this farmer registration
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this farmer registration.
	 *
	 * @param statusByUserName the status by user name of this farmer registration
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this farmer registration.
	 *
	 * @param statusByUserUuid the status by user uuid of this farmer registration
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this farmer registration.
	 *
	 * @param statusDate the status date of this farmer registration
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this farmer registration.
	 *
	 * @param userId the user ID of this farmer registration
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this farmer registration.
	 *
	 * @param userUuid the user uuid of this farmer registration
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this farmer registration.
	 *
	 * @param uuid the uuid of this farmer registration
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the version of this farmer registration.
	 *
	 * @param version the version of this farmer registration
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
	protected FarmerRegistrationWrapper wrap(
		FarmerRegistration farmerRegistration) {

		return new FarmerRegistrationWrapper(farmerRegistration);
	}

}