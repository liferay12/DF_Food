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
 * The table class for the &quot;fgl_master_details&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see FGLicenseDetails
 * @generated
 */
public class FGLicenseDetailsTable extends BaseTable<FGLicenseDetailsTable> {

	public static final FGLicenseDetailsTable INSTANCE =
		new FGLicenseDetailsTable();

	public final Column<FGLicenseDetailsTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FGLicenseDetailsTable, Long> fgLicenseMasterId =
		createColumn(
			"fgLicenseMasterId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FGLicenseDetailsTable, String> nationalId =
		createColumn(
			"nationalId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FGLicenseDetailsTable, String> applicationNumber =
		createColumn(
			"applicationNumber", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FGLicenseDetailsTable, String> applicantName =
		createColumn(
			"applicantName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FGLicenseDetailsTable, String> tradeLicenseNumber =
		createColumn(
			"tradeLicenseNumber", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FGLicenseDetailsTable, Date> tradeLicenseExpiryDate =
		createColumn(
			"tradeLicenseExpiryDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<FGLicenseDetailsTable, String> tradeLicenseIssuerCode =
		createColumn(
			"tradeLicenseIssuerCode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FGLicenseDetailsTable, String> tradeLicenseIssuerCity =
		createColumn(
			"tradeLicenseIssuerCity", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FGLicenseDetailsTable, String>
		businessIdentificationNumber = createColumn(
			"businessIdentificationNumber", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FGLicenseDetailsTable, String> taxIdentificationNumber =
		createColumn(
			"taxIdentificationNumber", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FGLicenseDetailsTable, Long> paymentChallanId =
		createColumn(
			"paymentChallanId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FGLicenseDetailsTable, Long> tradeLicenseDocId =
		createColumn(
			"tradeLicenseDocId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FGLicenseDetailsTable, Long>
		businessIdentificationDocId = createColumn(
			"businessIdentificationDocId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<FGLicenseDetailsTable, Long> taxIdentfctDocId =
		createColumn(
			"taxIdentfctDocId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FGLicenseDetailsTable, Long> bankStatementDocId =
		createColumn(
			"bankStatementDocId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<FGLicenseDetailsTable, String> reviewComments =
		createColumn(
			"reviewComments", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FGLicenseDetailsTable, String> comments = createColumn(
		"comments", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FGLicenseDetailsTable, String>
		duplicateLicenseReasonId = createColumn(
			"duplicateLicenseReasonId", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FGLicenseDetailsTable, String> applicationType =
		createColumn(
			"applicationType", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private FGLicenseDetailsTable() {
		super("fgl_master_details", FGLicenseDetailsTable::new);
	}

}