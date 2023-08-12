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

import bd.gov.dgfood.common.services.model.DGFUsers;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DGFUsers in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DGFUsersCacheModel
	implements CacheModel<DGFUsers>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DGFUsersCacheModel)) {
			return false;
		}

		DGFUsersCacheModel dgfUsersCacheModel = (DGFUsersCacheModel)object;

		if (dgfUserId == dgfUsersCacheModel.dgfUserId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dgfUserId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{dgfUserId=");
		sb.append(dgfUserId);
		sb.append(", nationalId=");
		sb.append(nationalId);
		sb.append(", password=");
		sb.append(password);
		sb.append(", mobileNumber=");
		sb.append(mobileNumber);
		sb.append(", email=");
		sb.append(email);
		sb.append(", birthDate=");
		sb.append(birthDate);
		sb.append(", maritalStatus=");
		sb.append(maritalStatus);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", presentAddressId=");
		sb.append(presentAddressId);
		sb.append(", profileType=");
		sb.append(profileType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DGFUsers toEntityModel() {
		DGFUsersImpl dgfUsersImpl = new DGFUsersImpl();

		dgfUsersImpl.setDgfUserId(dgfUserId);

		if (nationalId == null) {
			dgfUsersImpl.setNationalId("");
		}
		else {
			dgfUsersImpl.setNationalId(nationalId);
		}

		if (password == null) {
			dgfUsersImpl.setPassword("");
		}
		else {
			dgfUsersImpl.setPassword(password);
		}

		if (mobileNumber == null) {
			dgfUsersImpl.setMobileNumber("");
		}
		else {
			dgfUsersImpl.setMobileNumber(mobileNumber);
		}

		if (email == null) {
			dgfUsersImpl.setEmail("");
		}
		else {
			dgfUsersImpl.setEmail(email);
		}

		if (birthDate == Long.MIN_VALUE) {
			dgfUsersImpl.setBirthDate(null);
		}
		else {
			dgfUsersImpl.setBirthDate(new Date(birthDate));
		}

		if (maritalStatus == null) {
			dgfUsersImpl.setMaritalStatus("");
		}
		else {
			dgfUsersImpl.setMaritalStatus(maritalStatus);
		}

		dgfUsersImpl.setUserId(userId);
		dgfUsersImpl.setPresentAddressId(presentAddressId);

		if (profileType == null) {
			dgfUsersImpl.setProfileType("");
		}
		else {
			dgfUsersImpl.setProfileType(profileType);
		}

		dgfUsersImpl.resetOriginalValues();

		return dgfUsersImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dgfUserId = objectInput.readLong();
		nationalId = objectInput.readUTF();
		password = objectInput.readUTF();
		mobileNumber = objectInput.readUTF();
		email = objectInput.readUTF();
		birthDate = objectInput.readLong();
		maritalStatus = objectInput.readUTF();

		userId = objectInput.readLong();

		presentAddressId = objectInput.readLong();
		profileType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(dgfUserId);

		if (nationalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nationalId);
		}

		if (password == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(password);
		}

		if (mobileNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobileNumber);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		objectOutput.writeLong(birthDate);

		if (maritalStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(maritalStatus);
		}

		objectOutput.writeLong(userId);

		objectOutput.writeLong(presentAddressId);

		if (profileType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(profileType);
		}
	}

	public long dgfUserId;
	public String nationalId;
	public String password;
	public String mobileNumber;
	public String email;
	public long birthDate;
	public String maritalStatus;
	public long userId;
	public long presentAddressId;
	public String profileType;

}