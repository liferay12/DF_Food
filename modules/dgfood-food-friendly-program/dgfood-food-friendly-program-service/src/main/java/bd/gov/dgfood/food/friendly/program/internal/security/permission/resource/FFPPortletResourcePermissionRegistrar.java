package bd.gov.dgfood.food.friendly.program.internal.security.permission.resource;

import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.StagedPortletPermissionLogic;
import com.liferay.portal.kernel.util.HashMapDictionary;

import java.util.Dictionary;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.food.friendly.program.constants.FoodFriendlyProgramConstants;
import bd.gov.dgfood.food.friendly.program.constants.FoodFriendlyProgramPortletKeys;

@Component(immediate = true)
public class FFPPortletResourcePermissionRegistrar {

	@Activate
	public void activate(BundleContext bundleContext) {
		Dictionary<String, Object> properties = new HashMapDictionary<>();

		properties.put("resource.name", FoodFriendlyProgramConstants.RESOURCE_NAME);

		_serviceRegistration = bundleContext.registerService(PortletResourcePermission.class,
				PortletResourcePermissionFactory.create(FoodFriendlyProgramConstants.RESOURCE_NAME,
						new StagedPortletPermissionLogic(_stagingPermission,
								FoodFriendlyProgramPortletKeys.FOOD_FRIENDLY_PROGRAM_ADMIN)),
				properties);
	}

	@Deactivate
	public void deactivate() {
		_serviceRegistration.unregister();
	}

	private ServiceRegistration<PortletResourcePermission> _serviceRegistration;

	@Reference
	private StagingPermission _stagingPermission;

}
