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
 * Provides a wrapper for {@link AddressVersionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AddressVersionLocalService
 * @generated
 */
public class AddressVersionLocalServiceWrapper
	implements AddressVersionLocalService,
			   ServiceWrapper<AddressVersionLocalService> {

	public AddressVersionLocalServiceWrapper() {
		this(null);
	}

	public AddressVersionLocalServiceWrapper(
		AddressVersionLocalService addressVersionLocalService) {

		_addressVersionLocalService = addressVersionLocalService;
	}

	/**
	 * Adds the address version to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AddressVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param addressVersion the address version
	 * @return the address version that was added
	 */
	@Override
	public bd.gov.dgfood.common.services.model.AddressVersion addAddressVersion(
		bd.gov.dgfood.common.services.model.AddressVersion addressVersion) {

		return _addressVersionLocalService.addAddressVersion(addressVersion);
	}

	/**
	 * @param region
	 * @param district
	 * @param upazilla
	 * @param cityCorporationOrMunicipality
	 * @param unionOrWard
	 * @param zipCode
	 * @param postOffice
	 * @param villageOrRoad
	 * @param mouzaOrMoholla
	 * @param homeAddress
	 * @param addressType
	 * @param className
	 * @param classPK
	 * @return
	 */
	@Override
	public bd.gov.dgfood.common.services.model.AddressVersion addAddressVersion(
		long region, long district, long upazilla,
		long cityCorporationOrMunicipality, long unionOrWard, long zipCode,
		String postOffice, String villageOrRoad, String mouzaOrMoholla,
		String homeAddress, String addressType, String className,
		long classPK) {

		return _addressVersionLocalService.addAddressVersion(
			region, district, upazilla, cityCorporationOrMunicipality,
			unionOrWard, zipCode, postOffice, villageOrRoad, mouzaOrMoholla,
			homeAddress, addressType, className, classPK);
	}

	/**
	 * Creates a new address version with the primary key. Does not add the address version to the database.
	 *
	 * @param addressVersionId the primary key for the new address version
	 * @return the new address version
	 */
	@Override
	public bd.gov.dgfood.common.services.model.AddressVersion
		createAddressVersion(long addressVersionId) {

		return _addressVersionLocalService.createAddressVersion(
			addressVersionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addressVersionLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the address version from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AddressVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param addressVersion the address version
	 * @return the address version that was removed
	 */
	@Override
	public bd.gov.dgfood.common.services.model.AddressVersion
		deleteAddressVersion(
			bd.gov.dgfood.common.services.model.AddressVersion addressVersion) {

		return _addressVersionLocalService.deleteAddressVersion(addressVersion);
	}

	/**
	 * Deletes the address version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AddressVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param addressVersionId the primary key of the address version
	 * @return the address version that was removed
	 * @throws PortalException if a address version with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.common.services.model.AddressVersion
			deleteAddressVersion(long addressVersionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addressVersionLocalService.deleteAddressVersion(
			addressVersionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addressVersionLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _addressVersionLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _addressVersionLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _addressVersionLocalService.dynamicQuery();
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

		return _addressVersionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.AddressVersionModelImpl</code>.
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

		return _addressVersionLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.AddressVersionModelImpl</code>.
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

		return _addressVersionLocalService.dynamicQuery(
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

		return _addressVersionLocalService.dynamicQueryCount(dynamicQuery);
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

		return _addressVersionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.common.services.model.AddressVersion
		fetchAddressVersion(long addressVersionId) {

		return _addressVersionLocalService.fetchAddressVersion(
			addressVersionId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _addressVersionLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the address version with the primary key.
	 *
	 * @param addressVersionId the primary key of the address version
	 * @return the address version
	 * @throws PortalException if a address version with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.common.services.model.AddressVersion getAddressVersion(
			long addressVersionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addressVersionLocalService.getAddressVersion(addressVersionId);
	}

	/**
	 * Returns a range of all the address versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.AddressVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of address versions
	 * @param end the upper bound of the range of address versions (not inclusive)
	 * @return the range of address versions
	 */
	@Override
	public java.util.List<bd.gov.dgfood.common.services.model.AddressVersion>
		getAddressVersions(int start, int end) {

		return _addressVersionLocalService.getAddressVersions(start, end);
	}

	@Override
	public java.util.List<bd.gov.dgfood.common.services.model.AddressVersion>
		getAddressVersionsByClassNameAndClassPK(
			long classPK, String className) {

		return _addressVersionLocalService.
			getAddressVersionsByClassNameAndClassPK(classPK, className);
	}

	/**
	 * Returns the number of address versions.
	 *
	 * @return the number of address versions
	 */
	@Override
	public int getAddressVersionsCount() {
		return _addressVersionLocalService.getAddressVersionsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _addressVersionLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _addressVersionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addressVersionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the address version in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AddressVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param addressVersion the address version
	 * @return the address version that was updated
	 */
	@Override
	public bd.gov.dgfood.common.services.model.AddressVersion
		updateAddressVersion(
			bd.gov.dgfood.common.services.model.AddressVersion addressVersion) {

		return _addressVersionLocalService.updateAddressVersion(addressVersion);
	}

	@Override
	public AddressVersionLocalService getWrappedService() {
		return _addressVersionLocalService;
	}

	@Override
	public void setWrappedService(
		AddressVersionLocalService addressVersionLocalService) {

		_addressVersionLocalService = addressVersionLocalService;
	}

	private AddressVersionLocalService _addressVersionLocalService;

}