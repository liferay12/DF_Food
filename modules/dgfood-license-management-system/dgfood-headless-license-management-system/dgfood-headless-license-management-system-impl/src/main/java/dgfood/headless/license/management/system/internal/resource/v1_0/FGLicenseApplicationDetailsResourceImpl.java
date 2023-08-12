package dgfood.headless.license.management.system.internal.resource.v1_0;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;

import java.util.Collection;
import java.util.Date;

import javax.validation.Valid;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import bd.gov.dgfood.common.services.model.APIAudit;
import dgfood.headless.license.management.system.dto.v1_0.Address;
import bd.gov.dgfood.common.services.service.APIAuditLocalService;
import bd.gov.dgfood.common.services.service.AddressLocalService;
import bd.gov.dgfood.common.services.service.AddressVersionLocalService;
import bd.gov.dgfood.common.services.service.AttachmentLocalService;
import bd.gov.dgfood.common.services.service.AttachmentVersionLocalService;
import bd.gov.dgfood.license.management.system.model.FGLicenseInfo;
import bd.gov.dgfood.license.management.system.service.FGLicenseInfoLocalService;
import dgfood.headless.license.management.system.dto.v1_0.FGLicenseApplicationDetails;
import dgfood.headless.license.management.system.dto.v1_0.NewFGLicenseApplication;
import dgfood.headless.license.management.system.dto.v1_0.ResponseDetails;
import dgfood.headless.license.management.system.resource.v1_0.FGLicenseApplicationDetailsResource;

/**
 * @author Liferay
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0/fg-license-application-details.properties", scope = ServiceScope.PROTOTYPE, service = FGLicenseApplicationDetailsResource.class)
public class FGLicenseApplicationDetailsResourceImpl extends BaseFGLicenseApplicationDetailsResourceImpl {

	@Override
	public void setContextBatchUnsafeConsumer(
			UnsafeBiConsumer<Collection<FGLicenseApplicationDetails>, UnsafeConsumer<FGLicenseApplicationDetails, Exception>, Exception> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public ResponseDetails postFglicenseApplication(NewFGLicenseApplication newFGLicenseApplication) throws Exception {

		Date requestTime = new Date();
		long userId = PrincipalThreadLocal.getUserId();
		ResponseDetails responseDetails = new ResponseDetails();
		APIAudit apiAudit = null;
		long requestClassPK = 0;
		String applicationNumber;
		FGLicenseInfo fgLicense = null;
		 Address permanentAddress = newFGLicenseApplication.getPermanentAddress();
		 Address presentAddress =  newFGLicenseApplication.getPresentAddress();
		 Address businessAddress = newFGLicenseApplication.getBusinessAddress();
		ServiceContext serviceContext = ServiceContextFactory.getInstance(contextHttpServletRequest);

		try {
			fgLicense = fgLicenseInfoLocalService.addFGLicenseFormData(

					String.valueOf(newFGLicenseApplication.getApplicantNationalId()),
					newFGLicenseApplication.getApplicantMobileNumber(), newFGLicenseApplication.getDateOfBirth(),
					newFGLicenseApplication.getEmailAddress(), newFGLicenseApplication.getPassword(),
					newFGLicenseApplication.getApplicantName(), newFGLicenseApplication.getApplicantGender().intValue(),
					newFGLicenseApplication.getMaritalStatus().intValue(),
					newFGLicenseApplication.getApplicantFathersName(),
					newFGLicenseApplication.getApplicantMothersName(), newFGLicenseApplication.getTradeLicenseNumber(),
					newFGLicenseApplication.getTradeLicenseExpiry(), newFGLicenseApplication.getTaxIdentificationNo(),
					newFGLicenseApplication.getBusinessIdentificationNo(),
					newFGLicenseApplication.getTradeLicenseIssuerCode(),
					newFGLicenseApplication.getTradeLicenseIssueCity(),
					permanentAddress.getRegion().getId().longValue(),
					permanentAddress.getDistrict().getId().longValue(),
					permanentAddress.getUpzilla().getId().longValue(),
					permanentAddress.getCityCorporationOrMuncipalty().getId().longValue(),
					permanentAddress.getUnionOrWard().getId().longValue(), permanentAddress.getZipCode(),
					permanentAddress.getPostOffice(), permanentAddress.getVillageOrRoad(),
					permanentAddress.getMouzaOrMoholla(), permanentAddress.getAddress(),
					presentAddress.getRegion().getId().longValue(), presentAddress.getDistrict().getId().longValue(),
					presentAddress.getUpzilla().getId().longValue(),
					presentAddress.getCityCorporationOrMuncipalty().getId().longValue(),
					presentAddress.getUnionOrWard().getId().longValue(), presentAddress.getZipCode(),
					presentAddress.getPostOffice(), presentAddress.getVillageOrRoad(),
					presentAddress.getMouzaOrMoholla(), presentAddress.getAddress(),
					newFGLicenseApplication.getBusinessName(), newFGLicenseApplication.getBusinessType(),
					businessAddress.getRegion().getId().longValue(), businessAddress.getDistrict().getId().longValue(),
					businessAddress.getUpzilla().getId().longValue(),
					businessAddress.getCityCorporationOrMuncipalty().getId().longValue(),
					businessAddress.getUnionOrWard().getId().longValue(), businessAddress.getZipCode(),
					businessAddress.getPostOffice(), businessAddress.getVillageOrRoad(),
					businessAddress.getMouzaOrMoholla(), businessAddress.getAddress(), 1, 2, 3, 4, 5, serviceContext);

			requestClassPK = fgLicense.getFgLicenseInfoId();
			applicationNumber = fgLicense.getApplicationNumber();
			responseDetails.setApiStatus(true);
			responseDetails.setMsg("success");

			responseDetails.setData(applicationNumber);

		} catch (Exception e) { // TODO Auto-generated catch block e.printStackTrace();

			responseDetails.setApiStatus(false);
			;
			responseDetails.setMsg("failed");
			responseDetails.setTitle("details  failed to enter successfully");

		}

		Date responseTime = new Date();

		String sender = "MobileAPP";
		String receiver = "Portal";
		String requestPayload = newFGLicenseApplication.toString();
		String responsePayload = responseDetails.toString();
		String requestClassName = FGLicenseInfo.class.getName();
		boolean bulkRequest = false;

		apiAuditLocalService.updateApiAuditData("title", "description", sender, receiver, requestPayload,
				responsePayload, requestClassName, requestClassPK, bulkRequest, requestTime, responseTime, userId);

		logger.info(fgLicense.getFgLicenseInfoId());

		return responseDetails;
	}

	private Log logger = LogFactoryUtil.getLog(this.getClass());

	@Reference
	APIAuditLocalService apiAuditLocalService;

	@Reference
	FGLicenseInfoLocalService fgLicenseInfoLocalService;

	@Reference
	AddressLocalService addressLocalService;

	@Reference
	AddressVersionLocalService addressVersionLocalService;

	@Reference
	AttachmentLocalService attachmentLocalService;

	@Reference
	AttachmentVersionLocalService attachmentVersionLocalService;

}
