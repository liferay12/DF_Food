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
 * Provides a wrapper for {@link MDMSyncStatusLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MDMSyncStatusLocalService
 * @generated
 */
public class MDMSyncStatusLocalServiceWrapper
	implements MDMSyncStatusLocalService,
			   ServiceWrapper<MDMSyncStatusLocalService> {

	public MDMSyncStatusLocalServiceWrapper() {
		this(null);
	}

	public MDMSyncStatusLocalServiceWrapper(
		MDMSyncStatusLocalService mdmSyncStatusLocalService) {

		_mdmSyncStatusLocalService = mdmSyncStatusLocalService;
	}

	/**
	 * Adds the mdm sync status to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MDMSyncStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mdmSyncStatus the mdm sync status
	 * @return the mdm sync status that was added
	 */
	@Override
	public bd.gov.dgfood.common.services.model.MDMSyncStatus addMDMSyncStatus(
		bd.gov.dgfood.common.services.model.MDMSyncStatus mdmSyncStatus) {

		return _mdmSyncStatusLocalService.addMDMSyncStatus(mdmSyncStatus);
	}

	/**
	 * Creates a new mdm sync status with the primary key. Does not add the mdm sync status to the database.
	 *
	 * @param mdmSyncStatusId the primary key for the new mdm sync status
	 * @return the new mdm sync status
	 */
	@Override
	public bd.gov.dgfood.common.services.model.MDMSyncStatus
		createMDMSyncStatus(long mdmSyncStatusId) {

		return _mdmSyncStatusLocalService.createMDMSyncStatus(mdmSyncStatusId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mdmSyncStatusLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the mdm sync status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MDMSyncStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mdmSyncStatusId the primary key of the mdm sync status
	 * @return the mdm sync status that was removed
	 * @throws PortalException if a mdm sync status with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.common.services.model.MDMSyncStatus
			deleteMDMSyncStatus(long mdmSyncStatusId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mdmSyncStatusLocalService.deleteMDMSyncStatus(mdmSyncStatusId);
	}

	/**
	 * Deletes the mdm sync status from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MDMSyncStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mdmSyncStatus the mdm sync status
	 * @return the mdm sync status that was removed
	 */
	@Override
	public bd.gov.dgfood.common.services.model.MDMSyncStatus
		deleteMDMSyncStatus(
			bd.gov.dgfood.common.services.model.MDMSyncStatus mdmSyncStatus) {

		return _mdmSyncStatusLocalService.deleteMDMSyncStatus(mdmSyncStatus);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mdmSyncStatusLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _mdmSyncStatusLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _mdmSyncStatusLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _mdmSyncStatusLocalService.dynamicQuery();
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

		return _mdmSyncStatusLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.MDMSyncStatusModelImpl</code>.
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

		return _mdmSyncStatusLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.MDMSyncStatusModelImpl</code>.
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

		return _mdmSyncStatusLocalService.dynamicQuery(
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

		return _mdmSyncStatusLocalService.dynamicQueryCount(dynamicQuery);
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

		return _mdmSyncStatusLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.common.services.model.MDMSyncStatus fetchMDMSyncStatus(
		long mdmSyncStatusId) {

		return _mdmSyncStatusLocalService.fetchMDMSyncStatus(mdmSyncStatusId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _mdmSyncStatusLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _mdmSyncStatusLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the mdm sync status with the primary key.
	 *
	 * @param mdmSyncStatusId the primary key of the mdm sync status
	 * @return the mdm sync status
	 * @throws PortalException if a mdm sync status with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.common.services.model.MDMSyncStatus getMDMSyncStatus(
			long mdmSyncStatusId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mdmSyncStatusLocalService.getMDMSyncStatus(mdmSyncStatusId);
	}

	/**
	 * Returns a range of all the mdm sync statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.MDMSyncStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mdm sync statuses
	 * @param end the upper bound of the range of mdm sync statuses (not inclusive)
	 * @return the range of mdm sync statuses
	 */
	@Override
	public java.util.List<bd.gov.dgfood.common.services.model.MDMSyncStatus>
		getMDMSyncStatuses(int start, int end) {

		return _mdmSyncStatusLocalService.getMDMSyncStatuses(start, end);
	}

	/**
	 * Returns the number of mdm sync statuses.
	 *
	 * @return the number of mdm sync statuses
	 */
	@Override
	public int getMDMSyncStatusesCount() {
		return _mdmSyncStatusLocalService.getMDMSyncStatusesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _mdmSyncStatusLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mdmSyncStatusLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the mdm sync status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MDMSyncStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mdmSyncStatus the mdm sync status
	 * @return the mdm sync status that was updated
	 */
	@Override
	public bd.gov.dgfood.common.services.model.MDMSyncStatus
		updateMDMSyncStatus(
			bd.gov.dgfood.common.services.model.MDMSyncStatus mdmSyncStatus) {

		return _mdmSyncStatusLocalService.updateMDMSyncStatus(mdmSyncStatus);
	}

	@Override
	public MDMSyncStatusLocalService getWrappedService() {
		return _mdmSyncStatusLocalService;
	}

	@Override
	public void setWrappedService(
		MDMSyncStatusLocalService mdmSyncStatusLocalService) {

		_mdmSyncStatusLocalService = mdmSyncStatusLocalService;
	}

	private MDMSyncStatusLocalService _mdmSyncStatusLocalService;

}