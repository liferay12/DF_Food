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

import bd.gov.dgfood.farmer.information.management.system.exception.NoSuchFarmerSalesProposalException;
import bd.gov.dgfood.farmer.information.management.system.model.FarmerSalesProposal;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the farmer sales proposal service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FarmerSalesProposalUtil
 * @generated
 */
@ProviderType
public interface FarmerSalesProposalPersistence
	extends BasePersistence<FarmerSalesProposal> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FarmerSalesProposalUtil} to access the farmer sales proposal persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the farmer sales proposals where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching farmer sales proposals
	 */
	public java.util.List<FarmerSalesProposal> findByUuid(String uuid);

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
	public java.util.List<FarmerSalesProposal> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<FarmerSalesProposal> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FarmerSalesProposal>
			orderByComparator);

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
	public java.util.List<FarmerSalesProposal> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FarmerSalesProposal>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first farmer sales proposal in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a matching farmer sales proposal could not be found
	 */
	public FarmerSalesProposal findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<FarmerSalesProposal> orderByComparator)
		throws NoSuchFarmerSalesProposalException;

	/**
	 * Returns the first farmer sales proposal in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer sales proposal, or <code>null</code> if a matching farmer sales proposal could not be found
	 */
	public FarmerSalesProposal fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FarmerSalesProposal>
			orderByComparator);

	/**
	 * Returns the last farmer sales proposal in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a matching farmer sales proposal could not be found
	 */
	public FarmerSalesProposal findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<FarmerSalesProposal> orderByComparator)
		throws NoSuchFarmerSalesProposalException;

	/**
	 * Returns the last farmer sales proposal in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer sales proposal, or <code>null</code> if a matching farmer sales proposal could not be found
	 */
	public FarmerSalesProposal fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FarmerSalesProposal>
			orderByComparator);

	/**
	 * Returns the farmer sales proposals before and after the current farmer sales proposal in the ordered set where uuid = &#63;.
	 *
	 * @param farmerSalesProposalId the primary key of the current farmer sales proposal
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a farmer sales proposal with the primary key could not be found
	 */
	public FarmerSalesProposal[] findByUuid_PrevAndNext(
			long farmerSalesProposalId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<FarmerSalesProposal> orderByComparator)
		throws NoSuchFarmerSalesProposalException;

	/**
	 * Removes all the farmer sales proposals where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of farmer sales proposals where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching farmer sales proposals
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the farmer sales proposal where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFarmerSalesProposalException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a matching farmer sales proposal could not be found
	 */
	public FarmerSalesProposal findByUUID_G(String uuid, long groupId)
		throws NoSuchFarmerSalesProposalException;

	/**
	 * Returns the farmer sales proposal where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching farmer sales proposal, or <code>null</code> if a matching farmer sales proposal could not be found
	 */
	public FarmerSalesProposal fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the farmer sales proposal where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer sales proposal, or <code>null</code> if a matching farmer sales proposal could not be found
	 */
	public FarmerSalesProposal fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the farmer sales proposal where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the farmer sales proposal that was removed
	 */
	public FarmerSalesProposal removeByUUID_G(String uuid, long groupId)
		throws NoSuchFarmerSalesProposalException;

	/**
	 * Returns the number of farmer sales proposals where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching farmer sales proposals
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the farmer sales proposals where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching farmer sales proposals
	 */
	public java.util.List<FarmerSalesProposal> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<FarmerSalesProposal> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<FarmerSalesProposal> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FarmerSalesProposal>
			orderByComparator);

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
	public java.util.List<FarmerSalesProposal> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FarmerSalesProposal>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first farmer sales proposal in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a matching farmer sales proposal could not be found
	 */
	public FarmerSalesProposal findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FarmerSalesProposal> orderByComparator)
		throws NoSuchFarmerSalesProposalException;

	/**
	 * Returns the first farmer sales proposal in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer sales proposal, or <code>null</code> if a matching farmer sales proposal could not be found
	 */
	public FarmerSalesProposal fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FarmerSalesProposal>
			orderByComparator);

	/**
	 * Returns the last farmer sales proposal in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a matching farmer sales proposal could not be found
	 */
	public FarmerSalesProposal findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FarmerSalesProposal> orderByComparator)
		throws NoSuchFarmerSalesProposalException;

	/**
	 * Returns the last farmer sales proposal in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer sales proposal, or <code>null</code> if a matching farmer sales proposal could not be found
	 */
	public FarmerSalesProposal fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FarmerSalesProposal>
			orderByComparator);

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
	public FarmerSalesProposal[] findByUuid_C_PrevAndNext(
			long farmerSalesProposalId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FarmerSalesProposal> orderByComparator)
		throws NoSuchFarmerSalesProposalException;

	/**
	 * Removes all the farmer sales proposals where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of farmer sales proposals where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching farmer sales proposals
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the farmer sales proposals where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @return the matching farmer sales proposals
	 */
	public java.util.List<FarmerSalesProposal> findByBusinessCode(
		String businessCode);

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
	public java.util.List<FarmerSalesProposal> findByBusinessCode(
		String businessCode, int start, int end);

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
	public java.util.List<FarmerSalesProposal> findByBusinessCode(
		String businessCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FarmerSalesProposal>
			orderByComparator);

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
	public java.util.List<FarmerSalesProposal> findByBusinessCode(
		String businessCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FarmerSalesProposal>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first farmer sales proposal in the ordered set where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a matching farmer sales proposal could not be found
	 */
	public FarmerSalesProposal findByBusinessCode_First(
			String businessCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<FarmerSalesProposal> orderByComparator)
		throws NoSuchFarmerSalesProposalException;

	/**
	 * Returns the first farmer sales proposal in the ordered set where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer sales proposal, or <code>null</code> if a matching farmer sales proposal could not be found
	 */
	public FarmerSalesProposal fetchByBusinessCode_First(
		String businessCode,
		com.liferay.portal.kernel.util.OrderByComparator<FarmerSalesProposal>
			orderByComparator);

	/**
	 * Returns the last farmer sales proposal in the ordered set where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a matching farmer sales proposal could not be found
	 */
	public FarmerSalesProposal findByBusinessCode_Last(
			String businessCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<FarmerSalesProposal> orderByComparator)
		throws NoSuchFarmerSalesProposalException;

	/**
	 * Returns the last farmer sales proposal in the ordered set where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer sales proposal, or <code>null</code> if a matching farmer sales proposal could not be found
	 */
	public FarmerSalesProposal fetchByBusinessCode_Last(
		String businessCode,
		com.liferay.portal.kernel.util.OrderByComparator<FarmerSalesProposal>
			orderByComparator);

	/**
	 * Returns the farmer sales proposals before and after the current farmer sales proposal in the ordered set where businessCode = &#63;.
	 *
	 * @param farmerSalesProposalId the primary key of the current farmer sales proposal
	 * @param businessCode the business code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a farmer sales proposal with the primary key could not be found
	 */
	public FarmerSalesProposal[] findByBusinessCode_PrevAndNext(
			long farmerSalesProposalId, String businessCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<FarmerSalesProposal> orderByComparator)
		throws NoSuchFarmerSalesProposalException;

	/**
	 * Removes all the farmer sales proposals where businessCode = &#63; from the database.
	 *
	 * @param businessCode the business code
	 */
	public void removeByBusinessCode(String businessCode);

	/**
	 * Returns the number of farmer sales proposals where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @return the number of matching farmer sales proposals
	 */
	public int countByBusinessCode(String businessCode);

	/**
	 * Returns the farmer sales proposal where applicationNumber = &#63; or throws a <code>NoSuchFarmerSalesProposalException</code> if it could not be found.
	 *
	 * @param applicationNumber the application number
	 * @return the matching farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a matching farmer sales proposal could not be found
	 */
	public FarmerSalesProposal findByApplicationNumber(String applicationNumber)
		throws NoSuchFarmerSalesProposalException;

	/**
	 * Returns the farmer sales proposal where applicationNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @return the matching farmer sales proposal, or <code>null</code> if a matching farmer sales proposal could not be found
	 */
	public FarmerSalesProposal fetchByApplicationNumber(
		String applicationNumber);

	/**
	 * Returns the farmer sales proposal where applicationNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer sales proposal, or <code>null</code> if a matching farmer sales proposal could not be found
	 */
	public FarmerSalesProposal fetchByApplicationNumber(
		String applicationNumber, boolean useFinderCache);

	/**
	 * Removes the farmer sales proposal where applicationNumber = &#63; from the database.
	 *
	 * @param applicationNumber the application number
	 * @return the farmer sales proposal that was removed
	 */
	public FarmerSalesProposal removeByApplicationNumber(
			String applicationNumber)
		throws NoSuchFarmerSalesProposalException;

	/**
	 * Returns the number of farmer sales proposals where applicationNumber = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @return the number of matching farmer sales proposals
	 */
	public int countByApplicationNumber(String applicationNumber);

	/**
	 * Caches the farmer sales proposal in the entity cache if it is enabled.
	 *
	 * @param farmerSalesProposal the farmer sales proposal
	 */
	public void cacheResult(FarmerSalesProposal farmerSalesProposal);

	/**
	 * Caches the farmer sales proposals in the entity cache if it is enabled.
	 *
	 * @param farmerSalesProposals the farmer sales proposals
	 */
	public void cacheResult(
		java.util.List<FarmerSalesProposal> farmerSalesProposals);

	/**
	 * Creates a new farmer sales proposal with the primary key. Does not add the farmer sales proposal to the database.
	 *
	 * @param farmerSalesProposalId the primary key for the new farmer sales proposal
	 * @return the new farmer sales proposal
	 */
	public FarmerSalesProposal create(long farmerSalesProposalId);

	/**
	 * Removes the farmer sales proposal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param farmerSalesProposalId the primary key of the farmer sales proposal
	 * @return the farmer sales proposal that was removed
	 * @throws NoSuchFarmerSalesProposalException if a farmer sales proposal with the primary key could not be found
	 */
	public FarmerSalesProposal remove(long farmerSalesProposalId)
		throws NoSuchFarmerSalesProposalException;

	public FarmerSalesProposal updateImpl(
		FarmerSalesProposal farmerSalesProposal);

	/**
	 * Returns the farmer sales proposal with the primary key or throws a <code>NoSuchFarmerSalesProposalException</code> if it could not be found.
	 *
	 * @param farmerSalesProposalId the primary key of the farmer sales proposal
	 * @return the farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a farmer sales proposal with the primary key could not be found
	 */
	public FarmerSalesProposal findByPrimaryKey(long farmerSalesProposalId)
		throws NoSuchFarmerSalesProposalException;

	/**
	 * Returns the farmer sales proposal with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param farmerSalesProposalId the primary key of the farmer sales proposal
	 * @return the farmer sales proposal, or <code>null</code> if a farmer sales proposal with the primary key could not be found
	 */
	public FarmerSalesProposal fetchByPrimaryKey(long farmerSalesProposalId);

	/**
	 * Returns all the farmer sales proposals.
	 *
	 * @return the farmer sales proposals
	 */
	public java.util.List<FarmerSalesProposal> findAll();

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
	public java.util.List<FarmerSalesProposal> findAll(int start, int end);

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
	public java.util.List<FarmerSalesProposal> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FarmerSalesProposal>
			orderByComparator);

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
	public java.util.List<FarmerSalesProposal> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FarmerSalesProposal>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the farmer sales proposals from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of farmer sales proposals.
	 *
	 * @return the number of farmer sales proposals
	 */
	public int countAll();

}