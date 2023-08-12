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

import bd.gov.dgfood.common.services.model.Grievance;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Grievance. This utility wraps
 * <code>bd.gov.dgfood.common.services.service.impl.GrievanceLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see GrievanceLocalService
 * @generated
 */
public class GrievanceLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>bd.gov.dgfood.common.services.service.impl.GrievanceLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static Grievance addGrievance(Grievance grievance) {
		return getService().addGrievance(grievance);
	}

	public static Grievance addGrievance(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		long grievanceCategory, String userName, long userType,
		String mobileNumber, String complaintDetails, long attachmentId) {

		return getService().addGrievance(
			serviceContext, grievanceCategory, userName, userType, mobileNumber,
			complaintDetails, attachmentId);
	}

	/**
	 * Creates a new grievance with the primary key. Does not add the grievance to the database.
	 *
	 * @param grievanceId the primary key for the new grievance
	 * @return the new grievance
	 */
	public static Grievance createGrievance(long grievanceId) {
		return getService().createGrievance(grievanceId);
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
	 * Deletes the grievance from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GrievanceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param grievance the grievance
	 * @return the grievance that was removed
	 */
	public static Grievance deleteGrievance(Grievance grievance) {
		return getService().deleteGrievance(grievance);
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
	public static Grievance deleteGrievance(long grievanceId)
		throws PortalException {

		return getService().deleteGrievance(grievanceId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.GrievanceModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.GrievanceModelImpl</code>.
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

	public static Grievance fetchGrievance(long grievanceId) {
		return getService().fetchGrievance(grievanceId);
	}

	/**
	 * Returns the grievance matching the UUID and group.
	 *
	 * @param uuid the grievance's UUID
	 * @param groupId the primary key of the group
	 * @return the matching grievance, or <code>null</code> if a matching grievance could not be found
	 */
	public static Grievance fetchGrievanceByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchGrievanceByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the grievance with the primary key.
	 *
	 * @param grievanceId the primary key of the grievance
	 * @return the grievance
	 * @throws PortalException if a grievance with the primary key could not be found
	 */
	public static Grievance getGrievance(long grievanceId)
		throws PortalException {

		return getService().getGrievance(grievanceId);
	}

	/**
	 * Returns the grievance matching the UUID and group.
	 *
	 * @param uuid the grievance's UUID
	 * @param groupId the primary key of the group
	 * @return the matching grievance
	 * @throws PortalException if a matching grievance could not be found
	 */
	public static Grievance getGrievanceByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getGrievanceByUuidAndGroupId(uuid, groupId);
	}

	public static long getGrievanceCount(
		String searchKey, String fromDate, String toDate,
		long grievanceCategory, long grievanceUser, int status, long userID,
		boolean isAdmin) {

		return getService().getGrievanceCount(
			searchKey, fromDate, toDate, grievanceCategory, grievanceUser,
			status, userID, isAdmin);
	}

	public static List<Grievance> getGrievanceList(
		String searchKey, String fromDate, String toDate,
		long grievanceCategory, long grievanceUser, int status, int start,
		int end, long UserID, boolean isAdmin) {

		return getService().getGrievanceList(
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
	public static List<Grievance> getGrievances(int start, int end) {
		return getService().getGrievances(start, end);
	}

	/**
	 * Returns all the grievances matching the UUID and company.
	 *
	 * @param uuid the UUID of the grievances
	 * @param companyId the primary key of the company
	 * @return the matching grievances, or an empty list if no matches were found
	 */
	public static List<Grievance> getGrievancesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getGrievancesByUuidAndCompanyId(uuid, companyId);
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
	public static List<Grievance> getGrievancesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Grievance> orderByComparator) {

		return getService().getGrievancesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of grievances.
	 *
	 * @return the number of grievances
	 */
	public static int getGrievancesCount() {
		return getService().getGrievancesCount();
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

	public static void replyGrievance(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay,
		long grievanceId, String responseDetails) {

		getService().replyGrievance(themeDisplay, grievanceId, responseDetails);
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
	public static Grievance updateGrievance(Grievance grievance) {
		return getService().updateGrievance(grievance);
	}

	public static GrievanceLocalService getService() {
		return _service;
	}

	private static volatile GrievanceLocalService _service;

}