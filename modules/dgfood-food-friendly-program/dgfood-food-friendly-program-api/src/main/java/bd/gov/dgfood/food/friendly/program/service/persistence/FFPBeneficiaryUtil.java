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

import bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the ffp beneficiary service. This utility wraps <code>bd.gov.dgfood.food.friendly.program.service.persistence.impl.FFPBeneficiaryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FFPBeneficiaryPersistence
 * @generated
 */
public class FFPBeneficiaryUtil {

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
	public static void clearCache(FFPBeneficiary ffpBeneficiary) {
		getPersistence().clearCache(ffpBeneficiary);
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
	public static Map<Serializable, FFPBeneficiary> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FFPBeneficiary> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FFPBeneficiary> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FFPBeneficiary> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FFPBeneficiary> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FFPBeneficiary update(FFPBeneficiary ffpBeneficiary) {
		return getPersistence().update(ffpBeneficiary);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FFPBeneficiary update(
		FFPBeneficiary ffpBeneficiary, ServiceContext serviceContext) {

		return getPersistence().update(ffpBeneficiary, serviceContext);
	}

	/**
	 * Returns all the ffp beneficiaries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ffp beneficiaries
	 */
	public static List<FFPBeneficiary> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the ffp beneficiaries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ffp beneficiaries
	 * @param end the upper bound of the range of ffp beneficiaries (not inclusive)
	 * @return the range of matching ffp beneficiaries
	 */
	public static List<FFPBeneficiary> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the ffp beneficiaries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ffp beneficiaries
	 * @param end the upper bound of the range of ffp beneficiaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ffp beneficiaries
	 */
	public static List<FFPBeneficiary> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FFPBeneficiary> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ffp beneficiaries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ffp beneficiaries
	 * @param end the upper bound of the range of ffp beneficiaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ffp beneficiaries
	 */
	public static List<FFPBeneficiary> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FFPBeneficiary> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ffp beneficiary in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a matching ffp beneficiary could not be found
	 */
	public static FFPBeneficiary findByUuid_First(
			String uuid, OrderByComparator<FFPBeneficiary> orderByComparator)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFFPBeneficiaryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first ffp beneficiary in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	public static FFPBeneficiary fetchByUuid_First(
		String uuid, OrderByComparator<FFPBeneficiary> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last ffp beneficiary in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a matching ffp beneficiary could not be found
	 */
	public static FFPBeneficiary findByUuid_Last(
			String uuid, OrderByComparator<FFPBeneficiary> orderByComparator)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFFPBeneficiaryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last ffp beneficiary in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	public static FFPBeneficiary fetchByUuid_Last(
		String uuid, OrderByComparator<FFPBeneficiary> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the ffp beneficiaries before and after the current ffp beneficiary in the ordered set where uuid = &#63;.
	 *
	 * @param beneficiaryId the primary key of the current ffp beneficiary
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a ffp beneficiary with the primary key could not be found
	 */
	public static FFPBeneficiary[] findByUuid_PrevAndNext(
			long beneficiaryId, String uuid,
			OrderByComparator<FFPBeneficiary> orderByComparator)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFFPBeneficiaryException {

		return getPersistence().findByUuid_PrevAndNext(
			beneficiaryId, uuid, orderByComparator);
	}

	/**
	 * Removes all the ffp beneficiaries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of ffp beneficiaries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ffp beneficiaries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the ffp beneficiary where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFFPBeneficiaryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a matching ffp beneficiary could not be found
	 */
	public static FFPBeneficiary findByUUID_G(String uuid, long groupId)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFFPBeneficiaryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the ffp beneficiary where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	public static FFPBeneficiary fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the ffp beneficiary where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	public static FFPBeneficiary fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the ffp beneficiary where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ffp beneficiary that was removed
	 */
	public static FFPBeneficiary removeByUUID_G(String uuid, long groupId)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFFPBeneficiaryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of ffp beneficiaries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ffp beneficiaries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the ffp beneficiaries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ffp beneficiaries
	 */
	public static List<FFPBeneficiary> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the ffp beneficiaries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ffp beneficiaries
	 * @param end the upper bound of the range of ffp beneficiaries (not inclusive)
	 * @return the range of matching ffp beneficiaries
	 */
	public static List<FFPBeneficiary> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the ffp beneficiaries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ffp beneficiaries
	 * @param end the upper bound of the range of ffp beneficiaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ffp beneficiaries
	 */
	public static List<FFPBeneficiary> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FFPBeneficiary> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ffp beneficiaries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ffp beneficiaries
	 * @param end the upper bound of the range of ffp beneficiaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ffp beneficiaries
	 */
	public static List<FFPBeneficiary> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FFPBeneficiary> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ffp beneficiary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a matching ffp beneficiary could not be found
	 */
	public static FFPBeneficiary findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FFPBeneficiary> orderByComparator)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFFPBeneficiaryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first ffp beneficiary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	public static FFPBeneficiary fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FFPBeneficiary> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last ffp beneficiary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a matching ffp beneficiary could not be found
	 */
	public static FFPBeneficiary findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FFPBeneficiary> orderByComparator)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFFPBeneficiaryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last ffp beneficiary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	public static FFPBeneficiary fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FFPBeneficiary> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the ffp beneficiaries before and after the current ffp beneficiary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param beneficiaryId the primary key of the current ffp beneficiary
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a ffp beneficiary with the primary key could not be found
	 */
	public static FFPBeneficiary[] findByUuid_C_PrevAndNext(
			long beneficiaryId, String uuid, long companyId,
			OrderByComparator<FFPBeneficiary> orderByComparator)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFFPBeneficiaryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			beneficiaryId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the ffp beneficiaries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of ffp beneficiaries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ffp beneficiaries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the ffp beneficiary where nationalId = &#63; or throws a <code>NoSuchFFPBeneficiaryException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a matching ffp beneficiary could not be found
	 */
	public static FFPBeneficiary findByNationalId(long nationalId)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFFPBeneficiaryException {

		return getPersistence().findByNationalId(nationalId);
	}

	/**
	 * Returns the ffp beneficiary where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	public static FFPBeneficiary fetchByNationalId(long nationalId) {
		return getPersistence().fetchByNationalId(nationalId);
	}

	/**
	 * Returns the ffp beneficiary where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	public static FFPBeneficiary fetchByNationalId(
		long nationalId, boolean useFinderCache) {

		return getPersistence().fetchByNationalId(nationalId, useFinderCache);
	}

	/**
	 * Removes the ffp beneficiary where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the ffp beneficiary that was removed
	 */
	public static FFPBeneficiary removeByNationalId(long nationalId)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFFPBeneficiaryException {

		return getPersistence().removeByNationalId(nationalId);
	}

	/**
	 * Returns the number of ffp beneficiaries where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching ffp beneficiaries
	 */
	public static int countByNationalId(long nationalId) {
		return getPersistence().countByNationalId(nationalId);
	}

	/**
	 * Returns the ffp beneficiary where cardNumber = &#63; and dateOfBirth = &#63; or throws a <code>NoSuchFFPBeneficiaryException</code> if it could not be found.
	 *
	 * @param cardNumber the card number
	 * @param dateOfBirth the date of birth
	 * @return the matching ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a matching ffp beneficiary could not be found
	 */
	public static FFPBeneficiary findByCard_Dob(
			String cardNumber, Date dateOfBirth)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFFPBeneficiaryException {

		return getPersistence().findByCard_Dob(cardNumber, dateOfBirth);
	}

	/**
	 * Returns the ffp beneficiary where cardNumber = &#63; and dateOfBirth = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cardNumber the card number
	 * @param dateOfBirth the date of birth
	 * @return the matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	public static FFPBeneficiary fetchByCard_Dob(
		String cardNumber, Date dateOfBirth) {

		return getPersistence().fetchByCard_Dob(cardNumber, dateOfBirth);
	}

	/**
	 * Returns the ffp beneficiary where cardNumber = &#63; and dateOfBirth = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cardNumber the card number
	 * @param dateOfBirth the date of birth
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	public static FFPBeneficiary fetchByCard_Dob(
		String cardNumber, Date dateOfBirth, boolean useFinderCache) {

		return getPersistence().fetchByCard_Dob(
			cardNumber, dateOfBirth, useFinderCache);
	}

	/**
	 * Removes the ffp beneficiary where cardNumber = &#63; and dateOfBirth = &#63; from the database.
	 *
	 * @param cardNumber the card number
	 * @param dateOfBirth the date of birth
	 * @return the ffp beneficiary that was removed
	 */
	public static FFPBeneficiary removeByCard_Dob(
			String cardNumber, Date dateOfBirth)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFFPBeneficiaryException {

		return getPersistence().removeByCard_Dob(cardNumber, dateOfBirth);
	}

	/**
	 * Returns the number of ffp beneficiaries where cardNumber = &#63; and dateOfBirth = &#63;.
	 *
	 * @param cardNumber the card number
	 * @param dateOfBirth the date of birth
	 * @return the number of matching ffp beneficiaries
	 */
	public static int countByCard_Dob(String cardNumber, Date dateOfBirth) {
		return getPersistence().countByCard_Dob(cardNumber, dateOfBirth);
	}

	/**
	 * Returns the ffp beneficiary where beneficiaryId = &#63; and dateOfBirth = &#63; or throws a <code>NoSuchFFPBeneficiaryException</code> if it could not be found.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param dateOfBirth the date of birth
	 * @return the matching ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a matching ffp beneficiary could not be found
	 */
	public static FFPBeneficiary findById_Dob(
			long beneficiaryId, Date dateOfBirth)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFFPBeneficiaryException {

		return getPersistence().findById_Dob(beneficiaryId, dateOfBirth);
	}

	/**
	 * Returns the ffp beneficiary where beneficiaryId = &#63; and dateOfBirth = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param dateOfBirth the date of birth
	 * @return the matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	public static FFPBeneficiary fetchById_Dob(
		long beneficiaryId, Date dateOfBirth) {

		return getPersistence().fetchById_Dob(beneficiaryId, dateOfBirth);
	}

	/**
	 * Returns the ffp beneficiary where beneficiaryId = &#63; and dateOfBirth = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param dateOfBirth the date of birth
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	public static FFPBeneficiary fetchById_Dob(
		long beneficiaryId, Date dateOfBirth, boolean useFinderCache) {

		return getPersistence().fetchById_Dob(
			beneficiaryId, dateOfBirth, useFinderCache);
	}

	/**
	 * Removes the ffp beneficiary where beneficiaryId = &#63; and dateOfBirth = &#63; from the database.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param dateOfBirth the date of birth
	 * @return the ffp beneficiary that was removed
	 */
	public static FFPBeneficiary removeById_Dob(
			long beneficiaryId, Date dateOfBirth)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFFPBeneficiaryException {

		return getPersistence().removeById_Dob(beneficiaryId, dateOfBirth);
	}

	/**
	 * Returns the number of ffp beneficiaries where beneficiaryId = &#63; and dateOfBirth = &#63;.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param dateOfBirth the date of birth
	 * @return the number of matching ffp beneficiaries
	 */
	public static int countById_Dob(long beneficiaryId, Date dateOfBirth) {
		return getPersistence().countById_Dob(beneficiaryId, dateOfBirth);
	}

	/**
	 * Caches the ffp beneficiary in the entity cache if it is enabled.
	 *
	 * @param ffpBeneficiary the ffp beneficiary
	 */
	public static void cacheResult(FFPBeneficiary ffpBeneficiary) {
		getPersistence().cacheResult(ffpBeneficiary);
	}

	/**
	 * Caches the ffp beneficiaries in the entity cache if it is enabled.
	 *
	 * @param ffpBeneficiaries the ffp beneficiaries
	 */
	public static void cacheResult(List<FFPBeneficiary> ffpBeneficiaries) {
		getPersistence().cacheResult(ffpBeneficiaries);
	}

	/**
	 * Creates a new ffp beneficiary with the primary key. Does not add the ffp beneficiary to the database.
	 *
	 * @param beneficiaryId the primary key for the new ffp beneficiary
	 * @return the new ffp beneficiary
	 */
	public static FFPBeneficiary create(long beneficiaryId) {
		return getPersistence().create(beneficiaryId);
	}

	/**
	 * Removes the ffp beneficiary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param beneficiaryId the primary key of the ffp beneficiary
	 * @return the ffp beneficiary that was removed
	 * @throws NoSuchFFPBeneficiaryException if a ffp beneficiary with the primary key could not be found
	 */
	public static FFPBeneficiary remove(long beneficiaryId)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFFPBeneficiaryException {

		return getPersistence().remove(beneficiaryId);
	}

	public static FFPBeneficiary updateImpl(FFPBeneficiary ffpBeneficiary) {
		return getPersistence().updateImpl(ffpBeneficiary);
	}

	/**
	 * Returns the ffp beneficiary with the primary key or throws a <code>NoSuchFFPBeneficiaryException</code> if it could not be found.
	 *
	 * @param beneficiaryId the primary key of the ffp beneficiary
	 * @return the ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a ffp beneficiary with the primary key could not be found
	 */
	public static FFPBeneficiary findByPrimaryKey(long beneficiaryId)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFFPBeneficiaryException {

		return getPersistence().findByPrimaryKey(beneficiaryId);
	}

	/**
	 * Returns the ffp beneficiary with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param beneficiaryId the primary key of the ffp beneficiary
	 * @return the ffp beneficiary, or <code>null</code> if a ffp beneficiary with the primary key could not be found
	 */
	public static FFPBeneficiary fetchByPrimaryKey(long beneficiaryId) {
		return getPersistence().fetchByPrimaryKey(beneficiaryId);
	}

	/**
	 * Returns all the ffp beneficiaries.
	 *
	 * @return the ffp beneficiaries
	 */
	public static List<FFPBeneficiary> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ffp beneficiaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ffp beneficiaries
	 * @param end the upper bound of the range of ffp beneficiaries (not inclusive)
	 * @return the range of ffp beneficiaries
	 */
	public static List<FFPBeneficiary> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ffp beneficiaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ffp beneficiaries
	 * @param end the upper bound of the range of ffp beneficiaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ffp beneficiaries
	 */
	public static List<FFPBeneficiary> findAll(
		int start, int end,
		OrderByComparator<FFPBeneficiary> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ffp beneficiaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ffp beneficiaries
	 * @param end the upper bound of the range of ffp beneficiaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ffp beneficiaries
	 */
	public static List<FFPBeneficiary> findAll(
		int start, int end, OrderByComparator<FFPBeneficiary> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ffp beneficiaries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ffp beneficiaries.
	 *
	 * @return the number of ffp beneficiaries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FFPBeneficiaryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile FFPBeneficiaryPersistence _persistence;

}