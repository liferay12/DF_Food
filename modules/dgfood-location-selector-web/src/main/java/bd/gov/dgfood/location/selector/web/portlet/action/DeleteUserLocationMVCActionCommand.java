package bd.gov.dgfood.location.selector.web.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.common.services.service.UserLocationLocalService;
import bd.gov.dgfood.location.selector.web.constants.LocationSelectorPortletKeys;

/**
 * This method is used to delete assigned location to a User
 * 
 * @author krishna
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + LocationSelectorPortletKeys.MY_ACCOUNT,
		"javax.portlet.name=" + LocationSelectorPortletKeys.USERS_ADMIN,
		"javax.portlet.name=" + LocationSelectorPortletKeys.LOCATIONSELECTORWEB, "mvc.command.name="
				+ LocationSelectorPortletKeys.DELETE_USER_LOCATION_MVC_ACTION }, service = MVCActionCommand.class)
public class DeleteUserLocationMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long userLocationId = ParamUtil.getLong(actionRequest, "userLocationId");

		try {
			if (userLocationId > 0) {
				userLocationLocalService.deleteUserLocation(userLocationId);
			}
		} catch (Exception e) {
			SessionErrors.add(actionRequest, e.getClass(), e);
			e.printStackTrace();
		}

	}

	private static Log log = LogFactoryUtil.getLog(EditUserLocationMVCActionCommand.class);

	@Reference
	UserLocationLocalService userLocationLocalService;
}
