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
 * The table class for the &quot;DGF_AddressVersion&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AddressVersion
 * @generated
 */
public class AddressVersionTable extends BaseTable<AddressVersionTable> {

	public static final AddressVersionTable INSTANCE =
		new AddressVersionTable();

	public final Column<AddressVersionTable, Long> addressVersionId =
		createColumn(
			"addressVersionId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AddressVersionTable, Long> region = createColumn(
		"region", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AddressVersionTable, Long> district = createColumn(
		"district", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AddressVersionTable, Long> upazilla = createColumn(
		"upazilla", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AddressVersionTable, Long>
		cityCorporationOrMunicipality = createColumn(
			"cityCorporationOrMunicipality", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<AddressVersionTable, Long> unionOrWard = createColumn(
		"unionOrWard", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AddressVersionTable, Long> zipCode = createColumn(
		"zipCode", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AddressVersionTable, String> postOffice = createColumn(
		"postOffice", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AddressVersionTable, String> villageOrRoad =
		createColumn(
			"villageOrRoad", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AddressVersionTable, String> mouzaOrMoholla =
		createColumn(
			"mouzaOrMoholla", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AddressVersionTable, String> address = createColumn(
		"address", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AddressVersionTable, String> addressType = createColumn(
		"addressType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AddressVersionTable, Long> classPK = createColumn(
		"classPK", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AddressVersionTable, String> className = createColumn(
		"className", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private AddressVersionTable() {
		super("DGF_AddressVersion", AddressVersionTable::new);
	}

}