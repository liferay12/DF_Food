package bd.gov.dgfood.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "dg-api-configurations", scope = ExtendedObjectClassDefinition.Scope.COMPANY)
@Meta.OCD(id = "bd.gov.dgfood.configuration.NIDConfiguration", name = "nid-api-configuration")
public interface NIDConfiguration {
	@Meta.AD(required = false, deflt = "www.dgfood.gov.bd", description = "nid-api-url-description", name="nid-api-url")
	public String getNIDAPIURL();
	
	@Meta.AD(required = false, deflt = "Test", description = "nid-api-username-description", name="nid-api-username")
	public String getNIDAPIUsername();
	
	@Meta.AD(required = false, deflt = "Test", description = "nid-api-password-description", name="nid-api-password")
	public String getNIDAPIPassword();

}