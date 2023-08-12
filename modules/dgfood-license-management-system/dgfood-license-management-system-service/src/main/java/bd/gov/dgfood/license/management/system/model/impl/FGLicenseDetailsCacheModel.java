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

import bd.gov.dgfood.license.management.system.model.FGLicenseDetails;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FGLicenseDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FGLicenseDetailsCacheModel
	implements CacheModel<FGLicenseDetails>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FGLicenseDetailsCacheModel)) {
			return false;
		}

		FGLicenseDetailsCacheModel fgLicenseDetailsCacheModel =
			(FGLicenseDetailsCacheModel)object;

		if (fgLicenseMasterId == fgLicenseDetailsCacheModel.fgLicenseMasterId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fgLicenseMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", fgLicenseMasterId=");
		sb.append(fgLicenseMasterId);
		sb.append(", nationalId=");
		sb.append(nationalId);
		sb.append(", applicationNumber=");
		sb.append(applicationNumber);
		sb.append(", applicantName=");
		sb.append(applicantName);
		sb.append(", tradeLicenseNumber=");
		sb.append(tradeLicenseNumber);
		sb.append(", tradeLicenseExpiryDate=");
		sb.append(tradeLicenseExpiryDate);
		sb.append(", tradeLicenseIssuerCode=");
		sb.append(tradeLicenseIssuerCode);
		sb.append(", tradeLicenseIssuerCity=");
		sb.append(tradeLicenseIssuerCity);
		sb.append(", businessIdentificationNumber=");
		sb.append(businessIdentificationNumber);
		sb.append(", taxIdentificationNumber=");
		sb.append(taxIdentificationNumber);
		sb.append(", paymentChallanId=");
		sb.append(paymentChallanId);
		sb.append(", tradeLicenseDocId=");
		sb.append(tradeLicenseDocId);
		sb.append(", businessIdentificationDocId=");
		sb.append(businessIdentificationDocId);
		sb.append(", taxIdentfctDocId=");
		sb.append(taxIdentfctDocId);
		sb.append(", bankStatementDocId=");
		sb.append(bankStatementDocId);
		sb.append(", reviewComments=");
		sb.append(reviewComments);
		sb.append(", comments=");
		sb.append(comments);
		sb.append(", duplicateLicenseReasonId=");
		sb.append(duplicateLicenseReasonId);
		sb.append(", applicationType=");
		sb.append(applicationType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FGLicenseDetails toEntityModel() {
		FGLicenseDetailsImpl fgLicenseDetailsImpl = new FGLicenseDetailsImpl();

		if (uuid == null) {
			fgLicenseDetailsImpl.setUuid("");
		}
		else {
			fgLicenseDetailsImpl.setUuid(uuid);
		}

		fgLicenseDetailsImpl.setFgLicenseMasterId(fgLicenseMasterId);

		if (nationalId == null) {
			fgLicenseDetailsImpl.setNationalId("");
		}
		else {
			fgLicenseDetailsImpl.setNationalId(nationalId);
		}

		if (applicationNumber == null) {
			fgLicenseDetailsImpl.setApplicationNumber("");
		}
		else {
			fgLicenseDetailsImpl.setApplicationNumber(applicationNumber);
		}

		if (applicantName == null) {
			fgLicenseDetailsImpl.setApplicantName("");
		}
		else {
			fgLicenseDetailsImpl.setApplicantName(applicantName);
		}

		if (tradeLicenseNumber == null) {
			fgLicenseDetailsImpl.setTradeLicenseNumber("");
		}
		else {
			fgLicenseDetailsImpl.setTradeLicenseNumber(tradeLicenseNumber);
		}

		if (tradeLicenseExpiryDate == Long.MIN_VALUE) {
			fgLicenseDetailsImpl.setTradeLicenseExpiryDate(null);
		}
		else {
			fgLicenseDetailsImpl.setTradeLicenseExpiryDate(
				new Date(tradeLicenseExpiryDate));
		}

		if (tradeLicenseIssuerCode == null) {
			fgLicenseDetailsImpl.setTradeLicenseIssuerCode("");
		}
		else {
			fgLicenseDetailsImpl.setTradeLicenseIssuerCode(
				tradeLicenseIssuerCode);
		}

		if (tradeLicenseIssuerCity == null) {
			fgLicenseDetailsImpl.setTradeLicenseIssuerCity("");
		}
		else {
			fgLicenseDetailsImpl.setTradeLicenseIssuerCity(
				tradeLicenseIssuerCity);
		}

		if (businessIdentificationNumber == null) {
			fgLicenseDetailsImpl.setBusinessIdentificationNumber("");
		}
		else {
			fgLicenseDetailsImpl.setBusinessIdentificationNumber(
				businessIdentificationNumber);
		}

		if (taxIdentificationNumber == null) {
			fgLicenseDetailsImpl.setTaxIdentificationNumber("");
		}
		else {
			fgLicenseDetailsImpl.setTaxIdentificationNumber(
				taxIdentificationNumber);
		}

		fgLicenseDetailsImpl.setPaymentChallanId(paymentChallanId);
		fgLicenseDetailsImpl.setTradeLicenseDocId(tradeLicenseDocId);
		fgLicenseDetailsImpl.setBusinessIdentificationDocId(
			businessIdentificationDocId);
		fgLicenseDetailsImpl.setTaxIdentfctDocId(taxIdentfctDocId);
		fgLicenseDetailsImpl.setBankStatementDocId(bankStatementDocId);

		if (reviewComments == null) {
			fgLicenseDetailsImpl.setReviewComments("");
		}
		else {
			fgLicenseDetailsImpl.setReviewComments(reviewComments);
		}

		if (comments == null) {
			fgLicenseDetailsImpl.setComments("");
		}
		else {
			fgLicenseDetailsImpl.setComments(comments);
		}

		if (duplicateLicenseReasonId == null) {
			fgLicenseDetailsImpl.setDuplicateLicenseReasonId("");
		}
		else {
			fgLicenseDetailsImpl.setDuplicateLicenseReasonId(
				duplicateLicenseReasonId);
		}

		if (applicationType == null) {
			fgLicenseDetailsImpl.setApplicationType("");
		}
		else {
			fgLicenseDetailsImpl.setApplicationType(applicationType);
		}

		fgLicenseDetailsImpl.resetOriginalValues();

		return fgLicenseDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		fgLicenseMasterId = objectInput.readLong();
		nationalId = objectInput.readUTF();
		applicationNumber = objectInput.readUTF();
		applicantName = objectInput.readUTF();
		tradeLicenseNumber = objectInput.readUTF();
		tradeLicenseExpiryDate = objectInput.readLong();
		tradeLicenseIssuerCode = objectInput.readUTF();
		tradeLicenseIssuerCity = objectInput.readUTF();
		businessIdentificationNumber = objectInput.readUTF();
		taxIdentificationNumber = objectInput.readUTF();

		paymentChallanId = objectInput.readLong();

		tradeLicenseDocId = objectInput.readLong();

		businessIdentificationDocId = objectInput.readLong();

		taxIdentfctDocId = objectInput.readLong();

		bankStatementDocId = objectInput.readLong();
		reviewComments = objectInput.readUTF();
		comments = objectInput.readUTF();
		duplicateLicenseReasonId = objectInput.readUTF();
		applicationType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(fgLicenseMasterId);

		if (nationalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nationalId);
		}

		if (applicationNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(applicationNumber);
		}

		if (applicantName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(applicantName);
		}

		if (tradeLicenseNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tradeLicenseNumber);
		}

		objectOutput.writeLong(tradeLicenseExpiryDate);

		if (tradeLicenseIssuerCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tradeLicenseIssuerCode);
		}

		if (tradeLicenseIssuerCity == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tradeLicenseIssuerCity);
		}

		if (businessIdentificationNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(businessIdentificationNumber);
		}

		if (taxIdentificationNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(taxIdentificationNumber);
		}

		objectOutput.writeLong(paymentChallanId);

		objectOutput.writeLong(tradeLicenseDocId);

		objectOutput.writeLong(businessIdentificationDocId);

		objectOutput.writeLong(taxIdentfctDocId);

		objectOutput.writeLong(bankStatementDocId);

		if (reviewComments == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(reviewComments);
		}

		if (comments == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(comments);
		}

		if (duplicateLicenseReasonId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(duplicateLicenseReasonId);
		}

		if (applicationType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(applicationType);
		}
	}

	public String uuid;
	public long fgLicenseMasterId;
	public String nationalId;
	public String applicationNumber;
	public String applicantName;
	public String tradeLicenseNumber;
	public long tradeLicenseExpiryDate;
	public String tradeLicenseIssuerCode;
	public String tradeLicenseIssuerCity;
	public String businessIdentificationNumber;
	public String taxIdentificationNumber;
	public long paymentChallanId;
	public long tradeLicenseDocId;
	public long businessIdentificationDocId;
	public long taxIdentfctDocId;
	public long bankStatementDocId;
	public String reviewComments;
	public String comments;
	public String duplicateLicenseReasonId;
	public String applicationType;

}