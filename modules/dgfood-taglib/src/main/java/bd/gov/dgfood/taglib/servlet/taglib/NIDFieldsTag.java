package bd.gov.dgfood.taglib.servlet.taglib;

import com.liferay.taglib.util.IncludeTag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import bd.gov.dgfood.taglib.internal.servlet.DGFoodServletContextUtil;

public class NIDFieldsTag extends IncludeTag {

	boolean _isDisabled;
	NationalIdInformation _value;

	public NationalIdInformation getValue() {
		return _value;
	}

	public void setValue(NationalIdInformation _value) {
		this._value = _value;
	}
	
	public boolean getIsDisabled() {
		return _isDisabled;
	}

	public void setIsDisabled(boolean _isDisabled) {
		this._isDisabled = _isDisabled;
	}
	

	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);

		setServletContext(DGFoodServletContextUtil.getServletContext());
	}

	@Override
	protected void setAttributes(HttpServletRequest httpServletRequest) {

		boolean pageAccess = true;

		httpServletRequest.setAttribute("dgfood-ui:isDisabled", getIsDisabled());
		httpServletRequest.setAttribute("dgfood-ui:nationalIdInformation", getValue());
		httpServletRequest.setAttribute("dgfood-ui:page-access-status-verifier:showAlertMessage", pageAccess);
		httpServletRequest.setAttribute("dgfood-ui:page-access-status-verifier:isPageAccessable", pageAccess);
	}

	@Override
	protected String getPage() {
		return _PAGE;
	}

	/***
	 * create the folders <portal
	 * home>/tomcat-9.0.17/webapps/ROOT/html/dgfood/ui/nid-fields and page the
	 * page.jsp in nid-fields folder
	 ***/
	private static final String _PAGE = "/nid_fields/page.jsp";

}