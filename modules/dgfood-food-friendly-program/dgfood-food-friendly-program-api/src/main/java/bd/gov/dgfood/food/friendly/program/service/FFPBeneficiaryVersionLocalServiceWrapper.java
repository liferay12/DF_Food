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
 * Provides a wrapper for {@link FFPBeneficiaryVersionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FFPBeneficiaryVersionLocalService
 * @generated
 */
public class FFPBeneficiaryVersionLocalServiceWrapper
	implements FFPBeneficiaryVersionLocalService,
			   ServiceWrapper<FFPBeneficiaryVersionLocalService> {

	public FFPBeneficiaryVersionLocalServiceWrapper() {
		this(null);
	}

	public FFPBeneficiaryVersionLocalServiceWrapper(
		FFPBeneficiaryVersionLocalService ffpBeneficiaryVersionLocalService) {

		_ffpBeneficiaryVersionLocalService = ffpBeneficiaryVersionLocalService;
	}

	/**
	 * Add a new beneificairy as a default version
	 *
	 * @param beneficiaryId
	 * @param userId
	 * @param name
	 * @param nationalId
	 * @param emailAddress
	 * @param mobileNumber
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
	public bd.gov.dgfood.food.friendly.program.model.FFPBeneficiaryVersion
			addBenficiaryVersion(
				long beneficiaryId, long userId, String name, long nationalId,
				String emailAddress, String mobileNumber,
				java.util.Date dateOfBirth, int gender, int maritalStatus,
				String spouseName, String spouseFatherName,
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

		return _ffpBeneficiaryVersionLocalService.addBenficiaryVersion(
			beneficiaryId, userId, name, nationalId, emailAddress, mobileNumber,
			dateOfBirth, gender, maritalStatus, spouseName, spouseFatherName,
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
	 * Add a existing beneificairy as a increment version
	 *
	 * @param beneficiaryId
	 * @param userId
	 * @param name
	 * @param email
	 * @param nationalId
	 * @param mobileNumber
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
	 * @param nonOfMyFamilyMembersRegistred
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.FFPBeneficiaryVersion
			addBenficiaryVersionHistory(
				long beneficiaryId, long userId, String name, long nationalId,
				String mobileNumber, String emailAddress,
				java.util.Date dateOfBirth, int gender, int maritalStatus,
				String spouseName, String spouseFatherName,
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
				boolean acknowledge, boolean nonOfMyFamilyMembersRegistred,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ffpBeneficiaryVersionLocalService.addBenficiaryVersionHistory(
			beneficiaryId, userId, name, nationalId, mobileNumber, emailAddress,
			dateOfBirth, gender, maritalStatus, spouseName, spouseFatherName,
			spouseNationalId, spouseDateOfBirth, fatherName, motherName,
			familyEarningMembers, familyAverageMonthlyIncome, permanentRegion,
			permanentZilla, permanentUpazilla, permanentUnion, permanentVillage,
			permanentWard, permanentZipCode, permanentPostOffice,
			permanentHouseAddress, presentRegion, presentZilla, presentUpazilla,
			presentUnion, presentVillage, presentWard, presentZipCode,
			presentPostOffice, presentHouseAddress, sameAsPermanentAddress,
			acknowledge, nonOfMyFamilyMembersRegistred, serviceContext);
	}

	/**
	 * Adds the ffp beneficiary version to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FFPBeneficiaryVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ffpBeneficiaryVersion the ffp beneficiary version
	 * @return the ffp beneficiary version that was added
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.FFPBeneficiaryVersion
		addFFPBeneficiaryVersion(
			bd.gov.dgfood.food.friendly.program.model.FFPBeneficiaryVersion
				ffpBeneficiaryVersion) {

		return _ffpBeneficiaryVersionLocalService.addFFPBeneficiaryVersion(
			ffpBeneficiaryVersion);
	}

	/**
	 * Creates a new ffp beneficiary version with the primary key. Does not add the ffp beneficiary version to the database.
	 *
	 * @param beneficiaryVersionId the primary key for the new ffp beneficiary version
	 * @return the new ffp beneficiary version
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.FFPBeneficiaryVersion
		createFFPBeneficiaryVersion(long beneficiaryVersionId) {

		return _ffpBeneficiaryVersionLocalService.createFFPBeneficiaryVersion(
			beneficiaryVersionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ffpBeneficiaryVersionLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the ffp beneficiary version from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FFPBeneficiaryVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ffpBeneficiaryVersion the ffp beneficiary version
	 * @return the ffp beneficiary version that was removed
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.FFPBeneficiaryVersion
		deleteFFPBeneficiaryVersion(
			bd.gov.dgfood.food.friendly.program.model.FFPBeneficiaryVersion
				ffpBeneficiaryVersion) {

		return _ffpBeneficiaryVersionLocalService.deleteFFPBeneficiaryVersion(
			ffpBeneficiaryVersion);
	}

	/**
	 * Deletes the ffp beneficiary version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FFPBeneficiaryVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param beneficiaryVersionId the primary key of the ffp beneficiary version
	 * @return the ffp beneficiary version that was removed
	 * @throws PortalException if a ffp beneficiary version with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.FFPBeneficiaryVersion
			deleteFFPBeneficiaryVersion(long beneficiaryVersionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ffpBeneficiaryVersionLocalService.deleteFFPBeneficiaryVersion(
			beneficiaryVersionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ffpBeneficiaryVersionLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _ffpBeneficiaryVersionLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _ffpBeneficiaryVersionLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ffpBeneficiaryVersionLocalService.dynamicQuery();
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

		return _ffpBeneficiaryVersionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.friendly.program.model.impl.FFPBeneficiaryVersionModelImpl</code>.
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

		return _ffpBeneficiaryVersionLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.friendly.program.model.impl.FFPBeneficiaryVersionModelImpl</code>.
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

		return _ffpBeneficiaryVersionLocalService.dynamicQuery(
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

		return _ffpBeneficiaryVersionLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _ffpBeneficiaryVersionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.friendly.program.model.FFPBeneficiaryVersion
		fetchFFPBeneficiaryVersion(long beneficiaryVersionId) {

		return _ffpBeneficiaryVersionLocalService.fetchFFPBeneficiaryVersion(
			beneficiaryVersionId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ffpBeneficiaryVersionLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the ffp beneficiary version with the primary key.
	 *
	 * @param beneficiaryVersionId the primary key of the ffp beneficiary version
	 * @return the ffp beneficiary version
	 * @throws PortalException if a ffp beneficiary version with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.FFPBeneficiaryVersion
			getFFPBeneficiaryVersion(long beneficiaryVersionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ffpBeneficiaryVersionLocalService.getFFPBeneficiaryVersion(
			beneficiaryVersionId);
	}

	/**
	 * Returns a range of all the ffp beneficiary versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.friendly.program.model.impl.FFPBeneficiaryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ffp beneficiary versions
	 * @param end the upper bound of the range of ffp beneficiary versions (not inclusive)
	 * @return the range of ffp beneficiary versions
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.food.friendly.program.model.FFPBeneficiaryVersion>
			getFFPBeneficiaryVersions(int start, int end) {

		return _ffpBeneficiaryVersionLocalService.getFFPBeneficiaryVersions(
			start, end);
	}

	/**
	 * Returns the number of ffp beneficiary versions.
	 *
	 * @return the number of ffp beneficiary versions
	 */
	@Override
	public int getFFPBeneficiaryVersionsCount() {
		return _ffpBeneficiaryVersionLocalService.
			getFFPBeneficiaryVersionsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ffpBeneficiaryVersionLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ffpBeneficiaryVersionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ffpBeneficiaryVersionLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the ffp beneficiary version in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FFPBeneficiaryVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ffpBeneficiaryVersion the ffp beneficiary version
	 * @return the ffp beneficiary version that was updated
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.FFPBeneficiaryVersion
		updateFFPBeneficiaryVersion(
			bd.gov.dgfood.food.friendly.program.model.FFPBeneficiaryVersion
				ffpBeneficiaryVersion) {

		return _ffpBeneficiaryVersionLocalService.updateFFPBeneficiaryVersion(
			ffpBeneficiaryVersion);
	}

	/**
	 * update status reviewed by admins of FFPB registration
	 *
	 * @param userId
	 * @param beneficiaryId
	 * @param version
	 * @param status
	 * @param serviceContext
	 * @return
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.FFPBeneficiaryVersion
		updateStatus(
			long userId, long beneficiaryId, double version, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _ffpBeneficiaryVersionLocalService.updateStatus(
			userId, beneficiaryId, version, status, serviceContext);
	}

	/**
	 * Update workflow status when admin review profile update request of FFPB
	 *
	 * @param userId
	 * @param beneficiaryVersionId
	 * @param status
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.FFPBeneficiaryVersion
			updateStatus(
				long userId, long beneficiaryVersionId, int status,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _ffpBeneficiaryVersionLocalService.updateStatus(
			userId, beneficiaryVersionId, status, serviceContext);
	}

	@Override
	public FFPBeneficiaryVersionLocalService getWrappedService() {
		return _ffpBeneficiaryVersionLocalService;
	}

	@Override
	public void setWrappedService(
		FFPBeneficiaryVersionLocalService ffpBeneficiaryVersionLocalService) {

		_ffpBeneficiaryVersionLocalService = ffpBeneficiaryVersionLocalService;
	}

	private FFPBeneficiaryVersionLocalService
		_ffpBeneficiaryVersionLocalService;

}