package dgfood.headless.license.management.system.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.validation.Valid;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Liferay
 * @generated
 */
@Generated("")
@GraphQLName(
	description = "Contains all of the data for a single FGLicense.",
	value = "FGLicenseApplicationDetails"
)
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "FGLicenseApplicationDetails")
public class FGLicenseApplicationDetails implements Serializable {

	public static FGLicenseApplicationDetails toDTO(String json) {
		return ObjectMapperUtil.readValue(
			FGLicenseApplicationDetails.class, json);
	}

	public static FGLicenseApplicationDetails unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(
			FGLicenseApplicationDetails.class, json);
	}

	@Schema
	public String getApplicantFathersName() {
		return applicantFathersName;
	}

	public void setApplicantFathersName(String applicantFathersName) {
		this.applicantFathersName = applicantFathersName;
	}

	@JsonIgnore
	public void setApplicantFathersName(
		UnsafeSupplier<String, Exception> applicantFathersNameUnsafeSupplier) {

		try {
			applicantFathersName = applicantFathersNameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String applicantFathersName;

	@Schema
	public Integer getApplicantGender() {
		return applicantGender;
	}

	public void setApplicantGender(Integer applicantGender) {
		this.applicantGender = applicantGender;
	}

	@JsonIgnore
	public void setApplicantGender(
		UnsafeSupplier<Integer, Exception> applicantGenderUnsafeSupplier) {

		try {
			applicantGender = applicantGenderUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Integer applicantGender;

	@Schema
	public String getApplicantMobileNumber() {
		return applicantMobileNumber;
	}

	public void setApplicantMobileNumber(String applicantMobileNumber) {
		this.applicantMobileNumber = applicantMobileNumber;
	}

	@JsonIgnore
	public void setApplicantMobileNumber(
		UnsafeSupplier<String, Exception> applicantMobileNumberUnsafeSupplier) {

		try {
			applicantMobileNumber = applicantMobileNumberUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String applicantMobileNumber;

	@Schema
	public String getApplicantMothersName() {
		return applicantMothersName;
	}

	public void setApplicantMothersName(String applicantMothersName) {
		this.applicantMothersName = applicantMothersName;
	}

	@JsonIgnore
	public void setApplicantMothersName(
		UnsafeSupplier<String, Exception> applicantMothersNameUnsafeSupplier) {

		try {
			applicantMothersName = applicantMothersNameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String applicantMothersName;

	@Schema
	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	@JsonIgnore
	public void setApplicantName(
		UnsafeSupplier<String, Exception> applicantNameUnsafeSupplier) {

		try {
			applicantName = applicantNameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String applicantName;

	@Schema
	public Long getApplicantNationalId() {
		return applicantNationalId;
	}

	public void setApplicantNationalId(Long applicantNationalId) {
		this.applicantNationalId = applicantNationalId;
	}

	@JsonIgnore
	public void setApplicantNationalId(
		UnsafeSupplier<Long, Exception> applicantNationalIdUnsafeSupplier) {

		try {
			applicantNationalId = applicantNationalIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long applicantNationalId;

	@Schema
	public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	@JsonIgnore
	public void setApplicationNumber(
		UnsafeSupplier<String, Exception> applicationNumberUnsafeSupplier) {

		try {
			applicationNumber = applicationNumberUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected String applicationNumber;

	@Schema(
		description = "The fglicenses status (approved, pending, rejected)."
	)
	public Integer getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(Integer applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	@JsonIgnore
	public void setApplicationStatus(
		UnsafeSupplier<Integer, Exception> applicationStatusUnsafeSupplier) {

		try {
			applicationStatus = applicationStatusUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(
		description = "The fglicenses status (approved, pending, rejected)."
	)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Integer applicationStatus;

	@Schema
	@Valid
	public Attachment[] getAttachments() {
		return attachments;
	}

	public void setAttachments(Attachment[] attachments) {
		this.attachments = attachments;
	}

	@JsonIgnore
	public void setAttachments(
		UnsafeSupplier<Attachment[], Exception> attachmentsUnsafeSupplier) {

		try {
			attachments = attachmentsUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Attachment[] attachments;

	@Schema
	@Valid
	public Address getBusinessAddress() {
		return businessAddress;
	}

	public void setBusinessAddress(Address businessAddress) {
		this.businessAddress = businessAddress;
	}

	@JsonIgnore
	public void setBusinessAddress(
		UnsafeSupplier<Address, Exception> businessAddressUnsafeSupplier) {

		try {
			businessAddress = businessAddressUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Address businessAddress;

	@Schema
	public String getBusinessIdentificationNo() {
		return businessIdentificationNo;
	}

	public void setBusinessIdentificationNo(String businessIdentificationNo) {
		this.businessIdentificationNo = businessIdentificationNo;
	}

	@JsonIgnore
	public void setBusinessIdentificationNo(
		UnsafeSupplier<String, Exception>
			businessIdentificationNoUnsafeSupplier) {

		try {
			businessIdentificationNo =
				businessIdentificationNoUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String businessIdentificationNo;

	@Schema
	@Valid
	public Attachment getBusinessIdentificationNumberDocument() {
		return businessIdentificationNumberDocument;
	}

	public void setBusinessIdentificationNumberDocument(
		Attachment businessIdentificationNumberDocument) {

		this.businessIdentificationNumberDocument =
			businessIdentificationNumberDocument;
	}

	@JsonIgnore
	public void setBusinessIdentificationNumberDocument(
		UnsafeSupplier<Attachment, Exception>
			businessIdentificationNumberDocumentUnsafeSupplier) {

		try {
			businessIdentificationNumberDocument =
				businessIdentificationNumberDocumentUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Attachment businessIdentificationNumberDocument;

	@Schema
	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	@JsonIgnore
	public void setBusinessName(
		UnsafeSupplier<String, Exception> businessNameUnsafeSupplier) {

		try {
			businessName = businessNameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String businessName;

	@Schema
	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	@JsonIgnore
	public void setBusinessType(
		UnsafeSupplier<String, Exception> businessTypeUnsafeSupplier) {

		try {
			businessType = businessTypeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String businessType;

	@Schema
	@Valid
	public Attachment getChallanDocument() {
		return challanDocument;
	}

	public void setChallanDocument(Attachment challanDocument) {
		this.challanDocument = challanDocument;
	}

	@JsonIgnore
	public void setChallanDocument(
		UnsafeSupplier<Attachment, Exception> challanDocumentUnsafeSupplier) {

		try {
			challanDocument = challanDocumentUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Attachment challanDocument;

	@Schema(description = "comment for renewal & duplicate license request")
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@JsonIgnore
	public void setComments(
		UnsafeSupplier<String, Exception> commentsUnsafeSupplier) {

		try {
			comments = commentsUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(
		description = "comment for renewal & duplicate license request"
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String comments;

	@Schema(description = "0 if it newly created.")
	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@JsonIgnore
	public void setCreatedBy(
		UnsafeSupplier<Long, Exception> createdByUnsafeSupplier) {

		try {
			createdBy = createdByUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "0 if it newly created.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long createdBy;

	@Schema
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@JsonIgnore
	public void setCreatedDate(
		UnsafeSupplier<Date, Exception> createdDateUnsafeSupplier) {

		try {
			createdDate = createdDateUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Date createdDate;

	@Schema(description = "The applicants date of birth, in ISO 8601 format.")
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@JsonIgnore
	public void setDateOfBirth(
		UnsafeSupplier<Date, Exception> dateOfBirthUnsafeSupplier) {

		try {
			dateOfBirth = dateOfBirthUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(
		description = "The applicants date of birth, in ISO 8601 format."
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Date dateOfBirth;

	@Schema
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@JsonIgnore
	public void setEmailAddress(
		UnsafeSupplier<String, Exception> emailAddressUnsafeSupplier) {

		try {
			emailAddress = emailAddressUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String emailAddress;

	@Schema(
		description = "The applicants food grain license validity date, in ISO 8601 format."
	)
	public Date getFoodGrainLicenseExpiryDate() {
		return foodGrainLicenseExpiryDate;
	}

	public void setFoodGrainLicenseExpiryDate(Date foodGrainLicenseExpiryDate) {
		this.foodGrainLicenseExpiryDate = foodGrainLicenseExpiryDate;
	}

	@JsonIgnore
	public void setFoodGrainLicenseExpiryDate(
		UnsafeSupplier<Date, Exception>
			foodGrainLicenseExpiryDateUnsafeSupplier) {

		try {
			foodGrainLicenseExpiryDate =
				foodGrainLicenseExpiryDateUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(
		description = "The applicants food grain license validity date, in ISO 8601 format."
	)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Date foodGrainLicenseExpiryDate;

	@Schema(
		description = "The applicants food grain license issued date, in ISO 860 format."
	)
	public Date getFoodGrainLicenseIssueDate() {
		return foodGrainLicenseIssueDate;
	}

	public void setFoodGrainLicenseIssueDate(Date foodGrainLicenseIssueDate) {
		this.foodGrainLicenseIssueDate = foodGrainLicenseIssueDate;
	}

	@JsonIgnore
	public void setFoodGrainLicenseIssueDate(
		UnsafeSupplier<Date, Exception>
			foodGrainLicenseIssueDateUnsafeSupplier) {

		try {
			foodGrainLicenseIssueDate =
				foodGrainLicenseIssueDateUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(
		description = "The applicants food grain license issued date, in ISO 860 format."
	)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Date foodGrainLicenseIssueDate;

	@Schema
	public String getFoodGrainLicenseNumber() {
		return foodGrainLicenseNumber;
	}

	public void setFoodGrainLicenseNumber(String foodGrainLicenseNumber) {
		this.foodGrainLicenseNumber = foodGrainLicenseNumber;
	}

	@JsonIgnore
	public void setFoodGrainLicenseNumber(
		UnsafeSupplier<String, Exception>
			foodGrainLicenseNumberUnsafeSupplier) {

		try {
			foodGrainLicenseNumber = foodGrainLicenseNumberUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected String foodGrainLicenseNumber;

	@Schema(description = "The fglicense internal ID.")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public void setId(UnsafeSupplier<Long, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The fglicense internal ID.")
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Long id;

	@Schema
	public Integer getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(Integer maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	@JsonIgnore
	public void setMaritalStatus(
		UnsafeSupplier<Integer, Exception> maritalStatusUnsafeSupplier) {

		try {
			maritalStatus = maritalStatusUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Integer maritalStatus;

	@Schema(description = "0 if it newly created.")
	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@JsonIgnore
	public void setModifiedBy(
		UnsafeSupplier<Long, Exception> modifiedByUnsafeSupplier) {

		try {
			modifiedBy = modifiedByUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "0 if it newly created.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long modifiedBy;

	@Schema
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@JsonIgnore
	public void setModifiedDate(
		UnsafeSupplier<Date, Exception> modifiedDateUnsafeSupplier) {

		try {
			modifiedDate = modifiedDateUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Date modifiedDate;

	@Schema
	@Valid
	public Address getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	@JsonIgnore
	public void setPermanentAddress(
		UnsafeSupplier<Address, Exception> permanentAddressUnsafeSupplier) {

		try {
			permanentAddress = permanentAddressUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Address permanentAddress;

	@Schema
	@Valid
	public Address getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(Address presentAddress) {
		this.presentAddress = presentAddress;
	}

	@JsonIgnore
	public void setPresentAddress(
		UnsafeSupplier<Address, Exception> presentAddressUnsafeSupplier) {

		try {
			presentAddress = presentAddressUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Address presentAddress;

	@Schema
	@Valid
	public Attachment getProfilePhotographDocument() {
		return profilePhotographDocument;
	}

	public void setProfilePhotographDocument(
		Attachment profilePhotographDocument) {

		this.profilePhotographDocument = profilePhotographDocument;
	}

	@JsonIgnore
	public void setProfilePhotographDocument(
		UnsafeSupplier<Attachment, Exception>
			profilePhotographDocumentUnsafeSupplier) {

		try {
			profilePhotographDocument =
				profilePhotographDocumentUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Attachment profilePhotographDocument;

	@Schema(description = "reason for duplicate license request")
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@JsonIgnore
	public void setReason(
		UnsafeSupplier<String, Exception> reasonUnsafeSupplier) {

		try {
			reason = reasonUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "reason for duplicate license request")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String reason;

	@Schema
	public Boolean getSameAsPermanentAddress() {
		return sameAsPermanentAddress;
	}

	public void setSameAsPermanentAddress(Boolean sameAsPermanentAddress) {
		this.sameAsPermanentAddress = sameAsPermanentAddress;
	}

	@JsonIgnore
	public void setSameAsPermanentAddress(
		UnsafeSupplier<Boolean, Exception>
			sameAsPermanentAddressUnsafeSupplier) {

		try {
			sameAsPermanentAddress = sameAsPermanentAddressUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Boolean sameAsPermanentAddress;

	@Schema
	public String getTaxIdentificationNo() {
		return taxIdentificationNo;
	}

	public void setTaxIdentificationNo(String taxIdentificationNo) {
		this.taxIdentificationNo = taxIdentificationNo;
	}

	@JsonIgnore
	public void setTaxIdentificationNo(
		UnsafeSupplier<String, Exception> taxIdentificationNoUnsafeSupplier) {

		try {
			taxIdentificationNo = taxIdentificationNoUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String taxIdentificationNo;

	@Schema
	@Valid
	public Attachment getTaxIdentificationNumberDocument() {
		return taxIdentificationNumberDocument;
	}

	public void setTaxIdentificationNumberDocument(
		Attachment taxIdentificationNumberDocument) {

		this.taxIdentificationNumberDocument = taxIdentificationNumberDocument;
	}

	@JsonIgnore
	public void setTaxIdentificationNumberDocument(
		UnsafeSupplier<Attachment, Exception>
			taxIdentificationNumberDocumentUnsafeSupplier) {

		try {
			taxIdentificationNumberDocument =
				taxIdentificationNumberDocumentUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Attachment taxIdentificationNumberDocument;

	@Schema(
		description = "The applicants trade license validity date, in ISO 8601 format."
	)
	public Date getTradeLicenseExpiry() {
		return tradeLicenseExpiry;
	}

	public void setTradeLicenseExpiry(Date tradeLicenseExpiry) {
		this.tradeLicenseExpiry = tradeLicenseExpiry;
	}

	@JsonIgnore
	public void setTradeLicenseExpiry(
		UnsafeSupplier<Date, Exception> tradeLicenseExpiryUnsafeSupplier) {

		try {
			tradeLicenseExpiry = tradeLicenseExpiryUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(
		description = "The applicants trade license validity date, in ISO 8601 format."
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Date tradeLicenseExpiry;

	@Schema
	public String getTradeLicenseIssueCity() {
		return tradeLicenseIssueCity;
	}

	public void setTradeLicenseIssueCity(String tradeLicenseIssueCity) {
		this.tradeLicenseIssueCity = tradeLicenseIssueCity;
	}

	@JsonIgnore
	public void setTradeLicenseIssueCity(
		UnsafeSupplier<String, Exception> tradeLicenseIssueCityUnsafeSupplier) {

		try {
			tradeLicenseIssueCity = tradeLicenseIssueCityUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String tradeLicenseIssueCity;

	@Schema
	public String getTradeLicenseIssuerCode() {
		return tradeLicenseIssuerCode;
	}

	public void setTradeLicenseIssuerCode(String tradeLicenseIssuerCode) {
		this.tradeLicenseIssuerCode = tradeLicenseIssuerCode;
	}

	@JsonIgnore
	public void setTradeLicenseIssuerCode(
		UnsafeSupplier<String, Exception>
			tradeLicenseIssuerCodeUnsafeSupplier) {

		try {
			tradeLicenseIssuerCode = tradeLicenseIssuerCodeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String tradeLicenseIssuerCode;

	@Schema
	public String getTradeLicenseNumber() {
		return tradeLicenseNumber;
	}

	public void setTradeLicenseNumber(String tradeLicenseNumber) {
		this.tradeLicenseNumber = tradeLicenseNumber;
	}

	@JsonIgnore
	public void setTradeLicenseNumber(
		UnsafeSupplier<String, Exception> tradeLicenseNumberUnsafeSupplier) {

		try {
			tradeLicenseNumber = tradeLicenseNumberUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String tradeLicenseNumber;

	@Schema
	@Valid
	public Attachment getTradeLicenseNumberDocument() {
		return tradeLicenseNumberDocument;
	}

	public void setTradeLicenseNumberDocument(
		Attachment tradeLicenseNumberDocument) {

		this.tradeLicenseNumberDocument = tradeLicenseNumberDocument;
	}

	@JsonIgnore
	public void setTradeLicenseNumberDocument(
		UnsafeSupplier<Attachment, Exception>
			tradeLicenseNumberDocumentUnsafeSupplier) {

		try {
			tradeLicenseNumberDocument =
				tradeLicenseNumberDocumentUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Attachment tradeLicenseNumberDocument;

	@Schema
	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	@JsonIgnore
	public void setTransactionNumber(
		UnsafeSupplier<String, Exception> transactionNumberUnsafeSupplier) {

		try {
			transactionNumber = transactionNumberUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String transactionNumber;

	@Schema
	public String getTypeOfLicense() {
		return typeOfLicense;
	}

	public void setTypeOfLicense(String typeOfLicense) {
		this.typeOfLicense = typeOfLicense;
	}

	@JsonIgnore
	public void setTypeOfLicense(
		UnsafeSupplier<String, Exception> typeOfLicenseUnsafeSupplier) {

		try {
			typeOfLicense = typeOfLicenseUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String typeOfLicense;

	@Schema(
		description = "The latest version of the approved fglicense details."
	)
	public Double getVersion() {
		return version;
	}

	public void setVersion(Double version) {
		this.version = version;
	}

	@JsonIgnore
	public void setVersion(
		UnsafeSupplier<Double, Exception> versionUnsafeSupplier) {

		try {
			version = versionUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(
		description = "The latest version of the approved fglicense details."
	)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Double version;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FGLicenseApplicationDetails)) {
			return false;
		}

		FGLicenseApplicationDetails fgLicenseApplicationDetails =
			(FGLicenseApplicationDetails)object;

		return Objects.equals(
			toString(), fgLicenseApplicationDetails.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (applicantFathersName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"applicantFathersName\": ");

			sb.append("\"");

			sb.append(_escape(applicantFathersName));

			sb.append("\"");
		}

		if (applicantGender != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"applicantGender\": ");

			sb.append(applicantGender);
		}

		if (applicantMobileNumber != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"applicantMobileNumber\": ");

			sb.append("\"");

			sb.append(_escape(applicantMobileNumber));

			sb.append("\"");
		}

		if (applicantMothersName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"applicantMothersName\": ");

			sb.append("\"");

			sb.append(_escape(applicantMothersName));

			sb.append("\"");
		}

		if (applicantName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"applicantName\": ");

			sb.append("\"");

			sb.append(_escape(applicantName));

			sb.append("\"");
		}

		if (applicantNationalId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"applicantNationalId\": ");

			sb.append(applicantNationalId);
		}

		if (applicationNumber != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"applicationNumber\": ");

			sb.append("\"");

			sb.append(_escape(applicationNumber));

			sb.append("\"");
		}

		if (applicationStatus != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"applicationStatus\": ");

			sb.append(applicationStatus);
		}

		if (attachments != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"attachments\": ");

			sb.append("[");

			for (int i = 0; i < attachments.length; i++) {
				sb.append(String.valueOf(attachments[i]));

				if ((i + 1) < attachments.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (businessAddress != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"businessAddress\": ");

			sb.append(String.valueOf(businessAddress));
		}

		if (businessIdentificationNo != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"businessIdentificationNo\": ");

			sb.append("\"");

			sb.append(_escape(businessIdentificationNo));

			sb.append("\"");
		}

		if (businessIdentificationNumberDocument != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"businessIdentificationNumberDocument\": ");

			sb.append(String.valueOf(businessIdentificationNumberDocument));
		}

		if (businessName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"businessName\": ");

			sb.append("\"");

			sb.append(_escape(businessName));

			sb.append("\"");
		}

		if (businessType != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"businessType\": ");

			sb.append("\"");

			sb.append(_escape(businessType));

			sb.append("\"");
		}

		if (challanDocument != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"challanDocument\": ");

			sb.append(String.valueOf(challanDocument));
		}

		if (comments != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"comments\": ");

			sb.append("\"");

			sb.append(_escape(comments));

			sb.append("\"");
		}

		if (createdBy != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"createdBy\": ");

			sb.append(createdBy);
		}

		if (createdDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"createdDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(createdDate));

			sb.append("\"");
		}

		if (dateOfBirth != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dateOfBirth\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(dateOfBirth));

			sb.append("\"");
		}

		if (emailAddress != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"emailAddress\": ");

			sb.append("\"");

			sb.append(_escape(emailAddress));

			sb.append("\"");
		}

		if (foodGrainLicenseExpiryDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"foodGrainLicenseExpiryDate\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(foodGrainLicenseExpiryDate));

			sb.append("\"");
		}

		if (foodGrainLicenseIssueDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"foodGrainLicenseIssueDate\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(foodGrainLicenseIssueDate));

			sb.append("\"");
		}

		if (foodGrainLicenseNumber != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"foodGrainLicenseNumber\": ");

			sb.append("\"");

			sb.append(_escape(foodGrainLicenseNumber));

			sb.append("\"");
		}

		if (id != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(id);
		}

		if (maritalStatus != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"maritalStatus\": ");

			sb.append(maritalStatus);
		}

		if (modifiedBy != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"modifiedBy\": ");

			sb.append(modifiedBy);
		}

		if (modifiedDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"modifiedDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(modifiedDate));

			sb.append("\"");
		}

		if (permanentAddress != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"permanentAddress\": ");

			sb.append(String.valueOf(permanentAddress));
		}

		if (presentAddress != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"presentAddress\": ");

			sb.append(String.valueOf(presentAddress));
		}

		if (profilePhotographDocument != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"profilePhotographDocument\": ");

			sb.append(String.valueOf(profilePhotographDocument));
		}

		if (reason != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"reason\": ");

			sb.append("\"");

			sb.append(_escape(reason));

			sb.append("\"");
		}

		if (sameAsPermanentAddress != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"sameAsPermanentAddress\": ");

			sb.append(sameAsPermanentAddress);
		}

		if (taxIdentificationNo != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"taxIdentificationNo\": ");

			sb.append("\"");

			sb.append(_escape(taxIdentificationNo));

			sb.append("\"");
		}

		if (taxIdentificationNumberDocument != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"taxIdentificationNumberDocument\": ");

			sb.append(String.valueOf(taxIdentificationNumberDocument));
		}

		if (tradeLicenseExpiry != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"tradeLicenseExpiry\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(tradeLicenseExpiry));

			sb.append("\"");
		}

		if (tradeLicenseIssueCity != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"tradeLicenseIssueCity\": ");

			sb.append("\"");

			sb.append(_escape(tradeLicenseIssueCity));

			sb.append("\"");
		}

		if (tradeLicenseIssuerCode != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"tradeLicenseIssuerCode\": ");

			sb.append("\"");

			sb.append(_escape(tradeLicenseIssuerCode));

			sb.append("\"");
		}

		if (tradeLicenseNumber != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"tradeLicenseNumber\": ");

			sb.append("\"");

			sb.append(_escape(tradeLicenseNumber));

			sb.append("\"");
		}

		if (tradeLicenseNumberDocument != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"tradeLicenseNumberDocument\": ");

			sb.append(String.valueOf(tradeLicenseNumberDocument));
		}

		if (transactionNumber != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"transactionNumber\": ");

			sb.append("\"");

			sb.append(_escape(transactionNumber));

			sb.append("\"");
		}

		if (typeOfLicense != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"typeOfLicense\": ");

			sb.append("\"");

			sb.append(_escape(typeOfLicense));

			sb.append("\"");
		}

		if (version != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"version\": ");

			sb.append(version);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "dgfood.headless.license.management.system.dto.v1_0.FGLicenseApplicationDetails",
		name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		return StringUtil.replace(
			String.valueOf(object), _JSON_ESCAPE_STRINGS[0],
			_JSON_ESCAPE_STRINGS[1]);
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(_escape(entry.getKey()));
			sb.append("\": ");

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(value));
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static final String[][] _JSON_ESCAPE_STRINGS = {
		{"\\", "\"", "\b", "\f", "\n", "\r", "\t"},
		{"\\\\", "\\\"", "\\b", "\\f", "\\n", "\\r", "\\t"}
	};

}