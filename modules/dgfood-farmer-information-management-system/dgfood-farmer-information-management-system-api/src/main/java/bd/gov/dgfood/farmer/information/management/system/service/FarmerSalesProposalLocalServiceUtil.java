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

package bd.gov.dgfood.farmer.information.management.system.service;

import bd.gov.dgfood.farmer.information.management.system.model.FarmerSalesProposal;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for FarmerSalesProposal. This utility wraps
 * <code>bd.gov.dgfood.farmer.information.management.system.service.impl.FarmerSalesProposalLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FarmerSalesProposalLocalService
 * @generated
 */
public class FarmerSalesProposalLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>bd.gov.dgfood.farmer.information.management.system.service.impl.FarmerSalesProposalLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the farmer sales proposal to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FarmerSalesProposalLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param farmerSalesProposal the farmer sales proposal
	 * @return the farmer sales proposal that was added
	 */
	public static FarmerSalesProposal addFarmerSalesProposal(
		FarmerSalesProposal farmerSalesProposal) {

		return getService().addFarmerSalesProposal(farmerSalesProposal);
	}

	/**
	 * It will add a new Farmer Sales Proposal record in the Farmer Sales Proposal
	 * master table
	 *
	 * @return FarmerSalesProposal
	 * @throws PortalException
	 */
	public static FarmerSalesProposal addFarmerSalesProposal(
			long farmerRegistrationId, String businessCode,
			String currentSeason, String foodgrainType, String krishiCardNumber,
			String pastProdDataSeason1Name, String pastProdDataSeason1Year,
			double pastProdDataSeason1Qty, String pastProdDataSeason1QtyUnit,
			String pastProdDataSeason2Name, String pastProdDataSeason2Year,
			double pastProdDataSeason2Qty, String pastProdDataSeason2QtyUnit,
			String pastProdDataSeason3Name, String pastProdDataSeason3Year,
			double pastProdDataSeason3Qty, String pastProdDataSeason3QtyUnit,
			String succeedingProdDataSeason1Name,
			String succeedingProdDataSeason1Year,
			double succeedingProdDataSeason1Qty,
			String succeedingProdDataSeason1QtyUnit,
			String succeedingProdDataSeason2Name,
			String succeedingProdDataSeason2Year,
			double succeedingProdDataSeason2Qty,
			String succeedingProdDataSeason2QtyUnit,
			String succeedingProdDataSeason3Name,
			String succeedingProdDataSeason3Year,
			double succeedingProdDataSeason3Qty,
			String succeedingProdDataSeason3QtyUnit,
			boolean isGrainProcuredInLast4Seasons,
			String foodgrainProcuredSeason1Name,
			String foodgrainProcuredSeason1Year,
			String foodgrainProcuredSeason2Name,
			String foodgrainProcuredSeason2Year,
			String foodgrainProcuredSeason3Name,
			String foodgrainProcuredSeason3Year,
			String foodgrainProcuredSeason4Name,
			String foodgrainProcuredSeason4Year,
			String cultivableLandSeason1RiceType,
			String cultivableLandSeason2RiceType,
			String cultivableLandSeason3RiceType, long groupId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addFarmerSalesProposal(
			farmerRegistrationId, businessCode, currentSeason, foodgrainType,
			krishiCardNumber, pastProdDataSeason1Name, pastProdDataSeason1Year,
			pastProdDataSeason1Qty, pastProdDataSeason1QtyUnit,
			pastProdDataSeason2Name, pastProdDataSeason2Year,
			pastProdDataSeason2Qty, pastProdDataSeason2QtyUnit,
			pastProdDataSeason3Name, pastProdDataSeason3Year,
			pastProdDataSeason3Qty, pastProdDataSeason3QtyUnit,
			succeedingProdDataSeason1Name, succeedingProdDataSeason1Year,
			succeedingProdDataSeason1Qty, succeedingProdDataSeason1QtyUnit,
			succeedingProdDataSeason2Name, succeedingProdDataSeason2Year,
			succeedingProdDataSeason2Qty, succeedingProdDataSeason2QtyUnit,
			succeedingProdDataSeason3Name, succeedingProdDataSeason3Year,
			succeedingProdDataSeason3Qty, succeedingProdDataSeason3QtyUnit,
			isGrainProcuredInLast4Seasons, foodgrainProcuredSeason1Name,
			foodgrainProcuredSeason1Year, foodgrainProcuredSeason2Name,
			foodgrainProcuredSeason2Year, foodgrainProcuredSeason3Name,
			foodgrainProcuredSeason3Year, foodgrainProcuredSeason4Name,
			foodgrainProcuredSeason4Year, cultivableLandSeason1RiceType,
			cultivableLandSeason2RiceType, cultivableLandSeason3RiceType,
			groupId, serviceContext);
	}

	public static FarmerSalesProposal addFarmerSalesProposalFormData(
			boolean isHeadlessRequest, long farmerRegistrationId,
			String businessCode, String currentSeason, String foodgrainType,
			String krishiCardNumber, String pastProdDataSeason1Name,
			String pastProdDataSeason1Year, double pastProdDataSeason1Qty,
			String pastProdDataSeason1QtyUnit, String pastProdDataSeason2Name,
			String pastProdDataSeason2Year, double pastProdDataSeason2Qty,
			String pastProdDataSeason2QtyUnit, String pastProdDataSeason3Name,
			String pastProdDataSeason3Year, double pastProdDataSeason3Qty,
			String pastProdDataSeason3QtyUnit,
			String succeedingProdDataSeason1Name,
			String succeedingProdDataSeason1Year,
			double succeedingProdDataSeason1Qty,
			String succeedingProdDataSeason1QtyUnit,
			String succeedingProdDataSeason2Name,
			String succeedingProdDataSeason2Year,
			double succeedingProdDataSeason2Qty,
			String succeedingProdDataSeason2QtyUnit,
			String succeedingProdDataSeason3Name,
			String succeedingProdDataSeason3Year,
			double succeedingProdDataSeason3Qty,
			String succeedingProdDataSeason3QtyUnit,
			boolean isGrainProcuredInLast4Seasons,
			String foodgrainProcuredSeason1Name,
			String foodgrainProcuredSeason1Year,
			com.liferay.portal.vulcan.multipart.BinaryFile
				foodgrainProcuredSeason1WQSC,
			String foodgrainProcuredSeason2Name,
			String foodgrainProcuredSeason2Year,
			com.liferay.portal.vulcan.multipart.BinaryFile
				foodgrainProcuredSeason2WQSC,
			String foodgrainProcuredSeason3Name,
			String foodgrainProcuredSeason3Year,
			com.liferay.portal.vulcan.multipart.BinaryFile
				foodgrainProcuredSeason3WQSC,
			String foodgrainProcuredSeason4Name,
			String foodgrainProcuredSeason4Year,
			com.liferay.portal.vulcan.multipart.BinaryFile
				foodgrainProcuredSeason4WQSC,
			String cultivableLandSeason1RiceType,
			String cultivableLandSeason2RiceType,
			String cultivableLandSeason3RiceType, String bankAccountNumber,
			String bankName, String branchName, String routingCode,
			long groupId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addFarmerSalesProposalFormData(
			isHeadlessRequest, farmerRegistrationId, businessCode,
			currentSeason, foodgrainType, krishiCardNumber,
			pastProdDataSeason1Name, pastProdDataSeason1Year,
			pastProdDataSeason1Qty, pastProdDataSeason1QtyUnit,
			pastProdDataSeason2Name, pastProdDataSeason2Year,
			pastProdDataSeason2Qty, pastProdDataSeason2QtyUnit,
			pastProdDataSeason3Name, pastProdDataSeason3Year,
			pastProdDataSeason3Qty, pastProdDataSeason3QtyUnit,
			succeedingProdDataSeason1Name, succeedingProdDataSeason1Year,
			succeedingProdDataSeason1Qty, succeedingProdDataSeason1QtyUnit,
			succeedingProdDataSeason2Name, succeedingProdDataSeason2Year,
			succeedingProdDataSeason2Qty, succeedingProdDataSeason2QtyUnit,
			succeedingProdDataSeason3Name, succeedingProdDataSeason3Year,
			succeedingProdDataSeason3Qty, succeedingProdDataSeason3QtyUnit,
			isGrainProcuredInLast4Seasons, foodgrainProcuredSeason1Name,
			foodgrainProcuredSeason1Year, foodgrainProcuredSeason1WQSC,
			foodgrainProcuredSeason2Name, foodgrainProcuredSeason2Year,
			foodgrainProcuredSeason2WQSC, foodgrainProcuredSeason3Name,
			foodgrainProcuredSeason3Year, foodgrainProcuredSeason3WQSC,
			foodgrainProcuredSeason4Name, foodgrainProcuredSeason4Year,
			foodgrainProcuredSeason4WQSC, cultivableLandSeason1RiceType,
			cultivableLandSeason2RiceType, cultivableLandSeason3RiceType,
			bankAccountNumber, bankName, branchName, routingCode, groupId,
			serviceContext);
	}

	/**
	 * Creates a new farmer sales proposal with the primary key. Does not add the farmer sales proposal to the database.
	 *
	 * @param farmerSalesProposalId the primary key for the new farmer sales proposal
	 * @return the new farmer sales proposal
	 */
	public static FarmerSalesProposal createFarmerSalesProposal(
		long farmerSalesProposalId) {

		return getService().createFarmerSalesProposal(farmerSalesProposalId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the farmer sales proposal from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FarmerSalesProposalLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param farmerSalesProposal the farmer sales proposal
	 * @return the farmer sales proposal that was removed
	 */
	public static FarmerSalesProposal deleteFarmerSalesProposal(
		FarmerSalesProposal farmerSalesProposal) {

		return getService().deleteFarmerSalesProposal(farmerSalesProposal);
	}

	/**
	 * Deletes the farmer sales proposal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FarmerSalesProposalLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param farmerSalesProposalId the primary key of the farmer sales proposal
	 * @return the farmer sales proposal that was removed
	 * @throws PortalException if a farmer sales proposal with the primary key could not be found
	 */
	public static FarmerSalesProposal deleteFarmerSalesProposal(
			long farmerSalesProposalId)
		throws PortalException {

		return getService().deleteFarmerSalesProposal(farmerSalesProposalId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.farmer.information.management.system.model.impl.FarmerSalesProposalModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.farmer.information.management.system.model.impl.FarmerSalesProposalModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static FarmerSalesProposal fetchFarmerSalesProposal(
		long farmerSalesProposalId) {

		return getService().fetchFarmerSalesProposal(farmerSalesProposalId);
	}

	/**
	 * Returns the farmer sales proposal matching the UUID and group.
	 *
	 * @param uuid the farmer sales proposal's UUID
	 * @param groupId the primary key of the group
	 * @return the matching farmer sales proposal, or <code>null</code> if a matching farmer sales proposal could not be found
	 */
	public static FarmerSalesProposal fetchFarmerSalesProposalByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchFarmerSalesProposalByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	/**
	 * Returns the farmer sales proposal with the primary key.
	 *
	 * @param farmerSalesProposalId the primary key of the farmer sales proposal
	 * @return the farmer sales proposal
	 * @throws PortalException if a farmer sales proposal with the primary key could not be found
	 */
	public static FarmerSalesProposal getFarmerSalesProposal(
			long farmerSalesProposalId)
		throws PortalException {

		return getService().getFarmerSalesProposal(farmerSalesProposalId);
	}

	/**
	 * Returns the farmer sales proposal matching the UUID and group.
	 *
	 * @param uuid the farmer sales proposal's UUID
	 * @param groupId the primary key of the group
	 * @return the matching farmer sales proposal
	 * @throws PortalException if a matching farmer sales proposal could not be found
	 */
	public static FarmerSalesProposal getFarmerSalesProposalByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getFarmerSalesProposalByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the farmer sales proposals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.farmer.information.management.system.model.impl.FarmerSalesProposalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of farmer sales proposals
	 * @param end the upper bound of the range of farmer sales proposals (not inclusive)
	 * @return the range of farmer sales proposals
	 */
	public static List<FarmerSalesProposal> getFarmerSalesProposals(
		int start, int end) {

		return getService().getFarmerSalesProposals(start, end);
	}

	/**
	 * Returns all the farmer sales proposals matching the UUID and company.
	 *
	 * @param uuid the UUID of the farmer sales proposals
	 * @param companyId the primary key of the company
	 * @return the matching farmer sales proposals, or an empty list if no matches were found
	 */
	public static List<FarmerSalesProposal>
		getFarmerSalesProposalsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getFarmerSalesProposalsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of farmer sales proposals matching the UUID and company.
	 *
	 * @param uuid the UUID of the farmer sales proposals
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of farmer sales proposals
	 * @param end the upper bound of the range of farmer sales proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching farmer sales proposals, or an empty list if no matches were found
	 */
	public static List<FarmerSalesProposal>
		getFarmerSalesProposalsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<FarmerSalesProposal> orderByComparator) {

		return getService().getFarmerSalesProposalsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of farmer sales proposals.
	 *
	 * @return the number of farmer sales proposals
	 */
	public static int getFarmerSalesProposalsCount() {
		return getService().getFarmerSalesProposalsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the farmer sales proposal in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FarmerSalesProposalLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param farmerSalesProposal the farmer sales proposal
	 * @return the farmer sales proposal that was updated
	 */
	public static FarmerSalesProposal updateFarmerSalesProposal(
		FarmerSalesProposal farmerSalesProposal) {

		return getService().updateFarmerSalesProposal(farmerSalesProposal);
	}

	public static FarmerSalesProposalLocalService getService() {
		return _service;
	}

	private static volatile FarmerSalesProposalLocalService _service;

}