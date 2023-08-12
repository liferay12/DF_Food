package bd.gov.dgfood.reports.portlet.action.command;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.common.util.constants.ModuleConstant;
import bd.gov.dgfood.reports.constants.DgfoodReportsPortletKeys;
import bd.gov.dgfood.reports.portlet.util.ExcelReportGenerationUtil;


@Component(immediate = true, property = {
		"javax.portlet.name="+DgfoodReportsPortletKeys.DGFOODREPORTS,
		"mvc.command.name=/generatereport" }, service = MVCResourceCommand.class)
public class ReportGenerationMVCResourceCommand implements MVCResourceCommand {

	private static Log log = LogFactoryUtil.getLog(ReportGenerationMVCResourceCommand.class);
	private static ThemeDisplay themeDisplay;

	/*
	 * This method is used to get to call the serveResource to print pdf
	 * 
	 */
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		log.info("Inside serve resource...");
		
		try {
		
		/*Map<String, String> reportParam = new HashMap<String, String>();
		reportParam.put("invoiceDate", "12345");
		reportParam.put("Name", "ashish");
		
		String htmlRes = PDFReportGenerationUtil.generatePDF(themeDisplay, "GRIEVANCE_REPORT", reportParam);
		resourceResponse.getWriter().println(htmlRes);*/
		
		ExcelReportGenerationUtil.generateModuleReportAndCount(themeDisplay, resourceRequest, resourceResponse, ModuleConstant.DGFOOD_GRIEVANCE_MODULE);
			
		}catch (Exception e) {
			log.error("Exception in serveResource while generating PDF", e);
			e.printStackTrace();
		}
		
		return true;
	}
}
