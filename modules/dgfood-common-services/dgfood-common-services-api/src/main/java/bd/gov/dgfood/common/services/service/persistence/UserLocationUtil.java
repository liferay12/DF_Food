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

import bd.gov.dgfood.common.services.model.UserLocation;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the user location service. This utility wraps <code>bd.gov.dgfood.common.services.service.persistence.impl.UserLocationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserLocationPersistence
 * @generated
 */
public class UserLocationUtil {

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
	public static void clearCache(UserLocation userLocation) {
		getPersistence().clearCache(userLocation);
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
	public static Map<Serializable, UserLocation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserLocation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserLocation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserLocation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserLocation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserLocation update(UserLocation userLocation) {
		return getPersistence().update(userLocation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserLocation update(
		UserLocation userLocation, ServiceContext serviceContext) {

		return getPersistence().update(userLocation, serviceContext);
	}

	/**
	 * Returns all the user locations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user locations
	 */
	public static List<UserLocation> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the user locations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @return the range of matching user locations
	 */
	public static List<UserLocation> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the user locations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user locations
	 */
	public static List<UserLocation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserLocation> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user locations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user locations
	 */
	public static List<UserLocation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserLocation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user location in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	public static UserLocation findByUuid_First(
			String uuid, OrderByComparator<UserLocation> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchUserLocationException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first user location in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public static UserLocation fetchByUuid_First(
		String uuid, OrderByComparator<UserLocation> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last user location in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	public static UserLocation findByUuid_Last(
			String uuid, OrderByComparator<UserLocation> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchUserLocationException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last user location in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public static UserLocation fetchByUuid_Last(
		String uuid, OrderByComparator<UserLocation> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the user locations before and after the current user location in the ordered set where uuid = &#63;.
	 *
	 * @param userLocationId the primary key of the current user location
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user location
	 * @throws NoSuchUserLocationException if a user location with the primary key could not be found
	 */
	public static UserLocation[] findByUuid_PrevAndNext(
			long userLocationId, String uuid,
			OrderByComparator<UserLocation> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchUserLocationException {

		return getPersistence().findByUuid_PrevAndNext(
			userLocationId, uuid, orderByComparator);
	}

	/**
	 * Removes all the user locations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of user locations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user locations
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the user location where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchUserLocationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	public static UserLocation findByUUID_G(String uuid, long groupId)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchUserLocationException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the user location where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public static UserLocation fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the user location where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public static UserLocation fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the user location where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the user location that was removed
	 */
	public static UserLocation removeByUUID_G(String uuid, long groupId)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchUserLocationException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of user locations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching user locations
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the user locations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching user locations
	 */
	public static List<UserLocation> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the user locations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @return the range of matching user locations
	 */
	public static List<UserLocation> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the user locations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user locations
	 */
	public static List<UserLocation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UserLocation> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user locations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user locations
	 */
	public static List<UserLocation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UserLocation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user location in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	public static UserLocation findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<UserLocation> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchUserLocationException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first user location in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public static UserLocation fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<UserLocation> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last user location in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	public static UserLocation findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<UserLocation> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchUserLocationException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last user location in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public static UserLocation fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<UserLocation> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the user locations before and after the current user location in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param userLocationId the primary key of the current user location
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user location
	 * @throws NoSuchUserLocationException if a user location with the primary key could not be found
	 */
	public static UserLocation[] findByUuid_C_PrevAndNext(
			long userLocationId, String uuid, long companyId,
			OrderByComparator<UserLocation> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchUserLocationException {

		return getPersistence().findByUuid_C_PrevAndNext(
			userLocationId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the user locations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of user locations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching user locations
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the user locations where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching user locations
	 */
	public static List<UserLocation> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the user locations where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @return the range of matching user locations
	 */
	public static List<UserLocation> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the user locations where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user locations
	 */
	public static List<UserLocation> findByUserId(
		long userId, int start, int end,
		OrderByComparator<UserLocation> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user locations where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user locations
	 */
	public static List<UserLocation> findByUserId(
		long userId, int start, int end,
		OrderByComparator<UserLocation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user location in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	public static UserLocation findByUserId_First(
			long userId, OrderByComparator<UserLocation> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchUserLocationException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first user location in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public static UserLocation fetchByUserId_First(
		long userId, OrderByComparator<UserLocation> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last user location in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	public static UserLocation findByUserId_Last(
			long userId, OrderByComparator<UserLocation> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchUserLocationException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last user location in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public static UserLocation fetchByUserId_Last(
		long userId, OrderByComparator<UserLocation> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the user locations before and after the current user location in the ordered set where userId = &#63;.
	 *
	 * @param userLocationId the primary key of the current user location
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user location
	 * @throws NoSuchUserLocationException if a user location with the primary key could not be found
	 */
	public static UserLocation[] findByUserId_PrevAndNext(
			long userLocationId, long userId,
			OrderByComparator<UserLocation> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchUserLocationException {

		return getPersistence().findByUserId_PrevAndNext(
			userLocationId, userId, orderByComparator);
	}

	/**
	 * Removes all the user locations where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of user locations where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user locations
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns the user location where userId = &#63; and locationCode = &#63; or throws a <code>NoSuchUserLocationException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param locationCode the location code
	 * @return the matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	public static UserLocation findByUI_LC(long userId, String locationCode)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchUserLocationException {

		return getPersistence().findByUI_LC(userId, locationCode);
	}

	/**
	 * Returns the user location where userId = &#63; and locationCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param locationCode the location code
	 * @return the matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public static UserLocation fetchByUI_LC(long userId, String locationCode) {
		return getPersistence().fetchByUI_LC(userId, locationCode);
	}

	/**
	 * Returns the user location where userId = &#63; and locationCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param locationCode the location code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public static UserLocation fetchByUI_LC(
		long userId, String locationCode, boolean useFinderCache) {

		return getPersistence().fetchByUI_LC(
			userId, locationCode, useFinderCache);
	}

	/**
	 * Removes the user location where userId = &#63; and locationCode = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param locationCode the location code
	 * @return the user location that was removed
	 */
	public static UserLocation removeByUI_LC(long userId, String locationCode)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchUserLocationException {

		return getPersistence().removeByUI_LC(userId, locationCode);
	}

	/**
	 * Returns the number of user locations where userId = &#63; and locationCode = &#63;.
	 *
	 * @param userId the user ID
	 * @param locationCode the location code
	 * @return the number of matching user locations
	 */
	public static int countByUI_LC(long userId, String locationCode) {
		return getPersistence().countByUI_LC(userId, locationCode);
	}

	/**
	 * Returns the user location where userId = &#63; and locationCode = &#63; and roleKey = &#63; or throws a <code>NoSuchUserLocationException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param locationCode the location code
	 * @param roleKey the role key
	 * @return the matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	public static UserLocation findByUI_LC_RK(
			long userId, String locationCode, String roleKey)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchUserLocationException {

		return getPersistence().findByUI_LC_RK(userId, locationCode, roleKey);
	}

	/**
	 * Returns the user location where userId = &#63; and locationCode = &#63; and roleKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param locationCode the location code
	 * @param roleKey the role key
	 * @return the matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public static UserLocation fetchByUI_LC_RK(
		long userId, String locationCode, String roleKey) {

		return getPersistence().fetchByUI_LC_RK(userId, locationCode, roleKey);
	}

	/**
	 * Returns the user location where userId = &#63; and locationCode = &#63; and roleKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param locationCode the location code
	 * @param roleKey the role key
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public static UserLocation fetchByUI_LC_RK(
		long userId, String locationCode, String roleKey,
		boolean useFinderCache) {

		return getPersistence().fetchByUI_LC_RK(
			userId, locationCode, roleKey, useFinderCache);
	}

	/**
	 * Removes the user location where userId = &#63; and locationCode = &#63; and roleKey = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param locationCode the location code
	 * @param roleKey the role key
	 * @return the user location that was removed
	 */
	public static UserLocation removeByUI_LC_RK(
			long userId, String locationCode, String roleKey)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchUserLocationException {

		return getPersistence().removeByUI_LC_RK(userId, locationCode, roleKey);
	}

	/**
	 * Returns the number of user locations where userId = &#63; and locationCode = &#63; and roleKey = &#63;.
	 *
	 * @param userId the user ID
	 * @param locationCode the location code
	 * @param roleKey the role key
	 * @return the number of matching user locations
	 */
	public static int countByUI_LC_RK(
		long userId, String locationCode, String roleKey) {

		return getPersistence().countByUI_LC_RK(userId, locationCode, roleKey);
	}

	/**
	 * Returns the user location where locationId = &#63; or throws a <code>NoSuchUserLocationException</code> if it could not be found.
	 *
	 * @param locationId the location ID
	 * @return the matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	public static UserLocation findByLocationId(long locationId)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchUserLocationException {

		return getPersistence().findByLocationId(locationId);
	}

	/**
	 * Returns the user location where locationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param locationId the location ID
	 * @return the matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public static UserLocation fetchByLocationId(long locationId) {
		return getPersistence().fetchByLocationId(locationId);
	}

	/**
	 * Returns the user location where locationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param locationId the location ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public static UserLocation fetchByLocationId(
		long locationId, boolean useFinderCache) {

		return getPersistence().fetchByLocationId(locationId, useFinderCache);
	}

	/**
	 * Removes the user location where locationId = &#63; from the database.
	 *
	 * @param locationId the location ID
	 * @return the user location that was removed
	 */
	public static UserLocation removeByLocationId(long locationId)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchUserLocationException {

		return getPersistence().removeByLocationId(locationId);
	}

	/**
	 * Returns the number of user locations where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @return the number of matching user locations
	 */
	public static int countByLocationId(long locationId) {
		return getPersistence().countByLocationId(locationId);
	}

	/**
	 * Returns the user location where roleKey = &#63; and locationCode = &#63; or throws a <code>NoSuchUserLocationException</code> if it could not be found.
	 *
	 * @param roleKey the role key
	 * @param locationCode the location code
	 * @return the matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	public static UserLocation findByRK_LC(String roleKey, String locationCode)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchUserLocationException {

		return getPersistence().findByRK_LC(roleKey, locationCode);
	}

	/**
	 * Returns the user location where roleKey = &#63; and locationCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param roleKey the role key
	 * @param locationCode the location code
	 * @return the matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public static UserLocation fetchByRK_LC(
		String roleKey, String locationCode) {

		return getPersistence().fetchByRK_LC(roleKey, locationCode);
	}

	/**
	 * Returns the user location where roleKey = &#63; and locationCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param roleKey the role key
	 * @param locationCode the location code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public static UserLocation fetchByRK_LC(
		String roleKey, String locationCode, boolean useFinderCache) {

		return getPersistence().fetchByRK_LC(
			roleKey, locationCode, useFinderCache);
	}

	/**
	 * Removes the user location where roleKey = &#63; and locationCode = &#63; from the database.
	 *
	 * @param roleKey the role key
	 * @param locationCode the location code
	 * @return the user location that was removed
	 */
	public static UserLocation removeByRK_LC(
			String roleKey, String locationCode)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchUserLocationException {

		return getPersistence().removeByRK_LC(roleKey, locationCode);
	}

	/**
	 * Returns the number of user locations where roleKey = &#63; and locationCode = &#63;.
	 *
	 * @param roleKey the role key
	 * @param locationCode the location code
	 * @return the number of matching user locations
	 */
	public static int countByRK_LC(String roleKey, String locationCode) {
		return getPersistence().countByRK_LC(roleKey, locationCode);
	}

	/**
	 * Caches the user location in the entity cache if it is enabled.
	 *
	 * @param userLocation the user location
	 */
	public static void cacheResult(UserLocation userLocation) {
		getPersistence().cacheResult(userLocation);
	}

	/**
	 * Caches the user locations in the entity cache if it is enabled.
	 *
	 * @param userLocations the user locations
	 */
	public static void cacheResult(List<UserLocation> userLocations) {
		getPersistence().cacheResult(userLocations);
	}

	/**
	 * Creates a new user location with the primary key. Does not add the user location to the database.
	 *
	 * @param userLocationId the primary key for the new user location
	 * @return the new user location
	 */
	public static UserLocation create(long userLocationId) {
		return getPersistence().create(userLocationId);
	}

	/**
	 * Removes the user location with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userLocationId the primary key of the user location
	 * @return the user location that was removed
	 * @throws NoSuchUserLocationException if a user location with the primary key could not be found
	 */
	public static UserLocation remove(long userLocationId)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchUserLocationException {

		return getPersistence().remove(userLocationId);
	}

	public static UserLocation updateImpl(UserLocation userLocation) {
		return getPersistence().updateImpl(userLocation);
	}

	/**
	 * Returns the user location with the primary key or throws a <code>NoSuchUserLocationException</code> if it could not be found.
	 *
	 * @param userLocationId the primary key of the user location
	 * @return the user location
	 * @throws NoSuchUserLocationException if a user location with the primary key could not be found
	 */
	public static UserLocation findByPrimaryKey(long userLocationId)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchUserLocationException {

		return getPersistence().findByPrimaryKey(userLocationId);
	}

	/**
	 * Returns the user location with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userLocationId the primary key of the user location
	 * @return the user location, or <code>null</code> if a user location with the primary key could not be found
	 */
	public static UserLocation fetchByPrimaryKey(long userLocationId) {
		return getPersistence().fetchByPrimaryKey(userLocationId);
	}

	/**
	 * Returns all the user locations.
	 *
	 * @return the user locations
	 */
	public static List<UserLocation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the user locations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @return the range of user locations
	 */
	public static List<UserLocation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the user locations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user locations
	 */
	public static List<UserLocation> findAll(
		int start, int end, OrderByComparator<UserLocation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user locations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user locations
	 */
	public static List<UserLocation> findAll(
		int start, int end, OrderByComparator<UserLocation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the user locations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of user locations.
	 *
	 * @return the number of user locations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static UserLocationPersistence getPersistence() {
		return _persistence;
	}

	private static volatile UserLocationPersistence _persistence;

}