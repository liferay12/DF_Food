package bd.gov.dgfood.configuration.bean;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.configuration.NIDConfiguration;

@Component
public class NIDConfigurationDeclaration implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return NIDConfiguration.class;
	}	

}
