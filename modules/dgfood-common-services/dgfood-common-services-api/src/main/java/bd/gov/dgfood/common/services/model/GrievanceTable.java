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
 * The table class for the &quot;DGF_Grievance&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Grievance
 * @generated
 */
public class GrievanceTable extends BaseTable<GrievanceTable> {

	public static final GrievanceTable INSTANCE = new GrievanceTable();

	public final Column<GrievanceTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<GrievanceTable, Long> grievanceId = createColumn(
		"grievanceId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<GrievanceTable, String> grievanceNumber = createColumn(
		"grievanceNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<GrievanceTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<GrievanceTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<GrievanceTable, Long> grievanceCategory = createColumn(
		"grievanceCategory", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<GrievanceTable, Long> userType = createColumn(
		"userType", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<GrievanceTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<GrievanceTable, Long> userID = createColumn(
		"userID", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<GrievanceTable, String> mobileNumber = createColumn(
		"mobileNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<GrievanceTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<GrievanceTable, String> complaintDetails = createColumn(
		"complaintDetails", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<GrievanceTable, Long> attachmentId = createColumn(
		"attachmentId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<GrievanceTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<GrievanceTable, String> responseDetails = createColumn(
		"responseDetails", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<GrievanceTable, Date> responseDate = createColumn(
		"responseDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<GrievanceTable, Long> responseBy = createColumn(
		"responseBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private GrievanceTable() {
		super("DGF_Grievance", GrievanceTable::new);
	}

}