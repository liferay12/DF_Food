package bd.gov.dgfood.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "dg-food-configurations", scope = ExtendedObjectClassDefinition.Scope.COMPANY)
@Meta.OCD(id = "bd.gov.dgfood.configuration.FimsFarmerRegistrationConfiguration", name = "FIMS Farmer Registration Configuration")
public interface FIMSFarmerRegistrationConfiguration {
	
	
	@Meta.AD(required = false, deflt = "NA", description = "Enter the URL of Farmer landing page. Post login farmer will be redirect to this url", 
	name="Farmer Landing page URL")
	public String getFarmerLandingPageURL();

}
