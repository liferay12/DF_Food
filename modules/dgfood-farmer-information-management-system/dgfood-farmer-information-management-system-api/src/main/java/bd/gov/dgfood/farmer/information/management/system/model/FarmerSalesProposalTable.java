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

package bd.gov.dgfood.farmer.information.management.system.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;DGFood_SalesProposal&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see FarmerSalesProposal
 * @generated
 */
public class FarmerSalesProposalTable
	extends BaseTable<FarmerSalesProposalTable> {

	public static final FarmerSalesProposalTable INSTANCE =
		new FarmerSalesProposalTable();

	public final Column<FarmerSalesProposalTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, Long> farmerSalesProposalId =
		createColumn(
			"farmerSalesProposalId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<FarmerSalesProposalTable, String> applicationNumber =
		createColumn(
			"applicationNumber", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, Long> farmerRegistrationId =
		createColumn(
			"farmerRegistrationId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, String> businessCode =
		createColumn(
			"businessCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, String> currentSeason =
		createColumn(
			"currentSeason", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, String> foodGrainType =
		createColumn(
			"foodGrainType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, String> krishiCardNumber =
		createColumn(
			"krishiCardNumber", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, Clob> pastProdDataSeason1 =
		createColumn(
			"pastProdDataSeason1", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, Clob> pastProdDataSeason2 =
		createColumn(
			"pastProdDataSeason2", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, Clob> pastProdDataSeason3 =
		createColumn(
			"pastProdDataSeason3", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, Clob>
		succeedingProdDataSeason1 = createColumn(
			"succeedingProdDataSeason1", Clob.class, Types.CLOB,
			Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, Clob>
		succeedingProdDataSeason2 = createColumn(
			"succeedingProdDataSeason2", Clob.class, Types.CLOB,
			Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, Clob>
		succeedingProdDataSeason3 = createColumn(
			"succeedingProdDataSeason3", Clob.class, Types.CLOB,
			Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, Boolean>
		grainProcuredInLast4Seasons = createColumn(
			"grainProcuredInLast4Seasons ", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, Clob>
		foodgranProcuredSeason1 = createColumn(
			"foodgranProcuredSeason1", Clob.class, Types.CLOB,
			Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, Clob>
		foodgranProcuredSeason2 = createColumn(
			"foodgranProcuredSeason2", Clob.class, Types.CLOB,
			Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, Clob>
		foodgranProcuredSeason3 = createColumn(
			"foodgranProcuredSeason3", Clob.class, Types.CLOB,
			Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, Clob>
		foodgranProcuredSeason4 = createColumn(
			"foodgranProcuredSeason4", Clob.class, Types.CLOB,
			Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, Clob> cultivableLandSeason1 =
		createColumn(
			"cultivableLandSeason1", Clob.class, Types.CLOB,
			Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, Clob> cultivableLandSeason2 =
		createColumn(
			"cultivableLandSeason2", Clob.class, Types.CLOB,
			Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, Clob> cultivableLandSeason3 =
		createColumn(
			"cultivableLandSeason3", Clob.class, Types.CLOB,
			Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, Integer>
		foodgrainReceivedStatus = createColumn(
			"foodgrainReceivedStatus", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, Clob> receivedFoodgrainQty =
		createColumn(
			"receivedFoodgrainQty", Clob.class, Types.CLOB,
			Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, Date> foodgrainReceivedDate =
		createColumn(
			"foodgrainReceivedDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, Integer> paymentStatus =
		createColumn(
			"paymentStatus", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, String> remarks =
		createColumn(
			"remarks", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, Double> version =
		createColumn(
			"version", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, Integer> status =
		createColumn(
			"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, Long> statusByUserId =
		createColumn(
			"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FarmerSalesProposalTable, Date> statusDate =
		createColumn(
			"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private FarmerSalesProposalTable() {
		super("DGFood_SalesProposal", FarmerSalesProposalTable::new);
	}

}