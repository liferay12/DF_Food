//package bd.gov.dgfood.milling.license.actions;
//
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
//import com.liferay.portal.kernel.service.ServiceContext;
//import com.liferay.portal.kernel.service.ServiceContextFactory;
//import com.liferay.portal.kernel.theme.ThemeDisplay;
//import com.liferay.portal.kernel.upload.UploadPortletRequest;
//import com.liferay.portal.kernel.util.ParamUtil;
//import com.liferay.portal.kernel.util.PortalUtil;
//import com.liferay.portal.kernel.util.WebKeys;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.portlet.ActionRequest;
//import javax.portlet.ActionResponse;
//import javax.portlet.MimeResponse.Copy;
//import javax.portlet.RenderURL;
//
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Reference;
//
//import bd.gov.dgfood.common.model.AttachmentBinaryFile;
//import bd.gov.dgfood.common.services.exception.DataValidationException;
//import bd.gov.dgfood.common.util.DLUploadUtil;
//import bd.gov.dgfood.common.util.DateFormatterUtil;
//import bd.gov.dgfood.common.util.constants.DocumentLibraryConstants;
//import bd.gov.dgfood.license.management.system.constants.LicenseConstants;
//import bd.gov.dgfood.license.management.system.exception.InvalidMillingLicenseApplicationDataException;
//import bd.gov.dgfood.license.management.system.model.MillingLicense;
//import bd.gov.dgfood.license.management.system.service.MillingLicenseLocalService;
//import bd.gov.dgfood.milling.license.constants.MillingLicensePortletKeys;
//
///**
// * 
// * @author Abhijit Ande
// *
// */
//
//@Component(immediate = true,
//property = {
//		"javax.portlet.name=" + MillingLicensePortletKeys.MILLINGLICENSE,
//		"mvc.command.name=" + MillingLicensePortletKeys.SUBMIT_NEW_MILLING_MVC_ACTION_COMMAND
//},
//service = MVCActionCommand.class
//		)
//public class SubmitNewMillingLicenseMVCActionCommand extends BaseMVCActionCommand{
//
//	@Override
//	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
//
//		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
//		List<AttachmentBinaryFile> documentBinaryFileList = new ArrayList<AttachmentBinaryFile>();
//		
//		logger.info("Entered SubmitNewMillingLicenseMVCActionCommand");
//
//		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
//		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
//
//		//Food Grain License Basic Fields
//		long foodGrainLicenseId = ParamUtil.getLong(actionRequest, "foodGrainLicenseId");
//		logger.info("Food Grain License Id - "+foodGrainLicenseId);
//		
//		//Spouse Related Fields
//		int maritalStatus = ParamUtil.getInteger(actionRequest, "maritalStatus");
//		String spouseName = ParamUtil.getString(actionRequest, "spouseName");
//		String spouseFatherName = ParamUtil.getString(actionRequest, "spouseFatherName");
//		String spouseNationalId = ParamUtil.getString(actionRequest, "spouseNationalId");
//		Date spouseDateOfBirth = DateFormatterUtil.parseDate(ParamUtil.getString(actionRequest, "spouseDateOfBirth"));
//		
//		System.out.println("maritalStatus----------->"+maritalStatus);
//		System.out.println("spouseName----------->"+spouseName);
//		System.out.println("spouseFatherName----------->"+spouseFatherName);
//		System.out.println("spouseNationalId----------->"+spouseNationalId);
//		System.out.println("spouseDateOfBirth----------->"+spouseDateOfBirth);
//		
//		//Mill Operator Information
//		boolean operateOwnMill = ParamUtil.getBoolean(actionRequest, "operateOwnMill");
//		boolean millOperatingThroughThirdParty = ParamUtil.getBoolean(actionRequest, "millOperatingThroughThirdParty");
//		String operatorName = ParamUtil.getString(actionRequest, "operatorName");
//		String operatorNationalId = ParamUtil.getString(actionRequest, "operatorNationalId");
//		String operatorRunningBusinessFromYrs = ParamUtil.getString(actionRequest, "operatorRunningBusinessFromYears");
//		AttachmentBinaryFile operatorPhotograph = DLUploadUtil.getUploadedDocument(actionRequest, 
//				"operatorPhotograph", DocumentLibraryConstants.ATTACHMENT_PROFILE_PHOTO);
//		boolean publicRepresentative = ParamUtil.getBoolean(actionRequest, "publicRepresentative");
//		boolean workInGovernment = ParamUtil.getBoolean(actionRequest, "workInGovernment");
//
//		System.out.println("operateOwnMill----------->"+operateOwnMill);
//		System.out.println("millOperatingThroughThirdParty----------->"+millOperatingThroughThirdParty);
//		System.out.println("operatorName----------->"+operatorName);
//		System.out.println("operatorNationalId----------->"+operatorNationalId);
//		System.out.println("operatorRunningBusinessFromYrs----------->"+operatorRunningBusinessFromYrs);
//		System.out.println("publicRepresentative----------->"+publicRepresentative);
//		System.out.println("workInGovernment----------->"+workInGovernment);
//		
//		//Mill Information
//		String millName = ParamUtil.getString(actionRequest, "millName");
//		double millLength = ParamUtil.getDouble(actionRequest, "millLength");
//		double millHeight = ParamUtil.getDouble(actionRequest, "millHeight");
//		double millWidth =	ParamUtil.getDouble(actionRequest, "millWidth");
//		double millStorage = ParamUtil.getDouble(actionRequest, "millStorage");
//		int millType = ParamUtil.getInteger(actionRequest, "millType");
//		boolean millFloorPaved = ParamUtil.getBoolean(actionRequest, "millFloorPaved");
//		int riceType =  ParamUtil.getInteger(actionRequest, "riceType");
//		
//		Map<String, Serializable> millDetailsMap = new HashMap<String, Serializable>();
//		millDetailsMap.put(LicenseConstants.MILL_NAME, millName);
//		millDetailsMap.put(LicenseConstants.MILL_LENGTH, millLength);
//		millDetailsMap.put(LicenseConstants.MILL_HEIGHT, millHeight);
//		millDetailsMap.put(LicenseConstants.MILL_WIDTH, millWidth);
//		millDetailsMap.put(LicenseConstants.MILL_STORAGE, millStorage);
//		millDetailsMap.put(LicenseConstants.MILL_TYPE, millType);
//		millDetailsMap.put(LicenseConstants.MILL_FLOOR_PAVED, millFloorPaved);
//		millDetailsMap.put(LicenseConstants.RICE_TYPE, riceType);
//		
//		//Mill Attachments
//		AttachmentBinaryFile incomeTaxDocument = DLUploadUtil.getUploadedDocument(actionRequest, 
//				"incomeTaxDocument", DocumentLibraryConstants.ATTACHMENT_PROFILE_PHOTO);
//		
//		AttachmentBinaryFile signatureThumbImpression=DLUploadUtil.getUploadedDocument(actionRequest, 
//				"signatureThumbImpression", DocumentLibraryConstants.ATTACHMENT_TRADE_LICENSE_PHOTO);
//		
//		AttachmentBinaryFile tradeLicenseNumberPhotocopy=DLUploadUtil.getUploadedDocument(actionRequest, 
//				"tradeLicenseNumberPhotocopy",DocumentLibraryConstants.ATTACHMENT_BUSINESS_IDENTIFICATION_PHOTO);
//		
//		List<AttachmentBinaryFile> relevantDocument=DLUploadUtil.getUploadedDocuments(actionRequest, 
//				"relevantDocument", DocumentLibraryConstants.ATTACHMENT_RELEVANT_DOCUMENT);
//		for(AttachmentBinaryFile file : relevantDocument){
//			documentBinaryFileList.add(file);
//		}
//		
//		//Mill Address Information
//		long millRegion = ParamUtil.getLong(actionRequest, "millRegion");
//		long millZilla = ParamUtil.getLong(actionRequest, "millZilla");
//		long millUpazilla = ParamUtil.getLong(actionRequest, "millUpazilla");
//		long millUnion = ParamUtil.getLong(actionRequest, "millUnion");
//		String millVillage = ParamUtil.getString(actionRequest, "millVillage");
//		long millWard = ParamUtil.getLong(actionRequest, "millWard");
//		long millZipCode = ParamUtil.getLong(actionRequest, "millZipCode");
//		String millPostOffice = ParamUtil.getString(actionRequest, "millPostOffice");
//		String millAddress = ParamUtil.getString(actionRequest, "millAddress");
//
//		System.out.println("millRegion----------->"+millRegion);
//		System.out.println("millZilla----------->"+millZilla);
//		System.out.println("millUpazilla----------->"+millUpazilla);
//		System.out.println("millUnion----------->"+millUnion);
//		System.out.println("millVillage----------->"+millVillage);
//		System.out.println("millWard----------->"+millWard);
//		System.out.println("millZipCode----------->"+millZipCode);
//		System.out.println("millPostOffice----------->"+millPostOffice);
//		System.out.println("millAddress----------->"+millAddress);
//		
//		//Bank Account Information
//		String bankAccountNumber = ParamUtil.getString(actionRequest, "bankAccountNumber");
//		String bankAccountHolderName= ParamUtil.getString(actionRequest, "bankAccountHolderName");
//		String bankName = ParamUtil.getString(actionRequest, "bankName");
//		String bankBranchNameAndAddress = ParamUtil.getString(actionRequest, "bankBranchNameAndAddress");
//		
//		System.out.println("bankAccountNumber----------->"+bankAccountNumber);
//		System.out.println("bankAccountHolderName----------->"+bankAccountHolderName);
//		System.out.println("bankName----------->"+bankName);
//		System.out.println("bankBranchNameAndAddress----------->"+bankBranchNameAndAddress);
//		
//		//Electricity Bill Information
//		boolean electricityConnection = ParamUtil.getBoolean(actionRequest, "electricityConnection");
//		long electricityMeterNumber = ParamUtil.getLong(actionRequest, "electricityMeterNumber");
//		double lastBillAmountInTaka = ParamUtil.getDouble(actionRequest, "lastBillAmountInTaka");
//		double maximumLoadingCapacity = ParamUtil.getDouble(actionRequest, "maximumLoadingCapacity");
//		
//		Map<String, Serializable> electricityDetailsMap = new HashMap<String, Serializable>();
//		electricityDetailsMap.put(LicenseConstants.ELECTRICITY_CONNECTION, electricityConnection);
//		electricityDetailsMap.put(LicenseConstants.ELECTRICITY_METER_NUMBER, electricityMeterNumber);
//		electricityDetailsMap.put(LicenseConstants.LAST_BILL_AMOUNT_TAKA, lastBillAmountInTaka);
//		electricityDetailsMap.put(LicenseConstants.MAXIMUM_LOADING_CAPACITY, maximumLoadingCapacity);
//		
//		List<AttachmentBinaryFile> electricityConnectionDocument=DLUploadUtil.getUploadedDocuments(actionRequest, 
//				"electricityConnectionDocument", DocumentLibraryConstants.ATTACHMENT_RELEVANT_DOCUMENT);
//		for(AttachmentBinaryFile file : relevantDocument){
//			documentBinaryFileList.add(file);
//		}
//		
//		//Boiler Information
//		int boilerCount = ParamUtil.getInteger(actionRequest, "boilerCount");
//		boolean boilerSafety = ParamUtil.getBoolean(actionRequest, "boilerSafety");
//		boolean boilerPressureInstrumentAvailable = ParamUtil.getBoolean(actionRequest, "boilerPressureInstrumentAvailable");
//		
//		Map<String, Serializable> boilerDetailsMap = new HashMap<String, Serializable>();
//		boilerDetailsMap.put(LicenseConstants.BOILER_COUNT, boilerCount);
//		boilerDetailsMap.put(LicenseConstants.BOILER_CAPACITY, boilerSafety);
//		boilerDetailsMap.put(LicenseConstants.BOILER_PRESSURE_INSTRUMENT_AVAILABLE, boilerPressureInstrumentAvailable);
//
//		//Chimney Information
//		double chimneyHeight = ParamUtil.getDouble(actionRequest, "chimneyHeight");
//		
//		Map<String, Serializable> chimneyDetailsMap = new HashMap<String, Serializable>();
//		chimneyDetailsMap.put(LicenseConstants.CHIMNEY_HEIGHT, chimneyHeight);
//		
//		//Chatal Information
//		int chatalCount = ParamUtil.getInteger(actionRequest, "chatalCount");
//		double chatalArea = ParamUtil.getDouble(actionRequest, "chatalArea");
//		long oldLicenseNumber = ParamUtil.getLong(actionRequest, "oldLicenseNumber");
//		double chatalCapacityOfPaddyDried = ParamUtil.getDouble(actionRequest, "chatalCapacityOfPaddyDried");
//		
//		Map<String, Serializable> chatalDetailsMap = new HashMap<String, Serializable>();
//		chatalDetailsMap.put(LicenseConstants.CHATAL_COUNT, chatalCount);
//		chatalDetailsMap.put(LicenseConstants.CHATAL_AREA, chatalArea);
//		chatalDetailsMap.put(LicenseConstants.OLD_LICENSE_NUMBER, oldLicenseNumber);
//		chatalDetailsMap.put(LicenseConstants.CHATAL_CAPACITY_OF_PADDY_DRIED, chatalCapacityOfPaddyDried);
//
//		//Striping House Information
//		int stripingHouseCount = ParamUtil.getInteger(actionRequest, "stripingHouseCount");
//		double stripingHouseCapacity = ParamUtil.getDouble(actionRequest, "stripingHouseCapacity");
//		double stripingHousePaddyDippedCapacity = ParamUtil.getDouble(actionRequest, "stripingHousePaddyDippedCapacity");
//		
//		Map<String, Serializable> stripingHouseDetailsMap = new HashMap<String, Serializable>();
//		stripingHouseDetailsMap.put(LicenseConstants.STRIPING_HOUSE_COUNT, stripingHouseCount);
//		stripingHouseDetailsMap.put(LicenseConstants.STRIPING_HOUSE_CAPACITY, stripingHouseCapacity);
//		stripingHouseDetailsMap.put(LicenseConstants.STRIPING_HOUSE_PADDY_DIPPED_CAPACITY, stripingHousePaddyDippedCapacity);
//		
//		//Mill Storage Information
//		int godownsCount = ParamUtil.getInteger(actionRequest, "godownsCount");
//		double godownVolume = ParamUtil.getDouble(actionRequest, "godownVolume");
//		double godownStorageCapacity = ParamUtil.getDouble(actionRequest, "godownStorageCapacity");
//		
//		Map<String, Serializable> millStorageDetailsMap = new HashMap<String, Serializable>();
//		millStorageDetailsMap.put(LicenseConstants.GODOWNS_COUNT, godownsCount);
//		millStorageDetailsMap.put(LicenseConstants.GODOWN_VOLUME, godownVolume);
//		millStorageDetailsMap.put(LicenseConstants.GODOWN_STORAGE_CAPACITY, godownStorageCapacity);
//		
//		//Motor Information
//		int motorsCount = ParamUtil.getInteger(actionRequest, "motorsCount");
//		double totalHuskingCapacity = ParamUtil.getDouble(actionRequest, "totalHuskingCapacity");
//		double avgHuskingCapacity = ParamUtil.getDouble(actionRequest, "avgHuskingCapacity");
//		
//		Map<String, Serializable> motorDetailsMap = new HashMap<String, Serializable>();
//		motorDetailsMap.put(LicenseConstants.MOTORS_COUNT, motorsCount);
//		motorDetailsMap.put(LicenseConstants.TOTAl_HUSKING_CAPACITY, totalHuskingCapacity);
//		motorDetailsMap.put(LicenseConstants.AVG_HUSKING_CAPACITY, avgHuskingCapacity);
//
//		//Mill Capacity Information
//		double transformerCapacity = ParamUtil.getDouble(actionRequest, "transformerCapacity");
//		double transformerQuantity = ParamUtil.getDouble(actionRequest, "transformerQuantity");
//		double sanctionLoadCapacity = ParamUtil.getDouble(actionRequest, "sanctionLoadCapacity");
//		double sanctionLoadQuantity = ParamUtil.getDouble(actionRequest, "sanctionLoadQuantity");
//		double boilerCapacity = ParamUtil.getDouble(actionRequest, "boilerCapacity");
//		double boilerQuantity = ParamUtil.getDouble(actionRequest, "boilerQuantity");
//		double warehouseStorageCapacity = ParamUtil.getDouble(actionRequest, "warehouseStorageCapacity");
//		double warehouseStorageCapacityQuantity = ParamUtil.getDouble(actionRequest, "warehouseStorageCapacityQuantity");
//		double paddyStorageBinCapacity = ParamUtil.getDouble(actionRequest, "paddyStorageBinCapacity");
//		double paddyStorageBinCapacityQuantity = ParamUtil.getDouble(actionRequest, "paddyStorageBinCapacityQuantity");
//		double parBoilingUnitContainerCapacity = ParamUtil.getDouble(actionRequest, "parBoilingUnitContainerCapacity");
//		double parBoilingUnitContainerQuantity = ParamUtil.getDouble(actionRequest, "parBoilingUnitContainerQuantity");
//		double dryerCapacity = ParamUtil.getDouble(actionRequest, "dryerCapacity");
//		double dryerQuantity = ParamUtil.getDouble(actionRequest, "dryerQuantity");
//		double cleanerUnitSeriesCapacity = ParamUtil.getDouble(actionRequest, "cleanerUnitSeriesCapacity");
//		double cleanerUnitSeriesQuantity = ParamUtil.getDouble(actionRequest, "cleanerUnitSeriesQuantity");
//		double distonerCapacity = ParamUtil.getDouble(actionRequest, "distonerCapacity");
//		double distonerQuantity = ParamUtil.getDouble(actionRequest, "distonerQuantity");
//		double shellerCapacity = ParamUtil.getDouble(actionRequest, "shellerCapacity");
//		double shellerQuantity = ParamUtil.getDouble(actionRequest, "shellerQuantity");
//		double paddySeparatorCapacity = ParamUtil.getDouble(actionRequest, "paddySeparatorCapacity");
//		double paddySeparatorQuantity = ParamUtil.getDouble(actionRequest, "paddySeparatorQuantity");
//		double riceWhitenerCapacity = ParamUtil.getDouble(actionRequest, "riceWhitenerCapacity");
//		double riceWhitenerQuantity = ParamUtil.getDouble(actionRequest, "riceWhitenerQuantity");
//		double riceGraderCapacity = ParamUtil.getDouble(actionRequest, "riceGraderCapacity");
//		double riceGraderQuantity = ParamUtil.getDouble(actionRequest, "riceGraderQuantity");
//		double riceSmoothingUnitCapacity = ParamUtil.getDouble(actionRequest, "riceSmoothingUnitCapacity");
//		double riceSmoothingUnitQuantity = ParamUtil.getDouble(actionRequest, "riceSmoothingUnitQuantity");
//		double colorSorterUnitCapacity = ParamUtil.getDouble(actionRequest, "colorSorterUnitCapacity");
//		double colorSorterUnitQuantity = ParamUtil.getDouble(actionRequest, "colorSorterUnitQuantity");
//		double thicknessGraderUnitCapacity = ParamUtil.getDouble(actionRequest, "thicknessGraderUnitCapacity");
//		double thicknessGraderUnitQuantity = ParamUtil.getDouble(actionRequest, "thicknessGraderUnitQuantity");
//		double gunnyBagPackingCapacity = ParamUtil.getDouble(actionRequest, "gunnyBagPackingCapacity");
//		double gunnyBagPackingQuantity = ParamUtil.getDouble(actionRequest, "gunnyBagPackingQuantity");
//		
//		Map<String, Serializable> millCapacityDetailsMap = new HashMap<String, Serializable>();
//		millCapacityDetailsMap.put(LicenseConstants.TRANSFORMER_CAPACITY, transformerCapacity);
//		millCapacityDetailsMap.put(LicenseConstants.TRANSFORMER_QUANTITY, transformerQuantity);
//		millCapacityDetailsMap.put(LicenseConstants.SANCTION_LOAD_CAPACITY, sanctionLoadCapacity);
//		millCapacityDetailsMap.put(LicenseConstants.SANCTION_LOAD_QUANTITY, sanctionLoadQuantity);
//		millCapacityDetailsMap.put(LicenseConstants.BOILER_CAPACITY, boilerCapacity);
//		millCapacityDetailsMap.put(LicenseConstants.BOILER_QUANTITY, boilerQuantity);
//		millCapacityDetailsMap.put(LicenseConstants.WAREHOUSE_STORAGE_CAPACITY, warehouseStorageCapacity);
//		millCapacityDetailsMap.put(LicenseConstants.WAREHOUSE_STORAGE_CAPACITY_QUANTITY, warehouseStorageCapacityQuantity);
//		millCapacityDetailsMap.put(LicenseConstants.PADDY_STORAGE_BIN_CAPACITY, paddyStorageBinCapacity);
//		millCapacityDetailsMap.put(LicenseConstants.PADDY_STORAGE_BIN_CAPACITY_QUANTITY, paddyStorageBinCapacityQuantity);
//		millCapacityDetailsMap.put(LicenseConstants.PAR_BOILER_UNIT_CONTAINER_CAPACITY, parBoilingUnitContainerCapacity);
//		millCapacityDetailsMap.put(LicenseConstants.PAR_BOILER_UNIT_CONTAINER_QUANTITY, parBoilingUnitContainerQuantity);
//		millCapacityDetailsMap.put(LicenseConstants.DRYER_CAPACITY, dryerCapacity);
//		millCapacityDetailsMap.put(LicenseConstants.DRYER_QUANTITY, dryerQuantity);
//		millCapacityDetailsMap.put(LicenseConstants.CLEANER_UNIT_SERIES_CAPACITY, cleanerUnitSeriesCapacity);
//		millCapacityDetailsMap.put(LicenseConstants.CLEANER_UNIT_SERIES_QUANTITY, cleanerUnitSeriesQuantity);
//		millCapacityDetailsMap.put(LicenseConstants.DISTONER_CAPACITY, distonerCapacity);
//		millCapacityDetailsMap.put(LicenseConstants.DISTONER_QUANTITY, distonerQuantity);
//		millCapacityDetailsMap.put(LicenseConstants.SHELLER_CAPACITY, shellerCapacity);
//		millCapacityDetailsMap.put(LicenseConstants.SHELLER_QUANTITY, shellerQuantity);
//		millCapacityDetailsMap.put(LicenseConstants.PADDY_SEPARATOR_QUANTITY, paddySeparatorCapacity);
//		millCapacityDetailsMap.put(LicenseConstants.PADDY_SEPARATOR_QUANTITY, paddySeparatorQuantity);
//		millCapacityDetailsMap.put(LicenseConstants.RICE_WHITENER_CAPACITY, riceWhitenerCapacity);
//		millCapacityDetailsMap.put(LicenseConstants.RICE_WHITENER_QUANTITY, riceWhitenerQuantity);
//		millCapacityDetailsMap.put(LicenseConstants.RICE_GRADER_CAPACITY, riceGraderCapacity);
//		millCapacityDetailsMap.put(LicenseConstants.RICE_GRADER_QUANTITY, riceGraderQuantity);
//		millCapacityDetailsMap.put(LicenseConstants.RICE_SMOOTHING_UNIT_CAPACITY, riceSmoothingUnitCapacity);
//		millCapacityDetailsMap.put(LicenseConstants.RICE_SMOOTHING_UNIT_QUANTITY, riceSmoothingUnitQuantity);
//		millCapacityDetailsMap.put(LicenseConstants.COLOR_SORTER_UNIT_CAPACITY, colorSorterUnitCapacity);
//		millCapacityDetailsMap.put(LicenseConstants.COLOR_SORTER_UNIT_QUANTITY, colorSorterUnitQuantity);
//		millCapacityDetailsMap.put(LicenseConstants.THICKNESS_GRADER_UNIT_CAPACITY, thicknessGraderUnitCapacity);
//		millCapacityDetailsMap.put(LicenseConstants.THICKNESS_GRADER_UNIT_QUANTITY, thicknessGraderUnitQuantity);
//		millCapacityDetailsMap.put(LicenseConstants.GUNNY_BAG_PACKING_CAPACITY, gunnyBagPackingCapacity);
//		millCapacityDetailsMap.put(LicenseConstants.GUNNY_BAG_PACKING_QUANTITY, gunnyBagPackingQuantity);
//		
//		try 
//		{
//			//Basic Information Storing
//			MillingLicense millingLicense = millingLicenseLocalService.addMillingLicenseFormData(foodGrainLicenseId, serviceContext.getUserId(), 
//					maritalStatus, spouseName, spouseFatherName, spouseNationalId, spouseDateOfBirth, operateOwnMill, 
//					millOperatingThroughThirdParty, operatorName, operatorNationalId, operatorRunningBusinessFromYrs, 
//					publicRepresentative, workInGovernment, millName, millLength, millHeight, millWidth, millStorage, 
//					millType, millFloorPaved, riceType, millRegion, millZilla, millUpazilla, millUnion, millVillage, 
//					millWard, millZipCode, millPostOffice, millAddress, bankAccountNumber, bankAccountHolderName, 
//					bankName, bankBranchNameAndAddress, electricityConnection, electricityMeterNumber, lastBillAmountInTaka, 
//					maximumLoadingCapacity, boilerCount, boilerSafety, boilerPressureInstrumentAvailable, chimneyHeight, 
//					chatalCount, chatalArea, oldLicenseNumber, chatalCapacityOfPaddyDried, stripingHouseCount, 
//					stripingHouseCapacity, stripingHousePaddyDippedCapacity, godownsCount, godownVolume, godownStorageCapacity, 
//					motorsCount, totalHuskingCapacity, avgHuskingCapacity, transformerCapacity, transformerQuantity, 
//					sanctionLoadCapacity, sanctionLoadQuantity, boilerCapacity, boilerQuantity, warehouseStorageCapacity, 
//					warehouseStorageCapacityQuantity, paddyStorageBinCapacity, paddyStorageBinCapacityQuantity, 
//					parBoilingUnitContainerCapacity, parBoilingUnitContainerQuantity, dryerCapacity, dryerQuantity, 
//					cleanerUnitSeriesCapacity, cleanerUnitSeriesQuantity, distonerCapacity, distonerQuantity, shellerCapacity, 
//					shellerQuantity, paddySeparatorCapacity, paddySeparatorQuantity, riceWhitenerCapacity, riceWhitenerQuantity, 
//					riceGraderCapacity, riceGraderQuantity, riceSmoothingUnitCapacity, riceSmoothingUnitQuantity, colorSorterUnitCapacity, 
//					colorSorterUnitQuantity, thicknessGraderUnitCapacity, thicknessGraderUnitQuantity, gunnyBagPackingCapacity, 
//					gunnyBagPackingQuantity, documentBinaryFileList, serviceContext);
//
//			logger.debug(millingLicense);
//
//			RenderURL successPageURL=actionResponse.createRedirectURL(Copy.NONE);
//			successPageURL.setParameter("mvcPath", "/milling_registration/tld-steps/final_step.jsp");
//			successPageURL.setParameter("formNo", String.valueOf(millingLicense.getMillingLicenseId()));
//			actionResponse.sendRedirect(successPageURL.toString());
//
//			hideDefaultSuccessMessage(actionRequest);
//
//
//		} catch (DataValidationException dataValidationException) {
//			logger.error("Validation failed for submitted Milling License Data: " + dataValidationException.getMessage());
//			if (logger.isDebugEnabled()) {
//				dataValidationException.printStackTrace();
//			}
//		}
//		catch (InvalidMillingLicenseApplicationDataException invalidMillingLicenseApplicationDataException) {
//			logger.error("Internal error occured while storing Milling License data : " + invalidMillingLicenseApplicationDataException.getMessage());
//			if (logger.isDebugEnabled()) {
//				invalidMillingLicenseApplicationDataException.printStackTrace();
//			}
//		}
//		catch (Exception exception) {
//			logger.error("Exception occured while added the Milling License : " + exception.getMessage());
//			if (logger.isDebugEnabled()) {
//				exception.printStackTrace();
//			}
//		}
//	}
//
//	private Log logger = LogFactoryUtil.getLog(this.getClass());
//
//	@Reference
//	protected MillingLicenseLocalService millingLicenseLocalService;
//}