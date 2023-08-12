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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserLocationService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserLocationService
 * @generated
 */
public class UserLocationServiceWrapper
	implements ServiceWrapper<UserLocationService>, UserLocationService {

	public UserLocationServiceWrapper() {
		this(null);
	}

	public UserLocationServiceWrapper(UserLocationService userLocationService) {
		_userLocationService = userLocationService;
	}

	/**
	 * @param userId
	 * @param locationId
	 * @param locationName
	 * @param locationCode
	 * @param locationType
	 * @return
	 * @throws PortalException
	 */
	@Override
	public bd.gov.dgfood.common.services.model.UserLocation add(
			long userId, long locationId, String locationName,
			String locationCode, String locationType, String roleKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userLocationService.add(
			userId, locationId, locationName, locationCode, locationType,
			roleKey);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userLocationService.getOSGiServiceIdentifier();
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
	@Override
	public bd.gov.dgfood.common.services.model.UserLocation update(
			long userLocationId, long locationId, String locationName,
			String locationCode, String roleKey, String locationType)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userLocationService.update(
			userLocationId, locationId, locationName, locationCode, roleKey,
			locationType);
	}

	@Override
	public UserLocationService getWrappedService() {
		return _userLocationService;
	}

	@Override
	public void setWrappedService(UserLocationService userLocationService) {
		_userLocationService = userLocationService;
	}

	private UserLocationService _userLocationService;

}