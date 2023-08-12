package bd.gov.dgfood.food.friendly.program.web.internal.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.Date;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.food.friendly.program.constants.FoodFriendlyProgramPortletKeys;
import bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary;
import bd.gov.dgfood.food.friendly.program.service.FFPBeneficiaryLocalServiceUtil;

/**
 * It helps guest beneficiary to view his profile and application status
 * 
 * @author krishna
 *
 */
@Component(property = { "javax.portlet.name=" + FoodFriendlyProgramPortletKeys.FOOD_FRIENDLY_PROGRAM,
		"mvc.command.name=/application/status_details" }, service = MVCRenderCommand.class)
public class FFPBApplicationStatusMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		String jsp = "/ffpb_profile/ffpb_dashboard.jsp";

		try {

			String cmd = ParamUtil.getString(renderRequest, Constants.CMD);

			if (cmd.equals("status")) {

				String alert = "alert-success";
				String message = "your-application-is-approved-x";
				String cardno = "";

				long ffpRegistrationId = ParamUtil.getLong(renderRequest, "applplicationNumber");
				String dob = ParamUtil.getString(renderRequest, "statusDateOfBirth");

				Date dateOfBirth = ParamUtil.getDate(renderRequest, "statusDateOfBirth",
						DateFormatFactoryUtil.getSimpleDateFormat("yyyy-MM-dd"), null);

				try {

					FFPBeneficiary ffpRegistration = FFPBeneficiaryLocalServiceUtil.getApplication(ffpRegistrationId,
							dateOfBirth);

					if (ffpRegistration.getStatus() == WorkflowConstants.STATUS_PENDING) {
						alert = "alert-warning";
						message = "your-application-is-in-pending";
					} else if (ffpRegistration.getStatus() == 4) {
						alert = "alert-danger";
						message = "your-application-is-rejected";
					} else if (ffpRegistration.getStatus() == WorkflowConstants.STATUS_APPROVED) {
						cardno = "#" + ffpRegistration.getCardNumber();
					}

					renderRequest.setAttribute("alert", alert);
					renderRequest.setAttribute("message", message);
					renderRequest.setAttribute("cardno", cardno);

				} catch (Exception e) {
					_log.error(" Application does not exist for Application Number : " + ffpRegistrationId
							+ " and DOB : " + dateOfBirth);
					renderRequest.setAttribute("applicationError",
							"application-does-not-exist-for-application-x-and-dob-x");
					renderRequest.setAttribute("args",
							new String[] { ParamUtil.getString(renderRequest, "applplicationNumber"),
									ParamUtil.getString(renderRequest, "statusDateOfBirth") });
				}

			} else if (cmd.equals("details")) {

				String ffpCardNumber = ParamUtil.getString(renderRequest, "ffpCardNumber");

				Date dateOfBirth = ParamUtil.getDate(renderRequest, "detailsDateOfBirth",
						DateFormatFactoryUtil.getSimpleDateFormat("yyyy-MM-dd"), null);

				try {
					FFPBeneficiary ffpRegistration = FFPBeneficiaryLocalServiceUtil.getBenificiaryDetails(ffpCardNumber,
							dateOfBirth);

					jsp = "/ffpb_profile/ffpb_details.jsp";

				} catch (Exception e) {
					_log.error(" Application does not exist for Card Number : " + ffpCardNumber + " and DOB : "
							+ dateOfBirth);
					renderRequest.setAttribute("error", "application-does-not-exist-for-card-x-and-dob-x");
					renderRequest.setAttribute("args",
							new String[] { ParamUtil.getString(renderRequest, "ffpCardNumber"),
									ParamUtil.getString(renderRequest, "detailsDateOfBirth") });
				}

			}

		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return jsp;
	}

	private static final Log _log = LogFactoryUtil.getLog(NIDVerificationMVCResourceCommand.class);

}
