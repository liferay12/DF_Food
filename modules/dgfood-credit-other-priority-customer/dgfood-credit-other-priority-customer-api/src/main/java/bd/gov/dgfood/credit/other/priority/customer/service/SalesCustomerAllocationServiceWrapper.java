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
 * Provides a wrapper for {@link SalesCustomerAllocationService}.
 *
 * @author Brian Wing Shun Chan
 * @see SalesCustomerAllocationService
 * @generated
 */
public class SalesCustomerAllocationServiceWrapper
	implements SalesCustomerAllocationService,
			   ServiceWrapper<SalesCustomerAllocationService> {

	public SalesCustomerAllocationServiceWrapper() {
		this(null);
	}

	public SalesCustomerAllocationServiceWrapper(
		SalesCustomerAllocationService salesCustomerAllocationService) {

		_salesCustomerAllocationService = salesCustomerAllocationService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _salesCustomerAllocationService.getOSGiServiceIdentifier();
	}

	@Override
	public SalesCustomerAllocationService getWrappedService() {
		return _salesCustomerAllocationService;
	}

	@Override
	public void setWrappedService(
		SalesCustomerAllocationService salesCustomerAllocationService) {

		_salesCustomerAllocationService = salesCustomerAllocationService;
	}

	private SalesCustomerAllocationService _salesCustomerAllocationService;

}