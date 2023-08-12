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

import bd.gov.dgfood.common.services.exception.NoSuchDGFUsersException;
import bd.gov.dgfood.common.services.model.DGFUsers;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dgf users service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DGFUsersUtil
 * @generated
 */
@ProviderType
public interface DGFUsersPersistence extends BasePersistence<DGFUsers> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DGFUsersUtil} to access the dgf users persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the dgf users where nationalId = &#63; or throws a <code>NoSuchDGFUsersException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf users
	 * @throws NoSuchDGFUsersException if a matching dgf users could not be found
	 */
	public DGFUsers findByNationalId(String nationalId)
		throws NoSuchDGFUsersException;

	/**
	 * Returns the dgf users where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf users, or <code>null</code> if a matching dgf users could not be found
	 */
	public DGFUsers fetchByNationalId(String nationalId);

	/**
	 * Returns the dgf users where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf users, or <code>null</code> if a matching dgf users could not be found
	 */
	public DGFUsers fetchByNationalId(
		String nationalId, boolean useFinderCache);

	/**
	 * Removes the dgf users where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the dgf users that was removed
	 */
	public DGFUsers removeByNationalId(String nationalId)
		throws NoSuchDGFUsersException;

	/**
	 * Returns the number of dgf userses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf userses
	 */
	public int countByNationalId(String nationalId);

	/**
	 * Caches the dgf users in the entity cache if it is enabled.
	 *
	 * @param dgfUsers the dgf users
	 */
	public void cacheResult(DGFUsers dgfUsers);

	/**
	 * Caches the dgf userses in the entity cache if it is enabled.
	 *
	 * @param dgfUserses the dgf userses
	 */
	public void cacheResult(java.util.List<DGFUsers> dgfUserses);

	/**
	 * Creates a new dgf users with the primary key. Does not add the dgf users to the database.
	 *
	 * @param dgfUserId the primary key for the new dgf users
	 * @return the new dgf users
	 */
	public DGFUsers create(long dgfUserId);

	/**
	 * Removes the dgf users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dgfUserId the primary key of the dgf users
	 * @return the dgf users that was removed
	 * @throws NoSuchDGFUsersException if a dgf users with the primary key could not be found
	 */
	public DGFUsers remove(long dgfUserId) throws NoSuchDGFUsersException;

	public DGFUsers updateImpl(DGFUsers dgfUsers);

	/**
	 * Returns the dgf users with the primary key or throws a <code>NoSuchDGFUsersException</code> if it could not be found.
	 *
	 * @param dgfUserId the primary key of the dgf users
	 * @return the dgf users
	 * @throws NoSuchDGFUsersException if a dgf users with the primary key could not be found
	 */
	public DGFUsers findByPrimaryKey(long dgfUserId)
		throws NoSuchDGFUsersException;

	/**
	 * Returns the dgf users with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dgfUserId the primary key of the dgf users
	 * @return the dgf users, or <code>null</code> if a dgf users with the primary key could not be found
	 */
	public DGFUsers fetchByPrimaryKey(long dgfUserId);

	/**
	 * Returns all the dgf userses.
	 *
	 * @return the dgf userses
	 */
	public java.util.List<DGFUsers> findAll();

	/**
	 * Returns a range of all the dgf userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @return the range of dgf userses
	 */
	public java.util.List<DGFUsers> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dgf userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf userses
	 */
	public java.util.List<DGFUsers> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DGFUsers>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf userses
	 */
	public java.util.List<DGFUsers> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DGFUsers>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dgf userses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dgf userses.
	 *
	 * @return the number of dgf userses
	 */
	public int countAll();

}