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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the FGLicenseMDMData service. Represents a row in the &quot;fgl_mdm_data&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>bd.gov.dgfood.license.management.system.model.impl.FGLicenseMDMDataModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>bd.gov.dgfood.license.management.system.model.impl.FGLicenseMDMDataImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FGLicenseMDMData
 * @generated
 */
@ProviderType
public interface FGLicenseMDMDataModel extends BaseModel<FGLicenseMDMData> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a fg license mdm data model instance should use the {@link FGLicenseMDMData} interface instead.
	 */

	/**
	 * Returns the primary key of this fg license mdm data.
	 *
	 * @return the primary key of this fg license mdm data
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this fg license mdm data.
	 *
	 * @param primaryKey the primary key of this fg license mdm data
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this fg license mdm data.
	 *
	 * @return the uuid of this fg license mdm data
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this fg license mdm data.
	 *
	 * @param uuid the uuid of this fg license mdm data
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the fg license mdm ID of this fg license mdm data.
	 *
	 * @return the fg license mdm ID of this fg license mdm data
	 */
	public long getFgLicenseMDMId();

	/**
	 * Sets the fg license mdm ID of this fg license mdm data.
	 *
	 * @param fgLicenseMDMId the fg license mdm ID of this fg license mdm data
	 */
	public void setFgLicenseMDMId(long fgLicenseMDMId);

	/**
	 * Returns the fg license info ID of this fg license mdm data.
	 *
	 * @return the fg license info ID of this fg license mdm data
	 */
	public long getFgLicenseInfoId();

	/**
	 * Sets the fg license info ID of this fg license mdm data.
	 *
	 * @param fgLicenseInfoId the fg license info ID of this fg license mdm data
	 */
	public void setFgLicenseInfoId(long fgLicenseInfoId);

	/**
	 * Returns the fg license master ID of this fg license mdm data.
	 *
	 * @return the fg license master ID of this fg license mdm data
	 */
	public long getFgLicenseMasterId();

	/**
	 * Sets the fg license master ID of this fg license mdm data.
	 *
	 * @param fgLicenseMasterId the fg license master ID of this fg license mdm data
	 */
	public void setFgLicenseMasterId(long fgLicenseMasterId);

	/**
	 * Returns the application mdm data of this fg license mdm data.
	 *
	 * @return the application mdm data of this fg license mdm data
	 */
	@AutoEscape
	public String getApplicationMdmData();

	/**
	 * Sets the application mdm data of this fg license mdm data.
	 *
	 * @param applicationMdmData the application mdm data of this fg license mdm data
	 */
	public void setApplicationMdmData(String applicationMdmData);

	@Override
	public FGLicenseMDMData cloneWithOriginalValues();

}