package bd.gov.dgfood.configuration.bean;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.configuration.LocationUrlConfiguration;

@Component(service = ConfigurationBeanDeclaration.class)
public class LocationUrlConfigurationBeanDeclaration implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return LocationUrlConfiguration.class;
	}

}
