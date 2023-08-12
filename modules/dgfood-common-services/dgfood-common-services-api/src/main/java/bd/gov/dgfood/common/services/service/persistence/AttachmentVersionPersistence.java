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

import bd.gov.dgfood.common.services.exception.NoSuchAttachmentVersionException;
import bd.gov.dgfood.common.services.model.AttachmentVersion;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the attachment version service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentVersionUtil
 * @generated
 */
@ProviderType
public interface AttachmentVersionPersistence
	extends BasePersistence<AttachmentVersion> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AttachmentVersionUtil} to access the attachment version persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the attachment versions where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @return the matching attachment versions
	 */
	public java.util.List<AttachmentVersion> findByCPK_CN(
		long classPK, String className);

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
	public java.util.List<AttachmentVersion> findByCPK_CN(
		long classPK, String className, int start, int end);

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
	public java.util.List<AttachmentVersion> findByCPK_CN(
		long classPK, String className, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AttachmentVersion>
			orderByComparator);

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
	public java.util.List<AttachmentVersion> findByCPK_CN(
		long classPK, String className, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AttachmentVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first attachment version in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment version
	 * @throws NoSuchAttachmentVersionException if a matching attachment version could not be found
	 */
	public AttachmentVersion findByCPK_CN_First(
			long classPK, String className,
			com.liferay.portal.kernel.util.OrderByComparator<AttachmentVersion>
				orderByComparator)
		throws NoSuchAttachmentVersionException;

	/**
	 * Returns the first attachment version in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment version, or <code>null</code> if a matching attachment version could not be found
	 */
	public AttachmentVersion fetchByCPK_CN_First(
		long classPK, String className,
		com.liferay.portal.kernel.util.OrderByComparator<AttachmentVersion>
			orderByComparator);

	/**
	 * Returns the last attachment version in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment version
	 * @throws NoSuchAttachmentVersionException if a matching attachment version could not be found
	 */
	public AttachmentVersion findByCPK_CN_Last(
			long classPK, String className,
			com.liferay.portal.kernel.util.OrderByComparator<AttachmentVersion>
				orderByComparator)
		throws NoSuchAttachmentVersionException;

	/**
	 * Returns the last attachment version in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment version, or <code>null</code> if a matching attachment version could not be found
	 */
	public AttachmentVersion fetchByCPK_CN_Last(
		long classPK, String className,
		com.liferay.portal.kernel.util.OrderByComparator<AttachmentVersion>
			orderByComparator);

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
	public AttachmentVersion[] findByCPK_CN_PrevAndNext(
			long attachmentVersionId, long classPK, String className,
			com.liferay.portal.kernel.util.OrderByComparator<AttachmentVersion>
				orderByComparator)
		throws NoSuchAttachmentVersionException;

	/**
	 * Removes all the attachment versions where classPK = &#63; and className = &#63; from the database.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 */
	public void removeByCPK_CN(long classPK, String className);

	/**
	 * Returns the number of attachment versions where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @return the number of matching attachment versions
	 */
	public int countByCPK_CN(long classPK, String className);

	/**
	 * Caches the attachment version in the entity cache if it is enabled.
	 *
	 * @param attachmentVersion the attachment version
	 */
	public void cacheResult(AttachmentVersion attachmentVersion);

	/**
	 * Caches the attachment versions in the entity cache if it is enabled.
	 *
	 * @param attachmentVersions the attachment versions
	 */
	public void cacheResult(
		java.util.List<AttachmentVersion> attachmentVersions);

	/**
	 * Creates a new attachment version with the primary key. Does not add the attachment version to the database.
	 *
	 * @param attachmentVersionId the primary key for the new attachment version
	 * @return the new attachment version
	 */
	public AttachmentVersion create(long attachmentVersionId);

	/**
	 * Removes the attachment version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentVersionId the primary key of the attachment version
	 * @return the attachment version that was removed
	 * @throws NoSuchAttachmentVersionException if a attachment version with the primary key could not be found
	 */
	public AttachmentVersion remove(long attachmentVersionId)
		throws NoSuchAttachmentVersionException;

	public AttachmentVersion updateImpl(AttachmentVersion attachmentVersion);

	/**
	 * Returns the attachment version with the primary key or throws a <code>NoSuchAttachmentVersionException</code> if it could not be found.
	 *
	 * @param attachmentVersionId the primary key of the attachment version
	 * @return the attachment version
	 * @throws NoSuchAttachmentVersionException if a attachment version with the primary key could not be found
	 */
	public AttachmentVersion findByPrimaryKey(long attachmentVersionId)
		throws NoSuchAttachmentVersionException;

	/**
	 * Returns the attachment version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attachmentVersionId the primary key of the attachment version
	 * @return the attachment version, or <code>null</code> if a attachment version with the primary key could not be found
	 */
	public AttachmentVersion fetchByPrimaryKey(long attachmentVersionId);

	/**
	 * Returns all the attachment versions.
	 *
	 * @return the attachment versions
	 */
	public java.util.List<AttachmentVersion> findAll();

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
	public java.util.List<AttachmentVersion> findAll(int start, int end);

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
	public java.util.List<AttachmentVersion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AttachmentVersion>
			orderByComparator);

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
	public java.util.List<AttachmentVersion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AttachmentVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the attachment versions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of attachment versions.
	 *
	 * @return the number of attachment versions
	 */
	public int countAll();

}