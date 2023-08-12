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

import bd.gov.dgfood.farmer.information.management.system.model.FarmerRegistrationVersion;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for FarmerRegistrationVersion. This utility wraps
 * <code>bd.gov.dgfood.farmer.information.management.system.service.impl.FarmerRegistrationVersionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FarmerRegistrationVersionLocalService
 * @generated
 */
public class FarmerRegistrationVersionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>bd.gov.dgfood.farmer.information.management.system.service.impl.FarmerRegistrationVersionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static FarmerRegistrationVersion addFarmerRegistrationVersion(
		FarmerRegistrationVersion farmerRegistrationVersion) {

		return getService().addFarmerRegistrationVersion(
			farmerRegistrationVersion);
	}

	/**
	 * Creates a new farmer registration version with the primary key. Does not add the farmer registration version to the database.
	 *
	 * @param farmerRegistrationVersionId the primary key for the new farmer registration version
	 * @return the new farmer registration version
	 */
	public static FarmerRegistrationVersion createFarmerRegistrationVersion(
		long farmerRegistrationVersionId) {

		return getService().createFarmerRegistrationVersion(
			farmerRegistrationVersionId);
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
	 * Deletes the farmer registration version from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FarmerRegistrationVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param farmerRegistrationVersion the farmer registration version
	 * @return the farmer registration version that was removed
	 */
	public static FarmerRegistrationVersion deleteFarmerRegistrationVersion(
		FarmerRegistrationVersion farmerRegistrationVersion) {

		return getService().deleteFarmerRegistrationVersion(
			farmerRegistrationVersion);
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
	public static FarmerRegistrationVersion deleteFarmerRegistrationVersion(
			long farmerRegistrationVersionId)
		throws PortalException {

		return getService().deleteFarmerRegistrationVersion(
			farmerRegistrationVersionId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.farmer.information.management.system.model.impl.FarmerRegistrationVersionModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.farmer.information.management.system.model.impl.FarmerRegistrationVersionModelImpl</code>.
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

	public static FarmerRegistrationVersion fetchFarmerRegistrationVersion(
		long farmerRegistrationVersionId) {

		return getService().fetchFarmerRegistrationVersion(
			farmerRegistrationVersionId);
	}

	/**
	 * Returns the farmer registration version matching the UUID and group.
	 *
	 * @param uuid the farmer registration version's UUID
	 * @param groupId the primary key of the group
	 * @return the matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	public static FarmerRegistrationVersion
		fetchFarmerRegistrationVersionByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().fetchFarmerRegistrationVersionByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	/**
	 * Returns the farmer registration version with the primary key.
	 *
	 * @param farmerRegistrationVersionId the primary key of the farmer registration version
	 * @return the farmer registration version
	 * @throws PortalException if a farmer registration version with the primary key could not be found
	 */
	public static FarmerRegistrationVersion getFarmerRegistrationVersion(
			long farmerRegistrationVersionId)
		throws PortalException {

		return getService().getFarmerRegistrationVersion(
			farmerRegistrationVersionId);
	}

	/**
	 * Returns the farmer registration version matching the UUID and group.
	 *
	 * @param uuid the farmer registration version's UUID
	 * @param groupId the primary key of the group
	 * @return the matching farmer registration version
	 * @throws PortalException if a matching farmer registration version could not be found
	 */
	public static FarmerRegistrationVersion
			getFarmerRegistrationVersionByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return getService().getFarmerRegistrationVersionByUuidAndGroupId(
			uuid, groupId);
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
	public static List<FarmerRegistrationVersion> getFarmerRegistrationVersions(
		int start, int end) {

		return getService().getFarmerRegistrationVersions(start, end);
	}

	/**
	 * Returns all the farmer registration versions matching the UUID and company.
	 *
	 * @param uuid the UUID of the farmer registration versions
	 * @param companyId the primary key of the company
	 * @return the matching farmer registration versions, or an empty list if no matches were found
	 */
	public static List<FarmerRegistrationVersion>
		getFarmerRegistrationVersionsByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getFarmerRegistrationVersionsByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<FarmerRegistrationVersion>
		getFarmerRegistrationVersionsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		return getService().getFarmerRegistrationVersionsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of farmer registration versions.
	 *
	 * @return the number of farmer registration versions
	 */
	public static int getFarmerRegistrationVersionsCount() {
		return getService().getFarmerRegistrationVersionsCount();
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
	 * Updates the farmer registration version in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FarmerRegistrationVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param farmerRegistrationVersion the farmer registration version
	 * @return the farmer registration version that was updated
	 */
	public static FarmerRegistrationVersion updateFarmerRegistrationVersion(
		FarmerRegistrationVersion farmerRegistrationVersion) {

		return getService().updateFarmerRegistrationVersion(
			farmerRegistrationVersion);
	}

	public static FarmerRegistrationVersionLocalService getService() {
		return _service;
	}

	private static volatile FarmerRegistrationVersionLocalService _service;

}