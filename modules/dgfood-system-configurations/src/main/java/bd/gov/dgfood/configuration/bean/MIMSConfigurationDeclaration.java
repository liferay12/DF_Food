package bd.gov.dgfood.configuration.bean;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.configuration.MIMSConfiguration;

@Component
public class MIMSConfigurationDeclaration implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return MIMSConfiguration.class;
	}

}
