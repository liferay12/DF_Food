package bd.gov.dgfood.taglib.servlet.taglib;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.taglib.util.IncludeTag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import bd.gov.dgfood.taglib.internal.servlet.DGFoodServletContextUtil;

public class BankAccountInformation extends IncludeTag {

	boolean isDisabled;

	public boolean isDisabled() {
		return isDisabled;
	}

	public void setIsDisabled(boolean isDisabled) {
		this.isDisabled = isDisabled;
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);

		setServletContext(DGFoodServletContextUtil.getServletContext());
	}

	@Override
	protected void setAttributes(HttpServletRequest httpServletRequest) {

		try {

			log.debug("Is Disbaled: " + isDisabled);

			boolean pageAccess = true;
			httpServletRequest.setAttribute("dgfood-ui:page-access-status-verifier:showAlertMessage", pageAccess);
			httpServletRequest.setAttribute("dgfood-ui:page-access-status-verifier:isPageAccessable", pageAccess);
			httpServletRequest.setAttribute("dgfood-ui:isDisabled", isDisabled());

		} catch (Exception e) {
			log.error("Exception occured in Bank Account Information Tag-lib setter method");
			if (log.isDebugEnabled()) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected String getPage() {
		return _PAGE;
	}

	/***
	 * create the folders <portal
	 * home>/tomcat-9.0.17/webapps/ROOT/html/dgfood/ui/basic-fields and page the
	 * page.jsp in basic-fields folder
	 ***/
	private static final String _PAGE = "/bank_account_information/page.jsp";

	private Log log = LogFactoryUtil.getLog(this.getClass());

}
