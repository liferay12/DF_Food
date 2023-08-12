package bd.gov.dgfood.milling.license.renders;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.milling.license.constants.MillingLicensePortletKeys;

@Component(immediate = true,
property = {
		"javax.portlet.name=" + MillingLicensePortletKeys.MILLINGLICENSE,
		"mvc.command.name=" + MillingLicensePortletKeys.NEW_MILLING_MVC_RENDER_COMMAND 
},
	service = MVCRenderCommand.class
)
public class NewMillingLicenseMVCRenderCommand  implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		logger.info("Entered NewMillingLicenseMVCRenderCommand");
//		try {
//			
//			FGLicense fgLicense = null;
//			
//			long fgLicenseId = ParamUtil.getLong(renderRequest, "fgLicenseId");
//			
//			ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
//			
//			if(Validator.isNotNull(fgLicenseId)) {
//			
//				fgLicense = FGLicenseLocalServiceUtil.getFGLicense(fgLicenseId);
//				logger.info(fgLicense.getApplicantName());
//			}
//			
//			List<AssetCategory> divisionList = CategoryUtil.fetchCategoriesbyVocabularyNameAndParentId(themeDisplay, CategoryConstants.LOCATION, CategoryConstants.ZERO);
//			
//			renderRequest.setAttribute("divisionList", divisionList);
//			renderRequest.setAttribute("fgLicense", fgLicense);
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//			logger.error("Not Able to fetch the division List");
//		}
		
		return "/milling_registration/millingRegistration.jsp";
	}
	
	private Log logger = LogFactoryUtil.getLog(this.getClass());
}
