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
 * The table class for the &quot;DGF_Address&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Address
 * @generated
 */
public class AddressTable extends BaseTable<AddressTable> {

	public static final AddressTable INSTANCE = new AddressTable();

	public final Column<AddressTable, Long> addressId = createColumn(
		"addressId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AddressTable, Long> region = createColumn(
		"region", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AddressTable, Long> district = createColumn(
		"district", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AddressTable, Long> upazilla = createColumn(
		"upazilla", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AddressTable, Long> cityCorporationOrMunicipality =
		createColumn(
			"cityCorporationOrMunicipality", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<AddressTable, Long> unionOrWard = createColumn(
		"unionOrWard", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AddressTable, Long> zipCode = createColumn(
		"zipCode", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AddressTable, String> postOffice = createColumn(
		"postOffice", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AddressTable, String> villageOrRoad = createColumn(
		"villageOrRoad", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AddressTable, String> mouzaOrMoholla = createColumn(
		"mouzaOrMoholla", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AddressTable, String> address = createColumn(
		"address", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AddressTable, String> addressType = createColumn(
		"addressType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AddressTable, Long> classPK = createColumn(
		"classPK", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AddressTable, String> className = createColumn(
		"className", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private AddressTable() {
		super("DGF_Address", AddressTable::new);
	}

}