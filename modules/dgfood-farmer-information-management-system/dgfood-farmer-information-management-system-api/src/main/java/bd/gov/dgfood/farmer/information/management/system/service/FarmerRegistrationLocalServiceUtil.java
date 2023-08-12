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

import bd.gov.dgfood.farmer.information.management.system.model.FarmerRegistration;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for FarmerRegistration. This utility wraps
 * <code>bd.gov.dgfood.farmer.information.management.system.service.impl.FarmerRegistrationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FarmerRegistrationLocalService
 * @generated
 */
public class FarmerRegistrationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>bd.gov.dgfood.farmer.information.management.system.service.impl.FarmerRegistrationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static FarmerRegistration addFarmerRegistration(
		FarmerRegistration farmerRegistration) {

		return getService().addFarmerRegistration(farmerRegistration);
	}

	/**
	 * It will add a new Farmer Registration record in the Farmer Registration
	 * master table
	 */
	public static FarmerRegistration addFarmerRegistration(
		String nationalId, String emailAddress, String mobileNumber,
		java.util.Date dateOfBirth, String farmerName, String fatherName,
		String motherName, int gender, String krishiCardNumber,
		int maritalStatus, String cultivableLandSeason1Name,
		float cultivableLandSeason1Area, String cultivableLandSeason1Unit,
		String cultivableLandSeason2Name, float cultivableLandSeason2Area,
		String cultivableLandSeason2Unit, String cultivableLandSeason3Name,
		float cultivableLandSeason3Area, String cultivableLandSeason3Unit,
		String farmerCategory, String password, String remarks, long groupId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().addFarmerRegistration(
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
	public static FarmerRegistration addFarmerRegistrationFormData(
			boolean isHeadlessRequest, String nationalId, String emailAddress,
			String mobileNumber, String dateOfBirth, String farmerName,
			String fatherName, String motherName, int gender,
			String krishiCardNumber, int maritalStatus,
			String cultivableLandSeason1Name, float cultivableLandSeason1Area,
			String cultivableLandSeason1Unit, String cultivableLandSeason2Name,
			float cultivableLandSeason2Area, String cultivableLandSeason2Unit,
			String cultivableLandSeason3Name, float cultivableLandSeason3Area,
			String cultivableLandSeason3Unit, String farmerCategory,
			String password, String remarks, long permanentRegion,
			long permanentZilla, long permanentUpazila,
			long permanentCityCorporationOrMunicipality,
			long permanentUnionOrWard, long permanentZipCode,
			String permanentPostOffice, String permanentVillageOrRoad,
			String permanentMouzaOrMoholla, String permanentHouseAddress,
			long presentRegion, long presentZilla, long presentUpazila,
			long presentCityCorporationOrMunicipality, long presentUnionOrWard,
			long presentZipCode, String presentPostOffice,
			String presentVillageOrRoad, String presentMouzaOrMoholla,
			String presentHouseAddress,
			com.liferay.portal.vulcan.multipart.BinaryFile profilePhotograph,
			com.liferay.portal.vulcan.multipart.BinaryFile krishiCard,
			long groupId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addFarmerRegistrationFormData(
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
	public static FarmerRegistration createFarmerRegistration(
		long farmerRegistrationId) {

		return getService().createFarmerRegistration(farmerRegistrationId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static FarmerRegistration deleteFarmerRegistration(
		FarmerRegistration farmerRegistration) {

		return getService().deleteFarmerRegistration(farmerRegistration);
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
	public static FarmerRegistration deleteFarmerRegistration(
			long farmerRegistrationId)
		throws PortalException {

		return getService().deleteFarmerRegistration(farmerRegistrationId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static FarmerRegistration fetchFarmerRegistration(
		long farmerRegistrationId) {

		return getService().fetchFarmerRegistration(farmerRegistrationId);
	}

	/**
	 * Fetch Farmer Registration record by Application Number
	 *
	 * @param nationalId
	 * @return FarmerRegistration
	 */
	public static FarmerRegistration fetchFarmerRegistrationByApplicationNumber(
		String applicationNumber) {

		return getService().fetchFarmerRegistrationByApplicationNumber(
			applicationNumber);
	}

	/**
	 * Fetch Farmer Registration record by Application Number and Date of Birth
	 *
	 * @param nationalId
	 * @param dateOfBirth
	 * @return FarmerRegistration
	 */
	public static FarmerRegistration
		fetchFarmerRegistrationByApplicationNumberDob(
			String applicationNumber, java.util.Date dateOfBirth) {

		return getService().fetchFarmerRegistrationByApplicationNumberDob(
			applicationNumber, dateOfBirth);
	}

	/**
	 * Fetch Farmer Registration record by Naional Id
	 *
	 * @param nationalId
	 * @return FarmerRegistration
	 */
	public static FarmerRegistration fetchFarmerRegistrationByNationalId(
		String nationalId) {

		return getService().fetchFarmerRegistrationByNationalId(nationalId);
	}

	/**
	 * Fetch Farmer Registration record by Naional Id and Date of birth
	 *
	 * @param nationalId
	 * @param dateOfBirth
	 * @return FarmerRegistration
	 */
	public static FarmerRegistration fetchFarmerRegistrationByNationalIdDob(
		String nationalId, java.util.Date dateOfBirth) {

		return getService().fetchFarmerRegistrationByNationalIdDob(
			nationalId, dateOfBirth);
	}

	/**
	 * Fetch Farmer Registration record by User Id
	 *
	 * @param userId
	 * @return
	 */
	public static FarmerRegistration fetchFarmerRegistrationByUserId(
		long userId) {

		return getService().fetchFarmerRegistrationByUserId(userId);
	}

	/**
	 * Returns the farmer registration matching the UUID and group.
	 *
	 * @param uuid the farmer registration's UUID
	 * @param groupId the primary key of the group
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public static FarmerRegistration fetchFarmerRegistrationByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchFarmerRegistrationByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	/**
	 * Returns the farmer registration with the primary key.
	 *
	 * @param farmerRegistrationId the primary key of the farmer registration
	 * @return the farmer registration
	 * @throws PortalException if a farmer registration with the primary key could not be found
	 */
	public static FarmerRegistration getFarmerRegistration(
			long farmerRegistrationId)
		throws PortalException {

		return getService().getFarmerRegistration(farmerRegistrationId);
	}

	/**
	 * Returns the farmer registration matching the UUID and group.
	 *
	 * @param uuid the farmer registration's UUID
	 * @param groupId the primary key of the group
	 * @return the matching farmer registration
	 * @throws PortalException if a matching farmer registration could not be found
	 */
	public static FarmerRegistration getFarmerRegistrationByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getFarmerRegistrationByUuidAndGroupId(
			uuid, groupId);
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
	public static List<FarmerRegistration> getFarmerRegistrations(
		int start, int end) {

		return getService().getFarmerRegistrations(start, end);
	}

	/**
	 * Returns all the farmer registrations matching the UUID and company.
	 *
	 * @param uuid the UUID of the farmer registrations
	 * @param companyId the primary key of the company
	 * @return the matching farmer registrations, or an empty list if no matches were found
	 */
	public static List<FarmerRegistration>
		getFarmerRegistrationsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getFarmerRegistrationsByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<FarmerRegistration>
		getFarmerRegistrationsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<FarmerRegistration> orderByComparator) {

		return getService().getFarmerRegistrationsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of farmer registrations.
	 *
	 * @return the number of farmer registrations
	 */
	public static int getFarmerRegistrationsCount() {
		return getService().getFarmerRegistrationsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
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
	public static List<FarmerRegistration> searchFarmerRegistrations(
		long groupId, Map<String, Object> farmerRegistrationFilterOptions,
		Map<String, Object> addressOptions, String keywords,
		java.util.Date fromDate, java.util.Date toDate, int start, int end,
		OrderByComparator<FarmerRegistration> orderByComparator) {

		return getService().searchFarmerRegistrations(
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
	public static long searchFarmerRegistrationsCount(
		long groupId, Map<String, Object> farmerRegistrationFilterOptions,
		Map<String, Object> addressOptions, String keywords,
		java.util.Date fromDate, java.util.Date toDate) {

		return getService().searchFarmerRegistrationsCount(
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
	public static FarmerRegistration updateFarmerRegistration(
		FarmerRegistration farmerRegistration) {

		return getService().updateFarmerRegistration(farmerRegistration);
	}

	public static FarmerRegistration updateFarmerRegistration(
		long farmerRegistrationId, String nationalId, String emailAddress,
		String mobileNumber, java.util.Date dateOfBirth, String farmerName,
		String fatherName, String motherName, int gender,
		String krishiCardNumber, int maritalStatus,
		String cultivableLandSeason1Name, float cultivableLandSeason1Area,
		String cultivableLandSeason1Unit, String cultivableLandSeason2Name,
		float cultivableLandSeason2Area, String cultivableLandSeason2Unit,
		String cultivableLandSeason3Name, float cultivableLandSeason3Area,
		String cultivableLandSeason3Unit, String farmerCategory,
		String password, String remarks, long groupId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().updateFarmerRegistration(
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
	public static FarmerRegistration updateStatus(
			long userId, long faremerRegistrationId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		return getService().updateStatus(
			userId, faremerRegistrationId, status, serviceContext);
	}

	public static FarmerRegistrationLocalService getService() {
		return _service;
	}

	private static volatile FarmerRegistrationLocalService _service;

}