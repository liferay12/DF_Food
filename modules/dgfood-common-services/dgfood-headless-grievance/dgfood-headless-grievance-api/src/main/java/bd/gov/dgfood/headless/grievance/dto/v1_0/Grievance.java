package bd.gov.dgfood.headless.grievance.dto.v1_0;

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

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author liferay
 * @generated
 */
@Generated("")
@GraphQLName(
	description = "Contains all of the data for a Grievance.",
	value = "Grievance"
)
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "Grievance")
public class Grievance implements Serializable {

	public static Grievance toDTO(String json) {
		return ObjectMapperUtil.readValue(Grievance.class, json);
	}

	public static Grievance unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(Grievance.class, json);
	}

	@Schema
	public String getComplaintDetails() {
		return complaintDetails;
	}

	public void setComplaintDetails(String complaintDetails) {
		this.complaintDetails = complaintDetails;
	}

	@JsonIgnore
	public void setComplaintDetails(
		UnsafeSupplier<String, Exception> complaintDetailsUnsafeSupplier) {

		try {
			complaintDetails = complaintDetailsUnsafeSupplier.get();
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
	protected String complaintDetails;

	@Schema(description = "The grievance creation date, in ISO 8601 format.")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@JsonIgnore
	public void setCreateDate(
		UnsafeSupplier<Date, Exception> createDateUnsafeSupplier) {

		try {
			createDate = createDateUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(
		description = "The grievance creation date, in ISO 8601 format."
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Date createDate;

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
	public String getGrievanceCategory() {
		return grievanceCategory;
	}

	public void setGrievanceCategory(String grievanceCategory) {
		this.grievanceCategory = grievanceCategory;
	}

	@JsonIgnore
	public void setGrievanceCategory(
		UnsafeSupplier<String, Exception> grievanceCategoryUnsafeSupplier) {

		try {
			grievanceCategory = grievanceCategoryUnsafeSupplier.get();
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
	protected String grievanceCategory;

	@Schema
	public String getGrievanceNumber() {
		return grievanceNumber;
	}

	public void setGrievanceNumber(String grievanceNumber) {
		this.grievanceNumber = grievanceNumber;
	}

	@JsonIgnore
	public void setGrievanceNumber(
		UnsafeSupplier<String, Exception> grievanceNumberUnsafeSupplier) {

		try {
			grievanceNumber = grievanceNumberUnsafeSupplier.get();
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
	protected String grievanceNumber;

	@Schema(description = "The grievance internal ID.")
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

	@GraphQLField(description = "The grievance internal ID.")
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Long id;

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

	@Schema
	public Long getResponseBy() {
		return responseBy;
	}

	public void setResponseBy(Long responseBy) {
		this.responseBy = responseBy;
	}

	@JsonIgnore
	public void setResponseBy(
		UnsafeSupplier<Long, Exception> responseByUnsafeSupplier) {

		try {
			responseBy = responseByUnsafeSupplier.get();
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
	protected Long responseBy;

	@Schema(description = "The grievance response date, in ISO 8601 format.")
	public Date getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}

	@JsonIgnore
	public void setResponseDate(
		UnsafeSupplier<Date, Exception> responseDateUnsafeSupplier) {

		try {
			responseDate = responseDateUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(
		description = "The grievance response date, in ISO 8601 format."
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Date responseDate;

	@Schema
	public String getResponseDetails() {
		return responseDetails;
	}

	public void setResponseDetails(String responseDetails) {
		this.responseDetails = responseDetails;
	}

	@JsonIgnore
	public void setResponseDetails(
		UnsafeSupplier<String, Exception> responseDetailsUnsafeSupplier) {

		try {
			responseDetails = responseDetailsUnsafeSupplier.get();
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
	protected String responseDetails;

	@Schema
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@JsonIgnore
	public void setUserId(
		UnsafeSupplier<Long, Exception> userIdUnsafeSupplier) {

		try {
			userId = userIdUnsafeSupplier.get();
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
	protected Long userId;

	@Schema
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@JsonIgnore
	public void setUserName(
		UnsafeSupplier<String, Exception> userNameUnsafeSupplier) {

		try {
			userName = userNameUnsafeSupplier.get();
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
	protected String userName;

	@Schema
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@JsonIgnore
	public void setUserType(
		UnsafeSupplier<String, Exception> userTypeUnsafeSupplier) {

		try {
			userType = userTypeUnsafeSupplier.get();
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
	protected String userType;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Grievance)) {
			return false;
		}

		Grievance grievance = (Grievance)object;

		return Objects.equals(toString(), grievance.toString());
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

		if (complaintDetails != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"complaintDetails\": ");

			sb.append("\"");

			sb.append(_escape(complaintDetails));

			sb.append("\"");
		}

		if (createDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"createDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(createDate));

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

		if (grievanceCategory != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"grievanceCategory\": ");

			sb.append("\"");

			sb.append(_escape(grievanceCategory));

			sb.append("\"");
		}

		if (grievanceNumber != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"grievanceNumber\": ");

			sb.append("\"");

			sb.append(_escape(grievanceNumber));

			sb.append("\"");
		}

		if (id != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(id);
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

		if (responseBy != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"responseBy\": ");

			sb.append(responseBy);
		}

		if (responseDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"responseDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(responseDate));

			sb.append("\"");
		}

		if (responseDetails != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"responseDetails\": ");

			sb.append("\"");

			sb.append(_escape(responseDetails));

			sb.append("\"");
		}

		if (userId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userId\": ");

			sb.append(userId);
		}

		if (userName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userName\": ");

			sb.append("\"");

			sb.append(_escape(userName));

			sb.append("\"");
		}

		if (userType != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userType\": ");

			sb.append("\"");

			sb.append(_escape(userType));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "bd.gov.dgfood.headless.grievance.dto.v1_0.Grievance",
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