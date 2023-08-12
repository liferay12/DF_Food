package bd.gov.dgfood.headless.common.delivery.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author krishna
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false",
		"osgi.jaxrs.application.base=/dgfood-headless-common-delivery",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=DgfoodHeadlessCommonDelivery"
	},
	service = Application.class
)
@Generated("")
public class DgfoodHeadlessCommonDeliveryApplication extends Application {
}