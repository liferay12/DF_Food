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

package bd.gov.dgfood.farmer.information.management.system.service.impl;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.Conjunction;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.vulcan.multipart.BinaryFile;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.common.services.model.Address;
import bd.gov.dgfood.common.services.model.Attachment;
import bd.gov.dgfood.common.services.service.AddressLocalService;
import bd.gov.dgfood.common.services.service.AttachmentLocalService;
import bd.gov.dgfood.common.util.ApplicationNumberUtil;
import bd.gov.dgfood.common.util.DLUploadUtil;
import bd.gov.dgfood.common.util.DateFormatterUtil;
import bd.gov.dgfood.common.util.constants.AddressConstants;
import bd.gov.dgfood.common.util.constants.DocumentLibraryConstants;
import bd.gov.dgfood.common.util.constants.FileConstants;
import bd.gov.dgfood.common.util.constants.ParameterConstants;
import bd.gov.dgfood.common.util.constants.StatusConstants;
import bd.gov.dgfood.common.util.validator.DataValidationException;
import bd.gov.dgfood.farmer.information.management.system.exception.FarmerRegistrationInternalErrorException;
import bd.gov.dgfood.farmer.information.management.system.model.FarmerRegistration;
import bd.gov.dgfood.farmer.information.management.system.service.base.FarmerRegistrationLocalServiceBaseImpl;
import bd.gov.dgfood.farmer.information.management.system.util.FarmerManagementUtil;
import bd.gov.dgfood.farmer.information.management.system.validator.FarmerInformationValidator;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=bd.gov.dgfood.farmer.information.management.system.model.FarmerRegistration", service = AopService.class)
public class FarmerRegistrationLocalServiceImpl extends FarmerRegistrationLocalServiceBaseImpl {

	/**
	 * It will add a new Farmer Registration record in the Farmer Registration
	 * master table
	 */
	public FarmerRegistration addFarmerRegistration(String nationalId, String emailAddress, String mobileNumber,
			Date dateOfBirth, String farmerName, String fatherName, String motherName, int gender,
			String krishiCardNumber, int maritalStatus, String cultivableLandSeason1Name,
			float cultivableLandSeason1Area, String cultivableLandSeason1Unit, String cultivableLandSeason2Name,
			float cultivableLandSeason2Area, String cultivableLandSeason2Unit, String cultivableLandSeason3Name,
			float cultivableLandSeason3Area, String cultivableLandSeason3Unit, String farmerCategory, String password,
			String remarks, long groupId, ServiceContext serviceContext) {

		FarmerRegistration farmerRegistration = createFarmerRegistration(
				counterLocalService.increment(this.getClass().getName(), 1));
		farmerRegistration.setApplicationNumber(
				ApplicationNumberUtil.generateApplicationNumber(farmerRegistration.getFarmerRegistrationId(), "FIMS"));

		farmerRegistration.setNationalId(nationalId);
		farmerRegistration.setEmailAddress(emailAddress);
		farmerRegistration.setMobileNumber(mobileNumber);
		farmerRegistration.setDateOfBirth(dateOfBirth);
		farmerRegistration.setFarmerName(farmerName);
		farmerRegistration.setFatherName(fatherName);
		farmerRegistration.setMotherName(motherName);
		farmerRegistration.setGender(gender);
		farmerRegistration.setKrishokCardNumber(krishiCardNumber);
		farmerRegistration.setMaritalStatus(maritalStatus);

		Map<String, Serializable> cultivableLandSeason1 = new HashMap<String, Serializable>();
		cultivableLandSeason1.put(ParameterConstants.NAME, cultivableLandSeason1Name);
		cultivableLandSeason1.put(ParameterConstants.AREA, cultivableLandSeason1Area);
		cultivableLandSeason1.put(ParameterConstants.UNIT, cultivableLandSeason1Unit);
		farmerRegistration.setCultivableLandSeason1(cultivableLandSeason1);

		Map<String, Serializable> cultivableLandSeason2 = new HashMap<String, Serializable>();
		cultivableLandSeason2.put(ParameterConstants.NAME, cultivableLandSeason2Name);
		cultivableLandSeason2.put(ParameterConstants.AREA, cultivableLandSeason2Area);
		cultivableLandSeason2.put(ParameterConstants.UNIT, cultivableLandSeason2Unit);
		farmerRegistration.setCultivableLandSeason2(cultivableLandSeason2);

		Map<String, Serializable> cultivableLandSeason3 = new HashMap<String, Serializable>();
		cultivableLandSeason3.put(ParameterConstants.NAME, cultivableLandSeason3Name);
		cultivableLandSeason3.put(ParameterConstants.AREA, cultivableLandSeason3Area);
		cultivableLandSeason3.put(ParameterConstants.UNIT, cultivableLandSeason3Unit);
		farmerRegistration.setCultivableLandSeason3(cultivableLandSeason3);

		farmerRegistration.setFarmerCategory(farmerCategory);
		farmerRegistration.setPassword(password);
		farmerRegistration.setRemarks(remarks);

		// TODO: Updated Version code implemantation
		farmerRegistration.setVersion(counterLocalService
				.increment(FarmerRegistration.class.getName() + farmerRegistration.getFarmerRegistrationId(), 1));

		farmerRegistration.setGroupId(groupId);
		farmerRegistration.setCompanyId(serviceContext.getCompanyId());
		farmerRegistration.setCreateDate(new Date());
		farmerRegistration.setCreatedBy(serviceContext.getUserId());

		farmerRegistration.setStatus(StatusConstants.STATUS_PENDING);
		farmerRegistration.setStatusDate(new Date());

		farmerRegistration = addFarmerRegistration(farmerRegistration);
		logger.debug(farmerRegistration);
		return farmerRegistration;
	}

