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
 * The table class for the &quot;DGF_APIAudit&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see APIAudit
 * @generated
 */
public class APIAuditTable extends BaseTable<APIAuditTable> {

	public static final APIAuditTable INSTANCE = new APIAuditTable();

	public final Column<APIAuditTable, Long> apiAuditId = createColumn(
		"apiAuditId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<APIAuditTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<APIAuditTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<APIAuditTable, String> sender = createColumn(
		"sender", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<APIAuditTable, String> receiver = createColumn(
		"receiver", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<APIAuditTable, String> requestPayload = createColumn(
		"requestPayload", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<APIAuditTable, String> responsePayload = createColumn(
		"responsePayload", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<APIAuditTable, String> requestClassName = createColumn(
		"requestClassName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<APIAuditTable, Long> requestClassPK = createColumn(
		"requestClassPK", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<APIAuditTable, Boolean> bulkRequest = createColumn(
		"bulkRequest", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<APIAuditTable, Date> requestTime = createColumn(
		"requestTime", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<APIAuditTable, Date> responseTime = createColumn(
		"responseTime", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<APIAuditTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<APIAuditTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private APIAuditTable() {
		super("DGF_APIAudit", APIAuditTable::new);
	}

}