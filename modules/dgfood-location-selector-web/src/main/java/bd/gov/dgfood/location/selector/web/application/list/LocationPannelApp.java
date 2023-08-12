package bd.gov.dgfood.location.selector.web.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.location.selector.web.constants.LocationSelectorPortletKeys;

/** This call is used to add a Panel app under User category
 * @author krishna
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=700",
		"panel.category.key=" + PanelCategoryKeys.CONTROL_PANEL_USERS
	},
	service = PanelApp.class
)
public class LocationPannelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return LocationSelectorPortletKeys.LOCATIONSELECTORWEB;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + LocationSelectorPortletKeys.LOCATIONSELECTORWEB + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}
