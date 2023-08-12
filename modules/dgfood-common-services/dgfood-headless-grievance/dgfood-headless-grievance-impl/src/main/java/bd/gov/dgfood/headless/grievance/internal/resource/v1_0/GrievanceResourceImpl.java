package bd.gov.dgfood.headless.grievance.internal.resource.v1_0;

import bd.gov.dgfood.headless.grievance.resource.v1_0.GrievanceResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author liferay
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/grievance.properties",
	scope = ServiceScope.PROTOTYPE, service = GrievanceResource.class
)
public class GrievanceResourceImpl extends BaseGrievanceResourceImpl {
}