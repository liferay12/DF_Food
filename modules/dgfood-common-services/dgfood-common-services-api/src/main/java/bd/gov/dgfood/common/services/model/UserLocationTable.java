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
 * The table class for the &quot;DGF_UserLocation&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see UserLocation
 * @generated
 */
public class UserLocationTable extends BaseTable<UserLocationTable> {

	public static final UserLocationTable INSTANCE = new UserLocationTable();

	public final Column<UserLocationTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserLocationTable, Long> userLocationId = createColumn(
		"userLocationId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<UserLocationTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UserLocationTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UserLocationTable, String> locationName = createColumn(
		"locationName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserLocationTable, String> locationCode = createColumn(
		"locationCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserLocationTable, Long> locationId = createColumn(
		"locationId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UserLocationTable, String> locationType = createColumn(
		"locationType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserLocationTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserLocationTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UserLocationTable, String> roleKey = createColumn(
		"roleKey", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserLocationTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<UserLocationTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<UserLocationTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UserLocationTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private UserLocationTable() {
		super("DGF_UserLocation", UserLocationTable::new);
	}

}