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

import bd.gov.dgfood.movement.contractor.model.SubProgram;

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
 * The cache model class for representing SubProgram in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SubProgramCacheModel
	implements CacheModel<SubProgram>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SubProgramCacheModel)) {
			return false;
		}

		SubProgramCacheModel subProgramCacheModel =
			(SubProgramCacheModel)object;

		if (subProgramId == subProgramCacheModel.subProgramId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, subProgramId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{subProgramId=");
		sb.append(subProgramId);
		sb.append(", deliveryNo=");
		sb.append(deliveryNo);
		sb.append(", memoNo=");
		sb.append(memoNo);
		sb.append(", sendingDepot=");
		sb.append(sendingDepot);
		sb.append(", sendingPlantDesc=");
		sb.append(sendingPlantDesc);
		sb.append(", receivingDepot=");
		sb.append(receivingDepot);
		sb.append(", receivingPlantDesc=");
		sb.append(receivingPlantDesc);
		sb.append(", product=");
		sb.append(product);
		sb.append(", quantity=");
		sb.append(quantity);
		sb.append(", deliveryDate=");
		sb.append(deliveryDate);
		sb.append(", requestedDate=");
		sb.append(requestedDate);
		sb.append(", forwardingAgent=");
		sb.append(forwardingAgent);
		sb.append(", vehicleSendDate=");
		sb.append(vehicleSendDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SubProgram toEntityModel() {
		SubProgramImpl subProgramImpl = new SubProgramImpl();

		subProgramImpl.setSubProgramId(subProgramId);

		if (deliveryNo == null) {
			subProgramImpl.setDeliveryNo("");
		}
		else {
			subProgramImpl.setDeliveryNo(deliveryNo);
		}

		if (memoNo == null) {
			subProgramImpl.setMemoNo("");
		}
		else {
			subProgramImpl.setMemoNo(memoNo);
		}

		if (sendingDepot == null) {
			subProgramImpl.setSendingDepot("");
		}
		else {
			subProgramImpl.setSendingDepot(sendingDepot);
		}

		if (sendingPlantDesc == null) {
			subProgramImpl.setSendingPlantDesc("");
		}
		else {
			subProgramImpl.setSendingPlantDesc(sendingPlantDesc);
		}

		if (receivingDepot == null) {
			subProgramImpl.setReceivingDepot("");
		}
		else {
			subProgramImpl.setReceivingDepot(receivingDepot);
		}

		if (receivingPlantDesc == null) {
			subProgramImpl.setReceivingPlantDesc("");
		}
		else {
			subProgramImpl.setReceivingPlantDesc(receivingPlantDesc);
		}

		if (product == null) {
			subProgramImpl.setProduct("");
		}
		else {
			subProgramImpl.setProduct(product);
		}

		subProgramImpl.setQuantity(quantity);

		if (deliveryDate == Long.MIN_VALUE) {
			subProgramImpl.setDeliveryDate(null);
		}
		else {
			subProgramImpl.setDeliveryDate(new Date(deliveryDate));
		}

		if (requestedDate == Long.MIN_VALUE) {
			subProgramImpl.setRequestedDate(null);
		}
		else {
			subProgramImpl.setRequestedDate(new Date(requestedDate));
		}

		if (forwardingAgent == null) {
			subProgramImpl.setForwardingAgent("");
		}
		else {
			subProgramImpl.setForwardingAgent(forwardingAgent);
		}

		if (vehicleSendDate == Long.MIN_VALUE) {
			subProgramImpl.setVehicleSendDate(null);
		}
		else {
			subProgramImpl.setVehicleSendDate(new Date(vehicleSendDate));
		}

		subProgramImpl.setStatus(status);
		subProgramImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			subProgramImpl.setCreateDate(null);
		}
		else {
			subProgramImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			subProgramImpl.setModifiedDate(null);
		}
		else {
			subProgramImpl.setModifiedDate(new Date(modifiedDate));
		}

		subProgramImpl.resetOriginalValues();

		return subProgramImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		subProgramId = objectInput.readLong();
		deliveryNo = objectInput.readUTF();
		memoNo = objectInput.readUTF();
		sendingDepot = objectInput.readUTF();
		sendingPlantDesc = objectInput.readUTF();
		receivingDepot = objectInput.readUTF();
		receivingPlantDesc = objectInput.readUTF();
		product = objectInput.readUTF();
		quantity = (Map<String, Serializable>)objectInput.readObject();
		deliveryDate = objectInput.readLong();
		requestedDate = objectInput.readLong();
		forwardingAgent = objectInput.readUTF();
		vehicleSendDate = objectInput.readLong();

		status = objectInput.readInt();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(subProgramId);

		if (deliveryNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(deliveryNo);
		}

		if (memoNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(memoNo);
		}

		if (sendingDepot == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sendingDepot);
		}

		if (sendingPlantDesc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sendingPlantDesc);
		}

		if (receivingDepot == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(receivingDepot);
		}

		if (receivingPlantDesc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(receivingPlantDesc);
		}

		if (product == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(product);
		}

		objectOutput.writeObject(quantity);
		objectOutput.writeLong(deliveryDate);
		objectOutput.writeLong(requestedDate);

		if (forwardingAgent == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(forwardingAgent);
		}

		objectOutput.writeLong(vehicleSendDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long subProgramId;
	public String deliveryNo;
	public String memoNo;
	public String sendingDepot;
	public String sendingPlantDesc;
	public String receivingDepot;
	public String receivingPlantDesc;
	public String product;
	public Map<String, Serializable> quantity;
	public long deliveryDate;
	public long requestedDate;
	public String forwardingAgent;
	public long vehicleSendDate;
	public int status;
	public long userId;
	public long createDate;
	public long modifiedDate;

}