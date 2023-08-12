/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package bd.gov.dgfood.license.management.system.service.impl;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.Conjunction;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.common.services.model.Address;
import bd.gov.dgfood.common.services.service.AddressLocalService;
import bd.gov.dgfood.common.util.ApplicationNumberUtil;
import bd.gov.dgfood.common.util.constants.AddressConstants;
import bd.gov.dgfood.common.util.constants.ParameterConstants;
import bd.gov.dgfood.common.util.constants.StatusConstants;
import bd.gov.dgfood.common.util.validator.DataValidationException;
import bd.gov.dgfood.license.management.system.constants.FoodGrainLicenseConstants;
import bd.gov.dgfood.license.management.system.model.FGLicenseDetails;
import bd.gov.dgfood.license.management.system.model.FGLicenseInfo;
import bd.gov.dgfood.license.management.system.service.FGLicenseDetailsLocalService;
import bd.gov.dgfood.license.management.system.service.base.FGLicenseInfoLocalServiceBaseImpl;
import bd.gov.dgfood.license.management.system.validator.FoodGrainLicenseValidator;

/**
 * @author Ashish V
 */
@Component(property = "model.class.name=bd.gov.dgfood.license.management.system.model.FGLicenseInfo", service = AopService.class)
public class FGLicenseInfoLocalServiceImpl extends FGLicenseInfoLocalServiceBaseImpl {

	/**
	 * Create a new record in Foodgrain License Info table It stores the basic
	 * information of FG Licensee Registration form.
	 * 
	 */
	public FGLicenseInfo addFgLicenseInfo(long fgLicenseMasterId, String nationalId, String applicationNumber,
			String tradeLicenseNumber, String applicantName, String businessName, String businessType, String division,
			String district, String upazila, long businessAddressId, String applicationType,
			ServiceContext serviceContext) {

		FGLicenseInfo fgLicenseInfo = createFGLicenseInfo(counterLocalService.increment(FGLicenseInfo.class.getName()));
		fgLicenseInfo.setFgLicenseMasterId(fgLicenseMasterId);
		fgLicenseInfo.setApplicationNumber(applicationNumber);

		// Registration details
		fgLicenseInfo.setNationalId(nationalId);
		fgLicenseInfo.setApplicantName(applicantName);
		fgLicenseInfo.setBusinessName(businessName);
		fgLicenseInfo.setBusinessType(businessType);
		fgLicenseInfo.setApplicationType(applicationType);
		fgLicenseInfo.setBusinessAddressId(businessAddressId);
		fgLicenseInfo.setTradeLicenseNumber(tradeLicenseNumber);
		fgLicenseInfo.setDivision(division);
		fgLicenseInfo.setDistrict(district);
		fgLicenseInfo.setUpazila(upazila);

		// Liferay Audit details
		fgLicenseInfo.setGroupId(serviceContext.getScopeGroupId());
		fgLicenseInfo.setCompanyId(serviceContext.getCompanyId());
		fgLicenseInfo.setCreateDate(new Date());
		fgLicenseInfo.setModifiedDate(new Date());

		// Status Details
		fgLicenseInfo.setStatus(StatusConstants.STATUS_PENDING);
		fgLicenseInfo.setStatusDate(new Date());

		return addFGLicenseInfo(fgLicenseInfo);

	}

