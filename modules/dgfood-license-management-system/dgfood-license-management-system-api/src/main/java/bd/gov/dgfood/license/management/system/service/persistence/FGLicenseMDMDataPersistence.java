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

import bd.gov.dgfood.license.management.system.exception.NoSuchFGLicenseMDMDataException;
import bd.gov.dgfood.license.management.system.model.FGLicenseMDMData;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the fg license mdm data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FGLicenseMDMDataUtil
 * @generated
 */
@ProviderType
public interface FGLicenseMDMDataPersistence
	extends BasePersistence<FGLicenseMDMData> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FGLicenseMDMDataUtil} to access the fg license mdm data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the fg license mdm datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching fg license mdm datas
	 */
	public java.util.List<FGLicenseMDMData> findByUuid(String uuid);

	/**
	 * Returns a range of all the fg license mdm datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseMDMDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fg license mdm datas
	 * @param end the upper bound of the range of fg license mdm datas (not inclusive)
	 * @return the range of matching fg license mdm datas
	 */
	public java.util.List<FGLicenseMDMData> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the fg license mdm datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseMDMDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fg license mdm datas
	 * @param end the upper bound of the range of fg license mdm datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fg license mdm datas
	 */
	public java.util.List<FGLicenseMDMData> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FGLicenseMDMData>
			orderByComparator);

	/**
	 * Returns an ordered range of all the fg license mdm datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseMDMDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fg license mdm datas
	 * @param end the upper bound of the range of fg license mdm datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching fg license mdm datas
	 */
	public java.util.List<FGLicenseMDMData> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FGLicenseMDMData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first fg license mdm data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fg license mdm data
	 * @throws NoSuchFGLicenseMDMDataException if a matching fg license mdm data could not be found
	 */
	public FGLicenseMDMData findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FGLicenseMDMData>
				orderByComparator)
		throws NoSuchFGLicenseMDMDataException;

	/**
	 * Returns the first fg license mdm data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fg license mdm data, or <code>null</code> if a matching fg license mdm data could not be found
	 */
	public FGLicenseMDMData fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FGLicenseMDMData>
			orderByComparator);

	/**
	 * Returns the last fg license mdm data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fg license mdm data
	 * @throws NoSuchFGLicenseMDMDataException if a matching fg license mdm data could not be found
	 */
	public FGLicenseMDMData findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FGLicenseMDMData>
				orderByComparator)
		throws NoSuchFGLicenseMDMDataException;

	/**
	 * Returns the last fg license mdm data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fg license mdm data, or <code>null</code> if a matching fg license mdm data could not be found
	 */
	public FGLicenseMDMData fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FGLicenseMDMData>
			orderByComparator);

	/**
	 * Returns the fg license mdm datas before and after the current fg license mdm data in the ordered set where uuid = &#63;.
	 *
	 * @param fgLicenseMDMId the primary key of the current fg license mdm data
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fg license mdm data
	 * @throws NoSuchFGLicenseMDMDataException if a fg license mdm data with the primary key could not be found
	 */
	public FGLicenseMDMData[] findByUuid_PrevAndNext(
			long fgLicenseMDMId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FGLicenseMDMData>
				orderByComparator)
		throws NoSuchFGLicenseMDMDataException;

	/**
	 * Removes all the fg license mdm datas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of fg license mdm datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching fg license mdm datas
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the fg license mdm data in the entity cache if it is enabled.
	 *
	 * @param fgLicenseMDMData the fg license mdm data
	 */
	public void cacheResult(FGLicenseMDMData fgLicenseMDMData);

	/**
	 * Caches the fg license mdm datas in the entity cache if it is enabled.
	 *
	 * @param fgLicenseMDMDatas the fg license mdm datas
	 */
	public void cacheResult(java.util.List<FGLicenseMDMData> fgLicenseMDMDatas);

	/**
	 * Creates a new fg license mdm data with the primary key. Does not add the fg license mdm data to the database.
	 *
	 * @param fgLicenseMDMId the primary key for the new fg license mdm data
	 * @return the new fg license mdm data
	 */
	public FGLicenseMDMData create(long fgLicenseMDMId);

	/**
	 * Removes the fg license mdm data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fgLicenseMDMId the primary key of the fg license mdm data
	 * @return the fg license mdm data that was removed
	 * @throws NoSuchFGLicenseMDMDataException if a fg license mdm data with the primary key could not be found
	 */
	public FGLicenseMDMData remove(long fgLicenseMDMId)
		throws NoSuchFGLicenseMDMDataException;

	public FGLicenseMDMData updateImpl(FGLicenseMDMData fgLicenseMDMData);

	/**
	 * Returns the fg license mdm data with the primary key or throws a <code>NoSuchFGLicenseMDMDataException</code> if it could not be found.
	 *
	 * @param fgLicenseMDMId the primary key of the fg license mdm data
	 * @return the fg license mdm data
	 * @throws NoSuchFGLicenseMDMDataException if a fg license mdm data with the primary key could not be found
	 */
	public FGLicenseMDMData findByPrimaryKey(long fgLicenseMDMId)
		throws NoSuchFGLicenseMDMDataException;

	/**
	 * Returns the fg license mdm data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fgLicenseMDMId the primary key of the fg license mdm data
	 * @return the fg license mdm data, or <code>null</code> if a fg license mdm data with the primary key could not be found
	 */
	public FGLicenseMDMData fetchByPrimaryKey(long fgLicenseMDMId);

	/**
	 * Returns all the fg license mdm datas.
	 *
	 * @return the fg license mdm datas
	 */
	public java.util.List<FGLicenseMDMData> findAll();

	/**
	 * Returns a range of all the fg license mdm datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseMDMDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fg license mdm datas
	 * @param end the upper bound of the range of fg license mdm datas (not inclusive)
	 * @return the range of fg license mdm datas
	 */
	public java.util.List<FGLicenseMDMData> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the fg license mdm datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseMDMDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fg license mdm datas
	 * @param end the upper bound of the range of fg license mdm datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fg license mdm datas
	 */
	public java.util.List<FGLicenseMDMData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FGLicenseMDMData>
			orderByComparator);

	/**
	 * Returns an ordered range of all the fg license mdm datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseMDMDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fg license mdm datas
	 * @param end the upper bound of the range of fg license mdm datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of fg license mdm datas
	 */
	public java.util.List<FGLicenseMDMData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FGLicenseMDMData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the fg license mdm datas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of fg license mdm datas.
	 *
	 * @return the number of fg license mdm datas
	 */
	public int countAll();

}