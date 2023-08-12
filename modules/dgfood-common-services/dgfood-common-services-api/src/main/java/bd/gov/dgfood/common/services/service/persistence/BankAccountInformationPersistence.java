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

import bd.gov.dgfood.common.services.exception.NoSuchBankAccountInformationException;
import bd.gov.dgfood.common.services.model.BankAccountInformation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the bank account information service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BankAccountInformationUtil
 * @generated
 */
@ProviderType
public interface BankAccountInformationPersistence
	extends BasePersistence<BankAccountInformation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BankAccountInformationUtil} to access the bank account information persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the bank account informations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching bank account informations
	 */
	public java.util.List<BankAccountInformation> findByUuid(String uuid);

	/**
	 * Returns a range of all the bank account informations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankAccountInformationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bank account informations
	 * @param end the upper bound of the range of bank account informations (not inclusive)
	 * @return the range of matching bank account informations
	 */
	public java.util.List<BankAccountInformation> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the bank account informations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankAccountInformationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bank account informations
	 * @param end the upper bound of the range of bank account informations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bank account informations
	 */
	public java.util.List<BankAccountInformation> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BankAccountInformation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the bank account informations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankAccountInformationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bank account informations
	 * @param end the upper bound of the range of bank account informations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bank account informations
	 */
	public java.util.List<BankAccountInformation> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BankAccountInformation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first bank account information in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank account information
	 * @throws NoSuchBankAccountInformationException if a matching bank account information could not be found
	 */
	public BankAccountInformation findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<BankAccountInformation> orderByComparator)
		throws NoSuchBankAccountInformationException;

	/**
	 * Returns the first bank account information in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank account information, or <code>null</code> if a matching bank account information could not be found
	 */
	public BankAccountInformation fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<BankAccountInformation>
			orderByComparator);

	/**
	 * Returns the last bank account information in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank account information
	 * @throws NoSuchBankAccountInformationException if a matching bank account information could not be found
	 */
	public BankAccountInformation findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<BankAccountInformation> orderByComparator)
		throws NoSuchBankAccountInformationException;

	/**
	 * Returns the last bank account information in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank account information, or <code>null</code> if a matching bank account information could not be found
	 */
	public BankAccountInformation fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<BankAccountInformation>
			orderByComparator);

	/**
	 * Returns the bank account informations before and after the current bank account information in the ordered set where uuid = &#63;.
	 *
	 * @param bankAccountInformationId the primary key of the current bank account information
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bank account information
	 * @throws NoSuchBankAccountInformationException if a bank account information with the primary key could not be found
	 */
	public BankAccountInformation[] findByUuid_PrevAndNext(
			long bankAccountInformationId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<BankAccountInformation> orderByComparator)
		throws NoSuchBankAccountInformationException;

	/**
	 * Removes all the bank account informations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of bank account informations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching bank account informations
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the bank account information in the entity cache if it is enabled.
	 *
	 * @param bankAccountInformation the bank account information
	 */
	public void cacheResult(BankAccountInformation bankAccountInformation);

	/**
	 * Caches the bank account informations in the entity cache if it is enabled.
	 *
	 * @param bankAccountInformations the bank account informations
	 */
	public void cacheResult(
		java.util.List<BankAccountInformation> bankAccountInformations);

	/**
	 * Creates a new bank account information with the primary key. Does not add the bank account information to the database.
	 *
	 * @param bankAccountInformationId the primary key for the new bank account information
	 * @return the new bank account information
	 */
	public BankAccountInformation create(long bankAccountInformationId);

	/**
	 * Removes the bank account information with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bankAccountInformationId the primary key of the bank account information
	 * @return the bank account information that was removed
	 * @throws NoSuchBankAccountInformationException if a bank account information with the primary key could not be found
	 */
	public BankAccountInformation remove(long bankAccountInformationId)
		throws NoSuchBankAccountInformationException;

	public BankAccountInformation updateImpl(
		BankAccountInformation bankAccountInformation);

	/**
	 * Returns the bank account information with the primary key or throws a <code>NoSuchBankAccountInformationException</code> if it could not be found.
	 *
	 * @param bankAccountInformationId the primary key of the bank account information
	 * @return the bank account information
	 * @throws NoSuchBankAccountInformationException if a bank account information with the primary key could not be found
	 */
	public BankAccountInformation findByPrimaryKey(
			long bankAccountInformationId)
		throws NoSuchBankAccountInformationException;

	/**
	 * Returns the bank account information with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bankAccountInformationId the primary key of the bank account information
	 * @return the bank account information, or <code>null</code> if a bank account information with the primary key could not be found
	 */
	public BankAccountInformation fetchByPrimaryKey(
		long bankAccountInformationId);

	/**
	 * Returns all the bank account informations.
	 *
	 * @return the bank account informations
	 */
	public java.util.List<BankAccountInformation> findAll();

	/**
	 * Returns a range of all the bank account informations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankAccountInformationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bank account informations
	 * @param end the upper bound of the range of bank account informations (not inclusive)
	 * @return the range of bank account informations
	 */
	public java.util.List<BankAccountInformation> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the bank account informations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankAccountInformationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bank account informations
	 * @param end the upper bound of the range of bank account informations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bank account informations
	 */
	public java.util.List<BankAccountInformation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BankAccountInformation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the bank account informations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankAccountInformationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bank account informations
	 * @param end the upper bound of the range of bank account informations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of bank account informations
	 */
	public java.util.List<BankAccountInformation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BankAccountInformation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the bank account informations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of bank account informations.
	 *
	 * @return the number of bank account informations
	 */
	public int countAll();

}