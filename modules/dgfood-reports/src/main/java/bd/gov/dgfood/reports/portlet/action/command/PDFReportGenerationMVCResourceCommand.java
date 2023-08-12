package bd.gov.dgfood.reports.portlet.action.command;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.common.util.DateFormatterUtil;
import bd.gov.dgfood.common.util.constants.DateConstants;
import bd.gov.dgfood.common.util.constants.ParameterConstants;
import bd.gov.dgfood.reports.constants.DgfoodReportsPortletKeys;
/*
 * This class is used to print license(food grain and milling) PDF
 * 
 */

@Component(immediate = true, property = {
		"javax.portlet.name="+DgfoodReportsPortletKeys.DGFOODREPORTS,
		"mvc.command.name=/generatereport/pdf" }, service = MVCResourceCommand.class)
public class PDFReportGenerationMVCResourceCommand implements MVCResourceCommand {

	private static Log log = LogFactoryUtil.getLog(PDFReportGenerationMVCResourceCommand.class);

	/*
	 * This method is used to get to call the serveResource to fetch webcontent and generate pdf
	 * 
	 */
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		log.info("Inside serve resource...");
		
		try {
			String locale = ParamUtil.getString(resourceRequest, ParameterConstants.LANGUAGE_ID);
			String typeOfLicense = ParamUtil.getString(resourceRequest, ParameterConstants.LICENSE_APPLICATION_TYPE);
			String fgLicenseNumber = ParamUtil.getString(resourceRequest, ParameterConstants.FOOD_GRAIN_LICENSE_NUMBER);
			
			String htmlRes = StringPool.BLANK;
				if(Validator.isNotNull(locale) && Validator.isNotNull(typeOfLicense) && Validator.isNotNull(fgLicenseNumber)) {
					JournalArticle	journalArticle = JournalArticleLocalServiceUtil.fetchArticleByUrlTitle(themeDisplay.getScopeGroupId(), typeOfLicense);
					htmlRes = fetchDynamicValues(journalArticle.getContentByLocale(locale), themeDisplay, fgLicenseNumber);
					resourceResponse.getWriter().println(htmlRes);
				}else {
					log.error("Invalid Parameters in request");
				}
		}catch (Exception e) {
			log.error("Exception in serveResource while generating PDF", e);
			e.printStackTrace();
		}
		return true;
	}
	
	// get user's profile image and embed in PDF
	private String getUserImage(ThemeDisplay themeDisplay) {
		User user = themeDisplay.getRealUser();
		String portraitURL = StringPool.BLANK;
		try {
			portraitURL =  themeDisplay.getProtocol() + StringPool.COLON + StringPool.DOUBLE_SLASH + themeDisplay.getServerName() + StringPool.COLON +themeDisplay.getServerPort() + user.getPortraitURL(themeDisplay);
			log.info("URL ====>" + portraitURL);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return portraitURL;
	}

	//replace the placeholder values with dynamic data
	private String fetchDynamicValues(String licenseData, ThemeDisplay themeDisplay, String fgLicenseNumber) {
		
		String typeOfLicense = "Food Grain";
		long licenseNo = 123456;
		String licenseeName = "Abdul Hamid";
		String fatherName = "Mohd. Hamid";
		String village = "Chitta Gao";
		String postOffice = "Dhaka";
		String policeStation = "Dhaka";
		String district = "Dhaka";
		long licenseeNID = 987654;
		int grainQuantity = 500;
		String duration = "1 Year";
		String licenseDate = "";
		licenseDate = DateFormatterUtil.parseDate(new Date(), DateConstants.DD_MM_YYYY);

		log.info("fetchDynamicValues from webcontent");
		
		//get details against the FG license number
		//FGLicenseInfo fgLicenseInfo = FGLicenseInfoLocalServiceUtil.fetchFGLicenseInfo(123);
		
		try {
			//generating QR Code
			String qrCodeData = "Food Grain License No: "+licenseNo+". License Name : "+licenseeName+". Trade License No: "+licenseNo;
			byte[] qrCode = getQRCodeImage(qrCodeData);
			String base64Image = Base64.getEncoder().encodeToString(qrCode);
			
			// replcaing the template's placeholders with dynamic data
			licenseData = licenseData.replace("[TYPE_OF_LICENSE]", typeOfLicense);
			licenseData = licenseData.replace("[LICENSE_NUMBER]", Long.toString(licenseNo));
			licenseData = licenseData.replace("[LICENSE_DATE]", licenseDate);
			licenseData = licenseData.replace("[NID_PHOTO]", "<img id=\"profilepic\" src=\""
					+ getUserImage(themeDisplay) + "\"/>");
			licenseData = licenseData.replace("[LICENSEE_NAME]", licenseeName);
			licenseData = licenseData.replace("[FATHER_NAME]", fatherName);
			licenseData = licenseData.replace("[VILLAGE]", village);
			licenseData = licenseData.replace("[POST_OFFICE]", postOffice);
			licenseData = licenseData.replace("[POLICE_STATION]", policeStation);
			licenseData = licenseData.replace("[DISTRICT]", district);
			licenseData = licenseData.replace("[LICENSEE_NID]", Long.toString(licenseeNID));
			licenseData = licenseData.replace("[QUANTITY]", Integer.toString(grainQuantity));
			licenseData = licenseData.replace("[DURATION]", duration);
			licenseData = licenseData.replace("[QR_CODE]", "<img id=\"barcodeImg\" src=\"data:image/jpg;base64,"
					+ base64Image + "\"/>");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return licenseData;
	}

	// Logic to generate the QR Code
	public static byte[] getQRCodeImage(String text){
		try {
		BitMatrix bitMatrix = new MultiFormatWriter().encode(new String(text.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8), BarcodeFormat.QR_CODE, 450, 450);  
		ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
		return pngOutputStream.toByteArray();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}  
}
