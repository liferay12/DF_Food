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

import bd.gov.dgfood.food.friendly.program.exception.NoSuchFFPBeneficiaryException;
import bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary;
import bd.gov.dgfood.food.friendly.program.model.FFPBeneficiaryVersion;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.vulcan.multipart.BinaryFile;

import java.io.Serializable;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for FFPBeneficiary. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see FFPBeneficiaryLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface FFPBeneficiaryLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>bd.gov.dgfood.food.friendly.program.service.impl.FFPBeneficiaryLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the ffp beneficiary local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link FFPBeneficiaryLocalServiceUtil} if injection and service tracking are not available.
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
	public FFPBeneficiary addBenficiary(
			long userId, String name, long nationalId, String mobileNumber,
			String emailAddress, Date dateOfBirth, int gender,
			int maritalStatus, String spouseName, String spouseFatherName,
			long spouseNationalId, Date spouseDateOfBirth, String fatherName,
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
			BinaryFile photograph, BinaryFile signature,
			List<BinaryFile> additionalDoc, ServiceContext serviceContext)
		throws PortalException;

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
	@Indexable(type = IndexableType.REINDEX)
	public FFPBeneficiary addFFPBeneficiary(FFPBeneficiary ffpBeneficiary);

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
	public int countByKeyWords(
		long companyId, String keywords, int status,
		LinkedHashMap<String, Object> params,
		Map<String, Serializable> attributes);

	/**
	 * Creates a new ffp beneficiary with the primary key. Does not add the ffp beneficiary to the database.
	 *
	 * @param beneficiaryId the primary key for the new ffp beneficiary
	 * @return the new ffp beneficiary
	 */
	@Transactional(enabled = false)
	public FFPBeneficiary createFFPBeneficiary(long beneficiaryId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Delete all records (Use only of development purpose)
	 */
	public void deleteAll();

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
	@Indexable(type = IndexableType.DELETE)
	public FFPBeneficiary deleteFFPBeneficiary(FFPBeneficiary ffpBeneficiary);

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
	@Indexable(type = IndexableType.DELETE)
	public FFPBeneficiary deleteFFPBeneficiary(long beneficiaryId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FFPBeneficiary fetchFFPBeneficiary(long beneficiaryId);

	/**
	 * Returns the ffp beneficiary matching the UUID and group.
	 *
	 * @param uuid the ffp beneficiary's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FFPBeneficiary fetchFFPBeneficiaryByUuidAndGroupId(
		String uuid, long groupId);

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
	public List<FFPBeneficiary> findByKeyWords(
		long companyId, String keywords, int start, int end,
		LinkedHashMap<String, Object> params,
		Map<String, Serializable> attributes);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Get beneficiary application by
	 *
	 * @param beneficiaryId
	 * @param dateOfBirth
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FFPBeneficiary getApplication(long beneficiaryId, Date dateOfBirth);

	/**
	 * Get beneficiary by
	 *
	 * @param nationalId
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FFPBeneficiary getBenificiaryByNationalId(long nationalId);

	/**
	 * Get beneficiary by
	 *
	 * @param cardNumber
	 * @param dateOfBirth
	 * @return
	 * @throws NoSuchFFPBeneficiaryException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FFPBeneficiary getBenificiaryDetails(
			String cardNumber, Date dateOfBirth)
		throws NoSuchFFPBeneficiaryException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FFPBeneficiary> getFFPBeneficiaries(int start, int end);

	/**
	 * Returns all the ffp beneficiaries matching the UUID and company.
	 *
	 * @param uuid the UUID of the ffp beneficiaries
	 * @param companyId the primary key of the company
	 * @return the matching ffp beneficiaries, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FFPBeneficiary> getFFPBeneficiariesByUuidAndCompanyId(
		String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FFPBeneficiary> getFFPBeneficiariesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FFPBeneficiary> orderByComparator);

	/**
	 * Returns the number of ffp beneficiaries.
	 *
	 * @return the number of ffp beneficiaries
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getFFPBeneficiariesCount();

	/**
	 * Returns the ffp beneficiary with the primary key.
	 *
	 * @param beneficiaryId the primary key of the ffp beneficiary
	 * @return the ffp beneficiary
	 * @throws PortalException if a ffp beneficiary with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FFPBeneficiary getFFPBeneficiary(long beneficiaryId)
		throws PortalException;

	/**
	 * Returns the ffp beneficiary matching the UUID and group.
	 *
	 * @param uuid the ffp beneficiary's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ffp beneficiary
	 * @throws PortalException if a matching ffp beneficiary could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FFPBeneficiary getFFPBeneficiaryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Updating beneficiary record in DB
	 *
	 * @param ffpRegistrationVersion
	 * @param userId
	 * @param status
	 * @return
	 * @throws NoSuchFFPBeneficiaryException
	 */
	public FFPBeneficiary updateBenficiary(
			FFPBeneficiaryVersion ffpRegistrationVersion, long userId,
			int status)
		throws NoSuchFFPBeneficiaryException;

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
	@Indexable(type = IndexableType.REINDEX)
	public FFPBeneficiary updateFFPBeneficiary(FFPBeneficiary ffpBeneficiary);

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
	public FFPBeneficiary updateStatus(
			long userId, long beneficiaryId, int status,
			ServiceContext serviceContext)
		throws PortalException, SystemException;

}