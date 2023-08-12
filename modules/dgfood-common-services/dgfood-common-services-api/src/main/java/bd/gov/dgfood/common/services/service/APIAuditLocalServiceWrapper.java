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
 * Provides a wrapper for {@link APIAuditLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see APIAuditLocalService
 * @generated
 */
public class APIAuditLocalServiceWrapper
	implements APIAuditLocalService, ServiceWrapper<APIAuditLocalService> {

	public APIAuditLocalServiceWrapper() {
		this(null);
	}

	public APIAuditLocalServiceWrapper(
		APIAuditLocalService apiAuditLocalService) {

		_apiAuditLocalService = apiAuditLocalService;
	}

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
	@Override
	public bd.gov.dgfood.common.services.model.APIAudit addAPIAudit(
		bd.gov.dgfood.common.services.model.APIAudit apiAudit) {

		return _apiAuditLocalService.addAPIAudit(apiAudit);
	}

	/**
	 * Creates a new api audit with the primary key. Does not add the api audit to the database.
	 *
	 * @param apiAuditId the primary key for the new api audit
	 * @return the new api audit
	 */
	@Override
	public bd.gov.dgfood.common.services.model.APIAudit createAPIAudit(
		long apiAuditId) {

		return _apiAuditLocalService.createAPIAudit(apiAuditId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _apiAuditLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public bd.gov.dgfood.common.services.model.APIAudit deleteAPIAudit(
		bd.gov.dgfood.common.services.model.APIAudit apiAudit) {

		return _apiAuditLocalService.deleteAPIAudit(apiAudit);
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
	@Override
	public bd.gov.dgfood.common.services.model.APIAudit deleteAPIAudit(
			long apiAuditId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _apiAuditLocalService.deleteAPIAudit(apiAuditId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _apiAuditLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _apiAuditLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _apiAuditLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _apiAuditLocalService.dynamicQuery();
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

		return _apiAuditLocalService.dynamicQuery(dynamicQuery);
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
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _apiAuditLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _apiAuditLocalService.dynamicQuery(
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

		return _apiAuditLocalService.dynamicQueryCount(dynamicQuery);
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

		return _apiAuditLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.common.services.model.APIAudit fetchAPIAudit(
		long apiAuditId) {

		return _apiAuditLocalService.fetchAPIAudit(apiAuditId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _apiAuditLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the api audit with the primary key.
	 *
	 * @param apiAuditId the primary key of the api audit
	 * @return the api audit
	 * @throws PortalException if a api audit with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.common.services.model.APIAudit getAPIAudit(
			long apiAuditId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _apiAuditLocalService.getAPIAudit(apiAuditId);
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
	public java.util.List<bd.gov.dgfood.common.services.model.APIAudit>
		getAPIAudits(int start, int end) {

		return _apiAuditLocalService.getAPIAudits(start, end);
	}

	/**
	 * Returns the number of api audits.
	 *
	 * @return the number of api audits
	 */
	@Override
	public int getAPIAuditsCount() {
		return _apiAuditLocalService.getAPIAuditsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _apiAuditLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _apiAuditLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _apiAuditLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public bd.gov.dgfood.common.services.model.APIAudit updateAPIAudit(
		bd.gov.dgfood.common.services.model.APIAudit apiAudit) {

		return _apiAuditLocalService.updateAPIAudit(apiAudit);
	}

	@Override
	public bd.gov.dgfood.common.services.model.APIAudit updateApiAuditData(
		String title, String description, String sender, String receiver,
		String requestPayload, String responsePayload, String requestClassName,
		long requestClassPK, boolean bulkRequest, java.util.Date requestTime,
		java.util.Date responseTime, long userId) {

		return _apiAuditLocalService.updateApiAuditData(
			title, description, sender, receiver, requestPayload,
			responsePayload, requestClassName, requestClassPK, bulkRequest,
			requestTime, responseTime, userId);
	}

	@Override
	public APIAuditLocalService getWrappedService() {
		return _apiAuditLocalService;
	}

	@Override
	public void setWrappedService(APIAuditLocalService apiAuditLocalService) {
		_apiAuditLocalService = apiAuditLocalService;
	}

	private APIAuditLocalService _apiAuditLocalService;

}