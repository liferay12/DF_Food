package bd.gov.dgfood.credit.other.priority.customer.web.portlet.action;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Arrays;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.common.services.model.Address;
import bd.gov.dgfood.common.services.service.AddressLocalServiceUtil;
import bd.gov.dgfood.common.util.CategoryUtil;
import bd.gov.dgfood.credit.other.priority.customer.constants.CustomerPortletKeys;
import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer;
import bd.gov.dgfood.credit.other.priority.customer.service.SalesCustomerLocalServiceUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + CustomerPortletKeys.CREDIT_CUSTOMER_ADMIN,
		"javax.portlet.name=" + CustomerPortletKeys.OTHER_PRIORITY_CUSTOMER_ADMIN,
		"mvc.command.name=/customer/detail_view",
		"mvc.command.name=/customer/edit_entry"}, service = MVCRenderCommand.class)
public class DetailViewMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		String mvcPath = "/detail.jsp";

		long customerId = ParamUtil.getLong(renderRequest, "customerId");
		String cmd = ParamUtil.getString(renderRequest, Constants.CMD);

		if (StringUtil.equals(cmd, Constants.EDIT)) {
			mvcPath = "/customer_registration.jsp";
		}

		try {
			SalesCustomer customer = SalesCustomerLocalServiceUtil.getSalesCustomer(customerId);

			List<Address> addresses = AddressLocalServiceUtil
					.getAddressListByClassNameAndClassPK(customer.getSalesCustomerId(), SalesCustomer.class.getName());

			Address address = addresses.isEmpty() ? null : addresses.get(0);

			log.info(" address .. " + address);

			renderRequest.setAttribute("address", address);

			if (Validator.isNotNull(address)) {
				List<AssetCategory> categories = CategoryUtil.fetchCategoriesList(
						Arrays.asList(address.getRegion(), address.getDistrict(), address.getUpazilla(),
								address.getCityCorporationOrMunicipality(), address.getUnionOrWard()));
				renderRequest.setAttribute("categories", categories);
			}

			renderRequest.setAttribute("CUSTOMER", customer);
		} catch (PortalException e) {
			log.error("DetailViewMVCRenderCommand : ", e);
		}

		return mvcPath;
	}

	private static Log log = LogFactoryUtil.getLog(DetailViewMVCRenderCommand.class);

}
