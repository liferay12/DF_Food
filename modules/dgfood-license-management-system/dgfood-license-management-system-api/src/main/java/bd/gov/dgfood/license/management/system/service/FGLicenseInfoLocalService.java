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

import bd.gov.dgfood.license.management.system.model.FGLicenseInfo;

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

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for FGLicenseInfo. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see FGLicenseInfoLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface FGLicenseInfoLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>bd.gov.dgfood.license.management.system.service.impl.FGLicenseInfoLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the fg license info local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link FGLicenseInfoLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * This method is used to store the New Foodgrain License application data.
	 *
	 * @throws PortalException
	 */
	public FGLicenseInfo addFGLicenseFormData(
			String nationalId, String mobileNumber, Date dateOfBirth,
			String emailAddress, String password, String applicantName,
			int gender, int maritalStatus, String fatherName, String motherName,
			String tradeLicenseNo, Date tradeLicenseExpiryDate,
			String tradeLicenseIssuerCode, String tradeLicenseIssuerCity,
			String taxIdentificationNumber, String businessIdentificationNumber,
			long permanentRegion, long permanentDistrict, long permanentUpazila,
			long permanentCityCorporationOrMunicipality,
			long permanentUnionOrWard, long permanentZipCode,
			String permanentPostOffice, String permanentVillageOrRoad,
			String permanentMouzaOrMoholla, String permanentHouseAddress,
			long presentRegion, long presentDistrict, long presentUpazila,
			long presentCityCorporationOrMunicipality, long presentUnionOrWard,
			long presentZipCode, String presentPostOffice,
			String presentVillageOrRoad, String presentMouzaOrMoholla,
			String presentHouseAddress, String businessName,
			String businessType, long businessRegion, long businessDistrict,
			long businessUpazila, long businessCityCorporationOrMunicipality,
			long businessUnionOrWard, long businessZipCode,
			String businessPostOffice, String businessVillageOrRoad,
			String businessMouzaOrMoholla, String businessHouseAddress,
			long profilePhotographDocId, long tradeLicenseDocId,
			long businessIdentificationNumberDocId,
			long taxIdentificationNumberDocId, long bankStatementDocId,
			ServiceContext serviceContext)
		throws PortalException;

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
	@Indexable(type = IndexableType.REINDEX)
	public FGLicenseInfo addFGLicenseInfo(FGLicenseInfo fgLicenseInfo);

	/**
	 * Create a new record in Foodgrain License Info table It stores the basic
	 * information of FG Licensee Registration form.
	 */
	public FGLicenseInfo addFgLicenseInfo(
		long fgLicenseMasterId, String nationalId, String applicationNumber,
		String tradeLicenseNumber, String applicantName, String businessName,
		String businessType, String division, String district, String upazila,
		long businessAddressId, String applicationType,
		ServiceContext serviceContext);

	/**
	 * Creates a new fg license info with the primary key. Does not add the fg license info to the database.
	 *
	 * @param fgLicenseInfoId the primary key for the new fg license info
	 * @return the new fg license info
	 */
	@Transactional(enabled = false)
	public FGLicenseInfo createFGLicenseInfo(long fgLicenseInfoId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public FGLicenseInfo deleteFGLicenseInfo(FGLicenseInfo fgLicenseInfo);

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
	@Indexable(type = IndexableType.DELETE)
	public FGLicenseInfo deleteFGLicenseInfo(long fgLicenseInfoId)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.license.management.system.model.impl.FGLicenseInfoModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.license.management.system.model.impl.FGLicenseInfoModelImpl</code>.
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

	/**
	 * Fetch the FG License application by Application Number
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FGLicenseInfo fetchFGLicenseByApplicationNumber(
		String applicationNumber);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FGLicenseInfo fetchFGLicenseInfo(long fgLicenseInfoId);

	/**
	 * Returns the fg license info matching the UUID and group.
	 *
	 * @param uuid the fg license info's UUID
	 * @param groupId the primary key of the group
	 * @return the matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FGLicenseInfo fetchFGLicenseInfoByUuidAndGroupId(
		String uuid, long groupId);

	/**
	 * This method is used to fetch FG licenses with application number, date of
	 * birth and National Id. It compares dateofbirth and NID from user_ table as
	 * well.
	 *
	 * @throws Exception
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FGLicenseInfo fetchFGLicenseWithApplicationNumberNIDDateOfBirth(
			ServiceContext serviceContext, String applicationNumber,
			String nationalId, Date dateOfBirth)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns number of New Foodgrain License Applications available for the given
	 * National id
	 *
	 * @param nationalId
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getActiveFGLicenseCountByNationalId(String nationalId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	/**
	 * Returns the fg license info with the primary key.
	 *
	 * @param fgLicenseInfoId the primary key of the fg license info
	 * @return the fg license info
	 * @throws PortalException if a fg license info with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FGLicenseInfo getFGLicenseInfo(long fgLicenseInfoId)
		throws PortalException;

	/**
	 * Returns the fg license info matching the UUID and group.
	 *
	 * @param uuid the fg license info's UUID
	 * @param groupId the primary key of the group
	 * @return the matching fg license info
	 * @throws PortalException if a matching fg license info could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FGLicenseInfo getFGLicenseInfoByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FGLicenseInfo> getFGLicenseInfos(int start, int end);

	/**
	 * Returns all the fg license infos matching the UUID and company.
	 *
	 * @param uuid the UUID of the fg license infos
	 * @param companyId the primary key of the company
	 * @return the matching fg license infos, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FGLicenseInfo> getFGLicenseInfosByUuidAndCompanyId(
		String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FGLicenseInfo> getFGLicenseInfosByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FGLicenseInfo> orderByComparator);

	/**
	 * Returns the number of fg license infos.
	 *
	 * @return the number of fg license infos
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getFGLicenseInfosCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * Returns number of new Foodgrain License application are in pending state for
	 * the given National id
	 *
	 * @param nationalId
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getPendingFGLicenseCountByNationalId(String nationalId);

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * fetch the records based on the curent user location and other search & filter
	 * options.
	 *
	 * Search & filter optional are optional
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FGLicenseInfo> searchFGLicenseRecords(
		long groupId, Map<String, Object> filterOptions, String locationName,
		String locationValue, String keywords, Date fromDate, Date toDate,
		int start, int end, OrderByComparator<FGLicenseInfo> orderByComparator);

	/**
	 * Fetch the number of records are available based on the curent user location
	 * and other search & filter options.
	 *
	 * Search & filter optional are optional
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long searchFGLicenseRecordsCount(
		long groupId, Map<String, Object> filterOptions, String locationName,
		String locationValue, String keywords, Date fromDate, Date toDate);

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
	@Indexable(type = IndexableType.REINDEX)
	public FGLicenseInfo updateFGLicenseInfo(FGLicenseInfo fgLicenseInfo);

}