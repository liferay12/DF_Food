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

package bd.gov.dgfood.farmer.information.management.system.service.persistence;

import bd.gov.dgfood.farmer.information.management.system.model.FarmerSalesProposal;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the farmer sales proposal service. This utility wraps <code>bd.gov.dgfood.farmer.information.management.system.service.persistence.impl.FarmerSalesProposalPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FarmerSalesProposalPersistence
 * @generated
 */
public class FarmerSalesProposalUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(FarmerSalesProposal farmerSalesProposal) {
		getPersistence().clearCache(farmerSalesProposal);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, FarmerSalesProposal> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FarmerSalesProposal> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FarmerSalesProposal> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FarmerSalesProposal> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FarmerSalesProposal> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FarmerSalesProposal update(
		FarmerSalesProposal farmerSalesProposal) {

		return getPersistence().update(farmerSalesProposal);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FarmerSalesProposal update(
		FarmerSalesProposal farmerSalesProposal,
		ServiceContext serviceContext) {

		return getPersistence().update(farmerSalesProposal, serviceContext);
	}

	/**
	 * Returns all the farmer sales proposals where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching farmer sales proposals
	 */
	public static List<FarmerSalesProposal> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the farmer sales proposals where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerSalesProposalModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of farmer sales proposals
	 * @param end the upper bound of the range of farmer sales proposals (not inclusive)
	 * @return the range of matching farmer sales proposals
	 */
	public static List<FarmerSalesProposal> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the farmer sales proposals where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerSalesProposalModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of farmer sales proposals
	 * @param end the upper bound of the range of farmer sales proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching farmer sales proposals
	 */
	public static List<FarmerSalesProposal> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FarmerSalesProposal> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the farmer sales proposals where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerSalesProposalModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of farmer sales proposals
	 * @param end the upper bound of the range of farmer sales proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching farmer sales proposals
	 */
	public static List<FarmerSalesProposal> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FarmerSalesProposal> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first farmer sales proposal in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a matching farmer sales proposal could not be found
	 */
	public static FarmerSalesProposal findByUuid_First(
			String uuid,
			OrderByComparator<FarmerSalesProposal> orderByComparator)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerSalesProposalException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first farmer sales proposal in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer sales proposal, or <code>null</code> if a matching farmer sales proposal could not be found
	 */
	public static FarmerSalesProposal fetchByUuid_First(
		String uuid, OrderByComparator<FarmerSalesProposal> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last farmer sales proposal in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a matching farmer sales proposal could not be found
	 */
	public static FarmerSalesProposal findByUuid_Last(
			String uuid,
			OrderByComparator<FarmerSalesProposal> orderByComparator)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerSalesProposalException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last farmer sales proposal in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer sales proposal, or <code>null</code> if a matching farmer sales proposal could not be found
	 */
	public static FarmerSalesProposal fetchByUuid_Last(
		String uuid, OrderByComparator<FarmerSalesProposal> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the farmer sales proposals before and after the current farmer sales proposal in the ordered set where uuid = &#63;.
	 *
	 * @param farmerSalesProposalId the primary key of the current farmer sales proposal
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a farmer sales proposal with the primary key could not be found
	 */
	public static FarmerSalesProposal[] findByUuid_PrevAndNext(
			long farmerSalesProposalId, String uuid,
			OrderByComparator<FarmerSalesProposal> orderByComparator)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerSalesProposalException {

		return getPersistence().findByUuid_PrevAndNext(
			farmerSalesProposalId, uuid, orderByComparator);
	}

	/**
	 * Removes all the farmer sales proposals where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of farmer sales proposals where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching farmer sales proposals
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the farmer sales proposal where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFarmerSalesProposalException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a matching farmer sales proposal could not be found
	 */
	public static FarmerSalesProposal findByUUID_G(String uuid, long groupId)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerSalesProposalException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the farmer sales proposal where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching farmer sales proposal, or <code>null</code> if a matching farmer sales proposal could not be found
	 */
	public static FarmerSalesProposal fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the farmer sales proposal where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer sales proposal, or <code>null</code> if a matching farmer sales proposal could not be found
	 */
	public static FarmerSalesProposal fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the farmer sales proposal where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the farmer sales proposal that was removed
	 */
	public static FarmerSalesProposal removeByUUID_G(String uuid, long groupId)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerSalesProposalException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of farmer sales proposals where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching farmer sales proposals
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the farmer sales proposals where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching farmer sales proposals
	 */
	public static List<FarmerSalesProposal> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the farmer sales proposals where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerSalesProposalModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of farmer sales proposals
	 * @param end the upper bound of the range of farmer sales proposals (not inclusive)
	 * @return the range of matching farmer sales proposals
	 */
	public static List<FarmerSalesProposal> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the farmer sales proposals where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerSalesProposalModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of farmer sales proposals
	 * @param end the upper bound of the range of farmer sales proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching farmer sales proposals
	 */
	public static List<FarmerSalesProposal> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FarmerSalesProposal> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the farmer sales proposals where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerSalesProposalModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of farmer sales proposals
	 * @param end the upper bound of the range of farmer sales proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching farmer sales proposals
	 */
	public static List<FarmerSalesProposal> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FarmerSalesProposal> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first farmer sales proposal in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a matching farmer sales proposal could not be found
	 */
	public static FarmerSalesProposal findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FarmerSalesProposal> orderByComparator)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerSalesProposalException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first farmer sales proposal in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer sales proposal, or <code>null</code> if a matching farmer sales proposal could not be found
	 */
	public static FarmerSalesProposal fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FarmerSalesProposal> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last farmer sales proposal in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a matching farmer sales proposal could not be found
	 */
	public static FarmerSalesProposal findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FarmerSalesProposal> orderByComparator)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerSalesProposalException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last farmer sales proposal in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer sales proposal, or <code>null</code> if a matching farmer sales proposal could not be found
	 */
	public static FarmerSalesProposal fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FarmerSalesProposal> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the farmer sales proposals before and after the current farmer sales proposal in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param farmerSalesProposalId the primary key of the current farmer sales proposal
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a farmer sales proposal with the primary key could not be found
	 */
	public static FarmerSalesProposal[] findByUuid_C_PrevAndNext(
			long farmerSalesProposalId, String uuid, long companyId,
			OrderByComparator<FarmerSalesProposal> orderByComparator)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerSalesProposalException {

		return getPersistence().findByUuid_C_PrevAndNext(
			farmerSalesProposalId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the farmer sales proposals where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of farmer sales proposals where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching farmer sales proposals
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the farmer sales proposals where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @return the matching farmer sales proposals
	 */
	public static List<FarmerSalesProposal> findByBusinessCode(
		String businessCode) {

		return getPersistence().findByBusinessCode(businessCode);
	}

	/**
	 * Returns a range of all the farmer sales proposals where businessCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerSalesProposalModelImpl</code>.
	 * </p>
	 *
	 * @param businessCode the business code
	 * @param start the lower bound of the range of farmer sales proposals
	 * @param end the upper bound of the range of farmer sales proposals (not inclusive)
	 * @return the range of matching farmer sales proposals
	 */
	public static List<FarmerSalesProposal> findByBusinessCode(
		String businessCode, int start, int end) {

		return getPersistence().findByBusinessCode(businessCode, start, end);
	}

	/**
	 * Returns an ordered range of all the farmer sales proposals where businessCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerSalesProposalModelImpl</code>.
	 * </p>
	 *
	 * @param businessCode the business code
	 * @param start the lower bound of the range of farmer sales proposals
	 * @param end the upper bound of the range of farmer sales proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching farmer sales proposals
	 */
	public static List<FarmerSalesProposal> findByBusinessCode(
		String businessCode, int start, int end,
		OrderByComparator<FarmerSalesProposal> orderByComparator) {

		return getPersistence().findByBusinessCode(
			businessCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the farmer sales proposals where businessCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerSalesProposalModelImpl</code>.
	 * </p>
	 *
	 * @param businessCode the business code
	 * @param start the lower bound of the range of farmer sales proposals
	 * @param end the upper bound of the range of farmer sales proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching farmer sales proposals
	 */
	public static List<FarmerSalesProposal> findByBusinessCode(
		String businessCode, int start, int end,
		OrderByComparator<FarmerSalesProposal> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByBusinessCode(
			businessCode, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first farmer sales proposal in the ordered set where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a matching farmer sales proposal could not be found
	 */
	public static FarmerSalesProposal findByBusinessCode_First(
			String businessCode,
			OrderByComparator<FarmerSalesProposal> orderByComparator)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerSalesProposalException {

		return getPersistence().findByBusinessCode_First(
			businessCode, orderByComparator);
	}

	/**
	 * Returns the first farmer sales proposal in the ordered set where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer sales proposal, or <code>null</code> if a matching farmer sales proposal could not be found
	 */
	public static FarmerSalesProposal fetchByBusinessCode_First(
		String businessCode,
		OrderByComparator<FarmerSalesProposal> orderByComparator) {

		return getPersistence().fetchByBusinessCode_First(
			businessCode, orderByComparator);
	}

	/**
	 * Returns the last farmer sales proposal in the ordered set where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a matching farmer sales proposal could not be found
	 */
	public static FarmerSalesProposal findByBusinessCode_Last(
			String businessCode,
			OrderByComparator<FarmerSalesProposal> orderByComparator)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerSalesProposalException {

		return getPersistence().findByBusinessCode_Last(
			businessCode, orderByComparator);
	}

	/**
	 * Returns the last farmer sales proposal in the ordered set where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer sales proposal, or <code>null</code> if a matching farmer sales proposal could not be found
	 */
	public static FarmerSalesProposal fetchByBusinessCode_Last(
		String businessCode,
		OrderByComparator<FarmerSalesProposal> orderByComparator) {

		return getPersistence().fetchByBusinessCode_Last(
			businessCode, orderByComparator);
	}

	/**
	 * Returns the farmer sales proposals before and after the current farmer sales proposal in the ordered set where businessCode = &#63;.
	 *
	 * @param farmerSalesProposalId the primary key of the current farmer sales proposal
	 * @param businessCode the business code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a farmer sales proposal with the primary key could not be found
	 */
	public static FarmerSalesProposal[] findByBusinessCode_PrevAndNext(
			long farmerSalesProposalId, String businessCode,
			OrderByComparator<FarmerSalesProposal> orderByComparator)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerSalesProposalException {

		return getPersistence().findByBusinessCode_PrevAndNext(
			farmerSalesProposalId, businessCode, orderByComparator);
	}

	/**
	 * Removes all the farmer sales proposals where businessCode = &#63; from the database.
	 *
	 * @param businessCode the business code
	 */
	public static void removeByBusinessCode(String businessCode) {
		getPersistence().removeByBusinessCode(businessCode);
	}

	/**
	 * Returns the number of farmer sales proposals where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @return the number of matching farmer sales proposals
	 */
	public static int countByBusinessCode(String businessCode) {
		return getPersistence().countByBusinessCode(businessCode);
	}

	/**
	 * Returns the farmer sales proposal where applicationNumber = &#63; or throws a <code>NoSuchFarmerSalesProposalException</code> if it could not be found.
	 *
	 * @param applicationNumber the application number
	 * @return the matching farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a matching farmer sales proposal could not be found
	 */
	public static FarmerSalesProposal findByApplicationNumber(
			String applicationNumber)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerSalesProposalException {

		return getPersistence().findByApplicationNumber(applicationNumber);
	}

	/**
	 * Returns the farmer sales proposal where applicationNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @return the matching farmer sales proposal, or <code>null</code> if a matching farmer sales proposal could not be found
	 */
	public static FarmerSalesProposal fetchByApplicationNumber(
		String applicationNumber) {

		return getPersistence().fetchByApplicationNumber(applicationNumber);
	}

	/**
	 * Returns the farmer sales proposal where applicationNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer sales proposal, or <code>null</code> if a matching farmer sales proposal could not be found
	 */
	public static FarmerSalesProposal fetchByApplicationNumber(
		String applicationNumber, boolean useFinderCache) {

		return getPersistence().fetchByApplicationNumber(
			applicationNumber, useFinderCache);
	}

	/**
	 * Removes the farmer sales proposal where applicationNumber = &#63; from the database.
	 *
	 * @param applicationNumber the application number
	 * @return the farmer sales proposal that was removed
	 */
	public static FarmerSalesProposal removeByApplicationNumber(
			String applicationNumber)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerSalesProposalException {

		return getPersistence().removeByApplicationNumber(applicationNumber);
	}

	/**
	 * Returns the number of farmer sales proposals where applicationNumber = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @return the number of matching farmer sales proposals
	 */
	public static int countByApplicationNumber(String applicationNumber) {
		return getPersistence().countByApplicationNumber(applicationNumber);
	}

	/**
	 * Caches the farmer sales proposal in the entity cache if it is enabled.
	 *
	 * @param farmerSalesProposal the farmer sales proposal
	 */
	public static void cacheResult(FarmerSalesProposal farmerSalesProposal) {
		getPersistence().cacheResult(farmerSalesProposal);
	}

	/**
	 * Caches the farmer sales proposals in the entity cache if it is enabled.
	 *
	 * @param farmerSalesProposals the farmer sales proposals
	 */
	public static void cacheResult(
		List<FarmerSalesProposal> farmerSalesProposals) {

		getPersistence().cacheResult(farmerSalesProposals);
	}

	/**
	 * Creates a new farmer sales proposal with the primary key. Does not add the farmer sales proposal to the database.
	 *
	 * @param farmerSalesProposalId the primary key for the new farmer sales proposal
	 * @return the new farmer sales proposal
	 */
	public static FarmerSalesProposal create(long farmerSalesProposalId) {
		return getPersistence().create(farmerSalesProposalId);
	}

	/**
	 * Removes the farmer sales proposal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param farmerSalesProposalId the primary key of the farmer sales proposal
	 * @return the farmer sales proposal that was removed
	 * @throws NoSuchFarmerSalesProposalException if a farmer sales proposal with the primary key could not be found
	 */
	public static FarmerSalesProposal remove(long farmerSalesProposalId)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerSalesProposalException {

		return getPersistence().remove(farmerSalesProposalId);
	}

	public static FarmerSalesProposal updateImpl(
		FarmerSalesProposal farmerSalesProposal) {

		return getPersistence().updateImpl(farmerSalesProposal);
	}

	/**
	 * Returns the farmer sales proposal with the primary key or throws a <code>NoSuchFarmerSalesProposalException</code> if it could not be found.
	 *
	 * @param farmerSalesProposalId the primary key of the farmer sales proposal
	 * @return the farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a farmer sales proposal with the primary key could not be found
	 */
	public static FarmerSalesProposal findByPrimaryKey(
			long farmerSalesProposalId)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerSalesProposalException {

		return getPersistence().findByPrimaryKey(farmerSalesProposalId);
	}

	/**
	 * Returns the farmer sales proposal with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param farmerSalesProposalId the primary key of the farmer sales proposal
	 * @return the farmer sales proposal, or <code>null</code> if a farmer sales proposal with the primary key could not be found
	 */
	public static FarmerSalesProposal fetchByPrimaryKey(
		long farmerSalesProposalId) {

		return getPersistence().fetchByPrimaryKey(farmerSalesProposalId);
	}

	/**
	 * Returns all the farmer sales proposals.
	 *
	 * @return the farmer sales proposals
	 */
	public static List<FarmerSalesProposal> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the farmer sales proposals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerSalesProposalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of farmer sales proposals
	 * @param end the upper bound of the range of farmer sales proposals (not inclusive)
	 * @return the range of farmer sales proposals
	 */
	public static List<FarmerSalesProposal> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the farmer sales proposals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerSalesProposalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of farmer sales proposals
	 * @param end the upper bound of the range of farmer sales proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of farmer sales proposals
	 */
	public static List<FarmerSalesProposal> findAll(
		int start, int end,
		OrderByComparator<FarmerSalesProposal> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the farmer sales proposals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerSalesProposalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of farmer sales proposals
	 * @param end the upper bound of the range of farmer sales proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of farmer sales proposals
	 */
	public static List<FarmerSalesProposal> findAll(
		int start, int end,
		OrderByComparator<FarmerSalesProposal> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the farmer sales proposals from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of farmer sales proposals.
	 *
	 * @return the number of farmer sales proposals
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FarmerSalesProposalPersistence getPersistence() {
		return _persistence;
	}

	private static volatile FarmerSalesProposalPersistence _persistence;

}