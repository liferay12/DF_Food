//package bd.gov.dgfood.milling.license.resources;
//
//import com.liferay.petra.string.StringPool;
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.portlet.PortletResponseUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
//import com.liferay.portal.kernel.theme.ThemeDisplay;
//import com.liferay.portal.kernel.util.ContentTypes;
//import com.liferay.portal.kernel.util.ParamUtil;
//import com.liferay.portal.kernel.util.WebKeys;
//
//import javax.portlet.PortletException;
//import javax.portlet.ResourceRequest;
//import javax.portlet.ResourceResponse;
//
//import org.osgi.service.component.annotations.Component;
//
//import bd.gov.dgfood.common.util.constants.ModuleConstant;
//import bd.gov.dgfood.common.util.constants.ParameterConstants;
//import bd.gov.dgfood.milling.license.constants.MillingLicensePortletKeys;
//import bd.gov.dgfood.reports.portlet.util.ExcelFilterInfo;
//import bd.gov.dgfood.reports.portlet.util.ExcelGenerator;
//
//
//@Component(immediate = true, property = {
//		"javax.portlet.name="+MillingLicensePortletKeys.MILLINGLICENSE,
//		"mvc.command.name=/generatereport" }, service = MVCResourceCommand.class)
//public class DGFoodReportGenerationMVCResourceCommand implements MVCResourceCommand {
//
//	private static ThemeDisplay themeDisplay;
//	/*
//	 * This method is used to get to call the serveResource to print pdf 
//	 */
//	@Override
//	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
//			throws PortletException {
//		themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
//		
//		String fromDate = ParamUtil.getString(resourceRequest, ParameterConstants.FROM_DATE);
//		String toDate = ParamUtil.getString(resourceRequest, ParameterConstants.TO_DATE);
//		int status = ParamUtil.getInteger(resourceRequest, ParameterConstants.STATUS);
//		String keywords = ParamUtil.getString(resourceRequest, "keywords");
//
//		_log.info("Inside serve resource...");
//		_log.info("from date : "+fromDate+" to date : "+toDate+" status : "+status);
//		
//		try {
//			ExcelFilterInfo filterInfo = new ExcelFilterInfo();
//			filterInfo.setFromDate(fromDate);
//			filterInfo.setToDate(toDate);
//			filterInfo.setSearchedKeywords(keywords);
//			filterInfo.setStatus(status);
//			filterInfo.setModuleName(ModuleConstant.DGFOOD_MILLING_LICENSE_MODULE);
//			filterInfo.setModuleSheetName(ModuleConstant.DGFOOD_MILLING_LICENSE_MODULE);
//
//			byte [] outArray = ExcelGenerator.generateExcel(filterInfo, themeDisplay);
//			try {
//					_log.info("Generating excel....");
//					PortletResponseUtil.sendFile(resourceRequest, resourceResponse, ModuleConstant.DGFOOD_MILLING_LICENSE_MODULE + StringPool.PERIOD + "xls", outArray, ContentTypes.APPLICATION_VND_MS_EXCEL);
//					_log.info("Excel generated...");
//			} catch (Exception e) {
//					e.printStackTrace();
//			}
//		}catch (Exception e) {
//			_log.error("Exception in serveResource while generating PDF", e);
//			e.printStackTrace();
//		}
//		return true;
//	}
//	
//	private static Log _log = LogFactoryUtil.getLog(DGFoodReportGenerationMVCResourceCommand.class);
//}
