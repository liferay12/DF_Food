package bd.gov.dgfood.farmer.information.management.system.web.portlet.preference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

import bd.gov.dgfood.common.util.constants.ParameterConstants;
import bd.gov.dgfood.common.util.constants.PortletPreferencesConstants;
import bd.gov.dgfood.farmer.information.management.system.web.constants.FarmerInformationManagementSystemPortletKeys;

@Component(configurationPolicy = ConfigurationPolicy.OPTIONAL, property = "javax.portlet.name="
		+ FarmerInformationManagementSystemPortletKeys.FARMERINFORMATIONMANAGEMENTSYSTEM, service = ConfigurationAction.class)
public class FarmrWebPortletConfigurationActionCommand extends DefaultConfigurationAction {

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		log.debug("Portlet Preferencese will be updated");
		
		String landingPage=ParamUtil.getString(actionRequest, ParameterConstants.LANDING_PAGE, PortletPreferencesConstants.STATUS_TRACKER_FORM);

		setPreference(actionRequest,  ParameterConstants.LANDING_PAGE, landingPage);
		
		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	private Log log = LogFactoryUtil.getLog(this.getClass());
}
