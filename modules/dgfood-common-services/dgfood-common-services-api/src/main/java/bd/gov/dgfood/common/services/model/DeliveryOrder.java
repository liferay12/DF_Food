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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the DeliveryOrder service. Represents a row in the &quot;DGF_DeliveryOrder&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see DeliveryOrderModel
 * @generated
 */
@ImplementationClassName(
	"bd.gov.dgfood.common.services.model.impl.DeliveryOrderImpl"
)
@ProviderType
public interface DeliveryOrder extends DeliveryOrderModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>bd.gov.dgfood.common.services.model.impl.DeliveryOrderImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DeliveryOrder, Long>
		DELIVERY_ORDER_ID_ACCESSOR = new Accessor<DeliveryOrder, Long>() {

			@Override
			public Long get(DeliveryOrder deliveryOrder) {
				return deliveryOrder.getDeliveryOrderId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<DeliveryOrder> getTypeClass() {
				return DeliveryOrder.class;
			}

		};
	public static final Accessor<DeliveryOrder, Long> INDENT_ID_ACCESSOR =
		new Accessor<DeliveryOrder, Long>() {

			@Override
			public Long get(DeliveryOrder deliveryOrder) {
				return deliveryOrder.getIndentId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<DeliveryOrder> getTypeClass() {
				return DeliveryOrder.class;
			}

		};

}