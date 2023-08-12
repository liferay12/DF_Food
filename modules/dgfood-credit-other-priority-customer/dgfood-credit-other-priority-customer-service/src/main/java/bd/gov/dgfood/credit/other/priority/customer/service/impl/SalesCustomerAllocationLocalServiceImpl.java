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

package bd.gov.dgfood.credit.other.priority.customer.service.impl;

import com.liferay.petra.string.StringUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.Conjunction;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer;
import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerAllocation;
import bd.gov.dgfood.credit.other.priority.customer.service.SalesCustomerAllocationLocalServiceUtil;
import bd.gov.dgfood.credit.other.priority.customer.service.SalesCustomerLocalServiceUtil;
import bd.gov.dgfood.credit.other.priority.customer.service.base.SalesCustomerAllocationLocalServiceBaseImpl;

/**
 * The implementation of the sales customer allocation local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>bd.gov.dgfood.credit.other.priority.customer.service.SalesCustomerAllocationLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SalesCustomerAllocationLocalServiceBaseImpl
 */
@Component(property = "model.class.name=bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerAllocation", service = AopService.class)
public class SalesCustomerAllocationLocalServiceImpl extends SalesCustomerAllocationLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>bd.gov.dgfood.credit.other.priority.customer.service.
	 * SalesCustomerAllocationLocalService</code> via injection or a
	 * <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>bd.gov.dgfood.credit.other.priority.customer.service.
	 * SalesCustomerAllocationLocalServiceUtil</code>.
	 */

	public SalesCustomerAllocation addEntry(long salesCustomerCode, String salesCustomerName, long allocationNumber,
			String salesOrganization, String distributionChannel, int year, String district, String subDistrict,
			String govOrderNumber, String commodity, double yearlyQty, String yearlyQtyUnit, double monthlyQty,
			String monthlyQtyUnit, long businessCode, String uc) {

		long allocationId = counterLocalService.increment(SalesCustomerAllocation.class.getName());

		SalesCustomerAllocation salesCustomerAllocation = salesCustomerAllocationPersistence.create(allocationId);

		salesCustomerAllocation.setAllocationNumber(allocationNumber);
		salesCustomerAllocation.setSalesOrganization(salesOrganization);
		salesCustomerAllocation.setDistributionChannel(distributionChannel);
		salesCustomerAllocation.setYear(year);
		salesCustomerAllocation.setDistrict(subDistrict);
		salesCustomerAllocation.setSubDistrict(subDistrict);
		salesCustomerAllocation.setGovOrderNumber(govOrderNumber);
		salesCustomerAllocation.setCommodity(commodity);
		salesCustomerAllocation.setYearlyQty(yearlyQty);
		salesCustomerAllocation.setYearlyQtyUnit(yearlyQtyUnit);
		salesCustomerAllocation.setMonthlyQty(monthlyQty);
		salesCustomerAllocation.setMonthlyQtyUnit(monthlyQtyUnit);

		salesCustomerAllocation.setSalesCustomerCode(salesCustomerCode);

		salesCustomerAllocation.setSalesCustomerName(salesCustomerName);
		salesCustomerAllocation.setCreateDate(new Date());

		return salesCustomerAllocationLocalService.updateSalesCustomerAllocation(salesCustomerAllocation);

	}

	/**
	 * @param year
	 * @param commodity
	 * @param userId
	 * @param start
	 * @param end
	 * @return
	 */
	public List<SalesCustomerAllocation> search(int year, String commodity, long salesCustomerCode, int start,
			int end) {

		DynamicQuery dynamicQuery = salesCustomerAllocationLocalService.dynamicQuery();
		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		Disjunction disjunction = RestrictionsFactoryUtil.disjunction();

		conjunction.add(RestrictionsFactoryUtil.eq("salesCustomerCode", salesCustomerCode));

		if (Validator.isNotNull(commodity)) {
			conjunction.add(RestrictionsFactoryUtil.eq("commodity", commodity));
		}

		if (year > 0) {
			conjunction.add(RestrictionsFactoryUtil.eq("year", year));
		}
		dynamicQuery.add(conjunction);
		// dynamicQuery.add(RestrictionsFactoryUtil.and(conjunction, disjunction));

		return salesCustomerAllocationLocalService.dynamicQuery(dynamicQuery, start, end);

	}

	/**
	 * @param year
	 * @param commodity
	 * @param userId
	 * @return
	 */
	public int searchCount(int year, String commodity, long salesCustomerCode) {

		DynamicQuery dynamicQuery = salesCustomerAllocationLocalService.dynamicQuery();
		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		Disjunction disjunction = RestrictionsFactoryUtil.disjunction();

		conjunction.add(RestrictionsFactoryUtil.eq("salesCustomerCode", salesCustomerCode));

		if (Validator.isNotNull(commodity)) {
			conjunction.add(RestrictionsFactoryUtil.eq("commodity", commodity));
		}

		if (year > 0) {
			conjunction.add(RestrictionsFactoryUtil.eq("year", year));
		}
		dynamicQuery.add(conjunction);
		// dynamicQuery.add(RestrictionsFactoryUtil.and(conjunction, disjunction));

		return (int) salesCustomerAllocationLocalService.dynamicQueryCount(dynamicQuery);

	}

	private static Log log = LogFactoryUtil.getLog(SalesCustomerAllocationLocalServiceImpl.class);

}