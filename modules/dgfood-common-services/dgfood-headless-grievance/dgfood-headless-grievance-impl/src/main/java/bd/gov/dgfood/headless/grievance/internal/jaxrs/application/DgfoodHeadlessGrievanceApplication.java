package bd.gov.dgfood.headless.grievance.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author liferay
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false",
		"osgi.jaxrs.application.base=/dgfood-headless-grievance",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=DgfoodHeadlessGrievance"
	},
	service = Application.class
)
@Generated("")
public class DgfoodHeadlessGrievanceApplication extends Application {
}