	public FarmerRegistration updateFarmerRegistration(long farmerRegistrationId, String nationalId,
			String emailAddress, String mobileNumber, Date dateOfBirth, String farmerName, String fatherName,
			String motherName, int gender, String krishiCardNumber, int maritalStatus, String cultivableLandSeason1Name,
			float cultivableLandSeason1Area, String cultivableLandSeason1Unit, String cultivableLandSeason2Name,
			float cultivableLandSeason2Area, String cultivableLandSeason2Unit, String cultivableLandSeason3Name,
			float cultivableLandSeason3Area, String cultivableLandSeason3Unit, String farmerCategory, String password,
			String remarks, long groupId, ServiceContext serviceContext) {

		FarmerRegistration farmerRegistration = fetchFarmerRegistration(farmerRegistrationId);

		farmerRegistration.setNationalId(nationalId);
		farmerRegistration.setEmailAddress(emailAddress);
		farmerRegistration.setMobileNumber(mobileNumber);
		farmerRegistration.setDateOfBirth(dateOfBirth);
		farmerRegistration.setFarmerName(farmerName);
		farmerRegistration.setFatherName(fatherName);
		farmerRegistration.setMotherName(motherName);
		farmerRegistration.setGender(gender);
		farmerRegistration.setKrishokCardNumber(krishiCardNumber);
		farmerRegistration.setMaritalStatus(maritalStatus);

		Map<String, Serializable> cultivableLandSeason1 = new HashMap<String, Serializable>();
		cultivableLandSeason1.put(ParameterConstants.NAME, cultivableLandSeason1Name);
		cultivableLandSeason1.put(ParameterConstants.AREA, cultivableLandSeason1Area);
		cultivableLandSeason1.put(ParameterConstants.UNIT, cultivableLandSeason1Unit);
		farmerRegistration.setCultivableLandSeason1(cultivableLandSeason1);

		Map<String, Serializable> cultivableLandSeason2 = new HashMap<String, Serializable>();
		cultivableLandSeason2.put(ParameterConstants.NAME, cultivableLandSeason2Name);
		cultivableLandSeason2.put(ParameterConstants.AREA, cultivableLandSeason2Area);
		cultivableLandSeason2.put(ParameterConstants.UNIT, cultivableLandSeason2Unit);
		farmerRegistration.setCultivableLandSeason2(cultivableLandSeason2);

		Map<String, Serializable> cultivableLandSeason3 = new HashMap<String, Serializable>();
		cultivableLandSeason3.put(ParameterConstants.NAME, cultivableLandSeason3Name);
		cultivableLandSeason3.put(ParameterConstants.AREA, cultivableLandSeason3Area);
		cultivableLandSeason3.put(ParameterConstants.UNIT, cultivableLandSeason3Unit);
		farmerRegistration.setCultivableLandSeason3(cultivableLandSeason3);

		farmerRegistration.setFarmerCategory(farmerCategory);
		farmerRegistration.setPassword(password);
		farmerRegistration.setRemarks(remarks);

		// TODO: Updated Version code implemantation
		farmerRegistration.setVersion(farmerRegistration.getVersion() + 1);

		farmerRegistration.setModifiedDate(new Date());
		farmerRegistration.setModifiedBy(serviceContext.getUserId());

		farmerRegistration.setStatus(WorkflowConstants.STATUS_DRAFT);
		farmerRegistration.setStatusDate(new Date());

		farmerRegistration = updateFarmerRegistration(farmerRegistration);
		logger.debug(farmerRegistration);
		return farmerRegistration;
	}

