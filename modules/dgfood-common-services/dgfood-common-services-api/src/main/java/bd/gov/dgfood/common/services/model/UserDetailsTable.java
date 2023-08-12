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

/**
 * The table class for the &quot;DGF_UserDetails&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see UserDetails
 * @generated
 */
public class UserDetailsTable extends BaseTable<UserDetailsTable> {

	public static final UserDetailsTable INSTANCE = new UserDetailsTable();

	public final Column<UserDetailsTable, Long> userDetailsId = createColumn(
		"userDetailsId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<UserDetailsTable, String> nationalId = createColumn(
		"nationalId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserDetailsTable, String> applicantName = createColumn(
		"applicantName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserDetailsTable, String> fatherName = createColumn(
		"fatherName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserDetailsTable, String> motherName = createColumn(
		"motherName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserDetailsTable, String> gender = createColumn(
		"gender", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserDetailsTable, Long> nidPhotoAttachmentId =
		createColumn(
			"nidPhotoAttachmentId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<UserDetailsTable, String> nidDivision = createColumn(
		"nidDivision", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserDetailsTable, String> nidDistrict = createColumn(
		"nidDistrict", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserDetailsTable, String> nidUpzilla = createColumn(
		"nidUpzilla", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserDetailsTable, String> nidUnion = createColumn(
		"nidUnion", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserDetailsTable, String> nidVillage = createColumn(
		"nidVillage", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserDetailsTable, String> nidWard = createColumn(
		"nidWard", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserDetailsTable, Long> nidZipCode = createColumn(
		"nidZipCode", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UserDetailsTable, String> houseAddress = createColumn(
		"houseAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private UserDetailsTable() {
		super("DGF_UserDetails", UserDetailsTable::new);
	}

}