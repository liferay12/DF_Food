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

package bd.gov.dgfood.food.friendly.program.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FFPBeneficiaryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FFPBeneficiaryLocalService
 * @generated
 */
public class FFPBeneficiaryLocalServiceWrapper
	implements FFPBeneficiaryLocalService,
			   ServiceWrapper<FFPBeneficiaryLocalService> {

	public FFPBeneficiaryLocalServiceWrapper() {
		this(null);
	}

	public FFPBeneficiaryLocalServiceWrapper(
		FFPBeneficiaryLocalService ffpBeneficiaryLocalService) {

		_ffpBeneficiaryLocalService = ffpBeneficiaryLocalService;
	}

	/**
	 * Adding a new beneificairy record in DB
	 *
	 * @param userId
	 * @param name
	 * @param nationalId
	 * @param mobileNumber
	 * @param emailAddress
	 * @param dateOfBirth
	 * @param gender
	 * @param maritalStatus
	 * @param spouseName
	 * @param spouseFatherName
	 * @param spouseNationalId
	 * @param spouseDateOfBirth
	 * @param fatherName
	 * @param motherName
	 * @param familyEarningMembers
	 * @param familyAverageMonthlyIncome
	 * @param permanentRegion
	 * @param permanentZilla
	 * @param permanentUpazilla
	 * @param permanentUnion
	 * @param permanentVillage
	 * @param permanentWard
	 * @param permanentZipCode
	 * @param permanentPostOffice
	 * @param permanentHouseAddress
	 * @param presentRegion
	 * @param presentZilla
	 * @param presentUpazilla
	 * @param presentUnion
	 * @param presentVillage
	 * @param presentWard
	 * @param presentZipCode
	 * @param presentPostOffice
	 * @param presentHouseAddress
	 * @param sameAsPermanentAddress
	 * @param acknowledge
	 * @param nonOfMyFamilyMembersRegistered
	 * @param photograph
	 * @param signature
	 * @param additionalDoc
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary
			addBenficiary(
				long userId, String name, long nationalId, String mobileNumber,
				String emailAddress, java.util.Date dateOfBirth, int gender,
				int maritalStatus, String spouseName, String spouseFatherName,
				long spouseNationalId, java.util.Date spouseDateOfBirth,
				String fatherName, String motherName, int familyEarningMembers,
				String familyAverageMonthlyIncome, long permanentRegion,
				long permanentZilla, long permanentUpazilla,
				long permanentUnion, String permanentVillage,
				long permanentWard, long permanentZipCode,
				String permanentPostOffice, String permanentHouseAddress,
				long presentRegion, long presentZilla, long presentUpazilla,
				long presentUnion, String presentVillage, long presentWard,
				long presentZipCode, String presentPostOffice,
				String presentHouseAddress, boolean sameAsPermanentAddress,
				boolean acknowledge, boolean nonOfMyFamilyMembersRegistered,
				com.liferay.portal.vulcan.multipart.BinaryFile photograph,
				com.liferay.portal.vulcan.multipart.BinaryFile signature,
				java.util.List<com.liferay.portal.vulcan.multipart.BinaryFile>
					additionalDoc,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ffpBeneficiaryLocalService.addBenficiary(
			userId, name, nationalId, mobileNumber, emailAddress, dateOfBirth,
			gender, maritalStatus, spouseName, spouseFatherName,
			spouseNationalId, spouseDateOfBirth, fatherName, motherName,
			familyEarningMembers, familyAverageMonthlyIncome, permanentRegion,
			permanentZilla, permanentUpazilla, permanentUnion, permanentVillage,
			permanentWard, permanentZipCode, permanentPostOffice,
			permanentHouseAddress, presentRegion, presentZilla, presentUpazilla,
			presentUnion, presentVillage, presentWard, presentZipCode,
			presentPostOffice, presentHouseAddress, sameAsPermanentAddress,
			acknowledge, nonOfMyFamilyMembersRegistered, photograph, signature,
			additionalDoc, serviceContext);
	}

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
	@Override
	public bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary
		addFFPBeneficiary(
			bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary
				ffpBeneficiary) {

		return _ffpBeneficiaryLocalService.addFFPBeneficiary(ffpBeneficiary);
	}

	/**
	 * Search container results count
	 *
	 * @param companyId
	 * @param keywords
	 * @param status
	 * @param params
	 * @param attributes
	 * @return
	 */
	@Override
	public int countByKeyWords(
		long companyId, String keywords, int status,
		java.util.LinkedHashMap<String, Object> params,
		java.util.Map<String, java.io.Serializable> attributes) {

		return _ffpBeneficiaryLocalService.countByKeyWords(
			companyId, keywords, status, params, attributes);
	}

	/**
	 * Creates a new ffp beneficiary with the primary key. Does not add the ffp beneficiary to the database.
	 *
	 * @param beneficiaryId the primary key for the new ffp beneficiary
	 * @return the new ffp beneficiary
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary
		createFFPBeneficiary(long beneficiaryId) {

		return _ffpBeneficiaryLocalService.createFFPBeneficiary(beneficiaryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ffpBeneficiaryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Delete all records (Use only of development purpose)
	 */
	@Override
	public void deleteAll() {
		_ffpBeneficiaryLocalService.deleteAll();
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
	@Override
	public bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary
		deleteFFPBeneficiary(
			bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary
				ffpBeneficiary) {

		return _ffpBeneficiaryLocalService.deleteFFPBeneficiary(ffpBeneficiary);
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
	@Override
	public bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary
			deleteFFPBeneficiary(long beneficiaryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ffpBeneficiaryLocalService.deleteFFPBeneficiary(beneficiaryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ffpBeneficiaryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _ffpBeneficiaryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _ffpBeneficiaryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ffpBeneficiaryLocalService.dynamicQuery();
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

		return _ffpBeneficiaryLocalService.dynamicQuery(dynamicQuery);
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
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _ffpBeneficiaryLocalService.dynamicQuery(
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
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _ffpBeneficiaryLocalService.dynamicQuery(
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

		return _ffpBeneficiaryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _ffpBeneficiaryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary
		fetchFFPBeneficiary(long beneficiaryId) {

		return _ffpBeneficiaryLocalService.fetchFFPBeneficiary(beneficiaryId);
	}

	/**
	 * Returns the ffp beneficiary matching the UUID and group.
	 *
	 * @param uuid the ffp beneficiary's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary
		fetchFFPBeneficiaryByUuidAndGroupId(String uuid, long groupId) {

		return _ffpBeneficiaryLocalService.fetchFFPBeneficiaryByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Search container results
	 *
	 * @param companyId
	 * @param keywords
	 * @param start
	 * @param end
	 * @param params
	 * @param attributes
	 * @return
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary>
			findByKeyWords(
				long companyId, String keywords, int start, int end,
				java.util.LinkedHashMap<String, Object> params,
				java.util.Map<String, java.io.Serializable> attributes) {

		return _ffpBeneficiaryLocalService.findByKeyWords(
			companyId, keywords, start, end, params, attributes);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ffpBeneficiaryLocalService.getActionableDynamicQuery();
	}

	/**
	 * Get beneficiary application by
	 *
	 * @param beneficiaryId
	 * @param dateOfBirth
	 * @return
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary
		getApplication(long beneficiaryId, java.util.Date dateOfBirth) {

		return _ffpBeneficiaryLocalService.getApplication(
			beneficiaryId, dateOfBirth);
	}

	/**
	 * Get beneficiary by
	 *
	 * @param nationalId
	 * @return
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary
		getBenificiaryByNationalId(long nationalId) {

		return _ffpBeneficiaryLocalService.getBenificiaryByNationalId(
			nationalId);
	}

	/**
	 * Get beneficiary by
	 *
	 * @param cardNumber
	 * @param dateOfBirth
	 * @return
	 * @throws NoSuchFFPBeneficiaryException
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary
			getBenificiaryDetails(String cardNumber, java.util.Date dateOfBirth)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFFPBeneficiaryException {

		return _ffpBeneficiaryLocalService.getBenificiaryDetails(
			cardNumber, dateOfBirth);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _ffpBeneficiaryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
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
	public java.util.List
		<bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary>
			getFFPBeneficiaries(int start, int end) {

		return _ffpBeneficiaryLocalService.getFFPBeneficiaries(start, end);
	}

	/**
	 * Returns all the ffp beneficiaries matching the UUID and company.
	 *
	 * @param uuid the UUID of the ffp beneficiaries
	 * @param companyId the primary key of the company
	 * @return the matching ffp beneficiaries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary>
			getFFPBeneficiariesByUuidAndCompanyId(String uuid, long companyId) {

		return _ffpBeneficiaryLocalService.
			getFFPBeneficiariesByUuidAndCompanyId(uuid, companyId);
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
	public java.util.List
		<bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary>
			getFFPBeneficiariesByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary>
						orderByComparator) {

		return _ffpBeneficiaryLocalService.
			getFFPBeneficiariesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of ffp beneficiaries.
	 *
	 * @return the number of ffp beneficiaries
	 */
	@Override
	public int getFFPBeneficiariesCount() {
		return _ffpBeneficiaryLocalService.getFFPBeneficiariesCount();
	}

	/**
	 * Returns the ffp beneficiary with the primary key.
	 *
	 * @param beneficiaryId the primary key of the ffp beneficiary
	 * @return the ffp beneficiary
	 * @throws PortalException if a ffp beneficiary with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary
			getFFPBeneficiary(long beneficiaryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ffpBeneficiaryLocalService.getFFPBeneficiary(beneficiaryId);
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
	public bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary
			getFFPBeneficiaryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ffpBeneficiaryLocalService.getFFPBeneficiaryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ffpBeneficiaryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ffpBeneficiaryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ffpBeneficiaryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updating beneficiary record in DB
	 *
	 * @param ffpRegistrationVersion
	 * @param userId
	 * @param status
	 * @return
	 * @throws NoSuchFFPBeneficiaryException
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary
			updateBenficiary(
				bd.gov.dgfood.food.friendly.program.model.FFPBeneficiaryVersion
					ffpRegistrationVersion,
				long userId, int status)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFFPBeneficiaryException {

		return _ffpBeneficiaryLocalService.updateBenficiary(
			ffpRegistrationVersion, userId, status);
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
	@Override
	public bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary
		updateFFPBeneficiary(
			bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary
				ffpBeneficiary) {

		return _ffpBeneficiaryLocalService.updateFFPBeneficiary(ffpBeneficiary);
	}

	/**
	 * Update workflow status
	 *
	 * @param userId
	 * @param beneficiaryId
	 * @param status
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary
			updateStatus(
				long userId, long beneficiaryId, int status,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _ffpBeneficiaryLocalService.updateStatus(
			userId, beneficiaryId, status, serviceContext);
	}

	@Override
	public FFPBeneficiaryLocalService getWrappedService() {
		return _ffpBeneficiaryLocalService;
	}

	@Override
	public void setWrappedService(
		FFPBeneficiaryLocalService ffpBeneficiaryLocalService) {

		_ffpBeneficiaryLocalService = ffpBeneficiaryLocalService;
	}

	private FFPBeneficiaryLocalService _ffpBeneficiaryLocalService;

}