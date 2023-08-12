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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FGLicenseMDMData}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FGLicenseMDMData
 * @generated
 */
public class FGLicenseMDMDataWrapper
	extends BaseModelWrapper<FGLicenseMDMData>
	implements FGLicenseMDMData, ModelWrapper<FGLicenseMDMData> {

	public FGLicenseMDMDataWrapper(FGLicenseMDMData fgLicenseMDMData) {
		super(fgLicenseMDMData);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("fgLicenseMDMId", getFgLicenseMDMId());
		attributes.put("fgLicenseInfoId", getFgLicenseInfoId());
		attributes.put("fgLicenseMasterId", getFgLicenseMasterId());
		attributes.put("applicationMdmData", getApplicationMdmData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long fgLicenseMDMId = (Long)attributes.get("fgLicenseMDMId");

		if (fgLicenseMDMId != null) {
			setFgLicenseMDMId(fgLicenseMDMId);
		}

		Long fgLicenseInfoId = (Long)attributes.get("fgLicenseInfoId");

		if (fgLicenseInfoId != null) {
			setFgLicenseInfoId(fgLicenseInfoId);
		}

		Long fgLicenseMasterId = (Long)attributes.get("fgLicenseMasterId");

		if (fgLicenseMasterId != null) {
			setFgLicenseMasterId(fgLicenseMasterId);
		}

		String applicationMdmData = (String)attributes.get(
			"applicationMdmData");

		if (applicationMdmData != null) {
			setApplicationMdmData(applicationMdmData);
		}
	}

	@Override
	public FGLicenseMDMData cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the application mdm data of this fg license mdm data.
	 *
	 * @return the application mdm data of this fg license mdm data
	 */
	@Override
	public String getApplicationMdmData() {
		return model.getApplicationMdmData();
	}

	/**
	 * Returns the fg license info ID of this fg license mdm data.
	 *
	 * @return the fg license info ID of this fg license mdm data
	 */
	@Override
	public long getFgLicenseInfoId() {
		return model.getFgLicenseInfoId();
	}

	/**
	 * Returns the fg license master ID of this fg license mdm data.
	 *
	 * @return the fg license master ID of this fg license mdm data
	 */
	@Override
	public long getFgLicenseMasterId() {
		return model.getFgLicenseMasterId();
	}

	/**
	 * Returns the fg license mdm ID of this fg license mdm data.
	 *
	 * @return the fg license mdm ID of this fg license mdm data
	 */
	@Override
	public long getFgLicenseMDMId() {
		return model.getFgLicenseMDMId();
	}

	/**
	 * Returns the primary key of this fg license mdm data.
	 *
	 * @return the primary key of this fg license mdm data
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this fg license mdm data.
	 *
	 * @return the uuid of this fg license mdm data
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the application mdm data of this fg license mdm data.
	 *
	 * @param applicationMdmData the application mdm data of this fg license mdm data
	 */
	@Override
	public void setApplicationMdmData(String applicationMdmData) {
		model.setApplicationMdmData(applicationMdmData);
	}

	/**
	 * Sets the fg license info ID of this fg license mdm data.
	 *
	 * @param fgLicenseInfoId the fg license info ID of this fg license mdm data
	 */
	@Override
	public void setFgLicenseInfoId(long fgLicenseInfoId) {
		model.setFgLicenseInfoId(fgLicenseInfoId);
	}

	/**
	 * Sets the fg license master ID of this fg license mdm data.
	 *
	 * @param fgLicenseMasterId the fg license master ID of this fg license mdm data
	 */
	@Override
	public void setFgLicenseMasterId(long fgLicenseMasterId) {
		model.setFgLicenseMasterId(fgLicenseMasterId);
	}

	/**
	 * Sets the fg license mdm ID of this fg license mdm data.
	 *
	 * @param fgLicenseMDMId the fg license mdm ID of this fg license mdm data
	 */
	@Override
	public void setFgLicenseMDMId(long fgLicenseMDMId) {
		model.setFgLicenseMDMId(fgLicenseMDMId);
	}

	/**
	 * Sets the primary key of this fg license mdm data.
	 *
	 * @param primaryKey the primary key of this fg license mdm data
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this fg license mdm data.
	 *
	 * @param uuid the uuid of this fg license mdm data
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected FGLicenseMDMDataWrapper wrap(FGLicenseMDMData fgLicenseMDMData) {
		return new FGLicenseMDMDataWrapper(fgLicenseMDMData);
	}

}