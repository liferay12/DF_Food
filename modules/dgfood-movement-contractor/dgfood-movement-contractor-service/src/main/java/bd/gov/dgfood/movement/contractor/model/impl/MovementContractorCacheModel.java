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

package bd.gov.dgfood.movement.contractor.model.impl;

import bd.gov.dgfood.movement.contractor.model.MovementContractor;

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
 * The cache model class for representing MovementContractor in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MovementContractorCacheModel
	implements CacheModel<MovementContractor>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MovementContractorCacheModel)) {
			return false;
		}

		MovementContractorCacheModel movementContractorCacheModel =
			(MovementContractorCacheModel)object;

		if (movementContractorId ==
				movementContractorCacheModel.movementContractorId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, movementContractorId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(65);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", movementContractorId=");
		sb.append(movementContractorId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", mobileNumber=");
		sb.append(mobileNumber);
		sb.append(", nationalId=");
		sb.append(nationalId);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
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
		sb.append(", type=");
		sb.append(type);
		sb.append(", organizationName=");
		sb.append(organizationName);
		sb.append(", tradeLicenseNumber=");
		sb.append(tradeLicenseNumber);
		sb.append(", tradeLicenseExpiryDate=");
		sb.append(tradeLicenseExpiryDate);
		sb.append(", vehicle=");
		sb.append(vehicle);
		sb.append(", vehicleCount=");
		sb.append(vehicleCount);
		sb.append(", vehicleCapacity=");
		sb.append(vehicleCapacity);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", password=");
		sb.append(password);
		sb.append(", applicationNumber=");
		sb.append(applicationNumber);
		sb.append(", businessCode=");
		sb.append(businessCode);
		sb.append(", version=");
		sb.append(version);
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
	public MovementContractor toEntityModel() {
		MovementContractorImpl movementContractorImpl =
			new MovementContractorImpl();

		if (uuid == null) {
			movementContractorImpl.setUuid("");
		}
		else {
			movementContractorImpl.setUuid(uuid);
		}

		movementContractorImpl.setMovementContractorId(movementContractorId);
		movementContractorImpl.setGroupId(groupId);
		movementContractorImpl.setCompanyId(companyId);

		if (name == null) {
			movementContractorImpl.setName("");
		}
		else {
			movementContractorImpl.setName(name);
		}

		if (mobileNumber == null) {
			movementContractorImpl.setMobileNumber("");
		}
		else {
			movementContractorImpl.setMobileNumber(mobileNumber);
		}

		movementContractorImpl.setNationalId(nationalId);

		if (emailAddress == null) {
			movementContractorImpl.setEmailAddress("");
		}
		else {
			movementContractorImpl.setEmailAddress(emailAddress);
		}

		if (dateOfBirth == Long.MIN_VALUE) {
			movementContractorImpl.setDateOfBirth(null);
		}
		else {
			movementContractorImpl.setDateOfBirth(new Date(dateOfBirth));
		}

		movementContractorImpl.setGender(gender);

		if (fatherName == null) {
			movementContractorImpl.setFatherName("");
		}
		else {
			movementContractorImpl.setFatherName(fatherName);
		}

		if (motherName == null) {
			movementContractorImpl.setMotherName("");
		}
		else {
			movementContractorImpl.setMotherName(motherName);
		}

		movementContractorImpl.setMaritalStatus(maritalStatus);

		if (type == null) {
			movementContractorImpl.setType("");
		}
		else {
			movementContractorImpl.setType(type);
		}

		if (organizationName == null) {
			movementContractorImpl.setOrganizationName("");
		}
		else {
			movementContractorImpl.setOrganizationName(organizationName);
		}

		if (tradeLicenseNumber == null) {
			movementContractorImpl.setTradeLicenseNumber("");
		}
		else {
			movementContractorImpl.setTradeLicenseNumber(tradeLicenseNumber);
		}

		if (tradeLicenseExpiryDate == Long.MIN_VALUE) {
			movementContractorImpl.setTradeLicenseExpiryDate(null);
		}
		else {
			movementContractorImpl.setTradeLicenseExpiryDate(
				new Date(tradeLicenseExpiryDate));
		}

		if (vehicle == null) {
			movementContractorImpl.setVehicle("");
		}
		else {
			movementContractorImpl.setVehicle(vehicle);
		}

		movementContractorImpl.setVehicleCount(vehicleCount);
		movementContractorImpl.setVehicleCapacity(vehicleCapacity);
		movementContractorImpl.setUserId(userId);

		if (password == null) {
			movementContractorImpl.setPassword("");
		}
		else {
			movementContractorImpl.setPassword(password);
		}

		movementContractorImpl.setApplicationNumber(applicationNumber);
		movementContractorImpl.setBusinessCode(businessCode);
		movementContractorImpl.setVersion(version);
		movementContractorImpl.setStatus(status);
		movementContractorImpl.setStatusByUserId(statusByUserId);

		if (statusDate == Long.MIN_VALUE) {
			movementContractorImpl.setStatusDate(null);
		}
		else {
			movementContractorImpl.setStatusDate(new Date(statusDate));
		}

		movementContractorImpl.setCreatedBy(createdBy);

		if (createDate == Long.MIN_VALUE) {
			movementContractorImpl.setCreateDate(null);
		}
		else {
			movementContractorImpl.setCreateDate(new Date(createDate));
		}

		movementContractorImpl.setModifiedBy(modifiedBy);

		if (modifiedDate == Long.MIN_VALUE) {
			movementContractorImpl.setModifiedDate(null);
		}
		else {
			movementContractorImpl.setModifiedDate(new Date(modifiedDate));
		}

		movementContractorImpl.resetOriginalValues();

		return movementContractorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		movementContractorId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		name = objectInput.readUTF();
		mobileNumber = objectInput.readUTF();

		nationalId = objectInput.readLong();
		emailAddress = objectInput.readUTF();
		dateOfBirth = objectInput.readLong();

		gender = objectInput.readInt();
		fatherName = objectInput.readUTF();
		motherName = objectInput.readUTF();

		maritalStatus = objectInput.readInt();
		type = objectInput.readUTF();
		organizationName = objectInput.readUTF();
		tradeLicenseNumber = objectInput.readUTF();
		tradeLicenseExpiryDate = objectInput.readLong();
		vehicle = objectInput.readUTF();

		vehicleCount = objectInput.readInt();
		vehicleCapacity = (Map<String, Serializable>)objectInput.readObject();

		userId = objectInput.readLong();
		password = objectInput.readUTF();

		applicationNumber = objectInput.readLong();

		businessCode = objectInput.readLong();

		version = objectInput.readDouble();

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

		objectOutput.writeLong(movementContractorId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

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

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (organizationName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(organizationName);
		}

		if (tradeLicenseNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tradeLicenseNumber);
		}

		objectOutput.writeLong(tradeLicenseExpiryDate);

		if (vehicle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehicle);
		}

		objectOutput.writeInt(vehicleCount);
		objectOutput.writeObject(vehicleCapacity);

		objectOutput.writeLong(userId);

		if (password == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(password);
		}

		objectOutput.writeLong(applicationNumber);

		objectOutput.writeLong(businessCode);

		objectOutput.writeDouble(version);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);
		objectOutput.writeLong(statusDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(modifiedBy);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long movementContractorId;
	public long groupId;
	public long companyId;
	public String name;
	public String mobileNumber;
	public long nationalId;
	public String emailAddress;
	public long dateOfBirth;
	public int gender;
	public String fatherName;
	public String motherName;
	public int maritalStatus;
	public String type;
	public String organizationName;
	public String tradeLicenseNumber;
	public long tradeLicenseExpiryDate;
	public String vehicle;
	public int vehicleCount;
	public Map<String, Serializable> vehicleCapacity;
	public long userId;
	public String password;
	public long applicationNumber;
	public long businessCode;
	public double version;
	public int status;
	public long statusByUserId;
	public long statusDate;
	public long createdBy;
	public long createDate;
	public long modifiedBy;
	public long modifiedDate;

}