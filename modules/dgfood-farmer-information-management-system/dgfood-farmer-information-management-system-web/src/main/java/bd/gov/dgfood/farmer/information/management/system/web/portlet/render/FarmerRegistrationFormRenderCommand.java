package bd.gov.dgfood.farmer.information.management.system.web.portlet.render;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.farmer.information.management.system.web.constants.FarmerInformationManagementSystemConstants;
import bd.gov.dgfood.farmer.information.management.system.web.constants.FarmerInformationManagementSystemPortletKeys;

@Component(immediate = true, property = {
		"javax.portlet.name=" + FarmerInformationManagementSystemPortletKeys.FARMERINFORMATIONMANAGEMENTSYSTEM,
		"mvc.command.name="
				+ FarmerInformationManagementSystemConstants.FARMER_REGISTRATION_FORM_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class FarmerRegistrationFormRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<AssetCategory> regionList = new ArrayList<AssetCategory>();
		try {

			AssetVocabulary regionVocabulary = AssetVocabularyLocalServiceUtil
					.getGroupVocabulary(themeDisplay.getScopeGroupId(), "Location");
			regionList = AssetCategoryLocalServiceUtil.getVocabularyCategories(0, regionVocabulary.getVocabularyId(),
					-1, -1, null);

			log.debug("Dropdown fetched successfully");
		} catch (PortalException e) {
			log.error("Error while fetching the asset categories: " + e.getMessage());
			if (log.isDebugEnabled()) {
				e.printStackTrace();
			}
		}

		renderRequest.setAttribute("regionList", regionList);

		return FarmerInformationManagementSystemConstants.FIMS_DEFAULT_JSP;
	}

	private Log log = LogFactoryUtil.getLog(this.getClass());
}
