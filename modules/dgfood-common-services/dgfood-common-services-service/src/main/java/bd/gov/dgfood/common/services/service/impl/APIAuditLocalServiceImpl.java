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

import bd.gov.dgfood.common.services.model.APIAudit;
import bd.gov.dgfood.common.services.service.base.APIAuditLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=bd.gov.dgfood.common.services.model.APIAudit",
	service = AopService.class
)
public abstract class APIAuditLocalServiceImpl extends APIAuditLocalServiceBaseImpl {
	
	
	public APIAudit updateApiAuditData(String title, String description, String sender, String receiver,
			String requestPayload, String responsePayload, String requestClassName, long requestClassPK,
			boolean bulkRequest, Date requestTime, Date responseTime, long userId) {

		APIAudit apiAudit = createAPIAudit(counterLocalService.increment(APIAudit.class.getName()));
		apiAudit.setTitle(title);
		apiAudit.setDescription(description);
		apiAudit.setSender(sender);
		apiAudit.setReceiver(receiver);
		apiAudit.setRequestPayload(requestPayload);
		apiAudit.setResponsePayload(responsePayload);
		apiAudit.setRequestClassName(requestClassName);
		apiAudit.setRequestClassPK(requestClassPK);
		apiAudit.setBulkRequest(bulkRequest);
		apiAudit.setRequestTime(requestTime);
		apiAudit.setResponseTime(responseTime);
		apiAudit.setUserId(userId);
		apiAudit.setCreateDate(new Date());

		return apiAuditPersistence.update(apiAudit);

	}

	

	
}