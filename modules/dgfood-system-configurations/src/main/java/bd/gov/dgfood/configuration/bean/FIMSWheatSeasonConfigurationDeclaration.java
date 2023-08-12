package bd.gov.dgfood.configuration.bean;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.configuration.FIMSWheatSeasonConfiguration;

@Component
public class FIMSWheatSeasonConfigurationDeclaration implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return FIMSWheatSeasonConfiguration.class;
	}

}
