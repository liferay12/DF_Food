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

import bd.gov.dgfood.common.services.model.UserLocation;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for UserLocation. This utility wraps
 * <code>bd.gov.dgfood.common.services.service.impl.UserLocationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserLocationLocalService
 * @generated
 */
public class UserLocationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>bd.gov.dgfood.common.services.service.impl.UserLocationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @param userId
	 * @param salesOfficeId
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 */
	public static UserLocation add(
			long userId, long locationId, String locationName,
			String locationCode, String locationType, String roleKey,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().add(
			userId, locationId, locationName, locationCode, locationType,
			roleKey, serviceContext);
	}

	/**
	 * Adds the user location to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserLocationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userLocation the user location
	 * @return the user location that was added
	 */
	public static UserLocation addUserLocation(UserLocation userLocation) {
		return getService().addUserLocation(userLocation);
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
	 * Creates a new user location with the primary key. Does not add the user location to the database.
	 *
	 * @param userLocationId the primary key for the new user location
	 * @return the new user location
	 */
	public static UserLocation createUserLocation(long userLocationId) {
		return getService().createUserLocation(userLocationId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the user location with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserLocationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userLocationId the primary key of the user location
	 * @return the user location that was removed
	 * @throws PortalException if a user location with the primary key could not be found
	 */
	public static UserLocation deleteUserLocation(long userLocationId)
		throws PortalException {

		return getService().deleteUserLocation(userLocationId);
	}

	/**
	 * Deletes the user location from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserLocationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userLocation the user location
	 * @return the user location that was removed
	 */
	public static UserLocation deleteUserLocation(UserLocation userLocation) {
		return getService().deleteUserLocation(userLocation);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.UserLocationModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.UserLocationModelImpl</code>.
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

	public static UserLocation fetchUserLocation(long userLocationId) {
		return getService().fetchUserLocation(userLocationId);
	}

	/**
	 * Returns the user location matching the UUID and group.
	 *
	 * @param uuid the user location's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user location, or <code>null</code> if a matching user location could not be found
	 */
	public static UserLocation fetchUserLocationByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchUserLocationByUuidAndGroupId(uuid, groupId);
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
	 * Returns the user location with the primary key.
	 *
	 * @param userLocationId the primary key of the user location
	 * @return the user location
	 * @throws PortalException if a user location with the primary key could not be found
	 */
	public static UserLocation getUserLocation(long userLocationId)
		throws PortalException {

		return getService().getUserLocation(userLocationId);
	}

	/**
	 * @param locationId
	 */
	public static UserLocation getUserLocationByLocationId(long locationId) {
		return getService().getUserLocationByLocationId(locationId);
	}

	/**
	 * @param roleKey
	 * @param locationCode
	 * @return
	 */
	public static UserLocation getUserLocationByRK_LC(
		String roleKey, String locationCode) {

		return getService().getUserLocationByRK_LC(roleKey, locationCode);
	}

	/**
	 * Returns the user location matching the UUID and group.
	 *
	 * @param uuid the user location's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user location
	 * @throws PortalException if a matching user location could not be found
	 */
	public static UserLocation getUserLocationByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getUserLocationByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the user locations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @return the range of user locations
	 */
	public static List<UserLocation> getUserLocations(int start, int end) {
		return getService().getUserLocations(start, end);
	}

	/**
	 * @param userId
	 */
	public static List<UserLocation> getUserLocationsByUserId(
		long userId, int start, int end) {

		return getService().getUserLocationsByUserId(userId, start, end);
	}

	/**
	 * Returns all the user locations matching the UUID and company.
	 *
	 * @param uuid the UUID of the user locations
	 * @param companyId the primary key of the company
	 * @return the matching user locations, or an empty list if no matches were found
	 */
	public static List<UserLocation> getUserLocationsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getUserLocationsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of user locations matching the UUID and company.
	 *
	 * @param uuid the UUID of the user locations
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching user locations, or an empty list if no matches were found
	 */
	public static List<UserLocation> getUserLocationsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UserLocation> orderByComparator) {

		return getService().getUserLocationsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of user locations.
	 *
	 * @return the number of user locations
	 */
	public static int getUserLocationsCount() {
		return getService().getUserLocationsCount();
	}

	/**
	 * @param userId
	 */
	public static int getUserLocationsCountByUserId(long userId) {
		return getService().getUserLocationsCountByUserId(userId);
	}

	/**
	 * @param userLocationId
	 * @param salesOfficeId
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 */
	public static UserLocation update(
			long userLocationId, long locationId, String locationName,
			String locationCode, String roleKey, String locationType,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().update(
			userLocationId, locationId, locationName, locationCode, roleKey,
			locationType, serviceContext);
	}

	/**
	 * Updates the user location in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserLocationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userLocation the user location
	 * @return the user location that was updated
	 */
	public static UserLocation updateUserLocation(UserLocation userLocation) {
		return getService().updateUserLocation(userLocation);
	}

	public static UserLocationLocalService getService() {
		return _service;
	}

	private static volatile UserLocationLocalService _service;

}