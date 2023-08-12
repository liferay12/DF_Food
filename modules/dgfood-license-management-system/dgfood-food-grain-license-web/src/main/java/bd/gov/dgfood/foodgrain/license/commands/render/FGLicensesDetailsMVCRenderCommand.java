package bd.gov.dgfood.foodgrain.license.commands.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.common.services.model.Address;
import bd.gov.dgfood.common.services.model.Attachment;
import bd.gov.dgfood.common.services.service.AddressLocalService;
import bd.gov.dgfood.common.services.service.AttachmentLocalService;
import bd.gov.dgfood.common.services.service.UserLocationLocalService;
import bd.gov.dgfood.common.util.constants.ParameterConstants;
import bd.gov.dgfood.common.util.constants.StatusConstants;
import bd.gov.dgfood.foodgrain.license.constants.FoodGrainLicenseConstants;
import bd.gov.dgfood.foodgrain.license.constants.FoodGrainLicensePortletKeys;
import bd.gov.dgfood.license.management.system.model.FGLicenseDetails;
import bd.gov.dgfood.license.management.system.model.FGLicenseInfo;
import bd.gov.dgfood.license.management.system.service.FGLicenseDetailsLocalService;
import bd.gov.dgfood.license.management.system.service.FGLicenseInfoLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + FoodGrainLicensePortletKeys.FOODGRAIN_LICENSE_SEARCH_LIST, "mvc.command.name="
				+ FoodGrainLicenseConstants.FOODGRAIN_LICENSE_DETAILS_COMMAND, }, service = MVCRenderCommand.class)
public class FGLicensesDetailsMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		String applicationNumber = ParamUtil.getString(renderRequest, ParameterConstants.APPLICATION_NUMBER);
		int applicationStatus = ParamUtil.getInteger(renderRequest, ParameterConstants.STATUS,
				StatusConstants.STATUS_ANY);

		if (Validator.isNull(applicationNumber) || applicationStatus == StatusConstants.STATUS_ANY) {
			return FoodGrainLicenseConstants.FOODGRAIN_LICENSE_SEARCH_JSP;
		}

		FGLicenseInfo fgLicenseInfo = fgLicenseInfoLocalService.fetchFGLicenseByApplicationNumber(applicationNumber);

		if (Validator.isNull(fgLicenseInfo)) {
			return FoodGrainLicenseConstants.FOODGRAIN_LICENSE_SEARCH_JSP;
		}

		List<Long> userAddressIds = new ArrayList<>();
		userAddressIds.add(fgLicenseInfo.getBusinessAddressId());

		if (applicationStatus != StatusConstants.STATUS_APPROVED) {
			FGLicenseDetails fgLicenseDetails = fgLicenseDetailsLocalService
					.fetchFGLicenseDetails(fgLicenseInfo.getFgLicenseMasterId());

			if (Validator.isNull(fgLicenseDetails)) {
				return FoodGrainLicenseConstants.FOODGRAIN_LICENSE_SEARCH_JSP;
			}
			renderRequest.setAttribute(FGLicenseDetails.class.getSimpleName(), fgLicenseDetails);

			List<Long> userAttachmentIds = new ArrayList<>();
			userAttachmentIds.add(fgLicenseDetails.getBankStatementDocId());
			userAttachmentIds.add(fgLicenseDetails.getTaxIdentfctDocId());
			userAttachmentIds.add(fgLicenseDetails.getTradeLicenseDocId());
			userAttachmentIds.add(fgLicenseDetails.getBusinessIdentificationDocId());

			List<Attachment> attachmentslist = attachmentLocalService.fetchUserAttachments(userAttachmentIds);
			renderRequest.setAttribute(ParameterConstants.ATTACHMENTS, attachmentslist);

		} else {
			// TODO: data will be fetched from MDM / MDM table
		}

		List<Address> userAddresses = addressLocalService.fetchUserAddresses(userAddressIds);
		if (Validator.isNotNull(userAddresses)) {
			userAddresses.stream()
					.forEach(userAddress -> renderRequest.setAttribute(userAddress.getAddressType(), userAddress));
			logger.debug(userAddresses);
		}

		renderRequest.setAttribute(FGLicenseInfo.class.getSimpleName(), fgLicenseInfo);

		return FoodGrainLicenseConstants.FOODGRAIN_LICENSE_DETAILS_JSP;
	}

	@Reference
	private UserLocationLocalService userLocationLocalService;

	@Reference
	private FGLicenseInfoLocalService fgLicenseInfoLocalService;

	@Reference
	private FGLicenseDetailsLocalService fgLicenseDetailsLocalService;

	@Reference
	private AddressLocalService addressLocalService;

	@Reference
	private AttachmentLocalService attachmentLocalService;

	private Log logger = LogFactoryUtil.getLog(this.getClass());
}