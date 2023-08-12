package bd.gov.dgfood.configuration.bean;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

import bd.gov.dgfood.configuration.GeneralConfiguration;

public class GeneralConfigurationDeclaration implements ConfigurationBeanDeclaration{

	@Override
	public Class<?> getConfigurationBeanClass() {

		return GeneralConfiguration.class;
	}

}
