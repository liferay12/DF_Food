package bd.gov.dgfood.taglib.servlet.taglib;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.taglib.util.IncludeTag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import bd.gov.dgfood.taglib.internal.servlet.DGFoodServletContextUtil;

public class AlertTag extends IncludeTag {

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		this._type = type;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		this._status = status;
	}

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

	@Override
	protected String getPage() {
		return _PAGE;
	}

	@Override
	protected void cleanUp() {
		super.cleanUp();
		_type = null;
		_className = null;
		_classPK = 0;
		_status = 0;

	}

	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);
		setServletContext(DGFoodServletContextUtil.getServletContext());
	}

	@Override
	protected void setAttributes(HttpServletRequest httpServletRequest) {
		httpServletRequest.setAttribute("dgfood-ui:alert:className", _className);
		httpServletRequest.setAttribute("dgfood-ui:alert:classPK", _classPK);
		httpServletRequest.setAttribute("dgfood-ui:alert:status", _status);
		httpServletRequest.setAttribute("dgfood-ui:alert:type", _type);

	}

	private static final String _PAGE = "/alert/page.jsp";

	private static final Log _log = LogFactoryUtil.getLog(AttachmentUpload.class);

	private String _type;
	private int _status;
	private String _className;
	private long _classPK;

}
