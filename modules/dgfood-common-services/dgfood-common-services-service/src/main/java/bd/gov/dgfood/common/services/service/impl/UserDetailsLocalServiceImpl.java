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

package bd.gov.dgfood.common.services.service.impl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.common.services.model.UserDetails;
import bd.gov.dgfood.common.services.service.base.UserDetailsLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=bd.gov.dgfood.common.services.model.UserDetails", service = AopService.class)
public class UserDetailsLocalServiceImpl extends UserDetailsLocalServiceBaseImpl {

	public UserDetails findByNationalId(String nationalId) {
		return userDetailsPersistence.fetchByNationalId(nationalId);
	}

}