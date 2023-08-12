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

package bd.gov.dgfood.common.services.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DeliveryOrderLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DeliveryOrderLocalService
 * @generated
 */
public class DeliveryOrderLocalServiceWrapper
	implements DeliveryOrderLocalService,
			   ServiceWrapper<DeliveryOrderLocalService> {

	public DeliveryOrderLocalServiceWrapper() {
		this(null);
	}

	public DeliveryOrderLocalServiceWrapper(
		DeliveryOrderLocalService deliveryOrderLocalService) {

		_deliveryOrderLocalService = deliveryOrderLocalService;
	}

	/**
	 * Adds the delivery order to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DeliveryOrderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param deliveryOrder the delivery order
	 * @return the delivery order that was added
	 */
	@Override
	public bd.gov.dgfood.common.services.model.DeliveryOrder addDeliveryOrder(
		bd.gov.dgfood.common.services.model.DeliveryOrder deliveryOrder) {

		return _deliveryOrderLocalService.addDeliveryOrder(deliveryOrder);
	}

	/**
	 * Creates a new delivery order with the primary key. Does not add the delivery order to the database.
	 *
	 * @param deliveryOrderPK the primary key for the new delivery order
	 * @return the new delivery order
	 */
	@Override
	public bd.gov.dgfood.common.services.model.DeliveryOrder
		createDeliveryOrder(
			bd.gov.dgfood.common.services.service.persistence.DeliveryOrderPK
				deliveryOrderPK) {

		return _deliveryOrderLocalService.createDeliveryOrder(deliveryOrderPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deliveryOrderLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the delivery order from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DeliveryOrderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param deliveryOrder the delivery order
	 * @return the delivery order that was removed
	 */
	@Override
	public bd.gov.dgfood.common.services.model.DeliveryOrder
		deleteDeliveryOrder(
			bd.gov.dgfood.common.services.model.DeliveryOrder deliveryOrder) {

		return _deliveryOrderLocalService.deleteDeliveryOrder(deliveryOrder);
	}

	/**
	 * Deletes the delivery order with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DeliveryOrderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param deliveryOrderPK the primary key of the delivery order
	 * @return the delivery order that was removed
	 * @throws PortalException if a delivery order with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.common.services.model.DeliveryOrder
			deleteDeliveryOrder(
				bd.gov.dgfood.common.services.service.persistence.
					DeliveryOrderPK deliveryOrderPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deliveryOrderLocalService.deleteDeliveryOrder(deliveryOrderPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deliveryOrderLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _deliveryOrderLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _deliveryOrderLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _deliveryOrderLocalService.dynamicQuery();
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

		return _deliveryOrderLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.DeliveryOrderModelImpl</code>.
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

		return _deliveryOrderLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.DeliveryOrderModelImpl</code>.
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

		return _deliveryOrderLocalService.dynamicQuery(
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

		return _deliveryOrderLocalService.dynamicQueryCount(dynamicQuery);
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

		return _deliveryOrderLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.common.services.model.DeliveryOrder fetchDeliveryOrder(
		bd.gov.dgfood.common.services.service.persistence.DeliveryOrderPK
			deliveryOrderPK) {

		return _deliveryOrderLocalService.fetchDeliveryOrder(deliveryOrderPK);
	}

	/**
	 * Returns the delivery order with the matching UUID and company.
	 *
	 * @param uuid the delivery order's UUID
	 * @param companyId the primary key of the company
	 * @return the matching delivery order, or <code>null</code> if a matching delivery order could not be found
	 */
	@Override
	public bd.gov.dgfood.common.services.model.DeliveryOrder
		fetchDeliveryOrderByUuidAndCompanyId(String uuid, long companyId) {

		return _deliveryOrderLocalService.fetchDeliveryOrderByUuidAndCompanyId(
			uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _deliveryOrderLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the delivery order with the primary key.
	 *
	 * @param deliveryOrderPK the primary key of the delivery order
	 * @return the delivery order
	 * @throws PortalException if a delivery order with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.common.services.model.DeliveryOrder getDeliveryOrder(
			bd.gov.dgfood.common.services.service.persistence.DeliveryOrderPK
				deliveryOrderPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deliveryOrderLocalService.getDeliveryOrder(deliveryOrderPK);
	}

	/**
	 * Returns the delivery order with the matching UUID and company.
	 *
	 * @param uuid the delivery order's UUID
	 * @param companyId the primary key of the company
	 * @return the matching delivery order
	 * @throws PortalException if a matching delivery order could not be found
	 */
	@Override
	public bd.gov.dgfood.common.services.model.DeliveryOrder
			getDeliveryOrderByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deliveryOrderLocalService.getDeliveryOrderByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of all the delivery orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.DeliveryOrderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of delivery orders
	 * @param end the upper bound of the range of delivery orders (not inclusive)
	 * @return the range of delivery orders
	 */
	@Override
	public java.util.List<bd.gov.dgfood.common.services.model.DeliveryOrder>
		getDeliveryOrders(int start, int end) {

		return _deliveryOrderLocalService.getDeliveryOrders(start, end);
	}

	/**
	 * Returns the number of delivery orders.
	 *
	 * @return the number of delivery orders
	 */
	@Override
	public int getDeliveryOrdersCount() {
		return _deliveryOrderLocalService.getDeliveryOrdersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _deliveryOrderLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _deliveryOrderLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _deliveryOrderLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deliveryOrderLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the delivery order in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DeliveryOrderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param deliveryOrder the delivery order
	 * @return the delivery order that was updated
	 */
	@Override
	public bd.gov.dgfood.common.services.model.DeliveryOrder
		updateDeliveryOrder(
			bd.gov.dgfood.common.services.model.DeliveryOrder deliveryOrder) {

		return _deliveryOrderLocalService.updateDeliveryOrder(deliveryOrder);
	}

	@Override
	public DeliveryOrderLocalService getWrappedService() {
		return _deliveryOrderLocalService;
	}

	@Override
	public void setWrappedService(
		DeliveryOrderLocalService deliveryOrderLocalService) {

		_deliveryOrderLocalService = deliveryOrderLocalService;
	}

	private DeliveryOrderLocalService _deliveryOrderLocalService;

}