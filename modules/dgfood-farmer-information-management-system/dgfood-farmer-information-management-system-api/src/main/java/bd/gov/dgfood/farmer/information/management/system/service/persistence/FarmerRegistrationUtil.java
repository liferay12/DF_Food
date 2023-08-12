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

import bd.gov.dgfood.farmer.information.management.system.model.FarmerRegistration;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the farmer registration service. This utility wraps <code>bd.gov.dgfood.farmer.information.management.system.service.persistence.impl.FarmerRegistrationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FarmerRegistrationPersistence
 * @generated
 */
public class FarmerRegistrationUtil {

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
	public static void clearCache(FarmerRegistration farmerRegistration) {
		getPersistence().clearCache(farmerRegistration);
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
	public static Map<Serializable, FarmerRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FarmerRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FarmerRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FarmerRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FarmerRegistration> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FarmerRegistration update(
		FarmerRegistration farmerRegistration) {

		return getPersistence().update(farmerRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FarmerRegistration update(
		FarmerRegistration farmerRegistration, ServiceContext serviceContext) {

		return getPersistence().update(farmerRegistration, serviceContext);
	}

	/**
	 * Returns all the farmer registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching farmer registrations
	 */
	public static List<FarmerRegistration> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the farmer registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of farmer registrations
	 * @param end the upper bound of the range of farmer registrations (not inclusive)
	 * @return the range of matching farmer registrations
	 */
	public static List<FarmerRegistration> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the farmer registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of farmer registrations
	 * @param end the upper bound of the range of farmer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching farmer registrations
	 */
	public static List<FarmerRegistration> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FarmerRegistration> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the farmer registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of farmer registrations
	 * @param end the upper bound of the range of farmer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching farmer registrations
	 */
	public static List<FarmerRegistration> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FarmerRegistration> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first farmer registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	public static FarmerRegistration findByUuid_First(
			String uuid,
			OrderByComparator<FarmerRegistration> orderByComparator)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first farmer registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public static FarmerRegistration fetchByUuid_First(
		String uuid, OrderByComparator<FarmerRegistration> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last farmer registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	public static FarmerRegistration findByUuid_Last(
			String uuid,
			OrderByComparator<FarmerRegistration> orderByComparator)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last farmer registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public static FarmerRegistration fetchByUuid_Last(
		String uuid, OrderByComparator<FarmerRegistration> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the farmer registrations before and after the current farmer registration in the ordered set where uuid = &#63;.
	 *
	 * @param farmerRegistrationId the primary key of the current farmer registration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next farmer registration
	 * @throws NoSuchFarmerRegistrationException if a farmer registration with the primary key could not be found
	 */
	public static FarmerRegistration[] findByUuid_PrevAndNext(
			long farmerRegistrationId, String uuid,
			OrderByComparator<FarmerRegistration> orderByComparator)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationException {

		return getPersistence().findByUuid_PrevAndNext(
			farmerRegistrationId, uuid, orderByComparator);
	}

	/**
	 * Removes all the farmer registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of farmer registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching farmer registrations
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the farmer registration where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFarmerRegistrationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	public static FarmerRegistration findByUUID_G(String uuid, long groupId)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the farmer registration where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public static FarmerRegistration fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the farmer registration where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public static FarmerRegistration fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the farmer registration where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the farmer registration that was removed
	 */
	public static FarmerRegistration removeByUUID_G(String uuid, long groupId)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of farmer registrations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching farmer registrations
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the farmer registrations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching farmer registrations
	 */
	public static List<FarmerRegistration> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the farmer registrations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of farmer registrations
	 * @param end the upper bound of the range of farmer registrations (not inclusive)
	 * @return the range of matching farmer registrations
	 */
	public static List<FarmerRegistration> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the farmer registrations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of farmer registrations
	 * @param end the upper bound of the range of farmer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching farmer registrations
	 */
	public static List<FarmerRegistration> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FarmerRegistration> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the farmer registrations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of farmer registrations
	 * @param end the upper bound of the range of farmer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching farmer registrations
	 */
	public static List<FarmerRegistration> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FarmerRegistration> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first farmer registration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	public static FarmerRegistration findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FarmerRegistration> orderByComparator)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first farmer registration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public static FarmerRegistration fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FarmerRegistration> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last farmer registration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	public static FarmerRegistration findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FarmerRegistration> orderByComparator)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last farmer registration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public static FarmerRegistration fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FarmerRegistration> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the farmer registrations before and after the current farmer registration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param farmerRegistrationId the primary key of the current farmer registration
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next farmer registration
	 * @throws NoSuchFarmerRegistrationException if a farmer registration with the primary key could not be found
	 */
	public static FarmerRegistration[] findByUuid_C_PrevAndNext(
			long farmerRegistrationId, String uuid, long companyId,
			OrderByComparator<FarmerRegistration> orderByComparator)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationException {

		return getPersistence().findByUuid_C_PrevAndNext(
			farmerRegistrationId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the farmer registrations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of farmer registrations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching farmer registrations
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the farmer registration where nationalId = &#63; or throws a <code>NoSuchFarmerRegistrationException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	public static FarmerRegistration findByNationalId(String nationalId)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationException {

		return getPersistence().findByNationalId(nationalId);
	}

	/**
	 * Returns the farmer registration where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public static FarmerRegistration fetchByNationalId(String nationalId) {
		return getPersistence().fetchByNationalId(nationalId);
	}

	/**
	 * Returns the farmer registration where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public static FarmerRegistration fetchByNationalId(
		String nationalId, boolean useFinderCache) {

		return getPersistence().fetchByNationalId(nationalId, useFinderCache);
	}

	/**
	 * Removes the farmer registration where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the farmer registration that was removed
	 */
	public static FarmerRegistration removeByNationalId(String nationalId)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationException {

		return getPersistence().removeByNationalId(nationalId);
	}

	/**
	 * Returns the number of farmer registrations where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching farmer registrations
	 */
	public static int countByNationalId(String nationalId) {
		return getPersistence().countByNationalId(nationalId);
	}

	/**
	 * Returns the farmer registration where applicationNumber = &#63; or throws a <code>NoSuchFarmerRegistrationException</code> if it could not be found.
	 *
	 * @param applicationNumber the application number
	 * @return the matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	public static FarmerRegistration findByApplicationNumber(
			String applicationNumber)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationException {

		return getPersistence().findByApplicationNumber(applicationNumber);
	}

	/**
	 * Returns the farmer registration where applicationNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public static FarmerRegistration fetchByApplicationNumber(
		String applicationNumber) {

		return getPersistence().fetchByApplicationNumber(applicationNumber);
	}

	/**
	 * Returns the farmer registration where applicationNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public static FarmerRegistration fetchByApplicationNumber(
		String applicationNumber, boolean useFinderCache) {

		return getPersistence().fetchByApplicationNumber(
			applicationNumber, useFinderCache);
	}

	/**
	 * Removes the farmer registration where applicationNumber = &#63; from the database.
	 *
	 * @param applicationNumber the application number
	 * @return the farmer registration that was removed
	 */
	public static FarmerRegistration removeByApplicationNumber(
			String applicationNumber)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationException {

		return getPersistence().removeByApplicationNumber(applicationNumber);
	}

	/**
	 * Returns the number of farmer registrations where applicationNumber = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @return the number of matching farmer registrations
	 */
	public static int countByApplicationNumber(String applicationNumber) {
		return getPersistence().countByApplicationNumber(applicationNumber);
	}

	/**
	 * Returns the farmer registration where applicationNumber = &#63; and dateOfBirth = &#63; or throws a <code>NoSuchFarmerRegistrationException</code> if it could not be found.
	 *
	 * @param applicationNumber the application number
	 * @param dateOfBirth the date of birth
	 * @return the matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	public static FarmerRegistration findByApplicationNumberDob(
			String applicationNumber, Date dateOfBirth)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationException {

		return getPersistence().findByApplicationNumberDob(
			applicationNumber, dateOfBirth);
	}

	/**
	 * Returns the farmer registration where applicationNumber = &#63; and dateOfBirth = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @param dateOfBirth the date of birth
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public static FarmerRegistration fetchByApplicationNumberDob(
		String applicationNumber, Date dateOfBirth) {

		return getPersistence().fetchByApplicationNumberDob(
			applicationNumber, dateOfBirth);
	}

	/**
	 * Returns the farmer registration where applicationNumber = &#63; and dateOfBirth = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @param dateOfBirth the date of birth
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public static FarmerRegistration fetchByApplicationNumberDob(
		String applicationNumber, Date dateOfBirth, boolean useFinderCache) {

		return getPersistence().fetchByApplicationNumberDob(
			applicationNumber, dateOfBirth, useFinderCache);
	}

	/**
	 * Removes the farmer registration where applicationNumber = &#63; and dateOfBirth = &#63; from the database.
	 *
	 * @param applicationNumber the application number
	 * @param dateOfBirth the date of birth
	 * @return the farmer registration that was removed
	 */
	public static FarmerRegistration removeByApplicationNumberDob(
			String applicationNumber, Date dateOfBirth)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationException {

		return getPersistence().removeByApplicationNumberDob(
			applicationNumber, dateOfBirth);
	}

	/**
	 * Returns the number of farmer registrations where applicationNumber = &#63; and dateOfBirth = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @param dateOfBirth the date of birth
	 * @return the number of matching farmer registrations
	 */
	public static int countByApplicationNumberDob(
		String applicationNumber, Date dateOfBirth) {

		return getPersistence().countByApplicationNumberDob(
			applicationNumber, dateOfBirth);
	}

	/**
	 * Returns the farmer registration where nationalId = &#63; and dateOfBirth = &#63; or throws a <code>NoSuchFarmerRegistrationException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @param dateOfBirth the date of birth
	 * @return the matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	public static FarmerRegistration findByNationalIdDob(
			String nationalId, Date dateOfBirth)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationException {

		return getPersistence().findByNationalIdDob(nationalId, dateOfBirth);
	}

	/**
	 * Returns the farmer registration where nationalId = &#63; and dateOfBirth = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param dateOfBirth the date of birth
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public static FarmerRegistration fetchByNationalIdDob(
		String nationalId, Date dateOfBirth) {

		return getPersistence().fetchByNationalIdDob(nationalId, dateOfBirth);
	}

	/**
	 * Returns the farmer registration where nationalId = &#63; and dateOfBirth = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param dateOfBirth the date of birth
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public static FarmerRegistration fetchByNationalIdDob(
		String nationalId, Date dateOfBirth, boolean useFinderCache) {

		return getPersistence().fetchByNationalIdDob(
			nationalId, dateOfBirth, useFinderCache);
	}

	/**
	 * Removes the farmer registration where nationalId = &#63; and dateOfBirth = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @param dateOfBirth the date of birth
	 * @return the farmer registration that was removed
	 */
	public static FarmerRegistration removeByNationalIdDob(
			String nationalId, Date dateOfBirth)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationException {

		return getPersistence().removeByNationalIdDob(nationalId, dateOfBirth);
	}

	/**
	 * Returns the number of farmer registrations where nationalId = &#63; and dateOfBirth = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param dateOfBirth the date of birth
	 * @return the number of matching farmer registrations
	 */
	public static int countByNationalIdDob(
		String nationalId, Date dateOfBirth) {

		return getPersistence().countByNationalIdDob(nationalId, dateOfBirth);
	}

	/**
	 * Returns the farmer registration where krishokCardNumber = &#63; or throws a <code>NoSuchFarmerRegistrationException</code> if it could not be found.
	 *
	 * @param krishokCardNumber the krishok card number
	 * @return the matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	public static FarmerRegistration findByKrishokCard(String krishokCardNumber)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationException {

		return getPersistence().findByKrishokCard(krishokCardNumber);
	}

	/**
	 * Returns the farmer registration where krishokCardNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param krishokCardNumber the krishok card number
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public static FarmerRegistration fetchByKrishokCard(
		String krishokCardNumber) {

		return getPersistence().fetchByKrishokCard(krishokCardNumber);
	}

	/**
	 * Returns the farmer registration where krishokCardNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param krishokCardNumber the krishok card number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public static FarmerRegistration fetchByKrishokCard(
		String krishokCardNumber, boolean useFinderCache) {

		return getPersistence().fetchByKrishokCard(
			krishokCardNumber, useFinderCache);
	}

	/**
	 * Removes the farmer registration where krishokCardNumber = &#63; from the database.
	 *
	 * @param krishokCardNumber the krishok card number
	 * @return the farmer registration that was removed
	 */
	public static FarmerRegistration removeByKrishokCard(
			String krishokCardNumber)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationException {

		return getPersistence().removeByKrishokCard(krishokCardNumber);
	}

	/**
	 * Returns the number of farmer registrations where krishokCardNumber = &#63;.
	 *
	 * @param krishokCardNumber the krishok card number
	 * @return the number of matching farmer registrations
	 */
	public static int countByKrishokCard(String krishokCardNumber) {
		return getPersistence().countByKrishokCard(krishokCardNumber);
	}

	/**
	 * Returns the farmer registration where businessCode = &#63; or throws a <code>NoSuchFarmerRegistrationException</code> if it could not be found.
	 *
	 * @param businessCode the business code
	 * @return the matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	public static FarmerRegistration findByBusinessCode(String businessCode)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationException {

		return getPersistence().findByBusinessCode(businessCode);
	}

	/**
	 * Returns the farmer registration where businessCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param businessCode the business code
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public static FarmerRegistration fetchByBusinessCode(String businessCode) {
		return getPersistence().fetchByBusinessCode(businessCode);
	}

	/**
	 * Returns the farmer registration where businessCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param businessCode the business code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public static FarmerRegistration fetchByBusinessCode(
		String businessCode, boolean useFinderCache) {

		return getPersistence().fetchByBusinessCode(
			businessCode, useFinderCache);
	}

	/**
	 * Removes the farmer registration where businessCode = &#63; from the database.
	 *
	 * @param businessCode the business code
	 * @return the farmer registration that was removed
	 */
	public static FarmerRegistration removeByBusinessCode(String businessCode)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationException {

		return getPersistence().removeByBusinessCode(businessCode);
	}

	/**
	 * Returns the number of farmer registrations where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @return the number of matching farmer registrations
	 */
	public static int countByBusinessCode(String businessCode) {
		return getPersistence().countByBusinessCode(businessCode);
	}

	/**
	 * Returns the farmer registration where userId = &#63; or throws a <code>NoSuchFarmerRegistrationException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	public static FarmerRegistration findByUserId(long userId)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationException {

		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns the farmer registration where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public static FarmerRegistration fetchByUserId(long userId) {
		return getPersistence().fetchByUserId(userId);
	}

	/**
	 * Returns the farmer registration where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public static FarmerRegistration fetchByUserId(
		long userId, boolean useFinderCache) {

		return getPersistence().fetchByUserId(userId, useFinderCache);
	}

	/**
	 * Removes the farmer registration where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the farmer registration that was removed
	 */
	public static FarmerRegistration removeByUserId(long userId)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationException {

		return getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of farmer registrations where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching farmer registrations
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Caches the farmer registration in the entity cache if it is enabled.
	 *
	 * @param farmerRegistration the farmer registration
	 */
	public static void cacheResult(FarmerRegistration farmerRegistration) {
		getPersistence().cacheResult(farmerRegistration);
	}

	/**
	 * Caches the farmer registrations in the entity cache if it is enabled.
	 *
	 * @param farmerRegistrations the farmer registrations
	 */
	public static void cacheResult(
		List<FarmerRegistration> farmerRegistrations) {

		getPersistence().cacheResult(farmerRegistrations);
	}

	/**
	 * Creates a new farmer registration with the primary key. Does not add the farmer registration to the database.
	 *
	 * @param farmerRegistrationId the primary key for the new farmer registration
	 * @return the new farmer registration
	 */
	public static FarmerRegistration create(long farmerRegistrationId) {
		return getPersistence().create(farmerRegistrationId);
	}

	/**
	 * Removes the farmer registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param farmerRegistrationId the primary key of the farmer registration
	 * @return the farmer registration that was removed
	 * @throws NoSuchFarmerRegistrationException if a farmer registration with the primary key could not be found
	 */
	public static FarmerRegistration remove(long farmerRegistrationId)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationException {

		return getPersistence().remove(farmerRegistrationId);
	}

	public static FarmerRegistration updateImpl(
		FarmerRegistration farmerRegistration) {

		return getPersistence().updateImpl(farmerRegistration);
	}

	/**
	 * Returns the farmer registration with the primary key or throws a <code>NoSuchFarmerRegistrationException</code> if it could not be found.
	 *
	 * @param farmerRegistrationId the primary key of the farmer registration
	 * @return the farmer registration
	 * @throws NoSuchFarmerRegistrationException if a farmer registration with the primary key could not be found
	 */
	public static FarmerRegistration findByPrimaryKey(long farmerRegistrationId)
		throws bd.gov.dgfood.farmer.information.management.system.exception.
			NoSuchFarmerRegistrationException {

		return getPersistence().findByPrimaryKey(farmerRegistrationId);
	}

	/**
	 * Returns the farmer registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param farmerRegistrationId the primary key of the farmer registration
	 * @return the farmer registration, or <code>null</code> if a farmer registration with the primary key could not be found
	 */
	public static FarmerRegistration fetchByPrimaryKey(
		long farmerRegistrationId) {

		return getPersistence().fetchByPrimaryKey(farmerRegistrationId);
	}

	/**
	 * Returns all the farmer registrations.
	 *
	 * @return the farmer registrations
	 */
	public static List<FarmerRegistration> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the farmer registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of farmer registrations
	 * @param end the upper bound of the range of farmer registrations (not inclusive)
	 * @return the range of farmer registrations
	 */
	public static List<FarmerRegistration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the farmer registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of farmer registrations
	 * @param end the upper bound of the range of farmer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of farmer registrations
	 */
	public static List<FarmerRegistration> findAll(
		int start, int end,
		OrderByComparator<FarmerRegistration> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the farmer registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of farmer registrations
	 * @param end the upper bound of the range of farmer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of farmer registrations
	 */
	public static List<FarmerRegistration> findAll(
		int start, int end,
		OrderByComparator<FarmerRegistration> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the farmer registrations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of farmer registrations.
	 *
	 * @return the number of farmer registrations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FarmerRegistrationPersistence getPersistence() {
		return _persistence;
	}

	private static volatile FarmerRegistrationPersistence _persistence;

}