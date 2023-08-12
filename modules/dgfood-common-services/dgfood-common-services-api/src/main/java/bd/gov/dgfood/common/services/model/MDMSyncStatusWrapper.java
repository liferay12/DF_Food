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
 * This class is a wrapper for {@link MDMSyncStatus}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MDMSyncStatus
 * @generated
 */
public class MDMSyncStatusWrapper
	extends BaseModelWrapper<MDMSyncStatus>
	implements MDMSyncStatus, ModelWrapper<MDMSyncStatus> {

	public MDMSyncStatusWrapper(MDMSyncStatus mdmSyncStatus) {
		super(mdmSyncStatus);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mdmSyncStatusId", getMdmSyncStatusId());
		attributes.put("userType", getUserType());
		attributes.put("className", getClassName());
		attributes.put("classPk", getClassPk());
		attributes.put("requestPayload", getRequestPayload());
		attributes.put("mdmEndPoint", getMdmEndPoint());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mdmSyncStatusId = (Long)attributes.get("mdmSyncStatusId");

		if (mdmSyncStatusId != null) {
			setMdmSyncStatusId(mdmSyncStatusId);
		}

		String userType = (String)attributes.get("userType");

		if (userType != null) {
			setUserType(userType);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		Long classPk = (Long)attributes.get("classPk");

		if (classPk != null) {
			setClassPk(classPk);
		}

		String requestPayload = (String)attributes.get("requestPayload");

		if (requestPayload != null) {
			setRequestPayload(requestPayload);
		}

		String mdmEndPoint = (String)attributes.get("mdmEndPoint");

		if (mdmEndPoint != null) {
			setMdmEndPoint(mdmEndPoint);
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
	public MDMSyncStatus cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the class name of this mdm sync status.
	 *
	 * @return the class name of this mdm sync status
	 */
	@Override
	public String getClassName() {
		return model.getClassName();
	}

	/**
	 * Returns the class pk of this mdm sync status.
	 *
	 * @return the class pk of this mdm sync status
	 */
	@Override
	public long getClassPk() {
		return model.getClassPk();
	}

	/**
	 * Returns the create date of this mdm sync status.
	 *
	 * @return the create date of this mdm sync status
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the mdm end point of this mdm sync status.
	 *
	 * @return the mdm end point of this mdm sync status
	 */
	@Override
	public String getMdmEndPoint() {
		return model.getMdmEndPoint();
	}

	/**
	 * Returns the mdm sync status ID of this mdm sync status.
	 *
	 * @return the mdm sync status ID of this mdm sync status
	 */
	@Override
	public long getMdmSyncStatusId() {
		return model.getMdmSyncStatusId();
	}

	/**
	 * Returns the primary key of this mdm sync status.
	 *
	 * @return the primary key of this mdm sync status
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the request payload of this mdm sync status.
	 *
	 * @return the request payload of this mdm sync status
	 */
	@Override
	public String getRequestPayload() {
		return model.getRequestPayload();
	}

	/**
	 * Returns the user ID of this mdm sync status.
	 *
	 * @return the user ID of this mdm sync status
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user type of this mdm sync status.
	 *
	 * @return the user type of this mdm sync status
	 */
	@Override
	public String getUserType() {
		return model.getUserType();
	}

	/**
	 * Returns the user uuid of this mdm sync status.
	 *
	 * @return the user uuid of this mdm sync status
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the class name of this mdm sync status.
	 *
	 * @param className the class name of this mdm sync status
	 */
	@Override
	public void setClassName(String className) {
		model.setClassName(className);
	}

	/**
	 * Sets the class pk of this mdm sync status.
	 *
	 * @param classPk the class pk of this mdm sync status
	 */
	@Override
	public void setClassPk(long classPk) {
		model.setClassPk(classPk);
	}

	/**
	 * Sets the create date of this mdm sync status.
	 *
	 * @param createDate the create date of this mdm sync status
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the mdm end point of this mdm sync status.
	 *
	 * @param mdmEndPoint the mdm end point of this mdm sync status
	 */
	@Override
	public void setMdmEndPoint(String mdmEndPoint) {
		model.setMdmEndPoint(mdmEndPoint);
	}

	/**
	 * Sets the mdm sync status ID of this mdm sync status.
	 *
	 * @param mdmSyncStatusId the mdm sync status ID of this mdm sync status
	 */
	@Override
	public void setMdmSyncStatusId(long mdmSyncStatusId) {
		model.setMdmSyncStatusId(mdmSyncStatusId);
	}

	/**
	 * Sets the primary key of this mdm sync status.
	 *
	 * @param primaryKey the primary key of this mdm sync status
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the request payload of this mdm sync status.
	 *
	 * @param requestPayload the request payload of this mdm sync status
	 */
	@Override
	public void setRequestPayload(String requestPayload) {
		model.setRequestPayload(requestPayload);
	}

	/**
	 * Sets the user ID of this mdm sync status.
	 *
	 * @param userId the user ID of this mdm sync status
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user type of this mdm sync status.
	 *
	 * @param userType the user type of this mdm sync status
	 */
	@Override
	public void setUserType(String userType) {
		model.setUserType(userType);
	}

	/**
	 * Sets the user uuid of this mdm sync status.
	 *
	 * @param userUuid the user uuid of this mdm sync status
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected MDMSyncStatusWrapper wrap(MDMSyncStatus mdmSyncStatus) {
		return new MDMSyncStatusWrapper(mdmSyncStatus);
	}

}