package bd.gov.dgfood.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "dg-otp-configurations", scope = ExtendedObjectClassDefinition.Scope.COMPANY)
@Meta.OCD(id = "bd.gov.dgfood.configuration.OTPConfiguration", name = "otp-configuration")
public interface OTPConfiguration {
	@Meta.AD(required = false, deflt = "5", description = "otp-expiry-time-description", name="otp-expiry-time")
	public int getOtpExpiryTime();
	
	@Meta.AD(required = false, deflt = "4", description = "otp-verification-max-attempts-description", name="otp-verification-max-attempts")
	public int getMaxOtpVerifyAttempts();
	
	@Meta.AD(required = false, deflt = "3", description = "otp-resent-max-attempts-description", name="otp-resent-max-attempts")
	public int getOTPResendMaxAttempts();
	
	@Meta.AD(required = false, deflt = "15", description = "otp-lockout-time-description", name="otp-lockout-time")
	public int getLockOutTime();
}