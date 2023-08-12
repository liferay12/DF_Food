package bd.gov.dgfood.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "dg-food-configurations", scope = ExtendedObjectClassDefinition.Scope.COMPANY)
@Meta.OCD(id = "bd.gov.dgfood.configuration.FarmerCategoryConfiguration", name = "farmer-eoi-category-configuration")
public interface FarmerCategoryConfiguration {
	@Meta.AD(required = false, deflt = "10", description = "small-farmer-maximum-quota-decription", name="small-farmer-maximum-quota")
	public String getSmallFarmerMaximumQuota();
	
	@Meta.AD(required = false, deflt = "20", description = "medium-farmer-maximum-quota-decription", name="medium-farmer-maximum-quota")
	public String getMediumFarmerMaximumQuota();
	
	@Meta.AD(required = false, deflt = "30", description = "large-farmer-maximum-quota-decription", name="large-farmer-maximum-quota")
	public String getLargeFarmerMaximumQuota();
	
	@Meta.AD(required = false, deflt = "50", description = "small-farmer-percentage-in-eoi-decription", name="small-farmer-percentage-in-eoi")
	public String getSmallFarmerPercentageInEOI();
	
	@Meta.AD(required = false, deflt = "30", description = "medium-farmer-percentage-in-eoi-decription", name="medium-farmer-percentage-in-eoi")
	public String getMediumFarmerPercentageInEOI();
	
	@Meta.AD(required = false, deflt = "20", description = "large-farmer-percentage-in-eoi-decription", name="large-farmer-percentage-in-eoi")
	public String getLargeFarmerPercentageInEOI();

}