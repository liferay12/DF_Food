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

import bd.gov.dgfood.credit.other.priority.customer.exception.NoSuchSalesCustomerException;
import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the sales customer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SalesCustomerUtil
 * @generated
 */
@ProviderType
public interface SalesCustomerPersistence
	extends BasePersistence<SalesCustomer> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SalesCustomerUtil} to access the sales customer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the sales customers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sales customers
	 */
	public java.util.List<SalesCustomer> findByUuid(String uuid);

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
	public java.util.List<SalesCustomer> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<SalesCustomer> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalesCustomer>
			orderByComparator);

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
	public java.util.List<SalesCustomer> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalesCustomer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sales customer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer
	 * @throws NoSuchSalesCustomerException if a matching sales customer could not be found
	 */
	public SalesCustomer findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SalesCustomer>
				orderByComparator)
		throws NoSuchSalesCustomerException;

	/**
	 * Returns the first sales customer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer, or <code>null</code> if a matching sales customer could not be found
	 */
	public SalesCustomer fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SalesCustomer>
			orderByComparator);

	/**
	 * Returns the last sales customer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer
	 * @throws NoSuchSalesCustomerException if a matching sales customer could not be found
	 */
	public SalesCustomer findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SalesCustomer>
				orderByComparator)
		throws NoSuchSalesCustomerException;

	/**
	 * Returns the last sales customer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer, or <code>null</code> if a matching sales customer could not be found
	 */
	public SalesCustomer fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SalesCustomer>
			orderByComparator);

	/**
	 * Returns the sales customers before and after the current sales customer in the ordered set where uuid = &#63;.
	 *
	 * @param salesCustomerId the primary key of the current sales customer
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sales customer
	 * @throws NoSuchSalesCustomerException if a sales customer with the primary key could not be found
	 */
	public SalesCustomer[] findByUuid_PrevAndNext(
			long salesCustomerId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SalesCustomer>
				orderByComparator)
		throws NoSuchSalesCustomerException;

	/**
	 * Removes all the sales customers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of sales customers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sales customers
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the sales customer where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSalesCustomerException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sales customer
	 * @throws NoSuchSalesCustomerException if a matching sales customer could not be found
	 */
	public SalesCustomer findByUUID_G(String uuid, long groupId)
		throws NoSuchSalesCustomerException;

	/**
	 * Returns the sales customer where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sales customer, or <code>null</code> if a matching sales customer could not be found
	 */
	public SalesCustomer fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the sales customer where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sales customer, or <code>null</code> if a matching sales customer could not be found
	 */
	public SalesCustomer fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the sales customer where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the sales customer that was removed
	 */
	public SalesCustomer removeByUUID_G(String uuid, long groupId)
		throws NoSuchSalesCustomerException;

	/**
	 * Returns the number of sales customers where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching sales customers
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the sales customers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching sales customers
	 */
	public java.util.List<SalesCustomer> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<SalesCustomer> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<SalesCustomer> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalesCustomer>
			orderByComparator);

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
	public java.util.List<SalesCustomer> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalesCustomer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sales customer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer
	 * @throws NoSuchSalesCustomerException if a matching sales customer could not be found
	 */
	public SalesCustomer findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SalesCustomer>
				orderByComparator)
		throws NoSuchSalesCustomerException;

	/**
	 * Returns the first sales customer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer, or <code>null</code> if a matching sales customer could not be found
	 */
	public SalesCustomer fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SalesCustomer>
			orderByComparator);

	/**
	 * Returns the last sales customer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer
	 * @throws NoSuchSalesCustomerException if a matching sales customer could not be found
	 */
	public SalesCustomer findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SalesCustomer>
				orderByComparator)
		throws NoSuchSalesCustomerException;

	/**
	 * Returns the last sales customer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer, or <code>null</code> if a matching sales customer could not be found
	 */
	public SalesCustomer fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SalesCustomer>
			orderByComparator);

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
	public SalesCustomer[] findByUuid_C_PrevAndNext(
			long salesCustomerId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SalesCustomer>
				orderByComparator)
		throws NoSuchSalesCustomerException;

	/**
	 * Removes all the sales customers where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of sales customers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching sales customers
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the sales customer where userId = &#63; or throws a <code>NoSuchSalesCustomerException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching sales customer
	 * @throws NoSuchSalesCustomerException if a matching sales customer could not be found
	 */
	public SalesCustomer findByUserId(long userId)
		throws NoSuchSalesCustomerException;

	/**
	 * Returns the sales customer where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching sales customer, or <code>null</code> if a matching sales customer could not be found
	 */
	public SalesCustomer fetchByUserId(long userId);

	/**
	 * Returns the sales customer where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sales customer, or <code>null</code> if a matching sales customer could not be found
	 */
	public SalesCustomer fetchByUserId(long userId, boolean useFinderCache);

	/**
	 * Removes the sales customer where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the sales customer that was removed
	 */
	public SalesCustomer removeByUserId(long userId)
		throws NoSuchSalesCustomerException;

	/**
	 * Returns the number of sales customers where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching sales customers
	 */
	public int countByUserId(long userId);

	/**
	 * Caches the sales customer in the entity cache if it is enabled.
	 *
	 * @param salesCustomer the sales customer
	 */
	public void cacheResult(SalesCustomer salesCustomer);

	/**
	 * Caches the sales customers in the entity cache if it is enabled.
	 *
	 * @param salesCustomers the sales customers
	 */
	public void cacheResult(java.util.List<SalesCustomer> salesCustomers);

	/**
	 * Creates a new sales customer with the primary key. Does not add the sales customer to the database.
	 *
	 * @param salesCustomerId the primary key for the new sales customer
	 * @return the new sales customer
	 */
	public SalesCustomer create(long salesCustomerId);

	/**
	 * Removes the sales customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param salesCustomerId the primary key of the sales customer
	 * @return the sales customer that was removed
	 * @throws NoSuchSalesCustomerException if a sales customer with the primary key could not be found
	 */
	public SalesCustomer remove(long salesCustomerId)
		throws NoSuchSalesCustomerException;

	public SalesCustomer updateImpl(SalesCustomer salesCustomer);

	/**
	 * Returns the sales customer with the primary key or throws a <code>NoSuchSalesCustomerException</code> if it could not be found.
	 *
	 * @param salesCustomerId the primary key of the sales customer
	 * @return the sales customer
	 * @throws NoSuchSalesCustomerException if a sales customer with the primary key could not be found
	 */
	public SalesCustomer findByPrimaryKey(long salesCustomerId)
		throws NoSuchSalesCustomerException;

	/**
	 * Returns the sales customer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param salesCustomerId the primary key of the sales customer
	 * @return the sales customer, or <code>null</code> if a sales customer with the primary key could not be found
	 */
	public SalesCustomer fetchByPrimaryKey(long salesCustomerId);

	/**
	 * Returns all the sales customers.
	 *
	 * @return the sales customers
	 */
	public java.util.List<SalesCustomer> findAll();

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
	public java.util.List<SalesCustomer> findAll(int start, int end);

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
	public java.util.List<SalesCustomer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalesCustomer>
			orderByComparator);

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
	public java.util.List<SalesCustomer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalesCustomer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sales customers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of sales customers.
	 *
	 * @return the number of sales customers
	 */
	public int countAll();

}