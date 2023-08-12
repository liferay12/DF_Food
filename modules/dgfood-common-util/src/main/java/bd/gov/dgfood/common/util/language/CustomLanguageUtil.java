package bd.gov.dgfood.common.util.language;

import static java.lang.Integer.parseInt;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.language.override.model.PLOEntry;
import com.liferay.portal.language.override.service.PLOEntryLocalServiceUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * This Util is used to resolve labels / values from DB
 * 
 * @author Ashish Singh
 */
@Component
public class CustomLanguageUtil {
	private static final Log LOG = LogFactoryUtil.getLog(CustomLanguageUtil.class);

	public static final String CUSTOM_LABEL_CACHE_LANGUAGE_KEY = "language";

	private static final CustomLanguageUtil INSTANCE = new CustomLanguageUtil();

	/**
	 * Retrieve label values contained in custom Db table
	 *
	 * @param companyId - company Id of current site
	 * @param languageId - languageId of current Locale
	 * @return map of key-value pairs
	 *
	 */
	public static Map<String, String> getLabelList(long companyId, String languageId) {

        Map<String, String> labelsMap = new HashMap<>();

		try {
			
			List<PLOEntry> languageOverrideEntries = PLOEntryLocalServiceUtil.getPLOEntries(companyId, languageId);

			for (PLOEntry labelTranslator : languageOverrideEntries) {
				labelsMap.put(labelTranslator.getKey(), labelTranslator.getValue());
			}
			
		} catch (Exception e) {
			LOG.warn(e);
		}

        if (LOG.isTraceEnabled()) {
            LOG.trace("Labels: " + labelsMap.toString());
        }

        return labelsMap;
    }

	/**
	 * Retrieve label value contained in custom table
	 *
	 * @param request - request Object
	 * @param messageKey - given message key
	 * @return The resulting string
	 *
	 */

	public static String get(HttpServletRequest request, String messageKey) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		return get(themeDisplay.getCompanyId(), themeDisplay.getLanguageId(), messageKey, "");
	}

	/**
	 * Retrieve label value contained in custom table
	 *
	 * @param request - request Object
	 * @param messageKey - given message key
	 * @param messageParameter - Comma separated String with the parameters
	 * @return The resulting string
	 *
	 */
	public static String get(HttpServletRequest request, String messageKey, String messageParameter) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		return get(themeDisplay.getCompanyId(), themeDisplay.getLanguageId(), messageKey, messageParameter);
	}


	/**
	 * Retrieve label value contained in custom table
	 *
	 * @param companyId - company Id of current site
	 * @param languageId - languageId of current Locale
	 * @param messageKey - given message key
	 * @param messageParameter - Comma separated String with the parameters
	 * @return The resulting string
	 *
	 */
	public static String get(long companyId, String languageId, String messageKey, String messageParameter) {

		PortalCache<Serializable, Serializable> languageCache = LanguageCacheProvider
				.getPortalCache();
		String cacheKey = CUSTOM_LABEL_CACHE_LANGUAGE_KEY + StringPool.UNDERLINE + languageId;
		Map<String, String> labelsMap = (Map<String, String>) languageCache.get(cacheKey);
		if (Validator.isNull(labelsMap) || labelsMap.isEmpty()) {
			labelsMap = getLabelList(companyId, languageId);
			languageCache.put(cacheKey, (Serializable) labelsMap);
		}
		// add the labels to the request, so that the label tag can access them

		String labelValue = messageKey;
		if (labelsMap.containsKey(messageKey)) {
			labelValue = replaceParameters(labelsMap.get(messageKey), messageParameter);
		} else {
			Locale currentLocale = LocaleUtil.fromLanguageId(languageId);
			labelValue = LanguageUtil.get(currentLocale, messageKey);
		}
		return labelValue;
	}





    /**
     * This method will take a label and replace all instances of a number between curly brackets with the
     * parameters given in the parameters string.<br>
     * If there are no parameters, the original label will be returned.
     * <p>
     * For example:<br>
     * <pre>User {0} cleaned {1} at the {2}.</pre>
     * combined with the parameters<br>
     * <pre>A, B, C</pre>
     * will result in<br>
     * <pre>User A cleaned B at the C.</pre>
     *
     * @param label - Given label
     * @param parameters - Comma separated String with the parameters
     * @return The resulting string
     */
    public static String replaceParameters(String label, String parameters) {
        if (LOG.isTraceEnabled()) {
            LOG.trace("label: "+label);
            LOG.trace("parameters: " + parameters);
        }
        if (parameters != null) {
            String[] parametersArray = (parameters).split(",");
           
            Pattern patt = Pattern.compile("\\{([0-9])\\}");
            Matcher m = patt.matcher(label);
            StringBuffer sb = new StringBuffer(label.length());
            while (m.find()) {
                String text = m.group(1);
                int parameterIndex = parseInt(text);
                m.appendReplacement(sb, Matcher.quoteReplacement(parametersArray[parameterIndex].trim()));
            }
            m.appendTail(sb);

            return sb.toString();
        }

        return label;
    }

	public static Object getInstance() {
		return INSTANCE;
	}
	
}
