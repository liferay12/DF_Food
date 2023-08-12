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

package bd.gov.dgfood.license.management.system.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;fgl_master_info&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see FGLicenseInfo
 * @generated
 */
public class FGLicenseInfoTable extends BaseTable<FGLicenseInfoTable> {

	public static final FGLicenseInfoTable INSTANCE = new FGLicenseInfoTable();

	public final Column<FGLicenseInfoTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FGLicenseInfoTable, Long> fgLicenseInfoId =
		createColumn(
			"fgLicenseInfoId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FGLicenseInfoTable, Long> fgLicenseMasterId =
		createColumn(
			"fgLicenseMasterId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FGLicenseInfoTable, Long> fgLicenseMDMId = createColumn(
		"fgLicenseMDMId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FGLicenseInfoTable, String> nationalId = createColumn(
		"nationalId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FGLicenseInfoTable, String> applicationNumber =
		createColumn(
			"applicationNumber", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FGLicenseInfoTable, String> applicantName =
		createColumn(
			"applicantName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FGLicenseInfoTable, String> tradeLicenseNumber =
		createColumn(
			"tradeLicenseNumber", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FGLicenseInfoTable, String> foodgrainLicenseNumber =
		createColumn(
			"foodgrainLicenseNumber", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FGLicenseInfoTable, Date> foodgrainLicenseIssueDate =
		createColumn(
			"foodgrainLicenseIssueDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<FGLicenseInfoTable, Date> foodgrainLicenseExpiryDate =
		createColumn(
			"foodgrainLicenseExpiryDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<FGLicenseInfoTable, String> businessName = createColumn(
		"businessName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FGLicenseInfoTable, String> businessType = createColumn(
		"businessType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FGLicenseInfoTable, Long> businessAddressId =
		createColumn(
			"businessAddressId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FGLicenseInfoTable, Double> version = createColumn(
		"version", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<FGLicenseInfoTable, String> applicationType =
		createColumn(
			"applicationType", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FGLicenseInfoTable, Boolean> syncStatus = createColumn(
		"syncStatus", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<FGLicenseInfoTable, Boolean> isExpired = createColumn(
		"isExpired", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<FGLicenseInfoTable, Long> paymentChallanId =
		createColumn(
			"paymentChallanId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FGLicenseInfoTable, String> division = createColumn(
		"division", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FGLicenseInfoTable, String> district = createColumn(
		"district", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FGLicenseInfoTable, String> upazila = createColumn(
		"upazila", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FGLicenseInfoTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<FGLicenseInfoTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FGLicenseInfoTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FGLicenseInfoTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FGLicenseInfoTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FGLicenseInfoTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FGLicenseInfoTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FGLicenseInfoTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FGLicenseInfoTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private FGLicenseInfoTable() {
		super("fgl_master_info", FGLicenseInfoTable::new);
	}

}