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
 * Provides a wrapper for {@link FGLicenseDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FGLicenseDetailsLocalService
 * @generated
 */
public class FGLicenseDetailsLocalServiceWrapper
	implements FGLicenseDetailsLocalService,
			   ServiceWrapper<FGLicenseDetailsLocalService> {

	public FGLicenseDetailsLocalServiceWrapper() {
		this(null);
	}

	public FGLicenseDetailsLocalServiceWrapper(
		FGLicenseDetailsLocalService fgLicenseDetailsLocalService) {

		_fgLicenseDetailsLocalService = fgLicenseDetailsLocalService;
	}

	/**
	 * Adds the fg license details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FGLicenseDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fgLicenseDetails the fg license details
	 * @return the fg license details that was added
	 */
	@Override
	public bd.gov.dgfood.license.management.system.model.FGLicenseDetails
		addFGLicenseDetails(
			bd.gov.dgfood.license.management.system.model.FGLicenseDetails
				fgLicenseDetails) {

		return _fgLicenseDetailsLocalService.addFGLicenseDetails(
			fgLicenseDetails);
	}

	/**
	 * Create a new FG Licensee details record for the submitted FG License form.
	 * Complete form data will be stored in this table
	 */
	@Override
	public bd.gov.dgfood.license.management.system.model.FGLicenseDetails
		addFGLicenseDetails(
			String nationalId, String applicationNumber, String applicantName,
			String tradeLicenseNumber, java.util.Date tradeLicenseExpiryDate,
			String tradeLicenseIssuerCode, String tradeLicenseIssuerCity,
			String businessIdentificationNumber, String taxIdentificationNumber,
			long tradeLicenseDocId, long businessIdentificationDocId,
			long taxIdentfctDocId, long bankStatementDocId,
			String applicationType) {

		return _fgLicenseDetailsLocalService.addFGLicenseDetails(
			nationalId, applicationNumber, applicantName, tradeLicenseNumber,
			tradeLicenseExpiryDate, tradeLicenseIssuerCode,
			tradeLicenseIssuerCity, businessIdentificationNumber,
			taxIdentificationNumber, tradeLicenseDocId,
			businessIdentificationDocId, taxIdentfctDocId, bankStatementDocId,
			applicationType);
	}

	/**
	 * Creates a new fg license details with the primary key. Does not add the fg license details to the database.
	 *
	 * @param fgLicenseMasterId the primary key for the new fg license details
	 * @return the new fg license details
	 */
	@Override
	public bd.gov.dgfood.license.management.system.model.FGLicenseDetails
		createFGLicenseDetails(long fgLicenseMasterId) {

		return _fgLicenseDetailsLocalService.createFGLicenseDetails(
			fgLicenseMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fgLicenseDetailsLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the fg license details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FGLicenseDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fgLicenseDetails the fg license details
	 * @return the fg license details that was removed
	 */
	@Override
	public bd.gov.dgfood.license.management.system.model.FGLicenseDetails
		deleteFGLicenseDetails(
			bd.gov.dgfood.license.management.system.model.FGLicenseDetails
				fgLicenseDetails) {

		return _fgLicenseDetailsLocalService.deleteFGLicenseDetails(
			fgLicenseDetails);
	}

	/**
	 * Deletes the fg license details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FGLicenseDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fgLicenseMasterId the primary key of the fg license details
	 * @return the fg license details that was removed
	 * @throws PortalException if a fg license details with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.license.management.system.model.FGLicenseDetails
			deleteFGLicenseDetails(long fgLicenseMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fgLicenseDetailsLocalService.deleteFGLicenseDetails(
			fgLicenseMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fgLicenseDetailsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _fgLicenseDetailsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _fgLicenseDetailsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _fgLicenseDetailsLocalService.dynamicQuery();
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

		return _fgLicenseDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.license.management.system.model.impl.FGLicenseDetailsModelImpl</code>.
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

		return _fgLicenseDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.license.management.system.model.impl.FGLicenseDetailsModelImpl</code>.
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

		return _fgLicenseDetailsLocalService.dynamicQuery(
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

		return _fgLicenseDetailsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _fgLicenseDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.license.management.system.model.FGLicenseDetails
		fetchFGLicenseDetails(long fgLicenseMasterId) {

		return _fgLicenseDetailsLocalService.fetchFGLicenseDetails(
			fgLicenseMasterId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _fgLicenseDetailsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the fg license details with the primary key.
	 *
	 * @param fgLicenseMasterId the primary key of the fg license details
	 * @return the fg license details
	 * @throws PortalException if a fg license details with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.license.management.system.model.FGLicenseDetails
			getFGLicenseDetails(long fgLicenseMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fgLicenseDetailsLocalService.getFGLicenseDetails(
			fgLicenseMasterId);
	}

	/**
	 * Returns a range of all the fg license detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.license.management.system.model.impl.FGLicenseDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fg license detailses
	 * @param end the upper bound of the range of fg license detailses (not inclusive)
	 * @return the range of fg license detailses
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.license.management.system.model.FGLicenseDetails>
			getFGLicenseDetailses(int start, int end) {

		return _fgLicenseDetailsLocalService.getFGLicenseDetailses(start, end);
	}

	/**
	 * Returns the number of fg license detailses.
	 *
	 * @return the number of fg license detailses
	 */
	@Override
	public int getFGLicenseDetailsesCount() {
		return _fgLicenseDetailsLocalService.getFGLicenseDetailsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _fgLicenseDetailsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _fgLicenseDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fgLicenseDetailsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the fg license details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FGLicenseDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fgLicenseDetails the fg license details
	 * @return the fg license details that was updated
	 */
	@Override
	public bd.gov.dgfood.license.management.system.model.FGLicenseDetails
		updateFGLicenseDetails(
			bd.gov.dgfood.license.management.system.model.FGLicenseDetails
				fgLicenseDetails) {

		return _fgLicenseDetailsLocalService.updateFGLicenseDetails(
			fgLicenseDetails);
	}

	@Override
	public FGLicenseDetailsLocalService getWrappedService() {
		return _fgLicenseDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		FGLicenseDetailsLocalService fgLicenseDetailsLocalService) {

		_fgLicenseDetailsLocalService = fgLicenseDetailsLocalService;
	}

	private FGLicenseDetailsLocalService _fgLicenseDetailsLocalService;

}