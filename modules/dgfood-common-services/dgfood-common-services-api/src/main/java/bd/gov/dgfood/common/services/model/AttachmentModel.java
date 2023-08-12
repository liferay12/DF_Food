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
 * The base model interface for the Attachment service. Represents a row in the &quot;DGF_Attachment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>bd.gov.dgfood.common.services.model.impl.AttachmentModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>bd.gov.dgfood.common.services.model.impl.AttachmentImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Attachment
 * @generated
 */
@ProviderType
public interface AttachmentModel extends BaseModel<Attachment> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a attachment model instance should use the {@link Attachment} interface instead.
	 */

	/**
	 * Returns the primary key of this attachment.
	 *
	 * @return the primary key of this attachment
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this attachment.
	 *
	 * @param primaryKey the primary key of this attachment
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the attachment ID of this attachment.
	 *
	 * @return the attachment ID of this attachment
	 */
	public long getAttachmentId();

	/**
	 * Sets the attachment ID of this attachment.
	 *
	 * @param attachmentId the attachment ID of this attachment
	 */
	public void setAttachmentId(long attachmentId);

	/**
	 * Returns the title of this attachment.
	 *
	 * @return the title of this attachment
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this attachment.
	 *
	 * @param title the title of this attachment
	 */
	public void setTitle(String title);

	/**
	 * Returns the category of this attachment.
	 *
	 * @return the category of this attachment
	 */
	@AutoEscape
	public String getCategory();

	/**
	 * Sets the category of this attachment.
	 *
	 * @param category the category of this attachment
	 */
	public void setCategory(String category);

	/**
	 * Returns the file entry ID of this attachment.
	 *
	 * @return the file entry ID of this attachment
	 */
	public long getFileEntryId();

	/**
	 * Sets the file entry ID of this attachment.
	 *
	 * @param fileEntryId the file entry ID of this attachment
	 */
	public void setFileEntryId(long fileEntryId);

	/**
	 * Returns the open text ID of this attachment.
	 *
	 * @return the open text ID of this attachment
	 */
	public long getOpenTextId();

	/**
	 * Sets the open text ID of this attachment.
	 *
	 * @param openTextId the open text ID of this attachment
	 */
	public void setOpenTextId(long openTextId);

	/**
	 * Returns the metadata of this attachment.
	 *
	 * @return the metadata of this attachment
	 */
	public Map<String, Serializable> getMetadata();

	/**
	 * Sets the metadata of this attachment.
	 *
	 * @param metadata the metadata of this attachment
	 */
	public void setMetadata(Map<String, Serializable> metadata);

	/**
	 * Returns the class pk of this attachment.
	 *
	 * @return the class pk of this attachment
	 */
	public long getClassPK();

	/**
	 * Sets the class pk of this attachment.
	 *
	 * @param classPK the class pk of this attachment
	 */
	public void setClassPK(long classPK);

	/**
	 * Returns the class name of this attachment.
	 *
	 * @return the class name of this attachment
	 */
	@AutoEscape
	public String getClassName();

	/**
	 * Sets the class name of this attachment.
	 *
	 * @param className the class name of this attachment
	 */
	public void setClassName(String className);

	@Override
	public Attachment cloneWithOriginalValues();

}