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

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.multipart.BinaryFile;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.common.services.model.Attachment;
import bd.gov.dgfood.common.services.model.BankAccountInformation;
import bd.gov.dgfood.common.services.service.AttachmentLocalService;
import bd.gov.dgfood.common.services.service.BankAccountInformationLocalService;
import bd.gov.dgfood.common.util.ApplicationNumberUtil;
import bd.gov.dgfood.common.util.DLUploadUtil;
import bd.gov.dgfood.common.util.constants.DocumentLibraryConstants;
import bd.gov.dgfood.common.util.constants.ParameterConstants;
import bd.gov.dgfood.common.util.constants.StatusConstants;
import bd.gov.dgfood.farmer.information.management.system.exception.FarmerRegistrationInternalErrorException;
import bd.gov.dgfood.farmer.information.management.system.model.FarmerRegistration;
import bd.gov.dgfood.farmer.information.management.system.model.FarmerSalesProposal;
import bd.gov.dgfood.farmer.information.management.system.service.FarmerRegistrationLocalService;
import bd.gov.dgfood.farmer.information.management.system.service.base.FarmerSalesProposalLocalServiceBaseImpl;
import bd.gov.dgfood.farmer.information.management.system.validator.FarmerInformationValidator;

/**
 * The implementation of the farmer sales proposal local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>bd.gov.dgfood.farmer.information.management.system.service.FarmerSalesProposalLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FarmerSalesProposalLocalServiceBaseImpl
 */
@Component(property = "model.class.name=bd.gov.dgfood.farmer.information.management.system.model.FarmerSalesProposal", service = AopService.class)
public class FarmerSalesProposalLocalServiceImpl extends FarmerSalesProposalLocalServiceBaseImpl {

