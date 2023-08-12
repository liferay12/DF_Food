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

import bd.gov.dgfood.common.services.exception.NoSuchAttachmentException;
import bd.gov.dgfood.common.services.model.Attachment;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the attachment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentUtil
 * @generated
 */
@ProviderType
public interface AttachmentPersistence extends BasePersistence<Attachment> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AttachmentUtil} to access the attachment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the attachments where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @return the matching attachments
	 */
	public java.util.List<Attachment> findByCPK_CN(
		long classPK, String className);

	/**
	 * Returns a range of all the attachments where classPK = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param start the lower bound of the range of attachments
	 * @param end the upper bound of the range of attachments (not inclusive)
	 * @return the range of matching attachments
	 */
	public java.util.List<Attachment> findByCPK_CN(
		long classPK, String className, int start, int end);

	/**
	 * Returns an ordered range of all the attachments where classPK = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param start the lower bound of the range of attachments
	 * @param end the upper bound of the range of attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attachments
	 */
	public java.util.List<Attachment> findByCPK_CN(
		long classPK, String className, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Attachment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the attachments where classPK = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param start the lower bound of the range of attachments
	 * @param end the upper bound of the range of attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching attachments
	 */
	public java.util.List<Attachment> findByCPK_CN(
		long classPK, String className, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Attachment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first attachment in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment
	 * @throws NoSuchAttachmentException if a matching attachment could not be found
	 */
	public Attachment findByCPK_CN_First(
			long classPK, String className,
			com.liferay.portal.kernel.util.OrderByComparator<Attachment>
				orderByComparator)
		throws NoSuchAttachmentException;

	/**
	 * Returns the first attachment in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment, or <code>null</code> if a matching attachment could not be found
	 */
	public Attachment fetchByCPK_CN_First(
		long classPK, String className,
		com.liferay.portal.kernel.util.OrderByComparator<Attachment>
			orderByComparator);

	/**
	 * Returns the last attachment in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment
	 * @throws NoSuchAttachmentException if a matching attachment could not be found
	 */
	public Attachment findByCPK_CN_Last(
			long classPK, String className,
			com.liferay.portal.kernel.util.OrderByComparator<Attachment>
				orderByComparator)
		throws NoSuchAttachmentException;

	/**
	 * Returns the last attachment in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment, or <code>null</code> if a matching attachment could not be found
	 */
	public Attachment fetchByCPK_CN_Last(
		long classPK, String className,
		com.liferay.portal.kernel.util.OrderByComparator<Attachment>
			orderByComparator);

	/**
	 * Returns the attachments before and after the current attachment in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param attachmentId the primary key of the current attachment
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attachment
	 * @throws NoSuchAttachmentException if a attachment with the primary key could not be found
	 */
	public Attachment[] findByCPK_CN_PrevAndNext(
			long attachmentId, long classPK, String className,
			com.liferay.portal.kernel.util.OrderByComparator<Attachment>
				orderByComparator)
		throws NoSuchAttachmentException;

	/**
	 * Removes all the attachments where classPK = &#63; and className = &#63; from the database.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 */
	public void removeByCPK_CN(long classPK, String className);

	/**
	 * Returns the number of attachments where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @return the number of matching attachments
	 */
	public int countByCPK_CN(long classPK, String className);

	/**
	 * Caches the attachment in the entity cache if it is enabled.
	 *
	 * @param attachment the attachment
	 */
	public void cacheResult(Attachment attachment);

	/**
	 * Caches the attachments in the entity cache if it is enabled.
	 *
	 * @param attachments the attachments
	 */
	public void cacheResult(java.util.List<Attachment> attachments);

	/**
	 * Creates a new attachment with the primary key. Does not add the attachment to the database.
	 *
	 * @param attachmentId the primary key for the new attachment
	 * @return the new attachment
	 */
	public Attachment create(long attachmentId);

	/**
	 * Removes the attachment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentId the primary key of the attachment
	 * @return the attachment that was removed
	 * @throws NoSuchAttachmentException if a attachment with the primary key could not be found
	 */
	public Attachment remove(long attachmentId)
		throws NoSuchAttachmentException;

	public Attachment updateImpl(Attachment attachment);

	/**
	 * Returns the attachment with the primary key or throws a <code>NoSuchAttachmentException</code> if it could not be found.
	 *
	 * @param attachmentId the primary key of the attachment
	 * @return the attachment
	 * @throws NoSuchAttachmentException if a attachment with the primary key could not be found
	 */
	public Attachment findByPrimaryKey(long attachmentId)
		throws NoSuchAttachmentException;

	/**
	 * Returns the attachment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attachmentId the primary key of the attachment
	 * @return the attachment, or <code>null</code> if a attachment with the primary key could not be found
	 */
	public Attachment fetchByPrimaryKey(long attachmentId);

	/**
	 * Returns all the attachments.
	 *
	 * @return the attachments
	 */
	public java.util.List<Attachment> findAll();

	/**
	 * Returns a range of all the attachments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attachments
	 * @param end the upper bound of the range of attachments (not inclusive)
	 * @return the range of attachments
	 */
	public java.util.List<Attachment> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the attachments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attachments
	 * @param end the upper bound of the range of attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of attachments
	 */
	public java.util.List<Attachment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Attachment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the attachments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attachments
	 * @param end the upper bound of the range of attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of attachments
	 */
	public java.util.List<Attachment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Attachment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the attachments from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of attachments.
	 *
	 * @return the number of attachments
	 */
	public int countAll();

}