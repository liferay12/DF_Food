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

import bd.gov.dgfood.common.services.model.UserDetails;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing UserDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserDetailsCacheModel
	implements CacheModel<UserDetails>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserDetailsCacheModel)) {
			return false;
		}

		UserDetailsCacheModel userDetailsCacheModel =
			(UserDetailsCacheModel)object;

		if (userDetailsId == userDetailsCacheModel.userDetailsId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userDetailsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{userDetailsId=");
		sb.append(userDetailsId);
		sb.append(", nationalId=");
		sb.append(nationalId);
		sb.append(", applicantName=");
		sb.append(applicantName);
		sb.append(", fatherName=");
		sb.append(fatherName);
		sb.append(", motherName=");
		sb.append(motherName);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", nidPhotoAttachmentId=");
		sb.append(nidPhotoAttachmentId);
		sb.append(", nidDivision=");
		sb.append(nidDivision);
		sb.append(", nidDistrict=");
		sb.append(nidDistrict);
		sb.append(", nidUpzilla=");
		sb.append(nidUpzilla);
		sb.append(", nidUnion=");
		sb.append(nidUnion);
		sb.append(", nidVillage=");
		sb.append(nidVillage);
		sb.append(", nidWard=");
		sb.append(nidWard);
		sb.append(", nidZipCode=");
		sb.append(nidZipCode);
		sb.append(", houseAddress=");
		sb.append(houseAddress);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserDetails toEntityModel() {
		UserDetailsImpl userDetailsImpl = new UserDetailsImpl();

		userDetailsImpl.setUserDetailsId(userDetailsId);

		if (nationalId == null) {
			userDetailsImpl.setNationalId("");
		}
		else {
			userDetailsImpl.setNationalId(nationalId);
		}

		if (applicantName == null) {
			userDetailsImpl.setApplicantName("");
		}
		else {
			userDetailsImpl.setApplicantName(applicantName);
		}

		if (fatherName == null) {
			userDetailsImpl.setFatherName("");
		}
		else {
			userDetailsImpl.setFatherName(fatherName);
		}

		if (motherName == null) {
			userDetailsImpl.setMotherName("");
		}
		else {
			userDetailsImpl.setMotherName(motherName);
		}

		if (gender == null) {
			userDetailsImpl.setGender("");
		}
		else {
			userDetailsImpl.setGender(gender);
		}

		userDetailsImpl.setNidPhotoAttachmentId(nidPhotoAttachmentId);

		if (nidDivision == null) {
			userDetailsImpl.setNidDivision("");
		}
		else {
			userDetailsImpl.setNidDivision(nidDivision);
		}

		if (nidDistrict == null) {
			userDetailsImpl.setNidDistrict("");
		}
		else {
			userDetailsImpl.setNidDistrict(nidDistrict);
		}

		if (nidUpzilla == null) {
			userDetailsImpl.setNidUpzilla("");
		}
		else {
			userDetailsImpl.setNidUpzilla(nidUpzilla);
		}

		if (nidUnion == null) {
			userDetailsImpl.setNidUnion("");
		}
		else {
			userDetailsImpl.setNidUnion(nidUnion);
		}

		if (nidVillage == null) {
			userDetailsImpl.setNidVillage("");
		}
		else {
			userDetailsImpl.setNidVillage(nidVillage);
		}

		if (nidWard == null) {
			userDetailsImpl.setNidWard("");
		}
		else {
			userDetailsImpl.setNidWard(nidWard);
		}

		userDetailsImpl.setNidZipCode(nidZipCode);

		if (houseAddress == null) {
			userDetailsImpl.setHouseAddress("");
		}
		else {
			userDetailsImpl.setHouseAddress(houseAddress);
		}

		userDetailsImpl.resetOriginalValues();

		return userDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userDetailsId = objectInput.readLong();
		nationalId = objectInput.readUTF();
		applicantName = objectInput.readUTF();
		fatherName = objectInput.readUTF();
		motherName = objectInput.readUTF();
		gender = objectInput.readUTF();

		nidPhotoAttachmentId = objectInput.readLong();
		nidDivision = objectInput.readUTF();
		nidDistrict = objectInput.readUTF();
		nidUpzilla = objectInput.readUTF();
		nidUnion = objectInput.readUTF();
		nidVillage = objectInput.readUTF();
		nidWard = objectInput.readUTF();

		nidZipCode = objectInput.readLong();
		houseAddress = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(userDetailsId);

		if (nationalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nationalId);
		}

		if (applicantName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(applicantName);
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

		if (gender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gender);
		}

		objectOutput.writeLong(nidPhotoAttachmentId);

		if (nidDivision == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nidDivision);
		}

		if (nidDistrict == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nidDistrict);
		}

		if (nidUpzilla == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nidUpzilla);
		}

		if (nidUnion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nidUnion);
		}

		if (nidVillage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nidVillage);
		}

		if (nidWard == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nidWard);
		}

		objectOutput.writeLong(nidZipCode);

		if (houseAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(houseAddress);
		}
	}

	public long userDetailsId;
	public String nationalId;
	public String applicantName;
	public String fatherName;
	public String motherName;
	public String gender;
	public long nidPhotoAttachmentId;
	public String nidDivision;
	public String nidDistrict;
	public String nidUpzilla;
	public String nidUnion;
	public String nidVillage;
	public String nidWard;
	public long nidZipCode;
	public String houseAddress;

}