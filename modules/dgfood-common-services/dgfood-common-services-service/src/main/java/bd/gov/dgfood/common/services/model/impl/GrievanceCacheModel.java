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

package bd.gov.dgfood.common.services.model.impl;

import bd.gov.dgfood.common.services.model.Grievance;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Grievance in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class GrievanceCacheModel
	implements CacheModel<Grievance>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof GrievanceCacheModel)) {
			return false;
		}

		GrievanceCacheModel grievanceCacheModel = (GrievanceCacheModel)object;

		if (grievanceId == grievanceCacheModel.grievanceId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, grievanceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", grievanceId=");
		sb.append(grievanceId);
		sb.append(", grievanceNumber=");
		sb.append(grievanceNumber);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", grievanceCategory=");
		sb.append(grievanceCategory);
		sb.append(", userType=");
		sb.append(userType);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", userID=");
		sb.append(userID);
		sb.append(", mobileNumber=");
		sb.append(mobileNumber);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", complaintDetails=");
		sb.append(complaintDetails);
		sb.append(", attachmentId=");
		sb.append(attachmentId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", responseDetails=");
		sb.append(responseDetails);
		sb.append(", responseDate=");
		sb.append(responseDate);
		sb.append(", responseBy=");
		sb.append(responseBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Grievance toEntityModel() {
		GrievanceImpl grievanceImpl = new GrievanceImpl();

		if (uuid == null) {
			grievanceImpl.setUuid("");
		}
		else {
			grievanceImpl.setUuid(uuid);
		}

		grievanceImpl.setGrievanceId(grievanceId);

		if (grievanceNumber == null) {
			grievanceImpl.setGrievanceNumber("");
		}
		else {
			grievanceImpl.setGrievanceNumber(grievanceNumber);
		}

		grievanceImpl.setCompanyId(companyId);
		grievanceImpl.setGroupId(groupId);
		grievanceImpl.setGrievanceCategory(grievanceCategory);
		grievanceImpl.setUserType(userType);

		if (userName == null) {
			grievanceImpl.setUserName("");
		}
		else {
			grievanceImpl.setUserName(userName);
		}

		grievanceImpl.setUserID(userID);

		if (mobileNumber == null) {
			grievanceImpl.setMobileNumber("");
		}
		else {
			grievanceImpl.setMobileNumber(mobileNumber);
		}

		if (createDate == Long.MIN_VALUE) {
			grievanceImpl.setCreateDate(null);
		}
		else {
			grievanceImpl.setCreateDate(new Date(createDate));
		}

		if (complaintDetails == null) {
			grievanceImpl.setComplaintDetails("");
		}
		else {
			grievanceImpl.setComplaintDetails(complaintDetails);
		}

		grievanceImpl.setAttachmentId(attachmentId);
		grievanceImpl.setStatus(status);

		if (responseDetails == null) {
			grievanceImpl.setResponseDetails("");
		}
		else {
			grievanceImpl.setResponseDetails(responseDetails);
		}

		if (responseDate == Long.MIN_VALUE) {
			grievanceImpl.setResponseDate(null);
		}
		else {
			grievanceImpl.setResponseDate(new Date(responseDate));
		}

		grievanceImpl.setResponseBy(responseBy);

		grievanceImpl.resetOriginalValues();

		return grievanceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		grievanceId = objectInput.readLong();
		grievanceNumber = objectInput.readUTF();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		grievanceCategory = objectInput.readLong();

		userType = objectInput.readLong();
		userName = objectInput.readUTF();

		userID = objectInput.readLong();
		mobileNumber = objectInput.readUTF();
		createDate = objectInput.readLong();
		complaintDetails = objectInput.readUTF();

		attachmentId = objectInput.readLong();

		status = objectInput.readInt();
		responseDetails = objectInput.readUTF();
		responseDate = objectInput.readLong();

		responseBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(grievanceId);

		if (grievanceNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(grievanceNumber);
		}

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(grievanceCategory);

		objectOutput.writeLong(userType);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(userID);

		if (mobileNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobileNumber);
		}

		objectOutput.writeLong(createDate);

		if (complaintDetails == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(complaintDetails);
		}

		objectOutput.writeLong(attachmentId);

		objectOutput.writeInt(status);

		if (responseDetails == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(responseDetails);
		}

		objectOutput.writeLong(responseDate);

		objectOutput.writeLong(responseBy);
	}

	public String uuid;
	public long grievanceId;
	public String grievanceNumber;
	public long companyId;
	public long groupId;
	public long grievanceCategory;
	public long userType;
	public String userName;
	public long userID;
	public String mobileNumber;
	public long createDate;
	public String complaintDetails;
	public long attachmentId;
	public int status;
	public String responseDetails;
	public long responseDate;
	public long responseBy;

}