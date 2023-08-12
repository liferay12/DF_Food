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

package bd.gov.dgfood.common.services.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Indent}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Indent
 * @generated
 */
public class IndentWrapper
	extends BaseModelWrapper<Indent> implements Indent, ModelWrapper<Indent> {

	public IndentWrapper(Indent indent) {
		super(indent);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("indentId", getIndentId());
		attributes.put("allocationId", getAllocationId());
		attributes.put("commodity", getCommodity());
		attributes.put("commodityDescription", getCommodityDescription());
		attributes.put("quantity", getQuantity());
		attributes.put("quantityUnit", getQuantityUnit());
		attributes.put("requiredDeliveryDate", getRequiredDeliveryDate());
		attributes.put("foodGrainissueDate", getFoodGrainissueDate());
		attributes.put("netPrice", getNetPrice());
		attributes.put("netPriceCurrencyKey", getNetPriceCurrencyKey());
		attributes.put("netValue", getNetValue());
		attributes.put("netValueCurrencyKey", getNetValueCurrencyKey());
		attributes.put("salesOffice", getSalesOffice());
		attributes.put("depo", getDepo());
		attributes.put("repaymentTerms", getRepaymentTerms());
		attributes.put("deliveryTerms", getDeliveryTerms());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("reason", getReason());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long indentId = (Long)attributes.get("indentId");

		if (indentId != null) {
			setIndentId(indentId);
		}

		Long allocationId = (Long)attributes.get("allocationId");

		if (allocationId != null) {
			setAllocationId(allocationId);
		}

		String commodity = (String)attributes.get("commodity");

		if (commodity != null) {
			setCommodity(commodity);
		}

		String commodityDescription = (String)attributes.get(
			"commodityDescription");

		if (commodityDescription != null) {
			setCommodityDescription(commodityDescription);
		}

		Double quantity = (Double)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
		}

		String quantityUnit = (String)attributes.get("quantityUnit");

		if (quantityUnit != null) {
			setQuantityUnit(quantityUnit);
		}

		Date requiredDeliveryDate = (Date)attributes.get(
			"requiredDeliveryDate");

		if (requiredDeliveryDate != null) {
			setRequiredDeliveryDate(requiredDeliveryDate);
		}

		Date foodGrainissueDate = (Date)attributes.get("foodGrainissueDate");

		if (foodGrainissueDate != null) {
			setFoodGrainissueDate(foodGrainissueDate);
		}

		Double netPrice = (Double)attributes.get("netPrice");

		if (netPrice != null) {
			setNetPrice(netPrice);
		}

		String netPriceCurrencyKey = (String)attributes.get(
			"netPriceCurrencyKey");

		if (netPriceCurrencyKey != null) {
			setNetPriceCurrencyKey(netPriceCurrencyKey);
		}

		Double netValue = (Double)attributes.get("netValue");

		if (netValue != null) {
			setNetValue(netValue);
		}

		String netValueCurrencyKey = (String)attributes.get(
			"netValueCurrencyKey");

		if (netValueCurrencyKey != null) {
			setNetValueCurrencyKey(netValueCurrencyKey);
		}

		String salesOffice = (String)attributes.get("salesOffice");

		if (salesOffice != null) {
			setSalesOffice(salesOffice);
		}

		String depo = (String)attributes.get("depo");

		if (depo != null) {
			setDepo(depo);
		}

		String repaymentTerms = (String)attributes.get("repaymentTerms");

		if (repaymentTerms != null) {
			setRepaymentTerms(repaymentTerms);
		}

		String deliveryTerms = (String)attributes.get("deliveryTerms");

		if (deliveryTerms != null) {
			setDeliveryTerms(deliveryTerms);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Integer reason = (Integer)attributes.get("reason");

		if (reason != null) {
			setReason(reason);
		}
	}

	@Override
	public Indent cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the allocation ID of this indent.
	 *
	 * @return the allocation ID of this indent
	 */
	@Override
	public long getAllocationId() {
		return model.getAllocationId();
	}

	/**
	 * Returns the commodity of this indent.
	 *
	 * @return the commodity of this indent
	 */
	@Override
	public String getCommodity() {
		return model.getCommodity();
	}

	/**
	 * Returns the commodity description of this indent.
	 *
	 * @return the commodity description of this indent
	 */
	@Override
	public String getCommodityDescription() {
		return model.getCommodityDescription();
	}

	/**
	 * Returns the company ID of this indent.
	 *
	 * @return the company ID of this indent
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this indent.
	 *
	 * @return the create date of this indent
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the delivery terms of this indent.
	 *
	 * @return the delivery terms of this indent
	 */
	@Override
	public String getDeliveryTerms() {
		return model.getDeliveryTerms();
	}

	/**
	 * Returns the depo of this indent.
	 *
	 * @return the depo of this indent
	 */
	@Override
	public String getDepo() {
		return model.getDepo();
	}

	/**
	 * Returns the food grainissue date of this indent.
	 *
	 * @return the food grainissue date of this indent
	 */
	@Override
	public Date getFoodGrainissueDate() {
		return model.getFoodGrainissueDate();
	}

	/**
	 * Returns the group ID of this indent.
	 *
	 * @return the group ID of this indent
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the indent ID of this indent.
	 *
	 * @return the indent ID of this indent
	 */
	@Override
	public long getIndentId() {
		return model.getIndentId();
	}

	/**
	 * Returns the modified date of this indent.
	 *
	 * @return the modified date of this indent
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the net price of this indent.
	 *
	 * @return the net price of this indent
	 */
	@Override
	public double getNetPrice() {
		return model.getNetPrice();
	}

	/**
	 * Returns the net price currency key of this indent.
	 *
	 * @return the net price currency key of this indent
	 */
	@Override
	public String getNetPriceCurrencyKey() {
		return model.getNetPriceCurrencyKey();
	}

	/**
	 * Returns the net value of this indent.
	 *
	 * @return the net value of this indent
	 */
	@Override
	public double getNetValue() {
		return model.getNetValue();
	}

	/**
	 * Returns the net value currency key of this indent.
	 *
	 * @return the net value currency key of this indent
	 */
	@Override
	public String getNetValueCurrencyKey() {
		return model.getNetValueCurrencyKey();
	}

	/**
	 * Returns the primary key of this indent.
	 *
	 * @return the primary key of this indent
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the quantity of this indent.
	 *
	 * @return the quantity of this indent
	 */
	@Override
	public double getQuantity() {
		return model.getQuantity();
	}

	/**
	 * Returns the quantity unit of this indent.
	 *
	 * @return the quantity unit of this indent
	 */
	@Override
	public String getQuantityUnit() {
		return model.getQuantityUnit();
	}

	/**
	 * Returns the reason of this indent.
	 *
	 * @return the reason of this indent
	 */
	@Override
	public int getReason() {
		return model.getReason();
	}

	/**
	 * Returns the repayment terms of this indent.
	 *
	 * @return the repayment terms of this indent
	 */
	@Override
	public String getRepaymentTerms() {
		return model.getRepaymentTerms();
	}

	/**
	 * Returns the required delivery date of this indent.
	 *
	 * @return the required delivery date of this indent
	 */
	@Override
	public Date getRequiredDeliveryDate() {
		return model.getRequiredDeliveryDate();
	}

	/**
	 * Returns the sales office of this indent.
	 *
	 * @return the sales office of this indent
	 */
	@Override
	public String getSalesOffice() {
		return model.getSalesOffice();
	}

	/**
	 * Returns the status of this indent.
	 *
	 * @return the status of this indent
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this indent.
	 *
	 * @return the user ID of this indent
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this indent.
	 *
	 * @return the user uuid of this indent
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this indent.
	 *
	 * @return the uuid of this indent
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the allocation ID of this indent.
	 *
	 * @param allocationId the allocation ID of this indent
	 */
	@Override
	public void setAllocationId(long allocationId) {
		model.setAllocationId(allocationId);
	}

	/**
	 * Sets the commodity of this indent.
	 *
	 * @param commodity the commodity of this indent
	 */
	@Override
	public void setCommodity(String commodity) {
		model.setCommodity(commodity);
	}

	/**
	 * Sets the commodity description of this indent.
	 *
	 * @param commodityDescription the commodity description of this indent
	 */
	@Override
	public void setCommodityDescription(String commodityDescription) {
		model.setCommodityDescription(commodityDescription);
	}

	/**
	 * Sets the company ID of this indent.
	 *
	 * @param companyId the company ID of this indent
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this indent.
	 *
	 * @param createDate the create date of this indent
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the delivery terms of this indent.
	 *
	 * @param deliveryTerms the delivery terms of this indent
	 */
	@Override
	public void setDeliveryTerms(String deliveryTerms) {
		model.setDeliveryTerms(deliveryTerms);
	}

	/**
	 * Sets the depo of this indent.
	 *
	 * @param depo the depo of this indent
	 */
	@Override
	public void setDepo(String depo) {
		model.setDepo(depo);
	}

	/**
	 * Sets the food grainissue date of this indent.
	 *
	 * @param foodGrainissueDate the food grainissue date of this indent
	 */
	@Override
	public void setFoodGrainissueDate(Date foodGrainissueDate) {
		model.setFoodGrainissueDate(foodGrainissueDate);
	}

	/**
	 * Sets the group ID of this indent.
	 *
	 * @param groupId the group ID of this indent
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the indent ID of this indent.
	 *
	 * @param indentId the indent ID of this indent
	 */
	@Override
	public void setIndentId(long indentId) {
		model.setIndentId(indentId);
	}

	/**
	 * Sets the modified date of this indent.
	 *
	 * @param modifiedDate the modified date of this indent
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the net price of this indent.
	 *
	 * @param netPrice the net price of this indent
	 */
	@Override
	public void setNetPrice(double netPrice) {
		model.setNetPrice(netPrice);
	}

	/**
	 * Sets the net price currency key of this indent.
	 *
	 * @param netPriceCurrencyKey the net price currency key of this indent
	 */
	@Override
	public void setNetPriceCurrencyKey(String netPriceCurrencyKey) {
		model.setNetPriceCurrencyKey(netPriceCurrencyKey);
	}

	/**
	 * Sets the net value of this indent.
	 *
	 * @param netValue the net value of this indent
	 */
	@Override
	public void setNetValue(double netValue) {
		model.setNetValue(netValue);
	}

	/**
	 * Sets the net value currency key of this indent.
	 *
	 * @param netValueCurrencyKey the net value currency key of this indent
	 */
	@Override
	public void setNetValueCurrencyKey(String netValueCurrencyKey) {
		model.setNetValueCurrencyKey(netValueCurrencyKey);
	}

	/**
	 * Sets the primary key of this indent.
	 *
	 * @param primaryKey the primary key of this indent
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the quantity of this indent.
	 *
	 * @param quantity the quantity of this indent
	 */
	@Override
	public void setQuantity(double quantity) {
		model.setQuantity(quantity);
	}

	/**
	 * Sets the quantity unit of this indent.
	 *
	 * @param quantityUnit the quantity unit of this indent
	 */
	@Override
	public void setQuantityUnit(String quantityUnit) {
		model.setQuantityUnit(quantityUnit);
	}

	/**
	 * Sets the reason of this indent.
	 *
	 * @param reason the reason of this indent
	 */
	@Override
	public void setReason(int reason) {
		model.setReason(reason);
	}

	/**
	 * Sets the repayment terms of this indent.
	 *
	 * @param repaymentTerms the repayment terms of this indent
	 */
	@Override
	public void setRepaymentTerms(String repaymentTerms) {
		model.setRepaymentTerms(repaymentTerms);
	}

	/**
	 * Sets the required delivery date of this indent.
	 *
	 * @param requiredDeliveryDate the required delivery date of this indent
	 */
	@Override
	public void setRequiredDeliveryDate(Date requiredDeliveryDate) {
		model.setRequiredDeliveryDate(requiredDeliveryDate);
	}

	/**
	 * Sets the sales office of this indent.
	 *
	 * @param salesOffice the sales office of this indent
	 */
	@Override
	public void setSalesOffice(String salesOffice) {
		model.setSalesOffice(salesOffice);
	}

	/**
	 * Sets the status of this indent.
	 *
	 * @param status the status of this indent
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this indent.
	 *
	 * @param userId the user ID of this indent
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this indent.
	 *
	 * @param userUuid the user uuid of this indent
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this indent.
	 *
	 * @param uuid the uuid of this indent
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected IndentWrapper wrap(Indent indent) {
		return new IndentWrapper(indent);
	}

}