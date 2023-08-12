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

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.common.services.model.AttachmentVersion;
import bd.gov.dgfood.common.services.service.base.AttachmentVersionLocalServiceBaseImpl;

/**
 * The implementation of the attachment version local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>bd.gov.dgfood.common.services.service.AttachmentVersionLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentVersionLocalServiceBaseImpl
 */
@Component(property = "model.class.name=bd.gov.dgfood.common.services.model.AttachmentVersion", service = AopService.class)
public class AttachmentVersionLocalServiceImpl extends AttachmentVersionLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>bd.gov.dgfood.common.services.service.AttachmentVersionLocalService</
	 * code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or
	 * use
	 * <code>bd.gov.dgfood.common.services.service.AttachmentVersionLocalServiceUtil
	 * </code>.
	 */

	public AttachmentVersion addAttachmentVersion(long fileEntryId, String title, String category, Map<String,Serializable> metadata,String className,
			long classPK) throws PortalException {

		AttachmentVersion attachmentVersion = createAttachmentVersion(
				counterLocalService.increment(AttachmentVersion.class.getName()));

		attachmentVersion.setFileEntryId(fileEntryId);
		attachmentVersion.setTitle(title);
		attachmentVersion.setCategory(category);
		attachmentVersion.setClassPK(classPK);
		attachmentVersion.setClassName(className);
		attachmentVersion.setMetadata(metadata);

		return attachmentVersionPersistence.update(attachmentVersion);

	}
	
	public List<AttachmentVersion> getAttachmentVersionsByClassPKAndClassName(long classPK,String className){
		
		return attachmentVersionPersistence.findByCPK_CN(classPK, className);
	}

}