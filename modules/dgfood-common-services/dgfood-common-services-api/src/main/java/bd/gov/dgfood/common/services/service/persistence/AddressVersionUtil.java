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

import bd.gov.dgfood.common.services.model.AddressVersion;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the address version service. This utility wraps <code>bd.gov.dgfood.common.services.service.persistence.impl.AddressVersionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressVersionPersistence
 * @generated
 */
public class AddressVersionUtil {

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
	public static void clearCache(AddressVersion addressVersion) {
		getPersistence().clearCache(addressVersion);
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
	public static Map<Serializable, AddressVersion> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AddressVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AddressVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AddressVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AddressVersion> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AddressVersion update(AddressVersion addressVersion) {
		return getPersistence().update(addressVersion);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AddressVersion update(
		AddressVersion addressVersion, ServiceContext serviceContext) {

		return getPersistence().update(addressVersion, serviceContext);
	}

	/**
	 * Returns all the address versions where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @return the matching address versions
	 */
	public static List<AddressVersion> findByCPK_CN(
		long classPK, String className) {

		return getPersistence().findByCPK_CN(classPK, className);
	}

	/**
	 * Returns a range of all the address versions where classPK = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressVersionModelImpl</code>.
	 * </p>
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param start the lower bound of the range of address versions
	 * @param end the upper bound of the range of address versions (not inclusive)
	 * @return the range of matching address versions
	 */
	public static List<AddressVersion> findByCPK_CN(
		long classPK, String className, int start, int end) {

		return getPersistence().findByCPK_CN(classPK, className, start, end);
	}

	/**
	 * Returns an ordered range of all the address versions where classPK = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressVersionModelImpl</code>.
	 * </p>
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param start the lower bound of the range of address versions
	 * @param end the upper bound of the range of address versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching address versions
	 */
	public static List<AddressVersion> findByCPK_CN(
		long classPK, String className, int start, int end,
		OrderByComparator<AddressVersion> orderByComparator) {

		return getPersistence().findByCPK_CN(
			classPK, className, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the address versions where classPK = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressVersionModelImpl</code>.
	 * </p>
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param start the lower bound of the range of address versions
	 * @param end the upper bound of the range of address versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching address versions
	 */
	public static List<AddressVersion> findByCPK_CN(
		long classPK, String className, int start, int end,
		OrderByComparator<AddressVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCPK_CN(
			classPK, className, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first address version in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address version
	 * @throws NoSuchAddressVersionException if a matching address version could not be found
	 */
	public static AddressVersion findByCPK_CN_First(
			long classPK, String className,
			OrderByComparator<AddressVersion> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchAddressVersionException {

		return getPersistence().findByCPK_CN_First(
			classPK, className, orderByComparator);
	}

	/**
	 * Returns the first address version in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address version, or <code>null</code> if a matching address version could not be found
	 */
	public static AddressVersion fetchByCPK_CN_First(
		long classPK, String className,
		OrderByComparator<AddressVersion> orderByComparator) {

		return getPersistence().fetchByCPK_CN_First(
			classPK, className, orderByComparator);
	}

	/**
	 * Returns the last address version in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address version
	 * @throws NoSuchAddressVersionException if a matching address version could not be found
	 */
	public static AddressVersion findByCPK_CN_Last(
			long classPK, String className,
			OrderByComparator<AddressVersion> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchAddressVersionException {

		return getPersistence().findByCPK_CN_Last(
			classPK, className, orderByComparator);
	}

	/**
	 * Returns the last address version in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address version, or <code>null</code> if a matching address version could not be found
	 */
	public static AddressVersion fetchByCPK_CN_Last(
		long classPK, String className,
		OrderByComparator<AddressVersion> orderByComparator) {

		return getPersistence().fetchByCPK_CN_Last(
			classPK, className, orderByComparator);
	}

	/**
	 * Returns the address versions before and after the current address version in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param addressVersionId the primary key of the current address version
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next address version
	 * @throws NoSuchAddressVersionException if a address version with the primary key could not be found
	 */
	public static AddressVersion[] findByCPK_CN_PrevAndNext(
			long addressVersionId, long classPK, String className,
			OrderByComparator<AddressVersion> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchAddressVersionException {

		return getPersistence().findByCPK_CN_PrevAndNext(
			addressVersionId, classPK, className, orderByComparator);
	}

	/**
	 * Removes all the address versions where classPK = &#63; and className = &#63; from the database.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 */
	public static void removeByCPK_CN(long classPK, String className) {
		getPersistence().removeByCPK_CN(classPK, className);
	}

	/**
	 * Returns the number of address versions where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @return the number of matching address versions
	 */
	public static int countByCPK_CN(long classPK, String className) {
		return getPersistence().countByCPK_CN(classPK, className);
	}

	/**
	 * Caches the address version in the entity cache if it is enabled.
	 *
	 * @param addressVersion the address version
	 */
	public static void cacheResult(AddressVersion addressVersion) {
		getPersistence().cacheResult(addressVersion);
	}

	/**
	 * Caches the address versions in the entity cache if it is enabled.
	 *
	 * @param addressVersions the address versions
	 */
	public static void cacheResult(List<AddressVersion> addressVersions) {
		getPersistence().cacheResult(addressVersions);
	}

	/**
	 * Creates a new address version with the primary key. Does not add the address version to the database.
	 *
	 * @param addressVersionId the primary key for the new address version
	 * @return the new address version
	 */
	public static AddressVersion create(long addressVersionId) {
		return getPersistence().create(addressVersionId);
	}

	/**
	 * Removes the address version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addressVersionId the primary key of the address version
	 * @return the address version that was removed
	 * @throws NoSuchAddressVersionException if a address version with the primary key could not be found
	 */
	public static AddressVersion remove(long addressVersionId)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchAddressVersionException {

		return getPersistence().remove(addressVersionId);
	}

	public static AddressVersion updateImpl(AddressVersion addressVersion) {
		return getPersistence().updateImpl(addressVersion);
	}

	/**
	 * Returns the address version with the primary key or throws a <code>NoSuchAddressVersionException</code> if it could not be found.
	 *
	 * @param addressVersionId the primary key of the address version
	 * @return the address version
	 * @throws NoSuchAddressVersionException if a address version with the primary key could not be found
	 */
	public static AddressVersion findByPrimaryKey(long addressVersionId)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchAddressVersionException {

		return getPersistence().findByPrimaryKey(addressVersionId);
	}

	/**
	 * Returns the address version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addressVersionId the primary key of the address version
	 * @return the address version, or <code>null</code> if a address version with the primary key could not be found
	 */
	public static AddressVersion fetchByPrimaryKey(long addressVersionId) {
		return getPersistence().fetchByPrimaryKey(addressVersionId);
	}

	/**
	 * Returns all the address versions.
	 *
	 * @return the address versions
	 */
	public static List<AddressVersion> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the address versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of address versions
	 * @param end the upper bound of the range of address versions (not inclusive)
	 * @return the range of address versions
	 */
	public static List<AddressVersion> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the address versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of address versions
	 * @param end the upper bound of the range of address versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of address versions
	 */
	public static List<AddressVersion> findAll(
		int start, int end,
		OrderByComparator<AddressVersion> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the address versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of address versions
	 * @param end the upper bound of the range of address versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of address versions
	 */
	public static List<AddressVersion> findAll(
		int start, int end, OrderByComparator<AddressVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the address versions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of address versions.
	 *
	 * @return the number of address versions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AddressVersionPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AddressVersionPersistence _persistence;

}