package bd.gov.dgfood.location.selector.web.internal.frontend.taglib.servlet.taglib;

import com.liferay.frontend.taglib.servlet.taglib.ScreenNavigationEntry;
import com.liferay.frontend.taglib.servlet.taglib.util.JSPRenderer;
import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.AggregateResourceBundle;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.users.admin.constants.UserScreenNavigationEntryConstants;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.location.selector.web.constants.LocationSelectorPortletKeys;

/**This class is used to add a Portlet under general tab of Users & Organization
 * @author krishna
 *
 */
@Component(property = "screen.navigation.entry.order:Integer=80")
public class UserLocationsScreenNavigationCategory implements ScreenNavigationEntry<User> {

	@Reference
	private Language _language;

	@Override
	public String getCategoryKey() {
		return UserScreenNavigationEntryConstants.CATEGORY_KEY_GENERAL;
	}

	@Override
	public String getEntryKey() {
		return LocationSelectorPortletKeys.CATEGORY_KEY_LOCATIONS;
	}

	@Override
	public String getLabel(Locale locale) {
		return LanguageUtil.get(_getResourceBundle(locale), getEntryKey());
	}

	@Override
	public String getScreenNavigationKey() {
		return UserScreenNavigationEntryConstants.SCREEN_NAVIGATION_KEY_USERS;
	}

	@Override
	public boolean isVisible(User user, User selUser) {
		if (selUser == null) {
			return false;
		}

		return true;
	}

	@Override
	public void render(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws IOException {
		httpServletRequest.setAttribute(LocationSelectorPortletKeys.ACTION_COMMAND_NAME, "/users_admin/edit_locations_users");
		httpServletRequest.setAttribute(LocationSelectorPortletKeys.EDITABLE, true);
		httpServletRequest.setAttribute(LocationSelectorPortletKeys.SHOW_CONTROLS, true);

		jspRenderer.renderJSP(_servletContext, httpServletRequest, httpServletResponse, "/select_location.jsp");

	}

	@Reference
	protected JSPRenderer jspRenderer;

	@Reference
	protected Portal portal;

	private ResourceBundle _getResourceBundle(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle("content.Language", locale, getClass());

		return new AggregateResourceBundle(resourceBundle, PortalUtil.getResourceBundle(locale));
	}

	@Reference(target = "(osgi.web.symbolicname=bd.gov.dgfood.location.selector.web)", unbind = "-")
	public void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	private ServletContext _servletContext;

}
