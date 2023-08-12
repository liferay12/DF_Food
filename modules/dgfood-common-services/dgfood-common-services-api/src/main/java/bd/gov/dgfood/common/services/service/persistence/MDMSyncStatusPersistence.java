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

import bd.gov.dgfood.common.services.exception.NoSuchMDMSyncStatusException;
import bd.gov.dgfood.common.services.model.MDMSyncStatus;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the mdm sync status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MDMSyncStatusUtil
 * @generated
 */
@ProviderType
public interface MDMSyncStatusPersistence
	extends BasePersistence<MDMSyncStatus> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MDMSyncStatusUtil} to access the mdm sync status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the mdm sync status in the entity cache if it is enabled.
	 *
	 * @param mdmSyncStatus the mdm sync status
	 */
	public void cacheResult(MDMSyncStatus mdmSyncStatus);

	/**
	 * Caches the mdm sync statuses in the entity cache if it is enabled.
	 *
	 * @param mdmSyncStatuses the mdm sync statuses
	 */
	public void cacheResult(java.util.List<MDMSyncStatus> mdmSyncStatuses);

	/**
	 * Creates a new mdm sync status with the primary key. Does not add the mdm sync status to the database.
	 *
	 * @param mdmSyncStatusId the primary key for the new mdm sync status
	 * @return the new mdm sync status
	 */
	public MDMSyncStatus create(long mdmSyncStatusId);

	/**
	 * Removes the mdm sync status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mdmSyncStatusId the primary key of the mdm sync status
	 * @return the mdm sync status that was removed
	 * @throws NoSuchMDMSyncStatusException if a mdm sync status with the primary key could not be found
	 */
	public MDMSyncStatus remove(long mdmSyncStatusId)
		throws NoSuchMDMSyncStatusException;

	public MDMSyncStatus updateImpl(MDMSyncStatus mdmSyncStatus);

	/**
	 * Returns the mdm sync status with the primary key or throws a <code>NoSuchMDMSyncStatusException</code> if it could not be found.
	 *
	 * @param mdmSyncStatusId the primary key of the mdm sync status
	 * @return the mdm sync status
	 * @throws NoSuchMDMSyncStatusException if a mdm sync status with the primary key could not be found
	 */
	public MDMSyncStatus findByPrimaryKey(long mdmSyncStatusId)
		throws NoSuchMDMSyncStatusException;

	/**
	 * Returns the mdm sync status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mdmSyncStatusId the primary key of the mdm sync status
	 * @return the mdm sync status, or <code>null</code> if a mdm sync status with the primary key could not be found
	 */
	public MDMSyncStatus fetchByPrimaryKey(long mdmSyncStatusId);

	/**
	 * Returns all the mdm sync statuses.
	 *
	 * @return the mdm sync statuses
	 */
	public java.util.List<MDMSyncStatus> findAll();

	/**
	 * Returns a range of all the mdm sync statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MDMSyncStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mdm sync statuses
	 * @param end the upper bound of the range of mdm sync statuses (not inclusive)
	 * @return the range of mdm sync statuses
	 */
	public java.util.List<MDMSyncStatus> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the mdm sync statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MDMSyncStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mdm sync statuses
	 * @param end the upper bound of the range of mdm sync statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of mdm sync statuses
	 */
	public java.util.List<MDMSyncStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MDMSyncStatus>
			orderByComparator);

	/**
	 * Returns an ordered range of all the mdm sync statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MDMSyncStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mdm sync statuses
	 * @param end the upper bound of the range of mdm sync statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of mdm sync statuses
	 */
	public java.util.List<MDMSyncStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MDMSyncStatus>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the mdm sync statuses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of mdm sync statuses.
	 *
	 * @return the number of mdm sync statuses
	 */
	public int countAll();

}