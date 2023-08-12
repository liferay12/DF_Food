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

import bd.gov.dgfood.license.management.system.model.FGLicenseMDMData;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the fg license mdm data service. This utility wraps <code>bd.gov.dgfood.license.management.system.service.persistence.impl.FGLicenseMDMDataPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FGLicenseMDMDataPersistence
 * @generated
 */
public class FGLicenseMDMDataUtil {

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
	public static void clearCache(FGLicenseMDMData fgLicenseMDMData) {
		getPersistence().clearCache(fgLicenseMDMData);
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
	public static Map<Serializable, FGLicenseMDMData> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FGLicenseMDMData> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FGLicenseMDMData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FGLicenseMDMData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FGLicenseMDMData> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FGLicenseMDMData update(FGLicenseMDMData fgLicenseMDMData) {
		return getPersistence().update(fgLicenseMDMData);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FGLicenseMDMData update(
		FGLicenseMDMData fgLicenseMDMData, ServiceContext serviceContext) {

		return getPersistence().update(fgLicenseMDMData, serviceContext);
	}

	/**
	 * Returns all the fg license mdm datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching fg license mdm datas
	 */
	public static List<FGLicenseMDMData> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the fg license mdm datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseMDMDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fg license mdm datas
	 * @param end the upper bound of the range of fg license mdm datas (not inclusive)
	 * @return the range of matching fg license mdm datas
	 */
	public static List<FGLicenseMDMData> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the fg license mdm datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseMDMDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fg license mdm datas
	 * @param end the upper bound of the range of fg license mdm datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fg license mdm datas
	 */
	public static List<FGLicenseMDMData> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FGLicenseMDMData> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the fg license mdm datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseMDMDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fg license mdm datas
	 * @param end the upper bound of the range of fg license mdm datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching fg license mdm datas
	 */
	public static List<FGLicenseMDMData> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FGLicenseMDMData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first fg license mdm data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fg license mdm data
	 * @throws NoSuchFGLicenseMDMDataException if a matching fg license mdm data could not be found
	 */
	public static FGLicenseMDMData findByUuid_First(
			String uuid, OrderByComparator<FGLicenseMDMData> orderByComparator)
		throws bd.gov.dgfood.license.management.system.exception.
			NoSuchFGLicenseMDMDataException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first fg license mdm data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fg license mdm data, or <code>null</code> if a matching fg license mdm data could not be found
	 */
	public static FGLicenseMDMData fetchByUuid_First(
		String uuid, OrderByComparator<FGLicenseMDMData> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last fg license mdm data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fg license mdm data
	 * @throws NoSuchFGLicenseMDMDataException if a matching fg license mdm data could not be found
	 */
	public static FGLicenseMDMData findByUuid_Last(
			String uuid, OrderByComparator<FGLicenseMDMData> orderByComparator)
		throws bd.gov.dgfood.license.management.system.exception.
			NoSuchFGLicenseMDMDataException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last fg license mdm data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fg license mdm data, or <code>null</code> if a matching fg license mdm data could not be found
	 */
	public static FGLicenseMDMData fetchByUuid_Last(
		String uuid, OrderByComparator<FGLicenseMDMData> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the fg license mdm datas before and after the current fg license mdm data in the ordered set where uuid = &#63;.
	 *
	 * @param fgLicenseMDMId the primary key of the current fg license mdm data
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fg license mdm data
	 * @throws NoSuchFGLicenseMDMDataException if a fg license mdm data with the primary key could not be found
	 */
	public static FGLicenseMDMData[] findByUuid_PrevAndNext(
			long fgLicenseMDMId, String uuid,
			OrderByComparator<FGLicenseMDMData> orderByComparator)
		throws bd.gov.dgfood.license.management.system.exception.
			NoSuchFGLicenseMDMDataException {

		return getPersistence().findByUuid_PrevAndNext(
			fgLicenseMDMId, uuid, orderByComparator);
	}

	/**
	 * Removes all the fg license mdm datas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of fg license mdm datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching fg license mdm datas
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the fg license mdm data in the entity cache if it is enabled.
	 *
	 * @param fgLicenseMDMData the fg license mdm data
	 */
	public static void cacheResult(FGLicenseMDMData fgLicenseMDMData) {
		getPersistence().cacheResult(fgLicenseMDMData);
	}

	/**
	 * Caches the fg license mdm datas in the entity cache if it is enabled.
	 *
	 * @param fgLicenseMDMDatas the fg license mdm datas
	 */
	public static void cacheResult(List<FGLicenseMDMData> fgLicenseMDMDatas) {
		getPersistence().cacheResult(fgLicenseMDMDatas);
	}

	/**
	 * Creates a new fg license mdm data with the primary key. Does not add the fg license mdm data to the database.
	 *
	 * @param fgLicenseMDMId the primary key for the new fg license mdm data
	 * @return the new fg license mdm data
	 */
	public static FGLicenseMDMData create(long fgLicenseMDMId) {
		return getPersistence().create(fgLicenseMDMId);
	}

	/**
	 * Removes the fg license mdm data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fgLicenseMDMId the primary key of the fg license mdm data
	 * @return the fg license mdm data that was removed
	 * @throws NoSuchFGLicenseMDMDataException if a fg license mdm data with the primary key could not be found
	 */
	public static FGLicenseMDMData remove(long fgLicenseMDMId)
		throws bd.gov.dgfood.license.management.system.exception.
			NoSuchFGLicenseMDMDataException {

		return getPersistence().remove(fgLicenseMDMId);
	}

	public static FGLicenseMDMData updateImpl(
		FGLicenseMDMData fgLicenseMDMData) {

		return getPersistence().updateImpl(fgLicenseMDMData);
	}

	/**
	 * Returns the fg license mdm data with the primary key or throws a <code>NoSuchFGLicenseMDMDataException</code> if it could not be found.
	 *
	 * @param fgLicenseMDMId the primary key of the fg license mdm data
	 * @return the fg license mdm data
	 * @throws NoSuchFGLicenseMDMDataException if a fg license mdm data with the primary key could not be found
	 */
	public static FGLicenseMDMData findByPrimaryKey(long fgLicenseMDMId)
		throws bd.gov.dgfood.license.management.system.exception.
			NoSuchFGLicenseMDMDataException {

		return getPersistence().findByPrimaryKey(fgLicenseMDMId);
	}

	/**
	 * Returns the fg license mdm data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fgLicenseMDMId the primary key of the fg license mdm data
	 * @return the fg license mdm data, or <code>null</code> if a fg license mdm data with the primary key could not be found
	 */
	public static FGLicenseMDMData fetchByPrimaryKey(long fgLicenseMDMId) {
		return getPersistence().fetchByPrimaryKey(fgLicenseMDMId);
	}

	/**
	 * Returns all the fg license mdm datas.
	 *
	 * @return the fg license mdm datas
	 */
	public static List<FGLicenseMDMData> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the fg license mdm datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseMDMDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fg license mdm datas
	 * @param end the upper bound of the range of fg license mdm datas (not inclusive)
	 * @return the range of fg license mdm datas
	 */
	public static List<FGLicenseMDMData> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the fg license mdm datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseMDMDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fg license mdm datas
	 * @param end the upper bound of the range of fg license mdm datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fg license mdm datas
	 */
	public static List<FGLicenseMDMData> findAll(
		int start, int end,
		OrderByComparator<FGLicenseMDMData> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the fg license mdm datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseMDMDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fg license mdm datas
	 * @param end the upper bound of the range of fg license mdm datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of fg license mdm datas
	 */
	public static List<FGLicenseMDMData> findAll(
		int start, int end,
		OrderByComparator<FGLicenseMDMData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the fg license mdm datas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of fg license mdm datas.
	 *
	 * @return the number of fg license mdm datas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FGLicenseMDMDataPersistence getPersistence() {
		return _persistence;
	}

	private static volatile FGLicenseMDMDataPersistence _persistence;

}