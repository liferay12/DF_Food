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

package bd.gov.dgfood.credit.other.priority.customer.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SalesCustomerVersionPK
	implements Comparable<SalesCustomerVersionPK>, Serializable {

	public long salesCustomerVersionId;
	public long salesCustomerId;

	public SalesCustomerVersionPK() {
	}

	public SalesCustomerVersionPK(
		long salesCustomerVersionId, long salesCustomerId) {

		this.salesCustomerVersionId = salesCustomerVersionId;
		this.salesCustomerId = salesCustomerId;
	}

	public long getSalesCustomerVersionId() {
		return salesCustomerVersionId;
	}

	public void setSalesCustomerVersionId(long salesCustomerVersionId) {
		this.salesCustomerVersionId = salesCustomerVersionId;
	}

	public long getSalesCustomerId() {
		return salesCustomerId;
	}

	public void setSalesCustomerId(long salesCustomerId) {
		this.salesCustomerId = salesCustomerId;
	}

	@Override
	public int compareTo(SalesCustomerVersionPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (salesCustomerVersionId < pk.salesCustomerVersionId) {
			value = -1;
		}
		else if (salesCustomerVersionId > pk.salesCustomerVersionId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (salesCustomerId < pk.salesCustomerId) {
			value = -1;
		}
		else if (salesCustomerId > pk.salesCustomerId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SalesCustomerVersionPK)) {
			return false;
		}

		SalesCustomerVersionPK pk = (SalesCustomerVersionPK)object;

		if ((salesCustomerVersionId == pk.salesCustomerVersionId) &&
			(salesCustomerId == pk.salesCustomerId)) {

			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, salesCustomerVersionId);
		hashCode = HashUtil.hash(hashCode, salesCustomerId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("salesCustomerVersionId=");

		sb.append(salesCustomerVersionId);
		sb.append(", salesCustomerId=");

		sb.append(salesCustomerId);

		sb.append("}");

		return sb.toString();
	}

}