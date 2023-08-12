package bd.gov.dgfood.farmer.information.management.system.web.resource;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.farmer.information.management.system.web.constants.FarmerInformationManagementSystemConstants;
import bd.gov.dgfood.farmer.information.management.system.web.constants.FarmerInformationManagementSystemPortletKeys;
import bd.gov.dgfood.farmer.information.management.system.web.display.context.FarmerRegistrationDisplayContext;

@Component(immediate = true, property = {
		"javax.portlet.name=" + FarmerInformationManagementSystemPortletKeys.FARMERINFORMATIONMANAGEMENTSYSTEM,
		"mvc.command.name="
				+ FarmerInformationManagementSystemConstants.FARMER_REGISTRATIONS_SEARCH_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class SearchFarmerRegistrationsResourceCommand  extends BaseMVCResourceCommand{

	@Override
	public void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException, IOException {
		
		logger.debug("Inside Search Farmer registration records resource command");

		FarmerRegistrationDisplayContext farmerRegistrationDisplayContext  = new FarmerRegistrationDisplayContext(
				PortalUtil.getHttpServletRequest(resourceRequest), _portal.getLiferayPortletRequest(resourceRequest),
				_portal.getLiferayPortletResponse(resourceResponse));
		resourceRequest.setAttribute("customSearchContainer", farmerRegistrationDisplayContext.getSearch());
		
		include(resourceRequest, resourceResponse, FarmerInformationManagementSystemConstants.FARMER_REGISTRATIONS_SEARCH_CONTAINER_JSP);
	}

	@Reference
	private Portal _portal;
	private Log logger = LogFactoryUtil.getLog(this.getClass());
}
