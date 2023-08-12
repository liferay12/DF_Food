package bd.gov.dgfood.reports.portlet.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ContentTypes;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

public class ExcelReportGenerationUtil {

	private static Log _log = LogFactoryUtil.getLog(ExcelReportGenerationUtil.class);

	public static void generateModuleReportAndCount(ThemeDisplay themeDisplay, ResourceRequest resourceRequest, ResourceResponse resourceResponse, String moduleName){
		
		ExcelFilterInfo filterInfo = new ExcelFilterInfo();
		filterInfo.setFromDate("");
		filterInfo.setToDate("");
		filterInfo.setModuleName(moduleName);
		filterInfo.setModuleSheetName(moduleName);

		byte [] outArray = ExcelGenerator.generateExcel(filterInfo, themeDisplay);
		try {
				_log.info("Generating excel....");
				PortletResponseUtil.sendFile(resourceRequest, resourceResponse, moduleName + StringPool.PERIOD + "xls", outArray, ContentTypes.APPLICATION_VND_MS_EXCEL);
				_log.info("Excel generated...");
		} catch (Exception e) {
				e.printStackTrace();
		}
		}
}
