package bd.gov.dgfood.license.management.system.internal.security.permission.resource;

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

import bd.gov.dgfood.license.management.system.constants.FoodGrainLicenseConstants;
import bd.gov.dgfood.license.management.system.constants.FoodGrainLicensePortletKeys;

@Component(immediate = true)
public class FGLicensePortletResourcePermissionRegistrar {

	@Activate
	public void activate(BundleContext bundleContext) {

		Dictionary<String, Object> properties = new HashMapDictionary<>();
		properties.put("resource.name", FoodGrainLicenseConstants.RESOURCE_NAME);

		_serviceRegistration = bundleContext.registerService(PortletResourcePermission.class,
				PortletResourcePermissionFactory.create(FoodGrainLicenseConstants.RESOURCE_NAME,
						new StagedPortletPermissionLogic(_stagingPermission,
								FoodGrainLicensePortletKeys.FOOD_GRAIN_LICENSE)),
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
