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
 * The table class for the &quot;DGF_Indent&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Indent
 * @generated
 */
public class IndentTable extends BaseTable<IndentTable> {

	public static final IndentTable INSTANCE = new IndentTable();

	public final Column<IndentTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<IndentTable, Long> indentId = createColumn(
		"indentId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<IndentTable, Long> allocationId = createColumn(
		"allocationId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<IndentTable, String> commodity = createColumn(
		"commodity", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<IndentTable, String> commodityDescription =
		createColumn(
			"commodityDescription", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<IndentTable, Double> quantity = createColumn(
		"quantity", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<IndentTable, String> quantityUnit = createColumn(
		"quantityUnit", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<IndentTable, Date> requiredDeliveryDate = createColumn(
		"requiredDeliveryDate", Date.class, Types.TIMESTAMP,
		Column.FLAG_DEFAULT);
	public final Column<IndentTable, Date> foodGrainissueDate = createColumn(
		"foodGrainissueDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<IndentTable, Double> netPrice = createColumn(
		"netPrice", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<IndentTable, String> netPriceCurrencyKey = createColumn(
		"netPriceCurrencyKey", String.class, Types.VARCHAR,
		Column.FLAG_DEFAULT);
	public final Column<IndentTable, Double> netValue = createColumn(
		"netValue", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<IndentTable, String> netValueCurrencyKey = createColumn(
		"netValueCurrencyKey", String.class, Types.VARCHAR,
		Column.FLAG_DEFAULT);
	public final Column<IndentTable, String> salesOffice = createColumn(
		"salesOffice", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<IndentTable, String> depo = createColumn(
		"depo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<IndentTable, String> repaymentTerms = createColumn(
		"repaymentTerms", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<IndentTable, String> deliveryTerms = createColumn(
		"deliveryTerms", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<IndentTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<IndentTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<IndentTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<IndentTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<IndentTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<IndentTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<IndentTable, Integer> reason = createColumn(
		"reason", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private IndentTable() {
		super("DGF_Indent", IndentTable::new);
	}

}