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

import bd.gov.dgfood.common.services.exception.NoSuchIndentException;
import bd.gov.dgfood.common.services.model.Indent;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the indent service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IndentUtil
 * @generated
 */
@ProviderType
public interface IndentPersistence extends BasePersistence<Indent> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link IndentUtil} to access the indent persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the indents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching indents
	 */
	public java.util.List<Indent> findByUuid(String uuid);

	/**
	 * Returns a range of all the indents where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of indents
	 * @param end the upper bound of the range of indents (not inclusive)
	 * @return the range of matching indents
	 */
	public java.util.List<Indent> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the indents where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of indents
	 * @param end the upper bound of the range of indents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching indents
	 */
	public java.util.List<Indent> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Indent>
			orderByComparator);

	/**
	 * Returns an ordered range of all the indents where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of indents
	 * @param end the upper bound of the range of indents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching indents
	 */
	public java.util.List<Indent> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Indent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first indent in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching indent
	 * @throws NoSuchIndentException if a matching indent could not be found
	 */
	public Indent findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Indent>
				orderByComparator)
		throws NoSuchIndentException;

	/**
	 * Returns the first indent in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching indent, or <code>null</code> if a matching indent could not be found
	 */
	public Indent fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Indent>
			orderByComparator);

	/**
	 * Returns the last indent in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching indent
	 * @throws NoSuchIndentException if a matching indent could not be found
	 */
	public Indent findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Indent>
				orderByComparator)
		throws NoSuchIndentException;

	/**
	 * Returns the last indent in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching indent, or <code>null</code> if a matching indent could not be found
	 */
	public Indent fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Indent>
			orderByComparator);

	/**
	 * Returns the indents before and after the current indent in the ordered set where uuid = &#63;.
	 *
	 * @param indentId the primary key of the current indent
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next indent
	 * @throws NoSuchIndentException if a indent with the primary key could not be found
	 */
	public Indent[] findByUuid_PrevAndNext(
			long indentId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Indent>
				orderByComparator)
		throws NoSuchIndentException;

	/**
	 * Removes all the indents where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of indents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching indents
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the indent where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchIndentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching indent
	 * @throws NoSuchIndentException if a matching indent could not be found
	 */
	public Indent findByUUID_G(String uuid, long groupId)
		throws NoSuchIndentException;

	/**
	 * Returns the indent where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching indent, or <code>null</code> if a matching indent could not be found
	 */
	public Indent fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the indent where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching indent, or <code>null</code> if a matching indent could not be found
	 */
	public Indent fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the indent where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the indent that was removed
	 */
	public Indent removeByUUID_G(String uuid, long groupId)
		throws NoSuchIndentException;

	/**
	 * Returns the number of indents where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching indents
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the indents where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching indents
	 */
	public java.util.List<Indent> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the indents where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of indents
	 * @param end the upper bound of the range of indents (not inclusive)
	 * @return the range of matching indents
	 */
	public java.util.List<Indent> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the indents where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of indents
	 * @param end the upper bound of the range of indents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching indents
	 */
	public java.util.List<Indent> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Indent>
			orderByComparator);

	/**
	 * Returns an ordered range of all the indents where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of indents
	 * @param end the upper bound of the range of indents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching indents
	 */
	public java.util.List<Indent> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Indent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first indent in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching indent
	 * @throws NoSuchIndentException if a matching indent could not be found
	 */
	public Indent findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Indent>
				orderByComparator)
		throws NoSuchIndentException;

	/**
	 * Returns the first indent in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching indent, or <code>null</code> if a matching indent could not be found
	 */
	public Indent fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Indent>
			orderByComparator);

	/**
	 * Returns the last indent in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching indent
	 * @throws NoSuchIndentException if a matching indent could not be found
	 */
	public Indent findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Indent>
				orderByComparator)
		throws NoSuchIndentException;

	/**
	 * Returns the last indent in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching indent, or <code>null</code> if a matching indent could not be found
	 */
	public Indent fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Indent>
			orderByComparator);

	/**
	 * Returns the indents before and after the current indent in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param indentId the primary key of the current indent
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next indent
	 * @throws NoSuchIndentException if a indent with the primary key could not be found
	 */
	public Indent[] findByUuid_C_PrevAndNext(
			long indentId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Indent>
				orderByComparator)
		throws NoSuchIndentException;

	/**
	 * Removes all the indents where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of indents where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching indents
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the indents where allocationId = &#63;.
	 *
	 * @param allocationId the allocation ID
	 * @return the matching indents
	 */
	public java.util.List<Indent> findByAllocationId(long allocationId);

	/**
	 * Returns a range of all the indents where allocationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndentModelImpl</code>.
	 * </p>
	 *
	 * @param allocationId the allocation ID
	 * @param start the lower bound of the range of indents
	 * @param end the upper bound of the range of indents (not inclusive)
	 * @return the range of matching indents
	 */
	public java.util.List<Indent> findByAllocationId(
		long allocationId, int start, int end);

	/**
	 * Returns an ordered range of all the indents where allocationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndentModelImpl</code>.
	 * </p>
	 *
	 * @param allocationId the allocation ID
	 * @param start the lower bound of the range of indents
	 * @param end the upper bound of the range of indents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching indents
	 */
	public java.util.List<Indent> findByAllocationId(
		long allocationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Indent>
			orderByComparator);

	/**
	 * Returns an ordered range of all the indents where allocationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndentModelImpl</code>.
	 * </p>
	 *
	 * @param allocationId the allocation ID
	 * @param start the lower bound of the range of indents
	 * @param end the upper bound of the range of indents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching indents
	 */
	public java.util.List<Indent> findByAllocationId(
		long allocationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Indent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first indent in the ordered set where allocationId = &#63;.
	 *
	 * @param allocationId the allocation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching indent
	 * @throws NoSuchIndentException if a matching indent could not be found
	 */
	public Indent findByAllocationId_First(
			long allocationId,
			com.liferay.portal.kernel.util.OrderByComparator<Indent>
				orderByComparator)
		throws NoSuchIndentException;

	/**
	 * Returns the first indent in the ordered set where allocationId = &#63;.
	 *
	 * @param allocationId the allocation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching indent, or <code>null</code> if a matching indent could not be found
	 */
	public Indent fetchByAllocationId_First(
		long allocationId,
		com.liferay.portal.kernel.util.OrderByComparator<Indent>
			orderByComparator);

	/**
	 * Returns the last indent in the ordered set where allocationId = &#63;.
	 *
	 * @param allocationId the allocation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching indent
	 * @throws NoSuchIndentException if a matching indent could not be found
	 */
	public Indent findByAllocationId_Last(
			long allocationId,
			com.liferay.portal.kernel.util.OrderByComparator<Indent>
				orderByComparator)
		throws NoSuchIndentException;

	/**
	 * Returns the last indent in the ordered set where allocationId = &#63;.
	 *
	 * @param allocationId the allocation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching indent, or <code>null</code> if a matching indent could not be found
	 */
	public Indent fetchByAllocationId_Last(
		long allocationId,
		com.liferay.portal.kernel.util.OrderByComparator<Indent>
			orderByComparator);

	/**
	 * Returns the indents before and after the current indent in the ordered set where allocationId = &#63;.
	 *
	 * @param indentId the primary key of the current indent
	 * @param allocationId the allocation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next indent
	 * @throws NoSuchIndentException if a indent with the primary key could not be found
	 */
	public Indent[] findByAllocationId_PrevAndNext(
			long indentId, long allocationId,
			com.liferay.portal.kernel.util.OrderByComparator<Indent>
				orderByComparator)
		throws NoSuchIndentException;

	/**
	 * Removes all the indents where allocationId = &#63; from the database.
	 *
	 * @param allocationId the allocation ID
	 */
	public void removeByAllocationId(long allocationId);

	/**
	 * Returns the number of indents where allocationId = &#63;.
	 *
	 * @param allocationId the allocation ID
	 * @return the number of matching indents
	 */
	public int countByAllocationId(long allocationId);

	/**
	 * Caches the indent in the entity cache if it is enabled.
	 *
	 * @param indent the indent
	 */
	public void cacheResult(Indent indent);

	/**
	 * Caches the indents in the entity cache if it is enabled.
	 *
	 * @param indents the indents
	 */
	public void cacheResult(java.util.List<Indent> indents);

	/**
	 * Creates a new indent with the primary key. Does not add the indent to the database.
	 *
	 * @param indentId the primary key for the new indent
	 * @return the new indent
	 */
	public Indent create(long indentId);

	/**
	 * Removes the indent with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param indentId the primary key of the indent
	 * @return the indent that was removed
	 * @throws NoSuchIndentException if a indent with the primary key could not be found
	 */
	public Indent remove(long indentId) throws NoSuchIndentException;

	public Indent updateImpl(Indent indent);

	/**
	 * Returns the indent with the primary key or throws a <code>NoSuchIndentException</code> if it could not be found.
	 *
	 * @param indentId the primary key of the indent
	 * @return the indent
	 * @throws NoSuchIndentException if a indent with the primary key could not be found
	 */
	public Indent findByPrimaryKey(long indentId) throws NoSuchIndentException;

	/**
	 * Returns the indent with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param indentId the primary key of the indent
	 * @return the indent, or <code>null</code> if a indent with the primary key could not be found
	 */
	public Indent fetchByPrimaryKey(long indentId);

	/**
	 * Returns all the indents.
	 *
	 * @return the indents
	 */
	public java.util.List<Indent> findAll();

	/**
	 * Returns a range of all the indents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of indents
	 * @param end the upper bound of the range of indents (not inclusive)
	 * @return the range of indents
	 */
	public java.util.List<Indent> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the indents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of indents
	 * @param end the upper bound of the range of indents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of indents
	 */
	public java.util.List<Indent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Indent>
			orderByComparator);

	/**
	 * Returns an ordered range of all the indents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of indents
	 * @param end the upper bound of the range of indents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of indents
	 */
	public java.util.List<Indent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Indent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the indents from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of indents.
	 *
	 * @return the number of indents
	 */
	public int countAll();

}