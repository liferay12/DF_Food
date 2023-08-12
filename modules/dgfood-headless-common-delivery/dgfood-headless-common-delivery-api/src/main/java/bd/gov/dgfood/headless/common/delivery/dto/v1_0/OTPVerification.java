package bd.gov.dgfood.headless.common.delivery.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.processing.Generated;
import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author krishna
 * @generated
 */
@Generated("")
@GraphQLName(
	description = "This Component is for verification of OTP number.",
	value = "OTPVerification"
)
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "OTPVerification")
public class OTPVerification implements Serializable {

	public static OTPVerification toDTO(String json) {
		return ObjectMapperUtil.readValue(OTPVerification.class, json);
	}

	public static OTPVerification unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(OTPVerification.class, json);
	}

	@Schema
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@JsonIgnore
	public void setErrorMsg(
		UnsafeSupplier<String, Exception> errorMsgUnsafeSupplier) {

		try {
			errorMsg = errorMsgUnsafeSupplier.get();
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
	protected String errorMsg;

	@Schema
	public Boolean getExceededVerifyMaxAttempt() {
		return exceededVerifyMaxAttempt;
	}

	public void setExceededVerifyMaxAttempt(Boolean exceededVerifyMaxAttempt) {
		this.exceededVerifyMaxAttempt = exceededVerifyMaxAttempt;
	}

	@JsonIgnore
	public void setExceededVerifyMaxAttempt(
		UnsafeSupplier<Boolean, Exception>
			exceededVerifyMaxAttemptUnsafeSupplier) {

		try {
			exceededVerifyMaxAttempt =
				exceededVerifyMaxAttemptUnsafeSupplier.get();
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
	protected Boolean exceededVerifyMaxAttempt;

	@Schema
	public Boolean getIsOtpExpired() {
		return isOtpExpired;
	}

	public void setIsOtpExpired(Boolean isOtpExpired) {
		this.isOtpExpired = isOtpExpired;
	}

	@JsonIgnore
	public void setIsOtpExpired(
		UnsafeSupplier<Boolean, Exception> isOtpExpiredUnsafeSupplier) {

		try {
			isOtpExpired = isOtpExpiredUnsafeSupplier.get();
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
	protected Boolean isOtpExpired;

	@Schema
	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	@JsonIgnore
	public void setStatusCode(
		UnsafeSupplier<Integer, Exception> statusCodeUnsafeSupplier) {

		try {
			statusCode = statusCodeUnsafeSupplier.get();
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
	protected Integer statusCode;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof OTPVerification)) {
			return false;
		}

		OTPVerification otpVerification = (OTPVerification)object;

		return Objects.equals(toString(), otpVerification.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (errorMsg != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"errorMsg\": ");

			sb.append("\"");

			sb.append(_escape(errorMsg));

			sb.append("\"");
		}

		if (exceededVerifyMaxAttempt != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"exceededVerifyMaxAttempt\": ");

			sb.append(exceededVerifyMaxAttempt);
		}

		if (isOtpExpired != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"isOtpExpired\": ");

			sb.append(isOtpExpired);
		}

		if (statusCode != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"statusCode\": ");

			sb.append(statusCode);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "bd.gov.dgfood.headless.common.delivery.dto.v1_0.OTPVerification",
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