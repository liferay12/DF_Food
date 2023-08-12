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
 * Provides a wrapper for {@link MovementContractorLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MovementContractorLocalService
 * @generated
 */
public class MovementContractorLocalServiceWrapper
	implements MovementContractorLocalService,
			   ServiceWrapper<MovementContractorLocalService> {

	public MovementContractorLocalServiceWrapper() {
		this(null);
	}

	public MovementContractorLocalServiceWrapper(
		MovementContractorLocalService movementContractorLocalService) {

		_movementContractorLocalService = movementContractorLocalService;
	}

	/**
	 * Adds the movement contractor to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MovementContractorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param movementContractor the movement contractor
	 * @return the movement contractor that was added
	 */
	@Override
	public bd.gov.dgfood.movement.contractor.model.MovementContractor
		addMovementContractor(
			bd.gov.dgfood.movement.contractor.model.MovementContractor
				movementContractor) {

		return _movementContractorLocalService.addMovementContractor(
			movementContractor);
	}

	/**
	 * Creates a new movement contractor with the primary key. Does not add the movement contractor to the database.
	 *
	 * @param movementContractorId the primary key for the new movement contractor
	 * @return the new movement contractor
	 */
	@Override
	public bd.gov.dgfood.movement.contractor.model.MovementContractor
		createMovementContractor(long movementContractorId) {

		return _movementContractorLocalService.createMovementContractor(
			movementContractorId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _movementContractorLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the movement contractor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MovementContractorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param movementContractorId the primary key of the movement contractor
	 * @return the movement contractor that was removed
	 * @throws PortalException if a movement contractor with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.movement.contractor.model.MovementContractor
			deleteMovementContractor(long movementContractorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _movementContractorLocalService.deleteMovementContractor(
			movementContractorId);
	}

	/**
	 * Deletes the movement contractor from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MovementContractorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param movementContractor the movement contractor
	 * @return the movement contractor that was removed
	 */
	@Override
	public bd.gov.dgfood.movement.contractor.model.MovementContractor
		deleteMovementContractor(
			bd.gov.dgfood.movement.contractor.model.MovementContractor
				movementContractor) {

		return _movementContractorLocalService.deleteMovementContractor(
			movementContractor);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _movementContractorLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _movementContractorLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _movementContractorLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _movementContractorLocalService.dynamicQuery();
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

		return _movementContractorLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.movement.contractor.model.impl.MovementContractorModelImpl</code>.
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

		return _movementContractorLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.movement.contractor.model.impl.MovementContractorModelImpl</code>.
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

		return _movementContractorLocalService.dynamicQuery(
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

		return _movementContractorLocalService.dynamicQueryCount(dynamicQuery);
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

		return _movementContractorLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.movement.contractor.model.MovementContractor
		fetchMovementContractor(long movementContractorId) {

		return _movementContractorLocalService.fetchMovementContractor(
			movementContractorId);
	}

	/**
	 * Returns the movement contractor matching the UUID and group.
	 *
	 * @param uuid the movement contractor's UUID
	 * @param groupId the primary key of the group
	 * @return the matching movement contractor, or <code>null</code> if a matching movement contractor could not be found
	 */
	@Override
	public bd.gov.dgfood.movement.contractor.model.MovementContractor
		fetchMovementContractorByUuidAndGroupId(String uuid, long groupId) {

		return _movementContractorLocalService.
			fetchMovementContractorByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _movementContractorLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _movementContractorLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _movementContractorLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the movement contractor with the primary key.
	 *
	 * @param movementContractorId the primary key of the movement contractor
	 * @return the movement contractor
	 * @throws PortalException if a movement contractor with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.movement.contractor.model.MovementContractor
			getMovementContractor(long movementContractorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _movementContractorLocalService.getMovementContractor(
			movementContractorId);
	}

	/**
	 * Returns the movement contractor matching the UUID and group.
	 *
	 * @param uuid the movement contractor's UUID
	 * @param groupId the primary key of the group
	 * @return the matching movement contractor
	 * @throws PortalException if a matching movement contractor could not be found
	 */
	@Override
	public bd.gov.dgfood.movement.contractor.model.MovementContractor
			getMovementContractorByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _movementContractorLocalService.
			getMovementContractorByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the movement contractors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.movement.contractor.model.impl.MovementContractorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of movement contractors
	 * @param end the upper bound of the range of movement contractors (not inclusive)
	 * @return the range of movement contractors
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.movement.contractor.model.MovementContractor>
			getMovementContractors(int start, int end) {

		return _movementContractorLocalService.getMovementContractors(
			start, end);
	}

	/**
	 * Returns all the movement contractors matching the UUID and company.
	 *
	 * @param uuid the UUID of the movement contractors
	 * @param companyId the primary key of the company
	 * @return the matching movement contractors, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.movement.contractor.model.MovementContractor>
			getMovementContractorsByUuidAndCompanyId(
				String uuid, long companyId) {

		return _movementContractorLocalService.
			getMovementContractorsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of movement contractors matching the UUID and company.
	 *
	 * @param uuid the UUID of the movement contractors
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of movement contractors
	 * @param end the upper bound of the range of movement contractors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching movement contractors, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.movement.contractor.model.MovementContractor>
			getMovementContractorsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<bd.gov.dgfood.movement.contractor.model.MovementContractor>
						orderByComparator) {

		return _movementContractorLocalService.
			getMovementContractorsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of movement contractors.
	 *
	 * @return the number of movement contractors
	 */
	@Override
	public int getMovementContractorsCount() {
		return _movementContractorLocalService.getMovementContractorsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _movementContractorLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _movementContractorLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the movement contractor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MovementContractorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param movementContractor the movement contractor
	 * @return the movement contractor that was updated
	 */
	@Override
	public bd.gov.dgfood.movement.contractor.model.MovementContractor
		updateMovementContractor(
			bd.gov.dgfood.movement.contractor.model.MovementContractor
				movementContractor) {

		return _movementContractorLocalService.updateMovementContractor(
			movementContractor);
	}

	@Override
	public MovementContractorLocalService getWrappedService() {
		return _movementContractorLocalService;
	}

	@Override
	public void setWrappedService(
		MovementContractorLocalService movementContractorLocalService) {

		_movementContractorLocalService = movementContractorLocalService;
	}

	private MovementContractorLocalService _movementContractorLocalService;

}