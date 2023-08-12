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

package bd.gov.dgfood.farmer.information.management.system.model.impl;

import bd.gov.dgfood.farmer.information.management.system.model.FarmerSalesProposal;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

import java.util.Date;
import java.util.Map;

/**
 * The cache model class for representing FarmerSalesProposal in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FarmerSalesProposalCacheModel
	implements CacheModel<FarmerSalesProposal>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FarmerSalesProposalCacheModel)) {
			return false;
		}

		FarmerSalesProposalCacheModel farmerSalesProposalCacheModel =
			(FarmerSalesProposalCacheModel)object;

		if (farmerSalesProposalId ==
				farmerSalesProposalCacheModel.farmerSalesProposalId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, farmerSalesProposalId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(77);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", farmerSalesProposalId=");
		sb.append(farmerSalesProposalId);
		sb.append(", applicationNumber=");
		sb.append(applicationNumber);
		sb.append(", farmerRegistrationId=");
		sb.append(farmerRegistrationId);
		sb.append(", businessCode=");
		sb.append(businessCode);
		sb.append(", currentSeason=");
		sb.append(currentSeason);
		sb.append(", foodGrainType=");
		sb.append(foodGrainType);
		sb.append(", krishiCardNumber=");
		sb.append(krishiCardNumber);
		sb.append(", pastProdDataSeason1=");
		sb.append(pastProdDataSeason1);
		sb.append(", pastProdDataSeason2=");
		sb.append(pastProdDataSeason2);
		sb.append(", pastProdDataSeason3=");
		sb.append(pastProdDataSeason3);
		sb.append(", succeedingProdDataSeason1=");
		sb.append(succeedingProdDataSeason1);
		sb.append(", succeedingProdDataSeason2=");
		sb.append(succeedingProdDataSeason2);
		sb.append(", succeedingProdDataSeason3=");
		sb.append(succeedingProdDataSeason3);
		sb.append(", grainProcuredInLast4Seasons =");
		sb.append(grainProcuredInLast4Seasons);
		sb.append(", foodgranProcuredSeason1=");
		sb.append(foodgranProcuredSeason1);
		sb.append(", foodgranProcuredSeason2=");
		sb.append(foodgranProcuredSeason2);
		sb.append(", foodgranProcuredSeason3=");
		sb.append(foodgranProcuredSeason3);
		sb.append(", foodgranProcuredSeason4=");
		sb.append(foodgranProcuredSeason4);
		sb.append(", cultivableLandSeason1=");
		sb.append(cultivableLandSeason1);
		sb.append(", cultivableLandSeason2=");
		sb.append(cultivableLandSeason2);
		sb.append(", cultivableLandSeason3=");
		sb.append(cultivableLandSeason3);
		sb.append(", foodgrainReceivedStatus=");
		sb.append(foodgrainReceivedStatus);
		sb.append(", receivedFoodgrainQty=");
		sb.append(receivedFoodgrainQty);
		sb.append(", foodgrainReceivedDate=");
		sb.append(foodgrainReceivedDate);
		sb.append(", paymentStatus=");
		sb.append(paymentStatus);
		sb.append(", remarks=");
		sb.append(remarks);
		sb.append(", version=");
		sb.append(version);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
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
	public FarmerSalesProposal toEntityModel() {
		FarmerSalesProposalImpl farmerSalesProposalImpl =
			new FarmerSalesProposalImpl();

		if (uuid == null) {
			farmerSalesProposalImpl.setUuid("");
		}
		else {
			farmerSalesProposalImpl.setUuid(uuid);
		}

		farmerSalesProposalImpl.setFarmerSalesProposalId(farmerSalesProposalId);

		if (applicationNumber == null) {
			farmerSalesProposalImpl.setApplicationNumber("");
		}
		else {
			farmerSalesProposalImpl.setApplicationNumber(applicationNumber);
		}

		farmerSalesProposalImpl.setFarmerRegistrationId(farmerRegistrationId);

		if (businessCode == null) {
			farmerSalesProposalImpl.setBusinessCode("");
		}
		else {
			farmerSalesProposalImpl.setBusinessCode(businessCode);
		}

		if (currentSeason == null) {
			farmerSalesProposalImpl.setCurrentSeason("");
		}
		else {
			farmerSalesProposalImpl.setCurrentSeason(currentSeason);
		}

		if (foodGrainType == null) {
			farmerSalesProposalImpl.setFoodGrainType("");
		}
		else {
			farmerSalesProposalImpl.setFoodGrainType(foodGrainType);
		}

		if (krishiCardNumber == null) {
			farmerSalesProposalImpl.setKrishiCardNumber("");
		}
		else {
			farmerSalesProposalImpl.setKrishiCardNumber(krishiCardNumber);
		}

		farmerSalesProposalImpl.setPastProdDataSeason1(pastProdDataSeason1);
		farmerSalesProposalImpl.setPastProdDataSeason2(pastProdDataSeason2);
		farmerSalesProposalImpl.setPastProdDataSeason3(pastProdDataSeason3);
		farmerSalesProposalImpl.setSucceedingProdDataSeason1(
			succeedingProdDataSeason1);
		farmerSalesProposalImpl.setSucceedingProdDataSeason2(
			succeedingProdDataSeason2);
		farmerSalesProposalImpl.setSucceedingProdDataSeason3(
			succeedingProdDataSeason3);
		farmerSalesProposalImpl.setGrainProcuredInLast4Seasons(
			grainProcuredInLast4Seasons);
		farmerSalesProposalImpl.setFoodgranProcuredSeason1(
			foodgranProcuredSeason1);
		farmerSalesProposalImpl.setFoodgranProcuredSeason2(
			foodgranProcuredSeason2);
		farmerSalesProposalImpl.setFoodgranProcuredSeason3(
			foodgranProcuredSeason3);
		farmerSalesProposalImpl.setFoodgranProcuredSeason4(
			foodgranProcuredSeason4);
		farmerSalesProposalImpl.setCultivableLandSeason1(cultivableLandSeason1);
		farmerSalesProposalImpl.setCultivableLandSeason2(cultivableLandSeason2);
		farmerSalesProposalImpl.setCultivableLandSeason3(cultivableLandSeason3);
		farmerSalesProposalImpl.setFoodgrainReceivedStatus(
			foodgrainReceivedStatus);
		farmerSalesProposalImpl.setReceivedFoodgrainQty(receivedFoodgrainQty);

		if (foodgrainReceivedDate == Long.MIN_VALUE) {
			farmerSalesProposalImpl.setFoodgrainReceivedDate(null);
		}
		else {
			farmerSalesProposalImpl.setFoodgrainReceivedDate(
				new Date(foodgrainReceivedDate));
		}

		farmerSalesProposalImpl.setPaymentStatus(paymentStatus);

		if (remarks == null) {
			farmerSalesProposalImpl.setRemarks("");
		}
		else {
			farmerSalesProposalImpl.setRemarks(remarks);
		}

		farmerSalesProposalImpl.setVersion(version);
		farmerSalesProposalImpl.setGroupId(groupId);
		farmerSalesProposalImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			farmerSalesProposalImpl.setCreateDate(null);
		}
		else {
			farmerSalesProposalImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			farmerSalesProposalImpl.setModifiedDate(null);
		}
		else {
			farmerSalesProposalImpl.setModifiedDate(new Date(modifiedDate));
		}

		farmerSalesProposalImpl.setCreatedBy(createdBy);
		farmerSalesProposalImpl.setModifiedBy(modifiedBy);
		farmerSalesProposalImpl.setStatus(status);
		farmerSalesProposalImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			farmerSalesProposalImpl.setStatusByUserName("");
		}
		else {
			farmerSalesProposalImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			farmerSalesProposalImpl.setStatusDate(null);
		}
		else {
			farmerSalesProposalImpl.setStatusDate(new Date(statusDate));
		}

		farmerSalesProposalImpl.resetOriginalValues();

		return farmerSalesProposalImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		farmerSalesProposalId = objectInput.readLong();
		applicationNumber = objectInput.readUTF();

		farmerRegistrationId = objectInput.readLong();
		businessCode = objectInput.readUTF();
		currentSeason = objectInput.readUTF();
		foodGrainType = objectInput.readUTF();
		krishiCardNumber = objectInput.readUTF();
		pastProdDataSeason1 =
			(Map<String, Serializable>)objectInput.readObject();
		pastProdDataSeason2 =
			(Map<String, Serializable>)objectInput.readObject();
		pastProdDataSeason3 =
			(Map<String, Serializable>)objectInput.readObject();
		succeedingProdDataSeason1 =
			(Map<String, Serializable>)objectInput.readObject();
		succeedingProdDataSeason2 =
			(Map<String, Serializable>)objectInput.readObject();
		succeedingProdDataSeason3 =
			(Map<String, Serializable>)objectInput.readObject();

		grainProcuredInLast4Seasons = objectInput.readBoolean();
		foodgranProcuredSeason1 =
			(Map<String, Serializable>)objectInput.readObject();
		foodgranProcuredSeason2 =
			(Map<String, Serializable>)objectInput.readObject();
		foodgranProcuredSeason3 =
			(Map<String, Serializable>)objectInput.readObject();
		foodgranProcuredSeason4 =
			(Map<String, Serializable>)objectInput.readObject();
		cultivableLandSeason1 =
			(Map<String, Serializable>)objectInput.readObject();
		cultivableLandSeason2 =
			(Map<String, Serializable>)objectInput.readObject();
		cultivableLandSeason3 =
			(Map<String, Serializable>)objectInput.readObject();

		foodgrainReceivedStatus = objectInput.readInt();
		receivedFoodgrainQty =
			(Map<String, Serializable>)objectInput.readObject();
		foodgrainReceivedDate = objectInput.readLong();

		paymentStatus = objectInput.readInt();
		remarks = objectInput.readUTF();

		version = objectInput.readDouble();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();

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

		objectOutput.writeLong(farmerSalesProposalId);

		if (applicationNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(applicationNumber);
		}

		objectOutput.writeLong(farmerRegistrationId);

		if (businessCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(businessCode);
		}

		if (currentSeason == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(currentSeason);
		}

		if (foodGrainType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(foodGrainType);
		}

		if (krishiCardNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(krishiCardNumber);
		}

		objectOutput.writeObject(pastProdDataSeason1);
		objectOutput.writeObject(pastProdDataSeason2);
		objectOutput.writeObject(pastProdDataSeason3);
		objectOutput.writeObject(succeedingProdDataSeason1);
		objectOutput.writeObject(succeedingProdDataSeason2);
		objectOutput.writeObject(succeedingProdDataSeason3);

		objectOutput.writeBoolean(grainProcuredInLast4Seasons);
		objectOutput.writeObject(foodgranProcuredSeason1);
		objectOutput.writeObject(foodgranProcuredSeason2);
		objectOutput.writeObject(foodgranProcuredSeason3);
		objectOutput.writeObject(foodgranProcuredSeason4);
		objectOutput.writeObject(cultivableLandSeason1);
		objectOutput.writeObject(cultivableLandSeason2);
		objectOutput.writeObject(cultivableLandSeason3);

		objectOutput.writeInt(foodgrainReceivedStatus);
		objectOutput.writeObject(receivedFoodgrainQty);
		objectOutput.writeLong(foodgrainReceivedDate);

		objectOutput.writeInt(paymentStatus);

		if (remarks == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(remarks);
		}

		objectOutput.writeDouble(version);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);

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
	public long farmerSalesProposalId;
	public String applicationNumber;
	public long farmerRegistrationId;
	public String businessCode;
	public String currentSeason;
	public String foodGrainType;
	public String krishiCardNumber;
	public Map<String, Serializable> pastProdDataSeason1;
	public Map<String, Serializable> pastProdDataSeason2;
	public Map<String, Serializable> pastProdDataSeason3;
	public Map<String, Serializable> succeedingProdDataSeason1;
	public Map<String, Serializable> succeedingProdDataSeason2;
	public Map<String, Serializable> succeedingProdDataSeason3;
	public boolean grainProcuredInLast4Seasons;
	public Map<String, Serializable> foodgranProcuredSeason1;
	public Map<String, Serializable> foodgranProcuredSeason2;
	public Map<String, Serializable> foodgranProcuredSeason3;
	public Map<String, Serializable> foodgranProcuredSeason4;
	public Map<String, Serializable> cultivableLandSeason1;
	public Map<String, Serializable> cultivableLandSeason2;
	public Map<String, Serializable> cultivableLandSeason3;
	public int foodgrainReceivedStatus;
	public Map<String, Serializable> receivedFoodgrainQty;
	public long foodgrainReceivedDate;
	public int paymentStatus;
	public String remarks;
	public double version;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long createdBy;
	public long modifiedBy;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}