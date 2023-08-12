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

import bd.gov.dgfood.common.services.model.Indent;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the indent service. This utility wraps <code>bd.gov.dgfood.common.services.service.persistence.impl.IndentPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IndentPersistence
 * @generated
 */
public class IndentUtil {

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
	public static void clearCache(Indent indent) {
		getPersistence().clearCache(indent);
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
	public static Map<Serializable, Indent> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Indent> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Indent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Indent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Indent> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Indent update(Indent indent) {
		return getPersistence().update(indent);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Indent update(Indent indent, ServiceContext serviceContext) {
		return getPersistence().update(indent, serviceContext);
	}

	/**
	 * Returns all the indents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching indents
	 */
	public static List<Indent> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the indents where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of indents
	 * @param end the upper bound of the range of indents (not inclusive)
	 * @return the range of matching indents
	 */
	public static List<Indent> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the indents where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of indents
	 * @param end the upper bound of the range of indents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching indents
	 */
	public static List<Indent> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Indent> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the indents where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of indents
	 * @param end the upper bound of the range of indents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching indents
	 */
	public static List<Indent> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Indent> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first indent in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching indent
	 * @throws NoSuchIndentException if a matching indent could not be found
	 */
	public static Indent findByUuid_First(
			String uuid, OrderByComparator<Indent> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.NoSuchIndentException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first indent in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching indent, or <code>null</code> if a matching indent could not be found
	 */
	public static Indent fetchByUuid_First(
		String uuid, OrderByComparator<Indent> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last indent in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching indent
	 * @throws NoSuchIndentException if a matching indent could not be found
	 */
	public static Indent findByUuid_Last(
			String uuid, OrderByComparator<Indent> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.NoSuchIndentException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last indent in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching indent, or <code>null</code> if a matching indent could not be found
	 */
	public static Indent fetchByUuid_Last(
		String uuid, OrderByComparator<Indent> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the indents before and after the current indent in the ordered set where uuid = &#63;.
	 *
	 * @param indentId the primary key of the current indent
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next indent
	 * @throws NoSuchIndentException if a indent with the primary key could not be found
	 */
	public static Indent[] findByUuid_PrevAndNext(
			long indentId, String uuid,
			OrderByComparator<Indent> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.NoSuchIndentException {

		return getPersistence().findByUuid_PrevAndNext(
			indentId, uuid, orderByComparator);
	}

	/**
	 * Removes all the indents where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of indents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching indents
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the indent where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchIndentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching indent
	 * @throws NoSuchIndentException if a matching indent could not be found
	 */
	public static Indent findByUUID_G(String uuid, long groupId)
		throws bd.gov.dgfood.common.services.exception.NoSuchIndentException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the indent where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching indent, or <code>null</code> if a matching indent could not be found
	 */
	public static Indent fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the indent where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching indent, or <code>null</code> if a matching indent could not be found
	 */
	public static Indent fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the indent where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the indent that was removed
	 */
	public static Indent removeByUUID_G(String uuid, long groupId)
		throws bd.gov.dgfood.common.services.exception.NoSuchIndentException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of indents where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching indents
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the indents where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching indents
	 */
	public static List<Indent> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the indents where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of indents
	 * @param end the upper bound of the range of indents (not inclusive)
	 * @return the range of matching indents
	 */
	public static List<Indent> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the indents where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of indents
	 * @param end the upper bound of the range of indents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching indents
	 */
	public static List<Indent> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Indent> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the indents where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of indents
	 * @param end the upper bound of the range of indents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching indents
	 */
	public static List<Indent> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Indent> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first indent in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching indent
	 * @throws NoSuchIndentException if a matching indent could not be found
	 */
	public static Indent findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Indent> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.NoSuchIndentException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first indent in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching indent, or <code>null</code> if a matching indent could not be found
	 */
	public static Indent fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Indent> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last indent in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching indent
	 * @throws NoSuchIndentException if a matching indent could not be found
	 */
	public static Indent findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Indent> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.NoSuchIndentException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last indent in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching indent, or <code>null</code> if a matching indent could not be found
	 */
	public static Indent fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Indent> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the indents before and after the current indent in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param indentId the primary key of the current indent
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next indent
	 * @throws NoSuchIndentException if a indent with the primary key could not be found
	 */
	public static Indent[] findByUuid_C_PrevAndNext(
			long indentId, String uuid, long companyId,
			OrderByComparator<Indent> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.NoSuchIndentException {

		return getPersistence().findByUuid_C_PrevAndNext(
			indentId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the indents where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of indents where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching indents
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the indents where allocationId = &#63;.
	 *
	 * @param allocationId the allocation ID
	 * @return the matching indents
	 */
	public static List<Indent> findByAllocationId(long allocationId) {
		return getPersistence().findByAllocationId(allocationId);
	}

	/**
	 * Returns a range of all the indents where allocationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndentModelImpl</code>.
	 * </p>
	 *
	 * @param allocationId the allocation ID
	 * @param start the lower bound of the range of indents
	 * @param end the upper bound of the range of indents (not inclusive)
	 * @return the range of matching indents
	 */
	public static List<Indent> findByAllocationId(
		long allocationId, int start, int end) {

		return getPersistence().findByAllocationId(allocationId, start, end);
	}

	/**
	 * Returns an ordered range of all the indents where allocationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndentModelImpl</code>.
	 * </p>
	 *
	 * @param allocationId the allocation ID
	 * @param start the lower bound of the range of indents
	 * @param end the upper bound of the range of indents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching indents
	 */
	public static List<Indent> findByAllocationId(
		long allocationId, int start, int end,
		OrderByComparator<Indent> orderByComparator) {

		return getPersistence().findByAllocationId(
			allocationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the indents where allocationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndentModelImpl</code>.
	 * </p>
	 *
	 * @param allocationId the allocation ID
	 * @param start the lower bound of the range of indents
	 * @param end the upper bound of the range of indents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching indents
	 */
	public static List<Indent> findByAllocationId(
		long allocationId, int start, int end,
		OrderByComparator<Indent> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByAllocationId(
			allocationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first indent in the ordered set where allocationId = &#63;.
	 *
	 * @param allocationId the allocation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching indent
	 * @throws NoSuchIndentException if a matching indent could not be found
	 */
	public static Indent findByAllocationId_First(
			long allocationId, OrderByComparator<Indent> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.NoSuchIndentException {

		return getPersistence().findByAllocationId_First(
			allocationId, orderByComparator);
	}

	/**
	 * Returns the first indent in the ordered set where allocationId = &#63;.
	 *
	 * @param allocationId the allocation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching indent, or <code>null</code> if a matching indent could not be found
	 */
	public static Indent fetchByAllocationId_First(
		long allocationId, OrderByComparator<Indent> orderByComparator) {

		return getPersistence().fetchByAllocationId_First(
			allocationId, orderByComparator);
	}

	/**
	 * Returns the last indent in the ordered set where allocationId = &#63;.
	 *
	 * @param allocationId the allocation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching indent
	 * @throws NoSuchIndentException if a matching indent could not be found
	 */
	public static Indent findByAllocationId_Last(
			long allocationId, OrderByComparator<Indent> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.NoSuchIndentException {

		return getPersistence().findByAllocationId_Last(
			allocationId, orderByComparator);
	}

	/**
	 * Returns the last indent in the ordered set where allocationId = &#63;.
	 *
	 * @param allocationId the allocation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching indent, or <code>null</code> if a matching indent could not be found
	 */
	public static Indent fetchByAllocationId_Last(
		long allocationId, OrderByComparator<Indent> orderByComparator) {

		return getPersistence().fetchByAllocationId_Last(
			allocationId, orderByComparator);
	}

	/**
	 * Returns the indents before and after the current indent in the ordered set where allocationId = &#63;.
	 *
	 * @param indentId the primary key of the current indent
	 * @param allocationId the allocation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next indent
	 * @throws NoSuchIndentException if a indent with the primary key could not be found
	 */
	public static Indent[] findByAllocationId_PrevAndNext(
			long indentId, long allocationId,
			OrderByComparator<Indent> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.NoSuchIndentException {

		return getPersistence().findByAllocationId_PrevAndNext(
			indentId, allocationId, orderByComparator);
	}

	/**
	 * Removes all the indents where allocationId = &#63; from the database.
	 *
	 * @param allocationId the allocation ID
	 */
	public static void removeByAllocationId(long allocationId) {
		getPersistence().removeByAllocationId(allocationId);
	}

	/**
	 * Returns the number of indents where allocationId = &#63;.
	 *
	 * @param allocationId the allocation ID
	 * @return the number of matching indents
	 */
	public static int countByAllocationId(long allocationId) {
		return getPersistence().countByAllocationId(allocationId);
	}

	/**
	 * Caches the indent in the entity cache if it is enabled.
	 *
	 * @param indent the indent
	 */
	public static void cacheResult(Indent indent) {
		getPersistence().cacheResult(indent);
	}

	/**
	 * Caches the indents in the entity cache if it is enabled.
	 *
	 * @param indents the indents
	 */
	public static void cacheResult(List<Indent> indents) {
		getPersistence().cacheResult(indents);
	}

	/**
	 * Creates a new indent with the primary key. Does not add the indent to the database.
	 *
	 * @param indentId the primary key for the new indent
	 * @return the new indent
	 */
	public static Indent create(long indentId) {
		return getPersistence().create(indentId);
	}

	/**
	 * Removes the indent with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param indentId the primary key of the indent
	 * @return the indent that was removed
	 * @throws NoSuchIndentException if a indent with the primary key could not be found
	 */
	public static Indent remove(long indentId)
		throws bd.gov.dgfood.common.services.exception.NoSuchIndentException {

		return getPersistence().remove(indentId);
	}

	public static Indent updateImpl(Indent indent) {
		return getPersistence().updateImpl(indent);
	}

	/**
	 * Returns the indent with the primary key or throws a <code>NoSuchIndentException</code> if it could not be found.
	 *
	 * @param indentId the primary key of the indent
	 * @return the indent
	 * @throws NoSuchIndentException if a indent with the primary key could not be found
	 */
	public static Indent findByPrimaryKey(long indentId)
		throws bd.gov.dgfood.common.services.exception.NoSuchIndentException {

		return getPersistence().findByPrimaryKey(indentId);
	}

	/**
	 * Returns the indent with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param indentId the primary key of the indent
	 * @return the indent, or <code>null</code> if a indent with the primary key could not be found
	 */
	public static Indent fetchByPrimaryKey(long indentId) {
		return getPersistence().fetchByPrimaryKey(indentId);
	}

	/**
	 * Returns all the indents.
	 *
	 * @return the indents
	 */
	public static List<Indent> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the indents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of indents
	 * @param end the upper bound of the range of indents (not inclusive)
	 * @return the range of indents
	 */
	public static List<Indent> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the indents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of indents
	 * @param end the upper bound of the range of indents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of indents
	 */
	public static List<Indent> findAll(
		int start, int end, OrderByComparator<Indent> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the indents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of indents
	 * @param end the upper bound of the range of indents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of indents
	 */
	public static List<Indent> findAll(
		int start, int end, OrderByComparator<Indent> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the indents from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of indents.
	 *
	 * @return the number of indents
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static IndentPersistence getPersistence() {
		return _persistence;
	}

	private static volatile IndentPersistence _persistence;

}