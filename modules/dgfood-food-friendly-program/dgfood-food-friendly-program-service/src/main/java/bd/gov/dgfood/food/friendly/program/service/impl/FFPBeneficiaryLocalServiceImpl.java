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

package bd.gov.dgfood.food.friendly.program.service.impl;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.Conjunction;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.vulcan.multipart.BinaryFile;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.common.services.model.Address;
import bd.gov.dgfood.common.services.model.Attachment;
import bd.gov.dgfood.common.services.service.AddressLocalService;
import bd.gov.dgfood.common.services.service.AttachmentLocalService;
import bd.gov.dgfood.common.util.constants.AddressConstants;
import bd.gov.dgfood.food.friendly.program.exception.NoSuchFFPBeneficiaryException;
import bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary;
import bd.gov.dgfood.food.friendly.program.model.FFPBeneficiaryVersion;
import bd.gov.dgfood.food.friendly.program.service.FFPBeneficiaryVersionLocalServiceUtil;
import bd.gov.dgfood.food.friendly.program.service.base.FFPBeneficiaryLocalServiceBaseImpl;

/**
 * The implementation of the ffp beneficiary local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>bd.gov.dgfood.food.friendly.program.service.FFPBeneficiaryLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FFPBeneficiaryLocalServiceBaseImpl
 */
