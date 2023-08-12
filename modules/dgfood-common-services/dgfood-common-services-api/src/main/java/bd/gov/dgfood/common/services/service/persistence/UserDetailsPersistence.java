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

import bd.gov.dgfood.common.services.exception.NoSuchUserDetailsException;
import bd.gov.dgfood.common.services.model.UserDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserDetailsUtil
 * @generated
 */
@ProviderType
public interface UserDetailsPersistence extends BasePersistence<UserDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserDetailsUtil} to access the user details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the user details where nationalId = &#63; or throws a <code>NoSuchUserDetailsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching user details
	 * @throws NoSuchUserDetailsException if a matching user details could not be found
	 */
	public UserDetails findByNationalId(String nationalId)
		throws NoSuchUserDetailsException;

	/**
	 * Returns the user details where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching user details, or <code>null</code> if a matching user details could not be found
	 */
	public UserDetails fetchByNationalId(String nationalId);

	/**
	 * Returns the user details where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user details, or <code>null</code> if a matching user details could not be found
	 */
	public UserDetails fetchByNationalId(
		String nationalId, boolean useFinderCache);

	/**
	 * Removes the user details where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the user details that was removed
	 */
	public UserDetails removeByNationalId(String nationalId)
		throws NoSuchUserDetailsException;

	/**
	 * Returns the number of user detailses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching user detailses
	 */
	public int countByNationalId(String nationalId);

	/**
	 * Caches the user details in the entity cache if it is enabled.
	 *
	 * @param userDetails the user details
	 */
	public void cacheResult(UserDetails userDetails);

	/**
	 * Caches the user detailses in the entity cache if it is enabled.
	 *
	 * @param userDetailses the user detailses
	 */
	public void cacheResult(java.util.List<UserDetails> userDetailses);

	/**
	 * Creates a new user details with the primary key. Does not add the user details to the database.
	 *
	 * @param userDetailsId the primary key for the new user details
	 * @return the new user details
	 */
	public UserDetails create(long userDetailsId);

	/**
	 * Removes the user details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userDetailsId the primary key of the user details
	 * @return the user details that was removed
	 * @throws NoSuchUserDetailsException if a user details with the primary key could not be found
	 */
	public UserDetails remove(long userDetailsId)
		throws NoSuchUserDetailsException;

	public UserDetails updateImpl(UserDetails userDetails);

	/**
	 * Returns the user details with the primary key or throws a <code>NoSuchUserDetailsException</code> if it could not be found.
	 *
	 * @param userDetailsId the primary key of the user details
	 * @return the user details
	 * @throws NoSuchUserDetailsException if a user details with the primary key could not be found
	 */
	public UserDetails findByPrimaryKey(long userDetailsId)
		throws NoSuchUserDetailsException;

	/**
	 * Returns the user details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userDetailsId the primary key of the user details
	 * @return the user details, or <code>null</code> if a user details with the primary key could not be found
	 */
	public UserDetails fetchByPrimaryKey(long userDetailsId);

	/**
	 * Returns all the user detailses.
	 *
	 * @return the user detailses
	 */
	public java.util.List<UserDetails> findAll();

	/**
	 * Returns a range of all the user detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user detailses
	 * @param end the upper bound of the range of user detailses (not inclusive)
	 * @return the range of user detailses
	 */
	public java.util.List<UserDetails> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the user detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user detailses
	 * @param end the upper bound of the range of user detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user detailses
	 */
	public java.util.List<UserDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user detailses
	 * @param end the upper bound of the range of user detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user detailses
	 */
	public java.util.List<UserDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the user detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user detailses.
	 *
	 * @return the number of user detailses
	 */
	public int countAll();

}