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

import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerAllocation;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SalesCustomerAllocation. This utility wraps
 * <code>bd.gov.dgfood.credit.other.priority.customer.service.impl.SalesCustomerAllocationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SalesCustomerAllocationLocalService
 * @generated
 */
public class SalesCustomerAllocationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>bd.gov.dgfood.credit.other.priority.customer.service.impl.SalesCustomerAllocationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static SalesCustomerAllocation addEntry(
		long salesCustomerCode, String salesCustomerName, long allocationNumber,
		String salesOrganization, String distributionChannel, int year,
		String district, String subDistrict, String govOrderNumber,
		String commodity, double yearlyQty, String yearlyQtyUnit,
		double monthlyQty, String monthlyQtyUnit, long businessCode,
		String uc) {

		return getService().addEntry(
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
	public static SalesCustomerAllocation addSalesCustomerAllocation(
		SalesCustomerAllocation salesCustomerAllocation) {

		return getService().addSalesCustomerAllocation(salesCustomerAllocation);
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
	 * Creates a new sales customer allocation with the primary key. Does not add the sales customer allocation to the database.
	 *
	 * @param salesCustomerAllocationId the primary key for the new sales customer allocation
	 * @return the new sales customer allocation
	 */
	public static SalesCustomerAllocation createSalesCustomerAllocation(
		long salesCustomerAllocationId) {

		return getService().createSalesCustomerAllocation(
			salesCustomerAllocationId);
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
	public static SalesCustomerAllocation deleteSalesCustomerAllocation(
			long salesCustomerAllocationId)
		throws PortalException {

		return getService().deleteSalesCustomerAllocation(
			salesCustomerAllocationId);
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
	public static SalesCustomerAllocation deleteSalesCustomerAllocation(
		SalesCustomerAllocation salesCustomerAllocation) {

		return getService().deleteSalesCustomerAllocation(
			salesCustomerAllocation);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.credit.other.priority.customer.model.impl.SalesCustomerAllocationModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.credit.other.priority.customer.model.impl.SalesCustomerAllocationModelImpl</code>.
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

	public static SalesCustomerAllocation fetchSalesCustomerAllocation(
		long salesCustomerAllocationId) {

		return getService().fetchSalesCustomerAllocation(
			salesCustomerAllocationId);
	}

	/**
	 * Returns the sales customer allocation with the matching UUID and company.
	 *
	 * @param uuid the sales customer allocation's UUID
	 * @param companyId the primary key of the company
	 * @return the matching sales customer allocation, or <code>null</code> if a matching sales customer allocation could not be found
	 */
	public static SalesCustomerAllocation
		fetchSalesCustomerAllocationByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().fetchSalesCustomerAllocationByUuidAndCompanyId(
			uuid, companyId);
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
	 * Returns the sales customer allocation with the primary key.
	 *
	 * @param salesCustomerAllocationId the primary key of the sales customer allocation
	 * @return the sales customer allocation
	 * @throws PortalException if a sales customer allocation with the primary key could not be found
	 */
	public static SalesCustomerAllocation getSalesCustomerAllocation(
			long salesCustomerAllocationId)
		throws PortalException {

		return getService().getSalesCustomerAllocation(
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
	public static SalesCustomerAllocation
			getSalesCustomerAllocationByUuidAndCompanyId(
				String uuid, long companyId)
		throws PortalException {

		return getService().getSalesCustomerAllocationByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<SalesCustomerAllocation> getSalesCustomerAllocations(
		int start, int end) {

		return getService().getSalesCustomerAllocations(start, end);
	}

	/**
	 * Returns the number of sales customer allocations.
	 *
	 * @return the number of sales customer allocations
	 */
	public static int getSalesCustomerAllocationsCount() {
		return getService().getSalesCustomerAllocationsCount();
	}

	/**
	 * @param year
	 * @param commodity
	 * @param userId
	 * @param start
	 * @param end
	 * @return
	 */
	public static List<SalesCustomerAllocation> search(
		int year, String commodity, long salesCustomerCode, int start,
		int end) {

		return getService().search(
			year, commodity, salesCustomerCode, start, end);
	}

	/**
	 * @param year
	 * @param commodity
	 * @param userId
	 * @return
	 */
	public static int searchCount(
		int year, String commodity, long salesCustomerCode) {

		return getService().searchCount(year, commodity, salesCustomerCode);
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
	public static SalesCustomerAllocation updateSalesCustomerAllocation(
		SalesCustomerAllocation salesCustomerAllocation) {

		return getService().updateSalesCustomerAllocation(
			salesCustomerAllocation);
	}

	public static SalesCustomerAllocationLocalService getService() {
		return _service;
	}

	private static volatile SalesCustomerAllocationLocalService _service;

}