	/**
	 * This method is used to store the New Foodgrain License application data.
	 * 
	 * @throws PortalException
	 * 
	 */
	public FGLicenseInfo addFGLicenseFormData(String nationalId, String mobileNumber, Date dateOfBirth,
			String emailAddress, String password, String applicantName, int gender, int maritalStatus,
			String fatherName, String motherName, String tradeLicenseNo, Date tradeLicenseExpiryDate,
			String tradeLicenseIssuerCode, String tradeLicenseIssuerCity, String taxIdentificationNumber,
			String businessIdentificationNumber, long permanentRegion, long permanentDistrict, long permanentUpazila,
			long permanentCityCorporationOrMunicipality, long permanentUnionOrWard, long permanentZipCode,
			String permanentPostOffice, String permanentVillageOrRoad, String permanentMouzaOrMoholla,
			String permanentHouseAddress, long presentRegion, long presentDistrict, long presentUpazila,
			long presentCityCorporationOrMunicipality, long presentUnionOrWard, long presentZipCode,
			String presentPostOffice, String presentVillageOrRoad, String presentMouzaOrMoholla,
			String presentHouseAddress, String businessName, String businessType, long businessRegion,
			long businessDistrict, long businessUpazila, long businessCityCorporationOrMunicipality,
			long businessUnionOrWard, long businessZipCode, String businessPostOffice, String businessVillageOrRoad,
			String businessMouzaOrMoholla, String businessHouseAddress, long profilePhotographDocId,
			long tradeLicenseDocId, long businessIdentificationNumberDocId, long taxIdentificationNumberDocId,
			long bankStatementDocId, ServiceContext serviceContext) throws PortalException {

		// Validate Submitted FG License Form data
		FoodGrainLicenseValidator.validateFoodGrainLicenseData(nationalId, mobileNumber, dateOfBirth, emailAddress,
				password, applicantName, gender, maritalStatus, fatherName, motherName, tradeLicenseNo,
				tradeLicenseExpiryDate, tradeLicenseIssuerCode, tradeLicenseIssuerCity, taxIdentificationNumber,
				businessIdentificationNumber, permanentRegion, permanentDistrict, permanentUpazila,
				permanentCityCorporationOrMunicipality, permanentUnionOrWard, permanentZipCode, permanentPostOffice,
				permanentVillageOrRoad, permanentMouzaOrMoholla, permanentHouseAddress, presentRegion, presentDistrict,
				presentUpazila, presentCityCorporationOrMunicipality, presentUnionOrWard, presentZipCode,
				presentPostOffice, presentVillageOrRoad, presentMouzaOrMoholla, presentHouseAddress, businessName,
				businessType, businessRegion, businessDistrict, businessUpazila, businessCityCorporationOrMunicipality,
				businessUnionOrWard, businessZipCode, businessPostOffice, businessVillageOrRoad, businessMouzaOrMoholla,
				businessHouseAddress);

		// Validate if user has any active or pending Foodgrain License
		FoodGrainLicenseValidator.validateUserForNewFGL(nationalId, serviceContext);

		Address permanentAddress = null;
		Address presentAddress = null;
		Address businessAddress = null;
		FGLicenseDetails fgLicenseDetails = null;
		FGLicenseInfo fgLicenseInfo = null;

		try {

			String fglApplicationNo = ApplicationNumberUtil.generateApplicationNumber(
					counterLocalService.increment(
							FGLicenseInfo.class.getName() + FoodGrainLicenseConstants.FGL_APPLICATION_NO_PREFIX, 1),
					FoodGrainLicenseConstants.FGL_APPLICATION_NO_PREFIX);

			permanentAddress = addressLocalService.addAddress(permanentRegion, permanentDistrict, permanentUpazila,
					permanentCityCorporationOrMunicipality, permanentUnionOrWard, permanentZipCode, permanentPostOffice,
					permanentVillageOrRoad, permanentMouzaOrMoholla, permanentHouseAddress,
					AddressConstants.ADDRESS_PERMANENT);

			presentAddress = addressLocalService.addAddress(presentRegion, presentDistrict, presentUpazila,
					presentCityCorporationOrMunicipality, presentUnionOrWard, presentZipCode, presentPostOffice,
					presentVillageOrRoad, presentMouzaOrMoholla, presentHouseAddress, AddressConstants.ADDRESS_PRESENT);

			businessAddress = addressLocalService.addAddress(businessRegion, businessDistrict, businessUpazila,
					businessCityCorporationOrMunicipality, businessUnionOrWard, businessZipCode, businessPostOffice,
					businessVillageOrRoad, businessMouzaOrMoholla, businessHouseAddress,
					AddressConstants.ADDRESS_BUSINESS);

			fgLicenseDetails = fgLicenseDetailsLocalService.addFGLicenseDetails(nationalId, fglApplicationNo,
					applicantName, tradeLicenseNo, tradeLicenseExpiryDate, tradeLicenseIssuerCode,
					tradeLicenseIssuerCity, businessIdentificationNumber, taxIdentificationNumber, tradeLicenseDocId,
					businessIdentificationNumberDocId, taxIdentificationNumberDocId, bankStatementDocId,
					ParameterConstants.APPLICATION_TYPE_NEW);

			// TODO: Once the Address table updated, update the address related parameter
			// and instead of blank values pass the present division, district and union
			fgLicenseInfo = addFgLicenseInfo(fgLicenseDetails.getFgLicenseMasterId(), nationalId, fglApplicationNo,
					tradeLicenseNo, applicantName, businessName, businessType, StringPool.BLANK, StringPool.BLANK,
					StringPool.BLANK, businessAddress.getAddressId(), ParameterConstants.APPLICATION_TYPE_NEW,
					serviceContext);

			// Create Asset
			AssetEntry assetEntry = assetEntryLocalService.updateEntry(serviceContext.getUserId(),
					serviceContext.getScopeGroupId(), fgLicenseInfo.getCreateDate(), fgLicenseInfo.getModifiedDate(),
					FGLicenseInfo.class.getName(), fgLicenseInfo.getPrimaryKey(), fgLicenseInfo.getUuid(), 0,
					serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames(), true, true, null, null,
					null, null, ContentTypes.TEXT_HTML, fgLicenseInfo.getApplicantName(), null, null, null, null, 0, 0,
					null);

			assetLinkLocalService.updateLinks(serviceContext.getUserId(), assetEntry.getEntryId(),
					serviceContext.getAssetLinkEntryIds(), AssetLinkConstants.TYPE_RELATED);

			// Initiate Workflow
			Map<String, Serializable> workflowContext = new HashMap<>();
			workflowContext.put("locationId", presentDistrict);

			// TODO: After adding Workflow handler uncomment below pice of code
//			WorkflowHandlerRegistryUtil.startWorkflowInstance(fgLicenseInfo.getCompanyId(), fgLicenseInfo.getGroupId(),
//					serviceContext.getUserId(), FGLicenseInfo.class.getName(), fgLicenseInfo.getPrimaryKey(),
//					fgLicenseInfo, serviceContext, workflowContext);

		} catch (DataValidationException dataValidationException) {

			logger.error("Invalid user or user data: " + dataValidationException.getMessage());
			if (logger.isDebugEnabled()) {
				dataValidationException.printStackTrace();
			}
			rollbackNewFGLicenseRegistration(permanentAddress, presentAddress, businessAddress, fgLicenseDetails,
					fgLicenseInfo);

			throw dataValidationException;
		} catch (PortalException portalException) {
			logger.error(
					"Exception occured while adding new Foodgrain License Details: " + portalException.getMessage());
			if (logger.isDebugEnabled()) {
				portalException.printStackTrace();
			}
			rollbackNewFGLicenseRegistration(permanentAddress, presentAddress, businessAddress, fgLicenseDetails,
					fgLicenseInfo);

			throw portalException;
		}

		return fgLicenseInfo;

	}

