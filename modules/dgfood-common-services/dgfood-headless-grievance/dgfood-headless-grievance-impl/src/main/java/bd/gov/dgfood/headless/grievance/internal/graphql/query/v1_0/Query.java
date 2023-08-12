package bd.gov.dgfood.headless.grievance.internal.graphql.query.v1_0;

import bd.gov.dgfood.headless.grievance.dto.v1_0.Grievance;
import bd.gov.dgfood.headless.grievance.resource.v1_0.GrievanceResource;

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

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author liferay
 * @generated
 */
@Generated("")
public class Query {

	public static void setGrievanceResourceComponentServiceObjects(
		ComponentServiceObjects<GrievanceResource>
			grievanceResourceComponentServiceObjects) {

		_grievanceResourceComponentServiceObjects =
			grievanceResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {grievanceList(filter: ___, fromDate: ___, grievanceCategory: ___, keywords: ___, page: ___, pageSize: ___, sorts: ___, status: ___, toDate: ___, userType: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieves the grievance list. Results can be paginated, filtered, and searched."
	)
	public GrievancePage grievanceList(
			@GraphQLName("keywords") String keywords,
			@GraphQLName("grievanceCategory") String grievanceCategory,
			@GraphQLName("userType") String userType,
			@GraphQLName("fromDate") String fromDate,
			@GraphQLName("toDate") String toDate,
			@GraphQLName("status") Integer status,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_grievanceResourceComponentServiceObjects,
			this::_populateResourceContext,
			grievanceResource -> new GrievancePage(
				grievanceResource.getGrievanceList(
					keywords, grievanceCategory, userType, fromDate, toDate,
					status,
					_filterBiFunction.apply(grievanceResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(grievanceResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {grievanceDetails(grievanceId: ___){id, grievanceNumber, grievanceCategory, userType, emailAddress, userName, mobileNumber, userId, createDate, complaintDetails, responseDetails, responseDate, responseBy}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Retrieves the grievance details.")
	public Grievance grievanceDetails(
			@GraphQLName("grievanceId") Long grievanceId)
		throws Exception {

		return _applyComponentServiceObjects(
			_grievanceResourceComponentServiceObjects,
			this::_populateResourceContext,
			grievanceResource -> grievanceResource.getGrievanceDetails(
				grievanceId));
	}

	@GraphQLName("GrievancePage")
	public class GrievancePage {

		public GrievancePage(Page grievancePage) {
			actions = grievancePage.getActions();

			items = grievancePage.getItems();
			lastPage = grievancePage.getLastPage();
			page = grievancePage.getPage();
			pageSize = grievancePage.getPageSize();
			totalCount = grievancePage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Grievance> items;

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
	}

	private static ComponentServiceObjects<GrievanceResource>
		_grievanceResourceComponentServiceObjects;

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