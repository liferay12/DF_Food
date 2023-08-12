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

import bd.gov.dgfood.common.services.exception.NoSuchGrievanceException;
import bd.gov.dgfood.common.services.model.Grievance;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the grievance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GrievanceUtil
 * @generated
 */
@ProviderType
public interface GrievancePersistence extends BasePersistence<Grievance> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GrievanceUtil} to access the grievance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the grievances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching grievances
	 */
	public java.util.List<Grievance> findByUuid(String uuid);

	/**
	 * Returns a range of all the grievances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrievanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of grievances
	 * @param end the upper bound of the range of grievances (not inclusive)
	 * @return the range of matching grievances
	 */
	public java.util.List<Grievance> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the grievances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrievanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of grievances
	 * @param end the upper bound of the range of grievances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching grievances
	 */
	public java.util.List<Grievance> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Grievance>
			orderByComparator);

	/**
	 * Returns an ordered range of all the grievances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrievanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of grievances
	 * @param end the upper bound of the range of grievances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching grievances
	 */
	public java.util.List<Grievance> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Grievance>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first grievance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching grievance
	 * @throws NoSuchGrievanceException if a matching grievance could not be found
	 */
	public Grievance findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Grievance>
				orderByComparator)
		throws NoSuchGrievanceException;

	/**
	 * Returns the first grievance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching grievance, or <code>null</code> if a matching grievance could not be found
	 */
	public Grievance fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Grievance>
			orderByComparator);

	/**
	 * Returns the last grievance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching grievance
	 * @throws NoSuchGrievanceException if a matching grievance could not be found
	 */
	public Grievance findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Grievance>
				orderByComparator)
		throws NoSuchGrievanceException;

	/**
	 * Returns the last grievance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching grievance, or <code>null</code> if a matching grievance could not be found
	 */
	public Grievance fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Grievance>
			orderByComparator);

	/**
	 * Returns the grievances before and after the current grievance in the ordered set where uuid = &#63;.
	 *
	 * @param grievanceId the primary key of the current grievance
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next grievance
	 * @throws NoSuchGrievanceException if a grievance with the primary key could not be found
	 */
	public Grievance[] findByUuid_PrevAndNext(
			long grievanceId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Grievance>
				orderByComparator)
		throws NoSuchGrievanceException;

	/**
	 * Removes all the grievances where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of grievances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching grievances
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the grievance where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchGrievanceException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching grievance
	 * @throws NoSuchGrievanceException if a matching grievance could not be found
	 */
	public Grievance findByUUID_G(String uuid, long groupId)
		throws NoSuchGrievanceException;

	/**
	 * Returns the grievance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching grievance, or <code>null</code> if a matching grievance could not be found
	 */
	public Grievance fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the grievance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching grievance, or <code>null</code> if a matching grievance could not be found
	 */
	public Grievance fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the grievance where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the grievance that was removed
	 */
	public Grievance removeByUUID_G(String uuid, long groupId)
		throws NoSuchGrievanceException;

	/**
	 * Returns the number of grievances where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching grievances
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the grievances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching grievances
	 */
	public java.util.List<Grievance> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the grievances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrievanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of grievances
	 * @param end the upper bound of the range of grievances (not inclusive)
	 * @return the range of matching grievances
	 */
	public java.util.List<Grievance> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the grievances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrievanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of grievances
	 * @param end the upper bound of the range of grievances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching grievances
	 */
	public java.util.List<Grievance> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Grievance>
			orderByComparator);

	/**
	 * Returns an ordered range of all the grievances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrievanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of grievances
	 * @param end the upper bound of the range of grievances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching grievances
	 */
	public java.util.List<Grievance> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Grievance>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first grievance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching grievance
	 * @throws NoSuchGrievanceException if a matching grievance could not be found
	 */
	public Grievance findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Grievance>
				orderByComparator)
		throws NoSuchGrievanceException;

	/**
	 * Returns the first grievance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching grievance, or <code>null</code> if a matching grievance could not be found
	 */
	public Grievance fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Grievance>
			orderByComparator);

	/**
	 * Returns the last grievance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching grievance
	 * @throws NoSuchGrievanceException if a matching grievance could not be found
	 */
	public Grievance findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Grievance>
				orderByComparator)
		throws NoSuchGrievanceException;

	/**
	 * Returns the last grievance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching grievance, or <code>null</code> if a matching grievance could not be found
	 */
	public Grievance fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Grievance>
			orderByComparator);

	/**
	 * Returns the grievances before and after the current grievance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param grievanceId the primary key of the current grievance
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next grievance
	 * @throws NoSuchGrievanceException if a grievance with the primary key could not be found
	 */
	public Grievance[] findByUuid_C_PrevAndNext(
			long grievanceId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Grievance>
				orderByComparator)
		throws NoSuchGrievanceException;

	/**
	 * Removes all the grievances where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of grievances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching grievances
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the grievance in the entity cache if it is enabled.
	 *
	 * @param grievance the grievance
	 */
	public void cacheResult(Grievance grievance);

	/**
	 * Caches the grievances in the entity cache if it is enabled.
	 *
	 * @param grievances the grievances
	 */
	public void cacheResult(java.util.List<Grievance> grievances);

	/**
	 * Creates a new grievance with the primary key. Does not add the grievance to the database.
	 *
	 * @param grievanceId the primary key for the new grievance
	 * @return the new grievance
	 */
	public Grievance create(long grievanceId);

	/**
	 * Removes the grievance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param grievanceId the primary key of the grievance
	 * @return the grievance that was removed
	 * @throws NoSuchGrievanceException if a grievance with the primary key could not be found
	 */
	public Grievance remove(long grievanceId) throws NoSuchGrievanceException;

	public Grievance updateImpl(Grievance grievance);

	/**
	 * Returns the grievance with the primary key or throws a <code>NoSuchGrievanceException</code> if it could not be found.
	 *
	 * @param grievanceId the primary key of the grievance
	 * @return the grievance
	 * @throws NoSuchGrievanceException if a grievance with the primary key could not be found
	 */
	public Grievance findByPrimaryKey(long grievanceId)
		throws NoSuchGrievanceException;

	/**
	 * Returns the grievance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param grievanceId the primary key of the grievance
	 * @return the grievance, or <code>null</code> if a grievance with the primary key could not be found
	 */
	public Grievance fetchByPrimaryKey(long grievanceId);

	/**
	 * Returns all the grievances.
	 *
	 * @return the grievances
	 */
	public java.util.List<Grievance> findAll();

	/**
	 * Returns a range of all the grievances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrievanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of grievances
	 * @param end the upper bound of the range of grievances (not inclusive)
	 * @return the range of grievances
	 */
	public java.util.List<Grievance> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the grievances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrievanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of grievances
	 * @param end the upper bound of the range of grievances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of grievances
	 */
	public java.util.List<Grievance> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Grievance>
			orderByComparator);

	/**
	 * Returns an ordered range of all the grievances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrievanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of grievances
	 * @param end the upper bound of the range of grievances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of grievances
	 */
	public java.util.List<Grievance> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Grievance>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the grievances from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of grievances.
	 *
	 * @return the number of grievances
	 */
	public int countAll();

}