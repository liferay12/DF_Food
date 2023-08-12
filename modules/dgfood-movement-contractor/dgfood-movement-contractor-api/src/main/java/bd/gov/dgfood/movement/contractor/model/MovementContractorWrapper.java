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

package bd.gov.dgfood.movement.contractor.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link MovementContractor}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MovementContractor
 * @generated
 */
public class MovementContractorWrapper
	extends BaseModelWrapper<MovementContractor>
	implements ModelWrapper<MovementContractor>, MovementContractor {

	public MovementContractorWrapper(MovementContractor movementContractor) {
		super(movementContractor);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("movementContractorId", getMovementContractorId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("name", getName());
		attributes.put("mobileNumber", getMobileNumber());
		attributes.put("nationalId", getNationalId());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("dateOfBirth", getDateOfBirth());
		attributes.put("gender", getGender());
		attributes.put("fatherName", getFatherName());
		attributes.put("motherName", getMotherName());
		attributes.put("maritalStatus", getMaritalStatus());
		attributes.put("type", getType());
		attributes.put("organizationName", getOrganizationName());
		attributes.put("tradeLicenseNumber", getTradeLicenseNumber());
		attributes.put("tradeLicenseExpiryDate", getTradeLicenseExpiryDate());
		attributes.put("vehicle", getVehicle());
		attributes.put("vehicleCount", getVehicleCount());
		attributes.put("vehicleCapacity", getVehicleCapacity());
		attributes.put("userId", getUserId());
		attributes.put("password", getPassword());
		attributes.put("applicationNumber", getApplicationNumber());
		attributes.put("businessCode", getBusinessCode());
		attributes.put("version", getVersion());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusDate", getStatusDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long movementContractorId = (Long)attributes.get(
			"movementContractorId");

		if (movementContractorId != null) {
			setMovementContractorId(movementContractorId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String mobileNumber = (String)attributes.get("mobileNumber");

		if (mobileNumber != null) {
			setMobileNumber(mobileNumber);
		}

		Long nationalId = (Long)attributes.get("nationalId");

		if (nationalId != null) {
			setNationalId(nationalId);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		Date dateOfBirth = (Date)attributes.get("dateOfBirth");

		if (dateOfBirth != null) {
			setDateOfBirth(dateOfBirth);
		}

		Integer gender = (Integer)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		String fatherName = (String)attributes.get("fatherName");

		if (fatherName != null) {
			setFatherName(fatherName);
		}

		String motherName = (String)attributes.get("motherName");

		if (motherName != null) {
			setMotherName(motherName);
		}

		Integer maritalStatus = (Integer)attributes.get("maritalStatus");

		if (maritalStatus != null) {
			setMaritalStatus(maritalStatus);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String organizationName = (String)attributes.get("organizationName");

		if (organizationName != null) {
			setOrganizationName(organizationName);
		}

		String tradeLicenseNumber = (String)attributes.get(
			"tradeLicenseNumber");

		if (tradeLicenseNumber != null) {
			setTradeLicenseNumber(tradeLicenseNumber);
		}

		Date tradeLicenseExpiryDate = (Date)attributes.get(
			"tradeLicenseExpiryDate");

		if (tradeLicenseExpiryDate != null) {
			setTradeLicenseExpiryDate(tradeLicenseExpiryDate);
		}

		String vehicle = (String)attributes.get("vehicle");

		if (vehicle != null) {
			setVehicle(vehicle);
		}

		Integer vehicleCount = (Integer)attributes.get("vehicleCount");

		if (vehicleCount != null) {
			setVehicleCount(vehicleCount);
		}

		Map<String, Serializable> vehicleCapacity =
			(Map<String, Serializable>)attributes.get("vehicleCapacity");

		if (vehicleCapacity != null) {
			setVehicleCapacity(vehicleCapacity);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		Long applicationNumber = (Long)attributes.get("applicationNumber");

		if (applicationNumber != null) {
			setApplicationNumber(applicationNumber);
		}

		Long businessCode = (Long)attributes.get("businessCode");

		if (businessCode != null) {
			setBusinessCode(businessCode);
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

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
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
	}

	@Override
	public MovementContractor cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the application number of this movement contractor.
	 *
	 * @return the application number of this movement contractor
	 */
	@Override
	public long getApplicationNumber() {
		return model.getApplicationNumber();
	}

	/**
	 * Returns the business code of this movement contractor.
	 *
	 * @return the business code of this movement contractor
	 */
	@Override
	public long getBusinessCode() {
		return model.getBusinessCode();
	}

	/**
	 * Returns the company ID of this movement contractor.
	 *
	 * @return the company ID of this movement contractor
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this movement contractor.
	 *
	 * @return the create date of this movement contractor
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this movement contractor.
	 *
	 * @return the created by of this movement contractor
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the date of birth of this movement contractor.
	 *
	 * @return the date of birth of this movement contractor
	 */
	@Override
	public Date getDateOfBirth() {
		return model.getDateOfBirth();
	}

	/**
	 * Returns the email address of this movement contractor.
	 *
	 * @return the email address of this movement contractor
	 */
	@Override
	public String getEmailAddress() {
		return model.getEmailAddress();
	}

	/**
	 * Returns the father name of this movement contractor.
	 *
	 * @return the father name of this movement contractor
	 */
	@Override
	public String getFatherName() {
		return model.getFatherName();
	}

	/**
	 * Returns the gender of this movement contractor.
	 *
	 * @return the gender of this movement contractor
	 */
	@Override
	public int getGender() {
		return model.getGender();
	}

	/**
	 * Returns the group ID of this movement contractor.
	 *
	 * @return the group ID of this movement contractor
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the marital status of this movement contractor.
	 *
	 * @return the marital status of this movement contractor
	 */
	@Override
	public int getMaritalStatus() {
		return model.getMaritalStatus();
	}

	/**
	 * Returns the mobile number of this movement contractor.
	 *
	 * @return the mobile number of this movement contractor
	 */
	@Override
	public String getMobileNumber() {
		return model.getMobileNumber();
	}

	/**
	 * Returns the modified by of this movement contractor.
	 *
	 * @return the modified by of this movement contractor
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this movement contractor.
	 *
	 * @return the modified date of this movement contractor
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mother name of this movement contractor.
	 *
	 * @return the mother name of this movement contractor
	 */
	@Override
	public String getMotherName() {
		return model.getMotherName();
	}

	/**
	 * Returns the movement contractor ID of this movement contractor.
	 *
	 * @return the movement contractor ID of this movement contractor
	 */
	@Override
	public long getMovementContractorId() {
		return model.getMovementContractorId();
	}

	/**
	 * Returns the name of this movement contractor.
	 *
	 * @return the name of this movement contractor
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the national ID of this movement contractor.
	 *
	 * @return the national ID of this movement contractor
	 */
	@Override
	public long getNationalId() {
		return model.getNationalId();
	}

	/**
	 * Returns the organization name of this movement contractor.
	 *
	 * @return the organization name of this movement contractor
	 */
	@Override
	public String getOrganizationName() {
		return model.getOrganizationName();
	}

	/**
	 * Returns the password of this movement contractor.
	 *
	 * @return the password of this movement contractor
	 */
	@Override
	public String getPassword() {
		return model.getPassword();
	}

	/**
	 * Returns the primary key of this movement contractor.
	 *
	 * @return the primary key of this movement contractor
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this movement contractor.
	 *
	 * @return the status of this movement contractor
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this movement contractor.
	 *
	 * @return the status by user ID of this movement contractor
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user uuid of this movement contractor.
	 *
	 * @return the status by user uuid of this movement contractor
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this movement contractor.
	 *
	 * @return the status date of this movement contractor
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the trade license expiry date of this movement contractor.
	 *
	 * @return the trade license expiry date of this movement contractor
	 */
	@Override
	public Date getTradeLicenseExpiryDate() {
		return model.getTradeLicenseExpiryDate();
	}

	/**
	 * Returns the trade license number of this movement contractor.
	 *
	 * @return the trade license number of this movement contractor
	 */
	@Override
	public String getTradeLicenseNumber() {
		return model.getTradeLicenseNumber();
	}

	/**
	 * Returns the type of this movement contractor.
	 *
	 * @return the type of this movement contractor
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the user ID of this movement contractor.
	 *
	 * @return the user ID of this movement contractor
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this movement contractor.
	 *
	 * @return the user uuid of this movement contractor
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this movement contractor.
	 *
	 * @return the uuid of this movement contractor
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the vehicle of this movement contractor.
	 *
	 * @return the vehicle of this movement contractor
	 */
	@Override
	public String getVehicle() {
		return model.getVehicle();
	}

	/**
	 * Returns the vehicle capacity of this movement contractor.
	 *
	 * @return the vehicle capacity of this movement contractor
	 */
	@Override
	public Map<String, Serializable> getVehicleCapacity() {
		return model.getVehicleCapacity();
	}

	/**
	 * Returns the vehicle count of this movement contractor.
	 *
	 * @return the vehicle count of this movement contractor
	 */
	@Override
	public int getVehicleCount() {
		return model.getVehicleCount();
	}

	/**
	 * Returns the version of this movement contractor.
	 *
	 * @return the version of this movement contractor
	 */
	@Override
	public double getVersion() {
		return model.getVersion();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the application number of this movement contractor.
	 *
	 * @param applicationNumber the application number of this movement contractor
	 */
	@Override
	public void setApplicationNumber(long applicationNumber) {
		model.setApplicationNumber(applicationNumber);
	}

	/**
	 * Sets the business code of this movement contractor.
	 *
	 * @param businessCode the business code of this movement contractor
	 */
	@Override
	public void setBusinessCode(long businessCode) {
		model.setBusinessCode(businessCode);
	}

	/**
	 * Sets the company ID of this movement contractor.
	 *
	 * @param companyId the company ID of this movement contractor
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this movement contractor.
	 *
	 * @param createDate the create date of this movement contractor
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this movement contractor.
	 *
	 * @param createdBy the created by of this movement contractor
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the date of birth of this movement contractor.
	 *
	 * @param dateOfBirth the date of birth of this movement contractor
	 */
	@Override
	public void setDateOfBirth(Date dateOfBirth) {
		model.setDateOfBirth(dateOfBirth);
	}

	/**
	 * Sets the email address of this movement contractor.
	 *
	 * @param emailAddress the email address of this movement contractor
	 */
	@Override
	public void setEmailAddress(String emailAddress) {
		model.setEmailAddress(emailAddress);
	}

	/**
	 * Sets the father name of this movement contractor.
	 *
	 * @param fatherName the father name of this movement contractor
	 */
	@Override
	public void setFatherName(String fatherName) {
		model.setFatherName(fatherName);
	}

	/**
	 * Sets the gender of this movement contractor.
	 *
	 * @param gender the gender of this movement contractor
	 */
	@Override
	public void setGender(int gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the group ID of this movement contractor.
	 *
	 * @param groupId the group ID of this movement contractor
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the marital status of this movement contractor.
	 *
	 * @param maritalStatus the marital status of this movement contractor
	 */
	@Override
	public void setMaritalStatus(int maritalStatus) {
		model.setMaritalStatus(maritalStatus);
	}

	/**
	 * Sets the mobile number of this movement contractor.
	 *
	 * @param mobileNumber the mobile number of this movement contractor
	 */
	@Override
	public void setMobileNumber(String mobileNumber) {
		model.setMobileNumber(mobileNumber);
	}

	/**
	 * Sets the modified by of this movement contractor.
	 *
	 * @param modifiedBy the modified by of this movement contractor
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this movement contractor.
	 *
	 * @param modifiedDate the modified date of this movement contractor
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mother name of this movement contractor.
	 *
	 * @param motherName the mother name of this movement contractor
	 */
	@Override
	public void setMotherName(String motherName) {
		model.setMotherName(motherName);
	}

	/**
	 * Sets the movement contractor ID of this movement contractor.
	 *
	 * @param movementContractorId the movement contractor ID of this movement contractor
	 */
	@Override
	public void setMovementContractorId(long movementContractorId) {
		model.setMovementContractorId(movementContractorId);
	}

	/**
	 * Sets the name of this movement contractor.
	 *
	 * @param name the name of this movement contractor
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the national ID of this movement contractor.
	 *
	 * @param nationalId the national ID of this movement contractor
	 */
	@Override
	public void setNationalId(long nationalId) {
		model.setNationalId(nationalId);
	}

	/**
	 * Sets the organization name of this movement contractor.
	 *
	 * @param organizationName the organization name of this movement contractor
	 */
	@Override
	public void setOrganizationName(String organizationName) {
		model.setOrganizationName(organizationName);
	}

	/**
	 * Sets the password of this movement contractor.
	 *
	 * @param password the password of this movement contractor
	 */
	@Override
	public void setPassword(String password) {
		model.setPassword(password);
	}

	/**
	 * Sets the primary key of this movement contractor.
	 *
	 * @param primaryKey the primary key of this movement contractor
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this movement contractor.
	 *
	 * @param status the status of this movement contractor
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this movement contractor.
	 *
	 * @param statusByUserId the status by user ID of this movement contractor
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user uuid of this movement contractor.
	 *
	 * @param statusByUserUuid the status by user uuid of this movement contractor
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this movement contractor.
	 *
	 * @param statusDate the status date of this movement contractor
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the trade license expiry date of this movement contractor.
	 *
	 * @param tradeLicenseExpiryDate the trade license expiry date of this movement contractor
	 */
	@Override
	public void setTradeLicenseExpiryDate(Date tradeLicenseExpiryDate) {
		model.setTradeLicenseExpiryDate(tradeLicenseExpiryDate);
	}

	/**
	 * Sets the trade license number of this movement contractor.
	 *
	 * @param tradeLicenseNumber the trade license number of this movement contractor
	 */
	@Override
	public void setTradeLicenseNumber(String tradeLicenseNumber) {
		model.setTradeLicenseNumber(tradeLicenseNumber);
	}

	/**
	 * Sets the type of this movement contractor.
	 *
	 * @param type the type of this movement contractor
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	/**
	 * Sets the user ID of this movement contractor.
	 *
	 * @param userId the user ID of this movement contractor
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this movement contractor.
	 *
	 * @param userUuid the user uuid of this movement contractor
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this movement contractor.
	 *
	 * @param uuid the uuid of this movement contractor
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the vehicle of this movement contractor.
	 *
	 * @param vehicle the vehicle of this movement contractor
	 */
	@Override
	public void setVehicle(String vehicle) {
		model.setVehicle(vehicle);
	}

	/**
	 * Sets the vehicle capacity of this movement contractor.
	 *
	 * @param vehicleCapacity the vehicle capacity of this movement contractor
	 */
	@Override
	public void setVehicleCapacity(Map<String, Serializable> vehicleCapacity) {
		model.setVehicleCapacity(vehicleCapacity);
	}

	/**
	 * Sets the vehicle count of this movement contractor.
	 *
	 * @param vehicleCount the vehicle count of this movement contractor
	 */
	@Override
	public void setVehicleCount(int vehicleCount) {
		model.setVehicleCount(vehicleCount);
	}

	/**
	 * Sets the version of this movement contractor.
	 *
	 * @param version the version of this movement contractor
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
	protected MovementContractorWrapper wrap(
		MovementContractor movementContractor) {

		return new MovementContractorWrapper(movementContractor);
	}

}