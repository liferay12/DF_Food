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

package bd.gov.dgfood.license.management.system.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FGLicenseDetailsService}.
 *
 * @author Brian Wing Shun Chan
 * @see FGLicenseDetailsService
 * @generated
 */
public class FGLicenseDetailsServiceWrapper
	implements FGLicenseDetailsService,
			   ServiceWrapper<FGLicenseDetailsService> {

	public FGLicenseDetailsServiceWrapper() {
		this(null);
	}

	public FGLicenseDetailsServiceWrapper(
		FGLicenseDetailsService fgLicenseDetailsService) {

		_fgLicenseDetailsService = fgLicenseDetailsService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _fgLicenseDetailsService.getOSGiServiceIdentifier();
	}

	@Override
	public FGLicenseDetailsService getWrappedService() {
		return _fgLicenseDetailsService;
	}

	@Override
	public void setWrappedService(
		FGLicenseDetailsService fgLicenseDetailsService) {

		_fgLicenseDetailsService = fgLicenseDetailsService;
	}

	private FGLicenseDetailsService _fgLicenseDetailsService;

}