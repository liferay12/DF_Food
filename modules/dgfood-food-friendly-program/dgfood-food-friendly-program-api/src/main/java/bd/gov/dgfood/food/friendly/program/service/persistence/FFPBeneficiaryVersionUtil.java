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

package bd.gov.dgfood.food.friendly.program.service.persistence;

import bd.gov.dgfood.food.friendly.program.model.FFPBeneficiaryVersion;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the ffp beneficiary version service. This utility wraps <code>bd.gov.dgfood.food.friendly.program.service.persistence.impl.FFPBeneficiaryVersionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FFPBeneficiaryVersionPersistence
 * @generated
 */
public class FFPBeneficiaryVersionUtil {

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
	public static void clearCache(FFPBeneficiaryVersion ffpBeneficiaryVersion) {
		getPersistence().clearCache(ffpBeneficiaryVersion);
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
	public static Map<Serializable, FFPBeneficiaryVersion> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FFPBeneficiaryVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FFPBeneficiaryVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FFPBeneficiaryVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FFPBeneficiaryVersion> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FFPBeneficiaryVersion update(
		FFPBeneficiaryVersion ffpBeneficiaryVersion) {

		return getPersistence().update(ffpBeneficiaryVersion);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FFPBeneficiaryVersion update(
		FFPBeneficiaryVersion ffpBeneficiaryVersion,
		ServiceContext serviceContext) {

		return getPersistence().update(ffpBeneficiaryVersion, serviceContext);
	}

	/**
	 * Returns all the ffp beneficiary versions where beneficiaryId = &#63;.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @return the matching ffp beneficiary versions
	 */
	public static List<FFPBeneficiaryVersion> findByBeneficiaryId(
		long beneficiaryId) {

		return getPersistence().findByBeneficiaryId(beneficiaryId);
	}

	/**
	 * Returns a range of all the ffp beneficiary versions where beneficiaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param start the lower bound of the range of ffp beneficiary versions
	 * @param end the upper bound of the range of ffp beneficiary versions (not inclusive)
	 * @return the range of matching ffp beneficiary versions
	 */
	public static List<FFPBeneficiaryVersion> findByBeneficiaryId(
		long beneficiaryId, int start, int end) {

		return getPersistence().findByBeneficiaryId(beneficiaryId, start, end);
	}

	/**
	 * Returns an ordered range of all the ffp beneficiary versions where beneficiaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param start the lower bound of the range of ffp beneficiary versions
	 * @param end the upper bound of the range of ffp beneficiary versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ffp beneficiary versions
	 */
	public static List<FFPBeneficiaryVersion> findByBeneficiaryId(
		long beneficiaryId, int start, int end,
		OrderByComparator<FFPBeneficiaryVersion> orderByComparator) {

		return getPersistence().findByBeneficiaryId(
			beneficiaryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ffp beneficiary versions where beneficiaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param start the lower bound of the range of ffp beneficiary versions
	 * @param end the upper bound of the range of ffp beneficiary versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ffp beneficiary versions
	 */
	public static List<FFPBeneficiaryVersion> findByBeneficiaryId(
		long beneficiaryId, int start, int end,
		OrderByComparator<FFPBeneficiaryVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByBeneficiaryId(
			beneficiaryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ffp beneficiary version in the ordered set where beneficiaryId = &#63;.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ffp beneficiary version
	 * @throws NoSuchFFPBeneficiaryVersionException if a matching ffp beneficiary version could not be found
	 */
	public static FFPBeneficiaryVersion findByBeneficiaryId_First(
			long beneficiaryId,
			OrderByComparator<FFPBeneficiaryVersion> orderByComparator)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFFPBeneficiaryVersionException {

		return getPersistence().findByBeneficiaryId_First(
			beneficiaryId, orderByComparator);
	}

	/**
	 * Returns the first ffp beneficiary version in the ordered set where beneficiaryId = &#63;.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ffp beneficiary version, or <code>null</code> if a matching ffp beneficiary version could not be found
	 */
	public static FFPBeneficiaryVersion fetchByBeneficiaryId_First(
		long beneficiaryId,
		OrderByComparator<FFPBeneficiaryVersion> orderByComparator) {

		return getPersistence().fetchByBeneficiaryId_First(
			beneficiaryId, orderByComparator);
	}

	/**
	 * Returns the last ffp beneficiary version in the ordered set where beneficiaryId = &#63;.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ffp beneficiary version
	 * @throws NoSuchFFPBeneficiaryVersionException if a matching ffp beneficiary version could not be found
	 */
	public static FFPBeneficiaryVersion findByBeneficiaryId_Last(
			long beneficiaryId,
			OrderByComparator<FFPBeneficiaryVersion> orderByComparator)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFFPBeneficiaryVersionException {

		return getPersistence().findByBeneficiaryId_Last(
			beneficiaryId, orderByComparator);
	}

	/**
	 * Returns the last ffp beneficiary version in the ordered set where beneficiaryId = &#63;.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ffp beneficiary version, or <code>null</code> if a matching ffp beneficiary version could not be found
	 */
	public static FFPBeneficiaryVersion fetchByBeneficiaryId_Last(
		long beneficiaryId,
		OrderByComparator<FFPBeneficiaryVersion> orderByComparator) {

		return getPersistence().fetchByBeneficiaryId_Last(
			beneficiaryId, orderByComparator);
	}

	/**
	 * Returns the ffp beneficiary versions before and after the current ffp beneficiary version in the ordered set where beneficiaryId = &#63;.
	 *
	 * @param beneficiaryVersionId the primary key of the current ffp beneficiary version
	 * @param beneficiaryId the beneficiary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ffp beneficiary version
	 * @throws NoSuchFFPBeneficiaryVersionException if a ffp beneficiary version with the primary key could not be found
	 */
	public static FFPBeneficiaryVersion[] findByBeneficiaryId_PrevAndNext(
			long beneficiaryVersionId, long beneficiaryId,
			OrderByComparator<FFPBeneficiaryVersion> orderByComparator)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFFPBeneficiaryVersionException {

		return getPersistence().findByBeneficiaryId_PrevAndNext(
			beneficiaryVersionId, beneficiaryId, orderByComparator);
	}

	/**
	 * Removes all the ffp beneficiary versions where beneficiaryId = &#63; from the database.
	 *
	 * @param beneficiaryId the beneficiary ID
	 */
	public static void removeByBeneficiaryId(long beneficiaryId) {
		getPersistence().removeByBeneficiaryId(beneficiaryId);
	}

	/**
	 * Returns the number of ffp beneficiary versions where beneficiaryId = &#63;.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @return the number of matching ffp beneficiary versions
	 */
	public static int countByBeneficiaryId(long beneficiaryId) {
		return getPersistence().countByBeneficiaryId(beneficiaryId);
	}

	/**
	 * Returns the ffp beneficiary version where beneficiaryId = &#63; and version = &#63; or throws a <code>NoSuchFFPBeneficiaryVersionException</code> if it could not be found.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param version the version
	 * @return the matching ffp beneficiary version
	 * @throws NoSuchFFPBeneficiaryVersionException if a matching ffp beneficiary version could not be found
	 */
	public static FFPBeneficiaryVersion findById_Version(
			long beneficiaryId, double version)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFFPBeneficiaryVersionException {

		return getPersistence().findById_Version(beneficiaryId, version);
	}

	/**
	 * Returns the ffp beneficiary version where beneficiaryId = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param version the version
	 * @return the matching ffp beneficiary version, or <code>null</code> if a matching ffp beneficiary version could not be found
	 */
	public static FFPBeneficiaryVersion fetchById_Version(
		long beneficiaryId, double version) {

		return getPersistence().fetchById_Version(beneficiaryId, version);
	}

	/**
	 * Returns the ffp beneficiary version where beneficiaryId = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param version the version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ffp beneficiary version, or <code>null</code> if a matching ffp beneficiary version could not be found
	 */
	public static FFPBeneficiaryVersion fetchById_Version(
		long beneficiaryId, double version, boolean useFinderCache) {

		return getPersistence().fetchById_Version(
			beneficiaryId, version, useFinderCache);
	}

	/**
	 * Removes the ffp beneficiary version where beneficiaryId = &#63; and version = &#63; from the database.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param version the version
	 * @return the ffp beneficiary version that was removed
	 */
	public static FFPBeneficiaryVersion removeById_Version(
			long beneficiaryId, double version)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFFPBeneficiaryVersionException {

		return getPersistence().removeById_Version(beneficiaryId, version);
	}

	/**
	 * Returns the number of ffp beneficiary versions where beneficiaryId = &#63; and version = &#63;.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param version the version
	 * @return the number of matching ffp beneficiary versions
	 */
	public static int countById_Version(long beneficiaryId, double version) {
		return getPersistence().countById_Version(beneficiaryId, version);
	}

	/**
	 * Returns all the ffp beneficiary versions where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching ffp beneficiary versions
	 */
	public static List<FFPBeneficiaryVersion> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the ffp beneficiary versions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of ffp beneficiary versions
	 * @param end the upper bound of the range of ffp beneficiary versions (not inclusive)
	 * @return the range of matching ffp beneficiary versions
	 */
	public static List<FFPBeneficiaryVersion> findByStatus(
		int status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the ffp beneficiary versions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of ffp beneficiary versions
	 * @param end the upper bound of the range of ffp beneficiary versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ffp beneficiary versions
	 */
	public static List<FFPBeneficiaryVersion> findByStatus(
		int status, int start, int end,
		OrderByComparator<FFPBeneficiaryVersion> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ffp beneficiary versions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of ffp beneficiary versions
	 * @param end the upper bound of the range of ffp beneficiary versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ffp beneficiary versions
	 */
	public static List<FFPBeneficiaryVersion> findByStatus(
		int status, int start, int end,
		OrderByComparator<FFPBeneficiaryVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ffp beneficiary version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ffp beneficiary version
	 * @throws NoSuchFFPBeneficiaryVersionException if a matching ffp beneficiary version could not be found
	 */
	public static FFPBeneficiaryVersion findByStatus_First(
			int status,
			OrderByComparator<FFPBeneficiaryVersion> orderByComparator)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFFPBeneficiaryVersionException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first ffp beneficiary version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ffp beneficiary version, or <code>null</code> if a matching ffp beneficiary version could not be found
	 */
	public static FFPBeneficiaryVersion fetchByStatus_First(
		int status,
		OrderByComparator<FFPBeneficiaryVersion> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last ffp beneficiary version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ffp beneficiary version
	 * @throws NoSuchFFPBeneficiaryVersionException if a matching ffp beneficiary version could not be found
	 */
	public static FFPBeneficiaryVersion findByStatus_Last(
			int status,
			OrderByComparator<FFPBeneficiaryVersion> orderByComparator)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFFPBeneficiaryVersionException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last ffp beneficiary version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ffp beneficiary version, or <code>null</code> if a matching ffp beneficiary version could not be found
	 */
	public static FFPBeneficiaryVersion fetchByStatus_Last(
		int status,
		OrderByComparator<FFPBeneficiaryVersion> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the ffp beneficiary versions before and after the current ffp beneficiary version in the ordered set where status = &#63;.
	 *
	 * @param beneficiaryVersionId the primary key of the current ffp beneficiary version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ffp beneficiary version
	 * @throws NoSuchFFPBeneficiaryVersionException if a ffp beneficiary version with the primary key could not be found
	 */
	public static FFPBeneficiaryVersion[] findByStatus_PrevAndNext(
			long beneficiaryVersionId, int status,
			OrderByComparator<FFPBeneficiaryVersion> orderByComparator)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFFPBeneficiaryVersionException {

		return getPersistence().findByStatus_PrevAndNext(
			beneficiaryVersionId, status, orderByComparator);
	}

	/**
	 * Removes all the ffp beneficiary versions where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of ffp beneficiary versions where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching ffp beneficiary versions
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Caches the ffp beneficiary version in the entity cache if it is enabled.
	 *
	 * @param ffpBeneficiaryVersion the ffp beneficiary version
	 */
	public static void cacheResult(
		FFPBeneficiaryVersion ffpBeneficiaryVersion) {

		getPersistence().cacheResult(ffpBeneficiaryVersion);
	}

	/**
	 * Caches the ffp beneficiary versions in the entity cache if it is enabled.
	 *
	 * @param ffpBeneficiaryVersions the ffp beneficiary versions
	 */
	public static void cacheResult(
		List<FFPBeneficiaryVersion> ffpBeneficiaryVersions) {

		getPersistence().cacheResult(ffpBeneficiaryVersions);
	}

	/**
	 * Creates a new ffp beneficiary version with the primary key. Does not add the ffp beneficiary version to the database.
	 *
	 * @param beneficiaryVersionId the primary key for the new ffp beneficiary version
	 * @return the new ffp beneficiary version
	 */
	public static FFPBeneficiaryVersion create(long beneficiaryVersionId) {
		return getPersistence().create(beneficiaryVersionId);
	}

	/**
	 * Removes the ffp beneficiary version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param beneficiaryVersionId the primary key of the ffp beneficiary version
	 * @return the ffp beneficiary version that was removed
	 * @throws NoSuchFFPBeneficiaryVersionException if a ffp beneficiary version with the primary key could not be found
	 */
	public static FFPBeneficiaryVersion remove(long beneficiaryVersionId)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFFPBeneficiaryVersionException {

		return getPersistence().remove(beneficiaryVersionId);
	}

	public static FFPBeneficiaryVersion updateImpl(
		FFPBeneficiaryVersion ffpBeneficiaryVersion) {

		return getPersistence().updateImpl(ffpBeneficiaryVersion);
	}

	/**
	 * Returns the ffp beneficiary version with the primary key or throws a <code>NoSuchFFPBeneficiaryVersionException</code> if it could not be found.
	 *
	 * @param beneficiaryVersionId the primary key of the ffp beneficiary version
	 * @return the ffp beneficiary version
	 * @throws NoSuchFFPBeneficiaryVersionException if a ffp beneficiary version with the primary key could not be found
	 */
	public static FFPBeneficiaryVersion findByPrimaryKey(
			long beneficiaryVersionId)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFFPBeneficiaryVersionException {

		return getPersistence().findByPrimaryKey(beneficiaryVersionId);
	}

	/**
	 * Returns the ffp beneficiary version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param beneficiaryVersionId the primary key of the ffp beneficiary version
	 * @return the ffp beneficiary version, or <code>null</code> if a ffp beneficiary version with the primary key could not be found
	 */
	public static FFPBeneficiaryVersion fetchByPrimaryKey(
		long beneficiaryVersionId) {

		return getPersistence().fetchByPrimaryKey(beneficiaryVersionId);
	}

	/**
	 * Returns all the ffp beneficiary versions.
	 *
	 * @return the ffp beneficiary versions
	 */
	public static List<FFPBeneficiaryVersion> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ffp beneficiary versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ffp beneficiary versions
	 * @param end the upper bound of the range of ffp beneficiary versions (not inclusive)
	 * @return the range of ffp beneficiary versions
	 */
	public static List<FFPBeneficiaryVersion> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ffp beneficiary versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ffp beneficiary versions
	 * @param end the upper bound of the range of ffp beneficiary versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ffp beneficiary versions
	 */
	public static List<FFPBeneficiaryVersion> findAll(
		int start, int end,
		OrderByComparator<FFPBeneficiaryVersion> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ffp beneficiary versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ffp beneficiary versions
	 * @param end the upper bound of the range of ffp beneficiary versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ffp beneficiary versions
	 */
	public static List<FFPBeneficiaryVersion> findAll(
		int start, int end,
		OrderByComparator<FFPBeneficiaryVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ffp beneficiary versions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ffp beneficiary versions.
	 *
	 * @return the number of ffp beneficiary versions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FFPBeneficiaryVersionPersistence getPersistence() {
		return _persistence;
	}

	private static volatile FFPBeneficiaryVersionPersistence _persistence;

}