	/**
	 * Returns number of New Foodgrain License Applications available for the given
	 * National id
	 * 
	 * @param nationalId
	 * @return
	 */
	public long getActiveFGLicenseCountByNationalId(String nationalId) {
		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		conjunction.add(RestrictionsFactoryUtil.eq(ParameterConstants.NATIONAL_ID, nationalId));
		conjunction.add(RestrictionsFactoryUtil.eq(ParameterConstants.APPLICATION_TYPE,
				ParameterConstants.APPLICATION_TYPE_NEW));
		conjunction.add(RestrictionsFactoryUtil.ne(ParameterConstants.STATUS, StatusConstants.STATUS_REJECTED));
		return fgLicenseInfoPersistence.countWithDynamicQuery(dynamicQuery().add(conjunction));
	}

	/**
	 * Returns number of new Foodgrain License application are in pending state for
	 * the given National id
	 * 
	 * @param nationalId
	 * @return
	 */
	public long getPendingFGLicenseCountByNationalId(String nationalId) {
		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		conjunction.add(RestrictionsFactoryUtil.eq(ParameterConstants.NATIONAL_ID, nationalId));
		conjunction.add(RestrictionsFactoryUtil.eq(ParameterConstants.APPLICATION_TYPE,
				ParameterConstants.APPLICATION_TYPE_NEW));
		conjunction.add(RestrictionsFactoryUtil.ne(ParameterConstants.STATUS, StatusConstants.STATUS_REJECTED));
		conjunction.add(RestrictionsFactoryUtil.ne(ParameterConstants.STATUS, StatusConstants.STATUS_APPROVED));
		return fgLicenseInfoPersistence.countWithDynamicQuery(dynamicQuery().add(conjunction));
	}

