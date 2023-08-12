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

package bd.gov.dgfood.credit.other.priority.customer.service;

import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerVersion;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SalesCustomerVersion. This utility wraps
 * <code>bd.gov.dgfood.credit.other.priority.customer.service.impl.SalesCustomerVersionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SalesCustomerVersionLocalService
 * @generated
 */
public class SalesCustomerVersionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>bd.gov.dgfood.credit.other.priority.customer.service.impl.SalesCustomerVersionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static SalesCustomerVersion add(
			long salesCustomerId, long createdBy, String userType,
			String mobileNumber, String emailAddress, String title,
			String contactPersonName, String contactPersonDesignation,
			String officeName, String organizationName, String organizationType,
			int gender, long officeRegion, long officeDistrict,
			long officeUpazilla, long officeCityCorporationOrMunicipality,
			long officeUnionOrWard, String officevillageOrRoad,
			String officeMouzaOrMoholla, long officeZipCode,
			String officePostOffice, String address,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().add(
			salesCustomerId, createdBy, userType, mobileNumber, emailAddress,
			title, contactPersonName, contactPersonDesignation, officeName,
			organizationName, organizationType, gender, officeRegion,
			officeDistrict, officeUpazilla, officeCityCorporationOrMunicipality,
			officeUnionOrWard, officevillageOrRoad, officeMouzaOrMoholla,
			officeZipCode, officePostOffice, address, serviceContext);
	}

	/**
	 * @param modifiedBy
	 * @param userType
	 * @param mobileNumber
	 * @param emailAddress
	 * @param title
	 * @param contactPersonName
	 * @param contactPersonDesignation
	 * @param officeName
	 * @param organizationName
	 * @param organizationType
	 * @param gender
	 * @param officeRegion
	 * @param officeDistrict
	 * @param officeUpazilla
	 * @param officeCityCorporationOrMunicipality
	 * @param officeUnionOrWard
	 * @param officevillageOrRoad
	 * @param officeMouzaOrMoholla
	 * @param officeZipCode
	 * @param officePostOffice
	 * @param address
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 */
	public static SalesCustomerVersion addHistory(
			long modifiedBy, long salesCustomerId, String mobileNumber,
			String emailAddress, String title, String contactPersonName,
			String contactPersonDesignation, String officeName,
			String organizationName, String organizationType, int gender,
			long officeRegion, long officeDistrict, long officeUpazilla,
			long officeCityCorporationOrMunicipality, long officeUnionOrWard,
			String officevillageOrRoad, String officeMouzaOrMoholla,
			long officeZipCode, String officePostOffice, String address,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addHistory(
			modifiedBy, salesCustomerId, mobileNumber, emailAddress, title,
			contactPersonName, contactPersonDesignation, officeName,
			organizationName, organizationType, gender, officeRegion,
			officeDistrict, officeUpazilla, officeCityCorporationOrMunicipality,
			officeUnionOrWard, officevillageOrRoad, officeMouzaOrMoholla,
			officeZipCode, officePostOffice, address, serviceContext);
	}

	/**
	 * Adds the sales customer version to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SalesCustomerVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param salesCustomerVersion the sales customer version
	 * @return the sales customer version that was added
	 */
	public static SalesCustomerVersion addSalesCustomerVersion(
		SalesCustomerVersion salesCustomerVersion) {

		return getService().addSalesCustomerVersion(salesCustomerVersion);
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
	 * Creates a new sales customer version with the primary key. Does not add the sales customer version to the database.
	 *
	 * @param salesCustomerVersionId the primary key for the new sales customer version
	 * @return the new sales customer version
	 */
	public static SalesCustomerVersion createSalesCustomerVersion(
		long salesCustomerVersionId) {

		return getService().createSalesCustomerVersion(salesCustomerVersionId);
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
	 * Deletes the sales customer version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SalesCustomerVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param salesCustomerVersionId the primary key of the sales customer version
	 * @return the sales customer version that was removed
	 * @throws PortalException if a sales customer version with the primary key could not be found
	 */
	public static SalesCustomerVersion deleteSalesCustomerVersion(
			long salesCustomerVersionId)
		throws PortalException {

		return getService().deleteSalesCustomerVersion(salesCustomerVersionId);
	}

	/**
	 * Deletes the sales customer version from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SalesCustomerVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param salesCustomerVersion the sales customer version
	 * @return the sales customer version that was removed
	 */
	public static SalesCustomerVersion deleteSalesCustomerVersion(
		SalesCustomerVersion salesCustomerVersion) {

		return getService().deleteSalesCustomerVersion(salesCustomerVersion);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.credit.other.priority.customer.model.impl.SalesCustomerVersionModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.credit.other.priority.customer.model.impl.SalesCustomerVersionModelImpl</code>.
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

	public static SalesCustomerVersion fetchSalesCustomerVersion(
		long salesCustomerVersionId) {

		return getService().fetchSalesCustomerVersion(salesCustomerVersionId);
	}

	/**
	 * Returns the sales customer version matching the UUID and group.
	 *
	 * @param uuid the sales customer version's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sales customer version, or <code>null</code> if a matching sales customer version could not be found
	 */
	public static SalesCustomerVersion
		fetchSalesCustomerVersionByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchSalesCustomerVersionByUuidAndGroupId(
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
	 * Returns the sales customer version with the primary key.
	 *
	 * @param salesCustomerVersionId the primary key of the sales customer version
	 * @return the sales customer version
	 * @throws PortalException if a sales customer version with the primary key could not be found
	 */
	public static SalesCustomerVersion getSalesCustomerVersion(
			long salesCustomerVersionId)
		throws PortalException {

		return getService().getSalesCustomerVersion(salesCustomerVersionId);
	}

	/**
	 * Returns the sales customer version matching the UUID and group.
	 *
	 * @param uuid the sales customer version's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sales customer version
	 * @throws PortalException if a matching sales customer version could not be found
	 */
	public static SalesCustomerVersion getSalesCustomerVersionByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getSalesCustomerVersionByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the sales customer versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.credit.other.priority.customer.model.impl.SalesCustomerVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sales customer versions
	 * @param end the upper bound of the range of sales customer versions (not inclusive)
	 * @return the range of sales customer versions
	 */
	public static List<SalesCustomerVersion> getSalesCustomerVersions(
		int start, int end) {

		return getService().getSalesCustomerVersions(start, end);
	}

	/**
	 * Returns all the sales customer versions matching the UUID and company.
	 *
	 * @param uuid the UUID of the sales customer versions
	 * @param companyId the primary key of the company
	 * @return the matching sales customer versions, or an empty list if no matches were found
	 */
	public static List<SalesCustomerVersion>
		getSalesCustomerVersionsByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getSalesCustomerVersionsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of sales customer versions matching the UUID and company.
	 *
	 * @param uuid the UUID of the sales customer versions
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of sales customer versions
	 * @param end the upper bound of the range of sales customer versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching sales customer versions, or an empty list if no matches were found
	 */
	public static List<SalesCustomerVersion>
		getSalesCustomerVersionsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<SalesCustomerVersion> orderByComparator) {

		return getService().getSalesCustomerVersionsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of sales customer versions.
	 *
	 * @return the number of sales customer versions
	 */
	public static int getSalesCustomerVersionsCount() {
		return getService().getSalesCustomerVersionsCount();
	}

	/**
	 * Updates the sales customer version in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SalesCustomerVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param salesCustomerVersion the sales customer version
	 * @return the sales customer version that was updated
	 */
	public static SalesCustomerVersion updateSalesCustomerVersion(
		SalesCustomerVersion salesCustomerVersion) {

		return getService().updateSalesCustomerVersion(salesCustomerVersion);
	}

	/**
	 * Update workflow status
	 *
	 * @param userId
	 * @param beneficiaryId
	 * @param status
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static SalesCustomerVersion updateStatus(
			long approverId, long salesCustomerVersionId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		return getService().updateStatus(
			approverId, salesCustomerVersionId, status, serviceContext);
	}

	/**
	 * Update workflow status
	 *
	 * @param userId
	 * @param beneficiaryId
	 * @param status
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static SalesCustomerVersion updateStatus(
			long approvedId, String approverName, long salesCustomerId,
			double version, int status, long userId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateStatus(
			approvedId, approverName, salesCustomerId, version, status, userId,
			serviceContext);
	}

	public static SalesCustomerVersionLocalService getService() {
		return _service;
	}

	private static volatile SalesCustomerVersionLocalService _service;

}