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

import javax.validation.Valid;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author krishna
 * @generated
 */
@Generated("")
@GraphQLName(
	description = "Represents the beneficiary's contact information.",
	value = "Address"
)
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "Address")
public class Address implements Serializable {

	public static Address toDTO(String json) {
		return ObjectMapperUtil.readValue(Address.class, json);
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
	@Valid
	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	@JsonIgnore
	public void setDistrict(
		UnsafeSupplier<District, Exception> districtUnsafeSupplier) {

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
	protected District district;

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
	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	@JsonIgnore
	public void setRegion(
		UnsafeSupplier<Region, Exception> regionUnsafeSupplier) {

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
	protected Region region;

	@Schema
	@Valid
	public Union getUnion() {
		return union;
	}

	public void setUnion(Union union) {
		this.union = union;
	}

	@JsonIgnore
	public void setUnion(UnsafeSupplier<Union, Exception> unionUnsafeSupplier) {
		try {
			union = unionUnsafeSupplier.get();
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
	protected Union union;

	@Schema
	@Valid
	public Upzilla getUpzilla() {
		return upzilla;
	}

	public void setUpzilla(Upzilla upzilla) {
		this.upzilla = upzilla;
	}

	@JsonIgnore
	public void setUpzilla(
		UnsafeSupplier<Upzilla, Exception> upzillaUnsafeSupplier) {

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
	protected Upzilla upzilla;

	@Schema
	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	@JsonIgnore
	public void setVillage(
		UnsafeSupplier<String, Exception> villageUnsafeSupplier) {

		try {
			village = villageUnsafeSupplier.get();
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
	protected String village;

	@Schema
	@Valid
	public Ward getWard() {
		return ward;
	}

	public void setWard(Ward ward) {
		this.ward = ward;
	}

	@JsonIgnore
	public void setWard(UnsafeSupplier<Ward, Exception> wardUnsafeSupplier) {
		try {
			ward = wardUnsafeSupplier.get();
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
	protected Ward ward;

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

		if (district != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"district\": ");

			sb.append(String.valueOf(district));
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

		if (union != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"union\": ");

			sb.append(String.valueOf(union));
		}

		if (upzilla != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"upzilla\": ");

			sb.append(String.valueOf(upzilla));
		}

		if (village != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"village\": ");

			sb.append("\"");

			sb.append(_escape(village));

			sb.append("\"");
		}

		if (ward != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"ward\": ");

			sb.append(String.valueOf(ward));
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
		defaultValue = "bd.gov.dgfood.headless.food.friendly.program.dto.v1_0.Address",
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