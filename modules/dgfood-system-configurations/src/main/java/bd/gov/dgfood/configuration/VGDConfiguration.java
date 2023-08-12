package bd.gov.dgfood.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category="dg-api-configurations",scope = ExtendedObjectClassDefinition.Scope.COMPANY)
@Meta.OCD(id = "bd.gov.dgfood.configuration.VGDConfiguration", name = "vgd-api-configuration")
public interface VGDConfiguration {
	@Meta.AD(required = false, deflt = "www.dgfood.gov.bd", description = "vgd-api-url-description", name="vgd-api-url")
	public String getVGDAPIURL();
	
	@Meta.AD(required = false, deflt = "Test", description = "vgd-api-username-description", name="vgd-api-username")
	public String getVGDAPIUsername();
	
	@Meta.AD(required = false, deflt = "Test", description = "vgd-api-password-description", name="vgd-api-password")
	public String getVGDAPIPassword();

}
