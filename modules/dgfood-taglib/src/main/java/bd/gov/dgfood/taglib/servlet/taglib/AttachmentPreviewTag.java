package bd.gov.dgfood.taglib.servlet.taglib;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.taglib.util.IncludeTag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import bd.gov.dgfood.taglib.internal.servlet.DGFoodServletContextUtil;

public class AttachmentPreviewTag extends IncludeTag {

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		this._title = title;
	}

	public String getPreviewURL() {
		return _previewURL;
	}

	public void setPreviewURL(String previewURL) {
		this._previewURL = previewURL;
	}

	public String getExtension() {
		return _extension;
	}

	public void setExtension(String extension) {
		this._extension = extension;
	}

	public String getCssClass() {
		return _cssClass;
	}

	public void setCssClass(String cssClass) {
		this._cssClass = cssClass;
	}

	@Override
	protected String getPage() {
		return _PAGE;
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);
		_contextPath = DGFoodServletContextUtil.getServletContext().getContextPath();
		setServletContext(DGFoodServletContextUtil.getServletContext());
	}

	@Override
	protected void setAttributes(HttpServletRequest httpServletRequest) {

		httpServletRequest.setAttribute("dgfood-ui:attachment-preview:cssClass", _cssClass);
		httpServletRequest.setAttribute("dgfood-ui:attachment-preview:contextPath", _contextPath);
		httpServletRequest.setAttribute("dgfood-ui:attachment-preview:title", _title);
		httpServletRequest.setAttribute("dgfood-ui:attachment-preview:previewURL", _previewURL);
		httpServletRequest.setAttribute("dgfood-ui:attachment-preview:extension", _extension);
	}

	private static final String _PAGE = "/attachment_preview/page.jsp";

	private static final Log _log = LogFactoryUtil.getLog(AttachmentUpload.class);

	private String _cssClass;
	private String _contextPath;
	private String _title;
	private String _previewURL;
	private String _extension;
}
