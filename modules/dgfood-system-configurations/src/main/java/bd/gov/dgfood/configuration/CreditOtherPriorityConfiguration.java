package bd.gov.dgfood.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "dg-food-configurations", scope = ExtendedObjectClassDefinition.Scope.COMPANY)
@Meta.OCD(id = "bd.gov.dgfood.configuration.CreditOtherPriorityConfiguration", name = "label-credit-and-other-priority-customer")
public interface CreditOtherPriorityConfiguration {
	
	@Meta.AD(required = false, deflt = "NA", description = "label-credit-customer-list-page-description", 
	name="label-credit-customer-list-page")
	public String getCreditCustomerListPageURL();
	
	@Meta.AD(required = false, deflt = "NA", description = "label-other-priority-customer-list-page-description", 
	name="label-other-priority-customer-list-page")
	public String getOtherPriorityCustomerListPageURL();

}
