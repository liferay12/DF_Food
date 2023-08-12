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

import java.sql.Clob;
import java.sql.Types;

/**
 * The table class for the &quot;DGF_Attachment&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Attachment
 * @generated
 */
public class AttachmentTable extends BaseTable<AttachmentTable> {

	public static final AttachmentTable INSTANCE = new AttachmentTable();

	public final Column<AttachmentTable, Long> attachmentId = createColumn(
		"attachmentId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AttachmentTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AttachmentTable, String> category = createColumn(
		"category", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AttachmentTable, Long> fileEntryId = createColumn(
		"fileEntryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AttachmentTable, Long> openTextId = createColumn(
		"openTextId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AttachmentTable, Clob> metadata = createColumn(
		"metadata", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<AttachmentTable, Long> classPK = createColumn(
		"classPK", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AttachmentTable, String> className = createColumn(
		"className", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private AttachmentTable() {
		super("DGF_Attachment", AttachmentTable::new);
	}

}