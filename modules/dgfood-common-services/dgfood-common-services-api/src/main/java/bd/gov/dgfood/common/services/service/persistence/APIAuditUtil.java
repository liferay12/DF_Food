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

package bd.gov.dgfood.common.services.service.persistence;

import bd.gov.dgfood.common.services.model.APIAudit;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the api audit service. This utility wraps <code>bd.gov.dgfood.common.services.service.persistence.impl.APIAuditPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see APIAuditPersistence
 * @generated
 */
public class APIAuditUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(APIAudit apiAudit) {
		getPersistence().clearCache(apiAudit);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, APIAudit> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<APIAudit> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<APIAudit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<APIAudit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<APIAudit> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static APIAudit update(APIAudit apiAudit) {
		return getPersistence().update(apiAudit);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static APIAudit update(
		APIAudit apiAudit, ServiceContext serviceContext) {

		return getPersistence().update(apiAudit, serviceContext);
	}

	/**
	 * Caches the api audit in the entity cache if it is enabled.
	 *
	 * @param apiAudit the api audit
	 */
	public static void cacheResult(APIAudit apiAudit) {
		getPersistence().cacheResult(apiAudit);
	}

	/**
	 * Caches the api audits in the entity cache if it is enabled.
	 *
	 * @param apiAudits the api audits
	 */
	public static void cacheResult(List<APIAudit> apiAudits) {
		getPersistence().cacheResult(apiAudits);
	}

	/**
	 * Creates a new api audit with the primary key. Does not add the api audit to the database.
	 *
	 * @param apiAuditId the primary key for the new api audit
	 * @return the new api audit
	 */
	public static APIAudit create(long apiAuditId) {
		return getPersistence().create(apiAuditId);
	}

	/**
	 * Removes the api audit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param apiAuditId the primary key of the api audit
	 * @return the api audit that was removed
	 * @throws NoSuchAPIAuditException if a api audit with the primary key could not be found
	 */
	public static APIAudit remove(long apiAuditId)
		throws bd.gov.dgfood.common.services.exception.NoSuchAPIAuditException {

		return getPersistence().remove(apiAuditId);
	}

	public static APIAudit updateImpl(APIAudit apiAudit) {
		return getPersistence().updateImpl(apiAudit);
	}

	/**
	 * Returns the api audit with the primary key or throws a <code>NoSuchAPIAuditException</code> if it could not be found.
	 *
	 * @param apiAuditId the primary key of the api audit
	 * @return the api audit
	 * @throws NoSuchAPIAuditException if a api audit with the primary key could not be found
	 */
	public static APIAudit findByPrimaryKey(long apiAuditId)
		throws bd.gov.dgfood.common.services.exception.NoSuchAPIAuditException {

		return getPersistence().findByPrimaryKey(apiAuditId);
	}

	/**
	 * Returns the api audit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param apiAuditId the primary key of the api audit
	 * @return the api audit, or <code>null</code> if a api audit with the primary key could not be found
	 */
	public static APIAudit fetchByPrimaryKey(long apiAuditId) {
		return getPersistence().fetchByPrimaryKey(apiAuditId);
	}

	/**
	 * Returns all the api audits.
	 *
	 * @return the api audits
	 */
	public static List<APIAudit> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the api audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>APIAuditModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of api audits
	 * @param end the upper bound of the range of api audits (not inclusive)
	 * @return the range of api audits
	 */
	public static List<APIAudit> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the api audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>APIAuditModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of api audits
	 * @param end the upper bound of the range of api audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of api audits
	 */
	public static List<APIAudit> findAll(
		int start, int end, OrderByComparator<APIAudit> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the api audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>APIAuditModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of api audits
	 * @param end the upper bound of the range of api audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of api audits
	 */
	public static List<APIAudit> findAll(
		int start, int end, OrderByComparator<APIAudit> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the api audits from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of api audits.
	 *
	 * @return the number of api audits
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static APIAuditPersistence getPersistence() {
		return _persistence;
	}

	private static volatile APIAuditPersistence _persistence;

}