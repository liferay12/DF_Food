package bd.gov.dgfood.headless.common.delivery.internal.graphql.mutation.v1_0;

import bd.gov.dgfood.headless.common.delivery.dto.v1_0.UserNotification;
import bd.gov.dgfood.headless.common.delivery.resource.v1_0.UserNotificationResource;
import bd.gov.dgfood.headless.common.delivery.dto.v1_0.ChangePassword;
import bd.gov.dgfood.headless.common.delivery.dto.v1_0.ForgetPassword;
import bd.gov.dgfood.headless.common.delivery.dto.v1_0.UserResponse;
import bd.gov.dgfood.headless.common.delivery.resource.v1_0.UserResponseResource;

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

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author krishna
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setUserNotificationResourceComponentServiceObjects(
		ComponentServiceObjects<UserNotificationResource>
			userNotificationResourceComponentServiceObjects) {

		_userNotificationResourceComponentServiceObjects =
			userNotificationResourceComponentServiceObjects;
	}

	@GraphQLField(description = "Marks User Un Read Notification as Read.")
	public boolean createUserNotificationsMarkAsRead(
			@GraphQLName("userNotificationUserId") Long userNotificationUserId,
			@GraphQLName("userNotifications") UserNotification[]
				userNotifications)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_userNotificationResourceComponentServiceObjects,
			this::_populateResourceContext,
			userNotificationResource ->
				userNotificationResource.postUserNotificationsMarkAsRead(
					userNotificationUserId, userNotifications));

		return true;
	public static void setUserResponseResourceComponentServiceObjects(
		ComponentServiceObjects<UserResponseResource>
			userResponseResourceComponentServiceObjects) {

		_userResponseResourceComponentServiceObjects =
			userResponseResourceComponentServiceObjects;
	}

	@GraphQLField(description = "Change a new password")
	public UserResponse createChangePassword(
			@GraphQLName("changePassword") ChangePassword changePassword)
		throws Exception {

		return _applyComponentServiceObjects(
			_userResponseResourceComponentServiceObjects,
			this::_populateResourceContext,
			userResponseResource -> userResponseResource.postChangePassword(
				changePassword));
	}

	@GraphQLField(description = "Change a new password")
	public UserResponse createForgetPassword(
			@GraphQLName("forgetPassword") ForgetPassword forgetPassword)
		throws Exception {

		return _applyComponentServiceObjects(
			_userResponseResourceComponentServiceObjects,
			this::_populateResourceContext,
			userResponseResource -> userResponseResource.postForgetPassword(
				forgetPassword));
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
			UserNotificationResource userNotificationResource)
		throws Exception {

		userNotificationResource.setContextAcceptLanguage(_acceptLanguage);
		userNotificationResource.setContextCompany(_company);
		userNotificationResource.setContextHttpServletRequest(
			_httpServletRequest);
		userNotificationResource.setContextHttpServletResponse(
			_httpServletResponse);
		userNotificationResource.setContextUriInfo(_uriInfo);
		userNotificationResource.setContextUser(_user);
		userNotificationResource.setGroupLocalService(_groupLocalService);
		userNotificationResource.setRoleLocalService(_roleLocalService);

		userNotificationResource.setVulcanBatchEngineImportTaskResource(
			_vulcanBatchEngineImportTaskResource);
	}

	private static ComponentServiceObjects<UserNotificationResource>
		_userNotificationResourceComponentServiceObjects;
			UserResponseResource userResponseResource)
		throws Exception {

		userResponseResource.setContextAcceptLanguage(_acceptLanguage);
		userResponseResource.setContextCompany(_company);
		userResponseResource.setContextHttpServletRequest(_httpServletRequest);
		userResponseResource.setContextHttpServletResponse(
			_httpServletResponse);
		userResponseResource.setContextUriInfo(_uriInfo);
		userResponseResource.setContextUser(_user);
		userResponseResource.setGroupLocalService(_groupLocalService);
		userResponseResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<UserResponseResource>
		_userResponseResourceComponentServiceObjects;

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