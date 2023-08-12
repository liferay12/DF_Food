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
 * This class is a wrapper for {@link VInvoice}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VInvoice
 * @generated
 */
public class VInvoiceWrapper
	extends BaseModelWrapper<VInvoice>
	implements ModelWrapper<VInvoice>, VInvoice {

	public VInvoiceWrapper(VInvoice vInvoice) {
		super(vInvoice);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("vInvoiceId", getVInvoiceId());
		attributes.put("vInvoiceNo", getVInvoiceNo());
		attributes.put("deliveryNo", getDeliveryNo());
		attributes.put("sendingPlant", getSendingPlant());
		attributes.put("sendingPlantDesc", getSendingPlantDesc());
		attributes.put("receivingPlant", getReceivingPlant());
		attributes.put("receivingPlantDesc", getReceivingPlantDesc());
		attributes.put("userName", getUserName());
		attributes.put("departureDate", getDepartureDate());
		attributes.put("materialNo", getMaterialNo());
		attributes.put("materialDescription", getMaterialDescription());
		attributes.put("quantity", getQuantity());
		attributes.put("bagQuantity", getBagQuantity());
		attributes.put("grossWeight", getGrossWeight());
		attributes.put("netWeight", getNetWeight());
		attributes.put("storageLocation", getStorageLocation());
		attributes.put("storageBin", getStorageBin());
		attributes.put("carrier", getCarrier());
		attributes.put("transportationMode", getTransportationMode());
		attributes.put("meansOfTransport", getMeansOfTransport());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long vInvoiceId = (Long)attributes.get("vInvoiceId");

		if (vInvoiceId != null) {
			setVInvoiceId(vInvoiceId);
		}

		String vInvoiceNo = (String)attributes.get("vInvoiceNo");

		if (vInvoiceNo != null) {
			setVInvoiceNo(vInvoiceNo);
		}

		String deliveryNo = (String)attributes.get("deliveryNo");

		if (deliveryNo != null) {
			setDeliveryNo(deliveryNo);
		}

		String sendingPlant = (String)attributes.get("sendingPlant");

		if (sendingPlant != null) {
			setSendingPlant(sendingPlant);
		}

		String sendingPlantDesc = (String)attributes.get("sendingPlantDesc");

		if (sendingPlantDesc != null) {
			setSendingPlantDesc(sendingPlantDesc);
		}

		String receivingPlant = (String)attributes.get("receivingPlant");

		if (receivingPlant != null) {
			setReceivingPlant(receivingPlant);
		}

		String receivingPlantDesc = (String)attributes.get(
			"receivingPlantDesc");

		if (receivingPlantDesc != null) {
			setReceivingPlantDesc(receivingPlantDesc);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date departureDate = (Date)attributes.get("departureDate");

		if (departureDate != null) {
			setDepartureDate(departureDate);
		}

		String materialNo = (String)attributes.get("materialNo");

		if (materialNo != null) {
			setMaterialNo(materialNo);
		}

		String materialDescription = (String)attributes.get(
			"materialDescription");

		if (materialDescription != null) {
			setMaterialDescription(materialDescription);
		}

		Map<String, Serializable> quantity =
			(Map<String, Serializable>)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
		}

		Double bagQuantity = (Double)attributes.get("bagQuantity");

		if (bagQuantity != null) {
			setBagQuantity(bagQuantity);
		}

		Double grossWeight = (Double)attributes.get("grossWeight");

		if (grossWeight != null) {
			setGrossWeight(grossWeight);
		}

		Double netWeight = (Double)attributes.get("netWeight");

		if (netWeight != null) {
			setNetWeight(netWeight);
		}

		String storageLocation = (String)attributes.get("storageLocation");

		if (storageLocation != null) {
			setStorageLocation(storageLocation);
		}

		String storageBin = (String)attributes.get("storageBin");

		if (storageBin != null) {
			setStorageBin(storageBin);
		}

		String carrier = (String)attributes.get("carrier");

		if (carrier != null) {
			setCarrier(carrier);
		}

		String transportationMode = (String)attributes.get(
			"transportationMode");

		if (transportationMode != null) {
			setTransportationMode(transportationMode);
		}

		String meansOfTransport = (String)attributes.get("meansOfTransport");

		if (meansOfTransport != null) {
			setMeansOfTransport(meansOfTransport);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@Override
	public VInvoice cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the bag quantity of this v invoice.
	 *
	 * @return the bag quantity of this v invoice
	 */
	@Override
	public Double getBagQuantity() {
		return model.getBagQuantity();
	}

	/**
	 * Returns the carrier of this v invoice.
	 *
	 * @return the carrier of this v invoice
	 */
	@Override
	public String getCarrier() {
		return model.getCarrier();
	}

	/**
	 * Returns the create date of this v invoice.
	 *
	 * @return the create date of this v invoice
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the delivery no of this v invoice.
	 *
	 * @return the delivery no of this v invoice
	 */
	@Override
	public String getDeliveryNo() {
		return model.getDeliveryNo();
	}

	/**
	 * Returns the departure date of this v invoice.
	 *
	 * @return the departure date of this v invoice
	 */
	@Override
	public Date getDepartureDate() {
		return model.getDepartureDate();
	}

	/**
	 * Returns the gross weight of this v invoice.
	 *
	 * @return the gross weight of this v invoice
	 */
	@Override
	public Double getGrossWeight() {
		return model.getGrossWeight();
	}

	/**
	 * Returns the material description of this v invoice.
	 *
	 * @return the material description of this v invoice
	 */
	@Override
	public String getMaterialDescription() {
		return model.getMaterialDescription();
	}

	/**
	 * Returns the material no of this v invoice.
	 *
	 * @return the material no of this v invoice
	 */
	@Override
	public String getMaterialNo() {
		return model.getMaterialNo();
	}

	/**
	 * Returns the means of transport of this v invoice.
	 *
	 * @return the means of transport of this v invoice
	 */
	@Override
	public String getMeansOfTransport() {
		return model.getMeansOfTransport();
	}

	/**
	 * Returns the net weight of this v invoice.
	 *
	 * @return the net weight of this v invoice
	 */
	@Override
	public Double getNetWeight() {
		return model.getNetWeight();
	}

	/**
	 * Returns the primary key of this v invoice.
	 *
	 * @return the primary key of this v invoice
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the quantity of this v invoice.
	 *
	 * @return the quantity of this v invoice
	 */
	@Override
	public Map<String, Serializable> getQuantity() {
		return model.getQuantity();
	}

	/**
	 * Returns the receiving plant of this v invoice.
	 *
	 * @return the receiving plant of this v invoice
	 */
	@Override
	public String getReceivingPlant() {
		return model.getReceivingPlant();
	}

	/**
	 * Returns the receiving plant desc of this v invoice.
	 *
	 * @return the receiving plant desc of this v invoice
	 */
	@Override
	public String getReceivingPlantDesc() {
		return model.getReceivingPlantDesc();
	}

	/**
	 * Returns the sending plant of this v invoice.
	 *
	 * @return the sending plant of this v invoice
	 */
	@Override
	public String getSendingPlant() {
		return model.getSendingPlant();
	}

	/**
	 * Returns the sending plant desc of this v invoice.
	 *
	 * @return the sending plant desc of this v invoice
	 */
	@Override
	public String getSendingPlantDesc() {
		return model.getSendingPlantDesc();
	}

	/**
	 * Returns the storage bin of this v invoice.
	 *
	 * @return the storage bin of this v invoice
	 */
	@Override
	public String getStorageBin() {
		return model.getStorageBin();
	}

	/**
	 * Returns the storage location of this v invoice.
	 *
	 * @return the storage location of this v invoice
	 */
	@Override
	public String getStorageLocation() {
		return model.getStorageLocation();
	}

	/**
	 * Returns the transportation mode of this v invoice.
	 *
	 * @return the transportation mode of this v invoice
	 */
	@Override
	public String getTransportationMode() {
		return model.getTransportationMode();
	}

	/**
	 * Returns the user name of this v invoice.
	 *
	 * @return the user name of this v invoice
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the v invoice ID of this v invoice.
	 *
	 * @return the v invoice ID of this v invoice
	 */
	@Override
	public long getVInvoiceId() {
		return model.getVInvoiceId();
	}

	/**
	 * Returns the v invoice no of this v invoice.
	 *
	 * @return the v invoice no of this v invoice
	 */
	@Override
	public String getVInvoiceNo() {
		return model.getVInvoiceNo();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the bag quantity of this v invoice.
	 *
	 * @param bagQuantity the bag quantity of this v invoice
	 */
	@Override
	public void setBagQuantity(Double bagQuantity) {
		model.setBagQuantity(bagQuantity);
	}

	/**
	 * Sets the carrier of this v invoice.
	 *
	 * @param carrier the carrier of this v invoice
	 */
	@Override
	public void setCarrier(String carrier) {
		model.setCarrier(carrier);
	}

	/**
	 * Sets the create date of this v invoice.
	 *
	 * @param createDate the create date of this v invoice
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the delivery no of this v invoice.
	 *
	 * @param deliveryNo the delivery no of this v invoice
	 */
	@Override
	public void setDeliveryNo(String deliveryNo) {
		model.setDeliveryNo(deliveryNo);
	}

	/**
	 * Sets the departure date of this v invoice.
	 *
	 * @param departureDate the departure date of this v invoice
	 */
	@Override
	public void setDepartureDate(Date departureDate) {
		model.setDepartureDate(departureDate);
	}

	/**
	 * Sets the gross weight of this v invoice.
	 *
	 * @param grossWeight the gross weight of this v invoice
	 */
	@Override
	public void setGrossWeight(Double grossWeight) {
		model.setGrossWeight(grossWeight);
	}

	/**
	 * Sets the material description of this v invoice.
	 *
	 * @param materialDescription the material description of this v invoice
	 */
	@Override
	public void setMaterialDescription(String materialDescription) {
		model.setMaterialDescription(materialDescription);
	}

	/**
	 * Sets the material no of this v invoice.
	 *
	 * @param materialNo the material no of this v invoice
	 */
	@Override
	public void setMaterialNo(String materialNo) {
		model.setMaterialNo(materialNo);
	}

	/**
	 * Sets the means of transport of this v invoice.
	 *
	 * @param meansOfTransport the means of transport of this v invoice
	 */
	@Override
	public void setMeansOfTransport(String meansOfTransport) {
		model.setMeansOfTransport(meansOfTransport);
	}

	/**
	 * Sets the net weight of this v invoice.
	 *
	 * @param netWeight the net weight of this v invoice
	 */
	@Override
	public void setNetWeight(Double netWeight) {
		model.setNetWeight(netWeight);
	}

	/**
	 * Sets the primary key of this v invoice.
	 *
	 * @param primaryKey the primary key of this v invoice
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the quantity of this v invoice.
	 *
	 * @param quantity the quantity of this v invoice
	 */
	@Override
	public void setQuantity(Map<String, Serializable> quantity) {
		model.setQuantity(quantity);
	}

	/**
	 * Sets the receiving plant of this v invoice.
	 *
	 * @param receivingPlant the receiving plant of this v invoice
	 */
	@Override
	public void setReceivingPlant(String receivingPlant) {
		model.setReceivingPlant(receivingPlant);
	}

	/**
	 * Sets the receiving plant desc of this v invoice.
	 *
	 * @param receivingPlantDesc the receiving plant desc of this v invoice
	 */
	@Override
	public void setReceivingPlantDesc(String receivingPlantDesc) {
		model.setReceivingPlantDesc(receivingPlantDesc);
	}

	/**
	 * Sets the sending plant of this v invoice.
	 *
	 * @param sendingPlant the sending plant of this v invoice
	 */
	@Override
	public void setSendingPlant(String sendingPlant) {
		model.setSendingPlant(sendingPlant);
	}

	/**
	 * Sets the sending plant desc of this v invoice.
	 *
	 * @param sendingPlantDesc the sending plant desc of this v invoice
	 */
	@Override
	public void setSendingPlantDesc(String sendingPlantDesc) {
		model.setSendingPlantDesc(sendingPlantDesc);
	}

	/**
	 * Sets the storage bin of this v invoice.
	 *
	 * @param storageBin the storage bin of this v invoice
	 */
	@Override
	public void setStorageBin(String storageBin) {
		model.setStorageBin(storageBin);
	}

	/**
	 * Sets the storage location of this v invoice.
	 *
	 * @param storageLocation the storage location of this v invoice
	 */
	@Override
	public void setStorageLocation(String storageLocation) {
		model.setStorageLocation(storageLocation);
	}

	/**
	 * Sets the transportation mode of this v invoice.
	 *
	 * @param transportationMode the transportation mode of this v invoice
	 */
	@Override
	public void setTransportationMode(String transportationMode) {
		model.setTransportationMode(transportationMode);
	}

	/**
	 * Sets the user name of this v invoice.
	 *
	 * @param userName the user name of this v invoice
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the v invoice ID of this v invoice.
	 *
	 * @param vInvoiceId the v invoice ID of this v invoice
	 */
	@Override
	public void setVInvoiceId(long vInvoiceId) {
		model.setVInvoiceId(vInvoiceId);
	}

	/**
	 * Sets the v invoice no of this v invoice.
	 *
	 * @param vInvoiceNo the v invoice no of this v invoice
	 */
	@Override
	public void setVInvoiceNo(String vInvoiceNo) {
		model.setVInvoiceNo(vInvoiceNo);
	}

	@Override
	protected VInvoiceWrapper wrap(VInvoice vInvoice) {
		return new VInvoiceWrapper(vInvoice);
	}

}