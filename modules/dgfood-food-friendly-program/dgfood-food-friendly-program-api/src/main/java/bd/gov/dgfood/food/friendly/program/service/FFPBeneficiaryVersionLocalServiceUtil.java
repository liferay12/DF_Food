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

import bd.gov.dgfood.food.friendly.program.model.FFPBeneficiaryVersion;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for FFPBeneficiaryVersion. This utility wraps
 * <code>bd.gov.dgfood.food.friendly.program.service.impl.FFPBeneficiaryVersionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FFPBeneficiaryVersionLocalService
 * @generated
 */
public class FFPBeneficiaryVersionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>bd.gov.dgfood.food.friendly.program.service.impl.FFPBeneficiaryVersionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static FFPBeneficiaryVersion addBenficiaryVersion(
			long beneficiaryId, long userId, String name, long nationalId,
			String emailAddress, String mobileNumber,
			java.util.Date dateOfBirth, int gender, int maritalStatus,
			String spouseName, String spouseFatherName, long spouseNationalId,
			java.util.Date spouseDateOfBirth, String fatherName,
			String motherName, int familyEarningMembers,
			String familyAverageMonthlyIncome, long permanentRegion,
			long permanentZilla, long permanentUpazilla, long permanentUnion,
			String permanentVillage, long permanentWard, long permanentZipCode,
			String permanentPostOffice, String permanentHouseAddress,
			long presentRegion, long presentZilla, long presentUpazilla,
			long presentUnion, String presentVillage, long presentWard,
			long presentZipCode, String presentPostOffice,
			String presentHouseAddress, boolean sameAsPermanentAddress,
			boolean acknowledge, boolean nonOfMyFamilyMembersRegistered,
			com.liferay.portal.vulcan.multipart.BinaryFile photograph,
			com.liferay.portal.vulcan.multipart.BinaryFile signature,
			List<com.liferay.portal.vulcan.multipart.BinaryFile> additionalDoc,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addBenficiaryVersion(
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
	public static FFPBeneficiaryVersion addBenficiaryVersionHistory(
			long beneficiaryId, long userId, String name, long nationalId,
			String mobileNumber, String emailAddress,
			java.util.Date dateOfBirth, int gender, int maritalStatus,
			String spouseName, String spouseFatherName, long spouseNationalId,
			java.util.Date spouseDateOfBirth, String fatherName,
			String motherName, int familyEarningMembers,
			String familyAverageMonthlyIncome, long permanentRegion,
			long permanentZilla, long permanentUpazilla, long permanentUnion,
			String permanentVillage, long permanentWard, long permanentZipCode,
			String permanentPostOffice, String permanentHouseAddress,
			long presentRegion, long presentZilla, long presentUpazilla,
			long presentUnion, String presentVillage, long presentWard,
			long presentZipCode, String presentPostOffice,
			String presentHouseAddress, boolean sameAsPermanentAddress,
			boolean acknowledge, boolean nonOfMyFamilyMembersRegistred,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addBenficiaryVersionHistory(
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
	public static FFPBeneficiaryVersion addFFPBeneficiaryVersion(
		FFPBeneficiaryVersion ffpBeneficiaryVersion) {

		return getService().addFFPBeneficiaryVersion(ffpBeneficiaryVersion);
	}

	/**
	 * Creates a new ffp beneficiary version with the primary key. Does not add the ffp beneficiary version to the database.
	 *
	 * @param beneficiaryVersionId the primary key for the new ffp beneficiary version
	 * @return the new ffp beneficiary version
	 */
	public static FFPBeneficiaryVersion createFFPBeneficiaryVersion(
		long beneficiaryVersionId) {

		return getService().createFFPBeneficiaryVersion(beneficiaryVersionId);
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
	 * Deletes the ffp beneficiary version from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FFPBeneficiaryVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ffpBeneficiaryVersion the ffp beneficiary version
	 * @return the ffp beneficiary version that was removed
	 */
	public static FFPBeneficiaryVersion deleteFFPBeneficiaryVersion(
		FFPBeneficiaryVersion ffpBeneficiaryVersion) {

		return getService().deleteFFPBeneficiaryVersion(ffpBeneficiaryVersion);
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
	public static FFPBeneficiaryVersion deleteFFPBeneficiaryVersion(
			long beneficiaryVersionId)
		throws PortalException {

		return getService().deleteFFPBeneficiaryVersion(beneficiaryVersionId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.friendly.program.model.impl.FFPBeneficiaryVersionModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.friendly.program.model.impl.FFPBeneficiaryVersionModelImpl</code>.
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

	public static FFPBeneficiaryVersion fetchFFPBeneficiaryVersion(
		long beneficiaryVersionId) {

		return getService().fetchFFPBeneficiaryVersion(beneficiaryVersionId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the ffp beneficiary version with the primary key.
	 *
	 * @param beneficiaryVersionId the primary key of the ffp beneficiary version
	 * @return the ffp beneficiary version
	 * @throws PortalException if a ffp beneficiary version with the primary key could not be found
	 */
	public static FFPBeneficiaryVersion getFFPBeneficiaryVersion(
			long beneficiaryVersionId)
		throws PortalException {

		return getService().getFFPBeneficiaryVersion(beneficiaryVersionId);
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
	public static List<FFPBeneficiaryVersion> getFFPBeneficiaryVersions(
		int start, int end) {

		return getService().getFFPBeneficiaryVersions(start, end);
	}

	/**
	 * Returns the number of ffp beneficiary versions.
	 *
	 * @return the number of ffp beneficiary versions
	 */
	public static int getFFPBeneficiaryVersionsCount() {
		return getService().getFFPBeneficiaryVersionsCount();
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
	 * Updates the ffp beneficiary version in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FFPBeneficiaryVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ffpBeneficiaryVersion the ffp beneficiary version
	 * @return the ffp beneficiary version that was updated
	 */
	public static FFPBeneficiaryVersion updateFFPBeneficiaryVersion(
		FFPBeneficiaryVersion ffpBeneficiaryVersion) {

		return getService().updateFFPBeneficiaryVersion(ffpBeneficiaryVersion);
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
	public static FFPBeneficiaryVersion updateStatus(
		long userId, long beneficiaryId, double version, int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().updateStatus(
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
	public static FFPBeneficiaryVersion updateStatus(
			long userId, long beneficiaryVersionId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		return getService().updateStatus(
			userId, beneficiaryVersionId, status, serviceContext);
	}

	public static FFPBeneficiaryVersionLocalService getService() {
		return _service;
	}

	private static volatile FFPBeneficiaryVersionLocalService _service;

}