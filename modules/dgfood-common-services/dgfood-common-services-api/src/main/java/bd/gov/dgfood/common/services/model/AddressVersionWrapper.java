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
 * This class is a wrapper for {@link AddressVersion}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressVersion
 * @generated
 */
public class AddressVersionWrapper
	extends BaseModelWrapper<AddressVersion>
	implements AddressVersion, ModelWrapper<AddressVersion> {

	public AddressVersionWrapper(AddressVersion addressVersion) {
		super(addressVersion);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("addressVersionId", getAddressVersionId());
		attributes.put("region", getRegion());
		attributes.put("district", getDistrict());
		attributes.put("upazilla", getUpazilla());
		attributes.put(
			"cityCorporationOrMunicipality",
			getCityCorporationOrMunicipality());
		attributes.put("unionOrWard", getUnionOrWard());
		attributes.put("zipCode", getZipCode());
		attributes.put("postOffice", getPostOffice());
		attributes.put("villageOrRoad", getVillageOrRoad());
		attributes.put("mouzaOrMoholla", getMouzaOrMoholla());
		attributes.put("address", getAddress());
		attributes.put("addressType", getAddressType());
		attributes.put("classPK", getClassPK());
		attributes.put("className", getClassName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long addressVersionId = (Long)attributes.get("addressVersionId");

		if (addressVersionId != null) {
			setAddressVersionId(addressVersionId);
		}

		Long region = (Long)attributes.get("region");

		if (region != null) {
			setRegion(region);
		}

		Long district = (Long)attributes.get("district");

		if (district != null) {
			setDistrict(district);
		}

		Long upazilla = (Long)attributes.get("upazilla");

		if (upazilla != null) {
			setUpazilla(upazilla);
		}

		Long cityCorporationOrMunicipality = (Long)attributes.get(
			"cityCorporationOrMunicipality");

		if (cityCorporationOrMunicipality != null) {
			setCityCorporationOrMunicipality(cityCorporationOrMunicipality);
		}

		Long unionOrWard = (Long)attributes.get("unionOrWard");

		if (unionOrWard != null) {
			setUnionOrWard(unionOrWard);
		}

		Long zipCode = (Long)attributes.get("zipCode");

		if (zipCode != null) {
			setZipCode(zipCode);
		}

		String postOffice = (String)attributes.get("postOffice");

		if (postOffice != null) {
			setPostOffice(postOffice);
		}

		String villageOrRoad = (String)attributes.get("villageOrRoad");

		if (villageOrRoad != null) {
			setVillageOrRoad(villageOrRoad);
		}

		String mouzaOrMoholla = (String)attributes.get("mouzaOrMoholla");

		if (mouzaOrMoholla != null) {
			setMouzaOrMoholla(mouzaOrMoholla);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String addressType = (String)attributes.get("addressType");

		if (addressType != null) {
			setAddressType(addressType);
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
	public AddressVersion cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the address of this address version.
	 *
	 * @return the address of this address version
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the address type of this address version.
	 *
	 * @return the address type of this address version
	 */
	@Override
	public String getAddressType() {
		return model.getAddressType();
	}

	/**
	 * Returns the address version ID of this address version.
	 *
	 * @return the address version ID of this address version
	 */
	@Override
	public long getAddressVersionId() {
		return model.getAddressVersionId();
	}

	/**
	 * Returns the city corporation or municipality of this address version.
	 *
	 * @return the city corporation or municipality of this address version
	 */
	@Override
	public long getCityCorporationOrMunicipality() {
		return model.getCityCorporationOrMunicipality();
	}

	/**
	 * Returns the class name of this address version.
	 *
	 * @return the class name of this address version
	 */
	@Override
	public String getClassName() {
		return model.getClassName();
	}

	/**
	 * Returns the class pk of this address version.
	 *
	 * @return the class pk of this address version
	 */
	@Override
	public long getClassPK() {
		return model.getClassPK();
	}

	/**
	 * Returns the district of this address version.
	 *
	 * @return the district of this address version
	 */
	@Override
	public long getDistrict() {
		return model.getDistrict();
	}

	/**
	 * Returns the mouza or moholla of this address version.
	 *
	 * @return the mouza or moholla of this address version
	 */
	@Override
	public String getMouzaOrMoholla() {
		return model.getMouzaOrMoholla();
	}

	/**
	 * Returns the post office of this address version.
	 *
	 * @return the post office of this address version
	 */
	@Override
	public String getPostOffice() {
		return model.getPostOffice();
	}

	/**
	 * Returns the primary key of this address version.
	 *
	 * @return the primary key of this address version
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the region of this address version.
	 *
	 * @return the region of this address version
	 */
	@Override
	public long getRegion() {
		return model.getRegion();
	}

	/**
	 * Returns the union or ward of this address version.
	 *
	 * @return the union or ward of this address version
	 */
	@Override
	public long getUnionOrWard() {
		return model.getUnionOrWard();
	}

	/**
	 * Returns the upazilla of this address version.
	 *
	 * @return the upazilla of this address version
	 */
	@Override
	public long getUpazilla() {
		return model.getUpazilla();
	}

	/**
	 * Returns the village or road of this address version.
	 *
	 * @return the village or road of this address version
	 */
	@Override
	public String getVillageOrRoad() {
		return model.getVillageOrRoad();
	}

	/**
	 * Returns the zip code of this address version.
	 *
	 * @return the zip code of this address version
	 */
	@Override
	public long getZipCode() {
		return model.getZipCode();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address of this address version.
	 *
	 * @param address the address of this address version
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the address type of this address version.
	 *
	 * @param addressType the address type of this address version
	 */
	@Override
	public void setAddressType(String addressType) {
		model.setAddressType(addressType);
	}

	/**
	 * Sets the address version ID of this address version.
	 *
	 * @param addressVersionId the address version ID of this address version
	 */
	@Override
	public void setAddressVersionId(long addressVersionId) {
		model.setAddressVersionId(addressVersionId);
	}

	/**
	 * Sets the city corporation or municipality of this address version.
	 *
	 * @param cityCorporationOrMunicipality the city corporation or municipality of this address version
	 */
	@Override
	public void setCityCorporationOrMunicipality(
		long cityCorporationOrMunicipality) {

		model.setCityCorporationOrMunicipality(cityCorporationOrMunicipality);
	}

	/**
	 * Sets the class name of this address version.
	 *
	 * @param className the class name of this address version
	 */
	@Override
	public void setClassName(String className) {
		model.setClassName(className);
	}

	/**
	 * Sets the class pk of this address version.
	 *
	 * @param classPK the class pk of this address version
	 */
	@Override
	public void setClassPK(long classPK) {
		model.setClassPK(classPK);
	}

	/**
	 * Sets the district of this address version.
	 *
	 * @param district the district of this address version
	 */
	@Override
	public void setDistrict(long district) {
		model.setDistrict(district);
	}

	/**
	 * Sets the mouza or moholla of this address version.
	 *
	 * @param mouzaOrMoholla the mouza or moholla of this address version
	 */
	@Override
	public void setMouzaOrMoholla(String mouzaOrMoholla) {
		model.setMouzaOrMoholla(mouzaOrMoholla);
	}

	/**
	 * Sets the post office of this address version.
	 *
	 * @param postOffice the post office of this address version
	 */
	@Override
	public void setPostOffice(String postOffice) {
		model.setPostOffice(postOffice);
	}

	/**
	 * Sets the primary key of this address version.
	 *
	 * @param primaryKey the primary key of this address version
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the region of this address version.
	 *
	 * @param region the region of this address version
	 */
	@Override
	public void setRegion(long region) {
		model.setRegion(region);
	}

	/**
	 * Sets the union or ward of this address version.
	 *
	 * @param unionOrWard the union or ward of this address version
	 */
	@Override
	public void setUnionOrWard(long unionOrWard) {
		model.setUnionOrWard(unionOrWard);
	}

	/**
	 * Sets the upazilla of this address version.
	 *
	 * @param upazilla the upazilla of this address version
	 */
	@Override
	public void setUpazilla(long upazilla) {
		model.setUpazilla(upazilla);
	}

	/**
	 * Sets the village or road of this address version.
	 *
	 * @param villageOrRoad the village or road of this address version
	 */
	@Override
	public void setVillageOrRoad(String villageOrRoad) {
		model.setVillageOrRoad(villageOrRoad);
	}

	/**
	 * Sets the zip code of this address version.
	 *
	 * @param zipCode the zip code of this address version
	 */
	@Override
	public void setZipCode(long zipCode) {
		model.setZipCode(zipCode);
	}

	@Override
	protected AddressVersionWrapper wrap(AddressVersion addressVersion) {
		return new AddressVersionWrapper(addressVersion);
	}

}