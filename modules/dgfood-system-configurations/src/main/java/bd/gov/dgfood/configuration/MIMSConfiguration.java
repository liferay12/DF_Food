package bd.gov.dgfood.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "dg-food-configurations", scope = ExtendedObjectClassDefinition.Scope.COMPANY)
@Meta.OCD(id = "bd.gov.dgfood.configuration.MIMSConfiguration", name = "Miller Information System Configuration")
public interface MIMSConfiguration {
	
	
	@Meta.AD(required = false, deflt = "NA",  description = "Enter the URL of Miller landing page. Post login miller will be redirect to this url", 
	name="Miller Landing page URL")
	public String getMillerLandingPageURL();

}
