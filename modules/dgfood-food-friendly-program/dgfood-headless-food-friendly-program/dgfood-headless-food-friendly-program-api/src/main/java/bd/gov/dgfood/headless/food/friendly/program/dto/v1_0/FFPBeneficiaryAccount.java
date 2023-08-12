package bd.gov.dgfood.headless.food.friendly.program.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
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
 * @author krishna
 * @generated
 */
@Generated("")
@GraphQLName(
	description = "Contains all of the data for a single FFPBeneficiary.",
	value = "FFPBeneficiaryAccount"
)
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "FFPBeneficiaryAccount")
public class FFPBeneficiaryAccount implements Serializable {

	public static FFPBeneficiaryAccount toDTO(String json) {
		return ObjectMapperUtil.readValue(FFPBeneficiaryAccount.class, json);
	}

	@Schema
	public Boolean getAcknowledge() {
		return acknowledge;
	}

	public void setAcknowledge(Boolean acknowledge) {
		this.acknowledge = acknowledge;
	}

	@JsonIgnore
	public void setAcknowledge(
		UnsafeSupplier<Boolean, Exception> acknowledgeUnsafeSupplier) {

		try {
			acknowledge = acknowledgeUnsafeSupplier.get();
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
	protected Boolean acknowledge;

	@Schema
	public String[] getAdditionalDocuments() {
		return additionalDocuments;
	}

	public void setAdditionalDocuments(String[] additionalDocuments) {
		this.additionalDocuments = additionalDocuments;
	}

	@JsonIgnore
	public void setAdditionalDocuments(
		UnsafeSupplier<String[], Exception> additionalDocumentsUnsafeSupplier) {

		try {
			additionalDocuments = additionalDocumentsUnsafeSupplier.get();
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
	protected String[] additionalDocuments;

	@Schema(
		description = "The beneficiary's date of birth, in ISO 8601 format."
	)
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@JsonIgnore
	public void setBirthDate(
		UnsafeSupplier<Date, Exception> birthDateUnsafeSupplier) {

		try {
			birthDate = birthDateUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(
		description = "The beneficiary's date of birth, in ISO 8601 format."
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Date birthDate;

	@Schema
	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@JsonIgnore
	public void setCardNumber(
		UnsafeSupplier<String, Exception> cardNumberUnsafeSupplier) {

		try {
			cardNumber = cardNumberUnsafeSupplier.get();
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
	protected String cardNumber;

	@Schema(description = "The Union Chairman Id.")
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

	@GraphQLField(description = "The Union Chairman Id.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long createdBy;

	@Schema
	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@JsonIgnore
	public void setDateCreated(
		UnsafeSupplier<Date, Exception> dateCreatedUnsafeSupplier) {

		try {
			dateCreated = dateCreatedUnsafeSupplier.get();
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
	protected Date dateCreated;

	@Schema
	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	@JsonIgnore
	public void setDateModified(
		UnsafeSupplier<Date, Exception> dateModifiedUnsafeSupplier) {

		try {
			dateModified = dateModifiedUnsafeSupplier.get();
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
	protected Date dateModified;

	@Schema
	@Valid
	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	@JsonIgnore
	public void setDealer(
		UnsafeSupplier<Dealer, Exception> dealerUnsafeSupplier) {

		try {
			dealer = dealerUnsafeSupplier.get();
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
	protected Dealer dealer;

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

	@Schema
	public String getFamilyAverageMonthlyIncome() {
		return familyAverageMonthlyIncome;
	}

	public void setFamilyAverageMonthlyIncome(
		String familyAverageMonthlyIncome) {

		this.familyAverageMonthlyIncome = familyAverageMonthlyIncome;
	}

	@JsonIgnore
	public void setFamilyAverageMonthlyIncome(
		UnsafeSupplier<String, Exception>
			familyAverageMonthlyIncomeUnsafeSupplier) {

		try {
			familyAverageMonthlyIncome =
				familyAverageMonthlyIncomeUnsafeSupplier.get();
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
	protected String familyAverageMonthlyIncome;

	@Schema
	public Integer getFamilyEarningMembers() {
		return familyEarningMembers;
	}

	public void setFamilyEarningMembers(Integer familyEarningMembers) {
		this.familyEarningMembers = familyEarningMembers;
	}

	@JsonIgnore
	public void setFamilyEarningMembers(
		UnsafeSupplier<Integer, Exception> familyEarningMembersUnsafeSupplier) {

		try {
			familyEarningMembers = familyEarningMembersUnsafeSupplier.get();
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
	protected Integer familyEarningMembers;

	@Schema
	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	@JsonIgnore
	public void setFatherName(
		UnsafeSupplier<String, Exception> fatherNameUnsafeSupplier) {

		try {
			fatherName = fatherNameUnsafeSupplier.get();
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
	protected String fatherName;

	@Schema
	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	@JsonIgnore
	public void setGender(
		UnsafeSupplier<Integer, Exception> genderUnsafeSupplier) {

		try {
			gender = genderUnsafeSupplier.get();
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
	protected Integer gender;

	@Schema(description = "The beneficiary internal ID..")
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

	@GraphQLField(description = "The beneficiary internal ID..")
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

	@Schema
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@JsonIgnore
	public void setMobileNumber(
		UnsafeSupplier<String, Exception> mobileNumberUnsafeSupplier) {

		try {
			mobileNumber = mobileNumberUnsafeSupplier.get();
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
	protected String mobileNumber;

	@Schema(description = "The Union Chairman Id.")
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

	@GraphQLField(description = "The Union Chairman Id.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long modifiedBy;

	@Schema
	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	@JsonIgnore
	public void setMotherName(
		UnsafeSupplier<String, Exception> motherNameUnsafeSupplier) {

		try {
			motherName = motherNameUnsafeSupplier.get();
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
	protected String motherName;

	@Schema
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public void setName(UnsafeSupplier<String, Exception> nameUnsafeSupplier) {
		try {
			name = nameUnsafeSupplier.get();
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
	protected String name;

	@Schema
	public Long getNationalId() {
		return nationalId;
	}

	public void setNationalId(Long nationalId) {
		this.nationalId = nationalId;
	}

	@JsonIgnore
	public void setNationalId(
		UnsafeSupplier<Long, Exception> nationalIdUnsafeSupplier) {

		try {
			nationalId = nationalIdUnsafeSupplier.get();
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
	protected Long nationalId;

	@Schema
	public Boolean getNonOfMyFamilyMembersRegisteredEarlier() {
		return nonOfMyFamilyMembersRegisteredEarlier;
	}

	public void setNonOfMyFamilyMembersRegisteredEarlier(
		Boolean nonOfMyFamilyMembersRegisteredEarlier) {

		this.nonOfMyFamilyMembersRegisteredEarlier =
			nonOfMyFamilyMembersRegisteredEarlier;
	}

	@JsonIgnore
	public void setNonOfMyFamilyMembersRegisteredEarlier(
		UnsafeSupplier<Boolean, Exception>
			nonOfMyFamilyMembersRegisteredEarlierUnsafeSupplier) {

		try {
			nonOfMyFamilyMembersRegisteredEarlier =
				nonOfMyFamilyMembersRegisteredEarlierUnsafeSupplier.get();
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
	protected Boolean nonOfMyFamilyMembersRegisteredEarlier;

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
	public String getPhotograph() {
		return photograph;
	}

	public void setPhotograph(String photograph) {
		this.photograph = photograph;
	}

	@JsonIgnore
	public void setPhotograph(
		UnsafeSupplier<String, Exception> photographUnsafeSupplier) {

		try {
			photograph = photographUnsafeSupplier.get();
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
	protected String photograph;

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
	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	@JsonIgnore
	public void setSignature(
		UnsafeSupplier<String, Exception> signatureUnsafeSupplier) {

		try {
			signature = signatureUnsafeSupplier.get();
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
	protected String signature;

	@Schema(
		description = "The beneficiary's spouse date of birth, in ISO 8601 format."
	)
	public Date getSpouseBirthDate() {
		return spouseBirthDate;
	}

	public void setSpouseBirthDate(Date spouseBirthDate) {
		this.spouseBirthDate = spouseBirthDate;
	}

	@JsonIgnore
	public void setSpouseBirthDate(
		UnsafeSupplier<Date, Exception> spouseBirthDateUnsafeSupplier) {

		try {
			spouseBirthDate = spouseBirthDateUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(
		description = "The beneficiary's spouse date of birth, in ISO 8601 format."
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Date spouseBirthDate;

	@Schema
	public String getSpouseFatherName() {
		return spouseFatherName;
	}

	public void setSpouseFatherName(String spouseFatherName) {
		this.spouseFatherName = spouseFatherName;
	}

	@JsonIgnore
	public void setSpouseFatherName(
		UnsafeSupplier<String, Exception> spouseFatherNameUnsafeSupplier) {

		try {
			spouseFatherName = spouseFatherNameUnsafeSupplier.get();
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
	protected String spouseFatherName;

	@Schema
	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	@JsonIgnore
	public void setSpouseName(
		UnsafeSupplier<String, Exception> spouseNameUnsafeSupplier) {

		try {
			spouseName = spouseNameUnsafeSupplier.get();
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
	protected String spouseName;

	@Schema
	public Long getSpouseNationalId() {
		return spouseNationalId;
	}

	public void setSpouseNationalId(Long spouseNationalId) {
		this.spouseNationalId = spouseNationalId;
	}

	@JsonIgnore
	public void setSpouseNationalId(
		UnsafeSupplier<Long, Exception> spouseNationalIdUnsafeSupplier) {

		try {
			spouseNationalId = spouseNationalIdUnsafeSupplier.get();
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
	protected Long spouseNationalId;

	@Schema(
		description = "The beneficiary's status (approved, pending, rejected)."
	)
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@JsonIgnore
	public void setStatus(
		UnsafeSupplier<Integer, Exception> statusUnsafeSupplier) {

		try {
			status = statusUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(
		description = "The beneficiary's status (approved, pending, rejected)."
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Integer status;

	@Schema(
		description = "The latest version of the approved benficiary's details."
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
		description = "The latest version of the approved benficiary's details."
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Double version;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FFPBeneficiaryAccount)) {
			return false;
		}

		FFPBeneficiaryAccount ffpBeneficiaryAccount =
			(FFPBeneficiaryAccount)object;

		return Objects.equals(toString(), ffpBeneficiaryAccount.toString());
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

		if (acknowledge != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"acknowledge\": ");

			sb.append(acknowledge);
		}

		if (additionalDocuments != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"additionalDocuments\": ");

			sb.append("[");

			for (int i = 0; i < additionalDocuments.length; i++) {
				sb.append("\"");

				sb.append(_escape(additionalDocuments[i]));

				sb.append("\"");

				if ((i + 1) < additionalDocuments.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (birthDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"birthDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(birthDate));

			sb.append("\"");
		}

		if (cardNumber != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"cardNumber\": ");

			sb.append("\"");

			sb.append(_escape(cardNumber));

			sb.append("\"");
		}

		if (createdBy != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"createdBy\": ");

			sb.append(createdBy);
		}

		if (dateCreated != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dateCreated\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(dateCreated));

			sb.append("\"");
		}

		if (dateModified != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dateModified\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(dateModified));

			sb.append("\"");
		}

		if (dealer != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dealer\": ");

			sb.append(String.valueOf(dealer));
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

		if (familyAverageMonthlyIncome != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"familyAverageMonthlyIncome\": ");

			sb.append("\"");

			sb.append(_escape(familyAverageMonthlyIncome));

			sb.append("\"");
		}

		if (familyEarningMembers != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"familyEarningMembers\": ");

			sb.append(familyEarningMembers);
		}

		if (fatherName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fatherName\": ");

			sb.append("\"");

			sb.append(_escape(fatherName));

			sb.append("\"");
		}

		if (gender != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"gender\": ");

			sb.append(gender);
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

		if (mobileNumber != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"mobileNumber\": ");

			sb.append("\"");

			sb.append(_escape(mobileNumber));

			sb.append("\"");
		}

		if (modifiedBy != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"modifiedBy\": ");

			sb.append(modifiedBy);
		}

		if (motherName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"motherName\": ");

			sb.append("\"");

			sb.append(_escape(motherName));

			sb.append("\"");
		}

		if (name != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(name));

			sb.append("\"");
		}

		if (nationalId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nationalId\": ");

			sb.append(nationalId);
		}

		if (nonOfMyFamilyMembersRegisteredEarlier != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nonOfMyFamilyMembersRegisteredEarlier\": ");

			sb.append(nonOfMyFamilyMembersRegisteredEarlier);
		}

		if (permanentAddress != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"permanentAddress\": ");

			sb.append(String.valueOf(permanentAddress));
		}

		if (photograph != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"photograph\": ");

			sb.append("\"");

			sb.append(_escape(photograph));

			sb.append("\"");
		}

		if (presentAddress != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"presentAddress\": ");

			sb.append(String.valueOf(presentAddress));
		}

		if (sameAsPermanentAddress != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"sameAsPermanentAddress\": ");

			sb.append(sameAsPermanentAddress);
		}

		if (signature != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"signature\": ");

			sb.append("\"");

			sb.append(_escape(signature));

			sb.append("\"");
		}

		if (spouseBirthDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"spouseBirthDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(spouseBirthDate));

			sb.append("\"");
		}

		if (spouseFatherName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"spouseFatherName\": ");

			sb.append("\"");

			sb.append(_escape(spouseFatherName));

			sb.append("\"");
		}

		if (spouseName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"spouseName\": ");

			sb.append("\"");

			sb.append(_escape(spouseName));

			sb.append("\"");
		}

		if (spouseNationalId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"spouseNationalId\": ");

			sb.append(spouseNationalId);
		}

		if (status != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append(status);
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
		defaultValue = "bd.gov.dgfood.headless.food.friendly.program.dto.v1_0.FFPBeneficiaryAccount",
		name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		return string.replaceAll("\"", "\\\\\"");
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
			sb.append(entry.getKey());
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
				sb.append(value);
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

}