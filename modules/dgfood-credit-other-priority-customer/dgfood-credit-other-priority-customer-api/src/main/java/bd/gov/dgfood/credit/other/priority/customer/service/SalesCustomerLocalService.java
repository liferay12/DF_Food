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

import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer;
import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerVersion;

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
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for SalesCustomer. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see SalesCustomerLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface SalesCustomerLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>bd.gov.dgfood.credit.other.priority.customer.service.impl.SalesCustomerLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the sales customer local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link SalesCustomerLocalServiceUtil} if injection and service tracking are not available.
	 */

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
	public SalesCustomer addCustomer(
			long createdBy, String userType, String mobileNumber,
			String emailAddress, String title, String contactPersonName,
			String contactPersonDesignation, String officeName,
			String organizationName, String organizationType, int gender,
			long officeRegion, long officeDistrict, long officeUpazilla,
			long officeCityCorporationOrMunicipality, long officeUnionOrWard,
			String officevillageOrRoad, String officeMouzaOrMoholla,
			long officeZipCode, String officePostOffice, String address,
			ServiceContext serviceContext)
		throws PortalException;

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
	@Indexable(type = IndexableType.REINDEX)
	public SalesCustomer addSalesCustomer(SalesCustomer salesCustomer);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new sales customer with the primary key. Does not add the sales customer to the database.
	 *
	 * @param salesCustomerId the primary key for the new sales customer
	 * @return the new sales customer
	 */
	@Transactional(enabled = false)
	public SalesCustomer createSalesCustomer(long salesCustomerId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public SalesCustomer deleteSalesCustomer(long salesCustomerId)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public SalesCustomer deleteSalesCustomer(SalesCustomer salesCustomer);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.credit.other.priority.customer.model.impl.SalesCustomerModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.credit.other.priority.customer.model.impl.SalesCustomerModelImpl</code>.
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
	public SalesCustomer fetchSalesCustomer(long salesCustomerId);

	/**
	 * Returns the sales customer matching the UUID and group.
	 *
	 * @param uuid the sales customer's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sales customer, or <code>null</code> if a matching sales customer could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SalesCustomer fetchSalesCustomerByUuidAndGroupId(
		String uuid, long groupId);

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
	 * Returns the sales customer with the primary key.
	 *
	 * @param salesCustomerId the primary key of the sales customer
	 * @return the sales customer
	 * @throws PortalException if a sales customer with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SalesCustomer getSalesCustomer(long salesCustomerId)
		throws PortalException;

	/**
	 * @param userId
	 * @return
	 * @throws NoSuchSalesCustomerException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SalesCustomer getSalesCustomerByUserId(long userId);

	/**
	 * Returns the sales customer matching the UUID and group.
	 *
	 * @param uuid the sales customer's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sales customer
	 * @throws PortalException if a matching sales customer could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SalesCustomer getSalesCustomerByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SalesCustomer> getSalesCustomers(int start, int end);

	/**
	 * Returns all the sales customers matching the UUID and company.
	 *
	 * @param uuid the UUID of the sales customers
	 * @param companyId the primary key of the company
	 * @return the matching sales customers, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SalesCustomer> getSalesCustomersByUuidAndCompanyId(
		String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SalesCustomer> getSalesCustomersByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SalesCustomer> orderByComparator);

	/**
	 * Returns the number of sales customers.
	 *
	 * @return the number of sales customers
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSalesCustomersCount();

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SalesCustomer> search(
			Date fromDate, Date toDate, int status, String userType,
			String organizationName, int start, int end,
			LinkedHashMap<String, Object> params)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Hits search(
			long companyId, long fromDate, long toDate, int status,
			String userType, String organizationName, int start, int end,
			LinkedHashMap<String, Object> params)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int searchCount(
			Date fromDate, Date toDate, int status, String userType,
			String organizationName, int start, int end,
			LinkedHashMap<String, Object> params)
		throws PortalException;

	/**
	 * @param salesCustomerVersion
	 * @return
	 * @throws PortalException
	 */
	public SalesCustomer update(SalesCustomerVersion salesCustomerVersion)
		throws PortalException;

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
	@Indexable(type = IndexableType.REINDEX)
	public SalesCustomer updateSalesCustomer(SalesCustomer salesCustomer);

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
	public SalesCustomer updateStatus(
			long approverId, long customerId, int status,
			ServiceContext serviceContext)
		throws PortalException, SystemException;

}