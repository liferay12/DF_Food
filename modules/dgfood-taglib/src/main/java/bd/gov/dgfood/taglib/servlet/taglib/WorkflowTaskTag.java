package bd.gov.dgfood.taglib.servlet.taglib;

import com.liferay.taglib.util.IncludeTag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import bd.gov.dgfood.taglib.internal.servlet.DGFoodServletContextUtil;

public class WorkflowTaskTag extends IncludeTag {

	public String getClassName() {
		return _className;
	}

	public void setClassName(String className) {
		this._className = className;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		this._classPK = classPK;
	}

	public String getRedirect() {
		return _redirect;
	}

	public void setRedirect(String redirect) {
		this._redirect = redirect;
	}

	@Override
	protected String getPage() {
		return _PAGE;
	}

	@Override
	protected void cleanUp() {
		super.cleanUp();

		_className = null;
		_classPK = 0;
		_redirect = null;

	}

	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);

		setServletContext(DGFoodServletContextUtil.getServletContext());
	}

	@Override
	protected void setAttributes(HttpServletRequest httpServletRequest) {

		httpServletRequest.setAttribute("dgfood-ui:workflow-task:className", _className);
		httpServletRequest.setAttribute("dgfood-ui:workflow-task:classPK", _classPK);
		httpServletRequest.setAttribute("dgfood-ui:workflow-task:redirect", _redirect);

	}

	private static final String _PAGE = "/workflow_task/page.jsp";

	private String _className;
	private long _classPK;
	private String _redirect;

}
