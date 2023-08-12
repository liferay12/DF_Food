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

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.vulcan.multipart.BinaryFile;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for FarmerSalesProposal. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see FarmerSalesProposalLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface FarmerSalesProposalLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>bd.gov.dgfood.farmer.information.management.system.service.impl.FarmerSalesProposalLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the farmer sales proposal local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link FarmerSalesProposalLocalServiceUtil} if injection and service tracking are not available.
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
	@Indexable(type = IndexableType.REINDEX)
	public FarmerSalesProposal addFarmerSalesProposal(
		FarmerSalesProposal farmerSalesProposal);

	/**
	 * It will add a new Farmer Sales Proposal record in the Farmer Sales Proposal
	 * master table
	 *
	 * @return FarmerSalesProposal
	 * @throws PortalException
	 */
	public FarmerSalesProposal addFarmerSalesProposal(
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
			ServiceContext serviceContext)
		throws PortalException;

	public FarmerSalesProposal addFarmerSalesProposalFormData(
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
			BinaryFile foodgrainProcuredSeason1WQSC,
			String foodgrainProcuredSeason2Name,
			String foodgrainProcuredSeason2Year,
			BinaryFile foodgrainProcuredSeason2WQSC,
			String foodgrainProcuredSeason3Name,
			String foodgrainProcuredSeason3Year,
			BinaryFile foodgrainProcuredSeason3WQSC,
			String foodgrainProcuredSeason4Name,
			String foodgrainProcuredSeason4Year,
			BinaryFile foodgrainProcuredSeason4WQSC,
			String cultivableLandSeason1RiceType,
			String cultivableLandSeason2RiceType,
			String cultivableLandSeason3RiceType, String bankAccountNumber,
			String bankName, String branchName, String routingCode,
			long groupId, ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Creates a new farmer sales proposal with the primary key. Does not add the farmer sales proposal to the database.
	 *
	 * @param farmerSalesProposalId the primary key for the new farmer sales proposal
	 * @return the new farmer sales proposal
	 */
	@Transactional(enabled = false)
	public FarmerSalesProposal createFarmerSalesProposal(
		long farmerSalesProposalId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public FarmerSalesProposal deleteFarmerSalesProposal(
		FarmerSalesProposal farmerSalesProposal);

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
	@Indexable(type = IndexableType.DELETE)
	public FarmerSalesProposal deleteFarmerSalesProposal(
			long farmerSalesProposalId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FarmerSalesProposal fetchFarmerSalesProposal(
		long farmerSalesProposalId);

	/**
	 * Returns the farmer sales proposal matching the UUID and group.
	 *
	 * @param uuid the farmer sales proposal's UUID
	 * @param groupId the primary key of the group
	 * @return the matching farmer sales proposal, or <code>null</code> if a matching farmer sales proposal could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FarmerSalesProposal fetchFarmerSalesProposalByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	/**
	 * Returns the farmer sales proposal with the primary key.
	 *
	 * @param farmerSalesProposalId the primary key of the farmer sales proposal
	 * @return the farmer sales proposal
	 * @throws PortalException if a farmer sales proposal with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FarmerSalesProposal getFarmerSalesProposal(
			long farmerSalesProposalId)
		throws PortalException;

	/**
	 * Returns the farmer sales proposal matching the UUID and group.
	 *
	 * @param uuid the farmer sales proposal's UUID
	 * @param groupId the primary key of the group
	 * @return the matching farmer sales proposal
	 * @throws PortalException if a matching farmer sales proposal could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FarmerSalesProposal getFarmerSalesProposalByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FarmerSalesProposal> getFarmerSalesProposals(
		int start, int end);

	/**
	 * Returns all the farmer sales proposals matching the UUID and company.
	 *
	 * @param uuid the UUID of the farmer sales proposals
	 * @param companyId the primary key of the company
	 * @return the matching farmer sales proposals, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FarmerSalesProposal> getFarmerSalesProposalsByUuidAndCompanyId(
		String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FarmerSalesProposal> getFarmerSalesProposalsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FarmerSalesProposal> orderByComparator);

	/**
	 * Returns the number of farmer sales proposals.
	 *
	 * @return the number of farmer sales proposals
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getFarmerSalesProposalsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	@Indexable(type = IndexableType.REINDEX)
	public FarmerSalesProposal updateFarmerSalesProposal(
		FarmerSalesProposal farmerSalesProposal);

}