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

import bd.gov.dgfood.common.services.model.Indent;
import bd.gov.dgfood.common.services.service.IndentLocalService;
import bd.gov.dgfood.common.services.service.IndentLocalServiceUtil;
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

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
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
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
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
 * Provides the base implementation for the indent local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link bd.gov.dgfood.common.services.service.impl.IndentLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see bd.gov.dgfood.common.services.service.impl.IndentLocalServiceImpl
 * @generated
 */
public abstract class IndentLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService, IndentLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>IndentLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>IndentLocalServiceUtil</code>.
	 */

	/**
	 * Adds the indent to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IndentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param indent the indent
	 * @return the indent that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Indent addIndent(Indent indent) {
		indent.setNew(true);

		return indentPersistence.update(indent);
	}

	/**
	 * Creates a new indent with the primary key. Does not add the indent to the database.
	 *
	 * @param indentId the primary key for the new indent
	 * @return the new indent
	 */
	@Override
	@Transactional(enabled = false)
	public Indent createIndent(long indentId) {
		return indentPersistence.create(indentId);
	}

	/**
	 * Deletes the indent with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IndentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param indentId the primary key of the indent
	 * @return the indent that was removed
	 * @throws PortalException if a indent with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Indent deleteIndent(long indentId) throws PortalException {
		return indentPersistence.remove(indentId);
	}

	/**
	 * Deletes the indent from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IndentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param indent the indent
	 * @return the indent that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Indent deleteIndent(Indent indent) {
		return indentPersistence.remove(indent);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return indentPersistence.dslQuery(dslQuery);
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
			Indent.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return indentPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.IndentModelImpl</code>.
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

		return indentPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.IndentModelImpl</code>.
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

		return indentPersistence.findWithDynamicQuery(
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
		return indentPersistence.countWithDynamicQuery(dynamicQuery);
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

		return indentPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public Indent fetchIndent(long indentId) {
		return indentPersistence.fetchByPrimaryKey(indentId);
	}

	/**
	 * Returns the indent matching the UUID and group.
	 *
	 * @param uuid the indent's UUID
	 * @param groupId the primary key of the group
	 * @return the matching indent, or <code>null</code> if a matching indent could not be found
	 */
	@Override
	public Indent fetchIndentByUuidAndGroupId(String uuid, long groupId) {
		return indentPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the indent with the primary key.
	 *
	 * @param indentId the primary key of the indent
	 * @return the indent
	 * @throws PortalException if a indent with the primary key could not be found
	 */
	@Override
	public Indent getIndent(long indentId) throws PortalException {
		return indentPersistence.findByPrimaryKey(indentId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(indentLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Indent.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("indentId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(indentLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Indent.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("indentId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(indentLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Indent.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("indentId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {

		final ExportActionableDynamicQuery exportActionableDynamicQuery =
			new ExportActionableDynamicQuery() {

				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary =
						portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(
						stagedModelType, modelAdditionCount);

					long modelDeletionCount =
						ExportImportHelperUtil.getModelDeletionCount(
							portletDataContext, stagedModelType);

					manifestSummary.addModelDeletionCount(
						stagedModelType, modelDeletionCount);

					return modelAdditionCount;
				}

			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(
						dynamicQuery, "modifiedDate");
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Indent>() {

				@Override
				public void performAction(Indent indent)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, indent);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(Indent.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return indentPersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return indentLocalService.deleteIndent((Indent)persistedModel);
	}

	@Override
	public BasePersistence<Indent> getBasePersistence() {
		return indentPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return indentPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the indents matching the UUID and company.
	 *
	 * @param uuid the UUID of the indents
	 * @param companyId the primary key of the company
	 * @return the matching indents, or an empty list if no matches were found
	 */
	@Override
	public List<Indent> getIndentsByUuidAndCompanyId(
		String uuid, long companyId) {

		return indentPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of indents matching the UUID and company.
	 *
	 * @param uuid the UUID of the indents
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of indents
	 * @param end the upper bound of the range of indents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching indents, or an empty list if no matches were found
	 */
	@Override
	public List<Indent> getIndentsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Indent> orderByComparator) {

		return indentPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the indent matching the UUID and group.
	 *
	 * @param uuid the indent's UUID
	 * @param groupId the primary key of the group
	 * @return the matching indent
	 * @throws PortalException if a matching indent could not be found
	 */
	@Override
	public Indent getIndentByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return indentPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the indents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.IndentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of indents
	 * @param end the upper bound of the range of indents (not inclusive)
	 * @return the range of indents
	 */
	@Override
	public List<Indent> getIndents(int start, int end) {
		return indentPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of indents.
	 *
	 * @return the number of indents
	 */
	@Override
	public int getIndentsCount() {
		return indentPersistence.countAll();
	}

	/**
	 * Updates the indent in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IndentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param indent the indent
	 * @return the indent that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Indent updateIndent(Indent indent) {
		return indentPersistence.update(indent);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			IndentLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		indentLocalService = (IndentLocalService)aopProxy;

		_setLocalServiceUtilService(indentLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return IndentLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Indent.class;
	}

	protected String getModelClassName() {
		return Indent.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = indentPersistence.getDataSource();

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
		IndentLocalService indentLocalService) {

		try {
			Field field = IndentLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, indentLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected AddressPersistence addressPersistence;

	@Reference
	protected AddressVersionPersistence addressVersionPersistence;

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

	protected IndentLocalService indentLocalService;

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