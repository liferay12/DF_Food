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
 * Provides a wrapper for {@link AttachmentVersionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentVersionLocalService
 * @generated
 */
public class AttachmentVersionLocalServiceWrapper
	implements AttachmentVersionLocalService,
			   ServiceWrapper<AttachmentVersionLocalService> {

	public AttachmentVersionLocalServiceWrapper() {
		this(null);
	}

	public AttachmentVersionLocalServiceWrapper(
		AttachmentVersionLocalService attachmentVersionLocalService) {

		_attachmentVersionLocalService = attachmentVersionLocalService;
	}

	/**
	 * Adds the attachment version to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AttachmentVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param attachmentVersion the attachment version
	 * @return the attachment version that was added
	 */
	@Override
	public bd.gov.dgfood.common.services.model.AttachmentVersion
		addAttachmentVersion(
			bd.gov.dgfood.common.services.model.AttachmentVersion
				attachmentVersion) {

		return _attachmentVersionLocalService.addAttachmentVersion(
			attachmentVersion);
	}

	@Override
	public bd.gov.dgfood.common.services.model.AttachmentVersion
			addAttachmentVersion(
				long fileEntryId, String title, String category,
				java.util.Map<String, java.io.Serializable> metadata,
				String className, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _attachmentVersionLocalService.addAttachmentVersion(
			fileEntryId, title, category, metadata, className, classPK);
	}

	/**
	 * Creates a new attachment version with the primary key. Does not add the attachment version to the database.
	 *
	 * @param attachmentVersionId the primary key for the new attachment version
	 * @return the new attachment version
	 */
	@Override
	public bd.gov.dgfood.common.services.model.AttachmentVersion
		createAttachmentVersion(long attachmentVersionId) {

		return _attachmentVersionLocalService.createAttachmentVersion(
			attachmentVersionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _attachmentVersionLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the attachment version from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AttachmentVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param attachmentVersion the attachment version
	 * @return the attachment version that was removed
	 */
	@Override
	public bd.gov.dgfood.common.services.model.AttachmentVersion
		deleteAttachmentVersion(
			bd.gov.dgfood.common.services.model.AttachmentVersion
				attachmentVersion) {

		return _attachmentVersionLocalService.deleteAttachmentVersion(
			attachmentVersion);
	}

	/**
	 * Deletes the attachment version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AttachmentVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param attachmentVersionId the primary key of the attachment version
	 * @return the attachment version that was removed
	 * @throws PortalException if a attachment version with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.common.services.model.AttachmentVersion
			deleteAttachmentVersion(long attachmentVersionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _attachmentVersionLocalService.deleteAttachmentVersion(
			attachmentVersionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _attachmentVersionLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _attachmentVersionLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _attachmentVersionLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _attachmentVersionLocalService.dynamicQuery();
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

		return _attachmentVersionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.AttachmentVersionModelImpl</code>.
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

		return _attachmentVersionLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.AttachmentVersionModelImpl</code>.
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

		return _attachmentVersionLocalService.dynamicQuery(
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

		return _attachmentVersionLocalService.dynamicQueryCount(dynamicQuery);
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

		return _attachmentVersionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.common.services.model.AttachmentVersion
		fetchAttachmentVersion(long attachmentVersionId) {

		return _attachmentVersionLocalService.fetchAttachmentVersion(
			attachmentVersionId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _attachmentVersionLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the attachment version with the primary key.
	 *
	 * @param attachmentVersionId the primary key of the attachment version
	 * @return the attachment version
	 * @throws PortalException if a attachment version with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.common.services.model.AttachmentVersion
			getAttachmentVersion(long attachmentVersionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _attachmentVersionLocalService.getAttachmentVersion(
			attachmentVersionId);
	}

	/**
	 * Returns a range of all the attachment versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.AttachmentVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attachment versions
	 * @param end the upper bound of the range of attachment versions (not inclusive)
	 * @return the range of attachment versions
	 */
	@Override
	public java.util.List<bd.gov.dgfood.common.services.model.AttachmentVersion>
		getAttachmentVersions(int start, int end) {

		return _attachmentVersionLocalService.getAttachmentVersions(start, end);
	}

	@Override
	public java.util.List<bd.gov.dgfood.common.services.model.AttachmentVersion>
		getAttachmentVersionsByClassPKAndClassName(
			long classPK, String className) {

		return _attachmentVersionLocalService.
			getAttachmentVersionsByClassPKAndClassName(classPK, className);
	}

	/**
	 * Returns the number of attachment versions.
	 *
	 * @return the number of attachment versions
	 */
	@Override
	public int getAttachmentVersionsCount() {
		return _attachmentVersionLocalService.getAttachmentVersionsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _attachmentVersionLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _attachmentVersionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _attachmentVersionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the attachment version in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AttachmentVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param attachmentVersion the attachment version
	 * @return the attachment version that was updated
	 */
	@Override
	public bd.gov.dgfood.common.services.model.AttachmentVersion
		updateAttachmentVersion(
			bd.gov.dgfood.common.services.model.AttachmentVersion
				attachmentVersion) {

		return _attachmentVersionLocalService.updateAttachmentVersion(
			attachmentVersion);
	}

	@Override
	public AttachmentVersionLocalService getWrappedService() {
		return _attachmentVersionLocalService;
	}

	@Override
	public void setWrappedService(
		AttachmentVersionLocalService attachmentVersionLocalService) {

		_attachmentVersionLocalService = attachmentVersionLocalService;
	}

	private AttachmentVersionLocalService _attachmentVersionLocalService;

}