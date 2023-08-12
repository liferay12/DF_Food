//package bd.gov.dgfood.milling.license.actions;
//
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
//import com.liferay.portal.kernel.service.ServiceContext;
//import com.liferay.portal.kernel.service.ServiceContextFactory;
//import com.liferay.portal.kernel.theme.ThemeDisplay;
//import com.liferay.portal.kernel.upload.UploadPortletRequest;
//import com.liferay.portal.kernel.util.ParamUtil;
//import com.liferay.portal.kernel.util.PortalUtil;
//import com.liferay.portal.kernel.util.Validator;
//import com.liferay.portal.kernel.util.WebKeys;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.portlet.ActionRequest;
//import javax.portlet.ActionResponse;
//import javax.portlet.MimeResponse.Copy;
//import javax.portlet.RenderURL;
//
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Reference;
//
//import bd.gov.dgfood.common.model.AttachmentBinaryFile;
//import bd.gov.dgfood.common.services.exception.DataValidationException;
//import bd.gov.dgfood.common.services.model.Address;
//import bd.gov.dgfood.common.services.model.Attachment;
//import bd.gov.dgfood.common.services.model.BankAccountInformation;
//import bd.gov.dgfood.common.services.service.AddressLocalService;
//import bd.gov.dgfood.common.services.service.AttachmentLocalService;
//import bd.gov.dgfood.common.services.service.BankAccountInformationLocalService;
//import bd.gov.dgfood.common.util.DLUploadUtil;
//import bd.gov.dgfood.common.util.constants.AddressConstants;
//import bd.gov.dgfood.common.util.constants.DocumentLibraryConstants;
//import bd.gov.dgfood.common.util.constants.ParameterConstants;
//import bd.gov.dgfood.license.management.system.exception.InvalidMillingLicenseApplicationDataException;
//import bd.gov.dgfood.license.management.system.model.MillingLicense;
//import bd.gov.dgfood.license.management.system.model.MillingLicenseVersion;
//import bd.gov.dgfood.license.management.system.service.MillingLicenseLocalServiceUtil;
//import bd.gov.dgfood.license.management.system.service.MillingLicenseVersionLocalService;
//import bd.gov.dgfood.milling.license.constants.MillingLicensePortletKeys;
//
//@Component(immediate = true,
//property = {
//		"javax.portlet.name=" + MillingLicensePortletKeys.MILLINGLICENSE,
//		"mvc.command.name=" + MillingLicensePortletKeys.SUBMIT_RENEWAL_MILLING_MVC_ACTION_COMMAND 
//},
//service = MVCActionCommand.class
//		)
//public class SubmitRenewalMillingLicenseMVCActionCommand extends BaseMVCActionCommand {
//
//	@Override
//	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
//
//		logger.info("Entered SubmitRenewalMillingLicenseMVCActionCommand");
//
//		MillingLicense millingLicense = null;
//		List<Address> addressList = new ArrayList<Address>();
//		List<Attachment> attachmentList = new ArrayList<Attachment>();
//		Address millingAddress = null;
//		BankAccountInformation bankAccountInformation = null;
//		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
//		List<AttachmentBinaryFile> documentBinaryFileList = new ArrayList<AttachmentBinaryFile>();
//		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
//		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
//
//		//To Fetch FGLicense Details.
//		long millingLicenseId = ParamUtil.getLong(actionRequest, "millingLicenseId");
//		logger.info("millingLicenseId - "+millingLicenseId);
//
//		if(Validator.isNotNull(millingLicenseId)) {
//
//			millingLicense = MillingLicenseLocalServiceUtil.fetchMillingLicense(millingLicenseId);
//
//			if(Validator.isNotNull(millingLicense)) {
//
//				long classNameId = PortalUtil.getClassNameId(MillingLicense.class.getName());
//				addressList = addressLocalService.getAddressListByClassNameAndPrimaryKey(millingLicense.getPrimaryKey(), classNameId);
//				for(Address address : addressList) {
//					if(address.getAddressType().equalsIgnoreCase(AddressConstants.ADDRESS_MILL)) {
//						// Get the Permanent Address
//						millingAddress = address;
//					}
//				}
//
//				bankAccountInformation = bankAccountInformationLocalService.getBankAccountInformationByClassNameAndPrimaryKey(millingLicense.getPrimaryKey(), classNameId);
//
//				String millingLicenseNumber = ParamUtil.getString(actionRequest, "millingLicenseNumber");
//				String millingLicenseValidity= ParamUtil.getString(actionRequest, "millingLicenseValidity");
//				String tradeLicenseNumber = ParamUtil.getString(actionRequest, "tradeLicenseNumber");
//				String tradeLicenseValidity= ParamUtil.getString(actionRequest, "tradeLicenseValidity");
//				String comments = ParamUtil.getString(actionRequest, "comments");
//
//				System.out.println("millingLicenseNumber "+millingLicenseNumber);
//				System.out.println("millingLicenseValidity "+millingLicenseValidity);
//				System.out.println("tradeLicenseNumber "+tradeLicenseNumber);
//				System.out.println("tradeLicenseValidity "+tradeLicenseValidity);
//				System.out.println("comments "+comments);
//
//				//Get the FgLicense Files
//				AttachmentBinaryFile tradeLicenseNumberPhotocopy = null;
//				if(Validator.isNotNull(uploadPortletRequest.getFile("tradeLicenseNumberPhotocopy").exists()) && uploadPortletRequest.getFile("tradeLicenseNumberPhotocopy").exists()) {
//					tradeLicenseNumberPhotocopy = DLUploadUtil.getUploadedDocument(actionRequest, 
//							"tradeLicenseNumberPhotocopy", DocumentLibraryConstants.ATTACHMENT_TRADE_LICENSE_PHOTO);
//				}
//				documentBinaryFileList.add(tradeLicenseNumberPhotocopy);
//
//				try 
//				{
//					//Basic Information Storing
//					MillingLicenseVersion millingLicenseVersion = millingLicenseVersionLocalService.addMillingLicenseVersionFormData(ParameterConstants.LMS_RENEWAL, 
//							millingLicenseId, millingLicense.getFoodGrainLicenseId(), millingLicense.getUserId(), millingLicense.getMaritalStatus(), 
//							millingLicense.getSpouseName(), millingLicense.getSpouseFatherName(), millingLicense.getSpouseNationalId(), 
//							millingLicense.getSpouseDateOfBirth(), millingLicense.getOperateOwnMill(), millingLicense.getMillOperatingThroughThirdParty(), 
//							millingLicense.getOperatorName(), millingLicense.getOperatorNationalId(), millingLicense.getOperatorRunningBusinessFromYrs(), 
//							millingLicense.getPublicRepresentative(), millingLicense.getWorkInGovernment(), millingLicense.getMillDetails(), 
//							millingAddress.getRegionId(), millingAddress.getDistrictId(), millingAddress.getUpazillaId(), millingAddress.getUnionId(), 
//							millingAddress.getVillage(), millingAddress.getWard(), millingAddress.getZipcode(), millingAddress.getPostoffice(), 
//							millingAddress.getAddress(), bankAccountInformation.getAccountNumber(), bankAccountInformation.getAccountHolderName(),
//							bankAccountInformation.getBankName(), bankAccountInformation.getBranchName(), millingLicense.getElectricityDetails(), 
//							millingLicense.getBoilerDetails(), millingLicense.getChimneyDetails(), millingLicense.getChatalDetails(), 
//							millingLicense.getStripingHouseDetails(), millingLicense.getMillStorageDetails(), millingLicense.getMotorDetails(), 
//							millingLicense.getMillCapacityDetails(), documentBinaryFileList, serviceContext);
//
//					logger.debug(millingLicenseVersion);
//
//					RenderURL successPageURL=actionResponse.createRedirectURL(Copy.NONE);
//					successPageURL.setParameter("mvcRenderCommandName", MillingLicensePortletKeys.MILIING_SCREEN_MILLING_MVC_RENDER_COMMAND);
//					successPageURL.setParameter("millingLicenseId", String.valueOf(millingLicenseVersion.getMillingLicenseId()));
//					actionResponse.sendRedirect(successPageURL.toString());
//
//					hideDefaultSuccessMessage(actionRequest);
//
//
//				} catch (DataValidationException dataValidationException) {
//					logger.error("Validation failed for submitted Milling License Data: " + dataValidationException.getMessage());
//					if (logger.isDebugEnabled()) {
//						dataValidationException.printStackTrace();
//					}
//				}
//				catch (InvalidMillingLicenseApplicationDataException invalidMillingLicenseApplicationDataException) {
//					logger.error("Internal error occured while stroring Milling License data : " + invalidMillingLicenseApplicationDataException.getMessage());
//					if (logger.isDebugEnabled()) {
//						invalidMillingLicenseApplicationDataException.printStackTrace();
//					}
//				}
//				catch (Exception exception) {
//					logger.error("Exception occured while added the Milling	 License : " + exception.getMessage());
//					if (logger.isDebugEnabled()) {
//						exception.printStackTrace();
//					}
//				}
//			}
//		}
//	}
//
//	private Log logger = LogFactoryUtil.getLog(this.getClass());
//
//	//Need to check the issue of following reference.
//	@Reference 
//	protected MillingLicenseVersionLocalService millingLicenseVersionLocalService;
//
//	@Reference 
//	protected AddressLocalService addressLocalService;
//
//	@Reference
//	protected BankAccountInformationLocalService bankAccountInformationLocalService;
//
//	@Reference 
//	protected AttachmentLocalService attachmentLocalService;
//
//}