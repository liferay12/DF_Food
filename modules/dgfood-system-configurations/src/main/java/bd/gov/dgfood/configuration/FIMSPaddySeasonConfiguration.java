package bd.gov.dgfood.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "dg-food-configurations", scope = ExtendedObjectClassDefinition.Scope.COMPANY)
@Meta.OCD(id = "bd.gov.dgfood.configuration.FIMSPaddySeasonConfiguration", name = "fims-season-configuration-paddy")
public interface FIMSPaddySeasonConfiguration {
	
	@Meta.AD(required = false, deflt = "", description = "season-start-date-description", name="season-start-date")
	public String getSeasonStartDate();
	
	@Meta.AD(required = false, deflt = "", description = "season-end-date-description", name="season-end-date")
	public String getSeasonEndDate();

	@Meta.AD(required = false, description = "is-registration-open-description", name="is-registration-open")
	public boolean isEOIRegistrationOpen();
	
	@Meta.AD(required = false, deflt = "0", description = "total-food-grain-required-in-mt-description", name="total-food-grain-required-in-mt")
	public int getTotalRequiredFoodgrain();
			
}