	/**
	 * It will add a new Farmer Sales Proposal record in the Farmer Sales Proposal
	 * master table
	 * 
	 * @return FarmerSalesProposal
	 * @throws PortalException
	 */
	public FarmerSalesProposal addFarmerSalesProposal(long farmerRegistrationId, String businessCode,
			String currentSeason, String foodgrainType, String krishiCardNumber, String pastProdDataSeason1Name,
			String pastProdDataSeason1Year, double pastProdDataSeason1Qty, String pastProdDataSeason1QtyUnit,
			String pastProdDataSeason2Name, String pastProdDataSeason2Year, double pastProdDataSeason2Qty,
			String pastProdDataSeason2QtyUnit, String pastProdDataSeason3Name, String pastProdDataSeason3Year,
			double pastProdDataSeason3Qty, String pastProdDataSeason3QtyUnit, String succeedingProdDataSeason1Name,
			String succeedingProdDataSeason1Year, double succeedingProdDataSeason1Qty,
			String succeedingProdDataSeason1QtyUnit, String succeedingProdDataSeason2Name,
			String succeedingProdDataSeason2Year, double succeedingProdDataSeason2Qty,
			String succeedingProdDataSeason2QtyUnit, String succeedingProdDataSeason3Name,
			String succeedingProdDataSeason3Year, double succeedingProdDataSeason3Qty,
			String succeedingProdDataSeason3QtyUnit, boolean isGrainProcuredInLast4Seasons,
			String foodgrainProcuredSeason1Name, String foodgrainProcuredSeason1Year,
			String foodgrainProcuredSeason2Name, String foodgrainProcuredSeason2Year,
			String foodgrainProcuredSeason3Name, String foodgrainProcuredSeason3Year,
			String foodgrainProcuredSeason4Name, String foodgrainProcuredSeason4Year,
			String cultivableLandSeason1RiceType, String cultivableLandSeason2RiceType,
			String cultivableLandSeason3RiceType, long groupId, ServiceContext serviceContext

	) throws PortalException {

		FarmerSalesProposal farmerSalesProposal = createFarmerSalesProposal(
				counterLocalService.increment(this.getClass().getName(), 1));
		farmerSalesProposal.setApplicationNumber(ApplicationNumberUtil
				.generateApplicationNumber(farmerSalesProposal.getFarmerSalesProposalId(), "FIMS"));

		farmerSalesProposal.setFarmerRegistrationId(farmerRegistrationId);
		farmerSalesProposal.setBusinessCode(businessCode);

		farmerSalesProposal.setCurrentSeason(currentSeason);
		farmerSalesProposal.setFoodGrainType(foodgrainType);
		farmerSalesProposal.setKrishiCardNumber(krishiCardNumber);

		Map<String, Serializable> pastProdDataSeason1 = new HashMap<String, Serializable>();
		pastProdDataSeason1.put(ParameterConstants.NAME, pastProdDataSeason1Name);
		pastProdDataSeason1.put(ParameterConstants.YEAR, pastProdDataSeason1Year);
		pastProdDataSeason1.put(ParameterConstants.FOODGRAIN_QUANTITY, pastProdDataSeason1Qty);
		pastProdDataSeason1.put(ParameterConstants.UNIT, pastProdDataSeason1QtyUnit);
		farmerSalesProposal.setPastProdDataSeason1(pastProdDataSeason1);

		Map<String, Serializable> pastProdDataSeason2 = new HashMap<String, Serializable>();
		pastProdDataSeason2.put(ParameterConstants.NAME, pastProdDataSeason2Name);
		pastProdDataSeason2.put(ParameterConstants.YEAR, pastProdDataSeason2Year);
		pastProdDataSeason2.put(ParameterConstants.FOODGRAIN_QUANTITY, pastProdDataSeason2Qty);
		pastProdDataSeason2.put(ParameterConstants.UNIT, pastProdDataSeason2QtyUnit);
		farmerSalesProposal.setPastProdDataSeason2(pastProdDataSeason2);

		Map<String, Serializable> pastProdDataSeason3 = new HashMap<String, Serializable>();
		pastProdDataSeason3.put(ParameterConstants.NAME, pastProdDataSeason3Name);
		pastProdDataSeason3.put(ParameterConstants.YEAR, pastProdDataSeason3Year);
		pastProdDataSeason3.put(ParameterConstants.FOODGRAIN_QUANTITY, pastProdDataSeason3Qty);
		pastProdDataSeason3.put(ParameterConstants.UNIT, pastProdDataSeason3QtyUnit);
		farmerSalesProposal.setPastProdDataSeason3(pastProdDataSeason3);

		Map<String, Serializable> succeedingProdDataSeason1 = new HashMap<String, Serializable>();
		succeedingProdDataSeason1.put(ParameterConstants.NAME, succeedingProdDataSeason1Name);
		succeedingProdDataSeason1.put(ParameterConstants.YEAR, succeedingProdDataSeason1Year);
		succeedingProdDataSeason1.put(ParameterConstants.FOODGRAIN_QUANTITY, succeedingProdDataSeason1Qty);
		succeedingProdDataSeason1.put(ParameterConstants.UNIT, succeedingProdDataSeason1QtyUnit);
		farmerSalesProposal.setSucceedingProdDataSeason1(succeedingProdDataSeason1);

		Map<String, Serializable> succeedingProdDataSeason2 = new HashMap<String, Serializable>();
		succeedingProdDataSeason2.put(ParameterConstants.NAME, succeedingProdDataSeason2Name);
		succeedingProdDataSeason2.put(ParameterConstants.YEAR, succeedingProdDataSeason2Year);
		succeedingProdDataSeason2.put(ParameterConstants.FOODGRAIN_QUANTITY, succeedingProdDataSeason2Qty);
		succeedingProdDataSeason2.put(ParameterConstants.UNIT, succeedingProdDataSeason2QtyUnit);
		farmerSalesProposal.setSucceedingProdDataSeason2(succeedingProdDataSeason2);

		Map<String, Serializable> succeedingProdDataSeason3 = new HashMap<String, Serializable>();
		succeedingProdDataSeason3.put(ParameterConstants.NAME, succeedingProdDataSeason3Name);
		succeedingProdDataSeason3.put(ParameterConstants.YEAR, succeedingProdDataSeason3Year);
		succeedingProdDataSeason3.put(ParameterConstants.FOODGRAIN_QUANTITY, succeedingProdDataSeason3Qty);
		succeedingProdDataSeason3.put(ParameterConstants.UNIT, succeedingProdDataSeason3QtyUnit);
		farmerSalesProposal.setSucceedingProdDataSeason3(succeedingProdDataSeason3);

		farmerSalesProposal.setGrainProcuredInLast4Seasons(isGrainProcuredInLast4Seasons);
		logger.debug(isGrainProcuredInLast4Seasons);
		
		if(isGrainProcuredInLast4Seasons)
		{
			Map<String, Serializable> foodgrainProcuredSeason1 = new HashMap<String, Serializable>();
			foodgrainProcuredSeason1.put(ParameterConstants.NAME, foodgrainProcuredSeason1Name);
			foodgrainProcuredSeason1.put(ParameterConstants.YEAR, foodgrainProcuredSeason1Year);
			farmerSalesProposal.setFoodgranProcuredSeason1(foodgrainProcuredSeason1);
			
			Map<String, Serializable> foodgrainProcuredSeason2 = new HashMap<String, Serializable>();
			foodgrainProcuredSeason2.put(ParameterConstants.NAME, foodgrainProcuredSeason2Name);
			foodgrainProcuredSeason2.put(ParameterConstants.YEAR, foodgrainProcuredSeason2Year);
			farmerSalesProposal.setFoodgranProcuredSeason2(foodgrainProcuredSeason2);
			
			Map<String, Serializable> foodgrainProcuredSeason3 = new HashMap<String, Serializable>();
			foodgrainProcuredSeason3.put(ParameterConstants.NAME, foodgrainProcuredSeason3Name);
			foodgrainProcuredSeason3.put(ParameterConstants.YEAR, foodgrainProcuredSeason3Year);
			farmerSalesProposal.setFoodgranProcuredSeason3(foodgrainProcuredSeason3);
			
			Map<String, Serializable> foodgrainProcuredSeason4 = new HashMap<String, Serializable>();
			foodgrainProcuredSeason4.put(ParameterConstants.NAME, foodgrainProcuredSeason4Name);
			foodgrainProcuredSeason4.put(ParameterConstants.YEAR, foodgrainProcuredSeason4Year);
			farmerSalesProposal.setFoodgranProcuredSeason4(foodgrainProcuredSeason4);
		}


		FarmerRegistration farmerRegistration = farmerRegistrationLocalService
				.getFarmerRegistration(farmerRegistrationId);

		Map<String, Serializable> cultivableLandSeason1 = farmerRegistration.getCultivableLandSeason1();
		cultivableLandSeason1.put(ParameterConstants.RICE_TYPE, cultivableLandSeason1RiceType);
		farmerSalesProposal.setCultivableLandSeason1(cultivableLandSeason1);

		Map<String, Serializable> cultivableLandSeason2 = farmerRegistration.getCultivableLandSeason2();
		cultivableLandSeason2.put(ParameterConstants.RICE_TYPE, cultivableLandSeason2RiceType);
		farmerSalesProposal.setCultivableLandSeason2(cultivableLandSeason2);

		Map<String, Serializable> cultivableLandSeason3 = farmerRegistration.getCultivableLandSeason3();
		cultivableLandSeason3.put(ParameterConstants.RICE_TYPE, cultivableLandSeason3RiceType);
		farmerSalesProposal.setCultivableLandSeason3(cultivableLandSeason3);

		// TODO: Updated Version code implemantation
		farmerSalesProposal.setVersion(counterLocalService
				.increment(this.getClass().getName() + farmerSalesProposal.getFarmerSalesProposalId(), 1));

		farmerSalesProposal.setGroupId(groupId);
		farmerSalesProposal.setCompanyId(serviceContext.getCompanyId());
		farmerSalesProposal.setCreateDate(new Date());
		farmerSalesProposal.setCreatedBy(serviceContext.getUserId());

		farmerSalesProposal.setStatus(StatusConstants.STATUS_PENDING);
		farmerSalesProposal.setStatusDate(new Date());

		farmerSalesProposal = addFarmerSalesProposal(farmerSalesProposal);
		logger.debug(farmerSalesProposal);
		return farmerSalesProposal;
	}

