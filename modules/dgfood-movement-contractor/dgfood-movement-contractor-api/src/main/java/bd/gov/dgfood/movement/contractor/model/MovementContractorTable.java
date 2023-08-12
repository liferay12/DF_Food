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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;DGFOOD_MovementContractor&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see MovementContractor
 * @generated
 */
public class MovementContractorTable
	extends BaseTable<MovementContractorTable> {

	public static final MovementContractorTable INSTANCE =
		new MovementContractorTable();

	public final Column<MovementContractorTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MovementContractorTable, Long> movementContractorId =
		createColumn(
			"movementContractorId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<MovementContractorTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MovementContractorTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MovementContractorTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MovementContractorTable, String> mobileNumber =
		createColumn(
			"mobileNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MovementContractorTable, Long> nationalId =
		createColumn(
			"nationalId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MovementContractorTable, String> emailAddress =
		createColumn(
			"emailAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MovementContractorTable, Date> dateOfBirth =
		createColumn(
			"dateOfBirth", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<MovementContractorTable, Integer> gender = createColumn(
		"gender", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<MovementContractorTable, String> fatherName =
		createColumn(
			"fatherName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MovementContractorTable, String> motherName =
		createColumn(
			"motherName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MovementContractorTable, Integer> maritalStatus =
		createColumn(
			"maritalStatus", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<MovementContractorTable, String> type = createColumn(
		"type_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MovementContractorTable, String> organizationName =
		createColumn(
			"organizationName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<MovementContractorTable, String> tradeLicenseNumber =
		createColumn(
			"tradeLicenseNumber", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<MovementContractorTable, Date> tradeLicenseExpiryDate =
		createColumn(
			"tradeLicenseExpiryDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<MovementContractorTable, String> vehicle = createColumn(
		"vehicle", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MovementContractorTable, Integer> vehicleCount =
		createColumn(
			"vehicleCount", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<MovementContractorTable, Clob> vehicleCapacity =
		createColumn(
			"vehicleCapacity", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<MovementContractorTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MovementContractorTable, String> password =
		createColumn(
			"password_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MovementContractorTable, Long> applicationNumber =
		createColumn(
			"applicationNumber", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MovementContractorTable, Long> businessCode =
		createColumn(
			"businessCode", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MovementContractorTable, Double> version = createColumn(
		"version", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<MovementContractorTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<MovementContractorTable, Long> statusByUserId =
		createColumn(
			"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MovementContractorTable, Date> statusDate =
		createColumn(
			"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<MovementContractorTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MovementContractorTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<MovementContractorTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MovementContractorTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private MovementContractorTable() {
		super("DGFOOD_MovementContractor", MovementContractorTable::new);
	}

}