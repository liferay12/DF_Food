package bd.gov.dgfood.configuration.bean;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

import  bd.gov.dgfood.configuration.SMSConfiguration;

public class SMSConfigurationDeclaration implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return SMSConfiguration.class;
	}	


}
