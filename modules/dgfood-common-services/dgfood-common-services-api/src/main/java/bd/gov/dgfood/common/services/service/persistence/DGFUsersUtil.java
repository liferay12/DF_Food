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

import bd.gov.dgfood.common.services.model.DGFUsers;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dgf users service. This utility wraps <code>bd.gov.dgfood.common.services.service.persistence.impl.DGFUsersPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DGFUsersPersistence
 * @generated
 */
public class DGFUsersUtil {

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
	public static void clearCache(DGFUsers dgfUsers) {
		getPersistence().clearCache(dgfUsers);
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
	public static Map<Serializable, DGFUsers> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DGFUsers> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DGFUsers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DGFUsers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DGFUsers> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DGFUsers update(DGFUsers dgfUsers) {
		return getPersistence().update(dgfUsers);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DGFUsers update(
		DGFUsers dgfUsers, ServiceContext serviceContext) {

		return getPersistence().update(dgfUsers, serviceContext);
	}

	/**
	 * Returns the dgf users where nationalId = &#63; or throws a <code>NoSuchDGFUsersException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf users
	 * @throws NoSuchDGFUsersException if a matching dgf users could not be found
	 */
	public static DGFUsers findByNationalId(String nationalId)
		throws bd.gov.dgfood.common.services.exception.NoSuchDGFUsersException {

		return getPersistence().findByNationalId(nationalId);
	}

	/**
	 * Returns the dgf users where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf users, or <code>null</code> if a matching dgf users could not be found
	 */
	public static DGFUsers fetchByNationalId(String nationalId) {
		return getPersistence().fetchByNationalId(nationalId);
	}

	/**
	 * Returns the dgf users where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf users, or <code>null</code> if a matching dgf users could not be found
	 */
	public static DGFUsers fetchByNationalId(
		String nationalId, boolean useFinderCache) {

		return getPersistence().fetchByNationalId(nationalId, useFinderCache);
	}

	/**
	 * Removes the dgf users where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the dgf users that was removed
	 */
	public static DGFUsers removeByNationalId(String nationalId)
		throws bd.gov.dgfood.common.services.exception.NoSuchDGFUsersException {

		return getPersistence().removeByNationalId(nationalId);
	}

	/**
	 * Returns the number of dgf userses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf userses
	 */
	public static int countByNationalId(String nationalId) {
		return getPersistence().countByNationalId(nationalId);
	}

	/**
	 * Caches the dgf users in the entity cache if it is enabled.
	 *
	 * @param dgfUsers the dgf users
	 */
	public static void cacheResult(DGFUsers dgfUsers) {
		getPersistence().cacheResult(dgfUsers);
	}

	/**
	 * Caches the dgf userses in the entity cache if it is enabled.
	 *
	 * @param dgfUserses the dgf userses
	 */
	public static void cacheResult(List<DGFUsers> dgfUserses) {
		getPersistence().cacheResult(dgfUserses);
	}

	/**
	 * Creates a new dgf users with the primary key. Does not add the dgf users to the database.
	 *
	 * @param dgfUserId the primary key for the new dgf users
	 * @return the new dgf users
	 */
	public static DGFUsers create(long dgfUserId) {
		return getPersistence().create(dgfUserId);
	}

	/**
	 * Removes the dgf users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dgfUserId the primary key of the dgf users
	 * @return the dgf users that was removed
	 * @throws NoSuchDGFUsersException if a dgf users with the primary key could not be found
	 */
	public static DGFUsers remove(long dgfUserId)
		throws bd.gov.dgfood.common.services.exception.NoSuchDGFUsersException {

		return getPersistence().remove(dgfUserId);
	}

	public static DGFUsers updateImpl(DGFUsers dgfUsers) {
		return getPersistence().updateImpl(dgfUsers);
	}

	/**
	 * Returns the dgf users with the primary key or throws a <code>NoSuchDGFUsersException</code> if it could not be found.
	 *
	 * @param dgfUserId the primary key of the dgf users
	 * @return the dgf users
	 * @throws NoSuchDGFUsersException if a dgf users with the primary key could not be found
	 */
	public static DGFUsers findByPrimaryKey(long dgfUserId)
		throws bd.gov.dgfood.common.services.exception.NoSuchDGFUsersException {

		return getPersistence().findByPrimaryKey(dgfUserId);
	}

	/**
	 * Returns the dgf users with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dgfUserId the primary key of the dgf users
	 * @return the dgf users, or <code>null</code> if a dgf users with the primary key could not be found
	 */
	public static DGFUsers fetchByPrimaryKey(long dgfUserId) {
		return getPersistence().fetchByPrimaryKey(dgfUserId);
	}

	/**
	 * Returns all the dgf userses.
	 *
	 * @return the dgf userses
	 */
	public static List<DGFUsers> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dgf userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @return the range of dgf userses
	 */
	public static List<DGFUsers> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dgf userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf userses
	 */
	public static List<DGFUsers> findAll(
		int start, int end, OrderByComparator<DGFUsers> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf userses
	 */
	public static List<DGFUsers> findAll(
		int start, int end, OrderByComparator<DGFUsers> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dgf userses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dgf userses.
	 *
	 * @return the number of dgf userses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DGFUsersPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DGFUsersPersistence _persistence;

}