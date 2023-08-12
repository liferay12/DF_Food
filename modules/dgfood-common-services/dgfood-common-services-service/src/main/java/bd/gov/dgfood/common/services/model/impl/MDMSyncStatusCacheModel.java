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

import bd.gov.dgfood.common.services.model.MDMSyncStatus;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MDMSyncStatus in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MDMSyncStatusCacheModel
	implements CacheModel<MDMSyncStatus>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MDMSyncStatusCacheModel)) {
			return false;
		}

		MDMSyncStatusCacheModel mdmSyncStatusCacheModel =
			(MDMSyncStatusCacheModel)object;

		if (mdmSyncStatusId == mdmSyncStatusCacheModel.mdmSyncStatusId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, mdmSyncStatusId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{mdmSyncStatusId=");
		sb.append(mdmSyncStatusId);
		sb.append(", userType=");
		sb.append(userType);
		sb.append(", className=");
		sb.append(className);
		sb.append(", classPk=");
		sb.append(classPk);
		sb.append(", requestPayload=");
		sb.append(requestPayload);
		sb.append(", mdmEndPoint=");
		sb.append(mdmEndPoint);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MDMSyncStatus toEntityModel() {
		MDMSyncStatusImpl mdmSyncStatusImpl = new MDMSyncStatusImpl();

		mdmSyncStatusImpl.setMdmSyncStatusId(mdmSyncStatusId);

		if (userType == null) {
			mdmSyncStatusImpl.setUserType("");
		}
		else {
			mdmSyncStatusImpl.setUserType(userType);
		}

		if (className == null) {
			mdmSyncStatusImpl.setClassName("");
		}
		else {
			mdmSyncStatusImpl.setClassName(className);
		}

		mdmSyncStatusImpl.setClassPk(classPk);

		if (requestPayload == null) {
			mdmSyncStatusImpl.setRequestPayload("");
		}
		else {
			mdmSyncStatusImpl.setRequestPayload(requestPayload);
		}

		if (mdmEndPoint == null) {
			mdmSyncStatusImpl.setMdmEndPoint("");
		}
		else {
			mdmSyncStatusImpl.setMdmEndPoint(mdmEndPoint);
		}

		mdmSyncStatusImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			mdmSyncStatusImpl.setCreateDate(null);
		}
		else {
			mdmSyncStatusImpl.setCreateDate(new Date(createDate));
		}

		mdmSyncStatusImpl.resetOriginalValues();

		return mdmSyncStatusImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mdmSyncStatusId = objectInput.readLong();
		userType = objectInput.readUTF();
		className = objectInput.readUTF();

		classPk = objectInput.readLong();
		requestPayload = objectInput.readUTF();
		mdmEndPoint = objectInput.readUTF();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mdmSyncStatusId);

		if (userType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userType);
		}

		if (className == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(className);
		}

		objectOutput.writeLong(classPk);

		if (requestPayload == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(requestPayload);
		}

		if (mdmEndPoint == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mdmEndPoint);
		}

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
	}

	public long mdmSyncStatusId;
	public String userType;
	public String className;
	public long classPk;
	public String requestPayload;
	public String mdmEndPoint;
	public long userId;
	public long createDate;

}