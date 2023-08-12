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

package bd.gov.dgfood.common.services.service.base;

import bd.gov.dgfood.common.services.model.APIAudit;
import bd.gov.dgfood.common.services.service.APIAuditLocalService;
import bd.gov.dgfood.common.services.service.APIAuditLocalServiceUtil;
import bd.gov.dgfood.common.services.service.persistence.APIAuditPersistence;
import bd.gov.dgfood.common.services.service.persistence.AddressPersistence;
import bd.gov.dgfood.common.services.service.persistence.AddressVersionPersistence;
import bd.gov.dgfood.common.services.service.persistence.AttachmentPersistence;
import bd.gov.dgfood.common.services.service.persistence.AttachmentVersionPersistence;
import bd.gov.dgfood.common.services.service.persistence.BankAccountInformationPersistence;
import bd.gov.dgfood.common.services.service.persistence.DGFUsersPersistence;
import bd.gov.dgfood.common.services.service.persistence.DeliveryOrderPersistence;
import bd.gov.dgfood.common.services.service.persistence.GrievancePersistence;
import bd.gov.dgfood.common.services.service.persistence.IndentPersistence;
import bd.gov.dgfood.common.services.service.persistence.MDMSyncStatusPersistence;
import bd.gov.dgfood.common.services.service.persistence.UserDetailsPersistence;
import bd.gov.dgfood.common.services.service.persistence.UserLocationPersistence;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the api audit local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link bd.gov.dgfood.common.services.service.impl.APIAuditLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see bd.gov.dgfood.common.services.service.impl.APIAuditLocalServiceImpl
 * @generated
 */
public abstract class APIAuditLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, APIAuditLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>APIAuditLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>APIAuditLocalServiceUtil</code>.
	 */

	/**
	 * Adds the api audit to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect APIAuditLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param apiAudit the api audit
	 * @return the api audit that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public APIAudit addAPIAudit(APIAudit apiAudit) {
		apiAudit.setNew(true);

		return apiAuditPersistence.update(apiAudit);
	}

	/**
	 * Creates a new api audit with the primary key. Does not add the api audit to the database.
	 *
	 * @param apiAuditId the primary key for the new api audit
	 * @return the new api audit
	 */
	@Override
	@Transactional(enabled = false)
	public APIAudit createAPIAudit(long apiAuditId) {
		return apiAuditPersistence.create(apiAuditId);
	}

	/**
	 * Deletes the api audit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect APIAuditLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param apiAuditId the primary key of the api audit
	 * @return the api audit that was removed
	 * @throws PortalException if a api audit with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public APIAudit deleteAPIAudit(long apiAuditId) throws PortalException {
		return apiAuditPersistence.remove(apiAuditId);
	}

	/**
	 * Deletes the api audit from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect APIAuditLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param apiAudit the api audit
	 * @return the api audit that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public APIAudit deleteAPIAudit(APIAudit apiAudit) {
		return apiAuditPersistence.remove(apiAudit);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return apiAuditPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			APIAudit.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return apiAuditPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.APIAuditModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return apiAuditPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.APIAuditModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return apiAuditPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return apiAuditPersistence.countWithDynamicQuery(dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return apiAuditPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public APIAudit fetchAPIAudit(long apiAuditId) {
		return apiAuditPersistence.fetchByPrimaryKey(apiAuditId);
	}

	/**
	 * Returns the api audit with the primary key.
	 *
	 * @param apiAuditId the primary key of the api audit
	 * @return the api audit
	 * @throws PortalException if a api audit with the primary key could not be found
	 */
	@Override
	public APIAudit getAPIAudit(long apiAuditId) throws PortalException {
		return apiAuditPersistence.findByPrimaryKey(apiAuditId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(apiAuditLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(APIAudit.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("apiAuditId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			apiAuditLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(APIAudit.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("apiAuditId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(apiAuditLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(APIAudit.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("apiAuditId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return apiAuditPersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return apiAuditLocalService.deleteAPIAudit((APIAudit)persistedModel);
	}

	@Override
	public BasePersistence<APIAudit> getBasePersistence() {
		return apiAuditPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return apiAuditPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the api audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.APIAuditModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of api audits
	 * @param end the upper bound of the range of api audits (not inclusive)
	 * @return the range of api audits
	 */
	@Override
	public List<APIAudit> getAPIAudits(int start, int end) {
		return apiAuditPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of api audits.
	 *
	 * @return the number of api audits
	 */
	@Override
	public int getAPIAuditsCount() {
		return apiAuditPersistence.countAll();
	}

	/**
	 * Updates the api audit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect APIAuditLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param apiAudit the api audit
	 * @return the api audit that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public APIAudit updateAPIAudit(APIAudit apiAudit) {
		return apiAuditPersistence.update(apiAudit);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			APIAuditLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		apiAuditLocalService = (APIAuditLocalService)aopProxy;

		_setLocalServiceUtilService(apiAuditLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return APIAuditLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return APIAudit.class;
	}

	protected String getModelClassName() {
		return APIAudit.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = apiAuditPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		APIAuditLocalService apiAuditLocalService) {

		try {
			Field field = APIAuditLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, apiAuditLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected AddressPersistence addressPersistence;

	@Reference
	protected AddressVersionPersistence addressVersionPersistence;

	protected APIAuditLocalService apiAuditLocalService;

	@Reference
	protected APIAuditPersistence apiAuditPersistence;

	@Reference
	protected AttachmentPersistence attachmentPersistence;

	@Reference
	protected AttachmentVersionPersistence attachmentVersionPersistence;

	@Reference
	protected BankAccountInformationPersistence
		bankAccountInformationPersistence;

	@Reference
	protected DeliveryOrderPersistence deliveryOrderPersistence;

	@Reference
	protected DGFUsersPersistence dgfUsersPersistence;

	@Reference
	protected GrievancePersistence grievancePersistence;

	@Reference
	protected IndentPersistence indentPersistence;

	@Reference
	protected MDMSyncStatusPersistence mdmSyncStatusPersistence;

	@Reference
	protected UserDetailsPersistence userDetailsPersistence;

	@Reference
	protected UserLocationPersistence userLocationPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}