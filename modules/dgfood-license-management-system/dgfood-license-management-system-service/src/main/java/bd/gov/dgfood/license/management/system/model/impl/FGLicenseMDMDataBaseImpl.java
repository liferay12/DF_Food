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

package bd.gov.dgfood.license.management.system.model.impl;

import bd.gov.dgfood.license.management.system.model.FGLicenseMDMData;
import bd.gov.dgfood.license.management.system.service.FGLicenseMDMDataLocalServiceUtil;

/**
 * The extended model base implementation for the FGLicenseMDMData service. Represents a row in the &quot;fgl_mdm_data&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FGLicenseMDMDataImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FGLicenseMDMDataImpl
 * @see FGLicenseMDMData
 * @generated
 */
public abstract class FGLicenseMDMDataBaseImpl
	extends FGLicenseMDMDataModelImpl implements FGLicenseMDMData {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a fg license mdm data model instance should use the <code>FGLicenseMDMData</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			FGLicenseMDMDataLocalServiceUtil.addFGLicenseMDMData(this);
		}
		else {
			FGLicenseMDMDataLocalServiceUtil.updateFGLicenseMDMData(this);
		}
	}

}