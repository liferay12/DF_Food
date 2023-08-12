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

package bd.gov.dgfood.food.friendly.program.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;FFPB_RegistrationVersion&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see FFPBeneficiaryVersion
 * @generated
 */
public class FFPBeneficiaryVersionTable
	extends BaseTable<FFPBeneficiaryVersionTable> {

	public static final FFPBeneficiaryVersionTable INSTANCE =
		new FFPBeneficiaryVersionTable();

	public final Column<FFPBeneficiaryVersionTable, Long> beneficiaryVersionId =
		createColumn(
			"beneficiaryVersionId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<FFPBeneficiaryVersionTable, Long> beneficiaryId =
		createColumn(
			"beneficiaryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryVersionTable, Long> groupId =
		createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryVersionTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryVersionTable, Double> version =
		createColumn(
			"version", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryVersionTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryVersionTable, String> mobileNumber =
		createColumn(
			"mobileNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryVersionTable, Long> nationalId =
		createColumn(
			"nationalId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryVersionTable, String> emailAddress =
		createColumn(
			"emailAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryVersionTable, String> cardNumber =
		createColumn(
			"cardNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryVersionTable, Date> dateOfBirth =
		createColumn(
			"dateOfBirth", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryVersionTable, Integer> gender =
		createColumn(
			"gender", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryVersionTable, String> fatherName =
		createColumn(
			"fatherName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryVersionTable, String> motherName =
		createColumn(
			"motherName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryVersionTable, Integer> maritalStatus =
		createColumn(
			"maritalStatus", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryVersionTable, String> spouseName =
		createColumn(
			"spouseName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryVersionTable, String> spouseFatherName =
		createColumn(
			"spouseFatherName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryVersionTable, Date> spouseDateOfBirth =
		createColumn(
			"spouseDateOfBirth", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryVersionTable, Long> spouseNationalId =
		createColumn(
			"spouseNationalId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryVersionTable, String>
		familyAverageMonthlyIncome = createColumn(
			"familyAverageMonthlyIncome", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryVersionTable, Integer>
		familyEarningMembers = createColumn(
			"familyEarningMembers", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryVersionTable, Boolean> acknowledge =
		createColumn(
			"acknowledge", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryVersionTable, Boolean>
		nonOfMyFamilyMembersRegistered = createColumn(
			"nonOfMyFamilyMembersRegistered", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryVersionTable, Integer> status =
		createColumn(
			"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryVersionTable, Long> statusByUserId =
		createColumn(
			"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryVersionTable, Date> statusDate =
		createColumn(
			"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryVersionTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryVersionTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private FFPBeneficiaryVersionTable() {
		super("FFPB_RegistrationVersion", FFPBeneficiaryVersionTable::new);
	}

}