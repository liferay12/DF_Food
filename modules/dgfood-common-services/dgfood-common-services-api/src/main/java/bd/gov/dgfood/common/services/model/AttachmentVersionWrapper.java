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
 * This class is a wrapper for {@link AttachmentVersion}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentVersion
 * @generated
 */
public class AttachmentVersionWrapper
	extends BaseModelWrapper<AttachmentVersion>
	implements AttachmentVersion, ModelWrapper<AttachmentVersion> {

	public AttachmentVersionWrapper(AttachmentVersion attachmentVersion) {
		super(attachmentVersion);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("attachmentVersionId", getAttachmentVersionId());
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
		Long attachmentVersionId = (Long)attributes.get("attachmentVersionId");

		if (attachmentVersionId != null) {
			setAttachmentVersionId(attachmentVersionId);
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
	public AttachmentVersion cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the attachment version ID of this attachment version.
	 *
	 * @return the attachment version ID of this attachment version
	 */
	@Override
	public long getAttachmentVersionId() {
		return model.getAttachmentVersionId();
	}

	/**
	 * Returns the category of this attachment version.
	 *
	 * @return the category of this attachment version
	 */
	@Override
	public String getCategory() {
		return model.getCategory();
	}

	/**
	 * Returns the class name of this attachment version.
	 *
	 * @return the class name of this attachment version
	 */
	@Override
	public String getClassName() {
		return model.getClassName();
	}

	/**
	 * Returns the class pk of this attachment version.
	 *
	 * @return the class pk of this attachment version
	 */
	@Override
	public long getClassPK() {
		return model.getClassPK();
	}

	/**
	 * Returns the file entry ID of this attachment version.
	 *
	 * @return the file entry ID of this attachment version
	 */
	@Override
	public long getFileEntryId() {
		return model.getFileEntryId();
	}

	/**
	 * Returns the metadata of this attachment version.
	 *
	 * @return the metadata of this attachment version
	 */
	@Override
	public Map<String, Serializable> getMetadata() {
		return model.getMetadata();
	}

	/**
	 * Returns the open text ID of this attachment version.
	 *
	 * @return the open text ID of this attachment version
	 */
	@Override
	public long getOpenTextId() {
		return model.getOpenTextId();
	}

	/**
	 * Returns the primary key of this attachment version.
	 *
	 * @return the primary key of this attachment version
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the title of this attachment version.
	 *
	 * @return the title of this attachment version
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
	 * Sets the attachment version ID of this attachment version.
	 *
	 * @param attachmentVersionId the attachment version ID of this attachment version
	 */
	@Override
	public void setAttachmentVersionId(long attachmentVersionId) {
		model.setAttachmentVersionId(attachmentVersionId);
	}

	/**
	 * Sets the category of this attachment version.
	 *
	 * @param category the category of this attachment version
	 */
	@Override
	public void setCategory(String category) {
		model.setCategory(category);
	}

	/**
	 * Sets the class name of this attachment version.
	 *
	 * @param className the class name of this attachment version
	 */
	@Override
	public void setClassName(String className) {
		model.setClassName(className);
	}

	/**
	 * Sets the class pk of this attachment version.
	 *
	 * @param classPK the class pk of this attachment version
	 */
	@Override
	public void setClassPK(long classPK) {
		model.setClassPK(classPK);
	}

	/**
	 * Sets the file entry ID of this attachment version.
	 *
	 * @param fileEntryId the file entry ID of this attachment version
	 */
	@Override
	public void setFileEntryId(long fileEntryId) {
		model.setFileEntryId(fileEntryId);
	}

	/**
	 * Sets the metadata of this attachment version.
	 *
	 * @param metadata the metadata of this attachment version
	 */
	@Override
	public void setMetadata(Map<String, Serializable> metadata) {
		model.setMetadata(metadata);
	}

	/**
	 * Sets the open text ID of this attachment version.
	 *
	 * @param openTextId the open text ID of this attachment version
	 */
	@Override
	public void setOpenTextId(long openTextId) {
		model.setOpenTextId(openTextId);
	}

	/**
	 * Sets the primary key of this attachment version.
	 *
	 * @param primaryKey the primary key of this attachment version
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the title of this attachment version.
	 *
	 * @param title the title of this attachment version
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	@Override
	protected AttachmentVersionWrapper wrap(
		AttachmentVersion attachmentVersion) {

		return new AttachmentVersionWrapper(attachmentVersion);
	}

}