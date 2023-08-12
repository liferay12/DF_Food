package bd.gov.dgfood.location.selector.web.portlet.action;

import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.common.services.exception.LocationAssignedException;
import bd.gov.dgfood.common.services.exception.NoLocationExistException;
import bd.gov.dgfood.common.services.exception.NoSuchUserLocationException;
import bd.gov.dgfood.common.services.exception.UserLocationAlreadyExistException;
import bd.gov.dgfood.common.services.service.UserLocationService;
import bd.gov.dgfood.location.selector.web.constants.LocationSelectorPortletKeys;

/**
 * This class is used to Assign location to a User
 * 
 * @author krishna
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + LocationSelectorPortletKeys.MY_ACCOUNT,
		"javax.portlet.name=" + LocationSelectorPortletKeys.USERS_ADMIN,
		"javax.portlet.name=" + LocationSelectorPortletKeys.LOCATIONSELECTORWEB, "mvc.command.name="
				+ LocationSelectorPortletKeys.EDIT_USER_LOCATION_MVC_ACTION }, service = MVCActionCommand.class)
public class EditUserLocationMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		String redirect = ParamUtil.getString(actionRequest, "redirect");

		User selUser = PortalUtil.getSelectedUser(actionRequest);

		try {

			long locationId = ParamUtil.getLong(actionRequest, "locationId");
			long userLocationId = ParamUtil.getLong(actionRequest, "userLocationId");
			long assigneeUserId = ParamUtil.getLong(actionRequest, "assigneeUserId");

			String locationType = ParamUtil.getString(actionRequest, "locationType");
			String locationCode = ParamUtil.getString(actionRequest, "locationCode");
			String locationName = ParamUtil.getString(actionRequest, "locationName");
			String roleKey = ParamUtil.getString(actionRequest, "roleKey");

			if (assigneeUserId == 0 && selUser != null) {
				assigneeUserId = selUser.getUserId();
			}

			if (userLocationId > 0) {
				userLocationService.update(userLocationId, locationId, locationName, locationCode, roleKey,
						locationType);
			} else {
				userLocationService.add(assigneeUserId, locationId, locationName, locationCode, locationType, roleKey);
			}

		} catch (Exception exception) {

			log.error(exception);
			if (exception instanceof NoSuchUserLocationException || exception instanceof PrincipalException) {
				SessionErrors.add(actionRequest, exception.getClass(), exception);
				redirect = portal.escapeRedirect(redirect);

				sendRedirect(actionRequest, actionResponse, redirect);

			} else if (exception instanceof NoSuchUserException
					|| exception instanceof UserLocationAlreadyExistException
					|| exception instanceof LocationAssignedException
					|| exception instanceof NoLocationExistException) {
				hideDefaultErrorMessage(actionRequest);
				SessionErrors.add(actionRequest, exception.getClass());

				if (Validator.isNull(selUser)) {
					actionResponse.setRenderParameter("mvcPath", LocationSelectorPortletKeys.EDIT_USER_LOCATION_JSP);
				} else {
					sendRedirect(actionRequest, actionResponse, redirect);
				}

			} else {
				throw exception;
			}
		}
	}

	@Reference
	protected Portal portal;

	private static Log log = LogFactoryUtil.getLog(EditUserLocationMVCActionCommand.class);

	@Reference
	UserLocationService userLocationService;

}
