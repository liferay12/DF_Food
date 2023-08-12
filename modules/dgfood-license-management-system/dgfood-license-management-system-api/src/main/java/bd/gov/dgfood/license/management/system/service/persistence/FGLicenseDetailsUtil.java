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

package bd.gov.dgfood.license.management.system.service.persistence;

import bd.gov.dgfood.license.management.system.model.FGLicenseDetails;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the fg license details service. This utility wraps <code>bd.gov.dgfood.license.management.system.service.persistence.impl.FGLicenseDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FGLicenseDetailsPersistence
 * @generated
 */
public class FGLicenseDetailsUtil {

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
	public static void clearCache(FGLicenseDetails fgLicenseDetails) {
		getPersistence().clearCache(fgLicenseDetails);
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
	public static Map<Serializable, FGLicenseDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FGLicenseDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FGLicenseDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FGLicenseDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FGLicenseDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FGLicenseDetails update(FGLicenseDetails fgLicenseDetails) {
		return getPersistence().update(fgLicenseDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FGLicenseDetails update(
		FGLicenseDetails fgLicenseDetails, ServiceContext serviceContext) {

		return getPersistence().update(fgLicenseDetails, serviceContext);
	}

	/**
	 * Returns all the fg license detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching fg license detailses
	 */
	public static List<FGLicenseDetails> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the fg license detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fg license detailses
	 * @param end the upper bound of the range of fg license detailses (not inclusive)
	 * @return the range of matching fg license detailses
	 */
	public static List<FGLicenseDetails> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the fg license detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fg license detailses
	 * @param end the upper bound of the range of fg license detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fg license detailses
	 */
	public static List<FGLicenseDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FGLicenseDetails> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the fg license detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fg license detailses
	 * @param end the upper bound of the range of fg license detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching fg license detailses
	 */
	public static List<FGLicenseDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FGLicenseDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first fg license details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fg license details
	 * @throws NoSuchFGLicenseDetailsException if a matching fg license details could not be found
	 */
	public static FGLicenseDetails findByUuid_First(
			String uuid, OrderByComparator<FGLicenseDetails> orderByComparator)
		throws bd.gov.dgfood.license.management.system.exception.
			NoSuchFGLicenseDetailsException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first fg license details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fg license details, or <code>null</code> if a matching fg license details could not be found
	 */
	public static FGLicenseDetails fetchByUuid_First(
		String uuid, OrderByComparator<FGLicenseDetails> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last fg license details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fg license details
	 * @throws NoSuchFGLicenseDetailsException if a matching fg license details could not be found
	 */
	public static FGLicenseDetails findByUuid_Last(
			String uuid, OrderByComparator<FGLicenseDetails> orderByComparator)
		throws bd.gov.dgfood.license.management.system.exception.
			NoSuchFGLicenseDetailsException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last fg license details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fg license details, or <code>null</code> if a matching fg license details could not be found
	 */
	public static FGLicenseDetails fetchByUuid_Last(
		String uuid, OrderByComparator<FGLicenseDetails> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the fg license detailses before and after the current fg license details in the ordered set where uuid = &#63;.
	 *
	 * @param fgLicenseMasterId the primary key of the current fg license details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fg license details
	 * @throws NoSuchFGLicenseDetailsException if a fg license details with the primary key could not be found
	 */
	public static FGLicenseDetails[] findByUuid_PrevAndNext(
			long fgLicenseMasterId, String uuid,
			OrderByComparator<FGLicenseDetails> orderByComparator)
		throws bd.gov.dgfood.license.management.system.exception.
			NoSuchFGLicenseDetailsException {

		return getPersistence().findByUuid_PrevAndNext(
			fgLicenseMasterId, uuid, orderByComparator);
	}

	/**
	 * Removes all the fg license detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of fg license detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching fg license detailses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the fg license details in the entity cache if it is enabled.
	 *
	 * @param fgLicenseDetails the fg license details
	 */
	public static void cacheResult(FGLicenseDetails fgLicenseDetails) {
		getPersistence().cacheResult(fgLicenseDetails);
	}

	/**
	 * Caches the fg license detailses in the entity cache if it is enabled.
	 *
	 * @param fgLicenseDetailses the fg license detailses
	 */
	public static void cacheResult(List<FGLicenseDetails> fgLicenseDetailses) {
		getPersistence().cacheResult(fgLicenseDetailses);
	}

	/**
	 * Creates a new fg license details with the primary key. Does not add the fg license details to the database.
	 *
	 * @param fgLicenseMasterId the primary key for the new fg license details
	 * @return the new fg license details
	 */
	public static FGLicenseDetails create(long fgLicenseMasterId) {
		return getPersistence().create(fgLicenseMasterId);
	}

	/**
	 * Removes the fg license details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fgLicenseMasterId the primary key of the fg license details
	 * @return the fg license details that was removed
	 * @throws NoSuchFGLicenseDetailsException if a fg license details with the primary key could not be found
	 */
	public static FGLicenseDetails remove(long fgLicenseMasterId)
		throws bd.gov.dgfood.license.management.system.exception.
			NoSuchFGLicenseDetailsException {

		return getPersistence().remove(fgLicenseMasterId);
	}

	public static FGLicenseDetails updateImpl(
		FGLicenseDetails fgLicenseDetails) {

		return getPersistence().updateImpl(fgLicenseDetails);
	}

	/**
	 * Returns the fg license details with the primary key or throws a <code>NoSuchFGLicenseDetailsException</code> if it could not be found.
	 *
	 * @param fgLicenseMasterId the primary key of the fg license details
	 * @return the fg license details
	 * @throws NoSuchFGLicenseDetailsException if a fg license details with the primary key could not be found
	 */
	public static FGLicenseDetails findByPrimaryKey(long fgLicenseMasterId)
		throws bd.gov.dgfood.license.management.system.exception.
			NoSuchFGLicenseDetailsException {

		return getPersistence().findByPrimaryKey(fgLicenseMasterId);
	}

	/**
	 * Returns the fg license details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fgLicenseMasterId the primary key of the fg license details
	 * @return the fg license details, or <code>null</code> if a fg license details with the primary key could not be found
	 */
	public static FGLicenseDetails fetchByPrimaryKey(long fgLicenseMasterId) {
		return getPersistence().fetchByPrimaryKey(fgLicenseMasterId);
	}

	/**
	 * Returns all the fg license detailses.
	 *
	 * @return the fg license detailses
	 */
	public static List<FGLicenseDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the fg license detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fg license detailses
	 * @param end the upper bound of the range of fg license detailses (not inclusive)
	 * @return the range of fg license detailses
	 */
	public static List<FGLicenseDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the fg license detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fg license detailses
	 * @param end the upper bound of the range of fg license detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fg license detailses
	 */
	public static List<FGLicenseDetails> findAll(
		int start, int end,
		OrderByComparator<FGLicenseDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the fg license detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fg license detailses
	 * @param end the upper bound of the range of fg license detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of fg license detailses
	 */
	public static List<FGLicenseDetails> findAll(
		int start, int end,
		OrderByComparator<FGLicenseDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the fg license detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of fg license detailses.
	 *
	 * @return the number of fg license detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FGLicenseDetailsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile FGLicenseDetailsPersistence _persistence;

}