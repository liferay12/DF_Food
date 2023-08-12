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
 * The table class for the &quot;DGFOOD_SalesCustomer&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see SalesCustomer
 * @generated
 */
public class SalesCustomerTable extends BaseTable<SalesCustomerTable> {

	public static final SalesCustomerTable INSTANCE = new SalesCustomerTable();

	public final Column<SalesCustomerTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SalesCustomerTable, Long> salesCustomerId =
		createColumn(
			"salesCustomerId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SalesCustomerTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SalesCustomerTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SalesCustomerTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SalesCustomerTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SalesCustomerTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SalesCustomerTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SalesCustomerTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SalesCustomerTable, String> userType = createColumn(
		"userType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SalesCustomerTable, String> mobileNumber = createColumn(
		"mobileNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SalesCustomerTable, String> emailAddress = createColumn(
		"emailAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SalesCustomerTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SalesCustomerTable, String> contactPersonName =
		createColumn(
			"contactPersonName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SalesCustomerTable, String> contactPersonDesignation =
		createColumn(
			"contactPersonDesignation", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SalesCustomerTable, String> officeName = createColumn(
		"officeName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SalesCustomerTable, String> organizationName =
		createColumn(
			"organizationName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SalesCustomerTable, String> organizationType =
		createColumn(
			"organizationType", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SalesCustomerTable, Integer> gender = createColumn(
		"gender", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<SalesCustomerTable, Long> salesCustomerCode =
		createColumn(
			"salesCustomerCode", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SalesCustomerTable, Double> version = createColumn(
		"version", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<SalesCustomerTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<SalesCustomerTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SalesCustomerTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SalesCustomerTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private SalesCustomerTable() {
		super("DGFOOD_SalesCustomer", SalesCustomerTable::new);
	}

}