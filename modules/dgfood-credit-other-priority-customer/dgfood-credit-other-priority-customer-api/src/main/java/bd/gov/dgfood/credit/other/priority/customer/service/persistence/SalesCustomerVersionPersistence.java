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

import bd.gov.dgfood.credit.other.priority.customer.exception.NoSuchSalesCustomerVersionException;
import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerVersion;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the sales customer version service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SalesCustomerVersionUtil
 * @generated
 */
@ProviderType
public interface SalesCustomerVersionPersistence
	extends BasePersistence<SalesCustomerVersion> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SalesCustomerVersionUtil} to access the sales customer version persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the sales customer versions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sales customer versions
	 */
	public java.util.List<SalesCustomerVersion> findByUuid(String uuid);

	/**
	 * Returns a range of all the sales customer versions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sales customer versions
	 * @param end the upper bound of the range of sales customer versions (not inclusive)
	 * @return the range of matching sales customer versions
	 */
	public java.util.List<SalesCustomerVersion> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the sales customer versions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sales customer versions
	 * @param end the upper bound of the range of sales customer versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sales customer versions
	 */
	public java.util.List<SalesCustomerVersion> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalesCustomerVersion>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sales customer versions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sales customer versions
	 * @param end the upper bound of the range of sales customer versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sales customer versions
	 */
	public java.util.List<SalesCustomerVersion> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalesCustomerVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sales customer version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a matching sales customer version could not be found
	 */
	public SalesCustomerVersion findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<SalesCustomerVersion> orderByComparator)
		throws NoSuchSalesCustomerVersionException;

	/**
	 * Returns the first sales customer version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer version, or <code>null</code> if a matching sales customer version could not be found
	 */
	public SalesCustomerVersion fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SalesCustomerVersion>
			orderByComparator);

	/**
	 * Returns the last sales customer version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a matching sales customer version could not be found
	 */
	public SalesCustomerVersion findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<SalesCustomerVersion> orderByComparator)
		throws NoSuchSalesCustomerVersionException;

	/**
	 * Returns the last sales customer version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer version, or <code>null</code> if a matching sales customer version could not be found
	 */
	public SalesCustomerVersion fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SalesCustomerVersion>
			orderByComparator);

	/**
	 * Returns the sales customer versions before and after the current sales customer version in the ordered set where uuid = &#63;.
	 *
	 * @param salesCustomerVersionId the primary key of the current sales customer version
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a sales customer version with the primary key could not be found
	 */
	public SalesCustomerVersion[] findByUuid_PrevAndNext(
			long salesCustomerVersionId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<SalesCustomerVersion> orderByComparator)
		throws NoSuchSalesCustomerVersionException;

	/**
	 * Removes all the sales customer versions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of sales customer versions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sales customer versions
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the sales customer version where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSalesCustomerVersionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a matching sales customer version could not be found
	 */
	public SalesCustomerVersion findByUUID_G(String uuid, long groupId)
		throws NoSuchSalesCustomerVersionException;

	/**
	 * Returns the sales customer version where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sales customer version, or <code>null</code> if a matching sales customer version could not be found
	 */
	public SalesCustomerVersion fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the sales customer version where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sales customer version, or <code>null</code> if a matching sales customer version could not be found
	 */
	public SalesCustomerVersion fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the sales customer version where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the sales customer version that was removed
	 */
	public SalesCustomerVersion removeByUUID_G(String uuid, long groupId)
		throws NoSuchSalesCustomerVersionException;

	/**
	 * Returns the number of sales customer versions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching sales customer versions
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the sales customer versions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching sales customer versions
	 */
	public java.util.List<SalesCustomerVersion> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the sales customer versions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sales customer versions
	 * @param end the upper bound of the range of sales customer versions (not inclusive)
	 * @return the range of matching sales customer versions
	 */
	public java.util.List<SalesCustomerVersion> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the sales customer versions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sales customer versions
	 * @param end the upper bound of the range of sales customer versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sales customer versions
	 */
	public java.util.List<SalesCustomerVersion> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalesCustomerVersion>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sales customer versions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sales customer versions
	 * @param end the upper bound of the range of sales customer versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sales customer versions
	 */
	public java.util.List<SalesCustomerVersion> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalesCustomerVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sales customer version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a matching sales customer version could not be found
	 */
	public SalesCustomerVersion findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SalesCustomerVersion> orderByComparator)
		throws NoSuchSalesCustomerVersionException;

	/**
	 * Returns the first sales customer version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer version, or <code>null</code> if a matching sales customer version could not be found
	 */
	public SalesCustomerVersion fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SalesCustomerVersion>
			orderByComparator);

	/**
	 * Returns the last sales customer version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a matching sales customer version could not be found
	 */
	public SalesCustomerVersion findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SalesCustomerVersion> orderByComparator)
		throws NoSuchSalesCustomerVersionException;

	/**
	 * Returns the last sales customer version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer version, or <code>null</code> if a matching sales customer version could not be found
	 */
	public SalesCustomerVersion fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SalesCustomerVersion>
			orderByComparator);

	/**
	 * Returns the sales customer versions before and after the current sales customer version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param salesCustomerVersionId the primary key of the current sales customer version
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a sales customer version with the primary key could not be found
	 */
	public SalesCustomerVersion[] findByUuid_C_PrevAndNext(
			long salesCustomerVersionId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SalesCustomerVersion> orderByComparator)
		throws NoSuchSalesCustomerVersionException;

	/**
	 * Removes all the sales customer versions where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of sales customer versions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching sales customer versions
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the sales customer version where salesCustomerId = &#63; and version = &#63; or throws a <code>NoSuchSalesCustomerVersionException</code> if it could not be found.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param version the version
	 * @return the matching sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a matching sales customer version could not be found
	 */
	public SalesCustomerVersion findBySCI_V(
			long salesCustomerId, double version)
		throws NoSuchSalesCustomerVersionException;

	/**
	 * Returns the sales customer version where salesCustomerId = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param version the version
	 * @return the matching sales customer version, or <code>null</code> if a matching sales customer version could not be found
	 */
	public SalesCustomerVersion fetchBySCI_V(
		long salesCustomerId, double version);

	/**
	 * Returns the sales customer version where salesCustomerId = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param version the version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sales customer version, or <code>null</code> if a matching sales customer version could not be found
	 */
	public SalesCustomerVersion fetchBySCI_V(
		long salesCustomerId, double version, boolean useFinderCache);

	/**
	 * Removes the sales customer version where salesCustomerId = &#63; and version = &#63; from the database.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param version the version
	 * @return the sales customer version that was removed
	 */
	public SalesCustomerVersion removeBySCI_V(
			long salesCustomerId, double version)
		throws NoSuchSalesCustomerVersionException;

	/**
	 * Returns the number of sales customer versions where salesCustomerId = &#63; and version = &#63;.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param version the version
	 * @return the number of matching sales customer versions
	 */
	public int countBySCI_V(long salesCustomerId, double version);

	/**
	 * Returns all the sales customer versions where salesCustomerId = &#63;.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @return the matching sales customer versions
	 */
	public java.util.List<SalesCustomerVersion> findBySalesCustomerId(
		long salesCustomerId);

	/**
	 * Returns a range of all the sales customer versions where salesCustomerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerVersionModelImpl</code>.
	 * </p>
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param start the lower bound of the range of sales customer versions
	 * @param end the upper bound of the range of sales customer versions (not inclusive)
	 * @return the range of matching sales customer versions
	 */
	public java.util.List<SalesCustomerVersion> findBySalesCustomerId(
		long salesCustomerId, int start, int end);

	/**
	 * Returns an ordered range of all the sales customer versions where salesCustomerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerVersionModelImpl</code>.
	 * </p>
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param start the lower bound of the range of sales customer versions
	 * @param end the upper bound of the range of sales customer versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sales customer versions
	 */
	public java.util.List<SalesCustomerVersion> findBySalesCustomerId(
		long salesCustomerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalesCustomerVersion>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sales customer versions where salesCustomerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerVersionModelImpl</code>.
	 * </p>
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param start the lower bound of the range of sales customer versions
	 * @param end the upper bound of the range of sales customer versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sales customer versions
	 */
	public java.util.List<SalesCustomerVersion> findBySalesCustomerId(
		long salesCustomerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalesCustomerVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sales customer version in the ordered set where salesCustomerId = &#63;.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a matching sales customer version could not be found
	 */
	public SalesCustomerVersion findBySalesCustomerId_First(
			long salesCustomerId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SalesCustomerVersion> orderByComparator)
		throws NoSuchSalesCustomerVersionException;

	/**
	 * Returns the first sales customer version in the ordered set where salesCustomerId = &#63;.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer version, or <code>null</code> if a matching sales customer version could not be found
	 */
	public SalesCustomerVersion fetchBySalesCustomerId_First(
		long salesCustomerId,
		com.liferay.portal.kernel.util.OrderByComparator<SalesCustomerVersion>
			orderByComparator);

	/**
	 * Returns the last sales customer version in the ordered set where salesCustomerId = &#63;.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a matching sales customer version could not be found
	 */
	public SalesCustomerVersion findBySalesCustomerId_Last(
			long salesCustomerId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SalesCustomerVersion> orderByComparator)
		throws NoSuchSalesCustomerVersionException;

	/**
	 * Returns the last sales customer version in the ordered set where salesCustomerId = &#63;.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer version, or <code>null</code> if a matching sales customer version could not be found
	 */
	public SalesCustomerVersion fetchBySalesCustomerId_Last(
		long salesCustomerId,
		com.liferay.portal.kernel.util.OrderByComparator<SalesCustomerVersion>
			orderByComparator);

	/**
	 * Returns the sales customer versions before and after the current sales customer version in the ordered set where salesCustomerId = &#63;.
	 *
	 * @param salesCustomerVersionId the primary key of the current sales customer version
	 * @param salesCustomerId the sales customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a sales customer version with the primary key could not be found
	 */
	public SalesCustomerVersion[] findBySalesCustomerId_PrevAndNext(
			long salesCustomerVersionId, long salesCustomerId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SalesCustomerVersion> orderByComparator)
		throws NoSuchSalesCustomerVersionException;

	/**
	 * Removes all the sales customer versions where salesCustomerId = &#63; from the database.
	 *
	 * @param salesCustomerId the sales customer ID
	 */
	public void removeBySalesCustomerId(long salesCustomerId);

	/**
	 * Returns the number of sales customer versions where salesCustomerId = &#63;.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @return the number of matching sales customer versions
	 */
	public int countBySalesCustomerId(long salesCustomerId);

	/**
	 * Caches the sales customer version in the entity cache if it is enabled.
	 *
	 * @param salesCustomerVersion the sales customer version
	 */
	public void cacheResult(SalesCustomerVersion salesCustomerVersion);

	/**
	 * Caches the sales customer versions in the entity cache if it is enabled.
	 *
	 * @param salesCustomerVersions the sales customer versions
	 */
	public void cacheResult(
		java.util.List<SalesCustomerVersion> salesCustomerVersions);

	/**
	 * Creates a new sales customer version with the primary key. Does not add the sales customer version to the database.
	 *
	 * @param salesCustomerVersionId the primary key for the new sales customer version
	 * @return the new sales customer version
	 */
	public SalesCustomerVersion create(long salesCustomerVersionId);

	/**
	 * Removes the sales customer version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param salesCustomerVersionId the primary key of the sales customer version
	 * @return the sales customer version that was removed
	 * @throws NoSuchSalesCustomerVersionException if a sales customer version with the primary key could not be found
	 */
	public SalesCustomerVersion remove(long salesCustomerVersionId)
		throws NoSuchSalesCustomerVersionException;

	public SalesCustomerVersion updateImpl(
		SalesCustomerVersion salesCustomerVersion);

	/**
	 * Returns the sales customer version with the primary key or throws a <code>NoSuchSalesCustomerVersionException</code> if it could not be found.
	 *
	 * @param salesCustomerVersionId the primary key of the sales customer version
	 * @return the sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a sales customer version with the primary key could not be found
	 */
	public SalesCustomerVersion findByPrimaryKey(long salesCustomerVersionId)
		throws NoSuchSalesCustomerVersionException;

	/**
	 * Returns the sales customer version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param salesCustomerVersionId the primary key of the sales customer version
	 * @return the sales customer version, or <code>null</code> if a sales customer version with the primary key could not be found
	 */
	public SalesCustomerVersion fetchByPrimaryKey(long salesCustomerVersionId);

	/**
	 * Returns all the sales customer versions.
	 *
	 * @return the sales customer versions
	 */
	public java.util.List<SalesCustomerVersion> findAll();

	/**
	 * Returns a range of all the sales customer versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sales customer versions
	 * @param end the upper bound of the range of sales customer versions (not inclusive)
	 * @return the range of sales customer versions
	 */
	public java.util.List<SalesCustomerVersion> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the sales customer versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sales customer versions
	 * @param end the upper bound of the range of sales customer versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sales customer versions
	 */
	public java.util.List<SalesCustomerVersion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalesCustomerVersion>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sales customer versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sales customer versions
	 * @param end the upper bound of the range of sales customer versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sales customer versions
	 */
	public java.util.List<SalesCustomerVersion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalesCustomerVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sales customer versions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of sales customer versions.
	 *
	 * @return the number of sales customer versions
	 */
	public int countAll();

}