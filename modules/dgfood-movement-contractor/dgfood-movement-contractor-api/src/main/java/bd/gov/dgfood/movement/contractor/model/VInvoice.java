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

package bd.gov.dgfood.movement.contractor.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the VInvoice service. Represents a row in the &quot;DGFOOD_VInvoice&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see VInvoiceModel
 * @generated
 */
@ImplementationClassName(
	"bd.gov.dgfood.movement.contractor.model.impl.VInvoiceImpl"
)
@ProviderType
public interface VInvoice extends PersistedModel, VInvoiceModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>bd.gov.dgfood.movement.contractor.model.impl.VInvoiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<VInvoice, Long> V_INVOICE_ID_ACCESSOR =
		new Accessor<VInvoice, Long>() {

			@Override
			public Long get(VInvoice vInvoice) {
				return vInvoice.getVInvoiceId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<VInvoice> getTypeClass() {
				return VInvoice.class;
			}

		};

}