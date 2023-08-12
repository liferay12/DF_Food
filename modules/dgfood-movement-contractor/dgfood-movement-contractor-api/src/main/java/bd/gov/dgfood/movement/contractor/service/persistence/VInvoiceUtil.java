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

import bd.gov.dgfood.movement.contractor.model.VInvoice;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the v invoice service. This utility wraps <code>bd.gov.dgfood.movement.contractor.service.persistence.impl.VInvoicePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VInvoicePersistence
 * @generated
 */
public class VInvoiceUtil {

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
	public static void clearCache(VInvoice vInvoice) {
		getPersistence().clearCache(vInvoice);
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
	public static Map<Serializable, VInvoice> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<VInvoice> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VInvoice> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VInvoice> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<VInvoice> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static VInvoice update(VInvoice vInvoice) {
		return getPersistence().update(vInvoice);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static VInvoice update(
		VInvoice vInvoice, ServiceContext serviceContext) {

		return getPersistence().update(vInvoice, serviceContext);
	}

	/**
	 * Caches the v invoice in the entity cache if it is enabled.
	 *
	 * @param vInvoice the v invoice
	 */
	public static void cacheResult(VInvoice vInvoice) {
		getPersistence().cacheResult(vInvoice);
	}

	/**
	 * Caches the v invoices in the entity cache if it is enabled.
	 *
	 * @param vInvoices the v invoices
	 */
	public static void cacheResult(List<VInvoice> vInvoices) {
		getPersistence().cacheResult(vInvoices);
	}

	/**
	 * Creates a new v invoice with the primary key. Does not add the v invoice to the database.
	 *
	 * @param vInvoiceId the primary key for the new v invoice
	 * @return the new v invoice
	 */
	public static VInvoice create(long vInvoiceId) {
		return getPersistence().create(vInvoiceId);
	}

	/**
	 * Removes the v invoice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vInvoiceId the primary key of the v invoice
	 * @return the v invoice that was removed
	 * @throws NoSuchVInvoiceException if a v invoice with the primary key could not be found
	 */
	public static VInvoice remove(long vInvoiceId)
		throws bd.gov.dgfood.movement.contractor.exception.
			NoSuchVInvoiceException {

		return getPersistence().remove(vInvoiceId);
	}

	public static VInvoice updateImpl(VInvoice vInvoice) {
		return getPersistence().updateImpl(vInvoice);
	}

	/**
	 * Returns the v invoice with the primary key or throws a <code>NoSuchVInvoiceException</code> if it could not be found.
	 *
	 * @param vInvoiceId the primary key of the v invoice
	 * @return the v invoice
	 * @throws NoSuchVInvoiceException if a v invoice with the primary key could not be found
	 */
	public static VInvoice findByPrimaryKey(long vInvoiceId)
		throws bd.gov.dgfood.movement.contractor.exception.
			NoSuchVInvoiceException {

		return getPersistence().findByPrimaryKey(vInvoiceId);
	}

	/**
	 * Returns the v invoice with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param vInvoiceId the primary key of the v invoice
	 * @return the v invoice, or <code>null</code> if a v invoice with the primary key could not be found
	 */
	public static VInvoice fetchByPrimaryKey(long vInvoiceId) {
		return getPersistence().fetchByPrimaryKey(vInvoiceId);
	}

	/**
	 * Returns all the v invoices.
	 *
	 * @return the v invoices
	 */
	public static List<VInvoice> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the v invoices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of v invoices
	 * @param end the upper bound of the range of v invoices (not inclusive)
	 * @return the range of v invoices
	 */
	public static List<VInvoice> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the v invoices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of v invoices
	 * @param end the upper bound of the range of v invoices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of v invoices
	 */
	public static List<VInvoice> findAll(
		int start, int end, OrderByComparator<VInvoice> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the v invoices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of v invoices
	 * @param end the upper bound of the range of v invoices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of v invoices
	 */
	public static List<VInvoice> findAll(
		int start, int end, OrderByComparator<VInvoice> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the v invoices from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of v invoices.
	 *
	 * @return the number of v invoices
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static VInvoicePersistence getPersistence() {
		return _persistence;
	}

	private static volatile VInvoicePersistence _persistence;

}