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
	value = "NewFGLicenseApplication"
)
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "NewFGLicenseApplication")
public class NewFGLicenseApplication implements Serializable {

	public static NewFGLicenseApplication toDTO(String json) {
		return ObjectMapperUtil.readValue(NewFGLicenseApplication.class, json);
	}

	public static NewFGLicenseApplication unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(
			NewFGLicenseApplication.class, json);
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
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@JsonIgnore
	public void setPassword(
		UnsafeSupplier<String, Exception> passwordUnsafeSupplier) {

		try {
			password = passwordUnsafeSupplier.get();
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
	protected String password;

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
	public String getRetypedPassword() {
		return retypedPassword;
	}

	public void setRetypedPassword(String retypedPassword) {
		this.retypedPassword = retypedPassword;
	}

	@JsonIgnore
	public void setRetypedPassword(
		UnsafeSupplier<String, Exception> retypedPasswordUnsafeSupplier) {

		try {
			retypedPassword = retypedPasswordUnsafeSupplier.get();
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
	protected String retypedPassword;

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

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof NewFGLicenseApplication)) {
			return false;
		}

		NewFGLicenseApplication newFGLicenseApplication =
			(NewFGLicenseApplication)object;

		return Objects.equals(toString(), newFGLicenseApplication.toString());
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

		if (maritalStatus != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"maritalStatus\": ");

			sb.append(maritalStatus);
		}

		if (password != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"password\": ");

			sb.append("\"");

			sb.append(_escape(password));

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

		if (retypedPassword != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"retypedPassword\": ");

			sb.append("\"");

			sb.append(_escape(retypedPassword));

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

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "dgfood.headless.license.management.system.dto.v1_0.NewFGLicenseApplication",
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