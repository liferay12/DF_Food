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

import bd.gov.dgfood.common.services.model.MDMSyncStatus;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the mdm sync status service. This utility wraps <code>bd.gov.dgfood.common.services.service.persistence.impl.MDMSyncStatusPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MDMSyncStatusPersistence
 * @generated
 */
public class MDMSyncStatusUtil {

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
	public static void clearCache(MDMSyncStatus mdmSyncStatus) {
		getPersistence().clearCache(mdmSyncStatus);
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
	public static Map<Serializable, MDMSyncStatus> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MDMSyncStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MDMSyncStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MDMSyncStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MDMSyncStatus> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MDMSyncStatus update(MDMSyncStatus mdmSyncStatus) {
		return getPersistence().update(mdmSyncStatus);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MDMSyncStatus update(
		MDMSyncStatus mdmSyncStatus, ServiceContext serviceContext) {

		return getPersistence().update(mdmSyncStatus, serviceContext);
	}

	/**
	 * Caches the mdm sync status in the entity cache if it is enabled.
	 *
	 * @param mdmSyncStatus the mdm sync status
	 */
	public static void cacheResult(MDMSyncStatus mdmSyncStatus) {
		getPersistence().cacheResult(mdmSyncStatus);
	}

	/**
	 * Caches the mdm sync statuses in the entity cache if it is enabled.
	 *
	 * @param mdmSyncStatuses the mdm sync statuses
	 */
	public static void cacheResult(List<MDMSyncStatus> mdmSyncStatuses) {
		getPersistence().cacheResult(mdmSyncStatuses);
	}

	/**
	 * Creates a new mdm sync status with the primary key. Does not add the mdm sync status to the database.
	 *
	 * @param mdmSyncStatusId the primary key for the new mdm sync status
	 * @return the new mdm sync status
	 */
	public static MDMSyncStatus create(long mdmSyncStatusId) {
		return getPersistence().create(mdmSyncStatusId);
	}

	/**
	 * Removes the mdm sync status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mdmSyncStatusId the primary key of the mdm sync status
	 * @return the mdm sync status that was removed
	 * @throws NoSuchMDMSyncStatusException if a mdm sync status with the primary key could not be found
	 */
	public static MDMSyncStatus remove(long mdmSyncStatusId)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchMDMSyncStatusException {

		return getPersistence().remove(mdmSyncStatusId);
	}

	public static MDMSyncStatus updateImpl(MDMSyncStatus mdmSyncStatus) {
		return getPersistence().updateImpl(mdmSyncStatus);
	}

	/**
	 * Returns the mdm sync status with the primary key or throws a <code>NoSuchMDMSyncStatusException</code> if it could not be found.
	 *
	 * @param mdmSyncStatusId the primary key of the mdm sync status
	 * @return the mdm sync status
	 * @throws NoSuchMDMSyncStatusException if a mdm sync status with the primary key could not be found
	 */
	public static MDMSyncStatus findByPrimaryKey(long mdmSyncStatusId)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchMDMSyncStatusException {

		return getPersistence().findByPrimaryKey(mdmSyncStatusId);
	}

	/**
	 * Returns the mdm sync status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mdmSyncStatusId the primary key of the mdm sync status
	 * @return the mdm sync status, or <code>null</code> if a mdm sync status with the primary key could not be found
	 */
	public static MDMSyncStatus fetchByPrimaryKey(long mdmSyncStatusId) {
		return getPersistence().fetchByPrimaryKey(mdmSyncStatusId);
	}

	/**
	 * Returns all the mdm sync statuses.
	 *
	 * @return the mdm sync statuses
	 */
	public static List<MDMSyncStatus> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the mdm sync statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MDMSyncStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mdm sync statuses
	 * @param end the upper bound of the range of mdm sync statuses (not inclusive)
	 * @return the range of mdm sync statuses
	 */
	public static List<MDMSyncStatus> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the mdm sync statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MDMSyncStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mdm sync statuses
	 * @param end the upper bound of the range of mdm sync statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of mdm sync statuses
	 */
	public static List<MDMSyncStatus> findAll(
		int start, int end,
		OrderByComparator<MDMSyncStatus> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the mdm sync statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MDMSyncStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mdm sync statuses
	 * @param end the upper bound of the range of mdm sync statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of mdm sync statuses
	 */
	public static List<MDMSyncStatus> findAll(
		int start, int end, OrderByComparator<MDMSyncStatus> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the mdm sync statuses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of mdm sync statuses.
	 *
	 * @return the number of mdm sync statuses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MDMSyncStatusPersistence getPersistence() {
		return _persistence;
	}

	private static volatile MDMSyncStatusPersistence _persistence;

}