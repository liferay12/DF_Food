package dgfood.headless.license.management.system.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author Liferay
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false",
		"osgi.jaxrs.application.base=/dgfood-headless-license-management-system",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=DgfoodHeadlessLicenseManagementSystem"
	},
	service = Application.class
)
@Generated("")
public class DgfoodHeadlessLicenseManagementSystemApplication
	extends Application {
}