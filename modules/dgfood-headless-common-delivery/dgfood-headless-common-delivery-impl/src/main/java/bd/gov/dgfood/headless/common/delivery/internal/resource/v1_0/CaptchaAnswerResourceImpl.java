package bd.gov.dgfood.headless.common.delivery.internal.resource.v1_0;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import bd.gov.dgfood.headless.common.delivery.dto.v1_0.CaptchaAnswer;
import bd.gov.dgfood.headless.common.delivery.resource.v1_0.CaptchaAnswerResource;

/**
 * @author krishna
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0/captcha-answer.properties", scope = ServiceScope.PROTOTYPE, service = CaptchaAnswerResource.class)
public class CaptchaAnswerResourceImpl extends BaseCaptchaAnswerResourceImpl {

	@Override
	public CaptchaAnswer getCaptchaAnswer() throws Exception {
		
		HttpSession httpSession = _getHttpSession(contextHttpServletRequest);
		
		String httpSessionKey = _getHttpSessionKey(WebKeys.CAPTCHA_TEXT, contextHttpServletRequest);

		log.info("key " + WebKeys.CAPTCHA_TEXT);

		log.info("httpSessionKey " + httpSessionKey);

		String captchaText = (String) httpSession.getAttribute(httpSessionKey);

		log.info("captchaText " + captchaText);

		return _toCaptchaAnswer(captchaText);
	}

	private HttpSession _getHttpSession(HttpServletRequest httpServletRequest) {
		HttpServletRequest originalHttpServletRequest = portal.getOriginalServletRequest(httpServletRequest);

		return originalHttpServletRequest.getSession();
	}

	private String _getHttpSessionKey(String key, HttpServletRequest httpServletRequest) {

		String portletId = portal.getPortletId(httpServletRequest);

		if (Validator.isNotNull(portletId)) {
			return portal.getPortletNamespace(portletId) + key;
		}

		return key;
	}

	private CaptchaAnswer _toCaptchaAnswer(String captchaText) throws Exception {

		return new CaptchaAnswer() {
			{
				answer = captchaText;
			}
		};
	}

	Log log = LogFactoryUtil.getLog(CaptchaAnswerResourceImpl.class.getName());

	@Reference
	protected Portal portal;
}