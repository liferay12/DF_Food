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

import bd.gov.dgfood.common.services.model.UserDetails;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the user details service. This utility wraps <code>bd.gov.dgfood.common.services.service.persistence.impl.UserDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserDetailsPersistence
 * @generated
 */
public class UserDetailsUtil {

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
	public static void clearCache(UserDetails userDetails) {
		getPersistence().clearCache(userDetails);
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
	public static Map<Serializable, UserDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserDetails update(UserDetails userDetails) {
		return getPersistence().update(userDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserDetails update(
		UserDetails userDetails, ServiceContext serviceContext) {

		return getPersistence().update(userDetails, serviceContext);
	}

	/**
	 * Returns the user details where nationalId = &#63; or throws a <code>NoSuchUserDetailsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching user details
	 * @throws NoSuchUserDetailsException if a matching user details could not be found
	 */
	public static UserDetails findByNationalId(String nationalId)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchUserDetailsException {

		return getPersistence().findByNationalId(nationalId);
	}

	/**
	 * Returns the user details where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching user details, or <code>null</code> if a matching user details could not be found
	 */
	public static UserDetails fetchByNationalId(String nationalId) {
		return getPersistence().fetchByNationalId(nationalId);
	}

	/**
	 * Returns the user details where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user details, or <code>null</code> if a matching user details could not be found
	 */
	public static UserDetails fetchByNationalId(
		String nationalId, boolean useFinderCache) {

		return getPersistence().fetchByNationalId(nationalId, useFinderCache);
	}

	/**
	 * Removes the user details where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the user details that was removed
	 */
	public static UserDetails removeByNationalId(String nationalId)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchUserDetailsException {

		return getPersistence().removeByNationalId(nationalId);
	}

	/**
	 * Returns the number of user detailses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching user detailses
	 */
	public static int countByNationalId(String nationalId) {
		return getPersistence().countByNationalId(nationalId);
	}

	/**
	 * Caches the user details in the entity cache if it is enabled.
	 *
	 * @param userDetails the user details
	 */
	public static void cacheResult(UserDetails userDetails) {
		getPersistence().cacheResult(userDetails);
	}

	/**
	 * Caches the user detailses in the entity cache if it is enabled.
	 *
	 * @param userDetailses the user detailses
	 */
	public static void cacheResult(List<UserDetails> userDetailses) {
		getPersistence().cacheResult(userDetailses);
	}

	/**
	 * Creates a new user details with the primary key. Does not add the user details to the database.
	 *
	 * @param userDetailsId the primary key for the new user details
	 * @return the new user details
	 */
	public static UserDetails create(long userDetailsId) {
		return getPersistence().create(userDetailsId);
	}

	/**
	 * Removes the user details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userDetailsId the primary key of the user details
	 * @return the user details that was removed
	 * @throws NoSuchUserDetailsException if a user details with the primary key could not be found
	 */
	public static UserDetails remove(long userDetailsId)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchUserDetailsException {

		return getPersistence().remove(userDetailsId);
	}

	public static UserDetails updateImpl(UserDetails userDetails) {
		return getPersistence().updateImpl(userDetails);
	}

	/**
	 * Returns the user details with the primary key or throws a <code>NoSuchUserDetailsException</code> if it could not be found.
	 *
	 * @param userDetailsId the primary key of the user details
	 * @return the user details
	 * @throws NoSuchUserDetailsException if a user details with the primary key could not be found
	 */
	public static UserDetails findByPrimaryKey(long userDetailsId)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchUserDetailsException {

		return getPersistence().findByPrimaryKey(userDetailsId);
	}

	/**
	 * Returns the user details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userDetailsId the primary key of the user details
	 * @return the user details, or <code>null</code> if a user details with the primary key could not be found
	 */
	public static UserDetails fetchByPrimaryKey(long userDetailsId) {
		return getPersistence().fetchByPrimaryKey(userDetailsId);
	}

	/**
	 * Returns all the user detailses.
	 *
	 * @return the user detailses
	 */
	public static List<UserDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the user detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user detailses
	 * @param end the upper bound of the range of user detailses (not inclusive)
	 * @return the range of user detailses
	 */
	public static List<UserDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the user detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user detailses
	 * @param end the upper bound of the range of user detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user detailses
	 */
	public static List<UserDetails> findAll(
		int start, int end, OrderByComparator<UserDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user detailses
	 * @param end the upper bound of the range of user detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user detailses
	 */
	public static List<UserDetails> findAll(
		int start, int end, OrderByComparator<UserDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the user detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of user detailses.
	 *
	 * @return the number of user detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static UserDetailsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile UserDetailsPersistence _persistence;

}