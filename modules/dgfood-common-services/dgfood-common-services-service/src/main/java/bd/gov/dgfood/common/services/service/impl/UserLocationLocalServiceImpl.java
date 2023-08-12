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
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.common.services.exception.LocationAssignedException;
import bd.gov.dgfood.common.services.exception.NoLocationExistException;
import bd.gov.dgfood.common.services.exception.UserLocationAlreadyExistException;
import bd.gov.dgfood.common.services.model.UserLocation;
import bd.gov.dgfood.common.services.service.base.UserLocationLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=bd.gov.dgfood.common.services.model.UserLocation", service = AopService.class)
public class UserLocationLocalServiceImpl extends UserLocationLocalServiceBaseImpl {

	/**
	 * @param userId
	 * @param salesOfficeId
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 */
	public UserLocation add(long userId, long locationId, String locationName, String locationCode, String locationType,
			String roleKey, ServiceContext serviceContext) throws PortalException {

		validate(locationId);
        
		UserLocation userLocation1 = userLocationPersistence.fetchByUI_LC_RK(userId, locationCode, roleKey);
		

		if (Validator.isNotNull(userLocation1)) {
			throw new LocationAssignedException(
					"Could not add an entry, " + userLocation1.getLocationName() + " is already tagged to this User");
		}

		if (userLocationPersistence.fetchByRK_LC(roleKey, locationCode) != null) {
			throw new UserLocationAlreadyExistException(
					"Could not add an entry, Role key and Location Code combination already exist. roleKey = " + roleKey
							+ "locationCode" + "locationCode");
		}

		long createdBy = serviceContext.getUserId();

		User user = userLocalService.getUser(createdBy);

		User assigneUser = userLocalService.getUser(userId);

		long id = counterLocalService.increment(UserLocation.class.getName());
		UserLocation userLocation = userLocationPersistence.create(id);
		userLocation.setUserId(assigneUser.getUserId());
		userLocation.setUserName(assigneUser.getFullName());
		userLocation.setLocationCode(locationCode);
		userLocation.setLocationName(locationName);
		userLocation.setLocationType(locationType);
		userLocation.setLocationId(locationId);
		userLocation.setCreatedBy(user.getUserId());
		userLocation.setRoleKey(roleKey);
		return userLocationPersistence.update(userLocation);
	}

	/**
	 * @param locationId
	 * @throws PortalException
	 */
	private void validate(long locationId) throws PortalException {
		if (locationId <= 0) {
			throw new NoLocationExistException();
		}

	}

	/**
	 * @param userLocationId
	 * @param salesOfficeId
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 */
	public UserLocation update(long userLocationId, long locationId, String locationName, String locationCode,
			String roleKey, String locationType, ServiceContext serviceContext) throws PortalException {

		long modifiedBy = serviceContext.getUserId();
		
		UserLocation userLocation = userLocationPersistence.fetchByPrimaryKey(userLocationId);

		UserLocation oldUserLocation = userLocationPersistence.fetchByUI_LC_RK(userLocation.getUserId(), locationCode, roleKey);

		if (oldUserLocation != null && oldUserLocation.getUserId() != userLocation.getUserId()) {
			throw new UserLocationAlreadyExistException(
					"Could not add an entry, Role key and Location Code combination already exist. roleKey = " + roleKey
							+ "locationCode" + "locationCode");
		}

		User user = userLocalService.getUser(modifiedBy);

		userLocation.setLocationCode(locationCode);
		userLocation.setLocationName(locationName);
		userLocation.setLocationType(locationType);
		userLocation.setLocationId(locationId);
		userLocation.setModifiedBy(user.getUserId());
		userLocation.setRoleKey(roleKey);
		return userLocationPersistence.update(userLocation);
	}

	/**
	 * @param userId
	 */
	public List<UserLocation> getUserLocationsByUserId(long userId,int start,int end) {

		return userLocationPersistence.findByUserId(userId, start, end);
	}

	/**
	 * @param locationId
	 */
	public UserLocation getUserLocationByLocationId(long locationId) {

		return userLocationPersistence.fetchByLocationId(locationId);
	}
	/**
	 * @param roleKey
	 * @param locationCode
	 * @return
	 */
	public UserLocation getUserLocationByRK_LC(String roleKey, String locationCode) {
		return userLocationPersistence.fetchByRK_LC(roleKey, locationCode);
	}
	
	/**
	 * @param userId
	 */
	public int getUserLocationsCountByUserId(long userId) {

		return userLocationPersistence.countByUserId(userId);
	}

}