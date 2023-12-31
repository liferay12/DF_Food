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
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the FGLicenseInfo service. Represents a row in the &quot;fgl_master_info&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>bd.gov.dgfood.license.management.system.model.impl.FGLicenseInfoModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>bd.gov.dgfood.license.management.system.model.impl.FGLicenseInfoImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FGLicenseInfo
 * @generated
 */
@ProviderType
public interface FGLicenseInfoModel
	extends BaseModel<FGLicenseInfo>, ShardedModel, StagedModel,
			WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a fg license info model instance should use the {@link FGLicenseInfo} interface instead.
	 */

	/**
	 * Returns the primary key of this fg license info.
	 *
	 * @return the primary key of this fg license info
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this fg license info.
	 *
	 * @param primaryKey the primary key of this fg license info
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this fg license info.
	 *
	 * @return the uuid of this fg license info
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this fg license info.
	 *
	 * @param uuid the uuid of this fg license info
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the fg license info ID of this fg license info.
	 *
	 * @return the fg license info ID of this fg license info
	 */
	public long getFgLicenseInfoId();

	/**
	 * Sets the fg license info ID of this fg license info.
	 *
	 * @param fgLicenseInfoId the fg license info ID of this fg license info
	 */
	public void setFgLicenseInfoId(long fgLicenseInfoId);

	/**
	 * Returns the fg license master ID of this fg license info.
	 *
	 * @return the fg license master ID of this fg license info
	 */
	public long getFgLicenseMasterId();

	/**
	 * Sets the fg license master ID of this fg license info.
	 *
	 * @param fgLicenseMasterId the fg license master ID of this fg license info
	 */
	public void setFgLicenseMasterId(long fgLicenseMasterId);

	/**
	 * Returns the fg license mdm ID of this fg license info.
	 *
	 * @return the fg license mdm ID of this fg license info
	 */
	public long getFgLicenseMDMId();

	/**
	 * Sets the fg license mdm ID of this fg license info.
	 *
	 * @param fgLicenseMDMId the fg license mdm ID of this fg license info
	 */
	public void setFgLicenseMDMId(long fgLicenseMDMId);

	/**
	 * Returns the national ID of this fg license info.
	 *
	 * @return the national ID of this fg license info
	 */
	@AutoEscape
	public String getNationalId();

	/**
	 * Sets the national ID of this fg license info.
	 *
	 * @param nationalId the national ID of this fg license info
	 */
	public void setNationalId(String nationalId);

	/**
	 * Returns the application number of this fg license info.
	 *
	 * @return the application number of this fg license info
	 */
	@AutoEscape
	public String getApplicationNumber();

	/**
	 * Sets the application number of this fg license info.
	 *
	 * @param applicationNumber the application number of this fg license info
	 */
	public void setApplicationNumber(String applicationNumber);

	/**
	 * Returns the applicant name of this fg license info.
	 *
	 * @return the applicant name of this fg license info
	 */
	@AutoEscape
	public String getApplicantName();

	/**
	 * Sets the applicant name of this fg license info.
	 *
	 * @param applicantName the applicant name of this fg license info
	 */
	public void setApplicantName(String applicantName);

	/**
	 * Returns the trade license number of this fg license info.
	 *
	 * @return the trade license number of this fg license info
	 */
	@AutoEscape
	public String getTradeLicenseNumber();

	/**
	 * Sets the trade license number of this fg license info.
	 *
	 * @param tradeLicenseNumber the trade license number of this fg license info
	 */
	public void setTradeLicenseNumber(String tradeLicenseNumber);

	/**
	 * Returns the foodgrain license number of this fg license info.
	 *
	 * @return the foodgrain license number of this fg license info
	 */
	@AutoEscape
	public String getFoodgrainLicenseNumber();

	/**
	 * Sets the foodgrain license number of this fg license info.
	 *
	 * @param foodgrainLicenseNumber the foodgrain license number of this fg license info
	 */
	public void setFoodgrainLicenseNumber(String foodgrainLicenseNumber);

	/**
	 * Returns the foodgrain license issue date of this fg license info.
	 *
	 * @return the foodgrain license issue date of this fg license info
	 */
	public Date getFoodgrainLicenseIssueDate();

	/**
	 * Sets the foodgrain license issue date of this fg license info.
	 *
	 * @param foodgrainLicenseIssueDate the foodgrain license issue date of this fg license info
	 */
	public void setFoodgrainLicenseIssueDate(Date foodgrainLicenseIssueDate);

	/**
	 * Returns the foodgrain license expiry date of this fg license info.
	 *
	 * @return the foodgrain license expiry date of this fg license info
	 */
	public Date getFoodgrainLicenseExpiryDate();

	/**
	 * Sets the foodgrain license expiry date of this fg license info.
	 *
	 * @param foodgrainLicenseExpiryDate the foodgrain license expiry date of this fg license info
	 */
	public void setFoodgrainLicenseExpiryDate(Date foodgrainLicenseExpiryDate);

	/**
	 * Returns the business name of this fg license info.
	 *
	 * @return the business name of this fg license info
	 */
	@AutoEscape
	public String getBusinessName();

	/**
	 * Sets the business name of this fg license info.
	 *
	 * @param businessName the business name of this fg license info
	 */
	public void setBusinessName(String businessName);

	/**
	 * Returns the business type of this fg license info.
	 *
	 * @return the business type of this fg license info
	 */
	@AutoEscape
	public String getBusinessType();

	/**
	 * Sets the business type of this fg license info.
	 *
	 * @param businessType the business type of this fg license info
	 */
	public void setBusinessType(String businessType);

	/**
	 * Returns the business address ID of this fg license info.
	 *
	 * @return the business address ID of this fg license info
	 */
	public long getBusinessAddressId();

	/**
	 * Sets the business address ID of this fg license info.
	 *
	 * @param businessAddressId the business address ID of this fg license info
	 */
	public void setBusinessAddressId(long businessAddressId);

	/**
	 * Returns the version of this fg license info.
	 *
	 * @return the version of this fg license info
	 */
	public double getVersion();

	/**
	 * Sets the version of this fg license info.
	 *
	 * @param version the version of this fg license info
	 */
	public void setVersion(double version);

	/**
	 * Returns the application type of this fg license info.
	 *
	 * @return the application type of this fg license info
	 */
	@AutoEscape
	public String getApplicationType();

	/**
	 * Sets the application type of this fg license info.
	 *
	 * @param applicationType the application type of this fg license info
	 */
	public void setApplicationType(String applicationType);

	/**
	 * Returns the sync status of this fg license info.
	 *
	 * @return the sync status of this fg license info
	 */
	public boolean getSyncStatus();

	/**
	 * Returns <code>true</code> if this fg license info is sync status.
	 *
	 * @return <code>true</code> if this fg license info is sync status; <code>false</code> otherwise
	 */
	public boolean isSyncStatus();

	/**
	 * Sets whether this fg license info is sync status.
	 *
	 * @param syncStatus the sync status of this fg license info
	 */
	public void setSyncStatus(boolean syncStatus);

	/**
	 * Returns the is expired of this fg license info.
	 *
	 * @return the is expired of this fg license info
	 */
	public boolean getIsExpired();

	/**
	 * Returns <code>true</code> if this fg license info is is expired.
	 *
	 * @return <code>true</code> if this fg license info is is expired; <code>false</code> otherwise
	 */
	public boolean isIsExpired();

	/**
	 * Sets whether this fg license info is is expired.
	 *
	 * @param isExpired the is expired of this fg license info
	 */
	public void setIsExpired(boolean isExpired);

	/**
	 * Returns the payment challan ID of this fg license info.
	 *
	 * @return the payment challan ID of this fg license info
	 */
	public long getPaymentChallanId();

	/**
	 * Sets the payment challan ID of this fg license info.
	 *
	 * @param paymentChallanId the payment challan ID of this fg license info
	 */
	public void setPaymentChallanId(long paymentChallanId);

	/**
	 * Returns the division of this fg license info.
	 *
	 * @return the division of this fg license info
	 */
	@AutoEscape
	public String getDivision();

	/**
	 * Sets the division of this fg license info.
	 *
	 * @param division the division of this fg license info
	 */
	public void setDivision(String division);

	/**
	 * Returns the district of this fg license info.
	 *
	 * @return the district of this fg license info
	 */
	@AutoEscape
	public String getDistrict();

	/**
	 * Sets the district of this fg license info.
	 *
	 * @param district the district of this fg license info
	 */
	public void setDistrict(String district);

	/**
	 * Returns the upazila of this fg license info.
	 *
	 * @return the upazila of this fg license info
	 */
	@AutoEscape
	public String getUpazila();

	/**
	 * Sets the upazila of this fg license info.
	 *
	 * @param upazila the upazila of this fg license info
	 */
	public void setUpazila(String upazila);

	/**
	 * Returns the status of this fg license info.
	 *
	 * @return the status of this fg license info
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this fg license info.
	 *
	 * @param status the status of this fg license info
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this fg license info.
	 *
	 * @return the status by user ID of this fg license info
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this fg license info.
	 *
	 * @param statusByUserId the status by user ID of this fg license info
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this fg license info.
	 *
	 * @return the status by user uuid of this fg license info
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this fg license info.
	 *
	 * @param statusByUserUuid the status by user uuid of this fg license info
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this fg license info.
	 *
	 * @return the status by user name of this fg license info
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this fg license info.
	 *
	 * @param statusByUserName the status by user name of this fg license info
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this fg license info.
	 *
	 * @return the status date of this fg license info
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this fg license info.
	 *
	 * @param statusDate the status date of this fg license info
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the group ID of this fg license info.
	 *
	 * @return the group ID of this fg license info
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this fg license info.
	 *
	 * @param groupId the group ID of this fg license info
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this fg license info.
	 *
	 * @return the company ID of this fg license info
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this fg license info.
	 *
	 * @param companyId the company ID of this fg license info
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this fg license info.
	 *
	 * @return the create date of this fg license info
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this fg license info.
	 *
	 * @param createDate the create date of this fg license info
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this fg license info.
	 *
	 * @return the modified date of this fg license info
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this fg license info.
	 *
	 * @param modifiedDate the modified date of this fg license info
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the modified by of this fg license info.
	 *
	 * @return the modified by of this fg license info
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this fg license info.
	 *
	 * @param modifiedBy the modified by of this fg license info
	 */
	public void setModifiedBy(long modifiedBy);

	/**
	 * Returns <code>true</code> if this fg license info is approved.
	 *
	 * @return <code>true</code> if this fg license info is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this fg license info is denied.
	 *
	 * @return <code>true</code> if this fg license info is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this fg license info is a draft.
	 *
	 * @return <code>true</code> if this fg license info is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this fg license info is expired.
	 *
	 * @return <code>true</code> if this fg license info is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this fg license info is inactive.
	 *
	 * @return <code>true</code> if this fg license info is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this fg license info is incomplete.
	 *
	 * @return <code>true</code> if this fg license info is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this fg license info is pending.
	 *
	 * @return <code>true</code> if this fg license info is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this fg license info is scheduled.
	 *
	 * @return <code>true</code> if this fg license info is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public FGLicenseInfo cloneWithOriginalValues();

}