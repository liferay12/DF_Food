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

package bd.gov.dgfood.farmer.information.management.system.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FarmerRegistrationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FarmerRegistrationLocalService
 * @generated
 */
public class FarmerRegistrationLocalServiceWrapper
	implements FarmerRegistrationLocalService,
			   ServiceWrapper<FarmerRegistrationLocalService> {

	public FarmerRegistrationLocalServiceWrapper() {
		this(null);
	}

	public FarmerRegistrationLocalServiceWrapper(
		FarmerRegistrationLocalService farmerRegistrationLocalService) {

		_farmerRegistrationLocalService = farmerRegistrationLocalService;
	}

	/**
	 * Adds the farmer registration to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FarmerRegistrationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param farmerRegistration the farmer registration
	 * @return the farmer registration that was added
	 */
	@Override
	public
		bd.gov.dgfood.farmer.information.management.system.model.
			FarmerRegistration addFarmerRegistration(
				bd.gov.dgfood.farmer.information.management.system.model.
					FarmerRegistration farmerRegistration) {

		return _farmerRegistrationLocalService.addFarmerRegistration(
			farmerRegistration);
	}

	/**
	 * It will add a new Farmer Registration record in the Farmer Registration
	 * master table
	 */
	@Override
	public
		bd.gov.dgfood.farmer.information.management.system.model.
			FarmerRegistration addFarmerRegistration(
				String nationalId, String emailAddress, String mobileNumber,
				java.util.Date dateOfBirth, String farmerName,
				String fatherName, String motherName, int gender,
				String krishiCardNumber, int maritalStatus,
				String cultivableLandSeason1Name,
				float cultivableLandSeason1Area,
				String cultivableLandSeason1Unit,
				String cultivableLandSeason2Name,
				float cultivableLandSeason2Area,
				String cultivableLandSeason2Unit,
				String cultivableLandSeason3Name,
				float cultivableLandSeason3Area,
				String cultivableLandSeason3Unit, String farmerCategory,
				String password, String remarks, long groupId,
				com.liferay.portal.kernel.service.ServiceContext
					serviceContext) {

		return _farmerRegistrationLocalService.addFarmerRegistration(
			nationalId, emailAddress, mobileNumber, dateOfBirth, farmerName,
			fatherName, motherName, gender, krishiCardNumber, maritalStatus,
			cultivableLandSeason1Name, cultivableLandSeason1Area,
			cultivableLandSeason1Unit, cultivableLandSeason2Name,
			cultivableLandSeason2Area, cultivableLandSeason2Unit,
			cultivableLandSeason3Name, cultivableLandSeason3Area,
			cultivableLandSeason3Unit, farmerCategory, password, remarks,
			groupId, serviceContext);
	}

	/**
	 * Stores Farmer registration Form data by creating Farmer Registration record
	 * along with addition records like Framer address data and attachments
	 *
	 * @throws DataValidationException
	 */
	@Override
	public
		bd.gov.dgfood.farmer.information.management.system.model.
			FarmerRegistration addFarmerRegistrationFormData(
					boolean isHeadlessRequest, String nationalId,
					String emailAddress, String mobileNumber,
					String dateOfBirth, String farmerName, String fatherName,
					String motherName, int gender, String krishiCardNumber,
					int maritalStatus, String cultivableLandSeason1Name,
					float cultivableLandSeason1Area,
					String cultivableLandSeason1Unit,
					String cultivableLandSeason2Name,
					float cultivableLandSeason2Area,
					String cultivableLandSeason2Unit,
					String cultivableLandSeason3Name,
					float cultivableLandSeason3Area,
					String cultivableLandSeason3Unit, String farmerCategory,
					String password, String remarks, long permanentRegion,
					long permanentZilla, long permanentUpazila,
					long permanentCityCorporationOrMunicipality,
					long permanentUnionOrWard, long permanentZipCode,
					String permanentPostOffice, String permanentVillageOrRoad,
					String permanentMouzaOrMoholla,
					String permanentHouseAddress, long presentRegion,
					long presentZilla, long presentUpazila,
					long presentCityCorporationOrMunicipality,
					long presentUnionOrWard, long presentZipCode,
					String presentPostOffice, String presentVillageOrRoad,
					String presentMouzaOrMoholla, String presentHouseAddress,
					com.liferay.portal.vulcan.multipart.BinaryFile
						profilePhotograph,
					com.liferay.portal.vulcan.multipart.BinaryFile krishiCard,
					long groupId,
					com.liferay.portal.kernel.service.ServiceContext
						serviceContext)
				throws com.liferay.portal.kernel.exception.PortalException {

		return _farmerRegistrationLocalService.addFarmerRegistrationFormData(
			isHeadlessRequest, nationalId, emailAddress, mobileNumber,
			dateOfBirth, farmerName, fatherName, motherName, gender,
			krishiCardNumber, maritalStatus, cultivableLandSeason1Name,
			cultivableLandSeason1Area, cultivableLandSeason1Unit,
			cultivableLandSeason2Name, cultivableLandSeason2Area,
			cultivableLandSeason2Unit, cultivableLandSeason3Name,
			cultivableLandSeason3Area, cultivableLandSeason3Unit,
			farmerCategory, password, remarks, permanentRegion, permanentZilla,
			permanentUpazila, permanentCityCorporationOrMunicipality,
			permanentUnionOrWard, permanentZipCode, permanentPostOffice,
			permanentVillageOrRoad, permanentMouzaOrMoholla,
			permanentHouseAddress, presentRegion, presentZilla, presentUpazila,
			presentCityCorporationOrMunicipality, presentUnionOrWard,
			presentZipCode, presentPostOffice, presentVillageOrRoad,
			presentMouzaOrMoholla, presentHouseAddress, profilePhotograph,
			krishiCard, groupId, serviceContext);
	}

	/**
	 * Creates a new farmer registration with the primary key. Does not add the farmer registration to the database.
	 *
	 * @param farmerRegistrationId the primary key for the new farmer registration
	 * @return the new farmer registration
	 */
	@Override
	public
		bd.gov.dgfood.farmer.information.management.system.model.
			FarmerRegistration createFarmerRegistration(
				long farmerRegistrationId) {

		return _farmerRegistrationLocalService.createFarmerRegistration(
			farmerRegistrationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _farmerRegistrationLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the farmer registration from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FarmerRegistrationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param farmerRegistration the farmer registration
	 * @return the farmer registration that was removed
	 */
	@Override
	public
		bd.gov.dgfood.farmer.information.management.system.model.
			FarmerRegistration deleteFarmerRegistration(
				bd.gov.dgfood.farmer.information.management.system.model.
					FarmerRegistration farmerRegistration) {

		return _farmerRegistrationLocalService.deleteFarmerRegistration(
			farmerRegistration);
	}

	/**
	 * Deletes the farmer registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FarmerRegistrationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param farmerRegistrationId the primary key of the farmer registration
	 * @return the farmer registration that was removed
	 * @throws PortalException if a farmer registration with the primary key could not be found
	 */
	@Override
	public
		bd.gov.dgfood.farmer.information.management.system.model.
			FarmerRegistration deleteFarmerRegistration(
					long farmerRegistrationId)
				throws com.liferay.portal.kernel.exception.PortalException {

		return _farmerRegistrationLocalService.deleteFarmerRegistration(
			farmerRegistrationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _farmerRegistrationLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _farmerRegistrationLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _farmerRegistrationLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _farmerRegistrationLocalService.dynamicQuery();
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

		return _farmerRegistrationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.farmer.information.management.system.model.impl.FarmerRegistrationModelImpl</code>.
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

		return _farmerRegistrationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.farmer.information.management.system.model.impl.FarmerRegistrationModelImpl</code>.
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

		return _farmerRegistrationLocalService.dynamicQuery(
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

		return _farmerRegistrationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _farmerRegistrationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public
		bd.gov.dgfood.farmer.information.management.system.model.
			FarmerRegistration fetchFarmerRegistration(
				long farmerRegistrationId) {

		return _farmerRegistrationLocalService.fetchFarmerRegistration(
			farmerRegistrationId);
	}

	/**
	 * Fetch Farmer Registration record by Application Number
	 *
	 * @param nationalId
	 * @return FarmerRegistration
	 */
	@Override
	public
		bd.gov.dgfood.farmer.information.management.system.model.
			FarmerRegistration fetchFarmerRegistrationByApplicationNumber(
				String applicationNumber) {

		return _farmerRegistrationLocalService.
			fetchFarmerRegistrationByApplicationNumber(applicationNumber);
	}

	/**
	 * Fetch Farmer Registration record by Application Number and Date of Birth
	 *
	 * @param nationalId
	 * @param dateOfBirth
	 * @return FarmerRegistration
	 */
	@Override
	public
		bd.gov.dgfood.farmer.information.management.system.model.
			FarmerRegistration fetchFarmerRegistrationByApplicationNumberDob(
				String applicationNumber, java.util.Date dateOfBirth) {

		return _farmerRegistrationLocalService.
			fetchFarmerRegistrationByApplicationNumberDob(
				applicationNumber, dateOfBirth);
	}

	/**
	 * Fetch Farmer Registration record by Naional Id
	 *
	 * @param nationalId
	 * @return FarmerRegistration
	 */
	@Override
	public
		bd.gov.dgfood.farmer.information.management.system.model.
			FarmerRegistration fetchFarmerRegistrationByNationalId(
				String nationalId) {

		return _farmerRegistrationLocalService.
			fetchFarmerRegistrationByNationalId(nationalId);
	}

	/**
	 * Fetch Farmer Registration record by Naional Id and Date of birth
	 *
	 * @param nationalId
	 * @param dateOfBirth
	 * @return FarmerRegistration
	 */
	@Override
	public
		bd.gov.dgfood.farmer.information.management.system.model.
			FarmerRegistration fetchFarmerRegistrationByNationalIdDob(
				String nationalId, java.util.Date dateOfBirth) {

		return _farmerRegistrationLocalService.
			fetchFarmerRegistrationByNationalIdDob(nationalId, dateOfBirth);
	}

	/**
	 * Fetch Farmer Registration record by User Id
	 *
	 * @param userId
	 * @return
	 */
	@Override
	public
		bd.gov.dgfood.farmer.information.management.system.model.
			FarmerRegistration fetchFarmerRegistrationByUserId(long userId) {

		return _farmerRegistrationLocalService.fetchFarmerRegistrationByUserId(
			userId);
	}

	/**
	 * Returns the farmer registration matching the UUID and group.
	 *
	 * @param uuid the farmer registration's UUID
	 * @param groupId the primary key of the group
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	@Override
	public
		bd.gov.dgfood.farmer.information.management.system.model.
			FarmerRegistration fetchFarmerRegistrationByUuidAndGroupId(
				String uuid, long groupId) {

		return _farmerRegistrationLocalService.
			fetchFarmerRegistrationByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _farmerRegistrationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _farmerRegistrationLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	/**
	 * Returns the farmer registration with the primary key.
	 *
	 * @param farmerRegistrationId the primary key of the farmer registration
	 * @return the farmer registration
	 * @throws PortalException if a farmer registration with the primary key could not be found
	 */
	@Override
	public
		bd.gov.dgfood.farmer.information.management.system.model.
			FarmerRegistration getFarmerRegistration(long farmerRegistrationId)
				throws com.liferay.portal.kernel.exception.PortalException {

		return _farmerRegistrationLocalService.getFarmerRegistration(
			farmerRegistrationId);
	}

	/**
	 * Returns the farmer registration matching the UUID and group.
	 *
	 * @param uuid the farmer registration's UUID
	 * @param groupId the primary key of the group
	 * @return the matching farmer registration
	 * @throws PortalException if a matching farmer registration could not be found
	 */
	@Override
	public
		bd.gov.dgfood.farmer.information.management.system.model.
			FarmerRegistration getFarmerRegistrationByUuidAndGroupId(
					String uuid, long groupId)
				throws com.liferay.portal.kernel.exception.PortalException {

		return _farmerRegistrationLocalService.
			getFarmerRegistrationByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the farmer registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.farmer.information.management.system.model.impl.FarmerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of farmer registrations
	 * @param end the upper bound of the range of farmer registrations (not inclusive)
	 * @return the range of farmer registrations
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.farmer.information.management.system.model.
			FarmerRegistration> getFarmerRegistrations(int start, int end) {

		return _farmerRegistrationLocalService.getFarmerRegistrations(
			start, end);
	}

	/**
	 * Returns all the farmer registrations matching the UUID and company.
	 *
	 * @param uuid the UUID of the farmer registrations
	 * @param companyId the primary key of the company
	 * @return the matching farmer registrations, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.farmer.information.management.system.model.
			FarmerRegistration> getFarmerRegistrationsByUuidAndCompanyId(
				String uuid, long companyId) {

		return _farmerRegistrationLocalService.
			getFarmerRegistrationsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of farmer registrations matching the UUID and company.
	 *
	 * @param uuid the UUID of the farmer registrations
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of farmer registrations
	 * @param end the upper bound of the range of farmer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching farmer registrations, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.farmer.information.management.system.model.
			FarmerRegistration> getFarmerRegistrationsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<bd.gov.dgfood.farmer.information.management.system.model.
						FarmerRegistration> orderByComparator) {

		return _farmerRegistrationLocalService.
			getFarmerRegistrationsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of farmer registrations.
	 *
	 * @return the number of farmer registrations
	 */
	@Override
	public int getFarmerRegistrationsCount() {
		return _farmerRegistrationLocalService.getFarmerRegistrationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _farmerRegistrationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _farmerRegistrationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _farmerRegistrationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Fetch Farmer Registrations list based on search inputs
	 *
	 * @param groupId
	 * @param farmerRegistrationFilterOptions
	 * @param addressOptions
	 * @param keywords
	 * @param start
	 * @param end
	 * @param orderByComparator
	 * @return
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.farmer.information.management.system.model.
			FarmerRegistration> searchFarmerRegistrations(
				long groupId,
				java.util.Map<String, Object> farmerRegistrationFilterOptions,
				java.util.Map<String, Object> addressOptions, String keywords,
				java.util.Date fromDate, java.util.Date toDate, int start,
				int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<bd.gov.dgfood.farmer.information.management.system.model.
						FarmerRegistration> orderByComparator) {

		return _farmerRegistrationLocalService.searchFarmerRegistrations(
			groupId, farmerRegistrationFilterOptions, addressOptions, keywords,
			fromDate, toDate, start, end, orderByComparator);
	}

	/**
	 * Fetch Farmer Registrations count based on search inputs
	 *
	 * @param groupId
	 * @param farmerRegistrationFilterOptions
	 * @param addressOptions
	 * @param keywords
	 * @return
	 */
	@Override
	public long searchFarmerRegistrationsCount(
		long groupId,
		java.util.Map<String, Object> farmerRegistrationFilterOptions,
		java.util.Map<String, Object> addressOptions, String keywords,
		java.util.Date fromDate, java.util.Date toDate) {

		return _farmerRegistrationLocalService.searchFarmerRegistrationsCount(
			groupId, farmerRegistrationFilterOptions, addressOptions, keywords,
			fromDate, toDate);
	}

	/**
	 * Updates the farmer registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FarmerRegistrationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param farmerRegistration the farmer registration
	 * @return the farmer registration that was updated
	 */
	@Override
	public
		bd.gov.dgfood.farmer.information.management.system.model.
			FarmerRegistration updateFarmerRegistration(
				bd.gov.dgfood.farmer.information.management.system.model.
					FarmerRegistration farmerRegistration) {

		return _farmerRegistrationLocalService.updateFarmerRegistration(
			farmerRegistration);
	}

	@Override
	public
		bd.gov.dgfood.farmer.information.management.system.model.
			FarmerRegistration updateFarmerRegistration(
				long farmerRegistrationId, String nationalId,
				String emailAddress, String mobileNumber,
				java.util.Date dateOfBirth, String farmerName,
				String fatherName, String motherName, int gender,
				String krishiCardNumber, int maritalStatus,
				String cultivableLandSeason1Name,
				float cultivableLandSeason1Area,
				String cultivableLandSeason1Unit,
				String cultivableLandSeason2Name,
				float cultivableLandSeason2Area,
				String cultivableLandSeason2Unit,
				String cultivableLandSeason3Name,
				float cultivableLandSeason3Area,
				String cultivableLandSeason3Unit, String farmerCategory,
				String password, String remarks, long groupId,
				com.liferay.portal.kernel.service.ServiceContext
					serviceContext) {

		return _farmerRegistrationLocalService.updateFarmerRegistration(
			farmerRegistrationId, nationalId, emailAddress, mobileNumber,
			dateOfBirth, farmerName, fatherName, motherName, gender,
			krishiCardNumber, maritalStatus, cultivableLandSeason1Name,
			cultivableLandSeason1Area, cultivableLandSeason1Unit,
			cultivableLandSeason2Name, cultivableLandSeason2Area,
			cultivableLandSeason2Unit, cultivableLandSeason3Name,
			cultivableLandSeason3Area, cultivableLandSeason3Unit,
			farmerCategory, password, remarks, groupId, serviceContext);
	}

	/**
	 * To update the status of a Farmer Registration record with the given status
	 *
	 * @param userId
	 * @param faremerRegistrationId
	 * @param status
	 * @param serviceContext
	 * @return FarmerRegistration
	 * @throws PortalException
	 * @throws SystemException
	 */
	@Override
	public
		bd.gov.dgfood.farmer.information.management.system.model.
			FarmerRegistration updateStatus(
					long userId, long faremerRegistrationId, int status,
					com.liferay.portal.kernel.service.ServiceContext
						serviceContext)
				throws com.liferay.portal.kernel.exception.PortalException,
					   com.liferay.portal.kernel.exception.SystemException {

		return _farmerRegistrationLocalService.updateStatus(
			userId, faremerRegistrationId, status, serviceContext);
	}

	@Override
	public FarmerRegistrationLocalService getWrappedService() {
		return _farmerRegistrationLocalService;
	}

	@Override
	public void setWrappedService(
		FarmerRegistrationLocalService farmerRegistrationLocalService) {

		_farmerRegistrationLocalService = farmerRegistrationLocalService;
	}

	private FarmerRegistrationLocalService _farmerRegistrationLocalService;

}