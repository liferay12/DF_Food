package bd.gov.dgfood.taglib.servlet.taglib;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import bd.gov.dgfood.common.util.language.CustomLanguageUtil;

/**
 * The purpose of this class that acts as a tag handler and perform action at
 * the start or at the end of the tag.also extend SimpleTagSupport class.
 *
 * @author Ashish Singh 
 */
public class LabelTranslatorTag extends SimpleTagSupport {

	private static final Log LOG = LogFactoryUtil.getLog(LabelTranslatorTag.class);

	private String messageKey;
	private String messageParameter;
	private String languageId;

	public LabelTranslatorTag() {
	}

	public void setKey(String messageKey) {
		this.messageKey = messageKey;
	}

	public void setParameters(String messageParameter) {
		this.messageParameter = messageParameter;
	}

	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}

	@Override
	public void doTag() throws JspException, IOException {
		try {
			
			ThemeDisplay themeDisplay = (ThemeDisplay) getJspContext().getAttribute("themeDisplay");
			
			if (Validator.isNull(languageId)) {
				this.languageId = themeDisplay.getLanguageId();
			}
			String labelValue = CustomLanguageUtil.get(themeDisplay.getCompanyId(), languageId, messageKey, messageParameter);
			getJspContext().getOut().write(labelValue);
		} catch (Exception e) {
			LOG.error("Exception in " + languageId + " key " + messageKey + " error " + e);
			// stop page from loading further by throwing SkipPageException
			throw new SkipPageException("Exception in " + languageId + " key " + messageKey);
		}
	}
}