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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for UserLocation. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see UserLocationServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface UserLocationService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>bd.gov.dgfood.common.services.service.impl.UserLocationServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the user location remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link UserLocationServiceUtil} if injection and service tracking are not available.
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
	public UserLocation add(
			long userId, long locationId, String locationName,
			String locationCode, String locationType, String roleKey)
		throws PortalException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @param userLocationId
	 * @param locationId
	 * @param locationName
	 * @param locationCode
	 * @param locationType
	 * @return
	 * @throws PortalException
	 */
	public UserLocation update(
			long userLocationId, long locationId, String locationName,
			String locationCode, String roleKey, String locationType)
		throws PortalException;

}