	/**
	 * Stores Farmer registration Form data by creating Farmer Registration record
	 * along with addition records like Framer address data and attachments
	 * 
	 * @throws DataValidationException
	 * 
	 */
	public FarmerRegistration addFarmerRegistrationFormData(boolean isHeadlessRequest, String nationalId,
			String emailAddress, String mobileNumber, String dateOfBirth, String farmerName, String fatherName,
			String motherName, int gender, String krishiCardNumber, int maritalStatus, String cultivableLandSeason1Name,
			float cultivableLandSeason1Area, String cultivableLandSeason1Unit, String cultivableLandSeason2Name,
			float cultivableLandSeason2Area, String cultivableLandSeason2Unit, String cultivableLandSeason3Name,
			float cultivableLandSeason3Area, String cultivableLandSeason3Unit, String farmerCategory, String password,
			String remarks, long permanentRegion, long permanentZilla, long permanentUpazila,
			long permanentCityCorporationOrMunicipality, long permanentUnionOrWard, long permanentZipCode,
			String permanentPostOffice, String permanentVillageOrRoad, String permanentMouzaOrMoholla,
			String permanentHouseAddress, long presentRegion, long presentZilla, long presentUpazila,
			long presentCityCorporationOrMunicipality, long presentUnionOrWard, long presentZipCode,
			String presentPostOffice, String presentVillageOrRoad, String presentMouzaOrMoholla,
			String presentHouseAddress, BinaryFile profilePhotograph, BinaryFile krishiCard, long groupId,
			ServiceContext serviceContext) throws PortalException {

		FarmerRegistration oldFarmerRegistration = null;
		Address oldPermanentAddress = null;
		Address oldPresentAddress = null;
		Attachment oldProfilePhotographAttachment = null;
		Attachment oldKrishiCardAttachment = null;

		FarmerRegistration farmerRegistration = null;
		Address permanentAddress = null;
		Address presentAddress = null;
		Attachment profilePhotographAttachment = null;
		Attachment krishiCardAttachment = null;

		Date parsedDateOfBirth = DateFormatterUtil.parseDate(dateOfBirth);

		// TODO: Need to fix the code before enabling back-end validation
		FarmerInformationValidator.validateFarmerRegistrationData(isHeadlessRequest, nationalId, emailAddress,
				mobileNumber, parsedDateOfBirth, farmerName, fatherName, motherName, gender, krishiCardNumber,
				maritalStatus, cultivableLandSeason1Name, cultivableLandSeason1Area, cultivableLandSeason1Unit,
				cultivableLandSeason2Name, cultivableLandSeason2Area, cultivableLandSeason2Unit,
				cultivableLandSeason3Name, cultivableLandSeason3Area, cultivableLandSeason3Unit, farmerCategory,
				password, remarks, permanentRegion, permanentZilla, permanentUpazila,
				permanentCityCorporationOrMunicipality, permanentUnionOrWard, permanentZipCode, permanentPostOffice,
				permanentVillageOrRoad, permanentMouzaOrMoholla, permanentHouseAddress, presentRegion, presentZilla,
				presentUpazila, presentCityCorporationOrMunicipality, presentUnionOrWard, presentZipCode,
				presentPostOffice, presentVillageOrRoad, presentMouzaOrMoholla, presentHouseAddress, profilePhotograph,
				krishiCard);

		try {
			oldFarmerRegistration = fetchFarmerRegistrationByNationalId(nationalId);
			if (Validator.isNotNull(oldFarmerRegistration)) {
				farmerRegistration = farmerRegistrationLocalService.updateFarmerRegistration(
						oldFarmerRegistration.getFarmerRegistrationId(), nationalId, emailAddress, mobileNumber,
						parsedDateOfBirth, farmerName, fatherName, motherName, gender, krishiCardNumber, maritalStatus,
						cultivableLandSeason1Name, cultivableLandSeason1Area, cultivableLandSeason1Unit,
						cultivableLandSeason2Name, cultivableLandSeason2Area, cultivableLandSeason2Unit,
						cultivableLandSeason3Name, cultivableLandSeason3Area, cultivableLandSeason3Unit, farmerCategory,
						password, remarks, groupId, serviceContext);
			} else {
				farmerRegistration = addFarmerRegistration(nationalId, emailAddress, mobileNumber, parsedDateOfBirth,
						farmerName, fatherName, motherName, gender, krishiCardNumber, maritalStatus,
						cultivableLandSeason1Name, cultivableLandSeason1Area, cultivableLandSeason1Unit,
						cultivableLandSeason2Name, cultivableLandSeason2Area, cultivableLandSeason2Unit,
						cultivableLandSeason3Name, cultivableLandSeason3Area, cultivableLandSeason3Unit, farmerCategory,
						password, remarks, groupId, serviceContext);
			}

			List<Address> farmerRegistrationAddresses = addressLocalService.getAddressListByClassNameAndClassPK(
					farmerRegistration.getFarmerRegistrationId(), FarmerRegistration.class.getName());
			for (Address address : farmerRegistrationAddresses) {
				if (address.getAddressType().equalsIgnoreCase(AddressConstants.ADDRESS_PERMANENT)) {
					oldPermanentAddress = address;
				} else if (address.getAddressType().equalsIgnoreCase(AddressConstants.ADDRESS_PRESENT)) {
					oldPresentAddress = address;
				}
			}

			if (Validator.isNotNull(oldPermanentAddress)) {
				permanentAddress = addressLocalService.updateAddress(oldPermanentAddress.getAddressId(),
						permanentRegion, permanentZilla, permanentUpazila, permanentCityCorporationOrMunicipality,
						permanentUnionOrWard, permanentZipCode, permanentPostOffice, permanentVillageOrRoad,
						permanentMouzaOrMoholla, permanentHouseAddress);

			} else {

				permanentAddress = addressLocalService.addAddress(permanentRegion, permanentZilla, permanentUpazila,
						permanentCityCorporationOrMunicipality, permanentUnionOrWard, permanentZipCode,
						permanentPostOffice, permanentVillageOrRoad, permanentMouzaOrMoholla, permanentHouseAddress,
						AddressConstants.ADDRESS_PERMANENT, FarmerRegistration.class.getName(),
						farmerRegistration.getFarmerRegistrationId());
			}

			if (Validator.isNotNull(oldPresentAddress)) {

				presentAddress = addressLocalService.updateAddress(oldPresentAddress.getAddressId(), presentRegion,
						presentZilla, presentUpazila, presentCityCorporationOrMunicipality, presentUnionOrWard,
						presentZipCode, presentPostOffice, presentVillageOrRoad, presentMouzaOrMoholla,
						presentHouseAddress);

			} else {
				presentAddress = addressLocalService.addAddress(presentRegion, presentZilla, presentUpazila,
						presentCityCorporationOrMunicipality, presentUnionOrWard, presentZipCode, presentPostOffice,
						presentVillageOrRoad, presentMouzaOrMoholla, presentHouseAddress,
						AddressConstants.ADDRESS_PRESENT, FarmerRegistration.class.getName(),
						farmerRegistration.getFarmerRegistrationId());
			}

			if (!isHeadlessRequest) {

				long farmerFolderId = getFarmerRegistrationUserFolder(farmerRegistration.getFarmerRegistrationId(),
						serviceContext);
				List<Attachment> farmerRegistrationAttachments = attachmentLocalService
						.getAttachmentsByClassPKAndClassName(farmerRegistration.getFarmerRegistrationId(),
								FarmerRegistration.class.getName());
				for (Attachment attachment : farmerRegistrationAttachments) {
					if (attachment.getCategory().equalsIgnoreCase(FileConstants.FILE_PROFILE_PHOTOGRAPH)) {
						oldProfilePhotographAttachment = attachment;
					} else if (attachment.getCategory().equalsIgnoreCase(FileConstants.FILE_KRISHI_CARD)) {
						oldKrishiCardAttachment = attachment;
					}
				}

				if (Validator.isNotNull(oldProfilePhotographAttachment)) {
					profilePhotographAttachment = DLUploadUtil.updateAttachment(
							oldProfilePhotographAttachment.getAttachmentId(), farmerFolderId, profilePhotograph, null,
							null, DocumentLibraryConstants.ATTACHMENT_PROFILE_PHOTO, serviceContext);
				} else {
					profilePhotographAttachment = DLUploadUtil.addAttachment(farmerFolderId, profilePhotograph, null,
							null, DocumentLibraryConstants.ATTACHMENT_PROFILE_PHOTO, FarmerRegistration.class.getName(),
							farmerRegistration.getFarmerRegistrationId(), serviceContext);
				}

				if (Validator.isNotNull(oldKrishiCardAttachment)) {
					krishiCardAttachment = DLUploadUtil.updateAttachment(oldKrishiCardAttachment.getAttachmentId(),
							farmerFolderId, krishiCard, null, null, DocumentLibraryConstants.ATTACHMENT_KRISHI_CARD,
							serviceContext);
				} else {
					krishiCardAttachment = DLUploadUtil.addAttachment(farmerFolderId, krishiCard, null, null,
							DocumentLibraryConstants.ATTACHMENT_KRISHI_CARD, FarmerRegistration.class.getName(),
							farmerRegistration.getFarmerRegistrationId(), serviceContext);
				}

			}

			/* Create Asset Object for the farmer Registration Record */
			AssetEntry assetEntry = assetEntryLocalService.updateEntry(serviceContext.getUserId(),
					serviceContext.getScopeGroupId(), farmerRegistration.getCreateDate(),
					farmerRegistration.getModifiedDate(), FarmerRegistration.class.getName(),
					farmerRegistration.getPrimaryKey(), farmerRegistration.getUuid(), 0,
					serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames(), true, true, null, null,
					null, null, ContentTypes.TEXT_HTML, farmerRegistration.getFarmerName(), null, null, null, null, 0,
					0, null);
			assetLinkLocalService.updateLinks(serviceContext.getUserId(), assetEntry.getEntryId(),
					serviceContext.getAssetLinkEntryIds(), AssetLinkConstants.TYPE_RELATED);

			/* Initilize Workflow for the submited registration record */
			Map<String, Serializable> workflowContext = new HashMap<String, Serializable>();
			workflowContext.put("locationId", presentAddress.getDistrict());
			WorkflowHandlerRegistryUtil.startWorkflowInstance(farmerRegistration.getCompanyId(),
					farmerRegistration.getGroupId(), serviceContext.getUserId(), FarmerRegistration.class.getName(),
					farmerRegistration.getPrimaryKey(), farmerRegistration, serviceContext, workflowContext);

			/* Trigger Email to the farmer */
			FarmerManagementUtil.triggerRegistrationSubmissionNotification(farmerRegistration, serviceContext);

		} catch (Exception exception) {

			cleanFarmerRegistrationData(farmerRegistration, oldFarmerRegistration, permanentAddress,
					oldPermanentAddress, presentAddress, oldPresentAddress, profilePhotographAttachment,
					oldProfilePhotographAttachment, krishiCardAttachment, oldKrishiCardAttachment);

			if (logger.isDebugEnabled()) {
				exception.printStackTrace();
			}

			throw new FarmerRegistrationInternalErrorException(
					"Unable to Submit Farmer Registration data: " + exception.getMessage());

		}

		return farmerRegistration;
	}

