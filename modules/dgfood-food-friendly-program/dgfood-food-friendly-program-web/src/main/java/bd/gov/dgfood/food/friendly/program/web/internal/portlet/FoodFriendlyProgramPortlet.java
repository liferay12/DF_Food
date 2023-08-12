package bd.gov.dgfood.food.friendly.program.web.internal.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.food.friendly.program.constants.FoodFriendlyProgramPortletKeys;

/**
 * This Portlet allows guest beneficiaries to perform their activities such as
 * application status view, profile view, distrubution details
 * 
 * @author krishna
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", 
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=FFPBeneficiaryPortlet", 
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/ffpb_profile/ffpb_dashboard.jsp",
		"javax.portlet.name=" + FoodFriendlyProgramPortletKeys.FOOD_FRIENDLY_PROGRAM,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user,guest" }, service = Portlet.class)
public class FoodFriendlyProgramPortlet extends MVCPortlet {

}
