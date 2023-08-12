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
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.common.services.model.Address;
import bd.gov.dgfood.common.services.model.AddressVersion;
import bd.gov.dgfood.common.services.service.AddressLocalServiceUtil;
import bd.gov.dgfood.common.services.service.AddressVersionLocalServiceUtil;
import bd.gov.dgfood.common.util.constants.AddressConstants;
import bd.gov.dgfood.common.util.constants.GenderConstants;
import bd.gov.dgfood.common.util.constants.StatusConstants;
import bd.gov.dgfood.common.util.constants.ValidationConstants;
import bd.gov.dgfood.common.util.validator.DataValidationException;
import bd.gov.dgfood.common.util.validator.FormValidator;
import bd.gov.dgfood.credit.other.priority.customer.exception.NoSuchSalesCustomerException;
import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer;
import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerVersion;
import bd.gov.dgfood.credit.other.priority.customer.service.SalesCustomerVersionLocalServiceUtil;
import bd.gov.dgfood.credit.other.priority.customer.service.base.SalesCustomerLocalServiceBaseImpl;

/**
 * The implementation of the sales customer local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>bd.gov.dgfood.credit.other.priority.customer.service.SalesCustomerLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SalesCustomerLocalServiceBaseImpl
 */
@Component(property = "model.class.name=bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer", service = AopService.class)
public class SalesCustomerLocalServiceImpl extends SalesCustomerLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>bd.gov.dgfood.credit.other.priority.customer.service.
	 * SalesCustomerLocalService</code> via injection or a
	 * <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>bd.gov.dgfood.credit.other.priority.customer.service.
	 * SalesCustomerLocalServiceUtil</code>.
	 */

	/**
	 * @param createdBy
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
	public SalesCustomer addCustomer(long createdBy, String userType, String mobileNumber, String emailAddress,
			String title, String contactPersonName, String contactPersonDesignation, String officeName,
			String organizationName, String organizationType, int gender, long officeRegion, long officeDistrict,
			long officeUpazilla, long officeCityCorporationOrMunicipality, long officeUnionOrWard,
			String officevillageOrRoad, String officeMouzaOrMoholla, long officeZipCode, String officePostOffice,
			String address, ServiceContext serviceContext) throws PortalException {

		Address officeAddress = null;
		SalesCustomer customer = null;

		User user = userLocalService.getUserById(createdBy);

		validate(mobileNumber, emailAddress, title, contactPersonName, contactPersonDesignation, officeName,
				organizationName, organizationType, gender);

		validateAddress(officeRegion, officeDistrict, officeUpazilla, officeCityCorporationOrMunicipality,
				officeUnionOrWard, officePostOffice, officeZipCode, officevillageOrRoad, officeMouzaOrMoholla, address);

		// other validators

		long customerId = counterLocalService.increment(SalesCustomer.class.getName());

		try {
			// Address call

			officeAddress = AddressLocalServiceUtil.addAddress(officeRegion, officeDistrict, officeUpazilla,
					officeCityCorporationOrMunicipality, officeUnionOrWard, officeZipCode, officePostOffice,
					officevillageOrRoad, officeMouzaOrMoholla, address, AddressConstants.ADDRESS_OFFICE,
					SalesCustomer.class.getName(), customerId);

			// Photograph

			// Version Table

			// Master table

			Date createDate = new Date();

			long groupId = serviceContext.getScopeGroupId();
			long companyId = serviceContext.getCompanyId();

			customer = salesCustomerPersistence.create(customerId);

			customer.setCompanyId(companyId);
			customer.setGroupId(groupId);
			customer.setUserType(userType);
			customer.setMobileNumber(mobileNumber);
			customer.setEmailAddress(emailAddress);
			customer.setTitle(title);
			customer.setContactPersonName(contactPersonName);
			customer.setContactPersonDesignation(contactPersonDesignation);
			customer.setOfficeName(officeName);
			customer.setOrganizationName(organizationName);
			customer.setOrganizationType(organizationType);
			customer.setGender(gender);
			customer.setCreateDate(createDate);
			customer.setCreatedBy(user.getUserId());
			customer.setVersion(StatusConstants.DEFAULT_VERSION);
			customer.setStatus(StatusConstants.STATUS_DRAFT);

			customer = salesCustomerPersistence.update(customer);

			SalesCustomerVersionLocalServiceUtil.add(customerId, createdBy, userType, mobileNumber, emailAddress, title,
					contactPersonName, contactPersonDesignation, officeName, organizationName, organizationType, gender,
					officeRegion, officeDistrict, officeUpazilla, officeCityCorporationOrMunicipality,
					officeUnionOrWard, officevillageOrRoad, officeMouzaOrMoholla, officeZipCode, officePostOffice,
					address, serviceContext);

			// Making an Asset

			AssetEntry assetEntry = assetEntryLocalService.updateEntry(createdBy, groupId, customer.getCreateDate(),
					customer.getModifiedDate(), SalesCustomer.class.getName(), customerId, customer.getUuid(), 0,
					serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames(), true, true, null, null,
					null, null, ContentTypes.TEXT_HTML, customer.getOrganizationName(), null, null, null, null, 0, 0,
					null);

			assetLinkLocalService.updateLinks(createdBy, assetEntry.getEntryId(), serviceContext.getAssetLinkEntryIds(),
					AssetLinkConstants.TYPE_RELATED);

			// Initiating workflow

			WorkflowHandlerRegistryUtil.startWorkflowInstance(customer.getCompanyId(), customer.getGroupId(),
					customer.getCreatedBy(), SalesCustomer.class.getName(), customer.getPrimaryKey(), customer,
					serviceContext);
		} catch (Exception e) {
			log.error(" Unexpected Error has occoured ");

			if (Validator.isNotNull(officeAddress)) {
				log.error(" officeAddress model deleted ");
				AddressLocalServiceUtil.deleteAddress(officeAddress);
			}

			if (Validator.isNotNull(customer)) {
				log.error(" customer model deleted ");
				salesCustomerPersistence.remove(customer);
			}

			throw e;

		}

		return customer;

	}

	/**
	 * @param salesCustomerVersion
	 * @return
	 * @throws PortalException
	 */

	public SalesCustomer update(SalesCustomerVersion salesCustomerVersion) throws PortalException {

		List<AddressVersion> officeAddressVersions = AddressVersionLocalServiceUtil
				.getAddressVersionsByClassNameAndClassPK(salesCustomerVersion.getSalesCustomerVersionId(),
						SalesCustomerVersion.class.getName());

		if (ListUtil.isEmpty(officeAddressVersions)) {
			throw new DataValidationException("error-label-address-does-not-exist");
		}

		AddressVersion officeAddressVersion = officeAddressVersions.get(0);

		AddressLocalServiceUtil.updateAddress(salesCustomerVersion.getSalesCustomerId(), SalesCustomer.class.getName(),
				AddressConstants.ADDRESS_OFFICE, officeAddressVersion.getRegion(), officeAddressVersion.getDistrict(),
				officeAddressVersion.getUpazilla(), officeAddressVersion.getCityCorporationOrMunicipality(),
				officeAddressVersion.getUnionOrWard(), officeAddressVersion.getZipCode(),
				officeAddressVersion.getPostOffice(), officeAddressVersion.getVillageOrRoad(),
				officeAddressVersion.getMouzaOrMoholla(), officeAddressVersion.getAddress());

		SalesCustomer customer = getSalesCustomer(salesCustomerVersion.getSalesCustomerId());

		customer.setMobileNumber(salesCustomerVersion.getMobileNumber());
		customer.setEmailAddress(salesCustomerVersion.getEmailAddress());
		customer.setTitle(salesCustomerVersion.getTitle());
		customer.setContactPersonName(salesCustomerVersion.getContactPersonName());
		customer.setContactPersonDesignation(salesCustomerVersion.getContactPersonDesignation());
		customer.setOfficeName(salesCustomerVersion.getOfficeName());
		customer.setOrganizationName(salesCustomerVersion.getOrganizationName());
		customer.setOrganizationType(salesCustomerVersion.getOrganizationType());
		customer.setGender(salesCustomerVersion.getGender());
		customer.setModifiedDate(salesCustomerVersion.getModifiedDate());
		customer.setModifiedBy(salesCustomerVersion.getModifiedBy());
		customer.setVersion(salesCustomerVersion.getVersion());
		customer.setStatusByUserId(salesCustomerVersion.getStatusByUserId());
		customer.setStatusDate(salesCustomerVersion.getStatusDate());

		return salesCustomerPersistence.update(customer);

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
	public SalesCustomer updateStatus(long approverId, long customerId, int status, ServiceContext serviceContext)
			throws PortalException, SystemException {

		log.info(" updateStatus..." + status);

		User approver = userLocalService.getUser(approverId);

		SalesCustomer customer = getSalesCustomer(customerId);

		customer.setStatus(status);
		customer.setStatusByUserId(approver.getUserId());
		customer.setStatusDate(new Date());

		if (status == StatusConstants.STATUS_APPROVED) {

			try {
				User user2 = userLocalService.addUser(approverId, serviceContext.getCompanyId(), true, null, null, true,
						null, null, serviceContext.getLocale(), customer.getContactPersonName(), null, "user", 0L, 0L,
						customer.getGender() == GenderConstants.GENDER_MALE, 0, 1, 1970,
						customer.getContactPersonDesignation(), new long[0], new long[0], new long[0], new long[0],
						false, new ServiceContext());

				customer.setUserId(user2.getUserId());
			} catch (Exception e) {
				log.error("Unable to create a user account for Credit/Other Priority customer :", e);
			}
		}

		// Update status call to Version table

		if (status != StatusConstants.STATUS_PENDING) {

			try {

				SalesCustomerVersionLocalServiceUtil.updateStatus(approverId, approver.getFullName(),
						customer.getSalesCustomerId(), customer.getVersion(), status, customer.getUserId(),
						serviceContext);

			} catch (Exception e) {
				log.error("Unable to update status of SalesCustomerVersion : ", e);
			}
		}

		return salesCustomerPersistence.update(customer);

	}

	/**
	 * @param companyId
	 * @param fromDate
	 * @param toDate
	 * @param status
	 * @param userType
	 * @param organizationName
	 * @param start
	 * @param end
	 * @param params
	 * @return
	 * @throws PortalException
	 */
	public Hits search(long companyId, long fromDate, long toDate, int status, String userType, String organizationName,
			int start, int end, LinkedHashMap<String, Object> params) throws PortalException {

		Indexer<SalesCustomer> indexer = IndexerRegistryUtil.getIndexer(SalesCustomer.class.getName());

		SearchContext searchContext = new SearchContext();

		searchContext.setAttribute(Field.STATUS, status);
		searchContext.setAttribute("organizationName", organizationName);
		searchContext.setAttribute("userType", userType);

		if (toDate > 0) {
			searchContext.setAttribute("toDate", toDate);
		}

		if (fromDate > 0) {
			searchContext.setAttribute("fromDate", fromDate);
		}

//		if (Validator.isNotNull(keywords)) {
//			searchContext.setKeywords(keywords);
//		}

		if (params != null) {

			searchContext.setAttribute("params", params);
		}

		searchContext.setCompanyId(companyId);
		searchContext.setGroupIds(new long[] { -1L });
		searchContext.setSorts(new Sort(Field.CREATE_DATE, Sort.LONG_TYPE, true));

		searchContext.setEnd(end);
		searchContext.setStart(start);

		return indexer.search(searchContext);

	}


	/**
	 * @param fromDate
	 * @param toDate
	 * @param status
	 * @param userType
	 * @param organizationName
	 * @param start
	 * @param end
	 * @param params
	 * @return
	 * @throws PortalException
	 */
	public List<SalesCustomer> search(Date fromDate, Date toDate, int status, String userType, String organizationName,
			int start, int end, LinkedHashMap<String, Object> params) throws PortalException {

		DynamicQuery dynamicQuery = salesCustomerLocalService.dynamicQuery();

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		Disjunction disjunction = RestrictionsFactoryUtil.disjunction();

		conjunction.add(RestrictionsFactoryUtil.eq("userType", userType));

		if (status != -1) {
			conjunction.add(RestrictionsFactoryUtil.eq("status", status));
		}

		if (Validator.isNotNull(fromDate) && Validator.isNotNull(toDate)) {

			conjunction.add(RestrictionsFactoryUtil.gt("createDate", fromDate));
			conjunction.add(RestrictionsFactoryUtil.lt("createDate", toDate));

		}

		dynamicQuery.add(RestrictionsFactoryUtil.and(disjunction, conjunction));

		dynamicQuery.addOrder(OrderFactoryUtil.desc("createDate"));

		return salesCustomerLocalService.dynamicQuery(dynamicQuery, start, end);
	}


	/**
	 * @param fromDate
	 * @param toDate
	 * @param status
	 * @param userType
	 * @param organizationName
	 * @param start
	 * @param end
	 * @param params
	 * @return
	 * @throws PortalException
	 */
	public int searchCount(Date fromDate, Date toDate, int status, String userType, String organizationName, int start,
			int end, LinkedHashMap<String, Object> params) throws PortalException {

		DynamicQuery dynamicQuery = salesCustomerLocalService.dynamicQuery();

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		Disjunction disjunction = RestrictionsFactoryUtil.disjunction();

		conjunction.add(RestrictionsFactoryUtil.eq("userType", userType));

		if (status != -1) {
			conjunction.add(RestrictionsFactoryUtil.eq("status", status));
		}

		if (Validator.isNotNull(fromDate) && Validator.isNotNull(toDate)) {

			conjunction.add(RestrictionsFactoryUtil.gt("createDate", fromDate));
			conjunction.add(RestrictionsFactoryUtil.lt("createDate", toDate));

		}

		dynamicQuery.add(RestrictionsFactoryUtil.and(disjunction, conjunction));

		return (int) salesCustomerLocalService.dynamicQueryCount(dynamicQuery);
	}
	
	/**
	 * @param userId
	 * @return
	 * @throws NoSuchSalesCustomerException 
	 */
	public SalesCustomer getSalesCustomerByUserId(long userId) {
		return salesCustomerPersistence.fetchByUserId(userId);
		
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

	private static Log log = LogFactoryUtil.getLog(SalesCustomerLocalServiceImpl.class);

	@Reference
	protected AssetLinkLocalService assetLinkLocalService;
}