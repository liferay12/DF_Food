package bd.gov.dgfood.credit.other.priority.customer.web.portlet.security.permission.resource;

import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.credit.other.priority.customer.constants.CustomerConstants;

@Component(immediate = true)
public class CustomerPermission {

	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId) {

		return _portletResourcePermission.contains(permissionChecker, groupId, actionId);

	}

	@Reference(target = "(resource.name=" + CustomerConstants.RESOURCE_NAME + ")", unbind = "-")
	protected void setPortletResourcePermission(PortletResourcePermission portletResourcePermission) {

		_portletResourcePermission = portletResourcePermission;
	}

	private static PortletResourcePermission _portletResourcePermission;

}
