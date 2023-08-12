package bd.gov.dgfood.common.util;

import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

/**
 * The purpose of this class is to mention URL related activties
 *
 * Accessibility : Throughout application
 *
 *
 * @author Ashish Singh
 * 
 */
public class URLUtil {

	/**
	 * The purpose of this class is to generate portlet URL
	 * 
	 */
	public static String getGeneratedURL(ServiceContext serviceContext, Map<String, Object> urlMap) {

		PortletURL requestedURL = PortletURLFactoryUtil.create(serviceContext.getRequest(),
				serviceContext.getPortletId(), serviceContext.getPlid(), PortletRequest.RENDER_PHASE);

		if (Validator.isNotNull(urlMap) && !urlMap.isEmpty()) {
			for (Map.Entry<String, Object> entry : urlMap.entrySet()) {
				requestedURL.getRenderParameters().setValue(entry.getKey(), String.valueOf(entry.getValue()));
			}
		}
		return requestedURL.toString();
	}

}
