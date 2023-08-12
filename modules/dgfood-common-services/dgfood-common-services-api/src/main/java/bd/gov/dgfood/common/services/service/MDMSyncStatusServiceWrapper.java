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
 * Provides a wrapper for {@link MDMSyncStatusService}.
 *
 * @author Brian Wing Shun Chan
 * @see MDMSyncStatusService
 * @generated
 */
public class MDMSyncStatusServiceWrapper
	implements MDMSyncStatusService, ServiceWrapper<MDMSyncStatusService> {

	public MDMSyncStatusServiceWrapper() {
		this(null);
	}

	public MDMSyncStatusServiceWrapper(
		MDMSyncStatusService mdmSyncStatusService) {

		_mdmSyncStatusService = mdmSyncStatusService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _mdmSyncStatusService.getOSGiServiceIdentifier();
	}

	@Override
	public MDMSyncStatusService getWrappedService() {
		return _mdmSyncStatusService;
	}

	@Override
	public void setWrappedService(MDMSyncStatusService mdmSyncStatusService) {
		_mdmSyncStatusService = mdmSyncStatusService;
	}

	private MDMSyncStatusService _mdmSyncStatusService;

}