package dgfood.headless.license.management.system.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.batch.engine.resource.VulcanBatchEngineImportTaskResource;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import dgfood.headless.license.management.system.dto.v1_0.FGLicenseApplicationDetails;
import dgfood.headless.license.management.system.dto.v1_0.NewFGLicenseApplication;
import dgfood.headless.license.management.system.dto.v1_0.RenewalDuplicateFGLicenseApplication;
import dgfood.headless.license.management.system.dto.v1_0.ResponseDetails;
import dgfood.headless.license.management.system.dto.v1_0.ReviewFGLicenseApplication;
import dgfood.headless.license.management.system.dto.v1_0.UpdateFGLicenseApplication;
import dgfood.headless.license.management.system.dto.v1_0.UploadChallanFGLicenseApplication;
import dgfood.headless.license.management.system.resource.v1_0.FGLicenseApplicationDetailsResource;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Liferay
 * @generated
 */
@Generated("")
public class Mutation {

	public static void
		setFGLicenseApplicationDetailsResourceComponentServiceObjects(
			ComponentServiceObjects<FGLicenseApplicationDetailsResource>
				fgLicenseApplicationDetailsResourceComponentServiceObjects) {

		_fgLicenseApplicationDetailsResourceComponentServiceObjects =
			fgLicenseApplicationDetailsResourceComponentServiceObjects;
	}

	@GraphQLField(description = "Creates a new fg license")
	public ResponseDetails createFglicenseApplication(
			@GraphQLName("newFGLicenseApplication") NewFGLicenseApplication
				newFGLicenseApplication)
		throws Exception {

		return _applyComponentServiceObjects(
			_fgLicenseApplicationDetailsResourceComponentServiceObjects,
			this::_populateResourceContext,
			fgLicenseApplicationDetailsResource ->
				fgLicenseApplicationDetailsResource.postFglicenseApplication(
					newFGLicenseApplication));
	}

	@GraphQLField(
		description = "Update the fglicense details with information sent in the request body as a new version. Any missing fields are deleted unless they are required."
	)
	public FGLicenseApplicationDetails updateFglicenseApplicationUpdate(
			@GraphQLName("foodGrainLicenseNumber") String
				foodGrainLicenseNumber,
			@GraphQLName("updateFGLicenseApplication")
				UpdateFGLicenseApplication updateFGLicenseApplication)
		throws Exception {

		return _applyComponentServiceObjects(
			_fgLicenseApplicationDetailsResourceComponentServiceObjects,
			this::_populateResourceContext,
			fgLicenseApplicationDetailsResource ->
				fgLicenseApplicationDetailsResource.
					putFglicenseApplicationUpdate(
						foodGrainLicenseNumber, updateFGLicenseApplication));
	}

	@GraphQLField(
		description = "Update the fglicense details with information sent in the request body as a new version. Any missing fields are deleted unless they are required."
	)
	public FGLicenseApplicationDetails updateFglicenseApplicationUploadChallan(
			@GraphQLName("applicationNumber") String applicationNumber,
			@GraphQLName("uploadChallanFGLicenseApplication")
				UploadChallanFGLicenseApplication
					uploadChallanFGLicenseApplication)
		throws Exception {

		return _applyComponentServiceObjects(
			_fgLicenseApplicationDetailsResourceComponentServiceObjects,
			this::_populateResourceContext,
			fgLicenseApplicationDetailsResource ->
				fgLicenseApplicationDetailsResource.
					putFglicenseApplicationUploadChallan(
						applicationNumber, uploadChallanFGLicenseApplication));
	}

	@GraphQLField(
		description = "Review fglicense request information sent in the request body."
	)
	public FGLicenseApplicationDetails updateFglicenseApplicationReview(
			@GraphQLName("applicationNumber") String applicationNumber,
			@GraphQLName("reviewFGLicenseApplication")
				ReviewFGLicenseApplication reviewFGLicenseApplication)
		throws Exception {

		return _applyComponentServiceObjects(
			_fgLicenseApplicationDetailsResourceComponentServiceObjects,
			this::_populateResourceContext,
			fgLicenseApplicationDetailsResource ->
				fgLicenseApplicationDetailsResource.
					putFglicenseApplicationReview(
						applicationNumber, reviewFGLicenseApplication));
	}

	@GraphQLField(
		description = "Submit renewal fglicense request with trade license & food grain license details. information sent in the request body as a new version. Any missing fields are deleted unless they are required."
	)
	public FGLicenseApplicationDetails
			updateFglicenseApplicationRenewalDuplicate(
				@GraphQLName("foodGrainLicenseNumber") String
					foodGrainLicenseNumber,
				@GraphQLName("renewalDuplicateFGLicenseApplication")
					RenewalDuplicateFGLicenseApplication
						renewalDuplicateFGLicenseApplication)
		throws Exception {

		return _applyComponentServiceObjects(
			_fgLicenseApplicationDetailsResourceComponentServiceObjects,
			this::_populateResourceContext,
			fgLicenseApplicationDetailsResource ->
				fgLicenseApplicationDetailsResource.
					putFglicenseApplicationRenewalDuplicate(
						foodGrainLicenseNumber,
						renewalDuplicateFGLicenseApplication));
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

	private void _populateResourceContext(
			FGLicenseApplicationDetailsResource
				fgLicenseApplicationDetailsResource)
		throws Exception {

		fgLicenseApplicationDetailsResource.setContextAcceptLanguage(
			_acceptLanguage);
		fgLicenseApplicationDetailsResource.setContextCompany(_company);
		fgLicenseApplicationDetailsResource.setContextHttpServletRequest(
			_httpServletRequest);
		fgLicenseApplicationDetailsResource.setContextHttpServletResponse(
			_httpServletResponse);
		fgLicenseApplicationDetailsResource.setContextUriInfo(_uriInfo);
		fgLicenseApplicationDetailsResource.setContextUser(_user);
		fgLicenseApplicationDetailsResource.setGroupLocalService(
			_groupLocalService);
		fgLicenseApplicationDetailsResource.setRoleLocalService(
			_roleLocalService);

		fgLicenseApplicationDetailsResource.
			setVulcanBatchEngineImportTaskResource(
				_vulcanBatchEngineImportTaskResource);
	}

	private static ComponentServiceObjects<FGLicenseApplicationDetailsResource>
		_fgLicenseApplicationDetailsResourceComponentServiceObjects;

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