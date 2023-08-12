package bd.gov.dgfood.headless.grievance.internal.graphql.servlet.v1_0;

import bd.gov.dgfood.headless.grievance.internal.graphql.mutation.v1_0.Mutation;
import bd.gov.dgfood.headless.grievance.internal.graphql.query.v1_0.Query;
import bd.gov.dgfood.headless.grievance.resource.v1_0.GrievanceResource;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author liferay
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setGrievanceResourceComponentServiceObjects(
			_grievanceResourceComponentServiceObjects);

		Query.setGrievanceResourceComponentServiceObjects(
			_grievanceResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/dgfood-headless-grievance-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<GrievanceResource>
		_grievanceResourceComponentServiceObjects;

}