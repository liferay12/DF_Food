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
 * Provides a wrapper for {@link SalesCustomerLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SalesCustomerLocalService
 * @generated
 */
public class SalesCustomerLocalServiceWrapper
	implements SalesCustomerLocalService,
			   ServiceWrapper<SalesCustomerLocalService> {

	public SalesCustomerLocalServiceWrapper() {
		this(null);
	}

	public SalesCustomerLocalServiceWrapper(
		SalesCustomerLocalService salesCustomerLocalService) {

		_salesCustomerLocalService = salesCustomerLocalService;
	}

	/**
	 * @param createdBy
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
	public bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer
			addCustomer(
				long createdBy, String userType, String mobileNumber,
				String emailAddress, String title, String contactPersonName,
				String contactPersonDesignation, String officeName,
				String organizationName, String organizationType, int gender,
				long officeRegion, long officeDistrict, long officeUpazilla,
				long officeCityCorporationOrMunicipality,
				long officeUnionOrWard, String officevillageOrRoad,
				String officeMouzaOrMoholla, long officeZipCode,
				String officePostOffice, String address,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _salesCustomerLocalService.addCustomer(
			createdBy, userType, mobileNumber, emailAddress, title,
			contactPersonName, contactPersonDesignation, officeName,
			organizationName, organizationType, gender, officeRegion,
			officeDistrict, officeUpazilla, officeCityCorporationOrMunicipality,
			officeUnionOrWard, officevillageOrRoad, officeMouzaOrMoholla,
			officeZipCode, officePostOffice, address, serviceContext);
	}

	/**
	 * Adds the sales customer to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SalesCustomerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param salesCustomer the sales customer
	 * @return the sales customer that was added
	 */
	@Override
	public bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer
		addSalesCustomer(
			bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer
				salesCustomer) {

		return _salesCustomerLocalService.addSalesCustomer(salesCustomer);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _salesCustomerLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new sales customer with the primary key. Does not add the sales customer to the database.
	 *
	 * @param salesCustomerId the primary key for the new sales customer
	 * @return the new sales customer
	 */
	@Override
	public bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer
		createSalesCustomer(long salesCustomerId) {

		return _salesCustomerLocalService.createSalesCustomer(salesCustomerId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _salesCustomerLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the sales customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SalesCustomerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param salesCustomerId the primary key of the sales customer
	 * @return the sales customer that was removed
	 * @throws PortalException if a sales customer with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer
			deleteSalesCustomer(long salesCustomerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _salesCustomerLocalService.deleteSalesCustomer(salesCustomerId);
	}

	/**
	 * Deletes the sales customer from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SalesCustomerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param salesCustomer the sales customer
	 * @return the sales customer that was removed
	 */
	@Override
	public bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer
		deleteSalesCustomer(
			bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer
				salesCustomer) {

		return _salesCustomerLocalService.deleteSalesCustomer(salesCustomer);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _salesCustomerLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _salesCustomerLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _salesCustomerLocalService.dynamicQuery();
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

		return _salesCustomerLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.credit.other.priority.customer.model.impl.SalesCustomerModelImpl</code>.
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

		return _salesCustomerLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.credit.other.priority.customer.model.impl.SalesCustomerModelImpl</code>.
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

		return _salesCustomerLocalService.dynamicQuery(
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

		return _salesCustomerLocalService.dynamicQueryCount(dynamicQuery);
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

		return _salesCustomerLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer
		fetchSalesCustomer(long salesCustomerId) {

		return _salesCustomerLocalService.fetchSalesCustomer(salesCustomerId);
	}

	/**
	 * Returns the sales customer matching the UUID and group.
	 *
	 * @param uuid the sales customer's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sales customer, or <code>null</code> if a matching sales customer could not be found
	 */
	@Override
	public bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer
		fetchSalesCustomerByUuidAndGroupId(String uuid, long groupId) {

		return _salesCustomerLocalService.fetchSalesCustomerByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _salesCustomerLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _salesCustomerLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _salesCustomerLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _salesCustomerLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _salesCustomerLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the sales customer with the primary key.
	 *
	 * @param salesCustomerId the primary key of the sales customer
	 * @return the sales customer
	 * @throws PortalException if a sales customer with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer
			getSalesCustomer(long salesCustomerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _salesCustomerLocalService.getSalesCustomer(salesCustomerId);
	}

	/**
	 * @param userId
	 * @return
	 * @throws NoSuchSalesCustomerException
	 */
	@Override
	public bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer
		getSalesCustomerByUserId(long userId) {

		return _salesCustomerLocalService.getSalesCustomerByUserId(userId);
	}

	/**
	 * Returns the sales customer matching the UUID and group.
	 *
	 * @param uuid the sales customer's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sales customer
	 * @throws PortalException if a matching sales customer could not be found
	 */
	@Override
	public bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer
			getSalesCustomerByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _salesCustomerLocalService.getSalesCustomerByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the sales customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.credit.other.priority.customer.model.impl.SalesCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sales customers
	 * @param end the upper bound of the range of sales customers (not inclusive)
	 * @return the range of sales customers
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer>
			getSalesCustomers(int start, int end) {

		return _salesCustomerLocalService.getSalesCustomers(start, end);
	}

	/**
	 * Returns all the sales customers matching the UUID and company.
	 *
	 * @param uuid the UUID of the sales customers
	 * @param companyId the primary key of the company
	 * @return the matching sales customers, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer>
			getSalesCustomersByUuidAndCompanyId(String uuid, long companyId) {

		return _salesCustomerLocalService.getSalesCustomersByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of sales customers matching the UUID and company.
	 *
	 * @param uuid the UUID of the sales customers
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of sales customers
	 * @param end the upper bound of the range of sales customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching sales customers, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer>
			getSalesCustomersByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<bd.gov.dgfood.credit.other.priority.customer.model.
						SalesCustomer> orderByComparator) {

		return _salesCustomerLocalService.getSalesCustomersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of sales customers.
	 *
	 * @return the number of sales customers
	 */
	@Override
	public int getSalesCustomersCount() {
		return _salesCustomerLocalService.getSalesCustomersCount();
	}

	/**
	 * @param fromDate
	 * @param toDate
	 * @param status
	 * @param userType
	 * @param organizationName
	 * @param start
	 * @param end
	 * @param params
	 * @return
	 * @throws PortalException
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer>
				search(
					java.util.Date fromDate, java.util.Date toDate, int status,
					String userType, String organizationName, int start,
					int end, java.util.LinkedHashMap<String, Object> params)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _salesCustomerLocalService.search(
			fromDate, toDate, status, userType, organizationName, start, end,
			params);
	}

	/**
	 * @param companyId
	 * @param fromDate
	 * @param toDate
	 * @param status
	 * @param userType
	 * @param organizationName
	 * @param start
	 * @param end
	 * @param params
	 * @return
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.search.Hits search(
			long companyId, long fromDate, long toDate, int status,
			String userType, String organizationName, int start, int end,
			java.util.LinkedHashMap<String, Object> params)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _salesCustomerLocalService.search(
			companyId, fromDate, toDate, status, userType, organizationName,
			start, end, params);
	}

	/**
	 * @param fromDate
	 * @param toDate
	 * @param status
	 * @param userType
	 * @param organizationName
	 * @param start
	 * @param end
	 * @param params
	 * @return
	 * @throws PortalException
	 */
	@Override
	public int searchCount(
			java.util.Date fromDate, java.util.Date toDate, int status,
			String userType, String organizationName, int start, int end,
			java.util.LinkedHashMap<String, Object> params)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _salesCustomerLocalService.searchCount(
			fromDate, toDate, status, userType, organizationName, start, end,
			params);
	}

	/**
	 * @param salesCustomerVersion
	 * @return
	 * @throws PortalException
	 */
	@Override
	public bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer
			update(
				bd.gov.dgfood.credit.other.priority.customer.model.
					SalesCustomerVersion salesCustomerVersion)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _salesCustomerLocalService.update(salesCustomerVersion);
	}

	/**
	 * Updates the sales customer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SalesCustomerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param salesCustomer the sales customer
	 * @return the sales customer that was updated
	 */
	@Override
	public bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer
		updateSalesCustomer(
			bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer
				salesCustomer) {

		return _salesCustomerLocalService.updateSalesCustomer(salesCustomer);
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
	public bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer
			updateStatus(
				long approverId, long customerId, int status,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _salesCustomerLocalService.updateStatus(
			approverId, customerId, status, serviceContext);
	}

	@Override
	public SalesCustomerLocalService getWrappedService() {
		return _salesCustomerLocalService;
	}

	@Override
	public void setWrappedService(
		SalesCustomerLocalService salesCustomerLocalService) {

		_salesCustomerLocalService = salesCustomerLocalService;
	}

	private SalesCustomerLocalService _salesCustomerLocalService;

}