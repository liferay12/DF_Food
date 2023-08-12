package bd.gov.dgfood.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedAttributeDefinition;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "dg-food-configurations", scope = ExtendedObjectClassDefinition.Scope.COMPANY)
@Meta.OCD(id = "bd.gov.dgfood.configuration.LMSConfiguration", name = "label-license-management-system-configuration")
public interface LMSConfiguration {
	
	@ExtendedAttributeDefinition(descriptionArguments = "Required", requiredInput = true)
	@Meta.AD(required = false, deflt = "/admin-dashboard", description = "label-lms-admin-dashboard-description", name="label-lms-admin-dashboard-name")
	public String getLMSAdminDashboardURL();
	
	@ExtendedAttributeDefinition(descriptionArguments = "Required", requiredInput = true)
	@Meta.AD(required = false, deflt = "/admin-food-grain-license", description = "label-lms-admin-food-grain-license-description", name="label-lms-admin-food-grain-license-name")
	public String getLMSAdminFgLicenseURL();
	
	@ExtendedAttributeDefinition(descriptionArguments = "Required", requiredInput = true)
	@Meta.AD(required = false, deflt = "/admin-food-grain-license-version", description = "label-lms-admin-food-grain-license-description", name="label-lms-admin-food-grain-license-name")
	public String getLMSAdminFgLicenseVersionURL();
	
	@ExtendedAttributeDefinition(descriptionArguments = "Required", requiredInput = true)
	@Meta.AD(required = false, deflt = "/admin-my-profile", description = "label-lms-admin-my-profile-description", name="label-lms-admin-my-profile-name")
	public String getLMSAdminProfileURL();
	
	@ExtendedAttributeDefinition(descriptionArguments = "Required", requiredInput = true)
	@Meta.AD(required = false, deflt = "/fg-dashboard", description = "label-lms-dashboard-description", name="label-lms-dashboard-name")
	public String getLMSFGDashboardURL();
	
	@ExtendedAttributeDefinition(descriptionArguments = "Required", requiredInput = true)
	@Meta.AD(required = false, deflt = "/food-grain-license", description = "label-lms-food-grain-license-description", name="label-lms-food-grain-license-name")
	public String getLMSFGLicenseURL();
	
	@ExtendedAttributeDefinition(descriptionArguments = "Required", requiredInput = true)
	@Meta.AD(required = false, deflt = "/milling-license", description = "label-lms-milling-license-description", name="label-lms-milling-license-name")
	public String getLMSMillingLicenseURL();
	
	@ExtendedAttributeDefinition(descriptionArguments = "Required", requiredInput = true)
	@Meta.AD(required = false, deflt = "/lms-grievance", description = "label-lms-grievance-description", name="label-lms-grievance-name")
	public String getLMSGrievanceURL();
	
	@ExtendedAttributeDefinition(descriptionArguments = "Required", requiredInput = true)
	@Meta.AD(required = false, deflt = "/food-grain-license-profile", description = "label-lms-food-grain-license-profile-description", name="label-lms-food-grain-license-profile-name")
	public String getLMSFGMyProfileURL();
	
	@ExtendedAttributeDefinition(descriptionArguments = "Required", requiredInput = true)
	@Meta.AD(required = false, deflt = "/lms-change-password", description = "label-lms-change-password-description", name="label-lms-change-password-name")
	public String getLMSChangePasswordURL();
	
	@ExtendedAttributeDefinition(descriptionArguments = "Required", requiredInput = true)
	@Meta.AD(required = false, deflt = "/lms-logout", description = "label-lms-logout-description", name="label-lms-logout-name")
	public String getLMSLogOutURL();
	
	@ExtendedAttributeDefinition(descriptionArguments = "Required", requiredInput = true)
	@Meta.AD(required = false, deflt = "12345678900000001", description = "Enter LMS National Id", name="LMS National ID")
	public String getFGLicenseNationalId();

}
