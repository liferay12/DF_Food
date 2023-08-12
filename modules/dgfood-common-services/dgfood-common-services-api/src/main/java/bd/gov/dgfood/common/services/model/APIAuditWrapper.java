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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link APIAudit}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see APIAudit
 * @generated
 */
public class APIAuditWrapper
	extends BaseModelWrapper<APIAudit>
	implements APIAudit, ModelWrapper<APIAudit> {

	public APIAuditWrapper(APIAudit apiAudit) {
		super(apiAudit);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("apiAuditId", getApiAuditId());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("sender", getSender());
		attributes.put("receiver", getReceiver());
		attributes.put("requestPayload", getRequestPayload());
		attributes.put("responsePayload", getResponsePayload());
		attributes.put("requestClassName", getRequestClassName());
		attributes.put("requestClassPK", getRequestClassPK());
		attributes.put("bulkRequest", isBulkRequest());
		attributes.put("requestTime", getRequestTime());
		attributes.put("responseTime", getResponseTime());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long apiAuditId = (Long)attributes.get("apiAuditId");

		if (apiAuditId != null) {
			setApiAuditId(apiAuditId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String sender = (String)attributes.get("sender");

		if (sender != null) {
			setSender(sender);
		}

		String receiver = (String)attributes.get("receiver");

		if (receiver != null) {
			setReceiver(receiver);
		}

		String requestPayload = (String)attributes.get("requestPayload");

		if (requestPayload != null) {
			setRequestPayload(requestPayload);
		}

		String responsePayload = (String)attributes.get("responsePayload");

		if (responsePayload != null) {
			setResponsePayload(responsePayload);
		}

		String requestClassName = (String)attributes.get("requestClassName");

		if (requestClassName != null) {
			setRequestClassName(requestClassName);
		}

		Long requestClassPK = (Long)attributes.get("requestClassPK");

		if (requestClassPK != null) {
			setRequestClassPK(requestClassPK);
		}

		Boolean bulkRequest = (Boolean)attributes.get("bulkRequest");

		if (bulkRequest != null) {
			setBulkRequest(bulkRequest);
		}

		Date requestTime = (Date)attributes.get("requestTime");

		if (requestTime != null) {
			setRequestTime(requestTime);
		}

		Date responseTime = (Date)attributes.get("responseTime");

		if (responseTime != null) {
			setResponseTime(responseTime);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@Override
	public APIAudit cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the api audit ID of this api audit.
	 *
	 * @return the api audit ID of this api audit
	 */
	@Override
	public long getApiAuditId() {
		return model.getApiAuditId();
	}

	/**
	 * Returns the bulk request of this api audit.
	 *
	 * @return the bulk request of this api audit
	 */
	@Override
	public boolean getBulkRequest() {
		return model.getBulkRequest();
	}

	/**
	 * Returns the create date of this api audit.
	 *
	 * @return the create date of this api audit
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this api audit.
	 *
	 * @return the description of this api audit
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the primary key of this api audit.
	 *
	 * @return the primary key of this api audit
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the receiver of this api audit.
	 *
	 * @return the receiver of this api audit
	 */
	@Override
	public String getReceiver() {
		return model.getReceiver();
	}

	/**
	 * Returns the request class name of this api audit.
	 *
	 * @return the request class name of this api audit
	 */
	@Override
	public String getRequestClassName() {
		return model.getRequestClassName();
	}

	/**
	 * Returns the request class pk of this api audit.
	 *
	 * @return the request class pk of this api audit
	 */
	@Override
	public long getRequestClassPK() {
		return model.getRequestClassPK();
	}

	/**
	 * Returns the request payload of this api audit.
	 *
	 * @return the request payload of this api audit
	 */
	@Override
	public String getRequestPayload() {
		return model.getRequestPayload();
	}

	/**
	 * Returns the request time of this api audit.
	 *
	 * @return the request time of this api audit
	 */
	@Override
	public Date getRequestTime() {
		return model.getRequestTime();
	}

	/**
	 * Returns the response payload of this api audit.
	 *
	 * @return the response payload of this api audit
	 */
	@Override
	public String getResponsePayload() {
		return model.getResponsePayload();
	}

	/**
	 * Returns the response time of this api audit.
	 *
	 * @return the response time of this api audit
	 */
	@Override
	public Date getResponseTime() {
		return model.getResponseTime();
	}

	/**
	 * Returns the sender of this api audit.
	 *
	 * @return the sender of this api audit
	 */
	@Override
	public String getSender() {
		return model.getSender();
	}

	/**
	 * Returns the title of this api audit.
	 *
	 * @return the title of this api audit
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this api audit.
	 *
	 * @return the user ID of this api audit
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this api audit.
	 *
	 * @return the user uuid of this api audit
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this api audit is bulk request.
	 *
	 * @return <code>true</code> if this api audit is bulk request; <code>false</code> otherwise
	 */
	@Override
	public boolean isBulkRequest() {
		return model.isBulkRequest();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the api audit ID of this api audit.
	 *
	 * @param apiAuditId the api audit ID of this api audit
	 */
	@Override
	public void setApiAuditId(long apiAuditId) {
		model.setApiAuditId(apiAuditId);
	}

	/**
	 * Sets whether this api audit is bulk request.
	 *
	 * @param bulkRequest the bulk request of this api audit
	 */
	@Override
	public void setBulkRequest(boolean bulkRequest) {
		model.setBulkRequest(bulkRequest);
	}

	/**
	 * Sets the create date of this api audit.
	 *
	 * @param createDate the create date of this api audit
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this api audit.
	 *
	 * @param description the description of this api audit
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the primary key of this api audit.
	 *
	 * @param primaryKey the primary key of this api audit
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the receiver of this api audit.
	 *
	 * @param receiver the receiver of this api audit
	 */
	@Override
	public void setReceiver(String receiver) {
		model.setReceiver(receiver);
	}

	/**
	 * Sets the request class name of this api audit.
	 *
	 * @param requestClassName the request class name of this api audit
	 */
	@Override
	public void setRequestClassName(String requestClassName) {
		model.setRequestClassName(requestClassName);
	}

	/**
	 * Sets the request class pk of this api audit.
	 *
	 * @param requestClassPK the request class pk of this api audit
	 */
	@Override
	public void setRequestClassPK(long requestClassPK) {
		model.setRequestClassPK(requestClassPK);
	}

	/**
	 * Sets the request payload of this api audit.
	 *
	 * @param requestPayload the request payload of this api audit
	 */
	@Override
	public void setRequestPayload(String requestPayload) {
		model.setRequestPayload(requestPayload);
	}

	/**
	 * Sets the request time of this api audit.
	 *
	 * @param requestTime the request time of this api audit
	 */
	@Override
	public void setRequestTime(Date requestTime) {
		model.setRequestTime(requestTime);
	}

	/**
	 * Sets the response payload of this api audit.
	 *
	 * @param responsePayload the response payload of this api audit
	 */
	@Override
	public void setResponsePayload(String responsePayload) {
		model.setResponsePayload(responsePayload);
	}

	/**
	 * Sets the response time of this api audit.
	 *
	 * @param responseTime the response time of this api audit
	 */
	@Override
	public void setResponseTime(Date responseTime) {
		model.setResponseTime(responseTime);
	}

	/**
	 * Sets the sender of this api audit.
	 *
	 * @param sender the sender of this api audit
	 */
	@Override
	public void setSender(String sender) {
		model.setSender(sender);
	}

	/**
	 * Sets the title of this api audit.
	 *
	 * @param title the title of this api audit
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this api audit.
	 *
	 * @param userId the user ID of this api audit
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this api audit.
	 *
	 * @param userUuid the user uuid of this api audit
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected APIAuditWrapper wrap(APIAudit apiAudit) {
		return new APIAuditWrapper(apiAudit);
	}

}