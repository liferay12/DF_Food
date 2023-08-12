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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.vulcan.multipart.BinaryFile;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for FarmerRegistration. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see FarmerRegistrationServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface FarmerRegistrationService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>bd.gov.dgfood.farmer.information.management.system.service.impl.FarmerRegistrationServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the farmer registration remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link FarmerRegistrationServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * It will add a new Farmer Registration record in the Farmer Registration
	 * master table. Internally it calls the LocalService method only. This method
	 * will be accessable from Liferay JSON-web services.
	 *
	 * @throws bd.gov.dgfood.common.util.validator.DataValidationException
	 * @throws FarmerRegistrationInternalErrorException
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
	 * To get the Farmer Registration data
	 *
	 * @param farmerRegistrationId
	 * @return FarmerRegistration
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FarmerRegistration fetchFarmerRegistration(
		long farmerRegistrationId);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

}