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

package bd.gov.dgfood.common.services.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.common.services.model.UserLocation;
import bd.gov.dgfood.common.services.service.base.UserLocationServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = { "json.web.service.context.name=",
		"json.web.service.context.path=UserLocation" }, service = AopService.class)
public class UserLocationServiceImpl extends UserLocationServiceBaseImpl {

	/**
	 * @param userId
	 * @param locationId
	 * @param locationName
	 * @param locationCode
	 * @param locationType
	 * @return
	 * @throws PortalException
	 */
	public UserLocation add(long userId, long locationId, String locationName, String locationCode, String locationType,String roleKey)
			throws PortalException {
		return userLocationLocalService.add(userId, locationId, locationName, locationCode, locationType,roleKey,
				ServiceContextThreadLocal.getServiceContext());

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
	public UserLocation update(long userLocationId, long locationId, String locationName, String locationCode,String roleKey,
			String locationType) throws PortalException {
		return userLocationLocalService.update(userLocationId, locationId, locationName, locationCode, roleKey,locationType,
				ServiceContextThreadLocal.getServiceContext());
	}

}