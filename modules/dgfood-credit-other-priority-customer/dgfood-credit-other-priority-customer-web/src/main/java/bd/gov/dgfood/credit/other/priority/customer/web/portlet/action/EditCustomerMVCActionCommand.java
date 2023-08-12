package bd.gov.dgfood.credit.other.priority.customer.web.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.common.util.validator.DataValidationException;
import bd.gov.dgfood.credit.other.priority.customer.constants.CustomerPortletKeys;
import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer;
import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerVersion;
import bd.gov.dgfood.credit.other.priority.customer.service.SalesCustomerLocalService;
import bd.gov.dgfood.credit.other.priority.customer.service.SalesCustomerVersionLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + CustomerPortletKeys.CREDIT_CUSTOMER_ADMIN,
		"javax.portlet.name=" + CustomerPortletKeys.OTHER_PRIORITY_CUSTOMER_ADMIN,
		"mvc.command.name=/customer/add_entry",
		"mvc.command.name=/customer/edit_entry" }, service = MVCActionCommand.class)
public class EditCustomerMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		try {

			// Basic info
			String mobileNumber = ParamUtil.getString(actionRequest, "mobileNumber");
			String emailAddress = ParamUtil.getString(actionRequest, "emailAddress");
			String title = ParamUtil.getString(actionRequest, "title");
			int gender = ParamUtil.getInteger(actionRequest, "gender");
			String contactPersonName = ParamUtil.getString(actionRequest, "contactPersonName");
			String contactPersonDesignation = ParamUtil.getString(actionRequest, "contactPersonDesignation");
			String officeName = ParamUtil.getString(actionRequest, "officeName");
			String organizationName = ParamUtil.getString(actionRequest, "organizationName");
			String organizationType = ParamUtil.getString(actionRequest, "organizationType");

			// Office Address
			long officeRegion = ParamUtil.getLong(actionRequest, "officeRegion");
			long officeDistrict = ParamUtil.getLong(actionRequest, "officeZilla");
			long officeUpazilla = ParamUtil.getLong(actionRequest, "officeUpazilla");
			long officeUnion = ParamUtil.getLong(actionRequest, "officeUnion");
			long officeZipCode = ParamUtil.getInteger(actionRequest, "officeZipCode");
			String officePostOffice = ParamUtil.getString(actionRequest, "officePostOffice");
			String officeVillage = ParamUtil.getString(actionRequest, "officeVillage");
			long officeWard = ParamUtil.getLong(actionRequest, "officeWard");
			String officeAddress = ParamUtil.getString(actionRequest, "officeAddress");
			String userType = ParamUtil.getString(actionRequest, "userType");

			if (Validator.isNotNull(mobileNumber)) {
				mobileNumber = "+880" + mobileNumber;
			}

			String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
			long salesCustomerId = ParamUtil.getLong(actionRequest, "salesCustomerId");

			if (cmd.equals(Constants.ADD)) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(SalesCustomer.class.getName(),
						actionRequest);

				salesCustomerLocalService.addCustomer(PortalUtil.getUserId(actionRequest), userType, mobileNumber,
						emailAddress, title, contactPersonName, contactPersonDesignation, officeName, organizationName,
						organizationType, gender, officeRegion, officeDistrict, officeUpazilla, officeWard, officeUnion,
						officeVillage, "officeMouzaOrMoholla", officeZipCode, officePostOffice, officeAddress,
						serviceContext);
				actionResponse.setRenderParameter("mvcPath", "/final.jsp");
			} else if (cmd.equals(Constants.UPDATE)) {

				ServiceContext serviceContext = ServiceContextFactory.getInstance(SalesCustomerVersion.class.getName(),
						actionRequest);

				salesCustomerVersionLocalService.addHistory(PortalUtil.getUserId(actionRequest), salesCustomerId,
						mobileNumber, emailAddress, title, contactPersonName, contactPersonDesignation, officeName,
						organizationName, organizationType, gender, officeRegion, officeDistrict, officeUpazilla,
						officeWard, officeUnion, officeVillage, "officeMouzaOrMoholla", officeZipCode, officePostOffice,
						officeAddress, serviceContext);

			}

		} catch (Exception exception) {

			_log.error(" Unable to register ", exception);

			String mvcPath = "/customer_registration.jsp";
			SessionErrors.add(actionRequest, exception.getClass());

			if (exception instanceof DataValidationException) {

				_log.error(" TRUE>>>>>>>>>>>> .. ");

				actionRequest.setAttribute("errorKey", exception.getMessage());
			} else {
				mvcPath = "";
			}

			actionResponse.setRenderParameter("mvcPath", mvcPath);
		}

	}

	@Reference
	SalesCustomerVersionLocalService salesCustomerVersionLocalService;

	@Reference
	SalesCustomerLocalService salesCustomerLocalService;

	private static final Log _log = LogFactoryUtil.getLog(EditCustomerMVCActionCommand.class);
}
