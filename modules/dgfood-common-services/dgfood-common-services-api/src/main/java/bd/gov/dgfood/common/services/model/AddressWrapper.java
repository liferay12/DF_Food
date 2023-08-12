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
 * This class is a wrapper for {@link Address}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Address
 * @generated
 */
public class AddressWrapper
	extends BaseModelWrapper<Address>
	implements Address, ModelWrapper<Address> {

	public AddressWrapper(Address address) {
		super(address);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("addressId", getAddressId());
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
		Long addressId = (Long)attributes.get("addressId");

		if (addressId != null) {
			setAddressId(addressId);
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
	public Address cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the address of this address.
	 *
	 * @return the address of this address
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the address ID of this address.
	 *
	 * @return the address ID of this address
	 */
	@Override
	public long getAddressId() {
		return model.getAddressId();
	}

	/**
	 * Returns the address type of this address.
	 *
	 * @return the address type of this address
	 */
	@Override
	public String getAddressType() {
		return model.getAddressType();
	}

	/**
	 * Returns the city corporation or municipality of this address.
	 *
	 * @return the city corporation or municipality of this address
	 */
	@Override
	public long getCityCorporationOrMunicipality() {
		return model.getCityCorporationOrMunicipality();
	}

	/**
	 * Returns the class name of this address.
	 *
	 * @return the class name of this address
	 */
	@Override
	public String getClassName() {
		return model.getClassName();
	}

	/**
	 * Returns the class pk of this address.
	 *
	 * @return the class pk of this address
	 */
	@Override
	public long getClassPK() {
		return model.getClassPK();
	}

	/**
	 * Returns the district of this address.
	 *
	 * @return the district of this address
	 */
	@Override
	public long getDistrict() {
		return model.getDistrict();
	}

	/**
	 * Returns the mouza or moholla of this address.
	 *
	 * @return the mouza or moholla of this address
	 */
	@Override
	public String getMouzaOrMoholla() {
		return model.getMouzaOrMoholla();
	}

	/**
	 * Returns the post office of this address.
	 *
	 * @return the post office of this address
	 */
	@Override
	public String getPostOffice() {
		return model.getPostOffice();
	}

	/**
	 * Returns the primary key of this address.
	 *
	 * @return the primary key of this address
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the region of this address.
	 *
	 * @return the region of this address
	 */
	@Override
	public long getRegion() {
		return model.getRegion();
	}

	/**
	 * Returns the union or ward of this address.
	 *
	 * @return the union or ward of this address
	 */
	@Override
	public long getUnionOrWard() {
		return model.getUnionOrWard();
	}

	/**
	 * Returns the upazilla of this address.
	 *
	 * @return the upazilla of this address
	 */
	@Override
	public long getUpazilla() {
		return model.getUpazilla();
	}

	/**
	 * Returns the village or road of this address.
	 *
	 * @return the village or road of this address
	 */
	@Override
	public String getVillageOrRoad() {
		return model.getVillageOrRoad();
	}

	/**
	 * Returns the zip code of this address.
	 *
	 * @return the zip code of this address
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
	 * Sets the address of this address.
	 *
	 * @param address the address of this address
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the address ID of this address.
	 *
	 * @param addressId the address ID of this address
	 */
	@Override
	public void setAddressId(long addressId) {
		model.setAddressId(addressId);
	}

	/**
	 * Sets the address type of this address.
	 *
	 * @param addressType the address type of this address
	 */
	@Override
	public void setAddressType(String addressType) {
		model.setAddressType(addressType);
	}

	/**
	 * Sets the city corporation or municipality of this address.
	 *
	 * @param cityCorporationOrMunicipality the city corporation or municipality of this address
	 */
	@Override
	public void setCityCorporationOrMunicipality(
		long cityCorporationOrMunicipality) {

		model.setCityCorporationOrMunicipality(cityCorporationOrMunicipality);
	}

	/**
	 * Sets the class name of this address.
	 *
	 * @param className the class name of this address
	 */
	@Override
	public void setClassName(String className) {
		model.setClassName(className);
	}

	/**
	 * Sets the class pk of this address.
	 *
	 * @param classPK the class pk of this address
	 */
	@Override
	public void setClassPK(long classPK) {
		model.setClassPK(classPK);
	}

	/**
	 * Sets the district of this address.
	 *
	 * @param district the district of this address
	 */
	@Override
	public void setDistrict(long district) {
		model.setDistrict(district);
	}

	/**
	 * Sets the mouza or moholla of this address.
	 *
	 * @param mouzaOrMoholla the mouza or moholla of this address
	 */
	@Override
	public void setMouzaOrMoholla(String mouzaOrMoholla) {
		model.setMouzaOrMoholla(mouzaOrMoholla);
	}

	/**
	 * Sets the post office of this address.
	 *
	 * @param postOffice the post office of this address
	 */
	@Override
	public void setPostOffice(String postOffice) {
		model.setPostOffice(postOffice);
	}

	/**
	 * Sets the primary key of this address.
	 *
	 * @param primaryKey the primary key of this address
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the region of this address.
	 *
	 * @param region the region of this address
	 */
	@Override
	public void setRegion(long region) {
		model.setRegion(region);
	}

	/**
	 * Sets the union or ward of this address.
	 *
	 * @param unionOrWard the union or ward of this address
	 */
	@Override
	public void setUnionOrWard(long unionOrWard) {
		model.setUnionOrWard(unionOrWard);
	}

	/**
	 * Sets the upazilla of this address.
	 *
	 * @param upazilla the upazilla of this address
	 */
	@Override
	public void setUpazilla(long upazilla) {
		model.setUpazilla(upazilla);
	}

	/**
	 * Sets the village or road of this address.
	 *
	 * @param villageOrRoad the village or road of this address
	 */
	@Override
	public void setVillageOrRoad(String villageOrRoad) {
		model.setVillageOrRoad(villageOrRoad);
	}

	/**
	 * Sets the zip code of this address.
	 *
	 * @param zipCode the zip code of this address
	 */
	@Override
	public void setZipCode(long zipCode) {
		model.setZipCode(zipCode);
	}

	@Override
	protected AddressWrapper wrap(Address address) {
		return new AddressWrapper(address);
	}

}