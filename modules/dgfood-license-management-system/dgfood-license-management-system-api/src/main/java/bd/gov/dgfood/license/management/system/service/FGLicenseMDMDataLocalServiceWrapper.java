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

package bd.gov.dgfood.license.management.system.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FGLicenseMDMDataLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FGLicenseMDMDataLocalService
 * @generated
 */
public class FGLicenseMDMDataLocalServiceWrapper
	implements FGLicenseMDMDataLocalService,
			   ServiceWrapper<FGLicenseMDMDataLocalService> {

	public FGLicenseMDMDataLocalServiceWrapper() {
		this(null);
	}

	public FGLicenseMDMDataLocalServiceWrapper(
		FGLicenseMDMDataLocalService fgLicenseMDMDataLocalService) {

		_fgLicenseMDMDataLocalService = fgLicenseMDMDataLocalService;
	}

	/**
	 * Adds the fg license mdm data to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FGLicenseMDMDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fgLicenseMDMData the fg license mdm data
	 * @return the fg license mdm data that was added
	 */
	@Override
	public bd.gov.dgfood.license.management.system.model.FGLicenseMDMData
		addFGLicenseMDMData(
			bd.gov.dgfood.license.management.system.model.FGLicenseMDMData
				fgLicenseMDMData) {

		return _fgLicenseMDMDataLocalService.addFGLicenseMDMData(
			fgLicenseMDMData);
	}

	/**
	 * Creates a new fg license mdm data with the primary key. Does not add the fg license mdm data to the database.
	 *
	 * @param fgLicenseMDMId the primary key for the new fg license mdm data
	 * @return the new fg license mdm data
	 */
	@Override
	public bd.gov.dgfood.license.management.system.model.FGLicenseMDMData
		createFGLicenseMDMData(long fgLicenseMDMId) {

		return _fgLicenseMDMDataLocalService.createFGLicenseMDMData(
			fgLicenseMDMId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fgLicenseMDMDataLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the fg license mdm data from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FGLicenseMDMDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fgLicenseMDMData the fg license mdm data
	 * @return the fg license mdm data that was removed
	 */
	@Override
	public bd.gov.dgfood.license.management.system.model.FGLicenseMDMData
		deleteFGLicenseMDMData(
			bd.gov.dgfood.license.management.system.model.FGLicenseMDMData
				fgLicenseMDMData) {

		return _fgLicenseMDMDataLocalService.deleteFGLicenseMDMData(
			fgLicenseMDMData);
	}

	/**
	 * Deletes the fg license mdm data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FGLicenseMDMDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fgLicenseMDMId the primary key of the fg license mdm data
	 * @return the fg license mdm data that was removed
	 * @throws PortalException if a fg license mdm data with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.license.management.system.model.FGLicenseMDMData
			deleteFGLicenseMDMData(long fgLicenseMDMId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fgLicenseMDMDataLocalService.deleteFGLicenseMDMData(
			fgLicenseMDMId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fgLicenseMDMDataLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _fgLicenseMDMDataLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _fgLicenseMDMDataLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _fgLicenseMDMDataLocalService.dynamicQuery();
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

		return _fgLicenseMDMDataLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.license.management.system.model.impl.FGLicenseMDMDataModelImpl</code>.
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

		return _fgLicenseMDMDataLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.license.management.system.model.impl.FGLicenseMDMDataModelImpl</code>.
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

		return _fgLicenseMDMDataLocalService.dynamicQuery(
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

		return _fgLicenseMDMDataLocalService.dynamicQueryCount(dynamicQuery);
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

		return _fgLicenseMDMDataLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.license.management.system.model.FGLicenseMDMData
		fetchFGLicenseMDMData(long fgLicenseMDMId) {

		return _fgLicenseMDMDataLocalService.fetchFGLicenseMDMData(
			fgLicenseMDMId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _fgLicenseMDMDataLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the fg license mdm data with the primary key.
	 *
	 * @param fgLicenseMDMId the primary key of the fg license mdm data
	 * @return the fg license mdm data
	 * @throws PortalException if a fg license mdm data with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.license.management.system.model.FGLicenseMDMData
			getFGLicenseMDMData(long fgLicenseMDMId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fgLicenseMDMDataLocalService.getFGLicenseMDMData(
			fgLicenseMDMId);
	}

	/**
	 * Returns a range of all the fg license mdm datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.license.management.system.model.impl.FGLicenseMDMDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fg license mdm datas
	 * @param end the upper bound of the range of fg license mdm datas (not inclusive)
	 * @return the range of fg license mdm datas
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.license.management.system.model.FGLicenseMDMData>
			getFGLicenseMDMDatas(int start, int end) {

		return _fgLicenseMDMDataLocalService.getFGLicenseMDMDatas(start, end);
	}

	/**
	 * Returns the number of fg license mdm datas.
	 *
	 * @return the number of fg license mdm datas
	 */
	@Override
	public int getFGLicenseMDMDatasCount() {
		return _fgLicenseMDMDataLocalService.getFGLicenseMDMDatasCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _fgLicenseMDMDataLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _fgLicenseMDMDataLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fgLicenseMDMDataLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the fg license mdm data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FGLicenseMDMDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fgLicenseMDMData the fg license mdm data
	 * @return the fg license mdm data that was updated
	 */
	@Override
	public bd.gov.dgfood.license.management.system.model.FGLicenseMDMData
		updateFGLicenseMDMData(
			bd.gov.dgfood.license.management.system.model.FGLicenseMDMData
				fgLicenseMDMData) {

		return _fgLicenseMDMDataLocalService.updateFGLicenseMDMData(
			fgLicenseMDMData);
	}

	@Override
	public FGLicenseMDMDataLocalService getWrappedService() {
		return _fgLicenseMDMDataLocalService;
	}

	@Override
	public void setWrappedService(
		FGLicenseMDMDataLocalService fgLicenseMDMDataLocalService) {

		_fgLicenseMDMDataLocalService = fgLicenseMDMDataLocalService;
	}

	private FGLicenseMDMDataLocalService _fgLicenseMDMDataLocalService;

}