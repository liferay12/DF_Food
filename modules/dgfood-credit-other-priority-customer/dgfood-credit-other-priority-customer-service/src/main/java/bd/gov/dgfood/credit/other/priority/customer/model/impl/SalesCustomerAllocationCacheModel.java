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

package bd.gov.dgfood.credit.other.priority.customer.model.impl;

import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerAllocation;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SalesCustomerAllocation in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SalesCustomerAllocationCacheModel
	implements CacheModel<SalesCustomerAllocation>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SalesCustomerAllocationCacheModel)) {
			return false;
		}

		SalesCustomerAllocationCacheModel salesCustomerAllocationCacheModel =
			(SalesCustomerAllocationCacheModel)object;

		if (salesCustomerAllocationId ==
				salesCustomerAllocationCacheModel.salesCustomerAllocationId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, salesCustomerAllocationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", salesCustomerAllocationId=");
		sb.append(salesCustomerAllocationId);
		sb.append(", salesCustomerCode=");
		sb.append(salesCustomerCode);
		sb.append(", salesCustomerName=");
		sb.append(salesCustomerName);
		sb.append(", allocationNumber=");
		sb.append(allocationNumber);
		sb.append(", salesOrganization=");
		sb.append(salesOrganization);
		sb.append(", distributionChannel=");
		sb.append(distributionChannel);
		sb.append(", year=");
		sb.append(year);
		sb.append(", district=");
		sb.append(district);
		sb.append(", subDistrict=");
		sb.append(subDistrict);
		sb.append(", govOrderNumber=");
		sb.append(govOrderNumber);
		sb.append(", commodity=");
		sb.append(commodity);
		sb.append(", yearlyQty=");
		sb.append(yearlyQty);
		sb.append(", yearlyQtyUnit=");
		sb.append(yearlyQtyUnit);
		sb.append(", monthlyQty=");
		sb.append(monthlyQty);
		sb.append(", monthlyQtyUnit=");
		sb.append(monthlyQtyUnit);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SalesCustomerAllocation toEntityModel() {
		SalesCustomerAllocationImpl salesCustomerAllocationImpl =
			new SalesCustomerAllocationImpl();

		if (uuid == null) {
			salesCustomerAllocationImpl.setUuid("");
		}
		else {
			salesCustomerAllocationImpl.setUuid(uuid);
		}

		salesCustomerAllocationImpl.setSalesCustomerAllocationId(
			salesCustomerAllocationId);
		salesCustomerAllocationImpl.setSalesCustomerCode(salesCustomerCode);

		if (salesCustomerName == null) {
			salesCustomerAllocationImpl.setSalesCustomerName("");
		}
		else {
			salesCustomerAllocationImpl.setSalesCustomerName(salesCustomerName);
		}

		salesCustomerAllocationImpl.setAllocationNumber(allocationNumber);

		if (salesOrganization == null) {
			salesCustomerAllocationImpl.setSalesOrganization("");
		}
		else {
			salesCustomerAllocationImpl.setSalesOrganization(salesOrganization);
		}

		if (distributionChannel == null) {
			salesCustomerAllocationImpl.setDistributionChannel("");
		}
		else {
			salesCustomerAllocationImpl.setDistributionChannel(
				distributionChannel);
		}

		salesCustomerAllocationImpl.setYear(year);

		if (district == null) {
			salesCustomerAllocationImpl.setDistrict("");
		}
		else {
			salesCustomerAllocationImpl.setDistrict(district);
		}

		if (subDistrict == null) {
			salesCustomerAllocationImpl.setSubDistrict("");
		}
		else {
			salesCustomerAllocationImpl.setSubDistrict(subDistrict);
		}

		if (govOrderNumber == null) {
			salesCustomerAllocationImpl.setGovOrderNumber("");
		}
		else {
			salesCustomerAllocationImpl.setGovOrderNumber(govOrderNumber);
		}

		if (commodity == null) {
			salesCustomerAllocationImpl.setCommodity("");
		}
		else {
			salesCustomerAllocationImpl.setCommodity(commodity);
		}

		salesCustomerAllocationImpl.setYearlyQty(yearlyQty);

		if (yearlyQtyUnit == null) {
			salesCustomerAllocationImpl.setYearlyQtyUnit("");
		}
		else {
			salesCustomerAllocationImpl.setYearlyQtyUnit(yearlyQtyUnit);
		}

		salesCustomerAllocationImpl.setMonthlyQty(monthlyQty);

		if (monthlyQtyUnit == null) {
			salesCustomerAllocationImpl.setMonthlyQtyUnit("");
		}
		else {
			salesCustomerAllocationImpl.setMonthlyQtyUnit(monthlyQtyUnit);
		}

		salesCustomerAllocationImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			salesCustomerAllocationImpl.setCreateDate(null);
		}
		else {
			salesCustomerAllocationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			salesCustomerAllocationImpl.setModifiedDate(null);
		}
		else {
			salesCustomerAllocationImpl.setModifiedDate(new Date(modifiedDate));
		}

		salesCustomerAllocationImpl.resetOriginalValues();

		return salesCustomerAllocationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		salesCustomerAllocationId = objectInput.readLong();

		salesCustomerCode = objectInput.readLong();
		salesCustomerName = objectInput.readUTF();

		allocationNumber = objectInput.readLong();
		salesOrganization = objectInput.readUTF();
		distributionChannel = objectInput.readUTF();

		year = objectInput.readInt();
		district = objectInput.readUTF();
		subDistrict = objectInput.readUTF();
		govOrderNumber = objectInput.readUTF();
		commodity = objectInput.readUTF();

		yearlyQty = objectInput.readDouble();
		yearlyQtyUnit = objectInput.readUTF();

		monthlyQty = objectInput.readDouble();
		monthlyQtyUnit = objectInput.readUTF();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(salesCustomerAllocationId);

		objectOutput.writeLong(salesCustomerCode);

		if (salesCustomerName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(salesCustomerName);
		}

		objectOutput.writeLong(allocationNumber);

		if (salesOrganization == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(salesOrganization);
		}

		if (distributionChannel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(distributionChannel);
		}

		objectOutput.writeInt(year);

		if (district == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(district);
		}

		if (subDistrict == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(subDistrict);
		}

		if (govOrderNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(govOrderNumber);
		}

		if (commodity == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(commodity);
		}

		objectOutput.writeDouble(yearlyQty);

		if (yearlyQtyUnit == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(yearlyQtyUnit);
		}

		objectOutput.writeDouble(monthlyQty);

		if (monthlyQtyUnit == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(monthlyQtyUnit);
		}

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long salesCustomerAllocationId;
	public long salesCustomerCode;
	public String salesCustomerName;
	public long allocationNumber;
	public String salesOrganization;
	public String distributionChannel;
	public int year;
	public String district;
	public String subDistrict;
	public String govOrderNumber;
	public String commodity;
	public double yearlyQty;
	public String yearlyQtyUnit;
	public double monthlyQty;
	public String monthlyQtyUnit;
	public long companyId;
	public long createDate;
	public long modifiedDate;

}