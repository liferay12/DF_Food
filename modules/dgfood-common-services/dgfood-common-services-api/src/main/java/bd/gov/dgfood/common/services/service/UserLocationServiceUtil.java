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

package bd.gov.dgfood.common.services.service;

import bd.gov.dgfood.common.services.model.UserLocation;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * Provides the remote service utility for UserLocation. This utility wraps
 * <code>bd.gov.dgfood.common.services.service.impl.UserLocationServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see UserLocationService
 * @generated
 */
public class UserLocationServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>bd.gov.dgfood.common.services.service.impl.UserLocationServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @param userId
	 * @param locationId
	 * @param locationName
	 * @param locationCode
	 * @param locationType
	 * @return
	 * @throws PortalException
	 */
	public static UserLocation add(
			long userId, long locationId, String locationName,
			String locationCode, String locationType, String roleKey)
		throws PortalException {

		return getService().add(
			userId, locationId, locationName, locationCode, locationType,
			roleKey);
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
	 * @param userLocationId
	 * @param locationId
	 * @param locationName
	 * @param locationCode
	 * @param locationType
	 * @return
	 * @throws PortalException
	 */
	public static UserLocation update(
			long userLocationId, long locationId, String locationName,
			String locationCode, String roleKey, String locationType)
		throws PortalException {

		return getService().update(
			userLocationId, locationId, locationName, locationCode, roleKey,
			locationType);
	}

	public static UserLocationService getService() {
		return _service;
	}

	private static volatile UserLocationService _service;

}