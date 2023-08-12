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

package bd.gov.dgfood.credit.other.priority.customer.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SalesCustomerService}.
 *
 * @author Brian Wing Shun Chan
 * @see SalesCustomerService
 * @generated
 */
public class SalesCustomerServiceWrapper
	implements SalesCustomerService, ServiceWrapper<SalesCustomerService> {

	public SalesCustomerServiceWrapper() {
		this(null);
	}

	public SalesCustomerServiceWrapper(
		SalesCustomerService salesCustomerService) {

		_salesCustomerService = salesCustomerService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _salesCustomerService.getOSGiServiceIdentifier();
	}

	@Override
	public SalesCustomerService getWrappedService() {
		return _salesCustomerService;
	}

	@Override
	public void setWrappedService(SalesCustomerService salesCustomerService) {
		_salesCustomerService = salesCustomerService;
	}

	private SalesCustomerService _salesCustomerService;

}