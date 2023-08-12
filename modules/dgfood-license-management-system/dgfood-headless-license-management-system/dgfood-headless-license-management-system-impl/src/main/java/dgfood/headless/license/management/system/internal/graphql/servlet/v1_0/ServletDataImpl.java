package dgfood.headless.license.management.system.internal.graphql.servlet.v1_0;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import dgfood.headless.license.management.system.internal.graphql.mutation.v1_0.Mutation;
import dgfood.headless.license.management.system.internal.graphql.query.v1_0.Query;
import dgfood.headless.license.management.system.resource.v1_0.FGLicenseApplicationDetailsResource;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author Liferay
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setFGLicenseApplicationDetailsResourceComponentServiceObjects(
			_fgLicenseApplicationDetailsResourceComponentServiceObjects);

		Query.setFGLicenseApplicationDetailsResourceComponentServiceObjects(
			_fgLicenseApplicationDetailsResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/dgfood-headless-license-management-system-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<FGLicenseApplicationDetailsResource>
		_fgLicenseApplicationDetailsResourceComponentServiceObjects;

}