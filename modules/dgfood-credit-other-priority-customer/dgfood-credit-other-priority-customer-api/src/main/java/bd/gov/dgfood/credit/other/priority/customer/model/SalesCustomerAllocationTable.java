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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;DGFOOD_SalesCustomerAllocation&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see SalesCustomerAllocation
 * @generated
 */
public class SalesCustomerAllocationTable
	extends BaseTable<SalesCustomerAllocationTable> {

	public static final SalesCustomerAllocationTable INSTANCE =
		new SalesCustomerAllocationTable();

	public final Column<SalesCustomerAllocationTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SalesCustomerAllocationTable, Long>
		salesCustomerAllocationId = createColumn(
			"salesCustomerAllocationId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<SalesCustomerAllocationTable, Long> salesCustomerCode =
		createColumn(
			"salesCustomerCode", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SalesCustomerAllocationTable, String>
		salesCustomerName = createColumn(
			"salesCustomerName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SalesCustomerAllocationTable, Long> allocationNumber =
		createColumn(
			"allocationNumber", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SalesCustomerAllocationTable, String>
		salesOrganization = createColumn(
			"salesOrganization", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SalesCustomerAllocationTable, String>
		distributionChannel = createColumn(
			"distributionChannel", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SalesCustomerAllocationTable, Integer> year =
		createColumn("year", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<SalesCustomerAllocationTable, String> district =
		createColumn(
			"district", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SalesCustomerAllocationTable, String> subDistrict =
		createColumn(
			"subDistrict", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SalesCustomerAllocationTable, String> govOrderNumber =
		createColumn(
			"govOrderNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SalesCustomerAllocationTable, String> commodity =
		createColumn(
			"commodity", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SalesCustomerAllocationTable, Double> yearlyQty =
		createColumn(
			"yearlyQty", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<SalesCustomerAllocationTable, String> yearlyQtyUnit =
		createColumn(
			"yearlyQtyUnit", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SalesCustomerAllocationTable, Double> monthlyQty =
		createColumn(
			"monthlyQty", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<SalesCustomerAllocationTable, String> monthlyQtyUnit =
		createColumn(
			"monthlyQtyUnit", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SalesCustomerAllocationTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SalesCustomerAllocationTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SalesCustomerAllocationTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private SalesCustomerAllocationTable() {
		super(
			"DGFOOD_SalesCustomerAllocation",
			SalesCustomerAllocationTable::new);
	}

}