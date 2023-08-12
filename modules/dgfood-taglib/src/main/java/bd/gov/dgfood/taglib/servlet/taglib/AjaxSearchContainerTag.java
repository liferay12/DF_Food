package bd.gov.dgfood.taglib.servlet.taglib;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.taglib.util.IncludeTag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import bd.gov.dgfood.taglib.internal.servlet.DGFoodServletContextUtil;

public class AjaxSearchContainerTag extends IncludeTag {

	public String getCheckboxId() {
		return _checkboxId;
	}

	public void setCheckboxId(String checkboxId) {
		this._checkboxId = checkboxId;
	}

	public String getSearchContainerId() {
		return _searchContainerId;
	}

	public void setSearchContainerId(String searchContainerId) {
		this._searchContainerId = searchContainerId + "SearchContainer";
	}

	public String getFormId() {
		return _formId;
	}

	public void setFormId(String formId) {
		this._formId = formId;
	}

	public String getButtonId() {
		return _buttonId;
	}

	public void setButtonId(String buttonId) {
		this._buttonId = buttonId;
	}

	public String getContainerId() {
		return _containerId;
	}

	public void setContainerId(String _containerId) {
		this._containerId = _containerId;
	}

	public String getResourceId() {
		return _resourceId;
	}

	public void setResourceId(String _resourceId) {
		this._resourceId = _resourceId;
	}

	@Override
	protected String getPage() {
		return _PAGE;
	}

	@Override
	protected void cleanUp() {
		super.cleanUp();

		_formId = null;
		_containerId = null;
		_resourceId = null;
		_buttonId = null;
		_checkboxId = null;
		_searchContainerId = null;
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);

		setServletContext(DGFoodServletContextUtil.getServletContext());
	}

	@Override
	protected void setAttributes(HttpServletRequest httpServletRequest) {

		_log.info(" setAttributes.........");
		
		httpServletRequest.setAttribute("dgfood-ui:ajax-search-container:formId", _formId);
		httpServletRequest.setAttribute("dgfood-ui:ajax-search-container:containerId", _containerId);
		httpServletRequest.setAttribute("dgfood-ui:ajax-search-container:resourceId", _resourceId);
		httpServletRequest.setAttribute("dgfood-ui:ajax-search-container:buttonId", _buttonId);
		httpServletRequest.setAttribute("dgfood-ui:ajax-search-container:checkboxId", _checkboxId);
		httpServletRequest.setAttribute("dgfood-ui:ajax-search-container:searchContainerId", _searchContainerId);
	}

	private static final String _PAGE = "/ajax_search_container/page.jsp";

	private static final Log _log = LogFactoryUtil.getLog(AjaxSearchContainerTag.class);

	private String _formId;

	private String _containerId;
	private String _resourceId;
	private String _buttonId;

	private String _checkboxId;
	private String _searchContainerId;

}
