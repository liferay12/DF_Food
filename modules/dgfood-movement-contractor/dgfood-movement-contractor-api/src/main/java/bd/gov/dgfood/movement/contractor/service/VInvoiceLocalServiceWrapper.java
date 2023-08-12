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

package bd.gov.dgfood.movement.contractor.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VInvoiceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see VInvoiceLocalService
 * @generated
 */
public class VInvoiceLocalServiceWrapper
	implements ServiceWrapper<VInvoiceLocalService>, VInvoiceLocalService {

	public VInvoiceLocalServiceWrapper() {
		this(null);
	}

	public VInvoiceLocalServiceWrapper(
		VInvoiceLocalService vInvoiceLocalService) {

		_vInvoiceLocalService = vInvoiceLocalService;
	}

	/**
	 * Adds the v invoice to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VInvoiceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param vInvoice the v invoice
	 * @return the v invoice that was added
	 */
	@Override
	public bd.gov.dgfood.movement.contractor.model.VInvoice addVInvoice(
		bd.gov.dgfood.movement.contractor.model.VInvoice vInvoice) {

		return _vInvoiceLocalService.addVInvoice(vInvoice);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vInvoiceLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new v invoice with the primary key. Does not add the v invoice to the database.
	 *
	 * @param vInvoiceId the primary key for the new v invoice
	 * @return the new v invoice
	 */
	@Override
	public bd.gov.dgfood.movement.contractor.model.VInvoice createVInvoice(
		long vInvoiceId) {

		return _vInvoiceLocalService.createVInvoice(vInvoiceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vInvoiceLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the v invoice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VInvoiceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param vInvoiceId the primary key of the v invoice
	 * @return the v invoice that was removed
	 * @throws PortalException if a v invoice with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.movement.contractor.model.VInvoice deleteVInvoice(
			long vInvoiceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vInvoiceLocalService.deleteVInvoice(vInvoiceId);
	}

	/**
	 * Deletes the v invoice from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VInvoiceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param vInvoice the v invoice
	 * @return the v invoice that was removed
	 */
	@Override
	public bd.gov.dgfood.movement.contractor.model.VInvoice deleteVInvoice(
		bd.gov.dgfood.movement.contractor.model.VInvoice vInvoice) {

		return _vInvoiceLocalService.deleteVInvoice(vInvoice);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _vInvoiceLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _vInvoiceLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _vInvoiceLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _vInvoiceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.movement.contractor.model.impl.VInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _vInvoiceLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.movement.contractor.model.impl.VInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _vInvoiceLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _vInvoiceLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _vInvoiceLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.movement.contractor.model.VInvoice fetchVInvoice(
		long vInvoiceId) {

		return _vInvoiceLocalService.fetchVInvoice(vInvoiceId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _vInvoiceLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _vInvoiceLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _vInvoiceLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vInvoiceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the v invoice with the primary key.
	 *
	 * @param vInvoiceId the primary key of the v invoice
	 * @return the v invoice
	 * @throws PortalException if a v invoice with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.movement.contractor.model.VInvoice getVInvoice(
			long vInvoiceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vInvoiceLocalService.getVInvoice(vInvoiceId);
	}

	/**
	 * Returns a range of all the v invoices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.movement.contractor.model.impl.VInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of v invoices
	 * @param end the upper bound of the range of v invoices (not inclusive)
	 * @return the range of v invoices
	 */
	@Override
	public java.util.List<bd.gov.dgfood.movement.contractor.model.VInvoice>
		getVInvoices(int start, int end) {

		return _vInvoiceLocalService.getVInvoices(start, end);
	}

	/**
	 * Returns the number of v invoices.
	 *
	 * @return the number of v invoices
	 */
	@Override
	public int getVInvoicesCount() {
		return _vInvoiceLocalService.getVInvoicesCount();
	}

	/**
	 * Updates the v invoice in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VInvoiceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param vInvoice the v invoice
	 * @return the v invoice that was updated
	 */
	@Override
	public bd.gov.dgfood.movement.contractor.model.VInvoice updateVInvoice(
		bd.gov.dgfood.movement.contractor.model.VInvoice vInvoice) {

		return _vInvoiceLocalService.updateVInvoice(vInvoice);
	}

	@Override
	public VInvoiceLocalService getWrappedService() {
		return _vInvoiceLocalService;
	}

	@Override
	public void setWrappedService(VInvoiceLocalService vInvoiceLocalService) {
		_vInvoiceLocalService = vInvoiceLocalService;
	}

	private VInvoiceLocalService _vInvoiceLocalService;

}