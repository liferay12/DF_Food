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

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.MathUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.vulcan.multipart.BinaryFile;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.common.services.model.Address;
import bd.gov.dgfood.common.services.service.AddressLocalService;
import bd.gov.dgfood.common.services.service.AttachmentLocalService;
import bd.gov.dgfood.common.util.constants.AddressConstants;
import bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary;
import bd.gov.dgfood.food.friendly.program.model.FFPBeneficiaryVersion;
import bd.gov.dgfood.food.friendly.program.model.impl.FFPBeneficiaryVersionImpl;
import bd.gov.dgfood.food.friendly.program.service.FFPBeneficiaryLocalServiceUtil;
import bd.gov.dgfood.food.friendly.program.service.base.FFPBeneficiaryVersionLocalServiceBaseImpl;

/**
 * The implementation of the ffp beneficiary version local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>bd.gov.dgfood.food.friendly.program.service.FFPBeneficiaryVersionLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FFPBeneficiaryVersionLocalServiceBaseImpl
 */
@Component(property = "model.class.name=bd.gov.dgfood.food.friendly.program.model.FFPBeneficiaryVersion", service = AopService.class)
public class FFPBeneficiaryVersionLocalServiceImpl extends FFPBeneficiaryVersionLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>bd.gov.dgfood.food.friendly.program.service.
	 * FFPBeneficiaryVersionLocalService</code> via injection or a
	 * <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>bd.gov.dgfood.food.friendly.program.service.
	 * FFPBeneficiaryVersionLocalServiceUtil</code>.
	 */

	Log log = LogFactoryUtil.getLog(FFPBeneficiaryVersionLocalServiceImpl.class);

	/**
	 * Add a new beneificairy as a default version
	 * 
	 * @param beneficiaryId
	 * @param userId
	 * @param name
	 * @param nationalId
	 * @param emailAddress
	 * @param mobileNumber
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
	public FFPBeneficiaryVersion addBenficiaryVersion(long beneficiaryId, long userId, String name, long nationalId,
			String emailAddress, String mobileNumber, Date dateOfBirth, int gender, int maritalStatus,
			String spouseName, String spouseFatherName, long spouseNationalId, Date spouseDateOfBirth,
			String fatherName, String motherName, int familyEarningMembers, String familyAverageMonthlyIncome,
			long permanentRegion, long permanentZilla, long permanentUpazilla, long permanentUnion,
			String permanentVillage, long permanentWard, long permanentZipCode, String permanentPostOffice,
			String permanentHouseAddress, long presentRegion, long presentZilla, long presentUpazilla,
			long presentUnion, String presentVillage, long presentWard, long presentZipCode, String presentPostOffice,
			String presentHouseAddress, boolean sameAsPermanentAddress, boolean acknowledge,
			boolean nonOfMyFamilyMembersRegistered, BinaryFile photograph, BinaryFile signature,
			List<BinaryFile> additionalDoc, ServiceContext serviceContext) throws PortalException {
		User user = userLocalService.getUserById(userId);

		long groupId = serviceContext.getScopeGroupId();
		long companyId = serviceContext.getCompanyId();

		long beneficiaryVersionId = counterLocalService.increment(FFPBeneficiaryVersion.class.getName());

		Date createDate = new Date();

		FFPBeneficiaryVersion ffpBeneficiaryVersion = ffpBeneficiaryVersionPersistence.create(beneficiaryVersionId);

		ffpBeneficiaryVersion.setCreatedBy(user.getUserId());
		ffpBeneficiaryVersion.setGroupId(groupId);
		ffpBeneficiaryVersion.setCompanyId(companyId);
		ffpBeneficiaryVersion.setCreateDate(createDate);

		ffpBeneficiaryVersion.setName(name);
		ffpBeneficiaryVersion.setGender(gender);
		ffpBeneficiaryVersion.setNationalId(nationalId);
		ffpBeneficiaryVersion.setCardNumber("FFP" + nationalId);
		ffpBeneficiaryVersion.setEmailAddress(emailAddress);
		ffpBeneficiaryVersion.setMobileNumber(mobileNumber);
		ffpBeneficiaryVersion.setDateOfBirth(dateOfBirth);
		ffpBeneficiaryVersion.setFatherName(fatherName);
		ffpBeneficiaryVersion.setMotherName(motherName);
		ffpBeneficiaryVersion.setMaritalStatus(maritalStatus);
		ffpBeneficiaryVersion.setSpouseName(spouseName);
		ffpBeneficiaryVersion.setSpouseDateOfBirth(spouseDateOfBirth);
		ffpBeneficiaryVersion.setSpouseNationalId(spouseNationalId);
		ffpBeneficiaryVersion.setFamilyAverageMonthlyIncome(familyAverageMonthlyIncome);
		ffpBeneficiaryVersion.setFamilyEarningMembers(familyEarningMembers);
		ffpBeneficiaryVersion.setVersion(1.0);
		ffpBeneficiaryVersion.setStatus(WorkflowConstants.STATUS_DRAFT);
		ffpBeneficiaryVersion.setAcknowledge(acknowledge);
		ffpBeneficiaryVersion.setNonOfMyFamilyMembersRegistered(nonOfMyFamilyMembersRegistered);
		ffpBeneficiaryVersion.setBeneficiaryId(beneficiaryId);

		ffpBeneficiaryVersion = ffpBeneficiaryVersionPersistence.update(ffpBeneficiaryVersion);

		// Permanent address call
		Address parmanentAddress = null;

//		parmanentAddress = addressLocalService.addAddress(permanentRegion, permanentZilla, presentUpazilla,
//				permanentUnion, permanentVillage, permanentWard, permanentZipCode, permanentPostOffice,
//				permanentHouseAddress, FFPBeneficiary.class.getName(), ffpBeneficiaryVersion.getBeneficiaryId(),
//				AddressConstants.ADDRESS_PERMANENT);
//
//		// Present address call
//		Address presentAddress = null;
//
//		presentAddress = addressLocalService.addAddress(presentRegion, presentZilla, presentUpazilla, presentUnion,
//				presentVillage, presentWard, presentZipCode, presentPostOffice, presentHouseAddress,
//				FFPBeneficiary.class.getName(), ffpBeneficiaryVersion.getBeneficiaryId(),
//				AddressConstants.ADDRESS_PRESENT);

		// Attachments call

		return ffpBeneficiaryVersion;

	}

	/**
	 * Add a existing beneificairy as a increment version
	 * 
	 * @param beneficiaryId
	 * @param userId
	 * @param name
	 * @param email
	 * @param nationalId
	 * @param mobileNumber
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
	 * @param nonOfMyFamilyMembersRegistred
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 */
	public FFPBeneficiaryVersion addBenficiaryVersionHistory(long beneficiaryId, long userId, String name,
			long nationalId, String mobileNumber, String emailAddress, Date dateOfBirth, int gender, int maritalStatus,
			String spouseName, String spouseFatherName, long spouseNationalId, Date spouseDateOfBirth,
			String fatherName, String motherName, int familyEarningMembers, String familyAverageMonthlyIncome,
			long permanentRegion, long permanentZilla, long permanentUpazilla, long permanentUnion,
			String permanentVillage, long permanentWard, long permanentZipCode, String permanentPostOffice,
			String permanentHouseAddress, long presentRegion, long presentZilla, long presentUpazilla,
			long presentUnion, String presentVillage, long presentWard, long presentZipCode, String presentPostOffice,
			String presentHouseAddress, boolean sameAsPermanentAddress, boolean acknowledge,
			boolean nonOfMyFamilyMembersRegistred, ServiceContext serviceContext) throws PortalException {

		User user = userLocalService.getUserById(userId);

		long groupId = serviceContext.getScopeGroupId();
		long companyId = serviceContext.getCompanyId();

		Date createDate = new Date();

		boolean ascending = false;

		OrderByComparator<FFPBeneficiaryVersion> orderByComparator = OrderByComparatorFactoryUtil
				.create(FFPBeneficiaryVersionImpl.TABLE_NAME, "beneficiaryVersionId", ascending);

		FFPBeneficiaryVersion lastBeneficiaryVersion = ffpBeneficiaryVersionPersistence
				.fetchByBeneficiaryId_First(beneficiaryId, orderByComparator);

		log.info(" lastFFPRegistrationVersion ... " + lastBeneficiaryVersion.getVersion());
		log.info(" lastFFPRegistrationVersion ... " + lastBeneficiaryVersion.getBeneficiaryVersionId());

		long beneficiaryVersionId = counterLocalService.increment(FFPBeneficiaryVersion.class.getName());

		FFPBeneficiaryVersion ffpBeneficiaryVersion = ffpBeneficiaryVersionPersistence.create(beneficiaryVersionId);

		ffpBeneficiaryVersion.setBeneficiaryId(beneficiaryId);

		ffpBeneficiaryVersion.setCreatedBy(user.getUserId());
		ffpBeneficiaryVersion.setGroupId(groupId);
		ffpBeneficiaryVersion.setCompanyId(companyId);
		ffpBeneficiaryVersion.setCreateDate(createDate);

		ffpBeneficiaryVersion.setName(name);
		ffpBeneficiaryVersion.setGender(gender);
		ffpBeneficiaryVersion.setNationalId(nationalId);
		ffpBeneficiaryVersion.setEmailAddress(emailAddress);
		ffpBeneficiaryVersion.setMobileNumber(mobileNumber);
		ffpBeneficiaryVersion.setDateOfBirth(dateOfBirth);
		ffpBeneficiaryVersion.setFatherName(fatherName);
		ffpBeneficiaryVersion.setMotherName(motherName);
		ffpBeneficiaryVersion.setMaritalStatus(maritalStatus);
		ffpBeneficiaryVersion.setSpouseName(spouseName);
		ffpBeneficiaryVersion.setSpouseFatherName(spouseFatherName);
		ffpBeneficiaryVersion.setSpouseDateOfBirth(spouseDateOfBirth);
		ffpBeneficiaryVersion.setSpouseNationalId(spouseNationalId);
		ffpBeneficiaryVersion.setFamilyAverageMonthlyIncome(familyAverageMonthlyIncome);
		ffpBeneficiaryVersion.setFamilyEarningMembers(familyEarningMembers);
		ffpBeneficiaryVersion.setVersion(MathUtil.format(lastBeneficiaryVersion.getVersion() + 0.1, 1, 1));
		ffpBeneficiaryVersion.setStatus(WorkflowConstants.STATUS_DRAFT);

		ffpBeneficiaryVersion = ffpBeneficiaryVersionPersistence.update(ffpBeneficiaryVersion);

		// Permanent address call

		// Present address call

		// Attachments call

		Map<String, Serializable> workflowContext = new HashMap<String, Serializable>();

		workflowContext.put("unionId", presentUnion);

		WorkflowHandlerRegistryUtil.startWorkflowInstance(ffpBeneficiaryVersion.getCompanyId(),
				ffpBeneficiaryVersion.getGroupId(), ffpBeneficiaryVersion.getCreatedBy(),
				FFPBeneficiaryVersion.class.getName(), ffpBeneficiaryVersion.getPrimaryKey(), ffpBeneficiaryVersion,
				serviceContext, workflowContext);

		return ffpBeneficiaryVersion;

	}

	/**
	 * Update workflow status when admin review profile update request of FFPB
	 * 
	 * @param userId
	 * @param beneficiaryVersionId
	 * @param status
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public FFPBeneficiaryVersion updateStatus(long userId, long beneficiaryVersionId, int status,
			ServiceContext serviceContext) throws PortalException, SystemException {

		log.info(" update status 1 ");

		User user = userLocalService.getUser(userId);

		FFPBeneficiaryVersion ffpBeneficiaryVersion = getFFPBeneficiaryVersion(beneficiaryVersionId);

		ffpBeneficiaryVersion.setStatus(status);
		ffpBeneficiaryVersion.setStatusByUserId(user.getUserId());
		ffpBeneficiaryVersion.setStatusDate(new Date());

		ffpBeneficiaryVersion = ffpBeneficiaryVersionPersistence.update(ffpBeneficiaryVersion);

		// Update call to Master table if approved

		if (WorkflowConstants.STATUS_APPROVED == status) {
			log.info(" update status 1 ");
			FFPBeneficiaryLocalServiceUtil.updateBenficiary(ffpBeneficiaryVersion, userId, status);
		}

		return ffpBeneficiaryVersion;

	}

	/**
	 * update status reviewed by admins of FFPB registration
	 * 
	 * @param userId
	 * @param beneficiaryId
	 * @param version
	 * @param status
	 * @param serviceContext
	 * @return
	 */
	public FFPBeneficiaryVersion updateStatus(long userId, long beneficiaryId, double version, int status,
			ServiceContext serviceContext) {

		log.info(" update status 2 ffpRegistrationId " + beneficiaryId);
		log.info(" update status 2 version " + version);

		FFPBeneficiaryVersion ffpBeneficiaryVersion = ffpBeneficiaryVersionPersistence.fetchById_Version(beneficiaryId,
				version);

		log.info(" update status 2 ffpBeneficiaryVersion " + ffpBeneficiaryVersion);

		ffpBeneficiaryVersion.setStatus(status);
		ffpBeneficiaryVersion.setStatusByUserId(userId);
		ffpBeneficiaryVersion.setStatusDate(new Date());

		return ffpBeneficiaryVersionPersistence.update(ffpBeneficiaryVersion);

	}

	@Reference
	private AddressLocalService addressLocalService;

	@Reference
	private AttachmentLocalService attachmentLocalService;
}