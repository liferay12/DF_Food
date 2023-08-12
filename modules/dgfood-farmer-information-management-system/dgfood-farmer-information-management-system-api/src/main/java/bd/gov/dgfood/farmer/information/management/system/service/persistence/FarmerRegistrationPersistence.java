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

package bd.gov.dgfood.farmer.information.management.system.service.persistence;

import bd.gov.dgfood.farmer.information.management.system.exception.NoSuchFarmerRegistrationException;
import bd.gov.dgfood.farmer.information.management.system.model.FarmerRegistration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the farmer registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FarmerRegistrationUtil
 * @generated
 */
@ProviderType
public interface FarmerRegistrationPersistence
	extends BasePersistence<FarmerRegistration> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FarmerRegistrationUtil} to access the farmer registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the farmer registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching farmer registrations
	 */
	public java.util.List<FarmerRegistration> findByUuid(String uuid);

	/**
	 * Returns a range of all the farmer registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of farmer registrations
	 * @param end the upper bound of the range of farmer registrations (not inclusive)
	 * @return the range of matching farmer registrations
	 */
	public java.util.List<FarmerRegistration> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the farmer registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of farmer registrations
	 * @param end the upper bound of the range of farmer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching farmer registrations
	 */
	public java.util.List<FarmerRegistration> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FarmerRegistration>
			orderByComparator);

	/**
	 * Returns an ordered range of all the farmer registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of farmer registrations
	 * @param end the upper bound of the range of farmer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching farmer registrations
	 */
	public java.util.List<FarmerRegistration> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FarmerRegistration>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first farmer registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	public FarmerRegistration findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FarmerRegistration>
				orderByComparator)
		throws NoSuchFarmerRegistrationException;

	/**
	 * Returns the first farmer registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public FarmerRegistration fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FarmerRegistration>
			orderByComparator);

	/**
	 * Returns the last farmer registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	public FarmerRegistration findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FarmerRegistration>
				orderByComparator)
		throws NoSuchFarmerRegistrationException;

	/**
	 * Returns the last farmer registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public FarmerRegistration fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FarmerRegistration>
			orderByComparator);

	/**
	 * Returns the farmer registrations before and after the current farmer registration in the ordered set where uuid = &#63;.
	 *
	 * @param farmerRegistrationId the primary key of the current farmer registration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next farmer registration
	 * @throws NoSuchFarmerRegistrationException if a farmer registration with the primary key could not be found
	 */
	public FarmerRegistration[] findByUuid_PrevAndNext(
			long farmerRegistrationId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FarmerRegistration>
				orderByComparator)
		throws NoSuchFarmerRegistrationException;

	/**
	 * Removes all the farmer registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of farmer registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching farmer registrations
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the farmer registration where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFarmerRegistrationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	public FarmerRegistration findByUUID_G(String uuid, long groupId)
		throws NoSuchFarmerRegistrationException;

	/**
	 * Returns the farmer registration where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public FarmerRegistration fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the farmer registration where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public FarmerRegistration fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the farmer registration where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the farmer registration that was removed
	 */
	public FarmerRegistration removeByUUID_G(String uuid, long groupId)
		throws NoSuchFarmerRegistrationException;

	/**
	 * Returns the number of farmer registrations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching farmer registrations
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the farmer registrations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching farmer registrations
	 */
	public java.util.List<FarmerRegistration> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the farmer registrations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of farmer registrations
	 * @param end the upper bound of the range of farmer registrations (not inclusive)
	 * @return the range of matching farmer registrations
	 */
	public java.util.List<FarmerRegistration> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the farmer registrations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of farmer registrations
	 * @param end the upper bound of the range of farmer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching farmer registrations
	 */
	public java.util.List<FarmerRegistration> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FarmerRegistration>
			orderByComparator);

	/**
	 * Returns an ordered range of all the farmer registrations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of farmer registrations
	 * @param end the upper bound of the range of farmer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching farmer registrations
	 */
	public java.util.List<FarmerRegistration> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FarmerRegistration>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first farmer registration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	public FarmerRegistration findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FarmerRegistration>
				orderByComparator)
		throws NoSuchFarmerRegistrationException;

	/**
	 * Returns the first farmer registration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public FarmerRegistration fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FarmerRegistration>
			orderByComparator);

	/**
	 * Returns the last farmer registration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	public FarmerRegistration findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FarmerRegistration>
				orderByComparator)
		throws NoSuchFarmerRegistrationException;

	/**
	 * Returns the last farmer registration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public FarmerRegistration fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FarmerRegistration>
			orderByComparator);

	/**
	 * Returns the farmer registrations before and after the current farmer registration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param farmerRegistrationId the primary key of the current farmer registration
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next farmer registration
	 * @throws NoSuchFarmerRegistrationException if a farmer registration with the primary key could not be found
	 */
	public FarmerRegistration[] findByUuid_C_PrevAndNext(
			long farmerRegistrationId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FarmerRegistration>
				orderByComparator)
		throws NoSuchFarmerRegistrationException;

	/**
	 * Removes all the farmer registrations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of farmer registrations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching farmer registrations
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the farmer registration where nationalId = &#63; or throws a <code>NoSuchFarmerRegistrationException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	public FarmerRegistration findByNationalId(String nationalId)
		throws NoSuchFarmerRegistrationException;

	/**
	 * Returns the farmer registration where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public FarmerRegistration fetchByNationalId(String nationalId);

	/**
	 * Returns the farmer registration where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public FarmerRegistration fetchByNationalId(
		String nationalId, boolean useFinderCache);

	/**
	 * Removes the farmer registration where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the farmer registration that was removed
	 */
	public FarmerRegistration removeByNationalId(String nationalId)
		throws NoSuchFarmerRegistrationException;

	/**
	 * Returns the number of farmer registrations where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching farmer registrations
	 */
	public int countByNationalId(String nationalId);

	/**
	 * Returns the farmer registration where applicationNumber = &#63; or throws a <code>NoSuchFarmerRegistrationException</code> if it could not be found.
	 *
	 * @param applicationNumber the application number
	 * @return the matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	public FarmerRegistration findByApplicationNumber(String applicationNumber)
		throws NoSuchFarmerRegistrationException;

	/**
	 * Returns the farmer registration where applicationNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public FarmerRegistration fetchByApplicationNumber(
		String applicationNumber);

	/**
	 * Returns the farmer registration where applicationNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public FarmerRegistration fetchByApplicationNumber(
		String applicationNumber, boolean useFinderCache);

	/**
	 * Removes the farmer registration where applicationNumber = &#63; from the database.
	 *
	 * @param applicationNumber the application number
	 * @return the farmer registration that was removed
	 */
	public FarmerRegistration removeByApplicationNumber(
			String applicationNumber)
		throws NoSuchFarmerRegistrationException;

	/**
	 * Returns the number of farmer registrations where applicationNumber = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @return the number of matching farmer registrations
	 */
	public int countByApplicationNumber(String applicationNumber);

	/**
	 * Returns the farmer registration where applicationNumber = &#63; and dateOfBirth = &#63; or throws a <code>NoSuchFarmerRegistrationException</code> if it could not be found.
	 *
	 * @param applicationNumber the application number
	 * @param dateOfBirth the date of birth
	 * @return the matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	public FarmerRegistration findByApplicationNumberDob(
			String applicationNumber, Date dateOfBirth)
		throws NoSuchFarmerRegistrationException;

	/**
	 * Returns the farmer registration where applicationNumber = &#63; and dateOfBirth = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @param dateOfBirth the date of birth
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public FarmerRegistration fetchByApplicationNumberDob(
		String applicationNumber, Date dateOfBirth);

	/**
	 * Returns the farmer registration where applicationNumber = &#63; and dateOfBirth = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @param dateOfBirth the date of birth
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public FarmerRegistration fetchByApplicationNumberDob(
		String applicationNumber, Date dateOfBirth, boolean useFinderCache);

	/**
	 * Removes the farmer registration where applicationNumber = &#63; and dateOfBirth = &#63; from the database.
	 *
	 * @param applicationNumber the application number
	 * @param dateOfBirth the date of birth
	 * @return the farmer registration that was removed
	 */
	public FarmerRegistration removeByApplicationNumberDob(
			String applicationNumber, Date dateOfBirth)
		throws NoSuchFarmerRegistrationException;

	/**
	 * Returns the number of farmer registrations where applicationNumber = &#63; and dateOfBirth = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @param dateOfBirth the date of birth
	 * @return the number of matching farmer registrations
	 */
	public int countByApplicationNumberDob(
		String applicationNumber, Date dateOfBirth);

	/**
	 * Returns the farmer registration where nationalId = &#63; and dateOfBirth = &#63; or throws a <code>NoSuchFarmerRegistrationException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @param dateOfBirth the date of birth
	 * @return the matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	public FarmerRegistration findByNationalIdDob(
			String nationalId, Date dateOfBirth)
		throws NoSuchFarmerRegistrationException;

	/**
	 * Returns the farmer registration where nationalId = &#63; and dateOfBirth = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param dateOfBirth the date of birth
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public FarmerRegistration fetchByNationalIdDob(
		String nationalId, Date dateOfBirth);

	/**
	 * Returns the farmer registration where nationalId = &#63; and dateOfBirth = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param dateOfBirth the date of birth
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public FarmerRegistration fetchByNationalIdDob(
		String nationalId, Date dateOfBirth, boolean useFinderCache);

	/**
	 * Removes the farmer registration where nationalId = &#63; and dateOfBirth = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @param dateOfBirth the date of birth
	 * @return the farmer registration that was removed
	 */
	public FarmerRegistration removeByNationalIdDob(
			String nationalId, Date dateOfBirth)
		throws NoSuchFarmerRegistrationException;

	/**
	 * Returns the number of farmer registrations where nationalId = &#63; and dateOfBirth = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param dateOfBirth the date of birth
	 * @return the number of matching farmer registrations
	 */
	public int countByNationalIdDob(String nationalId, Date dateOfBirth);

	/**
	 * Returns the farmer registration where krishokCardNumber = &#63; or throws a <code>NoSuchFarmerRegistrationException</code> if it could not be found.
	 *
	 * @param krishokCardNumber the krishok card number
	 * @return the matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	public FarmerRegistration findByKrishokCard(String krishokCardNumber)
		throws NoSuchFarmerRegistrationException;

	/**
	 * Returns the farmer registration where krishokCardNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param krishokCardNumber the krishok card number
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public FarmerRegistration fetchByKrishokCard(String krishokCardNumber);

	/**
	 * Returns the farmer registration where krishokCardNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param krishokCardNumber the krishok card number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public FarmerRegistration fetchByKrishokCard(
		String krishokCardNumber, boolean useFinderCache);

	/**
	 * Removes the farmer registration where krishokCardNumber = &#63; from the database.
	 *
	 * @param krishokCardNumber the krishok card number
	 * @return the farmer registration that was removed
	 */
	public FarmerRegistration removeByKrishokCard(String krishokCardNumber)
		throws NoSuchFarmerRegistrationException;

	/**
	 * Returns the number of farmer registrations where krishokCardNumber = &#63;.
	 *
	 * @param krishokCardNumber the krishok card number
	 * @return the number of matching farmer registrations
	 */
	public int countByKrishokCard(String krishokCardNumber);

	/**
	 * Returns the farmer registration where businessCode = &#63; or throws a <code>NoSuchFarmerRegistrationException</code> if it could not be found.
	 *
	 * @param businessCode the business code
	 * @return the matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	public FarmerRegistration findByBusinessCode(String businessCode)
		throws NoSuchFarmerRegistrationException;

	/**
	 * Returns the farmer registration where businessCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param businessCode the business code
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public FarmerRegistration fetchByBusinessCode(String businessCode);

	/**
	 * Returns the farmer registration where businessCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param businessCode the business code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public FarmerRegistration fetchByBusinessCode(
		String businessCode, boolean useFinderCache);

	/**
	 * Removes the farmer registration where businessCode = &#63; from the database.
	 *
	 * @param businessCode the business code
	 * @return the farmer registration that was removed
	 */
	public FarmerRegistration removeByBusinessCode(String businessCode)
		throws NoSuchFarmerRegistrationException;

	/**
	 * Returns the number of farmer registrations where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @return the number of matching farmer registrations
	 */
	public int countByBusinessCode(String businessCode);

	/**
	 * Returns the farmer registration where userId = &#63; or throws a <code>NoSuchFarmerRegistrationException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	public FarmerRegistration findByUserId(long userId)
		throws NoSuchFarmerRegistrationException;

	/**
	 * Returns the farmer registration where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public FarmerRegistration fetchByUserId(long userId);

	/**
	 * Returns the farmer registration where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	public FarmerRegistration fetchByUserId(
		long userId, boolean useFinderCache);

	/**
	 * Removes the farmer registration where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the farmer registration that was removed
	 */
	public FarmerRegistration removeByUserId(long userId)
		throws NoSuchFarmerRegistrationException;

	/**
	 * Returns the number of farmer registrations where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching farmer registrations
	 */
	public int countByUserId(long userId);

	/**
	 * Caches the farmer registration in the entity cache if it is enabled.
	 *
	 * @param farmerRegistration the farmer registration
	 */
	public void cacheResult(FarmerRegistration farmerRegistration);

	/**
	 * Caches the farmer registrations in the entity cache if it is enabled.
	 *
	 * @param farmerRegistrations the farmer registrations
	 */
	public void cacheResult(
		java.util.List<FarmerRegistration> farmerRegistrations);

	/**
	 * Creates a new farmer registration with the primary key. Does not add the farmer registration to the database.
	 *
	 * @param farmerRegistrationId the primary key for the new farmer registration
	 * @return the new farmer registration
	 */
	public FarmerRegistration create(long farmerRegistrationId);

	/**
	 * Removes the farmer registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param farmerRegistrationId the primary key of the farmer registration
	 * @return the farmer registration that was removed
	 * @throws NoSuchFarmerRegistrationException if a farmer registration with the primary key could not be found
	 */
	public FarmerRegistration remove(long farmerRegistrationId)
		throws NoSuchFarmerRegistrationException;

	public FarmerRegistration updateImpl(FarmerRegistration farmerRegistration);

	/**
	 * Returns the farmer registration with the primary key or throws a <code>NoSuchFarmerRegistrationException</code> if it could not be found.
	 *
	 * @param farmerRegistrationId the primary key of the farmer registration
	 * @return the farmer registration
	 * @throws NoSuchFarmerRegistrationException if a farmer registration with the primary key could not be found
	 */
	public FarmerRegistration findByPrimaryKey(long farmerRegistrationId)
		throws NoSuchFarmerRegistrationException;

	/**
	 * Returns the farmer registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param farmerRegistrationId the primary key of the farmer registration
	 * @return the farmer registration, or <code>null</code> if a farmer registration with the primary key could not be found
	 */
	public FarmerRegistration fetchByPrimaryKey(long farmerRegistrationId);

	/**
	 * Returns all the farmer registrations.
	 *
	 * @return the farmer registrations
	 */
	public java.util.List<FarmerRegistration> findAll();

	/**
	 * Returns a range of all the farmer registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of farmer registrations
	 * @param end the upper bound of the range of farmer registrations (not inclusive)
	 * @return the range of farmer registrations
	 */
	public java.util.List<FarmerRegistration> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the farmer registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of farmer registrations
	 * @param end the upper bound of the range of farmer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of farmer registrations
	 */
	public java.util.List<FarmerRegistration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FarmerRegistration>
			orderByComparator);

	/**
	 * Returns an ordered range of all the farmer registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of farmer registrations
	 * @param end the upper bound of the range of farmer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of farmer registrations
	 */
	public java.util.List<FarmerRegistration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FarmerRegistration>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the farmer registrations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of farmer registrations.
	 *
	 * @return the number of farmer registrations
	 */
	public int countAll();

}