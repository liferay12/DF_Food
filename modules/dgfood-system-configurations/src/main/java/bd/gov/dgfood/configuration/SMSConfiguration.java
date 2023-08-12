package bd.gov.dgfood.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category="dg-api-configurations",scope = ExtendedObjectClassDefinition.Scope.COMPANY)
@Meta.OCD(id = "bd.gov.dgfood.configuration.SMSConfiguration", name = "sms-api-configuration")
public interface SMSConfiguration {
	@Meta.AD(required = false, deflt = "www.dgfood.gov.bd", description = "sms-api-url-description", name="sms-api-url")
	public String getSMSAPIURL();
	
	@Meta.AD(required = false, deflt = "Test", description = "sms-api-username-description", name="sms-api-username")
	public String getSMSAPIUsername();
	
	@Meta.AD(required = false, deflt = "Test", description = "sms-api-password-description", name="sms-api-password")
	public String getSMSAPIPassword();

}