	/**
	 * To update the status of a Farmer Registration record with the given status
	 * 
	 * @param userId
	 * @param faremerRegistrationId
	 * @param status
	 * @param serviceContext
	 * @return FarmerRegistration
	 * @throws PortalException
	 * @throws SystemException
	 */
	public FarmerRegistration updateStatus(long userId, long faremerRegistrationId, int status,
			ServiceContext serviceContext) throws PortalException, SystemException {

		User user = userLocalService.getUser(userId);
		FarmerRegistration farmerRegistration = getFarmerRegistration(faremerRegistrationId);

		farmerRegistration.setStatus(status);
		farmerRegistration.setStatusByUserId(user.getUserId());
		farmerRegistration.setStatusDate(new Date());

		return updateFarmerRegistration(farmerRegistration);
	}

	/**
	 * To get the Farme's Registration folder Id
	 * 
	 * @param farmerRegistrationId: Holds the Farmer Registration id
	 * @param serviceContext:       holds Object of ServiceContext and used for
	 *                              Folder Creation
	 * @return farmerRegistrationUserFolderId: Farme's Registration folder Id
	 */
	protected long getFarmerRegistrationUserFolder(long farmerRegistrationId, ServiceContext serviceContext) {
		Folder fimsRootFolder = DLUploadUtil.createFolder(serviceContext, 0,
				DocumentLibraryConstants.FIMS_ROOT_FOLDER_NAME);
		Folder farmerRegistrationFolder = DLUploadUtil.createFolder(serviceContext, fimsRootFolder.getFolderId(),
				DocumentLibraryConstants.FIMS_REGISTRATION_FOLDER_NAME);
		Folder farmerRegistrationUserFolder = DLUploadUtil.createFolder(serviceContext,
				farmerRegistrationFolder.getFolderId(),
				DocumentLibraryConstants.FIMS_REGISTRATION_USER_FOLDER_PREFIX + farmerRegistrationId);

		return farmerRegistrationUserFolder.getFolderId();
	}

