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

import bd.gov.dgfood.movement.contractor.exception.NoSuchVInvoiceException;
import bd.gov.dgfood.movement.contractor.model.VInvoice;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the v invoice service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VInvoiceUtil
 * @generated
 */
@ProviderType
public interface VInvoicePersistence extends BasePersistence<VInvoice> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VInvoiceUtil} to access the v invoice persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the v invoice in the entity cache if it is enabled.
	 *
	 * @param vInvoice the v invoice
	 */
	public void cacheResult(VInvoice vInvoice);

	/**
	 * Caches the v invoices in the entity cache if it is enabled.
	 *
	 * @param vInvoices the v invoices
	 */
	public void cacheResult(java.util.List<VInvoice> vInvoices);

	/**
	 * Creates a new v invoice with the primary key. Does not add the v invoice to the database.
	 *
	 * @param vInvoiceId the primary key for the new v invoice
	 * @return the new v invoice
	 */
	public VInvoice create(long vInvoiceId);

	/**
	 * Removes the v invoice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vInvoiceId the primary key of the v invoice
	 * @return the v invoice that was removed
	 * @throws NoSuchVInvoiceException if a v invoice with the primary key could not be found
	 */
	public VInvoice remove(long vInvoiceId) throws NoSuchVInvoiceException;

	public VInvoice updateImpl(VInvoice vInvoice);

	/**
	 * Returns the v invoice with the primary key or throws a <code>NoSuchVInvoiceException</code> if it could not be found.
	 *
	 * @param vInvoiceId the primary key of the v invoice
	 * @return the v invoice
	 * @throws NoSuchVInvoiceException if a v invoice with the primary key could not be found
	 */
	public VInvoice findByPrimaryKey(long vInvoiceId)
		throws NoSuchVInvoiceException;

	/**
	 * Returns the v invoice with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param vInvoiceId the primary key of the v invoice
	 * @return the v invoice, or <code>null</code> if a v invoice with the primary key could not be found
	 */
	public VInvoice fetchByPrimaryKey(long vInvoiceId);

	/**
	 * Returns all the v invoices.
	 *
	 * @return the v invoices
	 */
	public java.util.List<VInvoice> findAll();

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
	public java.util.List<VInvoice> findAll(int start, int end);

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
	public java.util.List<VInvoice> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VInvoice>
			orderByComparator);

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
	public java.util.List<VInvoice> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VInvoice>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the v invoices from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of v invoices.
	 *
	 * @return the number of v invoices
	 */
	public int countAll();

}