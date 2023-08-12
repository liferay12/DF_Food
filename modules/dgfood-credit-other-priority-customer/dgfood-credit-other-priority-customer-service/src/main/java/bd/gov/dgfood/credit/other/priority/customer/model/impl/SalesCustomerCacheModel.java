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

import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SalesCustomer in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SalesCustomerCacheModel
	implements CacheModel<SalesCustomer>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SalesCustomerCacheModel)) {
			return false;
		}

		SalesCustomerCacheModel salesCustomerCacheModel =
			(SalesCustomerCacheModel)object;

		if (salesCustomerId == salesCustomerCacheModel.salesCustomerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, salesCustomerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(51);

		sb.append("{uuid=");
		sb.append(uuid);
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
		sb.append(", salesCustomerCode=");
		sb.append(salesCustomerCode);
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
	public SalesCustomer toEntityModel() {
		SalesCustomerImpl salesCustomerImpl = new SalesCustomerImpl();

		if (uuid == null) {
			salesCustomerImpl.setUuid("");
		}
		else {
			salesCustomerImpl.setUuid(uuid);
		}

		salesCustomerImpl.setSalesCustomerId(salesCustomerId);
		salesCustomerImpl.setGroupId(groupId);
		salesCustomerImpl.setCompanyId(companyId);
		salesCustomerImpl.setCreatedBy(createdBy);

		if (createDate == Long.MIN_VALUE) {
			salesCustomerImpl.setCreateDate(null);
		}
		else {
			salesCustomerImpl.setCreateDate(new Date(createDate));
		}

		salesCustomerImpl.setModifiedBy(modifiedBy);

		if (modifiedDate == Long.MIN_VALUE) {
			salesCustomerImpl.setModifiedDate(null);
		}
		else {
			salesCustomerImpl.setModifiedDate(new Date(modifiedDate));
		}

		salesCustomerImpl.setUserId(userId);

		if (userType == null) {
			salesCustomerImpl.setUserType("");
		}
		else {
			salesCustomerImpl.setUserType(userType);
		}

		if (mobileNumber == null) {
			salesCustomerImpl.setMobileNumber("");
		}
		else {
			salesCustomerImpl.setMobileNumber(mobileNumber);
		}

		if (emailAddress == null) {
			salesCustomerImpl.setEmailAddress("");
		}
		else {
			salesCustomerImpl.setEmailAddress(emailAddress);
		}

		if (title == null) {
			salesCustomerImpl.setTitle("");
		}
		else {
			salesCustomerImpl.setTitle(title);
		}

		if (contactPersonName == null) {
			salesCustomerImpl.setContactPersonName("");
		}
		else {
			salesCustomerImpl.setContactPersonName(contactPersonName);
		}

		if (contactPersonDesignation == null) {
			salesCustomerImpl.setContactPersonDesignation("");
		}
		else {
			salesCustomerImpl.setContactPersonDesignation(
				contactPersonDesignation);
		}

		if (officeName == null) {
			salesCustomerImpl.setOfficeName("");
		}
		else {
			salesCustomerImpl.setOfficeName(officeName);
		}

		if (organizationName == null) {
			salesCustomerImpl.setOrganizationName("");
		}
		else {
			salesCustomerImpl.setOrganizationName(organizationName);
		}

		if (organizationType == null) {
			salesCustomerImpl.setOrganizationType("");
		}
		else {
			salesCustomerImpl.setOrganizationType(organizationType);
		}

		salesCustomerImpl.setGender(gender);
		salesCustomerImpl.setSalesCustomerCode(salesCustomerCode);
		salesCustomerImpl.setVersion(version);
		salesCustomerImpl.setStatus(status);
		salesCustomerImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			salesCustomerImpl.setStatusByUserName("");
		}
		else {
			salesCustomerImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			salesCustomerImpl.setStatusDate(null);
		}
		else {
			salesCustomerImpl.setStatusDate(new Date(statusDate));
		}

		salesCustomerImpl.resetOriginalValues();

		return salesCustomerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

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

		salesCustomerCode = objectInput.readLong();

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

		objectOutput.writeLong(salesCustomerCode);

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
	public long salesCustomerCode;
	public double version;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}