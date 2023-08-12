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
 * This class is a wrapper for {@link DGFUsers}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DGFUsers
 * @generated
 */
public class DGFUsersWrapper
	extends BaseModelWrapper<DGFUsers>
	implements DGFUsers, ModelWrapper<DGFUsers> {

	public DGFUsersWrapper(DGFUsers dgfUsers) {
		super(dgfUsers);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dgfUserId", getDgfUserId());
		attributes.put("nationalId", getNationalId());
		attributes.put("password", getPassword());
		attributes.put("mobileNumber", getMobileNumber());
		attributes.put("email", getEmail());
		attributes.put("birthDate", getBirthDate());
		attributes.put("maritalStatus", getMaritalStatus());
		attributes.put("userId", getUserId());
		attributes.put("presentAddressId", getPresentAddressId());
		attributes.put("profileType", getProfileType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dgfUserId = (Long)attributes.get("dgfUserId");

		if (dgfUserId != null) {
			setDgfUserId(dgfUserId);
		}

		String nationalId = (String)attributes.get("nationalId");

		if (nationalId != null) {
			setNationalId(nationalId);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		String mobileNumber = (String)attributes.get("mobileNumber");

		if (mobileNumber != null) {
			setMobileNumber(mobileNumber);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Date birthDate = (Date)attributes.get("birthDate");

		if (birthDate != null) {
			setBirthDate(birthDate);
		}

		String maritalStatus = (String)attributes.get("maritalStatus");

		if (maritalStatus != null) {
			setMaritalStatus(maritalStatus);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long presentAddressId = (Long)attributes.get("presentAddressId");

		if (presentAddressId != null) {
			setPresentAddressId(presentAddressId);
		}

		String profileType = (String)attributes.get("profileType");

		if (profileType != null) {
			setProfileType(profileType);
		}
	}

	@Override
	public DGFUsers cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the birth date of this dgf users.
	 *
	 * @return the birth date of this dgf users
	 */
	@Override
	public Date getBirthDate() {
		return model.getBirthDate();
	}

	/**
	 * Returns the dgf user ID of this dgf users.
	 *
	 * @return the dgf user ID of this dgf users
	 */
	@Override
	public long getDgfUserId() {
		return model.getDgfUserId();
	}

	/**
	 * Returns the dgf user uuid of this dgf users.
	 *
	 * @return the dgf user uuid of this dgf users
	 */
	@Override
	public String getDgfUserUuid() {
		return model.getDgfUserUuid();
	}

	/**
	 * Returns the email of this dgf users.
	 *
	 * @return the email of this dgf users
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the marital status of this dgf users.
	 *
	 * @return the marital status of this dgf users
	 */
	@Override
	public String getMaritalStatus() {
		return model.getMaritalStatus();
	}

	/**
	 * Returns the mobile number of this dgf users.
	 *
	 * @return the mobile number of this dgf users
	 */
	@Override
	public String getMobileNumber() {
		return model.getMobileNumber();
	}

	/**
	 * Returns the national ID of this dgf users.
	 *
	 * @return the national ID of this dgf users
	 */
	@Override
	public String getNationalId() {
		return model.getNationalId();
	}

	/**
	 * Returns the password of this dgf users.
	 *
	 * @return the password of this dgf users
	 */
	@Override
	public String getPassword() {
		return model.getPassword();
	}

	/**
	 * Returns the present address ID of this dgf users.
	 *
	 * @return the present address ID of this dgf users
	 */
	@Override
	public long getPresentAddressId() {
		return model.getPresentAddressId();
	}

	/**
	 * Returns the primary key of this dgf users.
	 *
	 * @return the primary key of this dgf users
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the profile type of this dgf users.
	 *
	 * @return the profile type of this dgf users
	 */
	@Override
	public String getProfileType() {
		return model.getProfileType();
	}

	/**
	 * Returns the user ID of this dgf users.
	 *
	 * @return the user ID of this dgf users
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this dgf users.
	 *
	 * @return the user uuid of this dgf users
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
	 * Sets the birth date of this dgf users.
	 *
	 * @param birthDate the birth date of this dgf users
	 */
	@Override
	public void setBirthDate(Date birthDate) {
		model.setBirthDate(birthDate);
	}

	/**
	 * Sets the dgf user ID of this dgf users.
	 *
	 * @param dgfUserId the dgf user ID of this dgf users
	 */
	@Override
	public void setDgfUserId(long dgfUserId) {
		model.setDgfUserId(dgfUserId);
	}

	/**
	 * Sets the dgf user uuid of this dgf users.
	 *
	 * @param dgfUserUuid the dgf user uuid of this dgf users
	 */
	@Override
	public void setDgfUserUuid(String dgfUserUuid) {
		model.setDgfUserUuid(dgfUserUuid);
	}

	/**
	 * Sets the email of this dgf users.
	 *
	 * @param email the email of this dgf users
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the marital status of this dgf users.
	 *
	 * @param maritalStatus the marital status of this dgf users
	 */
	@Override
	public void setMaritalStatus(String maritalStatus) {
		model.setMaritalStatus(maritalStatus);
	}

	/**
	 * Sets the mobile number of this dgf users.
	 *
	 * @param mobileNumber the mobile number of this dgf users
	 */
	@Override
	public void setMobileNumber(String mobileNumber) {
		model.setMobileNumber(mobileNumber);
	}

	/**
	 * Sets the national ID of this dgf users.
	 *
	 * @param nationalId the national ID of this dgf users
	 */
	@Override
	public void setNationalId(String nationalId) {
		model.setNationalId(nationalId);
	}

	/**
	 * Sets the password of this dgf users.
	 *
	 * @param password the password of this dgf users
	 */
	@Override
	public void setPassword(String password) {
		model.setPassword(password);
	}

	/**
	 * Sets the present address ID of this dgf users.
	 *
	 * @param presentAddressId the present address ID of this dgf users
	 */
	@Override
	public void setPresentAddressId(long presentAddressId) {
		model.setPresentAddressId(presentAddressId);
	}

	/**
	 * Sets the primary key of this dgf users.
	 *
	 * @param primaryKey the primary key of this dgf users
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the profile type of this dgf users.
	 *
	 * @param profileType the profile type of this dgf users
	 */
	@Override
	public void setProfileType(String profileType) {
		model.setProfileType(profileType);
	}

	/**
	 * Sets the user ID of this dgf users.
	 *
	 * @param userId the user ID of this dgf users
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this dgf users.
	 *
	 * @param userUuid the user uuid of this dgf users
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected DGFUsersWrapper wrap(DGFUsers dgfUsers) {
		return new DGFUsersWrapper(dgfUsers);
	}

}