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

import bd.gov.dgfood.common.services.model.BankAccountInformation;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the bank account information service. This utility wraps <code>bd.gov.dgfood.common.services.service.persistence.impl.BankAccountInformationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BankAccountInformationPersistence
 * @generated
 */
public class BankAccountInformationUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(
		BankAccountInformation bankAccountInformation) {

		getPersistence().clearCache(bankAccountInformation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, BankAccountInformation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BankAccountInformation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BankAccountInformation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BankAccountInformation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BankAccountInformation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BankAccountInformation update(
		BankAccountInformation bankAccountInformation) {

		return getPersistence().update(bankAccountInformation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BankAccountInformation update(
		BankAccountInformation bankAccountInformation,
		ServiceContext serviceContext) {

		return getPersistence().update(bankAccountInformation, serviceContext);
	}

	/**
	 * Returns all the bank account informations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching bank account informations
	 */
	public static List<BankAccountInformation> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<BankAccountInformation> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<BankAccountInformation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BankAccountInformation> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<BankAccountInformation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BankAccountInformation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first bank account information in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank account information
	 * @throws NoSuchBankAccountInformationException if a matching bank account information could not be found
	 */
	public static BankAccountInformation findByUuid_First(
			String uuid,
			OrderByComparator<BankAccountInformation> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchBankAccountInformationException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first bank account information in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank account information, or <code>null</code> if a matching bank account information could not be found
	 */
	public static BankAccountInformation fetchByUuid_First(
		String uuid,
		OrderByComparator<BankAccountInformation> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last bank account information in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank account information
	 * @throws NoSuchBankAccountInformationException if a matching bank account information could not be found
	 */
	public static BankAccountInformation findByUuid_Last(
			String uuid,
			OrderByComparator<BankAccountInformation> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchBankAccountInformationException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last bank account information in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank account information, or <code>null</code> if a matching bank account information could not be found
	 */
	public static BankAccountInformation fetchByUuid_Last(
		String uuid,
		OrderByComparator<BankAccountInformation> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the bank account informations before and after the current bank account information in the ordered set where uuid = &#63;.
	 *
	 * @param bankAccountInformationId the primary key of the current bank account information
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bank account information
	 * @throws NoSuchBankAccountInformationException if a bank account information with the primary key could not be found
	 */
	public static BankAccountInformation[] findByUuid_PrevAndNext(
			long bankAccountInformationId, String uuid,
			OrderByComparator<BankAccountInformation> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchBankAccountInformationException {

		return getPersistence().findByUuid_PrevAndNext(
			bankAccountInformationId, uuid, orderByComparator);
	}

	/**
	 * Removes all the bank account informations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of bank account informations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching bank account informations
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the bank account information in the entity cache if it is enabled.
	 *
	 * @param bankAccountInformation the bank account information
	 */
	public static void cacheResult(
		BankAccountInformation bankAccountInformation) {

		getPersistence().cacheResult(bankAccountInformation);
	}

	/**
	 * Caches the bank account informations in the entity cache if it is enabled.
	 *
	 * @param bankAccountInformations the bank account informations
	 */
	public static void cacheResult(
		List<BankAccountInformation> bankAccountInformations) {

		getPersistence().cacheResult(bankAccountInformations);
	}

	/**
	 * Creates a new bank account information with the primary key. Does not add the bank account information to the database.
	 *
	 * @param bankAccountInformationId the primary key for the new bank account information
	 * @return the new bank account information
	 */
	public static BankAccountInformation create(long bankAccountInformationId) {
		return getPersistence().create(bankAccountInformationId);
	}

	/**
	 * Removes the bank account information with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bankAccountInformationId the primary key of the bank account information
	 * @return the bank account information that was removed
	 * @throws NoSuchBankAccountInformationException if a bank account information with the primary key could not be found
	 */
	public static BankAccountInformation remove(long bankAccountInformationId)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchBankAccountInformationException {

		return getPersistence().remove(bankAccountInformationId);
	}

	public static BankAccountInformation updateImpl(
		BankAccountInformation bankAccountInformation) {

		return getPersistence().updateImpl(bankAccountInformation);
	}

	/**
	 * Returns the bank account information with the primary key or throws a <code>NoSuchBankAccountInformationException</code> if it could not be found.
	 *
	 * @param bankAccountInformationId the primary key of the bank account information
	 * @return the bank account information
	 * @throws NoSuchBankAccountInformationException if a bank account information with the primary key could not be found
	 */
	public static BankAccountInformation findByPrimaryKey(
			long bankAccountInformationId)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchBankAccountInformationException {

		return getPersistence().findByPrimaryKey(bankAccountInformationId);
	}

	/**
	 * Returns the bank account information with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bankAccountInformationId the primary key of the bank account information
	 * @return the bank account information, or <code>null</code> if a bank account information with the primary key could not be found
	 */
	public static BankAccountInformation fetchByPrimaryKey(
		long bankAccountInformationId) {

		return getPersistence().fetchByPrimaryKey(bankAccountInformationId);
	}

	/**
	 * Returns all the bank account informations.
	 *
	 * @return the bank account informations
	 */
	public static List<BankAccountInformation> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<BankAccountInformation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<BankAccountInformation> findAll(
		int start, int end,
		OrderByComparator<BankAccountInformation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<BankAccountInformation> findAll(
		int start, int end,
		OrderByComparator<BankAccountInformation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the bank account informations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of bank account informations.
	 *
	 * @return the number of bank account informations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BankAccountInformationPersistence getPersistence() {
		return _persistence;
	}

	private static volatile BankAccountInformationPersistence _persistence;

}