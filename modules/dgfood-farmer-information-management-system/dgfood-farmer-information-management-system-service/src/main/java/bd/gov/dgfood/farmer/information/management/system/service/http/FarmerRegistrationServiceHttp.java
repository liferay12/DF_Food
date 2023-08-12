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

package bd.gov.dgfood.farmer.information.management.system.service.http;

import bd.gov.dgfood.farmer.information.management.system.service.FarmerRegistrationServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>FarmerRegistrationServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FarmerRegistrationServiceHttp {

	public static
		bd.gov.dgfood.farmer.information.management.system.model.
			FarmerRegistration addFarmerRegistrationFormData(
					HttpPrincipal httpPrincipal, boolean isHeadlessRequest,
					String nationalId, String emailAddress, String mobileNumber,
					String dateOfBirth, String farmerName, String fatherName,
					String motherName, int gender, String krishiCardNumber,
					int maritalStatus, String cultivableLandSeason1Name,
					float cultivableLandSeason1Area,
					String cultivableLandSeason1Unit,
					String cultivableLandSeason2Name,
					float cultivableLandSeason2Area,
					String cultivableLandSeason2Unit,
					String cultivableLandSeason3Name,
					float cultivableLandSeason3Area,
					String cultivableLandSeason3Unit, String farmerCategory,
					String password, String remarks, long permanentRegion,
					long permanentZilla, long permanentUpazila,
					long permanentCityCorporationOrMunicipality,
					long permanentUnionOrWard, long permanentZipCode,
					String permanentPostOffice, String permanentVillageOrRoad,
					String permanentMouzaOrMoholla,
					String permanentHouseAddress, long presentRegion,
					long presentZilla, long presentUpazila,
					long presentCityCorporationOrMunicipality,
					long presentUnionOrWard, long presentZipCode,
					String presentPostOffice, String presentVillageOrRoad,
					String presentMouzaOrMoholla, String presentHouseAddress,
					com.liferay.portal.vulcan.multipart.BinaryFile
						profilePhotograph,
					com.liferay.portal.vulcan.multipart.BinaryFile krishiCard,
					long groupId,
					com.liferay.portal.kernel.service.ServiceContext
						serviceContext)
				throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				FarmerRegistrationServiceUtil.class,
				"addFarmerRegistrationFormData",
				_addFarmerRegistrationFormDataParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, isHeadlessRequest, nationalId, emailAddress,
				mobileNumber, dateOfBirth, farmerName, fatherName, motherName,
				gender, krishiCardNumber, maritalStatus,
				cultivableLandSeason1Name, cultivableLandSeason1Area,
				cultivableLandSeason1Unit, cultivableLandSeason2Name,
				cultivableLandSeason2Area, cultivableLandSeason2Unit,
				cultivableLandSeason3Name, cultivableLandSeason3Area,
				cultivableLandSeason3Unit, farmerCategory, password, remarks,
				permanentRegion, permanentZilla, permanentUpazila,
				permanentCityCorporationOrMunicipality, permanentUnionOrWard,
				permanentZipCode, permanentPostOffice, permanentVillageOrRoad,
				permanentMouzaOrMoholla, permanentHouseAddress, presentRegion,
				presentZilla, presentUpazila,
				presentCityCorporationOrMunicipality, presentUnionOrWard,
				presentZipCode, presentPostOffice, presentVillageOrRoad,
				presentMouzaOrMoholla, presentHouseAddress, profilePhotograph,
				krishiCard, groupId, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (bd.gov.dgfood.farmer.information.management.system.model.
				FarmerRegistration)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static
		bd.gov.dgfood.farmer.information.management.system.model.
			FarmerRegistration fetchFarmerRegistration(
				HttpPrincipal httpPrincipal, long farmerRegistrationId) {

		try {
			MethodKey methodKey = new MethodKey(
				FarmerRegistrationServiceUtil.class, "fetchFarmerRegistration",
				_fetchFarmerRegistrationParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, farmerRegistrationId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (bd.gov.dgfood.farmer.information.management.system.model.
				FarmerRegistration)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		FarmerRegistrationServiceHttp.class);

	private static final Class<?>[]
		_addFarmerRegistrationFormDataParameterTypes0 = new Class[] {
			boolean.class, String.class, String.class, String.class,
			String.class, String.class, String.class, String.class, int.class,
			String.class, int.class, String.class, float.class, String.class,
			String.class, float.class, String.class, String.class, float.class,
			String.class, String.class, String.class, String.class, long.class,
			long.class, long.class, long.class, long.class, long.class,
			String.class, String.class, String.class, String.class, long.class,
			long.class, long.class, long.class, long.class, long.class,
			String.class, String.class, String.class, String.class,
			com.liferay.portal.vulcan.multipart.BinaryFile.class,
			com.liferay.portal.vulcan.multipart.BinaryFile.class, long.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _fetchFarmerRegistrationParameterTypes1 =
		new Class[] {long.class};

}