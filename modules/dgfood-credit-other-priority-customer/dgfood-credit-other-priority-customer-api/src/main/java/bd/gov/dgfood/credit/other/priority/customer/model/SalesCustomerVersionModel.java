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

package bd.gov.dgfood.credit.other.priority.customer.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the SalesCustomerVersion service. Represents a row in the &quot;DGFOOD_SalesCustomerVersion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>bd.gov.dgfood.credit.other.priority.customer.model.impl.SalesCustomerVersionModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>bd.gov.dgfood.credit.other.priority.customer.model.impl.SalesCustomerVersionImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SalesCustomerVersion
 * @generated
 */
@ProviderType
public interface SalesCustomerVersionModel
	extends BaseModel<SalesCustomerVersion>, ShardedModel, StagedModel,
			WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a sales customer version model instance should use the {@link SalesCustomerVersion} interface instead.
	 */

	/**
	 * Returns the primary key of this sales customer version.
	 *
	 * @return the primary key of this sales customer version
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this sales customer version.
	 *
	 * @param primaryKey the primary key of this sales customer version
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this sales customer version.
	 *
	 * @return the uuid of this sales customer version
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this sales customer version.
	 *
	 * @param uuid the uuid of this sales customer version
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the sales customer version ID of this sales customer version.
	 *
	 * @return the sales customer version ID of this sales customer version
	 */
	public long getSalesCustomerVersionId();

	/**
	 * Sets the sales customer version ID of this sales customer version.
	 *
	 * @param salesCustomerVersionId the sales customer version ID of this sales customer version
	 */
	public void setSalesCustomerVersionId(long salesCustomerVersionId);

	/**
	 * Returns the sales customer ID of this sales customer version.
	 *
	 * @return the sales customer ID of this sales customer version
	 */
	public long getSalesCustomerId();

	/**
	 * Sets the sales customer ID of this sales customer version.
	 *
	 * @param salesCustomerId the sales customer ID of this sales customer version
	 */
	public void setSalesCustomerId(long salesCustomerId);

	/**
	 * Returns the group ID of this sales customer version.
	 *
	 * @return the group ID of this sales customer version
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this sales customer version.
	 *
	 * @param groupId the group ID of this sales customer version
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this sales customer version.
	 *
	 * @return the company ID of this sales customer version
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this sales customer version.
	 *
	 * @param companyId the company ID of this sales customer version
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the created by of this sales customer version.
	 *
	 * @return the created by of this sales customer version
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this sales customer version.
	 *
	 * @param createdBy the created by of this sales customer version
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the create date of this sales customer version.
	 *
	 * @return the create date of this sales customer version
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this sales customer version.
	 *
	 * @param createDate the create date of this sales customer version
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified by of this sales customer version.
	 *
	 * @return the modified by of this sales customer version
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this sales customer version.
	 *
	 * @param modifiedBy the modified by of this sales customer version
	 */
	public void setModifiedBy(long modifiedBy);

	/**
	 * Returns the modified date of this sales customer version.
	 *
	 * @return the modified date of this sales customer version
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this sales customer version.
	 *
	 * @param modifiedDate the modified date of this sales customer version
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the user ID of this sales customer version.
	 *
	 * @return the user ID of this sales customer version
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this sales customer version.
	 *
	 * @param userId the user ID of this sales customer version
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this sales customer version.
	 *
	 * @return the user uuid of this sales customer version
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this sales customer version.
	 *
	 * @param userUuid the user uuid of this sales customer version
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user type of this sales customer version.
	 *
	 * @return the user type of this sales customer version
	 */
	@AutoEscape
	public String getUserType();

	/**
	 * Sets the user type of this sales customer version.
	 *
	 * @param userType the user type of this sales customer version
	 */
	public void setUserType(String userType);

	/**
	 * Returns the mobile number of this sales customer version.
	 *
	 * @return the mobile number of this sales customer version
	 */
	@AutoEscape
	public String getMobileNumber();

	/**
	 * Sets the mobile number of this sales customer version.
	 *
	 * @param mobileNumber the mobile number of this sales customer version
	 */
	public void setMobileNumber(String mobileNumber);

	/**
	 * Returns the email address of this sales customer version.
	 *
	 * @return the email address of this sales customer version
	 */
	@AutoEscape
	public String getEmailAddress();

	/**
	 * Sets the email address of this sales customer version.
	 *
	 * @param emailAddress the email address of this sales customer version
	 */
	public void setEmailAddress(String emailAddress);

	/**
	 * Returns the title of this sales customer version.
	 *
	 * @return the title of this sales customer version
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this sales customer version.
	 *
	 * @param title the title of this sales customer version
	 */
	public void setTitle(String title);

	/**
	 * Returns the contact person name of this sales customer version.
	 *
	 * @return the contact person name of this sales customer version
	 */
	@AutoEscape
	public String getContactPersonName();

	/**
	 * Sets the contact person name of this sales customer version.
	 *
	 * @param contactPersonName the contact person name of this sales customer version
	 */
	public void setContactPersonName(String contactPersonName);

	/**
	 * Returns the contact person designation of this sales customer version.
	 *
	 * @return the contact person designation of this sales customer version
	 */
	@AutoEscape
	public String getContactPersonDesignation();

	/**
	 * Sets the contact person designation of this sales customer version.
	 *
	 * @param contactPersonDesignation the contact person designation of this sales customer version
	 */
	public void setContactPersonDesignation(String contactPersonDesignation);

	/**
	 * Returns the office name of this sales customer version.
	 *
	 * @return the office name of this sales customer version
	 */
	@AutoEscape
	public String getOfficeName();

	/**
	 * Sets the office name of this sales customer version.
	 *
	 * @param officeName the office name of this sales customer version
	 */
	public void setOfficeName(String officeName);

	/**
	 * Returns the organization name of this sales customer version.
	 *
	 * @return the organization name of this sales customer version
	 */
	@AutoEscape
	public String getOrganizationName();

	/**
	 * Sets the organization name of this sales customer version.
	 *
	 * @param organizationName the organization name of this sales customer version
	 */
	public void setOrganizationName(String organizationName);

	/**
	 * Returns the organization type of this sales customer version.
	 *
	 * @return the organization type of this sales customer version
	 */
	@AutoEscape
	public String getOrganizationType();

	/**
	 * Sets the organization type of this sales customer version.
	 *
	 * @param organizationType the organization type of this sales customer version
	 */
	public void setOrganizationType(String organizationType);

	/**
	 * Returns the gender of this sales customer version.
	 *
	 * @return the gender of this sales customer version
	 */
	public int getGender();

	/**
	 * Sets the gender of this sales customer version.
	 *
	 * @param gender the gender of this sales customer version
	 */
	public void setGender(int gender);

	/**
	 * Returns the version of this sales customer version.
	 *
	 * @return the version of this sales customer version
	 */
	public double getVersion();

	/**
	 * Sets the version of this sales customer version.
	 *
	 * @param version the version of this sales customer version
	 */
	public void setVersion(double version);

	/**
	 * Returns the status of this sales customer version.
	 *
	 * @return the status of this sales customer version
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this sales customer version.
	 *
	 * @param status the status of this sales customer version
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this sales customer version.
	 *
	 * @return the status by user ID of this sales customer version
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this sales customer version.
	 *
	 * @param statusByUserId the status by user ID of this sales customer version
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this sales customer version.
	 *
	 * @return the status by user uuid of this sales customer version
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this sales customer version.
	 *
	 * @param statusByUserUuid the status by user uuid of this sales customer version
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this sales customer version.
	 *
	 * @return the status by user name of this sales customer version
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this sales customer version.
	 *
	 * @param statusByUserName the status by user name of this sales customer version
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this sales customer version.
	 *
	 * @return the status date of this sales customer version
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this sales customer version.
	 *
	 * @param statusDate the status date of this sales customer version
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns <code>true</code> if this sales customer version is approved.
	 *
	 * @return <code>true</code> if this sales customer version is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this sales customer version is denied.
	 *
	 * @return <code>true</code> if this sales customer version is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this sales customer version is a draft.
	 *
	 * @return <code>true</code> if this sales customer version is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this sales customer version is expired.
	 *
	 * @return <code>true</code> if this sales customer version is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this sales customer version is inactive.
	 *
	 * @return <code>true</code> if this sales customer version is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this sales customer version is incomplete.
	 *
	 * @return <code>true</code> if this sales customer version is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this sales customer version is pending.
	 *
	 * @return <code>true</code> if this sales customer version is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this sales customer version is scheduled.
	 *
	 * @return <code>true</code> if this sales customer version is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public SalesCustomerVersion cloneWithOriginalValues();

}