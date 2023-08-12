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

import bd.gov.dgfood.common.services.model.UserLocation;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserLocation in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserLocationCacheModel
	implements CacheModel<UserLocation>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserLocationCacheModel)) {
			return false;
		}

		UserLocationCacheModel userLocationCacheModel =
			(UserLocationCacheModel)object;

		if (userLocationId == userLocationCacheModel.userLocationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userLocationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", userLocationId=");
		sb.append(userLocationId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", locationName=");
		sb.append(locationName);
		sb.append(", locationCode=");
		sb.append(locationCode);
		sb.append(", locationId=");
		sb.append(locationId);
		sb.append(", locationType=");
		sb.append(locationType);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", roleKey=");
		sb.append(roleKey);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserLocation toEntityModel() {
		UserLocationImpl userLocationImpl = new UserLocationImpl();

		if (uuid == null) {
			userLocationImpl.setUuid("");
		}
		else {
			userLocationImpl.setUuid(uuid);
		}

		userLocationImpl.setUserLocationId(userLocationId);
		userLocationImpl.setCompanyId(companyId);
		userLocationImpl.setGroupId(groupId);

		if (locationName == null) {
			userLocationImpl.setLocationName("");
		}
		else {
			userLocationImpl.setLocationName(locationName);
		}

		if (locationCode == null) {
			userLocationImpl.setLocationCode("");
		}
		else {
			userLocationImpl.setLocationCode(locationCode);
		}

		userLocationImpl.setLocationId(locationId);

		if (locationType == null) {
			userLocationImpl.setLocationType("");
		}
		else {
			userLocationImpl.setLocationType(locationType);
		}

		if (userName == null) {
			userLocationImpl.setUserName("");
		}
		else {
			userLocationImpl.setUserName(userName);
		}

		userLocationImpl.setUserId(userId);

		if (roleKey == null) {
			userLocationImpl.setRoleKey("");
		}
		else {
			userLocationImpl.setRoleKey(roleKey);
		}

		if (createDate == Long.MIN_VALUE) {
			userLocationImpl.setCreateDate(null);
		}
		else {
			userLocationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userLocationImpl.setModifiedDate(null);
		}
		else {
			userLocationImpl.setModifiedDate(new Date(modifiedDate));
		}

		userLocationImpl.setCreatedBy(createdBy);
		userLocationImpl.setModifiedBy(modifiedBy);

		userLocationImpl.resetOriginalValues();

		return userLocationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		userLocationId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();
		locationName = objectInput.readUTF();
		locationCode = objectInput.readUTF();

		locationId = objectInput.readLong();
		locationType = objectInput.readUTF();
		userName = objectInput.readUTF();

		userId = objectInput.readLong();
		roleKey = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		createdBy = objectInput.readLong();

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

		objectOutput.writeLong(userLocationId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		if (locationName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(locationName);
		}

		if (locationCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(locationCode);
		}

		objectOutput.writeLong(locationId);

		if (locationType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(locationType);
		}

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(userId);

		if (roleKey == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(roleKey);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);
	}

	public String uuid;
	public long userLocationId;
	public long companyId;
	public long groupId;
	public String locationName;
	public String locationCode;
	public long locationId;
	public String locationType;
	public String userName;
	public long userId;
	public String roleKey;
	public long createDate;
	public long modifiedDate;
	public long createdBy;
	public long modifiedBy;

}