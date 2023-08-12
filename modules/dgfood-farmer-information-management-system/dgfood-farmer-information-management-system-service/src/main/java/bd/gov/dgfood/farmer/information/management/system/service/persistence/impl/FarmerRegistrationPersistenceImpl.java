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

package bd.gov.dgfood.farmer.information.management.system.service.persistence.impl;

import bd.gov.dgfood.farmer.information.management.system.exception.NoSuchFarmerRegistrationException;
import bd.gov.dgfood.farmer.information.management.system.model.FarmerRegistration;
import bd.gov.dgfood.farmer.information.management.system.model.FarmerRegistrationTable;
import bd.gov.dgfood.farmer.information.management.system.model.impl.FarmerRegistrationImpl;
import bd.gov.dgfood.farmer.information.management.system.model.impl.FarmerRegistrationModelImpl;
import bd.gov.dgfood.farmer.information.management.system.service.persistence.FarmerRegistrationPersistence;
import bd.gov.dgfood.farmer.information.management.system.service.persistence.FarmerRegistrationUtil;
import bd.gov.dgfood.farmer.information.management.system.service.persistence.impl.constants.DGFOODPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the farmer registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {FarmerRegistrationPersistence.class, BasePersistence.class}
)
public class FarmerRegistrationPersistenceImpl
	extends BasePersistenceImpl<FarmerRegistration>
	implements FarmerRegistrationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FarmerRegistrationUtil</code> to access the farmer registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FarmerRegistrationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the farmer registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching farmer registrations
	 */
	@Override
	public List<FarmerRegistration> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<FarmerRegistration> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

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
	@Override
	public List<FarmerRegistration> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FarmerRegistration> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

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
	@Override
	public List<FarmerRegistration> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FarmerRegistration> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<FarmerRegistration> list = null;

		if (useFinderCache) {
			list = (List<FarmerRegistration>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FarmerRegistration farmerRegistration : list) {
					if (!uuid.equals(farmerRegistration.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_FARMERREGISTRATION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FarmerRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<FarmerRegistration>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first farmer registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	@Override
	public FarmerRegistration findByUuid_First(
			String uuid,
			OrderByComparator<FarmerRegistration> orderByComparator)
		throws NoSuchFarmerRegistrationException {

		FarmerRegistration farmerRegistration = fetchByUuid_First(
			uuid, orderByComparator);

		if (farmerRegistration != null) {
			return farmerRegistration;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFarmerRegistrationException(sb.toString());
	}

	/**
	 * Returns the first farmer registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	@Override
	public FarmerRegistration fetchByUuid_First(
		String uuid, OrderByComparator<FarmerRegistration> orderByComparator) {

		List<FarmerRegistration> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last farmer registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	@Override
	public FarmerRegistration findByUuid_Last(
			String uuid,
			OrderByComparator<FarmerRegistration> orderByComparator)
		throws NoSuchFarmerRegistrationException {

		FarmerRegistration farmerRegistration = fetchByUuid_Last(
			uuid, orderByComparator);

		if (farmerRegistration != null) {
			return farmerRegistration;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFarmerRegistrationException(sb.toString());
	}

	/**
	 * Returns the last farmer registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	@Override
	public FarmerRegistration fetchByUuid_Last(
		String uuid, OrderByComparator<FarmerRegistration> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<FarmerRegistration> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the farmer registrations before and after the current farmer registration in the ordered set where uuid = &#63;.
	 *
	 * @param farmerRegistrationId the primary key of the current farmer registration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next farmer registration
	 * @throws NoSuchFarmerRegistrationException if a farmer registration with the primary key could not be found
	 */
	@Override
	public FarmerRegistration[] findByUuid_PrevAndNext(
			long farmerRegistrationId, String uuid,
			OrderByComparator<FarmerRegistration> orderByComparator)
		throws NoSuchFarmerRegistrationException {

		uuid = Objects.toString(uuid, "");

		FarmerRegistration farmerRegistration = findByPrimaryKey(
			farmerRegistrationId);

		Session session = null;

		try {
			session = openSession();

			FarmerRegistration[] array = new FarmerRegistrationImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, farmerRegistration, uuid, orderByComparator, true);

			array[1] = farmerRegistration;

			array[2] = getByUuid_PrevAndNext(
				session, farmerRegistration, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FarmerRegistration getByUuid_PrevAndNext(
		Session session, FarmerRegistration farmerRegistration, String uuid,
		OrderByComparator<FarmerRegistration> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FARMERREGISTRATION_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(FarmerRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						farmerRegistration)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FarmerRegistration> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the farmer registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (FarmerRegistration farmerRegistration :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(farmerRegistration);
		}
	}

	/**
	 * Returns the number of farmer registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching farmer registrations
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FARMERREGISTRATION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"farmerRegistration.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(farmerRegistration.uuid IS NULL OR farmerRegistration.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the farmer registration where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFarmerRegistrationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	@Override
	public FarmerRegistration findByUUID_G(String uuid, long groupId)
		throws NoSuchFarmerRegistrationException {

		FarmerRegistration farmerRegistration = fetchByUUID_G(uuid, groupId);

		if (farmerRegistration == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFarmerRegistrationException(sb.toString());
		}

		return farmerRegistration;
	}

	/**
	 * Returns the farmer registration where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	@Override
	public FarmerRegistration fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the farmer registration where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	@Override
	public FarmerRegistration fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs);
		}

		if (result instanceof FarmerRegistration) {
			FarmerRegistration farmerRegistration = (FarmerRegistration)result;

			if (!Objects.equals(uuid, farmerRegistration.getUuid()) ||
				(groupId != farmerRegistration.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_FARMERREGISTRATION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<FarmerRegistration> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					FarmerRegistration farmerRegistration = list.get(0);

					result = farmerRegistration;

					cacheResult(farmerRegistration);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (FarmerRegistration)result;
		}
	}

	/**
	 * Removes the farmer registration where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the farmer registration that was removed
	 */
	@Override
	public FarmerRegistration removeByUUID_G(String uuid, long groupId)
		throws NoSuchFarmerRegistrationException {

		FarmerRegistration farmerRegistration = findByUUID_G(uuid, groupId);

		return remove(farmerRegistration);
	}

	/**
	 * Returns the number of farmer registrations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching farmer registrations
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FARMERREGISTRATION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"farmerRegistration.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(farmerRegistration.uuid IS NULL OR farmerRegistration.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"farmerRegistration.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the farmer registrations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching farmer registrations
	 */
	@Override
	public List<FarmerRegistration> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<FarmerRegistration> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

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
	@Override
	public List<FarmerRegistration> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FarmerRegistration> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<FarmerRegistration> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FarmerRegistration> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<FarmerRegistration> list = null;

		if (useFinderCache) {
			list = (List<FarmerRegistration>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FarmerRegistration farmerRegistration : list) {
					if (!uuid.equals(farmerRegistration.getUuid()) ||
						(companyId != farmerRegistration.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_FARMERREGISTRATION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FarmerRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<FarmerRegistration>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first farmer registration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	@Override
	public FarmerRegistration findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FarmerRegistration> orderByComparator)
		throws NoSuchFarmerRegistrationException {

		FarmerRegistration farmerRegistration = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (farmerRegistration != null) {
			return farmerRegistration;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFarmerRegistrationException(sb.toString());
	}

	/**
	 * Returns the first farmer registration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	@Override
	public FarmerRegistration fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FarmerRegistration> orderByComparator) {

		List<FarmerRegistration> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last farmer registration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	@Override
	public FarmerRegistration findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FarmerRegistration> orderByComparator)
		throws NoSuchFarmerRegistrationException {

		FarmerRegistration farmerRegistration = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (farmerRegistration != null) {
			return farmerRegistration;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFarmerRegistrationException(sb.toString());
	}

	/**
	 * Returns the last farmer registration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	@Override
	public FarmerRegistration fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FarmerRegistration> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<FarmerRegistration> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public FarmerRegistration[] findByUuid_C_PrevAndNext(
			long farmerRegistrationId, String uuid, long companyId,
			OrderByComparator<FarmerRegistration> orderByComparator)
		throws NoSuchFarmerRegistrationException {

		uuid = Objects.toString(uuid, "");

		FarmerRegistration farmerRegistration = findByPrimaryKey(
			farmerRegistrationId);

		Session session = null;

		try {
			session = openSession();

			FarmerRegistration[] array = new FarmerRegistrationImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, farmerRegistration, uuid, companyId, orderByComparator,
				true);

			array[1] = farmerRegistration;

			array[2] = getByUuid_C_PrevAndNext(
				session, farmerRegistration, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FarmerRegistration getByUuid_C_PrevAndNext(
		Session session, FarmerRegistration farmerRegistration, String uuid,
		long companyId, OrderByComparator<FarmerRegistration> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_FARMERREGISTRATION_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(FarmerRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						farmerRegistration)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FarmerRegistration> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the farmer registrations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (FarmerRegistration farmerRegistration :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(farmerRegistration);
		}
	}

	/**
	 * Returns the number of farmer registrations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching farmer registrations
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FARMERREGISTRATION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"farmerRegistration.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(farmerRegistration.uuid IS NULL OR farmerRegistration.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"farmerRegistration.companyId = ?";

	private FinderPath _finderPathFetchByNationalId;
	private FinderPath _finderPathCountByNationalId;

	/**
	 * Returns the farmer registration where nationalId = &#63; or throws a <code>NoSuchFarmerRegistrationException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	@Override
	public FarmerRegistration findByNationalId(String nationalId)
		throws NoSuchFarmerRegistrationException {

		FarmerRegistration farmerRegistration = fetchByNationalId(nationalId);

		if (farmerRegistration == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("nationalId=");
			sb.append(nationalId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFarmerRegistrationException(sb.toString());
		}

		return farmerRegistration;
	}

	/**
	 * Returns the farmer registration where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	@Override
	public FarmerRegistration fetchByNationalId(String nationalId) {
		return fetchByNationalId(nationalId, true);
	}

	/**
	 * Returns the farmer registration where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	@Override
	public FarmerRegistration fetchByNationalId(
		String nationalId, boolean useFinderCache) {

		nationalId = Objects.toString(nationalId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {nationalId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByNationalId, finderArgs);
		}

		if (result instanceof FarmerRegistration) {
			FarmerRegistration farmerRegistration = (FarmerRegistration)result;

			if (!Objects.equals(
					nationalId, farmerRegistration.getNationalId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_FARMERREGISTRATION_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_NATIONALID_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(_FINDER_COLUMN_NATIONALID_NATIONALID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNationalId) {
					queryPos.add(nationalId);
				}

				List<FarmerRegistration> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByNationalId, finderArgs, list);
					}
				}
				else {
					FarmerRegistration farmerRegistration = list.get(0);

					result = farmerRegistration;

					cacheResult(farmerRegistration);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (FarmerRegistration)result;
		}
	}

	/**
	 * Removes the farmer registration where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the farmer registration that was removed
	 */
	@Override
	public FarmerRegistration removeByNationalId(String nationalId)
		throws NoSuchFarmerRegistrationException {

		FarmerRegistration farmerRegistration = findByNationalId(nationalId);

		return remove(farmerRegistration);
	}

	/**
	 * Returns the number of farmer registrations where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching farmer registrations
	 */
	@Override
	public int countByNationalId(String nationalId) {
		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = _finderPathCountByNationalId;

		Object[] finderArgs = new Object[] {nationalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FARMERREGISTRATION_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_NATIONALID_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(_FINDER_COLUMN_NATIONALID_NATIONALID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNationalId) {
					queryPos.add(nationalId);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NATIONALID_NATIONALID_2 =
		"farmerRegistration.nationalId = ?";

	private static final String _FINDER_COLUMN_NATIONALID_NATIONALID_3 =
		"(farmerRegistration.nationalId IS NULL OR farmerRegistration.nationalId = '')";

	private FinderPath _finderPathFetchByApplicationNumber;
	private FinderPath _finderPathCountByApplicationNumber;

	/**
	 * Returns the farmer registration where applicationNumber = &#63; or throws a <code>NoSuchFarmerRegistrationException</code> if it could not be found.
	 *
	 * @param applicationNumber the application number
	 * @return the matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	@Override
	public FarmerRegistration findByApplicationNumber(String applicationNumber)
		throws NoSuchFarmerRegistrationException {

		FarmerRegistration farmerRegistration = fetchByApplicationNumber(
			applicationNumber);

		if (farmerRegistration == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("applicationNumber=");
			sb.append(applicationNumber);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFarmerRegistrationException(sb.toString());
		}

		return farmerRegistration;
	}

	/**
	 * Returns the farmer registration where applicationNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	@Override
	public FarmerRegistration fetchByApplicationNumber(
		String applicationNumber) {

		return fetchByApplicationNumber(applicationNumber, true);
	}

	/**
	 * Returns the farmer registration where applicationNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	@Override
	public FarmerRegistration fetchByApplicationNumber(
		String applicationNumber, boolean useFinderCache) {

		applicationNumber = Objects.toString(applicationNumber, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {applicationNumber};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByApplicationNumber, finderArgs);
		}

		if (result instanceof FarmerRegistration) {
			FarmerRegistration farmerRegistration = (FarmerRegistration)result;

			if (!Objects.equals(
					applicationNumber,
					farmerRegistration.getApplicationNumber())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_FARMERREGISTRATION_WHERE);

			boolean bindApplicationNumber = false;

			if (applicationNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPLICATIONNUMBER_APPLICATIONNUMBER_3);
			}
			else {
				bindApplicationNumber = true;

				sb.append(_FINDER_COLUMN_APPLICATIONNUMBER_APPLICATIONNUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindApplicationNumber) {
					queryPos.add(applicationNumber);
				}

				List<FarmerRegistration> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByApplicationNumber, finderArgs,
							list);
					}
				}
				else {
					FarmerRegistration farmerRegistration = list.get(0);

					result = farmerRegistration;

					cacheResult(farmerRegistration);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (FarmerRegistration)result;
		}
	}

	/**
	 * Removes the farmer registration where applicationNumber = &#63; from the database.
	 *
	 * @param applicationNumber the application number
	 * @return the farmer registration that was removed
	 */
	@Override
	public FarmerRegistration removeByApplicationNumber(
			String applicationNumber)
		throws NoSuchFarmerRegistrationException {

		FarmerRegistration farmerRegistration = findByApplicationNumber(
			applicationNumber);

		return remove(farmerRegistration);
	}

	/**
	 * Returns the number of farmer registrations where applicationNumber = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @return the number of matching farmer registrations
	 */
	@Override
	public int countByApplicationNumber(String applicationNumber) {
		applicationNumber = Objects.toString(applicationNumber, "");

		FinderPath finderPath = _finderPathCountByApplicationNumber;

		Object[] finderArgs = new Object[] {applicationNumber};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FARMERREGISTRATION_WHERE);

			boolean bindApplicationNumber = false;

			if (applicationNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPLICATIONNUMBER_APPLICATIONNUMBER_3);
			}
			else {
				bindApplicationNumber = true;

				sb.append(_FINDER_COLUMN_APPLICATIONNUMBER_APPLICATIONNUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindApplicationNumber) {
					queryPos.add(applicationNumber);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_APPLICATIONNUMBER_APPLICATIONNUMBER_2 =
			"farmerRegistration.applicationNumber = ?";

	private static final String
		_FINDER_COLUMN_APPLICATIONNUMBER_APPLICATIONNUMBER_3 =
			"(farmerRegistration.applicationNumber IS NULL OR farmerRegistration.applicationNumber = '')";

	private FinderPath _finderPathFetchByApplicationNumberDob;
	private FinderPath _finderPathCountByApplicationNumberDob;

	/**
	 * Returns the farmer registration where applicationNumber = &#63; and dateOfBirth = &#63; or throws a <code>NoSuchFarmerRegistrationException</code> if it could not be found.
	 *
	 * @param applicationNumber the application number
	 * @param dateOfBirth the date of birth
	 * @return the matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	@Override
	public FarmerRegistration findByApplicationNumberDob(
			String applicationNumber, Date dateOfBirth)
		throws NoSuchFarmerRegistrationException {

		FarmerRegistration farmerRegistration = fetchByApplicationNumberDob(
			applicationNumber, dateOfBirth);

		if (farmerRegistration == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("applicationNumber=");
			sb.append(applicationNumber);

			sb.append(", dateOfBirth=");
			sb.append(dateOfBirth);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFarmerRegistrationException(sb.toString());
		}

		return farmerRegistration;
	}

	/**
	 * Returns the farmer registration where applicationNumber = &#63; and dateOfBirth = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @param dateOfBirth the date of birth
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	@Override
	public FarmerRegistration fetchByApplicationNumberDob(
		String applicationNumber, Date dateOfBirth) {

		return fetchByApplicationNumberDob(
			applicationNumber, dateOfBirth, true);
	}

	/**
	 * Returns the farmer registration where applicationNumber = &#63; and dateOfBirth = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @param dateOfBirth the date of birth
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	@Override
	public FarmerRegistration fetchByApplicationNumberDob(
		String applicationNumber, Date dateOfBirth, boolean useFinderCache) {

		applicationNumber = Objects.toString(applicationNumber, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {
				applicationNumber, _getTime(dateOfBirth)
			};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByApplicationNumberDob, finderArgs);
		}

		if (result instanceof FarmerRegistration) {
			FarmerRegistration farmerRegistration = (FarmerRegistration)result;

			if (!Objects.equals(
					applicationNumber,
					farmerRegistration.getApplicationNumber()) ||
				!Objects.equals(
					dateOfBirth, farmerRegistration.getDateOfBirth())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_FARMERREGISTRATION_WHERE);

			boolean bindApplicationNumber = false;

			if (applicationNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_APPLICATIONNUMBERDOB_APPLICATIONNUMBER_3);
			}
			else {
				bindApplicationNumber = true;

				sb.append(
					_FINDER_COLUMN_APPLICATIONNUMBERDOB_APPLICATIONNUMBER_2);
			}

			boolean bindDateOfBirth = false;

			if (dateOfBirth == null) {
				sb.append(_FINDER_COLUMN_APPLICATIONNUMBERDOB_DATEOFBIRTH_1);
			}
			else {
				bindDateOfBirth = true;

				sb.append(_FINDER_COLUMN_APPLICATIONNUMBERDOB_DATEOFBIRTH_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindApplicationNumber) {
					queryPos.add(applicationNumber);
				}

				if (bindDateOfBirth) {
					queryPos.add(new Timestamp(dateOfBirth.getTime()));
				}

				List<FarmerRegistration> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByApplicationNumberDob, finderArgs,
							list);
					}
				}
				else {
					FarmerRegistration farmerRegistration = list.get(0);

					result = farmerRegistration;

					cacheResult(farmerRegistration);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (FarmerRegistration)result;
		}
	}

	/**
	 * Removes the farmer registration where applicationNumber = &#63; and dateOfBirth = &#63; from the database.
	 *
	 * @param applicationNumber the application number
	 * @param dateOfBirth the date of birth
	 * @return the farmer registration that was removed
	 */
	@Override
	public FarmerRegistration removeByApplicationNumberDob(
			String applicationNumber, Date dateOfBirth)
		throws NoSuchFarmerRegistrationException {

		FarmerRegistration farmerRegistration = findByApplicationNumberDob(
			applicationNumber, dateOfBirth);

		return remove(farmerRegistration);
	}

	/**
	 * Returns the number of farmer registrations where applicationNumber = &#63; and dateOfBirth = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @param dateOfBirth the date of birth
	 * @return the number of matching farmer registrations
	 */
	@Override
	public int countByApplicationNumberDob(
		String applicationNumber, Date dateOfBirth) {

		applicationNumber = Objects.toString(applicationNumber, "");

		FinderPath finderPath = _finderPathCountByApplicationNumberDob;

		Object[] finderArgs = new Object[] {
			applicationNumber, _getTime(dateOfBirth)
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FARMERREGISTRATION_WHERE);

			boolean bindApplicationNumber = false;

			if (applicationNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_APPLICATIONNUMBERDOB_APPLICATIONNUMBER_3);
			}
			else {
				bindApplicationNumber = true;

				sb.append(
					_FINDER_COLUMN_APPLICATIONNUMBERDOB_APPLICATIONNUMBER_2);
			}

			boolean bindDateOfBirth = false;

			if (dateOfBirth == null) {
				sb.append(_FINDER_COLUMN_APPLICATIONNUMBERDOB_DATEOFBIRTH_1);
			}
			else {
				bindDateOfBirth = true;

				sb.append(_FINDER_COLUMN_APPLICATIONNUMBERDOB_DATEOFBIRTH_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindApplicationNumber) {
					queryPos.add(applicationNumber);
				}

				if (bindDateOfBirth) {
					queryPos.add(new Timestamp(dateOfBirth.getTime()));
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_APPLICATIONNUMBERDOB_APPLICATIONNUMBER_2 =
			"farmerRegistration.applicationNumber = ? AND ";

	private static final String
		_FINDER_COLUMN_APPLICATIONNUMBERDOB_APPLICATIONNUMBER_3 =
			"(farmerRegistration.applicationNumber IS NULL OR farmerRegistration.applicationNumber = '') AND ";

	private static final String
		_FINDER_COLUMN_APPLICATIONNUMBERDOB_DATEOFBIRTH_1 =
			"farmerRegistration.dateOfBirth IS NULL";

	private static final String
		_FINDER_COLUMN_APPLICATIONNUMBERDOB_DATEOFBIRTH_2 =
			"farmerRegistration.dateOfBirth = ?";

	private FinderPath _finderPathFetchByNationalIdDob;
	private FinderPath _finderPathCountByNationalIdDob;

	/**
	 * Returns the farmer registration where nationalId = &#63; and dateOfBirth = &#63; or throws a <code>NoSuchFarmerRegistrationException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @param dateOfBirth the date of birth
	 * @return the matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	@Override
	public FarmerRegistration findByNationalIdDob(
			String nationalId, Date dateOfBirth)
		throws NoSuchFarmerRegistrationException {

		FarmerRegistration farmerRegistration = fetchByNationalIdDob(
			nationalId, dateOfBirth);

		if (farmerRegistration == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("nationalId=");
			sb.append(nationalId);

			sb.append(", dateOfBirth=");
			sb.append(dateOfBirth);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFarmerRegistrationException(sb.toString());
		}

		return farmerRegistration;
	}

	/**
	 * Returns the farmer registration where nationalId = &#63; and dateOfBirth = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param dateOfBirth the date of birth
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	@Override
	public FarmerRegistration fetchByNationalIdDob(
		String nationalId, Date dateOfBirth) {

		return fetchByNationalIdDob(nationalId, dateOfBirth, true);
	}

	/**
	 * Returns the farmer registration where nationalId = &#63; and dateOfBirth = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param dateOfBirth the date of birth
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	@Override
	public FarmerRegistration fetchByNationalIdDob(
		String nationalId, Date dateOfBirth, boolean useFinderCache) {

		nationalId = Objects.toString(nationalId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {nationalId, _getTime(dateOfBirth)};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByNationalIdDob, finderArgs);
		}

		if (result instanceof FarmerRegistration) {
			FarmerRegistration farmerRegistration = (FarmerRegistration)result;

			if (!Objects.equals(
					nationalId, farmerRegistration.getNationalId()) ||
				!Objects.equals(
					dateOfBirth, farmerRegistration.getDateOfBirth())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_FARMERREGISTRATION_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_NATIONALIDDOB_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(_FINDER_COLUMN_NATIONALIDDOB_NATIONALID_2);
			}

			boolean bindDateOfBirth = false;

			if (dateOfBirth == null) {
				sb.append(_FINDER_COLUMN_NATIONALIDDOB_DATEOFBIRTH_1);
			}
			else {
				bindDateOfBirth = true;

				sb.append(_FINDER_COLUMN_NATIONALIDDOB_DATEOFBIRTH_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNationalId) {
					queryPos.add(nationalId);
				}

				if (bindDateOfBirth) {
					queryPos.add(new Timestamp(dateOfBirth.getTime()));
				}

				List<FarmerRegistration> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByNationalIdDob, finderArgs, list);
					}
				}
				else {
					FarmerRegistration farmerRegistration = list.get(0);

					result = farmerRegistration;

					cacheResult(farmerRegistration);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (FarmerRegistration)result;
		}
	}

	/**
	 * Removes the farmer registration where nationalId = &#63; and dateOfBirth = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @param dateOfBirth the date of birth
	 * @return the farmer registration that was removed
	 */
	@Override
	public FarmerRegistration removeByNationalIdDob(
			String nationalId, Date dateOfBirth)
		throws NoSuchFarmerRegistrationException {

		FarmerRegistration farmerRegistration = findByNationalIdDob(
			nationalId, dateOfBirth);

		return remove(farmerRegistration);
	}

	/**
	 * Returns the number of farmer registrations where nationalId = &#63; and dateOfBirth = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param dateOfBirth the date of birth
	 * @return the number of matching farmer registrations
	 */
	@Override
	public int countByNationalIdDob(String nationalId, Date dateOfBirth) {
		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = _finderPathCountByNationalIdDob;

		Object[] finderArgs = new Object[] {nationalId, _getTime(dateOfBirth)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FARMERREGISTRATION_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_NATIONALIDDOB_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(_FINDER_COLUMN_NATIONALIDDOB_NATIONALID_2);
			}

			boolean bindDateOfBirth = false;

			if (dateOfBirth == null) {
				sb.append(_FINDER_COLUMN_NATIONALIDDOB_DATEOFBIRTH_1);
			}
			else {
				bindDateOfBirth = true;

				sb.append(_FINDER_COLUMN_NATIONALIDDOB_DATEOFBIRTH_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNationalId) {
					queryPos.add(nationalId);
				}

				if (bindDateOfBirth) {
					queryPos.add(new Timestamp(dateOfBirth.getTime()));
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NATIONALIDDOB_NATIONALID_2 =
		"farmerRegistration.nationalId = ? AND ";

	private static final String _FINDER_COLUMN_NATIONALIDDOB_NATIONALID_3 =
		"(farmerRegistration.nationalId IS NULL OR farmerRegistration.nationalId = '') AND ";

	private static final String _FINDER_COLUMN_NATIONALIDDOB_DATEOFBIRTH_1 =
		"farmerRegistration.dateOfBirth IS NULL";

	private static final String _FINDER_COLUMN_NATIONALIDDOB_DATEOFBIRTH_2 =
		"farmerRegistration.dateOfBirth = ?";

	private FinderPath _finderPathFetchByKrishokCard;
	private FinderPath _finderPathCountByKrishokCard;

	/**
	 * Returns the farmer registration where krishokCardNumber = &#63; or throws a <code>NoSuchFarmerRegistrationException</code> if it could not be found.
	 *
	 * @param krishokCardNumber the krishok card number
	 * @return the matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	@Override
	public FarmerRegistration findByKrishokCard(String krishokCardNumber)
		throws NoSuchFarmerRegistrationException {

		FarmerRegistration farmerRegistration = fetchByKrishokCard(
			krishokCardNumber);

		if (farmerRegistration == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("krishokCardNumber=");
			sb.append(krishokCardNumber);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFarmerRegistrationException(sb.toString());
		}

		return farmerRegistration;
	}

	/**
	 * Returns the farmer registration where krishokCardNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param krishokCardNumber the krishok card number
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	@Override
	public FarmerRegistration fetchByKrishokCard(String krishokCardNumber) {
		return fetchByKrishokCard(krishokCardNumber, true);
	}

	/**
	 * Returns the farmer registration where krishokCardNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param krishokCardNumber the krishok card number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	@Override
	public FarmerRegistration fetchByKrishokCard(
		String krishokCardNumber, boolean useFinderCache) {

		krishokCardNumber = Objects.toString(krishokCardNumber, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {krishokCardNumber};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByKrishokCard, finderArgs);
		}

		if (result instanceof FarmerRegistration) {
			FarmerRegistration farmerRegistration = (FarmerRegistration)result;

			if (!Objects.equals(
					krishokCardNumber,
					farmerRegistration.getKrishokCardNumber())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_FARMERREGISTRATION_WHERE);

			boolean bindKrishokCardNumber = false;

			if (krishokCardNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_KRISHOKCARD_KRISHOKCARDNUMBER_3);
			}
			else {
				bindKrishokCardNumber = true;

				sb.append(_FINDER_COLUMN_KRISHOKCARD_KRISHOKCARDNUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindKrishokCardNumber) {
					queryPos.add(krishokCardNumber);
				}

				List<FarmerRegistration> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByKrishokCard, finderArgs, list);
					}
				}
				else {
					FarmerRegistration farmerRegistration = list.get(0);

					result = farmerRegistration;

					cacheResult(farmerRegistration);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (FarmerRegistration)result;
		}
	}

	/**
	 * Removes the farmer registration where krishokCardNumber = &#63; from the database.
	 *
	 * @param krishokCardNumber the krishok card number
	 * @return the farmer registration that was removed
	 */
	@Override
	public FarmerRegistration removeByKrishokCard(String krishokCardNumber)
		throws NoSuchFarmerRegistrationException {

		FarmerRegistration farmerRegistration = findByKrishokCard(
			krishokCardNumber);

		return remove(farmerRegistration);
	}

	/**
	 * Returns the number of farmer registrations where krishokCardNumber = &#63;.
	 *
	 * @param krishokCardNumber the krishok card number
	 * @return the number of matching farmer registrations
	 */
	@Override
	public int countByKrishokCard(String krishokCardNumber) {
		krishokCardNumber = Objects.toString(krishokCardNumber, "");

		FinderPath finderPath = _finderPathCountByKrishokCard;

		Object[] finderArgs = new Object[] {krishokCardNumber};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FARMERREGISTRATION_WHERE);

			boolean bindKrishokCardNumber = false;

			if (krishokCardNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_KRISHOKCARD_KRISHOKCARDNUMBER_3);
			}
			else {
				bindKrishokCardNumber = true;

				sb.append(_FINDER_COLUMN_KRISHOKCARD_KRISHOKCARDNUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindKrishokCardNumber) {
					queryPos.add(krishokCardNumber);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_KRISHOKCARD_KRISHOKCARDNUMBER_2 =
		"farmerRegistration.krishokCardNumber = ?";

	private static final String _FINDER_COLUMN_KRISHOKCARD_KRISHOKCARDNUMBER_3 =
		"(farmerRegistration.krishokCardNumber IS NULL OR farmerRegistration.krishokCardNumber = '')";

	private FinderPath _finderPathFetchByBusinessCode;
	private FinderPath _finderPathCountByBusinessCode;

	/**
	 * Returns the farmer registration where businessCode = &#63; or throws a <code>NoSuchFarmerRegistrationException</code> if it could not be found.
	 *
	 * @param businessCode the business code
	 * @return the matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	@Override
	public FarmerRegistration findByBusinessCode(String businessCode)
		throws NoSuchFarmerRegistrationException {

		FarmerRegistration farmerRegistration = fetchByBusinessCode(
			businessCode);

		if (farmerRegistration == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("businessCode=");
			sb.append(businessCode);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFarmerRegistrationException(sb.toString());
		}

		return farmerRegistration;
	}

	/**
	 * Returns the farmer registration where businessCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param businessCode the business code
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	@Override
	public FarmerRegistration fetchByBusinessCode(String businessCode) {
		return fetchByBusinessCode(businessCode, true);
	}

	/**
	 * Returns the farmer registration where businessCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param businessCode the business code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	@Override
	public FarmerRegistration fetchByBusinessCode(
		String businessCode, boolean useFinderCache) {

		businessCode = Objects.toString(businessCode, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {businessCode};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByBusinessCode, finderArgs);
		}

		if (result instanceof FarmerRegistration) {
			FarmerRegistration farmerRegistration = (FarmerRegistration)result;

			if (!Objects.equals(
					businessCode, farmerRegistration.getBusinessCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_FARMERREGISTRATION_WHERE);

			boolean bindBusinessCode = false;

			if (businessCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_BUSINESSCODE_BUSINESSCODE_3);
			}
			else {
				bindBusinessCode = true;

				sb.append(_FINDER_COLUMN_BUSINESSCODE_BUSINESSCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindBusinessCode) {
					queryPos.add(businessCode);
				}

				List<FarmerRegistration> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByBusinessCode, finderArgs, list);
					}
				}
				else {
					FarmerRegistration farmerRegistration = list.get(0);

					result = farmerRegistration;

					cacheResult(farmerRegistration);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (FarmerRegistration)result;
		}
	}

	/**
	 * Removes the farmer registration where businessCode = &#63; from the database.
	 *
	 * @param businessCode the business code
	 * @return the farmer registration that was removed
	 */
	@Override
	public FarmerRegistration removeByBusinessCode(String businessCode)
		throws NoSuchFarmerRegistrationException {

		FarmerRegistration farmerRegistration = findByBusinessCode(
			businessCode);

		return remove(farmerRegistration);
	}

	/**
	 * Returns the number of farmer registrations where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @return the number of matching farmer registrations
	 */
	@Override
	public int countByBusinessCode(String businessCode) {
		businessCode = Objects.toString(businessCode, "");

		FinderPath finderPath = _finderPathCountByBusinessCode;

		Object[] finderArgs = new Object[] {businessCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FARMERREGISTRATION_WHERE);

			boolean bindBusinessCode = false;

			if (businessCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_BUSINESSCODE_BUSINESSCODE_3);
			}
			else {
				bindBusinessCode = true;

				sb.append(_FINDER_COLUMN_BUSINESSCODE_BUSINESSCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindBusinessCode) {
					queryPos.add(businessCode);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BUSINESSCODE_BUSINESSCODE_2 =
		"farmerRegistration.businessCode = ?";

	private static final String _FINDER_COLUMN_BUSINESSCODE_BUSINESSCODE_3 =
		"(farmerRegistration.businessCode IS NULL OR farmerRegistration.businessCode = '')";

	private FinderPath _finderPathFetchByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns the farmer registration where userId = &#63; or throws a <code>NoSuchFarmerRegistrationException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching farmer registration
	 * @throws NoSuchFarmerRegistrationException if a matching farmer registration could not be found
	 */
	@Override
	public FarmerRegistration findByUserId(long userId)
		throws NoSuchFarmerRegistrationException {

		FarmerRegistration farmerRegistration = fetchByUserId(userId);

		if (farmerRegistration == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("userId=");
			sb.append(userId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFarmerRegistrationException(sb.toString());
		}

		return farmerRegistration;
	}

	/**
	 * Returns the farmer registration where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	@Override
	public FarmerRegistration fetchByUserId(long userId) {
		return fetchByUserId(userId, true);
	}

	/**
	 * Returns the farmer registration where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer registration, or <code>null</code> if a matching farmer registration could not be found
	 */
	@Override
	public FarmerRegistration fetchByUserId(
		long userId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {userId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUserId, finderArgs);
		}

		if (result instanceof FarmerRegistration) {
			FarmerRegistration farmerRegistration = (FarmerRegistration)result;

			if (userId != farmerRegistration.getUserId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_FARMERREGISTRATION_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				List<FarmerRegistration> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUserId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {userId};
							}

							_log.warn(
								"FarmerRegistrationPersistenceImpl.fetchByUserId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					FarmerRegistration farmerRegistration = list.get(0);

					result = farmerRegistration;

					cacheResult(farmerRegistration);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (FarmerRegistration)result;
		}
	}

	/**
	 * Removes the farmer registration where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the farmer registration that was removed
	 */
	@Override
	public FarmerRegistration removeByUserId(long userId)
		throws NoSuchFarmerRegistrationException {

		FarmerRegistration farmerRegistration = findByUserId(userId);

		return remove(farmerRegistration);
	}

	/**
	 * Returns the number of farmer registrations where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching farmer registrations
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FARMERREGISTRATION_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"farmerRegistration.userId = ?";

	public FarmerRegistrationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(FarmerRegistration.class);

		setModelImplClass(FarmerRegistrationImpl.class);
		setModelPKClass(long.class);

		setTable(FarmerRegistrationTable.INSTANCE);
	}

	/**
	 * Caches the farmer registration in the entity cache if it is enabled.
	 *
	 * @param farmerRegistration the farmer registration
	 */
	@Override
	public void cacheResult(FarmerRegistration farmerRegistration) {
		entityCache.putResult(
			FarmerRegistrationImpl.class, farmerRegistration.getPrimaryKey(),
			farmerRegistration);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				farmerRegistration.getUuid(), farmerRegistration.getGroupId()
			},
			farmerRegistration);

		finderCache.putResult(
			_finderPathFetchByNationalId,
			new Object[] {farmerRegistration.getNationalId()},
			farmerRegistration);

		finderCache.putResult(
			_finderPathFetchByApplicationNumber,
			new Object[] {farmerRegistration.getApplicationNumber()},
			farmerRegistration);

		finderCache.putResult(
			_finderPathFetchByApplicationNumberDob,
			new Object[] {
				farmerRegistration.getApplicationNumber(),
				farmerRegistration.getDateOfBirth()
			},
			farmerRegistration);

		finderCache.putResult(
			_finderPathFetchByNationalIdDob,
			new Object[] {
				farmerRegistration.getNationalId(),
				farmerRegistration.getDateOfBirth()
			},
			farmerRegistration);

		finderCache.putResult(
			_finderPathFetchByKrishokCard,
			new Object[] {farmerRegistration.getKrishokCardNumber()},
			farmerRegistration);

		finderCache.putResult(
			_finderPathFetchByBusinessCode,
			new Object[] {farmerRegistration.getBusinessCode()},
			farmerRegistration);

		finderCache.putResult(
			_finderPathFetchByUserId,
			new Object[] {farmerRegistration.getUserId()}, farmerRegistration);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the farmer registrations in the entity cache if it is enabled.
	 *
	 * @param farmerRegistrations the farmer registrations
	 */
	@Override
	public void cacheResult(List<FarmerRegistration> farmerRegistrations) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (farmerRegistrations.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FarmerRegistration farmerRegistration : farmerRegistrations) {
			if (entityCache.getResult(
					FarmerRegistrationImpl.class,
					farmerRegistration.getPrimaryKey()) == null) {

				cacheResult(farmerRegistration);
			}
		}
	}

	/**
	 * Clears the cache for all farmer registrations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FarmerRegistrationImpl.class);

		finderCache.clearCache(FarmerRegistrationImpl.class);
	}

	/**
	 * Clears the cache for the farmer registration.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FarmerRegistration farmerRegistration) {
		entityCache.removeResult(
			FarmerRegistrationImpl.class, farmerRegistration);
	}

	@Override
	public void clearCache(List<FarmerRegistration> farmerRegistrations) {
		for (FarmerRegistration farmerRegistration : farmerRegistrations) {
			entityCache.removeResult(
				FarmerRegistrationImpl.class, farmerRegistration);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FarmerRegistrationImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FarmerRegistrationImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		FarmerRegistrationModelImpl farmerRegistrationModelImpl) {

		Object[] args = new Object[] {
			farmerRegistrationModelImpl.getUuid(),
			farmerRegistrationModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, farmerRegistrationModelImpl);

		args = new Object[] {farmerRegistrationModelImpl.getNationalId()};

		finderCache.putResult(
			_finderPathCountByNationalId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByNationalId, args, farmerRegistrationModelImpl);

		args = new Object[] {
			farmerRegistrationModelImpl.getApplicationNumber()
		};

		finderCache.putResult(
			_finderPathCountByApplicationNumber, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByApplicationNumber, args,
			farmerRegistrationModelImpl);

		args = new Object[] {
			farmerRegistrationModelImpl.getApplicationNumber(),
			_getTime(farmerRegistrationModelImpl.getDateOfBirth())
		};

		finderCache.putResult(
			_finderPathCountByApplicationNumberDob, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByApplicationNumberDob, args,
			farmerRegistrationModelImpl);

		args = new Object[] {
			farmerRegistrationModelImpl.getNationalId(),
			_getTime(farmerRegistrationModelImpl.getDateOfBirth())
		};

		finderCache.putResult(
			_finderPathCountByNationalIdDob, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByNationalIdDob, args, farmerRegistrationModelImpl);

		args = new Object[] {
			farmerRegistrationModelImpl.getKrishokCardNumber()
		};

		finderCache.putResult(
			_finderPathCountByKrishokCard, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByKrishokCard, args, farmerRegistrationModelImpl);

		args = new Object[] {farmerRegistrationModelImpl.getBusinessCode()};

		finderCache.putResult(
			_finderPathCountByBusinessCode, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByBusinessCode, args, farmerRegistrationModelImpl);

		args = new Object[] {farmerRegistrationModelImpl.getUserId()};

		finderCache.putResult(_finderPathCountByUserId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUserId, args, farmerRegistrationModelImpl);
	}

	/**
	 * Creates a new farmer registration with the primary key. Does not add the farmer registration to the database.
	 *
	 * @param farmerRegistrationId the primary key for the new farmer registration
	 * @return the new farmer registration
	 */
	@Override
	public FarmerRegistration create(long farmerRegistrationId) {
		FarmerRegistration farmerRegistration = new FarmerRegistrationImpl();

		farmerRegistration.setNew(true);
		farmerRegistration.setPrimaryKey(farmerRegistrationId);

		String uuid = _portalUUID.generate();

		farmerRegistration.setUuid(uuid);

		farmerRegistration.setCompanyId(CompanyThreadLocal.getCompanyId());

		return farmerRegistration;
	}

	/**
	 * Removes the farmer registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param farmerRegistrationId the primary key of the farmer registration
	 * @return the farmer registration that was removed
	 * @throws NoSuchFarmerRegistrationException if a farmer registration with the primary key could not be found
	 */
	@Override
	public FarmerRegistration remove(long farmerRegistrationId)
		throws NoSuchFarmerRegistrationException {

		return remove((Serializable)farmerRegistrationId);
	}

	/**
	 * Removes the farmer registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the farmer registration
	 * @return the farmer registration that was removed
	 * @throws NoSuchFarmerRegistrationException if a farmer registration with the primary key could not be found
	 */
	@Override
	public FarmerRegistration remove(Serializable primaryKey)
		throws NoSuchFarmerRegistrationException {

		Session session = null;

		try {
			session = openSession();

			FarmerRegistration farmerRegistration =
				(FarmerRegistration)session.get(
					FarmerRegistrationImpl.class, primaryKey);

			if (farmerRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFarmerRegistrationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(farmerRegistration);
		}
		catch (NoSuchFarmerRegistrationException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected FarmerRegistration removeImpl(
		FarmerRegistration farmerRegistration) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(farmerRegistration)) {
				farmerRegistration = (FarmerRegistration)session.get(
					FarmerRegistrationImpl.class,
					farmerRegistration.getPrimaryKeyObj());
			}

			if (farmerRegistration != null) {
				session.delete(farmerRegistration);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (farmerRegistration != null) {
			clearCache(farmerRegistration);
		}

		return farmerRegistration;
	}

	@Override
	public FarmerRegistration updateImpl(
		FarmerRegistration farmerRegistration) {

		boolean isNew = farmerRegistration.isNew();

		if (!(farmerRegistration instanceof FarmerRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(farmerRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					farmerRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in farmerRegistration proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FarmerRegistration implementation " +
					farmerRegistration.getClass());
		}

		FarmerRegistrationModelImpl farmerRegistrationModelImpl =
			(FarmerRegistrationModelImpl)farmerRegistration;

		if (Validator.isNull(farmerRegistration.getUuid())) {
			String uuid = _portalUUID.generate();

			farmerRegistration.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (farmerRegistration.getCreateDate() == null)) {
			if (serviceContext == null) {
				farmerRegistration.setCreateDate(date);
			}
			else {
				farmerRegistration.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!farmerRegistrationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				farmerRegistration.setModifiedDate(date);
			}
			else {
				farmerRegistration.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(farmerRegistration);
			}
			else {
				farmerRegistration = (FarmerRegistration)session.merge(
					farmerRegistration);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FarmerRegistrationImpl.class, farmerRegistrationModelImpl, false,
			true);

		cacheUniqueFindersCache(farmerRegistrationModelImpl);

		if (isNew) {
			farmerRegistration.setNew(false);
		}

		farmerRegistration.resetOriginalValues();

		return farmerRegistration;
	}

	/**
	 * Returns the farmer registration with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the farmer registration
	 * @return the farmer registration
	 * @throws NoSuchFarmerRegistrationException if a farmer registration with the primary key could not be found
	 */
	@Override
	public FarmerRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFarmerRegistrationException {

		FarmerRegistration farmerRegistration = fetchByPrimaryKey(primaryKey);

		if (farmerRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFarmerRegistrationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return farmerRegistration;
	}

	/**
	 * Returns the farmer registration with the primary key or throws a <code>NoSuchFarmerRegistrationException</code> if it could not be found.
	 *
	 * @param farmerRegistrationId the primary key of the farmer registration
	 * @return the farmer registration
	 * @throws NoSuchFarmerRegistrationException if a farmer registration with the primary key could not be found
	 */
	@Override
	public FarmerRegistration findByPrimaryKey(long farmerRegistrationId)
		throws NoSuchFarmerRegistrationException {

		return findByPrimaryKey((Serializable)farmerRegistrationId);
	}

	/**
	 * Returns the farmer registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param farmerRegistrationId the primary key of the farmer registration
	 * @return the farmer registration, or <code>null</code> if a farmer registration with the primary key could not be found
	 */
	@Override
	public FarmerRegistration fetchByPrimaryKey(long farmerRegistrationId) {
		return fetchByPrimaryKey((Serializable)farmerRegistrationId);
	}

	/**
	 * Returns all the farmer registrations.
	 *
	 * @return the farmer registrations
	 */
	@Override
	public List<FarmerRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<FarmerRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<FarmerRegistration> findAll(
		int start, int end,
		OrderByComparator<FarmerRegistration> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<FarmerRegistration> findAll(
		int start, int end,
		OrderByComparator<FarmerRegistration> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<FarmerRegistration> list = null;

		if (useFinderCache) {
			list = (List<FarmerRegistration>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FARMERREGISTRATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FARMERREGISTRATION;

				sql = sql.concat(FarmerRegistrationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FarmerRegistration>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the farmer registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FarmerRegistration farmerRegistration : findAll()) {
			remove(farmerRegistration);
		}
	}

	/**
	 * Returns the number of farmer registrations.
	 *
	 * @return the number of farmer registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_FARMERREGISTRATION);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "farmerRegistrationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FARMERREGISTRATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FarmerRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the farmer registration persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathFetchByNationalId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByNationalId",
			new String[] {String.class.getName()}, new String[] {"nationalId"},
			true);

		_finderPathCountByNationalId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNationalId",
			new String[] {String.class.getName()}, new String[] {"nationalId"},
			false);

		_finderPathFetchByApplicationNumber = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByApplicationNumber",
			new String[] {String.class.getName()},
			new String[] {"applicationNumber"}, true);

		_finderPathCountByApplicationNumber = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByApplicationNumber", new String[] {String.class.getName()},
			new String[] {"applicationNumber"}, false);

		_finderPathFetchByApplicationNumberDob = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByApplicationNumberDob",
			new String[] {String.class.getName(), Date.class.getName()},
			new String[] {"applicationNumber", "dateOfBirth"}, true);

		_finderPathCountByApplicationNumberDob = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByApplicationNumberDob",
			new String[] {String.class.getName(), Date.class.getName()},
			new String[] {"applicationNumber", "dateOfBirth"}, false);

		_finderPathFetchByNationalIdDob = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByNationalIdDob",
			new String[] {String.class.getName(), Date.class.getName()},
			new String[] {"nationalId", "dateOfBirth"}, true);

		_finderPathCountByNationalIdDob = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNationalIdDob",
			new String[] {String.class.getName(), Date.class.getName()},
			new String[] {"nationalId", "dateOfBirth"}, false);

		_finderPathFetchByKrishokCard = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByKrishokCard",
			new String[] {String.class.getName()},
			new String[] {"krishokCardNumber"}, true);

		_finderPathCountByKrishokCard = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByKrishokCard",
			new String[] {String.class.getName()},
			new String[] {"krishokCardNumber"}, false);

		_finderPathFetchByBusinessCode = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByBusinessCode",
			new String[] {String.class.getName()},
			new String[] {"businessCode"}, true);

		_finderPathCountByBusinessCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBusinessCode",
			new String[] {String.class.getName()},
			new String[] {"businessCode"}, false);

		_finderPathFetchByUserId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		_setFarmerRegistrationUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setFarmerRegistrationUtilPersistence(null);

		entityCache.removeCache(FarmerRegistrationImpl.class.getName());
	}

	private void _setFarmerRegistrationUtilPersistence(
		FarmerRegistrationPersistence farmerRegistrationPersistence) {

		try {
			Field field = FarmerRegistrationUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, farmerRegistrationPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = DGFOODPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = DGFOODPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = DGFOODPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_FARMERREGISTRATION =
		"SELECT farmerRegistration FROM FarmerRegistration farmerRegistration";

	private static final String _SQL_SELECT_FARMERREGISTRATION_WHERE =
		"SELECT farmerRegistration FROM FarmerRegistration farmerRegistration WHERE ";

	private static final String _SQL_COUNT_FARMERREGISTRATION =
		"SELECT COUNT(farmerRegistration) FROM FarmerRegistration farmerRegistration";

	private static final String _SQL_COUNT_FARMERREGISTRATION_WHERE =
		"SELECT COUNT(farmerRegistration) FROM FarmerRegistration farmerRegistration WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "farmerRegistration.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FarmerRegistration exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FarmerRegistration exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FarmerRegistrationPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private FarmerRegistrationModelArgumentsResolver
		_farmerRegistrationModelArgumentsResolver;

}