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
import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for FarmerRegistration. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see FarmerRegistrationLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface FarmerRegistrationLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>bd.gov.dgfood.farmer.information.management.system.service.impl.FarmerRegistrationLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the farmer registration local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link FarmerRegistrationLocalServiceUtil} if injection and service tracking are not available.
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
	@Indexable(type = IndexableType.REINDEX)
	public FarmerRegistration addFarmerRegistration(
		FarmerRegistration farmerRegistration);

	/**
	 * It will add a new Farmer Registration record in the Farmer Registration
	 * master table
	 */
	public FarmerRegistration addFarmerRegistration(
		String nationalId, String emailAddress, String mobileNumber,
		Date dateOfBirth, String farmerName, String fatherName,
		String motherName, int gender, String krishiCardNumber,
		int maritalStatus, String cultivableLandSeason1Name,
		float cultivableLandSeason1Area, String cultivableLandSeason1Unit,
		String cultivableLandSeason2Name, float cultivableLandSeason2Area,
		String cultivableLandSeason2Unit, String cultivableLandSeason3Name,
		float cultivableLandSeason3Area, String cultivableLandSeason3Unit,
		String farmerCategory, String password, String remarks, long groupId,
		ServiceContext serviceContext);

	/**
	 * Stores Farmer registration Form data by creating Farmer Registration record
	 * along with addition records like Framer address data and attachments
	 *
	 * @throws DataValidationException
	 */
	public FarmerRegistration addFarmerRegistrationFormData(
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
			String presentHouseAddress, BinaryFile profilePhotograph,
			BinaryFile krishiCard, long groupId, ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Creates a new farmer registration with the primary key. Does not add the farmer registration to the database.
	 *
	 * @param farmerRegistrationId the primary key for the new farmer registration
	 * @return the new farmer registration
	 */
	@Transactional(enabled = false)
	public FarmerRegistration createFarmerRegistration(
		long farmerRegistrationId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public FarmerRegistration deleteFarmerRegistration(
		FarmerRegistration farmerRegistration);

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
	@Indexable(type = IndexableType.DELETE)
	public FarmerRegistration deleteFarmerRegistration(
			long farmerRegistrationId)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.farmer.information.management.system.model.impl.FarmerRegistrationModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.farmer.information.management.system.model.impl.FarmerRegistrationModelImpl</code>.
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
	public FarmerRegistration fetchFarmerRegistration(
		long farmerRegistrationId);

	/**
	 * Fetch Farmer Registration record by Application Number
	 *
	 * @param nationalId
	 * @return FarmerRegistration
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FarmerRegistration fetchFarmerRegistrationByApplicationNumber(
		String applicationNumber);

	/**
	 * Fetch Farmer Registration record by Application Number and Date of Birth
	 *
	 * @param nationalId
	 * @param dateOfBirth
	 * @return FarmerRegistration
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FarmerRegistration fetchFarmerRegistrationByApplicationNumberDob(
		String applicationNumber, Date dateOfBirth);

	/**
	 * Fetch Farmer Registration record by Naional Id
	 *
	 * @param nationalId
	 * @return FarmerRegistration
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FarmerRegistration fetchFarmerRegistrationByNationalId(
		String nationalId);

	/**
	 * Fetch Farmer Registration record by Naional Id and Date of birth
	 *
	 * @param nationalId
	 * @param dateOfBirth
	 * @return FarmerRegistration
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FarmerRegistration fetchFarmerRegistrationByNationalIdDob(
		String nationalId, Date dateOfBirth);

	/**
	 * Fetch Farmer Registration record by User Id
	 *
	 * @param userId
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FarmerRegistration fetchFarmerRegistrationByUserId(long userId);

	/**
	 * Returns the farmer registration matching the UUID and group.
	 *
	 * @param uuid the farmer registration's UUID
	 * @param groupId the primary key of the group
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FarmerRegistration fetchFarmerRegistrationByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	/**
	 * Returns the farmer registration with the primary key.
	 *
	 * @param farmerRegistrationId the primary key of the farmer registration
	 * @return the farmer registration
	 * @throws PortalException if a farmer registration with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FarmerRegistration getFarmerRegistration(long farmerRegistrationId)
		throws PortalException;

	/**
	 * Returns the farmer registration matching the UUID and group.
	 *
	 * @param uuid the farmer registration's UUID
	 * @param groupId the primary key of the group
	 * @return the matching farmer registration
	 * @throws PortalException if a matching farmer registration could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FarmerRegistration getFarmerRegistrationByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FarmerRegistration> getFarmerRegistrations(int start, int end);

	/**
	 * Returns all the farmer registrations matching the UUID and company.
	 *
	 * @param uuid the UUID of the farmer registrations
	 * @param companyId the primary key of the company
	 * @return the matching farmer registrations, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FarmerRegistration> getFarmerRegistrationsByUuidAndCompanyId(
		String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FarmerRegistration> getFarmerRegistrationsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FarmerRegistration> orderByComparator);

	/**
	 * Returns the number of farmer registrations.
	 *
	 * @return the number of farmer registrations
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getFarmerRegistrationsCount();

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FarmerRegistration> searchFarmerRegistrations(
		long groupId, Map<String, Object> farmerRegistrationFilterOptions,
		Map<String, Object> addressOptions, String keywords, Date fromDate,
		Date toDate, int start, int end,
		OrderByComparator<FarmerRegistration> orderByComparator);

	/**
	 * Fetch Farmer Registrations count based on search inputs
	 *
	 * @param groupId
	 * @param farmerRegistrationFilterOptions
	 * @param addressOptions
	 * @param keywords
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long searchFarmerRegistrationsCount(
		long groupId, Map<String, Object> farmerRegistrationFilterOptions,
		Map<String, Object> addressOptions, String keywords, Date fromDate,
		Date toDate);

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
	@Indexable(type = IndexableType.REINDEX)
	public FarmerRegistration updateFarmerRegistration(
		FarmerRegistration farmerRegistration);

	public FarmerRegistration updateFarmerRegistration(
		long farmerRegistrationId, String nationalId, String emailAddress,
		String mobileNumber, Date dateOfBirth, String farmerName,
		String fatherName, String motherName, int gender,
		String krishiCardNumber, int maritalStatus,
		String cultivableLandSeason1Name, float cultivableLandSeason1Area,
		String cultivableLandSeason1Unit, String cultivableLandSeason2Name,
		float cultivableLandSeason2Area, String cultivableLandSeason2Unit,
		String cultivableLandSeason3Name, float cultivableLandSeason3Area,
		String cultivableLandSeason3Unit, String farmerCategory,
		String password, String remarks, long groupId,
		ServiceContext serviceContext);

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
	public FarmerRegistration updateStatus(
			long userId, long faremerRegistrationId, int status,
			ServiceContext serviceContext)
		throws PortalException, SystemException;

}