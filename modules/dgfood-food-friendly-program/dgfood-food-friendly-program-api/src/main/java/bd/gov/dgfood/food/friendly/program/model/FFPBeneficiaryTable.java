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
 * The table class for the &quot;FFPB_Registration&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see FFPBeneficiary
 * @generated
 */
public class FFPBeneficiaryTable extends BaseTable<FFPBeneficiaryTable> {

	public static final FFPBeneficiaryTable INSTANCE =
		new FFPBeneficiaryTable();

	public final Column<FFPBeneficiaryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryTable, Long> beneficiaryId = createColumn(
		"beneficiaryId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FFPBeneficiaryTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryTable, Double> version = createColumn(
		"version", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryTable, String> mobileNumber =
		createColumn(
			"mobileNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryTable, Long> nationalId = createColumn(
		"nationalId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryTable, String> emailAddress =
		createColumn(
			"emailAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryTable, String> cardNumber = createColumn(
		"cardNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryTable, Date> dateOfBirth = createColumn(
		"dateOfBirth", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryTable, Integer> gender = createColumn(
		"gender", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryTable, String> fatherName = createColumn(
		"fatherName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryTable, String> motherName = createColumn(
		"motherName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryTable, Integer> maritalStatus =
		createColumn(
			"maritalStatus", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryTable, String> spouseName = createColumn(
		"spouseName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryTable, String> spouseFatherName =
		createColumn(
			"spouseFatherName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryTable, Date> spouseDateOfBirth =
		createColumn(
			"spouseDateOfBirth", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryTable, Long> spouseNationalId =
		createColumn(
			"spouseNationalId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryTable, String>
		familyAverageMonthlyIncome = createColumn(
			"familyAverageMonthlyIncome", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryTable, Integer> familyEarningMembers =
		createColumn(
			"familyEarningMembers", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryTable, Boolean> acknowledge =
		createColumn(
			"acknowledge", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryTable, Boolean>
		nonOfMyFamilyMembersRegistered = createColumn(
			"nonOfMyFamilyMembersRegistered", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryTable, Long> statusByUserId =
		createColumn(
			"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FFPBeneficiaryTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private FFPBeneficiaryTable() {
		super("FFPB_Registration", FFPBeneficiaryTable::new);
	}

}