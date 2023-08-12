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

import bd.gov.dgfood.license.management.system.exception.NoSuchFGLicenseDetailsException;
import bd.gov.dgfood.license.management.system.model.FGLicenseDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the fg license details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FGLicenseDetailsUtil
 * @generated
 */
@ProviderType
public interface FGLicenseDetailsPersistence
	extends BasePersistence<FGLicenseDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FGLicenseDetailsUtil} to access the fg license details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the fg license detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching fg license detailses
	 */
	public java.util.List<FGLicenseDetails> findByUuid(String uuid);

	/**
	 * Returns a range of all the fg license detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fg license detailses
	 * @param end the upper bound of the range of fg license detailses (not inclusive)
	 * @return the range of matching fg license detailses
	 */
	public java.util.List<FGLicenseDetails> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the fg license detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fg license detailses
	 * @param end the upper bound of the range of fg license detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fg license detailses
	 */
	public java.util.List<FGLicenseDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FGLicenseDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the fg license detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fg license detailses
	 * @param end the upper bound of the range of fg license detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching fg license detailses
	 */
	public java.util.List<FGLicenseDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FGLicenseDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first fg license details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fg license details
	 * @throws NoSuchFGLicenseDetailsException if a matching fg license details could not be found
	 */
	public FGLicenseDetails findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FGLicenseDetails>
				orderByComparator)
		throws NoSuchFGLicenseDetailsException;

	/**
	 * Returns the first fg license details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fg license details, or <code>null</code> if a matching fg license details could not be found
	 */
	public FGLicenseDetails fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FGLicenseDetails>
			orderByComparator);

	/**
	 * Returns the last fg license details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fg license details
	 * @throws NoSuchFGLicenseDetailsException if a matching fg license details could not be found
	 */
	public FGLicenseDetails findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FGLicenseDetails>
				orderByComparator)
		throws NoSuchFGLicenseDetailsException;

	/**
	 * Returns the last fg license details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fg license details, or <code>null</code> if a matching fg license details could not be found
	 */
	public FGLicenseDetails fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FGLicenseDetails>
			orderByComparator);

	/**
	 * Returns the fg license detailses before and after the current fg license details in the ordered set where uuid = &#63;.
	 *
	 * @param fgLicenseMasterId the primary key of the current fg license details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fg license details
	 * @throws NoSuchFGLicenseDetailsException if a fg license details with the primary key could not be found
	 */
	public FGLicenseDetails[] findByUuid_PrevAndNext(
			long fgLicenseMasterId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FGLicenseDetails>
				orderByComparator)
		throws NoSuchFGLicenseDetailsException;

	/**
	 * Removes all the fg license detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of fg license detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching fg license detailses
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the fg license details in the entity cache if it is enabled.
	 *
	 * @param fgLicenseDetails the fg license details
	 */
	public void cacheResult(FGLicenseDetails fgLicenseDetails);

	/**
	 * Caches the fg license detailses in the entity cache if it is enabled.
	 *
	 * @param fgLicenseDetailses the fg license detailses
	 */
	public void cacheResult(
		java.util.List<FGLicenseDetails> fgLicenseDetailses);

	/**
	 * Creates a new fg license details with the primary key. Does not add the fg license details to the database.
	 *
	 * @param fgLicenseMasterId the primary key for the new fg license details
	 * @return the new fg license details
	 */
	public FGLicenseDetails create(long fgLicenseMasterId);

	/**
	 * Removes the fg license details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fgLicenseMasterId the primary key of the fg license details
	 * @return the fg license details that was removed
	 * @throws NoSuchFGLicenseDetailsException if a fg license details with the primary key could not be found
	 */
	public FGLicenseDetails remove(long fgLicenseMasterId)
		throws NoSuchFGLicenseDetailsException;

	public FGLicenseDetails updateImpl(FGLicenseDetails fgLicenseDetails);

	/**
	 * Returns the fg license details with the primary key or throws a <code>NoSuchFGLicenseDetailsException</code> if it could not be found.
	 *
	 * @param fgLicenseMasterId the primary key of the fg license details
	 * @return the fg license details
	 * @throws NoSuchFGLicenseDetailsException if a fg license details with the primary key could not be found
	 */
	public FGLicenseDetails findByPrimaryKey(long fgLicenseMasterId)
		throws NoSuchFGLicenseDetailsException;

	/**
	 * Returns the fg license details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fgLicenseMasterId the primary key of the fg license details
	 * @return the fg license details, or <code>null</code> if a fg license details with the primary key could not be found
	 */
	public FGLicenseDetails fetchByPrimaryKey(long fgLicenseMasterId);

	/**
	 * Returns all the fg license detailses.
	 *
	 * @return the fg license detailses
	 */
	public java.util.List<FGLicenseDetails> findAll();

	/**
	 * Returns a range of all the fg license detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fg license detailses
	 * @param end the upper bound of the range of fg license detailses (not inclusive)
	 * @return the range of fg license detailses
	 */
	public java.util.List<FGLicenseDetails> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the fg license detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fg license detailses
	 * @param end the upper bound of the range of fg license detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fg license detailses
	 */
	public java.util.List<FGLicenseDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FGLicenseDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the fg license detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fg license detailses
	 * @param end the upper bound of the range of fg license detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of fg license detailses
	 */
	public java.util.List<FGLicenseDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FGLicenseDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the fg license detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of fg license detailses.
	 *
	 * @return the number of fg license detailses
	 */
	public int countAll();

}