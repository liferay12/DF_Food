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

import java.util.List;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.common.services.model.AddressVersion;
import bd.gov.dgfood.common.services.service.base.AddressVersionLocalServiceBaseImpl;

/**
 * The implementation of the address version local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>bd.gov.dgfood.common.services.service.AddressVersionLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressVersionLocalServiceBaseImpl
 */
/**
 * @author krishna
 *
 */
@Component(
	property = "model.class.name=bd.gov.dgfood.common.services.model.AddressVersion",
	service = AopService.class
)
public class AddressVersionLocalServiceImpl
	extends AddressVersionLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>bd.gov.dgfood.common.services.service.AddressVersionLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>bd.gov.dgfood.common.services.service.AddressVersionLocalServiceUtil</code>.
	 */
	
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
	public AddressVersion addAddressVersion(long region, long district, long upazilla, long cityCorporationOrMunicipality,
			long unionOrWard, long zipCode, String postOffice, String villageOrRoad, String mouzaOrMoholla,
			String homeAddress, String addressType, String className, long classPK) {

		AddressVersion addressVersion = createAddressVersion(counterLocalService.increment(AddressVersion.class.getName()));
		addressVersion.setRegion(region);
		addressVersion.setDistrict(district);
		addressVersion.setUpazilla(upazilla);
		addressVersion.setCityCorporationOrMunicipality(cityCorporationOrMunicipality);
		addressVersion.setUnionOrWard(unionOrWard);
		addressVersion.setPostOffice(postOffice);
		addressVersion.setZipCode(zipCode);
		addressVersion.setVillageOrRoad(villageOrRoad);
		addressVersion.setMouzaOrMoholla(mouzaOrMoholla);
		addressVersion.setAddress(homeAddress);
		addressVersion.setAddressType(addressType);
		addressVersion.setClassPK(classPK);
		addressVersion.setClassName(className);

		return addressVersionPersistence.update(addressVersion);

	}

	public List<AddressVersion> getAddressVersionsByClassNameAndClassPK(long classPK, String className) {

		return addressVersionPersistence.findByCPK_CN(classPK, className);
	}
	
	
}