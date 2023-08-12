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

import bd.gov.dgfood.common.services.model.BankAccountInformation;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BankAccountInformation in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BankAccountInformationCacheModel
	implements CacheModel<BankAccountInformation>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BankAccountInformationCacheModel)) {
			return false;
		}

		BankAccountInformationCacheModel bankAccountInformationCacheModel =
			(BankAccountInformationCacheModel)object;

		if (bankAccountInformationId ==
				bankAccountInformationCacheModel.bankAccountInformationId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, bankAccountInformationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", bankAccountInformationId=");
		sb.append(bankAccountInformationId);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", accountNumber=");
		sb.append(accountNumber);
		sb.append(", bankName=");
		sb.append(bankName);
		sb.append(", branchName=");
		sb.append(branchName);
		sb.append(", routingCode=");
		sb.append(routingCode);
		sb.append(", status=");
		sb.append(status);
		sb.append(", version=");
		sb.append(version);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", classNameId=");
		sb.append(classNameId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BankAccountInformation toEntityModel() {
		BankAccountInformationImpl bankAccountInformationImpl =
			new BankAccountInformationImpl();

		if (uuid == null) {
			bankAccountInformationImpl.setUuid("");
		}
		else {
			bankAccountInformationImpl.setUuid(uuid);
		}

		bankAccountInformationImpl.setBankAccountInformationId(
			bankAccountInformationId);
		bankAccountInformationImpl.setCreatedBy(createdBy);

		if (createDate == Long.MIN_VALUE) {
			bankAccountInformationImpl.setCreateDate(null);
		}
		else {
			bankAccountInformationImpl.setCreateDate(new Date(createDate));
		}

		if (accountNumber == null) {
			bankAccountInformationImpl.setAccountNumber("");
		}
		else {
			bankAccountInformationImpl.setAccountNumber(accountNumber);
		}

		if (bankName == null) {
			bankAccountInformationImpl.setBankName("");
		}
		else {
			bankAccountInformationImpl.setBankName(bankName);
		}

		if (branchName == null) {
			bankAccountInformationImpl.setBranchName("");
		}
		else {
			bankAccountInformationImpl.setBranchName(branchName);
		}

		if (routingCode == null) {
			bankAccountInformationImpl.setRoutingCode("");
		}
		else {
			bankAccountInformationImpl.setRoutingCode(routingCode);
		}

		bankAccountInformationImpl.setStatus(status);

		if (version == null) {
			bankAccountInformationImpl.setVersion("");
		}
		else {
			bankAccountInformationImpl.setVersion(version);
		}

		bankAccountInformationImpl.setClassPK(classPK);
		bankAccountInformationImpl.setClassNameId(classNameId);

		bankAccountInformationImpl.resetOriginalValues();

		return bankAccountInformationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		bankAccountInformationId = objectInput.readLong();

		createdBy = objectInput.readLong();
		createDate = objectInput.readLong();
		accountNumber = objectInput.readUTF();
		bankName = objectInput.readUTF();
		branchName = objectInput.readUTF();
		routingCode = objectInput.readUTF();

		status = objectInput.readInt();
		version = objectInput.readUTF();

		classPK = objectInput.readLong();

		classNameId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(bankAccountInformationId);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(createDate);

		if (accountNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(accountNumber);
		}

		if (bankName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bankName);
		}

		if (branchName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(branchName);
		}

		if (routingCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(routingCode);
		}

		objectOutput.writeInt(status);

		if (version == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(version);
		}

		objectOutput.writeLong(classPK);

		objectOutput.writeLong(classNameId);
	}

	public String uuid;
	public long bankAccountInformationId;
	public long createdBy;
	public long createDate;
	public String accountNumber;
	public String bankName;
	public String branchName;
	public String routingCode;
	public int status;
	public String version;
	public long classPK;
	public long classNameId;

}