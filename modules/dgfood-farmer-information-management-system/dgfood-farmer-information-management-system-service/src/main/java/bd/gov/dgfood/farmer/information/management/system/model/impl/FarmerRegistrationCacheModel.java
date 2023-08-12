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

import bd.gov.dgfood.farmer.information.management.system.model.FarmerRegistration;

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
 * The cache model class for representing FarmerRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FarmerRegistrationCacheModel
	implements CacheModel<FarmerRegistration>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FarmerRegistrationCacheModel)) {
			return false;
		}

		FarmerRegistrationCacheModel farmerRegistrationCacheModel =
			(FarmerRegistrationCacheModel)object;

		if (farmerRegistrationId ==
				farmerRegistrationCacheModel.farmerRegistrationId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, farmerRegistrationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(65);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", farmerRegistrationId=");
		sb.append(farmerRegistrationId);
		sb.append(", applicationNumber=");
		sb.append(applicationNumber);
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
	public FarmerRegistration toEntityModel() {
		FarmerRegistrationImpl farmerRegistrationImpl =
			new FarmerRegistrationImpl();

		if (uuid == null) {
			farmerRegistrationImpl.setUuid("");
		}
		else {
			farmerRegistrationImpl.setUuid(uuid);
		}

		farmerRegistrationImpl.setFarmerRegistrationId(farmerRegistrationId);

		if (applicationNumber == null) {
			farmerRegistrationImpl.setApplicationNumber("");
		}
		else {
			farmerRegistrationImpl.setApplicationNumber(applicationNumber);
		}

		if (nationalId == null) {
			farmerRegistrationImpl.setNationalId("");
		}
		else {
			farmerRegistrationImpl.setNationalId(nationalId);
		}

		if (emailAddress == null) {
			farmerRegistrationImpl.setEmailAddress("");
		}
		else {
			farmerRegistrationImpl.setEmailAddress(emailAddress);
		}

		if (mobileNumber == null) {
			farmerRegistrationImpl.setMobileNumber("");
		}
		else {
			farmerRegistrationImpl.setMobileNumber(mobileNumber);
		}

		if (dateOfBirth == Long.MIN_VALUE) {
			farmerRegistrationImpl.setDateOfBirth(null);
		}
		else {
			farmerRegistrationImpl.setDateOfBirth(new Date(dateOfBirth));
		}

		if (farmerName == null) {
			farmerRegistrationImpl.setFarmerName("");
		}
		else {
			farmerRegistrationImpl.setFarmerName(farmerName);
		}

		if (fatherName == null) {
			farmerRegistrationImpl.setFatherName("");
		}
		else {
			farmerRegistrationImpl.setFatherName(fatherName);
		}

		if (motherName == null) {
			farmerRegistrationImpl.setMotherName("");
		}
		else {
			farmerRegistrationImpl.setMotherName(motherName);
		}

		farmerRegistrationImpl.setGender(gender);
		farmerRegistrationImpl.setMaritalStatus(maritalStatus);

		if (krishokCardNumber == null) {
			farmerRegistrationImpl.setKrishokCardNumber("");
		}
		else {
			farmerRegistrationImpl.setKrishokCardNumber(krishokCardNumber);
		}

		farmerRegistrationImpl.setCultivableLandSeason1(cultivableLandSeason1);
		farmerRegistrationImpl.setCultivableLandSeason2(cultivableLandSeason2);
		farmerRegistrationImpl.setCultivableLandSeason3(cultivableLandSeason3);

		if (farmerCategory == null) {
			farmerRegistrationImpl.setFarmerCategory("");
		}
		else {
			farmerRegistrationImpl.setFarmerCategory(farmerCategory);
		}

		if (password == null) {
			farmerRegistrationImpl.setPassword("");
		}
		else {
			farmerRegistrationImpl.setPassword(password);
		}

		if (remarks == null) {
			farmerRegistrationImpl.setRemarks("");
		}
		else {
			farmerRegistrationImpl.setRemarks(remarks);
		}

		if (businessCode == null) {
			farmerRegistrationImpl.setBusinessCode("");
		}
		else {
			farmerRegistrationImpl.setBusinessCode(businessCode);
		}

		farmerRegistrationImpl.setVersion(version);
		farmerRegistrationImpl.setUserId(userId);
		farmerRegistrationImpl.setGroupId(groupId);
		farmerRegistrationImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			farmerRegistrationImpl.setCreateDate(null);
		}
		else {
			farmerRegistrationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			farmerRegistrationImpl.setModifiedDate(null);
		}
		else {
			farmerRegistrationImpl.setModifiedDate(new Date(modifiedDate));
		}

		farmerRegistrationImpl.setCreatedBy(createdBy);
		farmerRegistrationImpl.setModifiedBy(modifiedBy);
		farmerRegistrationImpl.setStatus(status);
		farmerRegistrationImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			farmerRegistrationImpl.setStatusByUserName("");
		}
		else {
			farmerRegistrationImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			farmerRegistrationImpl.setStatusDate(null);
		}
		else {
			farmerRegistrationImpl.setStatusDate(new Date(statusDate));
		}

		farmerRegistrationImpl.resetOriginalValues();

		return farmerRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		farmerRegistrationId = objectInput.readLong();
		applicationNumber = objectInput.readUTF();
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

		userId = objectInput.readLong();

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

		objectOutput.writeLong(farmerRegistrationId);

		if (applicationNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(applicationNumber);
		}

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

		objectOutput.writeLong(userId);

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
	public long farmerRegistrationId;
	public String applicationNumber;
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
	public long userId;
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