	protected void cleanFarmerRegistrationData(FarmerRegistration farmerRegistration,
			FarmerRegistration oldFarmerRegistration, Address permanentAddress, Address oldPermanentAddress,
			Address presentAddress, Address oldPresentAddress, Attachment profilePhotographAttachment,
			Attachment oldProfilePhotographAttachment, Attachment krishiCardAttachment,
			Attachment oldKrishiCardAttachment) {

		if (Validator.isNotNull(farmerRegistration) && Validator.isNotNull(oldFarmerRegistration)) {
			updateFarmerRegistration(oldFarmerRegistration);
		} else if (Validator.isNotNull(farmerRegistration)) {
			deleteFarmerRegistration(farmerRegistration);
		}

		if (Validator.isNotNull(permanentAddress) && Validator.isNotNull(oldPermanentAddress)) {
			addressLocalService.updateAddress(oldPermanentAddress);
		} else if (Validator.isNotNull(permanentAddress)) {
			addressLocalService.deleteAddress(permanentAddress);
		}

		if (Validator.isNotNull(presentAddress) && Validator.isNotNull(oldPresentAddress)) {
			addressLocalService.updateAddress(oldPresentAddress);
		} else if (Validator.isNotNull(presentAddress)) {
			addressLocalService.deleteAddress(presentAddress);
		}

		if (Validator.isNotNull(profilePhotographAttachment) && Validator.isNotNull(oldProfilePhotographAttachment)) {
			attachmentLocalService.updateAttachment(oldProfilePhotographAttachment);
		} else if (Validator.isNotNull(profilePhotographAttachment)) {
			attachmentLocalService.deleteAttachment(profilePhotographAttachment);
		}

		if (Validator.isNotNull(krishiCardAttachment) && Validator.isNotNull(oldKrishiCardAttachment)) {
			attachmentLocalService.updateAttachment(oldKrishiCardAttachment);
		} else if (Validator.isNotNull(krishiCardAttachment)) {
			attachmentLocalService.deleteAttachment(krishiCardAttachment);
		}

		// TODO: Remove attchments folder
	}

