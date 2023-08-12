package bd.gov.dgfood.taglib.servlet.taglib;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.taglib.util.IncludeTag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import bd.gov.dgfood.taglib.internal.servlet.DGFoodServletContextUtil;

public class AttachmentUpload extends IncludeTag {

	public String getLabel() {
		return _label;
	}

	public void setLabel(String label) {
		this._label = label;
	}

	public boolean isRequired() {
		return _required;
	}

	public void setRequired(boolean required) {
		this._required = required;
	}

	public boolean isMultiple() {
		return _multiple;
	}

	public void setMultiple(boolean multiple) {
		this._multiple = multiple;
	}

	public long getMaxSize() {
		return _maxSize;
	}

	public void setMaxSize(long maxSize) {
		this._maxSize = maxSize;
	}

	public String getAccept() {
		return _accept;
	}

	public void setAccept(String accept) {
		this._accept = accept;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		this._name = name;
	}

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		this._id = id;
	}

	public String getPreviewContainerId() {
		return _previewContainerId;
	}

	public void setPreviewContainerId(String previewContainerId) {
		this._previewContainerId = previewContainerId;
	}

	public boolean getUpload() {
		return _upload;
	}

	public void setUpload(boolean upload) {
		this._upload = upload;
	}

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

	public String getClasses() {
		return _classes;
	}

	public void setClasses(String classes) {
		this._classes = classes;
	}

	@Override
	protected String getPage() {
		return _PAGE;
	}

	@Override
	protected void cleanUp() {
		super.cleanUp();

		_label = null;
		_required = false;
		_multiple = false;
		_maxSize = 0;
		_accept = null;
		_previewContainerId = null;
		_upload = true;
		_title = StringPool.BLANK;
		_previewURL = null;

	}

	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);
		_contextPath = DGFoodServletContextUtil.getServletContext().getContextPath();
		setServletContext(DGFoodServletContextUtil.getServletContext());
	}

	@Override
	protected void setAttributes(HttpServletRequest httpServletRequest) {

		_log.info(" setAttributes.........");

		httpServletRequest.setAttribute("dgfood-ui:attachment-upload:label", _label);
		httpServletRequest.setAttribute("dgfood-ui:attachment-upload:required", _required);
		httpServletRequest.setAttribute("dgfood-ui:attachment-upload:multiple", _multiple);
		httpServletRequest.setAttribute("dgfood-ui:attachment-upload:maxSize", _maxSize);
		httpServletRequest.setAttribute("dgfood-ui:attachment-upload:accept", _accept);

		httpServletRequest.setAttribute("dgfood-ui:attachment-upload:name", _name);
		httpServletRequest.setAttribute("dgfood-ui:attachment-upload:id", _id);
		httpServletRequest.setAttribute("dgfood-ui:attachment-upload:previewContainerId", _previewContainerId);
		httpServletRequest.setAttribute("dgfood-ui:attachment-upload:upload", _upload);
		httpServletRequest.setAttribute("dgfood-ui:attachment-upload:contextPath", _contextPath);
		httpServletRequest.setAttribute("dgfood-ui:attachment-upload:title", _title);
		httpServletRequest.setAttribute("dgfood-ui:attachment-upload:previewURL", _previewURL);
		httpServletRequest.setAttribute("dgfood-ui:attachment-upload:extension", _extension);
		httpServletRequest.setAttribute("dgfood-ui:attachment-upload:classes", _classes);

	}

	private static final String _PAGE = "/attachment_upload/page.jsp";

	private static final Log _log = LogFactoryUtil.getLog(AttachmentUpload.class);

	private String _name;
	private String _id;
	private String _label;
	private boolean _required;
	private boolean _multiple;
	private long _maxSize;
	private String _accept;
	private String _previewContainerId;
	private boolean _upload;
	private String _contextPath;

	private String _title;
	private String _previewURL;
	private String _extension;
	private String _classes;

}
