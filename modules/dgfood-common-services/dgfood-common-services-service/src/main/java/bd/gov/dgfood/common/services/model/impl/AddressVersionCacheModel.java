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

import bd.gov.dgfood.common.services.model.AddressVersion;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AddressVersion in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AddressVersionCacheModel
	implements CacheModel<AddressVersion>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AddressVersionCacheModel)) {
			return false;
		}

		AddressVersionCacheModel addressVersionCacheModel =
			(AddressVersionCacheModel)object;

		if (addressVersionId == addressVersionCacheModel.addressVersionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, addressVersionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{addressVersionId=");
		sb.append(addressVersionId);
		sb.append(", region=");
		sb.append(region);
		sb.append(", district=");
		sb.append(district);
		sb.append(", upazilla=");
		sb.append(upazilla);
		sb.append(", cityCorporationOrMunicipality=");
		sb.append(cityCorporationOrMunicipality);
		sb.append(", unionOrWard=");
		sb.append(unionOrWard);
		sb.append(", zipCode=");
		sb.append(zipCode);
		sb.append(", postOffice=");
		sb.append(postOffice);
		sb.append(", villageOrRoad=");
		sb.append(villageOrRoad);
		sb.append(", mouzaOrMoholla=");
		sb.append(mouzaOrMoholla);
		sb.append(", address=");
		sb.append(address);
		sb.append(", addressType=");
		sb.append(addressType);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", className=");
		sb.append(className);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AddressVersion toEntityModel() {
		AddressVersionImpl addressVersionImpl = new AddressVersionImpl();

		addressVersionImpl.setAddressVersionId(addressVersionId);
		addressVersionImpl.setRegion(region);
		addressVersionImpl.setDistrict(district);
		addressVersionImpl.setUpazilla(upazilla);
		addressVersionImpl.setCityCorporationOrMunicipality(
			cityCorporationOrMunicipality);
		addressVersionImpl.setUnionOrWard(unionOrWard);
		addressVersionImpl.setZipCode(zipCode);

		if (postOffice == null) {
			addressVersionImpl.setPostOffice("");
		}
		else {
			addressVersionImpl.setPostOffice(postOffice);
		}

		if (villageOrRoad == null) {
			addressVersionImpl.setVillageOrRoad("");
		}
		else {
			addressVersionImpl.setVillageOrRoad(villageOrRoad);
		}

		if (mouzaOrMoholla == null) {
			addressVersionImpl.setMouzaOrMoholla("");
		}
		else {
			addressVersionImpl.setMouzaOrMoholla(mouzaOrMoholla);
		}

		if (address == null) {
			addressVersionImpl.setAddress("");
		}
		else {
			addressVersionImpl.setAddress(address);
		}

		if (addressType == null) {
			addressVersionImpl.setAddressType("");
		}
		else {
			addressVersionImpl.setAddressType(addressType);
		}

		addressVersionImpl.setClassPK(classPK);

		if (className == null) {
			addressVersionImpl.setClassName("");
		}
		else {
			addressVersionImpl.setClassName(className);
		}

		addressVersionImpl.resetOriginalValues();

		return addressVersionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		addressVersionId = objectInput.readLong();

		region = objectInput.readLong();

		district = objectInput.readLong();

		upazilla = objectInput.readLong();

		cityCorporationOrMunicipality = objectInput.readLong();

		unionOrWard = objectInput.readLong();

		zipCode = objectInput.readLong();
		postOffice = objectInput.readUTF();
		villageOrRoad = objectInput.readUTF();
		mouzaOrMoholla = objectInput.readUTF();
		address = objectInput.readUTF();
		addressType = objectInput.readUTF();

		classPK = objectInput.readLong();
		className = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(addressVersionId);

		objectOutput.writeLong(region);

		objectOutput.writeLong(district);

		objectOutput.writeLong(upazilla);

		objectOutput.writeLong(cityCorporationOrMunicipality);

		objectOutput.writeLong(unionOrWard);

		objectOutput.writeLong(zipCode);

		if (postOffice == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(postOffice);
		}

		if (villageOrRoad == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(villageOrRoad);
		}

		if (mouzaOrMoholla == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mouzaOrMoholla);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (addressType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(addressType);
		}

		objectOutput.writeLong(classPK);

		if (className == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(className);
		}
	}

	public long addressVersionId;
	public long region;
	public long district;
	public long upazilla;
	public long cityCorporationOrMunicipality;
	public long unionOrWard;
	public long zipCode;
	public String postOffice;
	public String villageOrRoad;
	public String mouzaOrMoholla;
	public String address;
	public String addressType;
	public long classPK;
	public String className;

}