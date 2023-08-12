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

import bd.gov.dgfood.common.services.exception.NoSuchAddressVersionException;
import bd.gov.dgfood.common.services.model.AddressVersion;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the address version service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressVersionUtil
 * @generated
 */
@ProviderType
public interface AddressVersionPersistence
	extends BasePersistence<AddressVersion> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AddressVersionUtil} to access the address version persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the address versions where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @return the matching address versions
	 */
	public java.util.List<AddressVersion> findByCPK_CN(
		long classPK, String className);

	/**
	 * Returns a range of all the address versions where classPK = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressVersionModelImpl</code>.
	 * </p>
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param start the lower bound of the range of address versions
	 * @param end the upper bound of the range of address versions (not inclusive)
	 * @return the range of matching address versions
	 */
	public java.util.List<AddressVersion> findByCPK_CN(
		long classPK, String className, int start, int end);

	/**
	 * Returns an ordered range of all the address versions where classPK = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressVersionModelImpl</code>.
	 * </p>
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param start the lower bound of the range of address versions
	 * @param end the upper bound of the range of address versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching address versions
	 */
	public java.util.List<AddressVersion> findByCPK_CN(
		long classPK, String className, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AddressVersion>
			orderByComparator);

	/**
	 * Returns an ordered range of all the address versions where classPK = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressVersionModelImpl</code>.
	 * </p>
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param start the lower bound of the range of address versions
	 * @param end the upper bound of the range of address versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching address versions
	 */
	public java.util.List<AddressVersion> findByCPK_CN(
		long classPK, String className, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AddressVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first address version in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address version
	 * @throws NoSuchAddressVersionException if a matching address version could not be found
	 */
	public AddressVersion findByCPK_CN_First(
			long classPK, String className,
			com.liferay.portal.kernel.util.OrderByComparator<AddressVersion>
				orderByComparator)
		throws NoSuchAddressVersionException;

	/**
	 * Returns the first address version in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address version, or <code>null</code> if a matching address version could not be found
	 */
	public AddressVersion fetchByCPK_CN_First(
		long classPK, String className,
		com.liferay.portal.kernel.util.OrderByComparator<AddressVersion>
			orderByComparator);

	/**
	 * Returns the last address version in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address version
	 * @throws NoSuchAddressVersionException if a matching address version could not be found
	 */
	public AddressVersion findByCPK_CN_Last(
			long classPK, String className,
			com.liferay.portal.kernel.util.OrderByComparator<AddressVersion>
				orderByComparator)
		throws NoSuchAddressVersionException;

	/**
	 * Returns the last address version in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address version, or <code>null</code> if a matching address version could not be found
	 */
	public AddressVersion fetchByCPK_CN_Last(
		long classPK, String className,
		com.liferay.portal.kernel.util.OrderByComparator<AddressVersion>
			orderByComparator);

	/**
	 * Returns the address versions before and after the current address version in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param addressVersionId the primary key of the current address version
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next address version
	 * @throws NoSuchAddressVersionException if a address version with the primary key could not be found
	 */
	public AddressVersion[] findByCPK_CN_PrevAndNext(
			long addressVersionId, long classPK, String className,
			com.liferay.portal.kernel.util.OrderByComparator<AddressVersion>
				orderByComparator)
		throws NoSuchAddressVersionException;

	/**
	 * Removes all the address versions where classPK = &#63; and className = &#63; from the database.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 */
	public void removeByCPK_CN(long classPK, String className);

	/**
	 * Returns the number of address versions where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @return the number of matching address versions
	 */
	public int countByCPK_CN(long classPK, String className);

	/**
	 * Caches the address version in the entity cache if it is enabled.
	 *
	 * @param addressVersion the address version
	 */
	public void cacheResult(AddressVersion addressVersion);

	/**
	 * Caches the address versions in the entity cache if it is enabled.
	 *
	 * @param addressVersions the address versions
	 */
	public void cacheResult(java.util.List<AddressVersion> addressVersions);

	/**
	 * Creates a new address version with the primary key. Does not add the address version to the database.
	 *
	 * @param addressVersionId the primary key for the new address version
	 * @return the new address version
	 */
	public AddressVersion create(long addressVersionId);

	/**
	 * Removes the address version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addressVersionId the primary key of the address version
	 * @return the address version that was removed
	 * @throws NoSuchAddressVersionException if a address version with the primary key could not be found
	 */
	public AddressVersion remove(long addressVersionId)
		throws NoSuchAddressVersionException;

	public AddressVersion updateImpl(AddressVersion addressVersion);

	/**
	 * Returns the address version with the primary key or throws a <code>NoSuchAddressVersionException</code> if it could not be found.
	 *
	 * @param addressVersionId the primary key of the address version
	 * @return the address version
	 * @throws NoSuchAddressVersionException if a address version with the primary key could not be found
	 */
	public AddressVersion findByPrimaryKey(long addressVersionId)
		throws NoSuchAddressVersionException;

	/**
	 * Returns the address version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addressVersionId the primary key of the address version
	 * @return the address version, or <code>null</code> if a address version with the primary key could not be found
	 */
	public AddressVersion fetchByPrimaryKey(long addressVersionId);

	/**
	 * Returns all the address versions.
	 *
	 * @return the address versions
	 */
	public java.util.List<AddressVersion> findAll();

	/**
	 * Returns a range of all the address versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of address versions
	 * @param end the upper bound of the range of address versions (not inclusive)
	 * @return the range of address versions
	 */
	public java.util.List<AddressVersion> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the address versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of address versions
	 * @param end the upper bound of the range of address versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of address versions
	 */
	public java.util.List<AddressVersion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AddressVersion>
			orderByComparator);

	/**
	 * Returns an ordered range of all the address versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of address versions
	 * @param end the upper bound of the range of address versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of address versions
	 */
	public java.util.List<AddressVersion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AddressVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the address versions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of address versions.
	 *
	 * @return the number of address versions
	 */
	public int countAll();

}