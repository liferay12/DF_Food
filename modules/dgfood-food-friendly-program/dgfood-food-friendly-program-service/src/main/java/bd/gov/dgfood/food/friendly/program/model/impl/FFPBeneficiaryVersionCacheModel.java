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

package bd.gov.dgfood.food.friendly.program.model.impl;

import bd.gov.dgfood.food.friendly.program.model.FFPBeneficiaryVersion;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FFPBeneficiaryVersion in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FFPBeneficiaryVersionCacheModel
	implements CacheModel<FFPBeneficiaryVersion>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FFPBeneficiaryVersionCacheModel)) {
			return false;
		}

		FFPBeneficiaryVersionCacheModel ffpBeneficiaryVersionCacheModel =
			(FFPBeneficiaryVersionCacheModel)object;

		if (beneficiaryVersionId ==
				ffpBeneficiaryVersionCacheModel.beneficiaryVersionId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, beneficiaryVersionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(57);

		sb.append("{beneficiaryVersionId=");
		sb.append(beneficiaryVersionId);
		sb.append(", beneficiaryId=");
		sb.append(beneficiaryId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", version=");
		sb.append(version);
		sb.append(", name=");
		sb.append(name);
		sb.append(", mobileNumber=");
		sb.append(mobileNumber);
		sb.append(", nationalId=");
		sb.append(nationalId);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", cardNumber=");
		sb.append(cardNumber);
		sb.append(", dateOfBirth=");
		sb.append(dateOfBirth);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", fatherName=");
		sb.append(fatherName);
		sb.append(", motherName=");
		sb.append(motherName);
		sb.append(", maritalStatus=");
		sb.append(maritalStatus);
		sb.append(", spouseName=");
		sb.append(spouseName);
		sb.append(", spouseFatherName=");
		sb.append(spouseFatherName);
		sb.append(", spouseDateOfBirth=");
		sb.append(spouseDateOfBirth);
		sb.append(", spouseNationalId=");
		sb.append(spouseNationalId);
		sb.append(", familyAverageMonthlyIncome=");
		sb.append(familyAverageMonthlyIncome);
		sb.append(", familyEarningMembers=");
		sb.append(familyEarningMembers);
		sb.append(", acknowledge=");
		sb.append(acknowledge);
		sb.append(", nonOfMyFamilyMembersRegistered=");
		sb.append(nonOfMyFamilyMembersRegistered);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FFPBeneficiaryVersion toEntityModel() {
		FFPBeneficiaryVersionImpl ffpBeneficiaryVersionImpl =
			new FFPBeneficiaryVersionImpl();

		ffpBeneficiaryVersionImpl.setBeneficiaryVersionId(beneficiaryVersionId);
		ffpBeneficiaryVersionImpl.setBeneficiaryId(beneficiaryId);
		ffpBeneficiaryVersionImpl.setGroupId(groupId);
		ffpBeneficiaryVersionImpl.setCompanyId(companyId);
		ffpBeneficiaryVersionImpl.setVersion(version);

		if (name == null) {
			ffpBeneficiaryVersionImpl.setName("");
		}
		else {
			ffpBeneficiaryVersionImpl.setName(name);
		}

		if (mobileNumber == null) {
			ffpBeneficiaryVersionImpl.setMobileNumber("");
		}
		else {
			ffpBeneficiaryVersionImpl.setMobileNumber(mobileNumber);
		}

		ffpBeneficiaryVersionImpl.setNationalId(nationalId);

		if (emailAddress == null) {
			ffpBeneficiaryVersionImpl.setEmailAddress("");
		}
		else {
			ffpBeneficiaryVersionImpl.setEmailAddress(emailAddress);
		}

		if (cardNumber == null) {
			ffpBeneficiaryVersionImpl.setCardNumber("");
		}
		else {
			ffpBeneficiaryVersionImpl.setCardNumber(cardNumber);
		}

		if (dateOfBirth == Long.MIN_VALUE) {
			ffpBeneficiaryVersionImpl.setDateOfBirth(null);
		}
		else {
			ffpBeneficiaryVersionImpl.setDateOfBirth(new Date(dateOfBirth));
		}

		ffpBeneficiaryVersionImpl.setGender(gender);

		if (fatherName == null) {
			ffpBeneficiaryVersionImpl.setFatherName("");
		}
		else {
			ffpBeneficiaryVersionImpl.setFatherName(fatherName);
		}

		if (motherName == null) {
			ffpBeneficiaryVersionImpl.setMotherName("");
		}
		else {
			ffpBeneficiaryVersionImpl.setMotherName(motherName);
		}

		ffpBeneficiaryVersionImpl.setMaritalStatus(maritalStatus);

		if (spouseName == null) {
			ffpBeneficiaryVersionImpl.setSpouseName("");
		}
		else {
			ffpBeneficiaryVersionImpl.setSpouseName(spouseName);
		}

		if (spouseFatherName == null) {
			ffpBeneficiaryVersionImpl.setSpouseFatherName("");
		}
		else {
			ffpBeneficiaryVersionImpl.setSpouseFatherName(spouseFatherName);
		}

		if (spouseDateOfBirth == Long.MIN_VALUE) {
			ffpBeneficiaryVersionImpl.setSpouseDateOfBirth(null);
		}
		else {
			ffpBeneficiaryVersionImpl.setSpouseDateOfBirth(
				new Date(spouseDateOfBirth));
		}

		ffpBeneficiaryVersionImpl.setSpouseNationalId(spouseNationalId);

		if (familyAverageMonthlyIncome == null) {
			ffpBeneficiaryVersionImpl.setFamilyAverageMonthlyIncome("");
		}
		else {
			ffpBeneficiaryVersionImpl.setFamilyAverageMonthlyIncome(
				familyAverageMonthlyIncome);
		}

		ffpBeneficiaryVersionImpl.setFamilyEarningMembers(familyEarningMembers);
		ffpBeneficiaryVersionImpl.setAcknowledge(acknowledge);
		ffpBeneficiaryVersionImpl.setNonOfMyFamilyMembersRegistered(
			nonOfMyFamilyMembersRegistered);
		ffpBeneficiaryVersionImpl.setStatus(status);
		ffpBeneficiaryVersionImpl.setStatusByUserId(statusByUserId);

		if (statusDate == Long.MIN_VALUE) {
			ffpBeneficiaryVersionImpl.setStatusDate(null);
		}
		else {
			ffpBeneficiaryVersionImpl.setStatusDate(new Date(statusDate));
		}

		ffpBeneficiaryVersionImpl.setCreatedBy(createdBy);

		if (createDate == Long.MIN_VALUE) {
			ffpBeneficiaryVersionImpl.setCreateDate(null);
		}
		else {
			ffpBeneficiaryVersionImpl.setCreateDate(new Date(createDate));
		}

		ffpBeneficiaryVersionImpl.resetOriginalValues();

		return ffpBeneficiaryVersionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		beneficiaryVersionId = objectInput.readLong();

		beneficiaryId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		version = objectInput.readDouble();
		name = objectInput.readUTF();
		mobileNumber = objectInput.readUTF();

		nationalId = objectInput.readLong();
		emailAddress = objectInput.readUTF();
		cardNumber = objectInput.readUTF();
		dateOfBirth = objectInput.readLong();

		gender = objectInput.readInt();
		fatherName = objectInput.readUTF();
		motherName = objectInput.readUTF();

		maritalStatus = objectInput.readInt();
		spouseName = objectInput.readUTF();
		spouseFatherName = objectInput.readUTF();
		spouseDateOfBirth = objectInput.readLong();

		spouseNationalId = objectInput.readLong();
		familyAverageMonthlyIncome = objectInput.readUTF();

		familyEarningMembers = objectInput.readInt();

		acknowledge = objectInput.readBoolean();

		nonOfMyFamilyMembersRegistered = objectInput.readBoolean();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(beneficiaryVersionId);

		objectOutput.writeLong(beneficiaryId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeDouble(version);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (mobileNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobileNumber);
		}

		objectOutput.writeLong(nationalId);

		if (emailAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		if (cardNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cardNumber);
		}

		objectOutput.writeLong(dateOfBirth);

		objectOutput.writeInt(gender);

		if (fatherName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fatherName);
		}

		if (motherName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(motherName);
		}

		objectOutput.writeInt(maritalStatus);

		if (spouseName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(spouseName);
		}

		if (spouseFatherName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(spouseFatherName);
		}

		objectOutput.writeLong(spouseDateOfBirth);

		objectOutput.writeLong(spouseNationalId);

		if (familyAverageMonthlyIncome == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(familyAverageMonthlyIncome);
		}

		objectOutput.writeInt(familyEarningMembers);

		objectOutput.writeBoolean(acknowledge);

		objectOutput.writeBoolean(nonOfMyFamilyMembersRegistered);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);
		objectOutput.writeLong(statusDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(createDate);
	}

	public long beneficiaryVersionId;
	public long beneficiaryId;
	public long groupId;
	public long companyId;
	public double version;
	public String name;
	public String mobileNumber;
	public long nationalId;
	public String emailAddress;
	public String cardNumber;
	public long dateOfBirth;
	public int gender;
	public String fatherName;
	public String motherName;
	public int maritalStatus;
	public String spouseName;
	public String spouseFatherName;
	public long spouseDateOfBirth;
	public long spouseNationalId;
	public String familyAverageMonthlyIncome;
	public int familyEarningMembers;
	public boolean acknowledge;
	public boolean nonOfMyFamilyMembersRegistered;
	public int status;
	public long statusByUserId;
	public long statusDate;
	public long createdBy;
	public long createDate;

}