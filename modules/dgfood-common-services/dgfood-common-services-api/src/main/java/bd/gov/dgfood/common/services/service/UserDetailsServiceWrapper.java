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
 * Provides a wrapper for {@link UserDetailsService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserDetailsService
 * @generated
 */
public class UserDetailsServiceWrapper
	implements ServiceWrapper<UserDetailsService>, UserDetailsService {

	public UserDetailsServiceWrapper() {
		this(null);
	}

	public UserDetailsServiceWrapper(UserDetailsService userDetailsService) {
		_userDetailsService = userDetailsService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userDetailsService.getOSGiServiceIdentifier();
	}

	@Override
	public UserDetailsService getWrappedService() {
		return _userDetailsService;
	}

	@Override
	public void setWrappedService(UserDetailsService userDetailsService) {
		_userDetailsService = userDetailsService;
	}

	private UserDetailsService _userDetailsService;

}