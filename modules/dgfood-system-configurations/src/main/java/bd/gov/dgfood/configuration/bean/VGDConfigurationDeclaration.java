package bd.gov.dgfood.configuration.bean;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

import bd.gov.dgfood.configuration.VGDConfiguration;

public class VGDConfigurationDeclaration implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return VGDConfiguration.class;
	}	

}