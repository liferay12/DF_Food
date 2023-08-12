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

import bd.gov.dgfood.common.services.model.AttachmentVersion;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the attachment version service. This utility wraps <code>bd.gov.dgfood.common.services.service.persistence.impl.AttachmentVersionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentVersionPersistence
 * @generated
 */
public class AttachmentVersionUtil {

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
	public static void clearCache(AttachmentVersion attachmentVersion) {
		getPersistence().clearCache(attachmentVersion);
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
	public static Map<Serializable, AttachmentVersion> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AttachmentVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AttachmentVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AttachmentVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AttachmentVersion> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AttachmentVersion update(
		AttachmentVersion attachmentVersion) {

		return getPersistence().update(attachmentVersion);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AttachmentVersion update(
		AttachmentVersion attachmentVersion, ServiceContext serviceContext) {

		return getPersistence().update(attachmentVersion, serviceContext);
	}

	/**
	 * Returns all the attachment versions where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @return the matching attachment versions
	 */
	public static List<AttachmentVersion> findByCPK_CN(
		long classPK, String className) {

		return getPersistence().findByCPK_CN(classPK, className);
	}

	/**
	 * Returns a range of all the attachment versions where classPK = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentVersionModelImpl</code>.
	 * </p>
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param start the lower bound of the range of attachment versions
	 * @param end the upper bound of the range of attachment versions (not inclusive)
	 * @return the range of matching attachment versions
	 */
	public static List<AttachmentVersion> findByCPK_CN(
		long classPK, String className, int start, int end) {

		return getPersistence().findByCPK_CN(classPK, className, start, end);
	}

	/**
	 * Returns an ordered range of all the attachment versions where classPK = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentVersionModelImpl</code>.
	 * </p>
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param start the lower bound of the range of attachment versions
	 * @param end the upper bound of the range of attachment versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attachment versions
	 */
	public static List<AttachmentVersion> findByCPK_CN(
		long classPK, String className, int start, int end,
		OrderByComparator<AttachmentVersion> orderByComparator) {

		return getPersistence().findByCPK_CN(
			classPK, className, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the attachment versions where classPK = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentVersionModelImpl</code>.
	 * </p>
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param start the lower bound of the range of attachment versions
	 * @param end the upper bound of the range of attachment versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching attachment versions
	 */
	public static List<AttachmentVersion> findByCPK_CN(
		long classPK, String className, int start, int end,
		OrderByComparator<AttachmentVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCPK_CN(
			classPK, className, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first attachment version in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment version
	 * @throws NoSuchAttachmentVersionException if a matching attachment version could not be found
	 */
	public static AttachmentVersion findByCPK_CN_First(
			long classPK, String className,
			OrderByComparator<AttachmentVersion> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchAttachmentVersionException {

		return getPersistence().findByCPK_CN_First(
			classPK, className, orderByComparator);
	}

	/**
	 * Returns the first attachment version in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment version, or <code>null</code> if a matching attachment version could not be found
	 */
	public static AttachmentVersion fetchByCPK_CN_First(
		long classPK, String className,
		OrderByComparator<AttachmentVersion> orderByComparator) {

		return getPersistence().fetchByCPK_CN_First(
			classPK, className, orderByComparator);
	}

	/**
	 * Returns the last attachment version in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment version
	 * @throws NoSuchAttachmentVersionException if a matching attachment version could not be found
	 */
	public static AttachmentVersion findByCPK_CN_Last(
			long classPK, String className,
			OrderByComparator<AttachmentVersion> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchAttachmentVersionException {

		return getPersistence().findByCPK_CN_Last(
			classPK, className, orderByComparator);
	}

	/**
	 * Returns the last attachment version in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment version, or <code>null</code> if a matching attachment version could not be found
	 */
	public static AttachmentVersion fetchByCPK_CN_Last(
		long classPK, String className,
		OrderByComparator<AttachmentVersion> orderByComparator) {

		return getPersistence().fetchByCPK_CN_Last(
			classPK, className, orderByComparator);
	}

	/**
	 * Returns the attachment versions before and after the current attachment version in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param attachmentVersionId the primary key of the current attachment version
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attachment version
	 * @throws NoSuchAttachmentVersionException if a attachment version with the primary key could not be found
	 */
	public static AttachmentVersion[] findByCPK_CN_PrevAndNext(
			long attachmentVersionId, long classPK, String className,
			OrderByComparator<AttachmentVersion> orderByComparator)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchAttachmentVersionException {

		return getPersistence().findByCPK_CN_PrevAndNext(
			attachmentVersionId, classPK, className, orderByComparator);
	}

	/**
	 * Removes all the attachment versions where classPK = &#63; and className = &#63; from the database.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 */
	public static void removeByCPK_CN(long classPK, String className) {
		getPersistence().removeByCPK_CN(classPK, className);
	}

	/**
	 * Returns the number of attachment versions where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @return the number of matching attachment versions
	 */
	public static int countByCPK_CN(long classPK, String className) {
		return getPersistence().countByCPK_CN(classPK, className);
	}

	/**
	 * Caches the attachment version in the entity cache if it is enabled.
	 *
	 * @param attachmentVersion the attachment version
	 */
	public static void cacheResult(AttachmentVersion attachmentVersion) {
		getPersistence().cacheResult(attachmentVersion);
	}

	/**
	 * Caches the attachment versions in the entity cache if it is enabled.
	 *
	 * @param attachmentVersions the attachment versions
	 */
	public static void cacheResult(List<AttachmentVersion> attachmentVersions) {
		getPersistence().cacheResult(attachmentVersions);
	}

	/**
	 * Creates a new attachment version with the primary key. Does not add the attachment version to the database.
	 *
	 * @param attachmentVersionId the primary key for the new attachment version
	 * @return the new attachment version
	 */
	public static AttachmentVersion create(long attachmentVersionId) {
		return getPersistence().create(attachmentVersionId);
	}

	/**
	 * Removes the attachment version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentVersionId the primary key of the attachment version
	 * @return the attachment version that was removed
	 * @throws NoSuchAttachmentVersionException if a attachment version with the primary key could not be found
	 */
	public static AttachmentVersion remove(long attachmentVersionId)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchAttachmentVersionException {

		return getPersistence().remove(attachmentVersionId);
	}

	public static AttachmentVersion updateImpl(
		AttachmentVersion attachmentVersion) {

		return getPersistence().updateImpl(attachmentVersion);
	}

	/**
	 * Returns the attachment version with the primary key or throws a <code>NoSuchAttachmentVersionException</code> if it could not be found.
	 *
	 * @param attachmentVersionId the primary key of the attachment version
	 * @return the attachment version
	 * @throws NoSuchAttachmentVersionException if a attachment version with the primary key could not be found
	 */
	public static AttachmentVersion findByPrimaryKey(long attachmentVersionId)
		throws bd.gov.dgfood.common.services.exception.
			NoSuchAttachmentVersionException {

		return getPersistence().findByPrimaryKey(attachmentVersionId);
	}

	/**
	 * Returns the attachment version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attachmentVersionId the primary key of the attachment version
	 * @return the attachment version, or <code>null</code> if a attachment version with the primary key could not be found
	 */
	public static AttachmentVersion fetchByPrimaryKey(
		long attachmentVersionId) {

		return getPersistence().fetchByPrimaryKey(attachmentVersionId);
	}

	/**
	 * Returns all the attachment versions.
	 *
	 * @return the attachment versions
	 */
	public static List<AttachmentVersion> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the attachment versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attachment versions
	 * @param end the upper bound of the range of attachment versions (not inclusive)
	 * @return the range of attachment versions
	 */
	public static List<AttachmentVersion> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the attachment versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attachment versions
	 * @param end the upper bound of the range of attachment versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of attachment versions
	 */
	public static List<AttachmentVersion> findAll(
		int start, int end,
		OrderByComparator<AttachmentVersion> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the attachment versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attachment versions
	 * @param end the upper bound of the range of attachment versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of attachment versions
	 */
	public static List<AttachmentVersion> findAll(
		int start, int end,
		OrderByComparator<AttachmentVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the attachment versions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of attachment versions.
	 *
	 * @return the number of attachment versions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AttachmentVersionPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AttachmentVersionPersistence _persistence;

}