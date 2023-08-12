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

import bd.gov.dgfood.common.services.model.Indent;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Indent in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class IndentCacheModel implements CacheModel<Indent>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof IndentCacheModel)) {
			return false;
		}

		IndentCacheModel indentCacheModel = (IndentCacheModel)object;

		if (indentId == indentCacheModel.indentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, indentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", indentId=");
		sb.append(indentId);
		sb.append(", allocationId=");
		sb.append(allocationId);
		sb.append(", commodity=");
		sb.append(commodity);
		sb.append(", commodityDescription=");
		sb.append(commodityDescription);
		sb.append(", quantity=");
		sb.append(quantity);
		sb.append(", quantityUnit=");
		sb.append(quantityUnit);
		sb.append(", requiredDeliveryDate=");
		sb.append(requiredDeliveryDate);
		sb.append(", foodGrainissueDate=");
		sb.append(foodGrainissueDate);
		sb.append(", netPrice=");
		sb.append(netPrice);
		sb.append(", netPriceCurrencyKey=");
		sb.append(netPriceCurrencyKey);
		sb.append(", netValue=");
		sb.append(netValue);
		sb.append(", netValueCurrencyKey=");
		sb.append(netValueCurrencyKey);
		sb.append(", salesOffice=");
		sb.append(salesOffice);
		sb.append(", depo=");
		sb.append(depo);
		sb.append(", repaymentTerms=");
		sb.append(repaymentTerms);
		sb.append(", deliveryTerms=");
		sb.append(deliveryTerms);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", reason=");
		sb.append(reason);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Indent toEntityModel() {
		IndentImpl indentImpl = new IndentImpl();

		if (uuid == null) {
			indentImpl.setUuid("");
		}
		else {
			indentImpl.setUuid(uuid);
		}

		indentImpl.setIndentId(indentId);
		indentImpl.setAllocationId(allocationId);

		if (commodity == null) {
			indentImpl.setCommodity("");
		}
		else {
			indentImpl.setCommodity(commodity);
		}

		if (commodityDescription == null) {
			indentImpl.setCommodityDescription("");
		}
		else {
			indentImpl.setCommodityDescription(commodityDescription);
		}

		indentImpl.setQuantity(quantity);

		if (quantityUnit == null) {
			indentImpl.setQuantityUnit("");
		}
		else {
			indentImpl.setQuantityUnit(quantityUnit);
		}

		if (requiredDeliveryDate == Long.MIN_VALUE) {
			indentImpl.setRequiredDeliveryDate(null);
		}
		else {
			indentImpl.setRequiredDeliveryDate(new Date(requiredDeliveryDate));
		}

		if (foodGrainissueDate == Long.MIN_VALUE) {
			indentImpl.setFoodGrainissueDate(null);
		}
		else {
			indentImpl.setFoodGrainissueDate(new Date(foodGrainissueDate));
		}

		indentImpl.setNetPrice(netPrice);

		if (netPriceCurrencyKey == null) {
			indentImpl.setNetPriceCurrencyKey("");
		}
		else {
			indentImpl.setNetPriceCurrencyKey(netPriceCurrencyKey);
		}

		indentImpl.setNetValue(netValue);

		if (netValueCurrencyKey == null) {
			indentImpl.setNetValueCurrencyKey("");
		}
		else {
			indentImpl.setNetValueCurrencyKey(netValueCurrencyKey);
		}

		if (salesOffice == null) {
			indentImpl.setSalesOffice("");
		}
		else {
			indentImpl.setSalesOffice(salesOffice);
		}

		if (depo == null) {
			indentImpl.setDepo("");
		}
		else {
			indentImpl.setDepo(depo);
		}

		if (repaymentTerms == null) {
			indentImpl.setRepaymentTerms("");
		}
		else {
			indentImpl.setRepaymentTerms(repaymentTerms);
		}

		if (deliveryTerms == null) {
			indentImpl.setDeliveryTerms("");
		}
		else {
			indentImpl.setDeliveryTerms(deliveryTerms);
		}

		indentImpl.setGroupId(groupId);
		indentImpl.setCompanyId(companyId);
		indentImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			indentImpl.setCreateDate(null);
		}
		else {
			indentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			indentImpl.setModifiedDate(null);
		}
		else {
			indentImpl.setModifiedDate(new Date(modifiedDate));
		}

		indentImpl.setStatus(status);
		indentImpl.setReason(reason);

		indentImpl.resetOriginalValues();

		return indentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		indentId = objectInput.readLong();

		allocationId = objectInput.readLong();
		commodity = objectInput.readUTF();
		commodityDescription = objectInput.readUTF();

		quantity = objectInput.readDouble();
		quantityUnit = objectInput.readUTF();
		requiredDeliveryDate = objectInput.readLong();
		foodGrainissueDate = objectInput.readLong();

		netPrice = objectInput.readDouble();
		netPriceCurrencyKey = objectInput.readUTF();

		netValue = objectInput.readDouble();
		netValueCurrencyKey = objectInput.readUTF();
		salesOffice = objectInput.readUTF();
		depo = objectInput.readUTF();
		repaymentTerms = objectInput.readUTF();
		deliveryTerms = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		reason = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(indentId);

		objectOutput.writeLong(allocationId);

		if (commodity == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(commodity);
		}

		if (commodityDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(commodityDescription);
		}

		objectOutput.writeDouble(quantity);

		if (quantityUnit == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(quantityUnit);
		}

		objectOutput.writeLong(requiredDeliveryDate);
		objectOutput.writeLong(foodGrainissueDate);

		objectOutput.writeDouble(netPrice);

		if (netPriceCurrencyKey == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(netPriceCurrencyKey);
		}

		objectOutput.writeDouble(netValue);

		if (netValueCurrencyKey == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(netValueCurrencyKey);
		}

		if (salesOffice == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(salesOffice);
		}

		if (depo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(depo);
		}

		if (repaymentTerms == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(repaymentTerms);
		}

		if (deliveryTerms == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(deliveryTerms);
		}

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(status);

		objectOutput.writeInt(reason);
	}

	public String uuid;
	public long indentId;
	public long allocationId;
	public String commodity;
	public String commodityDescription;
	public double quantity;
	public String quantityUnit;
	public long requiredDeliveryDate;
	public long foodGrainissueDate;
	public double netPrice;
	public String netPriceCurrencyKey;
	public double netValue;
	public String netValueCurrencyKey;
	public String salesOffice;
	public String depo;
	public String repaymentTerms;
	public String deliveryTerms;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public int status;
	public int reason;

}