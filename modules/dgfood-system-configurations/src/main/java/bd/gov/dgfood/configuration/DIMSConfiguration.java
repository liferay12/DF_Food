package bd.gov.dgfood.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedAttributeDefinition;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "dg-food-configurations", scope = ExtendedObjectClassDefinition.Scope.COMPANY)
@Meta.OCD(id = "bd.gov.dgfood.configuration.DIMSConfiguration", name = "Dealer Information System Configuration")
public interface DIMSConfiguration {
	
	
	@Meta.AD(required = false, deflt = "NA", description = "Enter the URL of Dealer landing page. Post login dealer will be redirect to this url", 
	name="Dealer Landing page URL")
	public String getDealerLandingPageURL();

}
