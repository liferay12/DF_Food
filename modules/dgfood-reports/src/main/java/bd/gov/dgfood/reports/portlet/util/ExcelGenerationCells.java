package bd.gov.dgfood.reports.portlet.util;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import bd.gov.dgfood.common.services.model.Address;
import bd.gov.dgfood.common.services.model.Grievance;
import bd.gov.dgfood.common.services.service.AddressLocalServiceUtil;
import bd.gov.dgfood.common.util.CategoryUtil;
import bd.gov.dgfood.common.util.DateFormatterUtil;
import bd.gov.dgfood.common.util.constants.DateConstants;
import bd.gov.dgfood.common.util.constants.GenderConstants;
import bd.gov.dgfood.common.util.constants.StatusConstants;
import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer;
import bd.gov.dgfood.license.management.system.model.FGLicenseInfo;

/**
 * The purpose of this class is handle Excel utilities i.e. generation of excel
 * will be performed from here.
 * 
 */
public class ExcelGenerationCells {

	public static Sheet procesGrievanceCells(List<Grievance> grievances, Map<Integer, Integer> statusCountMap,
			Sheet sheet, ThemeDisplay themeDisplay) {
		int refNum = 1;
		String categoryValue = StringPool.BLANK;

		for (Grievance grievance : grievances) {

			Row row = sheet.createRow(refNum);

			Cell grievanceCategoryCell = row.createCell(0);
			if (Validator.isNotNull(grievance.getGrievanceCategory())) {
				categoryValue = CategoryUtil.fetchCategoryNamebyCategoryId(grievance.getGrievanceCategory(),
						themeDisplay.getLocale());
				grievanceCategoryCell.setCellValue(categoryValue);
			}

			Cell userTypeCell = row.createCell(1);
			if (Validator.isNotNull(grievance.getUserType())) {
				categoryValue = CategoryUtil.fetchCategoryNamebyCategoryId(grievance.getUserType(),
						themeDisplay.getLocale());
				userTypeCell.setCellValue(categoryValue);
			}

			Cell mobileNumberCell = row.createCell(2);
			mobileNumberCell.setCellValue(grievance.getMobileNumber());

			Cell complaintDetailsCell = row.createCell(3);
			complaintDetailsCell.setCellValue(grievance.getComplaintDetails());

			Cell userNameCell = row.createCell(4);
			userNameCell.setCellValue(grievance.getUserName());

			Cell statusCell = row.createCell(5);
			statusCell.setCellValue(StatusConstants.getStatusLabel(grievance.getStatus()));

			Cell createDateCell = row.createCell(6);
			createDateCell
					.setCellValue(DateFormatterUtil.parseDate(grievance.getCreateDate(), DateConstants.DD_MMM_YYYY));

			Cell responseDetailsCell = row.createCell(7);
			responseDetailsCell.setCellValue(grievance.getResponseDetails());

			Cell responseByCell = row.createCell(8);
			if (Validator.isNotNull(grievance.getResponseBy())) {
				responseByCell.setCellValue(UserLocalServiceUtil.fetchUser(grievance.getResponseBy()).getFullName());
			}

			Cell responseDate = row.createCell(9);
			responseDate
					.setCellValue(DateFormatterUtil.parseDate(grievance.getResponseDate(), DateConstants.DD_MMM_YYYY));

			Cell grievanceapplicationNo = row.createCell(10);
			grievanceapplicationNo.setCellValue(grievance.getGrievanceNumber());

			refNum++;
		}

		return sheet;
	}

	private static final Log _logger = LogFactoryUtil.getLog(ExcelGenerationCells.class);

