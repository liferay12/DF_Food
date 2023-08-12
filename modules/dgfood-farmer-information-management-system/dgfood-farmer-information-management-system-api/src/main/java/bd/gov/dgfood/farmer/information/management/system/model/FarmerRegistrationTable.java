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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;DGFood_FarmerRegistration&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see FarmerRegistration
 * @generated
 */
public class FarmerRegistrationTable
	extends BaseTable<FarmerRegistrationTable> {

	public static final FarmerRegistrationTable INSTANCE =
		new FarmerRegistrationTable();

	public final Column<FarmerRegistrationTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationTable, Long> farmerRegistrationId =
		createColumn(
			"farmerRegistrationId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<FarmerRegistrationTable, String> applicationNumber =
		createColumn(
			"applicationNumber", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationTable, String> nationalId =
		createColumn(
			"nationalId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationTable, String> emailAddress =
		createColumn(
			"emailAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationTable, String> mobileNumber =
		createColumn(
			"mobileNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationTable, Date> dateOfBirth =
		createColumn(
			"dateOfBirth", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationTable, String> farmerName =
		createColumn(
			"farmerName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationTable, String> fatherName =
		createColumn(
			"fatherName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationTable, String> motherName =
		createColumn(
			"motherName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationTable, Integer> gender = createColumn(
		"gender", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationTable, Integer> maritalStatus =
		createColumn(
			"maritalStatus", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationTable, String> krishokCardNumber =
		createColumn(
			"krishokCardNumber", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationTable, Clob> cultivableLandSeason1 =
		createColumn(
			"cultivableLandSeason1", Clob.class, Types.CLOB,
			Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationTable, Clob> cultivableLandSeason2 =
		createColumn(
			"cultivableLandSeason2", Clob.class, Types.CLOB,
			Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationTable, Clob> cultivableLandSeason3 =
		createColumn(
			"cultivableLandSeason3", Clob.class, Types.CLOB,
			Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationTable, String> farmerCategory =
		createColumn(
			"farmerCategory ", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationTable, String> password =
		createColumn(
			"password ", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationTable, String> remarks = createColumn(
		"remarks", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationTable, String> businessCode =
		createColumn(
			"businessCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationTable, Double> version = createColumn(
		"version", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationTable, Long> statusByUserId =
		createColumn(
			"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationTable, Date> statusDate =
		createColumn(
			"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private FarmerRegistrationTable() {
		super("DGFood_FarmerRegistration", FarmerRegistrationTable::new);
	}

}