@Component(property = "model.class.name=bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary", service = AopService.class)
public class FFPBeneficiaryLocalServiceImpl extends FFPBeneficiaryLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>bd.gov.dgfood.food.friendly.program.service.FFPBeneficiaryLocalService<
	 * /code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>
	 * or use <code>bd.gov.dgfood.food.friendly.program.service.
	 * FFPBeneficiaryLocalServiceUtil</code>.
	 */
	Log log = LogFactoryUtil.getLog(FFPBeneficiaryLocalServiceImpl.class);

	/**
	 * Adding a new beneificairy record in DB
	 * 
	 * @param userId
	 * @param name
	 * @param nationalId
	 * @param mobileNumber
	 * @param emailAddress
	 * @param dateOfBirth
	 * @param gender
	 * @param maritalStatus
	 * @param spouseName
	 * @param spouseFatherName
	 * @param spouseNationalId
	 * @param spouseDateOfBirth
	 * @param fatherName
	 * @param motherName
	 * @param familyEarningMembers
	 * @param familyAverageMonthlyIncome
	 * @param permanentRegion
	 * @param permanentZilla
	 * @param permanentUpazilla
	 * @param permanentUnion
	 * @param permanentVillage
	 * @param permanentWard
	 * @param permanentZipCode
	 * @param permanentPostOffice
	 * @param permanentHouseAddress
	 * @param presentRegion
	 * @param presentZilla
	 * @param presentUpazilla
	 * @param presentUnion
	 * @param presentVillage
	 * @param presentWard
	 * @param presentZipCode
	 * @param presentPostOffice
	 * @param presentHouseAddress
	 * @param sameAsPermanentAddress
	 * @param acknowledge
	 * @param nonOfMyFamilyMembersRegistered
	 * @param photograph
	 * @param signature
	 * @param additionalDoc
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 */
	public FFPBeneficiary addBenficiary(long userId, String name, long nationalId, String mobileNumber,
			String emailAddress, Date dateOfBirth, int gender, int maritalStatus, String spouseName,
			String spouseFatherName, long spouseNationalId, Date spouseDateOfBirth, String fatherName,
			String motherName, int familyEarningMembers, String familyAverageMonthlyIncome, long permanentRegion,
			long permanentZilla, long permanentUpazilla, long permanentUnion, String permanentVillage,
			long permanentWard, long permanentZipCode, String permanentPostOffice, String permanentHouseAddress,
			long presentRegion, long presentZilla, long presentUpazilla, long presentUnion, String presentVillage,
			long presentWard, long presentZipCode, String presentPostOffice, String presentHouseAddress,
			boolean sameAsPermanentAddress, boolean acknowledge, boolean nonOfMyFamilyMembersRegistered,
			BinaryFile photograph, BinaryFile signature, List<BinaryFile> additionalDoc, ServiceContext serviceContext)
			throws PortalException {

		User user = userLocalService.getUserById(userId);

		long groupId = serviceContext.getScopeGroupId();
		long companyId = serviceContext.getCompanyId();

		long beneficiaryId = counterLocalService.increment(FFPBeneficiary.class.getName());

		Date createDate = new Date();

		FFPBeneficiary ffpBeneficiary = ffpBeneficiaryPersistence.create(beneficiaryId);

		ffpBeneficiary.setCreatedBy(user.getUserId());
		ffpBeneficiary.setGroupId(groupId);
		ffpBeneficiary.setCompanyId(companyId);
		ffpBeneficiary.setCreateDate(createDate);

		ffpBeneficiary.setName(name);
		ffpBeneficiary.setGender(gender);
		ffpBeneficiary.setNationalId(nationalId);
		ffpBeneficiary.setEmailAddress(emailAddress);
		ffpBeneficiary.setCardNumber("FFP" + nationalId);
		ffpBeneficiary.setMobileNumber(mobileNumber);
		ffpBeneficiary.setDateOfBirth(dateOfBirth);
		ffpBeneficiary.setFatherName(fatherName);
		ffpBeneficiary.setMotherName(motherName);
		ffpBeneficiary.setMaritalStatus(maritalStatus);
		ffpBeneficiary.setSpouseName(spouseName);
		ffpBeneficiary.setSpouseFatherName(spouseFatherName);
		ffpBeneficiary.setSpouseDateOfBirth(spouseDateOfBirth);
		ffpBeneficiary.setSpouseNationalId(spouseNationalId);
		ffpBeneficiary.setFamilyAverageMonthlyIncome(familyAverageMonthlyIncome);
		ffpBeneficiary.setFamilyEarningMembers(familyEarningMembers);
		ffpBeneficiary.setAcknowledge(acknowledge);
		ffpBeneficiary.setNonOfMyFamilyMembersRegistered(nonOfMyFamilyMembersRegistered);

		ffpBeneficiary.setVersion(1.0);

		ffpBeneficiary.setStatus(WorkflowConstants.STATUS_DRAFT);
		ffpBeneficiary.setStatusByUserId(userId);
		ffpBeneficiary.setStatusDate(serviceContext.getModifiedDate(null));

		ffpBeneficiary = ffpBeneficiaryPersistence.update(ffpBeneficiary);

////		// Permanent address call
//		Address parmanentAddress = null;
//
//		parmanentAddress = addressLocalService.addAddress(permanentRegion, permanentZilla, presentUpazilla,
//				permanentUnion, permanentVillage, permanentWard, permanentZipCode, permanentPostOffice,
//				permanentHouseAddress, FFPBeneficiary.class.getName(), ffpBeneficiary.getBeneficiaryId(),
//				AddressConstants.ADDRESS_PERMANENT);
//
////		// Present address call
//		Address presentAddress = null;
//
//		presentAddress = addressLocalService.addAddress(presentRegion, presentZilla, presentUpazilla, presentUnion,
//				presentVillage, presentWard, presentZipCode, presentPostOffice, presentHouseAddress,
//				FFPBeneficiary.class.getName(), ffpBeneficiary.getBeneficiaryId(), AddressConstants.ADDRESS_PRESENT);

		// Attachments call
		Attachment photographAttachment = null;
		Attachment signatureAttachment = null;
		Attachment additionalAttachment = null;

		Map<String, Serializable> workflowContext = new HashMap<String, Serializable>();

		workflowContext.put("locationId", presentUpazilla);

		// version table

		try {
			FFPBeneficiaryVersionLocalServiceUtil.addBenficiaryVersion(beneficiaryId, userId, name, nationalId,
					emailAddress, mobileNumber, dateOfBirth, gender, maritalStatus, spouseName, spouseFatherName,
					spouseNationalId, spouseDateOfBirth, fatherName, motherName, familyEarningMembers,
					familyAverageMonthlyIncome, permanentRegion, permanentZilla, permanentUpazilla, permanentUnion,
					permanentVillage, permanentWard, permanentZipCode, permanentPostOffice, permanentHouseAddress,
					presentRegion, presentZilla, presentUpazilla, presentUnion, presentVillage, presentWard,
					presentZipCode, presentPostOffice, presentHouseAddress, sameAsPermanentAddress, acknowledge,
					nonOfMyFamilyMembersRegistered, photograph, signature, additionalDoc, serviceContext);
		} catch (Exception e) {
			log.error("Unable to add an entry to the version table..", e);
		}

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId, groupId, ffpBeneficiary.getCreateDate(),
				ffpBeneficiary.getModifiedDate(), FFPBeneficiary.class.getName(), beneficiaryId,
				ffpBeneficiary.getUuid(), 0, serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames(),
				true, true, null, null, null, null, ContentTypes.TEXT_HTML, ffpBeneficiary.getName(), null, null, null,
				null, 0, 0, null);

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(), serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);

		WorkflowHandlerRegistryUtil.startWorkflowInstance(ffpBeneficiary.getCompanyId(), ffpBeneficiary.getGroupId(),
				ffpBeneficiary.getCreatedBy(), FFPBeneficiary.class.getName(), ffpBeneficiary.getPrimaryKey(),
				ffpBeneficiary, serviceContext, workflowContext);

		return ffpBeneficiary;

	}

	/**
	 * Updating beneficiary record in DB
	 * 
	 * @param ffpRegistrationVersion
	 * @param userId
	 * @param status
	 * @return
	 * @throws NoSuchFFPBeneficiaryException
	 */
	public FFPBeneficiary updateBenficiary(FFPBeneficiaryVersion ffpRegistrationVersion, long userId, int status)
			throws NoSuchFFPBeneficiaryException {
		log.info(" update benificiary");

		FFPBeneficiary ffpRegistration = ffpBeneficiaryPersistence
				.findByPrimaryKey(ffpRegistrationVersion.getBeneficiaryId());

		ffpRegistration.setModifiedBy(ffpRegistrationVersion.getCreatedBy());

		ffpRegistration.setGender(ffpRegistrationVersion.getGender());
		ffpRegistration.setMobileNumber(ffpRegistrationVersion.getMobileNumber());
		ffpRegistration.setDateOfBirth(ffpRegistrationVersion.getDateOfBirth());
		ffpRegistration.setFatherName(ffpRegistrationVersion.getFatherName());
		ffpRegistration.setMotherName(ffpRegistrationVersion.getMotherName());
		ffpRegistration.setMaritalStatus(ffpRegistrationVersion.getMaritalStatus());
		ffpRegistration.setSpouseName(ffpRegistrationVersion.getSpouseName());
		ffpRegistration.setSpouseFatherName(ffpRegistrationVersion.getSpouseFatherName());
		ffpRegistration.setSpouseDateOfBirth(ffpRegistrationVersion.getSpouseDateOfBirth());
		ffpRegistration.setSpouseNationalId(ffpRegistrationVersion.getSpouseNationalId());
		ffpRegistration.setFamilyAverageMonthlyIncome(ffpRegistrationVersion.getFamilyAverageMonthlyIncome());
		ffpRegistration.setFamilyEarningMembers(ffpRegistrationVersion.getFamilyEarningMembers());
		ffpRegistration.setVersion(ffpRegistrationVersion.getVersion());

		ffpRegistrationVersion.setStatus(status);
		ffpRegistrationVersion.setStatusByUserId(userId);
		ffpRegistrationVersion.setStatusDate(new Date());

		ffpRegistration = ffpBeneficiaryPersistence.update(ffpRegistration);

		// Permanent address call
		Address parmanentAddress = null;

		// Present address call
		Address presentAddress = null;

		// Attachments call

		return ffpRegistration;

	}

	/**
	 * Update workflow status
	 * 
	 * @param userId
	 * @param beneficiaryId
	 * @param status
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public FFPBeneficiary updateStatus(long userId, long beneficiaryId, int status, ServiceContext serviceContext)
			throws PortalException, SystemException {

		User user = userLocalService.getUser(userId);

		FFPBeneficiary ffpRegistration = getFFPBeneficiary(beneficiaryId);

		ffpRegistration.setStatus(status);
		ffpRegistration.setStatusByUserId(user.getUserId());
		ffpRegistration.setStatusDate(new Date());

		// Update status call to Version table
		try {
			if (WorkflowConstants.STATUS_APPROVED == status) {
				FFPBeneficiaryVersionLocalServiceUtil.updateStatus(userId, beneficiaryId, ffpRegistration.getVersion(),
						status, serviceContext);
			}

		} catch (Exception e) {
			log.error(" Status upldate fail for Version table" + e);
		}

		return ffpBeneficiaryPersistence.update(ffpRegistration);

	}

	/**
	 * Get beneficiary by
	 * 
	 * @param cardNumber
	 * @param dateOfBirth
	 * @return
	 * @throws NoSuchFFPBeneficiaryException
	 */
	public FFPBeneficiary getBenificiaryDetails(String cardNumber, Date dateOfBirth)
			throws NoSuchFFPBeneficiaryException {
		return ffpBeneficiaryPersistence.findByCard_Dob(cardNumber, dateOfBirth);

	}

	/**
	 * Get beneficiary application by
	 * 
	 * @param beneficiaryId
	 * @param dateOfBirth
	 * @return
	 */
	public FFPBeneficiary getApplication(long beneficiaryId, Date dateOfBirth) {
		return ffpBeneficiaryPersistence.fetchById_Dob(beneficiaryId, dateOfBirth);
	}

	/**
	 * Get beneficiary by
	 * 
	 * @param nationalId
	 * @return
	 */
	public FFPBeneficiary getBenificiaryByNationalId(long nationalId) {
		return ffpBeneficiaryPersistence.fetchByNationalId(nationalId);

	}

	/**
	 * Delete all records (Use only of development purpose)
	 */
	public void deleteAll() {
		ffpBeneficiaryPersistence.removeAll();
		ffpBeneficiaryVersionPersistence.removeAll();
	}

	/**
	 * Search container results count
	 * 
	 * @param companyId
	 * @param keywords
	 * @param status
	 * @param params
	 * @param attributes
	 * @return
	 */
	public int countByKeyWords(long companyId, String keywords, int status, LinkedHashMap<String, Object> params,
			Map<String, Serializable> attributes) {

		String likeKeywords = StringPool.PERCENT + keywords + StringPool.PERCENT;

		DynamicQuery dynamicQuery = ffpBeneficiaryLocalService.dynamicQuery();
		try {
			Disjunction disjunction = RestrictionsFactoryUtil.disjunction();

			Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

			long nationalId = (long) params.get("nationalId");
			String ffpCardNumber = (String) params.get("cardNumber");

			if (keywords != null && !keywords.isEmpty()) {
				disjunction.add(RestrictionsFactoryUtil.like("name", likeKeywords));
			}

			if (ffpCardNumber != null && !ffpCardNumber.isEmpty()) {
				disjunction.add(RestrictionsFactoryUtil.eq("cardNumber", ffpCardNumber));
			}

			if (nationalId > 0) {
				disjunction.add(RestrictionsFactoryUtil.eq("nationalId", nationalId));
			}

			if (params.get("status") != null && (int) params.get("status") != -1) {
				conjunction.add(RestrictionsFactoryUtil.eq("status", (int) params.get("status")));
			}

			if (Validator.isNotNull(params.get("fromDate")) && Validator.isNotNull(params.get("toDate"))) {

				Date fromDate = (Date) params.get("fromDate");

				Calendar fromDateCalendar = CalendarFactoryUtil.getCalendar();
				fromDateCalendar.setTime(fromDate);
				fromDateCalendar.add(Calendar.DATE, -1);
				fromDate = fromDateCalendar.getTime();

				Date toDate = (Date) params.get("toDate");

				Calendar toDateCalendar = CalendarFactoryUtil.getCalendar();
				toDateCalendar.setTime(toDate);
				toDateCalendar.add(Calendar.DATE, +1);
				toDate = toDateCalendar.getTime();

				conjunction.add(RestrictionsFactoryUtil.gt("createDate", fromDate));
				conjunction.add(RestrictionsFactoryUtil.lt("createDate", toDate));

			}

			dynamicQuery.add(RestrictionsFactoryUtil.and(disjunction, conjunction));

			dynamicQuery.addOrder(OrderFactoryUtil.desc("createDate"));
		} catch (Exception e) {
			log.error(" Error ", e);
		}

		return (int) ffpBeneficiaryLocalService.dynamicQueryCount(dynamicQuery);

	}

	/**
	 * Search container results
	 * 
	 * @param companyId
	 * @param keywords
	 * @param start
	 * @param end
	 * @param params
	 * @param attributes
	 * @return
	 */
	public List<FFPBeneficiary> findByKeyWords(long companyId, String keywords, int start, int end,
			LinkedHashMap<String, Object> params, Map<String, Serializable> attributes) {

		String likeKeywords = StringPool.PERCENT + keywords + StringPool.PERCENT;

		DynamicQuery dynamicQuery = ffpBeneficiaryLocalService.dynamicQuery();
		try {
			Disjunction disjunction = RestrictionsFactoryUtil.disjunction();

			Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

			long nationalId = (long) params.get("nationalId");
			String ffpCardNumber = (String) params.get("cardNumber");

			if (keywords != null && !keywords.isEmpty()) {
				disjunction.add(RestrictionsFactoryUtil.like("name", likeKeywords));
			}

			if (ffpCardNumber != null && !ffpCardNumber.isEmpty()) {
				disjunction.add(RestrictionsFactoryUtil.eq("cardNumber", ffpCardNumber));
			}

			if (nationalId > 0) {
				disjunction.add(RestrictionsFactoryUtil.eq("nationalId", nationalId));
			}

			if (params.get("status") != null && (int) params.get("status") != -1) {
				conjunction.add(RestrictionsFactoryUtil.eq("status", (int) params.get("status")));
			}

			if (Validator.isNotNull(params.get("fromDate")) && Validator.isNotNull(params.get("toDate"))) {

				Date fromDate = (Date) params.get("fromDate");

				Calendar fromDateCalendar = CalendarFactoryUtil.getCalendar();
				fromDateCalendar.setTime(fromDate);
				fromDateCalendar.add(Calendar.DATE, -1);
				fromDate = fromDateCalendar.getTime();

				Date toDate = (Date) params.get("toDate");

				Calendar toDateCalendar = CalendarFactoryUtil.getCalendar();
				toDateCalendar.setTime(toDate);
				toDateCalendar.add(Calendar.DATE, +1);
				toDate = toDateCalendar.getTime();

				conjunction.add(RestrictionsFactoryUtil.gt("createDate", fromDate));
				conjunction.add(RestrictionsFactoryUtil.lt("createDate", toDate));

			}

			dynamicQuery.add(RestrictionsFactoryUtil.and(disjunction, conjunction));

			dynamicQuery.addOrder(OrderFactoryUtil.desc("createDate"));
		} catch (Exception e) {
			log.error(" Error ", e);
		}

		return ffpBeneficiaryLocalService.dynamicQuery(dynamicQuery, start, end);

	}

	@Reference
	private AddressLocalService addressLocalService;

	@Reference
	private AttachmentLocalService attachmentLocalService;

}