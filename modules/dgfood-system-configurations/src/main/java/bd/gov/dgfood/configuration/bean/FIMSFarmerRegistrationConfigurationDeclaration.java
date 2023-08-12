package bd.gov.dgfood.configuration.bean;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.configuration.FIMSFarmerRegistrationConfiguration;

@Component
public class FIMSFarmerRegistrationConfigurationDeclaration implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return FIMSFarmerRegistrationConfiguration.class;
	}

}
