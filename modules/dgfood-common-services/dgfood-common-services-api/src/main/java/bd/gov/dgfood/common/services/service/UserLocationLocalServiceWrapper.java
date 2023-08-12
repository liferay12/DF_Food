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
 * Provides a wrapper for {@link UserLocationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserLocationLocalService
 * @generated
 */
public class UserLocationLocalServiceWrapper
	implements ServiceWrapper<UserLocationLocalService>,
			   UserLocationLocalService {

	public UserLocationLocalServiceWrapper() {
		this(null);
	}

	public UserLocationLocalServiceWrapper(
		UserLocationLocalService userLocationLocalService) {

		_userLocationLocalService = userLocationLocalService;
	}

	/**
	 * @param userId
	 * @param salesOfficeId
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 */
	@Override
	public bd.gov.dgfood.common.services.model.UserLocation add(
			long userId, long locationId, String locationName,
			String locationCode, String locationType, String roleKey,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userLocationLocalService.add(
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
	@Override
	public bd.gov.dgfood.common.services.model.UserLocation addUserLocation(
		bd.gov.dgfood.common.services.model.UserLocation userLocation) {

		return _userLocationLocalService.addUserLocation(userLocation);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userLocationLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new user location with the primary key. Does not add the user location to the database.
	 *
	 * @param userLocationId the primary key for the new user location
	 * @return the new user location
	 */
	@Override
	public bd.gov.dgfood.common.services.model.UserLocation createUserLocation(
		long userLocationId) {

		return _userLocationLocalService.createUserLocation(userLocationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userLocationLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public bd.gov.dgfood.common.services.model.UserLocation deleteUserLocation(
			long userLocationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userLocationLocalService.deleteUserLocation(userLocationId);
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
	@Override
	public bd.gov.dgfood.common.services.model.UserLocation deleteUserLocation(
		bd.gov.dgfood.common.services.model.UserLocation userLocation) {

		return _userLocationLocalService.deleteUserLocation(userLocation);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _userLocationLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _userLocationLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userLocationLocalService.dynamicQuery();
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

		return _userLocationLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _userLocationLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _userLocationLocalService.dynamicQuery(
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

		return _userLocationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _userLocationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.common.services.model.UserLocation fetchUserLocation(
		long userLocationId) {

		return _userLocationLocalService.fetchUserLocation(userLocationId);
	}

	/**
	 * Returns the user location matching the UUID and group.
	 *
	 * @param uuid the user location's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user location, or <code>null</code> if a matching user location could not be found
	 */
	@Override
	public bd.gov.dgfood.common.services.model.UserLocation
		fetchUserLocationByUuidAndGroupId(String uuid, long groupId) {

		return _userLocationLocalService.fetchUserLocationByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _userLocationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _userLocationLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _userLocationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userLocationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userLocationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the user location with the primary key.
	 *
	 * @param userLocationId the primary key of the user location
	 * @return the user location
	 * @throws PortalException if a user location with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.common.services.model.UserLocation getUserLocation(
			long userLocationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userLocationLocalService.getUserLocation(userLocationId);
	}

	/**
	 * @param locationId
	 */
	@Override
	public bd.gov.dgfood.common.services.model.UserLocation
		getUserLocationByLocationId(long locationId) {

		return _userLocationLocalService.getUserLocationByLocationId(
			locationId);
	}

	/**
	 * @param roleKey
	 * @param locationCode
	 * @return
	 */
	@Override
	public bd.gov.dgfood.common.services.model.UserLocation
		getUserLocationByRK_LC(String roleKey, String locationCode) {

		return _userLocationLocalService.getUserLocationByRK_LC(
			roleKey, locationCode);
	}

	/**
	 * Returns the user location matching the UUID and group.
	 *
	 * @param uuid the user location's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user location
	 * @throws PortalException if a matching user location could not be found
	 */
	@Override
	public bd.gov.dgfood.common.services.model.UserLocation
			getUserLocationByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userLocationLocalService.getUserLocationByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<bd.gov.dgfood.common.services.model.UserLocation>
		getUserLocations(int start, int end) {

		return _userLocationLocalService.getUserLocations(start, end);
	}

	/**
	 * @param userId
	 */
	@Override
	public java.util.List<bd.gov.dgfood.common.services.model.UserLocation>
		getUserLocationsByUserId(long userId, int start, int end) {

		return _userLocationLocalService.getUserLocationsByUserId(
			userId, start, end);
	}

	/**
	 * Returns all the user locations matching the UUID and company.
	 *
	 * @param uuid the UUID of the user locations
	 * @param companyId the primary key of the company
	 * @return the matching user locations, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<bd.gov.dgfood.common.services.model.UserLocation>
		getUserLocationsByUuidAndCompanyId(String uuid, long companyId) {

		return _userLocationLocalService.getUserLocationsByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<bd.gov.dgfood.common.services.model.UserLocation>
		getUserLocationsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<bd.gov.dgfood.common.services.model.UserLocation>
					orderByComparator) {

		return _userLocationLocalService.getUserLocationsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of user locations.
	 *
	 * @return the number of user locations
	 */
	@Override
	public int getUserLocationsCount() {
		return _userLocationLocalService.getUserLocationsCount();
	}

	/**
	 * @param userId
	 */
	@Override
	public int getUserLocationsCountByUserId(long userId) {
		return _userLocationLocalService.getUserLocationsCountByUserId(userId);
	}

	/**
	 * @param userLocationId
	 * @param salesOfficeId
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 */
	@Override
	public bd.gov.dgfood.common.services.model.UserLocation update(
			long userLocationId, long locationId, String locationName,
			String locationCode, String roleKey, String locationType,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userLocationLocalService.update(
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
	@Override
	public bd.gov.dgfood.common.services.model.UserLocation updateUserLocation(
		bd.gov.dgfood.common.services.model.UserLocation userLocation) {

		return _userLocationLocalService.updateUserLocation(userLocation);
	}

	@Override
	public UserLocationLocalService getWrappedService() {
		return _userLocationLocalService;
	}

	@Override
	public void setWrappedService(
		UserLocationLocalService userLocationLocalService) {

		_userLocationLocalService = userLocationLocalService;
	}

	private UserLocationLocalService _userLocationLocalService;

}