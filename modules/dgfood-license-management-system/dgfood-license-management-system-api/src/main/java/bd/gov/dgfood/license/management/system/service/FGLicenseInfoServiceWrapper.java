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
 * Provides a wrapper for {@link FGLicenseInfoService}.
 *
 * @author Brian Wing Shun Chan
 * @see FGLicenseInfoService
 * @generated
 */
public class FGLicenseInfoServiceWrapper
	implements FGLicenseInfoService, ServiceWrapper<FGLicenseInfoService> {

	public FGLicenseInfoServiceWrapper() {
		this(null);
	}

	public FGLicenseInfoServiceWrapper(
		FGLicenseInfoService fgLicenseInfoService) {

		_fgLicenseInfoService = fgLicenseInfoService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _fgLicenseInfoService.getOSGiServiceIdentifier();
	}

	@Override
	public FGLicenseInfoService getWrappedService() {
		return _fgLicenseInfoService;
	}

	@Override
	public void setWrappedService(FGLicenseInfoService fgLicenseInfoService) {
		_fgLicenseInfoService = fgLicenseInfoService;
	}

	private FGLicenseInfoService _fgLicenseInfoService;

}