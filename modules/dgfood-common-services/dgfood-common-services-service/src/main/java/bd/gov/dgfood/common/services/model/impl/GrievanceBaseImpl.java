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

package bd.gov.dgfood.common.services.model.impl;

import bd.gov.dgfood.common.services.model.Grievance;
import bd.gov.dgfood.common.services.service.GrievanceLocalServiceUtil;

/**
 * The extended model base implementation for the Grievance service. Represents a row in the &quot;DGF_Grievance&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link GrievanceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GrievanceImpl
 * @see Grievance
 * @generated
 */
public abstract class GrievanceBaseImpl
	extends GrievanceModelImpl implements Grievance {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a grievance model instance should use the <code>Grievance</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			GrievanceLocalServiceUtil.addGrievance(this);
		}
		else {
			GrievanceLocalServiceUtil.updateGrievance(this);
		}
	}

}