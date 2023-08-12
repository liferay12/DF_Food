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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserDetails
 * @generated
 */
public class UserDetailsWrapper
	extends BaseModelWrapper<UserDetails>
	implements ModelWrapper<UserDetails>, UserDetails {

	public UserDetailsWrapper(UserDetails userDetails) {
		super(userDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userDetailsId", getUserDetailsId());
		attributes.put("nationalId", getNationalId());
		attributes.put("applicantName", getApplicantName());
		attributes.put("fatherName", getFatherName());
		attributes.put("motherName", getMotherName());
		attributes.put("gender", getGender());
		attributes.put("nidPhotoAttachmentId", getNidPhotoAttachmentId());
		attributes.put("nidDivision", getNidDivision());
		attributes.put("nidDistrict", getNidDistrict());
		attributes.put("nidUpzilla", getNidUpzilla());
		attributes.put("nidUnion", getNidUnion());
		attributes.put("nidVillage", getNidVillage());
		attributes.put("nidWard", getNidWard());
		attributes.put("nidZipCode", getNidZipCode());
		attributes.put("houseAddress", getHouseAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userDetailsId = (Long)attributes.get("userDetailsId");

		if (userDetailsId != null) {
			setUserDetailsId(userDetailsId);
		}

		String nationalId = (String)attributes.get("nationalId");

		if (nationalId != null) {
			setNationalId(nationalId);
		}

		String applicantName = (String)attributes.get("applicantName");

		if (applicantName != null) {
			setApplicantName(applicantName);
		}

		String fatherName = (String)attributes.get("fatherName");

		if (fatherName != null) {
			setFatherName(fatherName);
		}

		String motherName = (String)attributes.get("motherName");

		if (motherName != null) {
			setMotherName(motherName);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		Long nidPhotoAttachmentId = (Long)attributes.get(
			"nidPhotoAttachmentId");

		if (nidPhotoAttachmentId != null) {
			setNidPhotoAttachmentId(nidPhotoAttachmentId);
		}

		String nidDivision = (String)attributes.get("nidDivision");

		if (nidDivision != null) {
			setNidDivision(nidDivision);
		}

		String nidDistrict = (String)attributes.get("nidDistrict");

		if (nidDistrict != null) {
			setNidDistrict(nidDistrict);
		}

		String nidUpzilla = (String)attributes.get("nidUpzilla");

		if (nidUpzilla != null) {
			setNidUpzilla(nidUpzilla);
		}

		String nidUnion = (String)attributes.get("nidUnion");

		if (nidUnion != null) {
			setNidUnion(nidUnion);
		}

		String nidVillage = (String)attributes.get("nidVillage");

		if (nidVillage != null) {
			setNidVillage(nidVillage);
		}

		String nidWard = (String)attributes.get("nidWard");

		if (nidWard != null) {
			setNidWard(nidWard);
		}

		Long nidZipCode = (Long)attributes.get("nidZipCode");

		if (nidZipCode != null) {
			setNidZipCode(nidZipCode);
		}

		String houseAddress = (String)attributes.get("houseAddress");

		if (houseAddress != null) {
			setHouseAddress(houseAddress);
		}
	}

	@Override
	public UserDetails cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the applicant name of this user details.
	 *
	 * @return the applicant name of this user details
	 */
	@Override
	public String getApplicantName() {
		return model.getApplicantName();
	}

	/**
	 * Returns the father name of this user details.
	 *
	 * @return the father name of this user details
	 */
	@Override
	public String getFatherName() {
		return model.getFatherName();
	}

	/**
	 * Returns the gender of this user details.
	 *
	 * @return the gender of this user details
	 */
	@Override
	public String getGender() {
		return model.getGender();
	}

	/**
	 * Returns the house address of this user details.
	 *
	 * @return the house address of this user details
	 */
	@Override
	public String getHouseAddress() {
		return model.getHouseAddress();
	}

	/**
	 * Returns the mother name of this user details.
	 *
	 * @return the mother name of this user details
	 */
	@Override
	public String getMotherName() {
		return model.getMotherName();
	}

	/**
	 * Returns the national ID of this user details.
	 *
	 * @return the national ID of this user details
	 */
	@Override
	public String getNationalId() {
		return model.getNationalId();
	}

	/**
	 * Returns the nid district of this user details.
	 *
	 * @return the nid district of this user details
	 */
	@Override
	public String getNidDistrict() {
		return model.getNidDistrict();
	}

	/**
	 * Returns the nid division of this user details.
	 *
	 * @return the nid division of this user details
	 */
	@Override
	public String getNidDivision() {
		return model.getNidDivision();
	}

	/**
	 * Returns the nid photo attachment ID of this user details.
	 *
	 * @return the nid photo attachment ID of this user details
	 */
	@Override
	public long getNidPhotoAttachmentId() {
		return model.getNidPhotoAttachmentId();
	}

	/**
	 * Returns the nid union of this user details.
	 *
	 * @return the nid union of this user details
	 */
	@Override
	public String getNidUnion() {
		return model.getNidUnion();
	}

	/**
	 * Returns the nid upzilla of this user details.
	 *
	 * @return the nid upzilla of this user details
	 */
	@Override
	public String getNidUpzilla() {
		return model.getNidUpzilla();
	}

	/**
	 * Returns the nid village of this user details.
	 *
	 * @return the nid village of this user details
	 */
	@Override
	public String getNidVillage() {
		return model.getNidVillage();
	}

	/**
	 * Returns the nid ward of this user details.
	 *
	 * @return the nid ward of this user details
	 */
	@Override
	public String getNidWard() {
		return model.getNidWard();
	}

	/**
	 * Returns the nid zip code of this user details.
	 *
	 * @return the nid zip code of this user details
	 */
	@Override
	public long getNidZipCode() {
		return model.getNidZipCode();
	}

	/**
	 * Returns the primary key of this user details.
	 *
	 * @return the primary key of this user details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user details ID of this user details.
	 *
	 * @return the user details ID of this user details
	 */
	@Override
	public long getUserDetailsId() {
		return model.getUserDetailsId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the applicant name of this user details.
	 *
	 * @param applicantName the applicant name of this user details
	 */
	@Override
	public void setApplicantName(String applicantName) {
		model.setApplicantName(applicantName);
	}

	/**
	 * Sets the father name of this user details.
	 *
	 * @param fatherName the father name of this user details
	 */
	@Override
	public void setFatherName(String fatherName) {
		model.setFatherName(fatherName);
	}

	/**
	 * Sets the gender of this user details.
	 *
	 * @param gender the gender of this user details
	 */
	@Override
	public void setGender(String gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the house address of this user details.
	 *
	 * @param houseAddress the house address of this user details
	 */
	@Override
	public void setHouseAddress(String houseAddress) {
		model.setHouseAddress(houseAddress);
	}

	/**
	 * Sets the mother name of this user details.
	 *
	 * @param motherName the mother name of this user details
	 */
	@Override
	public void setMotherName(String motherName) {
		model.setMotherName(motherName);
	}

	/**
	 * Sets the national ID of this user details.
	 *
	 * @param nationalId the national ID of this user details
	 */
	@Override
	public void setNationalId(String nationalId) {
		model.setNationalId(nationalId);
	}

	/**
	 * Sets the nid district of this user details.
	 *
	 * @param nidDistrict the nid district of this user details
	 */
	@Override
	public void setNidDistrict(String nidDistrict) {
		model.setNidDistrict(nidDistrict);
	}

	/**
	 * Sets the nid division of this user details.
	 *
	 * @param nidDivision the nid division of this user details
	 */
	@Override
	public void setNidDivision(String nidDivision) {
		model.setNidDivision(nidDivision);
	}

	/**
	 * Sets the nid photo attachment ID of this user details.
	 *
	 * @param nidPhotoAttachmentId the nid photo attachment ID of this user details
	 */
	@Override
	public void setNidPhotoAttachmentId(long nidPhotoAttachmentId) {
		model.setNidPhotoAttachmentId(nidPhotoAttachmentId);
	}

	/**
	 * Sets the nid union of this user details.
	 *
	 * @param nidUnion the nid union of this user details
	 */
	@Override
	public void setNidUnion(String nidUnion) {
		model.setNidUnion(nidUnion);
	}

	/**
	 * Sets the nid upzilla of this user details.
	 *
	 * @param nidUpzilla the nid upzilla of this user details
	 */
	@Override
	public void setNidUpzilla(String nidUpzilla) {
		model.setNidUpzilla(nidUpzilla);
	}

	/**
	 * Sets the nid village of this user details.
	 *
	 * @param nidVillage the nid village of this user details
	 */
	@Override
	public void setNidVillage(String nidVillage) {
		model.setNidVillage(nidVillage);
	}

	/**
	 * Sets the nid ward of this user details.
	 *
	 * @param nidWard the nid ward of this user details
	 */
	@Override
	public void setNidWard(String nidWard) {
		model.setNidWard(nidWard);
	}

	/**
	 * Sets the nid zip code of this user details.
	 *
	 * @param nidZipCode the nid zip code of this user details
	 */
	@Override
	public void setNidZipCode(long nidZipCode) {
		model.setNidZipCode(nidZipCode);
	}

	/**
	 * Sets the primary key of this user details.
	 *
	 * @param primaryKey the primary key of this user details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user details ID of this user details.
	 *
	 * @param userDetailsId the user details ID of this user details
	 */
	@Override
	public void setUserDetailsId(long userDetailsId) {
		model.setUserDetailsId(userDetailsId);
	}

	@Override
	protected UserDetailsWrapper wrap(UserDetails userDetails) {
		return new UserDetailsWrapper(userDetails);
	}

}