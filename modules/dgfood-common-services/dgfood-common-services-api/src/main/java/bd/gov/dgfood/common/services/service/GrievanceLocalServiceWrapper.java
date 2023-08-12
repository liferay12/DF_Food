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
 * Provides a wrapper for {@link GrievanceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see GrievanceLocalService
 * @generated
 */
public class GrievanceLocalServiceWrapper
	implements GrievanceLocalService, ServiceWrapper<GrievanceLocalService> {

	public GrievanceLocalServiceWrapper() {
		this(null);
	}

	public GrievanceLocalServiceWrapper(
		GrievanceLocalService grievanceLocalService) {

		_grievanceLocalService = grievanceLocalService;
	}

	/**
	 * Adds the grievance to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GrievanceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param grievance the grievance
	 * @return the grievance that was added
	 */
	@Override
	public bd.gov.dgfood.common.services.model.Grievance addGrievance(
		bd.gov.dgfood.common.services.model.Grievance grievance) {

		return _grievanceLocalService.addGrievance(grievance);
	}

	@Override
	public bd.gov.dgfood.common.services.model.Grievance addGrievance(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		long grievanceCategory, String userName, long userType,
		String mobileNumber, String complaintDetails, long attachmentId) {

		return _grievanceLocalService.addGrievance(
			serviceContext, grievanceCategory, userName, userType, mobileNumber,
			complaintDetails, attachmentId);
	}

	/**
	 * Creates a new grievance with the primary key. Does not add the grievance to the database.
	 *
	 * @param grievanceId the primary key for the new grievance
	 * @return the new grievance
	 */
	@Override
	public bd.gov.dgfood.common.services.model.Grievance createGrievance(
		long grievanceId) {

		return _grievanceLocalService.createGrievance(grievanceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _grievanceLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the grievance from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GrievanceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param grievance the grievance
	 * @return the grievance that was removed
	 */
	@Override
	public bd.gov.dgfood.common.services.model.Grievance deleteGrievance(
		bd.gov.dgfood.common.services.model.Grievance grievance) {

		return _grievanceLocalService.deleteGrievance(grievance);
	}

	/**
	 * Deletes the grievance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GrievanceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param grievanceId the primary key of the grievance
	 * @return the grievance that was removed
	 * @throws PortalException if a grievance with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.common.services.model.Grievance deleteGrievance(
			long grievanceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _grievanceLocalService.deleteGrievance(grievanceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _grievanceLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _grievanceLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _grievanceLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _grievanceLocalService.dynamicQuery();
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

		return _grievanceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.GrievanceModelImpl</code>.
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

		return _grievanceLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.GrievanceModelImpl</code>.
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

		return _grievanceLocalService.dynamicQuery(
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

		return _grievanceLocalService.dynamicQueryCount(dynamicQuery);
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

		return _grievanceLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.common.services.model.Grievance fetchGrievance(
		long grievanceId) {

		return _grievanceLocalService.fetchGrievance(grievanceId);
	}

	/**
	 * Returns the grievance matching the UUID and group.
	 *
	 * @param uuid the grievance's UUID
	 * @param groupId the primary key of the group
	 * @return the matching grievance, or <code>null</code> if a matching grievance could not be found
	 */
	@Override
	public bd.gov.dgfood.common.services.model.Grievance
		fetchGrievanceByUuidAndGroupId(String uuid, long groupId) {

		return _grievanceLocalService.fetchGrievanceByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _grievanceLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the grievance with the primary key.
	 *
	 * @param grievanceId the primary key of the grievance
	 * @return the grievance
	 * @throws PortalException if a grievance with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.common.services.model.Grievance getGrievance(
			long grievanceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _grievanceLocalService.getGrievance(grievanceId);
	}

	/**
	 * Returns the grievance matching the UUID and group.
	 *
	 * @param uuid the grievance's UUID
	 * @param groupId the primary key of the group
	 * @return the matching grievance
	 * @throws PortalException if a matching grievance could not be found
	 */
	@Override
	public bd.gov.dgfood.common.services.model.Grievance
			getGrievanceByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _grievanceLocalService.getGrievanceByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public long getGrievanceCount(
		String searchKey, String fromDate, String toDate,
		long grievanceCategory, long grievanceUser, int status, long userID,
		boolean isAdmin) {

		return _grievanceLocalService.getGrievanceCount(
			searchKey, fromDate, toDate, grievanceCategory, grievanceUser,
			status, userID, isAdmin);
	}

	@Override
	public java.util.List<bd.gov.dgfood.common.services.model.Grievance>
		getGrievanceList(
			String searchKey, String fromDate, String toDate,
			long grievanceCategory, long grievanceUser, int status, int start,
			int end, long UserID, boolean isAdmin) {

		return _grievanceLocalService.getGrievanceList(
			searchKey, fromDate, toDate, grievanceCategory, grievanceUser,
			status, start, end, UserID, isAdmin);
	}

	/**
	 * Returns a range of all the grievances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.GrievanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of grievances
	 * @param end the upper bound of the range of grievances (not inclusive)
	 * @return the range of grievances
	 */
	@Override
	public java.util.List<bd.gov.dgfood.common.services.model.Grievance>
		getGrievances(int start, int end) {

		return _grievanceLocalService.getGrievances(start, end);
	}

	/**
	 * Returns all the grievances matching the UUID and company.
	 *
	 * @param uuid the UUID of the grievances
	 * @param companyId the primary key of the company
	 * @return the matching grievances, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<bd.gov.dgfood.common.services.model.Grievance>
		getGrievancesByUuidAndCompanyId(String uuid, long companyId) {

		return _grievanceLocalService.getGrievancesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of grievances matching the UUID and company.
	 *
	 * @param uuid the UUID of the grievances
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of grievances
	 * @param end the upper bound of the range of grievances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching grievances, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<bd.gov.dgfood.common.services.model.Grievance>
		getGrievancesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<bd.gov.dgfood.common.services.model.Grievance>
					orderByComparator) {

		return _grievanceLocalService.getGrievancesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of grievances.
	 *
	 * @return the number of grievances
	 */
	@Override
	public int getGrievancesCount() {
		return _grievanceLocalService.getGrievancesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _grievanceLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _grievanceLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _grievanceLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public void replyGrievance(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay,
		long grievanceId, String responseDetails) {

		_grievanceLocalService.replyGrievance(
			themeDisplay, grievanceId, responseDetails);
	}

	/**
	 * Updates the grievance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GrievanceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param grievance the grievance
	 * @return the grievance that was updated
	 */
	@Override
	public bd.gov.dgfood.common.services.model.Grievance updateGrievance(
		bd.gov.dgfood.common.services.model.Grievance grievance) {

		return _grievanceLocalService.updateGrievance(grievance);
	}

	@Override
	public GrievanceLocalService getWrappedService() {
		return _grievanceLocalService;
	}

	@Override
	public void setWrappedService(GrievanceLocalService grievanceLocalService) {
		_grievanceLocalService = grievanceLocalService;
	}

	private GrievanceLocalService _grievanceLocalService;

}