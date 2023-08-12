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

import bd.gov.dgfood.license.management.system.exception.NoSuchFGLicenseInfoException;
import bd.gov.dgfood.license.management.system.model.FGLicenseInfo;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the fg license info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FGLicenseInfoUtil
 * @generated
 */
@ProviderType
public interface FGLicenseInfoPersistence
	extends BasePersistence<FGLicenseInfo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FGLicenseInfoUtil} to access the fg license info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the fg license infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching fg license infos
	 */
	public java.util.List<FGLicenseInfo> findByUuid(String uuid);

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
	public java.util.List<FGLicenseInfo> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<FGLicenseInfo> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FGLicenseInfo>
			orderByComparator);

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
	public java.util.List<FGLicenseInfo> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FGLicenseInfo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first fg license info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fg license info
	 * @throws NoSuchFGLicenseInfoException if a matching fg license info could not be found
	 */
	public FGLicenseInfo findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FGLicenseInfo>
				orderByComparator)
		throws NoSuchFGLicenseInfoException;

	/**
	 * Returns the first fg license info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	public FGLicenseInfo fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FGLicenseInfo>
			orderByComparator);

	/**
	 * Returns the last fg license info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fg license info
	 * @throws NoSuchFGLicenseInfoException if a matching fg license info could not be found
	 */
	public FGLicenseInfo findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FGLicenseInfo>
				orderByComparator)
		throws NoSuchFGLicenseInfoException;

	/**
	 * Returns the last fg license info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	public FGLicenseInfo fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FGLicenseInfo>
			orderByComparator);

	/**
	 * Returns the fg license infos before and after the current fg license info in the ordered set where uuid = &#63;.
	 *
	 * @param fgLicenseInfoId the primary key of the current fg license info
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fg license info
	 * @throws NoSuchFGLicenseInfoException if a fg license info with the primary key could not be found
	 */
	public FGLicenseInfo[] findByUuid_PrevAndNext(
			long fgLicenseInfoId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FGLicenseInfo>
				orderByComparator)
		throws NoSuchFGLicenseInfoException;

	/**
	 * Removes all the fg license infos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of fg license infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching fg license infos
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the fg license info where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFGLicenseInfoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching fg license info
	 * @throws NoSuchFGLicenseInfoException if a matching fg license info could not be found
	 */
	public FGLicenseInfo findByUUID_G(String uuid, long groupId)
		throws NoSuchFGLicenseInfoException;

	/**
	 * Returns the fg license info where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	public FGLicenseInfo fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the fg license info where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	public FGLicenseInfo fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the fg license info where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the fg license info that was removed
	 */
	public FGLicenseInfo removeByUUID_G(String uuid, long groupId)
		throws NoSuchFGLicenseInfoException;

	/**
	 * Returns the number of fg license infos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching fg license infos
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the fg license infos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching fg license infos
	 */
	public java.util.List<FGLicenseInfo> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<FGLicenseInfo> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<FGLicenseInfo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FGLicenseInfo>
			orderByComparator);

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
	public java.util.List<FGLicenseInfo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FGLicenseInfo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first fg license info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fg license info
	 * @throws NoSuchFGLicenseInfoException if a matching fg license info could not be found
	 */
	public FGLicenseInfo findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FGLicenseInfo>
				orderByComparator)
		throws NoSuchFGLicenseInfoException;

	/**
	 * Returns the first fg license info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	public FGLicenseInfo fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FGLicenseInfo>
			orderByComparator);

	/**
	 * Returns the last fg license info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fg license info
	 * @throws NoSuchFGLicenseInfoException if a matching fg license info could not be found
	 */
	public FGLicenseInfo findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FGLicenseInfo>
				orderByComparator)
		throws NoSuchFGLicenseInfoException;

	/**
	 * Returns the last fg license info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	public FGLicenseInfo fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FGLicenseInfo>
			orderByComparator);

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
	public FGLicenseInfo[] findByUuid_C_PrevAndNext(
			long fgLicenseInfoId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FGLicenseInfo>
				orderByComparator)
		throws NoSuchFGLicenseInfoException;

	/**
	 * Removes all the fg license infos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of fg license infos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching fg license infos
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the fg license infos where nationalId = &#63; and status = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param status the status
	 * @return the matching fg license infos
	 */
	public java.util.List<FGLicenseInfo> findByNationalIdAndStatus(
		String nationalId, int status);

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
	public java.util.List<FGLicenseInfo> findByNationalIdAndStatus(
		String nationalId, int status, int start, int end);

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
	public java.util.List<FGLicenseInfo> findByNationalIdAndStatus(
		String nationalId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FGLicenseInfo>
			orderByComparator);

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
	public java.util.List<FGLicenseInfo> findByNationalIdAndStatus(
		String nationalId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FGLicenseInfo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first fg license info in the ordered set where nationalId = &#63; and status = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fg license info
	 * @throws NoSuchFGLicenseInfoException if a matching fg license info could not be found
	 */
	public FGLicenseInfo findByNationalIdAndStatus_First(
			String nationalId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<FGLicenseInfo>
				orderByComparator)
		throws NoSuchFGLicenseInfoException;

	/**
	 * Returns the first fg license info in the ordered set where nationalId = &#63; and status = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	public FGLicenseInfo fetchByNationalIdAndStatus_First(
		String nationalId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<FGLicenseInfo>
			orderByComparator);

	/**
	 * Returns the last fg license info in the ordered set where nationalId = &#63; and status = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fg license info
	 * @throws NoSuchFGLicenseInfoException if a matching fg license info could not be found
	 */
	public FGLicenseInfo findByNationalIdAndStatus_Last(
			String nationalId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<FGLicenseInfo>
				orderByComparator)
		throws NoSuchFGLicenseInfoException;

	/**
	 * Returns the last fg license info in the ordered set where nationalId = &#63; and status = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	public FGLicenseInfo fetchByNationalIdAndStatus_Last(
		String nationalId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<FGLicenseInfo>
			orderByComparator);

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
	public FGLicenseInfo[] findByNationalIdAndStatus_PrevAndNext(
			long fgLicenseInfoId, String nationalId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<FGLicenseInfo>
				orderByComparator)
		throws NoSuchFGLicenseInfoException;

	/**
	 * Removes all the fg license infos where nationalId = &#63; and status = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @param status the status
	 */
	public void removeByNationalIdAndStatus(String nationalId, int status);

	/**
	 * Returns the number of fg license infos where nationalId = &#63; and status = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param status the status
	 * @return the number of matching fg license infos
	 */
	public int countByNationalIdAndStatus(String nationalId, int status);

	/**
	 * Returns the fg license info where applicationNumber = &#63; and nationalId = &#63; or throws a <code>NoSuchFGLicenseInfoException</code> if it could not be found.
	 *
	 * @param applicationNumber the application number
	 * @param nationalId the national ID
	 * @return the matching fg license info
	 * @throws NoSuchFGLicenseInfoException if a matching fg license info could not be found
	 */
	public FGLicenseInfo findByApplicationNumberNIDDateOfBirth(
			String applicationNumber, String nationalId)
		throws NoSuchFGLicenseInfoException;

	/**
	 * Returns the fg license info where applicationNumber = &#63; and nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @param nationalId the national ID
	 * @return the matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	public FGLicenseInfo fetchByApplicationNumberNIDDateOfBirth(
		String applicationNumber, String nationalId);

	/**
	 * Returns the fg license info where applicationNumber = &#63; and nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	public FGLicenseInfo fetchByApplicationNumberNIDDateOfBirth(
		String applicationNumber, String nationalId, boolean useFinderCache);

	/**
	 * Removes the fg license info where applicationNumber = &#63; and nationalId = &#63; from the database.
	 *
	 * @param applicationNumber the application number
	 * @param nationalId the national ID
	 * @return the fg license info that was removed
	 */
	public FGLicenseInfo removeByApplicationNumberNIDDateOfBirth(
			String applicationNumber, String nationalId)
		throws NoSuchFGLicenseInfoException;

	/**
	 * Returns the number of fg license infos where applicationNumber = &#63; and nationalId = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @param nationalId the national ID
	 * @return the number of matching fg license infos
	 */
	public int countByApplicationNumberNIDDateOfBirth(
		String applicationNumber, String nationalId);

	/**
	 * Returns the fg license info where applicationNumber = &#63; or throws a <code>NoSuchFGLicenseInfoException</code> if it could not be found.
	 *
	 * @param applicationNumber the application number
	 * @return the matching fg license info
	 * @throws NoSuchFGLicenseInfoException if a matching fg license info could not be found
	 */
	public FGLicenseInfo findByApplicationNumber(String applicationNumber)
		throws NoSuchFGLicenseInfoException;

	/**
	 * Returns the fg license info where applicationNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @return the matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	public FGLicenseInfo fetchByApplicationNumber(String applicationNumber);

	/**
	 * Returns the fg license info where applicationNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	public FGLicenseInfo fetchByApplicationNumber(
		String applicationNumber, boolean useFinderCache);

	/**
	 * Removes the fg license info where applicationNumber = &#63; from the database.
	 *
	 * @param applicationNumber the application number
	 * @return the fg license info that was removed
	 */
	public FGLicenseInfo removeByApplicationNumber(String applicationNumber)
		throws NoSuchFGLicenseInfoException;

	/**
	 * Returns the number of fg license infos where applicationNumber = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @return the number of matching fg license infos
	 */
	public int countByApplicationNumber(String applicationNumber);

	/**
	 * Returns the fg license info where foodgrainLicenseNumber = &#63; or throws a <code>NoSuchFGLicenseInfoException</code> if it could not be found.
	 *
	 * @param foodgrainLicenseNumber the foodgrain license number
	 * @return the matching fg license info
	 * @throws NoSuchFGLicenseInfoException if a matching fg license info could not be found
	 */
	public FGLicenseInfo findByFoodgrainLicenseNumber(
			String foodgrainLicenseNumber)
		throws NoSuchFGLicenseInfoException;

	/**
	 * Returns the fg license info where foodgrainLicenseNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param foodgrainLicenseNumber the foodgrain license number
	 * @return the matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	public FGLicenseInfo fetchByFoodgrainLicenseNumber(
		String foodgrainLicenseNumber);

	/**
	 * Returns the fg license info where foodgrainLicenseNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param foodgrainLicenseNumber the foodgrain license number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	public FGLicenseInfo fetchByFoodgrainLicenseNumber(
		String foodgrainLicenseNumber, boolean useFinderCache);

	/**
	 * Removes the fg license info where foodgrainLicenseNumber = &#63; from the database.
	 *
	 * @param foodgrainLicenseNumber the foodgrain license number
	 * @return the fg license info that was removed
	 */
	public FGLicenseInfo removeByFoodgrainLicenseNumber(
			String foodgrainLicenseNumber)
		throws NoSuchFGLicenseInfoException;

	/**
	 * Returns the number of fg license infos where foodgrainLicenseNumber = &#63;.
	 *
	 * @param foodgrainLicenseNumber the foodgrain license number
	 * @return the number of matching fg license infos
	 */
	public int countByFoodgrainLicenseNumber(String foodgrainLicenseNumber);

	/**
	 * Caches the fg license info in the entity cache if it is enabled.
	 *
	 * @param fgLicenseInfo the fg license info
	 */
	public void cacheResult(FGLicenseInfo fgLicenseInfo);

	/**
	 * Caches the fg license infos in the entity cache if it is enabled.
	 *
	 * @param fgLicenseInfos the fg license infos
	 */
	public void cacheResult(java.util.List<FGLicenseInfo> fgLicenseInfos);

	/**
	 * Creates a new fg license info with the primary key. Does not add the fg license info to the database.
	 *
	 * @param fgLicenseInfoId the primary key for the new fg license info
	 * @return the new fg license info
	 */
	public FGLicenseInfo create(long fgLicenseInfoId);

	/**
	 * Removes the fg license info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fgLicenseInfoId the primary key of the fg license info
	 * @return the fg license info that was removed
	 * @throws NoSuchFGLicenseInfoException if a fg license info with the primary key could not be found
	 */
	public FGLicenseInfo remove(long fgLicenseInfoId)
		throws NoSuchFGLicenseInfoException;

	public FGLicenseInfo updateImpl(FGLicenseInfo fgLicenseInfo);

	/**
	 * Returns the fg license info with the primary key or throws a <code>NoSuchFGLicenseInfoException</code> if it could not be found.
	 *
	 * @param fgLicenseInfoId the primary key of the fg license info
	 * @return the fg license info
	 * @throws NoSuchFGLicenseInfoException if a fg license info with the primary key could not be found
	 */
	public FGLicenseInfo findByPrimaryKey(long fgLicenseInfoId)
		throws NoSuchFGLicenseInfoException;

	/**
	 * Returns the fg license info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fgLicenseInfoId the primary key of the fg license info
	 * @return the fg license info, or <code>null</code> if a fg license info with the primary key could not be found
	 */
	public FGLicenseInfo fetchByPrimaryKey(long fgLicenseInfoId);

	/**
	 * Returns all the fg license infos.
	 *
	 * @return the fg license infos
	 */
	public java.util.List<FGLicenseInfo> findAll();

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
	public java.util.List<FGLicenseInfo> findAll(int start, int end);

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
	public java.util.List<FGLicenseInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FGLicenseInfo>
			orderByComparator);

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
	public java.util.List<FGLicenseInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FGLicenseInfo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the fg license infos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of fg license infos.
	 *
	 * @return the number of fg license infos
	 */
	public int countAll();

}