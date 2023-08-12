package bd.gov.dgfood.common.util;

import com.liferay.dynamic.data.lists.service.DDLRecordLocalServiceUtil;
import com.liferay.dynamic.data.lists.service.DDLRecordSetLocalServiceUtil;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalServiceUtil;
import com.liferay.dynamic.data.mapping.service.DDMStructureVersionLocalServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.Conjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.mail.internet.InternetAddress;

import bd.gov.dgfood.common.util.constants.NotificationTemplateConstants;

/**
 * The purpose of this class is to mention notification template activities
 *
 * Accessibility : Throughout application
 *
 * @author Ashish Singh
 * 
 */

public class NotificationUtil {

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

			_log.info("recordSetName : " + recordSetName);
			_log.info("ddlRecordSetQuery : " + ddlRecordSetQuery);

			DynamicQuery ddlRecordQuery = DDLRecordLocalServiceUtil.dynamicQuery();
			ddlRecordQuery.add(PropertyFactoryUtil.forName("recordSetId").eq(ddlRecordSetQuery));
			ddlRecordQuery.setProjection(PropertyFactoryUtil.forName("recordId"));
			recordIdList = DDLRecordLocalServiceUtil.dynamicQuery(ddlRecordQuery);
		} catch (Exception e) {
			_log.error("Error in retrieving template : " + e.getMessage());
		}
		return recordIdList;
	}

	public static String getTemplateContent(List<Long> recordIdList, String templateAttributeName,
			String templateKeyName, String templateKeyValue, Locale locale) {
		String templateValue = StringPool.BLANK;
		try {
			if (ListUtil.isNotEmpty(recordIdList)) {
				for (long recordId : recordIdList) {
					String template = DDLRecordLocalServiceUtil.getRecord(recordId)
							.getDDMFormFieldValues(templateKeyName).get(0).getValue().getValues().get(locale);

					if (templateKeyValue.equalsIgnoreCase(template)) {
						templateValue = DDLRecordLocalServiceUtil.getRecord(recordId)
								.getDDMFormFieldValues(templateAttributeName).get(0).getValue().getValues().get(locale);
						break;
					}
				}
			} else {
				_log.error("No Template content");
			}

		} catch (Exception e) {
			_log.error("Error in retriving template content: " + templateAttributeName);

		}
		return templateValue;
	}

	public static void sendSMS(ThemeDisplay themeDisplay, String mobileNumber, String notificationTemplateKey,
			Map<String, String> smsMap) {
		try {
			List<Long> recordIdList = getTemplateList(themeDisplay.getScopeGroupId(),
					NotificationTemplateConstants.SMS_STRUCTURE, NotificationTemplateConstants.SMS_RECORDSET);
			String templateContentBody = getTemplateContent(recordIdList, "smsContent",
					NotificationTemplateConstants.SMS_KEY, notificationTemplateKey, themeDisplay.getLocale());
			_log.info("Sending sms notification to:" + mobileNumber);
			_log.info("sms body : " + templateContentBody);
			if (Validator.isNotNull(templateContentBody)) {
				try {
					templateContentBody = HtmlUtil.unescape(templateContentBody);
					for (Map.Entry<String, String> e : smsMap.entrySet()) {
						templateContentBody = templateContentBody.replace("$[" + e.getKey() + "]", e.getValue());
					}
					_log.info("SMS Content : " + templateContentBody);

				} catch (Exception e) {
					_log.error("Error in sending sms : " + e);
				}
			} else {
				_log.error("Unable to find sms template:" + notificationTemplateKey);
			}
			_log.info("sms sending process ended");
		} catch (Exception e) {
			_log.info("---------------sms error : " + e);
		}
	}

	public static void sendWebsiteNotification(ServiceContext serviceContext, long userId,
			String notificationTemplateKey, Map<String, String> emailMap, String url) {
		try {
			List<Long> recordIdList = getTemplateList(serviceContext.getScopeGroupId(),
					NotificationTemplateConstants.WEB_NOTIFICATION_STRUCTURE,
					NotificationTemplateConstants.WEB_NOTIFICATION_RECORDSET);
			String templateContentBody = getTemplateContent(recordIdList, "NotificationContent",
					NotificationTemplateConstants.TEMPLATEKEY, notificationTemplateKey, serviceContext.getLocale());
			String templateContentSubject = getTemplateContent(recordIdList, "NotificationTitle",
					NotificationTemplateConstants.TEMPLATEKEY, notificationTemplateKey, serviceContext.getLocale());

			if (Validator.isNotNull(templateContentBody) && Validator.isNotNull(templateContentSubject)) {
				try {
					templateContentBody = HtmlUtil.unescape(templateContentBody);
					for (Map.Entry<String, String> e : emailMap.entrySet()) {
						templateContentBody = templateContentBody.replace("$[" + e.getKey() + "]", e.getValue());
					}

					JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
					payloadJSON.put("title", templateContentSubject);
					payloadJSON.put("notificationText", templateContentBody);
					payloadJSON.put("url", url);

					UserNotificationEventLocalServiceUtil.addUserNotificationEvent(userId,
							serviceContext.getPortletId(), (new Date()).getTime(),
							UserNotificationDeliveryConstants.TYPE_WEBSITE, 0, payloadJSON.toString(), false,
							serviceContext);

					_log.info("Website Notification Title : " + templateContentSubject);
					_log.info("Website Notification Content  : " + templateContentBody);

				} catch (Exception e) {
					_log.error("Error in sending Web notification : " + e);
				}
			} else {
				_log.error("Unable to find web notification template:" + notificationTemplateKey);
			}
		} catch (Exception e) {
			_log.error(e);
		}
	}

	public static void sendMail(ServiceContext serviceContext, String emailId, String templateKey,
			Map<String, String> emailMap) {
		try {
			List<Long> recordIdList = getTemplateList(serviceContext.getScopeGroupId(),
					NotificationTemplateConstants.EMAIL_STRUCTURE, NotificationTemplateConstants.EMAIL_RECORDSET);
			String templateContentBody = getTemplateContent(recordIdList, NotificationTemplateConstants.CONTENT_BODY,
					NotificationTemplateConstants.TEMPLATEKEY, templateKey, serviceContext.getLocale());
			String templateContentSubject = getTemplateContent(recordIdList, NotificationTemplateConstants.SUBJECT,
					NotificationTemplateConstants.TEMPLATEKEY, templateKey, serviceContext.getLocale());

			if (Validator.isNotNull(templateContentBody) && Validator.isNotNull(templateContentSubject)) {
				try {
					templateContentBody = HtmlUtil.unescape(templateContentBody);
					for (Map.Entry<String, String> e : emailMap.entrySet()) {
						templateContentBody = templateContentBody.replace("$[" + e.getKey() + "]", e.getValue());
					}

					sendEmail(emailId, "abhijit.ande@liferay.com", templateContentSubject, templateContentBody, true);

					_log.info("Email Content : " + templateContentBody);

				} catch (Exception e) {
					_log.error("Error in sending mail : " + e);
				}
			} else {
				_log.error("Unable to find email template:" + templateKey);
			}
		} catch (Exception e) {
			_log.error(e);
		}
	}

	private static void sendEmail(String recipient, String from, String subject, String body, boolean sendHtml) {
		try {
			MailMessage mailMessage = new MailMessage();
			mailMessage.setBody(body);
			mailMessage.setHTMLFormat(sendHtml);
			mailMessage.setFrom(new InternetAddress(from));
			mailMessage.setTo(new InternetAddress(recipient));
			mailMessage.setSubject(subject);
			MailServiceUtil.sendEmail(mailMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void invokeNotification(ServiceContext serviceContext, String templateKey,
			Map<String, String> detailsMap, long userId, String emailId, String url,
			boolean triggerPortalNotification) {
		try {

			if (triggerPortalNotification) {
				if (Validator.isNotNull(userId)) {
					NotificationUtil.sendWebsiteNotification(serviceContext, userId, templateKey, detailsMap, url);
				} else {
					_log.error("User id is null :" + userId);
				}
			}

			if (Validator.isNotNull(emailId)) {
				NotificationUtil.sendMail(serviceContext, emailId, templateKey, detailsMap);
			} else {
				_log.error("Email Id is not provided:" + emailId);
			}
		} catch (Exception e) {
			_log.error(e);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(NotificationUtil.class);

}
