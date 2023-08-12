package bd.gov.dgfood.credit.other.priority.customer.web.portlet.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Date;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.common.util.DateFormatterUtil;
import bd.gov.dgfood.common.util.constants.ModuleConstant;
import bd.gov.dgfood.credit.other.priority.customer.constants.CustomerPortletKeys;
import bd.gov.dgfood.reports.portlet.util.ExcelFilterInfo;
import bd.gov.dgfood.reports.portlet.util.ExcelGenerator;

@Component(immediate = true, property = { "javax.portlet.name=" + CustomerPortletKeys.CREDIT_CUSTOMER_ADMIN,
		"javax.portlet.name=" + CustomerPortletKeys.OTHER_PRIORITY_CUSTOMER_ADMIN,
		"mvc.command.name=/generatereport" }, service = MVCResourceCommand.class)
public class ReportMVCResourceCommand extends BaseMVCResourceCommand {

	private static Log _log = LogFactoryUtil.getLog(ReportMVCResourceCommand.class);

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		_log.info(" ReportMVCResourceCommand >>>>>>>>>>>>>>>>>");

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String organizationName = ParamUtil.getString(resourceRequest, "organizationName");
		String userType = ParamUtil.getString(resourceRequest, "userType");
		int status = ParamUtil.getInteger(resourceRequest, "status", -1);

		Date fromDate = DateFormatterUtil.parseDate(ParamUtil.getString(resourceRequest, "startDate"));
		Date toDate = DateFormatterUtil.parseDate(ParamUtil.getString(resourceRequest, "endDate"));
		
		_log.info(" userType ..."+userType);

		ExcelFilterInfo filterInfo = new ExcelFilterInfo();
		filterInfo.setStartDate(fromDate);
		filterInfo.setEndDate(toDate);
		filterInfo.setStatus(status);
		filterInfo.setUserType(userType);
		filterInfo.setStart(0);
		filterInfo.setEnd(10000);
		filterInfo.setOrganizationName(organizationName);
		filterInfo.setModuleName(ModuleConstant.DGFOOD_CREDIT_CASH_MODULE);
		filterInfo.setModuleSheetName(userType);

		byte[] outArray = ExcelGenerator.generateExcel(filterInfo, themeDisplay);
		try {
			_log.info("Generating excel....");
			PortletResponseUtil.sendFile(resourceRequest, resourceResponse,
					userType + StringPool.PERIOD + "xls", outArray,
					ContentTypes.APPLICATION_VND_MS_EXCEL);
			_log.info("Excel generated...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
