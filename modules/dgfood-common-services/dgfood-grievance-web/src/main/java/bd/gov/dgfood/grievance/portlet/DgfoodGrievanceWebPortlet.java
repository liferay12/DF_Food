package bd.gov.dgfood.grievance.portlet;

import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetVocabularyLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.common.services.model.Grievance;
import bd.gov.dgfood.common.util.constants.CategoryConstants;
import bd.gov.dgfood.grievance.constants.DgfoodGrievanceWebPortletKeys;

/**
 * @author liferay
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=DgfoodGrievanceWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/list.jsp",
		"javax.portlet.name=" + DgfoodGrievanceWebPortletKeys.DGFOODGRIEVANCEWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.version=3.0"
	},
	service = Portlet.class
)
public class DgfoodGrievanceWebPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
	
		ServiceContext serviceContext = null;
		try {
			serviceContext = ServiceContextFactory.getInstance(Grievance.class.getName(), renderRequest);
		} catch (PortalException e) {
			_log.error(e);
		}
		
		AssetVocabulary assetVocabularyMaritalStatus =  assetVocabularyLocalService.fetchGroupVocabulary(serviceContext.getScopeGroupId(), CategoryConstants.GRIEVANCE_TYPE);
		if(Validator.isNotNull(assetVocabularyMaritalStatus)){
			renderRequest.setAttribute(CategoryConstants.GRIEVANCE_TYPE, assetVocabularyMaritalStatus.getCategories());
		}
		
		AssetVocabulary assetVocabularyGrievanceUsers =  assetVocabularyLocalService.fetchGroupVocabulary(serviceContext.getScopeGroupId(), CategoryConstants.GRIEVANCE_USERS);
		if(Validator.isNotNull(assetVocabularyGrievanceUsers)){
			renderRequest.setAttribute(CategoryConstants.GRIEVANCE_USERS, assetVocabularyGrievanceUsers.getCategories());
		}
		
		super.render(renderRequest, renderResponse);
	}
	
	@Reference
	private AssetVocabularyLocalService assetVocabularyLocalService;
	
	private static final Log _log = LogFactoryUtil.getLog(DgfoodGrievanceWebPortlet.class);
	
}