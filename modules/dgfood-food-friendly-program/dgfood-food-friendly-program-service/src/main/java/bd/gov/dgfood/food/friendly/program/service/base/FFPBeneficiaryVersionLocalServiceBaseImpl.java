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

package bd.gov.dgfood.food.friendly.program.service.base;

import bd.gov.dgfood.food.friendly.program.model.FFPBeneficiaryVersion;
import bd.gov.dgfood.food.friendly.program.service.FFPBeneficiaryVersionLocalService;
import bd.gov.dgfood.food.friendly.program.service.FFPBeneficiaryVersionLocalServiceUtil;
import bd.gov.dgfood.food.friendly.program.service.persistence.FFPBeneficiaryPersistence;
import bd.gov.dgfood.food.friendly.program.service.persistence.FFPBeneficiaryVersionPersistence;

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
 * Provides the base implementation for the ffp beneficiary version local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link bd.gov.dgfood.food.friendly.program.service.impl.FFPBeneficiaryVersionLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see bd.gov.dgfood.food.friendly.program.service.impl.FFPBeneficiaryVersionLocalServiceImpl
 * @generated
 */
public abstract class FFPBeneficiaryVersionLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, FFPBeneficiaryVersionLocalService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>FFPBeneficiaryVersionLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>FFPBeneficiaryVersionLocalServiceUtil</code>.
	 */

	/**
	 * Adds the ffp beneficiary version to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FFPBeneficiaryVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ffpBeneficiaryVersion the ffp beneficiary version
	 * @return the ffp beneficiary version that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public FFPBeneficiaryVersion addFFPBeneficiaryVersion(
		FFPBeneficiaryVersion ffpBeneficiaryVersion) {

		ffpBeneficiaryVersion.setNew(true);

		return ffpBeneficiaryVersionPersistence.update(ffpBeneficiaryVersion);
	}

	/**
	 * Creates a new ffp beneficiary version with the primary key. Does not add the ffp beneficiary version to the database.
	 *
	 * @param beneficiaryVersionId the primary key for the new ffp beneficiary version
	 * @return the new ffp beneficiary version
	 */
	@Override
	@Transactional(enabled = false)
	public FFPBeneficiaryVersion createFFPBeneficiaryVersion(
		long beneficiaryVersionId) {

		return ffpBeneficiaryVersionPersistence.create(beneficiaryVersionId);
	}

	/**
	 * Deletes the ffp beneficiary version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FFPBeneficiaryVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param beneficiaryVersionId the primary key of the ffp beneficiary version
	 * @return the ffp beneficiary version that was removed
	 * @throws PortalException if a ffp beneficiary version with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public FFPBeneficiaryVersion deleteFFPBeneficiaryVersion(
			long beneficiaryVersionId)
		throws PortalException {

		return ffpBeneficiaryVersionPersistence.remove(beneficiaryVersionId);
	}

	/**
	 * Deletes the ffp beneficiary version from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FFPBeneficiaryVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ffpBeneficiaryVersion the ffp beneficiary version
	 * @return the ffp beneficiary version that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public FFPBeneficiaryVersion deleteFFPBeneficiaryVersion(
		FFPBeneficiaryVersion ffpBeneficiaryVersion) {

		return ffpBeneficiaryVersionPersistence.remove(ffpBeneficiaryVersion);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return ffpBeneficiaryVersionPersistence.dslQuery(dslQuery);
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
			FFPBeneficiaryVersion.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return ffpBeneficiaryVersionPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.friendly.program.model.impl.FFPBeneficiaryVersionModelImpl</code>.
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

		return ffpBeneficiaryVersionPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.friendly.program.model.impl.FFPBeneficiaryVersionModelImpl</code>.
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

		return ffpBeneficiaryVersionPersistence.findWithDynamicQuery(
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
		return ffpBeneficiaryVersionPersistence.countWithDynamicQuery(
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
		DynamicQuery dynamicQuery, Projection projection) {

		return ffpBeneficiaryVersionPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public FFPBeneficiaryVersion fetchFFPBeneficiaryVersion(
		long beneficiaryVersionId) {

		return ffpBeneficiaryVersionPersistence.fetchByPrimaryKey(
			beneficiaryVersionId);
	}

	/**
	 * Returns the ffp beneficiary version with the primary key.
	 *
	 * @param beneficiaryVersionId the primary key of the ffp beneficiary version
	 * @return the ffp beneficiary version
	 * @throws PortalException if a ffp beneficiary version with the primary key could not be found
	 */
	@Override
	public FFPBeneficiaryVersion getFFPBeneficiaryVersion(
			long beneficiaryVersionId)
		throws PortalException {

		return ffpBeneficiaryVersionPersistence.findByPrimaryKey(
			beneficiaryVersionId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			ffpBeneficiaryVersionLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(FFPBeneficiaryVersion.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"beneficiaryVersionId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			ffpBeneficiaryVersionLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			FFPBeneficiaryVersion.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"beneficiaryVersionId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			ffpBeneficiaryVersionLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(FFPBeneficiaryVersion.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"beneficiaryVersionId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return ffpBeneficiaryVersionPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return ffpBeneficiaryVersionLocalService.deleteFFPBeneficiaryVersion(
			(FFPBeneficiaryVersion)persistedModel);
	}

	@Override
	public BasePersistence<FFPBeneficiaryVersion> getBasePersistence() {
		return ffpBeneficiaryVersionPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return ffpBeneficiaryVersionPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the ffp beneficiary versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.friendly.program.model.impl.FFPBeneficiaryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ffp beneficiary versions
	 * @param end the upper bound of the range of ffp beneficiary versions (not inclusive)
	 * @return the range of ffp beneficiary versions
	 */
	@Override
	public List<FFPBeneficiaryVersion> getFFPBeneficiaryVersions(
		int start, int end) {

		return ffpBeneficiaryVersionPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of ffp beneficiary versions.
	 *
	 * @return the number of ffp beneficiary versions
	 */
	@Override
	public int getFFPBeneficiaryVersionsCount() {
		return ffpBeneficiaryVersionPersistence.countAll();
	}

	/**
	 * Updates the ffp beneficiary version in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FFPBeneficiaryVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ffpBeneficiaryVersion the ffp beneficiary version
	 * @return the ffp beneficiary version that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public FFPBeneficiaryVersion updateFFPBeneficiaryVersion(
		FFPBeneficiaryVersion ffpBeneficiaryVersion) {

		return ffpBeneficiaryVersionPersistence.update(ffpBeneficiaryVersion);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			FFPBeneficiaryVersionLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		ffpBeneficiaryVersionLocalService =
			(FFPBeneficiaryVersionLocalService)aopProxy;

		_setLocalServiceUtilService(ffpBeneficiaryVersionLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return FFPBeneficiaryVersionLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return FFPBeneficiaryVersion.class;
	}

	protected String getModelClassName() {
		return FFPBeneficiaryVersion.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				ffpBeneficiaryVersionPersistence.getDataSource();

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
		FFPBeneficiaryVersionLocalService ffpBeneficiaryVersionLocalService) {

		try {
			Field field =
				FFPBeneficiaryVersionLocalServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, ffpBeneficiaryVersionLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected FFPBeneficiaryPersistence ffpBeneficiaryPersistence;

	protected FFPBeneficiaryVersionLocalService
		ffpBeneficiaryVersionLocalService;

	@Reference
	protected FFPBeneficiaryVersionPersistence ffpBeneficiaryVersionPersistence;

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

	@Reference
	protected com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalService
		workflowInstanceLinkLocalService;

}