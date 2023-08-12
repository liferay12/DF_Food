package bd.gov.dgfood.common.notification.handler;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationHandler;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.StringUtil;

import org.osgi.service.component.annotations.Component;

@Component(service = UserNotificationHandler.class)
public class NotificationToUserHandler extends BaseUserNotificationHandler {

	public NotificationToUserHandler() {
		super();
	}

	public NotificationToUserHandler(String portletId) {
		setPortletId(portletId);
	}

	@Override
	protected String getBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext)
			throws Exception {

		_log.info("Inside Custom notification");

		JSONObject payloadJson = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());
		String title = payloadJson.getString("title");
		String notificationText = payloadJson.getString("notificationText");
		String body = StringUtil.replace(getBodyTemplate(), new String[] { "[$TITLE$]", "[$BODY_TEXT$]" },
				new String[] { title, notificationText });

		_log.info(notificationText);

		return body;
	}

	@Override
	protected String getBodyTemplate() throws Exception {

		StringBuilder sb = new StringBuilder();
		sb.append("<div class=\"title\">[$TITLE$]</div><div ");
		sb.append("class=\"body\">[$BODY_TEXT$]</div>");
		return sb.toString();
	}

	@Override
	protected String getLink(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext)
			throws Exception {

		JSONObject payloadJson = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());
		return payloadJson.getString("url");
	}

	private Log _log = LogFactoryUtil.getLog(this.getClass());
}