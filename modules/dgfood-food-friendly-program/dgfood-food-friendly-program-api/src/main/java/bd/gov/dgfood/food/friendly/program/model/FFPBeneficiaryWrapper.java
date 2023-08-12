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

package bd.gov.dgfood.food.friendly.program.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FFPBeneficiary}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FFPBeneficiary
 * @generated
 */
public class FFPBeneficiaryWrapper
	extends BaseModelWrapper<FFPBeneficiary>
	implements FFPBeneficiary, ModelWrapper<FFPBeneficiary> {

	public FFPBeneficiaryWrapper(FFPBeneficiary ffpBeneficiary) {
		super(ffpBeneficiary);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("beneficiaryId", getBeneficiaryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("version", getVersion());
		attributes.put("name", getName());
		attributes.put("mobileNumber", getMobileNumber());
		attributes.put("nationalId", getNationalId());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("cardNumber", getCardNumber());
		attributes.put("dateOfBirth", getDateOfBirth());
		attributes.put("gender", getGender());
		attributes.put("fatherName", getFatherName());
		attributes.put("motherName", getMotherName());
		attributes.put("maritalStatus", getMaritalStatus());
		attributes.put("spouseName", getSpouseName());
		attributes.put("spouseFatherName", getSpouseFatherName());
		attributes.put("spouseDateOfBirth", getSpouseDateOfBirth());
		attributes.put("spouseNationalId", getSpouseNationalId());
		attributes.put(
			"familyAverageMonthlyIncome", getFamilyAverageMonthlyIncome());
		attributes.put("familyEarningMembers", getFamilyEarningMembers());
		attributes.put("acknowledge", isAcknowledge());
		attributes.put(
			"nonOfMyFamilyMembersRegistered",
			isNonOfMyFamilyMembersRegistered());
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

		Long beneficiaryId = (Long)attributes.get("beneficiaryId");

		if (beneficiaryId != null) {
			setBeneficiaryId(beneficiaryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Double version = (Double)attributes.get("version");

		if (version != null) {
			setVersion(version);
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

		String cardNumber = (String)attributes.get("cardNumber");

		if (cardNumber != null) {
			setCardNumber(cardNumber);
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

		String spouseName = (String)attributes.get("spouseName");

		if (spouseName != null) {
			setSpouseName(spouseName);
		}

		String spouseFatherName = (String)attributes.get("spouseFatherName");

		if (spouseFatherName != null) {
			setSpouseFatherName(spouseFatherName);
		}

		Date spouseDateOfBirth = (Date)attributes.get("spouseDateOfBirth");

		if (spouseDateOfBirth != null) {
			setSpouseDateOfBirth(spouseDateOfBirth);
		}

		Long spouseNationalId = (Long)attributes.get("spouseNationalId");

		if (spouseNationalId != null) {
			setSpouseNationalId(spouseNationalId);
		}

		String familyAverageMonthlyIncome = (String)attributes.get(
			"familyAverageMonthlyIncome");

		if (familyAverageMonthlyIncome != null) {
			setFamilyAverageMonthlyIncome(familyAverageMonthlyIncome);
		}

		Integer familyEarningMembers = (Integer)attributes.get(
			"familyEarningMembers");

		if (familyEarningMembers != null) {
			setFamilyEarningMembers(familyEarningMembers);
		}

		Boolean acknowledge = (Boolean)attributes.get("acknowledge");

		if (acknowledge != null) {
			setAcknowledge(acknowledge);
		}

		Boolean nonOfMyFamilyMembersRegistered = (Boolean)attributes.get(
			"nonOfMyFamilyMembersRegistered");

		if (nonOfMyFamilyMembersRegistered != null) {
			setNonOfMyFamilyMembersRegistered(nonOfMyFamilyMembersRegistered);
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
	public FFPBeneficiary cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the acknowledge of this ffp beneficiary.
	 *
	 * @return the acknowledge of this ffp beneficiary
	 */
	@Override
	public boolean getAcknowledge() {
		return model.getAcknowledge();
	}

	/**
	 * Returns the beneficiary ID of this ffp beneficiary.
	 *
	 * @return the beneficiary ID of this ffp beneficiary
	 */
	@Override
	public long getBeneficiaryId() {
		return model.getBeneficiaryId();
	}

	/**
	 * Returns the card number of this ffp beneficiary.
	 *
	 * @return the card number of this ffp beneficiary
	 */
	@Override
	public String getCardNumber() {
		return model.getCardNumber();
	}

	/**
	 * Returns the company ID of this ffp beneficiary.
	 *
	 * @return the company ID of this ffp beneficiary
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this ffp beneficiary.
	 *
	 * @return the create date of this ffp beneficiary
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this ffp beneficiary.
	 *
	 * @return the created by of this ffp beneficiary
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the date of birth of this ffp beneficiary.
	 *
	 * @return the date of birth of this ffp beneficiary
	 */
	@Override
	public Date getDateOfBirth() {
		return model.getDateOfBirth();
	}

	/**
	 * Returns the email address of this ffp beneficiary.
	 *
	 * @return the email address of this ffp beneficiary
	 */
	@Override
	public String getEmailAddress() {
		return model.getEmailAddress();
	}

	/**
	 * Returns the family average monthly income of this ffp beneficiary.
	 *
	 * @return the family average monthly income of this ffp beneficiary
	 */
	@Override
	public String getFamilyAverageMonthlyIncome() {
		return model.getFamilyAverageMonthlyIncome();
	}

	/**
	 * Returns the family earning members of this ffp beneficiary.
	 *
	 * @return the family earning members of this ffp beneficiary
	 */
	@Override
	public int getFamilyEarningMembers() {
		return model.getFamilyEarningMembers();
	}

	/**
	 * Returns the father name of this ffp beneficiary.
	 *
	 * @return the father name of this ffp beneficiary
	 */
	@Override
	public String getFatherName() {
		return model.getFatherName();
	}

	/**
	 * Returns the gender of this ffp beneficiary.
	 *
	 * @return the gender of this ffp beneficiary
	 */
	@Override
	public int getGender() {
		return model.getGender();
	}

	/**
	 * Returns the group ID of this ffp beneficiary.
	 *
	 * @return the group ID of this ffp beneficiary
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the marital status of this ffp beneficiary.
	 *
	 * @return the marital status of this ffp beneficiary
	 */
	@Override
	public int getMaritalStatus() {
		return model.getMaritalStatus();
	}

	/**
	 * Returns the mobile number of this ffp beneficiary.
	 *
	 * @return the mobile number of this ffp beneficiary
	 */
	@Override
	public String getMobileNumber() {
		return model.getMobileNumber();
	}

	/**
	 * Returns the modified by of this ffp beneficiary.
	 *
	 * @return the modified by of this ffp beneficiary
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this ffp beneficiary.
	 *
	 * @return the modified date of this ffp beneficiary
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mother name of this ffp beneficiary.
	 *
	 * @return the mother name of this ffp beneficiary
	 */
	@Override
	public String getMotherName() {
		return model.getMotherName();
	}

	/**
	 * Returns the name of this ffp beneficiary.
	 *
	 * @return the name of this ffp beneficiary
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the national ID of this ffp beneficiary.
	 *
	 * @return the national ID of this ffp beneficiary
	 */
	@Override
	public long getNationalId() {
		return model.getNationalId();
	}

	/**
	 * Returns the non of my family members registered of this ffp beneficiary.
	 *
	 * @return the non of my family members registered of this ffp beneficiary
	 */
	@Override
	public boolean getNonOfMyFamilyMembersRegistered() {
		return model.getNonOfMyFamilyMembersRegistered();
	}

	/**
	 * Returns the primary key of this ffp beneficiary.
	 *
	 * @return the primary key of this ffp beneficiary
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the spouse date of birth of this ffp beneficiary.
	 *
	 * @return the spouse date of birth of this ffp beneficiary
	 */
	@Override
	public Date getSpouseDateOfBirth() {
		return model.getSpouseDateOfBirth();
	}

	/**
	 * Returns the spouse father name of this ffp beneficiary.
	 *
	 * @return the spouse father name of this ffp beneficiary
	 */
	@Override
	public String getSpouseFatherName() {
		return model.getSpouseFatherName();
	}

	/**
	 * Returns the spouse name of this ffp beneficiary.
	 *
	 * @return the spouse name of this ffp beneficiary
	 */
	@Override
	public String getSpouseName() {
		return model.getSpouseName();
	}

	/**
	 * Returns the spouse national ID of this ffp beneficiary.
	 *
	 * @return the spouse national ID of this ffp beneficiary
	 */
	@Override
	public long getSpouseNationalId() {
		return model.getSpouseNationalId();
	}

	/**
	 * Returns the status of this ffp beneficiary.
	 *
	 * @return the status of this ffp beneficiary
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this ffp beneficiary.
	 *
	 * @return the status by user ID of this ffp beneficiary
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user uuid of this ffp beneficiary.
	 *
	 * @return the status by user uuid of this ffp beneficiary
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this ffp beneficiary.
	 *
	 * @return the status date of this ffp beneficiary
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the uuid of this ffp beneficiary.
	 *
	 * @return the uuid of this ffp beneficiary
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the version of this ffp beneficiary.
	 *
	 * @return the version of this ffp beneficiary
	 */
	@Override
	public double getVersion() {
		return model.getVersion();
	}

	/**
	 * Returns <code>true</code> if this ffp beneficiary is acknowledge.
	 *
	 * @return <code>true</code> if this ffp beneficiary is acknowledge; <code>false</code> otherwise
	 */
	@Override
	public boolean isAcknowledge() {
		return model.isAcknowledge();
	}

	/**
	 * Returns <code>true</code> if this ffp beneficiary is non of my family members registered.
	 *
	 * @return <code>true</code> if this ffp beneficiary is non of my family members registered; <code>false</code> otherwise
	 */
	@Override
	public boolean isNonOfMyFamilyMembersRegistered() {
		return model.isNonOfMyFamilyMembersRegistered();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this ffp beneficiary is acknowledge.
	 *
	 * @param acknowledge the acknowledge of this ffp beneficiary
	 */
	@Override
	public void setAcknowledge(boolean acknowledge) {
		model.setAcknowledge(acknowledge);
	}

	/**
	 * Sets the beneficiary ID of this ffp beneficiary.
	 *
	 * @param beneficiaryId the beneficiary ID of this ffp beneficiary
	 */
	@Override
	public void setBeneficiaryId(long beneficiaryId) {
		model.setBeneficiaryId(beneficiaryId);
	}

	/**
	 * Sets the card number of this ffp beneficiary.
	 *
	 * @param cardNumber the card number of this ffp beneficiary
	 */
	@Override
	public void setCardNumber(String cardNumber) {
		model.setCardNumber(cardNumber);
	}

	/**
	 * Sets the company ID of this ffp beneficiary.
	 *
	 * @param companyId the company ID of this ffp beneficiary
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this ffp beneficiary.
	 *
	 * @param createDate the create date of this ffp beneficiary
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this ffp beneficiary.
	 *
	 * @param createdBy the created by of this ffp beneficiary
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the date of birth of this ffp beneficiary.
	 *
	 * @param dateOfBirth the date of birth of this ffp beneficiary
	 */
	@Override
	public void setDateOfBirth(Date dateOfBirth) {
		model.setDateOfBirth(dateOfBirth);
	}

	/**
	 * Sets the email address of this ffp beneficiary.
	 *
	 * @param emailAddress the email address of this ffp beneficiary
	 */
	@Override
	public void setEmailAddress(String emailAddress) {
		model.setEmailAddress(emailAddress);
	}

	/**
	 * Sets the family average monthly income of this ffp beneficiary.
	 *
	 * @param familyAverageMonthlyIncome the family average monthly income of this ffp beneficiary
	 */
	@Override
	public void setFamilyAverageMonthlyIncome(
		String familyAverageMonthlyIncome) {

		model.setFamilyAverageMonthlyIncome(familyAverageMonthlyIncome);
	}

	/**
	 * Sets the family earning members of this ffp beneficiary.
	 *
	 * @param familyEarningMembers the family earning members of this ffp beneficiary
	 */
	@Override
	public void setFamilyEarningMembers(int familyEarningMembers) {
		model.setFamilyEarningMembers(familyEarningMembers);
	}

	/**
	 * Sets the father name of this ffp beneficiary.
	 *
	 * @param fatherName the father name of this ffp beneficiary
	 */
	@Override
	public void setFatherName(String fatherName) {
		model.setFatherName(fatherName);
	}

	/**
	 * Sets the gender of this ffp beneficiary.
	 *
	 * @param gender the gender of this ffp beneficiary
	 */
	@Override
	public void setGender(int gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the group ID of this ffp beneficiary.
	 *
	 * @param groupId the group ID of this ffp beneficiary
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the marital status of this ffp beneficiary.
	 *
	 * @param maritalStatus the marital status of this ffp beneficiary
	 */
	@Override
	public void setMaritalStatus(int maritalStatus) {
		model.setMaritalStatus(maritalStatus);
	}

	/**
	 * Sets the mobile number of this ffp beneficiary.
	 *
	 * @param mobileNumber the mobile number of this ffp beneficiary
	 */
	@Override
	public void setMobileNumber(String mobileNumber) {
		model.setMobileNumber(mobileNumber);
	}

	/**
	 * Sets the modified by of this ffp beneficiary.
	 *
	 * @param modifiedBy the modified by of this ffp beneficiary
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this ffp beneficiary.
	 *
	 * @param modifiedDate the modified date of this ffp beneficiary
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mother name of this ffp beneficiary.
	 *
	 * @param motherName the mother name of this ffp beneficiary
	 */
	@Override
	public void setMotherName(String motherName) {
		model.setMotherName(motherName);
	}

	/**
	 * Sets the name of this ffp beneficiary.
	 *
	 * @param name the name of this ffp beneficiary
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the national ID of this ffp beneficiary.
	 *
	 * @param nationalId the national ID of this ffp beneficiary
	 */
	@Override
	public void setNationalId(long nationalId) {
		model.setNationalId(nationalId);
	}

	/**
	 * Sets whether this ffp beneficiary is non of my family members registered.
	 *
	 * @param nonOfMyFamilyMembersRegistered the non of my family members registered of this ffp beneficiary
	 */
	@Override
	public void setNonOfMyFamilyMembersRegistered(
		boolean nonOfMyFamilyMembersRegistered) {

		model.setNonOfMyFamilyMembersRegistered(nonOfMyFamilyMembersRegistered);
	}

	/**
	 * Sets the primary key of this ffp beneficiary.
	 *
	 * @param primaryKey the primary key of this ffp beneficiary
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the spouse date of birth of this ffp beneficiary.
	 *
	 * @param spouseDateOfBirth the spouse date of birth of this ffp beneficiary
	 */
	@Override
	public void setSpouseDateOfBirth(Date spouseDateOfBirth) {
		model.setSpouseDateOfBirth(spouseDateOfBirth);
	}

	/**
	 * Sets the spouse father name of this ffp beneficiary.
	 *
	 * @param spouseFatherName the spouse father name of this ffp beneficiary
	 */
	@Override
	public void setSpouseFatherName(String spouseFatherName) {
		model.setSpouseFatherName(spouseFatherName);
	}

	/**
	 * Sets the spouse name of this ffp beneficiary.
	 *
	 * @param spouseName the spouse name of this ffp beneficiary
	 */
	@Override
	public void setSpouseName(String spouseName) {
		model.setSpouseName(spouseName);
	}

	/**
	 * Sets the spouse national ID of this ffp beneficiary.
	 *
	 * @param spouseNationalId the spouse national ID of this ffp beneficiary
	 */
	@Override
	public void setSpouseNationalId(long spouseNationalId) {
		model.setSpouseNationalId(spouseNationalId);
	}

	/**
	 * Sets the status of this ffp beneficiary.
	 *
	 * @param status the status of this ffp beneficiary
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this ffp beneficiary.
	 *
	 * @param statusByUserId the status by user ID of this ffp beneficiary
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user uuid of this ffp beneficiary.
	 *
	 * @param statusByUserUuid the status by user uuid of this ffp beneficiary
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this ffp beneficiary.
	 *
	 * @param statusDate the status date of this ffp beneficiary
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the uuid of this ffp beneficiary.
	 *
	 * @param uuid the uuid of this ffp beneficiary
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the version of this ffp beneficiary.
	 *
	 * @param version the version of this ffp beneficiary
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
	protected FFPBeneficiaryWrapper wrap(FFPBeneficiary ffpBeneficiary) {
		return new FFPBeneficiaryWrapper(ffpBeneficiary);
	}

}