	/**
	 * This method is used to fetch FG licenses with application number, date of
	 * birth and National Id. It compares dateofbirth and NID from user_ table as
	 * well.
	 * 
	 * @throws Exception
	 *
	 */
	public FGLicenseInfo fetchFGLicenseWithApplicationNumberNIDDateOfBirth(ServiceContext serviceContext,
			String applicationNumber, String nationalId, Date dateOfBirth) throws PortalException {
		User user = userLocalService.fetchUserByScreenName(serviceContext.getCompanyId(), nationalId);
		logger.debug("user object : " + user);
		logger.debug("user entered dateOfBirth :" + dateOfBirth);

		if (Validator.isNotNull(user) && Validator.isNotNull(user.getBirthday())
				&& user.getBirthday().compareTo(dateOfBirth) == 0) {
			logger.debug("user date of birth matches...fetch application from master info table..");
			return this.fgLicenseInfoPersistence.fetchByApplicationNumberNIDDateOfBirth(applicationNumber, nationalId);
		}
		return null;
	}

	/**
	 * Fetch the FG License application by Application Number
	 * 
	 */
	public FGLicenseInfo fetchFGLicenseByApplicationNumber(String applicationNumber) {

		return this.fgLicenseInfoPersistence.fetchByApplicationNumber(applicationNumber);
	}

	/**
	 * fetch the records based on the curent user location and other search & filter
	 * options.
	 * 
	 * Search & filter optional are optional
	 * 
	 * 
	 */
	public List<FGLicenseInfo> searchFGLicenseRecords(long groupId, Map<String, Object> filterOptions,
			String locationName, String locationValue, String keywords, Date fromDate, Date toDate, int start, int end,
			OrderByComparator<FGLicenseInfo> orderByComparator) {

		return dynamicQuery(
				getSearchDynamicQuery(groupId, filterOptions, locationName, locationValue, keywords, fromDate, toDate),
				start, end, orderByComparator);

	}

	/**
	 * Fetch the number of records are available based on the curent user location
	 * and other search & filter options.
	 * 
	 * Search & filter optional are optional
	 * 
	 * 
	 */
	public long searchFGLicenseRecordsCount(long groupId, Map<String, Object> filterOptions, String locationName,
			String locationValue, String keywords, Date fromDate, Date toDate) {

		return dynamicQueryCount(
				getSearchDynamicQuery(groupId, filterOptions, locationName, locationValue, keywords, fromDate, toDate));

	}

