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

package bd.gov.dgfood.movement.contractor.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;DGFOOD_VInvoice&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see VInvoice
 * @generated
 */
public class VInvoiceTable extends BaseTable<VInvoiceTable> {

	public static final VInvoiceTable INSTANCE = new VInvoiceTable();

	public final Column<VInvoiceTable, Long> vInvoiceId = createColumn(
		"vInvoiceId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<VInvoiceTable, String> vInvoiceNo = createColumn(
		"vInvoiceNo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VInvoiceTable, String> deliveryNo = createColumn(
		"deliveryNo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VInvoiceTable, String> sendingPlant = createColumn(
		"sendingPlant", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VInvoiceTable, String> sendingPlantDesc = createColumn(
		"sendingPlantDesc", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VInvoiceTable, String> receivingPlant = createColumn(
		"receivingPlant", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VInvoiceTable, String> receivingPlantDesc =
		createColumn(
			"receivingPlantDesc", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<VInvoiceTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VInvoiceTable, Date> departureDate = createColumn(
		"departureDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<VInvoiceTable, String> materialNo = createColumn(
		"materialNo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VInvoiceTable, String> materialDescription =
		createColumn(
			"materialDescription", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<VInvoiceTable, Clob> quantity = createColumn(
		"quantity", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<VInvoiceTable, Double> bagQuantity = createColumn(
		"bagQuantity", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<VInvoiceTable, Double> grossWeight = createColumn(
		"grossWeight", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<VInvoiceTable, Double> netWeight = createColumn(
		"netWeight", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<VInvoiceTable, String> storageLocation = createColumn(
		"storageLocation", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VInvoiceTable, String> storageBin = createColumn(
		"storageBin", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VInvoiceTable, String> carrier = createColumn(
		"carrier", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VInvoiceTable, String> transportationMode =
		createColumn(
			"transportationMode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<VInvoiceTable, String> meansOfTransport = createColumn(
		"meansOfTransport", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VInvoiceTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private VInvoiceTable() {
		super("DGFOOD_VInvoice", VInvoiceTable::new);
	}

}