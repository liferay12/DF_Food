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
 * Provides a wrapper for {@link FarmerSalesProposalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FarmerSalesProposalService
 * @generated
 */
public class FarmerSalesProposalServiceWrapper
	implements FarmerSalesProposalService,
			   ServiceWrapper<FarmerSalesProposalService> {

	public FarmerSalesProposalServiceWrapper() {
		this(null);
	}

	public FarmerSalesProposalServiceWrapper(
		FarmerSalesProposalService farmerSalesProposalService) {

		_farmerSalesProposalService = farmerSalesProposalService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _farmerSalesProposalService.getOSGiServiceIdentifier();
	}

	@Override
	public FarmerSalesProposalService getWrappedService() {
		return _farmerSalesProposalService;
	}

	@Override
	public void setWrappedService(
		FarmerSalesProposalService farmerSalesProposalService) {

		_farmerSalesProposalService = farmerSalesProposalService;
	}

	private FarmerSalesProposalService _farmerSalesProposalService;

}