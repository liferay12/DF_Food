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
 * Provides a wrapper for {@link AttachmentVersionService}.
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentVersionService
 * @generated
 */
public class AttachmentVersionServiceWrapper
	implements AttachmentVersionService,
			   ServiceWrapper<AttachmentVersionService> {

	public AttachmentVersionServiceWrapper() {
		this(null);
	}

	public AttachmentVersionServiceWrapper(
		AttachmentVersionService attachmentVersionService) {

		_attachmentVersionService = attachmentVersionService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _attachmentVersionService.getOSGiServiceIdentifier();
	}

	@Override
	public AttachmentVersionService getWrappedService() {
		return _attachmentVersionService;
	}

	@Override
	public void setWrappedService(
		AttachmentVersionService attachmentVersionService) {

		_attachmentVersionService = attachmentVersionService;
	}

	private AttachmentVersionService _attachmentVersionService;

}