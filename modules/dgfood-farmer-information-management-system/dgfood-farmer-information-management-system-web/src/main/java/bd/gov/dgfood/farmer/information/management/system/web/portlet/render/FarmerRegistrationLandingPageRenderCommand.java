package bd.gov.dgfood.farmer.information.management.system.web.portlet.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.common.services.model.Address;
import bd.gov.dgfood.common.services.service.AddressLocalService;
import bd.gov.dgfood.common.util.constants.ParameterConstants;
import bd.gov.dgfood.common.util.constants.PortletPreferencesConstants;
import bd.gov.dgfood.farmer.information.management.system.exception.FarmerSalesProposalInternalErrorException;
import bd.gov.dgfood.farmer.information.management.system.model.FarmerRegistration;
import bd.gov.dgfood.farmer.information.management.system.service.FarmerRegistrationLocalService;
import bd.gov.dgfood.farmer.information.management.system.web.constants.FarmerInformationManagementSystemConstants;
import bd.gov.dgfood.farmer.information.management.system.web.constants.FarmerInformationManagementSystemPortletKeys;
import bd.gov.dgfood.farmer.information.management.system.web.util.FarmerManagementWebUtil;

@Component(immediate = true, property = {
		"javax.portlet.name=" + FarmerInformationManagementSystemPortletKeys.FARMERINFORMATIONMANAGEMENTSYSTEM,
		"mvc.command.name=/" }, service = MVCRenderCommand.class)
public class FarmerRegistrationLandingPageRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		PortletPreferences preference = renderRequest.getPreferences();
		String landingPage = preference.getValue(ParameterConstants.LANDING_PAGE,
				PortletPreferencesConstants.STATUS_TRACKER_FORM);

		log.debug(landingPage);

		if (landingPage.equalsIgnoreCase(PortletPreferencesConstants.FARMER_REGISTRATION_FORM)) {
			FarmerManagementWebUtil.loadLocationAssetVocabulary(renderRequest);
		}

		else if (landingPage.equalsIgnoreCase(PortletPreferencesConstants.SALES_PROPOSAL_FORM)) {
			try {
				_loadSalesProposalFormData(renderRequest);
			} catch (FarmerSalesProposalInternalErrorException e) {
				log.error("Exception while fetching farmer information for Sales Proposal application: "
						+ e.getMessage());
				if (log.isDebugEnabled()) {
					e.printStackTrace();
				}
			}
		}

		return FarmerInformationManagementSystemConstants.FIMS_DEFAULT_JSP;
	}

	private void _loadSalesProposalFormData(RenderRequest renderRequest)
			throws FarmerSalesProposalInternalErrorException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		FarmerRegistration currentUserRegistrationRecord = farmerRegistrationLocalService
				.fetchFarmerRegistrationByUserId(themeDisplay.getUserId());

		if (Validator.isNull(currentUserRegistrationRecord)) {
			throw new FarmerSalesProposalInternalErrorException(
					"Farmer is not yet registered. Please register your self before applying sales proposal");
		}

		List<Address> farmerRegistrationAddressList = addressLocalService.getAddressListByClassNameAndClassPK(
				currentUserRegistrationRecord.getFarmerRegistrationId(), FarmerRegistration.class.getName());
		Map<String, Address> farmerRegistrationAddress=new HashMap<String, Address>();
		
		farmerRegistrationAddressList.forEach((address)->{
			farmerRegistrationAddress.put(address.getAddressType(), address);
		});

		// TODO: Fetch current season and foodgrain type from season configurations
		String currentSeason = "boro";
		String foodgrainType = "rice";

		renderRequest.setAttribute("currentUserRegistrationRecord", currentUserRegistrationRecord);
		renderRequest.setAttribute("farmerRegistrationAddress", farmerRegistrationAddress);
		renderRequest.setAttribute("currentSeason", currentSeason);
		renderRequest.setAttribute("foodgrainType", foodgrainType);

	}

	@Reference
	private FarmerRegistrationLocalService farmerRegistrationLocalService;

	@Reference
	private AddressLocalService addressLocalService;

	private Log log = LogFactoryUtil.getLog(this.getClass());
}
