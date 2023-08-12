package bd.gov.dgfood.grievance.render.command;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetVocabularyLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.common.services.model.Grievance;
import bd.gov.dgfood.common.util.CategoryUtil;
import bd.gov.dgfood.common.util.constants.CategoryConstants;
import bd.gov.dgfood.grievance.constants.DgfoodGrievanceWebPortletKeys;

@Component(immediate = true, property = {
				"javax.portlet.name=" + DgfoodGrievanceWebPortletKeys.DGFOODGRIEVANCEWEB,
				"mvc.command.name=/grievance/add" }, service = MVCRenderCommand.class)

//This class is used to render data on add grievances form
public class DGFoodGrievanceMVCRenderCommand implements MVCRenderCommand{
	
	
	//This method is used to render required fields in the Add grievances form 
	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {
		
		ServiceContext serviceContext = null;
		try {
			serviceContext = ServiceContextFactory.getInstance(Grievance.class.getName(), renderRequest);
		} catch (PortalException e) {
			_log.error(e);
		}
		
		try {
			List<AssetCategory> assetVocabularyGrievanceType = CategoryUtil.fetchCategoriesbyVocabularyNameAndParentId(serviceContext.getThemeDisplay(), CategoryConstants.GRIEVANCE_TYPE,0);
		
		if(Validator.isNotNull(assetVocabularyGrievanceType)){
			renderRequest.setAttribute(CategoryConstants.GRIEVANCE_TYPE, assetVocabularyGrievanceType);
		}
		
		List<AssetCategory> assetVocabularyGrievanceUsers =  CategoryUtil.fetchCategoriesbyVocabularyNameAndParentId(serviceContext.getThemeDisplay(), CategoryConstants.GRIEVANCE_USERS,0);
		if(Validator.isNotNull(assetVocabularyGrievanceUsers)){
			renderRequest.setAttribute(CategoryConstants.GRIEVANCE_USERS, assetVocabularyGrievanceUsers);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/add.jsp";
	}
	
	@Reference
	private AssetVocabularyLocalService assetVocabularyLocalService;
	
	private static final Log _log = LogFactoryUtil.getLog(DGFoodGrievanceMVCRenderCommand.class);

}
