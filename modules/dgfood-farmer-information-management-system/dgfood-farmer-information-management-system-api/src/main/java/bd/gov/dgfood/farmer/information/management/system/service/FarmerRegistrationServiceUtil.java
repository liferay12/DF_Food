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

/**
 * Provides the remote service utility for FarmerRegistration. This utility wraps
 * <code>bd.gov.dgfood.farmer.information.management.system.service.impl.FarmerRegistrationServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see FarmerRegistrationService
 * @generated
 */
public class FarmerRegistrationServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>bd.gov.dgfood.farmer.information.management.system.service.impl.FarmerRegistrationServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * It will add a new Farmer Registration record in the Farmer Registration
	 * master table. Internally it calls the LocalService method only. This method
	 * will be accessable from Liferay JSON-web services.
	 *
	 * @throws bd.gov.dgfood.common.util.validator.DataValidationException
	 * @throws FarmerRegistrationInternalErrorException
	 */
	public static FarmerRegistration addFarmerRegistrationFormData(
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
			String presentHouseAddress,
			com.liferay.portal.vulcan.multipart.BinaryFile profilePhotograph,
			com.liferay.portal.vulcan.multipart.BinaryFile krishiCard,
			long groupId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addFarmerRegistrationFormData(
			isHeadlessRequest, nationalId, emailAddress, mobileNumber,
			dateOfBirth, farmerName, fatherName, motherName, gender,
			krishiCardNumber, maritalStatus, cultivableLandSeason1Name,
			cultivableLandSeason1Area, cultivableLandSeason1Unit,
			cultivableLandSeason2Name, cultivableLandSeason2Area,
			cultivableLandSeason2Unit, cultivableLandSeason3Name,
			cultivableLandSeason3Area, cultivableLandSeason3Unit,
			farmerCategory, password, remarks, permanentRegion, permanentZilla,
			permanentUpazila, permanentCityCorporationOrMunicipality,
			permanentUnionOrWard, permanentZipCode, permanentPostOffice,
			permanentVillageOrRoad, permanentMouzaOrMoholla,
			permanentHouseAddress, presentRegion, presentZilla, presentUpazila,
			presentCityCorporationOrMunicipality, presentUnionOrWard,
			presentZipCode, presentPostOffice, presentVillageOrRoad,
			presentMouzaOrMoholla, presentHouseAddress, profilePhotograph,
			krishiCard, groupId, serviceContext);
	}

	/**
	 * To get the Farmer Registration data
	 *
	 * @param farmerRegistrationId
	 * @return FarmerRegistration
	 */
	public static FarmerRegistration fetchFarmerRegistration(
		long farmerRegistrationId) {

		return getService().fetchFarmerRegistration(farmerRegistrationId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static FarmerRegistrationService getService() {
		return _service;
	}

	private static volatile FarmerRegistrationService _service;

}