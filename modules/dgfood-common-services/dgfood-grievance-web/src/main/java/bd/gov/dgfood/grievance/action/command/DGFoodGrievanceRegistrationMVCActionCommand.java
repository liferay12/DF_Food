package bd.gov.dgfood.grievance.action.command;

import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.common.services.model.Grievance;
import bd.gov.dgfood.common.services.service.GrievanceLocalServiceUtil;
import bd.gov.dgfood.common.util.DLUploadUtil;
import bd.gov.dgfood.common.util.constants.FileConstants;
import bd.gov.dgfood.common.util.constants.ParameterConstants;
import bd.gov.dgfood.grievance.constants.DgfoodGrievanceWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + DgfoodGrievanceWebPortletKeys.DGFOODGRIEVANCEWEB,
		"mvc.command.name=/grievance/register" }, service = MVCActionCommand.class)

//This class is used to perform actions regarding grievances registration 
public class DGFoodGrievanceRegistrationMVCActionCommand extends BaseMVCActionCommand {

	//This method is used to Add Grievances data 
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		try {

			ServiceContext serviceContext = ServiceContextFactory
					.getInstance(DGFoodGrievanceRegistrationMVCActionCommand.class.getName(), actionRequest);

			long grievanceCategory = ParamUtil.getLong(actionRequest, ParameterConstants.GRIEVANCE_CATEGORY);
			long userType = ParamUtil.getLong(actionRequest, ParameterConstants.GRIEVANCE_USER_TYPE);
			String userName = ParamUtil.getString(actionRequest, ParameterConstants.GRIEVANCE_USER_NAME);
			String mobileNumber = ParamUtil.getString(actionRequest, ParameterConstants.MOBILE_NUMBER);
			String complaintDetails = ParamUtil.getString(actionRequest, ParameterConstants.GRIEVANCE_DETAILS);

			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			String attachment = uploadPortletRequest.getFileName(ParameterConstants.ATTACHMENTS);

			_log.info("grievanceCategory - " + grievanceCategory + " - " + " userType" + userType + " userName - "
					+ userName + " mobileNumber - " + mobileNumber);
			_log.info("complaintDetails - " + complaintDetails);

			if (Validator.isNotNull(grievanceCategory) && Validator.isNotNull(userType)
					&& Validator.isNotNull(mobileNumber) && Validator.isNotNull(complaintDetails) && Validator.isNotNull(attachment)) {
				
				// Create UserId folder in root folder
				Folder parentFolder = DLUploadUtil.createFolder(serviceContext, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
						String.valueOf(serviceContext.getUserId()));

				// create attachments folder
				Folder folder = DLUploadUtil.createFolder(serviceContext, parentFolder.getFolderId(), ParameterConstants.ATTACHMENTS);

				// upload file in profile folder
				long fileEntryId = DLUploadUtil.fileUpload(serviceContext, actionRequest, folder.getFolderId(), ParameterConstants.ATTACHMENTS, ParameterConstants.ATTACHMENTS,
						FileConstants.SIX_MB);
				if (fileEntryId != 0) {
					Grievance grievance = GrievanceLocalServiceUtil.addGrievance(serviceContext, grievanceCategory, userName, userType,
							mobileNumber, complaintDetails, fileEntryId);
					actionRequest.setAttribute(ParameterConstants.APPLICATION_NUMBER, grievance.getGrievanceNumber());

				}
			}
			SessionMessages.add(actionRequest, "grievance-submitted-successfully");
		} catch (Exception e) {
			e.printStackTrace();
			_log.error("Error - " + e.getMessage());
			SessionMessages.add(actionRequest, "grievance-submission-failed");
		}

	}

	private static final Log _log = LogFactoryUtil.getLog(DGFoodGrievanceRegistrationMVCActionCommand.class);
}
