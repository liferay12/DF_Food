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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FGLicenseDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FGLicenseDetails
 * @generated
 */
public class FGLicenseDetailsWrapper
	extends BaseModelWrapper<FGLicenseDetails>
	implements FGLicenseDetails, ModelWrapper<FGLicenseDetails> {

	public FGLicenseDetailsWrapper(FGLicenseDetails fgLicenseDetails) {
		super(fgLicenseDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("fgLicenseMasterId", getFgLicenseMasterId());
		attributes.put("nationalId", getNationalId());
		attributes.put("applicationNumber", getApplicationNumber());
		attributes.put("applicantName", getApplicantName());
		attributes.put("tradeLicenseNumber", getTradeLicenseNumber());
		attributes.put("tradeLicenseExpiryDate", getTradeLicenseExpiryDate());
		attributes.put("tradeLicenseIssuerCode", getTradeLicenseIssuerCode());
		attributes.put("tradeLicenseIssuerCity", getTradeLicenseIssuerCity());
		attributes.put(
			"businessIdentificationNumber", getBusinessIdentificationNumber());
		attributes.put("taxIdentificationNumber", getTaxIdentificationNumber());
		attributes.put("paymentChallanId", getPaymentChallanId());
		attributes.put("tradeLicenseDocId", getTradeLicenseDocId());
		attributes.put(
			"businessIdentificationDocId", getBusinessIdentificationDocId());
		attributes.put("taxIdentfctDocId", getTaxIdentfctDocId());
		attributes.put("bankStatementDocId", getBankStatementDocId());
		attributes.put("reviewComments", getReviewComments());
		attributes.put("comments", getComments());
		attributes.put(
			"duplicateLicenseReasonId", getDuplicateLicenseReasonId());
		attributes.put("applicationType", getApplicationType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long fgLicenseMasterId = (Long)attributes.get("fgLicenseMasterId");

		if (fgLicenseMasterId != null) {
			setFgLicenseMasterId(fgLicenseMasterId);
		}

		String nationalId = (String)attributes.get("nationalId");

		if (nationalId != null) {
			setNationalId(nationalId);
		}

		String applicationNumber = (String)attributes.get("applicationNumber");

		if (applicationNumber != null) {
			setApplicationNumber(applicationNumber);
		}

		String applicantName = (String)attributes.get("applicantName");

		if (applicantName != null) {
			setApplicantName(applicantName);
		}

		String tradeLicenseNumber = (String)attributes.get(
			"tradeLicenseNumber");

		if (tradeLicenseNumber != null) {
			setTradeLicenseNumber(tradeLicenseNumber);
		}

		Date tradeLicenseExpiryDate = (Date)attributes.get(
			"tradeLicenseExpiryDate");

		if (tradeLicenseExpiryDate != null) {
			setTradeLicenseExpiryDate(tradeLicenseExpiryDate);
		}

		String tradeLicenseIssuerCode = (String)attributes.get(
			"tradeLicenseIssuerCode");

		if (tradeLicenseIssuerCode != null) {
			setTradeLicenseIssuerCode(tradeLicenseIssuerCode);
		}

		String tradeLicenseIssuerCity = (String)attributes.get(
			"tradeLicenseIssuerCity");

		if (tradeLicenseIssuerCity != null) {
			setTradeLicenseIssuerCity(tradeLicenseIssuerCity);
		}

		String businessIdentificationNumber = (String)attributes.get(
			"businessIdentificationNumber");

		if (businessIdentificationNumber != null) {
			setBusinessIdentificationNumber(businessIdentificationNumber);
		}

		String taxIdentificationNumber = (String)attributes.get(
			"taxIdentificationNumber");

		if (taxIdentificationNumber != null) {
			setTaxIdentificationNumber(taxIdentificationNumber);
		}

		Long paymentChallanId = (Long)attributes.get("paymentChallanId");

		if (paymentChallanId != null) {
			setPaymentChallanId(paymentChallanId);
		}

		Long tradeLicenseDocId = (Long)attributes.get("tradeLicenseDocId");

		if (tradeLicenseDocId != null) {
			setTradeLicenseDocId(tradeLicenseDocId);
		}

		Long businessIdentificationDocId = (Long)attributes.get(
			"businessIdentificationDocId");

		if (businessIdentificationDocId != null) {
			setBusinessIdentificationDocId(businessIdentificationDocId);
		}

		Long taxIdentfctDocId = (Long)attributes.get("taxIdentfctDocId");

		if (taxIdentfctDocId != null) {
			setTaxIdentfctDocId(taxIdentfctDocId);
		}

		Long bankStatementDocId = (Long)attributes.get("bankStatementDocId");

		if (bankStatementDocId != null) {
			setBankStatementDocId(bankStatementDocId);
		}

		String reviewComments = (String)attributes.get("reviewComments");

		if (reviewComments != null) {
			setReviewComments(reviewComments);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		String duplicateLicenseReasonId = (String)attributes.get(
			"duplicateLicenseReasonId");

		if (duplicateLicenseReasonId != null) {
			setDuplicateLicenseReasonId(duplicateLicenseReasonId);
		}

		String applicationType = (String)attributes.get("applicationType");

		if (applicationType != null) {
			setApplicationType(applicationType);
		}
	}

	@Override
	public FGLicenseDetails cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the applicant name of this fg license details.
	 *
	 * @return the applicant name of this fg license details
	 */
	@Override
	public String getApplicantName() {
		return model.getApplicantName();
	}

	/**
	 * Returns the application number of this fg license details.
	 *
	 * @return the application number of this fg license details
	 */
	@Override
	public String getApplicationNumber() {
		return model.getApplicationNumber();
	}

	/**
	 * Returns the application type of this fg license details.
	 *
	 * @return the application type of this fg license details
	 */
	@Override
	public String getApplicationType() {
		return model.getApplicationType();
	}

	/**
	 * Returns the bank statement doc ID of this fg license details.
	 *
	 * @return the bank statement doc ID of this fg license details
	 */
	@Override
	public long getBankStatementDocId() {
		return model.getBankStatementDocId();
	}

	/**
	 * Returns the business identification doc ID of this fg license details.
	 *
	 * @return the business identification doc ID of this fg license details
	 */
	@Override
	public long getBusinessIdentificationDocId() {
		return model.getBusinessIdentificationDocId();
	}

	/**
	 * Returns the business identification number of this fg license details.
	 *
	 * @return the business identification number of this fg license details
	 */
	@Override
	public String getBusinessIdentificationNumber() {
		return model.getBusinessIdentificationNumber();
	}

	/**
	 * Returns the comments of this fg license details.
	 *
	 * @return the comments of this fg license details
	 */
	@Override
	public String getComments() {
		return model.getComments();
	}

	/**
	 * Returns the duplicate license reason ID of this fg license details.
	 *
	 * @return the duplicate license reason ID of this fg license details
	 */
	@Override
	public String getDuplicateLicenseReasonId() {
		return model.getDuplicateLicenseReasonId();
	}

	/**
	 * Returns the fg license master ID of this fg license details.
	 *
	 * @return the fg license master ID of this fg license details
	 */
	@Override
	public long getFgLicenseMasterId() {
		return model.getFgLicenseMasterId();
	}

	/**
	 * Returns the national ID of this fg license details.
	 *
	 * @return the national ID of this fg license details
	 */
	@Override
	public String getNationalId() {
		return model.getNationalId();
	}

	/**
	 * Returns the payment challan ID of this fg license details.
	 *
	 * @return the payment challan ID of this fg license details
	 */
	@Override
	public long getPaymentChallanId() {
		return model.getPaymentChallanId();
	}

	/**
	 * Returns the primary key of this fg license details.
	 *
	 * @return the primary key of this fg license details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the review comments of this fg license details.
	 *
	 * @return the review comments of this fg license details
	 */
	@Override
	public String getReviewComments() {
		return model.getReviewComments();
	}

	/**
	 * Returns the tax identfct doc ID of this fg license details.
	 *
	 * @return the tax identfct doc ID of this fg license details
	 */
	@Override
	public long getTaxIdentfctDocId() {
		return model.getTaxIdentfctDocId();
	}

	/**
	 * Returns the tax identification number of this fg license details.
	 *
	 * @return the tax identification number of this fg license details
	 */
	@Override
	public String getTaxIdentificationNumber() {
		return model.getTaxIdentificationNumber();
	}

	/**
	 * Returns the trade license doc ID of this fg license details.
	 *
	 * @return the trade license doc ID of this fg license details
	 */
	@Override
	public long getTradeLicenseDocId() {
		return model.getTradeLicenseDocId();
	}

	/**
	 * Returns the trade license expiry date of this fg license details.
	 *
	 * @return the trade license expiry date of this fg license details
	 */
	@Override
	public Date getTradeLicenseExpiryDate() {
		return model.getTradeLicenseExpiryDate();
	}

	/**
	 * Returns the trade license issuer city of this fg license details.
	 *
	 * @return the trade license issuer city of this fg license details
	 */
	@Override
	public String getTradeLicenseIssuerCity() {
		return model.getTradeLicenseIssuerCity();
	}

	/**
	 * Returns the trade license issuer code of this fg license details.
	 *
	 * @return the trade license issuer code of this fg license details
	 */
	@Override
	public String getTradeLicenseIssuerCode() {
		return model.getTradeLicenseIssuerCode();
	}

	/**
	 * Returns the trade license number of this fg license details.
	 *
	 * @return the trade license number of this fg license details
	 */
	@Override
	public String getTradeLicenseNumber() {
		return model.getTradeLicenseNumber();
	}

	/**
	 * Returns the uuid of this fg license details.
	 *
	 * @return the uuid of this fg license details
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
	 * Sets the applicant name of this fg license details.
	 *
	 * @param applicantName the applicant name of this fg license details
	 */
	@Override
	public void setApplicantName(String applicantName) {
		model.setApplicantName(applicantName);
	}

	/**
	 * Sets the application number of this fg license details.
	 *
	 * @param applicationNumber the application number of this fg license details
	 */
	@Override
	public void setApplicationNumber(String applicationNumber) {
		model.setApplicationNumber(applicationNumber);
	}

	/**
	 * Sets the application type of this fg license details.
	 *
	 * @param applicationType the application type of this fg license details
	 */
	@Override
	public void setApplicationType(String applicationType) {
		model.setApplicationType(applicationType);
	}

	/**
	 * Sets the bank statement doc ID of this fg license details.
	 *
	 * @param bankStatementDocId the bank statement doc ID of this fg license details
	 */
	@Override
	public void setBankStatementDocId(long bankStatementDocId) {
		model.setBankStatementDocId(bankStatementDocId);
	}

	/**
	 * Sets the business identification doc ID of this fg license details.
	 *
	 * @param businessIdentificationDocId the business identification doc ID of this fg license details
	 */
	@Override
	public void setBusinessIdentificationDocId(
		long businessIdentificationDocId) {

		model.setBusinessIdentificationDocId(businessIdentificationDocId);
	}

	/**
	 * Sets the business identification number of this fg license details.
	 *
	 * @param businessIdentificationNumber the business identification number of this fg license details
	 */
	@Override
	public void setBusinessIdentificationNumber(
		String businessIdentificationNumber) {

		model.setBusinessIdentificationNumber(businessIdentificationNumber);
	}

	/**
	 * Sets the comments of this fg license details.
	 *
	 * @param comments the comments of this fg license details
	 */
	@Override
	public void setComments(String comments) {
		model.setComments(comments);
	}

	/**
	 * Sets the duplicate license reason ID of this fg license details.
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID of this fg license details
	 */
	@Override
	public void setDuplicateLicenseReasonId(String duplicateLicenseReasonId) {
		model.setDuplicateLicenseReasonId(duplicateLicenseReasonId);
	}

	/**
	 * Sets the fg license master ID of this fg license details.
	 *
	 * @param fgLicenseMasterId the fg license master ID of this fg license details
	 */
	@Override
	public void setFgLicenseMasterId(long fgLicenseMasterId) {
		model.setFgLicenseMasterId(fgLicenseMasterId);
	}

	/**
	 * Sets the national ID of this fg license details.
	 *
	 * @param nationalId the national ID of this fg license details
	 */
	@Override
	public void setNationalId(String nationalId) {
		model.setNationalId(nationalId);
	}

	/**
	 * Sets the payment challan ID of this fg license details.
	 *
	 * @param paymentChallanId the payment challan ID of this fg license details
	 */
	@Override
	public void setPaymentChallanId(long paymentChallanId) {
		model.setPaymentChallanId(paymentChallanId);
	}

	/**
	 * Sets the primary key of this fg license details.
	 *
	 * @param primaryKey the primary key of this fg license details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the review comments of this fg license details.
	 *
	 * @param reviewComments the review comments of this fg license details
	 */
	@Override
	public void setReviewComments(String reviewComments) {
		model.setReviewComments(reviewComments);
	}

	/**
	 * Sets the tax identfct doc ID of this fg license details.
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID of this fg license details
	 */
	@Override
	public void setTaxIdentfctDocId(long taxIdentfctDocId) {
		model.setTaxIdentfctDocId(taxIdentfctDocId);
	}

	/**
	 * Sets the tax identification number of this fg license details.
	 *
	 * @param taxIdentificationNumber the tax identification number of this fg license details
	 */
	@Override
	public void setTaxIdentificationNumber(String taxIdentificationNumber) {
		model.setTaxIdentificationNumber(taxIdentificationNumber);
	}

	/**
	 * Sets the trade license doc ID of this fg license details.
	 *
	 * @param tradeLicenseDocId the trade license doc ID of this fg license details
	 */
	@Override
	public void setTradeLicenseDocId(long tradeLicenseDocId) {
		model.setTradeLicenseDocId(tradeLicenseDocId);
	}

	/**
	 * Sets the trade license expiry date of this fg license details.
	 *
	 * @param tradeLicenseExpiryDate the trade license expiry date of this fg license details
	 */
	@Override
	public void setTradeLicenseExpiryDate(Date tradeLicenseExpiryDate) {
		model.setTradeLicenseExpiryDate(tradeLicenseExpiryDate);
	}

	/**
	 * Sets the trade license issuer city of this fg license details.
	 *
	 * @param tradeLicenseIssuerCity the trade license issuer city of this fg license details
	 */
	@Override
	public void setTradeLicenseIssuerCity(String tradeLicenseIssuerCity) {
		model.setTradeLicenseIssuerCity(tradeLicenseIssuerCity);
	}

	/**
	 * Sets the trade license issuer code of this fg license details.
	 *
	 * @param tradeLicenseIssuerCode the trade license issuer code of this fg license details
	 */
	@Override
	public void setTradeLicenseIssuerCode(String tradeLicenseIssuerCode) {
		model.setTradeLicenseIssuerCode(tradeLicenseIssuerCode);
	}

	/**
	 * Sets the trade license number of this fg license details.
	 *
	 * @param tradeLicenseNumber the trade license number of this fg license details
	 */
	@Override
	public void setTradeLicenseNumber(String tradeLicenseNumber) {
		model.setTradeLicenseNumber(tradeLicenseNumber);
	}

	/**
	 * Sets the uuid of this fg license details.
	 *
	 * @param uuid the uuid of this fg license details
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected FGLicenseDetailsWrapper wrap(FGLicenseDetails fgLicenseDetails) {
		return new FGLicenseDetailsWrapper(fgLicenseDetails);
	}

}