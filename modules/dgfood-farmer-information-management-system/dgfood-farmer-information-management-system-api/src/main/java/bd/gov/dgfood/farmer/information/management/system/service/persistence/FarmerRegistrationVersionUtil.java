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

import bd.gov.dgfood.farmer.information.management.system.model.FarmerRegistrationVersion;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the farmer registration version service. This utility wraps <code>bd.gov.dgfood.farmer.information.management.system.service.persistence.impl.FarmerRegistrationVersionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FarmerRegistrationVersionPersistence
 * @generated
 */
public class FarmerRegistrationVersionUtil {

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
	public static void clearCache(
		FarmerRegistrationVersion farmerRegistrationVersion) {

		getPersistence().clearCache(farmerRegistrationVersion);
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
	public static Map<Serializable, FarmerRegistrationVersion>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FarmerRegistrationVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FarmerRegistrationVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FarmerRegistrationVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FarmerRegistrationVersion update(
		FarmerRegistrationVersion farmerRegistrationVersion) {

		return getPersistence().update(farmerRegistrationVersion);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FarmerRegistrationVersion update(
		FarmerRegistrationVersion farmerRegistrationVersion,
		ServiceContext serviceContext) {

		return getPersistence().update(
			farmerRegistrationVersion, serviceContext);
	}

	/**
	 * Returns all the farmer registration versions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching farmer registration versions
	 */
	public static List<FarmerRegistrationVersion> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<FarmerRegistrationVersion> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<FarmerRegistrationVersion> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<FarmerRegistrationVersion> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first farmer registration version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	public static FarmerRegistrationVersion findByUuid_First(
			String uuid,
			OrderByComparator<FarmerRegistrationVersion> orderByComparator)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationVersionException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first farmer registration version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	public static FarmerRegistrationVersion fetchByUuid_First(
		String uuid,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last farmer registration version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	public static FarmerRegistrationVersion findByUuid_Last(
			String uuid,
			OrderByComparator<FarmerRegistrationVersion> orderByComparator)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationVersionException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last farmer registration version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	public static FarmerRegistrationVersion fetchByUuid_Last(
		String uuid,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the farmer registration versions before and after the current farmer registration version in the ordered set where uuid = &#63;.
	 *
	 * @param farmerRegistrationVersionId the primary key of the current farmer registration version
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a farmer registration version with the primary key could not be found
	 */
	public static FarmerRegistrationVersion[] findByUuid_PrevAndNext(
			long farmerRegistrationVersionId, String uuid,
			OrderByComparator<FarmerRegistrationVersion> orderByComparator)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationVersionException {

		return getPersistence().findByUuid_PrevAndNext(
			farmerRegistrationVersionId, uuid, orderByComparator);
	}

	/**
	 * Removes all the farmer registration versions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of farmer registration versions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching farmer registration versions
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the farmer registration version where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFarmerRegistrationVersionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	public static FarmerRegistrationVersion findByUUID_G(
			String uuid, long groupId)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationVersionException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the farmer registration version where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	public static FarmerRegistrationVersion fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the farmer registration version where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	public static FarmerRegistrationVersion fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the farmer registration version where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the farmer registration version that was removed
	 */
	public static FarmerRegistrationVersion removeByUUID_G(
			String uuid, long groupId)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationVersionException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of farmer registration versions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching farmer registration versions
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the farmer registration versions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching farmer registration versions
	 */
	public static List<FarmerRegistrationVersion> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<FarmerRegistrationVersion> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<FarmerRegistrationVersion> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<FarmerRegistrationVersion> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first farmer registration version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	public static FarmerRegistrationVersion findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FarmerRegistrationVersion> orderByComparator)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationVersionException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first farmer registration version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	public static FarmerRegistrationVersion fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last farmer registration version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	public static FarmerRegistrationVersion findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FarmerRegistrationVersion> orderByComparator)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationVersionException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last farmer registration version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	public static FarmerRegistrationVersion fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static FarmerRegistrationVersion[] findByUuid_C_PrevAndNext(
			long farmerRegistrationVersionId, String uuid, long companyId,
			OrderByComparator<FarmerRegistrationVersion> orderByComparator)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationVersionException {

		return getPersistence().findByUuid_C_PrevAndNext(
			farmerRegistrationVersionId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the farmer registration versions where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of farmer registration versions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching farmer registration versions
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the farmer registration versions where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching farmer registration versions
	 */
	public static List<FarmerRegistrationVersion> findByNationalId(
		String nationalId) {

		return getPersistence().findByNationalId(nationalId);
	}

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
	public static List<FarmerRegistrationVersion> findByNationalId(
		String nationalId, int start, int end) {

		return getPersistence().findByNationalId(nationalId, start, end);
	}

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
	public static List<FarmerRegistrationVersion> findByNationalId(
		String nationalId, int start, int end,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		return getPersistence().findByNationalId(
			nationalId, start, end, orderByComparator);
	}

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
	public static List<FarmerRegistrationVersion> findByNationalId(
		String nationalId, int start, int end,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByNationalId(
			nationalId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first farmer registration version in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	public static FarmerRegistrationVersion findByNationalId_First(
			String nationalId,
			OrderByComparator<FarmerRegistrationVersion> orderByComparator)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationVersionException {

		return getPersistence().findByNationalId_First(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the first farmer registration version in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	public static FarmerRegistrationVersion fetchByNationalId_First(
		String nationalId,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		return getPersistence().fetchByNationalId_First(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the last farmer registration version in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	public static FarmerRegistrationVersion findByNationalId_Last(
			String nationalId,
			OrderByComparator<FarmerRegistrationVersion> orderByComparator)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationVersionException {

		return getPersistence().findByNationalId_Last(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the last farmer registration version in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	public static FarmerRegistrationVersion fetchByNationalId_Last(
		String nationalId,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		return getPersistence().fetchByNationalId_Last(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the farmer registration versions before and after the current farmer registration version in the ordered set where nationalId = &#63;.
	 *
	 * @param farmerRegistrationVersionId the primary key of the current farmer registration version
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a farmer registration version with the primary key could not be found
	 */
	public static FarmerRegistrationVersion[] findByNationalId_PrevAndNext(
			long farmerRegistrationVersionId, String nationalId,
			OrderByComparator<FarmerRegistrationVersion> orderByComparator)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationVersionException {

		return getPersistence().findByNationalId_PrevAndNext(
			farmerRegistrationVersionId, nationalId, orderByComparator);
	}

	/**
	 * Removes all the farmer registration versions where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	public static void removeByNationalId(String nationalId) {
		getPersistence().removeByNationalId(nationalId);
	}

	/**
	 * Returns the number of farmer registration versions where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching farmer registration versions
	 */
	public static int countByNationalId(String nationalId) {
		return getPersistence().countByNationalId(nationalId);
	}

	/**
	 * Returns all the farmer registration versions where applicationNumber = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @return the matching farmer registration versions
	 */
	public static List<FarmerRegistrationVersion> findByApplicationNumber(
		String applicationNumber) {

		return getPersistence().findByApplicationNumber(applicationNumber);
	}

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
	public static List<FarmerRegistrationVersion> findByApplicationNumber(
		String applicationNumber, int start, int end) {

		return getPersistence().findByApplicationNumber(
			applicationNumber, start, end);
	}

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
	public static List<FarmerRegistrationVersion> findByApplicationNumber(
		String applicationNumber, int start, int end,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		return getPersistence().findByApplicationNumber(
			applicationNumber, start, end, orderByComparator);
	}

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
	public static List<FarmerRegistrationVersion> findByApplicationNumber(
		String applicationNumber, int start, int end,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByApplicationNumber(
			applicationNumber, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first farmer registration version in the ordered set where applicationNumber = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	public static FarmerRegistrationVersion findByApplicationNumber_First(
			String applicationNumber,
			OrderByComparator<FarmerRegistrationVersion> orderByComparator)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationVersionException {

		return getPersistence().findByApplicationNumber_First(
			applicationNumber, orderByComparator);
	}

	/**
	 * Returns the first farmer registration version in the ordered set where applicationNumber = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	public static FarmerRegistrationVersion fetchByApplicationNumber_First(
		String applicationNumber,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		return getPersistence().fetchByApplicationNumber_First(
			applicationNumber, orderByComparator);
	}

	/**
	 * Returns the last farmer registration version in the ordered set where applicationNumber = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	public static FarmerRegistrationVersion findByApplicationNumber_Last(
			String applicationNumber,
			OrderByComparator<FarmerRegistrationVersion> orderByComparator)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationVersionException {

		return getPersistence().findByApplicationNumber_Last(
			applicationNumber, orderByComparator);
	}

	/**
	 * Returns the last farmer registration version in the ordered set where applicationNumber = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	public static FarmerRegistrationVersion fetchByApplicationNumber_Last(
		String applicationNumber,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		return getPersistence().fetchByApplicationNumber_Last(
			applicationNumber, orderByComparator);
	}

	/**
	 * Returns the farmer registration versions before and after the current farmer registration version in the ordered set where applicationNumber = &#63;.
	 *
	 * @param farmerRegistrationVersionId the primary key of the current farmer registration version
	 * @param applicationNumber the application number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a farmer registration version with the primary key could not be found
	 */
	public static FarmerRegistrationVersion[]
			findByApplicationNumber_PrevAndNext(
				long farmerRegistrationVersionId, String applicationNumber,
				OrderByComparator<FarmerRegistrationVersion> orderByComparator)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationVersionException {

		return getPersistence().findByApplicationNumber_PrevAndNext(
			farmerRegistrationVersionId, applicationNumber, orderByComparator);
	}

	/**
	 * Removes all the farmer registration versions where applicationNumber = &#63; from the database.
	 *
	 * @param applicationNumber the application number
	 */
	public static void removeByApplicationNumber(String applicationNumber) {
		getPersistence().removeByApplicationNumber(applicationNumber);
	}

	/**
	 * Returns the number of farmer registration versions where applicationNumber = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @return the number of matching farmer registration versions
	 */
	public static int countByApplicationNumber(String applicationNumber) {
		return getPersistence().countByApplicationNumber(applicationNumber);
	}

	/**
	 * Returns all the farmer registration versions where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @return the matching farmer registration versions
	 */
	public static List<FarmerRegistrationVersion> findByBusinessCode(
		String businessCode) {

		return getPersistence().findByBusinessCode(businessCode);
	}

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
	public static List<FarmerRegistrationVersion> findByBusinessCode(
		String businessCode, int start, int end) {

		return getPersistence().findByBusinessCode(businessCode, start, end);
	}

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
	public static List<FarmerRegistrationVersion> findByBusinessCode(
		String businessCode, int start, int end,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		return getPersistence().findByBusinessCode(
			businessCode, start, end, orderByComparator);
	}

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
	public static List<FarmerRegistrationVersion> findByBusinessCode(
		String businessCode, int start, int end,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByBusinessCode(
			businessCode, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first farmer registration version in the ordered set where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	public static FarmerRegistrationVersion findByBusinessCode_First(
			String businessCode,
			OrderByComparator<FarmerRegistrationVersion> orderByComparator)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationVersionException {

		return getPersistence().findByBusinessCode_First(
			businessCode, orderByComparator);
	}

	/**
	 * Returns the first farmer registration version in the ordered set where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	public static FarmerRegistrationVersion fetchByBusinessCode_First(
		String businessCode,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		return getPersistence().fetchByBusinessCode_First(
			businessCode, orderByComparator);
	}

	/**
	 * Returns the last farmer registration version in the ordered set where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	public static FarmerRegistrationVersion findByBusinessCode_Last(
			String businessCode,
			OrderByComparator<FarmerRegistrationVersion> orderByComparator)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationVersionException {

		return getPersistence().findByBusinessCode_Last(
			businessCode, orderByComparator);
	}

	/**
	 * Returns the last farmer registration version in the ordered set where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	public static FarmerRegistrationVersion fetchByBusinessCode_Last(
		String businessCode,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		return getPersistence().fetchByBusinessCode_Last(
			businessCode, orderByComparator);
	}

	/**
	 * Returns the farmer registration versions before and after the current farmer registration version in the ordered set where businessCode = &#63;.
	 *
	 * @param farmerRegistrationVersionId the primary key of the current farmer registration version
	 * @param businessCode the business code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a farmer registration version with the primary key could not be found
	 */
	public static FarmerRegistrationVersion[] findByBusinessCode_PrevAndNext(
			long farmerRegistrationVersionId, String businessCode,
			OrderByComparator<FarmerRegistrationVersion> orderByComparator)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationVersionException {

		return getPersistence().findByBusinessCode_PrevAndNext(
			farmerRegistrationVersionId, businessCode, orderByComparator);
	}

	/**
	 * Removes all the farmer registration versions where businessCode = &#63; from the database.
	 *
	 * @param businessCode the business code
	 */
	public static void removeByBusinessCode(String businessCode) {
		getPersistence().removeByBusinessCode(businessCode);
	}

	/**
	 * Returns the number of farmer registration versions where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @return the number of matching farmer registration versions
	 */
	public static int countByBusinessCode(String businessCode) {
		return getPersistence().countByBusinessCode(businessCode);
	}

	/**
	 * Returns the farmer registration version where farmerRegistrationId = &#63; and version = &#63; or throws a <code>NoSuchFarmerRegistrationVersionException</code> if it could not be found.
	 *
	 * @param farmerRegistrationId the farmer registration ID
	 * @param version the version
	 * @return the matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	public static FarmerRegistrationVersion findByFarmerRegistrationId(
			long farmerRegistrationId, double version)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationVersionException {

		return getPersistence().findByFarmerRegistrationId(
			farmerRegistrationId, version);
	}

	/**
	 * Returns the farmer registration version where farmerRegistrationId = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param farmerRegistrationId the farmer registration ID
	 * @param version the version
	 * @return the matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	public static FarmerRegistrationVersion fetchByFarmerRegistrationId(
		long farmerRegistrationId, double version) {

		return getPersistence().fetchByFarmerRegistrationId(
			farmerRegistrationId, version);
	}

	/**
	 * Returns the farmer registration version where farmerRegistrationId = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param farmerRegistrationId the farmer registration ID
	 * @param version the version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	public static FarmerRegistrationVersion fetchByFarmerRegistrationId(
		long farmerRegistrationId, double version, boolean useFinderCache) {

		return getPersistence().fetchByFarmerRegistrationId(
			farmerRegistrationId, version, useFinderCache);
	}

	/**
	 * Removes the farmer registration version where farmerRegistrationId = &#63; and version = &#63; from the database.
	 *
	 * @param farmerRegistrationId the farmer registration ID
	 * @param version the version
	 * @return the farmer registration version that was removed
	 */
	public static FarmerRegistrationVersion removeByFarmerRegistrationId(
			long farmerRegistrationId, double version)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationVersionException {

		return getPersistence().removeByFarmerRegistrationId(
			farmerRegistrationId, version);
	}

	/**
	 * Returns the number of farmer registration versions where farmerRegistrationId = &#63; and version = &#63;.
	 *
	 * @param farmerRegistrationId the farmer registration ID
	 * @param version the version
	 * @return the number of matching farmer registration versions
	 */
	public static int countByFarmerRegistrationId(
		long farmerRegistrationId, double version) {

		return getPersistence().countByFarmerRegistrationId(
			farmerRegistrationId, version);
	}

	/**
	 * Caches the farmer registration version in the entity cache if it is enabled.
	 *
	 * @param farmerRegistrationVersion the farmer registration version
	 */
	public static void cacheResult(
		FarmerRegistrationVersion farmerRegistrationVersion) {

		getPersistence().cacheResult(farmerRegistrationVersion);
	}

	/**
	 * Caches the farmer registration versions in the entity cache if it is enabled.
	 *
	 * @param farmerRegistrationVersions the farmer registration versions
	 */
	public static void cacheResult(
		List<FarmerRegistrationVersion> farmerRegistrationVersions) {

		getPersistence().cacheResult(farmerRegistrationVersions);
	}

	/**
	 * Creates a new farmer registration version with the primary key. Does not add the farmer registration version to the database.
	 *
	 * @param farmerRegistrationVersionId the primary key for the new farmer registration version
	 * @return the new farmer registration version
	 */
	public static FarmerRegistrationVersion create(
		long farmerRegistrationVersionId) {

		return getPersistence().create(farmerRegistrationVersionId);
	}

	/**
	 * Removes the farmer registration version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param farmerRegistrationVersionId the primary key of the farmer registration version
	 * @return the farmer registration version that was removed
	 * @throws NoSuchFarmerRegistrationVersionException if a farmer registration version with the primary key could not be found
	 */
	public static FarmerRegistrationVersion remove(
			long farmerRegistrationVersionId)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationVersionException {

		return getPersistence().remove(farmerRegistrationVersionId);
	}

	public static FarmerRegistrationVersion updateImpl(
		FarmerRegistrationVersion farmerRegistrationVersion) {

		return getPersistence().updateImpl(farmerRegistrationVersion);
	}

	/**
	 * Returns the farmer registration version with the primary key or throws a <code>NoSuchFarmerRegistrationVersionException</code> if it could not be found.
	 *
	 * @param farmerRegistrationVersionId the primary key of the farmer registration version
	 * @return the farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a farmer registration version with the primary key could not be found
	 */
	public static FarmerRegistrationVersion findByPrimaryKey(
			long farmerRegistrationVersionId)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationVersionException {

		return getPersistence().findByPrimaryKey(farmerRegistrationVersionId);
	}

	/**
	 * Returns the farmer registration version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param farmerRegistrationVersionId the primary key of the farmer registration version
	 * @return the farmer registration version, or <code>null</code> if a farmer registration version with the primary key could not be found
	 */
	public static FarmerRegistrationVersion fetchByPrimaryKey(
		long farmerRegistrationVersionId) {

		return getPersistence().fetchByPrimaryKey(farmerRegistrationVersionId);
	}

	/**
	 * Returns all the farmer registration versions.
	 *
	 * @return the farmer registration versions
	 */
	public static List<FarmerRegistrationVersion> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<FarmerRegistrationVersion> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<FarmerRegistrationVersion> findAll(
		int start, int end,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<FarmerRegistrationVersion> findAll(
		int start, int end,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the farmer registration versions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of farmer registration versions.
	 *
	 * @return the number of farmer registration versions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FarmerRegistrationVersionPersistence getPersistence() {
		return _persistence;
	}

	private static volatile FarmerRegistrationVersionPersistence _persistence;

}