package bd.gov.dgfood.grievance.friendly.url;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.grievance.constants.DgfoodGrievanceWebPortletKeys;

/**
 * This is friendly URL mapper class for grievance.
 * It get's executed when the URL pattern matches with routes.xml
 *  
 */
@Component(
	     property = {
	         "com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/routes.xml",
	         "javax.portlet.name=" + DgfoodGrievanceWebPortletKeys.DGFOODGRIEVANCEWEB
	     },
	     service = FriendlyURLMapper.class
	 )
public class GrievanceFriendlyURLMapper extends DefaultFriendlyURLMapper {
	
	@Override
    public String getMapping() {
        return _MAPPING;
    }

	
	/**HOW TO TEST
	 * test url with http://localhost:8080/web/dgfood/<page name>/-/<friendlyURLMapper>/register
	 * for e.g-http://localhost:8080/web/dgfood/grievance-page/-/grievance/register
	 * 
	 * 
	 * **/
    private static final String _MAPPING = "grievance";

}