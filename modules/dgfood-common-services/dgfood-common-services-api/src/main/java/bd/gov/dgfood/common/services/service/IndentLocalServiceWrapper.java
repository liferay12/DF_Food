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

package bd.gov.dgfood.common.services.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link IndentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see IndentLocalService
 * @generated
 */
public class IndentLocalServiceWrapper
	implements IndentLocalService, ServiceWrapper<IndentLocalService> {

	public IndentLocalServiceWrapper() {
		this(null);
	}

	public IndentLocalServiceWrapper(IndentLocalService indentLocalService) {
		_indentLocalService = indentLocalService;
	}

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
	@Override
	public bd.gov.dgfood.common.services.model.Indent addIndent(
		bd.gov.dgfood.common.services.model.Indent indent) {

		return _indentLocalService.addIndent(indent);
	}

	@Override
	public bd.gov.dgfood.common.services.model.Indent addIndent(
			long allocationId, String className, double quantity,
			String quantityUnit, java.util.Date requiredDeliveryDate,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _indentLocalService.addIndent(
			allocationId, className, quantity, quantityUnit,
			requiredDeliveryDate, serviceContext);
	}

	/**
	 * Creates a new indent with the primary key. Does not add the indent to the database.
	 *
	 * @param indentId the primary key for the new indent
	 * @return the new indent
	 */
	@Override
	public bd.gov.dgfood.common.services.model.Indent createIndent(
		long indentId) {

		return _indentLocalService.createIndent(indentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _indentLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public bd.gov.dgfood.common.services.model.Indent deleteIndent(
		bd.gov.dgfood.common.services.model.Indent indent) {

		return _indentLocalService.deleteIndent(indent);
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
	@Override
	public bd.gov.dgfood.common.services.model.Indent deleteIndent(
			long indentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _indentLocalService.deleteIndent(indentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _indentLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _indentLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _indentLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _indentLocalService.dynamicQuery();
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

		return _indentLocalService.dynamicQuery(dynamicQuery);
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
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _indentLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _indentLocalService.dynamicQuery(
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

		return _indentLocalService.dynamicQueryCount(dynamicQuery);
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

		return _indentLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.common.services.model.Indent fetchIndent(
		long indentId) {

		return _indentLocalService.fetchIndent(indentId);
	}

	/**
	 * Returns the indent matching the UUID and group.
	 *
	 * @param uuid the indent's UUID
	 * @param groupId the primary key of the group
	 * @return the matching indent, or <code>null</code> if a matching indent could not be found
	 */
	@Override
	public bd.gov.dgfood.common.services.model.Indent
		fetchIndentByUuidAndGroupId(String uuid, long groupId) {

		return _indentLocalService.fetchIndentByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _indentLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _indentLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	/**
	 * Returns the indent with the primary key.
	 *
	 * @param indentId the primary key of the indent
	 * @return the indent
	 * @throws PortalException if a indent with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.common.services.model.Indent getIndent(long indentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _indentLocalService.getIndent(indentId);
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
	public bd.gov.dgfood.common.services.model.Indent getIndentByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _indentLocalService.getIndentByUuidAndGroupId(uuid, groupId);
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
	public java.util.List<bd.gov.dgfood.common.services.model.Indent>
		getIndents(int start, int end) {

		return _indentLocalService.getIndents(start, end);
	}

	@Override
	public java.util.List<bd.gov.dgfood.common.services.model.Indent>
		getIndents(long allocationId, int start, int end) {

		return _indentLocalService.getIndents(allocationId, start, end);
	}

	/**
	 * Returns all the indents matching the UUID and company.
	 *
	 * @param uuid the UUID of the indents
	 * @param companyId the primary key of the company
	 * @return the matching indents, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<bd.gov.dgfood.common.services.model.Indent>
		getIndentsByUuidAndCompanyId(String uuid, long companyId) {

		return _indentLocalService.getIndentsByUuidAndCompanyId(
			uuid, companyId);
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
	public java.util.List<bd.gov.dgfood.common.services.model.Indent>
		getIndentsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<bd.gov.dgfood.common.services.model.Indent>
					orderByComparator) {

		return _indentLocalService.getIndentsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of indents.
	 *
	 * @return the number of indents
	 */
	@Override
	public int getIndentsCount() {
		return _indentLocalService.getIndentsCount();
	}

	@Override
	public int getIndentsCount(long allocationId) {
		return _indentLocalService.getIndentsCount(allocationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _indentLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _indentLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _indentLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public bd.gov.dgfood.common.services.model.Indent updateIndent(
		bd.gov.dgfood.common.services.model.Indent indent) {

		return _indentLocalService.updateIndent(indent);
	}

	@Override
	public IndentLocalService getWrappedService() {
		return _indentLocalService;
	}

	@Override
	public void setWrappedService(IndentLocalService indentLocalService) {
		_indentLocalService = indentLocalService;
	}

	private IndentLocalService _indentLocalService;

}