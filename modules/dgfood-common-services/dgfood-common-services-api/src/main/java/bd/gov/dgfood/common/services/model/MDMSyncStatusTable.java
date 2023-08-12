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

package bd.gov.dgfood.common.services.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;DGF_MDMSyncStatus&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see MDMSyncStatus
 * @generated
 */
public class MDMSyncStatusTable extends BaseTable<MDMSyncStatusTable> {

	public static final MDMSyncStatusTable INSTANCE = new MDMSyncStatusTable();

	public final Column<MDMSyncStatusTable, Long> mdmSyncStatusId =
		createColumn(
			"mdmSyncStatusId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<MDMSyncStatusTable, String> userType = createColumn(
		"userType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MDMSyncStatusTable, String> className = createColumn(
		"className", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MDMSyncStatusTable, Long> classPk = createColumn(
		"classPk", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MDMSyncStatusTable, String> requestPayload =
		createColumn(
			"requestPayload", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MDMSyncStatusTable, String> mdmEndPoint = createColumn(
		"mdmEndPoint", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MDMSyncStatusTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MDMSyncStatusTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private MDMSyncStatusTable() {
		super("DGF_MDMSyncStatus", MDMSyncStatusTable::new);
	}

}