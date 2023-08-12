package bd.gov.dgfood.common.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProviderUtil;

import bd.gov.dgfood.configuration.BypassValidationConfiguration;

/**
 * The purpose of this class is to get the system Configurstion object and
 * related data
 *
 * Accessibility : Throughout application
 *
 *
 * @author Ashish V
 * 
 */

public class ConfigurationUtil {

	/**
	 * To bypass captcha validation accross the modules for performance testing
	 * 
	 * @param assetCategoriesList
	 * @return Map<Long, JSONObject>
	 */

	public static BypassValidationConfiguration getBypassValidationConfiguration() {
		try {
			return ConfigurationProviderUtil.getSystemConfiguration(BypassValidationConfiguration.class);
		} catch (ConfigurationException e) {
			_log.error("Unable to get the Bypass Validation System Configuration object");
			e.printStackTrace();
		}
		return null;
	}

	private static Log _log = LogFactoryUtil.getLog(ConfigurationUtil.class);
}
