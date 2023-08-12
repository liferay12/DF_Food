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

package bd.gov.dgfood.food.friendly.program.service.persistence;

import bd.gov.dgfood.food.friendly.program.exception.NoSuchFFPBeneficiaryException;
import bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ffp beneficiary service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FFPBeneficiaryUtil
 * @generated
 */
@ProviderType
public interface FFPBeneficiaryPersistence
	extends BasePersistence<FFPBeneficiary> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FFPBeneficiaryUtil} to access the ffp beneficiary persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the ffp beneficiaries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ffp beneficiaries
	 */
	public java.util.List<FFPBeneficiary> findByUuid(String uuid);

	/**
	 * Returns a range of all the ffp beneficiaries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ffp beneficiaries
	 * @param end the upper bound of the range of ffp beneficiaries (not inclusive)
	 * @return the range of matching ffp beneficiaries
	 */
	public java.util.List<FFPBeneficiary> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the ffp beneficiaries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ffp beneficiaries
	 * @param end the upper bound of the range of ffp beneficiaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ffp beneficiaries
	 */
	public java.util.List<FFPBeneficiary> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FFPBeneficiary>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ffp beneficiaries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ffp beneficiaries
	 * @param end the upper bound of the range of ffp beneficiaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ffp beneficiaries
	 */
	public java.util.List<FFPBeneficiary> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FFPBeneficiary>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ffp beneficiary in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a matching ffp beneficiary could not be found
	 */
	public FFPBeneficiary findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FFPBeneficiary>
				orderByComparator)
		throws NoSuchFFPBeneficiaryException;

	/**
	 * Returns the first ffp beneficiary in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	public FFPBeneficiary fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FFPBeneficiary>
			orderByComparator);

	/**
	 * Returns the last ffp beneficiary in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a matching ffp beneficiary could not be found
	 */
	public FFPBeneficiary findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FFPBeneficiary>
				orderByComparator)
		throws NoSuchFFPBeneficiaryException;

	/**
	 * Returns the last ffp beneficiary in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	public FFPBeneficiary fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FFPBeneficiary>
			orderByComparator);

	/**
	 * Returns the ffp beneficiaries before and after the current ffp beneficiary in the ordered set where uuid = &#63;.
	 *
	 * @param beneficiaryId the primary key of the current ffp beneficiary
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a ffp beneficiary with the primary key could not be found
	 */
	public FFPBeneficiary[] findByUuid_PrevAndNext(
			long beneficiaryId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FFPBeneficiary>
				orderByComparator)
		throws NoSuchFFPBeneficiaryException;

	/**
	 * Removes all the ffp beneficiaries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of ffp beneficiaries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ffp beneficiaries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the ffp beneficiary where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFFPBeneficiaryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a matching ffp beneficiary could not be found
	 */
	public FFPBeneficiary findByUUID_G(String uuid, long groupId)
		throws NoSuchFFPBeneficiaryException;

	/**
	 * Returns the ffp beneficiary where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	public FFPBeneficiary fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the ffp beneficiary where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	public FFPBeneficiary fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the ffp beneficiary where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ffp beneficiary that was removed
	 */
	public FFPBeneficiary removeByUUID_G(String uuid, long groupId)
		throws NoSuchFFPBeneficiaryException;

	/**
	 * Returns the number of ffp beneficiaries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ffp beneficiaries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the ffp beneficiaries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ffp beneficiaries
	 */
	public java.util.List<FFPBeneficiary> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the ffp beneficiaries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ffp beneficiaries
	 * @param end the upper bound of the range of ffp beneficiaries (not inclusive)
	 * @return the range of matching ffp beneficiaries
	 */
	public java.util.List<FFPBeneficiary> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the ffp beneficiaries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ffp beneficiaries
	 * @param end the upper bound of the range of ffp beneficiaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ffp beneficiaries
	 */
	public java.util.List<FFPBeneficiary> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FFPBeneficiary>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ffp beneficiaries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ffp beneficiaries
	 * @param end the upper bound of the range of ffp beneficiaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ffp beneficiaries
	 */
	public java.util.List<FFPBeneficiary> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FFPBeneficiary>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ffp beneficiary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a matching ffp beneficiary could not be found
	 */
	public FFPBeneficiary findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FFPBeneficiary>
				orderByComparator)
		throws NoSuchFFPBeneficiaryException;

	/**
	 * Returns the first ffp beneficiary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	public FFPBeneficiary fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FFPBeneficiary>
			orderByComparator);

	/**
	 * Returns the last ffp beneficiary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a matching ffp beneficiary could not be found
	 */
	public FFPBeneficiary findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FFPBeneficiary>
				orderByComparator)
		throws NoSuchFFPBeneficiaryException;

	/**
	 * Returns the last ffp beneficiary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	public FFPBeneficiary fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FFPBeneficiary>
			orderByComparator);

	/**
	 * Returns the ffp beneficiaries before and after the current ffp beneficiary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param beneficiaryId the primary key of the current ffp beneficiary
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a ffp beneficiary with the primary key could not be found
	 */
	public FFPBeneficiary[] findByUuid_C_PrevAndNext(
			long beneficiaryId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FFPBeneficiary>
				orderByComparator)
		throws NoSuchFFPBeneficiaryException;

	/**
	 * Removes all the ffp beneficiaries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of ffp beneficiaries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ffp beneficiaries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the ffp beneficiary where nationalId = &#63; or throws a <code>NoSuchFFPBeneficiaryException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a matching ffp beneficiary could not be found
	 */
	public FFPBeneficiary findByNationalId(long nationalId)
		throws NoSuchFFPBeneficiaryException;

	/**
	 * Returns the ffp beneficiary where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	public FFPBeneficiary fetchByNationalId(long nationalId);

	/**
	 * Returns the ffp beneficiary where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	public FFPBeneficiary fetchByNationalId(
		long nationalId, boolean useFinderCache);

	/**
	 * Removes the ffp beneficiary where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the ffp beneficiary that was removed
	 */
	public FFPBeneficiary removeByNationalId(long nationalId)
		throws NoSuchFFPBeneficiaryException;

	/**
	 * Returns the number of ffp beneficiaries where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching ffp beneficiaries
	 */
	public int countByNationalId(long nationalId);

	/**
	 * Returns the ffp beneficiary where cardNumber = &#63; and dateOfBirth = &#63; or throws a <code>NoSuchFFPBeneficiaryException</code> if it could not be found.
	 *
	 * @param cardNumber the card number
	 * @param dateOfBirth the date of birth
	 * @return the matching ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a matching ffp beneficiary could not be found
	 */
	public FFPBeneficiary findByCard_Dob(String cardNumber, Date dateOfBirth)
		throws NoSuchFFPBeneficiaryException;

	/**
	 * Returns the ffp beneficiary where cardNumber = &#63; and dateOfBirth = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cardNumber the card number
	 * @param dateOfBirth the date of birth
	 * @return the matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	public FFPBeneficiary fetchByCard_Dob(String cardNumber, Date dateOfBirth);

	/**
	 * Returns the ffp beneficiary where cardNumber = &#63; and dateOfBirth = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cardNumber the card number
	 * @param dateOfBirth the date of birth
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	public FFPBeneficiary fetchByCard_Dob(
		String cardNumber, Date dateOfBirth, boolean useFinderCache);

	/**
	 * Removes the ffp beneficiary where cardNumber = &#63; and dateOfBirth = &#63; from the database.
	 *
	 * @param cardNumber the card number
	 * @param dateOfBirth the date of birth
	 * @return the ffp beneficiary that was removed
	 */
	public FFPBeneficiary removeByCard_Dob(String cardNumber, Date dateOfBirth)
		throws NoSuchFFPBeneficiaryException;

	/**
	 * Returns the number of ffp beneficiaries where cardNumber = &#63; and dateOfBirth = &#63;.
	 *
	 * @param cardNumber the card number
	 * @param dateOfBirth the date of birth
	 * @return the number of matching ffp beneficiaries
	 */
	public int countByCard_Dob(String cardNumber, Date dateOfBirth);

	/**
	 * Returns the ffp beneficiary where beneficiaryId = &#63; and dateOfBirth = &#63; or throws a <code>NoSuchFFPBeneficiaryException</code> if it could not be found.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param dateOfBirth the date of birth
	 * @return the matching ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a matching ffp beneficiary could not be found
	 */
	public FFPBeneficiary findById_Dob(long beneficiaryId, Date dateOfBirth)
		throws NoSuchFFPBeneficiaryException;

	/**
	 * Returns the ffp beneficiary where beneficiaryId = &#63; and dateOfBirth = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param dateOfBirth the date of birth
	 * @return the matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	public FFPBeneficiary fetchById_Dob(long beneficiaryId, Date dateOfBirth);

	/**
	 * Returns the ffp beneficiary where beneficiaryId = &#63; and dateOfBirth = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param dateOfBirth the date of birth
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	public FFPBeneficiary fetchById_Dob(
		long beneficiaryId, Date dateOfBirth, boolean useFinderCache);

	/**
	 * Removes the ffp beneficiary where beneficiaryId = &#63; and dateOfBirth = &#63; from the database.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param dateOfBirth the date of birth
	 * @return the ffp beneficiary that was removed
	 */
	public FFPBeneficiary removeById_Dob(long beneficiaryId, Date dateOfBirth)
		throws NoSuchFFPBeneficiaryException;

	/**
	 * Returns the number of ffp beneficiaries where beneficiaryId = &#63; and dateOfBirth = &#63;.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param dateOfBirth the date of birth
	 * @return the number of matching ffp beneficiaries
	 */
	public int countById_Dob(long beneficiaryId, Date dateOfBirth);

	/**
	 * Caches the ffp beneficiary in the entity cache if it is enabled.
	 *
	 * @param ffpBeneficiary the ffp beneficiary
	 */
	public void cacheResult(FFPBeneficiary ffpBeneficiary);

	/**
	 * Caches the ffp beneficiaries in the entity cache if it is enabled.
	 *
	 * @param ffpBeneficiaries the ffp beneficiaries
	 */
	public void cacheResult(java.util.List<FFPBeneficiary> ffpBeneficiaries);

	/**
	 * Creates a new ffp beneficiary with the primary key. Does not add the ffp beneficiary to the database.
	 *
	 * @param beneficiaryId the primary key for the new ffp beneficiary
	 * @return the new ffp beneficiary
	 */
	public FFPBeneficiary create(long beneficiaryId);

	/**
	 * Removes the ffp beneficiary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param beneficiaryId the primary key of the ffp beneficiary
	 * @return the ffp beneficiary that was removed
	 * @throws NoSuchFFPBeneficiaryException if a ffp beneficiary with the primary key could not be found
	 */
	public FFPBeneficiary remove(long beneficiaryId)
		throws NoSuchFFPBeneficiaryException;

	public FFPBeneficiary updateImpl(FFPBeneficiary ffpBeneficiary);

	/**
	 * Returns the ffp beneficiary with the primary key or throws a <code>NoSuchFFPBeneficiaryException</code> if it could not be found.
	 *
	 * @param beneficiaryId the primary key of the ffp beneficiary
	 * @return the ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a ffp beneficiary with the primary key could not be found
	 */
	public FFPBeneficiary findByPrimaryKey(long beneficiaryId)
		throws NoSuchFFPBeneficiaryException;

	/**
	 * Returns the ffp beneficiary with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param beneficiaryId the primary key of the ffp beneficiary
	 * @return the ffp beneficiary, or <code>null</code> if a ffp beneficiary with the primary key could not be found
	 */
	public FFPBeneficiary fetchByPrimaryKey(long beneficiaryId);

	/**
	 * Returns all the ffp beneficiaries.
	 *
	 * @return the ffp beneficiaries
	 */
	public java.util.List<FFPBeneficiary> findAll();

	/**
	 * Returns a range of all the ffp beneficiaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ffp beneficiaries
	 * @param end the upper bound of the range of ffp beneficiaries (not inclusive)
	 * @return the range of ffp beneficiaries
	 */
	public java.util.List<FFPBeneficiary> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the ffp beneficiaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ffp beneficiaries
	 * @param end the upper bound of the range of ffp beneficiaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ffp beneficiaries
	 */
	public java.util.List<FFPBeneficiary> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FFPBeneficiary>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ffp beneficiaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ffp beneficiaries
	 * @param end the upper bound of the range of ffp beneficiaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ffp beneficiaries
	 */
	public java.util.List<FFPBeneficiary> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FFPBeneficiary>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ffp beneficiaries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ffp beneficiaries.
	 *
	 * @return the number of ffp beneficiaries
	 */
	public int countAll();

}