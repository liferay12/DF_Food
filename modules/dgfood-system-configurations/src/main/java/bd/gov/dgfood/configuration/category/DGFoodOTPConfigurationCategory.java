package bd.gov.dgfood.configuration.category;

import org.osgi.service.component.annotations.Component;

import com.liferay.configuration.admin.category.ConfigurationCategory;

/**
 * The purpose of this class is to create a category inside System Settings.
 * Here we are defining category icon, category key.
 * 
 * Accessibility: This class gets executed when the System Settings page is
 * loaded.
 * 
 * @author Ashish Singh
 */

@Component
public class DGFoodOTPConfigurationCategory implements ConfigurationCategory {

	@Override
	public String getCategoryIcon() {
		return "chip";
	}

	@Override
	public String getCategoryKey() {
		return _KEY;
	}

	@Override
	public String getCategorySection() {
		return _CATEGORY_SET_KEY;
	}

	private static final String _CATEGORY_SET_KEY = "dg-food-configurations";

	private static final String _KEY = "dg-otp-configurations";

}
