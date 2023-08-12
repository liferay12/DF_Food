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

package bd.gov.dgfood.common.services.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.common.services.model.Address;
import bd.gov.dgfood.common.services.service.base.AddressLocalServiceBaseImpl;

/**
 * The implementation of the address local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>bd.gov.dgfood.common.services.service.AddressLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressLocalServiceBaseImpl
 */
/**
 * @author krishna
 *
 */
@Component(property = "model.class.name=bd.gov.dgfood.common.services.model.Address", service = AopService.class)
public class AddressLocalServiceImpl extends AddressLocalServiceBaseImpl {

	/**
	 * @param region
	 * @param district
	 * @param upazilla
	 * @param cityCorporationOrMunicipality
	 * @param unionOrWard
	 * @param zipCode
	 * @param postOffice
	 * @param villageOrRoad
	 * @param mouzaOrMoholla
	 * @param homeAddress
	 * @param addressType
	 * @param className
	 * @param classPK
	 * @return
	 */
	public Address addAddress(long region, long district, long upazilla, long cityCorporationOrMunicipality,
			long unionOrWard, long zipCode, String postOffice, String villageOrRoad, String mouzaOrMoholla,
			String homeAddress, String addressType, String className, long classPK) {

		Address address = createAddress(counterLocalService.increment(Address.class.getName()));
		address.setRegion(region);
		address.setDistrict(district);
		address.setUpazilla(upazilla);
		address.setCityCorporationOrMunicipality(cityCorporationOrMunicipality);
		address.setUnionOrWard(unionOrWard);
		address.setPostOffice(postOffice);
		address.setZipCode(zipCode);
		address.setVillageOrRoad(villageOrRoad);
		address.setMouzaOrMoholla(mouzaOrMoholla);
		address.setAddress(homeAddress);
		address.setAddressType(addressType);
		address.setClassPK(classPK);
		address.setClassName(className);

		return addressPersistence.update(address);

	}

	/**
	 * Store the address of a user with address type.
	 */
	public Address addAddress(long region, long district, long upazilla, long cityCorporationOrMunicipality,
			long unionOrWard, long zipCode, String postOffice, String villageOrRoad, String mouzaOrMoholla,
			String homeAddress, String addressType) {

		Address address = createAddress(counterLocalService.increment(Address.class.getName()));
		address.setRegion(region);
		address.setDistrict(district);
		address.setUpazilla(upazilla);
		address.setCityCorporationOrMunicipality(cityCorporationOrMunicipality);
		address.setUnionOrWard(unionOrWard);
		address.setPostOffice(postOffice);
		address.setZipCode(zipCode);
		address.setVillageOrRoad(villageOrRoad);
		address.setMouzaOrMoholla(mouzaOrMoholla);
		address.setAddress(homeAddress);
		address.setAddressType(addressType);

		return addressPersistence.update(address);

	}

	public Address updateAddress(long addressId, long region, long district, long upazilla,
			long cityCorporationOrMunicipality, long unionOrWard, long zipCode, String postOffice, String villageOrRoad,
			String mouzaOrMoholla, String homeAddress) throws PortalException {

		Address address = getAddress(addressId);
		address.setRegion(region);
		address.setDistrict(district);
		address.setUpazilla(upazilla);
		address.setCityCorporationOrMunicipality(cityCorporationOrMunicipality);
		address.setUnionOrWard(unionOrWard);
		address.setPostOffice(postOffice);
		address.setZipCode(zipCode);
		address.setVillageOrRoad(villageOrRoad);
		address.setMouzaOrMoholla(mouzaOrMoholla);
		address.setAddress(homeAddress);

		return addressPersistence.update(address);

	}

	public Address updateAddress(long classPK, String className, String addressType, long region, long district,
			long upazilla, long cityCorporationOrMunicipality, long unionOrWard, long zipCode, String postOffice,
			String villageOrRoad, String mouzaOrMoholla, String homeAddress) throws PortalException {

		Address address = addressPersistence.findByCPK_CN_AT(classPK, className, addressType);

		address.setRegion(region);
		address.setDistrict(district);
		address.setUpazilla(upazilla);
		address.setCityCorporationOrMunicipality(cityCorporationOrMunicipality);
		address.setUnionOrWard(unionOrWard);
		address.setPostOffice(postOffice);
		address.setZipCode(zipCode);
		address.setVillageOrRoad(villageOrRoad);
		address.setMouzaOrMoholla(mouzaOrMoholla);
		address.setAddress(homeAddress);

		return addressPersistence.update(address);

	}

	/**
	 * fetch the address list for the given ids
	 * 
	 */
	public List<Address> fetchUserAddresses(List<Long> addressIds) {
		DynamicQuery dynamicQuery = dynamicQuery().add(RestrictionsFactoryUtil.in("addressId", addressIds));
		return dynamicQuery(dynamicQuery);

	}

	public List<Address> getAddressListByClassNameAndClassPK(long classPK, String className) {

		return addressPersistence.findByCPK_CN(classPK, className);
	}

}
