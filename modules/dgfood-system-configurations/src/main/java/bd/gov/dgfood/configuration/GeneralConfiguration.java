package bd.gov.dgfood.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "dg-food-configurations", scope = ExtendedObjectClassDefinition.Scope.COMPANY)
@Meta.OCD(id = "bd.gov.dgfood.configuration.GeneralConfiguration", name = "general-configuration")
public interface GeneralConfiguration {

	@Meta.AD(required = false, deflt = "0", description = "label-vocabulary-id-description", 
	name="label-vocabulary-id")
	public long getVocabularyId();
	
	@Meta.AD(required = false, deflt = "/notifications", description = "label-notifications-page-url-description", 
			name="label-notifications-page-url")
			public String getNotificationPageUrl();
}
