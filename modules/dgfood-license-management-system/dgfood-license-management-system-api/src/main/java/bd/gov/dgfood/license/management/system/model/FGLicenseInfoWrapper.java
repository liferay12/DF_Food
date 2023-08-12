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

package bd.gov.dgfood.license.management.system.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FGLicenseInfo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FGLicenseInfo
 * @generated
 */
public class FGLicenseInfoWrapper
	extends BaseModelWrapper<FGLicenseInfo>
	implements FGLicenseInfo, ModelWrapper<FGLicenseInfo> {

	public FGLicenseInfoWrapper(FGLicenseInfo fgLicenseInfo) {
		super(fgLicenseInfo);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("fgLicenseInfoId", getFgLicenseInfoId());
		attributes.put("fgLicenseMasterId", getFgLicenseMasterId());
		attributes.put("fgLicenseMDMId", getFgLicenseMDMId());
		attributes.put("nationalId", getNationalId());
		attributes.put("applicationNumber", getApplicationNumber());
		attributes.put("applicantName", getApplicantName());
		attributes.put("tradeLicenseNumber", getTradeLicenseNumber());
		attributes.put("foodgrainLicenseNumber", getFoodgrainLicenseNumber());
		attributes.put(
			"foodgrainLicenseIssueDate", getFoodgrainLicenseIssueDate());
		attributes.put(
			"foodgrainLicenseExpiryDate", getFoodgrainLicenseExpiryDate());
		attributes.put("businessName", getBusinessName());
		attributes.put("businessType", getBusinessType());
		attributes.put("businessAddressId", getBusinessAddressId());
		attributes.put("version", getVersion());
		attributes.put("applicationType", getApplicationType());
		attributes.put("syncStatus", isSyncStatus());
		attributes.put("isExpired", isIsExpired());
		attributes.put("paymentChallanId", getPaymentChallanId());
		attributes.put("division", getDivision());
		attributes.put("district", getDistrict());
		attributes.put("upazila", getUpazila());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long fgLicenseInfoId = (Long)attributes.get("fgLicenseInfoId");

		if (fgLicenseInfoId != null) {
			setFgLicenseInfoId(fgLicenseInfoId);
		}

		Long fgLicenseMasterId = (Long)attributes.get("fgLicenseMasterId");

		if (fgLicenseMasterId != null) {
			setFgLicenseMasterId(fgLicenseMasterId);
		}

		Long fgLicenseMDMId = (Long)attributes.get("fgLicenseMDMId");

		if (fgLicenseMDMId != null) {
			setFgLicenseMDMId(fgLicenseMDMId);
		}

		String nationalId = (String)attributes.get("nationalId");

		if (nationalId != null) {
			setNationalId(nationalId);
		}

		String applicationNumber = (String)attributes.get("applicationNumber");

		if (applicationNumber != null) {
			setApplicationNumber(applicationNumber);
		}

		String applicantName = (String)attributes.get("applicantName");

		if (applicantName != null) {
			setApplicantName(applicantName);
		}

		String tradeLicenseNumber = (String)attributes.get(
			"tradeLicenseNumber");

		if (tradeLicenseNumber != null) {
			setTradeLicenseNumber(tradeLicenseNumber);
		}

		String foodgrainLicenseNumber = (String)attributes.get(
			"foodgrainLicenseNumber");

		if (foodgrainLicenseNumber != null) {
			setFoodgrainLicenseNumber(foodgrainLicenseNumber);
		}

		Date foodgrainLicenseIssueDate = (Date)attributes.get(
			"foodgrainLicenseIssueDate");

		if (foodgrainLicenseIssueDate != null) {
			setFoodgrainLicenseIssueDate(foodgrainLicenseIssueDate);
		}

		Date foodgrainLicenseExpiryDate = (Date)attributes.get(
			"foodgrainLicenseExpiryDate");

		if (foodgrainLicenseExpiryDate != null) {
			setFoodgrainLicenseExpiryDate(foodgrainLicenseExpiryDate);
		}

		String businessName = (String)attributes.get("businessName");

		if (businessName != null) {
			setBusinessName(businessName);
		}

		String businessType = (String)attributes.get("businessType");

		if (businessType != null) {
			setBusinessType(businessType);
		}

		Long businessAddressId = (Long)attributes.get("businessAddressId");

		if (businessAddressId != null) {
			setBusinessAddressId(businessAddressId);
		}

		Double version = (Double)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		String applicationType = (String)attributes.get("applicationType");

		if (applicationType != null) {
			setApplicationType(applicationType);
		}

		Boolean syncStatus = (Boolean)attributes.get("syncStatus");

		if (syncStatus != null) {
			setSyncStatus(syncStatus);
		}

		Boolean isExpired = (Boolean)attributes.get("isExpired");

		if (isExpired != null) {
			setIsExpired(isExpired);
		}

		Long paymentChallanId = (Long)attributes.get("paymentChallanId");

		if (paymentChallanId != null) {
			setPaymentChallanId(paymentChallanId);
		}

		String division = (String)attributes.get("division");

		if (division != null) {
			setDivision(division);
		}

		String district = (String)attributes.get("district");

		if (district != null) {
			setDistrict(district);
		}

		String upazila = (String)attributes.get("upazila");

		if (upazila != null) {
			setUpazila(upazila);
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

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}
	}

	@Override
	public FGLicenseInfo cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the applicant name of this fg license info.
	 *
	 * @return the applicant name of this fg license info
	 */
	@Override
	public String getApplicantName() {
		return model.getApplicantName();
	}

	/**
	 * Returns the application number of this fg license info.
	 *
	 * @return the application number of this fg license info
	 */
	@Override
	public String getApplicationNumber() {
		return model.getApplicationNumber();
	}

	/**
	 * Returns the application type of this fg license info.
	 *
	 * @return the application type of this fg license info
	 */
	@Override
	public String getApplicationType() {
		return model.getApplicationType();
	}

	/**
	 * Returns the business address ID of this fg license info.
	 *
	 * @return the business address ID of this fg license info
	 */
	@Override
	public long getBusinessAddressId() {
		return model.getBusinessAddressId();
	}

	/**
	 * Returns the business name of this fg license info.
	 *
	 * @return the business name of this fg license info
	 */
	@Override
	public String getBusinessName() {
		return model.getBusinessName();
	}

	/**
	 * Returns the business type of this fg license info.
	 *
	 * @return the business type of this fg license info
	 */
	@Override
	public String getBusinessType() {
		return model.getBusinessType();
	}

	/**
	 * Returns the company ID of this fg license info.
	 *
	 * @return the company ID of this fg license info
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this fg license info.
	 *
	 * @return the create date of this fg license info
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the district of this fg license info.
	 *
	 * @return the district of this fg license info
	 */
	@Override
	public String getDistrict() {
		return model.getDistrict();
	}

	/**
	 * Returns the division of this fg license info.
	 *
	 * @return the division of this fg license info
	 */
	@Override
	public String getDivision() {
		return model.getDivision();
	}

	/**
	 * Returns the fg license info ID of this fg license info.
	 *
	 * @return the fg license info ID of this fg license info
	 */
	@Override
	public long getFgLicenseInfoId() {
		return model.getFgLicenseInfoId();
	}

	/**
	 * Returns the fg license master ID of this fg license info.
	 *
	 * @return the fg license master ID of this fg license info
	 */
	@Override
	public long getFgLicenseMasterId() {
		return model.getFgLicenseMasterId();
	}

	/**
	 * Returns the fg license mdm ID of this fg license info.
	 *
	 * @return the fg license mdm ID of this fg license info
	 */
	@Override
	public long getFgLicenseMDMId() {
		return model.getFgLicenseMDMId();
	}

	/**
	 * Returns the foodgrain license expiry date of this fg license info.
	 *
	 * @return the foodgrain license expiry date of this fg license info
	 */
	@Override
	public Date getFoodgrainLicenseExpiryDate() {
		return model.getFoodgrainLicenseExpiryDate();
	}

	/**
	 * Returns the foodgrain license issue date of this fg license info.
	 *
	 * @return the foodgrain license issue date of this fg license info
	 */
	@Override
	public Date getFoodgrainLicenseIssueDate() {
		return model.getFoodgrainLicenseIssueDate();
	}

	/**
	 * Returns the foodgrain license number of this fg license info.
	 *
	 * @return the foodgrain license number of this fg license info
	 */
	@Override
	public String getFoodgrainLicenseNumber() {
		return model.getFoodgrainLicenseNumber();
	}

	/**
	 * Returns the group ID of this fg license info.
	 *
	 * @return the group ID of this fg license info
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is expired of this fg license info.
	 *
	 * @return the is expired of this fg license info
	 */
	@Override
	public boolean getIsExpired() {
		return model.getIsExpired();
	}

	/**
	 * Returns the modified by of this fg license info.
	 *
	 * @return the modified by of this fg license info
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this fg license info.
	 *
	 * @return the modified date of this fg license info
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the national ID of this fg license info.
	 *
	 * @return the national ID of this fg license info
	 */
	@Override
	public String getNationalId() {
		return model.getNationalId();
	}

	/**
	 * Returns the payment challan ID of this fg license info.
	 *
	 * @return the payment challan ID of this fg license info
	 */
	@Override
	public long getPaymentChallanId() {
		return model.getPaymentChallanId();
	}

	/**
	 * Returns the primary key of this fg license info.
	 *
	 * @return the primary key of this fg license info
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this fg license info.
	 *
	 * @return the status of this fg license info
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this fg license info.
	 *
	 * @return the status by user ID of this fg license info
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this fg license info.
	 *
	 * @return the status by user name of this fg license info
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this fg license info.
	 *
	 * @return the status by user uuid of this fg license info
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this fg license info.
	 *
	 * @return the status date of this fg license info
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the sync status of this fg license info.
	 *
	 * @return the sync status of this fg license info
	 */
	@Override
	public boolean getSyncStatus() {
		return model.getSyncStatus();
	}

	/**
	 * Returns the trade license number of this fg license info.
	 *
	 * @return the trade license number of this fg license info
	 */
	@Override
	public String getTradeLicenseNumber() {
		return model.getTradeLicenseNumber();
	}

	/**
	 * Returns the upazila of this fg license info.
	 *
	 * @return the upazila of this fg license info
	 */
	@Override
	public String getUpazila() {
		return model.getUpazila();
	}

	/**
	 * Returns the uuid of this fg license info.
	 *
	 * @return the uuid of this fg license info
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the version of this fg license info.
	 *
	 * @return the version of this fg license info
	 */
	@Override
	public double getVersion() {
		return model.getVersion();
	}

	/**
	 * Returns <code>true</code> if this fg license info is approved.
	 *
	 * @return <code>true</code> if this fg license info is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this fg license info is denied.
	 *
	 * @return <code>true</code> if this fg license info is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this fg license info is a draft.
	 *
	 * @return <code>true</code> if this fg license info is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this fg license info is expired.
	 *
	 * @return <code>true</code> if this fg license info is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this fg license info is inactive.
	 *
	 * @return <code>true</code> if this fg license info is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this fg license info is incomplete.
	 *
	 * @return <code>true</code> if this fg license info is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this fg license info is is expired.
	 *
	 * @return <code>true</code> if this fg license info is is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsExpired() {
		return model.isIsExpired();
	}

	/**
	 * Returns <code>true</code> if this fg license info is pending.
	 *
	 * @return <code>true</code> if this fg license info is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this fg license info is scheduled.
	 *
	 * @return <code>true</code> if this fg license info is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	/**
	 * Returns <code>true</code> if this fg license info is sync status.
	 *
	 * @return <code>true</code> if this fg license info is sync status; <code>false</code> otherwise
	 */
	@Override
	public boolean isSyncStatus() {
		return model.isSyncStatus();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the applicant name of this fg license info.
	 *
	 * @param applicantName the applicant name of this fg license info
	 */
	@Override
	public void setApplicantName(String applicantName) {
		model.setApplicantName(applicantName);
	}

	/**
	 * Sets the application number of this fg license info.
	 *
	 * @param applicationNumber the application number of this fg license info
	 */
	@Override
	public void setApplicationNumber(String applicationNumber) {
		model.setApplicationNumber(applicationNumber);
	}

	/**
	 * Sets the application type of this fg license info.
	 *
	 * @param applicationType the application type of this fg license info
	 */
	@Override
	public void setApplicationType(String applicationType) {
		model.setApplicationType(applicationType);
	}

	/**
	 * Sets the business address ID of this fg license info.
	 *
	 * @param businessAddressId the business address ID of this fg license info
	 */
	@Override
	public void setBusinessAddressId(long businessAddressId) {
		model.setBusinessAddressId(businessAddressId);
	}

	/**
	 * Sets the business name of this fg license info.
	 *
	 * @param businessName the business name of this fg license info
	 */
	@Override
	public void setBusinessName(String businessName) {
		model.setBusinessName(businessName);
	}

	/**
	 * Sets the business type of this fg license info.
	 *
	 * @param businessType the business type of this fg license info
	 */
	@Override
	public void setBusinessType(String businessType) {
		model.setBusinessType(businessType);
	}

	/**
	 * Sets the company ID of this fg license info.
	 *
	 * @param companyId the company ID of this fg license info
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this fg license info.
	 *
	 * @param createDate the create date of this fg license info
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the district of this fg license info.
	 *
	 * @param district the district of this fg license info
	 */
	@Override
	public void setDistrict(String district) {
		model.setDistrict(district);
	}

	/**
	 * Sets the division of this fg license info.
	 *
	 * @param division the division of this fg license info
	 */
	@Override
	public void setDivision(String division) {
		model.setDivision(division);
	}

	/**
	 * Sets the fg license info ID of this fg license info.
	 *
	 * @param fgLicenseInfoId the fg license info ID of this fg license info
	 */
	@Override
	public void setFgLicenseInfoId(long fgLicenseInfoId) {
		model.setFgLicenseInfoId(fgLicenseInfoId);
	}

	/**
	 * Sets the fg license master ID of this fg license info.
	 *
	 * @param fgLicenseMasterId the fg license master ID of this fg license info
	 */
	@Override
	public void setFgLicenseMasterId(long fgLicenseMasterId) {
		model.setFgLicenseMasterId(fgLicenseMasterId);
	}

	/**
	 * Sets the fg license mdm ID of this fg license info.
	 *
	 * @param fgLicenseMDMId the fg license mdm ID of this fg license info
	 */
	@Override
	public void setFgLicenseMDMId(long fgLicenseMDMId) {
		model.setFgLicenseMDMId(fgLicenseMDMId);
	}

	/**
	 * Sets the foodgrain license expiry date of this fg license info.
	 *
	 * @param foodgrainLicenseExpiryDate the foodgrain license expiry date of this fg license info
	 */
	@Override
	public void setFoodgrainLicenseExpiryDate(Date foodgrainLicenseExpiryDate) {
		model.setFoodgrainLicenseExpiryDate(foodgrainLicenseExpiryDate);
	}

	/**
	 * Sets the foodgrain license issue date of this fg license info.
	 *
	 * @param foodgrainLicenseIssueDate the foodgrain license issue date of this fg license info
	 */
	@Override
	public void setFoodgrainLicenseIssueDate(Date foodgrainLicenseIssueDate) {
		model.setFoodgrainLicenseIssueDate(foodgrainLicenseIssueDate);
	}

	/**
	 * Sets the foodgrain license number of this fg license info.
	 *
	 * @param foodgrainLicenseNumber the foodgrain license number of this fg license info
	 */
	@Override
	public void setFoodgrainLicenseNumber(String foodgrainLicenseNumber) {
		model.setFoodgrainLicenseNumber(foodgrainLicenseNumber);
	}

	/**
	 * Sets the group ID of this fg license info.
	 *
	 * @param groupId the group ID of this fg license info
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this fg license info is is expired.
	 *
	 * @param isExpired the is expired of this fg license info
	 */
	@Override
	public void setIsExpired(boolean isExpired) {
		model.setIsExpired(isExpired);
	}

	/**
	 * Sets the modified by of this fg license info.
	 *
	 * @param modifiedBy the modified by of this fg license info
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this fg license info.
	 *
	 * @param modifiedDate the modified date of this fg license info
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the national ID of this fg license info.
	 *
	 * @param nationalId the national ID of this fg license info
	 */
	@Override
	public void setNationalId(String nationalId) {
		model.setNationalId(nationalId);
	}

	/**
	 * Sets the payment challan ID of this fg license info.
	 *
	 * @param paymentChallanId the payment challan ID of this fg license info
	 */
	@Override
	public void setPaymentChallanId(long paymentChallanId) {
		model.setPaymentChallanId(paymentChallanId);
	}

	/**
	 * Sets the primary key of this fg license info.
	 *
	 * @param primaryKey the primary key of this fg license info
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this fg license info.
	 *
	 * @param status the status of this fg license info
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this fg license info.
	 *
	 * @param statusByUserId the status by user ID of this fg license info
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this fg license info.
	 *
	 * @param statusByUserName the status by user name of this fg license info
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this fg license info.
	 *
	 * @param statusByUserUuid the status by user uuid of this fg license info
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this fg license info.
	 *
	 * @param statusDate the status date of this fg license info
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets whether this fg license info is sync status.
	 *
	 * @param syncStatus the sync status of this fg license info
	 */
	@Override
	public void setSyncStatus(boolean syncStatus) {
		model.setSyncStatus(syncStatus);
	}

	/**
	 * Sets the trade license number of this fg license info.
	 *
	 * @param tradeLicenseNumber the trade license number of this fg license info
	 */
	@Override
	public void setTradeLicenseNumber(String tradeLicenseNumber) {
		model.setTradeLicenseNumber(tradeLicenseNumber);
	}

	/**
	 * Sets the upazila of this fg license info.
	 *
	 * @param upazila the upazila of this fg license info
	 */
	@Override
	public void setUpazila(String upazila) {
		model.setUpazila(upazila);
	}

	/**
	 * Sets the uuid of this fg license info.
	 *
	 * @param uuid the uuid of this fg license info
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the version of this fg license info.
	 *
	 * @param version the version of this fg license info
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
	protected FGLicenseInfoWrapper wrap(FGLicenseInfo fgLicenseInfo) {
		return new FGLicenseInfoWrapper(fgLicenseInfo);
	}

}