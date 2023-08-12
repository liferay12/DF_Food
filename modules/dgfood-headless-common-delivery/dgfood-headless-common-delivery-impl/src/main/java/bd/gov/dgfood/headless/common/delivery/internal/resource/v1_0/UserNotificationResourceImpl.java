package bd.gov.dgfood.headless.common.delivery.internal.resource.v1_0;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import bd.gov.dgfood.headless.common.delivery.dto.v1_0.UserNotification;
import bd.gov.dgfood.headless.common.delivery.resource.v1_0.UserNotificationResource;

/**
 * @author krishna
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0/user-notification.properties", scope = ServiceScope.PROTOTYPE, service = UserNotificationResource.class)
public class UserNotificationResourceImpl extends BaseUserNotificationResourceImpl {
	@Override
	public Page<UserNotification> getUserNotificationsPage(@NotNull Long userNotificationUserId, Pagination pagination)
			throws Exception {

		long totalCount = _userNotificationEventLocalService.getUserNotificationEventsCount(userNotificationUserId);

		List<UserNotificationEvent> userNotificationEvents = _userNotificationEventLocalService
				.getUserNotificationEvents(userNotificationUserId, pagination.getStartPosition(),
						pagination.getEndPosition());

		return Page.of(userNotificationEvents.stream().map(this::_toUserNotification).collect(Collectors.toList()),
				pagination, totalCount);
	}

	@Override
	public UserNotification getUserNotificationsUnReadCount(@NotNull Long userNotificationUserId) throws Exception {
		UserNotification userNotification = new UserNotification();
		userNotification.setUnReadCount(_userNotificationEventLocalService
				.getArchivedUserNotificationEventsCount(userNotificationUserId, false));
		return userNotification;
	}

	@Override
	public void postUserNotificationsMarkAsRead(@NotNull Long userNotificationUserId,
			UserNotification[] userNotifications) throws Exception {
		for (UserNotification userNotification : userNotifications) {
			_updateArchived(userNotificationUserId, userNotification.getId(), true);
		}
	}

	private void _updateArchived(@NotNull Long userId, Long userNotificationEventId, boolean archived)
			throws PrincipalException {

		UserNotificationEvent userNotificationEvent = _userNotificationEventLocalService
				.fetchUserNotificationEvent(userNotificationEventId);

		if (userNotificationEvent == null) {
			return;
		}

		if (userNotificationEvent.getUserId() != userId) {
			throw new PrincipalException();
		}

		userNotificationEvent.setArchived(archived);

		_userNotificationEventLocalService.updateUserNotificationEvent(userNotificationEvent);

	}

	private UserNotification _toUserNotification(UserNotificationEvent userNotificationEvent) {

		try {

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());
			long creadted = System.currentTimeMillis() - userNotificationEvent.getTimestamp();

			UserNotification userNotification = new UserNotification();
			userNotification.setId(userNotificationEvent.getUserNotificationEventId());
			userNotification.setTitle(jsonObject.getString("notificationMessage"));
			userNotification.setDescription(jsonObject.getString("description"));
			userNotification.setIsRead(userNotificationEvent.getArchived());
			userNotification.setTime(() -> {
				return creadted > 60000
						? LanguageUtil.format(contextHttpServletRequest, "x-ago",
								LanguageUtil.getTimeDescription(contextHttpServletRequest,
										System.currentTimeMillis() - userNotificationEvent.getTimestamp(), true),
								false)
						: LanguageUtil.get(contextHttpServletRequest, "label-just-now");
			});
			return userNotification;
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return new UserNotification();

	}

	@Reference
	private UserNotificationEventLocalService _userNotificationEventLocalService;
}