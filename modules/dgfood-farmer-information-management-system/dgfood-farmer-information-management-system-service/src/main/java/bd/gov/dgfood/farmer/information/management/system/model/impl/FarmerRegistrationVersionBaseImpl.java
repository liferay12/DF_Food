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

package bd.gov.dgfood.farmer.information.management.system.model.impl;

import bd.gov.dgfood.farmer.information.management.system.model.FarmerRegistrationVersion;
import bd.gov.dgfood.farmer.information.management.system.service.FarmerRegistrationVersionLocalServiceUtil;

/**
 * The extended model base implementation for the FarmerRegistrationVersion service. Represents a row in the &quot;DGFood_FarmerRegistrationVer&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FarmerRegistrationVersionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FarmerRegistrationVersionImpl
 * @see FarmerRegistrationVersion
 * @generated
 */
public abstract class FarmerRegistrationVersionBaseImpl
	extends FarmerRegistrationVersionModelImpl
	implements FarmerRegistrationVersion {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a farmer registration version model instance should use the <code>FarmerRegistrationVersion</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			FarmerRegistrationVersionLocalServiceUtil.
				addFarmerRegistrationVersion(this);
		}
		else {
			FarmerRegistrationVersionLocalServiceUtil.
				updateFarmerRegistrationVersion(this);
		}
	}

}