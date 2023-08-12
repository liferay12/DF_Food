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

import bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary;

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
 * Provides the local service utility for FFPBeneficiary. This utility wraps
 * <code>bd.gov.dgfood.food.friendly.program.service.impl.FFPBeneficiaryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FFPBeneficiaryLocalService
 * @generated
 */
public class FFPBeneficiaryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>bd.gov.dgfood.food.friendly.program.service.impl.FFPBeneficiaryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static FFPBeneficiary addBenficiary(
			long userId, String name, long nationalId, String mobileNumber,
			String emailAddress, java.util.Date dateOfBirth, int gender,
			int maritalStatus, String spouseName, String spouseFatherName,
			long spouseNationalId, java.util.Date spouseDateOfBirth,
			String fatherName, String motherName, int familyEarningMembers,
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

		return getService().addBenficiary(
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
	public static FFPBeneficiary addFFPBeneficiary(
		FFPBeneficiary ffpBeneficiary) {

		return getService().addFFPBeneficiary(ffpBeneficiary);
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
	public static int countByKeyWords(
		long companyId, String keywords, int status,
		java.util.LinkedHashMap<String, Object> params,
		Map<String, Serializable> attributes) {

		return getService().countByKeyWords(
			companyId, keywords, status, params, attributes);
	}

	/**
	 * Creates a new ffp beneficiary with the primary key. Does not add the ffp beneficiary to the database.
	 *
	 * @param beneficiaryId the primary key for the new ffp beneficiary
	 * @return the new ffp beneficiary
	 */
	public static FFPBeneficiary createFFPBeneficiary(long beneficiaryId) {
		return getService().createFFPBeneficiary(beneficiaryId);
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
	 * Delete all records (Use only of development purpose)
	 */
	public static void deleteAll() {
		getService().deleteAll();
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
	public static FFPBeneficiary deleteFFPBeneficiary(
		FFPBeneficiary ffpBeneficiary) {

		return getService().deleteFFPBeneficiary(ffpBeneficiary);
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
	public static FFPBeneficiary deleteFFPBeneficiary(long beneficiaryId)
		throws PortalException {

		return getService().deleteFFPBeneficiary(beneficiaryId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.friendly.program.model.impl.FFPBeneficiaryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.friendly.program.model.impl.FFPBeneficiaryModelImpl</code>.
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

	public static FFPBeneficiary fetchFFPBeneficiary(long beneficiaryId) {
		return getService().fetchFFPBeneficiary(beneficiaryId);
	}

	/**
	 * Returns the ffp beneficiary matching the UUID and group.
	 *
	 * @param uuid the ffp beneficiary's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	public static FFPBeneficiary fetchFFPBeneficiaryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchFFPBeneficiaryByUuidAndGroupId(uuid, groupId);
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
	public static List<FFPBeneficiary> findByKeyWords(
		long companyId, String keywords, int start, int end,
		java.util.LinkedHashMap<String, Object> params,
		Map<String, Serializable> attributes) {

		return getService().findByKeyWords(
			companyId, keywords, start, end, params, attributes);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Get beneficiary application by
	 *
	 * @param beneficiaryId
	 * @param dateOfBirth
	 * @return
	 */
	public static FFPBeneficiary getApplication(
		long beneficiaryId, java.util.Date dateOfBirth) {

		return getService().getApplication(beneficiaryId, dateOfBirth);
	}

	/**
	 * Get beneficiary by
	 *
	 * @param nationalId
	 * @return
	 */
	public static FFPBeneficiary getBenificiaryByNationalId(long nationalId) {
		return getService().getBenificiaryByNationalId(nationalId);
	}

	/**
	 * Get beneficiary by
	 *
	 * @param cardNumber
	 * @param dateOfBirth
	 * @return
	 * @throws NoSuchFFPBeneficiaryException
	 */
	public static FFPBeneficiary getBenificiaryDetails(
			String cardNumber, java.util.Date dateOfBirth)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFFPBeneficiaryException {

		return getService().getBenificiaryDetails(cardNumber, dateOfBirth);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
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
	public static List<FFPBeneficiary> getFFPBeneficiaries(int start, int end) {
		return getService().getFFPBeneficiaries(start, end);
	}

	/**
	 * Returns all the ffp beneficiaries matching the UUID and company.
	 *
	 * @param uuid the UUID of the ffp beneficiaries
	 * @param companyId the primary key of the company
	 * @return the matching ffp beneficiaries, or an empty list if no matches were found
	 */
	public static List<FFPBeneficiary> getFFPBeneficiariesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getFFPBeneficiariesByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<FFPBeneficiary> getFFPBeneficiariesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FFPBeneficiary> orderByComparator) {

		return getService().getFFPBeneficiariesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of ffp beneficiaries.
	 *
	 * @return the number of ffp beneficiaries
	 */
	public static int getFFPBeneficiariesCount() {
		return getService().getFFPBeneficiariesCount();
	}

	/**
	 * Returns the ffp beneficiary with the primary key.
	 *
	 * @param beneficiaryId the primary key of the ffp beneficiary
	 * @return the ffp beneficiary
	 * @throws PortalException if a ffp beneficiary with the primary key could not be found
	 */
	public static FFPBeneficiary getFFPBeneficiary(long beneficiaryId)
		throws PortalException {

		return getService().getFFPBeneficiary(beneficiaryId);
	}

	/**
	 * Returns the ffp beneficiary matching the UUID and group.
	 *
	 * @param uuid the ffp beneficiary's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ffp beneficiary
	 * @throws PortalException if a matching ffp beneficiary could not be found
	 */
	public static FFPBeneficiary getFFPBeneficiaryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getFFPBeneficiaryByUuidAndGroupId(uuid, groupId);
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
	 * Updating beneficiary record in DB
	 *
	 * @param ffpRegistrationVersion
	 * @param userId
	 * @param status
	 * @return
	 * @throws NoSuchFFPBeneficiaryException
	 */
	public static FFPBeneficiary updateBenficiary(
			bd.gov.dgfood.food.friendly.program.model.FFPBeneficiaryVersion
				ffpRegistrationVersion,
			long userId, int status)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFFPBeneficiaryException {

		return getService().updateBenficiary(
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
	public static FFPBeneficiary updateFFPBeneficiary(
		FFPBeneficiary ffpBeneficiary) {

		return getService().updateFFPBeneficiary(ffpBeneficiary);
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
	public static FFPBeneficiary updateStatus(
			long userId, long beneficiaryId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		return getService().updateStatus(
			userId, beneficiaryId, status, serviceContext);
	}

	public static FFPBeneficiaryLocalService getService() {
		return _service;
	}

	private static volatile FFPBeneficiaryLocalService _service;

}