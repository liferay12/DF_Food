package bd.gov.dgfood.portal.notification.web.handler;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationHandler;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.portal.notification.web.constants.PortalNotificationPortletKeys;

/**
 * This call extends Liferays default Notification handler which will allow us
 * to send Portal notification to users
 * 
 * @author krishna
 *
 */
@Component(immediate = true, property = "javax.portlet.name="
		+ PortalNotificationPortletKeys.PORTAL_NOTIFICATION, service = UserNotificationHandler.class)
public class PortalNotificationHandler extends BaseUserNotificationHandler {

	public PortalNotificationHandler() {
		setPortletId(PortalNotificationPortletKeys.PORTAL_NOTIFICATION);
	}

	@Override
	protected String getBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext)
			throws Exception {

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());
		String description = jsonObject.getString("description");
		String notificationMessage = jsonObject.getString("notificationMessage");

		return StringUtil.replace(getBodyTemplate(), new String[] { "[$TITLE$]", "[$DESCRIPTION$]" },
				new String[] { notificationMessage, description });

	}

	protected String getBodyTemplate() {
		StringBundler sb = new StringBundler(5);
		sb.append("<div class=\"title\">[$TITLE$]</div><div ");
		sb.append("class=\"body\">[$DESCRIPTION$]</div>");
		return sb.toString();
	}

}
