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

import bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary;
import bd.gov.dgfood.food.friendly.program.service.FFPBeneficiaryLocalService;
import bd.gov.dgfood.food.friendly.program.service.FFPBeneficiaryLocalServiceUtil;
import bd.gov.dgfood.food.friendly.program.service.persistence.FFPBeneficiaryPersistence;
import bd.gov.dgfood.food.friendly.program.service.persistence.FFPBeneficiaryVersionPersistence;

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
 * Provides the base implementation for the ffp beneficiary local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link bd.gov.dgfood.food.friendly.program.service.impl.FFPBeneficiaryLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see bd.gov.dgfood.food.friendly.program.service.impl.FFPBeneficiaryLocalServiceImpl
 * @generated
 */
public abstract class FFPBeneficiaryLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, FFPBeneficiaryLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>FFPBeneficiaryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>FFPBeneficiaryLocalServiceUtil</code>.
	 */

	/**
	 * Adds the ffp beneficiary to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FFPBeneficiaryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ffpBeneficiary the ffp beneficiary
	 * @return the ffp beneficiary that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public FFPBeneficiary addFFPBeneficiary(FFPBeneficiary ffpBeneficiary) {
		ffpBeneficiary.setNew(true);

		return ffpBeneficiaryPersistence.update(ffpBeneficiary);
	}

	/**
	 * Creates a new ffp beneficiary with the primary key. Does not add the ffp beneficiary to the database.
	 *
	 * @param beneficiaryId the primary key for the new ffp beneficiary
	 * @return the new ffp beneficiary
	 */
	@Override
	@Transactional(enabled = false)
	public FFPBeneficiary createFFPBeneficiary(long beneficiaryId) {
		return ffpBeneficiaryPersistence.create(beneficiaryId);
	}

	/**
	 * Deletes the ffp beneficiary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FFPBeneficiaryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param beneficiaryId the primary key of the ffp beneficiary
	 * @return the ffp beneficiary that was removed
	 * @throws PortalException if a ffp beneficiary with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public FFPBeneficiary deleteFFPBeneficiary(long beneficiaryId)
		throws PortalException {

		return ffpBeneficiaryPersistence.remove(beneficiaryId);
	}

	/**
	 * Deletes the ffp beneficiary from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FFPBeneficiaryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ffpBeneficiary the ffp beneficiary
	 * @return the ffp beneficiary that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public FFPBeneficiary deleteFFPBeneficiary(FFPBeneficiary ffpBeneficiary) {
		return ffpBeneficiaryPersistence.remove(ffpBeneficiary);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return ffpBeneficiaryPersistence.dslQuery(dslQuery);
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
			FFPBeneficiary.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return ffpBeneficiaryPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.friendly.program.model.impl.FFPBeneficiaryModelImpl</code>.
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

		return ffpBeneficiaryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.friendly.program.model.impl.FFPBeneficiaryModelImpl</code>.
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

		return ffpBeneficiaryPersistence.findWithDynamicQuery(
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
		return ffpBeneficiaryPersistence.countWithDynamicQuery(dynamicQuery);
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

		return ffpBeneficiaryPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public FFPBeneficiary fetchFFPBeneficiary(long beneficiaryId) {
		return ffpBeneficiaryPersistence.fetchByPrimaryKey(beneficiaryId);
	}

	/**
	 * Returns the ffp beneficiary matching the UUID and group.
	 *
	 * @param uuid the ffp beneficiary's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	@Override
	public FFPBeneficiary fetchFFPBeneficiaryByUuidAndGroupId(
		String uuid, long groupId) {

		return ffpBeneficiaryPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the ffp beneficiary with the primary key.
	 *
	 * @param beneficiaryId the primary key of the ffp beneficiary
	 * @return the ffp beneficiary
	 * @throws PortalException if a ffp beneficiary with the primary key could not be found
	 */
	@Override
	public FFPBeneficiary getFFPBeneficiary(long beneficiaryId)
		throws PortalException {

		return ffpBeneficiaryPersistence.findByPrimaryKey(beneficiaryId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(ffpBeneficiaryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(FFPBeneficiary.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("beneficiaryId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			ffpBeneficiaryLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(FFPBeneficiary.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"beneficiaryId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(ffpBeneficiaryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(FFPBeneficiary.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("beneficiaryId");
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
			new ActionableDynamicQuery.PerformActionMethod<FFPBeneficiary>() {

				@Override
				public void performAction(FFPBeneficiary ffpBeneficiary)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, ffpBeneficiary);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(FFPBeneficiary.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return ffpBeneficiaryPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return ffpBeneficiaryLocalService.deleteFFPBeneficiary(
			(FFPBeneficiary)persistedModel);
	}

	@Override
	public BasePersistence<FFPBeneficiary> getBasePersistence() {
		return ffpBeneficiaryPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return ffpBeneficiaryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the ffp beneficiaries matching the UUID and company.
	 *
	 * @param uuid the UUID of the ffp beneficiaries
	 * @param companyId the primary key of the company
	 * @return the matching ffp beneficiaries, or an empty list if no matches were found
	 */
	@Override
	public List<FFPBeneficiary> getFFPBeneficiariesByUuidAndCompanyId(
		String uuid, long companyId) {

		return ffpBeneficiaryPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of ffp beneficiaries matching the UUID and company.
	 *
	 * @param uuid the UUID of the ffp beneficiaries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of ffp beneficiaries
	 * @param end the upper bound of the range of ffp beneficiaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching ffp beneficiaries, or an empty list if no matches were found
	 */
	@Override
	public List<FFPBeneficiary> getFFPBeneficiariesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FFPBeneficiary> orderByComparator) {

		return ffpBeneficiaryPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the ffp beneficiary matching the UUID and group.
	 *
	 * @param uuid the ffp beneficiary's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ffp beneficiary
	 * @throws PortalException if a matching ffp beneficiary could not be found
	 */
	@Override
	public FFPBeneficiary getFFPBeneficiaryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return ffpBeneficiaryPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the ffp beneficiaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.friendly.program.model.impl.FFPBeneficiaryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ffp beneficiaries
	 * @param end the upper bound of the range of ffp beneficiaries (not inclusive)
	 * @return the range of ffp beneficiaries
	 */
	@Override
	public List<FFPBeneficiary> getFFPBeneficiaries(int start, int end) {
		return ffpBeneficiaryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of ffp beneficiaries.
	 *
	 * @return the number of ffp beneficiaries
	 */
	@Override
	public int getFFPBeneficiariesCount() {
		return ffpBeneficiaryPersistence.countAll();
	}

	/**
	 * Updates the ffp beneficiary in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FFPBeneficiaryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ffpBeneficiary the ffp beneficiary
	 * @return the ffp beneficiary that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public FFPBeneficiary updateFFPBeneficiary(FFPBeneficiary ffpBeneficiary) {
		return ffpBeneficiaryPersistence.update(ffpBeneficiary);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			FFPBeneficiaryLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		ffpBeneficiaryLocalService = (FFPBeneficiaryLocalService)aopProxy;

		_setLocalServiceUtilService(ffpBeneficiaryLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return FFPBeneficiaryLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return FFPBeneficiary.class;
	}

	protected String getModelClassName() {
		return FFPBeneficiary.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = ffpBeneficiaryPersistence.getDataSource();

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
		FFPBeneficiaryLocalService ffpBeneficiaryLocalService) {

		try {
			Field field = FFPBeneficiaryLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, ffpBeneficiaryLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	protected FFPBeneficiaryLocalService ffpBeneficiaryLocalService;

	@Reference
	protected FFPBeneficiaryPersistence ffpBeneficiaryPersistence;

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

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetLinkLocalService
		assetLinkLocalService;

}