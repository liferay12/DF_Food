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

package bd.gov.dgfood.credit.other.priority.customer.service.base;

import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerAllocation;
import bd.gov.dgfood.credit.other.priority.customer.service.SalesCustomerAllocationService;
import bd.gov.dgfood.credit.other.priority.customer.service.SalesCustomerAllocationServiceUtil;
import bd.gov.dgfood.credit.other.priority.customer.service.persistence.SalesCustomerAllocationPersistence;
import bd.gov.dgfood.credit.other.priority.customer.service.persistence.SalesCustomerPersistence;
import bd.gov.dgfood.credit.other.priority.customer.service.persistence.SalesCustomerVersionPersistence;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import java.lang.reflect.Field;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the sales customer allocation remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link bd.gov.dgfood.credit.other.priority.customer.service.impl.SalesCustomerAllocationServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see bd.gov.dgfood.credit.other.priority.customer.service.impl.SalesCustomerAllocationServiceImpl
 * @generated
 */
public abstract class SalesCustomerAllocationServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, IdentifiableOSGiService,
			   SalesCustomerAllocationService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>SalesCustomerAllocationService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>SalesCustomerAllocationServiceUtil</code>.
	 */
	@Deactivate
	protected void deactivate() {
		_setServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			SalesCustomerAllocationService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		salesCustomerAllocationService =
			(SalesCustomerAllocationService)aopProxy;

		_setServiceUtilService(salesCustomerAllocationService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return SalesCustomerAllocationService.class.getName();
	}

	protected Class<?> getModelClass() {
		return SalesCustomerAllocation.class;
	}

	protected String getModelClassName() {
		return SalesCustomerAllocation.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				salesCustomerAllocationPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setServiceUtilService(
		SalesCustomerAllocationService salesCustomerAllocationService) {

		try {
			Field field =
				SalesCustomerAllocationServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, salesCustomerAllocationService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected SalesCustomerPersistence salesCustomerPersistence;

	@Reference
	protected bd.gov.dgfood.credit.other.priority.customer.service.
		SalesCustomerAllocationLocalService salesCustomerAllocationLocalService;

	protected SalesCustomerAllocationService salesCustomerAllocationService;

	@Reference
	protected SalesCustomerAllocationPersistence
		salesCustomerAllocationPersistence;

	@Reference
	protected SalesCustomerVersionPersistence salesCustomerVersionPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

}