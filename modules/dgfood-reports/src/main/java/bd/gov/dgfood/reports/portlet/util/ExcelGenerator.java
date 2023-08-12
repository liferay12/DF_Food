package bd.gov.dgfood.reports.portlet.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import bd.gov.dgfood.common.services.model.Grievance;
import bd.gov.dgfood.common.services.service.GrievanceLocalServiceUtil;
import bd.gov.dgfood.common.util.DateFormatterUtil;
import bd.gov.dgfood.common.util.constants.ModuleConstant;
import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer;
import bd.gov.dgfood.credit.other.priority.customer.service.SalesCustomerLocalServiceUtil;
import bd.gov.dgfood.license.management.system.model.FGLicenseInfo;
import bd.gov.dgfood.license.management.system.service.FGLicenseInfoLocalServiceUtil;
import bd.gov.dgfood.reports.constants.ExcelHeaderList;

/**
 * The purpose of this class is handle Excel utilities i.e. generation of excel
 * will be performed from here.
 * 
 */
public class ExcelGenerator {

	public static byte[] generateExcel(ExcelFilterInfo filterInfo, ThemeDisplay themeDisplay) {
		
		List<String> headerList = null;
		Workbook workbook = null;
		Sheet sheet = null;
		Map<Integer, Integer> statusCountMap = new HashMap<Integer, Integer>();
		ByteArrayOutputStream outByteStream = null;
		byte[] outArray = null;

		try {
			workbook = new XSSFWorkbook();
			sheet = workbook.createSheet(filterInfo.getModuleSheetName());

			// Create a Font for styling header cells
			Font headerFont = workbook.createFont();
			
			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);

			headerList = ExcelHeaderList.getHeaderList(filterInfo.getModuleName());
			for (int i = 0; i < headerList.size(); i++) {
				sheet.autoSizeColumn(i);
			}
			
			Row headerRow = sheet.createRow(0);
			for (int i = 0; i < headerList.size(); i++) {
				Cell headerCell = headerRow.createCell(i);
				headerCell.setCellValue(headerList.get(i));
				headerCell.setCellStyle(headerCellStyle);
			}
			
			if (Validator.isNotNull(filterInfo.getModuleName())) {
				if (StringUtil.equalsIgnoreCase(filterInfo.getModuleName(), ModuleConstant.DGFOOD_GRIEVANCE_MODULE)) {
						List<Grievance> grievances =  GrievanceLocalServiceUtil.getGrievanceList(StringPool.BLANK, filterInfo.getFromDate(), filterInfo.getToDate(), filterInfo.getGrievanceCategory(), filterInfo.getGrievanceUser(), filterInfo.getStatus(), -1, -1,filterInfo.getuserId(),filterInfo.getisAdmin());
						ExcelGenerationCells.procesGrievanceCells(grievances, statusCountMap, sheet, themeDisplay);
				} else if (StringUtil.equalsIgnoreCase(filterInfo.getModuleName(),
						ModuleConstant.DGFOOD_CREDIT_CASH_MODULE)) {

					List<SalesCustomer> customers = SalesCustomerLocalServiceUtil.search(filterInfo.getStartDate(),
							filterInfo.getEndDate(), filterInfo.getStatus(), filterInfo.getUserType(), filterInfo.getOrganizationName(), filterInfo.getStart(),
							filterInfo.getEnd(), null);
					ExcelGenerationCells.procesCashCreditCustomerCells(customers, sheet, themeDisplay);
				}else if(StringUtil.equalsIgnoreCase(filterInfo.getModuleName(), ModuleConstant.DGFOOD_LMS_FG_MODULE)) {
					LinkedHashMap<String, Object> params = new LinkedHashMap<>();
					params.put("status", filterInfo.getStatus());
					params.put("fromDate", DateFormatterUtil.parseDate(filterInfo.getFromDate()));
					params.put("toDate", DateFormatterUtil.parseDate(filterInfo.getToDate()));
					List<FGLicenseInfo> foodGrainLicenses =  FGLicenseInfoLocalServiceUtil.getFGLicenseInfos(-1, -1);
					_logger.info(foodGrainLicenses);
					ExcelGenerationCells.processFoodGrainCells(foodGrainLicenses, sheet, themeDisplay);
				}
				
			}
		
			outByteStream = new ByteArrayOutputStream();
			workbook.write(outByteStream);
			outArray = outByteStream.toByteArray();

		}catch (Exception e) {
			_logger.error("Error while exporting : " + e);
			e.printStackTrace();
		}finally {
			try {
				outByteStream.flush();
				outByteStream.close();
				
			} catch (Exception e) {
				_logger.error("Error while exporting  : " + e);
			}
			// Removing unused objects
			//JCBCoreUtil.removeUnusedObjects(statusList, headerList, workbook, jcbEmployersSheet, statusStringMap,
				//	statusCountMap, filterInfo);
		}
		return outArray;
	}
	
	private static final Log _logger = LogFactoryUtil.getLog(ExcelGenerator.class);
}