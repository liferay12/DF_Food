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

import bd.gov.dgfood.common.services.model.APIAudit;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing APIAudit in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class APIAuditCacheModel
	implements CacheModel<APIAudit>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof APIAuditCacheModel)) {
			return false;
		}

		APIAuditCacheModel apiAuditCacheModel = (APIAuditCacheModel)object;

		if (apiAuditId == apiAuditCacheModel.apiAuditId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, apiAuditId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{apiAuditId=");
		sb.append(apiAuditId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", sender=");
		sb.append(sender);
		sb.append(", receiver=");
		sb.append(receiver);
		sb.append(", requestPayload=");
		sb.append(requestPayload);
		sb.append(", responsePayload=");
		sb.append(responsePayload);
		sb.append(", requestClassName=");
		sb.append(requestClassName);
		sb.append(", requestClassPK=");
		sb.append(requestClassPK);
		sb.append(", bulkRequest=");
		sb.append(bulkRequest);
		sb.append(", requestTime=");
		sb.append(requestTime);
		sb.append(", responseTime=");
		sb.append(responseTime);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public APIAudit toEntityModel() {
		APIAuditImpl apiAuditImpl = new APIAuditImpl();

		apiAuditImpl.setApiAuditId(apiAuditId);

		if (title == null) {
			apiAuditImpl.setTitle("");
		}
		else {
			apiAuditImpl.setTitle(title);
		}

		if (description == null) {
			apiAuditImpl.setDescription("");
		}
		else {
			apiAuditImpl.setDescription(description);
		}

		if (sender == null) {
			apiAuditImpl.setSender("");
		}
		else {
			apiAuditImpl.setSender(sender);
		}

		if (receiver == null) {
			apiAuditImpl.setReceiver("");
		}
		else {
			apiAuditImpl.setReceiver(receiver);
		}

		if (requestPayload == null) {
			apiAuditImpl.setRequestPayload("");
		}
		else {
			apiAuditImpl.setRequestPayload(requestPayload);
		}

		if (responsePayload == null) {
			apiAuditImpl.setResponsePayload("");
		}
		else {
			apiAuditImpl.setResponsePayload(responsePayload);
		}

		if (requestClassName == null) {
			apiAuditImpl.setRequestClassName("");
		}
		else {
			apiAuditImpl.setRequestClassName(requestClassName);
		}

		apiAuditImpl.setRequestClassPK(requestClassPK);
		apiAuditImpl.setBulkRequest(bulkRequest);

		if (requestTime == Long.MIN_VALUE) {
			apiAuditImpl.setRequestTime(null);
		}
		else {
			apiAuditImpl.setRequestTime(new Date(requestTime));
		}

		if (responseTime == Long.MIN_VALUE) {
			apiAuditImpl.setResponseTime(null);
		}
		else {
			apiAuditImpl.setResponseTime(new Date(responseTime));
		}

		apiAuditImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			apiAuditImpl.setCreateDate(null);
		}
		else {
			apiAuditImpl.setCreateDate(new Date(createDate));
		}

		apiAuditImpl.resetOriginalValues();

		return apiAuditImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		apiAuditId = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		sender = objectInput.readUTF();
		receiver = objectInput.readUTF();
		requestPayload = objectInput.readUTF();
		responsePayload = objectInput.readUTF();
		requestClassName = objectInput.readUTF();

		requestClassPK = objectInput.readLong();

		bulkRequest = objectInput.readBoolean();
		requestTime = objectInput.readLong();
		responseTime = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(apiAuditId);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (sender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sender);
		}

		if (receiver == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(receiver);
		}

		if (requestPayload == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(requestPayload);
		}

		if (responsePayload == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(responsePayload);
		}

		if (requestClassName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(requestClassName);
		}

		objectOutput.writeLong(requestClassPK);

		objectOutput.writeBoolean(bulkRequest);
		objectOutput.writeLong(requestTime);
		objectOutput.writeLong(responseTime);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
	}

	public long apiAuditId;
	public String title;
	public String description;
	public String sender;
	public String receiver;
	public String requestPayload;
	public String responsePayload;
	public String requestClassName;
	public long requestClassPK;
	public boolean bulkRequest;
	public long requestTime;
	public long responseTime;
	public long userId;
	public long createDate;

}