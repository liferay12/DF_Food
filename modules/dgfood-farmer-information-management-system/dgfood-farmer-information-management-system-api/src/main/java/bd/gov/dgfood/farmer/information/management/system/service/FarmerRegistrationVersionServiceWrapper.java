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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FarmerRegistrationVersionService}.
 *
 * @author Brian Wing Shun Chan
 * @see FarmerRegistrationVersionService
 * @generated
 */
public class FarmerRegistrationVersionServiceWrapper
	implements FarmerRegistrationVersionService,
			   ServiceWrapper<FarmerRegistrationVersionService> {

	public FarmerRegistrationVersionServiceWrapper() {
		this(null);
	}

	public FarmerRegistrationVersionServiceWrapper(
		FarmerRegistrationVersionService farmerRegistrationVersionService) {

		_farmerRegistrationVersionService = farmerRegistrationVersionService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _farmerRegistrationVersionService.getOSGiServiceIdentifier();
	}

	@Override
	public FarmerRegistrationVersionService getWrappedService() {
		return _farmerRegistrationVersionService;
	}

	@Override
	public void setWrappedService(
		FarmerRegistrationVersionService farmerRegistrationVersionService) {

		_farmerRegistrationVersionService = farmerRegistrationVersionService;
	}

	private FarmerRegistrationVersionService _farmerRegistrationVersionService;

}