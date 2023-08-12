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

import bd.gov.dgfood.credit.other.priority.customer.exception.NoSuchSalesCustomerAllocationException;
import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerAllocation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the sales customer allocation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SalesCustomerAllocationUtil
 * @generated
 */
@ProviderType
public interface SalesCustomerAllocationPersistence
	extends BasePersistence<SalesCustomerAllocation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SalesCustomerAllocationUtil} to access the sales customer allocation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the sales customer allocations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sales customer allocations
	 */
	public java.util.List<SalesCustomerAllocation> findByUuid(String uuid);

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
	public java.util.List<SalesCustomerAllocation> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<SalesCustomerAllocation> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<SalesCustomerAllocation> orderByComparator);

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
	public java.util.List<SalesCustomerAllocation> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<SalesCustomerAllocation> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sales customer allocation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer allocation
	 * @throws NoSuchSalesCustomerAllocationException if a matching sales customer allocation could not be found
	 */
	public SalesCustomerAllocation findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<SalesCustomerAllocation> orderByComparator)
		throws NoSuchSalesCustomerAllocationException;

	/**
	 * Returns the first sales customer allocation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer allocation, or <code>null</code> if a matching sales customer allocation could not be found
	 */
	public SalesCustomerAllocation fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<SalesCustomerAllocation> orderByComparator);

	/**
	 * Returns the last sales customer allocation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer allocation
	 * @throws NoSuchSalesCustomerAllocationException if a matching sales customer allocation could not be found
	 */
	public SalesCustomerAllocation findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<SalesCustomerAllocation> orderByComparator)
		throws NoSuchSalesCustomerAllocationException;

	/**
	 * Returns the last sales customer allocation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer allocation, or <code>null</code> if a matching sales customer allocation could not be found
	 */
	public SalesCustomerAllocation fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<SalesCustomerAllocation> orderByComparator);

	/**
	 * Returns the sales customer allocations before and after the current sales customer allocation in the ordered set where uuid = &#63;.
	 *
	 * @param salesCustomerAllocationId the primary key of the current sales customer allocation
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sales customer allocation
	 * @throws NoSuchSalesCustomerAllocationException if a sales customer allocation with the primary key could not be found
	 */
	public SalesCustomerAllocation[] findByUuid_PrevAndNext(
			long salesCustomerAllocationId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<SalesCustomerAllocation> orderByComparator)
		throws NoSuchSalesCustomerAllocationException;

	/**
	 * Removes all the sales customer allocations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of sales customer allocations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sales customer allocations
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the sales customer allocations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching sales customer allocations
	 */
	public java.util.List<SalesCustomerAllocation> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<SalesCustomerAllocation> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<SalesCustomerAllocation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<SalesCustomerAllocation> orderByComparator);

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
	public java.util.List<SalesCustomerAllocation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<SalesCustomerAllocation> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sales customer allocation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer allocation
	 * @throws NoSuchSalesCustomerAllocationException if a matching sales customer allocation could not be found
	 */
	public SalesCustomerAllocation findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SalesCustomerAllocation> orderByComparator)
		throws NoSuchSalesCustomerAllocationException;

	/**
	 * Returns the first sales customer allocation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer allocation, or <code>null</code> if a matching sales customer allocation could not be found
	 */
	public SalesCustomerAllocation fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<SalesCustomerAllocation> orderByComparator);

	/**
	 * Returns the last sales customer allocation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer allocation
	 * @throws NoSuchSalesCustomerAllocationException if a matching sales customer allocation could not be found
	 */
	public SalesCustomerAllocation findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SalesCustomerAllocation> orderByComparator)
		throws NoSuchSalesCustomerAllocationException;

	/**
	 * Returns the last sales customer allocation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer allocation, or <code>null</code> if a matching sales customer allocation could not be found
	 */
	public SalesCustomerAllocation fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<SalesCustomerAllocation> orderByComparator);

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
	public SalesCustomerAllocation[] findByUuid_C_PrevAndNext(
			long salesCustomerAllocationId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SalesCustomerAllocation> orderByComparator)
		throws NoSuchSalesCustomerAllocationException;

	/**
	 * Removes all the sales customer allocations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of sales customer allocations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching sales customer allocations
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the sales customer allocation in the entity cache if it is enabled.
	 *
	 * @param salesCustomerAllocation the sales customer allocation
	 */
	public void cacheResult(SalesCustomerAllocation salesCustomerAllocation);

	/**
	 * Caches the sales customer allocations in the entity cache if it is enabled.
	 *
	 * @param salesCustomerAllocations the sales customer allocations
	 */
	public void cacheResult(
		java.util.List<SalesCustomerAllocation> salesCustomerAllocations);

	/**
	 * Creates a new sales customer allocation with the primary key. Does not add the sales customer allocation to the database.
	 *
	 * @param salesCustomerAllocationId the primary key for the new sales customer allocation
	 * @return the new sales customer allocation
	 */
	public SalesCustomerAllocation create(long salesCustomerAllocationId);

	/**
	 * Removes the sales customer allocation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param salesCustomerAllocationId the primary key of the sales customer allocation
	 * @return the sales customer allocation that was removed
	 * @throws NoSuchSalesCustomerAllocationException if a sales customer allocation with the primary key could not be found
	 */
	public SalesCustomerAllocation remove(long salesCustomerAllocationId)
		throws NoSuchSalesCustomerAllocationException;

	public SalesCustomerAllocation updateImpl(
		SalesCustomerAllocation salesCustomerAllocation);

	/**
	 * Returns the sales customer allocation with the primary key or throws a <code>NoSuchSalesCustomerAllocationException</code> if it could not be found.
	 *
	 * @param salesCustomerAllocationId the primary key of the sales customer allocation
	 * @return the sales customer allocation
	 * @throws NoSuchSalesCustomerAllocationException if a sales customer allocation with the primary key could not be found
	 */
	public SalesCustomerAllocation findByPrimaryKey(
			long salesCustomerAllocationId)
		throws NoSuchSalesCustomerAllocationException;

	/**
	 * Returns the sales customer allocation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param salesCustomerAllocationId the primary key of the sales customer allocation
	 * @return the sales customer allocation, or <code>null</code> if a sales customer allocation with the primary key could not be found
	 */
	public SalesCustomerAllocation fetchByPrimaryKey(
		long salesCustomerAllocationId);

	/**
	 * Returns all the sales customer allocations.
	 *
	 * @return the sales customer allocations
	 */
	public java.util.List<SalesCustomerAllocation> findAll();

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
	public java.util.List<SalesCustomerAllocation> findAll(int start, int end);

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
	public java.util.List<SalesCustomerAllocation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<SalesCustomerAllocation> orderByComparator);

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
	public java.util.List<SalesCustomerAllocation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<SalesCustomerAllocation> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sales customer allocations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of sales customer allocations.
	 *
	 * @return the number of sales customer allocations
	 */
	public int countAll();

}