//package bd.gov.dgfood.milling.license.renders;
//
//import com.liferay.portal.kernel.exception.PortalException;
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.model.Role;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
//import com.liferay.portal.kernel.theme.ThemeDisplay;
//import com.liferay.portal.kernel.util.PortalUtil;
//import com.liferay.portal.kernel.util.Validator;
//import com.liferay.portal.kernel.util.WebKeys;
//
//import java.util.HashMap;
//import java.util.List;
//
//import javax.portlet.PortletException;
//import javax.portlet.RenderRequest;
//import javax.portlet.RenderResponse;
//
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Reference;
//
//import bd.gov.dgfood.common.services.model.Address;
//import bd.gov.dgfood.common.services.model.Attachment;
//import bd.gov.dgfood.common.services.service.AddressLocalService;
//import bd.gov.dgfood.common.services.service.AttachmentLocalService;
//import bd.gov.dgfood.common.util.constants.AddressConstants;
//import bd.gov.dgfood.license.management.system.model.FGLicense;
//import bd.gov.dgfood.license.management.system.model.MillingLicense;
//import bd.gov.dgfood.license.management.system.service.FGLicenseLocalServiceUtil;
//import bd.gov.dgfood.license.management.system.service.MillingLicenseLocalServiceUtil;
//import bd.gov.dgfood.milling.license.constants.MillingLicensePortletKeys;
//
//@Component(immediate = true,
//property = {
//		"javax.portlet.name=" + MillingLicensePortletKeys.MILLINGLICENSE,
//		"mvc.command.name=/",
//		"mvc.command.name=" + MillingLicensePortletKeys.NAVIGATION_MVC_RENDER_COMMAND 
//},
//	service = MVCRenderCommand.class
//)
//public class MillingNavigationMVCRenderCommand implements MVCRenderCommand {
//
//	private static String ADMIN_MILLING_LICENSE = "/admin-milling-license";
//	
//	private static String MILLING_LICENSE = "/milling-license";
//	private static String LMS_MY_PROFILE = "/milling-license-profile";
//		
//	@Override
//	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
//
//		String mvcPath = "/view.jsp";
//		boolean hasAdminRole = false;
//
//		try {
//			
//			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
//			String siteName = themeDisplay.getLayout().getFriendlyURL().toLowerCase();
//			
//			for(Role role : themeDisplay.getUser().getRoles()) {
//				if(role.getName().equalsIgnoreCase("ACF") || role.getName().equalsIgnoreCase("DCF"))
//					hasAdminRole = true;
//			}
//			
//			if(themeDisplay.isSignedIn()) {
//				if(hasAdminRole) {
//					if(ADMIN_MILLING_LICENSE.equals(siteName)) {
//						mvcPath = "/milling_admin/milling_list.jsp";
//					}
//				}else{
//					
//					//Need to create User on FGLicense Approval & create a funtion to get fgLicense based on the userId.
//					//FGLicense fgLicense = FGLicenseLocalServiceUtil.getFGLicenseByUserId(themeDisplay.getUserId());
//					//String userNationalId = themeDisplay.getAccount().getUserName();
//					String userNationalId = "12345678900000001";
//					FGLicense fgLicense = FGLicenseLocalServiceUtil.getFGLicenseForNationalId(userNationalId);
//					MillingLicense millingLicense = MillingLicenseLocalServiceUtil.getMillingLicenseByFGLicenseId(fgLicense.getFgLicenseId());
//					
//					if(MILLING_LICENSE.equals(siteName)) {
//						renderRequest.setAttribute("millingLicense", millingLicense);
//						mvcPath = "/milling_dashboard/milling_license_info.jsp";
//					}else if(LMS_MY_PROFILE.equals(siteName)){
//						getMillingLicenseProfileDetails(renderRequest, millingLicense);
//						mvcPath = "/milling_dashboard/milling_profile.jsp";
//					}
//				}
//			}else {
//				mvcPath = "/view.jsp";
//			}
//			logger.info(" >>>mvcPath>>>> " + mvcPath);
//		}catch(PortalException e) {
//			e.printStackTrace();
//		}
//		return mvcPath;
//	}
//	
//	private void getMillingLicenseProfileDetails(RenderRequest renderRequest, MillingLicense millingLicense) {
//		
//		FGLicense fgLicense = null;
//		List <Address> addressList = null;
//		List <Attachment> attachmentList = null;
//		Address millingAddress = null;
//		HashMap<String,Attachment> attachmentEntryMap = new HashMap<String,Attachment>();
//		
//		try {
//			if(Validator.isNotNull(millingLicense)) {
//				
//				fgLicense = FGLicenseLocalServiceUtil.getFGLicense(millingLicense.getFoodGrainLicenseId());
//				
//				renderRequest.setAttribute("millingLicense", millingLicense);
//				renderRequest.setAttribute("fgLicense", fgLicense);
//			
//				long classNameId = PortalUtil.getClassNameId(MillingLicense.class.getName());
//				addressList = addressLocalService.getAddressListByClassNameAndPrimaryKey(millingLicense.getPrimaryKey(), classNameId);
//				for(Address address : addressList) {
//					if(address.getAddressType().equalsIgnoreCase(AddressConstants.ADDRESS_MILL)) {
//						millingAddress = address;
//						renderRequest.setAttribute("millingAddress", millingAddress);
//					}
//				}
//				attachmentList = attachmentLocalService.getAttachmentListByClassNameAndPrimaryKey(millingLicense.getPrimaryKey(), classNameId);
//				logger.info("Attachment List size - "+attachmentList.size());
//				for(Attachment attachment : attachmentList) {
//					if(Validator.isNotNull(attachment)) {
//						attachmentEntryMap.put(attachment.getAttachmentCategory(), attachment);
//					}
//				}
//				
//				renderRequest.setAttribute("attachmentEntryMap", attachmentEntryMap);
//			}
//		} catch (PortalException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	private Log logger = LogFactoryUtil.getLog(this.getClass());
//	
//	@Reference 
//	protected AddressLocalService addressLocalService;
//
//	@Reference 
//	protected AttachmentLocalService attachmentLocalService;
//}
