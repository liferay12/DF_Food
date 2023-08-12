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

package bd.gov.dgfood.common.services.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.io.Serializable;

import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the AttachmentVersion service. Represents a row in the &quot;DGF_AttachmentVersion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>bd.gov.dgfood.common.services.model.impl.AttachmentVersionModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>bd.gov.dgfood.common.services.model.impl.AttachmentVersionImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentVersion
 * @generated
 */
@ProviderType
public interface AttachmentVersionModel extends BaseModel<AttachmentVersion> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a attachment version model instance should use the {@link AttachmentVersion} interface instead.
	 */

	/**
	 * Returns the primary key of this attachment version.
	 *
	 * @return the primary key of this attachment version
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this attachment version.
	 *
	 * @param primaryKey the primary key of this attachment version
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the attachment version ID of this attachment version.
	 *
	 * @return the attachment version ID of this attachment version
	 */
	public long getAttachmentVersionId();

	/**
	 * Sets the attachment version ID of this attachment version.
	 *
	 * @param attachmentVersionId the attachment version ID of this attachment version
	 */
	public void setAttachmentVersionId(long attachmentVersionId);

	/**
	 * Returns the title of this attachment version.
	 *
	 * @return the title of this attachment version
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this attachment version.
	 *
	 * @param title the title of this attachment version
	 */
	public void setTitle(String title);

	/**
	 * Returns the category of this attachment version.
	 *
	 * @return the category of this attachment version
	 */
	@AutoEscape
	public String getCategory();

	/**
	 * Sets the category of this attachment version.
	 *
	 * @param category the category of this attachment version
	 */
	public void setCategory(String category);

	/**
	 * Returns the file entry ID of this attachment version.
	 *
	 * @return the file entry ID of this attachment version
	 */
	public long getFileEntryId();

	/**
	 * Sets the file entry ID of this attachment version.
	 *
	 * @param fileEntryId the file entry ID of this attachment version
	 */
	public void setFileEntryId(long fileEntryId);

	/**
	 * Returns the open text ID of this attachment version.
	 *
	 * @return the open text ID of this attachment version
	 */
	public long getOpenTextId();

	/**
	 * Sets the open text ID of this attachment version.
	 *
	 * @param openTextId the open text ID of this attachment version
	 */
	public void setOpenTextId(long openTextId);

	/**
	 * Returns the metadata of this attachment version.
	 *
	 * @return the metadata of this attachment version
	 */
	public Map<String, Serializable> getMetadata();

	/**
	 * Sets the metadata of this attachment version.
	 *
	 * @param metadata the metadata of this attachment version
	 */
	public void setMetadata(Map<String, Serializable> metadata);

	/**
	 * Returns the class pk of this attachment version.
	 *
	 * @return the class pk of this attachment version
	 */
	public long getClassPK();

	/**
	 * Sets the class pk of this attachment version.
	 *
	 * @param classPK the class pk of this attachment version
	 */
	public void setClassPK(long classPK);

	/**
	 * Returns the class name of this attachment version.
	 *
	 * @return the class name of this attachment version
	 */
	@AutoEscape
	public String getClassName();

	/**
	 * Sets the class name of this attachment version.
	 *
	 * @param className the class name of this attachment version
	 */
	public void setClassName(String className);

	@Override
	public AttachmentVersion cloneWithOriginalValues();

}