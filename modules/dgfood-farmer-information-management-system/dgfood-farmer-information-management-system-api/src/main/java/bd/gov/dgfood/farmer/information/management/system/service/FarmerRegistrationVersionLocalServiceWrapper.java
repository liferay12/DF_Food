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

package bd.gov.dgfood.farmer.information.management.system.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FarmerRegistrationVersionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FarmerRegistrationVersionLocalService
 * @generated
 */
public class FarmerRegistrationVersionLocalServiceWrapper
	implements FarmerRegistrationVersionLocalService,
			   ServiceWrapper<FarmerRegistrationVersionLocalService> {

	public FarmerRegistrationVersionLocalServiceWrapper() {
		this(null);
	}

	public FarmerRegistrationVersionLocalServiceWrapper(
		FarmerRegistrationVersionLocalService
			farmerRegistrationVersionLocalService) {

		_farmerRegistrationVersionLocalService =
			farmerRegistrationVersionLocalService;
	}

	/**
	 * Adds the farmer registration version to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FarmerRegistrationVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param farmerRegistrationVersion the farmer registration version
	 * @return the farmer registration version that was added
	 */
	@Override
	public bd.gov.dgfood.farmer.information.management.system.model.
		FarmerRegistrationVersion addFarmerRegistrationVersion(
			bd.gov.dgfood.farmer.information.management.system.model.
				FarmerRegistrationVersion farmerRegistrationVersion) {

		return _farmerRegistrationVersionLocalService.
			addFarmerRegistrationVersion(farmerRegistrationVersion);
	}

	/**
	 * Creates a new farmer registration version with the primary key. Does not add the farmer registration version to the database.
	 *
	 * @param farmerRegistrationVersionId the primary key for the new farmer registration version
	 * @return the new farmer registration version
	 */
	@Override
	public bd.gov.dgfood.farmer.information.management.system.model.
		FarmerRegistrationVersion createFarmerRegistrationVersion(
			long farmerRegistrationVersionId) {

		return _farmerRegistrationVersionLocalService.
			createFarmerRegistrationVersion(farmerRegistrationVersionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _farmerRegistrationVersionLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the farmer registration version from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FarmerRegistrationVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param farmerRegistrationVersion the farmer registration version
	 * @return the farmer registration version that was removed
	 */
	@Override
	public bd.gov.dgfood.farmer.information.management.system.model.
		FarmerRegistrationVersion deleteFarmerRegistrationVersion(
			bd.gov.dgfood.farmer.information.management.system.model.
				FarmerRegistrationVersion farmerRegistrationVersion) {

		return _farmerRegistrationVersionLocalService.
			deleteFarmerRegistrationVersion(farmerRegistrationVersion);
	}

	/**
	 * Deletes the farmer registration version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FarmerRegistrationVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param farmerRegistrationVersionId the primary key of the farmer registration version
	 * @return the farmer registration version that was removed
	 * @throws PortalException if a farmer registration version with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.farmer.information.management.system.model.
		FarmerRegistrationVersion deleteFarmerRegistrationVersion(
				long farmerRegistrationVersionId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _farmerRegistrationVersionLocalService.
			deleteFarmerRegistrationVersion(farmerRegistrationVersionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _farmerRegistrationVersionLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _farmerRegistrationVersionLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _farmerRegistrationVersionLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _farmerRegistrationVersionLocalService.dynamicQuery();
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

		return _farmerRegistrationVersionLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.farmer.information.management.system.model.impl.FarmerRegistrationVersionModelImpl</code>.
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

		return _farmerRegistrationVersionLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.farmer.information.management.system.model.impl.FarmerRegistrationVersionModelImpl</code>.
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

		return _farmerRegistrationVersionLocalService.dynamicQuery(
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

		return _farmerRegistrationVersionLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _farmerRegistrationVersionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.farmer.information.management.system.model.
		FarmerRegistrationVersion fetchFarmerRegistrationVersion(
			long farmerRegistrationVersionId) {

		return _farmerRegistrationVersionLocalService.
			fetchFarmerRegistrationVersion(farmerRegistrationVersionId);
	}

	/**
	 * Returns the farmer registration version matching the UUID and group.
	 *
	 * @param uuid the farmer registration version's UUID
	 * @param groupId the primary key of the group
	 * @return the matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	@Override
	public bd.gov.dgfood.farmer.information.management.system.model.
		FarmerRegistrationVersion
			fetchFarmerRegistrationVersionByUuidAndGroupId(
				String uuid, long groupId) {

		return _farmerRegistrationVersionLocalService.
			fetchFarmerRegistrationVersionByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _farmerRegistrationVersionLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _farmerRegistrationVersionLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	/**
	 * Returns the farmer registration version with the primary key.
	 *
	 * @param farmerRegistrationVersionId the primary key of the farmer registration version
	 * @return the farmer registration version
	 * @throws PortalException if a farmer registration version with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.farmer.information.management.system.model.
		FarmerRegistrationVersion getFarmerRegistrationVersion(
				long farmerRegistrationVersionId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _farmerRegistrationVersionLocalService.
			getFarmerRegistrationVersion(farmerRegistrationVersionId);
	}

	/**
	 * Returns the farmer registration version matching the UUID and group.
	 *
	 * @param uuid the farmer registration version's UUID
	 * @param groupId the primary key of the group
	 * @return the matching farmer registration version
	 * @throws PortalException if a matching farmer registration version could not be found
	 */
	@Override
	public bd.gov.dgfood.farmer.information.management.system.model.
		FarmerRegistrationVersion getFarmerRegistrationVersionByUuidAndGroupId(
				String uuid, long groupId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _farmerRegistrationVersionLocalService.
			getFarmerRegistrationVersionByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the farmer registration versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.farmer.information.management.system.model.impl.FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @return the range of farmer registration versions
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.farmer.information.management.system.model.
			FarmerRegistrationVersion> getFarmerRegistrationVersions(
				int start, int end) {

		return _farmerRegistrationVersionLocalService.
			getFarmerRegistrationVersions(start, end);
	}

	/**
	 * Returns all the farmer registration versions matching the UUID and company.
	 *
	 * @param uuid the UUID of the farmer registration versions
	 * @param companyId the primary key of the company
	 * @return the matching farmer registration versions, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.farmer.information.management.system.model.
			FarmerRegistrationVersion>
				getFarmerRegistrationVersionsByUuidAndCompanyId(
					String uuid, long companyId) {

		return _farmerRegistrationVersionLocalService.
			getFarmerRegistrationVersionsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of farmer registration versions matching the UUID and company.
	 *
	 * @param uuid the UUID of the farmer registration versions
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching farmer registration versions, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.farmer.information.management.system.model.
			FarmerRegistrationVersion>
				getFarmerRegistrationVersionsByUuidAndCompanyId(
					String uuid, long companyId, int start, int end,
					com.liferay.portal.kernel.util.OrderByComparator
						<bd.gov.dgfood.farmer.information.management.system.
							model.FarmerRegistrationVersion>
								orderByComparator) {

		return _farmerRegistrationVersionLocalService.
			getFarmerRegistrationVersionsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of farmer registration versions.
	 *
	 * @return the number of farmer registration versions
	 */
	@Override
	public int getFarmerRegistrationVersionsCount() {
		return _farmerRegistrationVersionLocalService.
			getFarmerRegistrationVersionsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _farmerRegistrationVersionLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _farmerRegistrationVersionLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _farmerRegistrationVersionLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the farmer registration version in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FarmerRegistrationVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param farmerRegistrationVersion the farmer registration version
	 * @return the farmer registration version that was updated
	 */
	@Override
	public bd.gov.dgfood.farmer.information.management.system.model.
		FarmerRegistrationVersion updateFarmerRegistrationVersion(
			bd.gov.dgfood.farmer.information.management.system.model.
				FarmerRegistrationVersion farmerRegistrationVersion) {

		return _farmerRegistrationVersionLocalService.
			updateFarmerRegistrationVersion(farmerRegistrationVersion);
	}

	@Override
	public FarmerRegistrationVersionLocalService getWrappedService() {
		return _farmerRegistrationVersionLocalService;
	}

	@Override
	public void setWrappedService(
		FarmerRegistrationVersionLocalService
			farmerRegistrationVersionLocalService) {

		_farmerRegistrationVersionLocalService =
			farmerRegistrationVersionLocalService;
	}

	private FarmerRegistrationVersionLocalService
		_farmerRegistrationVersionLocalService;

}