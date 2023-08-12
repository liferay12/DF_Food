package bd.gov.dgfood.milling.license.web.internal.search;

import com.liferay.portal.kernel.display.context.helper.BaseRequestHelper;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.RenderRequest;

public class MillingLicenseVersionRequestHelper extends BaseRequestHelper {

	public MillingLicenseVersionRequestHelper(RenderRequest renderRequest) {
		super(PortalUtil.getHttpServletRequest(renderRequest));
	}
}
