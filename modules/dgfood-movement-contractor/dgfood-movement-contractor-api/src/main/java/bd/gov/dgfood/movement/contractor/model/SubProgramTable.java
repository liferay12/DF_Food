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
 * The table class for the &quot;DGFOOD_SubProgram&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see SubProgram
 * @generated
 */
public class SubProgramTable extends BaseTable<SubProgramTable> {

	public static final SubProgramTable INSTANCE = new SubProgramTable();

	public final Column<SubProgramTable, Long> subProgramId = createColumn(
		"subProgramId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SubProgramTable, String> deliveryNo = createColumn(
		"deliveryNo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SubProgramTable, String> memoNo = createColumn(
		"memoNo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SubProgramTable, String> sendingDepot = createColumn(
		"sendingDepot", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SubProgramTable, String> sendingPlantDesc =
		createColumn(
			"sendingPlantDesc", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SubProgramTable, String> receivingDepot = createColumn(
		"receivingDepot", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SubProgramTable, String> receivingPlantDesc =
		createColumn(
			"receivingPlantDesc", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SubProgramTable, String> product = createColumn(
		"product", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SubProgramTable, Clob> quantity = createColumn(
		"quantity", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<SubProgramTable, Date> deliveryDate = createColumn(
		"deliveryDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SubProgramTable, Date> requestedDate = createColumn(
		"requestedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SubProgramTable, String> forwardingAgent = createColumn(
		"forwardingAgent", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SubProgramTable, Date> vehicleSendDate = createColumn(
		"vehicleSendDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SubProgramTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<SubProgramTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SubProgramTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SubProgramTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private SubProgramTable() {
		super("DGFOOD_SubProgram", SubProgramTable::new);
	}

}