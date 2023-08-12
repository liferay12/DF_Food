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
		"mvc.command.name=" + MillingLicensePortletKeys.RENEWAL_DUPLICATE_MILLING_MVC_RENDER_COMMAND 
},
	service = MVCRenderCommand.class
)
public class RenewalOrDuplicateMillingLicenseMVCRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		logger.info("Entered RenewalOrDuplicateMillingLicenseMVCRenderCommand");
		
		String mvcPath = "";
		
//		try {
//			
//			MillingLicense millingLicense = null;
//			
//			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
//			ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
//
//			//Food Grain License Basic Fields
//			long  millingLicenseId = ParamUtil.getLong(renderRequest, "millingLicenseId");
//			String cmd = ParamUtil.getString(renderRequest, "cmd");
//			
//			if(cmd.equalsIgnoreCase("renewal")) {
//				mvcPath = "/milling_dashboard/milling_renewal/millingRenewal.jsp";
//			}else {
//				mvcPath = "/milling_dashboard/milling_duplicate/millingDuplicate.jsp";
//			}
//			
//			if(Validator.isNotNull(millingLicenseId)){
//				
//				millingLicense = millingLicenseLocalService.getMillingLicense(millingLicenseId);
//				
//				if(Validator.isNotNull(millingLicense)) {
//					renderRequest.setAttribute("millingLicense", millingLicense);
//				}
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		
		return mvcPath;
	}
	
	private Log logger = LogFactoryUtil.getLog(this.getClass());
	
//	@Reference 
//	protected MillingLicenseLocalService millingLicenseLocalService;

}
