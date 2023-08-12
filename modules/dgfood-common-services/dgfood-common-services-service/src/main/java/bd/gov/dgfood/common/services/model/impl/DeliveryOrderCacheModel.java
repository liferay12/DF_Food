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

import bd.gov.dgfood.common.services.model.DeliveryOrder;
import bd.gov.dgfood.common.services.service.persistence.DeliveryOrderPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DeliveryOrder in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DeliveryOrderCacheModel
	implements CacheModel<DeliveryOrder>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DeliveryOrderCacheModel)) {
			return false;
		}

		DeliveryOrderCacheModel deliveryOrderCacheModel =
			(DeliveryOrderCacheModel)object;

		if (deliveryOrderPK.equals(deliveryOrderCacheModel.deliveryOrderPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, deliveryOrderPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(57);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", deliveryOrderId=");
		sb.append(deliveryOrderId);
		sb.append(", indentId=");
		sb.append(indentId);
		sb.append(", deliveryOrderNo=");
		sb.append(deliveryOrderNo);
		sb.append(", customerNo=");
		sb.append(customerNo);
		sb.append(", name=");
		sb.append(name);
		sb.append(", doDate=");
		sb.append(doDate);
		sb.append(", commodity=");
		sb.append(commodity);
		sb.append(", commodityDescription=");
		sb.append(commodityDescription);
		sb.append(", doQty=");
		sb.append(doQty);
		sb.append(", doQtyUnit=");
		sb.append(doQtyUnit);
		sb.append(", depo=");
		sb.append(depo);
		sb.append(", warehouseNo=");
		sb.append(warehouseNo);
		sb.append(", khamaalNo=");
		sb.append(khamaalNo);
		sb.append(", lUANo=");
		sb.append(lUANo);
		sb.append(", lUADate=");
		sb.append(lUADate);
		sb.append(", bagUnit=");
		sb.append(bagUnit);
		sb.append(", vehicleNo=");
		sb.append(vehicleNo);
		sb.append(", gateKeeper=");
		sb.append(gateKeeper);
		sb.append(", goodsIssueDate=");
		sb.append(goodsIssueDate);
		sb.append(", shipToParty=");
		sb.append(shipToParty);
		sb.append(", shipToPartyName=");
		sb.append(shipToPartyName);
		sb.append(", deliveredQty=");
		sb.append(deliveredQty);
		sb.append(", deliveredQtyUnit=");
		sb.append(deliveredQtyUnit);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DeliveryOrder toEntityModel() {
		DeliveryOrderImpl deliveryOrderImpl = new DeliveryOrderImpl();

		if (uuid == null) {
			deliveryOrderImpl.setUuid("");
		}
		else {
			deliveryOrderImpl.setUuid(uuid);
		}

		deliveryOrderImpl.setDeliveryOrderId(deliveryOrderId);
		deliveryOrderImpl.setIndentId(indentId);

		if (deliveryOrderNo == null) {
			deliveryOrderImpl.setDeliveryOrderNo("");
		}
		else {
			deliveryOrderImpl.setDeliveryOrderNo(deliveryOrderNo);
		}

		if (customerNo == null) {
			deliveryOrderImpl.setCustomerNo("");
		}
		else {
			deliveryOrderImpl.setCustomerNo(customerNo);
		}

		if (name == null) {
			deliveryOrderImpl.setName("");
		}
		else {
			deliveryOrderImpl.setName(name);
		}

		if (doDate == Long.MIN_VALUE) {
			deliveryOrderImpl.setDoDate(null);
		}
		else {
			deliveryOrderImpl.setDoDate(new Date(doDate));
		}

		if (commodity == null) {
			deliveryOrderImpl.setCommodity("");
		}
		else {
			deliveryOrderImpl.setCommodity(commodity);
		}

		if (commodityDescription == null) {
			deliveryOrderImpl.setCommodityDescription("");
		}
		else {
			deliveryOrderImpl.setCommodityDescription(commodityDescription);
		}

		if (doQty == null) {
			deliveryOrderImpl.setDoQty("");
		}
		else {
			deliveryOrderImpl.setDoQty(doQty);
		}

		if (doQtyUnit == null) {
			deliveryOrderImpl.setDoQtyUnit("");
		}
		else {
			deliveryOrderImpl.setDoQtyUnit(doQtyUnit);
		}

		if (depo == null) {
			deliveryOrderImpl.setDepo("");
		}
		else {
			deliveryOrderImpl.setDepo(depo);
		}

		if (warehouseNo == null) {
			deliveryOrderImpl.setWarehouseNo("");
		}
		else {
			deliveryOrderImpl.setWarehouseNo(warehouseNo);
		}

		if (khamaalNo == null) {
			deliveryOrderImpl.setKhamaalNo("");
		}
		else {
			deliveryOrderImpl.setKhamaalNo(khamaalNo);
		}

		if (lUANo == null) {
			deliveryOrderImpl.setLUANo("");
		}
		else {
			deliveryOrderImpl.setLUANo(lUANo);
		}

		if (lUADate == Long.MIN_VALUE) {
			deliveryOrderImpl.setLUADate(null);
		}
		else {
			deliveryOrderImpl.setLUADate(new Date(lUADate));
		}

		if (bagUnit == null) {
			deliveryOrderImpl.setBagUnit("");
		}
		else {
			deliveryOrderImpl.setBagUnit(bagUnit);
		}

		if (vehicleNo == null) {
			deliveryOrderImpl.setVehicleNo("");
		}
		else {
			deliveryOrderImpl.setVehicleNo(vehicleNo);
		}

		if (gateKeeper == null) {
			deliveryOrderImpl.setGateKeeper("");
		}
		else {
			deliveryOrderImpl.setGateKeeper(gateKeeper);
		}

		if (goodsIssueDate == null) {
			deliveryOrderImpl.setGoodsIssueDate("");
		}
		else {
			deliveryOrderImpl.setGoodsIssueDate(goodsIssueDate);
		}

		if (shipToParty == null) {
			deliveryOrderImpl.setShipToParty("");
		}
		else {
			deliveryOrderImpl.setShipToParty(shipToParty);
		}

		if (shipToPartyName == null) {
			deliveryOrderImpl.setShipToPartyName("");
		}
		else {
			deliveryOrderImpl.setShipToPartyName(shipToPartyName);
		}

		if (deliveredQty == null) {
			deliveryOrderImpl.setDeliveredQty("");
		}
		else {
			deliveryOrderImpl.setDeliveredQty(deliveredQty);
		}

		if (deliveredQtyUnit == null) {
			deliveryOrderImpl.setDeliveredQtyUnit("");
		}
		else {
			deliveryOrderImpl.setDeliveredQtyUnit(deliveredQtyUnit);
		}

		deliveryOrderImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			deliveryOrderImpl.setCreateDate(null);
		}
		else {
			deliveryOrderImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			deliveryOrderImpl.setModifiedDate(null);
		}
		else {
			deliveryOrderImpl.setModifiedDate(new Date(modifiedDate));
		}

		deliveryOrderImpl.setStatus(status);

		deliveryOrderImpl.resetOriginalValues();

		return deliveryOrderImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		deliveryOrderId = objectInput.readLong();

		indentId = objectInput.readLong();
		deliveryOrderNo = objectInput.readUTF();
		customerNo = objectInput.readUTF();
		name = objectInput.readUTF();
		doDate = objectInput.readLong();
		commodity = objectInput.readUTF();
		commodityDescription = objectInput.readUTF();
		doQty = objectInput.readUTF();
		doQtyUnit = objectInput.readUTF();
		depo = objectInput.readUTF();
		warehouseNo = objectInput.readUTF();
		khamaalNo = objectInput.readUTF();
		lUANo = objectInput.readUTF();
		lUADate = objectInput.readLong();
		bagUnit = objectInput.readUTF();
		vehicleNo = objectInput.readUTF();
		gateKeeper = objectInput.readUTF();
		goodsIssueDate = objectInput.readUTF();
		shipToParty = objectInput.readUTF();
		shipToPartyName = objectInput.readUTF();
		deliveredQty = objectInput.readUTF();
		deliveredQtyUnit = objectInput.readUTF();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		deliveryOrderPK = new DeliveryOrderPK(deliveryOrderId, indentId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(deliveryOrderId);

		objectOutput.writeLong(indentId);

		if (deliveryOrderNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(deliveryOrderNo);
		}

		if (customerNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(customerNo);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(doDate);

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

		if (doQty == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(doQty);
		}

		if (doQtyUnit == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(doQtyUnit);
		}

		if (depo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(depo);
		}

		if (warehouseNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(warehouseNo);
		}

		if (khamaalNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(khamaalNo);
		}

		if (lUANo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lUANo);
		}

		objectOutput.writeLong(lUADate);

		if (bagUnit == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bagUnit);
		}

		if (vehicleNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehicleNo);
		}

		if (gateKeeper == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gateKeeper);
		}

		if (goodsIssueDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(goodsIssueDate);
		}

		if (shipToParty == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(shipToParty);
		}

		if (shipToPartyName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(shipToPartyName);
		}

		if (deliveredQty == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(deliveredQty);
		}

		if (deliveredQtyUnit == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(deliveredQtyUnit);
		}

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(status);
	}

	public String uuid;
	public long deliveryOrderId;
	public long indentId;
	public String deliveryOrderNo;
	public String customerNo;
	public String name;
	public long doDate;
	public String commodity;
	public String commodityDescription;
	public String doQty;
	public String doQtyUnit;
	public String depo;
	public String warehouseNo;
	public String khamaalNo;
	public String lUANo;
	public long lUADate;
	public String bagUnit;
	public String vehicleNo;
	public String gateKeeper;
	public String goodsIssueDate;
	public String shipToParty;
	public String shipToPartyName;
	public String deliveredQty;
	public String deliveredQtyUnit;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public int status;
	public transient DeliveryOrderPK deliveryOrderPK;

}