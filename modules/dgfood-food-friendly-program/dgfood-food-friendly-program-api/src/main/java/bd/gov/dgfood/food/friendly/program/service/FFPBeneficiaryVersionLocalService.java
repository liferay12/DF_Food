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
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
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
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for FFPBeneficiaryVersion. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see FFPBeneficiaryVersionLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface FFPBeneficiaryVersionLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>bd.gov.dgfood.food.friendly.program.service.impl.FFPBeneficiaryVersionLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the ffp beneficiary version local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link FFPBeneficiaryVersionLocalServiceUtil} if injection and service tracking are not available.
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
	public FFPBeneficiaryVersion addBenficiaryVersion(
			long beneficiaryId, long userId, String name, long nationalId,
			String emailAddress, String mobileNumber, Date dateOfBirth,
			int gender, int maritalStatus, String spouseName,
			String spouseFatherName, long spouseNationalId,
			Date spouseDateOfBirth, String fatherName, String motherName,
			int familyEarningMembers, String familyAverageMonthlyIncome,
			long permanentRegion, long permanentZilla, long permanentUpazilla,
			long permanentUnion, String permanentVillage, long permanentWard,
			long permanentZipCode, String permanentPostOffice,
			String permanentHouseAddress, long presentRegion, long presentZilla,
			long presentUpazilla, long presentUnion, String presentVillage,
			long presentWard, long presentZipCode, String presentPostOffice,
			String presentHouseAddress, boolean sameAsPermanentAddress,
			boolean acknowledge, boolean nonOfMyFamilyMembersRegistered,
			BinaryFile photograph, BinaryFile signature,
			List<BinaryFile> additionalDoc, ServiceContext serviceContext)
		throws PortalException;

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
	public FFPBeneficiaryVersion addBenficiaryVersionHistory(
			long beneficiaryId, long userId, String name, long nationalId,
			String mobileNumber, String emailAddress, Date dateOfBirth,
			int gender, int maritalStatus, String spouseName,
			String spouseFatherName, long spouseNationalId,
			Date spouseDateOfBirth, String fatherName, String motherName,
			int familyEarningMembers, String familyAverageMonthlyIncome,
			long permanentRegion, long permanentZilla, long permanentUpazilla,
			long permanentUnion, String permanentVillage, long permanentWard,
			long permanentZipCode, String permanentPostOffice,
			String permanentHouseAddress, long presentRegion, long presentZilla,
			long presentUpazilla, long presentUnion, String presentVillage,
			long presentWard, long presentZipCode, String presentPostOffice,
			String presentHouseAddress, boolean sameAsPermanentAddress,
			boolean acknowledge, boolean nonOfMyFamilyMembersRegistred,
			ServiceContext serviceContext)
		throws PortalException;

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
	@Indexable(type = IndexableType.REINDEX)
	public FFPBeneficiaryVersion addFFPBeneficiaryVersion(
		FFPBeneficiaryVersion ffpBeneficiaryVersion);

	/**
	 * Creates a new ffp beneficiary version with the primary key. Does not add the ffp beneficiary version to the database.
	 *
	 * @param beneficiaryVersionId the primary key for the new ffp beneficiary version
	 * @return the new ffp beneficiary version
	 */
	@Transactional(enabled = false)
	public FFPBeneficiaryVersion createFFPBeneficiaryVersion(
		long beneficiaryVersionId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public FFPBeneficiaryVersion deleteFFPBeneficiaryVersion(
		FFPBeneficiaryVersion ffpBeneficiaryVersion);

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
	@Indexable(type = IndexableType.DELETE)
	public FFPBeneficiaryVersion deleteFFPBeneficiaryVersion(
			long beneficiaryVersionId)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.friendly.program.model.impl.FFPBeneficiaryVersionModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.friendly.program.model.impl.FFPBeneficiaryVersionModelImpl</code>.
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
	public FFPBeneficiaryVersion fetchFFPBeneficiaryVersion(
		long beneficiaryVersionId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the ffp beneficiary version with the primary key.
	 *
	 * @param beneficiaryVersionId the primary key of the ffp beneficiary version
	 * @return the ffp beneficiary version
	 * @throws PortalException if a ffp beneficiary version with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FFPBeneficiaryVersion getFFPBeneficiaryVersion(
			long beneficiaryVersionId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FFPBeneficiaryVersion> getFFPBeneficiaryVersions(
		int start, int end);

	/**
	 * Returns the number of ffp beneficiary versions.
	 *
	 * @return the number of ffp beneficiary versions
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getFFPBeneficiaryVersionsCount();

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
	 * Updates the ffp beneficiary version in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FFPBeneficiaryVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ffpBeneficiaryVersion the ffp beneficiary version
	 * @return the ffp beneficiary version that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public FFPBeneficiaryVersion updateFFPBeneficiaryVersion(
		FFPBeneficiaryVersion ffpBeneficiaryVersion);

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
	public FFPBeneficiaryVersion updateStatus(
		long userId, long beneficiaryId, double version, int status,
		ServiceContext serviceContext);

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
	public FFPBeneficiaryVersion updateStatus(
			long userId, long beneficiaryVersionId, int status,
			ServiceContext serviceContext)
		throws PortalException, SystemException;

}