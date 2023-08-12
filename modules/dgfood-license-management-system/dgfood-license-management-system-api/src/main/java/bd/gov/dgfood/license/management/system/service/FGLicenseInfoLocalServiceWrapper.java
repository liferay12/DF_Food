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

package bd.gov.dgfood.license.management.system.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FGLicenseInfoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FGLicenseInfoLocalService
 * @generated
 */
public class FGLicenseInfoLocalServiceWrapper
	implements FGLicenseInfoLocalService,
			   ServiceWrapper<FGLicenseInfoLocalService> {

	public FGLicenseInfoLocalServiceWrapper() {
		this(null);
	}

	public FGLicenseInfoLocalServiceWrapper(
		FGLicenseInfoLocalService fgLicenseInfoLocalService) {

		_fgLicenseInfoLocalService = fgLicenseInfoLocalService;
	}

	/**
	 * This method is used to store the New Foodgrain License application data.
	 *
	 * @throws PortalException
	 */
	@Override
	public bd.gov.dgfood.license.management.system.model.FGLicenseInfo
			addFGLicenseFormData(
				String nationalId, String mobileNumber,
				java.util.Date dateOfBirth, String emailAddress,
				String password, String applicantName, int gender,
				int maritalStatus, String fatherName, String motherName,
				String tradeLicenseNo, java.util.Date tradeLicenseExpiryDate,
				String tradeLicenseIssuerCode, String tradeLicenseIssuerCity,
				String taxIdentificationNumber,
				String businessIdentificationNumber, long permanentRegion,
				long permanentDistrict, long permanentUpazila,
				long permanentCityCorporationOrMunicipality,
				long permanentUnionOrWard, long permanentZipCode,
				String permanentPostOffice, String permanentVillageOrRoad,
				String permanentMouzaOrMoholla, String permanentHouseAddress,
				long presentRegion, long presentDistrict, long presentUpazila,
				long presentCityCorporationOrMunicipality,
				long presentUnionOrWard, long presentZipCode,
				String presentPostOffice, String presentVillageOrRoad,
				String presentMouzaOrMoholla, String presentHouseAddress,
				String businessName, String businessType, long businessRegion,
				long businessDistrict, long businessUpazila,
				long businessCityCorporationOrMunicipality,
				long businessUnionOrWard, long businessZipCode,
				String businessPostOffice, String businessVillageOrRoad,
				String businessMouzaOrMoholla, String businessHouseAddress,
				long profilePhotographDocId, long tradeLicenseDocId,
				long businessIdentificationNumberDocId,
				long taxIdentificationNumberDocId, long bankStatementDocId,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fgLicenseInfoLocalService.addFGLicenseFormData(
			nationalId, mobileNumber, dateOfBirth, emailAddress, password,
			applicantName, gender, maritalStatus, fatherName, motherName,
			tradeLicenseNo, tradeLicenseExpiryDate, tradeLicenseIssuerCode,
			tradeLicenseIssuerCity, taxIdentificationNumber,
			businessIdentificationNumber, permanentRegion, permanentDistrict,
			permanentUpazila, permanentCityCorporationOrMunicipality,
			permanentUnionOrWard, permanentZipCode, permanentPostOffice,
			permanentVillageOrRoad, permanentMouzaOrMoholla,
			permanentHouseAddress, presentRegion, presentDistrict,
			presentUpazila, presentCityCorporationOrMunicipality,
			presentUnionOrWard, presentZipCode, presentPostOffice,
			presentVillageOrRoad, presentMouzaOrMoholla, presentHouseAddress,
			businessName, businessType, businessRegion, businessDistrict,
			businessUpazila, businessCityCorporationOrMunicipality,
			businessUnionOrWard, businessZipCode, businessPostOffice,
			businessVillageOrRoad, businessMouzaOrMoholla, businessHouseAddress,
			profilePhotographDocId, tradeLicenseDocId,
			businessIdentificationNumberDocId, taxIdentificationNumberDocId,
			bankStatementDocId, serviceContext);
	}

	/**
	 * Adds the fg license info to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FGLicenseInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fgLicenseInfo the fg license info
	 * @return the fg license info that was added
	 */
	@Override
	public bd.gov.dgfood.license.management.system.model.FGLicenseInfo
		addFGLicenseInfo(
			bd.gov.dgfood.license.management.system.model.FGLicenseInfo
				fgLicenseInfo) {

		return _fgLicenseInfoLocalService.addFGLicenseInfo(fgLicenseInfo);
	}

	/**
	 * Create a new record in Foodgrain License Info table It stores the basic
	 * information of FG Licensee Registration form.
	 */
	@Override
	public bd.gov.dgfood.license.management.system.model.FGLicenseInfo
		addFgLicenseInfo(
			long fgLicenseMasterId, String nationalId, String applicationNumber,
			String tradeLicenseNumber, String applicantName,
			String businessName, String businessType, String division,
			String district, String upazila, long businessAddressId,
			String applicationType,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _fgLicenseInfoLocalService.addFgLicenseInfo(
			fgLicenseMasterId, nationalId, applicationNumber,
			tradeLicenseNumber, applicantName, businessName, businessType,
			division, district, upazila, businessAddressId, applicationType,
			serviceContext);
	}

	/**
	 * Creates a new fg license info with the primary key. Does not add the fg license info to the database.
	 *
	 * @param fgLicenseInfoId the primary key for the new fg license info
	 * @return the new fg license info
	 */
	@Override
	public bd.gov.dgfood.license.management.system.model.FGLicenseInfo
		createFGLicenseInfo(long fgLicenseInfoId) {

		return _fgLicenseInfoLocalService.createFGLicenseInfo(fgLicenseInfoId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fgLicenseInfoLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the fg license info from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FGLicenseInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fgLicenseInfo the fg license info
	 * @return the fg license info that was removed
	 */
	@Override
	public bd.gov.dgfood.license.management.system.model.FGLicenseInfo
		deleteFGLicenseInfo(
			bd.gov.dgfood.license.management.system.model.FGLicenseInfo
				fgLicenseInfo) {

		return _fgLicenseInfoLocalService.deleteFGLicenseInfo(fgLicenseInfo);
	}

	/**
	 * Deletes the fg license info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FGLicenseInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fgLicenseInfoId the primary key of the fg license info
	 * @return the fg license info that was removed
	 * @throws PortalException if a fg license info with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.license.management.system.model.FGLicenseInfo
			deleteFGLicenseInfo(long fgLicenseInfoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fgLicenseInfoLocalService.deleteFGLicenseInfo(fgLicenseInfoId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fgLicenseInfoLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _fgLicenseInfoLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _fgLicenseInfoLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _fgLicenseInfoLocalService.dynamicQuery();
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

		return _fgLicenseInfoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.license.management.system.model.impl.FGLicenseInfoModelImpl</code>.
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

		return _fgLicenseInfoLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.license.management.system.model.impl.FGLicenseInfoModelImpl</code>.
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

		return _fgLicenseInfoLocalService.dynamicQuery(
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

		return _fgLicenseInfoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _fgLicenseInfoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	/**
	 * Fetch the FG License application by Application Number
	 */
	@Override
	public bd.gov.dgfood.license.management.system.model.FGLicenseInfo
		fetchFGLicenseByApplicationNumber(String applicationNumber) {

		return _fgLicenseInfoLocalService.fetchFGLicenseByApplicationNumber(
			applicationNumber);
	}

	@Override
	public bd.gov.dgfood.license.management.system.model.FGLicenseInfo
		fetchFGLicenseInfo(long fgLicenseInfoId) {

		return _fgLicenseInfoLocalService.fetchFGLicenseInfo(fgLicenseInfoId);
	}

	/**
	 * Returns the fg license info matching the UUID and group.
	 *
	 * @param uuid the fg license info's UUID
	 * @param groupId the primary key of the group
	 * @return the matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	@Override
	public bd.gov.dgfood.license.management.system.model.FGLicenseInfo
		fetchFGLicenseInfoByUuidAndGroupId(String uuid, long groupId) {

		return _fgLicenseInfoLocalService.fetchFGLicenseInfoByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * This method is used to fetch FG licenses with application number, date of
	 * birth and National Id. It compares dateofbirth and NID from user_ table as
	 * well.
	 *
	 * @throws Exception
	 */
	@Override
	public bd.gov.dgfood.license.management.system.model.FGLicenseInfo
			fetchFGLicenseWithApplicationNumberNIDDateOfBirth(
				com.liferay.portal.kernel.service.ServiceContext serviceContext,
				String applicationNumber, String nationalId,
				java.util.Date dateOfBirth)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fgLicenseInfoLocalService.
			fetchFGLicenseWithApplicationNumberNIDDateOfBirth(
				serviceContext, applicationNumber, nationalId, dateOfBirth);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _fgLicenseInfoLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns number of New Foodgrain License Applications available for the given
	 * National id
	 *
	 * @param nationalId
	 * @return
	 */
	@Override
	public long getActiveFGLicenseCountByNationalId(String nationalId) {
		return _fgLicenseInfoLocalService.getActiveFGLicenseCountByNationalId(
			nationalId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _fgLicenseInfoLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	/**
	 * Returns the fg license info with the primary key.
	 *
	 * @param fgLicenseInfoId the primary key of the fg license info
	 * @return the fg license info
	 * @throws PortalException if a fg license info with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.license.management.system.model.FGLicenseInfo
			getFGLicenseInfo(long fgLicenseInfoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fgLicenseInfoLocalService.getFGLicenseInfo(fgLicenseInfoId);
	}

	/**
	 * Returns the fg license info matching the UUID and group.
	 *
	 * @param uuid the fg license info's UUID
	 * @param groupId the primary key of the group
	 * @return the matching fg license info
	 * @throws PortalException if a matching fg license info could not be found
	 */
	@Override
	public bd.gov.dgfood.license.management.system.model.FGLicenseInfo
			getFGLicenseInfoByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fgLicenseInfoLocalService.getFGLicenseInfoByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the fg license infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.license.management.system.model.impl.FGLicenseInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fg license infos
	 * @param end the upper bound of the range of fg license infos (not inclusive)
	 * @return the range of fg license infos
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.license.management.system.model.FGLicenseInfo>
			getFGLicenseInfos(int start, int end) {

		return _fgLicenseInfoLocalService.getFGLicenseInfos(start, end);
	}

	/**
	 * Returns all the fg license infos matching the UUID and company.
	 *
	 * @param uuid the UUID of the fg license infos
	 * @param companyId the primary key of the company
	 * @return the matching fg license infos, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.license.management.system.model.FGLicenseInfo>
			getFGLicenseInfosByUuidAndCompanyId(String uuid, long companyId) {

		return _fgLicenseInfoLocalService.getFGLicenseInfosByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of fg license infos matching the UUID and company.
	 *
	 * @param uuid the UUID of the fg license infos
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of fg license infos
	 * @param end the upper bound of the range of fg license infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching fg license infos, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.license.management.system.model.FGLicenseInfo>
			getFGLicenseInfosByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<bd.gov.dgfood.license.management.system.model.
						FGLicenseInfo> orderByComparator) {

		return _fgLicenseInfoLocalService.getFGLicenseInfosByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of fg license infos.
	 *
	 * @return the number of fg license infos
	 */
	@Override
	public int getFGLicenseInfosCount() {
		return _fgLicenseInfoLocalService.getFGLicenseInfosCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _fgLicenseInfoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _fgLicenseInfoLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns number of new Foodgrain License application are in pending state for
	 * the given National id
	 *
	 * @param nationalId
	 * @return
	 */
	@Override
	public long getPendingFGLicenseCountByNationalId(String nationalId) {
		return _fgLicenseInfoLocalService.getPendingFGLicenseCountByNationalId(
			nationalId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fgLicenseInfoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * fetch the records based on the curent user location and other search & filter
	 * options.
	 *
	 * Search & filter optional are optional
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.license.management.system.model.FGLicenseInfo>
			searchFGLicenseRecords(
				long groupId, java.util.Map<String, Object> filterOptions,
				String locationName, String locationValue, String keywords,
				java.util.Date fromDate, java.util.Date toDate, int start,
				int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<bd.gov.dgfood.license.management.system.model.
						FGLicenseInfo> orderByComparator) {

		return _fgLicenseInfoLocalService.searchFGLicenseRecords(
			groupId, filterOptions, locationName, locationValue, keywords,
			fromDate, toDate, start, end, orderByComparator);
	}

	/**
	 * Fetch the number of records are available based on the curent user location
	 * and other search & filter options.
	 *
	 * Search & filter optional are optional
	 */
	@Override
	public long searchFGLicenseRecordsCount(
		long groupId, java.util.Map<String, Object> filterOptions,
		String locationName, String locationValue, String keywords,
		java.util.Date fromDate, java.util.Date toDate) {

		return _fgLicenseInfoLocalService.searchFGLicenseRecordsCount(
			groupId, filterOptions, locationName, locationValue, keywords,
			fromDate, toDate);
	}

	/**
	 * Updates the fg license info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FGLicenseInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fgLicenseInfo the fg license info
	 * @return the fg license info that was updated
	 */
	@Override
	public bd.gov.dgfood.license.management.system.model.FGLicenseInfo
		updateFGLicenseInfo(
			bd.gov.dgfood.license.management.system.model.FGLicenseInfo
				fgLicenseInfo) {

		return _fgLicenseInfoLocalService.updateFGLicenseInfo(fgLicenseInfo);
	}

	@Override
	public FGLicenseInfoLocalService getWrappedService() {
		return _fgLicenseInfoLocalService;
	}

	@Override
	public void setWrappedService(
		FGLicenseInfoLocalService fgLicenseInfoLocalService) {

		_fgLicenseInfoLocalService = fgLicenseInfoLocalService;
	}

	private FGLicenseInfoLocalService _fgLicenseInfoLocalService;

}