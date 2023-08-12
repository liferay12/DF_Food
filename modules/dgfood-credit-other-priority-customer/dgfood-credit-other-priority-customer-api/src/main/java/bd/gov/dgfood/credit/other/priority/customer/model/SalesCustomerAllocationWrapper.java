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

package bd.gov.dgfood.credit.other.priority.customer.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SalesCustomerAllocation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SalesCustomerAllocation
 * @generated
 */
public class SalesCustomerAllocationWrapper
	extends BaseModelWrapper<SalesCustomerAllocation>
	implements ModelWrapper<SalesCustomerAllocation>, SalesCustomerAllocation {

	public SalesCustomerAllocationWrapper(
		SalesCustomerAllocation salesCustomerAllocation) {

		super(salesCustomerAllocation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put(
			"salesCustomerAllocationId", getSalesCustomerAllocationId());
		attributes.put("salesCustomerCode", getSalesCustomerCode());
		attributes.put("salesCustomerName", getSalesCustomerName());
		attributes.put("allocationNumber", getAllocationNumber());
		attributes.put("salesOrganization", getSalesOrganization());
		attributes.put("distributionChannel", getDistributionChannel());
		attributes.put("year", getYear());
		attributes.put("district", getDistrict());
		attributes.put("subDistrict", getSubDistrict());
		attributes.put("govOrderNumber", getGovOrderNumber());
		attributes.put("commodity", getCommodity());
		attributes.put("yearlyQty", getYearlyQty());
		attributes.put("yearlyQtyUnit", getYearlyQtyUnit());
		attributes.put("monthlyQty", getMonthlyQty());
		attributes.put("monthlyQtyUnit", getMonthlyQtyUnit());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long salesCustomerAllocationId = (Long)attributes.get(
			"salesCustomerAllocationId");

		if (salesCustomerAllocationId != null) {
			setSalesCustomerAllocationId(salesCustomerAllocationId);
		}

		Long salesCustomerCode = (Long)attributes.get("salesCustomerCode");

		if (salesCustomerCode != null) {
			setSalesCustomerCode(salesCustomerCode);
		}

		String salesCustomerName = (String)attributes.get("salesCustomerName");

		if (salesCustomerName != null) {
			setSalesCustomerName(salesCustomerName);
		}

		Long allocationNumber = (Long)attributes.get("allocationNumber");

		if (allocationNumber != null) {
			setAllocationNumber(allocationNumber);
		}

		String salesOrganization = (String)attributes.get("salesOrganization");

		if (salesOrganization != null) {
			setSalesOrganization(salesOrganization);
		}

		String distributionChannel = (String)attributes.get(
			"distributionChannel");

		if (distributionChannel != null) {
			setDistributionChannel(distributionChannel);
		}

		Integer year = (Integer)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		String district = (String)attributes.get("district");

		if (district != null) {
			setDistrict(district);
		}

		String subDistrict = (String)attributes.get("subDistrict");

		if (subDistrict != null) {
			setSubDistrict(subDistrict);
		}

		String govOrderNumber = (String)attributes.get("govOrderNumber");

		if (govOrderNumber != null) {
			setGovOrderNumber(govOrderNumber);
		}

		String commodity = (String)attributes.get("commodity");

		if (commodity != null) {
			setCommodity(commodity);
		}

		Double yearlyQty = (Double)attributes.get("yearlyQty");

		if (yearlyQty != null) {
			setYearlyQty(yearlyQty);
		}

		String yearlyQtyUnit = (String)attributes.get("yearlyQtyUnit");

		if (yearlyQtyUnit != null) {
			setYearlyQtyUnit(yearlyQtyUnit);
		}

		Double monthlyQty = (Double)attributes.get("monthlyQty");

		if (monthlyQty != null) {
			setMonthlyQty(monthlyQty);
		}

		String monthlyQtyUnit = (String)attributes.get("monthlyQtyUnit");

		if (monthlyQtyUnit != null) {
			setMonthlyQtyUnit(monthlyQtyUnit);
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
	}

	@Override
	public SalesCustomerAllocation cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the allocation number of this sales customer allocation.
	 *
	 * @return the allocation number of this sales customer allocation
	 */
	@Override
	public long getAllocationNumber() {
		return model.getAllocationNumber();
	}

	/**
	 * Returns the commodity of this sales customer allocation.
	 *
	 * @return the commodity of this sales customer allocation
	 */
	@Override
	public String getCommodity() {
		return model.getCommodity();
	}

	/**
	 * Returns the company ID of this sales customer allocation.
	 *
	 * @return the company ID of this sales customer allocation
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this sales customer allocation.
	 *
	 * @return the create date of this sales customer allocation
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the distribution channel of this sales customer allocation.
	 *
	 * @return the distribution channel of this sales customer allocation
	 */
	@Override
	public String getDistributionChannel() {
		return model.getDistributionChannel();
	}

	/**
	 * Returns the district of this sales customer allocation.
	 *
	 * @return the district of this sales customer allocation
	 */
	@Override
	public String getDistrict() {
		return model.getDistrict();
	}

	/**
	 * Returns the gov order number of this sales customer allocation.
	 *
	 * @return the gov order number of this sales customer allocation
	 */
	@Override
	public String getGovOrderNumber() {
		return model.getGovOrderNumber();
	}

	/**
	 * Returns the modified date of this sales customer allocation.
	 *
	 * @return the modified date of this sales customer allocation
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the monthly qty of this sales customer allocation.
	 *
	 * @return the monthly qty of this sales customer allocation
	 */
	@Override
	public double getMonthlyQty() {
		return model.getMonthlyQty();
	}

	/**
	 * Returns the monthly qty unit of this sales customer allocation.
	 *
	 * @return the monthly qty unit of this sales customer allocation
	 */
	@Override
	public String getMonthlyQtyUnit() {
		return model.getMonthlyQtyUnit();
	}

	/**
	 * Returns the primary key of this sales customer allocation.
	 *
	 * @return the primary key of this sales customer allocation
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sales customer allocation ID of this sales customer allocation.
	 *
	 * @return the sales customer allocation ID of this sales customer allocation
	 */
	@Override
	public long getSalesCustomerAllocationId() {
		return model.getSalesCustomerAllocationId();
	}

	/**
	 * Returns the sales customer code of this sales customer allocation.
	 *
	 * @return the sales customer code of this sales customer allocation
	 */
	@Override
	public long getSalesCustomerCode() {
		return model.getSalesCustomerCode();
	}

	/**
	 * Returns the sales customer name of this sales customer allocation.
	 *
	 * @return the sales customer name of this sales customer allocation
	 */
	@Override
	public String getSalesCustomerName() {
		return model.getSalesCustomerName();
	}

	/**
	 * Returns the sales organization of this sales customer allocation.
	 *
	 * @return the sales organization of this sales customer allocation
	 */
	@Override
	public String getSalesOrganization() {
		return model.getSalesOrganization();
	}

	/**
	 * Returns the sub district of this sales customer allocation.
	 *
	 * @return the sub district of this sales customer allocation
	 */
	@Override
	public String getSubDistrict() {
		return model.getSubDistrict();
	}

	/**
	 * Returns the uuid of this sales customer allocation.
	 *
	 * @return the uuid of this sales customer allocation
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the year of this sales customer allocation.
	 *
	 * @return the year of this sales customer allocation
	 */
	@Override
	public int getYear() {
		return model.getYear();
	}

	/**
	 * Returns the yearly qty of this sales customer allocation.
	 *
	 * @return the yearly qty of this sales customer allocation
	 */
	@Override
	public double getYearlyQty() {
		return model.getYearlyQty();
	}

	/**
	 * Returns the yearly qty unit of this sales customer allocation.
	 *
	 * @return the yearly qty unit of this sales customer allocation
	 */
	@Override
	public String getYearlyQtyUnit() {
		return model.getYearlyQtyUnit();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the allocation number of this sales customer allocation.
	 *
	 * @param allocationNumber the allocation number of this sales customer allocation
	 */
	@Override
	public void setAllocationNumber(long allocationNumber) {
		model.setAllocationNumber(allocationNumber);
	}

	/**
	 * Sets the commodity of this sales customer allocation.
	 *
	 * @param commodity the commodity of this sales customer allocation
	 */
	@Override
	public void setCommodity(String commodity) {
		model.setCommodity(commodity);
	}

	/**
	 * Sets the company ID of this sales customer allocation.
	 *
	 * @param companyId the company ID of this sales customer allocation
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this sales customer allocation.
	 *
	 * @param createDate the create date of this sales customer allocation
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the distribution channel of this sales customer allocation.
	 *
	 * @param distributionChannel the distribution channel of this sales customer allocation
	 */
	@Override
	public void setDistributionChannel(String distributionChannel) {
		model.setDistributionChannel(distributionChannel);
	}

	/**
	 * Sets the district of this sales customer allocation.
	 *
	 * @param district the district of this sales customer allocation
	 */
	@Override
	public void setDistrict(String district) {
		model.setDistrict(district);
	}

	/**
	 * Sets the gov order number of this sales customer allocation.
	 *
	 * @param govOrderNumber the gov order number of this sales customer allocation
	 */
	@Override
	public void setGovOrderNumber(String govOrderNumber) {
		model.setGovOrderNumber(govOrderNumber);
	}

	/**
	 * Sets the modified date of this sales customer allocation.
	 *
	 * @param modifiedDate the modified date of this sales customer allocation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the monthly qty of this sales customer allocation.
	 *
	 * @param monthlyQty the monthly qty of this sales customer allocation
	 */
	@Override
	public void setMonthlyQty(double monthlyQty) {
		model.setMonthlyQty(monthlyQty);
	}

	/**
	 * Sets the monthly qty unit of this sales customer allocation.
	 *
	 * @param monthlyQtyUnit the monthly qty unit of this sales customer allocation
	 */
	@Override
	public void setMonthlyQtyUnit(String monthlyQtyUnit) {
		model.setMonthlyQtyUnit(monthlyQtyUnit);
	}

	/**
	 * Sets the primary key of this sales customer allocation.
	 *
	 * @param primaryKey the primary key of this sales customer allocation
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sales customer allocation ID of this sales customer allocation.
	 *
	 * @param salesCustomerAllocationId the sales customer allocation ID of this sales customer allocation
	 */
	@Override
	public void setSalesCustomerAllocationId(long salesCustomerAllocationId) {
		model.setSalesCustomerAllocationId(salesCustomerAllocationId);
	}

	/**
	 * Sets the sales customer code of this sales customer allocation.
	 *
	 * @param salesCustomerCode the sales customer code of this sales customer allocation
	 */
	@Override
	public void setSalesCustomerCode(long salesCustomerCode) {
		model.setSalesCustomerCode(salesCustomerCode);
	}

	/**
	 * Sets the sales customer name of this sales customer allocation.
	 *
	 * @param salesCustomerName the sales customer name of this sales customer allocation
	 */
	@Override
	public void setSalesCustomerName(String salesCustomerName) {
		model.setSalesCustomerName(salesCustomerName);
	}

	/**
	 * Sets the sales organization of this sales customer allocation.
	 *
	 * @param salesOrganization the sales organization of this sales customer allocation
	 */
	@Override
	public void setSalesOrganization(String salesOrganization) {
		model.setSalesOrganization(salesOrganization);
	}

	/**
	 * Sets the sub district of this sales customer allocation.
	 *
	 * @param subDistrict the sub district of this sales customer allocation
	 */
	@Override
	public void setSubDistrict(String subDistrict) {
		model.setSubDistrict(subDistrict);
	}

	/**
	 * Sets the uuid of this sales customer allocation.
	 *
	 * @param uuid the uuid of this sales customer allocation
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the year of this sales customer allocation.
	 *
	 * @param year the year of this sales customer allocation
	 */
	@Override
	public void setYear(int year) {
		model.setYear(year);
	}

	/**
	 * Sets the yearly qty of this sales customer allocation.
	 *
	 * @param yearlyQty the yearly qty of this sales customer allocation
	 */
	@Override
	public void setYearlyQty(double yearlyQty) {
		model.setYearlyQty(yearlyQty);
	}

	/**
	 * Sets the yearly qty unit of this sales customer allocation.
	 *
	 * @param yearlyQtyUnit the yearly qty unit of this sales customer allocation
	 */
	@Override
	public void setYearlyQtyUnit(String yearlyQtyUnit) {
		model.setYearlyQtyUnit(yearlyQtyUnit);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected SalesCustomerAllocationWrapper wrap(
		SalesCustomerAllocation salesCustomerAllocation) {

		return new SalesCustomerAllocationWrapper(salesCustomerAllocation);
	}

}