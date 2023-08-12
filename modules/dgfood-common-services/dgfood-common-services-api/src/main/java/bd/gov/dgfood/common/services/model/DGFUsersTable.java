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
 * The table class for the &quot;DGF_Users&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DGFUsers
 * @generated
 */
public class DGFUsersTable extends BaseTable<DGFUsersTable> {

	public static final DGFUsersTable INSTANCE = new DGFUsersTable();

	public final Column<DGFUsersTable, Long> dgfUserId = createColumn(
		"dgfUserId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DGFUsersTable, String> nationalId = createColumn(
		"nationalId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGFUsersTable, String> password = createColumn(
		"password_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGFUsersTable, String> mobileNumber = createColumn(
		"mobileNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGFUsersTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGFUsersTable, Date> birthDate = createColumn(
		"birthDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DGFUsersTable, String> maritalStatus = createColumn(
		"maritalStatus", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGFUsersTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFUsersTable, Long> presentAddressId = createColumn(
		"presentAddressId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFUsersTable, String> profileType = createColumn(
		"profileType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private DGFUsersTable() {
		super("DGF_Users", DGFUsersTable::new);
	}

}