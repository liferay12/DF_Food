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

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for SalesCustomerAllocation. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see SalesCustomerAllocationLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface SalesCustomerAllocationLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>bd.gov.dgfood.credit.other.priority.customer.service.impl.SalesCustomerAllocationLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the sales customer allocation local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link SalesCustomerAllocationLocalServiceUtil} if injection and service tracking are not available.
	 */
	public SalesCustomerAllocation addEntry(
		long salesCustomerCode, String salesCustomerName, long allocationNumber,
		String salesOrganization, String distributionChannel, int year,
		String district, String subDistrict, String govOrderNumber,
		String commodity, double yearlyQty, String yearlyQtyUnit,
		double monthlyQty, String monthlyQtyUnit, long businessCode, String uc);

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
	@Indexable(type = IndexableType.REINDEX)
	public SalesCustomerAllocation addSalesCustomerAllocation(
		SalesCustomerAllocation salesCustomerAllocation);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new sales customer allocation with the primary key. Does not add the sales customer allocation to the database.
	 *
	 * @param salesCustomerAllocationId the primary key for the new sales customer allocation
	 * @return the new sales customer allocation
	 */
	@Transactional(enabled = false)
	public SalesCustomerAllocation createSalesCustomerAllocation(
		long salesCustomerAllocationId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public SalesCustomerAllocation deleteSalesCustomerAllocation(
			long salesCustomerAllocationId)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public SalesCustomerAllocation deleteSalesCustomerAllocation(
		SalesCustomerAllocation salesCustomerAllocation);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SalesCustomerAllocation fetchSalesCustomerAllocation(
		long salesCustomerAllocationId);

	/**
	 * Returns the sales customer allocation with the matching UUID and company.
	 *
	 * @param uuid the sales customer allocation's UUID
	 * @param companyId the primary key of the company
	 * @return the matching sales customer allocation, or <code>null</code> if a matching sales customer allocation could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SalesCustomerAllocation
		fetchSalesCustomerAllocationByUuidAndCompanyId(
			String uuid, long companyId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Returns the sales customer allocation with the primary key.
	 *
	 * @param salesCustomerAllocationId the primary key of the sales customer allocation
	 * @return the sales customer allocation
	 * @throws PortalException if a sales customer allocation with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SalesCustomerAllocation getSalesCustomerAllocation(
			long salesCustomerAllocationId)
		throws PortalException;

	/**
	 * Returns the sales customer allocation with the matching UUID and company.
	 *
	 * @param uuid the sales customer allocation's UUID
	 * @param companyId the primary key of the company
	 * @return the matching sales customer allocation
	 * @throws PortalException if a matching sales customer allocation could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SalesCustomerAllocation getSalesCustomerAllocationByUuidAndCompanyId(
			String uuid, long companyId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SalesCustomerAllocation> getSalesCustomerAllocations(
		int start, int end);

	/**
	 * Returns the number of sales customer allocations.
	 *
	 * @return the number of sales customer allocations
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSalesCustomerAllocationsCount();

	/**
	 * @param year
	 * @param commodity
	 * @param userId
	 * @param start
	 * @param end
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SalesCustomerAllocation> search(
		int year, String commodity, long salesCustomerCode, int start, int end);

	/**
	 * @param year
	 * @param commodity
	 * @param userId
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int searchCount(int year, String commodity, long salesCustomerCode);

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
	@Indexable(type = IndexableType.REINDEX)
	public SalesCustomerAllocation updateSalesCustomerAllocation(
		SalesCustomerAllocation salesCustomerAllocation);

}