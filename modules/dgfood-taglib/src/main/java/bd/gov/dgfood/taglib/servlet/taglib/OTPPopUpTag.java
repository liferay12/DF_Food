package bd.gov.dgfood.taglib.servlet.taglib;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.taglib.util.IncludeTag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import bd.gov.dgfood.taglib.internal.servlet.DGFoodServletContextUtil;

public class OTPPopUpTag extends IncludeTag{
	
	public String getOtpEntered() {
		return _otpEntered;
	}

	public void setOtpEntered(String _otpEntered) {
		this._otpEntered = _otpEntered;
	}


	@Override
	protected String getPage() {
		return _PAGE;
	}

	@Override
	protected void cleanUp() {
		// TODO Auto-generated method stub
		super.cleanUp();
	}
	
	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);
		setServletContext(DGFoodServletContextUtil.getServletContext());
	}

	@Override
	protected void setAttributes(HttpServletRequest httpServletRequest) {
		httpServletRequest.setAttribute("dgfood-ui:otp:otp-entered", _otpEntered);
	}
	
	private static final String _PAGE = "/otp/page.jsp";

	private static final Log _log = LogFactoryUtil.getLog(OTPPopUpTag.class);

	private String _otpEntered;
}
