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

import bd.gov.dgfood.farmer.information.management.system.exception.NoSuchFarmerRegistrationVersionException;
import bd.gov.dgfood.farmer.information.management.system.model.FarmerRegistrationVersion;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the farmer registration version service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FarmerRegistrationVersionUtil
 * @generated
 */
@ProviderType
public interface FarmerRegistrationVersionPersistence
	extends BasePersistence<FarmerRegistrationVersion> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FarmerRegistrationVersionUtil} to access the farmer registration version persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the farmer registration versions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching farmer registration versions
	 */
	public java.util.List<FarmerRegistrationVersion> findByUuid(String uuid);

	/**
	 * Returns a range of all the farmer registration versions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @return the range of matching farmer registration versions
	 */
	public java.util.List<FarmerRegistrationVersion> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the farmer registration versions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching farmer registration versions
	 */
	public java.util.List<FarmerRegistrationVersion> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<FarmerRegistrationVersion> orderByComparator);

	/**
	 * Returns an ordered range of all the farmer registration versions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching farmer registration versions
	 */
	public java.util.List<FarmerRegistrationVersion> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<FarmerRegistrationVersion> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first farmer registration version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	public FarmerRegistrationVersion findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<FarmerRegistrationVersion> orderByComparator)
		throws NoSuchFarmerRegistrationVersionException;

	/**
	 * Returns the first farmer registration version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	public FarmerRegistrationVersion fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<FarmerRegistrationVersion> orderByComparator);

	/**
	 * Returns the last farmer registration version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	public FarmerRegistrationVersion findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<FarmerRegistrationVersion> orderByComparator)
		throws NoSuchFarmerRegistrationVersionException;

	/**
	 * Returns the last farmer registration version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	public FarmerRegistrationVersion fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<FarmerRegistrationVersion> orderByComparator);

	/**
	 * Returns the farmer registration versions before and after the current farmer registration version in the ordered set where uuid = &#63;.
	 *
	 * @param farmerRegistrationVersionId the primary key of the current farmer registration version
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a farmer registration version with the primary key could not be found
	 */
	public FarmerRegistrationVersion[] findByUuid_PrevAndNext(
			long farmerRegistrationVersionId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<FarmerRegistrationVersion> orderByComparator)
		throws NoSuchFarmerRegistrationVersionException;

	/**
	 * Removes all the farmer registration versions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of farmer registration versions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching farmer registration versions
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the farmer registration version where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFarmerRegistrationVersionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	public FarmerRegistrationVersion findByUUID_G(String uuid, long groupId)
		throws NoSuchFarmerRegistrationVersionException;

	/**
	 * Returns the farmer registration version where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	public FarmerRegistrationVersion fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the farmer registration version where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	public FarmerRegistrationVersion fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the farmer registration version where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the farmer registration version that was removed
	 */
	public FarmerRegistrationVersion removeByUUID_G(String uuid, long groupId)
		throws NoSuchFarmerRegistrationVersionException;

	/**
	 * Returns the number of farmer registration versions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching farmer registration versions
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the farmer registration versions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching farmer registration versions
	 */
	public java.util.List<FarmerRegistrationVersion> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the farmer registration versions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @return the range of matching farmer registration versions
	 */
	public java.util.List<FarmerRegistrationVersion> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the farmer registration versions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching farmer registration versions
	 */
	public java.util.List<FarmerRegistrationVersion> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<FarmerRegistrationVersion> orderByComparator);

	/**
	 * Returns an ordered range of all the farmer registration versions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching farmer registration versions
	 */
	public java.util.List<FarmerRegistrationVersion> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<FarmerRegistrationVersion> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first farmer registration version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	public FarmerRegistrationVersion findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FarmerRegistrationVersion> orderByComparator)
		throws NoSuchFarmerRegistrationVersionException;

	/**
	 * Returns the first farmer registration version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	public FarmerRegistrationVersion fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<FarmerRegistrationVersion> orderByComparator);

	/**
	 * Returns the last farmer registration version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	public FarmerRegistrationVersion findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FarmerRegistrationVersion> orderByComparator)
		throws NoSuchFarmerRegistrationVersionException;

	/**
	 * Returns the last farmer registration version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	public FarmerRegistrationVersion fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<FarmerRegistrationVersion> orderByComparator);

	/**
	 * Returns the farmer registration versions before and after the current farmer registration version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param farmerRegistrationVersionId the primary key of the current farmer registration version
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a farmer registration version with the primary key could not be found
	 */
	public FarmerRegistrationVersion[] findByUuid_C_PrevAndNext(
			long farmerRegistrationVersionId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FarmerRegistrationVersion> orderByComparator)
		throws NoSuchFarmerRegistrationVersionException;

	/**
	 * Removes all the farmer registration versions where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of farmer registration versions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching farmer registration versions
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the farmer registration versions where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching farmer registration versions
	 */
	public java.util.List<FarmerRegistrationVersion> findByNationalId(
		String nationalId);

	/**
	 * Returns a range of all the farmer registration versions where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @return the range of matching farmer registration versions
	 */
	public java.util.List<FarmerRegistrationVersion> findByNationalId(
		String nationalId, int start, int end);

	/**
	 * Returns an ordered range of all the farmer registration versions where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching farmer registration versions
	 */
	public java.util.List<FarmerRegistrationVersion> findByNationalId(
		String nationalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<FarmerRegistrationVersion> orderByComparator);

	/**
	 * Returns an ordered range of all the farmer registration versions where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching farmer registration versions
	 */
	public java.util.List<FarmerRegistrationVersion> findByNationalId(
		String nationalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<FarmerRegistrationVersion> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first farmer registration version in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	public FarmerRegistrationVersion findByNationalId_First(
			String nationalId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FarmerRegistrationVersion> orderByComparator)
		throws NoSuchFarmerRegistrationVersionException;

	/**
	 * Returns the first farmer registration version in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	public FarmerRegistrationVersion fetchByNationalId_First(
		String nationalId,
		com.liferay.portal.kernel.util.OrderByComparator
			<FarmerRegistrationVersion> orderByComparator);

	/**
	 * Returns the last farmer registration version in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	public FarmerRegistrationVersion findByNationalId_Last(
			String nationalId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FarmerRegistrationVersion> orderByComparator)
		throws NoSuchFarmerRegistrationVersionException;

	/**
	 * Returns the last farmer registration version in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	public FarmerRegistrationVersion fetchByNationalId_Last(
		String nationalId,
		com.liferay.portal.kernel.util.OrderByComparator
			<FarmerRegistrationVersion> orderByComparator);

	/**
	 * Returns the farmer registration versions before and after the current farmer registration version in the ordered set where nationalId = &#63;.
	 *
	 * @param farmerRegistrationVersionId the primary key of the current farmer registration version
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a farmer registration version with the primary key could not be found
	 */
	public FarmerRegistrationVersion[] findByNationalId_PrevAndNext(
			long farmerRegistrationVersionId, String nationalId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FarmerRegistrationVersion> orderByComparator)
		throws NoSuchFarmerRegistrationVersionException;

	/**
	 * Removes all the farmer registration versions where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	public void removeByNationalId(String nationalId);

	/**
	 * Returns the number of farmer registration versions where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching farmer registration versions
	 */
	public int countByNationalId(String nationalId);

	/**
	 * Returns all the farmer registration versions where applicationNumber = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @return the matching farmer registration versions
	 */
	public java.util.List<FarmerRegistrationVersion> findByApplicationNumber(
		String applicationNumber);

	/**
	 * Returns a range of all the farmer registration versions where applicationNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param applicationNumber the application number
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @return the range of matching farmer registration versions
	 */
	public java.util.List<FarmerRegistrationVersion> findByApplicationNumber(
		String applicationNumber, int start, int end);

	/**
	 * Returns an ordered range of all the farmer registration versions where applicationNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param applicationNumber the application number
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching farmer registration versions
	 */
	public java.util.List<FarmerRegistrationVersion> findByApplicationNumber(
		String applicationNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<FarmerRegistrationVersion> orderByComparator);

	/**
	 * Returns an ordered range of all the farmer registration versions where applicationNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param applicationNumber the application number
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching farmer registration versions
	 */
	public java.util.List<FarmerRegistrationVersion> findByApplicationNumber(
		String applicationNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<FarmerRegistrationVersion> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first farmer registration version in the ordered set where applicationNumber = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	public FarmerRegistrationVersion findByApplicationNumber_First(
			String applicationNumber,
			com.liferay.portal.kernel.util.OrderByComparator
				<FarmerRegistrationVersion> orderByComparator)
		throws NoSuchFarmerRegistrationVersionException;

	/**
	 * Returns the first farmer registration version in the ordered set where applicationNumber = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	public FarmerRegistrationVersion fetchByApplicationNumber_First(
		String applicationNumber,
		com.liferay.portal.kernel.util.OrderByComparator
			<FarmerRegistrationVersion> orderByComparator);

	/**
	 * Returns the last farmer registration version in the ordered set where applicationNumber = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	public FarmerRegistrationVersion findByApplicationNumber_Last(
			String applicationNumber,
			com.liferay.portal.kernel.util.OrderByComparator
				<FarmerRegistrationVersion> orderByComparator)
		throws NoSuchFarmerRegistrationVersionException;

	/**
	 * Returns the last farmer registration version in the ordered set where applicationNumber = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	public FarmerRegistrationVersion fetchByApplicationNumber_Last(
		String applicationNumber,
		com.liferay.portal.kernel.util.OrderByComparator
			<FarmerRegistrationVersion> orderByComparator);

	/**
	 * Returns the farmer registration versions before and after the current farmer registration version in the ordered set where applicationNumber = &#63;.
	 *
	 * @param farmerRegistrationVersionId the primary key of the current farmer registration version
	 * @param applicationNumber the application number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a farmer registration version with the primary key could not be found
	 */
	public FarmerRegistrationVersion[] findByApplicationNumber_PrevAndNext(
			long farmerRegistrationVersionId, String applicationNumber,
			com.liferay.portal.kernel.util.OrderByComparator
				<FarmerRegistrationVersion> orderByComparator)
		throws NoSuchFarmerRegistrationVersionException;

	/**
	 * Removes all the farmer registration versions where applicationNumber = &#63; from the database.
	 *
	 * @param applicationNumber the application number
	 */
	public void removeByApplicationNumber(String applicationNumber);

	/**
	 * Returns the number of farmer registration versions where applicationNumber = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @return the number of matching farmer registration versions
	 */
	public int countByApplicationNumber(String applicationNumber);

	/**
	 * Returns all the farmer registration versions where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @return the matching farmer registration versions
	 */
	public java.util.List<FarmerRegistrationVersion> findByBusinessCode(
		String businessCode);

	/**
	 * Returns a range of all the farmer registration versions where businessCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param businessCode the business code
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @return the range of matching farmer registration versions
	 */
	public java.util.List<FarmerRegistrationVersion> findByBusinessCode(
		String businessCode, int start, int end);

	/**
	 * Returns an ordered range of all the farmer registration versions where businessCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param businessCode the business code
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching farmer registration versions
	 */
	public java.util.List<FarmerRegistrationVersion> findByBusinessCode(
		String businessCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<FarmerRegistrationVersion> orderByComparator);

	/**
	 * Returns an ordered range of all the farmer registration versions where businessCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param businessCode the business code
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching farmer registration versions
	 */
	public java.util.List<FarmerRegistrationVersion> findByBusinessCode(
		String businessCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<FarmerRegistrationVersion> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first farmer registration version in the ordered set where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	public FarmerRegistrationVersion findByBusinessCode_First(
			String businessCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<FarmerRegistrationVersion> orderByComparator)
		throws NoSuchFarmerRegistrationVersionException;

	/**
	 * Returns the first farmer registration version in the ordered set where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	public FarmerRegistrationVersion fetchByBusinessCode_First(
		String businessCode,
		com.liferay.portal.kernel.util.OrderByComparator
			<FarmerRegistrationVersion> orderByComparator);

	/**
	 * Returns the last farmer registration version in the ordered set where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	public FarmerRegistrationVersion findByBusinessCode_Last(
			String businessCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<FarmerRegistrationVersion> orderByComparator)
		throws NoSuchFarmerRegistrationVersionException;

	/**
	 * Returns the last farmer registration version in the ordered set where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	public FarmerRegistrationVersion fetchByBusinessCode_Last(
		String businessCode,
		com.liferay.portal.kernel.util.OrderByComparator
			<FarmerRegistrationVersion> orderByComparator);

	/**
	 * Returns the farmer registration versions before and after the current farmer registration version in the ordered set where businessCode = &#63;.
	 *
	 * @param farmerRegistrationVersionId the primary key of the current farmer registration version
	 * @param businessCode the business code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a farmer registration version with the primary key could not be found
	 */
	public FarmerRegistrationVersion[] findByBusinessCode_PrevAndNext(
			long farmerRegistrationVersionId, String businessCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<FarmerRegistrationVersion> orderByComparator)
		throws NoSuchFarmerRegistrationVersionException;

	/**
	 * Removes all the farmer registration versions where businessCode = &#63; from the database.
	 *
	 * @param businessCode the business code
	 */
	public void removeByBusinessCode(String businessCode);

	/**
	 * Returns the number of farmer registration versions where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @return the number of matching farmer registration versions
	 */
	public int countByBusinessCode(String businessCode);

	/**
	 * Returns the farmer registration version where farmerRegistrationId = &#63; and version = &#63; or throws a <code>NoSuchFarmerRegistrationVersionException</code> if it could not be found.
	 *
	 * @param farmerRegistrationId the farmer registration ID
	 * @param version the version
	 * @return the matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	public FarmerRegistrationVersion findByFarmerRegistrationId(
			long farmerRegistrationId, double version)
		throws NoSuchFarmerRegistrationVersionException;

	/**
	 * Returns the farmer registration version where farmerRegistrationId = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param farmerRegistrationId the farmer registration ID
	 * @param version the version
	 * @return the matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	public FarmerRegistrationVersion fetchByFarmerRegistrationId(
		long farmerRegistrationId, double version);

	/**
	 * Returns the farmer registration version where farmerRegistrationId = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param farmerRegistrationId the farmer registration ID
	 * @param version the version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	public FarmerRegistrationVersion fetchByFarmerRegistrationId(
		long farmerRegistrationId, double version, boolean useFinderCache);

	/**
	 * Removes the farmer registration version where farmerRegistrationId = &#63; and version = &#63; from the database.
	 *
	 * @param farmerRegistrationId the farmer registration ID
	 * @param version the version
	 * @return the farmer registration version that was removed
	 */
	public FarmerRegistrationVersion removeByFarmerRegistrationId(
			long farmerRegistrationId, double version)
		throws NoSuchFarmerRegistrationVersionException;

	/**
	 * Returns the number of farmer registration versions where farmerRegistrationId = &#63; and version = &#63;.
	 *
	 * @param farmerRegistrationId the farmer registration ID
	 * @param version the version
	 * @return the number of matching farmer registration versions
	 */
	public int countByFarmerRegistrationId(
		long farmerRegistrationId, double version);

	/**
	 * Caches the farmer registration version in the entity cache if it is enabled.
	 *
	 * @param farmerRegistrationVersion the farmer registration version
	 */
	public void cacheResult(
		FarmerRegistrationVersion farmerRegistrationVersion);

	/**
	 * Caches the farmer registration versions in the entity cache if it is enabled.
	 *
	 * @param farmerRegistrationVersions the farmer registration versions
	 */
	public void cacheResult(
		java.util.List<FarmerRegistrationVersion> farmerRegistrationVersions);

	/**
	 * Creates a new farmer registration version with the primary key. Does not add the farmer registration version to the database.
	 *
	 * @param farmerRegistrationVersionId the primary key for the new farmer registration version
	 * @return the new farmer registration version
	 */
	public FarmerRegistrationVersion create(long farmerRegistrationVersionId);

	/**
	 * Removes the farmer registration version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param farmerRegistrationVersionId the primary key of the farmer registration version
	 * @return the farmer registration version that was removed
	 * @throws NoSuchFarmerRegistrationVersionException if a farmer registration version with the primary key could not be found
	 */
	public FarmerRegistrationVersion remove(long farmerRegistrationVersionId)
		throws NoSuchFarmerRegistrationVersionException;

	public FarmerRegistrationVersion updateImpl(
		FarmerRegistrationVersion farmerRegistrationVersion);

	/**
	 * Returns the farmer registration version with the primary key or throws a <code>NoSuchFarmerRegistrationVersionException</code> if it could not be found.
	 *
	 * @param farmerRegistrationVersionId the primary key of the farmer registration version
	 * @return the farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a farmer registration version with the primary key could not be found
	 */
	public FarmerRegistrationVersion findByPrimaryKey(
			long farmerRegistrationVersionId)
		throws NoSuchFarmerRegistrationVersionException;

	/**
	 * Returns the farmer registration version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param farmerRegistrationVersionId the primary key of the farmer registration version
	 * @return the farmer registration version, or <code>null</code> if a farmer registration version with the primary key could not be found
	 */
	public FarmerRegistrationVersion fetchByPrimaryKey(
		long farmerRegistrationVersionId);

	/**
	 * Returns all the farmer registration versions.
	 *
	 * @return the farmer registration versions
	 */
	public java.util.List<FarmerRegistrationVersion> findAll();

	/**
	 * Returns a range of all the farmer registration versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @return the range of farmer registration versions
	 */
	public java.util.List<FarmerRegistrationVersion> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the farmer registration versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of farmer registration versions
	 */
	public java.util.List<FarmerRegistrationVersion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<FarmerRegistrationVersion> orderByComparator);

	/**
	 * Returns an ordered range of all the farmer registration versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of farmer registration versions
	 */
	public java.util.List<FarmerRegistrationVersion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<FarmerRegistrationVersion> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the farmer registration versions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of farmer registration versions.
	 *
	 * @return the number of farmer registration versions
	 */
	public int countAll();

}