package bd.gov.dgfood.food.friendly.program.web.internal.portlet.action;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.food.friendly.program.constants.FoodFriendlyProgramPortletKeys;
import bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary;
import bd.gov.dgfood.food.friendly.program.service.FFPBeneficiaryLocalServiceUtil;

@Component(immediate = true, property = {
		"javax.portlet.name=" + FoodFriendlyProgramPortletKeys.FOOD_FRIENDLY_PROGRAM_ADMIN,
		"mvc.command.name=/link/ffpb_dealer" }, service = MVCRenderCommand.class)
public class BenificiaryDealerLinkMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		String mvcPath = "/ffpb_dealer_link/ffpb_dealer_link_list.jsp";

		List<Long> list = null;

		PortletSession portletSession = renderRequest.getPortletSession();
		
		log.info(" sessions linkIds ..." + renderRequest.getPortletSession().getAttribute("linkIds"));
		
		if (portletSession.getAttribute("linkIds") == null) {

			long[] linkIds = ParamUtil.getLongValues(renderRequest, "linkIds");

			log.debug(" linkIds ..." + Arrays.toString(linkIds));

			list = LongStream.of(linkIds).boxed().collect(Collectors.toList());

			renderRequest.getPortletSession().setAttribute("linkIds", list);

		} else {
			list = (List<Long>) portletSession.getAttribute("linkIds");
		}

		log.debug(" linkIds ..." + list);

		DynamicQuery dynamicQuery = FFPBeneficiaryLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.in("beneficiaryId", list));

		List<FFPBeneficiary> beneficiaries = FFPBeneficiaryLocalServiceUtil.dynamicQuery(dynamicQuery);

		log.debug(" beneficiaries ..." + beneficiaries);
		int count = (int) FFPBeneficiaryLocalServiceUtil.dynamicQueryCount(dynamicQuery);

		log.debug(" count ..." + count);
		if (count == 1) {
			mvcPath = "/ffpb_dealer_link/ffpb_dealer_link.jsp";
			renderRequest.setAttribute("ffpBeneficiary", beneficiaries.get(0));

		} else {
			SearchContainer<FFPBeneficiary> searchContainer = new SearchContainer(renderRequest,
					renderResponse.createRenderURL(), null, "there-are-no-sales-officeses");
			searchContainer.setResultsAndTotal(beneficiaries);
			searchContainer.setDelta(200);
			renderRequest.setAttribute("customSearchContainer", searchContainer);
		}

		return mvcPath;
	}

	private static Log log = LogFactoryUtil.getLog(BenificiaryDealerLinkMVCRenderCommand.class);
}
