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

package bd.gov.dgfood.credit.other.priority.customer.service.persistence;

import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerAllocation;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the sales customer allocation service. This utility wraps <code>bd.gov.dgfood.credit.other.priority.customer.service.persistence.impl.SalesCustomerAllocationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SalesCustomerAllocationPersistence
 * @generated
 */
public class SalesCustomerAllocationUtil {

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
	public static void clearCache(
		SalesCustomerAllocation salesCustomerAllocation) {

		getPersistence().clearCache(salesCustomerAllocation);
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
	public static Map<Serializable, SalesCustomerAllocation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SalesCustomerAllocation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SalesCustomerAllocation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SalesCustomerAllocation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SalesCustomerAllocation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SalesCustomerAllocation update(
		SalesCustomerAllocation salesCustomerAllocation) {

		return getPersistence().update(salesCustomerAllocation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SalesCustomerAllocation update(
		SalesCustomerAllocation salesCustomerAllocation,
		ServiceContext serviceContext) {

		return getPersistence().update(salesCustomerAllocation, serviceContext);
	}

	/**
	 * Returns all the sales customer allocations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sales customer allocations
	 */
	public static List<SalesCustomerAllocation> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the sales customer allocations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerAllocationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sales customer allocations
	 * @param end the upper bound of the range of sales customer allocations (not inclusive)
	 * @return the range of matching sales customer allocations
	 */
	public static List<SalesCustomerAllocation> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the sales customer allocations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerAllocationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sales customer allocations
	 * @param end the upper bound of the range of sales customer allocations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sales customer allocations
	 */
	public static List<SalesCustomerAllocation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SalesCustomerAllocation> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sales customer allocations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerAllocationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sales customer allocations
	 * @param end the upper bound of the range of sales customer allocations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sales customer allocations
	 */
	public static List<SalesCustomerAllocation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SalesCustomerAllocation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sales customer allocation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer allocation
	 * @throws NoSuchSalesCustomerAllocationException if a matching sales customer allocation could not be found
	 */
	public static SalesCustomerAllocation findByUuid_First(
			String uuid,
			OrderByComparator<SalesCustomerAllocation> orderByComparator)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerAllocationException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first sales customer allocation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer allocation, or <code>null</code> if a matching sales customer allocation could not be found
	 */
	public static SalesCustomerAllocation fetchByUuid_First(
		String uuid,
		OrderByComparator<SalesCustomerAllocation> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last sales customer allocation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer allocation
	 * @throws NoSuchSalesCustomerAllocationException if a matching sales customer allocation could not be found
	 */
	public static SalesCustomerAllocation findByUuid_Last(
			String uuid,
			OrderByComparator<SalesCustomerAllocation> orderByComparator)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerAllocationException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last sales customer allocation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer allocation, or <code>null</code> if a matching sales customer allocation could not be found
	 */
	public static SalesCustomerAllocation fetchByUuid_Last(
		String uuid,
		OrderByComparator<SalesCustomerAllocation> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the sales customer allocations before and after the current sales customer allocation in the ordered set where uuid = &#63;.
	 *
	 * @param salesCustomerAllocationId the primary key of the current sales customer allocation
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sales customer allocation
	 * @throws NoSuchSalesCustomerAllocationException if a sales customer allocation with the primary key could not be found
	 */
	public static SalesCustomerAllocation[] findByUuid_PrevAndNext(
			long salesCustomerAllocationId, String uuid,
			OrderByComparator<SalesCustomerAllocation> orderByComparator)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerAllocationException {

		return getPersistence().findByUuid_PrevAndNext(
			salesCustomerAllocationId, uuid, orderByComparator);
	}

	/**
	 * Removes all the sales customer allocations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of sales customer allocations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sales customer allocations
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the sales customer allocations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching sales customer allocations
	 */
	public static List<SalesCustomerAllocation> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the sales customer allocations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerAllocationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sales customer allocations
	 * @param end the upper bound of the range of sales customer allocations (not inclusive)
	 * @return the range of matching sales customer allocations
	 */
	public static List<SalesCustomerAllocation> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the sales customer allocations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerAllocationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sales customer allocations
	 * @param end the upper bound of the range of sales customer allocations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sales customer allocations
	 */
	public static List<SalesCustomerAllocation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SalesCustomerAllocation> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sales customer allocations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerAllocationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sales customer allocations
	 * @param end the upper bound of the range of sales customer allocations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sales customer allocations
	 */
	public static List<SalesCustomerAllocation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SalesCustomerAllocation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sales customer allocation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer allocation
	 * @throws NoSuchSalesCustomerAllocationException if a matching sales customer allocation could not be found
	 */
	public static SalesCustomerAllocation findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<SalesCustomerAllocation> orderByComparator)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerAllocationException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first sales customer allocation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer allocation, or <code>null</code> if a matching sales customer allocation could not be found
	 */
	public static SalesCustomerAllocation fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<SalesCustomerAllocation> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last sales customer allocation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer allocation
	 * @throws NoSuchSalesCustomerAllocationException if a matching sales customer allocation could not be found
	 */
	public static SalesCustomerAllocation findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<SalesCustomerAllocation> orderByComparator)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerAllocationException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last sales customer allocation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer allocation, or <code>null</code> if a matching sales customer allocation could not be found
	 */
	public static SalesCustomerAllocation fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<SalesCustomerAllocation> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the sales customer allocations before and after the current sales customer allocation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param salesCustomerAllocationId the primary key of the current sales customer allocation
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sales customer allocation
	 * @throws NoSuchSalesCustomerAllocationException if a sales customer allocation with the primary key could not be found
	 */
	public static SalesCustomerAllocation[] findByUuid_C_PrevAndNext(
			long salesCustomerAllocationId, String uuid, long companyId,
			OrderByComparator<SalesCustomerAllocation> orderByComparator)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerAllocationException {

		return getPersistence().findByUuid_C_PrevAndNext(
			salesCustomerAllocationId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the sales customer allocations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of sales customer allocations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching sales customer allocations
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the sales customer allocation in the entity cache if it is enabled.
	 *
	 * @param salesCustomerAllocation the sales customer allocation
	 */
	public static void cacheResult(
		SalesCustomerAllocation salesCustomerAllocation) {

		getPersistence().cacheResult(salesCustomerAllocation);
	}

	/**
	 * Caches the sales customer allocations in the entity cache if it is enabled.
	 *
	 * @param salesCustomerAllocations the sales customer allocations
	 */
	public static void cacheResult(
		List<SalesCustomerAllocation> salesCustomerAllocations) {

		getPersistence().cacheResult(salesCustomerAllocations);
	}

	/**
	 * Creates a new sales customer allocation with the primary key. Does not add the sales customer allocation to the database.
	 *
	 * @param salesCustomerAllocationId the primary key for the new sales customer allocation
	 * @return the new sales customer allocation
	 */
	public static SalesCustomerAllocation create(
		long salesCustomerAllocationId) {

		return getPersistence().create(salesCustomerAllocationId);
	}

	/**
	 * Removes the sales customer allocation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param salesCustomerAllocationId the primary key of the sales customer allocation
	 * @return the sales customer allocation that was removed
	 * @throws NoSuchSalesCustomerAllocationException if a sales customer allocation with the primary key could not be found
	 */
	public static SalesCustomerAllocation remove(long salesCustomerAllocationId)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerAllocationException {

		return getPersistence().remove(salesCustomerAllocationId);
	}

	public static SalesCustomerAllocation updateImpl(
		SalesCustomerAllocation salesCustomerAllocation) {

		return getPersistence().updateImpl(salesCustomerAllocation);
	}

	/**
	 * Returns the sales customer allocation with the primary key or throws a <code>NoSuchSalesCustomerAllocationException</code> if it could not be found.
	 *
	 * @param salesCustomerAllocationId the primary key of the sales customer allocation
	 * @return the sales customer allocation
	 * @throws NoSuchSalesCustomerAllocationException if a sales customer allocation with the primary key could not be found
	 */
	public static SalesCustomerAllocation findByPrimaryKey(
			long salesCustomerAllocationId)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerAllocationException {

		return getPersistence().findByPrimaryKey(salesCustomerAllocationId);
	}

	/**
	 * Returns the sales customer allocation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param salesCustomerAllocationId the primary key of the sales customer allocation
	 * @return the sales customer allocation, or <code>null</code> if a sales customer allocation with the primary key could not be found
	 */
	public static SalesCustomerAllocation fetchByPrimaryKey(
		long salesCustomerAllocationId) {

		return getPersistence().fetchByPrimaryKey(salesCustomerAllocationId);
	}

	/**
	 * Returns all the sales customer allocations.
	 *
	 * @return the sales customer allocations
	 */
	public static List<SalesCustomerAllocation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the sales customer allocations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerAllocationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sales customer allocations
	 * @param end the upper bound of the range of sales customer allocations (not inclusive)
	 * @return the range of sales customer allocations
	 */
	public static List<SalesCustomerAllocation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the sales customer allocations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerAllocationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sales customer allocations
	 * @param end the upper bound of the range of sales customer allocations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sales customer allocations
	 */
	public static List<SalesCustomerAllocation> findAll(
		int start, int end,
		OrderByComparator<SalesCustomerAllocation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sales customer allocations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerAllocationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sales customer allocations
	 * @param end the upper bound of the range of sales customer allocations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sales customer allocations
	 */
	public static List<SalesCustomerAllocation> findAll(
		int start, int end,
		OrderByComparator<SalesCustomerAllocation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the sales customer allocations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of sales customer allocations.
	 *
	 * @return the number of sales customer allocations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SalesCustomerAllocationPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SalesCustomerAllocationPersistence _persistence;

}