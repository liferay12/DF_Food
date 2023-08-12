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

package bd.gov.dgfood.movement.contractor.service.persistence;

import bd.gov.dgfood.movement.contractor.exception.NoSuchMovementContractorException;
import bd.gov.dgfood.movement.contractor.model.MovementContractor;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the movement contractor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MovementContractorUtil
 * @generated
 */
@ProviderType
public interface MovementContractorPersistence
	extends BasePersistence<MovementContractor> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MovementContractorUtil} to access the movement contractor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the movement contractors where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching movement contractors
	 */
	public java.util.List<MovementContractor> findByUuid(String uuid);

	/**
	 * Returns a range of all the movement contractors where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovementContractorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of movement contractors
	 * @param end the upper bound of the range of movement contractors (not inclusive)
	 * @return the range of matching movement contractors
	 */
	public java.util.List<MovementContractor> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the movement contractors where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovementContractorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of movement contractors
	 * @param end the upper bound of the range of movement contractors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching movement contractors
	 */
	public java.util.List<MovementContractor> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MovementContractor>
			orderByComparator);

	/**
	 * Returns an ordered range of all the movement contractors where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovementContractorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of movement contractors
	 * @param end the upper bound of the range of movement contractors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching movement contractors
	 */
	public java.util.List<MovementContractor> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MovementContractor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first movement contractor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching movement contractor
	 * @throws NoSuchMovementContractorException if a matching movement contractor could not be found
	 */
	public MovementContractor findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<MovementContractor>
				orderByComparator)
		throws NoSuchMovementContractorException;

	/**
	 * Returns the first movement contractor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching movement contractor, or <code>null</code> if a matching movement contractor could not be found
	 */
	public MovementContractor fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MovementContractor>
			orderByComparator);

	/**
	 * Returns the last movement contractor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching movement contractor
	 * @throws NoSuchMovementContractorException if a matching movement contractor could not be found
	 */
	public MovementContractor findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<MovementContractor>
				orderByComparator)
		throws NoSuchMovementContractorException;

	/**
	 * Returns the last movement contractor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching movement contractor, or <code>null</code> if a matching movement contractor could not be found
	 */
	public MovementContractor fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MovementContractor>
			orderByComparator);

	/**
	 * Returns the movement contractors before and after the current movement contractor in the ordered set where uuid = &#63;.
	 *
	 * @param movementContractorId the primary key of the current movement contractor
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next movement contractor
	 * @throws NoSuchMovementContractorException if a movement contractor with the primary key could not be found
	 */
	public MovementContractor[] findByUuid_PrevAndNext(
			long movementContractorId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<MovementContractor>
				orderByComparator)
		throws NoSuchMovementContractorException;

	/**
	 * Removes all the movement contractors where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of movement contractors where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching movement contractors
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the movement contractor where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchMovementContractorException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching movement contractor
	 * @throws NoSuchMovementContractorException if a matching movement contractor could not be found
	 */
	public MovementContractor findByUUID_G(String uuid, long groupId)
		throws NoSuchMovementContractorException;

	/**
	 * Returns the movement contractor where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching movement contractor, or <code>null</code> if a matching movement contractor could not be found
	 */
	public MovementContractor fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the movement contractor where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching movement contractor, or <code>null</code> if a matching movement contractor could not be found
	 */
	public MovementContractor fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the movement contractor where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the movement contractor that was removed
	 */
	public MovementContractor removeByUUID_G(String uuid, long groupId)
		throws NoSuchMovementContractorException;

	/**
	 * Returns the number of movement contractors where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching movement contractors
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the movement contractors where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching movement contractors
	 */
	public java.util.List<MovementContractor> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the movement contractors where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovementContractorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of movement contractors
	 * @param end the upper bound of the range of movement contractors (not inclusive)
	 * @return the range of matching movement contractors
	 */
	public java.util.List<MovementContractor> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the movement contractors where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovementContractorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of movement contractors
	 * @param end the upper bound of the range of movement contractors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching movement contractors
	 */
	public java.util.List<MovementContractor> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MovementContractor>
			orderByComparator);

	/**
	 * Returns an ordered range of all the movement contractors where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovementContractorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of movement contractors
	 * @param end the upper bound of the range of movement contractors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching movement contractors
	 */
	public java.util.List<MovementContractor> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MovementContractor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first movement contractor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching movement contractor
	 * @throws NoSuchMovementContractorException if a matching movement contractor could not be found
	 */
	public MovementContractor findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<MovementContractor>
				orderByComparator)
		throws NoSuchMovementContractorException;

	/**
	 * Returns the first movement contractor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching movement contractor, or <code>null</code> if a matching movement contractor could not be found
	 */
	public MovementContractor fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MovementContractor>
			orderByComparator);

	/**
	 * Returns the last movement contractor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching movement contractor
	 * @throws NoSuchMovementContractorException if a matching movement contractor could not be found
	 */
	public MovementContractor findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<MovementContractor>
				orderByComparator)
		throws NoSuchMovementContractorException;

	/**
	 * Returns the last movement contractor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching movement contractor, or <code>null</code> if a matching movement contractor could not be found
	 */
	public MovementContractor fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MovementContractor>
			orderByComparator);

	/**
	 * Returns the movement contractors before and after the current movement contractor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param movementContractorId the primary key of the current movement contractor
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next movement contractor
	 * @throws NoSuchMovementContractorException if a movement contractor with the primary key could not be found
	 */
	public MovementContractor[] findByUuid_C_PrevAndNext(
			long movementContractorId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<MovementContractor>
				orderByComparator)
		throws NoSuchMovementContractorException;

	/**
	 * Removes all the movement contractors where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of movement contractors where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching movement contractors
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the movement contractor in the entity cache if it is enabled.
	 *
	 * @param movementContractor the movement contractor
	 */
	public void cacheResult(MovementContractor movementContractor);

	/**
	 * Caches the movement contractors in the entity cache if it is enabled.
	 *
	 * @param movementContractors the movement contractors
	 */
	public void cacheResult(
		java.util.List<MovementContractor> movementContractors);

	/**
	 * Creates a new movement contractor with the primary key. Does not add the movement contractor to the database.
	 *
	 * @param movementContractorId the primary key for the new movement contractor
	 * @return the new movement contractor
	 */
	public MovementContractor create(long movementContractorId);

	/**
	 * Removes the movement contractor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param movementContractorId the primary key of the movement contractor
	 * @return the movement contractor that was removed
	 * @throws NoSuchMovementContractorException if a movement contractor with the primary key could not be found
	 */
	public MovementContractor remove(long movementContractorId)
		throws NoSuchMovementContractorException;

	public MovementContractor updateImpl(MovementContractor movementContractor);

	/**
	 * Returns the movement contractor with the primary key or throws a <code>NoSuchMovementContractorException</code> if it could not be found.
	 *
	 * @param movementContractorId the primary key of the movement contractor
	 * @return the movement contractor
	 * @throws NoSuchMovementContractorException if a movement contractor with the primary key could not be found
	 */
	public MovementContractor findByPrimaryKey(long movementContractorId)
		throws NoSuchMovementContractorException;

	/**
	 * Returns the movement contractor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param movementContractorId the primary key of the movement contractor
	 * @return the movement contractor, or <code>null</code> if a movement contractor with the primary key could not be found
	 */
	public MovementContractor fetchByPrimaryKey(long movementContractorId);

	/**
	 * Returns all the movement contractors.
	 *
	 * @return the movement contractors
	 */
	public java.util.List<MovementContractor> findAll();

	/**
	 * Returns a range of all the movement contractors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovementContractorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of movement contractors
	 * @param end the upper bound of the range of movement contractors (not inclusive)
	 * @return the range of movement contractors
	 */
	public java.util.List<MovementContractor> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the movement contractors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovementContractorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of movement contractors
	 * @param end the upper bound of the range of movement contractors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of movement contractors
	 */
	public java.util.List<MovementContractor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MovementContractor>
			orderByComparator);

	/**
	 * Returns an ordered range of all the movement contractors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovementContractorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of movement contractors
	 * @param end the upper bound of the range of movement contractors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of movement contractors
	 */
	public java.util.List<MovementContractor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MovementContractor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the movement contractors from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of movement contractors.
	 *
	 * @return the number of movement contractors
	 */
	public int countAll();

}