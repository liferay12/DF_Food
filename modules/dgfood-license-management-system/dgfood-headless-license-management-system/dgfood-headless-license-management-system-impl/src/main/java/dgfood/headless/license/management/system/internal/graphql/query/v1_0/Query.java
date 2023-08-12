package dgfood.headless.license.management.system.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import dgfood.headless.license.management.system.dto.v1_0.FGLicenseApplicationDetails;
import dgfood.headless.license.management.system.dto.v1_0.FGLicenseApplicationStatus;
import dgfood.headless.license.management.system.dto.v1_0.FGLicenses;
import dgfood.headless.license.management.system.dto.v1_0.ResponseDetails;
import dgfood.headless.license.management.system.dto.v1_0.TransitionFGLicenseApplication;
import dgfood.headless.license.management.system.resource.v1_0.FGLicenseApplicationDetailsResource;

import java.util.Map;
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
public class Query {

	public static void
		setFGLicenseApplicationDetailsResourceComponentServiceObjects(
			ComponentServiceObjects<FGLicenseApplicationDetailsResource>
				fgLicenseApplicationDetailsResourceComponentServiceObjects) {

		_fgLicenseApplicationDetailsResourceComponentServiceObjects =
			fgLicenseApplicationDetailsResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {fglicenseAccounts(filter: ___, keywords: ___, page: ___, pageSize: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieves the fglicenses. Results can be paginated, filtered, and searched."
	)
	public FGLicenseApplicationDetailsPage fglicenseAccounts(
			@GraphQLName("keywords") String keywords,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_fgLicenseApplicationDetailsResourceComponentServiceObjects,
			this::_populateResourceContext,
			fgLicenseApplicationDetailsResource ->
				new FGLicenseApplicationDetailsPage(
					fgLicenseApplicationDetailsResource.
						getFglicenseAccountsPage(
							keywords,
							_filterBiFunction.apply(
								fgLicenseApplicationDetailsResource,
								filterString),
							Pagination.of(page, pageSize),
							_sortsBiFunction.apply(
								fgLicenseApplicationDetailsResource,
								sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {fglicenseApplicationsByNationalId(foodGrainLicenseNumber: ___, nationalId: ___){fgLicenseApplicationDetailses, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieves the approved fglicense list based on national id"
	)
	public FGLicenses fglicenseApplicationsByNationalId(
			@GraphQLName("nationalId") String nationalId,
			@GraphQLName("foodGrainLicenseNumber") String
				foodGrainLicenseNumber)
		throws Exception {

		return _applyComponentServiceObjects(
			_fgLicenseApplicationDetailsResourceComponentServiceObjects,
			this::_populateResourceContext,
			fgLicenseApplicationDetailsResource ->
				fgLicenseApplicationDetailsResource.
					getFglicenseApplicationsByNationalId(
						nationalId, foodGrainLicenseNumber));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {fglicenseApplication(applicationNumber: ___, applicationType: ___, foodGrainLicenseNumber: ___, tradeLicenseNumber: ___){apiStatus, msg, title, data}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Retrieves the fglicense details")
	public ResponseDetails fglicenseApplication(
			@GraphQLName("applicationNumber") String applicationNumber,
			@GraphQLName("foodGrainLicenseNumber") String
				foodGrainLicenseNumber,
			@GraphQLName("tradeLicenseNumber") String tradeLicenseNumber,
			@GraphQLName("applicationType") String applicationType)
		throws Exception {

		return _applyComponentServiceObjects(
			_fgLicenseApplicationDetailsResourceComponentServiceObjects,
			this::_populateResourceContext,
			fgLicenseApplicationDetailsResource ->
				fgLicenseApplicationDetailsResource.getFglicenseApplication(
					applicationNumber, foodGrainLicenseNumber,
					tradeLicenseNumber, applicationType));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {fglicenseApplicationStatus(applicationNumber: ___, dateOfBirth: ___, nationalId: ___){applicantNationalId, dateOfBirth, applicationNumber, applicationStatus, transactionNumber, challanDocument}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Retrieves the fglicense status")
	public FGLicenseApplicationStatus fglicenseApplicationStatus(
			@GraphQLName("nationalId") String nationalId,
			@GraphQLName("applicationNumber") String applicationNumber,
			@GraphQLName("dateOfBirth") String dateOfBirth)
		throws Exception {

		return _applyComponentServiceObjects(
			_fgLicenseApplicationDetailsResourceComponentServiceObjects,
			this::_populateResourceContext,
			fgLicenseApplicationDetailsResource ->
				fgLicenseApplicationDetailsResource.
					getFglicenseApplicationStatus(
						nationalId, applicationNumber, dateOfBirth));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {fglicenseRecentApplicationStatus(applicationType: ___, foodGrainLicenseNumber: ___){applicantNationalId, dateOfBirth, applicationNumber, applicationStatus, transactionNumber, challanDocument}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieves the status of most recent fglicense application"
	)
	public FGLicenseApplicationStatus fglicenseRecentApplicationStatus(
			@GraphQLName("foodGrainLicenseNumber") String
				foodGrainLicenseNumber,
			@GraphQLName("applicationType") String applicationType)
		throws Exception {

		return _applyComponentServiceObjects(
			_fgLicenseApplicationDetailsResourceComponentServiceObjects,
			this::_populateResourceContext,
			fgLicenseApplicationDetailsResource ->
				fgLicenseApplicationDetailsResource.
					getFglicenseRecentApplicationStatus(
						foodGrainLicenseNumber, applicationType));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {fglicenseApplicationTransition(applicationNumber: ___, licenseType: ___){id, transitions, licenseType}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Retrieves the fglicense transition details")
	public TransitionFGLicenseApplication fglicenseApplicationTransition(
			@GraphQLName("licenseType") String licenseType,
			@GraphQLName("applicationNumber") String applicationNumber)
		throws Exception {

		return _applyComponentServiceObjects(
			_fgLicenseApplicationDetailsResourceComponentServiceObjects,
			this::_populateResourceContext,
			fgLicenseApplicationDetailsResource ->
				fgLicenseApplicationDetailsResource.
					getFglicenseApplicationTransition(
						licenseType, applicationNumber));
	}

	@GraphQLName("FGLicenseApplicationDetailsPage")
	public class FGLicenseApplicationDetailsPage {

		public FGLicenseApplicationDetailsPage(
			Page fgLicenseApplicationDetailsPage) {

			actions = fgLicenseApplicationDetailsPage.getActions();

			items = fgLicenseApplicationDetailsPage.getItems();
			lastPage = fgLicenseApplicationDetailsPage.getLastPage();
			page = fgLicenseApplicationDetailsPage.getPage();
			pageSize = fgLicenseApplicationDetailsPage.getPageSize();
			totalCount = fgLicenseApplicationDetailsPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<FGLicenseApplicationDetails> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

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
	}

	private static ComponentServiceObjects<FGLicenseApplicationDetailsResource>
		_fgLicenseApplicationDetailsResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}