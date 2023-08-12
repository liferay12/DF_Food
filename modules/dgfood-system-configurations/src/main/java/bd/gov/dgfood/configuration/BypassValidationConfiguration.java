package bd.gov.dgfood.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "dg-food-configurations", scope = ExtendedObjectClassDefinition.Scope.COMPANY)
@Meta.OCD(id = "bd.gov.dgfood.configuration.BypassValidationConfiguration", name = "validation-bypass-configuration")
public interface BypassValidationConfiguration {
	@Meta.AD(required = false, description = "bypass-farmer-registraton-validation-description", name="bypass-farmer-registration-validation")
	public boolean isFarmerRegistrationValidationDisabled();
	
	@Meta.AD(required = false, description = "bypass-farmer-sales-proposal-validation-description", name="bypass-farmer-sales-proposal-validation")
	public boolean isFarmerSalesProposalValidationDisabled();

	@Meta.AD(required = false, description = "bypass-food-grain-license-validation-description", name="bypass-food-grain-license-validation")
	public boolean isFoodGrainLicenseValidationDisabled();	

	@Meta.AD(required = false, deflt = "false", description = "If Set To TRUE Captcha Will ByPass", name="Captcha Bypass")
	public boolean isCaptchaValidationDisabled();
}