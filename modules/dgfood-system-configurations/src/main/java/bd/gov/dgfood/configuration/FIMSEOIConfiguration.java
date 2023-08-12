package bd.gov.dgfood.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "dg-food-configurations", scope = ExtendedObjectClassDefinition.Scope.COMPANY)
@Meta.OCD(id = "bd.gov.dgfood.configuration.FIMSEOIConfiguration", name = "FIMS EOI Configuration")
public interface FIMSEOIConfiguration {
	
	@Meta.AD(required = false, deflt = "NA", description = "Enter the URL of EOI Admin Dashboard", name="EOI Admin Dashboard URL")
	public String getEOIAdminDashboardURL();
		
	@Meta.AD(required = false, deflt = "NA", description = "Enter the URL of EOI Registration Form", name="EOI Registration URL")
	public String getEOIRegistrationURL();
	
	@Meta.AD(required = false, deflt = "/eoi-application", description = "Enter the page friendly URL of EOI Registration Form (Not the complete URL)", 
		name="EOI Application Page Friendly URL")
	public String getEOIRegistrationPageFriendlyURL();
	
	@Meta.AD(required = false,deflt = "NA", description = "Enter the column and respective label values for search data export. e.g. {\"column1\":\"column label\",\"column2\":\"column label\"})", 
		name="EOI Application Export Search data fields List")
	public String getEOIRegistrationExportDataFields();
	
	@Meta.AD(required = false,deflt = "NA", description = "Enter the column and respective label values for search data export.", 
		name="EOI Application Asset Category fields List")
	public String getEOIRegistrationAssetCategoryFields();
	
	@Meta.AD(required = false, deflt = "4", description = "Specify the number of past season production details to be required", 
		name="Past Season Production Details Input Count")
	public int getPastSeasonProductionDetailsInputCount();
	
	
	
	
}
