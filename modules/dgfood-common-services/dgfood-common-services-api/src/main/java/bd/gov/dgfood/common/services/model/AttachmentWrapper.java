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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Attachment}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Attachment
 * @generated
 */
public class AttachmentWrapper
	extends BaseModelWrapper<Attachment>
	implements Attachment, ModelWrapper<Attachment> {

	public AttachmentWrapper(Attachment attachment) {
		super(attachment);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("attachmentId", getAttachmentId());
		attributes.put("title", getTitle());
		attributes.put("category", getCategory());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("openTextId", getOpenTextId());
		attributes.put("metadata", getMetadata());
		attributes.put("classPK", getClassPK());
		attributes.put("className", getClassName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long attachmentId = (Long)attributes.get("attachmentId");

		if (attachmentId != null) {
			setAttachmentId(attachmentId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		Long openTextId = (Long)attributes.get("openTextId");

		if (openTextId != null) {
			setOpenTextId(openTextId);
		}

		Map<String, Serializable> metadata =
			(Map<String, Serializable>)attributes.get("metadata");

		if (metadata != null) {
			setMetadata(metadata);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}
	}

	@Override
	public Attachment cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the attachment ID of this attachment.
	 *
	 * @return the attachment ID of this attachment
	 */
	@Override
	public long getAttachmentId() {
		return model.getAttachmentId();
	}

	/**
	 * Returns the category of this attachment.
	 *
	 * @return the category of this attachment
	 */
	@Override
	public String getCategory() {
		return model.getCategory();
	}

	/**
	 * Returns the class name of this attachment.
	 *
	 * @return the class name of this attachment
	 */
	@Override
	public String getClassName() {
		return model.getClassName();
	}

	/**
	 * Returns the class pk of this attachment.
	 *
	 * @return the class pk of this attachment
	 */
	@Override
	public long getClassPK() {
		return model.getClassPK();
	}

	/**
	 * Returns the file entry ID of this attachment.
	 *
	 * @return the file entry ID of this attachment
	 */
	@Override
	public long getFileEntryId() {
		return model.getFileEntryId();
	}

	/**
	 * Returns the metadata of this attachment.
	 *
	 * @return the metadata of this attachment
	 */
	@Override
	public Map<String, Serializable> getMetadata() {
		return model.getMetadata();
	}

	/**
	 * Returns the open text ID of this attachment.
	 *
	 * @return the open text ID of this attachment
	 */
	@Override
	public long getOpenTextId() {
		return model.getOpenTextId();
	}

	/**
	 * Returns the primary key of this attachment.
	 *
	 * @return the primary key of this attachment
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the title of this attachment.
	 *
	 * @return the title of this attachment
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the attachment ID of this attachment.
	 *
	 * @param attachmentId the attachment ID of this attachment
	 */
	@Override
	public void setAttachmentId(long attachmentId) {
		model.setAttachmentId(attachmentId);
	}

	/**
	 * Sets the category of this attachment.
	 *
	 * @param category the category of this attachment
	 */
	@Override
	public void setCategory(String category) {
		model.setCategory(category);
	}

	/**
	 * Sets the class name of this attachment.
	 *
	 * @param className the class name of this attachment
	 */
	@Override
	public void setClassName(String className) {
		model.setClassName(className);
	}

	/**
	 * Sets the class pk of this attachment.
	 *
	 * @param classPK the class pk of this attachment
	 */
	@Override
	public void setClassPK(long classPK) {
		model.setClassPK(classPK);
	}

	/**
	 * Sets the file entry ID of this attachment.
	 *
	 * @param fileEntryId the file entry ID of this attachment
	 */
	@Override
	public void setFileEntryId(long fileEntryId) {
		model.setFileEntryId(fileEntryId);
	}

	/**
	 * Sets the metadata of this attachment.
	 *
	 * @param metadata the metadata of this attachment
	 */
	@Override
	public void setMetadata(Map<String, Serializable> metadata) {
		model.setMetadata(metadata);
	}

	/**
	 * Sets the open text ID of this attachment.
	 *
	 * @param openTextId the open text ID of this attachment
	 */
	@Override
	public void setOpenTextId(long openTextId) {
		model.setOpenTextId(openTextId);
	}

	/**
	 * Sets the primary key of this attachment.
	 *
	 * @param primaryKey the primary key of this attachment
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the title of this attachment.
	 *
	 * @param title the title of this attachment
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	@Override
	protected AttachmentWrapper wrap(Attachment attachment) {
		return new AttachmentWrapper(attachment);
	}

}