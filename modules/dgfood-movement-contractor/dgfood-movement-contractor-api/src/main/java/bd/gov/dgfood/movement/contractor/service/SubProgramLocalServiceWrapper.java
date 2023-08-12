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

package bd.gov.dgfood.movement.contractor.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SubProgramLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SubProgramLocalService
 * @generated
 */
public class SubProgramLocalServiceWrapper
	implements ServiceWrapper<SubProgramLocalService>, SubProgramLocalService {

	public SubProgramLocalServiceWrapper() {
		this(null);
	}

	public SubProgramLocalServiceWrapper(
		SubProgramLocalService subProgramLocalService) {

		_subProgramLocalService = subProgramLocalService;
	}

	/**
	 * Adds the sub program to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubProgramLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subProgram the sub program
	 * @return the sub program that was added
	 */
	@Override
	public bd.gov.dgfood.movement.contractor.model.SubProgram addSubProgram(
		bd.gov.dgfood.movement.contractor.model.SubProgram subProgram) {

		return _subProgramLocalService.addSubProgram(subProgram);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subProgramLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new sub program with the primary key. Does not add the sub program to the database.
	 *
	 * @param subProgramId the primary key for the new sub program
	 * @return the new sub program
	 */
	@Override
	public bd.gov.dgfood.movement.contractor.model.SubProgram createSubProgram(
		long subProgramId) {

		return _subProgramLocalService.createSubProgram(subProgramId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subProgramLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the sub program with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubProgramLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subProgramId the primary key of the sub program
	 * @return the sub program that was removed
	 * @throws PortalException if a sub program with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.movement.contractor.model.SubProgram deleteSubProgram(
			long subProgramId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subProgramLocalService.deleteSubProgram(subProgramId);
	}

	/**
	 * Deletes the sub program from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubProgramLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subProgram the sub program
	 * @return the sub program that was removed
	 */
	@Override
	public bd.gov.dgfood.movement.contractor.model.SubProgram deleteSubProgram(
		bd.gov.dgfood.movement.contractor.model.SubProgram subProgram) {

		return _subProgramLocalService.deleteSubProgram(subProgram);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _subProgramLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _subProgramLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _subProgramLocalService.dynamicQuery();
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

		return _subProgramLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.movement.contractor.model.impl.SubProgramModelImpl</code>.
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

		return _subProgramLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.movement.contractor.model.impl.SubProgramModelImpl</code>.
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

		return _subProgramLocalService.dynamicQuery(
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

		return _subProgramLocalService.dynamicQueryCount(dynamicQuery);
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

		return _subProgramLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.movement.contractor.model.SubProgram fetchSubProgram(
		long subProgramId) {

		return _subProgramLocalService.fetchSubProgram(subProgramId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _subProgramLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _subProgramLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _subProgramLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subProgramLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the sub program with the primary key.
	 *
	 * @param subProgramId the primary key of the sub program
	 * @return the sub program
	 * @throws PortalException if a sub program with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.movement.contractor.model.SubProgram getSubProgram(
			long subProgramId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subProgramLocalService.getSubProgram(subProgramId);
	}

	/**
	 * Returns a range of all the sub programs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.movement.contractor.model.impl.SubProgramModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sub programs
	 * @param end the upper bound of the range of sub programs (not inclusive)
	 * @return the range of sub programs
	 */
	@Override
	public java.util.List<bd.gov.dgfood.movement.contractor.model.SubProgram>
		getSubPrograms(int start, int end) {

		return _subProgramLocalService.getSubPrograms(start, end);
	}

	/**
	 * Returns the number of sub programs.
	 *
	 * @return the number of sub programs
	 */
	@Override
	public int getSubProgramsCount() {
		return _subProgramLocalService.getSubProgramsCount();
	}

	/**
	 * Updates the sub program in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubProgramLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subProgram the sub program
	 * @return the sub program that was updated
	 */
	@Override
	public bd.gov.dgfood.movement.contractor.model.SubProgram updateSubProgram(
		bd.gov.dgfood.movement.contractor.model.SubProgram subProgram) {

		return _subProgramLocalService.updateSubProgram(subProgram);
	}

	@Override
	public SubProgramLocalService getWrappedService() {
		return _subProgramLocalService;
	}

	@Override
	public void setWrappedService(
		SubProgramLocalService subProgramLocalService) {

		_subProgramLocalService = subProgramLocalService;
	}

	private SubProgramLocalService _subProgramLocalService;

}