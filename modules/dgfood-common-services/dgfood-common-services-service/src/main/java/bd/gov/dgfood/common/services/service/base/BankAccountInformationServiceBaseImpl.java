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

package bd.gov.dgfood.common.services.service.base;

import bd.gov.dgfood.common.services.model.BankAccountInformation;
import bd.gov.dgfood.common.services.service.BankAccountInformationService;
import bd.gov.dgfood.common.services.service.BankAccountInformationServiceUtil;
import bd.gov.dgfood.common.services.service.persistence.APIAuditPersistence;
import bd.gov.dgfood.common.services.service.persistence.AddressPersistence;
import bd.gov.dgfood.common.services.service.persistence.AddressVersionPersistence;
import bd.gov.dgfood.common.services.service.persistence.AttachmentPersistence;
import bd.gov.dgfood.common.services.service.persistence.AttachmentVersionPersistence;
import bd.gov.dgfood.common.services.service.persistence.BankAccountInformationPersistence;
import bd.gov.dgfood.common.services.service.persistence.DGFUsersPersistence;
import bd.gov.dgfood.common.services.service.persistence.DeliveryOrderPersistence;
import bd.gov.dgfood.common.services.service.persistence.GrievancePersistence;
import bd.gov.dgfood.common.services.service.persistence.IndentPersistence;
import bd.gov.dgfood.common.services.service.persistence.MDMSyncStatusPersistence;
import bd.gov.dgfood.common.services.service.persistence.UserDetailsPersistence;
import bd.gov.dgfood.common.services.service.persistence.UserLocationPersistence;

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
 * Provides the base implementation for the bank account information remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link bd.gov.dgfood.common.services.service.impl.BankAccountInformationServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see bd.gov.dgfood.common.services.service.impl.BankAccountInformationServiceImpl
 * @generated
 */
public abstract class BankAccountInformationServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, BankAccountInformationService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>BankAccountInformationService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>BankAccountInformationServiceUtil</code>.
	 */
	@Deactivate
	protected void deactivate() {
		_setServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			BankAccountInformationService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		bankAccountInformationService = (BankAccountInformationService)aopProxy;

		_setServiceUtilService(bankAccountInformationService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return BankAccountInformationService.class.getName();
	}

	protected Class<?> getModelClass() {
		return BankAccountInformation.class;
	}

	protected String getModelClassName() {
		return BankAccountInformation.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				bankAccountInformationPersistence.getDataSource();

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
		BankAccountInformationService bankAccountInformationService) {

		try {
			Field field =
				BankAccountInformationServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, bankAccountInformationService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected AddressPersistence addressPersistence;

	@Reference
	protected AddressVersionPersistence addressVersionPersistence;

	@Reference
	protected APIAuditPersistence apiAuditPersistence;

	@Reference
	protected AttachmentPersistence attachmentPersistence;

	@Reference
	protected AttachmentVersionPersistence attachmentVersionPersistence;

	@Reference
	protected
		bd.gov.dgfood.common.services.service.BankAccountInformationLocalService
			bankAccountInformationLocalService;

	protected BankAccountInformationService bankAccountInformationService;

	@Reference
	protected BankAccountInformationPersistence
		bankAccountInformationPersistence;

	@Reference
	protected DeliveryOrderPersistence deliveryOrderPersistence;

	@Reference
	protected DGFUsersPersistence dgfUsersPersistence;

	@Reference
	protected GrievancePersistence grievancePersistence;

	@Reference
	protected IndentPersistence indentPersistence;

	@Reference
	protected MDMSyncStatusPersistence mdmSyncStatusPersistence;

	@Reference
	protected UserDetailsPersistence userDetailsPersistence;

	@Reference
	protected UserLocationPersistence userLocationPersistence;

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