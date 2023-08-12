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
	description = "Represents the dealer information to whom beneficiary will be linked.",
	value = "Dealer"
)
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "Dealer")
public class Dealer implements Serializable {

	public static Dealer toDTO(String json) {
		return ObjectMapperUtil.readValue(Dealer.class, json);
	}

	@Schema
	public String getDealerCode() {
		return dealerCode;
	}

	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	@JsonIgnore
	public void setDealerCode(
		UnsafeSupplier<String, Exception> dealerCodeUnsafeSupplier) {

		try {
			dealerCode = dealerCodeUnsafeSupplier.get();
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
	protected String dealerCode;

	@Schema
	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	@JsonIgnore
	public void setDealerName(
		UnsafeSupplier<String, Exception> dealerNameUnsafeSupplier) {

		try {
			dealerName = dealerNameUnsafeSupplier.get();
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
	protected String dealerName;

	@Schema
	public String getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	@JsonIgnore
	public void setShopAddress(
		UnsafeSupplier<String, Exception> shopAddressUnsafeSupplier) {

		try {
			shopAddress = shopAddressUnsafeSupplier.get();
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
	protected String shopAddress;

	@Schema
	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	@JsonIgnore
	public void setShopName(
		UnsafeSupplier<String, Exception> shopNameUnsafeSupplier) {

		try {
			shopName = shopNameUnsafeSupplier.get();
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
	protected String shopName;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Dealer)) {
			return false;
		}

		Dealer dealer = (Dealer)object;

		return Objects.equals(toString(), dealer.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (dealerCode != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dealerCode\": ");

			sb.append("\"");

			sb.append(_escape(dealerCode));

			sb.append("\"");
		}

		if (dealerName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dealerName\": ");

			sb.append("\"");

			sb.append(_escape(dealerName));

			sb.append("\"");
		}

		if (shopAddress != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"shopAddress\": ");

			sb.append("\"");

			sb.append(_escape(shopAddress));

			sb.append("\"");
		}

		if (shopName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"shopName\": ");

			sb.append("\"");

			sb.append(_escape(shopName));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "bd.gov.dgfood.headless.food.friendly.program.dto.v1_0.Dealer",
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