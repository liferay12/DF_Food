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

package bd.gov.dgfood.common.services.model.impl;

import bd.gov.dgfood.common.services.model.Attachment;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

import java.util.Map;

/**
 * The cache model class for representing Attachment in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AttachmentCacheModel
	implements CacheModel<Attachment>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AttachmentCacheModel)) {
			return false;
		}

		AttachmentCacheModel attachmentCacheModel =
			(AttachmentCacheModel)object;

		if (attachmentId == attachmentCacheModel.attachmentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, attachmentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{attachmentId=");
		sb.append(attachmentId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", category=");
		sb.append(category);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append(", openTextId=");
		sb.append(openTextId);
		sb.append(", metadata=");
		sb.append(metadata);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", className=");
		sb.append(className);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Attachment toEntityModel() {
		AttachmentImpl attachmentImpl = new AttachmentImpl();

		attachmentImpl.setAttachmentId(attachmentId);

		if (title == null) {
			attachmentImpl.setTitle("");
		}
		else {
			attachmentImpl.setTitle(title);
		}

		if (category == null) {
			attachmentImpl.setCategory("");
		}
		else {
			attachmentImpl.setCategory(category);
		}

		attachmentImpl.setFileEntryId(fileEntryId);
		attachmentImpl.setOpenTextId(openTextId);
		attachmentImpl.setMetadata(metadata);
		attachmentImpl.setClassPK(classPK);

		if (className == null) {
			attachmentImpl.setClassName("");
		}
		else {
			attachmentImpl.setClassName(className);
		}

		attachmentImpl.resetOriginalValues();

		return attachmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		attachmentId = objectInput.readLong();
		title = objectInput.readUTF();
		category = objectInput.readUTF();

		fileEntryId = objectInput.readLong();

		openTextId = objectInput.readLong();
		metadata = (Map<String, Serializable>)objectInput.readObject();

		classPK = objectInput.readLong();
		className = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(attachmentId);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (category == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(category);
		}

		objectOutput.writeLong(fileEntryId);

		objectOutput.writeLong(openTextId);
		objectOutput.writeObject(metadata);

		objectOutput.writeLong(classPK);

		if (className == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(className);
		}
	}

	public long attachmentId;
	public String title;
	public String category;
	public long fileEntryId;
	public long openTextId;
	public Map<String, Serializable> metadata;
	public long classPK;
	public String className;

}