package bd.gov.dgfood.reports.constants;

import java.util.ArrayList;
import java.util.List;

import bd.gov.dgfood.common.util.constants.ModuleConstant;

/**
 * The purpose of this interface is for creating Excel Headers.
 */

public interface ExcelHeaderList {

	public static List<String> getHeaderList(String moduleConstant) {
		List<String> excelHeaderList = new ArrayList<String>();
		switch (moduleConstant) {
		case ModuleConstant.DGFOOD_GRIEVANCE_MODULE:
			excelHeaderList.add(ExcelHeader.GRIEVANCE_CATEGORY);
			excelHeaderList.add(ExcelHeader.USER_TYPE);
			excelHeaderList.add(ExcelHeader.MOBILE_NUMBER);
			excelHeaderList.add(ExcelHeader.COMPLAINT_DETAILS);
			excelHeaderList.add(ExcelHeader.USER_NAME);
			excelHeaderList.add(ExcelHeader.STATUS);
			excelHeaderList.add(ExcelHeader.CREATED_DATE);
			excelHeaderList.add(ExcelHeader.RESPONSE_DETAILS);
			excelHeaderList.add(ExcelHeader.RESPONSE_BY);
			excelHeaderList.add(ExcelHeader.RESPONSE_DATE);
			excelHeaderList.add(ExcelHeader.GRIEVANCE_NO);
			break;
		case ModuleConstant.DGFOOD_CREDIT_CASH_MODULE:
			excelHeaderList.add(ExcelHeader.MOBILE_NUMBER);
			excelHeaderList.add(ExcelHeader.EMAIL_ADDRESS);
			excelHeaderList.add(ExcelHeader.TITLE);
			excelHeaderList.add(ExcelHeader.CONTACT_PERSONNAME);
			excelHeaderList.add(ExcelHeader.CONTACT_PERSON_DESIGNATION);
			excelHeaderList.add(ExcelHeader.OFFICE_NAME);
			excelHeaderList.add(ExcelHeader.ORGANIZATION_NAME);
			excelHeaderList.add(ExcelHeader.ORGANIZATION_TYPE);
			excelHeaderList.add(ExcelHeader.GENDER);
			excelHeaderList.add(ExcelHeader.STATUS);
			excelHeaderList.add(ExcelHeader.CREATE_DATE);
			excelHeaderList.add(ExcelHeader.USER_TYPE);
			getAddress("office", excelHeaderList);
			break;
		case ModuleConstant.DGFOOD_LMS_FG_MODULE:
			excelHeaderList.add(ExcelHeader.STATUS);
			excelHeaderList.add(ExcelHeader.CREATE_DATE);
			excelHeaderList.add(ExcelHeader.APPLICATION_NUMBER);
			excelHeaderList.add(ExcelHeader.NATIONAL_ID);
			excelHeaderList.add(ExcelHeader.MOBILE_NUMBER);
			excelHeaderList.add(ExcelHeader.APPLICANT_NAME);
			excelHeaderList.add(ExcelHeader.FATHER_NAME);
			excelHeaderList.add(ExcelHeader.MOTHER_NAME);
			excelHeaderList.add(ExcelHeader.DATE_OF_BIRTH);
			excelHeaderList.add(ExcelHeader.EMAIL_ADDRESS);
			excelHeaderList.add(ExcelHeader.GENDER);
			excelHeaderList.add(ExcelHeader.MARITAL_STATUS);
			excelHeaderList.add(ExcelHeader.TRADE_LICENSE_NUMBER);
			excelHeaderList.add(ExcelHeader.TRADE_LICENSE_EXPIRY_DATE);
			excelHeaderList.add(ExcelHeader.TAX_IDENTIFICATION_NUMBER);
			excelHeaderList.add(ExcelHeader.BUSINESS_IDENTIFICATION_NUMBER);
			excelHeaderList.add(ExcelHeader.TRADE_LICENSE_ISSUER_CODE);
			excelHeaderList.add(ExcelHeader.TRADE_LICENSE_ISSUER_CITY);
			excelHeaderList.add(ExcelHeader.LICENSE_TYPE);
			excelHeaderList.add(ExcelHeader.FOOD_GRAIN_LICENSE_NUMBER);
			excelHeaderList.add(ExcelHeader.FOOD_GRAIN_LICENSE_ISSUED_DATE);
			excelHeaderList.add(ExcelHeader.FOOD_GRAIN_LICENSE_EXPIRY_DATE);
			getAddress("permanent", excelHeaderList);
			getAddress("present", excelHeaderList);
		case ModuleConstant.DGFOOD_LMS_FG_VERSION_MODULE:
			excelHeaderList.add(ExcelHeader.STATUS);
			excelHeaderList.add(ExcelHeader.CREATE_DATE);
			excelHeaderList.add(ExcelHeader.APPLICATION_NUMBER);
			excelHeaderList.add(ExcelHeader.NATIONAL_ID);
			excelHeaderList.add(ExcelHeader.MOBILE_NUMBER);
			excelHeaderList.add(ExcelHeader.APPLICANT_NAME);
			excelHeaderList.add(ExcelHeader.FATHER_NAME);
			excelHeaderList.add(ExcelHeader.MOTHER_NAME);
			excelHeaderList.add(ExcelHeader.DATE_OF_BIRTH);
			excelHeaderList.add(ExcelHeader.EMAIL_ADDRESS);
			excelHeaderList.add(ExcelHeader.GENDER);
			excelHeaderList.add(ExcelHeader.MARITAL_STATUS);
			excelHeaderList.add(ExcelHeader.TRADE_LICENSE_NUMBER);
			excelHeaderList.add(ExcelHeader.TRADE_LICENSE_EXPIRY_DATE);
			excelHeaderList.add(ExcelHeader.TAX_IDENTIFICATION_NUMBER);
			excelHeaderList.add(ExcelHeader.BUSINESS_IDENTIFICATION_NUMBER);
			excelHeaderList.add(ExcelHeader.TRADE_LICENSE_ISSUER_CODE);
			excelHeaderList.add(ExcelHeader.TRADE_LICENSE_ISSUER_CITY);
			excelHeaderList.add(ExcelHeader.LICENSE_TYPE);
			excelHeaderList.add(ExcelHeader.FOOD_GRAIN_LICENSE_NUMBER);
			excelHeaderList.add(ExcelHeader.FOOD_GRAIN_LICENSE_ISSUED_DATE);
			excelHeaderList.add(ExcelHeader.FOOD_GRAIN_LICENSE_EXPIRY_DATE);
			getAddress("permanent", excelHeaderList);
			getAddress("present", excelHeaderList);
		}
		return excelHeaderList;
	}

	public static void getAddress(String type, List<String> addresses) {

		addresses.add(type + ExcelHeader.REGION);
		addresses.add(type + ExcelHeader.DISTRICT);
		addresses.add(type + ExcelHeader.UPAZILLA);
		addresses.add(type + ExcelHeader.CITYCORPORATION_OR_MUNICIPALITY);
		addresses.add(type + ExcelHeader.UNION_OR_WARD);
		addresses.add(type + ExcelHeader.ZIPCODE);
		addresses.add(type + ExcelHeader.POSTOFFICE);
		addresses.add(type + ExcelHeader.VILLAGE_OR_ROAD);
		addresses.add(type + ExcelHeader.MOUZA_OR_MOHOLLA);
		addresses.add(type + ExcelHeader.ADDRESS);

	}
}
