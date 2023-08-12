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
 * Provides a wrapper for {@link DGFUsersLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DGFUsersLocalService
 * @generated
 */
public class DGFUsersLocalServiceWrapper
	implements DGFUsersLocalService, ServiceWrapper<DGFUsersLocalService> {

	public DGFUsersLocalServiceWrapper() {
		this(null);
	}

	public DGFUsersLocalServiceWrapper(
		DGFUsersLocalService dgfUsersLocalService) {

		_dgfUsersLocalService = dgfUsersLocalService;
	}

	/**
	 * Adds the dgf users to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFUsersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsers the dgf users
	 * @return the dgf users that was added
	 */
	@Override
	public bd.gov.dgfood.common.services.model.DGFUsers addDGFUsers(
		bd.gov.dgfood.common.services.model.DGFUsers dgfUsers) {

		return _dgfUsersLocalService.addDGFUsers(dgfUsers);
	}

	/**
	 * Creates a new dgf users with the primary key. Does not add the dgf users to the database.
	 *
	 * @param dgfUserId the primary key for the new dgf users
	 * @return the new dgf users
	 */
	@Override
	public bd.gov.dgfood.common.services.model.DGFUsers createDGFUsers(
		long dgfUserId) {

		return _dgfUsersLocalService.createDGFUsers(dgfUserId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the dgf users from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFUsersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsers the dgf users
	 * @return the dgf users that was removed
	 */
	@Override
	public bd.gov.dgfood.common.services.model.DGFUsers deleteDGFUsers(
		bd.gov.dgfood.common.services.model.DGFUsers dgfUsers) {

		return _dgfUsersLocalService.deleteDGFUsers(dgfUsers);
	}

	/**
	 * Deletes the dgf users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFUsersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUserId the primary key of the dgf users
	 * @return the dgf users that was removed
	 * @throws PortalException if a dgf users with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.common.services.model.DGFUsers deleteDGFUsers(
			long dgfUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersLocalService.deleteDGFUsers(dgfUserId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgfUsersLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgfUsersLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgfUsersLocalService.dynamicQuery();
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

		return _dgfUsersLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.DGFUsersModelImpl</code>.
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

		return _dgfUsersLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.DGFUsersModelImpl</code>.
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

		return _dgfUsersLocalService.dynamicQuery(
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

		return _dgfUsersLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dgfUsersLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.common.services.model.DGFUsers fetchDGFUsers(
		long dgfUserId) {

		return _dgfUsersLocalService.fetchDGFUsers(dgfUserId);
	}

	@Override
	public bd.gov.dgfood.common.services.model.DGFUsers findByNationalId(
		String nationalId) {

		return _dgfUsersLocalService.findByNationalId(nationalId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgfUsersLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the dgf users with the primary key.
	 *
	 * @param dgfUserId the primary key of the dgf users
	 * @return the dgf users
	 * @throws PortalException if a dgf users with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.common.services.model.DGFUsers getDGFUsers(
			long dgfUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersLocalService.getDGFUsers(dgfUserId);
	}

	/**
	 * Returns a range of all the dgf userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.DGFUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @return the range of dgf userses
	 */
	@Override
	public java.util.List<bd.gov.dgfood.common.services.model.DGFUsers>
		getDGFUserses(int start, int end) {

		return _dgfUsersLocalService.getDGFUserses(start, end);
	}

	/**
	 * Returns the number of dgf userses.
	 *
	 * @return the number of dgf userses
	 */
	@Override
	public int getDGFUsersesCount() {
		return _dgfUsersLocalService.getDGFUsersesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgfUsersLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfUsersLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the dgf users in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFUsersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsers the dgf users
	 * @return the dgf users that was updated
	 */
	@Override
	public bd.gov.dgfood.common.services.model.DGFUsers updateDGFUsers(
		bd.gov.dgfood.common.services.model.DGFUsers dgfUsers) {

		return _dgfUsersLocalService.updateDGFUsers(dgfUsers);
	}

	@Override
	public DGFUsersLocalService getWrappedService() {
		return _dgfUsersLocalService;
	}

	@Override
	public void setWrappedService(DGFUsersLocalService dgfUsersLocalService) {
		_dgfUsersLocalService = dgfUsersLocalService;
	}

	private DGFUsersLocalService _dgfUsersLocalService;

}