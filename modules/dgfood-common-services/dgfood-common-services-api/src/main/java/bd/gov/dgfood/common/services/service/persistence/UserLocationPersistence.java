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

import bd.gov.dgfood.common.services.exception.NoSuchUserLocationException;
import bd.gov.dgfood.common.services.model.UserLocation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user location service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserLocationUtil
 * @generated
 */
@ProviderType
public interface UserLocationPersistence extends BasePersistence<UserLocation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserLocationUtil} to access the user location persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the user locations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user locations
	 */
	public java.util.List<UserLocation> findByUuid(String uuid);

	/**
	 * Returns a range of all the user locations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @return the range of matching user locations
	 */
	public java.util.List<UserLocation> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the user locations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user locations
	 */
	public java.util.List<UserLocation> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserLocation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user locations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user locations
	 */
	public java.util.List<UserLocation> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserLocation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user location in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	public UserLocation findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserLocation>
				orderByComparator)
		throws NoSuchUserLocationException;

	/**
	 * Returns the first user location in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public UserLocation fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserLocation>
			orderByComparator);

	/**
	 * Returns the last user location in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	public UserLocation findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserLocation>
				orderByComparator)
		throws NoSuchUserLocationException;

	/**
	 * Returns the last user location in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public UserLocation fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserLocation>
			orderByComparator);

	/**
	 * Returns the user locations before and after the current user location in the ordered set where uuid = &#63;.
	 *
	 * @param userLocationId the primary key of the current user location
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user location
	 * @throws NoSuchUserLocationException if a user location with the primary key could not be found
	 */
	public UserLocation[] findByUuid_PrevAndNext(
			long userLocationId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserLocation>
				orderByComparator)
		throws NoSuchUserLocationException;

	/**
	 * Removes all the user locations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of user locations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user locations
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the user location where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchUserLocationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	public UserLocation findByUUID_G(String uuid, long groupId)
		throws NoSuchUserLocationException;

	/**
	 * Returns the user location where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public UserLocation fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the user location where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public UserLocation fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the user location where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the user location that was removed
	 */
	public UserLocation removeByUUID_G(String uuid, long groupId)
		throws NoSuchUserLocationException;

	/**
	 * Returns the number of user locations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching user locations
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the user locations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching user locations
	 */
	public java.util.List<UserLocation> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the user locations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @return the range of matching user locations
	 */
	public java.util.List<UserLocation> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the user locations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user locations
	 */
	public java.util.List<UserLocation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserLocation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user locations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user locations
	 */
	public java.util.List<UserLocation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserLocation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user location in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	public UserLocation findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<UserLocation>
				orderByComparator)
		throws NoSuchUserLocationException;

	/**
	 * Returns the first user location in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public UserLocation fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserLocation>
			orderByComparator);

	/**
	 * Returns the last user location in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	public UserLocation findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<UserLocation>
				orderByComparator)
		throws NoSuchUserLocationException;

	/**
	 * Returns the last user location in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public UserLocation fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserLocation>
			orderByComparator);

	/**
	 * Returns the user locations before and after the current user location in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param userLocationId the primary key of the current user location
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user location
	 * @throws NoSuchUserLocationException if a user location with the primary key could not be found
	 */
	public UserLocation[] findByUuid_C_PrevAndNext(
			long userLocationId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<UserLocation>
				orderByComparator)
		throws NoSuchUserLocationException;

	/**
	 * Removes all the user locations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of user locations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching user locations
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the user locations where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching user locations
	 */
	public java.util.List<UserLocation> findByUserId(long userId);

	/**
	 * Returns a range of all the user locations where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @return the range of matching user locations
	 */
	public java.util.List<UserLocation> findByUserId(
		long userId, int start, int end);

	/**
	 * Returns an ordered range of all the user locations where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user locations
	 */
	public java.util.List<UserLocation> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserLocation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user locations where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user locations
	 */
	public java.util.List<UserLocation> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserLocation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user location in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	public UserLocation findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<UserLocation>
				orderByComparator)
		throws NoSuchUserLocationException;

	/**
	 * Returns the first user location in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public UserLocation fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<UserLocation>
			orderByComparator);

	/**
	 * Returns the last user location in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	public UserLocation findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<UserLocation>
				orderByComparator)
		throws NoSuchUserLocationException;

	/**
	 * Returns the last user location in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public UserLocation fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<UserLocation>
			orderByComparator);

	/**
	 * Returns the user locations before and after the current user location in the ordered set where userId = &#63;.
	 *
	 * @param userLocationId the primary key of the current user location
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user location
	 * @throws NoSuchUserLocationException if a user location with the primary key could not be found
	 */
	public UserLocation[] findByUserId_PrevAndNext(
			long userLocationId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<UserLocation>
				orderByComparator)
		throws NoSuchUserLocationException;

	/**
	 * Removes all the user locations where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of user locations where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user locations
	 */
	public int countByUserId(long userId);

	/**
	 * Returns the user location where userId = &#63; and locationCode = &#63; or throws a <code>NoSuchUserLocationException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param locationCode the location code
	 * @return the matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	public UserLocation findByUI_LC(long userId, String locationCode)
		throws NoSuchUserLocationException;

	/**
	 * Returns the user location where userId = &#63; and locationCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param locationCode the location code
	 * @return the matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public UserLocation fetchByUI_LC(long userId, String locationCode);

	/**
	 * Returns the user location where userId = &#63; and locationCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param locationCode the location code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public UserLocation fetchByUI_LC(
		long userId, String locationCode, boolean useFinderCache);

	/**
	 * Removes the user location where userId = &#63; and locationCode = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param locationCode the location code
	 * @return the user location that was removed
	 */
	public UserLocation removeByUI_LC(long userId, String locationCode)
		throws NoSuchUserLocationException;

	/**
	 * Returns the number of user locations where userId = &#63; and locationCode = &#63;.
	 *
	 * @param userId the user ID
	 * @param locationCode the location code
	 * @return the number of matching user locations
	 */
	public int countByUI_LC(long userId, String locationCode);

	/**
	 * Returns the user location where userId = &#63; and locationCode = &#63; and roleKey = &#63; or throws a <code>NoSuchUserLocationException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param locationCode the location code
	 * @param roleKey the role key
	 * @return the matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	public UserLocation findByUI_LC_RK(
			long userId, String locationCode, String roleKey)
		throws NoSuchUserLocationException;

	/**
	 * Returns the user location where userId = &#63; and locationCode = &#63; and roleKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param locationCode the location code
	 * @param roleKey the role key
	 * @return the matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public UserLocation fetchByUI_LC_RK(
		long userId, String locationCode, String roleKey);

	/**
	 * Returns the user location where userId = &#63; and locationCode = &#63; and roleKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param locationCode the location code
	 * @param roleKey the role key
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public UserLocation fetchByUI_LC_RK(
		long userId, String locationCode, String roleKey,
		boolean useFinderCache);

	/**
	 * Removes the user location where userId = &#63; and locationCode = &#63; and roleKey = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param locationCode the location code
	 * @param roleKey the role key
	 * @return the user location that was removed
	 */
	public UserLocation removeByUI_LC_RK(
			long userId, String locationCode, String roleKey)
		throws NoSuchUserLocationException;

	/**
	 * Returns the number of user locations where userId = &#63; and locationCode = &#63; and roleKey = &#63;.
	 *
	 * @param userId the user ID
	 * @param locationCode the location code
	 * @param roleKey the role key
	 * @return the number of matching user locations
	 */
	public int countByUI_LC_RK(
		long userId, String locationCode, String roleKey);

	/**
	 * Returns the user location where locationId = &#63; or throws a <code>NoSuchUserLocationException</code> if it could not be found.
	 *
	 * @param locationId the location ID
	 * @return the matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	public UserLocation findByLocationId(long locationId)
		throws NoSuchUserLocationException;

	/**
	 * Returns the user location where locationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param locationId the location ID
	 * @return the matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public UserLocation fetchByLocationId(long locationId);

	/**
	 * Returns the user location where locationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param locationId the location ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public UserLocation fetchByLocationId(
		long locationId, boolean useFinderCache);

	/**
	 * Removes the user location where locationId = &#63; from the database.
	 *
	 * @param locationId the location ID
	 * @return the user location that was removed
	 */
	public UserLocation removeByLocationId(long locationId)
		throws NoSuchUserLocationException;

	/**
	 * Returns the number of user locations where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @return the number of matching user locations
	 */
	public int countByLocationId(long locationId);

	/**
	 * Returns the user location where roleKey = &#63; and locationCode = &#63; or throws a <code>NoSuchUserLocationException</code> if it could not be found.
	 *
	 * @param roleKey the role key
	 * @param locationCode the location code
	 * @return the matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	public UserLocation findByRK_LC(String roleKey, String locationCode)
		throws NoSuchUserLocationException;

	/**
	 * Returns the user location where roleKey = &#63; and locationCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param roleKey the role key
	 * @param locationCode the location code
	 * @return the matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public UserLocation fetchByRK_LC(String roleKey, String locationCode);

	/**
	 * Returns the user location where roleKey = &#63; and locationCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param roleKey the role key
	 * @param locationCode the location code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public UserLocation fetchByRK_LC(
		String roleKey, String locationCode, boolean useFinderCache);

	/**
	 * Removes the user location where roleKey = &#63; and locationCode = &#63; from the database.
	 *
	 * @param roleKey the role key
	 * @param locationCode the location code
	 * @return the user location that was removed
	 */
	public UserLocation removeByRK_LC(String roleKey, String locationCode)
		throws NoSuchUserLocationException;

	/**
	 * Returns the number of user locations where roleKey = &#63; and locationCode = &#63;.
	 *
	 * @param roleKey the role key
	 * @param locationCode the location code
	 * @return the number of matching user locations
	 */
	public int countByRK_LC(String roleKey, String locationCode);

	/**
	 * Caches the user location in the entity cache if it is enabled.
	 *
	 * @param userLocation the user location
	 */
	public void cacheResult(UserLocation userLocation);

	/**
	 * Caches the user locations in the entity cache if it is enabled.
	 *
	 * @param userLocations the user locations
	 */
	public void cacheResult(java.util.List<UserLocation> userLocations);

	/**
	 * Creates a new user location with the primary key. Does not add the user location to the database.
	 *
	 * @param userLocationId the primary key for the new user location
	 * @return the new user location
	 */
	public UserLocation create(long userLocationId);

	/**
	 * Removes the user location with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userLocationId the primary key of the user location
	 * @return the user location that was removed
	 * @throws NoSuchUserLocationException if a user location with the primary key could not be found
	 */
	public UserLocation remove(long userLocationId)
		throws NoSuchUserLocationException;

	public UserLocation updateImpl(UserLocation userLocation);

	/**
	 * Returns the user location with the primary key or throws a <code>NoSuchUserLocationException</code> if it could not be found.
	 *
	 * @param userLocationId the primary key of the user location
	 * @return the user location
	 * @throws NoSuchUserLocationException if a user location with the primary key could not be found
	 */
	public UserLocation findByPrimaryKey(long userLocationId)
		throws NoSuchUserLocationException;

	/**
	 * Returns the user location with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userLocationId the primary key of the user location
	 * @return the user location, or <code>null</code> if a user location with the primary key could not be found
	 */
	public UserLocation fetchByPrimaryKey(long userLocationId);

	/**
	 * Returns all the user locations.
	 *
	 * @return the user locations
	 */
	public java.util.List<UserLocation> findAll();

	/**
	 * Returns a range of all the user locations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @return the range of user locations
	 */
	public java.util.List<UserLocation> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the user locations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user locations
	 */
	public java.util.List<UserLocation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserLocation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user locations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user locations
	 */
	public java.util.List<UserLocation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserLocation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the user locations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user locations.
	 *
	 * @return the number of user locations
	 */
	public int countAll();

}