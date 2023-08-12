package bd.gov.dgfood.headless.common.delivery.internal.graphql.query.v1_0;

import bd.gov.dgfood.headless.common.delivery.dto.v1_0.CaptchaAnswer;
import bd.gov.dgfood.headless.common.delivery.dto.v1_0.OTPGeneration;
import bd.gov.dgfood.headless.common.delivery.dto.v1_0.OTPVerification;
import bd.gov.dgfood.headless.common.delivery.dto.v1_0.UserNotification;
import bd.gov.dgfood.headless.common.delivery.resource.v1_0.CaptchaAnswerResource;
import bd.gov.dgfood.headless.common.delivery.resource.v1_0.OTPGenerationResource;
import bd.gov.dgfood.headless.common.delivery.resource.v1_0.OTPVerificationResource;
import bd.gov.dgfood.headless.common.delivery.resource.v1_0.UserNotificationResource;
import bd.gov.dgfood.headless.common.delivery.dto.v1_0.UserResponse;
import bd.gov.dgfood.headless.common.delivery.resource.v1_0.CaptchaAnswerResource;
import bd.gov.dgfood.headless.common.delivery.resource.v1_0.OTPGenerationResource;
import bd.gov.dgfood.headless.common.delivery.resource.v1_0.OTPVerificationResource;
import bd.gov.dgfood.headless.common.delivery.resource.v1_0.UserResponseResource;

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
 * @author krishna
 * @generated
 */
@Generated("")
public class Query {

	public static void setCaptchaAnswerResourceComponentServiceObjects(
		ComponentServiceObjects<CaptchaAnswerResource>
			captchaAnswerResourceComponentServiceObjects) {

		_captchaAnswerResourceComponentServiceObjects =
			captchaAnswerResourceComponentServiceObjects;
	}

	public static void setOTPGenerationResourceComponentServiceObjects(
		ComponentServiceObjects<OTPGenerationResource>
			otpGenerationResourceComponentServiceObjects) {

		_otpGenerationResourceComponentServiceObjects =
			otpGenerationResourceComponentServiceObjects;
	}

	public static void setOTPVerificationResourceComponentServiceObjects(
		ComponentServiceObjects<OTPVerificationResource>
			otpVerificationResourceComponentServiceObjects) {

		_otpVerificationResourceComponentServiceObjects =
			otpVerificationResourceComponentServiceObjects;
	}

