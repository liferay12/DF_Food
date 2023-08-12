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
 * Provides a wrapper for {@link SalesCustomerAllocationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SalesCustomerAllocationLocalService
 * @generated
 */
public class SalesCustomerAllocationLocalServiceWrapper
	implements SalesCustomerAllocationLocalService,
			   ServiceWrapper<SalesCustomerAllocationLocalService> {

	public SalesCustomerAllocationLocalServiceWrapper() {
		this(null);
	}

	public SalesCustomerAllocationLocalServiceWrapper(
		SalesCustomerAllocationLocalService
			salesCustomerAllocationLocalService) {

		_salesCustomerAllocationLocalService =
			salesCustomerAllocationLocalService;
	}

	@Override
	public
		bd.gov.dgfood.credit.other.priority.customer.model.
			SalesCustomerAllocation addEntry(
				long salesCustomerCode, String salesCustomerName,
				long allocationNumber, String salesOrganization,
				String distributionChannel, int year, String district,
				String subDistrict, String govOrderNumber, String commodity,
				double yearlyQty, String yearlyQtyUnit, double monthlyQty,
				String monthlyQtyUnit, long businessCode, String uc) {

		return _salesCustomerAllocationLocalService.addEntry(
			salesCustomerCode, salesCustomerName, allocationNumber,
			salesOrganization, distributionChannel, year, district, subDistrict,
			govOrderNumber, commodity, yearlyQty, yearlyQtyUnit, monthlyQty,
			monthlyQtyUnit, businessCode, uc);
	}

	/**
	 * Adds the sales customer allocation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SalesCustomerAllocationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param salesCustomerAllocation the sales customer allocation
	 * @return the sales customer allocation that was added
	 */
	@Override
	public
		bd.gov.dgfood.credit.other.priority.customer.model.
			SalesCustomerAllocation addSalesCustomerAllocation(
				bd.gov.dgfood.credit.other.priority.customer.model.
					SalesCustomerAllocation salesCustomerAllocation) {

		return _salesCustomerAllocationLocalService.addSalesCustomerAllocation(
			salesCustomerAllocation);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _salesCustomerAllocationLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new sales customer allocation with the primary key. Does not add the sales customer allocation to the database.
	 *
	 * @param salesCustomerAllocationId the primary key for the new sales customer allocation
	 * @return the new sales customer allocation
	 */
	@Override
	public
		bd.gov.dgfood.credit.other.priority.customer.model.
			SalesCustomerAllocation createSalesCustomerAllocation(
				long salesCustomerAllocationId) {

		return _salesCustomerAllocationLocalService.
			createSalesCustomerAllocation(salesCustomerAllocationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _salesCustomerAllocationLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the sales customer allocation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SalesCustomerAllocationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param salesCustomerAllocationId the primary key of the sales customer allocation
	 * @return the sales customer allocation that was removed
	 * @throws PortalException if a sales customer allocation with the primary key could not be found
	 */
	@Override
	public
		bd.gov.dgfood.credit.other.priority.customer.model.
			SalesCustomerAllocation deleteSalesCustomerAllocation(
					long salesCustomerAllocationId)
				throws com.liferay.portal.kernel.exception.PortalException {

		return _salesCustomerAllocationLocalService.
			deleteSalesCustomerAllocation(salesCustomerAllocationId);
	}

	/**
	 * Deletes the sales customer allocation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SalesCustomerAllocationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param salesCustomerAllocation the sales customer allocation
	 * @return the sales customer allocation that was removed
	 */
	@Override
	public
		bd.gov.dgfood.credit.other.priority.customer.model.
			SalesCustomerAllocation deleteSalesCustomerAllocation(
				bd.gov.dgfood.credit.other.priority.customer.model.
					SalesCustomerAllocation salesCustomerAllocation) {

		return _salesCustomerAllocationLocalService.
			deleteSalesCustomerAllocation(salesCustomerAllocation);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _salesCustomerAllocationLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _salesCustomerAllocationLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _salesCustomerAllocationLocalService.dynamicQuery();
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

		return _salesCustomerAllocationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.credit.other.priority.customer.model.impl.SalesCustomerAllocationModelImpl</code>.
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

		return _salesCustomerAllocationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.credit.other.priority.customer.model.impl.SalesCustomerAllocationModelImpl</code>.
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

		return _salesCustomerAllocationLocalService.dynamicQuery(
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

		return _salesCustomerAllocationLocalService.dynamicQueryCount(
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

		return _salesCustomerAllocationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public
		bd.gov.dgfood.credit.other.priority.customer.model.
			SalesCustomerAllocation fetchSalesCustomerAllocation(
				long salesCustomerAllocationId) {

		return _salesCustomerAllocationLocalService.
			fetchSalesCustomerAllocation(salesCustomerAllocationId);
	}

	/**
	 * Returns the sales customer allocation with the matching UUID and company.
	 *
	 * @param uuid the sales customer allocation's UUID
	 * @param companyId the primary key of the company
	 * @return the matching sales customer allocation, or <code>null</code> if a matching sales customer allocation could not be found
	 */
	@Override
	public
		bd.gov.dgfood.credit.other.priority.customer.model.
			SalesCustomerAllocation
				fetchSalesCustomerAllocationByUuidAndCompanyId(
					String uuid, long companyId) {

		return _salesCustomerAllocationLocalService.
			fetchSalesCustomerAllocationByUuidAndCompanyId(uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _salesCustomerAllocationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _salesCustomerAllocationLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _salesCustomerAllocationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _salesCustomerAllocationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _salesCustomerAllocationLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the sales customer allocation with the primary key.
	 *
	 * @param salesCustomerAllocationId the primary key of the sales customer allocation
	 * @return the sales customer allocation
	 * @throws PortalException if a sales customer allocation with the primary key could not be found
	 */
	@Override
	public
		bd.gov.dgfood.credit.other.priority.customer.model.
			SalesCustomerAllocation getSalesCustomerAllocation(
					long salesCustomerAllocationId)
				throws com.liferay.portal.kernel.exception.PortalException {

		return _salesCustomerAllocationLocalService.getSalesCustomerAllocation(
			salesCustomerAllocationId);
	}

	/**
	 * Returns the sales customer allocation with the matching UUID and company.
	 *
	 * @param uuid the sales customer allocation's UUID
	 * @param companyId the primary key of the company
	 * @return the matching sales customer allocation
	 * @throws PortalException if a matching sales customer allocation could not be found
	 */
	@Override
	public
		bd.gov.dgfood.credit.other.priority.customer.model.
			SalesCustomerAllocation
					getSalesCustomerAllocationByUuidAndCompanyId(
						String uuid, long companyId)
				throws com.liferay.portal.kernel.exception.PortalException {

		return _salesCustomerAllocationLocalService.
			getSalesCustomerAllocationByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of all the sales customer allocations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.credit.other.priority.customer.model.impl.SalesCustomerAllocationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sales customer allocations
	 * @param end the upper bound of the range of sales customer allocations (not inclusive)
	 * @return the range of sales customer allocations
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.credit.other.priority.customer.model.
			SalesCustomerAllocation> getSalesCustomerAllocations(
				int start, int end) {

		return _salesCustomerAllocationLocalService.getSalesCustomerAllocations(
			start, end);
	}

	/**
	 * Returns the number of sales customer allocations.
	 *
	 * @return the number of sales customer allocations
	 */
	@Override
	public int getSalesCustomerAllocationsCount() {
		return _salesCustomerAllocationLocalService.
			getSalesCustomerAllocationsCount();
	}

	/**
	 * @param year
	 * @param commodity
	 * @param userId
	 * @param start
	 * @param end
	 * @return
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.credit.other.priority.customer.model.
			SalesCustomerAllocation> search(
				int year, String commodity, long salesCustomerCode, int start,
				int end) {

		return _salesCustomerAllocationLocalService.search(
			year, commodity, salesCustomerCode, start, end);
	}

	/**
	 * @param year
	 * @param commodity
	 * @param userId
	 * @return
	 */
	@Override
	public int searchCount(int year, String commodity, long salesCustomerCode) {
		return _salesCustomerAllocationLocalService.searchCount(
			year, commodity, salesCustomerCode);
	}

	/**
	 * Updates the sales customer allocation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SalesCustomerAllocationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param salesCustomerAllocation the sales customer allocation
	 * @return the sales customer allocation that was updated
	 */
	@Override
	public
		bd.gov.dgfood.credit.other.priority.customer.model.
			SalesCustomerAllocation updateSalesCustomerAllocation(
				bd.gov.dgfood.credit.other.priority.customer.model.
					SalesCustomerAllocation salesCustomerAllocation) {

		return _salesCustomerAllocationLocalService.
			updateSalesCustomerAllocation(salesCustomerAllocation);
	}

	@Override
	public SalesCustomerAllocationLocalService getWrappedService() {
		return _salesCustomerAllocationLocalService;
	}

	@Override
	public void setWrappedService(
		SalesCustomerAllocationLocalService
			salesCustomerAllocationLocalService) {

		_salesCustomerAllocationLocalService =
			salesCustomerAllocationLocalService;
	}

	private SalesCustomerAllocationLocalService
		_salesCustomerAllocationLocalService;

}