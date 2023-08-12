package bd.gov.dgfood.foodgrain.license.renders;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.common.services.model.AttachmentVersion;
import bd.gov.dgfood.common.services.service.AddressLocalServiceUtil;
import bd.gov.dgfood.common.services.service.AddressVersionLocalService;
import bd.gov.dgfood.common.services.service.AttachmentVersionLocalService;
import bd.gov.dgfood.common.util.DateFormatterUtil;
import bd.gov.dgfood.common.util.constants.DocumentLibraryConstants;
import bd.gov.dgfood.foodgrain.license.constants.FoodGrainLicensePortletKeys;
import bd.gov.dgfood.license.management.system.model.FGLicenseInfo;
import bd.gov.dgfood.license.management.system.service.FGLicenseInfoLocalService;

/**
 * This class is referred while checking status of food grain license application.
 * This class is used to fetch FG licenses with application number, date of birth and NID and show it to end user. 
 * 
 */

@Component(immediate = true,
property = {
		"javax.portlet.name=" + FoodGrainLicensePortletKeys.FOODGRAINLICENSE,
		"javax.portlet.name=" + FoodGrainLicensePortletKeys.HOMESCREENFGLICENSE,
		"mvc.command.name=" + FoodGrainLicensePortletKeys.FG_LICENSE_STATUS_MVC_RENDER_COMMAND 
},
service = MVCRenderCommand.class
		)
public class FGLicenseStatusMVCRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		logger.info("Entered FGLicenseApplicationStatusMVCRenderCommand");

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(FGLicenseInfo.class.getName(), renderRequest);
			//Food Grain License Fields
			String nationalId = ParamUtil.getString(renderRequest, "nationalId");
			String applicationNumber = ParamUtil.getString(renderRequest, "applicationNumber");
			String dateOfBirth = ParamUtil.getString(renderRequest, "dateOfBirth");
			Date parsedDateOfBirth = DateFormatterUtil.parseDate(dateOfBirth);

			//String cmd = ParamUtil.getString(renderRequest, Constants.CMD);
			logger.info("nationalId----------->"+nationalId);
			logger.info("applicationNumber----------->"+applicationNumber);
			logger.info("dateOfBirth----------->"+dateOfBirth);

			User user = UserLocalServiceUtil.fetchUserByScreenName(serviceContext.getCompanyId(), nationalId);
			//if(Validator.isNotNull(cmd) && cmd.equalsIgnoreCase("Uploaded")) {
			FGLicenseInfo fgLicenseInfo = fgLicenseInfoLocalService.fetchFGLicenseWithApplicationNumberNIDDateOfBirth(serviceContext, applicationNumber, nationalId, parsedDateOfBirth);

			//}

			//List<AttachmentVersion>	attachmentList = attachmentVersionLocalService.getAttachmentVersionsByClassPKAndClassName(fgLicenseInfo.getPrimaryKey(), FGLicenseInfo.class.getName());
				
			if(Validator.isNull(fgLicenseInfo)) {
				// return that no fg license exists
				SessionErrors.add(renderRequest, "error-label-no-fglicense-found");
				return "/jsp/fglicense_status_check/fglicense_input.jsp";
			}
			
			// Check if attachment is empty
			/*if(Validator.isNotNull(attachmentList) && !attachmentList.isEmpty()) {
				for(AttachmentVersion attachment : attachmentList) {
					if(attachment.getCategory().equalsIgnoreCase(DocumentLibraryConstants.CHALLAN_DOC)) {
						AttachmentVersion challanAttachment = attachment;
						renderRequest.setAttribute("challanAttachment", challanAttachment);
					}
				}
			}*/

			renderRequest.setAttribute("fgUser", user);
			renderRequest.setAttribute("fgLicenseInfo", fgLicenseInfo);
			
			//renderRequest.setAttribute("attachmentList", attachmentList);

			return "/jsp/fglicense_status_check/fglicense_status_details.jsp";

		} catch (Exception exception) {
			logger.error(exception.getMessage());
			exception.printStackTrace();
			if (logger.isDebugEnabled()) {
				exception.printStackTrace();
			}
			renderRequest.setAttribute("errorKey", exception.getMessage());
			SessionErrors.add(renderRequest, exception.getClass());
			return "/jsp/fglicense_status_check/fglicense_input.jsp";
		}
	}

	/*protected FGLicense getFgLicenseVersion(String applicationNumber, String nationalId,
			Date dateOfBirth) throws DataValidationException {

		FGLicenseVersion fgLicenseVersion = null;

		if(Validator.isNull(dateOfBirth)) {
			throw new DataValidationException("error-label-date-of-birth-can-not-be-blank");
		}else if(Validator.isNull(nationalId)) {
			throw new DataValidationException("error-label-national-id-can-not-be-blank");
		}else if(Validator.isNull(applicationNumber)) {
			throw new DataValidationException("error-label-application-number-can-not-be-blank");
		}
		
		Date before18YearsDate = Date
				.from(LocalDate.now().minusYears(18).atStartOfDay(ZoneId.systemDefault()).toInstant());
		FormValidator.validateInput(dateOfBirth, ParameterConstants.DATE_OF_BIRTH, true, null, before18YearsDate);
		FormValidator.validateNationalId(nationalId, true, ParameterConstants.NATIONAL_ID);
		FormValidator.validateInput(applicationNumber, ParameterLabelConstants.LABEL_APPLICATION_NUMBER, true, 0, 0, null);
		
		fgLicenseVersion = fgLicenseInfoLocalService.getFGLicenseVersionForApplicationNumber(applicationNumber);
		return fgLicenseVersion;
	}*/

	private Log logger = LogFactoryUtil.getLog(this.getClass());

	@Reference 
	protected FGLicenseInfoLocalService fgLicenseInfoLocalService;

	@Reference 
	protected AddressVersionLocalService addressVersionLocalService;

	@Reference 
	protected AttachmentVersionLocalService attachmentVersionLocalService;

}