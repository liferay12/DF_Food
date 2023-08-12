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

package bd.gov.dgfood.credit.other.priority.customer.service.impl;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.asset.kernel.service.AssetLinkLocalService;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.MathUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

import java.util.Date;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.common.services.model.AddressVersion;
import bd.gov.dgfood.common.services.service.AddressVersionLocalServiceUtil;
import bd.gov.dgfood.common.util.constants.AddressConstants;
import bd.gov.dgfood.common.util.constants.StatusConstants;
import bd.gov.dgfood.common.util.constants.ValidationConstants;
import bd.gov.dgfood.common.util.validator.DataValidationException;
import bd.gov.dgfood.common.util.validator.FormValidator;
import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerVersion;
import bd.gov.dgfood.credit.other.priority.customer.model.impl.SalesCustomerVersionImpl;
import bd.gov.dgfood.credit.other.priority.customer.service.SalesCustomerLocalServiceUtil;
import bd.gov.dgfood.credit.other.priority.customer.service.base.SalesCustomerVersionLocalServiceBaseImpl;

/**
 * The implementation of the sales customer version local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>bd.gov.dgfood.credit.other.priority.customer.service.SalesCustomerVersionLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SalesCustomerVersionLocalServiceBaseImpl
 */
@Component(property = "model.class.name=bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerVersion", service = AopService.class)
public class SalesCustomerVersionLocalServiceImpl extends SalesCustomerVersionLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>bd.gov.dgfood.credit.other.priority.customer.service.
	 * SalesCustomerVersionLocalService</code> via injection or a
	 * <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>bd.gov.dgfood.credit.other.priority.customer.service.
	 * SalesCustomerVersionLocalServiceUtil</code>.
	 */

	/**
	 *
	 */
	public SalesCustomerVersion add(long salesCustomerId, long createdBy, String userType, String mobileNumber,
			String emailAddress, String title, String contactPersonName, String contactPersonDesignation,
			String officeName, String organizationName, String organizationType, int gender, long officeRegion,
			long officeDistrict, long officeUpazilla, long officeCityCorporationOrMunicipality, long officeUnionOrWard,
			String officevillageOrRoad, String officeMouzaOrMoholla, long officeZipCode, String officePostOffice,
			String address, ServiceContext serviceContext) throws PortalException {

		long salesCustomerVersionId = counterLocalService.increment(SalesCustomerVersion.class.getName());

		AddressVersionLocalServiceUtil.addAddressVersion(officeRegion, officeDistrict, officeUpazilla,
				officeCityCorporationOrMunicipality, officeUnionOrWard, officeZipCode, officePostOffice,
				officevillageOrRoad, officeMouzaOrMoholla, address, AddressConstants.ADDRESS_OFFICE,
				SalesCustomerVersion.class.getName(), salesCustomerVersionId);

		Date createDate = new Date();

		long groupId = serviceContext.getScopeGroupId();
		long companyId = serviceContext.getCompanyId();

		SalesCustomerVersion salesCustomerVersion = salesCustomerVersionPersistence.create(salesCustomerVersionId);

		salesCustomerVersion.setSalesCustomerId(salesCustomerId);
		salesCustomerVersion.setCompanyId(companyId);
		salesCustomerVersion.setGroupId(groupId);
		salesCustomerVersion.setUserType(userType);
		salesCustomerVersion.setMobileNumber(mobileNumber);
		salesCustomerVersion.setEmailAddress(emailAddress);
		salesCustomerVersion.setTitle(title);
		salesCustomerVersion.setContactPersonName(contactPersonName);
		salesCustomerVersion.setContactPersonDesignation(contactPersonDesignation);
		salesCustomerVersion.setOfficeName(officeName);
		salesCustomerVersion.setOrganizationName(organizationName);
		salesCustomerVersion.setOrganizationType(organizationType);
		salesCustomerVersion.setGender(gender);
		salesCustomerVersion.setCreateDate(createDate);
		salesCustomerVersion.setCreatedBy(createdBy);
		salesCustomerVersion.setVersion(StatusConstants.DEFAULT_VERSION);
		salesCustomerVersion.setStatus(StatusConstants.STATUS_PENDING);

		salesCustomerVersion = salesCustomerVersionPersistence.update(salesCustomerVersion);

		return salesCustomerVersion;

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
	public SalesCustomerVersion updateStatus(long approvedId, String approverName, long salesCustomerId, double version,
			int status, long userId, ServiceContext serviceContext) throws PortalException {

		SalesCustomerVersion salesCustomerVersion = salesCustomerVersionPersistence.findBySCI_V(salesCustomerId,
				version);

		salesCustomerVersion.setStatus(status);
		salesCustomerVersion.setStatusByUserId(approvedId);
		salesCustomerVersion.setStatusByUserName(approverName);
		salesCustomerVersion.setStatusDate(new Date());
		salesCustomerVersion.setUserId(userId);

		return salesCustomerVersionPersistence.update(salesCustomerVersion);

	}

	/**
	 * @param modifiedBy
	 * @param userType
	 * @param mobileNumber
	 * @param emailAddress
	 * @param title
	 * @param contactPersonName
	 * @param contactPersonDesignation
	 * @param officeName
	 * @param organizationName
	 * @param organizationType
	 * @param gender
	 * @param officeRegion
	 * @param officeDistrict
	 * @param officeUpazilla
	 * @param officeCityCorporationOrMunicipality
	 * @param officeUnionOrWard
	 * @param officevillageOrRoad
	 * @param officeMouzaOrMoholla
	 * @param officeZipCode
	 * @param officePostOffice
	 * @param address
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 */
	public SalesCustomerVersion addHistory(long modifiedBy, long salesCustomerId, String mobileNumber, String emailAddress,
			String title, String contactPersonName, String contactPersonDesignation, String officeName,
			String organizationName, String organizationType, int gender, long officeRegion, long officeDistrict,
			long officeUpazilla, long officeCityCorporationOrMunicipality, long officeUnionOrWard,
			String officevillageOrRoad, String officeMouzaOrMoholla, long officeZipCode, String officePostOffice,
			String address, ServiceContext serviceContext) throws PortalException {

		AddressVersion officeAddressVersion = null;
		SalesCustomerVersion salesCustomerVersion = null;

		User user = userLocalService.getUserById(modifiedBy);

		validate(mobileNumber, emailAddress, title, contactPersonName, contactPersonDesignation, officeName,
				organizationName, organizationType, gender);

		validateAddress(officeRegion, officeDistrict, officeUpazilla, officeCityCorporationOrMunicipality,
				officeUnionOrWard, officePostOffice, officeZipCode, officevillageOrRoad, officeMouzaOrMoholla, address);

		long salesCustomerVersionId = counterLocalService.increment(SalesCustomerVersion.class.getName());

		boolean ascending = false;

		OrderByComparator<SalesCustomerVersion> orderByComparator = OrderByComparatorFactoryUtil
				.create(SalesCustomerVersionImpl.TABLE_NAME, "salesCustomerVersionId", ascending);
		SalesCustomerVersion latestSalesCustomerVersion = salesCustomerVersionPersistence.findBySalesCustomerId_First(salesCustomerId, orderByComparator);
		
		log.info(" latestSalesCustomerVersion .... "+latestSalesCustomerVersion.getSalesCustomerVersionId());
		
		if(latestSalesCustomerVersion.getStatus() ==  StatusConstants.STATUS_PENDING) {
			throw new DataValidationException("error-label-you-are-not-allowed-to-edit-a-pending-record");
		}
		

		try {
			// Address call

			officeAddressVersion = AddressVersionLocalServiceUtil.addAddressVersion(officeRegion, officeDistrict, officeUpazilla,
					officeCityCorporationOrMunicipality, officeUnionOrWard, officeZipCode, officePostOffice,
					officevillageOrRoad, officeMouzaOrMoholla, address, AddressConstants.ADDRESS_OFFICE,
					SalesCustomerVersion.class.getName(), salesCustomerVersionId);

			Date createDate = new Date();

			long groupId = serviceContext.getScopeGroupId();
			long companyId = serviceContext.getCompanyId();

			salesCustomerVersion = salesCustomerVersionPersistence.create(salesCustomerVersionId);

			salesCustomerVersion.setCompanyId(companyId);
			salesCustomerVersion.setGroupId(groupId);
			salesCustomerVersion.setUserType(latestSalesCustomerVersion.getUserType());
			salesCustomerVersion.setMobileNumber(mobileNumber);
			salesCustomerVersion.setEmailAddress(emailAddress);
			salesCustomerVersion.setTitle(title);
			salesCustomerVersion.setContactPersonName(contactPersonName);
			salesCustomerVersion.setContactPersonDesignation(contactPersonDesignation);
			salesCustomerVersion.setOfficeName(officeName);
			salesCustomerVersion.setOrganizationName(organizationName);
			salesCustomerVersion.setOrganizationType(organizationType);
			salesCustomerVersion.setGender(gender);
			salesCustomerVersion.setCreateDate(createDate);
			salesCustomerVersion.setCreatedBy(user.getUserId());
			salesCustomerVersion.setVersion(MathUtil.format(latestSalesCustomerVersion.getVersion() + 0.1, 1, 1));
			salesCustomerVersion.setStatus(StatusConstants.STATUS_DRAFT);
			salesCustomerVersion.setSalesCustomerId(salesCustomerId);
			
			salesCustomerVersion = salesCustomerVersionPersistence.update(salesCustomerVersion);


			// Making an Asset

			AssetEntry assetEntry = assetEntryLocalService.updateEntry(modifiedBy, groupId,
					salesCustomerVersion.getCreateDate(), salesCustomerVersion.getModifiedDate(),
					SalesCustomerVersion.class.getName(), salesCustomerVersionId, salesCustomerVersion.getUuid(), 0,
					serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames(), true, true, null, null,
					null, null, ContentTypes.TEXT_HTML, salesCustomerVersion.getOrganizationName(), null, null, null,
					null, 0, 0, null);

			assetLinkLocalService.updateLinks(modifiedBy, assetEntry.getEntryId(),
					serviceContext.getAssetLinkEntryIds(), AssetLinkConstants.TYPE_RELATED);

			// Initiating workflow

			WorkflowHandlerRegistryUtil.startWorkflowInstance(salesCustomerVersion.getCompanyId(),
					salesCustomerVersion.getGroupId(), salesCustomerVersion.getCreatedBy(), SalesCustomerVersion.class.getName(),
					salesCustomerVersion.getPrimaryKey(), salesCustomerVersion, serviceContext);
		} catch (Exception e) {
			log.error(" Unexpected Error has occoured ");

			if (Validator.isNotNull(officeAddressVersion)) {
				log.error(" officeAddress model deleted ");
				AddressVersionLocalServiceUtil.deleteAddressVersion(officeAddressVersion);
			}

			if (Validator.isNotNull(salesCustomerVersion)) {
				log.error(" customer model deleted ");
				salesCustomerVersionPersistence.remove(salesCustomerVersion);
			}

			throw e;

		}

		return salesCustomerVersion;

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
	public SalesCustomerVersion updateStatus(long approverId, long salesCustomerVersionId, int status,
			ServiceContext serviceContext) throws PortalException, SystemException {
		
		log.info(" updateStatus..." + status);

		User approver = userLocalService.getUser(approverId);

		SalesCustomerVersion salesCustomerVersion = getSalesCustomerVersion(salesCustomerVersionId);

		salesCustomerVersion.setStatus(status);
		salesCustomerVersion.setStatusByUserId(approver.getUserId());
		salesCustomerVersion.setStatusDate(new Date());
		
		if (status == StatusConstants.STATUS_APPROVED) {
			//SalesCustomerLocalServiceUtil.updateSalesCustomer(salesCustomerVersion);
		}
		
		
		return salesCustomerVersionPersistence.update(salesCustomerVersion);

	}

	/**
	 * @param region
	 * @param destrict
	 * @param upazilla
	 * @param cityCorporationOrMunicipality
	 * @param unionOrWard
	 * @param postOffice
	 * @param zipCode
	 * @param villageOrRoad
	 * @param mouzaOrMoholla
	 * @param address
	 * @throws DataValidationException
	 */
	private void validateAddress(long region, long destrict, long upazilla, long cityCorporationOrMunicipality,
			long unionOrWard, String postOffice, long zipCode, String villageOrRoad, String mouzaOrMoholla,
			String address) throws DataValidationException {
		FormValidator.validateAddress(region, destrict, upazilla, cityCorporationOrMunicipality, unionOrWard,
				postOffice, zipCode, villageOrRoad, mouzaOrMoholla, address);

	}

	/**
	 * @param mobileNumber
	 * @param emailAddress
	 * @param title
	 * @param contactPersonName
	 * @param contactPersonDesignation
	 * @param officeName
	 * @param organizationName
	 * @param organizationType
	 * @param gender
	 * @throws DataValidationException
	 */
	private void validate(String mobileNumber, String emailAddress, String title, String contactPersonName,
			String contactPersonDesignation, String officeName, String organizationName, String organizationType,
			int gender) throws DataValidationException {

		FormValidator.validateInput(mobileNumber, "label-mobile-number", false, 10, 14,
				ValidationConstants.REGEX_BANGLADESH_MOBILE_NUMBER);
		FormValidator.validateInput(emailAddress, "label-email-address", false, 0, 0,
				ValidationConstants.REGEX_EMAIL_ADDRESS);

		FormValidator.validateInput(title, "label-title", false, 2, 4, ValidationConstants.REGEX_ONLY_CHAR_WITH);
		FormValidator.validateInput(contactPersonName, "label-contact-person-name", true, 3, 30,
				ValidationConstants.REGEX_ONLY_CHAR_WITH_SPACE);
		FormValidator.validateInput(officeName, "label-office-name", true, 3, 30,
				ValidationConstants.REGEX_ONLY_CHAR_WITH_SPACE);
		FormValidator.validateInput(contactPersonDesignation, "label-contact-person-designation", true, 3, 30,
				ValidationConstants.REGEX_ONLY_CHAR_WITH_SPACE);
		FormValidator.validateInput(organizationName, "label-organization-name", true, 3, 30,
				ValidationConstants.REGEX_ONLY_CHAR_WITH_SPACE);
		FormValidator.validateInput(organizationType, "label-organization-type", true, 3, 30,
				ValidationConstants.REGEX_ONLY_CHAR_WITH_SPACE);

		FormValidator.validateInput(gender, "label-gender", true, 0, 2);

	}

	private static Log log = LogFactoryUtil.getLog(SalesCustomerVersionLocalServiceImpl.class);

	@Reference
	protected AssetLinkLocalService assetLinkLocalService;

}