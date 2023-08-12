/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package bd.gov.dgfood.common.services.service.impl;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.common.services.model.Grievance;
import bd.gov.dgfood.common.services.service.base.GrievanceLocalServiceBaseImpl;
import bd.gov.dgfood.common.util.ApplicationNumberUtil;
import bd.gov.dgfood.common.util.constants.ModuleConstant;
import bd.gov.dgfood.common.util.constants.StatusConstants;

/**
 * The implementation of the grievance local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>bd.gov.dgfood.common.services.service.GrievanceLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GrievanceLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=bd.gov.dgfood.common.services.model.Grievance",
	service = AopService.class
)
public class GrievanceLocalServiceImpl extends GrievanceLocalServiceBaseImpl {

public void replyGrievance(ThemeDisplay themeDisplay, long grievanceId, String responseDetails) {
		
		Grievance grievance = fetchGrievance(grievanceId);
		
		grievance.setGrievanceId(grievanceId);
		grievance.setResponseDetails(responseDetails);
		grievance.setResponseBy(themeDisplay.getUserId());
		grievance.setResponseDate(new Date());
		grievance.setStatus(StatusConstants.STATUS_RESOLVED);
		
		grievancePersistence.update(grievance);
	}
	
	public Grievance addGrievance(ServiceContext serviceContext, long grievanceCategory, String userName, long userType, String mobileNumber, String complaintDetails, long attachmentId) {
		Grievance grievance = createGrievance(counterLocalService.increment(Grievance.class.getName()));
		
		grievance.setCompanyId(serviceContext.getCompanyId());
		grievance.setGroupId(serviceContext.getScopeGroupId());
		
		grievance.setGrievanceCategory(grievanceCategory);
		grievance.setUserType(userType);
		grievance.setUserName(userName);
		grievance.setUserID(serviceContext.getUserId());
	
		grievance.setMobileNumber(mobileNumber);
		grievance.setComplaintDetails(complaintDetails);
		grievance.setCreateDate(new Date());
		grievance.setStatus(StatusConstants.STATUS_PENDING);
		grievance.setAttachmentId(attachmentId);		
		grievance.setGrievanceNumber(ApplicationNumberUtil.generateApplicationNumber(grievance.getGrievanceId(), ModuleConstant.DGFOOD_GRIEVANCE_MODULE));
		
		grievancePersistence.update(grievance);
		
		return grievance;
	}
	
	public List<Grievance> getGrievanceList(String searchKey, String fromDate, String toDate, long grievanceCategory, long grievanceUser, int status, int start, int end, long UserID, boolean isAdmin) {
		DynamicQuery query = getQueryObject(searchKey, fromDate, toDate, grievanceCategory, grievanceUser, status, UserID, isAdmin);
		List<Grievance> getGrievanceList = dynamicQuery(query, start, end);
		return getGrievanceList;
	}
	
	public long getGrievanceCount(String searchKey, String fromDate, String toDate, long grievanceCategory, long grievanceUser, int status, long userID, boolean isAdmin) {
		DynamicQuery query = getQueryObject(searchKey, fromDate, toDate, grievanceCategory, grievanceUser, status, userID, isAdmin);
		long getGrievanceCount = dynamicQueryCount(query);
		return getGrievanceCount;
	}
	
	private DynamicQuery getQueryObject(String searchKey, String fromDate, String toDate, long grievanceCategory, long grievanceUser, int status, long userID, boolean isAdmin) {
		DynamicQuery query = dynamicQuery();
		
		Criterion criteria = null;
		
		Junction grievanceJunction = RestrictionsFactoryUtil.disjunction();
		
		Junction fromDateJunction = RestrictionsFactoryUtil.disjunction();
		Junction toDateJunction = RestrictionsFactoryUtil.disjunction();
		Junction grievanceCategoryJunction = RestrictionsFactoryUtil.disjunction();
		Junction grievanceUserJunction = RestrictionsFactoryUtil.disjunction();
		Junction statusJunction = RestrictionsFactoryUtil.disjunction();

		//SimpleDateFormat originalDateFormat = new SimpleDateFormat(DateConstants.YYYY_MM_DD);
		
		try {
			if (searchKey != null) {
				Criterion complaintDetailsCriteria = RestrictionsFactoryUtil.ilike("complaintDetails",
						StringPool.PERCENT + searchKey + StringPool.PERCENT);
				grievanceJunction.add(complaintDetailsCriteria);
			}
			
			if (Validator.isNotNull(fromDate) && !fromDate.equals("")) {
				//criteria = RestrictionsFactoryUtil.ge("createDate",originalDateFormat.parse(fromDate));
				fromDateJunction.add(criteria);
			}
			if (Validator.isNotNull(toDate) && !toDate.equals("")) {
				Calendar targetToDate = Calendar.getInstance();
				//targetToDate.setTime(originalDateFormat.parse(toDate));
				targetToDate.set(Calendar.HOUR, 23);
				targetToDate.set(Calendar.MINUTE, 59);
				
				criteria = RestrictionsFactoryUtil.le("createDate", targetToDate.getTime());
				toDateJunction.add(criteria);
			}
			
			if(Validator.isNotNull(status) && status != 0){
				criteria=RestrictionsFactoryUtil.eq("status", status);
				statusJunction.add(criteria);
			}
			
			if(Validator.isNotNull(grievanceCategory) && grievanceCategory != 0){
				criteria=RestrictionsFactoryUtil.eq("grievanceCategory", grievanceCategory);
				grievanceCategoryJunction.add(criteria);
			}
			
			if(isAdmin) { 
				if(Validator.isNotNull(grievanceUser) && grievanceUser != 0){
					criteria=RestrictionsFactoryUtil.eq("userType", grievanceUser);
					grievanceUserJunction.add(criteria);
				}
			}
			else {
				criteria=RestrictionsFactoryUtil.eq("userID", userID);
				grievanceUserJunction.add(criteria);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		query = dynamicQuery().add(RestrictionsFactoryUtil.and(grievanceJunction,RestrictionsFactoryUtil.and(grievanceCategoryJunction,
				RestrictionsFactoryUtil.and(grievanceUserJunction,RestrictionsFactoryUtil.and(statusJunction,
						RestrictionsFactoryUtil.and(fromDateJunction,toDateJunction))))));

		return query.addOrder(OrderFactoryUtil.desc("createDate"));
	}
	
}