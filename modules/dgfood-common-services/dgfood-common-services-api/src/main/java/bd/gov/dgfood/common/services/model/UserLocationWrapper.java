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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserLocation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserLocation
 * @generated
 */
public class UserLocationWrapper
	extends BaseModelWrapper<UserLocation>
	implements ModelWrapper<UserLocation>, UserLocation {

	public UserLocationWrapper(UserLocation userLocation) {
		super(userLocation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("userLocationId", getUserLocationId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("locationName", getLocationName());
		attributes.put("locationCode", getLocationCode());
		attributes.put("locationId", getLocationId());
		attributes.put("locationType", getLocationType());
		attributes.put("userName", getUserName());
		attributes.put("userId", getUserId());
		attributes.put("roleKey", getRoleKey());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long userLocationId = (Long)attributes.get("userLocationId");

		if (userLocationId != null) {
			setUserLocationId(userLocationId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String locationName = (String)attributes.get("locationName");

		if (locationName != null) {
			setLocationName(locationName);
		}

		String locationCode = (String)attributes.get("locationCode");

		if (locationCode != null) {
			setLocationCode(locationCode);
		}

		Long locationId = (Long)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
		}

		String locationType = (String)attributes.get("locationType");

		if (locationType != null) {
			setLocationType(locationType);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String roleKey = (String)attributes.get("roleKey");

		if (roleKey != null) {
			setRoleKey(roleKey);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}
	}

	@Override
	public UserLocation cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this user location.
	 *
	 * @return the company ID of this user location
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this user location.
	 *
	 * @return the create date of this user location
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this user location.
	 *
	 * @return the created by of this user location
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this user location.
	 *
	 * @return the group ID of this user location
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the location code of this user location.
	 *
	 * @return the location code of this user location
	 */
	@Override
	public String getLocationCode() {
		return model.getLocationCode();
	}

	/**
	 * Returns the location ID of this user location.
	 *
	 * @return the location ID of this user location
	 */
	@Override
	public long getLocationId() {
		return model.getLocationId();
	}

	/**
	 * Returns the location name of this user location.
	 *
	 * @return the location name of this user location
	 */
	@Override
	public String getLocationName() {
		return model.getLocationName();
	}

	/**
	 * Returns the location type of this user location.
	 *
	 * @return the location type of this user location
	 */
	@Override
	public String getLocationType() {
		return model.getLocationType();
	}

	/**
	 * Returns the modified by of this user location.
	 *
	 * @return the modified by of this user location
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this user location.
	 *
	 * @return the modified date of this user location
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this user location.
	 *
	 * @return the primary key of this user location
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the role key of this user location.
	 *
	 * @return the role key of this user location
	 */
	@Override
	public String getRoleKey() {
		return model.getRoleKey();
	}

	/**
	 * Returns the user ID of this user location.
	 *
	 * @return the user ID of this user location
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user location ID of this user location.
	 *
	 * @return the user location ID of this user location
	 */
	@Override
	public long getUserLocationId() {
		return model.getUserLocationId();
	}

	/**
	 * Returns the user name of this user location.
	 *
	 * @return the user name of this user location
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this user location.
	 *
	 * @return the user uuid of this user location
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this user location.
	 *
	 * @return the uuid of this user location
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this user location.
	 *
	 * @param companyId the company ID of this user location
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this user location.
	 *
	 * @param createDate the create date of this user location
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this user location.
	 *
	 * @param createdBy the created by of this user location
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this user location.
	 *
	 * @param groupId the group ID of this user location
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the location code of this user location.
	 *
	 * @param locationCode the location code of this user location
	 */
	@Override
	public void setLocationCode(String locationCode) {
		model.setLocationCode(locationCode);
	}

	/**
	 * Sets the location ID of this user location.
	 *
	 * @param locationId the location ID of this user location
	 */
	@Override
	public void setLocationId(long locationId) {
		model.setLocationId(locationId);
	}

	/**
	 * Sets the location name of this user location.
	 *
	 * @param locationName the location name of this user location
	 */
	@Override
	public void setLocationName(String locationName) {
		model.setLocationName(locationName);
	}

	/**
	 * Sets the location type of this user location.
	 *
	 * @param locationType the location type of this user location
	 */
	@Override
	public void setLocationType(String locationType) {
		model.setLocationType(locationType);
	}

	/**
	 * Sets the modified by of this user location.
	 *
	 * @param modifiedBy the modified by of this user location
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this user location.
	 *
	 * @param modifiedDate the modified date of this user location
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this user location.
	 *
	 * @param primaryKey the primary key of this user location
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the role key of this user location.
	 *
	 * @param roleKey the role key of this user location
	 */
	@Override
	public void setRoleKey(String roleKey) {
		model.setRoleKey(roleKey);
	}

	/**
	 * Sets the user ID of this user location.
	 *
	 * @param userId the user ID of this user location
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user location ID of this user location.
	 *
	 * @param userLocationId the user location ID of this user location
	 */
	@Override
	public void setUserLocationId(long userLocationId) {
		model.setUserLocationId(userLocationId);
	}

	/**
	 * Sets the user name of this user location.
	 *
	 * @param userName the user name of this user location
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this user location.
	 *
	 * @param userUuid the user uuid of this user location
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this user location.
	 *
	 * @param uuid the uuid of this user location
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected UserLocationWrapper wrap(UserLocation userLocation) {
		return new UserLocationWrapper(userLocation);
	}

}