package bd.gov.dgfood.portal.notification.web.portlet;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import bd.gov.dgfood.configuration.GeneralConfiguration;
import bd.gov.dgfood.portal.notification.web.constants.PortalNotificationPortletKeys;

/**
 * This Portlet is responsible for showing bell notification and 5 recent
 * notification of users
 * 
 * @author krishna
 */
@Component(configurationPid = "bd.gov.dgfood.configuration.GeneralConfiguration",
         immediate = true, property = { 
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Portal Bell Notification", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view_bell_icon.jsp",
		"javax.portlet.name=" + PortalNotificationPortletKeys.PORTAL_BELL_NOTIFICATION,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class PortalBellNotificationPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		if (!themeDisplay.isSignedIn()) {
			log.error("User " + themeDisplay.getUserId() + "does not have access access to this portlet");
			throw new PortletException();
		}
		renderRequest.setAttribute("notificationPageUrl", _configuration.getNotificationPageUrl());
		super.doView(renderRequest, renderResponse);
	}
	
	@Activate
    @Modified
    protected void activate(Map<String, Object> properties) {
        _configuration = ConfigurableUtil.createConfigurable(GeneralConfiguration.class, properties);
    }

    private volatile GeneralConfiguration _configuration;

	Log log = LogFactoryUtil.getLog(PortalBellNotificationPortlet.class);
}