	public static void setUserNotificationResourceComponentServiceObjects(
		ComponentServiceObjects<UserNotificationResource>
			userNotificationResourceComponentServiceObjects) {

		_userNotificationResourceComponentServiceObjects =
			userNotificationResourceComponentServiceObjects;
	public static void setUserResponseResourceComponentServiceObjects(
		ComponentServiceObjects<UserResponseResource>
			userResponseResourceComponentServiceObjects) {

		_userResponseResourceComponentServiceObjects =
			userResponseResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {captchaAnswer{answer}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "This end point returns captcha answer for a session."
	)
	public CaptchaAnswer captchaAnswer() throws Exception {
		return _applyComponentServiceObjects(
			_captchaAnswerResourceComponentServiceObjects,
			this::_populateResourceContext,
			captchaAnswerResource -> captchaAnswerResource.getCaptchaAnswer());
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {oTPNumber(mobileno: ___){statusCode, errorMsg, lockOutTime, isLockOut, exceededResendMaxAttempt}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "This Component returns otp number for a mobile number."
	)
	public OTPGeneration oTPNumber(@GraphQLName("mobileno") String mobileno)
		throws Exception {

		return _applyComponentServiceObjects(
			_otpGenerationResourceComponentServiceObjects,
			this::_populateResourceContext,
			otpGenerationResource -> otpGenerationResource.getOTPNumber(
				mobileno));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {resendOTPNumber(mobileno: ___){statusCode, errorMsg, lockOutTime, isLockOut, exceededResendMaxAttempt}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "This Component returns otp number for a mobile number."
	)
	public OTPGeneration resendOTPNumber(
			@GraphQLName("mobileno") String mobileno)
		throws Exception {

		return _applyComponentServiceObjects(
			_otpGenerationResourceComponentServiceObjects,
			this::_populateResourceContext,
			otpGenerationResource -> otpGenerationResource.resendOTPNumber(
				mobileno));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {verifyOTP(mobileno: ___, otpval: ___){statusCode, errorMsg, exceededVerifyMaxAttempt, isOtpExpired}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "This Component returns success or failure messages for opt verification."
	)
	public OTPVerification verifyOTP(
			@GraphQLName("mobileno") String mobileno,
			@GraphQLName("otpval") String otpval)
		throws Exception {

		return _applyComponentServiceObjects(
			_otpVerificationResourceComponentServiceObjects,
			this::_populateResourceContext,
			otpVerificationResource -> otpVerificationResource.verifyOTP(
				mobileno, otpval));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {userNotifications(page: ___, pageSize: ___, userNotificationUserId: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "This end point returns notifications of a user."
	)
	public UserNotificationPage userNotifications(
			@GraphQLName("userNotificationUserId") Long userNotificationUserId,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_userNotificationResourceComponentServiceObjects,
			this::_populateResourceContext,
			userNotificationResource -> new UserNotificationPage(
				userNotificationResource.getUserNotificationsPage(
					userNotificationUserId, Pagination.of(page, pageSize))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {userNotificationsUnReadCount(userNotificationUserId: ___){id, title, description, time, isRead, unReadCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "This end point returns Un Read notifications count of a user."
	)
	public UserNotification userNotificationsUnReadCount(
			@GraphQLName("userNotificationUserId") Long userNotificationUserId)
		throws Exception {

		return _applyComponentServiceObjects(
			_userNotificationResourceComponentServiceObjects,
			this::_populateResourceContext,
			userNotificationResource ->
				userNotificationResource.getUserNotificationsUnReadCount(
					userNotificationUserId));
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {login(lang: ___, nid: ___, password: ___){apiStatus, statusCode, message}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "User login url.")
	public UserResponse login(
			@GraphQLName("nid") String nid,
			@GraphQLName("password") String password,
			@GraphQLName("lang") String lang)
		throws Exception {

		return _applyComponentServiceObjects(
			_userResponseResourceComponentServiceObjects,
			this::_populateResourceContext,
			userResponseResource -> userResponseResource.getLogin(
				nid, password, lang));
	}

	@GraphQLName("CaptchaAnswerPage")
	public class CaptchaAnswerPage {

		public CaptchaAnswerPage(Page captchaAnswerPage) {
			actions = captchaAnswerPage.getActions();

			items = captchaAnswerPage.getItems();
			lastPage = captchaAnswerPage.getLastPage();
			page = captchaAnswerPage.getPage();
			pageSize = captchaAnswerPage.getPageSize();
			totalCount = captchaAnswerPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<CaptchaAnswer> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("OTPGenerationPage")
	public class OTPGenerationPage {

		public OTPGenerationPage(Page otpGenerationPage) {
			actions = otpGenerationPage.getActions();

			items = otpGenerationPage.getItems();
			lastPage = otpGenerationPage.getLastPage();
			page = otpGenerationPage.getPage();
			pageSize = otpGenerationPage.getPageSize();
			totalCount = otpGenerationPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<OTPGeneration> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("OTPVerificationPage")
	public class OTPVerificationPage {

		public OTPVerificationPage(Page otpVerificationPage) {
			actions = otpVerificationPage.getActions();

			items = otpVerificationPage.getItems();
			lastPage = otpVerificationPage.getLastPage();
			page = otpVerificationPage.getPage();
			pageSize = otpVerificationPage.getPageSize();
			totalCount = otpVerificationPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<OTPVerification> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("UserNotificationPage")
	public class UserNotificationPage {

		public UserNotificationPage(Page userNotificationPage) {
			actions = userNotificationPage.getActions();

			items = userNotificationPage.getItems();
			lastPage = userNotificationPage.getLastPage();
			page = userNotificationPage.getPage();
			pageSize = userNotificationPage.getPageSize();
			totalCount = userNotificationPage.getTotalCount();
	@GraphQLName("UserResponsePage")
	public class UserResponsePage {

		public UserResponsePage(Page userResponsePage) {
			actions = userResponsePage.getActions();

			items = userResponsePage.getItems();
			lastPage = userResponsePage.getLastPage();
			page = userResponsePage.getPage();
			pageSize = userResponsePage.getPageSize();
			totalCount = userResponsePage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<UserNotification> items;
		protected java.util.Collection<UserResponse> items;

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
			CaptchaAnswerResource captchaAnswerResource)
		throws Exception {

		captchaAnswerResource.setContextAcceptLanguage(_acceptLanguage);
		captchaAnswerResource.setContextCompany(_company);
		captchaAnswerResource.setContextHttpServletRequest(_httpServletRequest);
		captchaAnswerResource.setContextHttpServletResponse(
			_httpServletResponse);
		captchaAnswerResource.setContextUriInfo(_uriInfo);
		captchaAnswerResource.setContextUser(_user);
		captchaAnswerResource.setGroupLocalService(_groupLocalService);
		captchaAnswerResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(
			OTPGenerationResource otpGenerationResource)
		throws Exception {

		otpGenerationResource.setContextAcceptLanguage(_acceptLanguage);
		otpGenerationResource.setContextCompany(_company);
		otpGenerationResource.setContextHttpServletRequest(_httpServletRequest);
		otpGenerationResource.setContextHttpServletResponse(
			_httpServletResponse);
		otpGenerationResource.setContextUriInfo(_uriInfo);
		otpGenerationResource.setContextUser(_user);
		otpGenerationResource.setGroupLocalService(_groupLocalService);
		otpGenerationResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(
			OTPVerificationResource otpVerificationResource)
		throws Exception {

		otpVerificationResource.setContextAcceptLanguage(_acceptLanguage);
		otpVerificationResource.setContextCompany(_company);
		otpVerificationResource.setContextHttpServletRequest(
			_httpServletRequest);
		otpVerificationResource.setContextHttpServletResponse(
			_httpServletResponse);
		otpVerificationResource.setContextUriInfo(_uriInfo);
		otpVerificationResource.setContextUser(_user);
		otpVerificationResource.setGroupLocalService(_groupLocalService);
		otpVerificationResource.setRoleLocalService(_roleLocalService);
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

	private static ComponentServiceObjects<CaptchaAnswerResource>
		_captchaAnswerResourceComponentServiceObjects;
	private static ComponentServiceObjects<OTPGenerationResource>
		_otpGenerationResourceComponentServiceObjects;
	private static ComponentServiceObjects<OTPVerificationResource>
		_otpVerificationResourceComponentServiceObjects;
	private static ComponentServiceObjects<UserNotificationResource>
		_userNotificationResourceComponentServiceObjects;
	private static ComponentServiceObjects<UserResponseResource>
		_userResponseResourceComponentServiceObjects;

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