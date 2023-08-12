package bd.gov.dgfood.food.friendly.program.web.internal.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.food.friendly.program.constants.FoodFriendlyProgramPortletKeys;


/**
 * This portlet is accessiable only for admins to add/update beneficiary, review
 * , link a dealer
 * 
 * @author krishna
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.css-class-wrapper=dgfood-food-friendly-program-web",
		"com.liferay.portlet.header-portlet-css=/css/main.css", 
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=FFPBAdminPortlet",
		"javax.portlet.init-param.template-path=/META-INF/resources/", 
		"javax.portlet.init-param.view-template=true",
		"javax.portlet.name=" + FoodFriendlyProgramPortletKeys.FOOD_FRIENDLY_PROGRAM_ADMIN,
		"javax.portlet.resource-bundle=content.Language", 
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.init-param.view-template=/ffpb/view", 
		"javax.portlet.expiration-cache=0",
		"com.liferay.portlet.render-weight=50", }, service = Portlet.class)
public class FoodFriendlyProgramAdminPortlet extends MVCPortlet {
	
}
