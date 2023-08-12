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

import bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FFPBeneficiary in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FFPBeneficiaryCacheModel
	implements CacheModel<FFPBeneficiary>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FFPBeneficiaryCacheModel)) {
			return false;
		}

		FFPBeneficiaryCacheModel ffpBeneficiaryCacheModel =
			(FFPBeneficiaryCacheModel)object;

		if (beneficiaryId == ffpBeneficiaryCacheModel.beneficiaryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, beneficiaryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(61);

		sb.append("{uuid=");
		sb.append(uuid);
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
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FFPBeneficiary toEntityModel() {
		FFPBeneficiaryImpl ffpBeneficiaryImpl = new FFPBeneficiaryImpl();

		if (uuid == null) {
			ffpBeneficiaryImpl.setUuid("");
		}
		else {
			ffpBeneficiaryImpl.setUuid(uuid);
		}

		ffpBeneficiaryImpl.setBeneficiaryId(beneficiaryId);
		ffpBeneficiaryImpl.setGroupId(groupId);
		ffpBeneficiaryImpl.setCompanyId(companyId);
		ffpBeneficiaryImpl.setVersion(version);

		if (name == null) {
			ffpBeneficiaryImpl.setName("");
		}
		else {
			ffpBeneficiaryImpl.setName(name);
		}

		if (mobileNumber == null) {
			ffpBeneficiaryImpl.setMobileNumber("");
		}
		else {
			ffpBeneficiaryImpl.setMobileNumber(mobileNumber);
		}

		ffpBeneficiaryImpl.setNationalId(nationalId);

		if (emailAddress == null) {
			ffpBeneficiaryImpl.setEmailAddress("");
		}
		else {
			ffpBeneficiaryImpl.setEmailAddress(emailAddress);
		}

		if (cardNumber == null) {
			ffpBeneficiaryImpl.setCardNumber("");
		}
		else {
			ffpBeneficiaryImpl.setCardNumber(cardNumber);
		}

		if (dateOfBirth == Long.MIN_VALUE) {
			ffpBeneficiaryImpl.setDateOfBirth(null);
		}
		else {
			ffpBeneficiaryImpl.setDateOfBirth(new Date(dateOfBirth));
		}

		ffpBeneficiaryImpl.setGender(gender);

		if (fatherName == null) {
			ffpBeneficiaryImpl.setFatherName("");
		}
		else {
			ffpBeneficiaryImpl.setFatherName(fatherName);
		}

		if (motherName == null) {
			ffpBeneficiaryImpl.setMotherName("");
		}
		else {
			ffpBeneficiaryImpl.setMotherName(motherName);
		}

		ffpBeneficiaryImpl.setMaritalStatus(maritalStatus);

		if (spouseName == null) {
			ffpBeneficiaryImpl.setSpouseName("");
		}
		else {
			ffpBeneficiaryImpl.setSpouseName(spouseName);
		}

		if (spouseFatherName == null) {
			ffpBeneficiaryImpl.setSpouseFatherName("");
		}
		else {
			ffpBeneficiaryImpl.setSpouseFatherName(spouseFatherName);
		}

		if (spouseDateOfBirth == Long.MIN_VALUE) {
			ffpBeneficiaryImpl.setSpouseDateOfBirth(null);
		}
		else {
			ffpBeneficiaryImpl.setSpouseDateOfBirth(
				new Date(spouseDateOfBirth));
		}

		ffpBeneficiaryImpl.setSpouseNationalId(spouseNationalId);

		if (familyAverageMonthlyIncome == null) {
			ffpBeneficiaryImpl.setFamilyAverageMonthlyIncome("");
		}
		else {
			ffpBeneficiaryImpl.setFamilyAverageMonthlyIncome(
				familyAverageMonthlyIncome);
		}

		ffpBeneficiaryImpl.setFamilyEarningMembers(familyEarningMembers);
		ffpBeneficiaryImpl.setAcknowledge(acknowledge);
		ffpBeneficiaryImpl.setNonOfMyFamilyMembersRegistered(
			nonOfMyFamilyMembersRegistered);
		ffpBeneficiaryImpl.setStatus(status);
		ffpBeneficiaryImpl.setStatusByUserId(statusByUserId);

		if (statusDate == Long.MIN_VALUE) {
			ffpBeneficiaryImpl.setStatusDate(null);
		}
		else {
			ffpBeneficiaryImpl.setStatusDate(new Date(statusDate));
		}

		ffpBeneficiaryImpl.setCreatedBy(createdBy);

		if (createDate == Long.MIN_VALUE) {
			ffpBeneficiaryImpl.setCreateDate(null);
		}
		else {
			ffpBeneficiaryImpl.setCreateDate(new Date(createDate));
		}

		ffpBeneficiaryImpl.setModifiedBy(modifiedBy);

		if (modifiedDate == Long.MIN_VALUE) {
			ffpBeneficiaryImpl.setModifiedDate(null);
		}
		else {
			ffpBeneficiaryImpl.setModifiedDate(new Date(modifiedDate));
		}

		ffpBeneficiaryImpl.resetOriginalValues();

		return ffpBeneficiaryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

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

		modifiedBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

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

		objectOutput.writeLong(modifiedBy);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
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
	public long modifiedBy;
	public long modifiedDate;

}