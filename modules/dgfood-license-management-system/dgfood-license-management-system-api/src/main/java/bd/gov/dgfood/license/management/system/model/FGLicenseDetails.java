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

package bd.gov.dgfood.license.management.system.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the FGLicenseDetails service. Represents a row in the &quot;fgl_master_details&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see FGLicenseDetailsModel
 * @generated
 */
@ImplementationClassName(
	"bd.gov.dgfood.license.management.system.model.impl.FGLicenseDetailsImpl"
)
@ProviderType
public interface FGLicenseDetails
	extends FGLicenseDetailsModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>bd.gov.dgfood.license.management.system.model.impl.FGLicenseDetailsImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<FGLicenseDetails, Long>
		FG_LICENSE_MASTER_ID_ACCESSOR = new Accessor<FGLicenseDetails, Long>() {

			@Override
			public Long get(FGLicenseDetails fgLicenseDetails) {
				return fgLicenseDetails.getFgLicenseMasterId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<FGLicenseDetails> getTypeClass() {
				return FGLicenseDetails.class;
			}

		};

}