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

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the MDMSyncStatus service. Represents a row in the &quot;DGF_MDMSyncStatus&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>bd.gov.dgfood.common.services.model.impl.MDMSyncStatusModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>bd.gov.dgfood.common.services.model.impl.MDMSyncStatusImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MDMSyncStatus
 * @generated
 */
@ProviderType
public interface MDMSyncStatusModel extends BaseModel<MDMSyncStatus> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a mdm sync status model instance should use the {@link MDMSyncStatus} interface instead.
	 */

	/**
	 * Returns the primary key of this mdm sync status.
	 *
	 * @return the primary key of this mdm sync status
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this mdm sync status.
	 *
	 * @param primaryKey the primary key of this mdm sync status
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mdm sync status ID of this mdm sync status.
	 *
	 * @return the mdm sync status ID of this mdm sync status
	 */
	public long getMdmSyncStatusId();

	/**
	 * Sets the mdm sync status ID of this mdm sync status.
	 *
	 * @param mdmSyncStatusId the mdm sync status ID of this mdm sync status
	 */
	public void setMdmSyncStatusId(long mdmSyncStatusId);

	/**
	 * Returns the user type of this mdm sync status.
	 *
	 * @return the user type of this mdm sync status
	 */
	@AutoEscape
	public String getUserType();

	/**
	 * Sets the user type of this mdm sync status.
	 *
	 * @param userType the user type of this mdm sync status
	 */
	public void setUserType(String userType);

	/**
	 * Returns the class name of this mdm sync status.
	 *
	 * @return the class name of this mdm sync status
	 */
	@AutoEscape
	public String getClassName();

	/**
	 * Sets the class name of this mdm sync status.
	 *
	 * @param className the class name of this mdm sync status
	 */
	public void setClassName(String className);

	/**
	 * Returns the class pk of this mdm sync status.
	 *
	 * @return the class pk of this mdm sync status
	 */
	public long getClassPk();

	/**
	 * Sets the class pk of this mdm sync status.
	 *
	 * @param classPk the class pk of this mdm sync status
	 */
	public void setClassPk(long classPk);

	/**
	 * Returns the request payload of this mdm sync status.
	 *
	 * @return the request payload of this mdm sync status
	 */
	@AutoEscape
	public String getRequestPayload();

	/**
	 * Sets the request payload of this mdm sync status.
	 *
	 * @param requestPayload the request payload of this mdm sync status
	 */
	public void setRequestPayload(String requestPayload);

	/**
	 * Returns the mdm end point of this mdm sync status.
	 *
	 * @return the mdm end point of this mdm sync status
	 */
	@AutoEscape
	public String getMdmEndPoint();

	/**
	 * Sets the mdm end point of this mdm sync status.
	 *
	 * @param mdmEndPoint the mdm end point of this mdm sync status
	 */
	public void setMdmEndPoint(String mdmEndPoint);

	/**
	 * Returns the user ID of this mdm sync status.
	 *
	 * @return the user ID of this mdm sync status
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this mdm sync status.
	 *
	 * @param userId the user ID of this mdm sync status
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this mdm sync status.
	 *
	 * @return the user uuid of this mdm sync status
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this mdm sync status.
	 *
	 * @param userUuid the user uuid of this mdm sync status
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this mdm sync status.
	 *
	 * @return the create date of this mdm sync status
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this mdm sync status.
	 *
	 * @param createDate the create date of this mdm sync status
	 */
	public void setCreateDate(Date createDate);

	@Override
	public MDMSyncStatus cloneWithOriginalValues();

}