	/**
	 * Generates the Dynamic Query based on the given user search and filter options
	 */
	private DynamicQuery getSearchDynamicQuery(long groupId, Map<String, Object> filterOptions, String locationName,
			String locationValue, String keywords, Date fromDate, Date toDate) {

		DynamicQuery searchFoodgrainLicenseDynamicQuery = dynamicQuery();

		Conjunction filterCriterion = RestrictionsFactoryUtil.conjunction();
		if (Validator.isNotNull(groupId)) {
			filterCriterion.add(RestrictionsFactoryUtil.eq("groupId", groupId));
		}

		if (Validator.isNotNull(locationName) && Validator.isNotNull(locationValue)) {
			filterCriterion.add(RestrictionsFactoryUtil.eq(locationName, locationValue));
		}

		if (Validator.isNotNull(filterOptions) && filterOptions.size() > 0) {
			for (Entry<String, Object> criterionEntry : filterOptions.entrySet()) {
				filterCriterion.add(RestrictionsFactoryUtil.eq(criterionEntry.getKey(), criterionEntry.getValue()));
			}
		}

		if (Validator.isNotNull(fromDate)) {
			filterCriterion.add(RestrictionsFactoryUtil.ge(ParameterConstants.CREATED_DATE, fromDate));
		}
		if (Validator.isNotNull(toDate)) {
			filterCriterion.add(RestrictionsFactoryUtil.le(ParameterConstants.CREATED_DATE, toDate));
		}

		if (Validator.isNotNull(keywords)) {
			keywords = StringPool.PERCENT + keywords + StringPool.PERCENT;

			Disjunction searchCiterion = RestrictionsFactoryUtil.disjunction();

			searchCiterion.add(RestrictionsFactoryUtil.like(ParameterConstants.APPLICATION_NUMBER, keywords));
			searchCiterion.add(RestrictionsFactoryUtil.like(ParameterConstants.TRADE_LICENSE_NUMBER, keywords));
			searchCiterion.add(RestrictionsFactoryUtil.like(ParameterConstants.EMAIL_ADDRESS, keywords));
			searchCiterion.add(RestrictionsFactoryUtil.like(ParameterConstants.MOBILE_NUMBER, keywords));
			searchCiterion.add(RestrictionsFactoryUtil.like(ParameterConstants.NATIONAL_ID, keywords));
			searchCiterion.add(RestrictionsFactoryUtil.like(ParameterConstants.APPLICATION_NUMBER, keywords));

			filterCriterion.add(searchCiterion);
		}

		logger.debug("Dynamic Query Created Sucessfully");
		logger.debug(filterCriterion);

		return searchFoodgrainLicenseDynamicQuery.add(filterCriterion);
	}

	/**
	 * This method is to rollback the New FG License Registration oparation. If any
	 * error occured when the data is pushed to database, rollback method will
	 * remove all the data that is alredy pushed to databse.
	 * 
	 */
	private void rollbackNewFGLicenseRegistration(Address permanentAddress, Address presentAddress,
			Address businessAddress, FGLicenseDetails fgLicenseDetails, FGLicenseInfo fgLicenseInfo) {

		if (Validator.isNotNull(fgLicenseInfo)) {
			super.deleteFGLicenseInfo(fgLicenseInfo);
		}

		if (Validator.isNotNull(fgLicenseDetails)) {
			fgLicenseDetailsLocalService.deleteFGLicenseDetails(fgLicenseDetails);
		}

		if (Validator.isNotNull(permanentAddress)) {
			addressLocalService.deleteAddress(permanentAddress);
		}

		if (Validator.isNotNull(presentAddress)) {
			addressLocalService.deleteAddress(presentAddress);
		}

		if (Validator.isNotNull(businessAddress)) {
			addressLocalService.deleteAddress(businessAddress);
		}
	}

	private Log logger = LogFactoryUtil.getLog(this.getClass());

	@Reference
	private AddressLocalService addressLocalService;

	@Reference
	private FGLicenseDetailsLocalService fgLicenseDetailsLocalService;

}