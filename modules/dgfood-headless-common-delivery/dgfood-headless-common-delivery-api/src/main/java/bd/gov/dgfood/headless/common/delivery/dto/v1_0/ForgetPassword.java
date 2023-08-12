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
 * @author krishna
 * @generated
 */
@Generated("")
@GraphQLName(
	description = "For Forget password of existing user",
	value = "ForgetPassword"
)
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "ForgetPassword")
public class ForgetPassword implements Serializable {

	public static ForgetPassword toDTO(String json) {
		return ObjectMapperUtil.readValue(ForgetPassword.class, json);
	}

	public static ForgetPassword unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(ForgetPassword.class, json);
	}

	@Schema
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

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Date dateOfBirth;

	@Schema
	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	@JsonIgnore
	public void setLang(UnsafeSupplier<String, Exception> langUnsafeSupplier) {
		try {
			lang = langUnsafeSupplier.get();
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
	protected String lang;

	@Schema
	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@JsonIgnore
	public void setMobileNumber(
		UnsafeSupplier<Long, Exception> mobileNumberUnsafeSupplier) {

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
	protected Long mobileNumber;

	@Schema
	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	@JsonIgnore
	public void setNid(UnsafeSupplier<String, Exception> nidUnsafeSupplier) {
		try {
			nid = nidUnsafeSupplier.get();
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
	protected String nid;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ForgetPassword)) {
			return false;
		}

		ForgetPassword forgetPassword = (ForgetPassword)object;

		return Objects.equals(toString(), forgetPassword.toString());
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

		if (dateOfBirth != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dateOfBirth\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(dateOfBirth));

			sb.append("\"");
		}

		if (lang != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"lang\": ");

			sb.append("\"");

			sb.append(_escape(lang));

			sb.append("\"");
		}

		if (mobileNumber != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"mobileNumber\": ");

			sb.append(mobileNumber);
		}

		if (nid != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nid\": ");

			sb.append("\"");

			sb.append(_escape(nid));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "bd.gov.dgfood.headless.common.delivery.dto.v1_0.ForgetPassword",
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