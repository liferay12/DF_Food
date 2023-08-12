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
 * Provides a wrapper for {@link SalesCustomerVersionService}.
 *
 * @author Brian Wing Shun Chan
 * @see SalesCustomerVersionService
 * @generated
 */
public class SalesCustomerVersionServiceWrapper
	implements SalesCustomerVersionService,
			   ServiceWrapper<SalesCustomerVersionService> {

	public SalesCustomerVersionServiceWrapper() {
		this(null);
	}

	public SalesCustomerVersionServiceWrapper(
		SalesCustomerVersionService salesCustomerVersionService) {

		_salesCustomerVersionService = salesCustomerVersionService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _salesCustomerVersionService.getOSGiServiceIdentifier();
	}

	@Override
	public SalesCustomerVersionService getWrappedService() {
		return _salesCustomerVersionService;
	}

	@Override
	public void setWrappedService(
		SalesCustomerVersionService salesCustomerVersionService) {

		_salesCustomerVersionService = salesCustomerVersionService;
	}

	private SalesCustomerVersionService _salesCustomerVersionService;

}