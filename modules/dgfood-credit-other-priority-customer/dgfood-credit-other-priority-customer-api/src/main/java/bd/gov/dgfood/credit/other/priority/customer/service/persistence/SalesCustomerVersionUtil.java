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

import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerVersion;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the sales customer version service. This utility wraps <code>bd.gov.dgfood.credit.other.priority.customer.service.persistence.impl.SalesCustomerVersionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SalesCustomerVersionPersistence
 * @generated
 */
public class SalesCustomerVersionUtil {

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
	public static void clearCache(SalesCustomerVersion salesCustomerVersion) {
		getPersistence().clearCache(salesCustomerVersion);
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
	public static Map<Serializable, SalesCustomerVersion> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SalesCustomerVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SalesCustomerVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SalesCustomerVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SalesCustomerVersion> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SalesCustomerVersion update(
		SalesCustomerVersion salesCustomerVersion) {

		return getPersistence().update(salesCustomerVersion);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SalesCustomerVersion update(
		SalesCustomerVersion salesCustomerVersion,
		ServiceContext serviceContext) {

		return getPersistence().update(salesCustomerVersion, serviceContext);
	}

	/**
	 * Returns all the sales customer versions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sales customer versions
	 */
	public static List<SalesCustomerVersion> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<SalesCustomerVersion> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<SalesCustomerVersion> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SalesCustomerVersion> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<SalesCustomerVersion> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SalesCustomerVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sales customer version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a matching sales customer version could not be found
	 */
	public static SalesCustomerVersion findByUuid_First(
			String uuid,
			OrderByComparator<SalesCustomerVersion> orderByComparator)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerVersionException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first sales customer version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer version, or <code>null</code> if a matching sales customer version could not be found
	 */
	public static SalesCustomerVersion fetchByUuid_First(
		String uuid,
		OrderByComparator<SalesCustomerVersion> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last sales customer version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a matching sales customer version could not be found
	 */
	public static SalesCustomerVersion findByUuid_Last(
			String uuid,
			OrderByComparator<SalesCustomerVersion> orderByComparator)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerVersionException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last sales customer version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer version, or <code>null</code> if a matching sales customer version could not be found
	 */
	public static SalesCustomerVersion fetchByUuid_Last(
		String uuid,
		OrderByComparator<SalesCustomerVersion> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the sales customer versions before and after the current sales customer version in the ordered set where uuid = &#63;.
	 *
	 * @param salesCustomerVersionId the primary key of the current sales customer version
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a sales customer version with the primary key could not be found
	 */
	public static SalesCustomerVersion[] findByUuid_PrevAndNext(
			long salesCustomerVersionId, String uuid,
			OrderByComparator<SalesCustomerVersion> orderByComparator)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerVersionException {

		return getPersistence().findByUuid_PrevAndNext(
			salesCustomerVersionId, uuid, orderByComparator);
	}

	/**
	 * Removes all the sales customer versions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of sales customer versions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sales customer versions
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the sales customer version where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSalesCustomerVersionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a matching sales customer version could not be found
	 */
	public static SalesCustomerVersion findByUUID_G(String uuid, long groupId)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerVersionException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the sales customer version where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sales customer version, or <code>null</code> if a matching sales customer version could not be found
	 */
	public static SalesCustomerVersion fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the sales customer version where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sales customer version, or <code>null</code> if a matching sales customer version could not be found
	 */
	public static SalesCustomerVersion fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the sales customer version where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the sales customer version that was removed
	 */
	public static SalesCustomerVersion removeByUUID_G(String uuid, long groupId)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerVersionException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of sales customer versions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching sales customer versions
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the sales customer versions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching sales customer versions
	 */
	public static List<SalesCustomerVersion> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<SalesCustomerVersion> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<SalesCustomerVersion> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SalesCustomerVersion> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<SalesCustomerVersion> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SalesCustomerVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sales customer version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a matching sales customer version could not be found
	 */
	public static SalesCustomerVersion findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<SalesCustomerVersion> orderByComparator)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerVersionException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first sales customer version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer version, or <code>null</code> if a matching sales customer version could not be found
	 */
	public static SalesCustomerVersion fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<SalesCustomerVersion> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last sales customer version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a matching sales customer version could not be found
	 */
	public static SalesCustomerVersion findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<SalesCustomerVersion> orderByComparator)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerVersionException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last sales customer version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer version, or <code>null</code> if a matching sales customer version could not be found
	 */
	public static SalesCustomerVersion fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<SalesCustomerVersion> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static SalesCustomerVersion[] findByUuid_C_PrevAndNext(
			long salesCustomerVersionId, String uuid, long companyId,
			OrderByComparator<SalesCustomerVersion> orderByComparator)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerVersionException {

		return getPersistence().findByUuid_C_PrevAndNext(
			salesCustomerVersionId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the sales customer versions where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of sales customer versions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching sales customer versions
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the sales customer version where salesCustomerId = &#63; and version = &#63; or throws a <code>NoSuchSalesCustomerVersionException</code> if it could not be found.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param version the version
	 * @return the matching sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a matching sales customer version could not be found
	 */
	public static SalesCustomerVersion findBySCI_V(
			long salesCustomerId, double version)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerVersionException {

		return getPersistence().findBySCI_V(salesCustomerId, version);
	}

	/**
	 * Returns the sales customer version where salesCustomerId = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param version the version
	 * @return the matching sales customer version, or <code>null</code> if a matching sales customer version could not be found
	 */
	public static SalesCustomerVersion fetchBySCI_V(
		long salesCustomerId, double version) {

		return getPersistence().fetchBySCI_V(salesCustomerId, version);
	}

	/**
	 * Returns the sales customer version where salesCustomerId = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param version the version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sales customer version, or <code>null</code> if a matching sales customer version could not be found
	 */
	public static SalesCustomerVersion fetchBySCI_V(
		long salesCustomerId, double version, boolean useFinderCache) {

		return getPersistence().fetchBySCI_V(
			salesCustomerId, version, useFinderCache);
	}

	/**
	 * Removes the sales customer version where salesCustomerId = &#63; and version = &#63; from the database.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param version the version
	 * @return the sales customer version that was removed
	 */
	public static SalesCustomerVersion removeBySCI_V(
			long salesCustomerId, double version)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerVersionException {

		return getPersistence().removeBySCI_V(salesCustomerId, version);
	}

	/**
	 * Returns the number of sales customer versions where salesCustomerId = &#63; and version = &#63;.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param version the version
	 * @return the number of matching sales customer versions
	 */
	public static int countBySCI_V(long salesCustomerId, double version) {
		return getPersistence().countBySCI_V(salesCustomerId, version);
	}

	/**
	 * Returns all the sales customer versions where salesCustomerId = &#63;.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @return the matching sales customer versions
	 */
	public static List<SalesCustomerVersion> findBySalesCustomerId(
		long salesCustomerId) {

		return getPersistence().findBySalesCustomerId(salesCustomerId);
	}

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
	public static List<SalesCustomerVersion> findBySalesCustomerId(
		long salesCustomerId, int start, int end) {

		return getPersistence().findBySalesCustomerId(
			salesCustomerId, start, end);
	}

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
	public static List<SalesCustomerVersion> findBySalesCustomerId(
		long salesCustomerId, int start, int end,
		OrderByComparator<SalesCustomerVersion> orderByComparator) {

		return getPersistence().findBySalesCustomerId(
			salesCustomerId, start, end, orderByComparator);
	}

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
	public static List<SalesCustomerVersion> findBySalesCustomerId(
		long salesCustomerId, int start, int end,
		OrderByComparator<SalesCustomerVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySalesCustomerId(
			salesCustomerId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sales customer version in the ordered set where salesCustomerId = &#63;.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a matching sales customer version could not be found
	 */
	public static SalesCustomerVersion findBySalesCustomerId_First(
			long salesCustomerId,
			OrderByComparator<SalesCustomerVersion> orderByComparator)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerVersionException {

		return getPersistence().findBySalesCustomerId_First(
			salesCustomerId, orderByComparator);
	}

	/**
	 * Returns the first sales customer version in the ordered set where salesCustomerId = &#63;.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer version, or <code>null</code> if a matching sales customer version could not be found
	 */
	public static SalesCustomerVersion fetchBySalesCustomerId_First(
		long salesCustomerId,
		OrderByComparator<SalesCustomerVersion> orderByComparator) {

		return getPersistence().fetchBySalesCustomerId_First(
			salesCustomerId, orderByComparator);
	}

	/**
	 * Returns the last sales customer version in the ordered set where salesCustomerId = &#63;.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a matching sales customer version could not be found
	 */
	public static SalesCustomerVersion findBySalesCustomerId_Last(
			long salesCustomerId,
			OrderByComparator<SalesCustomerVersion> orderByComparator)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerVersionException {

		return getPersistence().findBySalesCustomerId_Last(
			salesCustomerId, orderByComparator);
	}

	/**
	 * Returns the last sales customer version in the ordered set where salesCustomerId = &#63;.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer version, or <code>null</code> if a matching sales customer version could not be found
	 */
	public static SalesCustomerVersion fetchBySalesCustomerId_Last(
		long salesCustomerId,
		OrderByComparator<SalesCustomerVersion> orderByComparator) {

		return getPersistence().fetchBySalesCustomerId_Last(
			salesCustomerId, orderByComparator);
	}

	/**
	 * Returns the sales customer versions before and after the current sales customer version in the ordered set where salesCustomerId = &#63;.
	 *
	 * @param salesCustomerVersionId the primary key of the current sales customer version
	 * @param salesCustomerId the sales customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a sales customer version with the primary key could not be found
	 */
	public static SalesCustomerVersion[] findBySalesCustomerId_PrevAndNext(
			long salesCustomerVersionId, long salesCustomerId,
			OrderByComparator<SalesCustomerVersion> orderByComparator)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerVersionException {

		return getPersistence().findBySalesCustomerId_PrevAndNext(
			salesCustomerVersionId, salesCustomerId, orderByComparator);
	}

	/**
	 * Removes all the sales customer versions where salesCustomerId = &#63; from the database.
	 *
	 * @param salesCustomerId the sales customer ID
	 */
	public static void removeBySalesCustomerId(long salesCustomerId) {
		getPersistence().removeBySalesCustomerId(salesCustomerId);
	}

	/**
	 * Returns the number of sales customer versions where salesCustomerId = &#63;.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @return the number of matching sales customer versions
	 */
	public static int countBySalesCustomerId(long salesCustomerId) {
		return getPersistence().countBySalesCustomerId(salesCustomerId);
	}

	/**
	 * Caches the sales customer version in the entity cache if it is enabled.
	 *
	 * @param salesCustomerVersion the sales customer version
	 */
	public static void cacheResult(SalesCustomerVersion salesCustomerVersion) {
		getPersistence().cacheResult(salesCustomerVersion);
	}

	/**
	 * Caches the sales customer versions in the entity cache if it is enabled.
	 *
	 * @param salesCustomerVersions the sales customer versions
	 */
	public static void cacheResult(
		List<SalesCustomerVersion> salesCustomerVersions) {

		getPersistence().cacheResult(salesCustomerVersions);
	}

	/**
	 * Creates a new sales customer version with the primary key. Does not add the sales customer version to the database.
	 *
	 * @param salesCustomerVersionId the primary key for the new sales customer version
	 * @return the new sales customer version
	 */
	public static SalesCustomerVersion create(long salesCustomerVersionId) {
		return getPersistence().create(salesCustomerVersionId);
	}

	/**
	 * Removes the sales customer version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param salesCustomerVersionId the primary key of the sales customer version
	 * @return the sales customer version that was removed
	 * @throws NoSuchSalesCustomerVersionException if a sales customer version with the primary key could not be found
	 */
	public static SalesCustomerVersion remove(long salesCustomerVersionId)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerVersionException {

		return getPersistence().remove(salesCustomerVersionId);
	}

	public static SalesCustomerVersion updateImpl(
		SalesCustomerVersion salesCustomerVersion) {

		return getPersistence().updateImpl(salesCustomerVersion);
	}

	/**
	 * Returns the sales customer version with the primary key or throws a <code>NoSuchSalesCustomerVersionException</code> if it could not be found.
	 *
	 * @param salesCustomerVersionId the primary key of the sales customer version
	 * @return the sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a sales customer version with the primary key could not be found
	 */
	public static SalesCustomerVersion findByPrimaryKey(
			long salesCustomerVersionId)
		throws bd.gov.dgfood.credit.other.priority.customer.exception.
			NoSuchSalesCustomerVersionException {

		return getPersistence().findByPrimaryKey(salesCustomerVersionId);
	}

	/**
	 * Returns the sales customer version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param salesCustomerVersionId the primary key of the sales customer version
	 * @return the sales customer version, or <code>null</code> if a sales customer version with the primary key could not be found
	 */
	public static SalesCustomerVersion fetchByPrimaryKey(
		long salesCustomerVersionId) {

		return getPersistence().fetchByPrimaryKey(salesCustomerVersionId);
	}

	/**
	 * Returns all the sales customer versions.
	 *
	 * @return the sales customer versions
	 */
	public static List<SalesCustomerVersion> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<SalesCustomerVersion> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<SalesCustomerVersion> findAll(
		int start, int end,
		OrderByComparator<SalesCustomerVersion> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<SalesCustomerVersion> findAll(
		int start, int end,
		OrderByComparator<SalesCustomerVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the sales customer versions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of sales customer versions.
	 *
	 * @return the number of sales customer versions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SalesCustomerVersionPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SalesCustomerVersionPersistence _persistence;

}