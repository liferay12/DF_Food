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

package bd.gov.dgfood.movement.contractor.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SubProgram}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubProgram
 * @generated
 */
public class SubProgramWrapper
	extends BaseModelWrapper<SubProgram>
	implements ModelWrapper<SubProgram>, SubProgram {

	public SubProgramWrapper(SubProgram subProgram) {
		super(subProgram);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("subProgramId", getSubProgramId());
		attributes.put("deliveryNo", getDeliveryNo());
		attributes.put("memoNo", getMemoNo());
		attributes.put("sendingDepot", getSendingDepot());
		attributes.put("sendingPlantDesc", getSendingPlantDesc());
		attributes.put("receivingDepot", getReceivingDepot());
		attributes.put("receivingPlantDesc", getReceivingPlantDesc());
		attributes.put("product", getProduct());
		attributes.put("quantity", getQuantity());
		attributes.put("deliveryDate", getDeliveryDate());
		attributes.put("requestedDate", getRequestedDate());
		attributes.put("forwardingAgent", getForwardingAgent());
		attributes.put("vehicleSendDate", getVehicleSendDate());
		attributes.put("status", getStatus());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long subProgramId = (Long)attributes.get("subProgramId");

		if (subProgramId != null) {
			setSubProgramId(subProgramId);
		}

		String deliveryNo = (String)attributes.get("deliveryNo");

		if (deliveryNo != null) {
			setDeliveryNo(deliveryNo);
		}

		String memoNo = (String)attributes.get("memoNo");

		if (memoNo != null) {
			setMemoNo(memoNo);
		}

		String sendingDepot = (String)attributes.get("sendingDepot");

		if (sendingDepot != null) {
			setSendingDepot(sendingDepot);
		}

		String sendingPlantDesc = (String)attributes.get("sendingPlantDesc");

		if (sendingPlantDesc != null) {
			setSendingPlantDesc(sendingPlantDesc);
		}

		String receivingDepot = (String)attributes.get("receivingDepot");

		if (receivingDepot != null) {
			setReceivingDepot(receivingDepot);
		}

		String receivingPlantDesc = (String)attributes.get(
			"receivingPlantDesc");

		if (receivingPlantDesc != null) {
			setReceivingPlantDesc(receivingPlantDesc);
		}

		String product = (String)attributes.get("product");

		if (product != null) {
			setProduct(product);
		}

		Map<String, Serializable> quantity =
			(Map<String, Serializable>)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
		}

		Date deliveryDate = (Date)attributes.get("deliveryDate");

		if (deliveryDate != null) {
			setDeliveryDate(deliveryDate);
		}

		Date requestedDate = (Date)attributes.get("requestedDate");

		if (requestedDate != null) {
			setRequestedDate(requestedDate);
		}

		String forwardingAgent = (String)attributes.get("forwardingAgent");

		if (forwardingAgent != null) {
			setForwardingAgent(forwardingAgent);
		}

		Date vehicleSendDate = (Date)attributes.get("vehicleSendDate");

		if (vehicleSendDate != null) {
			setVehicleSendDate(vehicleSendDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public SubProgram cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the create date of this sub program.
	 *
	 * @return the create date of this sub program
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the delivery date of this sub program.
	 *
	 * @return the delivery date of this sub program
	 */
	@Override
	public Date getDeliveryDate() {
		return model.getDeliveryDate();
	}

	/**
	 * Returns the delivery no of this sub program.
	 *
	 * @return the delivery no of this sub program
	 */
	@Override
	public String getDeliveryNo() {
		return model.getDeliveryNo();
	}

	/**
	 * Returns the forwarding agent of this sub program.
	 *
	 * @return the forwarding agent of this sub program
	 */
	@Override
	public String getForwardingAgent() {
		return model.getForwardingAgent();
	}

	/**
	 * Returns the memo no of this sub program.
	 *
	 * @return the memo no of this sub program
	 */
	@Override
	public String getMemoNo() {
		return model.getMemoNo();
	}

	/**
	 * Returns the modified date of this sub program.
	 *
	 * @return the modified date of this sub program
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this sub program.
	 *
	 * @return the primary key of this sub program
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product of this sub program.
	 *
	 * @return the product of this sub program
	 */
	@Override
	public String getProduct() {
		return model.getProduct();
	}

	/**
	 * Returns the quantity of this sub program.
	 *
	 * @return the quantity of this sub program
	 */
	@Override
	public Map<String, Serializable> getQuantity() {
		return model.getQuantity();
	}

	/**
	 * Returns the receiving depot of this sub program.
	 *
	 * @return the receiving depot of this sub program
	 */
	@Override
	public String getReceivingDepot() {
		return model.getReceivingDepot();
	}

	/**
	 * Returns the receiving plant desc of this sub program.
	 *
	 * @return the receiving plant desc of this sub program
	 */
	@Override
	public String getReceivingPlantDesc() {
		return model.getReceivingPlantDesc();
	}

	/**
	 * Returns the requested date of this sub program.
	 *
	 * @return the requested date of this sub program
	 */
	@Override
	public Date getRequestedDate() {
		return model.getRequestedDate();
	}

	/**
	 * Returns the sending depot of this sub program.
	 *
	 * @return the sending depot of this sub program
	 */
	@Override
	public String getSendingDepot() {
		return model.getSendingDepot();
	}

	/**
	 * Returns the sending plant desc of this sub program.
	 *
	 * @return the sending plant desc of this sub program
	 */
	@Override
	public String getSendingPlantDesc() {
		return model.getSendingPlantDesc();
	}

	/**
	 * Returns the status of this sub program.
	 *
	 * @return the status of this sub program
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the sub program ID of this sub program.
	 *
	 * @return the sub program ID of this sub program
	 */
	@Override
	public long getSubProgramId() {
		return model.getSubProgramId();
	}

	/**
	 * Returns the user ID of this sub program.
	 *
	 * @return the user ID of this sub program
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this sub program.
	 *
	 * @return the user uuid of this sub program
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the vehicle send date of this sub program.
	 *
	 * @return the vehicle send date of this sub program
	 */
	@Override
	public Date getVehicleSendDate() {
		return model.getVehicleSendDate();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the create date of this sub program.
	 *
	 * @param createDate the create date of this sub program
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the delivery date of this sub program.
	 *
	 * @param deliveryDate the delivery date of this sub program
	 */
	@Override
	public void setDeliveryDate(Date deliveryDate) {
		model.setDeliveryDate(deliveryDate);
	}

	/**
	 * Sets the delivery no of this sub program.
	 *
	 * @param deliveryNo the delivery no of this sub program
	 */
	@Override
	public void setDeliveryNo(String deliveryNo) {
		model.setDeliveryNo(deliveryNo);
	}

	/**
	 * Sets the forwarding agent of this sub program.
	 *
	 * @param forwardingAgent the forwarding agent of this sub program
	 */
	@Override
	public void setForwardingAgent(String forwardingAgent) {
		model.setForwardingAgent(forwardingAgent);
	}

	/**
	 * Sets the memo no of this sub program.
	 *
	 * @param memoNo the memo no of this sub program
	 */
	@Override
	public void setMemoNo(String memoNo) {
		model.setMemoNo(memoNo);
	}

	/**
	 * Sets the modified date of this sub program.
	 *
	 * @param modifiedDate the modified date of this sub program
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this sub program.
	 *
	 * @param primaryKey the primary key of this sub program
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product of this sub program.
	 *
	 * @param product the product of this sub program
	 */
	@Override
	public void setProduct(String product) {
		model.setProduct(product);
	}

	/**
	 * Sets the quantity of this sub program.
	 *
	 * @param quantity the quantity of this sub program
	 */
	@Override
	public void setQuantity(Map<String, Serializable> quantity) {
		model.setQuantity(quantity);
	}

	/**
	 * Sets the receiving depot of this sub program.
	 *
	 * @param receivingDepot the receiving depot of this sub program
	 */
	@Override
	public void setReceivingDepot(String receivingDepot) {
		model.setReceivingDepot(receivingDepot);
	}

	/**
	 * Sets the receiving plant desc of this sub program.
	 *
	 * @param receivingPlantDesc the receiving plant desc of this sub program
	 */
	@Override
	public void setReceivingPlantDesc(String receivingPlantDesc) {
		model.setReceivingPlantDesc(receivingPlantDesc);
	}

	/**
	 * Sets the requested date of this sub program.
	 *
	 * @param requestedDate the requested date of this sub program
	 */
	@Override
	public void setRequestedDate(Date requestedDate) {
		model.setRequestedDate(requestedDate);
	}

	/**
	 * Sets the sending depot of this sub program.
	 *
	 * @param sendingDepot the sending depot of this sub program
	 */
	@Override
	public void setSendingDepot(String sendingDepot) {
		model.setSendingDepot(sendingDepot);
	}

	/**
	 * Sets the sending plant desc of this sub program.
	 *
	 * @param sendingPlantDesc the sending plant desc of this sub program
	 */
	@Override
	public void setSendingPlantDesc(String sendingPlantDesc) {
		model.setSendingPlantDesc(sendingPlantDesc);
	}

	/**
	 * Sets the status of this sub program.
	 *
	 * @param status the status of this sub program
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the sub program ID of this sub program.
	 *
	 * @param subProgramId the sub program ID of this sub program
	 */
	@Override
	public void setSubProgramId(long subProgramId) {
		model.setSubProgramId(subProgramId);
	}

	/**
	 * Sets the user ID of this sub program.
	 *
	 * @param userId the user ID of this sub program
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this sub program.
	 *
	 * @param userUuid the user uuid of this sub program
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the vehicle send date of this sub program.
	 *
	 * @param vehicleSendDate the vehicle send date of this sub program
	 */
	@Override
	public void setVehicleSendDate(Date vehicleSendDate) {
		model.setVehicleSendDate(vehicleSendDate);
	}

	@Override
	protected SubProgramWrapper wrap(SubProgram subProgram) {
		return new SubProgramWrapper(subProgram);
	}

}