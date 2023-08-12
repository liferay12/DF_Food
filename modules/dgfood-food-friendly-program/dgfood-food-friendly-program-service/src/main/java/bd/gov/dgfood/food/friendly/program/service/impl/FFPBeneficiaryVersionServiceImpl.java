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

package bd.gov.dgfood.food.friendly.program.service.impl;

import bd.gov.dgfood.food.friendly.program.service.base.FFPBeneficiaryVersionServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the ffp beneficiary version remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>bd.gov.dgfood.food.friendly.program.service.FFPBeneficiaryVersionService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FFPBeneficiaryVersionServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=dg_food_ffpb",
		"json.web.service.context.path=FFPBeneficiaryVersion"
	},
	service = AopService.class
)
public class FFPBeneficiaryVersionServiceImpl
	extends FFPBeneficiaryVersionServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>bd.gov.dgfood.food.friendly.program.service.FFPBeneficiaryVersionServiceUtil</code> to access the ffp beneficiary version remote service.
	 */
}