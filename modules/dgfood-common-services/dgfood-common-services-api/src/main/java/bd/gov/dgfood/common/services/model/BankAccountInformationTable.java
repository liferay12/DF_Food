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
 * The table class for the &quot;DGF_BankAccountInformation&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see BankAccountInformation
 * @generated
 */
public class BankAccountInformationTable
	extends BaseTable<BankAccountInformationTable> {

	public static final BankAccountInformationTable INSTANCE =
		new BankAccountInformationTable();

	public final Column<BankAccountInformationTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BankAccountInformationTable, Long>
		bankAccountInformationId = createColumn(
			"bankAccountInformationId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<BankAccountInformationTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BankAccountInformationTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BankAccountInformationTable, String> accountNumber =
		createColumn(
			"accountNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BankAccountInformationTable, String> bankName =
		createColumn(
			"bankName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BankAccountInformationTable, String> branchName =
		createColumn(
			"branchName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BankAccountInformationTable, String> routingCode =
		createColumn(
			"routingCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BankAccountInformationTable, Integer> status =
		createColumn(
			"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<BankAccountInformationTable, String> version =
		createColumn(
			"version", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BankAccountInformationTable, Long> classPK =
		createColumn("classPK", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BankAccountInformationTable, Long> classNameId =
		createColumn(
			"classNameId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private BankAccountInformationTable() {
		super("DGF_BankAccountInformation", BankAccountInformationTable::new);
	}

}