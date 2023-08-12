package bd.gov.dgfood.farmer.information.management.system.web.portlet.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.vulcan.multipart.BinaryFile;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.common.util.DLUploadUtil;
import bd.gov.dgfood.common.util.constants.ParameterConstants;
import bd.gov.dgfood.common.util.constants.StatusConstants;
import bd.gov.dgfood.common.util.constants.UnitConstants;
import bd.gov.dgfood.common.util.validator.DataValidationException;
import bd.gov.dgfood.farmer.information.management.system.exception.FarmerSalesProposalInternalErrorException;
import bd.gov.dgfood.farmer.information.management.system.model.FarmerRegistration;
import bd.gov.dgfood.farmer.information.management.system.model.FarmerSalesProposal;
import bd.gov.dgfood.farmer.information.management.system.service.FarmerRegistrationLocalService;
import bd.gov.dgfood.farmer.information.management.system.service.FarmerSalesProposalLocalService;
import bd.gov.dgfood.farmer.information.management.system.web.constants.FarmerInformationManagementSystemConstants;
import bd.gov.dgfood.farmer.information.management.system.web.constants.FarmerInformationManagementSystemPortletKeys;

@Component(immediate = true, property = {
		"javax.portlet.name=" + FarmerInformationManagementSystemPortletKeys.FARMERINFORMATIONMANAGEMENTSYSTEM,
		"mvc.command.name="
				+ FarmerInformationManagementSystemConstants.SUBMIT_SALES_PROPOSAL_FORM_ACTION_COMMAND }, service = MVCActionCommand.class)
