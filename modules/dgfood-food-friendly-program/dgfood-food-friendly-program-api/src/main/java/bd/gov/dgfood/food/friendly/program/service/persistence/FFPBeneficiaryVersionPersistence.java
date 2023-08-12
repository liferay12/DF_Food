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

import bd.gov.dgfood.food.friendly.program.exception.NoSuchFFPBeneficiaryVersionException;
import bd.gov.dgfood.food.friendly.program.model.FFPBeneficiaryVersion;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ffp beneficiary version service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FFPBeneficiaryVersionUtil
 * @generated
 */
@ProviderType
public interface FFPBeneficiaryVersionPersistence
	extends BasePersistence<FFPBeneficiaryVersion> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FFPBeneficiaryVersionUtil} to access the ffp beneficiary version persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the ffp beneficiary versions where beneficiaryId = &#63;.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @return the matching ffp beneficiary versions
	 */
	public java.util.List<FFPBeneficiaryVersion> findByBeneficiaryId(
		long beneficiaryId);

	/**
	 * Returns a range of all the ffp beneficiary versions where beneficiaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param start the lower bound of the range of ffp beneficiary versions
	 * @param end the upper bound of the range of ffp beneficiary versions (not inclusive)
	 * @return the range of matching ffp beneficiary versions
	 */
	public java.util.List<FFPBeneficiaryVersion> findByBeneficiaryId(
		long beneficiaryId, int start, int end);

	/**
	 * Returns an ordered range of all the ffp beneficiary versions where beneficiaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param start the lower bound of the range of ffp beneficiary versions
	 * @param end the upper bound of the range of ffp beneficiary versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ffp beneficiary versions
	 */
	public java.util.List<FFPBeneficiaryVersion> findByBeneficiaryId(
		long beneficiaryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FFPBeneficiaryVersion>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ffp beneficiary versions where beneficiaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param start the lower bound of the range of ffp beneficiary versions
	 * @param end the upper bound of the range of ffp beneficiary versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ffp beneficiary versions
	 */
	public java.util.List<FFPBeneficiaryVersion> findByBeneficiaryId(
		long beneficiaryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FFPBeneficiaryVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ffp beneficiary version in the ordered set where beneficiaryId = &#63;.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ffp beneficiary version
	 * @throws NoSuchFFPBeneficiaryVersionException if a matching ffp beneficiary version could not be found
	 */
	public FFPBeneficiaryVersion findByBeneficiaryId_First(
			long beneficiaryId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FFPBeneficiaryVersion> orderByComparator)
		throws NoSuchFFPBeneficiaryVersionException;

	/**
	 * Returns the first ffp beneficiary version in the ordered set where beneficiaryId = &#63;.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ffp beneficiary version, or <code>null</code> if a matching ffp beneficiary version could not be found
	 */
	public FFPBeneficiaryVersion fetchByBeneficiaryId_First(
		long beneficiaryId,
		com.liferay.portal.kernel.util.OrderByComparator<FFPBeneficiaryVersion>
			orderByComparator);

	/**
	 * Returns the last ffp beneficiary version in the ordered set where beneficiaryId = &#63;.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ffp beneficiary version
	 * @throws NoSuchFFPBeneficiaryVersionException if a matching ffp beneficiary version could not be found
	 */
	public FFPBeneficiaryVersion findByBeneficiaryId_Last(
			long beneficiaryId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FFPBeneficiaryVersion> orderByComparator)
		throws NoSuchFFPBeneficiaryVersionException;

	/**
	 * Returns the last ffp beneficiary version in the ordered set where beneficiaryId = &#63;.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ffp beneficiary version, or <code>null</code> if a matching ffp beneficiary version could not be found
	 */
	public FFPBeneficiaryVersion fetchByBeneficiaryId_Last(
		long beneficiaryId,
		com.liferay.portal.kernel.util.OrderByComparator<FFPBeneficiaryVersion>
			orderByComparator);

	/**
	 * Returns the ffp beneficiary versions before and after the current ffp beneficiary version in the ordered set where beneficiaryId = &#63;.
	 *
	 * @param beneficiaryVersionId the primary key of the current ffp beneficiary version
	 * @param beneficiaryId the beneficiary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ffp beneficiary version
	 * @throws NoSuchFFPBeneficiaryVersionException if a ffp beneficiary version with the primary key could not be found
	 */
	public FFPBeneficiaryVersion[] findByBeneficiaryId_PrevAndNext(
			long beneficiaryVersionId, long beneficiaryId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FFPBeneficiaryVersion> orderByComparator)
		throws NoSuchFFPBeneficiaryVersionException;

	/**
	 * Removes all the ffp beneficiary versions where beneficiaryId = &#63; from the database.
	 *
	 * @param beneficiaryId the beneficiary ID
	 */
	public void removeByBeneficiaryId(long beneficiaryId);

	/**
	 * Returns the number of ffp beneficiary versions where beneficiaryId = &#63;.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @return the number of matching ffp beneficiary versions
	 */
	public int countByBeneficiaryId(long beneficiaryId);

	/**
	 * Returns the ffp beneficiary version where beneficiaryId = &#63; and version = &#63; or throws a <code>NoSuchFFPBeneficiaryVersionException</code> if it could not be found.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param version the version
	 * @return the matching ffp beneficiary version
	 * @throws NoSuchFFPBeneficiaryVersionException if a matching ffp beneficiary version could not be found
	 */
	public FFPBeneficiaryVersion findById_Version(
			long beneficiaryId, double version)
		throws NoSuchFFPBeneficiaryVersionException;

	/**
	 * Returns the ffp beneficiary version where beneficiaryId = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param version the version
	 * @return the matching ffp beneficiary version, or <code>null</code> if a matching ffp beneficiary version could not be found
	 */
	public FFPBeneficiaryVersion fetchById_Version(
		long beneficiaryId, double version);

	/**
	 * Returns the ffp beneficiary version where beneficiaryId = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param version the version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ffp beneficiary version, or <code>null</code> if a matching ffp beneficiary version could not be found
	 */
	public FFPBeneficiaryVersion fetchById_Version(
		long beneficiaryId, double version, boolean useFinderCache);

	/**
	 * Removes the ffp beneficiary version where beneficiaryId = &#63; and version = &#63; from the database.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param version the version
	 * @return the ffp beneficiary version that was removed
	 */
	public FFPBeneficiaryVersion removeById_Version(
			long beneficiaryId, double version)
		throws NoSuchFFPBeneficiaryVersionException;

	/**
	 * Returns the number of ffp beneficiary versions where beneficiaryId = &#63; and version = &#63;.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param version the version
	 * @return the number of matching ffp beneficiary versions
	 */
	public int countById_Version(long beneficiaryId, double version);

	/**
	 * Returns all the ffp beneficiary versions where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching ffp beneficiary versions
	 */
	public java.util.List<FFPBeneficiaryVersion> findByStatus(int status);

	/**
	 * Returns a range of all the ffp beneficiary versions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of ffp beneficiary versions
	 * @param end the upper bound of the range of ffp beneficiary versions (not inclusive)
	 * @return the range of matching ffp beneficiary versions
	 */
	public java.util.List<FFPBeneficiaryVersion> findByStatus(
		int status, int start, int end);

	/**
	 * Returns an ordered range of all the ffp beneficiary versions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of ffp beneficiary versions
	 * @param end the upper bound of the range of ffp beneficiary versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ffp beneficiary versions
	 */
	public java.util.List<FFPBeneficiaryVersion> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FFPBeneficiaryVersion>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ffp beneficiary versions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of ffp beneficiary versions
	 * @param end the upper bound of the range of ffp beneficiary versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ffp beneficiary versions
	 */
	public java.util.List<FFPBeneficiaryVersion> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FFPBeneficiaryVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ffp beneficiary version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ffp beneficiary version
	 * @throws NoSuchFFPBeneficiaryVersionException if a matching ffp beneficiary version could not be found
	 */
	public FFPBeneficiaryVersion findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<FFPBeneficiaryVersion> orderByComparator)
		throws NoSuchFFPBeneficiaryVersionException;

	/**
	 * Returns the first ffp beneficiary version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ffp beneficiary version, or <code>null</code> if a matching ffp beneficiary version could not be found
	 */
	public FFPBeneficiaryVersion fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<FFPBeneficiaryVersion>
			orderByComparator);

	/**
	 * Returns the last ffp beneficiary version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ffp beneficiary version
	 * @throws NoSuchFFPBeneficiaryVersionException if a matching ffp beneficiary version could not be found
	 */
	public FFPBeneficiaryVersion findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<FFPBeneficiaryVersion> orderByComparator)
		throws NoSuchFFPBeneficiaryVersionException;

	/**
	 * Returns the last ffp beneficiary version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ffp beneficiary version, or <code>null</code> if a matching ffp beneficiary version could not be found
	 */
	public FFPBeneficiaryVersion fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<FFPBeneficiaryVersion>
			orderByComparator);

	/**
	 * Returns the ffp beneficiary versions before and after the current ffp beneficiary version in the ordered set where status = &#63;.
	 *
	 * @param beneficiaryVersionId the primary key of the current ffp beneficiary version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ffp beneficiary version
	 * @throws NoSuchFFPBeneficiaryVersionException if a ffp beneficiary version with the primary key could not be found
	 */
	public FFPBeneficiaryVersion[] findByStatus_PrevAndNext(
			long beneficiaryVersionId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<FFPBeneficiaryVersion> orderByComparator)
		throws NoSuchFFPBeneficiaryVersionException;

	/**
	 * Removes all the ffp beneficiary versions where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of ffp beneficiary versions where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching ffp beneficiary versions
	 */
	public int countByStatus(int status);

	/**
	 * Caches the ffp beneficiary version in the entity cache if it is enabled.
	 *
	 * @param ffpBeneficiaryVersion the ffp beneficiary version
	 */
	public void cacheResult(FFPBeneficiaryVersion ffpBeneficiaryVersion);

	/**
	 * Caches the ffp beneficiary versions in the entity cache if it is enabled.
	 *
	 * @param ffpBeneficiaryVersions the ffp beneficiary versions
	 */
	public void cacheResult(
		java.util.List<FFPBeneficiaryVersion> ffpBeneficiaryVersions);

	/**
	 * Creates a new ffp beneficiary version with the primary key. Does not add the ffp beneficiary version to the database.
	 *
	 * @param beneficiaryVersionId the primary key for the new ffp beneficiary version
	 * @return the new ffp beneficiary version
	 */
	public FFPBeneficiaryVersion create(long beneficiaryVersionId);

	/**
	 * Removes the ffp beneficiary version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param beneficiaryVersionId the primary key of the ffp beneficiary version
	 * @return the ffp beneficiary version that was removed
	 * @throws NoSuchFFPBeneficiaryVersionException if a ffp beneficiary version with the primary key could not be found
	 */
	public FFPBeneficiaryVersion remove(long beneficiaryVersionId)
		throws NoSuchFFPBeneficiaryVersionException;

	public FFPBeneficiaryVersion updateImpl(
		FFPBeneficiaryVersion ffpBeneficiaryVersion);

	/**
	 * Returns the ffp beneficiary version with the primary key or throws a <code>NoSuchFFPBeneficiaryVersionException</code> if it could not be found.
	 *
	 * @param beneficiaryVersionId the primary key of the ffp beneficiary version
	 * @return the ffp beneficiary version
	 * @throws NoSuchFFPBeneficiaryVersionException if a ffp beneficiary version with the primary key could not be found
	 */
	public FFPBeneficiaryVersion findByPrimaryKey(long beneficiaryVersionId)
		throws NoSuchFFPBeneficiaryVersionException;

	/**
	 * Returns the ffp beneficiary version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param beneficiaryVersionId the primary key of the ffp beneficiary version
	 * @return the ffp beneficiary version, or <code>null</code> if a ffp beneficiary version with the primary key could not be found
	 */
	public FFPBeneficiaryVersion fetchByPrimaryKey(long beneficiaryVersionId);

	/**
	 * Returns all the ffp beneficiary versions.
	 *
	 * @return the ffp beneficiary versions
	 */
	public java.util.List<FFPBeneficiaryVersion> findAll();

	/**
	 * Returns a range of all the ffp beneficiary versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ffp beneficiary versions
	 * @param end the upper bound of the range of ffp beneficiary versions (not inclusive)
	 * @return the range of ffp beneficiary versions
	 */
	public java.util.List<FFPBeneficiaryVersion> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the ffp beneficiary versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ffp beneficiary versions
	 * @param end the upper bound of the range of ffp beneficiary versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ffp beneficiary versions
	 */
	public java.util.List<FFPBeneficiaryVersion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FFPBeneficiaryVersion>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ffp beneficiary versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ffp beneficiary versions
	 * @param end the upper bound of the range of ffp beneficiary versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ffp beneficiary versions
	 */
	public java.util.List<FFPBeneficiaryVersion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FFPBeneficiaryVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ffp beneficiary versions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ffp beneficiary versions.
	 *
	 * @return the number of ffp beneficiary versions
	 */
	public int countAll();

}