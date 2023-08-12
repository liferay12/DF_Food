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

import javax.validation.Valid;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Liferay
 * @generated
 */
@Generated("")
@GraphQLName(
	description = "Represents the fglicense applicants address information.",
	value = "Address"
)
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "Address")
public class Address implements Serializable {

	public static Address toDTO(String json) {
		return ObjectMapperUtil.readValue(Address.class, json);
	}

	public static Address unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(Address.class, json);
	}

	@Schema
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@JsonIgnore
	public void setAddress(
		UnsafeSupplier<String, Exception> addressUnsafeSupplier) {

		try {
			address = addressUnsafeSupplier.get();
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
	protected String address;

	@Schema
	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	@JsonIgnore
	public void setAddressType(
		UnsafeSupplier<String, Exception> addressTypeUnsafeSupplier) {

		try {
			addressType = addressTypeUnsafeSupplier.get();
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
	protected String addressType;

	@Schema
	@Valid
	public Location getCityCorporationOrMuncipalty() {
		return cityCorporationOrMuncipalty;
	}

	public void setCityCorporationOrMuncipalty(
		Location cityCorporationOrMuncipalty) {

		this.cityCorporationOrMuncipalty = cityCorporationOrMuncipalty;
	}

	@JsonIgnore
	public void setCityCorporationOrMuncipalty(
		UnsafeSupplier<Location, Exception>
			cityCorporationOrMuncipaltyUnsafeSupplier) {

		try {
			cityCorporationOrMuncipalty =
				cityCorporationOrMuncipaltyUnsafeSupplier.get();
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
	protected Location cityCorporationOrMuncipalty;

	@Schema
	@Valid
	public Location getDistrict() {
		return district;
	}

	public void setDistrict(Location district) {
		this.district = district;
	}

	@JsonIgnore
	public void setDistrict(
		UnsafeSupplier<Location, Exception> districtUnsafeSupplier) {

		try {
			district = districtUnsafeSupplier.get();
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
	protected Location district;

	@Schema
	public String getMouzaOrMoholla() {
		return mouzaOrMoholla;
	}

	public void setMouzaOrMoholla(String mouzaOrMoholla) {
		this.mouzaOrMoholla = mouzaOrMoholla;
	}

	@JsonIgnore
	public void setMouzaOrMoholla(
		UnsafeSupplier<String, Exception> mouzaOrMohollaUnsafeSupplier) {

		try {
			mouzaOrMoholla = mouzaOrMohollaUnsafeSupplier.get();
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
	protected String mouzaOrMoholla;

	@Schema
	public String getPostOffice() {
		return postOffice;
	}

	public void setPostOffice(String postOffice) {
		this.postOffice = postOffice;
	}

	@JsonIgnore
	public void setPostOffice(
		UnsafeSupplier<String, Exception> postOfficeUnsafeSupplier) {

		try {
			postOffice = postOfficeUnsafeSupplier.get();
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
	protected String postOffice;

	@Schema
	@Valid
	public Location getRegion() {
		return region;
	}

	public void setRegion(Location region) {
		this.region = region;
	}

	@JsonIgnore
	public void setRegion(
		UnsafeSupplier<Location, Exception> regionUnsafeSupplier) {

		try {
			region = regionUnsafeSupplier.get();
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
	protected Location region;

	@Schema
	@Valid
	public Location getUnionOrWard() {
		return unionOrWard;
	}

	public void setUnionOrWard(Location unionOrWard) {
		this.unionOrWard = unionOrWard;
	}

	@JsonIgnore
	public void setUnionOrWard(
		UnsafeSupplier<Location, Exception> unionOrWardUnsafeSupplier) {

		try {
			unionOrWard = unionOrWardUnsafeSupplier.get();
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
	protected Location unionOrWard;

	@Schema
	@Valid
	public Location getUpzilla() {
		return upzilla;
	}

	public void setUpzilla(Location upzilla) {
		this.upzilla = upzilla;
	}

	@JsonIgnore
	public void setUpzilla(
		UnsafeSupplier<Location, Exception> upzillaUnsafeSupplier) {

		try {
			upzilla = upzillaUnsafeSupplier.get();
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
	protected Location upzilla;

	@Schema
	public String getVillageOrRoad() {
		return villageOrRoad;
	}

	public void setVillageOrRoad(String villageOrRoad) {
		this.villageOrRoad = villageOrRoad;
	}

	@JsonIgnore
	public void setVillageOrRoad(
		UnsafeSupplier<String, Exception> villageOrRoadUnsafeSupplier) {

		try {
			villageOrRoad = villageOrRoadUnsafeSupplier.get();
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
	protected String villageOrRoad;

	@Schema
	public Long getZipCode() {
		return zipCode;
	}

	public void setZipCode(Long zipCode) {
		this.zipCode = zipCode;
	}

	@JsonIgnore
	public void setZipCode(
		UnsafeSupplier<Long, Exception> zipCodeUnsafeSupplier) {

		try {
			zipCode = zipCodeUnsafeSupplier.get();
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
	protected Long zipCode;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Address)) {
			return false;
		}

		Address address = (Address)object;

		return Objects.equals(toString(), address.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (address != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"address\": ");

			sb.append("\"");

			sb.append(_escape(address));

			sb.append("\"");
		}

		if (addressType != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"addressType\": ");

			sb.append("\"");

			sb.append(_escape(addressType));

			sb.append("\"");
		}

		if (cityCorporationOrMuncipalty != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"cityCorporationOrMuncipalty\": ");

			sb.append(String.valueOf(cityCorporationOrMuncipalty));
		}

		if (district != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"district\": ");

			sb.append(String.valueOf(district));
		}

		if (mouzaOrMoholla != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"mouzaOrMoholla\": ");

			sb.append("\"");

			sb.append(_escape(mouzaOrMoholla));

			sb.append("\"");
		}

		if (postOffice != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"postOffice\": ");

			sb.append("\"");

			sb.append(_escape(postOffice));

			sb.append("\"");
		}

		if (region != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"region\": ");

			sb.append(String.valueOf(region));
		}

		if (unionOrWard != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"unionOrWard\": ");

			sb.append(String.valueOf(unionOrWard));
		}

		if (upzilla != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"upzilla\": ");

			sb.append(String.valueOf(upzilla));
		}

		if (villageOrRoad != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"villageOrRoad\": ");

			sb.append("\"");

			sb.append(_escape(villageOrRoad));

			sb.append("\"");
		}

		if (zipCode != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"zipCode\": ");

			sb.append(zipCode);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "dgfood.headless.license.management.system.dto.v1_0.Address",
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