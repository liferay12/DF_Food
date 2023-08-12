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

import bd.gov.dgfood.license.management.system.model.FGLicenseMDMData;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing FGLicenseMDMData in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FGLicenseMDMDataCacheModel
	implements CacheModel<FGLicenseMDMData>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FGLicenseMDMDataCacheModel)) {
			return false;
		}

		FGLicenseMDMDataCacheModel fgLicenseMDMDataCacheModel =
			(FGLicenseMDMDataCacheModel)object;

		if (fgLicenseMDMId == fgLicenseMDMDataCacheModel.fgLicenseMDMId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fgLicenseMDMId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", fgLicenseMDMId=");
		sb.append(fgLicenseMDMId);
		sb.append(", fgLicenseInfoId=");
		sb.append(fgLicenseInfoId);
		sb.append(", fgLicenseMasterId=");
		sb.append(fgLicenseMasterId);
		sb.append(", applicationMdmData=");
		sb.append(applicationMdmData);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FGLicenseMDMData toEntityModel() {
		FGLicenseMDMDataImpl fgLicenseMDMDataImpl = new FGLicenseMDMDataImpl();

		if (uuid == null) {
			fgLicenseMDMDataImpl.setUuid("");
		}
		else {
			fgLicenseMDMDataImpl.setUuid(uuid);
		}

		fgLicenseMDMDataImpl.setFgLicenseMDMId(fgLicenseMDMId);
		fgLicenseMDMDataImpl.setFgLicenseInfoId(fgLicenseInfoId);
		fgLicenseMDMDataImpl.setFgLicenseMasterId(fgLicenseMasterId);

		if (applicationMdmData == null) {
			fgLicenseMDMDataImpl.setApplicationMdmData("");
		}
		else {
			fgLicenseMDMDataImpl.setApplicationMdmData(applicationMdmData);
		}

		fgLicenseMDMDataImpl.resetOriginalValues();

		return fgLicenseMDMDataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		fgLicenseMDMId = objectInput.readLong();

		fgLicenseInfoId = objectInput.readLong();

		fgLicenseMasterId = objectInput.readLong();
		applicationMdmData = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(fgLicenseMDMId);

		objectOutput.writeLong(fgLicenseInfoId);

		objectOutput.writeLong(fgLicenseMasterId);

		if (applicationMdmData == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(applicationMdmData);
		}
	}

	public String uuid;
	public long fgLicenseMDMId;
	public long fgLicenseInfoId;
	public long fgLicenseMasterId;
	public String applicationMdmData;

}