	/**
	 * Fetch Farmer Registration record by Naional Id
	 * 
	 * @param nationalId
	 * @return FarmerRegistration
	 */
	public FarmerRegistration fetchFarmerRegistrationByNationalId(String nationalId) {
		return farmerRegistrationPersistence.fetchByNationalId(nationalId);
	}

	/**
	 * Fetch Farmer Registration record by Naional Id and Date of birth
	 * 
	 * @param nationalId
	 * @param dateOfBirth
	 * @return FarmerRegistration
	 */
	public FarmerRegistration fetchFarmerRegistrationByNationalIdDob(String nationalId, Date dateOfBirth) {
		return farmerRegistrationPersistence.fetchByNationalIdDob(nationalId, dateOfBirth);
	}

	/**
	 * Fetch Farmer Registration record by Application Number and Date of Birth
	 * 
	 * @param nationalId
	 * @param dateOfBirth
	 * @return FarmerRegistration
	 */
	public FarmerRegistration fetchFarmerRegistrationByApplicationNumberDob(String applicationNumber,
			Date dateOfBirth) {
		return farmerRegistrationPersistence.fetchByApplicationNumberDob(applicationNumber, dateOfBirth);
	}

	/**
	 * Fetch Farmer Registration record by Application Number
	 * 
	 * @param nationalId
	 * @return FarmerRegistration
	 */
	public FarmerRegistration fetchFarmerRegistrationByApplicationNumber(String applicationNumber) {
		return farmerRegistrationPersistence.fetchByApplicationNumber(applicationNumber);
	}
	
