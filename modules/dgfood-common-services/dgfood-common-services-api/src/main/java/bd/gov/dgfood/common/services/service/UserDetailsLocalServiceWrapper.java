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
 * Provides a wrapper for {@link UserDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserDetailsLocalService
 * @generated
 */
public class UserDetailsLocalServiceWrapper
	implements ServiceWrapper<UserDetailsLocalService>,
			   UserDetailsLocalService {

	public UserDetailsLocalServiceWrapper() {
		this(null);
	}

	public UserDetailsLocalServiceWrapper(
		UserDetailsLocalService userDetailsLocalService) {

		_userDetailsLocalService = userDetailsLocalService;
	}

	/**
	 * Adds the user details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userDetails the user details
	 * @return the user details that was added
	 */
	@Override
	public bd.gov.dgfood.common.services.model.UserDetails addUserDetails(
		bd.gov.dgfood.common.services.model.UserDetails userDetails) {

		return _userDetailsLocalService.addUserDetails(userDetails);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userDetailsLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new user details with the primary key. Does not add the user details to the database.
	 *
	 * @param userDetailsId the primary key for the new user details
	 * @return the new user details
	 */
	@Override
	public bd.gov.dgfood.common.services.model.UserDetails createUserDetails(
		long userDetailsId) {

		return _userDetailsLocalService.createUserDetails(userDetailsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userDetailsLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the user details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userDetailsId the primary key of the user details
	 * @return the user details that was removed
	 * @throws PortalException if a user details with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.common.services.model.UserDetails deleteUserDetails(
			long userDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userDetailsLocalService.deleteUserDetails(userDetailsId);
	}

	/**
	 * Deletes the user details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userDetails the user details
	 * @return the user details that was removed
	 */
	@Override
	public bd.gov.dgfood.common.services.model.UserDetails deleteUserDetails(
		bd.gov.dgfood.common.services.model.UserDetails userDetails) {

		return _userDetailsLocalService.deleteUserDetails(userDetails);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _userDetailsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _userDetailsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userDetailsLocalService.dynamicQuery();
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

		return _userDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.UserDetailsModelImpl</code>.
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

		return _userDetailsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.UserDetailsModelImpl</code>.
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

		return _userDetailsLocalService.dynamicQuery(
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

		return _userDetailsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _userDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.common.services.model.UserDetails fetchUserDetails(
		long userDetailsId) {

		return _userDetailsLocalService.fetchUserDetails(userDetailsId);
	}

	@Override
	public bd.gov.dgfood.common.services.model.UserDetails findByNationalId(
		String nationalId) {

		return _userDetailsLocalService.findByNationalId(nationalId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _userDetailsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _userDetailsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userDetailsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the user details with the primary key.
	 *
	 * @param userDetailsId the primary key of the user details
	 * @return the user details
	 * @throws PortalException if a user details with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.common.services.model.UserDetails getUserDetails(
			long userDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userDetailsLocalService.getUserDetails(userDetailsId);
	}

	/**
	 * Returns a range of all the user detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.UserDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user detailses
	 * @param end the upper bound of the range of user detailses (not inclusive)
	 * @return the range of user detailses
	 */
	@Override
	public java.util.List<bd.gov.dgfood.common.services.model.UserDetails>
		getUserDetailses(int start, int end) {

		return _userDetailsLocalService.getUserDetailses(start, end);
	}

	/**
	 * Returns the number of user detailses.
	 *
	 * @return the number of user detailses
	 */
	@Override
	public int getUserDetailsesCount() {
		return _userDetailsLocalService.getUserDetailsesCount();
	}

	/**
	 * Updates the user details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userDetails the user details
	 * @return the user details that was updated
	 */
	@Override
	public bd.gov.dgfood.common.services.model.UserDetails updateUserDetails(
		bd.gov.dgfood.common.services.model.UserDetails userDetails) {

		return _userDetailsLocalService.updateUserDetails(userDetails);
	}

	@Override
	public UserDetailsLocalService getWrappedService() {
		return _userDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		UserDetailsLocalService userDetailsLocalService) {

		_userDetailsLocalService = userDetailsLocalService;
	}

	private UserDetailsLocalService _userDetailsLocalService;

}