public class SubmitSalesProposalApplicationDataActioanCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
		try {
			// Get Farmer Registration based on the current loggedin userId
			FarmerRegistration farmerRegistration = farmerRegistrationLocalService
					.fetchFarmerRegistrationByUserId(serviceContext.getUserId());
			if (Validator.isNull(farmerRegistration)) {
				throw new DataValidationException(
						"Please Register your-self as a Farmer before submiting you Sales Proposal Application");
			} else if (farmerRegistration.getStatus() != StatusConstants.STATUS_APPROVED) {
				throw new DataValidationException("Your Registration application is not yet approved");
			}

			// TODO: Fetch current season and foodgrain type from season configurations
			String currentSeason = "boro";
			String foodgrainType = "rice";
			
			String accountNumber = ParamUtil.getString(actionRequest, ParameterConstants.ACCOUNT_NUMBER);
			String bankName = ParamUtil.getString(actionRequest, ParameterConstants.BANK_NAME);
			String branchName = ParamUtil.getString(actionRequest, ParameterConstants.BRANCH_NAME);
			String routingCode = ParamUtil.getString(actionRequest, ParameterConstants.ROUTING_CODE);

			String pastProdDataSeason1Name = ParamUtil.getString(actionRequest,
					ParameterConstants.PAST_PROD_DATA_SEASON_1_NAME);
			String pastProdDataSeason1Year = ParamUtil.getString(actionRequest,
					ParameterConstants.PAST_PROD_DATA_SEASON_1_YEAR);
			double pastProdDataSeason1FoodgrainQuantity = ParamUtil.getDouble(actionRequest,
					ParameterConstants.PAST_PROD_DATA_SEASON_1_FOODGRAIN_QUANTITY);
			String pastProdDataSeason2Name = ParamUtil.getString(actionRequest,
					ParameterConstants.PAST_PROD_DATA_SEASON_2_NAME);
			String pastProdDataSeason2Year = ParamUtil.getString(actionRequest,
					ParameterConstants.PAST_PROD_DATA_SEASON_2_YEAR);
			double pastProdDataSeason2FoodgrainQuantity = ParamUtil.getDouble(actionRequest,
					ParameterConstants.PAST_PROD_DATA_SEASON_2_FOODGRAIN_QUANTITY);
			String pastProdDataSeason3Name = ParamUtil.getString(actionRequest,
					ParameterConstants.PAST_PROD_DATA_SEASON_3_NAME);
			String pastProdDataSeason3Year = ParamUtil.getString(actionRequest,
					ParameterConstants.PAST_PROD_DATA_SEASON_3_YEAR);
			double pastProdDataSeason3FoodgrainQuantity = ParamUtil.getDouble(actionRequest,
					ParameterConstants.PAST_PROD_DATA_SEASON_3_FOODGRAIN_QUANTITY);

			String succeedingProdDataSeason1Name = ParamUtil.getString(actionRequest,
					ParameterConstants.SUCCEEDING_PROD_DATA_SEASON_1_NAME);
			String succeedingProdDataSeason1Year = ParamUtil.getString(actionRequest,
					ParameterConstants.SUCCEEDING_PROD_DATA_SEASON_1_YEAR);
			double succeedingProdDataSeason1FoodgrainQuantity = ParamUtil.getDouble(actionRequest,
					ParameterConstants.SUCCEEDING_PROD_DATA_SEASON_1_FOODGRAIN_QUANTITY);
			String succeedingProdDataSeason2Name = ParamUtil.getString(actionRequest,
					ParameterConstants.SUCCEEDING_PROD_DATA_SEASON_2_NAME);
			String succeedingProdDataSeason2Year = ParamUtil.getString(actionRequest,
					ParameterConstants.SUCCEEDING_PROD_DATA_SEASON_2_YEAR);
			double succeedingProdDataSeason2FoodgrainQuantity = ParamUtil.getDouble(actionRequest,
					ParameterConstants.SUCCEEDING_PROD_DATA_SEASON_2_FOODGRAIN_QUANTITY);
			String succeedingProdDataSeason3Name = ParamUtil.getString(actionRequest,
					ParameterConstants.SUCCEEDING_PROD_DATA_SEASON_3_NAME);
			String succeedingProdDataSeason3Year = ParamUtil.getString(actionRequest,
					ParameterConstants.SUCCEEDING_PROD_DATA_SEASON_3_YEAR);
			double succeedingProdDataSeason3FoodgrainQuantity = ParamUtil.getDouble(actionRequest,
					ParameterConstants.SUCCEEDING_PROD_DATA_SEASON_3_FOODGRAIN_QUANTITY);

			boolean isGrainProcuredInLast4Seasons = ParamUtil.getBoolean(actionRequest,
					ParameterConstants.IS_GRAIN_PROCURED_IN_LAST_4_SEASONS);
			String foodgrainProcuredSeason1Name = StringPool.BLANK;
			String foodgrainProcuredSeason1Year = StringPool.BLANK;
			BinaryFile foodgrainProcuredSeason1WQSC = null;
			String foodgrainProcuredSeason2Name = StringPool.BLANK;
			String foodgrainProcuredSeason2Year = StringPool.BLANK;
			BinaryFile foodgrainProcuredSeason2WQSC = null;
			String foodgrainProcuredSeason3Name = StringPool.BLANK;
			String foodgrainProcuredSeason3Year = StringPool.BLANK;
			BinaryFile foodgrainProcuredSeason3WQSC = null;
			String foodgrainProcuredSeason4Name = StringPool.BLANK;
			String foodgrainProcuredSeason4Year = StringPool.BLANK;
			BinaryFile foodgrainProcuredSeason4WQSC = null;
			
			logger.debug(isGrainProcuredInLast4Seasons);
			
			if (isGrainProcuredInLast4Seasons) {
				foodgrainProcuredSeason1Name = ParamUtil.getString(actionRequest,
						ParameterConstants.FOODGRAIN_PROCURED_SEASON_1_NAME);
				foodgrainProcuredSeason1Year = ParamUtil.getString(actionRequest,
						ParameterConstants.FOODGRAIN_PROCURED_SEASON_1_YEAR);
				foodgrainProcuredSeason1WQSC = DLUploadUtil
						.getBinaryFile(ParameterConstants.FOODGRAIN_PROCURED_SEASON_1_WQSC, actionRequest);

				foodgrainProcuredSeason2Name = ParamUtil.getString(actionRequest,
						ParameterConstants.FOODGRAIN_PROCURED_SEASON_2_NAME);
				foodgrainProcuredSeason2Year = ParamUtil.getString(actionRequest,
						ParameterConstants.FOODGRAIN_PROCURED_SEASON_2_YEAR);
				foodgrainProcuredSeason2WQSC = DLUploadUtil
						.getBinaryFile(ParameterConstants.FOODGRAIN_PROCURED_SEASON_2_WQSC, actionRequest);

				foodgrainProcuredSeason3Name = ParamUtil.getString(actionRequest,
						ParameterConstants.FOODGRAIN_PROCURED_SEASON_3_NAME);
				foodgrainProcuredSeason3Year = ParamUtil.getString(actionRequest,
						ParameterConstants.FOODGRAIN_PROCURED_SEASON_3_YEAR);
				foodgrainProcuredSeason3WQSC = DLUploadUtil
						.getBinaryFile(ParameterConstants.FOODGRAIN_PROCURED_SEASON_3_WQSC, actionRequest);

				foodgrainProcuredSeason4Name = ParamUtil.getString(actionRequest,
						ParameterConstants.FOODGRAIN_PROCURED_SEASON_4_NAME);
				foodgrainProcuredSeason4Year = ParamUtil.getString(actionRequest,
						ParameterConstants.FOODGRAIN_PROCURED_SEASON_4_YEAR);
				foodgrainProcuredSeason4WQSC = DLUploadUtil
						.getBinaryFile(ParameterConstants.FOODGRAIN_PROCURED_SEASON_4_WQSC, actionRequest);

			}

			String cultivableLandSeason1RiceType = ParamUtil.getString(actionRequest,
					ParameterConstants.CULTIVABLE_LAND_SEASON_1_RICE_TYPE);
			String cultivableLandSeason2RiceType = ParamUtil.getString(actionRequest,
					ParameterConstants.CULTIVABLE_LAND_SEASON_2_RICE_TYPE);
			String cultivableLandSeason3RiceType = ParamUtil.getString(actionRequest,
					ParameterConstants.CULTIVABLE_LAND_SEASON_3_RICE_TYPE);

			FarmerSalesProposal farmerSalesProposal = farmerSalesProposalLocalService.addFarmerSalesProposalFormData(
					false, farmerRegistration.getFarmerRegistrationId(), farmerRegistration.getBusinessCode(),
					currentSeason, foodgrainType, farmerRegistration.getKrishokCardNumber(), pastProdDataSeason1Name, pastProdDataSeason1Year,
					pastProdDataSeason1FoodgrainQuantity, UnitConstants.UNIT_MT, pastProdDataSeason2Name,
					pastProdDataSeason2Year, pastProdDataSeason2FoodgrainQuantity, UnitConstants.UNIT_MT,
					pastProdDataSeason3Name, pastProdDataSeason3Year, pastProdDataSeason3FoodgrainQuantity,
					UnitConstants.UNIT_MT, succeedingProdDataSeason1Name, succeedingProdDataSeason1Year,
					succeedingProdDataSeason1FoodgrainQuantity, UnitConstants.UNIT_MT, succeedingProdDataSeason2Name,
					succeedingProdDataSeason2Year, succeedingProdDataSeason2FoodgrainQuantity, UnitConstants.UNIT_MT,
					succeedingProdDataSeason3Name, succeedingProdDataSeason3Year,
					succeedingProdDataSeason3FoodgrainQuantity, UnitConstants.UNIT_MT, isGrainProcuredInLast4Seasons,
					foodgrainProcuredSeason1Name, foodgrainProcuredSeason1Year, foodgrainProcuredSeason1WQSC,
					foodgrainProcuredSeason2Name, foodgrainProcuredSeason2Year, foodgrainProcuredSeason2WQSC,
					foodgrainProcuredSeason3Name, foodgrainProcuredSeason3Year, foodgrainProcuredSeason3WQSC,
					foodgrainProcuredSeason4Name, foodgrainProcuredSeason4Year, foodgrainProcuredSeason4WQSC,
					cultivableLandSeason1RiceType, cultivableLandSeason2RiceType, cultivableLandSeason3RiceType,
					accountNumber, bankName, branchName, routingCode, themeDisplay.getScopeGroupId(), serviceContext);

			logger.debug(farmerSalesProposal);

			actionResponse.setRenderParameter(ParameterConstants.APPLICATION_NUMBER,
					farmerSalesProposal.getApplicationNumber());
			actionResponse.setRenderParameter("mvcPath",
					FarmerInformationManagementSystemConstants.SALES_PROPOSAL_SUCCESS_JSP);

		} catch (DataValidationException dataValidationException) {

			logger.error("Validation failed for submited Sales Proposal Application Data: "
					+ dataValidationException.getMessage());
			if (logger.isDebugEnabled()) {
				dataValidationException.printStackTrace();
			}

			actionRequest.setAttribute("errorKey", dataValidationException.getMessage());
			SessionErrors.add(actionRequest, dataValidationException.getClass());
			actionResponse.setRenderParameter("mvcRenderCommand",
					FarmerInformationManagementSystemConstants.DEFAULT_COMMAND);

		} catch (FarmerSalesProposalInternalErrorException farmerSalesProposalInternalErrorException) {
			logger.error("Internal error occured while stroing Sales Proposal Application data : "
					+ farmerSalesProposalInternalErrorException.getMessage());
			if (logger.isDebugEnabled()) {
				farmerSalesProposalInternalErrorException.printStackTrace();
			}

			actionRequest.setAttribute("errorKey", farmerSalesProposalInternalErrorException.getMessage());
			SessionErrors.add(actionRequest, farmerSalesProposalInternalErrorException.getClass());

			/* TODO: redirect to error Page */
			actionResponse.setRenderParameter("mvcRenderCommand",
					FarmerInformationManagementSystemConstants.DEFAULT_COMMAND);
		} catch (Exception exception) {
			logger.error("Exception occured while adding the Sales Proposal Application : " + exception.getMessage());
			if (logger.isDebugEnabled()) {
				exception.printStackTrace();
			}

			actionRequest.setAttribute("errorKey", exception.getMessage());
			SessionErrors.add(actionRequest, exception.getClass());

			/* TODO: redirect to error Page */
			actionResponse.setRenderParameter("mvcRenderCommand",
					FarmerInformationManagementSystemConstants.DEFAULT_COMMAND);
		}

	}

	private Log logger = LogFactoryUtil.getLog(this.getClass());

	@Reference
	private FarmerSalesProposalLocalService farmerSalesProposalLocalService;

	@Reference
	private FarmerRegistrationLocalService farmerRegistrationLocalService;

}
