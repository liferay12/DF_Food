package bd.gov.dgfood.configuration.bean;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

import bd.gov.dgfood.configuration.CreditOtherPriorityConfiguration;

public class CreditOtherPriorityConfigurationDeclaration implements ConfigurationBeanDeclaration{

	@Override
	public Class<?> getConfigurationBeanClass() {

		return CreditOtherPriorityConfiguration.class;
	}

}
