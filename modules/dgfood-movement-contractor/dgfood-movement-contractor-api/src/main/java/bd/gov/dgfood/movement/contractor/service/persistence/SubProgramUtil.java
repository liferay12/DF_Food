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

package bd.gov.dgfood.movement.contractor.service.persistence;

import bd.gov.dgfood.movement.contractor.model.SubProgram;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the sub program service. This utility wraps <code>bd.gov.dgfood.movement.contractor.service.persistence.impl.SubProgramPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubProgramPersistence
 * @generated
 */
public class SubProgramUtil {

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
	public static void clearCache(SubProgram subProgram) {
		getPersistence().clearCache(subProgram);
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
	public static Map<Serializable, SubProgram> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SubProgram> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SubProgram> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SubProgram> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SubProgram> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SubProgram update(SubProgram subProgram) {
		return getPersistence().update(subProgram);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SubProgram update(
		SubProgram subProgram, ServiceContext serviceContext) {

		return getPersistence().update(subProgram, serviceContext);
	}

	/**
	 * Caches the sub program in the entity cache if it is enabled.
	 *
	 * @param subProgram the sub program
	 */
	public static void cacheResult(SubProgram subProgram) {
		getPersistence().cacheResult(subProgram);
	}

	/**
	 * Caches the sub programs in the entity cache if it is enabled.
	 *
	 * @param subPrograms the sub programs
	 */
	public static void cacheResult(List<SubProgram> subPrograms) {
		getPersistence().cacheResult(subPrograms);
	}

	/**
	 * Creates a new sub program with the primary key. Does not add the sub program to the database.
	 *
	 * @param subProgramId the primary key for the new sub program
	 * @return the new sub program
	 */
	public static SubProgram create(long subProgramId) {
		return getPersistence().create(subProgramId);
	}

	/**
	 * Removes the sub program with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subProgramId the primary key of the sub program
	 * @return the sub program that was removed
	 * @throws NoSuchSubProgramException if a sub program with the primary key could not be found
	 */
	public static SubProgram remove(long subProgramId)
		throws bd.gov.dgfood.movement.contractor.exception.
			NoSuchSubProgramException {

		return getPersistence().remove(subProgramId);
	}

	public static SubProgram updateImpl(SubProgram subProgram) {
		return getPersistence().updateImpl(subProgram);
	}

	/**
	 * Returns the sub program with the primary key or throws a <code>NoSuchSubProgramException</code> if it could not be found.
	 *
	 * @param subProgramId the primary key of the sub program
	 * @return the sub program
	 * @throws NoSuchSubProgramException if a sub program with the primary key could not be found
	 */
	public static SubProgram findByPrimaryKey(long subProgramId)
		throws bd.gov.dgfood.movement.contractor.exception.
			NoSuchSubProgramException {

		return getPersistence().findByPrimaryKey(subProgramId);
	}

	/**
	 * Returns the sub program with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param subProgramId the primary key of the sub program
	 * @return the sub program, or <code>null</code> if a sub program with the primary key could not be found
	 */
	public static SubProgram fetchByPrimaryKey(long subProgramId) {
		return getPersistence().fetchByPrimaryKey(subProgramId);
	}

	/**
	 * Returns all the sub programs.
	 *
	 * @return the sub programs
	 */
	public static List<SubProgram> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the sub programs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubProgramModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sub programs
	 * @param end the upper bound of the range of sub programs (not inclusive)
	 * @return the range of sub programs
	 */
	public static List<SubProgram> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the sub programs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubProgramModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sub programs
	 * @param end the upper bound of the range of sub programs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sub programs
	 */
	public static List<SubProgram> findAll(
		int start, int end, OrderByComparator<SubProgram> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sub programs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubProgramModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sub programs
	 * @param end the upper bound of the range of sub programs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sub programs
	 */
	public static List<SubProgram> findAll(
		int start, int end, OrderByComparator<SubProgram> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the sub programs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of sub programs.
	 *
	 * @return the number of sub programs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SubProgramPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SubProgramPersistence _persistence;

}