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
 * The table class for the &quot;DGFood_FarmerRegistrationVer&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see FarmerRegistrationVersion
 * @generated
 */
public class FarmerRegistrationVersionTable
	extends BaseTable<FarmerRegistrationVersionTable> {

	public static final FarmerRegistrationVersionTable INSTANCE =
		new FarmerRegistrationVersionTable();

	public final Column<FarmerRegistrationVersionTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationVersionTable, Long>
		farmerRegistrationVersionId = createColumn(
			"farmerRegistrationVersionId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<FarmerRegistrationVersionTable, String>
		applicationNumber = createColumn(
			"applicationNumber", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationVersionTable, Long>
		farmerRegistrationId = createColumn(
			"farmerRegistrationId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationVersionTable, String> nationalId =
		createColumn(
			"nationalId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationVersionTable, String> emailAddress =
		createColumn(
			"emailAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationVersionTable, String> mobileNumber =
		createColumn(
			"mobileNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationVersionTable, Date> dateOfBirth =
		createColumn(
			"dateOfBirth", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationVersionTable, String> farmerName =
		createColumn(
			"farmerName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationVersionTable, String> fatherName =
		createColumn(
			"fatherName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationVersionTable, String> motherName =
		createColumn(
			"motherName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationVersionTable, Integer> gender =
		createColumn(
			"gender", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationVersionTable, Integer> maritalStatus =
		createColumn(
			"maritalStatus", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationVersionTable, String>
		krishokCardNumber = createColumn(
			"krishokCardNumber", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationVersionTable, Clob>
		cultivableLandSeason1 = createColumn(
			"cultivableLandSeason1", Clob.class, Types.CLOB,
			Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationVersionTable, Clob>
		cultivableLandSeason2 = createColumn(
			"cultivableLandSeason2", Clob.class, Types.CLOB,
			Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationVersionTable, Clob>
		cultivableLandSeason3 = createColumn(
			"cultivableLandSeason3", Clob.class, Types.CLOB,
			Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationVersionTable, String> farmerCategory =
		createColumn(
			"farmerCategory ", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationVersionTable, String> password =
		createColumn(
			"password ", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationVersionTable, String> remarks =
		createColumn(
			"remarks", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationVersionTable, String> businessCode =
		createColumn(
			"businessCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationVersionTable, Double> version =
		createColumn(
			"version", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationVersionTable, String> userId =
		createColumn(
			"userId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationVersionTable, Long> groupId =
		createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationVersionTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationVersionTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationVersionTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationVersionTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationVersionTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationVersionTable, Integer> status =
		createColumn(
			"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationVersionTable, Long> statusByUserId =
		createColumn(
			"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationVersionTable, String>
		statusByUserName = createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FarmerRegistrationVersionTable, Date> statusDate =
		createColumn(
			"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private FarmerRegistrationVersionTable() {
		super(
			"DGFood_FarmerRegistrationVer",
			FarmerRegistrationVersionTable::new);
	}

}