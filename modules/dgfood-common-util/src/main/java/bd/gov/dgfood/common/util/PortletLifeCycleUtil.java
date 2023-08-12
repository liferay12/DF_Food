package bd.gov.dgfood.common.util;

import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.Arrays;
import java.util.List;

public class PortletLifeCycleUtil {

	private static List<String> parms = Arrays.asList("p_p_mode", "p_p_state", "p_p_id", "p_p_lifecycle");

	public static String _getSearchData(String searchActionURL) {

		StringBuilder stringBuilder = new StringBuilder();

		//String[] parameters = StringUtil.split(HttpUtil.getQueryString(searchActionURL), CharPool.AMPERSAND);
		String[] parameters = null;
		for (String parameter : parameters) {
			if (parameter.length() == 0) {
				continue;
			}

			String[] parameterParts = StringUtil.split(parameter, CharPool.EQUAL);

			if (ArrayUtil.isEmpty(parameterParts)) {
				continue;
			}

			String parameterName = parameterParts[0];

			if (parms.contains(parameterName)) {
				String parameterValue = StringPool.BLANK;

				if (parameterParts.length > 1) {
					parameterValue = parameterParts[1];
				}

				//parameterValue = HttpUtil.decodeURL(parameterValue);

				stringBuilder.append("<input");
				stringBuilder.append(StringPool.SPACE);
				stringBuilder.append("name=\"");
				stringBuilder.append(parameterName + "\"");
				stringBuilder.append(StringPool.SPACE);
				stringBuilder.append("type=\"hidden\"");
				stringBuilder.append(StringPool.SPACE);
				stringBuilder.append("value=\"");
				stringBuilder.append(parameterValue + "\"");
				stringBuilder.append(">");
			}
		}

		_log.debug("StringBuilder - " + stringBuilder.toString());

		return stringBuilder.toString();
	}

	private static Log _log = LogFactoryUtil.getLog(PortletLifeCycleUtil.class);

}
