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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.common.services.model.Indent;
import bd.gov.dgfood.common.services.service.base.IndentLocalServiceBaseImpl;

/**
 * The implementation of the indent local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>bd.gov.dgfood.common.services.service.IndentLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IndentLocalServiceBaseImpl
 */
@Component(property = "model.class.name=bd.gov.dgfood.common.services.model.Indent", service = AopService.class)
public class IndentLocalServiceImpl extends IndentLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>bd.gov.dgfood.common.services.service.IndentLocalService</code> via
	 * injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>bd.gov.dgfood.common.services.service.IndentLocalServiceUtil</code>.
	 */

	public Indent addIndent(long allocationId, String className, double quantity, String quantityUnit,
			Date requiredDeliveryDate, ServiceContext serviceContext) throws PortalException {

		// TODO
	//	Allocation allocation = allocationPersistence.findByPrimaryKey(allocationId);

		User user = userLocalService.getUser(serviceContext.getUserId());

		long indentId = counterLocalService.increment(Indent.class.getName());

		Indent indent = indentPersistence.create(indentId);
		indent.setAllocationId(allocationId);
		//indent.setCommodity(allocation.getCommodity());
		indent.setQuantity(quantity);
		indent.setQuantityUnit(quantityUnit);
		indent.setRequiredDeliveryDate(requiredDeliveryDate);
		indent.setUserId(user.getUserId());
		indent.setCreateDate(new Date());
		indent.setGroupId(serviceContext.getScopeGroupId());

		return indentPersistence.update(indent);

	}

	public List<Indent> getIndents(long allocationId, int start, int end) {
		return indentPersistence.findByAllocationId(allocationId, start, end);

	}

	public int getIndentsCount(long allocationId) {
		return indentPersistence.countByAllocationId(allocationId);

	}

}