package bd.gov.dgfood.headless.grievance.internal.graphql.mutation.v1_0;

import bd.gov.dgfood.headless.grievance.dto.v1_0.Grievance;
import bd.gov.dgfood.headless.grievance.resource.v1_0.GrievanceResource;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.batch.engine.resource.VulcanBatchEngineImportTaskResource;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author liferay
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setGrievanceResourceComponentServiceObjects(
		ComponentServiceObjects<GrievanceResource>
			grievanceResourceComponentServiceObjects) {

		_grievanceResourceComponentServiceObjects =
			grievanceResourceComponentServiceObjects;
	}

	@GraphQLField(description = "Creates a new grievance")
	public Grievance createGrievance(
			@GraphQLName("grievance") Grievance grievance)
		throws Exception {

		return _applyComponentServiceObjects(
			_grievanceResourceComponentServiceObjects,
			this::_populateResourceContext,
			grievanceResource -> grievanceResource.postGrievance(grievance));
	}

	@GraphQLField
	public Response createGrievanceBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_grievanceResourceComponentServiceObjects,
			this::_populateResourceContext,
			grievanceResource -> grievanceResource.postGrievanceBatch(
				callbackURL, object));
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(GrievanceResource grievanceResource)
		throws Exception {

		grievanceResource.setContextAcceptLanguage(_acceptLanguage);
		grievanceResource.setContextCompany(_company);
		grievanceResource.setContextHttpServletRequest(_httpServletRequest);
		grievanceResource.setContextHttpServletResponse(_httpServletResponse);
		grievanceResource.setContextUriInfo(_uriInfo);
		grievanceResource.setContextUser(_user);
		grievanceResource.setGroupLocalService(_groupLocalService);
		grievanceResource.setRoleLocalService(_roleLocalService);

		grievanceResource.setVulcanBatchEngineImportTaskResource(
			_vulcanBatchEngineImportTaskResource);
	}

	private static ComponentServiceObjects<GrievanceResource>
		_grievanceResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;
	private VulcanBatchEngineImportTaskResource
		_vulcanBatchEngineImportTaskResource;

}