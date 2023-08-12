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

import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the sales customer service. This utility wraps <code>bd.gov.dgfood.credit.other.priority.customer.service.persistence.impl.SalesCustomerPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SalesCustomerPersistence
 * @generated
 */
public class SalesCustomerUtil {

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
	public static void clearCache(SalesCustomer salesCustomer) {
		getPersistence().clearCache(salesCustomer);
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
	public static Map<Serializable, SalesCustomer> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SalesCustomer> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SalesCustomer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SalesCustomer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SalesCustomer> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SalesCustomer update(SalesCustomer salesCustomer) {
		return getPersistence().update(salesCustomer);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SalesCustomer update(
		SalesCustomer salesCustomer, ServiceContext serviceContext) {

		return getPersistence().update(salesCustomer, serviceContext);
	}

	/**
	 * Returns all the sales customers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sales customers
	 */
	public static List<SalesCustomer> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the sales customers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sales customers
	 * @param end the upper bound of the range of sales customers (not inclusive)
	 * @return the range of matching sales customers
	 */
	public static List<SalesCustomer> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the sales customers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sales customers
	 * @param end the upper bound of the range of sales customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sales customers
	 */
	public static List<SalesCustomer> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SalesCustomer> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sales customers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sales customers
	 * @param end the upper bound of the range of sales customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sales customers
	 */
	public static List<SalesCustomer> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SalesCustomer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sales customer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer
	 * @throws NoSuchSalesCustomerException if a matching sales customer could not be found
	 */
	public static SalesCustomer findByUuid_First(
			String uuid, OrderByComparator<SalesCustomer> orderByComparator)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first sales customer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer, or <code>null</code> if a matching sales customer could not be found
	 */
	public static SalesCustomer fetchByUuid_First(
		String uuid, OrderByComparator<SalesCustomer> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last sales customer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer
	 * @throws NoSuchSalesCustomerException if a matching sales customer could not be found
	 */
	public static SalesCustomer findByUuid_Last(
			String uuid, OrderByComparator<SalesCustomer> orderByComparator)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last sales customer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer, or <code>null</code> if a matching sales customer could not be found
	 */
	public static SalesCustomer fetchByUuid_Last(
		String uuid, OrderByComparator<SalesCustomer> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the sales customers before and after the current sales customer in the ordered set where uuid = &#63;.
	 *
	 * @param salesCustomerId the primary key of the current sales customer
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sales customer
	 * @throws NoSuchSalesCustomerException if a sales customer with the primary key could not be found
	 */
	public static SalesCustomer[] findByUuid_PrevAndNext(
			long salesCustomerId, String uuid,
			OrderByComparator<SalesCustomer> orderByComparator)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerException {

		return getPersistence().findByUuid_PrevAndNext(
			salesCustomerId, uuid, orderByComparator);
	}

	/**
	 * Removes all the sales customers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of sales customers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sales customers
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the sales customer where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSalesCustomerException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sales customer
	 * @throws NoSuchSalesCustomerException if a matching sales customer could not be found
	 */
	public static SalesCustomer findByUUID_G(String uuid, long groupId)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the sales customer where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sales customer, or <code>null</code> if a matching sales customer could not be found
	 */
	public static SalesCustomer fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the sales customer where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sales customer, or <code>null</code> if a matching sales customer could not be found
	 */
	public static SalesCustomer fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the sales customer where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the sales customer that was removed
	 */
	public static SalesCustomer removeByUUID_G(String uuid, long groupId)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of sales customers where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching sales customers
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the sales customers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching sales customers
	 */
	public static List<SalesCustomer> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the sales customers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sales customers
	 * @param end the upper bound of the range of sales customers (not inclusive)
	 * @return the range of matching sales customers
	 */
	public static List<SalesCustomer> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the sales customers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sales customers
	 * @param end the upper bound of the range of sales customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sales customers
	 */
	public static List<SalesCustomer> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SalesCustomer> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sales customers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sales customers
	 * @param end the upper bound of the range of sales customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sales customers
	 */
	public static List<SalesCustomer> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SalesCustomer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sales customer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer
	 * @throws NoSuchSalesCustomerException if a matching sales customer could not be found
	 */
	public static SalesCustomer findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<SalesCustomer> orderByComparator)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first sales customer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer, or <code>null</code> if a matching sales customer could not be found
	 */
	public static SalesCustomer fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<SalesCustomer> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last sales customer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer
	 * @throws NoSuchSalesCustomerException if a matching sales customer could not be found
	 */
	public static SalesCustomer findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<SalesCustomer> orderByComparator)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last sales customer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer, or <code>null</code> if a matching sales customer could not be found
	 */
	public static SalesCustomer fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<SalesCustomer> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the sales customers before and after the current sales customer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param salesCustomerId the primary key of the current sales customer
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sales customer
	 * @throws NoSuchSalesCustomerException if a sales customer with the primary key could not be found
	 */
	public static SalesCustomer[] findByUuid_C_PrevAndNext(
			long salesCustomerId, String uuid, long companyId,
			OrderByComparator<SalesCustomer> orderByComparator)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerException {

		return getPersistence().findByUuid_C_PrevAndNext(
			salesCustomerId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the sales customers where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of sales customers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching sales customers
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the sales customer where userId = &#63; or throws a <code>NoSuchSalesCustomerException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching sales customer
	 * @throws NoSuchSalesCustomerException if a matching sales customer could not be found
	 */
	public static SalesCustomer findByUserId(long userId)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerException {

		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns the sales customer where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching sales customer, or <code>null</code> if a matching sales customer could not be found
	 */
	public static SalesCustomer fetchByUserId(long userId) {
		return getPersistence().fetchByUserId(userId);
	}

	/**
	 * Returns the sales customer where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sales customer, or <code>null</code> if a matching sales customer could not be found
	 */
	public static SalesCustomer fetchByUserId(
		long userId, boolean useFinderCache) {

		return getPersistence().fetchByUserId(userId, useFinderCache);
	}

	/**
	 * Removes the sales customer where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the sales customer that was removed
	 */
	public static SalesCustomer removeByUserId(long userId)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerException {

		return getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of sales customers where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching sales customers
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Caches the sales customer in the entity cache if it is enabled.
	 *
	 * @param salesCustomer the sales customer
	 */
	public static void cacheResult(SalesCustomer salesCustomer) {
		getPersistence().cacheResult(salesCustomer);
	}

	/**
	 * Caches the sales customers in the entity cache if it is enabled.
	 *
	 * @param salesCustomers the sales customers
	 */
	public static void cacheResult(List<SalesCustomer> salesCustomers) {
		getPersistence().cacheResult(salesCustomers);
	}

	/**
	 * Creates a new sales customer with the primary key. Does not add the sales customer to the database.
	 *
	 * @param salesCustomerId the primary key for the new sales customer
	 * @return the new sales customer
	 */
	public static SalesCustomer create(long salesCustomerId) {
		return getPersistence().create(salesCustomerId);
	}

	/**
	 * Removes the sales customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param salesCustomerId the primary key of the sales customer
	 * @return the sales customer that was removed
	 * @throws NoSuchSalesCustomerException if a sales customer with the primary key could not be found
	 */
	public static SalesCustomer remove(long salesCustomerId)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerException {

		return getPersistence().remove(salesCustomerId);
	}

	public static SalesCustomer updateImpl(SalesCustomer salesCustomer) {
		return getPersistence().updateImpl(salesCustomer);
	}

	/**
	 * Returns the sales customer with the primary key or throws a <code>NoSuchSalesCustomerException</code> if it could not be found.
	 *
	 * @param salesCustomerId the primary key of the sales customer
	 * @return the sales customer
	 * @throws NoSuchSalesCustomerException if a sales customer with the primary key could not be found
	 */
	public static SalesCustomer findByPrimaryKey(long salesCustomerId)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerException {

		return getPersistence().findByPrimaryKey(salesCustomerId);
	}

	/**
	 * Returns the sales customer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param salesCustomerId the primary key of the sales customer
	 * @return the sales customer, or <code>null</code> if a sales customer with the primary key could not be found
	 */
	public static SalesCustomer fetchByPrimaryKey(long salesCustomerId) {
		return getPersistence().fetchByPrimaryKey(salesCustomerId);
	}

	/**
	 * Returns all the sales customers.
	 *
	 * @return the sales customers
	 */
	public static List<SalesCustomer> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the sales customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sales customers
	 * @param end the upper bound of the range of sales customers (not inclusive)
	 * @return the range of sales customers
	 */
	public static List<SalesCustomer> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the sales customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sales customers
	 * @param end the upper bound of the range of sales customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sales customers
	 */
	public static List<SalesCustomer> findAll(
		int start, int end,
		OrderByComparator<SalesCustomer> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sales customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sales customers
	 * @param end the upper bound of the range of sales customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sales customers
	 */
	public static List<SalesCustomer> findAll(
		int start, int end, OrderByComparator<SalesCustomer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the sales customers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of sales customers.
	 *
	 * @return the number of sales customers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SalesCustomerPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SalesCustomerPersistence _persistence;

}