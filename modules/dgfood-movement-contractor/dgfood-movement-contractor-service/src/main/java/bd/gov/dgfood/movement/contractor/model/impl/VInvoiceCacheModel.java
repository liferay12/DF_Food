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

package bd.gov.dgfood.movement.contractor.model.impl;

import bd.gov.dgfood.movement.contractor.model.VInvoice;

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
 * The cache model class for representing VInvoice in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class VInvoiceCacheModel
	implements CacheModel<VInvoice>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof VInvoiceCacheModel)) {
			return false;
		}

		VInvoiceCacheModel vInvoiceCacheModel = (VInvoiceCacheModel)object;

		if (vInvoiceId == vInvoiceCacheModel.vInvoiceId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, vInvoiceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{vInvoiceId=");
		sb.append(vInvoiceId);
		sb.append(", vInvoiceNo=");
		sb.append(vInvoiceNo);
		sb.append(", deliveryNo=");
		sb.append(deliveryNo);
		sb.append(", sendingPlant=");
		sb.append(sendingPlant);
		sb.append(", sendingPlantDesc=");
		sb.append(sendingPlantDesc);
		sb.append(", receivingPlant=");
		sb.append(receivingPlant);
		sb.append(", receivingPlantDesc=");
		sb.append(receivingPlantDesc);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", departureDate=");
		sb.append(departureDate);
		sb.append(", materialNo=");
		sb.append(materialNo);
		sb.append(", materialDescription=");
		sb.append(materialDescription);
		sb.append(", quantity=");
		sb.append(quantity);
		sb.append(", bagQuantity=");
		sb.append(bagQuantity);
		sb.append(", grossWeight=");
		sb.append(grossWeight);
		sb.append(", netWeight=");
		sb.append(netWeight);
		sb.append(", storageLocation=");
		sb.append(storageLocation);
		sb.append(", storageBin=");
		sb.append(storageBin);
		sb.append(", carrier=");
		sb.append(carrier);
		sb.append(", transportationMode=");
		sb.append(transportationMode);
		sb.append(", meansOfTransport=");
		sb.append(meansOfTransport);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VInvoice toEntityModel() {
		VInvoiceImpl vInvoiceImpl = new VInvoiceImpl();

		vInvoiceImpl.setVInvoiceId(vInvoiceId);

		if (vInvoiceNo == null) {
			vInvoiceImpl.setVInvoiceNo("");
		}
		else {
			vInvoiceImpl.setVInvoiceNo(vInvoiceNo);
		}

		if (deliveryNo == null) {
			vInvoiceImpl.setDeliveryNo("");
		}
		else {
			vInvoiceImpl.setDeliveryNo(deliveryNo);
		}

		if (sendingPlant == null) {
			vInvoiceImpl.setSendingPlant("");
		}
		else {
			vInvoiceImpl.setSendingPlant(sendingPlant);
		}

		if (sendingPlantDesc == null) {
			vInvoiceImpl.setSendingPlantDesc("");
		}
		else {
			vInvoiceImpl.setSendingPlantDesc(sendingPlantDesc);
		}

		if (receivingPlant == null) {
			vInvoiceImpl.setReceivingPlant("");
		}
		else {
			vInvoiceImpl.setReceivingPlant(receivingPlant);
		}

		if (receivingPlantDesc == null) {
			vInvoiceImpl.setReceivingPlantDesc("");
		}
		else {
			vInvoiceImpl.setReceivingPlantDesc(receivingPlantDesc);
		}

		if (userName == null) {
			vInvoiceImpl.setUserName("");
		}
		else {
			vInvoiceImpl.setUserName(userName);
		}

		if (departureDate == Long.MIN_VALUE) {
			vInvoiceImpl.setDepartureDate(null);
		}
		else {
			vInvoiceImpl.setDepartureDate(new Date(departureDate));
		}

		if (materialNo == null) {
			vInvoiceImpl.setMaterialNo("");
		}
		else {
			vInvoiceImpl.setMaterialNo(materialNo);
		}

		if (materialDescription == null) {
			vInvoiceImpl.setMaterialDescription("");
		}
		else {
			vInvoiceImpl.setMaterialDescription(materialDescription);
		}

		vInvoiceImpl.setQuantity(quantity);
		vInvoiceImpl.setBagQuantity(bagQuantity);
		vInvoiceImpl.setGrossWeight(grossWeight);
		vInvoiceImpl.setNetWeight(netWeight);

		if (storageLocation == null) {
			vInvoiceImpl.setStorageLocation("");
		}
		else {
			vInvoiceImpl.setStorageLocation(storageLocation);
		}

		if (storageBin == null) {
			vInvoiceImpl.setStorageBin("");
		}
		else {
			vInvoiceImpl.setStorageBin(storageBin);
		}

		if (carrier == null) {
			vInvoiceImpl.setCarrier("");
		}
		else {
			vInvoiceImpl.setCarrier(carrier);
		}

		if (transportationMode == null) {
			vInvoiceImpl.setTransportationMode("");
		}
		else {
			vInvoiceImpl.setTransportationMode(transportationMode);
		}

		if (meansOfTransport == null) {
			vInvoiceImpl.setMeansOfTransport("");
		}
		else {
			vInvoiceImpl.setMeansOfTransport(meansOfTransport);
		}

		if (createDate == Long.MIN_VALUE) {
			vInvoiceImpl.setCreateDate(null);
		}
		else {
			vInvoiceImpl.setCreateDate(new Date(createDate));
		}

		vInvoiceImpl.resetOriginalValues();

		return vInvoiceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		vInvoiceId = objectInput.readLong();
		vInvoiceNo = objectInput.readUTF();
		deliveryNo = objectInput.readUTF();
		sendingPlant = objectInput.readUTF();
		sendingPlantDesc = objectInput.readUTF();
		receivingPlant = objectInput.readUTF();
		receivingPlantDesc = objectInput.readUTF();
		userName = objectInput.readUTF();
		departureDate = objectInput.readLong();
		materialNo = objectInput.readUTF();
		materialDescription = objectInput.readUTF();
		quantity = (Map<String, Serializable>)objectInput.readObject();

		bagQuantity = objectInput.readDouble();

		grossWeight = objectInput.readDouble();

		netWeight = objectInput.readDouble();
		storageLocation = objectInput.readUTF();
		storageBin = objectInput.readUTF();
		carrier = objectInput.readUTF();
		transportationMode = objectInput.readUTF();
		meansOfTransport = objectInput.readUTF();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(vInvoiceId);

		if (vInvoiceNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vInvoiceNo);
		}

		if (deliveryNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(deliveryNo);
		}

		if (sendingPlant == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sendingPlant);
		}

		if (sendingPlantDesc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sendingPlantDesc);
		}

		if (receivingPlant == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(receivingPlant);
		}

		if (receivingPlantDesc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(receivingPlantDesc);
		}

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(departureDate);

		if (materialNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(materialNo);
		}

		if (materialDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(materialDescription);
		}

		objectOutput.writeObject(quantity);

		objectOutput.writeDouble(bagQuantity);

		objectOutput.writeDouble(grossWeight);

		objectOutput.writeDouble(netWeight);

		if (storageLocation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(storageLocation);
		}

		if (storageBin == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(storageBin);
		}

		if (carrier == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(carrier);
		}

		if (transportationMode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(transportationMode);
		}

		if (meansOfTransport == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(meansOfTransport);
		}

		objectOutput.writeLong(createDate);
	}

	public long vInvoiceId;
	public String vInvoiceNo;
	public String deliveryNo;
	public String sendingPlant;
	public String sendingPlantDesc;
	public String receivingPlant;
	public String receivingPlantDesc;
	public String userName;
	public long departureDate;
	public String materialNo;
	public String materialDescription;
	public Map<String, Serializable> quantity;
	public double bagQuantity;
	public double grossWeight;
	public double netWeight;
	public String storageLocation;
	public String storageBin;
	public String carrier;
	public String transportationMode;
	public String meansOfTransport;
	public long createDate;

}