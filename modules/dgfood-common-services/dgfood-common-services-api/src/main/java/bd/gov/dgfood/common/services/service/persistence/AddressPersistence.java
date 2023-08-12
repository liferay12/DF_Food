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

import bd.gov.dgfood.common.services.exception.NoSuchAddressException;
import bd.gov.dgfood.common.services.model.Address;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the address service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressUtil
 * @generated
 */
@ProviderType
public interface AddressPersistence extends BasePersistence<Address> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AddressUtil} to access the address persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the addresses where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @return the matching addresses
	 */
	public java.util.List<Address> findByCPK_CN(long classPK, String className);

	/**
	 * Returns a range of all the addresses where classPK = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @return the range of matching addresses
	 */
	public java.util.List<Address> findByCPK_CN(
		long classPK, String className, int start, int end);

	/**
	 * Returns an ordered range of all the addresses where classPK = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching addresses
	 */
	public java.util.List<Address> findByCPK_CN(
		long classPK, String className, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator);

	/**
	 * Returns an ordered range of all the addresses where classPK = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching addresses
	 */
	public java.util.List<Address> findByCPK_CN(
		long classPK, String className, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first address in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	public Address findByCPK_CN_First(
			long classPK, String className,
			com.liferay.portal.kernel.util.OrderByComparator<Address>
				orderByComparator)
		throws NoSuchAddressException;

	/**
	 * Returns the first address in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address, or <code>null</code> if a matching address could not be found
	 */
	public Address fetchByCPK_CN_First(
		long classPK, String className,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator);

	/**
	 * Returns the last address in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	public Address findByCPK_CN_Last(
			long classPK, String className,
			com.liferay.portal.kernel.util.OrderByComparator<Address>
				orderByComparator)
		throws NoSuchAddressException;

	/**
	 * Returns the last address in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address, or <code>null</code> if a matching address could not be found
	 */
	public Address fetchByCPK_CN_Last(
		long classPK, String className,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator);

	/**
	 * Returns the addresses before and after the current address in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param addressId the primary key of the current address
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next address
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	public Address[] findByCPK_CN_PrevAndNext(
			long addressId, long classPK, String className,
			com.liferay.portal.kernel.util.OrderByComparator<Address>
				orderByComparator)
		throws NoSuchAddressException;

	/**
	 * Removes all the addresses where classPK = &#63; and className = &#63; from the database.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 */
	public void removeByCPK_CN(long classPK, String className);

	/**
	 * Returns the number of addresses where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @return the number of matching addresses
	 */
	public int countByCPK_CN(long classPK, String className);

	/**
	 * Returns the address where classPK = &#63; and className = &#63; and addressType = &#63; or throws a <code>NoSuchAddressException</code> if it could not be found.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param addressType the address type
	 * @return the matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	public Address findByCPK_CN_AT(
			long classPK, String className, String addressType)
		throws NoSuchAddressException;

	/**
	 * Returns the address where classPK = &#63; and className = &#63; and addressType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param addressType the address type
	 * @return the matching address, or <code>null</code> if a matching address could not be found
	 */
	public Address fetchByCPK_CN_AT(
		long classPK, String className, String addressType);

	/**
	 * Returns the address where classPK = &#63; and className = &#63; and addressType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param addressType the address type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching address, or <code>null</code> if a matching address could not be found
	 */
	public Address fetchByCPK_CN_AT(
		long classPK, String className, String addressType,
		boolean useFinderCache);

	/**
	 * Removes the address where classPK = &#63; and className = &#63; and addressType = &#63; from the database.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param addressType the address type
	 * @return the address that was removed
	 */
	public Address removeByCPK_CN_AT(
			long classPK, String className, String addressType)
		throws NoSuchAddressException;

	/**
	 * Returns the number of addresses where classPK = &#63; and className = &#63; and addressType = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param addressType the address type
	 * @return the number of matching addresses
	 */
	public int countByCPK_CN_AT(
		long classPK, String className, String addressType);

	/**
	 * Caches the address in the entity cache if it is enabled.
	 *
	 * @param address the address
	 */
	public void cacheResult(Address address);

	/**
	 * Caches the addresses in the entity cache if it is enabled.
	 *
	 * @param addresses the addresses
	 */
	public void cacheResult(java.util.List<Address> addresses);

	/**
	 * Creates a new address with the primary key. Does not add the address to the database.
	 *
	 * @param addressId the primary key for the new address
	 * @return the new address
	 */
	public Address create(long addressId);

	/**
	 * Removes the address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addressId the primary key of the address
	 * @return the address that was removed
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	public Address remove(long addressId) throws NoSuchAddressException;

	public Address updateImpl(Address address);

	/**
	 * Returns the address with the primary key or throws a <code>NoSuchAddressException</code> if it could not be found.
	 *
	 * @param addressId the primary key of the address
	 * @return the address
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	public Address findByPrimaryKey(long addressId)
		throws NoSuchAddressException;

	/**
	 * Returns the address with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addressId the primary key of the address
	 * @return the address, or <code>null</code> if a address with the primary key could not be found
	 */
	public Address fetchByPrimaryKey(long addressId);

	/**
	 * Returns all the addresses.
	 *
	 * @return the addresses
	 */
	public java.util.List<Address> findAll();

	/**
	 * Returns a range of all the addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @return the range of addresses
	 */
	public java.util.List<Address> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of addresses
	 */
	public java.util.List<Address> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator);

	/**
	 * Returns an ordered range of all the addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of addresses
	 */
	public java.util.List<Address> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the addresses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of addresses.
	 *
	 * @return the number of addresses
	 */
	public int countAll();

}