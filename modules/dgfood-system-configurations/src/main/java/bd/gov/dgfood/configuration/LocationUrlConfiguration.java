package bd.gov.dgfood.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import aQute.bnd.annotation.metatype.Meta;

/**
 * @author krishna
 *
 */
@ExtendedObjectClassDefinition(category = "dg-food-configurations", generateUI = true, scope = ExtendedObjectClassDefinition.Scope.COMPANY)
@Meta.OCD(id = "bd.gov.dgfood.configuration.LocationUrlConfiguration", localization = "content/Language", name = "location-configuration-name")
public interface LocationUrlConfiguration {

	@Meta.AD(deflt = "", description = "division-url-help", name = "division-url", required = false)
	public String divisionUrl();

	@Meta.AD(deflt = "", description = "district-url-help", name = "district-url", required = false)
	public String districtUrl();

	@Meta.AD(deflt = "", description = "upazila-url-help", name = "upazila-url", required = false)
	public String upazilaUrl();

	@Meta.AD(deflt = "", description = "union-url-help", name = "union-url", required = false)
	public String unionUrl();
	
	@Meta.AD(deflt = "0", description = "location-type-help", name = "location-type", required = false)
	public long locationType();
	
	@Meta.AD(deflt = "0", description = "role-help", name = "role", required = false)
	public long role();

}
