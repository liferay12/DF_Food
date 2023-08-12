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
	description = "Contains the data for a FGLicense status.",
	value = "FGLicenseApplicationStatus"
)
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "FGLicenseApplicationStatus")
public class FGLicenseApplicationStatus implements Serializable {

	public static FGLicenseApplicationStatus toDTO(String json) {
		return ObjectMapperUtil.readValue(
			FGLicenseApplicationStatus.class, json);
	}

	public static FGLicenseApplicationStatus unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(
			FGLicenseApplicationStatus.class, json);
	}

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

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FGLicenseApplicationStatus)) {
			return false;
		}

		FGLicenseApplicationStatus fgLicenseApplicationStatus =
			(FGLicenseApplicationStatus)object;

		return Objects.equals(
			toString(), fgLicenseApplicationStatus.toString());
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

		if (challanDocument != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"challanDocument\": ");

			sb.append(String.valueOf(challanDocument));
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

		if (transactionNumber != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"transactionNumber\": ");

			sb.append("\"");

			sb.append(_escape(transactionNumber));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "dgfood.headless.license.management.system.dto.v1_0.FGLicenseApplicationStatus",
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