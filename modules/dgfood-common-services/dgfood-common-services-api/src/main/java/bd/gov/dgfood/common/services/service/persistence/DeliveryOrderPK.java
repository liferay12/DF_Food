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

package bd.gov.dgfood.common.services.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DeliveryOrderPK
	implements Comparable<DeliveryOrderPK>, Serializable {

	public long deliveryOrderId;
	public long indentId;

	public DeliveryOrderPK() {
	}

	public DeliveryOrderPK(long deliveryOrderId, long indentId) {
		this.deliveryOrderId = deliveryOrderId;
		this.indentId = indentId;
	}

	public long getDeliveryOrderId() {
		return deliveryOrderId;
	}

	public void setDeliveryOrderId(long deliveryOrderId) {
		this.deliveryOrderId = deliveryOrderId;
	}

	public long getIndentId() {
		return indentId;
	}

	public void setIndentId(long indentId) {
		this.indentId = indentId;
	}

	@Override
	public int compareTo(DeliveryOrderPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (deliveryOrderId < pk.deliveryOrderId) {
			value = -1;
		}
		else if (deliveryOrderId > pk.deliveryOrderId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (indentId < pk.indentId) {
			value = -1;
		}
		else if (indentId > pk.indentId) {
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

		if (!(object instanceof DeliveryOrderPK)) {
			return false;
		}

		DeliveryOrderPK pk = (DeliveryOrderPK)object;

		if ((deliveryOrderId == pk.deliveryOrderId) &&
			(indentId == pk.indentId)) {

			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, deliveryOrderId);
		hashCode = HashUtil.hash(hashCode, indentId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("deliveryOrderId=");

		sb.append(deliveryOrderId);
		sb.append(", indentId=");

		sb.append(indentId);

		sb.append("}");

		return sb.toString();
	}

}