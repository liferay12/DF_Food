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
 * The table class for the &quot;DGF_DeliveryOrder&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DeliveryOrder
 * @generated
 */
public class DeliveryOrderTable extends BaseTable<DeliveryOrderTable> {

	public static final DeliveryOrderTable INSTANCE = new DeliveryOrderTable();

	public final Column<DeliveryOrderTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DeliveryOrderTable, Long> deliveryOrderId =
		createColumn(
			"deliveryOrderId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DeliveryOrderTable, Long> indentId = createColumn(
		"indentId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DeliveryOrderTable, String> deliveryOrderNo =
		createColumn(
			"deliveryOrderNo", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DeliveryOrderTable, String> customerNo = createColumn(
		"customerNo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DeliveryOrderTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DeliveryOrderTable, Date> doDate = createColumn(
		"doDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DeliveryOrderTable, String> commodity = createColumn(
		"commodity", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DeliveryOrderTable, String> commodityDescription =
		createColumn(
			"commodityDescription", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DeliveryOrderTable, String> doQty = createColumn(
		"doQty", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DeliveryOrderTable, String> doQtyUnit = createColumn(
		"doQtyUnit", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DeliveryOrderTable, String> depo = createColumn(
		"depo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DeliveryOrderTable, String> warehouseNo = createColumn(
		"warehouseNo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DeliveryOrderTable, String> khamaalNo = createColumn(
		"khamaalNo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DeliveryOrderTable, String> lUANo = createColumn(
		"lUANo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DeliveryOrderTable, Date> lUADate = createColumn(
		"lUADate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DeliveryOrderTable, String> bagUnit = createColumn(
		"bagUnit", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DeliveryOrderTable, String> vehicleNo = createColumn(
		"vehicleNo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DeliveryOrderTable, String> gateKeeper = createColumn(
		"gateKeeper", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DeliveryOrderTable, String> goodsIssueDate =
		createColumn(
			"goodsIssueDate", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DeliveryOrderTable, String> shipToParty = createColumn(
		"shipToParty", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DeliveryOrderTable, String> shipToPartyName =
		createColumn(
			"shipToPartyName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DeliveryOrderTable, String> deliveredQty = createColumn(
		"deliveredQty", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DeliveryOrderTable, String> deliveredQtyUnit =
		createColumn(
			"deliveredQtyUnit", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DeliveryOrderTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DeliveryOrderTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DeliveryOrderTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DeliveryOrderTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private DeliveryOrderTable() {
		super("DGF_DeliveryOrder", DeliveryOrderTable::new);
	}

}