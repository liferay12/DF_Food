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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BankAccountInformation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BankAccountInformation
 * @generated
 */
public class BankAccountInformationWrapper
	extends BaseModelWrapper<BankAccountInformation>
	implements BankAccountInformation, ModelWrapper<BankAccountInformation> {

	public BankAccountInformationWrapper(
		BankAccountInformation bankAccountInformation) {

		super(bankAccountInformation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put(
			"bankAccountInformationId", getBankAccountInformationId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("accountNumber", getAccountNumber());
		attributes.put("bankName", getBankName());
		attributes.put("branchName", getBranchName());
		attributes.put("routingCode", getRoutingCode());
		attributes.put("status", getStatus());
		attributes.put("version", getVersion());
		attributes.put("classPK", getClassPK());
		attributes.put("classNameId", getClassNameId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long bankAccountInformationId = (Long)attributes.get(
			"bankAccountInformationId");

		if (bankAccountInformationId != null) {
			setBankAccountInformationId(bankAccountInformationId);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String accountNumber = (String)attributes.get("accountNumber");

		if (accountNumber != null) {
			setAccountNumber(accountNumber);
		}

		String bankName = (String)attributes.get("bankName");

		if (bankName != null) {
			setBankName(bankName);
		}

		String branchName = (String)attributes.get("branchName");

		if (branchName != null) {
			setBranchName(branchName);
		}

		String routingCode = (String)attributes.get("routingCode");

		if (routingCode != null) {
			setRoutingCode(routingCode);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}
	}

	@Override
	public BankAccountInformation cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the account number of this bank account information.
	 *
	 * @return the account number of this bank account information
	 */
	@Override
	public String getAccountNumber() {
		return model.getAccountNumber();
	}

	/**
	 * Returns the bank account information ID of this bank account information.
	 *
	 * @return the bank account information ID of this bank account information
	 */
	@Override
	public long getBankAccountInformationId() {
		return model.getBankAccountInformationId();
	}

	/**
	 * Returns the bank name of this bank account information.
	 *
	 * @return the bank name of this bank account information
	 */
	@Override
	public String getBankName() {
		return model.getBankName();
	}

	/**
	 * Returns the branch name of this bank account information.
	 *
	 * @return the branch name of this bank account information
	 */
	@Override
	public String getBranchName() {
		return model.getBranchName();
	}

	/**
	 * Returns the fully qualified class name of this bank account information.
	 *
	 * @return the fully qualified class name of this bank account information
	 */
	@Override
	public String getClassName() {
		return model.getClassName();
	}

	/**
	 * Returns the class name ID of this bank account information.
	 *
	 * @return the class name ID of this bank account information
	 */
	@Override
	public long getClassNameId() {
		return model.getClassNameId();
	}

	/**
	 * Returns the class pk of this bank account information.
	 *
	 * @return the class pk of this bank account information
	 */
	@Override
	public long getClassPK() {
		return model.getClassPK();
	}

	/**
	 * Returns the create date of this bank account information.
	 *
	 * @return the create date of this bank account information
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this bank account information.
	 *
	 * @return the created by of this bank account information
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the primary key of this bank account information.
	 *
	 * @return the primary key of this bank account information
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the routing code of this bank account information.
	 *
	 * @return the routing code of this bank account information
	 */
	@Override
	public String getRoutingCode() {
		return model.getRoutingCode();
	}

	/**
	 * Returns the status of this bank account information.
	 *
	 * @return the status of this bank account information
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the uuid of this bank account information.
	 *
	 * @return the uuid of this bank account information
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the version of this bank account information.
	 *
	 * @return the version of this bank account information
	 */
	@Override
	public String getVersion() {
		return model.getVersion();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the account number of this bank account information.
	 *
	 * @param accountNumber the account number of this bank account information
	 */
	@Override
	public void setAccountNumber(String accountNumber) {
		model.setAccountNumber(accountNumber);
	}

	/**
	 * Sets the bank account information ID of this bank account information.
	 *
	 * @param bankAccountInformationId the bank account information ID of this bank account information
	 */
	@Override
	public void setBankAccountInformationId(long bankAccountInformationId) {
		model.setBankAccountInformationId(bankAccountInformationId);
	}

	/**
	 * Sets the bank name of this bank account information.
	 *
	 * @param bankName the bank name of this bank account information
	 */
	@Override
	public void setBankName(String bankName) {
		model.setBankName(bankName);
	}

	/**
	 * Sets the branch name of this bank account information.
	 *
	 * @param branchName the branch name of this bank account information
	 */
	@Override
	public void setBranchName(String branchName) {
		model.setBranchName(branchName);
	}

	@Override
	public void setClassName(String className) {
		model.setClassName(className);
	}

	/**
	 * Sets the class name ID of this bank account information.
	 *
	 * @param classNameId the class name ID of this bank account information
	 */
	@Override
	public void setClassNameId(long classNameId) {
		model.setClassNameId(classNameId);
	}

	/**
	 * Sets the class pk of this bank account information.
	 *
	 * @param classPK the class pk of this bank account information
	 */
	@Override
	public void setClassPK(long classPK) {
		model.setClassPK(classPK);
	}

	/**
	 * Sets the create date of this bank account information.
	 *
	 * @param createDate the create date of this bank account information
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this bank account information.
	 *
	 * @param createdBy the created by of this bank account information
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the primary key of this bank account information.
	 *
	 * @param primaryKey the primary key of this bank account information
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the routing code of this bank account information.
	 *
	 * @param routingCode the routing code of this bank account information
	 */
	@Override
	public void setRoutingCode(String routingCode) {
		model.setRoutingCode(routingCode);
	}

	/**
	 * Sets the status of this bank account information.
	 *
	 * @param status the status of this bank account information
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the uuid of this bank account information.
	 *
	 * @param uuid the uuid of this bank account information
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the version of this bank account information.
	 *
	 * @param version the version of this bank account information
	 */
	@Override
	public void setVersion(String version) {
		model.setVersion(version);
	}

	@Override
	protected BankAccountInformationWrapper wrap(
		BankAccountInformation bankAccountInformation) {

		return new BankAccountInformationWrapper(bankAccountInformation);
	}

}