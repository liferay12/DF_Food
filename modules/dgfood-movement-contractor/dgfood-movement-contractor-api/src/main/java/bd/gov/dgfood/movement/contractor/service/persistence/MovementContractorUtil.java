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

package bd.gov.dgfood.movement.contractor.service.persistence;

import bd.gov.dgfood.movement.contractor.model.MovementContractor;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the movement contractor service. This utility wraps <code>bd.gov.dgfood.movement.contractor.service.persistence.impl.MovementContractorPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MovementContractorPersistence
 * @generated
 */
public class MovementContractorUtil {

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
	public static void clearCache(MovementContractor movementContractor) {
		getPersistence().clearCache(movementContractor);
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
	public static Map<Serializable, MovementContractor> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MovementContractor> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MovementContractor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MovementContractor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MovementContractor> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MovementContractor update(
		MovementContractor movementContractor) {

		return getPersistence().update(movementContractor);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MovementContractor update(
		MovementContractor movementContractor, ServiceContext serviceContext) {

		return getPersistence().update(movementContractor, serviceContext);
	}

	/**
	 * Returns all the movement contractors where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching movement contractors
	 */
	public static List<MovementContractor> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the movement contractors where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovementContractorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of movement contractors
	 * @param end the upper bound of the range of movement contractors (not inclusive)
	 * @return the range of matching movement contractors
	 */
	public static List<MovementContractor> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the movement contractors where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovementContractorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of movement contractors
	 * @param end the upper bound of the range of movement contractors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching movement contractors
	 */
	public static List<MovementContractor> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MovementContractor> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the movement contractors where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovementContractorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of movement contractors
	 * @param end the upper bound of the range of movement contractors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching movement contractors
	 */
	public static List<MovementContractor> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MovementContractor> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first movement contractor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching movement contractor
	 * @throws NoSuchMovementContractorException if a matching movement contractor could not be found
	 */
	public static MovementContractor findByUuid_First(
			String uuid,
			OrderByComparator<MovementContractor> orderByComparator)
		throws bd.gov.dgfood.movement.contractor.exception.
			NoSuchMovementContractorException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first movement contractor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching movement contractor, or <code>null</code> if a matching movement contractor could not be found
	 */
	public static MovementContractor fetchByUuid_First(
		String uuid, OrderByComparator<MovementContractor> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last movement contractor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching movement contractor
	 * @throws NoSuchMovementContractorException if a matching movement contractor could not be found
	 */
	public static MovementContractor findByUuid_Last(
			String uuid,
			OrderByComparator<MovementContractor> orderByComparator)
		throws bd.gov.dgfood.movement.contractor.exception.
			NoSuchMovementContractorException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last movement contractor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching movement contractor, or <code>null</code> if a matching movement contractor could not be found
	 */
	public static MovementContractor fetchByUuid_Last(
		String uuid, OrderByComparator<MovementContractor> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the movement contractors before and after the current movement contractor in the ordered set where uuid = &#63;.
	 *
	 * @param movementContractorId the primary key of the current movement contractor
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next movement contractor
	 * @throws NoSuchMovementContractorException if a movement contractor with the primary key could not be found
	 */
	public static MovementContractor[] findByUuid_PrevAndNext(
			long movementContractorId, String uuid,
			OrderByComparator<MovementContractor> orderByComparator)
		throws bd.gov.dgfood.movement.contractor.exception.
			NoSuchMovementContractorException {

		return getPersistence().findByUuid_PrevAndNext(
			movementContractorId, uuid, orderByComparator);
	}

	/**
	 * Removes all the movement contractors where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of movement contractors where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching movement contractors
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the movement contractor where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchMovementContractorException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching movement contractor
	 * @throws NoSuchMovementContractorException if a matching movement contractor could not be found
	 */
	public static MovementContractor findByUUID_G(String uuid, long groupId)
		throws bd.gov.dgfood.movement.contractor.exception.
			NoSuchMovementContractorException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the movement contractor where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching movement contractor, or <code>null</code> if a matching movement contractor could not be found
	 */
	public static MovementContractor fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the movement contractor where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching movement contractor, or <code>null</code> if a matching movement contractor could not be found
	 */
	public static MovementContractor fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the movement contractor where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the movement contractor that was removed
	 */
	public static MovementContractor removeByUUID_G(String uuid, long groupId)
		throws bd.gov.dgfood.movement.contractor.exception.
			NoSuchMovementContractorException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of movement contractors where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching movement contractors
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the movement contractors where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching movement contractors
	 */
	public static List<MovementContractor> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the movement contractors where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovementContractorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of movement contractors
	 * @param end the upper bound of the range of movement contractors (not inclusive)
	 * @return the range of matching movement contractors
	 */
	public static List<MovementContractor> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the movement contractors where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovementContractorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of movement contractors
	 * @param end the upper bound of the range of movement contractors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching movement contractors
	 */
	public static List<MovementContractor> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MovementContractor> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the movement contractors where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovementContractorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of movement contractors
	 * @param end the upper bound of the range of movement contractors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching movement contractors
	 */
	public static List<MovementContractor> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MovementContractor> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first movement contractor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching movement contractor
	 * @throws NoSuchMovementContractorException if a matching movement contractor could not be found
	 */
	public static MovementContractor findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<MovementContractor> orderByComparator)
		throws bd.gov.dgfood.movement.contractor.exception.
			NoSuchMovementContractorException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first movement contractor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching movement contractor, or <code>null</code> if a matching movement contractor could not be found
	 */
	public static MovementContractor fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<MovementContractor> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last movement contractor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching movement contractor
	 * @throws NoSuchMovementContractorException if a matching movement contractor could not be found
	 */
	public static MovementContractor findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<MovementContractor> orderByComparator)
		throws bd.gov.dgfood.movement.contractor.exception.
			NoSuchMovementContractorException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last movement contractor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching movement contractor, or <code>null</code> if a matching movement contractor could not be found
	 */
	public static MovementContractor fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<MovementContractor> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the movement contractors before and after the current movement contractor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param movementContractorId the primary key of the current movement contractor
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next movement contractor
	 * @throws NoSuchMovementContractorException if a movement contractor with the primary key could not be found
	 */
	public static MovementContractor[] findByUuid_C_PrevAndNext(
			long movementContractorId, String uuid, long companyId,
			OrderByComparator<MovementContractor> orderByComparator)
		throws bd.gov.dgfood.movement.contractor.exception.
			NoSuchMovementContractorException {

		return getPersistence().findByUuid_C_PrevAndNext(
			movementContractorId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the movement contractors where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of movement contractors where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching movement contractors
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the movement contractor in the entity cache if it is enabled.
	 *
	 * @param movementContractor the movement contractor
	 */
	public static void cacheResult(MovementContractor movementContractor) {
		getPersistence().cacheResult(movementContractor);
	}

	/**
	 * Caches the movement contractors in the entity cache if it is enabled.
	 *
	 * @param movementContractors the movement contractors
	 */
	public static void cacheResult(
		List<MovementContractor> movementContractors) {

		getPersistence().cacheResult(movementContractors);
	}

	/**
	 * Creates a new movement contractor with the primary key. Does not add the movement contractor to the database.
	 *
	 * @param movementContractorId the primary key for the new movement contractor
	 * @return the new movement contractor
	 */
	public static MovementContractor create(long movementContractorId) {
		return getPersistence().create(movementContractorId);
	}

	/**
	 * Removes the movement contractor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param movementContractorId the primary key of the movement contractor
	 * @return the movement contractor that was removed
	 * @throws NoSuchMovementContractorException if a movement contractor with the primary key could not be found
	 */
	public static MovementContractor remove(long movementContractorId)
		throws bd.gov.dgfood.movement.contractor.exception.
			NoSuchMovementContractorException {

		return getPersistence().remove(movementContractorId);
	}

	public static MovementContractor updateImpl(
		MovementContractor movementContractor) {

		return getPersistence().updateImpl(movementContractor);
	}

	/**
	 * Returns the movement contractor with the primary key or throws a <code>NoSuchMovementContractorException</code> if it could not be found.
	 *
	 * @param movementContractorId the primary key of the movement contractor
	 * @return the movement contractor
	 * @throws NoSuchMovementContractorException if a movement contractor with the primary key could not be found
	 */
	public static MovementContractor findByPrimaryKey(long movementContractorId)
		throws bd.gov.dgfood.movement.contractor.exception.
			NoSuchMovementContractorException {

		return getPersistence().findByPrimaryKey(movementContractorId);
	}

	/**
	 * Returns the movement contractor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param movementContractorId the primary key of the movement contractor
	 * @return the movement contractor, or <code>null</code> if a movement contractor with the primary key could not be found
	 */
	public static MovementContractor fetchByPrimaryKey(
		long movementContractorId) {

		return getPersistence().fetchByPrimaryKey(movementContractorId);
	}

	/**
	 * Returns all the movement contractors.
	 *
	 * @return the movement contractors
	 */
	public static List<MovementContractor> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the movement contractors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovementContractorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of movement contractors
	 * @param end the upper bound of the range of movement contractors (not inclusive)
	 * @return the range of movement contractors
	 */
	public static List<MovementContractor> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the movement contractors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovementContractorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of movement contractors
	 * @param end the upper bound of the range of movement contractors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of movement contractors
	 */
	public static List<MovementContractor> findAll(
		int start, int end,
		OrderByComparator<MovementContractor> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the movement contractors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovementContractorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of movement contractors
	 * @param end the upper bound of the range of movement contractors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of movement contractors
	 */
	public static List<MovementContractor> findAll(
		int start, int end,
		OrderByComparator<MovementContractor> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the movement contractors from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of movement contractors.
	 *
	 * @return the number of movement contractors
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MovementContractorPersistence getPersistence() {
		return _persistence;
	}

	private static volatile MovementContractorPersistence _persistence;

}