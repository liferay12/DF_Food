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

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Liferay
 * @generated
 */
@Generated("")
@GraphQLName(
	description = "Contains all of the data for a FGLicense renewal and duplicate.",
	value = "RenewalDuplicateFGLicenseApplication"
)
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "RenewalDuplicateFGLicenseApplication")
public class RenewalDuplicateFGLicenseApplication implements Serializable {

	public static RenewalDuplicateFGLicenseApplication toDTO(String json) {
		return ObjectMapperUtil.readValue(
			RenewalDuplicateFGLicenseApplication.class, json);
	}

	public static RenewalDuplicateFGLicenseApplication unsafeToDTO(
		String json) {

		return ObjectMapperUtil.unsafeReadValue(
			RenewalDuplicateFGLicenseApplication.class, json);
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

	@Schema
	public String getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}

	@JsonIgnore
	public void setLicenseType(
		UnsafeSupplier<String, Exception> licenseTypeUnsafeSupplier) {

		try {
			licenseType = licenseTypeUnsafeSupplier.get();
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
	protected String licenseType;

	@Schema(description = "reason for duplicate or renewal license request")
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

	@GraphQLField(
		description = "reason for duplicate or renewal license request"
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String reason;

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
	public String getTradeLicenseNumberPhotocopy() {
		return tradeLicenseNumberPhotocopy;
	}

	public void setTradeLicenseNumberPhotocopy(
		String tradeLicenseNumberPhotocopy) {

		this.tradeLicenseNumberPhotocopy = tradeLicenseNumberPhotocopy;
	}

	@JsonIgnore
	public void setTradeLicenseNumberPhotocopy(
		UnsafeSupplier<String, Exception>
			tradeLicenseNumberPhotocopyUnsafeSupplier) {

		try {
			tradeLicenseNumberPhotocopy =
				tradeLicenseNumberPhotocopyUnsafeSupplier.get();
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
	protected String tradeLicenseNumberPhotocopy;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RenewalDuplicateFGLicenseApplication)) {
			return false;
		}

		RenewalDuplicateFGLicenseApplication
			renewalDuplicateFGLicenseApplication =
				(RenewalDuplicateFGLicenseApplication)object;

		return Objects.equals(
			toString(), renewalDuplicateFGLicenseApplication.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (acknowledge != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"acknowledge\": ");

			sb.append(acknowledge);
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

		if (licenseType != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"licenseType\": ");

			sb.append("\"");

			sb.append(_escape(licenseType));

			sb.append("\"");
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

		if (tradeLicenseNumber != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"tradeLicenseNumber\": ");

			sb.append("\"");

			sb.append(_escape(tradeLicenseNumber));

			sb.append("\"");
		}

		if (tradeLicenseNumberPhotocopy != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"tradeLicenseNumberPhotocopy\": ");

			sb.append("\"");

			sb.append(_escape(tradeLicenseNumberPhotocopy));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "dgfood.headless.license.management.system.dto.v1_0.RenewalDuplicateFGLicenseApplication",
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