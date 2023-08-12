package bd.gov.dgfood.foodgrain.license.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.foodgrain.license.constants.FoodGrainLicensePortletKeys;

/**
 * @author Abhijit Ande
 * 
 * This Portlet Class is used to deploy and land on view.jsp page.
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=LMSHomeScreen",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/jsp/view.jsp",
		"javax.portlet.name=" + FoodGrainLicensePortletKeys.HOMESCREENFGLICENSE,
		"javax.portlet.version=3.0",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class HomeScreenFGLicensePortlet extends MVCPortlet {

}
