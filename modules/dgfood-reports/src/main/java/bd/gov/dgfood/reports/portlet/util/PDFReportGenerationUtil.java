package bd.gov.dgfood.reports.portlet.util;

import com.liferay.dynamic.data.lists.service.DDLRecordLocalServiceUtil;
import com.liferay.dynamic.data.lists.service.DDLRecordSetLocalServiceUtil;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalServiceUtil;
import com.liferay.dynamic.data.mapping.service.DDMStructureVersionLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.Conjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public class PDFReportGenerationUtil {

	private static Log _log = LogFactoryUtil.getLog(PDFReportGenerationUtil.class);

	public static List<Long> getTemplateList(long groupId, String structureName, String recordSetName) {
		List<Long> recordIdList = null;
		long structureId = 0;
		try {
			DynamicQuery ddmStructureVersionQuery = DDMStructureVersionLocalServiceUtil.dynamicQuery();
			ddmStructureVersionQuery.add(RestrictionsFactoryUtil.like("name", '%' + structureName + '%'));
			Conjunction versionConjunction = RestrictionsFactoryUtil.conjunction();
			versionConjunction.add(RestrictionsFactoryUtil.eq("groupId", groupId));
			ddmStructureVersionQuery.add(versionConjunction);
			ddmStructureVersionQuery.setProjection(PropertyFactoryUtil.forName("structureId"));
			List<Long> ddmVersionIdstructureId = DDMStructureVersionLocalServiceUtil
					.dynamicQuery(ddmStructureVersionQuery);

			if (ListUtil.isNotEmpty(ddmVersionIdstructureId)) {
				for (long ddmStructureId : ddmVersionIdstructureId) {
					String ddmStructureName = DDMStructureLocalServiceUtil.fetchDDMStructure(ddmStructureId)
							.getName(LocaleUtil.getSiteDefault());
					if (structureName.equalsIgnoreCase(ddmStructureName)) {
						structureId = ddmStructureId;
						break;
					}
				}

			}
			DynamicQuery ddlRecordSetQuery = DDLRecordSetLocalServiceUtil.dynamicQuery();
			Conjunction recordSetconjunction = RestrictionsFactoryUtil.conjunction();
			recordSetconjunction.add(RestrictionsFactoryUtil.eq("DDMStructureId", structureId));
			recordSetconjunction.add(RestrictionsFactoryUtil.like("name", '%' + recordSetName + '%'));
			ddlRecordSetQuery.add(recordSetconjunction);
			ddlRecordSetQuery.setProjection(PropertyFactoryUtil.forName("recordSetId"));

			_log.info("recordSetName : "+recordSetName);
			
			_log.info("ddlRecordSetQuery : "+ddlRecordSetQuery);
			/*
			 * Using DDLRecordSetId from above query , this query will fetch all the record
			 * by DDLRecordSetId and projecting recordId
			 * 
			 */

			DynamicQuery ddlRecordQuery = DDLRecordLocalServiceUtil.dynamicQuery();
			ddlRecordQuery.add(PropertyFactoryUtil.forName("recordSetId").eq(ddlRecordSetQuery));
			ddlRecordQuery.setProjection(PropertyFactoryUtil.forName("recordId"));
			recordIdList = DDLRecordLocalServiceUtil.dynamicQuery(ddlRecordQuery);
		} catch (Exception e) {
			_log.error("Error in retrieving template : " + e.getMessage());
		}
		return recordIdList;
	}
	
	
	public static String generateReport(ThemeDisplay themeDisplay, String structureName, String recordSetName,
			String templateKey, Map<String, String> reportParam, Locale locale) {
		try {
			List<Long> recordIdList = getTemplateList(themeDisplay.getScopeGroupId(), structureName, recordSetName);
			String templateContentBody = getTemplateContent(recordIdList, "Content", "TemplateKey", templateKey, locale);
			//_log.info("Content Body  : " + templateContentBody);
			if (Validator.isNotNull(templateContentBody)) {
				try {
					templateContentBody = HtmlUtil.unescape(templateContentBody);
					for (Map.Entry<String, String> e : reportParam.entrySet()) {
						templateContentBody = templateContentBody.replace("$[" + e.getKey() + "]", e.getValue());
					}
					//_log.info("----------------------------------------");
					//_log.info("Actual Content : "+templateContentBody);
					
				} catch (Exception e) {
					_log.error("Error in writing report : " + e);
				}
			} else {
				_log.error("Unable to find template:" + templateKey);
			}
			_log.info("process ended");
			return templateContentBody;
		} catch (Exception e) {
			_log.info("---------------error : " + e);
		}
		return null;
	}
	
	public static String getTemplateContent(List<Long> recordIdList, String templateAttributeName,
			String templateKeyName, String templateKeyValue, Locale locale) {
		String templateValue = StringPool.BLANK;
		try {
			if (ListUtil.isNotEmpty(recordIdList)) {
				for (long recordId : recordIdList) {
					String template = DDLRecordLocalServiceUtil.getRecord(recordId)
							.getDDMFormFieldValues(templateKeyName).get(0).getValue().getValues()
							.get(locale);

					if (templateKeyValue.equalsIgnoreCase(template)) {
						templateValue = DDLRecordLocalServiceUtil.getRecord(recordId)
								.getDDMFormFieldValues(templateAttributeName).get(0).getValue().getValues()
								.get(locale);
						break;
					}
				}
			}else {
				_log.error("No Template content");
			}

		} catch (Exception e) {
			_log.error("Error in retriving template content: " + templateAttributeName);

		}
		return templateValue;
	}
	
	
	public static String generatePDF(ThemeDisplay themeDisplay, String templateKey, Map<String, String> reportParam) {
		try {
			_log.info("Inside generatePDF...");
		return generateReport(themeDisplay, "Reports", "Reports Template", templateKey, reportParam, themeDisplay.getLocale()); 
		
		} catch (Exception e) {
			_log.error("Exception in ContractCreationMVCResourceCommand while generating PDF", e);
		}
		return null;
	}

}
