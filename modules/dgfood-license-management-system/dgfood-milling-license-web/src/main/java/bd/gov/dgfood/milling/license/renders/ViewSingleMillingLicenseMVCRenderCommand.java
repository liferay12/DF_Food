//package bd.gov.dgfood.milling.license.renders;
//
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.model.Role;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
//import com.liferay.portal.kernel.service.ServiceContext;
//import com.liferay.portal.kernel.service.ServiceContextFactory;
//import com.liferay.portal.kernel.theme.ThemeDisplay;
//import com.liferay.portal.kernel.util.ParamUtil;
//import com.liferay.portal.kernel.util.PortalUtil;
//import com.liferay.portal.kernel.util.Validator;
//import com.liferay.portal.kernel.util.WebKeys;
//import com.liferay.portal.kernel.workflow.WorkflowConstants;
//
//import java.util.ArrayList;
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
//import bd.gov.dgfood.license.management.system.service.MillingLicenseLocalService;
//import bd.gov.dgfood.milling.license.constants.MillingLicensePortletKeys;
//
//@Component(immediate = true,
//property = {
//		"javax.portlet.name=" + MillingLicensePortletKeys.MILLINGLICENSE,
//		"mvc.command.name=" + MillingLicensePortletKeys.VIEW_SINGLE_MILLING_MVC_RENDER_COMMAND 
//},
//service = MVCRenderCommand.class
//		)
//public class ViewSingleMillingLicenseMVCRenderCommand implements MVCRenderCommand {
//
//	@Override
//	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
//
//		logger.info("Entered ViewSingleMillingLicenseMVCRenderCommand");
//		String jspPath = "";
//		boolean hasAdminRole = false;
//		
//		try {
//
//			MillingLicense millingLicense = null;
//			FGLicense fgLicense = null;
//			List <Address> addressList = new ArrayList<Address>();
//			List <Attachment> attachmentList = new ArrayList<Attachment>();
//			Address millingAddress = null;
//			HashMap<String,Attachment> attachmentEntryMap = new HashMap<String,Attachment>();
//
//			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
//			ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
//			
//			for(Role role : themeDisplay.getUser().getRoles()) {
//				if(role.getName().equalsIgnoreCase("ACF") || role.getName().equalsIgnoreCase("DCF"))
//					hasAdminRole = true;
//			}
//			
//			//Food Grain License Basic Fields
//			long millingLicenseId = ParamUtil.getLong(renderRequest, "millingLicenseId");
//			long fgLicenseId = ParamUtil.getLong(renderRequest, "fgLicenseId");
//			logger.info("Has Role - "+hasAdminRole);
//			
//			if(hasAdminRole) {
//				jspPath = "/milling_admin/milling_details.jsp";
//			}else {
//				//Need to remove hardcoding.
//				jspPath = "/milling_dashboard/milling_profile.jsp";
//			}
//			
//			if(Validator.isNotNull(millingLicenseId)){
//
//				millingLicense = millingLicenseLocalService.getMillingLicense(millingLicenseId);
//				fgLicense = FGLicenseLocalServiceUtil.getFGLicense(millingLicense.getFoodGrainLicenseId());
//				
//			}else if(Validator.isNotNull(fgLicenseId)) {
//				
//				fgLicense = FGLicenseLocalServiceUtil.getFGLicense(fgLicenseId);
//				millingLicense = millingLicenseLocalService.getMillingLicenseByFGLicenseId(fgLicenseId);
//				
//			}
//
//				if(Validator.isNotNull(millingLicense) && Validator.isNotNull(fgLicense)) {
//					
//					if (millingLicense.getStatus() == WorkflowConstants.STATUS_PENDING) {
//						renderRequest.setAttribute("workflowPending", true);
//					}
//					
//					renderRequest.setAttribute("millingLicense", millingLicense);
//					renderRequest.setAttribute("fgLicense", fgLicense);
//				
//					long classNameId = PortalUtil.getClassNameId(MillingLicense.class.getName());
//					addressList = addressLocalService.getAddressListByClassNameAndPrimaryKey(millingLicense.getPrimaryKey(), classNameId);
//					for(Address address : addressList) {
//						if(address.getAddressType().equalsIgnoreCase(AddressConstants.ADDRESS_MILL)) {
//							millingAddress = address;
//							renderRequest.setAttribute("millingAddress", millingAddress);
//						}
//					}
//					attachmentList = attachmentLocalService.getAttachmentListByClassNameAndPrimaryKey(millingLicense.getPrimaryKey(), classNameId);
//					logger.info("Attachment List size - "+attachmentList.size());
//					for(Attachment attachment : attachmentList) {
//						if(Validator.isNotNull(attachment)) {
//							attachmentEntryMap.put(attachment.getAttachmentCategory(), attachment);
//						}
//					}
//					
//					renderRequest.setAttribute("attachmentEntryMap", attachmentEntryMap);
//				}
//
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//
//		return jspPath;
//	}
//
//	private Log logger = LogFactoryUtil.getLog(this.getClass());
//
//	@Reference 
//	protected MillingLicenseLocalService millingLicenseLocalService;
//
//	@Reference 
//	protected AddressLocalService addressLocalService;
//
//	@Reference 
//	protected AttachmentLocalService attachmentLocalService;
//}
