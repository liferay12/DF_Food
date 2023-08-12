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

import bd.gov.dgfood.common.services.model.AttachmentVersion;

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
 * The cache model class for representing AttachmentVersion in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AttachmentVersionCacheModel
	implements CacheModel<AttachmentVersion>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AttachmentVersionCacheModel)) {
			return false;
		}

		AttachmentVersionCacheModel attachmentVersionCacheModel =
			(AttachmentVersionCacheModel)object;

		if (attachmentVersionId ==
				attachmentVersionCacheModel.attachmentVersionId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, attachmentVersionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{attachmentVersionId=");
		sb.append(attachmentVersionId);
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
	public AttachmentVersion toEntityModel() {
		AttachmentVersionImpl attachmentVersionImpl =
			new AttachmentVersionImpl();

		attachmentVersionImpl.setAttachmentVersionId(attachmentVersionId);

		if (title == null) {
			attachmentVersionImpl.setTitle("");
		}
		else {
			attachmentVersionImpl.setTitle(title);
		}

		if (category == null) {
			attachmentVersionImpl.setCategory("");
		}
		else {
			attachmentVersionImpl.setCategory(category);
		}

		attachmentVersionImpl.setFileEntryId(fileEntryId);
		attachmentVersionImpl.setOpenTextId(openTextId);
		attachmentVersionImpl.setMetadata(metadata);
		attachmentVersionImpl.setClassPK(classPK);

		if (className == null) {
			attachmentVersionImpl.setClassName("");
		}
		else {
			attachmentVersionImpl.setClassName(className);
		}

		attachmentVersionImpl.resetOriginalValues();

		return attachmentVersionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		attachmentVersionId = objectInput.readLong();
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
		objectOutput.writeLong(attachmentVersionId);

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

	public long attachmentVersionId;
	public String title;
	public String category;
	public long fileEntryId;
	public long openTextId;
	public Map<String, Serializable> metadata;
	public long classPK;
	public String className;

}