package bd.gov.dgfood.headless.user.authentication.dto.v1_0;

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

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author AshishV
 * @generated
 */
@Generated("")
@GraphQLName(
	description = "Response for requested user authentication",
	value = "UserAuthenticationResponseData"
)
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "UserAuthenticationResponseData")
public class UserAuthenticationResponseData implements Serializable {

	public static UserAuthenticationResponseData toDTO(String json) {
		return ObjectMapperUtil.readValue(
			UserAuthenticationResponseData.class, json);
	}

	@Schema(description = "error Code for the request")
	public String getAuthenticationResult() {
		return authenticationResult;
	}

	public void setAuthenticationResult(String authenticationResult) {
		this.authenticationResult = authenticationResult;
	}

	@JsonIgnore
	public void setAuthenticationResult(
		UnsafeSupplier<String, Exception> authenticationResultUnsafeSupplier) {

		try {
			authenticationResult = authenticationResultUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "error Code for the request")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String authenticationResult;

	@Schema(description = "user email address")
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

	@GraphQLField(description = "user email address")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String emailAddress;

	@Schema(description = "Error code for the request")
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@JsonIgnore
	public void setErrorCode(
		UnsafeSupplier<String, Exception> errorCodeUnsafeSupplier) {

		try {
			errorCode = errorCodeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Error code for the request")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String errorCode;

	@Schema(description = "Error message for the request")
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@JsonIgnore
	public void setErrorMessage(
		UnsafeSupplier<String, Exception> errorMessageUnsafeSupplier) {

		try {
			errorMessage = errorMessageUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Error message for the request")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String errorMessage;

	@Schema(description = "Name of the user")
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@JsonIgnore
	public void setFullName(
		UnsafeSupplier<String, Exception> fullNameUnsafeSupplier) {

		try {
			fullName = fullNameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Name of the user")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String fullName;

	@Schema(description = "user screen name")
	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	@JsonIgnore
	public void setScreenName(
		UnsafeSupplier<String, Exception> screenNameUnsafeSupplier) {

		try {
			screenName = screenNameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "user screen name")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String screenName;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserAuthenticationResponseData)) {
			return false;
		}

		UserAuthenticationResponseData userAuthenticationResponseData =
			(UserAuthenticationResponseData)object;

		return Objects.equals(
			toString(), userAuthenticationResponseData.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (authenticationResult != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"authenticationResult\": ");

			sb.append("\"");

			sb.append(_escape(authenticationResult));

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

		if (errorCode != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"errorCode\": ");

			sb.append("\"");

			sb.append(_escape(errorCode));

			sb.append("\"");
		}

		if (errorMessage != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"errorMessage\": ");

			sb.append("\"");

			sb.append(_escape(errorMessage));

			sb.append("\"");
		}

		if (fullName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fullName\": ");

			sb.append("\"");

			sb.append(_escape(fullName));

			sb.append("\"");
		}

		if (screenName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"screenName\": ");

			sb.append("\"");

			sb.append(_escape(screenName));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "bd.gov.dgfood.headless.user.authentication.dto.v1_0.UserAuthenticationResponseData",
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