	public FarmerSalesProposal addFarmerSalesProposalFormData(boolean isHeadlessRequest, long farmerRegistrationId,
			String businessCode, String currentSeason, String foodgrainType, String krishiCardNumber,
			String pastProdDataSeason1Name, String pastProdDataSeason1Year, double pastProdDataSeason1Qty,
			String pastProdDataSeason1QtyUnit, String pastProdDataSeason2Name, String pastProdDataSeason2Year,
			double pastProdDataSeason2Qty, String pastProdDataSeason2QtyUnit, String pastProdDataSeason3Name,
			String pastProdDataSeason3Year, double pastProdDataSeason3Qty, String pastProdDataSeason3QtyUnit,
			String succeedingProdDataSeason1Name, String succeedingProdDataSeason1Year,
			double succeedingProdDataSeason1Qty, String succeedingProdDataSeason1QtyUnit,
			String succeedingProdDataSeason2Name, String succeedingProdDataSeason2Year,
			double succeedingProdDataSeason2Qty, String succeedingProdDataSeason2QtyUnit,
			String succeedingProdDataSeason3Name, String succeedingProdDataSeason3Year,
			double succeedingProdDataSeason3Qty, String succeedingProdDataSeason3QtyUnit,
			boolean isGrainProcuredInLast4Seasons, String foodgrainProcuredSeason1Name,
			String foodgrainProcuredSeason1Year, BinaryFile foodgrainProcuredSeason1WQSC,
			String foodgrainProcuredSeason2Name, String foodgrainProcuredSeason2Year,
			BinaryFile foodgrainProcuredSeason2WQSC, String foodgrainProcuredSeason3Name,
			String foodgrainProcuredSeason3Year, BinaryFile foodgrainProcuredSeason3WQSC,
			String foodgrainProcuredSeason4Name, String foodgrainProcuredSeason4Year,
			BinaryFile foodgrainProcuredSeason4WQSC, String cultivableLandSeason1RiceType,
			String cultivableLandSeason2RiceType, String cultivableLandSeason3RiceType, String bankAccountNumber,
			String bankName, String branchName, String routingCode, long groupId, ServiceContext serviceContext)
			throws PortalException {

		FarmerInformationValidator.validateFarmerSalesProposalFormData(isHeadlessRequest, currentSeason, foodgrainType,
				krishiCardNumber, pastProdDataSeason1Name, pastProdDataSeason1Year, pastProdDataSeason1Qty,
				pastProdDataSeason1QtyUnit, pastProdDataSeason2Name, pastProdDataSeason2Year, pastProdDataSeason2Qty,
				pastProdDataSeason2QtyUnit, pastProdDataSeason3Name, pastProdDataSeason3Year, pastProdDataSeason3Qty,
				pastProdDataSeason3QtyUnit, succeedingProdDataSeason1Name, succeedingProdDataSeason1Year,
				succeedingProdDataSeason1Qty, succeedingProdDataSeason1QtyUnit, succeedingProdDataSeason2Name,
				succeedingProdDataSeason2Year, succeedingProdDataSeason2Qty, succeedingProdDataSeason2QtyUnit,
				succeedingProdDataSeason3Name, succeedingProdDataSeason3Year, succeedingProdDataSeason3Qty,
				succeedingProdDataSeason3QtyUnit, isGrainProcuredInLast4Seasons, foodgrainProcuredSeason1Name,
				foodgrainProcuredSeason1Year, foodgrainProcuredSeason1WQSC, foodgrainProcuredSeason2Name,
				foodgrainProcuredSeason2Year, foodgrainProcuredSeason2WQSC, foodgrainProcuredSeason3Name,
				foodgrainProcuredSeason3Year, foodgrainProcuredSeason3WQSC, foodgrainProcuredSeason4Name,
				foodgrainProcuredSeason4Year, foodgrainProcuredSeason4WQSC, cultivableLandSeason1RiceType,
				cultivableLandSeason2RiceType, cultivableLandSeason3RiceType, bankAccountNumber, bankName, branchName,
				routingCode);

		FarmerSalesProposal farmerSalesProposal = null;
		BankAccountInformation bankAccountInformation = null;
		Attachment foodgrainProcuredSeason1WQSCattachment = null;
		Attachment foodgrainProcuredSeason2WQSCattachment = null;
		Attachment foodgrainProcuredSeason3WQSCattachment = null;
		Attachment foodgrainProcuredSeason4WQSCattachment = null;

		try {
			farmerSalesProposal = addFarmerSalesProposal(farmerRegistrationId, businessCode, currentSeason,
					foodgrainType, krishiCardNumber, pastProdDataSeason1Name, pastProdDataSeason1Year,
					pastProdDataSeason1Qty, pastProdDataSeason1QtyUnit, pastProdDataSeason2Name, pastProdDataSeason2Year,
					pastProdDataSeason2Qty, pastProdDataSeason2QtyUnit, pastProdDataSeason3Name, pastProdDataSeason3Year,
					pastProdDataSeason3Qty, pastProdDataSeason3QtyUnit, succeedingProdDataSeason1Name,
					succeedingProdDataSeason1Year, succeedingProdDataSeason1Qty, succeedingProdDataSeason1QtyUnit,
					succeedingProdDataSeason2Name, succeedingProdDataSeason2Year, succeedingProdDataSeason2Qty,
					succeedingProdDataSeason2QtyUnit, succeedingProdDataSeason3Name, succeedingProdDataSeason3Year,
					succeedingProdDataSeason3Qty, succeedingProdDataSeason3QtyUnit, isGrainProcuredInLast4Seasons,
					foodgrainProcuredSeason1Name, foodgrainProcuredSeason1Year, foodgrainProcuredSeason2Name,
					foodgrainProcuredSeason2Year, foodgrainProcuredSeason3Name, foodgrainProcuredSeason3Year,
					foodgrainProcuredSeason4Name, foodgrainProcuredSeason4Year, cultivableLandSeason1RiceType,
					cultivableLandSeason2RiceType, cultivableLandSeason3RiceType, groupId, serviceContext);

			bankAccountInformation = bankAccountInformationLocalService.addBankAccountInformation(bankAccountNumber,
					bankName, branchName, FarmerSalesProposal.class.getName(),
					farmerSalesProposal.getFarmerSalesProposalId(), serviceContext);

			if (!isHeadlessRequest) {

				long farmerSalesProposalFolderId = getFarmerSalesProposalFolder(
						farmerSalesProposal.getFarmerSalesProposalId(), serviceContext);

				foodgrainProcuredSeason1WQSCattachment = DLUploadUtil.addAttachment(farmerSalesProposalFolderId,
						foodgrainProcuredSeason1WQSC, null, null,
						DocumentLibraryConstants.PROCURED_FOODGRAIN_WQSC_SEASON_1, FarmerSalesProposal.class.getName(),
						farmerSalesProposal.getFarmerSalesProposalId(), serviceContext);

				foodgrainProcuredSeason2WQSCattachment = DLUploadUtil.addAttachment(farmerSalesProposalFolderId,
						foodgrainProcuredSeason2WQSC, null, null,
						DocumentLibraryConstants.PROCURED_FOODGRAIN_WQSC_SEASON_2, FarmerSalesProposal.class.getName(),
						farmerSalesProposal.getFarmerSalesProposalId(), serviceContext);

				foodgrainProcuredSeason3WQSCattachment = DLUploadUtil.addAttachment(farmerSalesProposalFolderId,
						foodgrainProcuredSeason3WQSC, null, null,
						DocumentLibraryConstants.PROCURED_FOODGRAIN_WQSC_SEASON_3, FarmerSalesProposal.class.getName(),
						farmerSalesProposal.getFarmerSalesProposalId(), serviceContext);

				foodgrainProcuredSeason4WQSCattachment = DLUploadUtil.addAttachment(farmerSalesProposalFolderId,
						foodgrainProcuredSeason4WQSC, null, null,
						DocumentLibraryConstants.PROCURED_FOODGRAIN_WQSC_SEASON_4, FarmerSalesProposal.class.getName(),
						farmerSalesProposal.getFarmerSalesProposalId(), serviceContext);
			}

		} catch (Exception exception) {

			logger.error(
					"Caught exception while adding farmer sales proposal application data: " + exception.getMessage());

			cleanFarmerSalesProposalFormData(farmerSalesProposal, bankAccountInformation,
					foodgrainProcuredSeason1WQSCattachment, foodgrainProcuredSeason2WQSCattachment,
					foodgrainProcuredSeason3WQSCattachment, foodgrainProcuredSeason4WQSCattachment);

			if (logger.isDebugEnabled()) {
				exception.printStackTrace();
			}

			throw new FarmerRegistrationInternalErrorException(
					"Unable to Submit Farmer Sales Proposal Application data: " + exception.getMessage());

		}

		return farmerSalesProposal;

	}

