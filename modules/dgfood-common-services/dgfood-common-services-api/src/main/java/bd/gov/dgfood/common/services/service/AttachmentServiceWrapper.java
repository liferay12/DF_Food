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

package bd.gov.dgfood.common.services.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AttachmentService}.
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentService
 * @generated
 */
public class AttachmentServiceWrapper
	implements AttachmentService, ServiceWrapper<AttachmentService> {

	public AttachmentServiceWrapper() {
		this(null);
	}

	public AttachmentServiceWrapper(AttachmentService attachmentService) {
		_attachmentService = attachmentService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _attachmentService.getOSGiServiceIdentifier();
	}

	@Override
	public AttachmentService getWrappedService() {
		return _attachmentService;
	}

	@Override
	public void setWrappedService(AttachmentService attachmentService) {
		_attachmentService = attachmentService;
	}

	private AttachmentService _attachmentService;

}