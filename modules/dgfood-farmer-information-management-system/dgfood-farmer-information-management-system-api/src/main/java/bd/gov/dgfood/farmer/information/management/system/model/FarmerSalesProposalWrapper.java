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

package bd.gov.dgfood.farmer.information.management.system.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FarmerSalesProposal}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FarmerSalesProposal
 * @generated
 */
public class FarmerSalesProposalWrapper
	extends BaseModelWrapper<FarmerSalesProposal>
	implements FarmerSalesProposal, ModelWrapper<FarmerSalesProposal> {

	public FarmerSalesProposalWrapper(FarmerSalesProposal farmerSalesProposal) {
		super(farmerSalesProposal);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("farmerSalesProposalId", getFarmerSalesProposalId());
		attributes.put("applicationNumber", getApplicationNumber());
		attributes.put("farmerRegistrationId", getFarmerRegistrationId());
		attributes.put("businessCode", getBusinessCode());
		attributes.put("currentSeason", getCurrentSeason());
		attributes.put("foodGrainType", getFoodGrainType());
		attributes.put("krishiCardNumber", getKrishiCardNumber());
		attributes.put("pastProdDataSeason1", getPastProdDataSeason1());
		attributes.put("pastProdDataSeason2", getPastProdDataSeason2());
		attributes.put("pastProdDataSeason3", getPastProdDataSeason3());
		attributes.put(
			"succeedingProdDataSeason1", getSucceedingProdDataSeason1());
		attributes.put(
			"succeedingProdDataSeason2", getSucceedingProdDataSeason2());
		attributes.put(
			"succeedingProdDataSeason3", getSucceedingProdDataSeason3());
		attributes.put(
			"grainProcuredInLast4Seasons ", isGrainProcuredInLast4Seasons());
		attributes.put("foodgranProcuredSeason1", getFoodgranProcuredSeason1());
		attributes.put("foodgranProcuredSeason2", getFoodgranProcuredSeason2());
		attributes.put("foodgranProcuredSeason3", getFoodgranProcuredSeason3());
		attributes.put("foodgranProcuredSeason4", getFoodgranProcuredSeason4());
		attributes.put("cultivableLandSeason1", getCultivableLandSeason1());
		attributes.put("cultivableLandSeason2", getCultivableLandSeason2());
		attributes.put("cultivableLandSeason3", getCultivableLandSeason3());
		attributes.put("foodgrainReceivedStatus", getFoodgrainReceivedStatus());
		attributes.put("receivedFoodgrainQty", getReceivedFoodgrainQty());
		attributes.put("foodgrainReceivedDate", getFoodgrainReceivedDate());
		attributes.put("paymentStatus", getPaymentStatus());
		attributes.put("remarks", getRemarks());
		attributes.put("version", getVersion());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long farmerSalesProposalId = (Long)attributes.get(
			"farmerSalesProposalId");

		if (farmerSalesProposalId != null) {
			setFarmerSalesProposalId(farmerSalesProposalId);
		}

		String applicationNumber = (String)attributes.get("applicationNumber");

		if (applicationNumber != null) {
			setApplicationNumber(applicationNumber);
		}

		Long farmerRegistrationId = (Long)attributes.get(
			"farmerRegistrationId");

		if (farmerRegistrationId != null) {
			setFarmerRegistrationId(farmerRegistrationId);
		}

		String businessCode = (String)attributes.get("businessCode");

		if (businessCode != null) {
			setBusinessCode(businessCode);
		}

		String currentSeason = (String)attributes.get("currentSeason");

		if (currentSeason != null) {
			setCurrentSeason(currentSeason);
		}

		String foodGrainType = (String)attributes.get("foodGrainType");

		if (foodGrainType != null) {
			setFoodGrainType(foodGrainType);
		}

		String krishiCardNumber = (String)attributes.get("krishiCardNumber");

		if (krishiCardNumber != null) {
			setKrishiCardNumber(krishiCardNumber);
		}

		Map<String, Serializable> pastProdDataSeason1 =
			(Map<String, Serializable>)attributes.get("pastProdDataSeason1");

		if (pastProdDataSeason1 != null) {
			setPastProdDataSeason1(pastProdDataSeason1);
		}

		Map<String, Serializable> pastProdDataSeason2 =
			(Map<String, Serializable>)attributes.get("pastProdDataSeason2");

		if (pastProdDataSeason2 != null) {
			setPastProdDataSeason2(pastProdDataSeason2);
		}

		Map<String, Serializable> pastProdDataSeason3 =
			(Map<String, Serializable>)attributes.get("pastProdDataSeason3");

		if (pastProdDataSeason3 != null) {
			setPastProdDataSeason3(pastProdDataSeason3);
		}

		Map<String, Serializable> succeedingProdDataSeason1 =
			(Map<String, Serializable>)attributes.get(
				"succeedingProdDataSeason1");

		if (succeedingProdDataSeason1 != null) {
			setSucceedingProdDataSeason1(succeedingProdDataSeason1);
		}

		Map<String, Serializable> succeedingProdDataSeason2 =
			(Map<String, Serializable>)attributes.get(
				"succeedingProdDataSeason2");

		if (succeedingProdDataSeason2 != null) {
			setSucceedingProdDataSeason2(succeedingProdDataSeason2);
		}

		Map<String, Serializable> succeedingProdDataSeason3 =
			(Map<String, Serializable>)attributes.get(
				"succeedingProdDataSeason3");

		if (succeedingProdDataSeason3 != null) {
			setSucceedingProdDataSeason3(succeedingProdDataSeason3);
		}

		Boolean grainProcuredInLast4Seasons = (Boolean)attributes.get(
			"grainProcuredInLast4Seasons ");

		if (grainProcuredInLast4Seasons != null) {
			setGrainProcuredInLast4Seasons(grainProcuredInLast4Seasons);
		}

		Map<String, Serializable> foodgranProcuredSeason1 =
			(Map<String, Serializable>)attributes.get(
				"foodgranProcuredSeason1");

		if (foodgranProcuredSeason1 != null) {
			setFoodgranProcuredSeason1(foodgranProcuredSeason1);
		}

		Map<String, Serializable> foodgranProcuredSeason2 =
			(Map<String, Serializable>)attributes.get(
				"foodgranProcuredSeason2");

		if (foodgranProcuredSeason2 != null) {
			setFoodgranProcuredSeason2(foodgranProcuredSeason2);
		}

		Map<String, Serializable> foodgranProcuredSeason3 =
			(Map<String, Serializable>)attributes.get(
				"foodgranProcuredSeason3");

		if (foodgranProcuredSeason3 != null) {
			setFoodgranProcuredSeason3(foodgranProcuredSeason3);
		}

		Map<String, Serializable> foodgranProcuredSeason4 =
			(Map<String, Serializable>)attributes.get(
				"foodgranProcuredSeason4");

		if (foodgranProcuredSeason4 != null) {
			setFoodgranProcuredSeason4(foodgranProcuredSeason4);
		}

		Map<String, Serializable> cultivableLandSeason1 =
			(Map<String, Serializable>)attributes.get("cultivableLandSeason1");

		if (cultivableLandSeason1 != null) {
			setCultivableLandSeason1(cultivableLandSeason1);
		}

		Map<String, Serializable> cultivableLandSeason2 =
			(Map<String, Serializable>)attributes.get("cultivableLandSeason2");

		if (cultivableLandSeason2 != null) {
			setCultivableLandSeason2(cultivableLandSeason2);
		}

		Map<String, Serializable> cultivableLandSeason3 =
			(Map<String, Serializable>)attributes.get("cultivableLandSeason3");

		if (cultivableLandSeason3 != null) {
			setCultivableLandSeason3(cultivableLandSeason3);
		}

		Integer foodgrainReceivedStatus = (Integer)attributes.get(
			"foodgrainReceivedStatus");

		if (foodgrainReceivedStatus != null) {
			setFoodgrainReceivedStatus(foodgrainReceivedStatus);
		}

		Map<String, Serializable> receivedFoodgrainQty =
			(Map<String, Serializable>)attributes.get("receivedFoodgrainQty");

		if (receivedFoodgrainQty != null) {
			setReceivedFoodgrainQty(receivedFoodgrainQty);
		}

		Date foodgrainReceivedDate = (Date)attributes.get(
			"foodgrainReceivedDate");

		if (foodgrainReceivedDate != null) {
			setFoodgrainReceivedDate(foodgrainReceivedDate);
		}

		Integer paymentStatus = (Integer)attributes.get("paymentStatus");

		if (paymentStatus != null) {
			setPaymentStatus(paymentStatus);
		}

		String remarks = (String)attributes.get("remarks");

		if (remarks != null) {
			setRemarks(remarks);
		}

		Double version = (Double)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	@Override
	public FarmerSalesProposal cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the application number of this farmer sales proposal.
	 *
	 * @return the application number of this farmer sales proposal
	 */
	@Override
	public String getApplicationNumber() {
		return model.getApplicationNumber();
	}

	/**
	 * Returns the business code of this farmer sales proposal.
	 *
	 * @return the business code of this farmer sales proposal
	 */
	@Override
	public String getBusinessCode() {
		return model.getBusinessCode();
	}

	/**
	 * Returns the company ID of this farmer sales proposal.
	 *
	 * @return the company ID of this farmer sales proposal
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this farmer sales proposal.
	 *
	 * @return the create date of this farmer sales proposal
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this farmer sales proposal.
	 *
	 * @return the created by of this farmer sales proposal
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the cultivable land season1 of this farmer sales proposal.
	 *
	 * @return the cultivable land season1 of this farmer sales proposal
	 */
	@Override
	public Map<String, Serializable> getCultivableLandSeason1() {
		return model.getCultivableLandSeason1();
	}

	/**
	 * Returns the cultivable land season2 of this farmer sales proposal.
	 *
	 * @return the cultivable land season2 of this farmer sales proposal
	 */
	@Override
	public Map<String, Serializable> getCultivableLandSeason2() {
		return model.getCultivableLandSeason2();
	}

	/**
	 * Returns the cultivable land season3 of this farmer sales proposal.
	 *
	 * @return the cultivable land season3 of this farmer sales proposal
	 */
	@Override
	public Map<String, Serializable> getCultivableLandSeason3() {
		return model.getCultivableLandSeason3();
	}

	/**
	 * Returns the current season of this farmer sales proposal.
	 *
	 * @return the current season of this farmer sales proposal
	 */
	@Override
	public String getCurrentSeason() {
		return model.getCurrentSeason();
	}

	/**
	 * Returns the farmer registration ID of this farmer sales proposal.
	 *
	 * @return the farmer registration ID of this farmer sales proposal
	 */
	@Override
	public long getFarmerRegistrationId() {
		return model.getFarmerRegistrationId();
	}

	/**
	 * Returns the farmer sales proposal ID of this farmer sales proposal.
	 *
	 * @return the farmer sales proposal ID of this farmer sales proposal
	 */
	@Override
	public long getFarmerSalesProposalId() {
		return model.getFarmerSalesProposalId();
	}

	/**
	 * Returns the foodgrain received date of this farmer sales proposal.
	 *
	 * @return the foodgrain received date of this farmer sales proposal
	 */
	@Override
	public Date getFoodgrainReceivedDate() {
		return model.getFoodgrainReceivedDate();
	}

	/**
	 * Returns the foodgrain received status of this farmer sales proposal.
	 *
	 * @return the foodgrain received status of this farmer sales proposal
	 */
	@Override
	public int getFoodgrainReceivedStatus() {
		return model.getFoodgrainReceivedStatus();
	}

	/**
	 * Returns the food grain type of this farmer sales proposal.
	 *
	 * @return the food grain type of this farmer sales proposal
	 */
	@Override
	public String getFoodGrainType() {
		return model.getFoodGrainType();
	}

	/**
	 * Returns the foodgran procured season1 of this farmer sales proposal.
	 *
	 * @return the foodgran procured season1 of this farmer sales proposal
	 */
	@Override
	public Map<String, Serializable> getFoodgranProcuredSeason1() {
		return model.getFoodgranProcuredSeason1();
	}

	/**
	 * Returns the foodgran procured season2 of this farmer sales proposal.
	 *
	 * @return the foodgran procured season2 of this farmer sales proposal
	 */
	@Override
	public Map<String, Serializable> getFoodgranProcuredSeason2() {
		return model.getFoodgranProcuredSeason2();
	}

	/**
	 * Returns the foodgran procured season3 of this farmer sales proposal.
	 *
	 * @return the foodgran procured season3 of this farmer sales proposal
	 */
	@Override
	public Map<String, Serializable> getFoodgranProcuredSeason3() {
		return model.getFoodgranProcuredSeason3();
	}

	/**
	 * Returns the foodgran procured season4 of this farmer sales proposal.
	 *
	 * @return the foodgran procured season4 of this farmer sales proposal
	 */
	@Override
	public Map<String, Serializable> getFoodgranProcuredSeason4() {
		return model.getFoodgranProcuredSeason4();
	}

	/**
	 * Returns the grain procured in last4 seasons of this farmer sales proposal.
	 *
	 * @return the grain procured in last4 seasons of this farmer sales proposal
	 */
	@Override
	public boolean getGrainProcuredInLast4Seasons() {
		return model.getGrainProcuredInLast4Seasons();
	}

	/**
	 * Returns the group ID of this farmer sales proposal.
	 *
	 * @return the group ID of this farmer sales proposal
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the krishi card number of this farmer sales proposal.
	 *
	 * @return the krishi card number of this farmer sales proposal
	 */
	@Override
	public String getKrishiCardNumber() {
		return model.getKrishiCardNumber();
	}

	/**
	 * Returns the modified by of this farmer sales proposal.
	 *
	 * @return the modified by of this farmer sales proposal
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this farmer sales proposal.
	 *
	 * @return the modified date of this farmer sales proposal
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the past prod data season1 of this farmer sales proposal.
	 *
	 * @return the past prod data season1 of this farmer sales proposal
	 */
	@Override
	public Map<String, Serializable> getPastProdDataSeason1() {
		return model.getPastProdDataSeason1();
	}

	/**
	 * Returns the past prod data season2 of this farmer sales proposal.
	 *
	 * @return the past prod data season2 of this farmer sales proposal
	 */
	@Override
	public Map<String, Serializable> getPastProdDataSeason2() {
		return model.getPastProdDataSeason2();
	}

	/**
	 * Returns the past prod data season3 of this farmer sales proposal.
	 *
	 * @return the past prod data season3 of this farmer sales proposal
	 */
	@Override
	public Map<String, Serializable> getPastProdDataSeason3() {
		return model.getPastProdDataSeason3();
	}

	/**
	 * Returns the payment status of this farmer sales proposal.
	 *
	 * @return the payment status of this farmer sales proposal
	 */
	@Override
	public int getPaymentStatus() {
		return model.getPaymentStatus();
	}

	/**
	 * Returns the primary key of this farmer sales proposal.
	 *
	 * @return the primary key of this farmer sales proposal
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the received foodgrain qty of this farmer sales proposal.
	 *
	 * @return the received foodgrain qty of this farmer sales proposal
	 */
	@Override
	public Map<String, Serializable> getReceivedFoodgrainQty() {
		return model.getReceivedFoodgrainQty();
	}

	/**
	 * Returns the remarks of this farmer sales proposal.
	 *
	 * @return the remarks of this farmer sales proposal
	 */
	@Override
	public String getRemarks() {
		return model.getRemarks();
	}

	/**
	 * Returns the status of this farmer sales proposal.
	 *
	 * @return the status of this farmer sales proposal
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this farmer sales proposal.
	 *
	 * @return the status by user ID of this farmer sales proposal
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this farmer sales proposal.
	 *
	 * @return the status by user name of this farmer sales proposal
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this farmer sales proposal.
	 *
	 * @return the status by user uuid of this farmer sales proposal
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this farmer sales proposal.
	 *
	 * @return the status date of this farmer sales proposal
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the succeeding prod data season1 of this farmer sales proposal.
	 *
	 * @return the succeeding prod data season1 of this farmer sales proposal
	 */
	@Override
	public Map<String, Serializable> getSucceedingProdDataSeason1() {
		return model.getSucceedingProdDataSeason1();
	}

	/**
	 * Returns the succeeding prod data season2 of this farmer sales proposal.
	 *
	 * @return the succeeding prod data season2 of this farmer sales proposal
	 */
	@Override
	public Map<String, Serializable> getSucceedingProdDataSeason2() {
		return model.getSucceedingProdDataSeason2();
	}

	/**
	 * Returns the succeeding prod data season3 of this farmer sales proposal.
	 *
	 * @return the succeeding prod data season3 of this farmer sales proposal
	 */
	@Override
	public Map<String, Serializable> getSucceedingProdDataSeason3() {
		return model.getSucceedingProdDataSeason3();
	}

	/**
	 * Returns the uuid of this farmer sales proposal.
	 *
	 * @return the uuid of this farmer sales proposal
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the version of this farmer sales proposal.
	 *
	 * @return the version of this farmer sales proposal
	 */
	@Override
	public double getVersion() {
		return model.getVersion();
	}

	/**
	 * Returns <code>true</code> if this farmer sales proposal is approved.
	 *
	 * @return <code>true</code> if this farmer sales proposal is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this farmer sales proposal is denied.
	 *
	 * @return <code>true</code> if this farmer sales proposal is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this farmer sales proposal is a draft.
	 *
	 * @return <code>true</code> if this farmer sales proposal is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this farmer sales proposal is expired.
	 *
	 * @return <code>true</code> if this farmer sales proposal is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this farmer sales proposal is grain procured in last4 seasons.
	 *
	 * @return <code>true</code> if this farmer sales proposal is grain procured in last4 seasons; <code>false</code> otherwise
	 */
	@Override
	public boolean isGrainProcuredInLast4Seasons() {
		return model.isGrainProcuredInLast4Seasons();
	}

	/**
	 * Returns <code>true</code> if this farmer sales proposal is inactive.
	 *
	 * @return <code>true</code> if this farmer sales proposal is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this farmer sales proposal is incomplete.
	 *
	 * @return <code>true</code> if this farmer sales proposal is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this farmer sales proposal is pending.
	 *
	 * @return <code>true</code> if this farmer sales proposal is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this farmer sales proposal is scheduled.
	 *
	 * @return <code>true</code> if this farmer sales proposal is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the application number of this farmer sales proposal.
	 *
	 * @param applicationNumber the application number of this farmer sales proposal
	 */
	@Override
	public void setApplicationNumber(String applicationNumber) {
		model.setApplicationNumber(applicationNumber);
	}

	/**
	 * Sets the business code of this farmer sales proposal.
	 *
	 * @param businessCode the business code of this farmer sales proposal
	 */
	@Override
	public void setBusinessCode(String businessCode) {
		model.setBusinessCode(businessCode);
	}

	/**
	 * Sets the company ID of this farmer sales proposal.
	 *
	 * @param companyId the company ID of this farmer sales proposal
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this farmer sales proposal.
	 *
	 * @param createDate the create date of this farmer sales proposal
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this farmer sales proposal.
	 *
	 * @param createdBy the created by of this farmer sales proposal
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the cultivable land season1 of this farmer sales proposal.
	 *
	 * @param cultivableLandSeason1 the cultivable land season1 of this farmer sales proposal
	 */
	@Override
	public void setCultivableLandSeason1(
		Map<String, Serializable> cultivableLandSeason1) {

		model.setCultivableLandSeason1(cultivableLandSeason1);
	}

	/**
	 * Sets the cultivable land season2 of this farmer sales proposal.
	 *
	 * @param cultivableLandSeason2 the cultivable land season2 of this farmer sales proposal
	 */
	@Override
	public void setCultivableLandSeason2(
		Map<String, Serializable> cultivableLandSeason2) {

		model.setCultivableLandSeason2(cultivableLandSeason2);
	}

	/**
	 * Sets the cultivable land season3 of this farmer sales proposal.
	 *
	 * @param cultivableLandSeason3 the cultivable land season3 of this farmer sales proposal
	 */
	@Override
	public void setCultivableLandSeason3(
		Map<String, Serializable> cultivableLandSeason3) {

		model.setCultivableLandSeason3(cultivableLandSeason3);
	}

	/**
	 * Sets the current season of this farmer sales proposal.
	 *
	 * @param currentSeason the current season of this farmer sales proposal
	 */
	@Override
	public void setCurrentSeason(String currentSeason) {
		model.setCurrentSeason(currentSeason);
	}

	/**
	 * Sets the farmer registration ID of this farmer sales proposal.
	 *
	 * @param farmerRegistrationId the farmer registration ID of this farmer sales proposal
	 */
	@Override
	public void setFarmerRegistrationId(long farmerRegistrationId) {
		model.setFarmerRegistrationId(farmerRegistrationId);
	}

	/**
	 * Sets the farmer sales proposal ID of this farmer sales proposal.
	 *
	 * @param farmerSalesProposalId the farmer sales proposal ID of this farmer sales proposal
	 */
	@Override
	public void setFarmerSalesProposalId(long farmerSalesProposalId) {
		model.setFarmerSalesProposalId(farmerSalesProposalId);
	}

	/**
	 * Sets the foodgrain received date of this farmer sales proposal.
	 *
	 * @param foodgrainReceivedDate the foodgrain received date of this farmer sales proposal
	 */
	@Override
	public void setFoodgrainReceivedDate(Date foodgrainReceivedDate) {
		model.setFoodgrainReceivedDate(foodgrainReceivedDate);
	}

	/**
	 * Sets the foodgrain received status of this farmer sales proposal.
	 *
	 * @param foodgrainReceivedStatus the foodgrain received status of this farmer sales proposal
	 */
	@Override
	public void setFoodgrainReceivedStatus(int foodgrainReceivedStatus) {
		model.setFoodgrainReceivedStatus(foodgrainReceivedStatus);
	}

	/**
	 * Sets the food grain type of this farmer sales proposal.
	 *
	 * @param foodGrainType the food grain type of this farmer sales proposal
	 */
	@Override
	public void setFoodGrainType(String foodGrainType) {
		model.setFoodGrainType(foodGrainType);
	}

	/**
	 * Sets the foodgran procured season1 of this farmer sales proposal.
	 *
	 * @param foodgranProcuredSeason1 the foodgran procured season1 of this farmer sales proposal
	 */
	@Override
	public void setFoodgranProcuredSeason1(
		Map<String, Serializable> foodgranProcuredSeason1) {

		model.setFoodgranProcuredSeason1(foodgranProcuredSeason1);
	}

	/**
	 * Sets the foodgran procured season2 of this farmer sales proposal.
	 *
	 * @param foodgranProcuredSeason2 the foodgran procured season2 of this farmer sales proposal
	 */
	@Override
	public void setFoodgranProcuredSeason2(
		Map<String, Serializable> foodgranProcuredSeason2) {

		model.setFoodgranProcuredSeason2(foodgranProcuredSeason2);
	}

	/**
	 * Sets the foodgran procured season3 of this farmer sales proposal.
	 *
	 * @param foodgranProcuredSeason3 the foodgran procured season3 of this farmer sales proposal
	 */
	@Override
	public void setFoodgranProcuredSeason3(
		Map<String, Serializable> foodgranProcuredSeason3) {

		model.setFoodgranProcuredSeason3(foodgranProcuredSeason3);
	}

	/**
	 * Sets the foodgran procured season4 of this farmer sales proposal.
	 *
	 * @param foodgranProcuredSeason4 the foodgran procured season4 of this farmer sales proposal
	 */
	@Override
	public void setFoodgranProcuredSeason4(
		Map<String, Serializable> foodgranProcuredSeason4) {

		model.setFoodgranProcuredSeason4(foodgranProcuredSeason4);
	}

	/**
	 * Sets whether this farmer sales proposal is grain procured in last4 seasons.
	 *
	 * @param grainProcuredInLast4Seasons  the grain procured in last4 seasons of this farmer sales proposal
	 */
	@Override
	public void setGrainProcuredInLast4Seasons(
		boolean grainProcuredInLast4Seasons) {

		model.setGrainProcuredInLast4Seasons(grainProcuredInLast4Seasons);
	}

	/**
	 * Sets the group ID of this farmer sales proposal.
	 *
	 * @param groupId the group ID of this farmer sales proposal
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the krishi card number of this farmer sales proposal.
	 *
	 * @param krishiCardNumber the krishi card number of this farmer sales proposal
	 */
	@Override
	public void setKrishiCardNumber(String krishiCardNumber) {
		model.setKrishiCardNumber(krishiCardNumber);
	}

	/**
	 * Sets the modified by of this farmer sales proposal.
	 *
	 * @param modifiedBy the modified by of this farmer sales proposal
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this farmer sales proposal.
	 *
	 * @param modifiedDate the modified date of this farmer sales proposal
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the past prod data season1 of this farmer sales proposal.
	 *
	 * @param pastProdDataSeason1 the past prod data season1 of this farmer sales proposal
	 */
	@Override
	public void setPastProdDataSeason1(
		Map<String, Serializable> pastProdDataSeason1) {

		model.setPastProdDataSeason1(pastProdDataSeason1);
	}

	/**
	 * Sets the past prod data season2 of this farmer sales proposal.
	 *
	 * @param pastProdDataSeason2 the past prod data season2 of this farmer sales proposal
	 */
	@Override
	public void setPastProdDataSeason2(
		Map<String, Serializable> pastProdDataSeason2) {

		model.setPastProdDataSeason2(pastProdDataSeason2);
	}

	/**
	 * Sets the past prod data season3 of this farmer sales proposal.
	 *
	 * @param pastProdDataSeason3 the past prod data season3 of this farmer sales proposal
	 */
	@Override
	public void setPastProdDataSeason3(
		Map<String, Serializable> pastProdDataSeason3) {

		model.setPastProdDataSeason3(pastProdDataSeason3);
	}

	/**
	 * Sets the payment status of this farmer sales proposal.
	 *
	 * @param paymentStatus the payment status of this farmer sales proposal
	 */
	@Override
	public void setPaymentStatus(int paymentStatus) {
		model.setPaymentStatus(paymentStatus);
	}

	/**
	 * Sets the primary key of this farmer sales proposal.
	 *
	 * @param primaryKey the primary key of this farmer sales proposal
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the received foodgrain qty of this farmer sales proposal.
	 *
	 * @param receivedFoodgrainQty the received foodgrain qty of this farmer sales proposal
	 */
	@Override
	public void setReceivedFoodgrainQty(
		Map<String, Serializable> receivedFoodgrainQty) {

		model.setReceivedFoodgrainQty(receivedFoodgrainQty);
	}

	/**
	 * Sets the remarks of this farmer sales proposal.
	 *
	 * @param remarks the remarks of this farmer sales proposal
	 */
	@Override
	public void setRemarks(String remarks) {
		model.setRemarks(remarks);
	}

	/**
	 * Sets the status of this farmer sales proposal.
	 *
	 * @param status the status of this farmer sales proposal
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this farmer sales proposal.
	 *
	 * @param statusByUserId the status by user ID of this farmer sales proposal
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this farmer sales proposal.
	 *
	 * @param statusByUserName the status by user name of this farmer sales proposal
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this farmer sales proposal.
	 *
	 * @param statusByUserUuid the status by user uuid of this farmer sales proposal
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this farmer sales proposal.
	 *
	 * @param statusDate the status date of this farmer sales proposal
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the succeeding prod data season1 of this farmer sales proposal.
	 *
	 * @param succeedingProdDataSeason1 the succeeding prod data season1 of this farmer sales proposal
	 */
	@Override
	public void setSucceedingProdDataSeason1(
		Map<String, Serializable> succeedingProdDataSeason1) {

		model.setSucceedingProdDataSeason1(succeedingProdDataSeason1);
	}

	/**
	 * Sets the succeeding prod data season2 of this farmer sales proposal.
	 *
	 * @param succeedingProdDataSeason2 the succeeding prod data season2 of this farmer sales proposal
	 */
	@Override
	public void setSucceedingProdDataSeason2(
		Map<String, Serializable> succeedingProdDataSeason2) {

		model.setSucceedingProdDataSeason2(succeedingProdDataSeason2);
	}

	/**
	 * Sets the succeeding prod data season3 of this farmer sales proposal.
	 *
	 * @param succeedingProdDataSeason3 the succeeding prod data season3 of this farmer sales proposal
	 */
	@Override
	public void setSucceedingProdDataSeason3(
		Map<String, Serializable> succeedingProdDataSeason3) {

		model.setSucceedingProdDataSeason3(succeedingProdDataSeason3);
	}

	/**
	 * Sets the uuid of this farmer sales proposal.
	 *
	 * @param uuid the uuid of this farmer sales proposal
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the version of this farmer sales proposal.
	 *
	 * @param version the version of this farmer sales proposal
	 */
	@Override
	public void setVersion(double version) {
		model.setVersion(version);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected FarmerSalesProposalWrapper wrap(
		FarmerSalesProposal farmerSalesProposal) {

		return new FarmerSalesProposalWrapper(farmerSalesProposal);
	}

}