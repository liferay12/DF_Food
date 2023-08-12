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

/**
 * The table class for the &quot;fgl_mdm_data&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see FGLicenseMDMData
 * @generated
 */
public class FGLicenseMDMDataTable extends BaseTable<FGLicenseMDMDataTable> {

	public static final FGLicenseMDMDataTable INSTANCE =
		new FGLicenseMDMDataTable();

	public final Column<FGLicenseMDMDataTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FGLicenseMDMDataTable, Long> fgLicenseMDMId =
		createColumn(
			"fgLicenseMDMId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FGLicenseMDMDataTable, Long> fgLicenseInfoId =
		createColumn(
			"fgLicenseInfoId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FGLicenseMDMDataTable, Long> fgLicenseMasterId =
		createColumn(
			"fgLicenseMasterId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FGLicenseMDMDataTable, String> applicationMdmData =
		createColumn(
			"applicationMdmData", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private FGLicenseMDMDataTable() {
		super("fgl_mdm_data", FGLicenseMDMDataTable::new);
	}

}