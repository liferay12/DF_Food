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

package bd.gov.dgfood.license.management.system.model.impl;

import bd.gov.dgfood.license.management.system.model.FGLicenseInfo;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FGLicenseInfo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FGLicenseInfoCacheModel
	implements CacheModel<FGLicenseInfo>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FGLicenseInfoCacheModel)) {
			return false;
		}

		FGLicenseInfoCacheModel fgLicenseInfoCacheModel =
			(FGLicenseInfoCacheModel)object;

		if (fgLicenseInfoId == fgLicenseInfoCacheModel.fgLicenseInfoId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fgLicenseInfoId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(63);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", fgLicenseInfoId=");
		sb.append(fgLicenseInfoId);
		sb.append(", fgLicenseMasterId=");
		sb.append(fgLicenseMasterId);
		sb.append(", fgLicenseMDMId=");
		sb.append(fgLicenseMDMId);
		sb.append(", nationalId=");
		sb.append(nationalId);
		sb.append(", applicationNumber=");
		sb.append(applicationNumber);
		sb.append(", applicantName=");
		sb.append(applicantName);
		sb.append(", tradeLicenseNumber=");
		sb.append(tradeLicenseNumber);
		sb.append(", foodgrainLicenseNumber=");
		sb.append(foodgrainLicenseNumber);
		sb.append(", foodgrainLicenseIssueDate=");
		sb.append(foodgrainLicenseIssueDate);
		sb.append(", foodgrainLicenseExpiryDate=");
		sb.append(foodgrainLicenseExpiryDate);
		sb.append(", businessName=");
		sb.append(businessName);
		sb.append(", businessType=");
		sb.append(businessType);
		sb.append(", businessAddressId=");
		sb.append(businessAddressId);
		sb.append(", version=");
		sb.append(version);
		sb.append(", applicationType=");
		sb.append(applicationType);
		sb.append(", syncStatus=");
		sb.append(syncStatus);
		sb.append(", isExpired=");
		sb.append(isExpired);
		sb.append(", paymentChallanId=");
		sb.append(paymentChallanId);
		sb.append(", division=");
		sb.append(division);
		sb.append(", district=");
		sb.append(district);
		sb.append(", upazila=");
		sb.append(upazila);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FGLicenseInfo toEntityModel() {
		FGLicenseInfoImpl fgLicenseInfoImpl = new FGLicenseInfoImpl();

		if (uuid == null) {
			fgLicenseInfoImpl.setUuid("");
		}
		else {
			fgLicenseInfoImpl.setUuid(uuid);
		}

		fgLicenseInfoImpl.setFgLicenseInfoId(fgLicenseInfoId);
		fgLicenseInfoImpl.setFgLicenseMasterId(fgLicenseMasterId);
		fgLicenseInfoImpl.setFgLicenseMDMId(fgLicenseMDMId);

		if (nationalId == null) {
			fgLicenseInfoImpl.setNationalId("");
		}
		else {
			fgLicenseInfoImpl.setNationalId(nationalId);
		}

		if (applicationNumber == null) {
			fgLicenseInfoImpl.setApplicationNumber("");
		}
		else {
			fgLicenseInfoImpl.setApplicationNumber(applicationNumber);
		}

		if (applicantName == null) {
			fgLicenseInfoImpl.setApplicantName("");
		}
		else {
			fgLicenseInfoImpl.setApplicantName(applicantName);
		}

		if (tradeLicenseNumber == null) {
			fgLicenseInfoImpl.setTradeLicenseNumber("");
		}
		else {
			fgLicenseInfoImpl.setTradeLicenseNumber(tradeLicenseNumber);
		}

		if (foodgrainLicenseNumber == null) {
			fgLicenseInfoImpl.setFoodgrainLicenseNumber("");
		}
		else {
			fgLicenseInfoImpl.setFoodgrainLicenseNumber(foodgrainLicenseNumber);
		}

		if (foodgrainLicenseIssueDate == Long.MIN_VALUE) {
			fgLicenseInfoImpl.setFoodgrainLicenseIssueDate(null);
		}
		else {
			fgLicenseInfoImpl.setFoodgrainLicenseIssueDate(
				new Date(foodgrainLicenseIssueDate));
		}

		if (foodgrainLicenseExpiryDate == Long.MIN_VALUE) {
			fgLicenseInfoImpl.setFoodgrainLicenseExpiryDate(null);
		}
		else {
			fgLicenseInfoImpl.setFoodgrainLicenseExpiryDate(
				new Date(foodgrainLicenseExpiryDate));
		}

		if (businessName == null) {
			fgLicenseInfoImpl.setBusinessName("");
		}
		else {
			fgLicenseInfoImpl.setBusinessName(businessName);
		}

		if (businessType == null) {
			fgLicenseInfoImpl.setBusinessType("");
		}
		else {
			fgLicenseInfoImpl.setBusinessType(businessType);
		}

		fgLicenseInfoImpl.setBusinessAddressId(businessAddressId);
		fgLicenseInfoImpl.setVersion(version);

		if (applicationType == null) {
			fgLicenseInfoImpl.setApplicationType("");
		}
		else {
			fgLicenseInfoImpl.setApplicationType(applicationType);
		}

		fgLicenseInfoImpl.setSyncStatus(syncStatus);
		fgLicenseInfoImpl.setIsExpired(isExpired);
		fgLicenseInfoImpl.setPaymentChallanId(paymentChallanId);

		if (division == null) {
			fgLicenseInfoImpl.setDivision("");
		}
		else {
			fgLicenseInfoImpl.setDivision(division);
		}

		if (district == null) {
			fgLicenseInfoImpl.setDistrict("");
		}
		else {
			fgLicenseInfoImpl.setDistrict(district);
		}

		if (upazila == null) {
			fgLicenseInfoImpl.setUpazila("");
		}
		else {
			fgLicenseInfoImpl.setUpazila(upazila);
		}

		fgLicenseInfoImpl.setStatus(status);
		fgLicenseInfoImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			fgLicenseInfoImpl.setStatusByUserName("");
		}
		else {
			fgLicenseInfoImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			fgLicenseInfoImpl.setStatusDate(null);
		}
		else {
			fgLicenseInfoImpl.setStatusDate(new Date(statusDate));
		}

		fgLicenseInfoImpl.setGroupId(groupId);
		fgLicenseInfoImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			fgLicenseInfoImpl.setCreateDate(null);
		}
		else {
			fgLicenseInfoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			fgLicenseInfoImpl.setModifiedDate(null);
		}
		else {
			fgLicenseInfoImpl.setModifiedDate(new Date(modifiedDate));
		}

		fgLicenseInfoImpl.setModifiedBy(modifiedBy);

		fgLicenseInfoImpl.resetOriginalValues();

		return fgLicenseInfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		fgLicenseInfoId = objectInput.readLong();

		fgLicenseMasterId = objectInput.readLong();

		fgLicenseMDMId = objectInput.readLong();
		nationalId = objectInput.readUTF();
		applicationNumber = objectInput.readUTF();
		applicantName = objectInput.readUTF();
		tradeLicenseNumber = objectInput.readUTF();
		foodgrainLicenseNumber = objectInput.readUTF();
		foodgrainLicenseIssueDate = objectInput.readLong();
		foodgrainLicenseExpiryDate = objectInput.readLong();
		businessName = objectInput.readUTF();
		businessType = objectInput.readUTF();

		businessAddressId = objectInput.readLong();

		version = objectInput.readDouble();
		applicationType = objectInput.readUTF();

		syncStatus = objectInput.readBoolean();

		isExpired = objectInput.readBoolean();

		paymentChallanId = objectInput.readLong();
		division = objectInput.readUTF();
		district = objectInput.readUTF();
		upazila = objectInput.readUTF();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(fgLicenseInfoId);

		objectOutput.writeLong(fgLicenseMasterId);

		objectOutput.writeLong(fgLicenseMDMId);

		if (nationalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nationalId);
		}

		if (applicationNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(applicationNumber);
		}

		if (applicantName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(applicantName);
		}

		if (tradeLicenseNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tradeLicenseNumber);
		}

		if (foodgrainLicenseNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(foodgrainLicenseNumber);
		}

		objectOutput.writeLong(foodgrainLicenseIssueDate);
		objectOutput.writeLong(foodgrainLicenseExpiryDate);

		if (businessName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(businessName);
		}

		if (businessType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(businessType);
		}

		objectOutput.writeLong(businessAddressId);

		objectOutput.writeDouble(version);

		if (applicationType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(applicationType);
		}

		objectOutput.writeBoolean(syncStatus);

		objectOutput.writeBoolean(isExpired);

		objectOutput.writeLong(paymentChallanId);

		if (division == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(division);
		}

		if (district == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(district);
		}

		if (upazila == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(upazila);
		}

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public String uuid;
	public long fgLicenseInfoId;
	public long fgLicenseMasterId;
	public long fgLicenseMDMId;
	public String nationalId;
	public String applicationNumber;
	public String applicantName;
	public String tradeLicenseNumber;
	public String foodgrainLicenseNumber;
	public long foodgrainLicenseIssueDate;
	public long foodgrainLicenseExpiryDate;
	public String businessName;
	public String businessType;
	public long businessAddressId;
	public double version;
	public String applicationType;
	public boolean syncStatus;
	public boolean isExpired;
	public long paymentChallanId;
	public String division;
	public String district;
	public String upazila;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long modifiedBy;

}