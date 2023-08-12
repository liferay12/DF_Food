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

package bd.gov.dgfood.common.services.service.persistence;

import bd.gov.dgfood.common.services.model.Grievance;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the grievance service. This utility wraps <code>bd.gov.dgfood.common.services.service.persistence.impl.GrievancePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GrievancePersistence
 * @generated
 */
public class GrievanceUtil {

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
	public static void clearCache(Grievance grievance) {
		getPersistence().clearCache(grievance);
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
	public static Map<Serializable, Grievance> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Grievance> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Grievance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Grievance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Grievance> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Grievance update(Grievance grievance) {
		return getPersistence().update(grievance);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Grievance update(
		Grievance grievance, ServiceContext serviceContext) {

		return getPersistence().update(grievance, serviceContext);
	}

	/**
	 * Returns all the grievances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching grievances
	 */
	public static List<Grievance> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the grievances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrievanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of grievances
	 * @param end the upper bound of the range of grievances (not inclusive)
	 * @return the range of matching grievances
	 */
	public static List<Grievance> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the grievances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrievanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of grievances
	 * @param end the upper bound of the range of grievances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching grievances
	 */
	public static List<Grievance> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Grievance> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the grievances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrievanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of grievances
	 * @param end the upper bound of the range of grievances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching grievances
	 */
	public static List<Grievance> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Grievance> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first grievance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching grievance
	 * @throws NoSuchGrievanceException if a matching grievance could not be found
	 */
	public static Grievance findByUuid_First(
			String uuid, OrderByComparator<Grievance> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchGrievanceException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first grievance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching grievance, or <code>null</code> if a matching grievance could not be found
	 */
	public static Grievance fetchByUuid_First(
		String uuid, OrderByComparator<Grievance> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last grievance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching grievance
	 * @throws NoSuchGrievanceException if a matching grievance could not be found
	 */
	public static Grievance findByUuid_Last(
			String uuid, OrderByComparator<Grievance> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchGrievanceException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last grievance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching grievance, or <code>null</code> if a matching grievance could not be found
	 */
	public static Grievance fetchByUuid_Last(
		String uuid, OrderByComparator<Grievance> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the grievances before and after the current grievance in the ordered set where uuid = &#63;.
	 *
	 * @param grievanceId the primary key of the current grievance
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next grievance
	 * @throws NoSuchGrievanceException if a grievance with the primary key could not be found
	 */
	public static Grievance[] findByUuid_PrevAndNext(
			long grievanceId, String uuid,
			OrderByComparator<Grievance> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchGrievanceException {

		return getPersistence().findByUuid_PrevAndNext(
			grievanceId, uuid, orderByComparator);
	}

	/**
	 * Removes all the grievances where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of grievances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching grievances
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the grievance where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchGrievanceException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching grievance
	 * @throws NoSuchGrievanceException if a matching grievance could not be found
	 */
	public static Grievance findByUUID_G(String uuid, long groupId)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchGrievanceException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the grievance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching grievance, or <code>null</code> if a matching grievance could not be found
	 */
	public static Grievance fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the grievance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching grievance, or <code>null</code> if a matching grievance could not be found
	 */
	public static Grievance fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the grievance where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the grievance that was removed
	 */
	public static Grievance removeByUUID_G(String uuid, long groupId)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchGrievanceException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of grievances where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching grievances
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the grievances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching grievances
	 */
	public static List<Grievance> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the grievances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrievanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of grievances
	 * @param end the upper bound of the range of grievances (not inclusive)
	 * @return the range of matching grievances
	 */
	public static List<Grievance> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the grievances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrievanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of grievances
	 * @param end the upper bound of the range of grievances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching grievances
	 */
	public static List<Grievance> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Grievance> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the grievances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrievanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of grievances
	 * @param end the upper bound of the range of grievances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching grievances
	 */
	public static List<Grievance> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Grievance> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first grievance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching grievance
	 * @throws NoSuchGrievanceException if a matching grievance could not be found
	 */
	public static Grievance findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Grievance> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchGrievanceException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first grievance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching grievance, or <code>null</code> if a matching grievance could not be found
	 */
	public static Grievance fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Grievance> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last grievance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching grievance
	 * @throws NoSuchGrievanceException if a matching grievance could not be found
	 */
	public static Grievance findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Grievance> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchGrievanceException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last grievance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching grievance, or <code>null</code> if a matching grievance could not be found
	 */
	public static Grievance fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Grievance> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the grievances before and after the current grievance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param grievanceId the primary key of the current grievance
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next grievance
	 * @throws NoSuchGrievanceException if a grievance with the primary key could not be found
	 */
	public static Grievance[] findByUuid_C_PrevAndNext(
			long grievanceId, String uuid, long companyId,
			OrderByComparator<Grievance> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchGrievanceException {

		return getPersistence().findByUuid_C_PrevAndNext(
			grievanceId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the grievances where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of grievances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching grievances
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the grievance in the entity cache if it is enabled.
	 *
	 * @param grievance the grievance
	 */
	public static void cacheResult(Grievance grievance) {
		getPersistence().cacheResult(grievance);
	}

	/**
	 * Caches the grievances in the entity cache if it is enabled.
	 *
	 * @param grievances the grievances
	 */
	public static void cacheResult(List<Grievance> grievances) {
		getPersistence().cacheResult(grievances);
	}

	/**
	 * Creates a new grievance with the primary key. Does not add the grievance to the database.
	 *
	 * @param grievanceId the primary key for the new grievance
	 * @return the new grievance
	 */
	public static Grievance create(long grievanceId) {
		return getPersistence().create(grievanceId);
	}

	/**
	 * Removes the grievance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param grievanceId the primary key of the grievance
	 * @return the grievance that was removed
	 * @throws NoSuchGrievanceException if a grievance with the primary key could not be found
	 */
	public static Grievance remove(long grievanceId)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchGrievanceException {

		return getPersistence().remove(grievanceId);
	}

	public static Grievance updateImpl(Grievance grievance) {
		return getPersistence().updateImpl(grievance);
	}

	/**
	 * Returns the grievance with the primary key or throws a <code>NoSuchGrievanceException</code> if it could not be found.
	 *
	 * @param grievanceId the primary key of the grievance
	 * @return the grievance
	 * @throws NoSuchGrievanceException if a grievance with the primary key could not be found
	 */
	public static Grievance findByPrimaryKey(long grievanceId)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchGrievanceException {

		return getPersistence().findByPrimaryKey(grievanceId);
	}

	/**
	 * Returns the grievance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param grievanceId the primary key of the grievance
	 * @return the grievance, or <code>null</code> if a grievance with the primary key could not be found
	 */
	public static Grievance fetchByPrimaryKey(long grievanceId) {
		return getPersistence().fetchByPrimaryKey(grievanceId);
	}

	/**
	 * Returns all the grievances.
	 *
	 * @return the grievances
	 */
	public static List<Grievance> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the grievances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrievanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of grievances
	 * @param end the upper bound of the range of grievances (not inclusive)
	 * @return the range of grievances
	 */
	public static List<Grievance> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the grievances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrievanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of grievances
	 * @param end the upper bound of the range of grievances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of grievances
	 */
	public static List<Grievance> findAll(
		int start, int end, OrderByComparator<Grievance> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the grievances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrievanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of grievances
	 * @param end the upper bound of the range of grievances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of grievances
	 */
	public static List<Grievance> findAll(
		int start, int end, OrderByComparator<Grievance> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the grievances from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of grievances.
	 *
	 * @return the number of grievances
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static GrievancePersistence getPersistence() {
		return _persistence;
	}

	private static volatile GrievancePersistence _persistence;

}