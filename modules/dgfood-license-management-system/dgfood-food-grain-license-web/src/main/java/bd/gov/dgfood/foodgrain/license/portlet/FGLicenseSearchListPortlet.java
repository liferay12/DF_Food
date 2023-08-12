package bd.gov.dgfood.foodgrain.license.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.foodgrain.license.constants.FoodGrainLicenseConstants;
import bd.gov.dgfood.foodgrain.license.constants.FoodGrainLicensePortletKeys;

/**
 * @author Ashish V
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.dgf.license.foodgrain",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Foodgrain License Search & Filter", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=" + FoodGrainLicenseConstants.FOODGRAIN_LICENSE_SEARCH_JSP,
		"javax.portlet.name=" + FoodGrainLicensePortletKeys.FOODGRAIN_LICENSE_SEARCH_LIST, "javax.portlet.version=3.0",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class FGLicenseSearchListPortlet extends MVCPortlet {

}