	/**
	 * To get the Farme's Sales Proposal folder Id
	 * 
	 * @param salesProposalId: Holds the Farmer Sales Proposal id
	 * @param serviceContext:  holds Object of ServiceContext and used for Folder
	 *                         Creation
	 * @return farmerSalesProposalFolderId: Farme's Sales Proposal folder Id
	 */
	protected long getFarmerSalesProposalFolder(long salesProposalId, ServiceContext serviceContext) {
		Folder fimsRootFolder = DLUploadUtil.createFolder(serviceContext, 0,
				DocumentLibraryConstants.FIMS_ROOT_FOLDER_NAME);
		Folder salesProposalFolder = DLUploadUtil.createFolder(serviceContext, fimsRootFolder.getFolderId(),
				DocumentLibraryConstants.FIMS_SALES_PROPOSAL_FOLDER_NAME);
		Folder farmerSalesProposalFolder = DLUploadUtil.createFolder(serviceContext, salesProposalFolder.getFolderId(),
				DocumentLibraryConstants.FIMS_SALES_PROPOSAL_FOLDER_PREFIX + salesProposalId);

		return farmerSalesProposalFolder.getFolderId();
	}

	protected void cleanFarmerSalesProposalFormData(FarmerSalesProposal farmerSalesProposal,
			BankAccountInformation bankAccountInformation, Attachment foodgrainProcuredSeason1WQSCattachment,
			Attachment foodgrainProcuredSeason2WQSCattachment, Attachment foodgrainProcuredSeason3WQSCattachment,
			Attachment foodgrainProcuredSeason4WQSCattachment) {

		if (Validator.isNotNull(farmerSalesProposal)) {
			deleteFarmerSalesProposal(farmerSalesProposal);
		}

		if (Validator.isNotNull(bankAccountInformation)) {
			bankAccountInformationLocalService.deleteBankAccountInformation(bankAccountInformation);
		}

		if (Validator.isNotNull(foodgrainProcuredSeason1WQSCattachment)) {
			attachmentLocalService.deleteAttachment(foodgrainProcuredSeason1WQSCattachment);
		}
		if (Validator.isNotNull(foodgrainProcuredSeason2WQSCattachment)) {
			attachmentLocalService.deleteAttachment(foodgrainProcuredSeason2WQSCattachment);
		}
		if (Validator.isNotNull(foodgrainProcuredSeason3WQSCattachment)) {
			attachmentLocalService.deleteAttachment(foodgrainProcuredSeason3WQSCattachment);
		}
		if (Validator.isNotNull(foodgrainProcuredSeason4WQSCattachment)) {
			attachmentLocalService.deleteAttachment(foodgrainProcuredSeason4WQSCattachment);
		}

		// TODO: Remove attchments folder
	}

	private Log logger = LogFactoryUtil.getLog(this.getClass());

	@Reference
	private AttachmentLocalService attachmentLocalService;

	@Reference
	private BankAccountInformationLocalService bankAccountInformationLocalService;

	@Reference
	private FarmerRegistrationLocalService farmerRegistrationLocalService;
}