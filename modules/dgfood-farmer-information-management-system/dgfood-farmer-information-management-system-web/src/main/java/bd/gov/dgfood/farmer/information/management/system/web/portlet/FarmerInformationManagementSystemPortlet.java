package bd.gov.dgfood.farmer.information.management.system.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.farmer.information.management.system.web.constants.FarmerInformationManagementSystemConstants;
import bd.gov.dgfood.farmer.information.management.system.web.constants.FarmerInformationManagementSystemPortletKeys;

/**
 * @author AshishV
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.dgfood.fims",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=FarmerInformationManagementSystem", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=" + FarmerInformationManagementSystemConstants.FIMS_DEFAULT_JSP,
		"javax.portlet.name=" + FarmerInformationManagementSystemPortletKeys.FARMERINFORMATIONMANAGEMENTSYSTEM,
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.version=3.0" }, service = Portlet.class)
public class FarmerInformationManagementSystemPortlet extends MVCPortlet {

}
