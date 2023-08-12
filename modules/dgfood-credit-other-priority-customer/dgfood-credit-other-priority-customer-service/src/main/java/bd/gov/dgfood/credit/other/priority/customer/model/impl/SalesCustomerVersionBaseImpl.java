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

package bd.gov.dgfood.credit.other.priority.customer.model.impl;

import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerVersion;
import bd.gov.dgfood.credit.other.priority.customer.service.SalesCustomerVersionLocalServiceUtil;

/**
 * The extended model base implementation for the SalesCustomerVersion service. Represents a row in the &quot;DGFOOD_SalesCustomerVersion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SalesCustomerVersionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SalesCustomerVersionImpl
 * @see SalesCustomerVersion
 * @generated
 */
public abstract class SalesCustomerVersionBaseImpl
	extends SalesCustomerVersionModelImpl implements SalesCustomerVersion {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a sales customer version model instance should use the <code>SalesCustomerVersion</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			SalesCustomerVersionLocalServiceUtil.addSalesCustomerVersion(this);
		}
		else {
			SalesCustomerVersionLocalServiceUtil.updateSalesCustomerVersion(
				this);
		}
	}

}