	/**
	 * Fetch Farmer Registration record by User Id
	 * 
	 * @param userId
	 * @return
	 */
	public FarmerRegistration fetchFarmerRegistrationByUserId(long userId) {
		return farmerRegistrationPersistence.fetchByUserId(userId);
	}

	/**
	 * Fetch Farmer Registrations list based on search inputs
	 * 
	 * @param groupId
	 * @param farmerRegistrationFilterOptions
	 * @param addressOptions
	 * @param keywords
	 * @param start
	 * @param end
	 * @param orderByComparator
	 * @return
	 */
	public List<FarmerRegistration> searchFarmerRegistrations(long groupId,
			Map<String, Object> farmerRegistrationFilterOptions, Map<String, Object> addressOptions, String keywords,
			Date fromDate, Date toDate, int start, int end, OrderByComparator<FarmerRegistration> orderByComparator) {
		return dynamicQuery(getSearchDynamicQuery(groupId, farmerRegistrationFilterOptions, addressOptions, keywords,
				fromDate, toDate), start, end, orderByComparator);

	}

	/**
	 * Fetch Farmer Registrations count based on search inputs
	 * 
	 * @param groupId
	 * @param farmerRegistrationFilterOptions
	 * @param addressOptions
	 * @param keywords
	 * @return
	 */
	public long searchFarmerRegistrationsCount(long groupId, Map<String, Object> farmerRegistrationFilterOptions,
			Map<String, Object> addressOptions, String keywords, Date fromDate, Date toDate) {
		return dynamicQueryCount(getSearchDynamicQuery(groupId, farmerRegistrationFilterOptions, addressOptions,
				keywords, fromDate, toDate));

	}

