//package dgfood.headless.license.management.system.internal.resource.v1_0;
//
//import com.liferay.petra.string.StringPool;
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.service.ServiceContext;
//import com.liferay.portal.kernel.service.ServiceContextFactory;
//import com.liferay.portal.kernel.util.Portal;
//import com.liferay.portal.kernel.util.Validator;
//import com.liferay.portal.kernel.workflow.WorkflowInstance;
//import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
//import com.liferay.portal.kernel.workflow.WorkflowTask;
//import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
//import java.util.Map;
//
//import javax.validation.constraints.NotNull;
//import javax.ws.rs.BadRequestException;
//import javax.ws.rs.NotFoundException;
//
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Reference;
//import org.osgi.service.component.annotations.ServiceScope;
//
//import bd.gov.dgfood.common.services.service.AddressLocalService;
//import bd.gov.dgfood.common.services.service.AddressVersionLocalService;
//import bd.gov.dgfood.common.util.CategoryUtil;
//import bd.gov.dgfood.common.util.constants.AddressConstants;
//import bd.gov.dgfood.common.util.constants.CommonUtilPortletKeys;
//import bd.gov.dgfood.common.util.constants.StatusConstants;
//import bd.gov.dgfood.common.util.validator.DataValidationException;
//import bd.gov.dgfood.license.management.system.constants.LicenseConstants;
//import bd.gov.dgfood.license.management.system.model.FGLicense;
//import bd.gov.dgfood.license.management.system.model.FGLicenseVersion;
//import bd.gov.dgfood.license.management.system.service.FGLicenseLocalService;
//import bd.gov.dgfood.license.management.system.service.FGLicenseVersionLocalService;
//import bd.gov.dgfood.license.management.system.service.FGLicenseVersionLocalServiceUtil;
//import bd.gov.dgfood.taglib.util.WorflowTaskSubmissionUtil;
//import dgfood.headless.license.management.system.dto.v1_0.Address;
//import dgfood.headless.license.management.system.dto.v1_0.FGLicenseAccountDetails;
//import dgfood.headless.license.management.system.dto.v1_0.Location;
//import dgfood.headless.license.management.system.dto.v1_0.NewFGLicenseAccount;
//import dgfood.headless.license.management.system.dto.v1_0.RenewalDuplicateFGLicenseAccount;
//import dgfood.headless.license.management.system.dto.v1_0.ReviewFGLicenseAccount;
//import dgfood.headless.license.management.system.dto.v1_0.TransitionFGLicenseAccount;
//
///**
// * @author Liferay
// */
//@Component(
//		properties = "OSGI-INF/liferay/rest/v1_0/fg-license-account.properties",
//		scope = ServiceScope.PROTOTYPE, service = FGLicenseAccountResource.class
//		)
//public class FGLicenseAccountResourceImpl extends BaseFGLicenseAccountResourceImpl {
//
//	/**
//	 * To get the Food Grain License Details based on Application Number.
//	 * @param fgApplicationNo
//	 * @return FGLicenseAccount
//	 */
//	@Override
//	public FGLicenseAccount getFGLicenseAccount(@NotNull String fgApplicationNo) throws Exception {
//		FGLicenseVersion fgLicenseVersion = null;
//
//		fgLicenseVersion = _fgLicenseVersionLocalService.getFGLicenseVersionForApplicationNumber(fgApplicationNo);
//		ServiceContext serviceContext = ServiceContextFactory.getInstance(contextHttpServletRequest);
//		serviceContext.setPortletId(CommonUtilPortletKeys.FOODGRAINLICENSE);
//		logger.info("Portlet Id- "+serviceContext.getPortletId());
//		logger.info("Scope Group Id- "+serviceContext.getScopeGroupId());
//		logger.info("Locale - "+serviceContext.getLocale());
//		WorkflowTask workflowTask = WorflowTaskSubmissionUtil.getWorkflowTask(fgLicenseVersion.getPrimaryKey(), FGLicense.class.getName());
//		Map<String, Serializable> workflowContext = _getWorkflowContext(serviceContext.getCompanyId(), workflowTask.getWorkflowTaskId());
//		
//		
//		if(Validator.isNotNull(fgLicenseVersion)) {
//			return _toFgLicenseVersionAccount(fgLicenseVersion, fgLicenseVersion.getTypeOfLicense());
//		}else {
//			throw new NotFoundException("no-food-grain-license-with-this-application-number-available");
//		}
//	}
//
//	/**
//	 * To get the Food Grain License Application Transitions for approval & rejection.
//	 * @param licenseType
//	 * @param fgApplicationNo
//	 * @return TransitionFGLicenseAccount
//	 */
//	@Override
//	public TransitionFGLicenseAccount getTransitionFGLicenseAccount(@NotNull String licenseType,
//			@NotNull String fgApplicationNo) throws Exception {
//
//		FGLicense fgLicense = null;
//		FGLicenseVersion fgLicenseVersion = null;
//		WorkflowTask workflowTask = null;
//		long primaryKey = 0;
//		String className = StringPool.BLANK;
//		ServiceContext serviceContext = ServiceContextFactory.getInstance(contextHttpServletRequest);
//
//		if(Validator.isNotNull(fgApplicationNo) && Validator.isNotNull(licenseType)) {
//
//			if(licenseType.equalsIgnoreCase(LicenseConstants.LMS_NEW)) {
//				fgLicense = _fgLicenseLocalService.getFGLicenseForApplicationNumber(fgApplicationNo);
//				primaryKey = fgLicense.getPrimaryKey();
//				className = FGLicense.class.getName();
//
//			}else if(licenseType.equalsIgnoreCase(LicenseConstants.LMS_UPDATE) ||
//					licenseType.equalsIgnoreCase(LicenseConstants.LMS_RENEWAL) ||
//					licenseType.equalsIgnoreCase(LicenseConstants.LMS_DUPLICATE)){
//				fgLicenseVersion = _fgLicenseVersionLocalService.getFGLicenseVersionForApplicationNumber(fgApplicationNo);
//				primaryKey = fgLicenseVersion.getPrimaryKey();
//				className = FGLicenseVersion.class.getName();
//				logger.info(primaryKey);
//				logger.info(className);
//			}
//
//			if(Validator.isNotNull(primaryKey) && Validator.isNotNull(className)) {
//				workflowTask = WorflowTaskSubmissionUtil.getWorkflowTask(primaryKey, className);
//				logger.info(workflowTask);
//				if(Validator.isNotNull(workflowTask)) {
//					List<String> transitionNames = 
//							WorkflowTaskManagerUtil.getNextTransitionNames(serviceContext.getCompanyId(), workflowTask.getAssigneeUserId(), workflowTask.getWorkflowTaskId());
//
//					if(Validator.isNotNull(transitionNames) && !transitionNames.isEmpty()) {
//						long fgLicenseId = primaryKey;
//						return new TransitionFGLicenseAccount(){
//							{
//								id = fgLicenseId;
//								transitions = (String [])transitionNames.toArray(new String[transitionNames.size()]);
//								licenseType = licenseType;
//							}
//						};
//					}else {
//						throw new DataValidationException("no-transition-action-available-for-the-user-for-this-food-grain-license-application");
//					}
//				}else {
//					throw new DataValidationException("no-workflow-is-active-for-this-food-grain-license-id");
//				}
//			}else {
//				throw new NotFoundException("no-food-grain-license-with-this-application-number-available");
//			}
//		}else {
//			throw new BadRequestException("please-provide-valid-food-grain-application-no-and-license-type");
//		}
//	}
//
//	/**
//	 * To add new Food Grain License Application Details through Schema.
//	 * @param fgLicenseAccount
//	 * @return FGLicenseAccount
//	 */
//	@Override
//	public FGLicenseAccountDetails postFGLicenseAccount(NewFGLicenseAccount fgLicenseAccount)
//			throws Exception {
//
//		FGLicense fgLicense = null;
//		Address permanentAddress = fgLicenseAccount.getPermanentAddress();
//		Address presentAddress = fgLicenseAccount.getPresentAddress();
//		ServiceContext serviceContext = ServiceContextFactory.getInstance(contextHttpServletRequest);
//
//		fgLicense = _fgLicenseLocalService.addFGLicenseFormData(isHeadlessRequest, acknowledge, nationalId, mobileNumber, dateOfBirth, emailAddress, password, applicantName, gender, maritalStatus, fatherName, motherName, tradeLicenseNumber, tradeLicenseValidity, taxIdentificationNumber, businessIdentificationNumber, tradeLicenseIssuerCode, tradeLicenseIssuerCity, permanentRegion, permanentDistrict, permanentUpazilla, permanentCityCorporationOrMunicipality, permanentUnionOrWard, permanentZipCode, permanentPostOffice, permanentVillageOrRoad, permanentMouzaOrMoholla, permanentHouseAddress, presentRegion, presentDistrict, presentUpazilla, presentCityCorporationOrMunicipality, presentUnionOrWard, presentZipCode, presentPostOffice, presentVillageOrRoad, presentMouzaOrMoholla, presentHouseAddress, businessName, businessType, businessRegion, businessDistrict, businessUpazilla, businessCityCorporationOrMunicipality, businessUnionOrWard, businessZipCode, businessPostOffice, businessVillageOrRoad, businessMouzaOrMoholla, businessHouseAddress, profilePhotograph, tradeLicenseNumberPhotocopy, businessIdentificationNumberPhotocopy, taxIdentificationNumberPhotocopy, bankStatementDocument, relevantDocument, serviceContext)
//				
//				(true, String.valueOf(fgLicenseAccount.getApplicantNid()), 
//				fgLicenseAccount.getApplicantMobileNumber(), fgLicenseAccount.getDateOfBirth(), fgLicenseAccount.getTradeLicenseNumber(), 
//				fgLicenseAccount.getTradeLicenseExpiry(), fgLicenseAccount.getTaxIdentificationNo(), 
//				fgLicenseAccount.getBusinessIdentificationNo(), fgLicenseAccount.getTradeLicenseIssuerCode(), 
//				fgLicenseAccount.getTradeLicenseIssueCity(), fgLicenseAccount.getApplicantName(), 
//				fgLicenseAccount.getApplicantGender().intValue(), fgLicenseAccount.getMaritalStatus().intValue(), 
//				fgLicenseAccount.getEmailAddress(),fgLicenseAccount.getApplicantFathersName(), fgLicenseAccount.getApplicantMothersName(),
//				"Password",  permanentAddress.getRegion().getId().longValue(), permanentAddress.getDistrict().getId().longValue(), 
//				permanentAddress.getUpzilla().getId().longValue(), permanentAddress.getCityCorporationOrMuncipalty().getId().longValue(),
//				permanentAddress.getUnionOrWard().getId().longValue(), permanentAddress.getVillageOrRoad(), 
//				permanentAddress.getWard().getId().longValue(), permanentAddress.getZipCode(), 
//				permanentAddress.getPostOffice(), permanentAddress.getAddress(), presentAddress.getRegion().getId().longValue(), 
//				presentAddress.getDistrict().getId().longValue(), presentAddress.getUpzilla().getId().longValue(), 
//				presentAddress.getCityCorporationOrMuncipalty().getId().longValue(), presentAddress.getUnionOrWard().getId().longValue(), 
//				presentAddress.getVillageOrRoad(), presentAddress.getWard().getId().longValue(), presentAddress.getZipCode(), 
//				presentAddress.getPostOffice(), presentAddress.getAddress(), true, 
//				null, null, null, null, null, null, serviceContext);
//
//		return _toFgLicenseAccount(fgLicense);
//	}
//
//	/**
//	 * To update Food Grain License Application Details through Schema.
//	 * @param fgApplicationNo
//	 * @param fgLicenseAccount
//	 * @return FGLicenseAccount
//	 */
//	@Override
//	public FGLicenseAccount putUpdateFGLicenseAccount(@NotNull String fgApplicationNo, FGLicenseAccount fgLicenseAccount)
//			throws Exception {
//
//		ServiceContext serviceContext = ServiceContextFactory.getInstance(contextHttpServletRequest);
//
//		FGLicenseVersion fgLicenseVersion = null;
//		FGLicense fgLicense = null;
//		String licenseType = LicenseConstants.LMS_UPDATE;
//		bd.gov.dgfood.common.services.model.Address permanentAddressDb = null;
//		Address presentAddress = fgLicenseAccount.getPresentAddress();
//
//		List<bd.gov.dgfood.common.services.model.Address> addressList = 
//				new ArrayList<bd.gov.dgfood.common.services.model.Address>();
//
//		logger.info("Upazilla - "+presentAddress.getUpzilla().getId().longValue());
//
//		fgLicense = _fgLicenseLocalService.getFGLicenseForApplicationNumber(fgApplicationNo);
//		if(Validator.isNotNull(fgLicense)) {
//			fgLicenseVersion = FGLicenseVersionLocalServiceUtil.getRecentFGLicenseRecord(fgLicense.getNationalId(), "fgLicenseVersionId");
//
//			if(fgLicense.getStatus() == StatusConstants.STATUS_APPROVED) {
//
//				if(Validator.isNotNull(fgLicenseVersion) && fgLicenseVersion.getStatus() != StatusConstants.STATUS_PENDING) {
//
//					addressList = addressLocalService.getAddressListByClassNameAndClassPK(fgLicense.getFgLicenseId(), FGLicense.class.getName());
//					for(bd.gov.dgfood.common.services.model.Address address : addressList) {
//						if(address.getAddressType().equalsIgnoreCase(AddressConstants.ADDRESS_PERMANENT)) {
//							permanentAddressDb = address;
//						}
//					}
//
//					fgLicenseVersion = _fgLicenseVersionLocalService.addFGLicenseVersionFormData(licenseType, true, 
//							fgLicense.getFgLicenseId(), fgLicense.getApplicationNumber(), fgLicense.getNationalId(), fgLicense.getMobileNumber(), 
//							fgLicense.getDateOfBirth(), fgLicenseAccount.getTradeLicenseNumber(), fgLicenseAccount.getTradeLicenseExpiry(), 
//							fgLicenseAccount.getTaxIdentificationNo(), fgLicenseAccount.getBusinessIdentificationNo(), fgLicenseAccount.getTradeLicenseIssuerCode(), 
//							fgLicenseAccount.getTradeLicenseIssueCity(), fgLicense.getApplicantName(), (int)fgLicense.getGender(), (int)fgLicense.getMaritalStatus(), 
//							fgLicense.getEmailAddress(), fgLicense.getFatherName(), fgLicense.getMotherName(), fgLicense.getPassword(), 
//							permanentAddressDb.getRegion(), permanentAddressDb.getDistrict(), permanentAddressDb.getCityCorporationOrMunicipality(), 
//							permanentAddressDb.getUpazilla(), permanentAddressDb.getUnionOrWard(), permanentAddressDb.getVillageOrRoad(), 
//							0, permanentAddressDb.getZipCode(), permanentAddressDb.getPostOffice(), permanentAddressDb.getAddress(), 
//							presentAddress.getRegion().getId().longValue(), presentAddress.getDistrict().getId().longValue(), 
//							presentAddress.getCityCorporationOrMuncipalty().getId().longValue(), presentAddress.getUpzilla().getId().longValue(), 
//							presentAddress.getUnionOrWard().getId().longValue(), presentAddress.getVillageOrRoad(), presentAddress.getWard().getId().longValue(), 
//							presentAddress.getZipCode(), presentAddress.getPostOffice(), presentAddress.getAddress(), true, 
//							fgLicense.getFoodGrainLicenseNo(), fgLicense.getFoodGrainLicenseIssueDate(), fgLicense.getFoodGrainLicenseValidity(), 
//							StringPool.BLANK, StringPool.BLANK, null, null, null, null, null, null, null, fgLicense.getLicenseUserId(), serviceContext);
//
//				}else {
//					throw new DataValidationException("a-request-is-already-raised-for-license-update-renewal-or-duplicate-and-it-is-in-pending");
//				}
//			}else {
//				throw new DataValidationException("your-food-grain-license-registration-is-in-pending-status");
//			}
//		}else {
//			throw new NotFoundException("no-approved-food-grain-license-is-available-with-this-food-grain-license-application-no");
//		}
//
//		return _toFgLicenseVersionAccount(fgLicenseVersion, licenseType);
//	}
//
//
//	@Override
//	public FGLicenseAccount putRenewalDuplicateFGLicenseAccount(@NotNull String fgApplicationNo,
//			RenewalDuplicateFGLicenseAccount renewalDuplicateFGLicenseAccount) throws Exception {
//
//		ServiceContext serviceContext = ServiceContextFactory.getInstance(contextHttpServletRequest);
//
//		FGLicenseVersion fgLicenseVersion = null;
//		FGLicense fgLicense = null;
//		String reason = null;
//		String licenseType = StringPool.BLANK;
//		bd.gov.dgfood.common.services.model.Address permanentAddressDb = null;
//		bd.gov.dgfood.common.services.model.Address presentAddressDb = null;
//
//		List<bd.gov.dgfood.common.services.model.Address> addressList = 
//				new ArrayList<bd.gov.dgfood.common.services.model.Address>();
//
//		if(renewalDuplicateFGLicenseAccount.getLicenseType().equalsIgnoreCase(LicenseConstants.LMS_RENEWAL)) {
//			licenseType = LicenseConstants.LMS_RENEWAL;
//		}else if(renewalDuplicateFGLicenseAccount.getLicenseType().equalsIgnoreCase(LicenseConstants.LMS_DUPLICATE)){
//			licenseType = LicenseConstants.LMS_DUPLICATE;
//		}
//
//		fgLicense = _fgLicenseLocalService.getFGLicenseForApplicationNumber(fgApplicationNo);
//		if(Validator.isNotNull(fgLicense)) {
//
//			fgLicenseVersion = FGLicenseVersionLocalServiceUtil.getRecentFGLicenseRecord(fgLicense.getNationalId(), "fgLicenseVersionId");
//
//			if(fgLicense.getStatus() == StatusConstants.STATUS_APPROVED) {
//				if(Validator.isNotNull(fgLicenseVersion) && fgLicenseVersion.getStatus() != StatusConstants.STATUS_PENDING) {
//					if(Validator.isNotNull(renewalDuplicateFGLicenseAccount.getReason()) && !renewalDuplicateFGLicenseAccount.getReason().isEmpty()) {
//						reason = renewalDuplicateFGLicenseAccount.getReason();
//					}
//
//					addressList = addressLocalService.getAddressListByClassNameAndClassPK(fgLicense.getFgLicenseId(), FGLicense.class.getName());
//					for(bd.gov.dgfood.common.services.model.Address address : addressList) {
//						if(address.getAddressType().equalsIgnoreCase(AddressConstants.ADDRESS_PERMANENT)) {
//							permanentAddressDb = address;
//						}else if(address.getAddressType().equalsIgnoreCase(AddressConstants.ADDRESS_PRESENT)) {
//							presentAddressDb = address;
//						}
//					}
//
//					fgLicenseVersion = _fgLicenseVersionLocalService.addFGLicenseVersionFormData(licenseType, true, 
//							fgLicense.getFgLicenseId(), fgLicense.getApplicationNumber(), fgLicense.getNationalId(), fgLicense.getMobileNumber(), 
//							fgLicense.getDateOfBirth(), renewalDuplicateFGLicenseAccount.getTradeLicenseNumber(), renewalDuplicateFGLicenseAccount.getTradeLicenseExpiry(), 
//							fgLicense.getTaxIdentificationNumber(), fgLicense.getBusinessIdentificationNumber(), fgLicense.getTradeLicenseIssuerCode(), 
//							fgLicense.getTradeLicenseIssuerCity(), fgLicense.getApplicantName(), (int)fgLicense.getGender(), (int)fgLicense.getMaritalStatus(), 
//							fgLicense.getEmailAddress(), fgLicense.getFatherName(), fgLicense.getMotherName(), fgLicense.getPassword(), 
//							permanentAddressDb.getRegion(), permanentAddressDb.getDistrict(), permanentAddressDb.getCityCorporationOrMunicipality(), 
//							permanentAddressDb.getUpazilla(), permanentAddressDb.getUnionOrWard(), permanentAddressDb.getVillageOrRoad(), 
//							0, permanentAddressDb.getZipCode(), permanentAddressDb.getPostOffice(), permanentAddressDb.getAddress(), 
//							presentAddressDb.getRegion(), presentAddressDb.getDistrict(), presentAddressDb.getCityCorporationOrMunicipality(), 
//							presentAddressDb.getUpazilla(), presentAddressDb.getUnionOrWard(), presentAddressDb.getVillageOrRoad(), 0, 
//							presentAddressDb.getZipCode(), presentAddressDb.getPostOffice(), presentAddressDb.getAddress(), true, 
//							fgLicense.getFoodGrainLicenseNo(), fgLicense.getFoodGrainLicenseIssueDate(), fgLicense.getFoodGrainLicenseValidity(), 
//							renewalDuplicateFGLicenseAccount.getComments(), reason, null, null, null, null, null, null, null, fgLicense.getLicenseUserId(), serviceContext);
//
//				}else {
//					throw new DataValidationException("a-request-is-already-raised-for-license-update-renewal-or-duplicate-and-it-is-in-pending");
//				}
//			}else {
//				throw new DataValidationException("your-food-grain-license-registration-is-in-pending-status");
//			}
//		}else {
//			throw new NotFoundException("no-approved-food-grain-license-is-available-with-this-food-grain-license-application-no");
//		}
//		return _toFgLicenseVersionAccount(fgLicenseVersion, licenseType);
//	}
//
//	/**
//	 * To Review New, Update, Renewal & Duplicate Food Grain License Application.
//	 * @param fgApplicationNo
//	 * @param reviewFGLicenseAccount
//	 * @return FGLicenseAccount
//	 */
//	@Override
//	public FGLicenseAccount putReviewFGLicenseAccount(@NotNull String fgApplicationNo,
//			ReviewFGLicenseAccount reviewFGLicenseAccount) throws Exception {
//
//		ServiceContext serviceContext = ServiceContextFactory.getInstance(contextHttpServletRequest);
//		FGLicenseVersion fgLicenseVersion = null;
//		WorkflowTask workflowTask = null;
//		String transitionName = reviewFGLicenseAccount.getTransitionName();
//		String licenseType = reviewFGLicenseAccount.getLicenseType();
//
//		fgLicenseVersion = FGLicenseVersionLocalServiceUtil.getFGLicenseVersionForApplicationNumber(fgApplicationNo);
//		
//		if(licenseType.equalsIgnoreCase(LicenseConstants.LMS_NEW)) {
//			logger.info(reviewFGLicenseAccount);
//			workflowTask = WorflowTaskSubmissionUtil.getWorkflowTask(fgLicenseVersion.getFgLicenseId(), FGLicense.class.getName());
//		}else if(licenseType.equalsIgnoreCase(LicenseConstants.LMS_UPDATE) || licenseType.equalsIgnoreCase(LicenseConstants.LMS_RENEWAL) || 
//				licenseType.equalsIgnoreCase(LicenseConstants.LMS_DUPLICATE)){
//			workflowTask = WorflowTaskSubmissionUtil.getWorkflowTask(fgLicenseVersion.getFgLicenseVersionId(), FGLicenseVersion.class.getName());
//		}
//
//		if(Validator.isNotNull(workflowTask)) {
//
//			Map<String, Serializable> workflowContext = _getWorkflowContext(serviceContext.getCompanyId(), workflowTask.getWorkflowTaskId());
//
//			WorkflowTaskManagerUtil.completeWorkflowTask(serviceContext.getCompanyId(), workflowTask.getAssigneeUserId(), workflowTask.getWorkflowTaskId(),
//					transitionName, reviewFGLicenseAccount.getComment(), workflowContext);
//
//			return _toFgLicenseVersionAccount(fgLicenseVersion, licenseType);
//
//		}else {
//			throw new DataValidationException("no-workflow-is-active-for-this-food-grain-license-id");
//		}
//
//	}
//
//	private FGLicenseAccount _toFgLicenseVersionAccount(FGLicenseVersion fgLicenseVersion, String licenseType) throws Exception {
//
//		if(Validator.isNotNull(fgLicenseVersion)) {
//			List<Address> headlessAddressList = getAddressList(fgLicenseVersion);
//
//			if(licenseType.equalsIgnoreCase(LicenseConstants.LMS_NEW) || licenseType.equalsIgnoreCase(LicenseConstants.LMS_UPDATE)) {
//				return new FGLicenseAccount() {
//					{
//						id = fgLicenseVersion.getFgLicenseId();
//						applicantNid = Long.valueOf(fgLicenseVersion.getNationalId());
//						applicantMobileNumber = fgLicenseVersion.getMobileNumber();
//						dateOfBirth = fgLicenseVersion.getDateOfBirth();
//						emailAddress = fgLicenseVersion.getEmailAddress();
//						applicantName = fgLicenseVersion.getApplicantName();
//						applicantFathersName = fgLicenseVersion.getFatherName();
//						applicantMothersName = fgLicenseVersion.getMotherName();
//						applicantGender = (int)fgLicenseVersion.getGender();
//						maritalStatus = (int)fgLicenseVersion.getMaritalStatus();
//						tradeLicenseNumber = fgLicenseVersion.getTradeLicenseNumber();
//						tradeLicenseExpiry = fgLicenseVersion.getTradeLicenseValidity();
//						taxIdentificationNo = fgLicenseVersion.getTaxIdentificationNumber();
//						businessIdentificationNo = fgLicenseVersion.getBusinessIdentificationNumber();
//						tradeLicenseIssuerCode = fgLicenseVersion.getTradeLicenseIssuerCode();
//						tradeLicenseIssueCity = fgLicenseVersion.getTradeLicenseIssuerCity();
//						fgApplicationNo = fgLicenseVersion.getApplicationNumber();
//						fgLicenseNo = fgLicenseVersion.getFoodGrainLicenseNo();
//						foodGrainLicenseIssueDate = fgLicenseVersion.getFoodGrainLicenseIssueDate();
//						fgLicenseExpiry = fgLicenseVersion.getFoodGrainLicenseValidity();
//						applicationStatus = fgLicenseVersion.getStatus();
//						version = fgLicenseVersion.getVersion();
//						createdBy = fgLicenseVersion.getCreatedBy();
//						modifiedBy = fgLicenseVersion.getModifiedBy();
//						createdDate = fgLicenseVersion.getCreateDate();
//						modifiedDate = fgLicenseVersion.getModifiedDate();
//
//						if(Validator.isNotNull(headlessAddressList) && headlessAddressList.size() > 0) {
//							for(Address address : headlessAddressList) {
//								if(address.getAddressType().equalsIgnoreCase(AddressConstants.ADDRESS_PERMANENT)) {
//									permanentAddress = address;
//								}else if(address.getAddressType().equalsIgnoreCase(AddressConstants.ADDRESS_PRESENT)) {
//									presentAddress = address;
//								}
//							}
//						}
//					}
//				};
//
//			}else {
//				return new FGLicenseAccount() {
//					{
//						id = fgLicenseVersion.getFgLicenseVersionId();
//						tradeLicenseNumber = fgLicenseVersion.getTradeLicenseNumber();
//						tradeLicenseExpiry = fgLicenseVersion.getTradeLicenseValidity();
//						fgApplicationNo = fgLicenseVersion.getApplicationNumber();
//						applicationStatus = fgLicenseVersion.getStatus();
//						createdDate = fgLicenseVersion.getCreateDate();
//						if(Validator.isNotNull(fgLicenseVersion.getReason()) && !fgLicenseVersion.getReason().isEmpty()) {
//							reason = fgLicenseVersion.getReason();
//						}
//					}
//				};
//			}
//		}else {
//			throw new NotFoundException("issue-occured-while-sending-the-response");
//		}
//	}
//
//	private FGLicenseAccount _toFgLicenseAccount(FGLicense fgLicense) throws Exception {
//
//		if(Validator.isNotNull(fgLicense)) {
//
//			bd.gov.dgfood.common.services.model.Address permanentAddressDb = null;
//			Address permanentAddressObj = new Address();
//			Location permanentRegion = new Location();
//			Location permanentDistrict = new Location();
//			Location permanentUpazilla = new Location();
//			Location permanentCityCorporationOrMuncipalty = new Location();
//			Location permanentUnionOrWard = new Location();
//
//			bd.gov.dgfood.common.services.model.Address presentAddressDb = null;
//			Address presentAddressObj = new Address();
//			Location presentRegion = new Location();
//			Location presentDistrict = new Location();
//			Location presentUpazilla = new Location();
//			Location presentCityCorporationOrMuncipalty = new Location();
//			Location presentUnionOrWard = new Location();
//
//			List<bd.gov.dgfood.common.services.model.Address> addressList = 
//					new ArrayList<bd.gov.dgfood.common.services.model.Address>();
//
//			// Get address
//			addressList = addressLocalService.getAddressListByClassNameAndClassPK(fgLicense.getFgLicenseId(), FGLicense.class.getName());
//			for(bd.gov.dgfood.common.services.model.Address address : addressList) {
//				if(address.getAddressType().equalsIgnoreCase(AddressConstants.ADDRESS_PERMANENT)) {
//					permanentAddressDb = address;
//
//					permanentRegion.setId(permanentAddressDb.getRegion());
//					permanentRegion.setValue(CategoryUtil.fetchCategoryNamebyCategoryId(permanentAddressDb.getRegion(), Locale.ENGLISH));
//					permanentAddressObj.setRegion(permanentRegion);
//
//					permanentDistrict.setId(permanentAddressDb.getDistrict());
//					permanentDistrict.setValue(CategoryUtil.fetchCategoryNamebyCategoryId(permanentAddressDb.getDistrict(), Locale.ENGLISH));
//					permanentAddressObj.setDistrict(permanentDistrict);
//
//					permanentUpazilla.setId(permanentAddressDb.getUpazilla());
//					permanentUpazilla.setValue(CategoryUtil.fetchCategoryNamebyCategoryId(permanentAddressDb.getUpazilla(), Locale.ENGLISH));
//					permanentAddressObj.setUpzilla(permanentUpazilla);
//
//					//					permanentCityCorporationOrMuncipalty.setId(permanentAddressDb.getCityCorporationOrMunicipality());
//					//					permanentCityCorporationOrMuncipalty.setValue(CategoryUtil.fetchCategoryNamebyCategoryId(permanentAddressDb.getCityCorporationOrMunicipality(), Locale.ENGLISH));
//					//					permanentAddressObj.setCityCorporationOrMuncipalty(permanentCityCorporationOrMuncipalty);
//
//					permanentUnionOrWard.setId(permanentAddressDb.getUnionOrWard());
//					permanentUnionOrWard.setValue(CategoryUtil.fetchCategoryNamebyCategoryId(permanentAddressDb.getUnionOrWard(), Locale.ENGLISH));
//					permanentAddressObj.setUnionOrWard(permanentUnionOrWard);
//
//					permanentAddressObj.setVillageOrRoad(permanentAddressDb.getVillageOrRoad());
//					permanentAddressObj.setZipCode(permanentAddressDb.getZipCode());
//					permanentAddressObj.setPostOffice(permanentAddressDb.getPostOffice());
//					permanentAddressObj.setAddress(permanentAddressDb.getAddress());
//
//				}else if(address.getAddressType().equalsIgnoreCase(AddressConstants.ADDRESS_PRESENT)) {
//					presentAddressDb = address;
//
//					presentRegion.setId(presentAddressDb.getRegion());
//					presentRegion.setValue(CategoryUtil.fetchCategoryNamebyCategoryId(presentAddressDb.getRegion(), Locale.ENGLISH));
//					presentAddressObj.setRegion(presentRegion);
//
//					presentDistrict.setId(presentAddressDb.getDistrict());
//					presentDistrict.setValue(CategoryUtil.fetchCategoryNamebyCategoryId(presentAddressDb.getDistrict(), Locale.ENGLISH));
//					presentAddressObj.setDistrict(presentDistrict);
//
//					presentUpazilla.setId(presentAddressDb.getUpazilla());
//					presentUpazilla.setValue(CategoryUtil.fetchCategoryNamebyCategoryId(presentAddressDb.getUpazilla(), Locale.ENGLISH));
//					presentAddressObj.setUpzilla(presentUpazilla);
//
//					//					presentCityCorporationOrMuncipalty.setId(presentAddressDb.getCityCorporationOrMunicipality());
//					//					presentCityCorporationOrMuncipalty.setValue(CategoryUtil.fetchCategoryNamebyCategoryId(presentAddressDb.getCityCorporationOrMunicipality(), Locale.ENGLISH));
//					//					presentAddressObj.setCityCorporationOrMuncipalty(presentCityCorporationOrMuncipalty);
//
//					presentUnionOrWard.setId(presentAddressDb.getUnionOrWard());
//					presentUnionOrWard.setValue(CategoryUtil.fetchCategoryNamebyCategoryId(presentAddressDb.getUnionOrWard(), Locale.ENGLISH));
//					presentAddressObj.setUnionOrWard(presentUnionOrWard);
//
//					presentAddressObj.setVillageOrRoad(presentAddressDb.getVillageOrRoad());
//					presentAddressObj.setZipCode(presentAddressDb.getZipCode());
//					presentAddressObj.setPostOffice(presentAddressDb.getPostOffice());
//					presentAddressObj.setAddress(presentAddressDb.getAddress());
//				}
//			}
//
//			return new FGLicenseAccount() {
//				{
//					id = fgLicense.getFgLicenseId();
//					applicantNid = Long.valueOf(fgLicense.getNationalId());
//					applicantMobileNumber = fgLicense.getMobileNumber();
//					dateOfBirth = fgLicense.getDateOfBirth();
//					emailAddress = fgLicense.getEmailAddress();
//					applicantName = fgLicense.getApplicantName();
//					applicantFathersName = fgLicense.getFatherName();
//					applicantMothersName = fgLicense.getMotherName();
//					applicantGender = (int)fgLicense.getGender();
//					maritalStatus = (int)fgLicense.getMaritalStatus();
//					tradeLicenseNumber = fgLicense.getTradeLicenseNumber();
//					tradeLicenseExpiry = fgLicense.getTradeLicenseValidity();
//					taxIdentificationNo = fgLicense.getTaxIdentificationNumber();
//					businessIdentificationNo = fgLicense.getBusinessIdentificationNumber();
//					tradeLicenseIssuerCode = fgLicense.getTradeLicenseIssuerCode();
//					tradeLicenseIssueCity = fgLicense.getTradeLicenseIssuerCity();
//					fgApplicationNo = fgLicense.getApplicationNumber();
//					fgLicenseNo = fgLicense.getFoodGrainLicenseNo();
//					foodGrainLicenseIssueDate = fgLicense.getFoodGrainLicenseIssueDate();
//					fgLicenseExpiry = fgLicense.getFoodGrainLicenseValidity();
//					applicationStatus = fgLicense.getStatus();
//					version = fgLicense.getVersion();
//					createdBy = fgLicense.getCreatedBy();
//					modifiedBy = fgLicense.getModifiedBy();
//					createdDate = fgLicense.getCreateDate();
//					modifiedDate = fgLicense.getModifiedDate();
//
//					permanentAddress = permanentAddressObj;
//					presentAddress = presentAddressObj;
//				}
//			};
//
//		}else {
//			throw new NotFoundException("issue-occured-while-sending-the-response");
//		}
//		// Get attachments
//	}
//
//	private Map<String, Serializable> _getWorkflowContext(long companyId, long workflowTaskId) throws Exception {
//
//		WorkflowTask workflowTask = WorkflowTaskManagerUtil.getWorkflowTask(companyId, workflowTaskId);
//
//		WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(companyId,
//				workflowTask.getWorkflowInstanceId());
//
//		return workflowInstance.getWorkflowContext();
//	}
//
//	private List<Address> getAddressList(FGLicenseVersion fgLicenseVersion){
//
//		List<Address> headlessAddressList = new ArrayList<Address>();
//
//		bd.gov.dgfood.common.services.model.AddressVersion permanentAddressDb = null;
//		Address permanentAddressObj = new Address();
//		Location permanentRegion = new Location();
//		Location permanentDistrict = new Location();
//		Location permanentUpazilla = new Location();
//		Location permanentCityCorporationOrMuncipalty = new Location();
//		Location permanentUnionOrWard = new Location();
//
//		bd.gov.dgfood.common.services.model.AddressVersion presentAddressDb = null;
//		Address presentAddressObj = new Address();
//		Location presentRegion = new Location();
//		Location presentDistrict = new Location();
//		Location presentUpazilla = new Location();
//		Location presentCityCorporationOrMuncipalty = new Location();
//		Location presentUnionOrWard = new Location();
//
//		List<bd.gov.dgfood.common.services.model.AddressVersion> addressList = 
//				new ArrayList<bd.gov.dgfood.common.services.model.AddressVersion>();
//
//		try {
//
//			// Get address
//			addressList = addressVersionLocalService.getAddressVersionsByClassNameAndClassPK(fgLicenseVersion.getPrimaryKey(), FGLicenseVersion.class.getName());
//			for(bd.gov.dgfood.common.services.model.AddressVersion address : addressList) {
//				if(address.getAddressType().equalsIgnoreCase(AddressConstants.ADDRESS_PERMANENT)) {
//					permanentAddressDb = address;
//
//					permanentRegion.setId(permanentAddressDb.getRegion());
//					permanentRegion.setValue(CategoryUtil.fetchCategoryNamebyCategoryId(permanentAddressDb.getRegion(), Locale.ENGLISH));
//					permanentAddressObj.setRegion(permanentRegion);
//
//					permanentDistrict.setId(permanentAddressDb.getDistrict());
//					permanentDistrict.setValue(CategoryUtil.fetchCategoryNamebyCategoryId(permanentAddressDb.getDistrict(), Locale.ENGLISH));
//					permanentAddressObj.setDistrict(permanentDistrict);
//
//					permanentUpazilla.setId(permanentAddressDb.getUpazilla());
//					permanentUpazilla.setValue(CategoryUtil.fetchCategoryNamebyCategoryId(permanentAddressDb.getUpazilla(), Locale.ENGLISH));
//					permanentAddressObj.setUpzilla(permanentUpazilla);
//
//					//					permanentCityCorporationOrMuncipalty.setId(permanentAddressDb.getCityCorporationOrMunicipality());
//					//					permanentCityCorporationOrMuncipalty.setValue(CategoryUtil.fetchCategoryNamebyCategoryId(permanentAddressDb.getCityCorporationOrMunicipality(), Locale.ENGLISH));
//					//					permanentAddressObj.setCityCorporationOrMuncipalty(permanentCityCorporationOrMuncipalty);
//
//					permanentUnionOrWard.setId(permanentAddressDb.getUnionOrWard());
//					permanentUnionOrWard.setValue(CategoryUtil.fetchCategoryNamebyCategoryId(permanentAddressDb.getUnionOrWard(), Locale.ENGLISH));
//					permanentAddressObj.setUnionOrWard(permanentUnionOrWard);
//
//					permanentAddressObj.setVillageOrRoad(permanentAddressDb.getVillageOrRoad());
//					permanentAddressObj.setZipCode(permanentAddressDb.getZipCode());
//					permanentAddressObj.setPostOffice(permanentAddressDb.getPostOffice());
//					permanentAddressObj.setAddress(permanentAddressDb.getAddress());
//					permanentAddressObj.setAddressType(permanentAddressDb.getAddressType());
//
//					headlessAddressList.add(permanentAddressObj);
//
//				}else if(address.getAddressType().equalsIgnoreCase(AddressConstants.ADDRESS_PRESENT)) {
//					presentAddressDb = address;
//
//					presentRegion.setId(presentAddressDb.getRegion());
//					presentRegion.setValue(CategoryUtil.fetchCategoryNamebyCategoryId(presentAddressDb.getRegion(), Locale.ENGLISH));
//					presentAddressObj.setRegion(presentRegion);
//
//					presentDistrict.setId(presentAddressDb.getDistrict());
//					presentDistrict.setValue(CategoryUtil.fetchCategoryNamebyCategoryId(presentAddressDb.getDistrict(), Locale.ENGLISH));
//					presentAddressObj.setDistrict(presentDistrict);
//
//					presentUpazilla.setId(presentAddressDb.getUpazilla());
//					presentUpazilla.setValue(CategoryUtil.fetchCategoryNamebyCategoryId(presentAddressDb.getUpazilla(), Locale.ENGLISH));
//					presentAddressObj.setUpzilla(presentUpazilla);
//
//					//					presentCityCorporationOrMuncipalty.setId(presentAddressDb.getCityCorporationOrMunicipality());
//					//					presentCityCorporationOrMuncipalty.setValue(CategoryUtil.fetchCategoryNamebyCategoryId(presentAddressDb.getCityCorporationOrMunicipality(), Locale.ENGLISH));
//					//					presentAddressObj.setCityCorporationOrMuncipalty(presentCityCorporationOrMuncipalty);
//
//					presentUnionOrWard.setId(presentAddressDb.getUnionOrWard());
//					presentUnionOrWard.setValue(CategoryUtil.fetchCategoryNamebyCategoryId(presentAddressDb.getUnionOrWard(), Locale.ENGLISH));
//					presentAddressObj.setUnionOrWard(presentUnionOrWard);
//
//					presentAddressObj.setVillageOrRoad(presentAddressDb.getVillageOrRoad());
//					presentAddressObj.setZipCode(presentAddressDb.getZipCode());
//					presentAddressObj.setPostOffice(presentAddressDb.getPostOffice());
//					presentAddressObj.setAddress(presentAddressDb.getAddress());
//					presentAddressObj.setAddressType(presentAddressDb.getAddressType());
//
//					headlessAddressList.add(presentAddressObj);
//				}
//			}
//
//		}catch(Exception exception) {
//			exception.printStackTrace();
//		}
//		return headlessAddressList;
//	}
//
//	private Log logger = LogFactoryUtil.getLog(this.getClass());
//
//	@Reference
//	FGLicenseLocalService _fgLicenseLocalService;
//
//	@Reference
//	FGLicenseVersionLocalService _fgLicenseVersionLocalService;
//
//	@Reference
//	AddressLocalService addressLocalService;
//
//	@Reference
//	AddressVersionLocalService addressVersionLocalService;
//
//	@Reference
//	private Portal _portal;
//}