	public static Sheet procesCashCreditCustomerCells(List<SalesCustomer> customers, Sheet sheet,
			ThemeDisplay themeDisplay) {
		int refNum = 1;

		for (SalesCustomer customer : customers) {

			Row row = sheet.createRow(refNum);

			Cell cell1 = row.createCell(0);
			cell1.setCellValue(customer.getMobileNumber());

			Cell cell2 = row.createCell(1);
			cell2.setCellValue(customer.getEmailAddress());

			Cell cell3 = row.createCell(2);
			cell3.setCellValue(customer.getTitle());

			Cell cell4 = row.createCell(3);
			cell4.setCellValue(customer.getContactPersonName());

			Cell cell5 = row.createCell(4);
			cell5.setCellValue(customer.getContactPersonDesignation());

			Cell cell6 = row.createCell(5);
			cell6.setCellValue(customer.getOfficeName());

			Cell cell7 = row.createCell(6);
			cell7.setCellValue(customer.getOrganizationName());

			Cell cell8 = row.createCell(7);
			cell8.setCellValue(customer.getOrganizationType());

			Cell cell9 = row.createCell(8);
			cell9.setCellValue(GenderConstants.getGenderLabel(customer.getGender()));

			Cell cell10 = row.createCell(9);
			cell10.setCellValue(StatusConstants.getStatusLabel(customer.getStatus()));

			Cell cell11 = row.createCell(10);
			cell11.setCellValue(DateFormatterUtil.parseDate(customer.getCreateDate(), DateConstants.DD_MMM_YYYY));

			// Cell cell12 = row.createCell(11);
			// cell12.setCellValue(DateFormatterUtil.parseDate(customer.getModifiedDate(),
			// DateConstants.DD_MMM_YYYY));

			Cell cell13 = row.createCell(11);
			cell13.setCellValue(customer.getUserType());

			List<Address> addresses = AddressLocalServiceUtil
					.getAddressListByClassNameAndClassPK(customer.getSalesCustomerId(), SalesCustomer.class.getName());

			for (Address address : addresses) {

				List<AssetCategory> categories = CategoryUtil.fetchCategoriesList(
						Arrays.asList(address.getRegion(), address.getDistrict(), address.getUpazilla(),
								address.getCityCorporationOrMunicipality(), address.getUnionOrWard()));

				for (AssetCategory category : categories) {

					if (category.getCategoryId() == address.getRegion()) {
						Cell cell14 = row.createCell(12);
						cell14.setCellValue(category.getTitle(themeDisplay.getLocale()));

					}
					if (category.getCategoryId() == address.getDistrict()) {
						Cell cell15 = row.createCell(13);
						cell15.setCellValue(category.getTitle(themeDisplay.getLocale()));

					}
					if (category.getCategoryId() == address.getUpazilla()) {
						Cell cell16 = row.createCell(14);
						cell16.setCellValue(category.getTitle(themeDisplay.getLocale()));

					}
					if (category.getCategoryId() == address.getCityCorporationOrMunicipality()) {
						Cell cell17 = row.createCell(15);
						cell17.setCellValue(category.getTitle(themeDisplay.getLocale()));

					}
					if (category.getCategoryId() == address.getUnionOrWard()) {
						Cell cell18 = row.createCell(16);
						cell18.setCellValue(category.getTitle(themeDisplay.getLocale()));

					}

				}

				Cell cell19 = row.createCell(17);
				cell19.setCellValue(address.getZipCode());

				Cell cell120 = row.createCell(18);
				cell120.setCellValue(address.getPostOffice());

				Cell cell21 = row.createCell(19);
				cell21.setCellValue(address.getVillageOrRoad());

				Cell cell22 = row.createCell(20);
				cell22.setCellValue(address.getMouzaOrMoholla());

				Cell cell23 = row.createCell(21);
				cell23.setCellValue(address.getAddress());

			}

			refNum++;

		}

		return sheet;

	}
	
	public static Sheet processFoodGrainCells(List<FGLicenseInfo> foodGrainLicenses, Sheet sheet, ThemeDisplay themeDisplay) {
		int refNum = 1;
		
		for (FGLicenseInfo fgLicense : foodGrainLicenses) {
			
			Row row = sheet.createRow(refNum);
			
			Cell statusCell = row.createCell(0);
			statusCell.setCellValue(StatusConstants.getStatusLabel(fgLicense.getStatus()));
			
			Cell createDateCell = row.createCell(1);
			createDateCell.setCellValue(DateFormatterUtil.parseDate(fgLicense.getCreateDate(), DateConstants.DD_MMM_YYYY));
			
			Cell foodGrainLicenseApplicationNumberCell = row.createCell(2);
			foodGrainLicenseApplicationNumberCell.setCellValue(fgLicense.getApplicationNumber());
			
			Cell nationalIdCell = row.createCell(3);
			nationalIdCell.setCellValue(fgLicense.getNationalId());
			
			Cell foodgrainLicenseNoCell = row.createCell(4);
			foodgrainLicenseNoCell.setCellValue(fgLicense.getFoodgrainLicenseNumber());
			
			Cell applicantNameCell = row.createCell(5);
			applicantNameCell.setCellValue(fgLicense.getApplicantName());
			
			Cell businessName = row.createCell(6);
			businessName.setCellValue(fgLicense.getBusinessName());
			
			Cell businessType = row.createCell(7);
			businessType.setCellValue(fgLicense.getBusinessType());
			
			Cell foodGrainLicenseIssueDateCell = row.createCell(8);
			foodGrainLicenseIssueDateCell.setCellValue(DateFormatterUtil.parseDate(fgLicense.getFoodgrainLicenseIssueDate(), DateConstants.DD_MMM_YYYY));
			
			Cell foodGrainLicenseExpiryDateCell = row.createCell(9);
			foodGrainLicenseExpiryDateCell.setCellValue(DateFormatterUtil.parseDate(fgLicense.getFoodgrainLicenseExpiryDate(), DateConstants.DD_MMM_YYYY));
			
			Cell applicationTypeCell = row.createCell(10);
			applicationTypeCell.setCellValue(fgLicense.getApplicationType());
			
			
			refNum++;
		}	
		return sheet;
	}
	
	
}