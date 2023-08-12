package bd.gov.dgfood.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "dg-food-configurations", scope = ExtendedObjectClassDefinition.Scope.COMPANY)
@Meta.OCD(id = "bd.gov.dgfood.configuration.LotteryConfiguration", name = "fims-lottery-configuration")
public interface LotteryConfiguration {
	@Meta.AD(required = false, deflt = "NA", description = "scheduled-lottery-date-description", name="scheduled-lottery-date")
	public String getScheduledLotteryDate();
	
	@Meta.AD(required = false, deflt = "10", description = "number-of-farmers-description", name="number-of-farmers")
	public String getNumberOfFarmers();
	
	@Meta.AD(required = false, optionLabels = {"BORO", "AMAN"},
	        optionValues = {"boro", "aman"} , description = "season-description", name="season")
	public String getSeason();

	@Meta.AD(required = false, optionLabels = {"Rice", "Wheat"},
	        optionValues = {"Rice", "Wheat"}, description = "food-grain-type-description", name="food-grain-type")
	public String getFoodgrainType();
	
}