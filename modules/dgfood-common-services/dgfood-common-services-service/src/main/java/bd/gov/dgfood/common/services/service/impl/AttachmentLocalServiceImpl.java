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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.common.services.model.Attachment;
import bd.gov.dgfood.common.services.service.base.AttachmentLocalServiceBaseImpl;

/**
 * The implementation of the attachment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>bd.gov.dgfood.common.services.service.AttachmentLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentLocalServiceBaseImpl
 */
/**
 * @author krishna
 *
 */
@Component(property = "model.class.name=bd.gov.dgfood.common.services.model.Attachment", service = AopService.class)
public class AttachmentLocalServiceImpl extends AttachmentLocalServiceBaseImpl {

	public Attachment addAttachment(long fileEntryId, String title, String category, Map<String,Serializable> metadata) {

		Attachment attachment = createAttachment(counterLocalService.increment(Attachment.class.getName()));

		attachment.setFileEntryId(fileEntryId);

		attachment.setTitle(title);
		attachment.setCategory(category);
		attachment.setMetadata(metadata);

		return attachmentPersistence.update(attachment);
	}

	public Attachment updateAttachment(long attachmentId, long fileEntryId, String title,
			Map<String, Serializable> metadata) throws PortalException {

		Attachment attachment = getAttachment(attachmentId);

		attachment.setFileEntryId(fileEntryId);

		attachment.setTitle(title);
		attachment.setMetadata(metadata);

		return attachmentPersistence.update(attachment);
	}

	/**
	 * fetch the attachments list for the given ids
	 * 
	 */
	public List<Attachment> fetchUserAttachments(List<Long> attachmentIds) {
		DynamicQuery dynamicQuery = dynamicQuery().add(RestrictionsFactoryUtil.in("attachmentId", attachmentIds));
		return dynamicQuery(dynamicQuery);

	}

	public List<Attachment> getAttachmentsByClassPKAndClassName(long classPK, String className) {
		return attachmentPersistence.findByCPK_CN(classPK, className);
	}

}
