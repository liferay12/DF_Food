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

import bd.gov.dgfood.license.management.system.model.FGLicenseDetails;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for FGLicenseDetails. This utility wraps
 * <code>bd.gov.dgfood.license.management.system.service.impl.FGLicenseDetailsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FGLicenseDetailsLocalService
 * @generated
 */
public class FGLicenseDetailsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>bd.gov.dgfood.license.management.system.service.impl.FGLicenseDetailsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static FGLicenseDetails addFGLicenseDetails(
		FGLicenseDetails fgLicenseDetails) {

		return getService().addFGLicenseDetails(fgLicenseDetails);
	}

	/**
	 * Create a new FG Licensee details record for the submitted FG License form.
	 * Complete form data will be stored in this table
	 */
	public static FGLicenseDetails addFGLicenseDetails(
		String nationalId, String applicationNumber, String applicantName,
		String tradeLicenseNumber, java.util.Date tradeLicenseExpiryDate,
		String tradeLicenseIssuerCode, String tradeLicenseIssuerCity,
		String businessIdentificationNumber, String taxIdentificationNumber,
		long tradeLicenseDocId, long businessIdentificationDocId,
		long taxIdentfctDocId, long bankStatementDocId,
		String applicationType) {

		return getService().addFGLicenseDetails(
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
	public static FGLicenseDetails createFGLicenseDetails(
		long fgLicenseMasterId) {

		return getService().createFGLicenseDetails(fgLicenseMasterId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static FGLicenseDetails deleteFGLicenseDetails(
		FGLicenseDetails fgLicenseDetails) {

		return getService().deleteFGLicenseDetails(fgLicenseDetails);
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
	public static FGLicenseDetails deleteFGLicenseDetails(
			long fgLicenseMasterId)
		throws PortalException {

		return getService().deleteFGLicenseDetails(fgLicenseMasterId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static FGLicenseDetails fetchFGLicenseDetails(
		long fgLicenseMasterId) {

		return getService().fetchFGLicenseDetails(fgLicenseMasterId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the fg license details with the primary key.
	 *
	 * @param fgLicenseMasterId the primary key of the fg license details
	 * @return the fg license details
	 * @throws PortalException if a fg license details with the primary key could not be found
	 */
	public static FGLicenseDetails getFGLicenseDetails(long fgLicenseMasterId)
		throws PortalException {

		return getService().getFGLicenseDetails(fgLicenseMasterId);
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
	public static List<FGLicenseDetails> getFGLicenseDetailses(
		int start, int end) {

		return getService().getFGLicenseDetailses(start, end);
	}

	/**
	 * Returns the number of fg license detailses.
	 *
	 * @return the number of fg license detailses
	 */
	public static int getFGLicenseDetailsesCount() {
		return getService().getFGLicenseDetailsesCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
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
	public static FGLicenseDetails updateFGLicenseDetails(
		FGLicenseDetails fgLicenseDetails) {

		return getService().updateFGLicenseDetails(fgLicenseDetails);
	}

	public static FGLicenseDetailsLocalService getService() {
		return _service;
	}

	private static volatile FGLicenseDetailsLocalService _service;

}