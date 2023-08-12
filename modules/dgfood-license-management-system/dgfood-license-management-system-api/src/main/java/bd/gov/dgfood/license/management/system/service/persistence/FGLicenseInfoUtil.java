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

package bd.gov.dgfood.license.management.system.service.persistence;

import bd.gov.dgfood.license.management.system.model.FGLicenseInfo;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the fg license info service. This utility wraps <code>bd.gov.dgfood.license.management.system.service.persistence.impl.FGLicenseInfoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FGLicenseInfoPersistence
 * @generated
 */
public class FGLicenseInfoUtil {

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
	public static void clearCache(FGLicenseInfo fgLicenseInfo) {
		getPersistence().clearCache(fgLicenseInfo);
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
	public static Map<Serializable, FGLicenseInfo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FGLicenseInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FGLicenseInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FGLicenseInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FGLicenseInfo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FGLicenseInfo update(FGLicenseInfo fgLicenseInfo) {
		return getPersistence().update(fgLicenseInfo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FGLicenseInfo update(
		FGLicenseInfo fgLicenseInfo, ServiceContext serviceContext) {

		return getPersistence().update(fgLicenseInfo, serviceContext);
	}

	/**
	 * Returns all the fg license infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching fg license infos
	 */
	public static List<FGLicenseInfo> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the fg license infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fg license infos
	 * @param end the upper bound of the range of fg license infos (not inclusive)
	 * @return the range of matching fg license infos
	 */
	public static List<FGLicenseInfo> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the fg license infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fg license infos
	 * @param end the upper bound of the range of fg license infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fg license infos
	 */
	public static List<FGLicenseInfo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FGLicenseInfo> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the fg license infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fg license infos
	 * @param end the upper bound of the range of fg license infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching fg license infos
	 */
	public static List<FGLicenseInfo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FGLicenseInfo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first fg license info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fg license info
	 * @throws NoSuchFGLicenseInfoException if a matching fg license info could not be found
	 */
	public static FGLicenseInfo findByUuid_First(
			String uuid, OrderByComparator<FGLicenseInfo> orderByComparator)
		throws bd.gov.dgfood.license.management.system.exception.
			NoSuchFGLicenseInfoException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first fg license info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	public static FGLicenseInfo fetchByUuid_First(
		String uuid, OrderByComparator<FGLicenseInfo> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last fg license info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fg license info
	 * @throws NoSuchFGLicenseInfoException if a matching fg license info could not be found
	 */
	public static FGLicenseInfo findByUuid_Last(
			String uuid, OrderByComparator<FGLicenseInfo> orderByComparator)
		throws bd.gov.dgfood.license.management.system.exception.
			NoSuchFGLicenseInfoException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last fg license info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	public static FGLicenseInfo fetchByUuid_Last(
		String uuid, OrderByComparator<FGLicenseInfo> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the fg license infos before and after the current fg license info in the ordered set where uuid = &#63;.
	 *
	 * @param fgLicenseInfoId the primary key of the current fg license info
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fg license info
	 * @throws NoSuchFGLicenseInfoException if a fg license info with the primary key could not be found
	 */
	public static FGLicenseInfo[] findByUuid_PrevAndNext(
			long fgLicenseInfoId, String uuid,
			OrderByComparator<FGLicenseInfo> orderByComparator)
		throws bd.gov.dgfood.license.management.system.exception.
			NoSuchFGLicenseInfoException {

		return getPersistence().findByUuid_PrevAndNext(
			fgLicenseInfoId, uuid, orderByComparator);
	}

	/**
	 * Removes all the fg license infos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of fg license infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching fg license infos
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the fg license info where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFGLicenseInfoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching fg license info
	 * @throws NoSuchFGLicenseInfoException if a matching fg license info could not be found
	 */
	public static FGLicenseInfo findByUUID_G(String uuid, long groupId)
		throws bd.gov.dgfood.license.management.system.exception.
			NoSuchFGLicenseInfoException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the fg license info where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	public static FGLicenseInfo fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the fg license info where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	public static FGLicenseInfo fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the fg license info where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the fg license info that was removed
	 */
	public static FGLicenseInfo removeByUUID_G(String uuid, long groupId)
		throws bd.gov.dgfood.license.management.system.exception.
			NoSuchFGLicenseInfoException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of fg license infos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching fg license infos
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the fg license infos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching fg license infos
	 */
	public static List<FGLicenseInfo> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the fg license infos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of fg license infos
	 * @param end the upper bound of the range of fg license infos (not inclusive)
	 * @return the range of matching fg license infos
	 */
	public static List<FGLicenseInfo> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the fg license infos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of fg license infos
	 * @param end the upper bound of the range of fg license infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fg license infos
	 */
	public static List<FGLicenseInfo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FGLicenseInfo> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the fg license infos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of fg license infos
	 * @param end the upper bound of the range of fg license infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching fg license infos
	 */
	public static List<FGLicenseInfo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FGLicenseInfo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first fg license info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fg license info
	 * @throws NoSuchFGLicenseInfoException if a matching fg license info could not be found
	 */
	public static FGLicenseInfo findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FGLicenseInfo> orderByComparator)
		throws bd.gov.dgfood.license.management.system.exception.
			NoSuchFGLicenseInfoException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first fg license info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	public static FGLicenseInfo fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FGLicenseInfo> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last fg license info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fg license info
	 * @throws NoSuchFGLicenseInfoException if a matching fg license info could not be found
	 */
	public static FGLicenseInfo findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FGLicenseInfo> orderByComparator)
		throws bd.gov.dgfood.license.management.system.exception.
			NoSuchFGLicenseInfoException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last fg license info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	public static FGLicenseInfo fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FGLicenseInfo> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the fg license infos before and after the current fg license info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param fgLicenseInfoId the primary key of the current fg license info
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fg license info
	 * @throws NoSuchFGLicenseInfoException if a fg license info with the primary key could not be found
	 */
	public static FGLicenseInfo[] findByUuid_C_PrevAndNext(
			long fgLicenseInfoId, String uuid, long companyId,
			OrderByComparator<FGLicenseInfo> orderByComparator)
		throws bd.gov.dgfood.license.management.system.exception.
			NoSuchFGLicenseInfoException {

		return getPersistence().findByUuid_C_PrevAndNext(
			fgLicenseInfoId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the fg license infos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of fg license infos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching fg license infos
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the fg license infos where nationalId = &#63; and status = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param status the status
	 * @return the matching fg license infos
	 */
	public static List<FGLicenseInfo> findByNationalIdAndStatus(
		String nationalId, int status) {

		return getPersistence().findByNationalIdAndStatus(nationalId, status);
	}

	/**
	 * Returns a range of all the fg license infos where nationalId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseInfoModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param status the status
	 * @param start the lower bound of the range of fg license infos
	 * @param end the upper bound of the range of fg license infos (not inclusive)
	 * @return the range of matching fg license infos
	 */
	public static List<FGLicenseInfo> findByNationalIdAndStatus(
		String nationalId, int status, int start, int end) {

		return getPersistence().findByNationalIdAndStatus(
			nationalId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the fg license infos where nationalId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseInfoModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param status the status
	 * @param start the lower bound of the range of fg license infos
	 * @param end the upper bound of the range of fg license infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fg license infos
	 */
	public static List<FGLicenseInfo> findByNationalIdAndStatus(
		String nationalId, int status, int start, int end,
		OrderByComparator<FGLicenseInfo> orderByComparator) {

		return getPersistence().findByNationalIdAndStatus(
			nationalId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the fg license infos where nationalId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseInfoModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param status the status
	 * @param start the lower bound of the range of fg license infos
	 * @param end the upper bound of the range of fg license infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching fg license infos
	 */
	public static List<FGLicenseInfo> findByNationalIdAndStatus(
		String nationalId, int status, int start, int end,
		OrderByComparator<FGLicenseInfo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByNationalIdAndStatus(
			nationalId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first fg license info in the ordered set where nationalId = &#63; and status = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fg license info
	 * @throws NoSuchFGLicenseInfoException if a matching fg license info could not be found
	 */
	public static FGLicenseInfo findByNationalIdAndStatus_First(
			String nationalId, int status,
			OrderByComparator<FGLicenseInfo> orderByComparator)
		throws bd.gov.dgfood.license.management.system.exception.
			NoSuchFGLicenseInfoException {

		return getPersistence().findByNationalIdAndStatus_First(
			nationalId, status, orderByComparator);
	}

	/**
	 * Returns the first fg license info in the ordered set where nationalId = &#63; and status = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	public static FGLicenseInfo fetchByNationalIdAndStatus_First(
		String nationalId, int status,
		OrderByComparator<FGLicenseInfo> orderByComparator) {

		return getPersistence().fetchByNationalIdAndStatus_First(
			nationalId, status, orderByComparator);
	}

	/**
	 * Returns the last fg license info in the ordered set where nationalId = &#63; and status = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fg license info
	 * @throws NoSuchFGLicenseInfoException if a matching fg license info could not be found
	 */
	public static FGLicenseInfo findByNationalIdAndStatus_Last(
			String nationalId, int status,
			OrderByComparator<FGLicenseInfo> orderByComparator)
		throws bd.gov.dgfood.license.management.system.exception.
			NoSuchFGLicenseInfoException {

		return getPersistence().findByNationalIdAndStatus_Last(
			nationalId, status, orderByComparator);
	}

	/**
	 * Returns the last fg license info in the ordered set where nationalId = &#63; and status = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	public static FGLicenseInfo fetchByNationalIdAndStatus_Last(
		String nationalId, int status,
		OrderByComparator<FGLicenseInfo> orderByComparator) {

		return getPersistence().fetchByNationalIdAndStatus_Last(
			nationalId, status, orderByComparator);
	}

	/**
	 * Returns the fg license infos before and after the current fg license info in the ordered set where nationalId = &#63; and status = &#63;.
	 *
	 * @param fgLicenseInfoId the primary key of the current fg license info
	 * @param nationalId the national ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fg license info
	 * @throws NoSuchFGLicenseInfoException if a fg license info with the primary key could not be found
	 */
	public static FGLicenseInfo[] findByNationalIdAndStatus_PrevAndNext(
			long fgLicenseInfoId, String nationalId, int status,
			OrderByComparator<FGLicenseInfo> orderByComparator)
		throws bd.gov.dgfood.license.management.system.exception.
			NoSuchFGLicenseInfoException {

		return getPersistence().findByNationalIdAndStatus_PrevAndNext(
			fgLicenseInfoId, nationalId, status, orderByComparator);
	}

	/**
	 * Removes all the fg license infos where nationalId = &#63; and status = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @param status the status
	 */
	public static void removeByNationalIdAndStatus(
		String nationalId, int status) {

		getPersistence().removeByNationalIdAndStatus(nationalId, status);
	}

	/**
	 * Returns the number of fg license infos where nationalId = &#63; and status = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param status the status
	 * @return the number of matching fg license infos
	 */
	public static int countByNationalIdAndStatus(
		String nationalId, int status) {

		return getPersistence().countByNationalIdAndStatus(nationalId, status);
	}

	/**
	 * Returns the fg license info where applicationNumber = &#63; and nationalId = &#63; or throws a <code>NoSuchFGLicenseInfoException</code> if it could not be found.
	 *
	 * @param applicationNumber the application number
	 * @param nationalId the national ID
	 * @return the matching fg license info
	 * @throws NoSuchFGLicenseInfoException if a matching fg license info could not be found
	 */
	public static FGLicenseInfo findByApplicationNumberNIDDateOfBirth(
			String applicationNumber, String nationalId)
		throws bd.gov.dgfood.license.management.system.exception.
			NoSuchFGLicenseInfoException {

		return getPersistence().findByApplicationNumberNIDDateOfBirth(
			applicationNumber, nationalId);
	}

	/**
	 * Returns the fg license info where applicationNumber = &#63; and nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @param nationalId the national ID
	 * @return the matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	public static FGLicenseInfo fetchByApplicationNumberNIDDateOfBirth(
		String applicationNumber, String nationalId) {

		return getPersistence().fetchByApplicationNumberNIDDateOfBirth(
			applicationNumber, nationalId);
	}

	/**
	 * Returns the fg license info where applicationNumber = &#63; and nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	public static FGLicenseInfo fetchByApplicationNumberNIDDateOfBirth(
		String applicationNumber, String nationalId, boolean useFinderCache) {

		return getPersistence().fetchByApplicationNumberNIDDateOfBirth(
			applicationNumber, nationalId, useFinderCache);
	}

	/**
	 * Removes the fg license info where applicationNumber = &#63; and nationalId = &#63; from the database.
	 *
	 * @param applicationNumber the application number
	 * @param nationalId the national ID
	 * @return the fg license info that was removed
	 */
	public static FGLicenseInfo removeByApplicationNumberNIDDateOfBirth(
			String applicationNumber, String nationalId)
		throws bd.gov.dgfood.license.management.system.exception.
			NoSuchFGLicenseInfoException {

		return getPersistence().removeByApplicationNumberNIDDateOfBirth(
			applicationNumber, nationalId);
	}

	/**
	 * Returns the number of fg license infos where applicationNumber = &#63; and nationalId = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @param nationalId the national ID
	 * @return the number of matching fg license infos
	 */
	public static int countByApplicationNumberNIDDateOfBirth(
		String applicationNumber, String nationalId) {

		return getPersistence().countByApplicationNumberNIDDateOfBirth(
			applicationNumber, nationalId);
	}

	/**
	 * Returns the fg license info where applicationNumber = &#63; or throws a <code>NoSuchFGLicenseInfoException</code> if it could not be found.
	 *
	 * @param applicationNumber the application number
	 * @return the matching fg license info
	 * @throws NoSuchFGLicenseInfoException if a matching fg license info could not be found
	 */
	public static FGLicenseInfo findByApplicationNumber(
			String applicationNumber)
		throws bd.gov.dgfood.license.management.system.exception.
			NoSuchFGLicenseInfoException {

		return getPersistence().findByApplicationNumber(applicationNumber);
	}

	/**
	 * Returns the fg license info where applicationNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @return the matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	public static FGLicenseInfo fetchByApplicationNumber(
		String applicationNumber) {

		return getPersistence().fetchByApplicationNumber(applicationNumber);
	}

	/**
	 * Returns the fg license info where applicationNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	public static FGLicenseInfo fetchByApplicationNumber(
		String applicationNumber, boolean useFinderCache) {

		return getPersistence().fetchByApplicationNumber(
			applicationNumber, useFinderCache);
	}

	/**
	 * Removes the fg license info where applicationNumber = &#63; from the database.
	 *
	 * @param applicationNumber the application number
	 * @return the fg license info that was removed
	 */
	public static FGLicenseInfo removeByApplicationNumber(
			String applicationNumber)
		throws bd.gov.dgfood.license.management.system.exception.
			NoSuchFGLicenseInfoException {

		return getPersistence().removeByApplicationNumber(applicationNumber);
	}

	/**
	 * Returns the number of fg license infos where applicationNumber = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @return the number of matching fg license infos
	 */
	public static int countByApplicationNumber(String applicationNumber) {
		return getPersistence().countByApplicationNumber(applicationNumber);
	}

	/**
	 * Returns the fg license info where foodgrainLicenseNumber = &#63; or throws a <code>NoSuchFGLicenseInfoException</code> if it could not be found.
	 *
	 * @param foodgrainLicenseNumber the foodgrain license number
	 * @return the matching fg license info
	 * @throws NoSuchFGLicenseInfoException if a matching fg license info could not be found
	 */
	public static FGLicenseInfo findByFoodgrainLicenseNumber(
			String foodgrainLicenseNumber)
		throws bd.gov.dgfood.license.management.system.exception.
			NoSuchFGLicenseInfoException {

		return getPersistence().findByFoodgrainLicenseNumber(
			foodgrainLicenseNumber);
	}

	/**
	 * Returns the fg license info where foodgrainLicenseNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param foodgrainLicenseNumber the foodgrain license number
	 * @return the matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	public static FGLicenseInfo fetchByFoodgrainLicenseNumber(
		String foodgrainLicenseNumber) {

		return getPersistence().fetchByFoodgrainLicenseNumber(
			foodgrainLicenseNumber);
	}

	/**
	 * Returns the fg license info where foodgrainLicenseNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param foodgrainLicenseNumber the foodgrain license number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	public static FGLicenseInfo fetchByFoodgrainLicenseNumber(
		String foodgrainLicenseNumber, boolean useFinderCache) {

		return getPersistence().fetchByFoodgrainLicenseNumber(
			foodgrainLicenseNumber, useFinderCache);
	}

	/**
	 * Removes the fg license info where foodgrainLicenseNumber = &#63; from the database.
	 *
	 * @param foodgrainLicenseNumber the foodgrain license number
	 * @return the fg license info that was removed
	 */
	public static FGLicenseInfo removeByFoodgrainLicenseNumber(
			String foodgrainLicenseNumber)
		throws bd.gov.dgfood.license.management.system.exception.
			NoSuchFGLicenseInfoException {

		return getPersistence().removeByFoodgrainLicenseNumber(
			foodgrainLicenseNumber);
	}

	/**
	 * Returns the number of fg license infos where foodgrainLicenseNumber = &#63;.
	 *
	 * @param foodgrainLicenseNumber the foodgrain license number
	 * @return the number of matching fg license infos
	 */
	public static int countByFoodgrainLicenseNumber(
		String foodgrainLicenseNumber) {

		return getPersistence().countByFoodgrainLicenseNumber(
			foodgrainLicenseNumber);
	}

	/**
	 * Caches the fg license info in the entity cache if it is enabled.
	 *
	 * @param fgLicenseInfo the fg license info
	 */
	public static void cacheResult(FGLicenseInfo fgLicenseInfo) {
		getPersistence().cacheResult(fgLicenseInfo);
	}

	/**
	 * Caches the fg license infos in the entity cache if it is enabled.
	 *
	 * @param fgLicenseInfos the fg license infos
	 */
	public static void cacheResult(List<FGLicenseInfo> fgLicenseInfos) {
		getPersistence().cacheResult(fgLicenseInfos);
	}

	/**
	 * Creates a new fg license info with the primary key. Does not add the fg license info to the database.
	 *
	 * @param fgLicenseInfoId the primary key for the new fg license info
	 * @return the new fg license info
	 */
	public static FGLicenseInfo create(long fgLicenseInfoId) {
		return getPersistence().create(fgLicenseInfoId);
	}

	/**
	 * Removes the fg license info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fgLicenseInfoId the primary key of the fg license info
	 * @return the fg license info that was removed
	 * @throws NoSuchFGLicenseInfoException if a fg license info with the primary key could not be found
	 */
	public static FGLicenseInfo remove(long fgLicenseInfoId)
		throws bd.gov.dgfood.license.management.system.exception.
			NoSuchFGLicenseInfoException {

		return getPersistence().remove(fgLicenseInfoId);
	}

	public static FGLicenseInfo updateImpl(FGLicenseInfo fgLicenseInfo) {
		return getPersistence().updateImpl(fgLicenseInfo);
	}

	/**
	 * Returns the fg license info with the primary key or throws a <code>NoSuchFGLicenseInfoException</code> if it could not be found.
	 *
	 * @param fgLicenseInfoId the primary key of the fg license info
	 * @return the fg license info
	 * @throws NoSuchFGLicenseInfoException if a fg license info with the primary key could not be found
	 */
	public static FGLicenseInfo findByPrimaryKey(long fgLicenseInfoId)
		throws bd.gov.dgfood.license.management.system.exception.
			NoSuchFGLicenseInfoException {

		return getPersistence().findByPrimaryKey(fgLicenseInfoId);
	}

	/**
	 * Returns the fg license info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fgLicenseInfoId the primary key of the fg license info
	 * @return the fg license info, or <code>null</code> if a fg license info with the primary key could not be found
	 */
	public static FGLicenseInfo fetchByPrimaryKey(long fgLicenseInfoId) {
		return getPersistence().fetchByPrimaryKey(fgLicenseInfoId);
	}

	/**
	 * Returns all the fg license infos.
	 *
	 * @return the fg license infos
	 */
	public static List<FGLicenseInfo> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the fg license infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fg license infos
	 * @param end the upper bound of the range of fg license infos (not inclusive)
	 * @return the range of fg license infos
	 */
	public static List<FGLicenseInfo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the fg license infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fg license infos
	 * @param end the upper bound of the range of fg license infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fg license infos
	 */
	public static List<FGLicenseInfo> findAll(
		int start, int end,
		OrderByComparator<FGLicenseInfo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the fg license infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fg license infos
	 * @param end the upper bound of the range of fg license infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of fg license infos
	 */
	public static List<FGLicenseInfo> findAll(
		int start, int end, OrderByComparator<FGLicenseInfo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the fg license infos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of fg license infos.
	 *
	 * @return the number of fg license infos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FGLicenseInfoPersistence getPersistence() {
		return _persistence;
	}

	private static volatile FGLicenseInfoPersistence _persistence;

}