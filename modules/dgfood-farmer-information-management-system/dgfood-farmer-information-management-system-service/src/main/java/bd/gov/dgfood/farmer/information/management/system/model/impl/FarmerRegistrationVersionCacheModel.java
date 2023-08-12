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

package bd.gov.dgfood.farmer.information.management.system.model.impl;

import bd.gov.dgfood.farmer.information.management.system.model.FarmerRegistrationVersion;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

import java.util.Date;
import java.util.Map;

/**
 * The cache model class for representing FarmerRegistrationVersion in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FarmerRegistrationVersionCacheModel
	implements CacheModel<FarmerRegistrationVersion>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FarmerRegistrationVersionCacheModel)) {
			return false;
		}

		FarmerRegistrationVersionCacheModel
			farmerRegistrationVersionCacheModel =
				(FarmerRegistrationVersionCacheModel)object;

		if (farmerRegistrationVersionId ==
				farmerRegistrationVersionCacheModel.
					farmerRegistrationVersionId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, farmerRegistrationVersionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(67);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", farmerRegistrationVersionId=");
		sb.append(farmerRegistrationVersionId);
		sb.append(", applicationNumber=");
		sb.append(applicationNumber);
		sb.append(", farmerRegistrationId=");
		sb.append(farmerRegistrationId);
		sb.append(", nationalId=");
		sb.append(nationalId);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", mobileNumber=");
		sb.append(mobileNumber);
		sb.append(", dateOfBirth=");
		sb.append(dateOfBirth);
		sb.append(", farmerName=");
		sb.append(farmerName);
		sb.append(", fatherName=");
		sb.append(fatherName);
		sb.append(", motherName=");
		sb.append(motherName);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", maritalStatus=");
		sb.append(maritalStatus);
		sb.append(", krishokCardNumber=");
		sb.append(krishokCardNumber);
		sb.append(", cultivableLandSeason1=");
		sb.append(cultivableLandSeason1);
		sb.append(", cultivableLandSeason2=");
		sb.append(cultivableLandSeason2);
		sb.append(", cultivableLandSeason3=");
		sb.append(cultivableLandSeason3);
		sb.append(", farmerCategory =");
		sb.append(farmerCategory);
		sb.append(", password =");
		sb.append(password);
		sb.append(", remarks=");
		sb.append(remarks);
		sb.append(", businessCode=");
		sb.append(businessCode);
		sb.append(", version=");
		sb.append(version);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FarmerRegistrationVersion toEntityModel() {
		FarmerRegistrationVersionImpl farmerRegistrationVersionImpl =
			new FarmerRegistrationVersionImpl();

		if (uuid == null) {
			farmerRegistrationVersionImpl.setUuid("");
		}
		else {
			farmerRegistrationVersionImpl.setUuid(uuid);
		}

		farmerRegistrationVersionImpl.setFarmerRegistrationVersionId(
			farmerRegistrationVersionId);

		if (applicationNumber == null) {
			farmerRegistrationVersionImpl.setApplicationNumber("");
		}
		else {
			farmerRegistrationVersionImpl.setApplicationNumber(
				applicationNumber);
		}

		farmerRegistrationVersionImpl.setFarmerRegistrationId(
			farmerRegistrationId);

		if (nationalId == null) {
			farmerRegistrationVersionImpl.setNationalId("");
		}
		else {
			farmerRegistrationVersionImpl.setNationalId(nationalId);
		}

		if (emailAddress == null) {
			farmerRegistrationVersionImpl.setEmailAddress("");
		}
		else {
			farmerRegistrationVersionImpl.setEmailAddress(emailAddress);
		}

		if (mobileNumber == null) {
			farmerRegistrationVersionImpl.setMobileNumber("");
		}
		else {
			farmerRegistrationVersionImpl.setMobileNumber(mobileNumber);
		}

		if (dateOfBirth == Long.MIN_VALUE) {
			farmerRegistrationVersionImpl.setDateOfBirth(null);
		}
		else {
			farmerRegistrationVersionImpl.setDateOfBirth(new Date(dateOfBirth));
		}

		if (farmerName == null) {
			farmerRegistrationVersionImpl.setFarmerName("");
		}
		else {
			farmerRegistrationVersionImpl.setFarmerName(farmerName);
		}

		if (fatherName == null) {
			farmerRegistrationVersionImpl.setFatherName("");
		}
		else {
			farmerRegistrationVersionImpl.setFatherName(fatherName);
		}

		if (motherName == null) {
			farmerRegistrationVersionImpl.setMotherName("");
		}
		else {
			farmerRegistrationVersionImpl.setMotherName(motherName);
		}

		farmerRegistrationVersionImpl.setGender(gender);
		farmerRegistrationVersionImpl.setMaritalStatus(maritalStatus);

		if (krishokCardNumber == null) {
			farmerRegistrationVersionImpl.setKrishokCardNumber("");
		}
		else {
			farmerRegistrationVersionImpl.setKrishokCardNumber(
				krishokCardNumber);
		}

		farmerRegistrationVersionImpl.setCultivableLandSeason1(
			cultivableLandSeason1);
		farmerRegistrationVersionImpl.setCultivableLandSeason2(
			cultivableLandSeason2);
		farmerRegistrationVersionImpl.setCultivableLandSeason3(
			cultivableLandSeason3);

		if (farmerCategory == null) {
			farmerRegistrationVersionImpl.setFarmerCategory("");
		}
		else {
			farmerRegistrationVersionImpl.setFarmerCategory(farmerCategory);
		}

		if (password == null) {
			farmerRegistrationVersionImpl.setPassword("");
		}
		else {
			farmerRegistrationVersionImpl.setPassword(password);
		}

		if (remarks == null) {
			farmerRegistrationVersionImpl.setRemarks("");
		}
		else {
			farmerRegistrationVersionImpl.setRemarks(remarks);
		}

		if (businessCode == null) {
			farmerRegistrationVersionImpl.setBusinessCode("");
		}
		else {
			farmerRegistrationVersionImpl.setBusinessCode(businessCode);
		}

		farmerRegistrationVersionImpl.setVersion(version);

		if (userId == null) {
			farmerRegistrationVersionImpl.setUserId("");
		}
		else {
			farmerRegistrationVersionImpl.setUserId(userId);
		}

		farmerRegistrationVersionImpl.setGroupId(groupId);
		farmerRegistrationVersionImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			farmerRegistrationVersionImpl.setCreateDate(null);
		}
		else {
			farmerRegistrationVersionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			farmerRegistrationVersionImpl.setModifiedDate(null);
		}
		else {
			farmerRegistrationVersionImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		farmerRegistrationVersionImpl.setCreatedBy(createdBy);
		farmerRegistrationVersionImpl.setModifiedBy(modifiedBy);
		farmerRegistrationVersionImpl.setStatus(status);
		farmerRegistrationVersionImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			farmerRegistrationVersionImpl.setStatusByUserName("");
		}
		else {
			farmerRegistrationVersionImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			farmerRegistrationVersionImpl.setStatusDate(null);
		}
		else {
			farmerRegistrationVersionImpl.setStatusDate(new Date(statusDate));
		}

		farmerRegistrationVersionImpl.resetOriginalValues();

		return farmerRegistrationVersionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		farmerRegistrationVersionId = objectInput.readLong();
		applicationNumber = objectInput.readUTF();

		farmerRegistrationId = objectInput.readLong();
		nationalId = objectInput.readUTF();
		emailAddress = objectInput.readUTF();
		mobileNumber = objectInput.readUTF();
		dateOfBirth = objectInput.readLong();
		farmerName = objectInput.readUTF();
		fatherName = objectInput.readUTF();
		motherName = objectInput.readUTF();

		gender = objectInput.readInt();

		maritalStatus = objectInput.readInt();
		krishokCardNumber = objectInput.readUTF();
		cultivableLandSeason1 =
			(Map<String, Serializable>)objectInput.readObject();
		cultivableLandSeason2 =
			(Map<String, Serializable>)objectInput.readObject();
		cultivableLandSeason3 =
			(Map<String, Serializable>)objectInput.readObject();
		farmerCategory = objectInput.readUTF();
		password = objectInput.readUTF();
		remarks = objectInput.readUTF();
		businessCode = objectInput.readUTF();

		version = objectInput.readDouble();
		userId = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(farmerRegistrationVersionId);

		if (applicationNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(applicationNumber);
		}

		objectOutput.writeLong(farmerRegistrationId);

		if (nationalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nationalId);
		}

		if (emailAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		if (mobileNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobileNumber);
		}

		objectOutput.writeLong(dateOfBirth);

		if (farmerName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(farmerName);
		}

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

		objectOutput.writeInt(gender);

		objectOutput.writeInt(maritalStatus);

		if (krishokCardNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(krishokCardNumber);
		}

		objectOutput.writeObject(cultivableLandSeason1);
		objectOutput.writeObject(cultivableLandSeason2);
		objectOutput.writeObject(cultivableLandSeason3);

		if (farmerCategory == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(farmerCategory);
		}

		if (password == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(password);
		}

		if (remarks == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(remarks);
		}

		if (businessCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(businessCode);
		}

		objectOutput.writeDouble(version);

		if (userId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userId);
		}

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public String uuid;
	public long farmerRegistrationVersionId;
	public String applicationNumber;
	public long farmerRegistrationId;
	public String nationalId;
	public String emailAddress;
	public String mobileNumber;
	public long dateOfBirth;
	public String farmerName;
	public String fatherName;
	public String motherName;
	public int gender;
	public int maritalStatus;
	public String krishokCardNumber;
	public Map<String, Serializable> cultivableLandSeason1;
	public Map<String, Serializable> cultivableLandSeason2;
	public Map<String, Serializable> cultivableLandSeason3;
	public String farmerCategory;
	public String password;
	public String remarks;
	public String businessCode;
	public double version;
	public String userId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long createdBy;
	public long modifiedBy;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}