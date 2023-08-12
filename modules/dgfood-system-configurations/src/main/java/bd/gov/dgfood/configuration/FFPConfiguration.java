package bd.gov.dgfood.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedAttributeDefinition;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "dg-food-configurations", scope = ExtendedObjectClassDefinition.Scope.COMPANY)
@Meta.OCD(id = "bd.gov.dgfood.configuration.FFPConfiguration", name = "Food Friendly Program Configuration")
public interface FFPConfiguration {

	
	@Meta.AD(required = false, deflt = "NA", description = "Enter the URL of FFP landing page. Post login FFP beneficiaries will be redirect to this url", name = "FFP Landing page URL")
	public String getFFPLandingPageURL();

	@Meta.AD(required = false, deflt = "0", description = "authority-user-id-description", name = "authority-user-id")
	public long getAuthorityUserId();

}