	/**
	 * Will generate the dynamicQuery based on the given search inputs
	 * 
	 * @param groupId
	 * @param farmerRegistrationFilterOptions
	 * @param addressOptions
	 * @param keywords
	 * @param toDate
	 * @param fromDate
	 * @return
	 */
	private DynamicQuery getSearchDynamicQuery(long groupId, Map<String, Object> farmerRegistrationFilterOptions,
			Map<String, Object> addressOptions, String keywords, Date fromDate, Date toDate) {

		/* Dynmic query for Farmer Registration filter */
		DynamicQuery farmerRegistrationDynamicQuery = dynamicQuery()
				.add(RestrictionsFactoryUtil.eq("groupId", groupId));
		Conjunction farmerRegistrationsonConjunction = RestrictionsFactoryUtil.conjunction();
		if (Validator.isNotNull(farmerRegistrationFilterOptions) && farmerRegistrationFilterOptions.size() > 0) {
			for (Entry<String, Object> farmerREgistrationCriterionEntry : farmerRegistrationFilterOptions.entrySet()) {
				farmerRegistrationsonConjunction.add(RestrictionsFactoryUtil
						.eq(farmerREgistrationCriterionEntry.getKey(), farmerREgistrationCriterionEntry.getValue()));
			}
		}

		if (Validator.isNotNull(keywords)) {
			keywords = StringPool.PERCENT + keywords + StringPool.PERCENT;

			Disjunction farmerRegistrationDisjunction = RestrictionsFactoryUtil.disjunction();

			farmerRegistrationDisjunction.add(RestrictionsFactoryUtil.like(ParameterConstants.FARMER_NAME, keywords));
			farmerRegistrationDisjunction
					.add(RestrictionsFactoryUtil.like(ParameterConstants.KRISHOK_CARD_NUMBER, keywords));
			farmerRegistrationDisjunction.add(RestrictionsFactoryUtil.like(ParameterConstants.FATHER_NAME, keywords));
			farmerRegistrationDisjunction.add(RestrictionsFactoryUtil.like(ParameterConstants.EMAIL_ADDRESS, keywords));
			farmerRegistrationDisjunction.add(RestrictionsFactoryUtil.like(ParameterConstants.MOBILE_NUMBER, keywords));
			farmerRegistrationDisjunction.add(RestrictionsFactoryUtil.like(ParameterConstants.NATIONAL_ID, keywords));
			farmerRegistrationDisjunction
					.add(RestrictionsFactoryUtil.like(ParameterConstants.APPLICATION_NUMBER, keywords));

			farmerRegistrationsonConjunction.add(farmerRegistrationDisjunction);
		}

		if (Validator.isNotNull(fromDate)) {
			farmerRegistrationsonConjunction.add(RestrictionsFactoryUtil.ge(ParameterConstants.CREATED_DATE, fromDate));
		}
		if (Validator.isNotNull(toDate)) {
			farmerRegistrationsonConjunction.add(RestrictionsFactoryUtil.le(ParameterConstants.CREATED_DATE, toDate));
		}

		/* Get farmer Registraion Id based on location */
		DynamicQuery addressDynamicQuery = addressLocalService.dynamicQuery()
				.add(RestrictionsFactoryUtil.eq("className", FarmerRegistration.class.getName()));
		Disjunction addressCriterionDisjunction = RestrictionsFactoryUtil.disjunction();
		if (Validator.isNotNull(addressOptions) && addressOptions.size() > 0) {
			for (Entry<String, Object> locationCriterionEntry : addressOptions.entrySet()) {
				addressCriterionDisjunction.add(
						RestrictionsFactoryUtil.eq(locationCriterionEntry.getKey(), locationCriterionEntry.getValue()));
			}

			addressDynamicQuery.add(addressCriterionDisjunction)
					.setProjection(ProjectionFactoryUtil.property("classPK"));

			// TODO: Update with
			// PropertyFactoryUtil.forName("farmerREgistrationId").in(addressDynamicQuery) -
			// currently geting some error with this
			List<Long> filteredFarmerRegistrationIds = addressLocalService.dynamicQuery(addressDynamicQuery);

			logger.debug(filteredFarmerRegistrationIds);

			farmerRegistrationsonConjunction
					.add(RestrictionsFactoryUtil.in("farmerRegistrationId", filteredFarmerRegistrationIds));
		}

		logger.debug("Dynamic Query Created Sucessfully");
		return farmerRegistrationDynamicQuery.add(farmerRegistrationsonConjunction);
	}

	private Log logger = LogFactoryUtil.getLog(this.getClass());

	@Reference
	private AddressLocalService addressLocalService;

	@Reference
	private AttachmentLocalService attachmentLocalService;
}