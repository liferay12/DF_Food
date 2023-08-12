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

package bd.gov.dgfood.farmer.information.management.system.service.impl;

import bd.gov.dgfood.farmer.information.management.system.service.base.FarmerSalesProposalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the farmer sales proposal remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>bd.gov.dgfood.farmer.information.management.system.service.FarmerSalesProposalService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FarmerSalesProposalServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=dgfood",
		"json.web.service.context.path=FarmerSalesProposal"
	},
	service = AopService.class
)
public class FarmerSalesProposalServiceImpl
	extends FarmerSalesProposalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>bd.gov.dgfood.farmer.information.management.system.service.FarmerSalesProposalServiceUtil</code> to access the farmer sales proposal remote service.
	 */
}