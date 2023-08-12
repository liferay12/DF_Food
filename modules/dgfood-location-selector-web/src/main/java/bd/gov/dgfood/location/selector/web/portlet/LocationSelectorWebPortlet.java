package bd.gov.dgfood.location.selector.web.portlet;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.common.services.service.UserLocationLocalService;
import bd.gov.dgfood.configuration.LocationUrlConfiguration;
import bd.gov.dgfood.location.selector.web.constants.LocationSelectorPortletKeys;

/**This Portlet will provide a User Interface which can be sued to Assign location to required Admin user based on this tagging workflow notification will be triggring to Admins
 * @author krishna
 */
@Component(configurationPid = "bd.gov.dgfood.location.selector.web.configuration.LocationUrlConfiguration", 

     immediate = true, property = {
		"com.liferay.portlet.add-default-resource=true", 
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.header-portlet-css=/css/main.css", 
		"com.liferay.portlet.layout-cacheable=true",
		"com.liferay.portlet.private-request-attributes=false", 
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.render-weight=50", 
		"com.liferay.portlet.use-default-template=true",
		"javax.portlet.display-name=Location", 
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.template-path=/", 
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + LocationSelectorPortletKeys.LOCATIONSELECTORWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)

public class LocationSelectorWebPortlet extends MVCPortlet {


	/**System configuration initilization
	 * @param properties
	 */
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_locationUrlConfiguration = ConfigurableUtil.createConfigurable(LocationUrlConfiguration.class, properties);
	}

	@Override
	protected void doDispatch(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		renderRequest.setAttribute(LocationUrlConfiguration.class.getName(), _locationUrlConfiguration);

		super.doDispatch(renderRequest, renderResponse);
	}

	private volatile LocationUrlConfiguration _locationUrlConfiguration;

}