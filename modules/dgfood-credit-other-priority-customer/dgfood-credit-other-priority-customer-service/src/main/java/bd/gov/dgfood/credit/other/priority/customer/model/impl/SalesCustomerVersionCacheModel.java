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

package bd.gov.dgfood.credit.other.priority.customer.model.impl;

import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerVersion;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SalesCustomerVersion in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SalesCustomerVersionCacheModel
	implements CacheModel<SalesCustomerVersion>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SalesCustomerVersionCacheModel)) {
			return false;
		}

		SalesCustomerVersionCacheModel salesCustomerVersionCacheModel =
			(SalesCustomerVersionCacheModel)object;

		if (salesCustomerVersionId ==
				salesCustomerVersionCacheModel.salesCustomerVersionId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, salesCustomerVersionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(51);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", salesCustomerVersionId=");
		sb.append(salesCustomerVersionId);
		sb.append(", salesCustomerId=");
		sb.append(salesCustomerId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userType=");
		sb.append(userType);
		sb.append(", mobileNumber=");
		sb.append(mobileNumber);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", title=");
		sb.append(title);
		sb.append(", contactPersonName=");
		sb.append(contactPersonName);
		sb.append(", contactPersonDesignation=");
		sb.append(contactPersonDesignation);
		sb.append(", officeName=");
		sb.append(officeName);
		sb.append(", organizationName=");
		sb.append(organizationName);
		sb.append(", organizationType=");
		sb.append(organizationType);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", version=");
		sb.append(version);
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
	public SalesCustomerVersion toEntityModel() {
		SalesCustomerVersionImpl salesCustomerVersionImpl =
			new SalesCustomerVersionImpl();

		if (uuid == null) {
			salesCustomerVersionImpl.setUuid("");
		}
		else {
			salesCustomerVersionImpl.setUuid(uuid);
		}

		salesCustomerVersionImpl.setSalesCustomerVersionId(
			salesCustomerVersionId);
		salesCustomerVersionImpl.setSalesCustomerId(salesCustomerId);
		salesCustomerVersionImpl.setGroupId(groupId);
		salesCustomerVersionImpl.setCompanyId(companyId);
		salesCustomerVersionImpl.setCreatedBy(createdBy);

		if (createDate == Long.MIN_VALUE) {
			salesCustomerVersionImpl.setCreateDate(null);
		}
		else {
			salesCustomerVersionImpl.setCreateDate(new Date(createDate));
		}

		salesCustomerVersionImpl.setModifiedBy(modifiedBy);

		if (modifiedDate == Long.MIN_VALUE) {
			salesCustomerVersionImpl.setModifiedDate(null);
		}
		else {
			salesCustomerVersionImpl.setModifiedDate(new Date(modifiedDate));
		}

		salesCustomerVersionImpl.setUserId(userId);

		if (userType == null) {
			salesCustomerVersionImpl.setUserType("");
		}
		else {
			salesCustomerVersionImpl.setUserType(userType);
		}

		if (mobileNumber == null) {
			salesCustomerVersionImpl.setMobileNumber("");
		}
		else {
			salesCustomerVersionImpl.setMobileNumber(mobileNumber);
		}

		if (emailAddress == null) {
			salesCustomerVersionImpl.setEmailAddress("");
		}
		else {
			salesCustomerVersionImpl.setEmailAddress(emailAddress);
		}

		if (title == null) {
			salesCustomerVersionImpl.setTitle("");
		}
		else {
			salesCustomerVersionImpl.setTitle(title);
		}

		if (contactPersonName == null) {
			salesCustomerVersionImpl.setContactPersonName("");
		}
		else {
			salesCustomerVersionImpl.setContactPersonName(contactPersonName);
		}

		if (contactPersonDesignation == null) {
			salesCustomerVersionImpl.setContactPersonDesignation("");
		}
		else {
			salesCustomerVersionImpl.setContactPersonDesignation(
				contactPersonDesignation);
		}

		if (officeName == null) {
			salesCustomerVersionImpl.setOfficeName("");
		}
		else {
			salesCustomerVersionImpl.setOfficeName(officeName);
		}

		if (organizationName == null) {
			salesCustomerVersionImpl.setOrganizationName("");
		}
		else {
			salesCustomerVersionImpl.setOrganizationName(organizationName);
		}

		if (organizationType == null) {
			salesCustomerVersionImpl.setOrganizationType("");
		}
		else {
			salesCustomerVersionImpl.setOrganizationType(organizationType);
		}

		salesCustomerVersionImpl.setGender(gender);
		salesCustomerVersionImpl.setVersion(version);
		salesCustomerVersionImpl.setStatus(status);
		salesCustomerVersionImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			salesCustomerVersionImpl.setStatusByUserName("");
		}
		else {
			salesCustomerVersionImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			salesCustomerVersionImpl.setStatusDate(null);
		}
		else {
			salesCustomerVersionImpl.setStatusDate(new Date(statusDate));
		}

		salesCustomerVersionImpl.resetOriginalValues();

		return salesCustomerVersionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		salesCustomerVersionId = objectInput.readLong();

		salesCustomerId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		createdBy = objectInput.readLong();
		createDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		userId = objectInput.readLong();
		userType = objectInput.readUTF();
		mobileNumber = objectInput.readUTF();
		emailAddress = objectInput.readUTF();
		title = objectInput.readUTF();
		contactPersonName = objectInput.readUTF();
		contactPersonDesignation = objectInput.readUTF();
		officeName = objectInput.readUTF();
		organizationName = objectInput.readUTF();
		organizationType = objectInput.readUTF();

		gender = objectInput.readInt();

		version = objectInput.readDouble();

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

		objectOutput.writeLong(salesCustomerVersionId);

		objectOutput.writeLong(salesCustomerId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(modifiedBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(userId);

		if (userType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userType);
		}

		if (mobileNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobileNumber);
		}

		if (emailAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (contactPersonName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contactPersonName);
		}

		if (contactPersonDesignation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contactPersonDesignation);
		}

		if (officeName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(officeName);
		}

		if (organizationName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(organizationName);
		}

		if (organizationType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(organizationType);
		}

		objectOutput.writeInt(gender);

		objectOutput.writeDouble(version);

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
	public long salesCustomerVersionId;
	public long salesCustomerId;
	public long groupId;
	public long companyId;
	public long createdBy;
	public long createDate;
	public long modifiedBy;
	public long modifiedDate;
	public long userId;
	public String userType;
	public String mobileNumber;
	public String emailAddress;
	public String title;
	public String contactPersonName;
	public String contactPersonDesignation;
	public String officeName;
	public String organizationName;
	public String organizationType;
	public int gender;
	public double version;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}