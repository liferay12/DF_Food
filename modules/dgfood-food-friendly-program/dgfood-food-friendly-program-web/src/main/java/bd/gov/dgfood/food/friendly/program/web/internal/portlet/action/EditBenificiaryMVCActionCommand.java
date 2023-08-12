package bd.gov.dgfood.food.friendly.program.web.internal.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.vulcan.multipart.BinaryFile;

import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.common.util.DLUploadUtil;
import bd.gov.dgfood.common.util.constants.FileConstants;
import bd.gov.dgfood.food.friendly.program.constants.FoodFriendlyProgramPortletKeys;
import bd.gov.dgfood.food.friendly.program.service.FFPBeneficiaryLocalService;
import bd.gov.dgfood.food.friendly.program.service.FFPBeneficiaryVersionLocalService;

/**
 * FFPB Registration as well as update class by UC
 * 
 * @author krishna
 *
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + FoodFriendlyProgramPortletKeys.FOOD_FRIENDLY_PROGRAM_ADMIN,
		"mvc.command.name=/ffpb_registration/add_entry",
		"mvc.command.name=/ffpb_registration/edit_entry" }, service = MVCActionCommand.class)
public class EditBenificiaryMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		addFFPBeneficiary(actionRequest, actionResponse);

	}

	/**
	 * FFPB registration and updation method
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void addFFPBeneficiary(ActionRequest request, ActionResponse response) throws Exception {

		try {

			// NID Details
			long nationalId = ParamUtil.getLong(request, "nationalId");
			// String dateOfBirth = ParamUtil.getString(request, "dateOfBirth");
			Date dateOfBirth = ParamUtil.getDate(request, "dateOfBirth",
					DateFormatFactoryUtil.getSimpleDateFormat("dd/MM/yyyy"), null);
			String mobileNumber = ParamUtil.getString(request, "mobileNumber");
			String emailAddress = ParamUtil.getString(request, "emailAddress");

			// Basic info
			String name = ParamUtil.getString(request, "name");
			String fatherName = ParamUtil.getString(request, "fatherName");
			String motherName = ParamUtil.getString(request, "motherName");
			int gender = ParamUtil.getInteger(request, "gender");

			// Permanent Address
			long permanentRegion = ParamUtil.getLong(request, "permanentRegion");
			long permanentZilla = ParamUtil.getLong(request, "permanentZilla");
			long permanentUpazilla = ParamUtil.getLong(request, "permanentUpazilla");
			long permanentUnion = ParamUtil.getLong(request, "permanentUnion");
			long permanentZipCode = ParamUtil.getInteger(request, "permanentZipCode");
			String permanentPostOffice = ParamUtil.getString(request, "permanentPostOffice");
			String permanentVillage = ParamUtil.getString(request, "permanentVillage");
			long permanentWard = ParamUtil.getLong(request, "permanentWard");
			String permanentHouseAddress = ParamUtil.getString(request, "permanentHouseAddress");

			// Present Address
			boolean sameAsPermanentAddress = ParamUtil.getBoolean(request, "sameAsPermanentAddress");

			long presentRegion = ParamUtil.getLong(request, "presentRegion");
			long presentZilla = ParamUtil.getLong(request, "presentZilla");
			long presentUpazilla = ParamUtil.getLong(request, "presentUpazilla");
			long presentUnion = ParamUtil.getLong(request, "presentUnion");
			long presentZipCode = ParamUtil.getInteger(request, "presentZipCode");
			String presentPostOffice = ParamUtil.getString(request, "presentPostOffice");
			String presentVillage = ParamUtil.getString(request, "presentVillage");
			long presentWard = ParamUtil.getLong(request, "presentWard");
			String presentHouseAddress = ParamUtil.getString(request, "presentHouseAddress");

			// Family Details
			int maritalStatus = ParamUtil.getInteger(request, "maritalStatus");
			String spouseName = ParamUtil.getString(request, "spouseName");
			String spouseFatherName = ParamUtil.getString(request, "spouseFatherName");
			long spouseNationalId = ParamUtil.getLong(request, "spouseNationalId");
			// String spouseDateOfBirth = ParamUtil.getString(request, "spouseDateOfBirth");
			Date spouseDateOfBirth = ParamUtil.getDate(request, "spouseDateOfBirth",
					DateFormatFactoryUtil.getSimpleDateFormat("dd/MM/yyyy"), null);
			int familyEarningMembers = ParamUtil.getInteger(request, "familyEarningMembers");
			String familyAverageMonthlyIncome = ParamUtil.getString(request, "familyAverageMonthlyIncome");

			// Documents

			BinaryFile photograph = DLUploadUtil.getBinaryFile("photograph", request);

			BinaryFile signature = DLUploadUtil.getBinaryFile("signature", request);

			List<BinaryFile> additionalDoc = DLUploadUtil.getBinaryFileList("additionalDoc", request);

			_log.info(" photograph .." + photograph.getFileName());
			_log.info(" signature .." + signature.getFileName());
		

			boolean acknowledge = ParamUtil.getBoolean(request, "acknowledge");
			boolean nonOfMyFamilyMembersRegistered = ParamUtil.getBoolean(request,
					"nonOfMyFamilyMembersRegisteredEarlier");

			long userId = PortalUtil.getUserId(request);

			long ffpRegistrationId = ParamUtil.getLong(request, "ffpb_id");

//			if (ffpRegistrationId > 0) {
//				ServiceContext serviceContext = ServiceContextFactory.getInstance(FFPBeneficiaryVersion.class.getName(),
//						request);
//				ffpRegistrationVersionLocalService.addBenficiaryVersionHistory(ffpRegistrationId, userId, name,
//						nationalId, mobileNumber, emailAddress, dateOfBirth, gender, maritalStatus, spouseName,
//						spouseFatherName, spouseNationalId, spouseDateOfBirth, fatherName, motherName,
//						familyEarningMembers, familyAverageMonthlyIncome, permanentRegion, permanentZilla,
//						permanentUpazilla, permanentUnion, permanentVillage, permanentWard, permanentZipCode,
//						permanentPostOffice, permanentHouseAddress, presentRegion, presentZilla, presentUpazilla,
//						presentUnion, presentVillage, presentWard, presentZipCode, presentPostOffice,
//						presentHouseAddress, sameAsPermanentAddress, acknowledge, nonOfMyFamilyMembersRegistered,
//						serviceContext);
//			} else {
//				ServiceContext serviceContext = ServiceContextFactory.getInstance(FFPBeneficiary.class.getName(),
//						request);
//				FFPBeneficiary ffpRegistration = ffpRegistrationLocalService.addBenficiary(userId, name, nationalId,
//						mobileNumber, emailAddress, dateOfBirth, gender, maritalStatus, spouseName, spouseFatherName,
//						spouseNationalId, spouseDateOfBirth, fatherName, motherName, familyEarningMembers,
//						familyAverageMonthlyIncome, permanentRegion, permanentZilla, permanentUpazilla, permanentUnion,
//						permanentVillage, permanentWard, permanentZipCode, permanentPostOffice, permanentHouseAddress,
//						presentRegion, presentZilla, presentUpazilla, presentUnion, presentVillage, presentWard,
//						presentZipCode, presentPostOffice, presentHouseAddress, sameAsPermanentAddress, acknowledge,
//						nonOfMyFamilyMembersRegistered, serviceContext);
//				response.setRenderParameter("applicationNumber", Long.toString(ffpRegistration.getBeneficiaryId()));
//			}
//			response.setRenderParameter("mvcRenderCommandName", "/ffpb_registration/final_page");

		} catch (Exception exception) {

			_log.error(" Unable to register ", exception);
			String mvcPath = "/ffpb_registration/registration.jsp";

			response.setRenderParameter("mvcPath", mvcPath);
		}

	}

	@Reference
	FFPBeneficiaryLocalService ffpRegistrationLocalService;

	@Reference
	FFPBeneficiaryVersionLocalService ffpRegistrationVersionLocalService;

	private static final Log _log = LogFactoryUtil.getLog(EditBenificiaryMVCActionCommand.class);

}
