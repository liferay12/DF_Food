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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SalesCustomerVersionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SalesCustomerVersionLocalService
 * @generated
 */
public class SalesCustomerVersionLocalServiceWrapper
	implements SalesCustomerVersionLocalService,
			   ServiceWrapper<SalesCustomerVersionLocalService> {

	public SalesCustomerVersionLocalServiceWrapper() {
		this(null);
	}

	public SalesCustomerVersionLocalServiceWrapper(
		SalesCustomerVersionLocalService salesCustomerVersionLocalService) {

		_salesCustomerVersionLocalService = salesCustomerVersionLocalService;
	}

	@Override
	public
		bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerVersion
				add(
					long salesCustomerId, long createdBy, String userType,
					String mobileNumber, String emailAddress, String title,
					String contactPersonName, String contactPersonDesignation,
					String officeName, String organizationName,
					String organizationType, int gender, long officeRegion,
					long officeDistrict, long officeUpazilla,
					long officeCityCorporationOrMunicipality,
					long officeUnionOrWard, String officevillageOrRoad,
					String officeMouzaOrMoholla, long officeZipCode,
					String officePostOffice, String address,
					com.liferay.portal.kernel.service.ServiceContext
						serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _salesCustomerVersionLocalService.add(
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
	@Override
	public
		bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerVersion
				addHistory(
					long modifiedBy, long salesCustomerId, String mobileNumber,
					String emailAddress, String title, String contactPersonName,
					String contactPersonDesignation, String officeName,
					String organizationName, String organizationType,
					int gender, long officeRegion, long officeDistrict,
					long officeUpazilla,
					long officeCityCorporationOrMunicipality,
					long officeUnionOrWard, String officevillageOrRoad,
					String officeMouzaOrMoholla, long officeZipCode,
					String officePostOffice, String address,
					com.liferay.portal.kernel.service.ServiceContext
						serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _salesCustomerVersionLocalService.addHistory(
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
	@Override
	public
		bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerVersion
			addSalesCustomerVersion(
				bd.gov.dgfood.credit.other.priority.customer.model.
					SalesCustomerVersion salesCustomerVersion) {

		return _salesCustomerVersionLocalService.addSalesCustomerVersion(
			salesCustomerVersion);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _salesCustomerVersionLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new sales customer version with the primary key. Does not add the sales customer version to the database.
	 *
	 * @param salesCustomerVersionId the primary key for the new sales customer version
	 * @return the new sales customer version
	 */
	@Override
	public
		bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerVersion
			createSalesCustomerVersion(long salesCustomerVersionId) {

		return _salesCustomerVersionLocalService.createSalesCustomerVersion(
			salesCustomerVersionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _salesCustomerVersionLocalService.deletePersistedModel(
			persistedModel);
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
	@Override
	public
		bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerVersion
				deleteSalesCustomerVersion(long salesCustomerVersionId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _salesCustomerVersionLocalService.deleteSalesCustomerVersion(
			salesCustomerVersionId);
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
	@Override
	public
		bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerVersion
			deleteSalesCustomerVersion(
				bd.gov.dgfood.credit.other.priority.customer.model.
					SalesCustomerVersion salesCustomerVersion) {

		return _salesCustomerVersionLocalService.deleteSalesCustomerVersion(
			salesCustomerVersion);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _salesCustomerVersionLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _salesCustomerVersionLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _salesCustomerVersionLocalService.dynamicQuery();
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

		return _salesCustomerVersionLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _salesCustomerVersionLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _salesCustomerVersionLocalService.dynamicQuery(
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

		return _salesCustomerVersionLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _salesCustomerVersionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public
		bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerVersion
			fetchSalesCustomerVersion(long salesCustomerVersionId) {

		return _salesCustomerVersionLocalService.fetchSalesCustomerVersion(
			salesCustomerVersionId);
	}

	/**
	 * Returns the sales customer version matching the UUID and group.
	 *
	 * @param uuid the sales customer version's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sales customer version, or <code>null</code> if a matching sales customer version could not be found
	 */
	@Override
	public
		bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerVersion
			fetchSalesCustomerVersionByUuidAndGroupId(
				String uuid, long groupId) {

		return _salesCustomerVersionLocalService.
			fetchSalesCustomerVersionByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _salesCustomerVersionLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _salesCustomerVersionLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _salesCustomerVersionLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _salesCustomerVersionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _salesCustomerVersionLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the sales customer version with the primary key.
	 *
	 * @param salesCustomerVersionId the primary key of the sales customer version
	 * @return the sales customer version
	 * @throws PortalException if a sales customer version with the primary key could not be found
	 */
	@Override
	public
		bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerVersion
				getSalesCustomerVersion(long salesCustomerVersionId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _salesCustomerVersionLocalService.getSalesCustomerVersion(
			salesCustomerVersionId);
	}

	/**
	 * Returns the sales customer version matching the UUID and group.
	 *
	 * @param uuid the sales customer version's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sales customer version
	 * @throws PortalException if a matching sales customer version could not be found
	 */
	@Override
	public
		bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerVersion
				getSalesCustomerVersionByUuidAndGroupId(
					String uuid, long groupId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _salesCustomerVersionLocalService.
			getSalesCustomerVersionByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List
		<bd.gov.dgfood.credit.other.priority.customer.model.
			SalesCustomerVersion> getSalesCustomerVersions(int start, int end) {

		return _salesCustomerVersionLocalService.getSalesCustomerVersions(
			start, end);
	}

	/**
	 * Returns all the sales customer versions matching the UUID and company.
	 *
	 * @param uuid the UUID of the sales customer versions
	 * @param companyId the primary key of the company
	 * @return the matching sales customer versions, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.credit.other.priority.customer.model.
			SalesCustomerVersion> getSalesCustomerVersionsByUuidAndCompanyId(
				String uuid, long companyId) {

		return _salesCustomerVersionLocalService.
			getSalesCustomerVersionsByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List
		<bd.gov.dgfood.credit.other.priority.customer.model.
			SalesCustomerVersion> getSalesCustomerVersionsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<bd.gov.dgfood.credit.other.priority.customer.model.
						SalesCustomerVersion> orderByComparator) {

		return _salesCustomerVersionLocalService.
			getSalesCustomerVersionsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of sales customer versions.
	 *
	 * @return the number of sales customer versions
	 */
	@Override
	public int getSalesCustomerVersionsCount() {
		return _salesCustomerVersionLocalService.
			getSalesCustomerVersionsCount();
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
	@Override
	public
		bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerVersion
			updateSalesCustomerVersion(
				bd.gov.dgfood.credit.other.priority.customer.model.
					SalesCustomerVersion salesCustomerVersion) {

		return _salesCustomerVersionLocalService.updateSalesCustomerVersion(
			salesCustomerVersion);
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
	@Override
	public
		bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerVersion
				updateStatus(
					long approverId, long salesCustomerVersionId, int status,
					com.liferay.portal.kernel.service.ServiceContext
						serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException,
				   com.liferay.portal.kernel.exception.SystemException {

		return _salesCustomerVersionLocalService.updateStatus(
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
	@Override
	public
		bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerVersion
				updateStatus(
					long approvedId, String approverName, long salesCustomerId,
					double version, int status, long userId,
					com.liferay.portal.kernel.service.ServiceContext
						serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _salesCustomerVersionLocalService.updateStatus(
			approvedId, approverName, salesCustomerId, version, status, userId,
			serviceContext);
	}

	@Override
	public SalesCustomerVersionLocalService getWrappedService() {
		return _salesCustomerVersionLocalService;
	}

	@Override
	public void setWrappedService(
		SalesCustomerVersionLocalService salesCustomerVersionLocalService) {

		_salesCustomerVersionLocalService = salesCustomerVersionLocalService;
	}

	private SalesCustomerVersionLocalService _salesCustomerVersionLocalService;

}