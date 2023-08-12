package bd.gov.dgfood.grievance.resource.command;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.common.util.constants.ModuleConstant;
import bd.gov.dgfood.common.util.constants.ParameterConstants;
import bd.gov.dgfood.common.util.constants.RoleConstants;
import bd.gov.dgfood.grievance.constants.DgfoodGrievanceWebPortletKeys;
import bd.gov.dgfood.reports.portlet.util.ExcelFilterInfo;
import bd.gov.dgfood.reports.portlet.util.ExcelGenerator;


@Component(immediate = true, property = {
		"javax.portlet.name="+DgfoodGrievanceWebPortletKeys.DGFOODGRIEVANCEWEB,
		"mvc.command.name=/generatereport" }, service = MVCResourceCommand.class)

//Class used to export records of grievances list
public class DGFoodReportGenerationMVCResourceCommand implements MVCResourceCommand {

	public static ThemeDisplay themeDisplay;
	/*
	 * This method is used to get to call the serveResource to print excel 
	 */
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String fromDate = ParamUtil.getString(resourceRequest, ParameterConstants.FROM_DATE);
		String toDate = ParamUtil.getString(resourceRequest, ParameterConstants.TO_DATE);
		long grievanceCategory = ParamUtil.getLong(resourceRequest, ParameterConstants.GRIEVANCE_CATEGORY);
		long grievanceUser = ParamUtil.getLong(resourceRequest, ParameterConstants.GRIEVANCE_USER_TYPE);
		int status = ParamUtil.getInteger(resourceRequest, ParameterConstants.STATUS);
		boolean isAdmin =resourceRequest.isUserInRole(RoleConstants.UCF);
		_log.debug("Inside serve resource...");
		_log.debug("from date : "+fromDate+" to date : "+toDate+" status : "+status);

		try {
			ExcelFilterInfo filterInfo = new ExcelFilterInfo();
			filterInfo.setFromDate(fromDate);
			filterInfo.setToDate(toDate);
			filterInfo.setStatus(status);
			filterInfo.setGrievanceCategory(grievanceCategory);;
			filterInfo.setGrievanceUser(grievanceUser);
			filterInfo.setModuleName(ModuleConstant.DGFOOD_GRIEVANCE_MODULE);
			filterInfo.setModuleSheetName(ModuleConstant.DGFOOD_GRIEVANCE_MODULE);
			filterInfo.setisAdmin(isAdmin);
			filterInfo.setuserId(themeDisplay.getUserId());
			byte [] outArray = ExcelGenerator.generateExcel(filterInfo, themeDisplay);
			try {
					_log.debug("Generating excel....");
					PortletResponseUtil.sendFile(resourceRequest, resourceResponse, ModuleConstant.DGFOOD_GRIEVANCE_MODULE + StringPool.PERIOD + "xls", outArray, ContentTypes.APPLICATION_VND_MS_EXCEL);
					_log.debug("Excel generated...");
			} catch (Exception e) {
					e.printStackTrace();
			}
		}catch (Exception e) {
			_log.error("Exception in serveResource while generating PDF", e);
			e.printStackTrace();
		}
		return true;
	}

	private static Log _log = LogFactoryUtil.getLog(DGFoodReportGenerationMVCResourceCommand.class);
}