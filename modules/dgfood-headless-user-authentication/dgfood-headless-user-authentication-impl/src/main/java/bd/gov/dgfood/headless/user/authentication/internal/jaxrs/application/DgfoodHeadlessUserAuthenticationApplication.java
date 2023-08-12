package bd.gov.dgfood.headless.user.authentication.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author AshishV
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false",
		"osgi.jaxrs.application.base=/dgfood-headless-user-authentication",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=DgfoodHeadlessUserAuthentication"
	},
	service = Application.class
)
@Generated("")
public class DgfoodHeadlessUserAuthenticationApplication extends Application {
}