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

package bd.gov.dgfood.common.services.service.persistence.impl;

import bd.gov.dgfood.common.services.exception.NoSuchUserLocationException;
import bd.gov.dgfood.common.services.model.UserLocation;
import bd.gov.dgfood.common.services.model.UserLocationTable;
import bd.gov.dgfood.common.services.model.impl.UserLocationImpl;
import bd.gov.dgfood.common.services.model.impl.UserLocationModelImpl;
import bd.gov.dgfood.common.services.service.persistence.UserLocationPersistence;
import bd.gov.dgfood.common.services.service.persistence.UserLocationUtil;
import bd.gov.dgfood.common.services.service.persistence.impl.constants.PersistenceConstants;

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
 * The persistence implementation for the user location service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {UserLocationPersistence.class, BasePersistence.class})
public class UserLocationPersistenceImpl
	extends BasePersistenceImpl<UserLocation>
	implements UserLocationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UserLocationUtil</code> to access the user location persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UserLocationImpl.class.getName();

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
	 * Returns all the user locations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user locations
	 */
	@Override
	public List<UserLocation> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user locations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @return the range of matching user locations
	 */
	@Override
	public List<UserLocation> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user locations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user locations
	 */
	@Override
	public List<UserLocation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserLocation> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user locations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user locations
	 */
	@Override
	public List<UserLocation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserLocation> orderByComparator,
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

		List<UserLocation> list = null;

		if (useFinderCache) {
			list = (List<UserLocation>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (UserLocation userLocation : list) {
					if (!uuid.equals(userLocation.getUuid())) {
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

			sb.append(_SQL_SELECT_USERLOCATION_WHERE);

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
				sb.append(UserLocationModelImpl.ORDER_BY_JPQL);
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

				list = (List<UserLocation>)QueryUtil.list(
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
	 * Returns the first user location in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	@Override
	public UserLocation findByUuid_First(
			String uuid, OrderByComparator<UserLocation> orderByComparator)
		throws NoSuchUserLocationException {

		UserLocation userLocation = fetchByUuid_First(uuid, orderByComparator);

		if (userLocation != null) {
			return userLocation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchUserLocationException(sb.toString());
	}

	/**
	 * Returns the first user location in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user location, or <code>null</code> if a matching user location could not be found
	 */
	@Override
	public UserLocation fetchByUuid_First(
		String uuid, OrderByComparator<UserLocation> orderByComparator) {

		List<UserLocation> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user location in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	@Override
	public UserLocation findByUuid_Last(
			String uuid, OrderByComparator<UserLocation> orderByComparator)
		throws NoSuchUserLocationException {

		UserLocation userLocation = fetchByUuid_Last(uuid, orderByComparator);

		if (userLocation != null) {
			return userLocation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchUserLocationException(sb.toString());
	}

	/**
	 * Returns the last user location in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user location, or <code>null</code> if a matching user location could not be found
	 */
	@Override
	public UserLocation fetchByUuid_Last(
		String uuid, OrderByComparator<UserLocation> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<UserLocation> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user locations before and after the current user location in the ordered set where uuid = &#63;.
	 *
	 * @param userLocationId the primary key of the current user location
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user location
	 * @throws NoSuchUserLocationException if a user location with the primary key could not be found
	 */
	@Override
	public UserLocation[] findByUuid_PrevAndNext(
			long userLocationId, String uuid,
			OrderByComparator<UserLocation> orderByComparator)
		throws NoSuchUserLocationException {

		uuid = Objects.toString(uuid, "");

		UserLocation userLocation = findByPrimaryKey(userLocationId);

		Session session = null;

		try {
			session = openSession();

			UserLocation[] array = new UserLocationImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, userLocation, uuid, orderByComparator, true);

			array[1] = userLocation;

			array[2] = getByUuid_PrevAndNext(
				session, userLocation, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserLocation getByUuid_PrevAndNext(
		Session session, UserLocation userLocation, String uuid,
		OrderByComparator<UserLocation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_USERLOCATION_WHERE);

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
			sb.append(UserLocationModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(userLocation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UserLocation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user locations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (UserLocation userLocation :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(userLocation);
		}
	}

	/**
	 * Returns the number of user locations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user locations
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_USERLOCATION_WHERE);

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
		"userLocation.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(userLocation.uuid IS NULL OR userLocation.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the user location where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchUserLocationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	@Override
	public UserLocation findByUUID_G(String uuid, long groupId)
		throws NoSuchUserLocationException {

		UserLocation userLocation = fetchByUUID_G(uuid, groupId);

		if (userLocation == null) {
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

			throw new NoSuchUserLocationException(sb.toString());
		}

		return userLocation;
	}

	/**
	 * Returns the user location where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user location, or <code>null</code> if a matching user location could not be found
	 */
	@Override
	public UserLocation fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the user location where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user location, or <code>null</code> if a matching user location could not be found
	 */
	@Override
	public UserLocation fetchByUUID_G(
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

		if (result instanceof UserLocation) {
			UserLocation userLocation = (UserLocation)result;

			if (!Objects.equals(uuid, userLocation.getUuid()) ||
				(groupId != userLocation.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_USERLOCATION_WHERE);

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

				List<UserLocation> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					UserLocation userLocation = list.get(0);

					result = userLocation;

					cacheResult(userLocation);
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
			return (UserLocation)result;
		}
	}

	/**
	 * Removes the user location where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the user location that was removed
	 */
	@Override
	public UserLocation removeByUUID_G(String uuid, long groupId)
		throws NoSuchUserLocationException {

		UserLocation userLocation = findByUUID_G(uuid, groupId);

		return remove(userLocation);
	}

	/**
	 * Returns the number of user locations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching user locations
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_USERLOCATION_WHERE);

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
		"userLocation.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(userLocation.uuid IS NULL OR userLocation.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"userLocation.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the user locations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching user locations
	 */
	@Override
	public List<UserLocation> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user locations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @return the range of matching user locations
	 */
	@Override
	public List<UserLocation> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user locations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user locations
	 */
	@Override
	public List<UserLocation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UserLocation> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user locations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user locations
	 */
	@Override
	public List<UserLocation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UserLocation> orderByComparator,
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

		List<UserLocation> list = null;

		if (useFinderCache) {
			list = (List<UserLocation>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (UserLocation userLocation : list) {
					if (!uuid.equals(userLocation.getUuid()) ||
						(companyId != userLocation.getCompanyId())) {

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

			sb.append(_SQL_SELECT_USERLOCATION_WHERE);

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
				sb.append(UserLocationModelImpl.ORDER_BY_JPQL);
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

				list = (List<UserLocation>)QueryUtil.list(
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
	 * Returns the first user location in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	@Override
	public UserLocation findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<UserLocation> orderByComparator)
		throws NoSuchUserLocationException {

		UserLocation userLocation = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (userLocation != null) {
			return userLocation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchUserLocationException(sb.toString());
	}

	/**
	 * Returns the first user location in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user location, or <code>null</code> if a matching user location could not be found
	 */
	@Override
	public UserLocation fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<UserLocation> orderByComparator) {

		List<UserLocation> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user location in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	@Override
	public UserLocation findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<UserLocation> orderByComparator)
		throws NoSuchUserLocationException {

		UserLocation userLocation = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (userLocation != null) {
			return userLocation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchUserLocationException(sb.toString());
	}

	/**
	 * Returns the last user location in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user location, or <code>null</code> if a matching user location could not be found
	 */
	@Override
	public UserLocation fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<UserLocation> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<UserLocation> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user locations before and after the current user location in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param userLocationId the primary key of the current user location
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user location
	 * @throws NoSuchUserLocationException if a user location with the primary key could not be found
	 */
	@Override
	public UserLocation[] findByUuid_C_PrevAndNext(
			long userLocationId, String uuid, long companyId,
			OrderByComparator<UserLocation> orderByComparator)
		throws NoSuchUserLocationException {

		uuid = Objects.toString(uuid, "");

		UserLocation userLocation = findByPrimaryKey(userLocationId);

		Session session = null;

		try {
			session = openSession();

			UserLocation[] array = new UserLocationImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, userLocation, uuid, companyId, orderByComparator,
				true);

			array[1] = userLocation;

			array[2] = getByUuid_C_PrevAndNext(
				session, userLocation, uuid, companyId, orderByComparator,
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

	protected UserLocation getByUuid_C_PrevAndNext(
		Session session, UserLocation userLocation, String uuid, long companyId,
		OrderByComparator<UserLocation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_USERLOCATION_WHERE);

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
			sb.append(UserLocationModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(userLocation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UserLocation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user locations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (UserLocation userLocation :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(userLocation);
		}
	}

	/**
	 * Returns the number of user locations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching user locations
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_USERLOCATION_WHERE);

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
		"userLocation.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(userLocation.uuid IS NULL OR userLocation.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"userLocation.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the user locations where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching user locations
	 */
	@Override
	public List<UserLocation> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user locations where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @return the range of matching user locations
	 */
	@Override
	public List<UserLocation> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user locations where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user locations
	 */
	@Override
	public List<UserLocation> findByUserId(
		long userId, int start, int end,
		OrderByComparator<UserLocation> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user locations where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user locations
	 */
	@Override
	public List<UserLocation> findByUserId(
		long userId, int start, int end,
		OrderByComparator<UserLocation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserId;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<UserLocation> list = null;

		if (useFinderCache) {
			list = (List<UserLocation>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (UserLocation userLocation : list) {
					if (userId != userLocation.getUserId()) {
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

			sb.append(_SQL_SELECT_USERLOCATION_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(UserLocationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<UserLocation>)QueryUtil.list(
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
	 * Returns the first user location in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	@Override
	public UserLocation findByUserId_First(
			long userId, OrderByComparator<UserLocation> orderByComparator)
		throws NoSuchUserLocationException {

		UserLocation userLocation = fetchByUserId_First(
			userId, orderByComparator);

		if (userLocation != null) {
			return userLocation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchUserLocationException(sb.toString());
	}

	/**
	 * Returns the first user location in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user location, or <code>null</code> if a matching user location could not be found
	 */
	@Override
	public UserLocation fetchByUserId_First(
		long userId, OrderByComparator<UserLocation> orderByComparator) {

		List<UserLocation> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user location in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	@Override
	public UserLocation findByUserId_Last(
			long userId, OrderByComparator<UserLocation> orderByComparator)
		throws NoSuchUserLocationException {

		UserLocation userLocation = fetchByUserId_Last(
			userId, orderByComparator);

		if (userLocation != null) {
			return userLocation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchUserLocationException(sb.toString());
	}

	/**
	 * Returns the last user location in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user location, or <code>null</code> if a matching user location could not be found
	 */
	@Override
	public UserLocation fetchByUserId_Last(
		long userId, OrderByComparator<UserLocation> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<UserLocation> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user locations before and after the current user location in the ordered set where userId = &#63;.
	 *
	 * @param userLocationId the primary key of the current user location
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user location
	 * @throws NoSuchUserLocationException if a user location with the primary key could not be found
	 */
	@Override
	public UserLocation[] findByUserId_PrevAndNext(
			long userLocationId, long userId,
			OrderByComparator<UserLocation> orderByComparator)
		throws NoSuchUserLocationException {

		UserLocation userLocation = findByPrimaryKey(userLocationId);

		Session session = null;

		try {
			session = openSession();

			UserLocation[] array = new UserLocationImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, userLocation, userId, orderByComparator, true);

			array[1] = userLocation;

			array[2] = getByUserId_PrevAndNext(
				session, userLocation, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserLocation getByUserId_PrevAndNext(
		Session session, UserLocation userLocation, long userId,
		OrderByComparator<UserLocation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_USERLOCATION_WHERE);

		sb.append(_FINDER_COLUMN_USERID_USERID_2);

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
			sb.append(UserLocationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(userLocation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UserLocation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user locations where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (UserLocation userLocation :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(userLocation);
		}
	}

	/**
	 * Returns the number of user locations where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user locations
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_USERLOCATION_WHERE);

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
		"userLocation.userId = ?";

	private FinderPath _finderPathFetchByUI_LC;
	private FinderPath _finderPathCountByUI_LC;

	/**
	 * Returns the user location where userId = &#63; and locationCode = &#63; or throws a <code>NoSuchUserLocationException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param locationCode the location code
	 * @return the matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	@Override
	public UserLocation findByUI_LC(long userId, String locationCode)
		throws NoSuchUserLocationException {

		UserLocation userLocation = fetchByUI_LC(userId, locationCode);

		if (userLocation == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("userId=");
			sb.append(userId);

			sb.append(", locationCode=");
			sb.append(locationCode);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchUserLocationException(sb.toString());
		}

		return userLocation;
	}

	/**
	 * Returns the user location where userId = &#63; and locationCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param locationCode the location code
	 * @return the matching user location, or <code>null</code> if a matching user location could not be found
	 */
	@Override
	public UserLocation fetchByUI_LC(long userId, String locationCode) {
		return fetchByUI_LC(userId, locationCode, true);
	}

	/**
	 * Returns the user location where userId = &#63; and locationCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param locationCode the location code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user location, or <code>null</code> if a matching user location could not be found
	 */
	@Override
	public UserLocation fetchByUI_LC(
		long userId, String locationCode, boolean useFinderCache) {

		locationCode = Objects.toString(locationCode, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {userId, locationCode};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByUI_LC, finderArgs);
		}

		if (result instanceof UserLocation) {
			UserLocation userLocation = (UserLocation)result;

			if ((userId != userLocation.getUserId()) ||
				!Objects.equals(locationCode, userLocation.getLocationCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_USERLOCATION_WHERE);

			sb.append(_FINDER_COLUMN_UI_LC_USERID_2);

			boolean bindLocationCode = false;

			if (locationCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_UI_LC_LOCATIONCODE_3);
			}
			else {
				bindLocationCode = true;

				sb.append(_FINDER_COLUMN_UI_LC_LOCATIONCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				if (bindLocationCode) {
					queryPos.add(locationCode);
				}

				List<UserLocation> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUI_LC, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									userId, locationCode
								};
							}

							_log.warn(
								"UserLocationPersistenceImpl.fetchByUI_LC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					UserLocation userLocation = list.get(0);

					result = userLocation;

					cacheResult(userLocation);
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
			return (UserLocation)result;
		}
	}

	/**
	 * Removes the user location where userId = &#63; and locationCode = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param locationCode the location code
	 * @return the user location that was removed
	 */
	@Override
	public UserLocation removeByUI_LC(long userId, String locationCode)
		throws NoSuchUserLocationException {

		UserLocation userLocation = findByUI_LC(userId, locationCode);

		return remove(userLocation);
	}

	/**
	 * Returns the number of user locations where userId = &#63; and locationCode = &#63;.
	 *
	 * @param userId the user ID
	 * @param locationCode the location code
	 * @return the number of matching user locations
	 */
	@Override
	public int countByUI_LC(long userId, String locationCode) {
		locationCode = Objects.toString(locationCode, "");

		FinderPath finderPath = _finderPathCountByUI_LC;

		Object[] finderArgs = new Object[] {userId, locationCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_USERLOCATION_WHERE);

			sb.append(_FINDER_COLUMN_UI_LC_USERID_2);

			boolean bindLocationCode = false;

			if (locationCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_UI_LC_LOCATIONCODE_3);
			}
			else {
				bindLocationCode = true;

				sb.append(_FINDER_COLUMN_UI_LC_LOCATIONCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				if (bindLocationCode) {
					queryPos.add(locationCode);
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

	private static final String _FINDER_COLUMN_UI_LC_USERID_2 =
		"userLocation.userId = ? AND ";

	private static final String _FINDER_COLUMN_UI_LC_LOCATIONCODE_2 =
		"userLocation.locationCode = ?";

	private static final String _FINDER_COLUMN_UI_LC_LOCATIONCODE_3 =
		"(userLocation.locationCode IS NULL OR userLocation.locationCode = '')";

	private FinderPath _finderPathFetchByUI_LC_RK;
	private FinderPath _finderPathCountByUI_LC_RK;

	/**
	 * Returns the user location where userId = &#63; and locationCode = &#63; and roleKey = &#63; or throws a <code>NoSuchUserLocationException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param locationCode the location code
	 * @param roleKey the role key
	 * @return the matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	@Override
	public UserLocation findByUI_LC_RK(
			long userId, String locationCode, String roleKey)
		throws NoSuchUserLocationException {

		UserLocation userLocation = fetchByUI_LC_RK(
			userId, locationCode, roleKey);

		if (userLocation == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("userId=");
			sb.append(userId);

			sb.append(", locationCode=");
			sb.append(locationCode);

			sb.append(", roleKey=");
			sb.append(roleKey);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchUserLocationException(sb.toString());
		}

		return userLocation;
	}

	/**
	 * Returns the user location where userId = &#63; and locationCode = &#63; and roleKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param locationCode the location code
	 * @param roleKey the role key
	 * @return the matching user location, or <code>null</code> if a matching user location could not be found
	 */
	@Override
	public UserLocation fetchByUI_LC_RK(
		long userId, String locationCode, String roleKey) {

		return fetchByUI_LC_RK(userId, locationCode, roleKey, true);
	}

	/**
	 * Returns the user location where userId = &#63; and locationCode = &#63; and roleKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param locationCode the location code
	 * @param roleKey the role key
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user location, or <code>null</code> if a matching user location could not be found
	 */
	@Override
	public UserLocation fetchByUI_LC_RK(
		long userId, String locationCode, String roleKey,
		boolean useFinderCache) {

		locationCode = Objects.toString(locationCode, "");
		roleKey = Objects.toString(roleKey, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {userId, locationCode, roleKey};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUI_LC_RK, finderArgs);
		}

		if (result instanceof UserLocation) {
			UserLocation userLocation = (UserLocation)result;

			if ((userId != userLocation.getUserId()) ||
				!Objects.equals(locationCode, userLocation.getLocationCode()) ||
				!Objects.equals(roleKey, userLocation.getRoleKey())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_USERLOCATION_WHERE);

			sb.append(_FINDER_COLUMN_UI_LC_RK_USERID_2);

			boolean bindLocationCode = false;

			if (locationCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_UI_LC_RK_LOCATIONCODE_3);
			}
			else {
				bindLocationCode = true;

				sb.append(_FINDER_COLUMN_UI_LC_RK_LOCATIONCODE_2);
			}

			boolean bindRoleKey = false;

			if (roleKey.isEmpty()) {
				sb.append(_FINDER_COLUMN_UI_LC_RK_ROLEKEY_3);
			}
			else {
				bindRoleKey = true;

				sb.append(_FINDER_COLUMN_UI_LC_RK_ROLEKEY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				if (bindLocationCode) {
					queryPos.add(locationCode);
				}

				if (bindRoleKey) {
					queryPos.add(roleKey);
				}

				List<UserLocation> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUI_LC_RK, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									userId, locationCode, roleKey
								};
							}

							_log.warn(
								"UserLocationPersistenceImpl.fetchByUI_LC_RK(long, String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					UserLocation userLocation = list.get(0);

					result = userLocation;

					cacheResult(userLocation);
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
			return (UserLocation)result;
		}
	}

	/**
	 * Removes the user location where userId = &#63; and locationCode = &#63; and roleKey = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param locationCode the location code
	 * @param roleKey the role key
	 * @return the user location that was removed
	 */
	@Override
	public UserLocation removeByUI_LC_RK(
			long userId, String locationCode, String roleKey)
		throws NoSuchUserLocationException {

		UserLocation userLocation = findByUI_LC_RK(
			userId, locationCode, roleKey);

		return remove(userLocation);
	}

	/**
	 * Returns the number of user locations where userId = &#63; and locationCode = &#63; and roleKey = &#63;.
	 *
	 * @param userId the user ID
	 * @param locationCode the location code
	 * @param roleKey the role key
	 * @return the number of matching user locations
	 */
	@Override
	public int countByUI_LC_RK(
		long userId, String locationCode, String roleKey) {

		locationCode = Objects.toString(locationCode, "");
		roleKey = Objects.toString(roleKey, "");

		FinderPath finderPath = _finderPathCountByUI_LC_RK;

		Object[] finderArgs = new Object[] {userId, locationCode, roleKey};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_USERLOCATION_WHERE);

			sb.append(_FINDER_COLUMN_UI_LC_RK_USERID_2);

			boolean bindLocationCode = false;

			if (locationCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_UI_LC_RK_LOCATIONCODE_3);
			}
			else {
				bindLocationCode = true;

				sb.append(_FINDER_COLUMN_UI_LC_RK_LOCATIONCODE_2);
			}

			boolean bindRoleKey = false;

			if (roleKey.isEmpty()) {
				sb.append(_FINDER_COLUMN_UI_LC_RK_ROLEKEY_3);
			}
			else {
				bindRoleKey = true;

				sb.append(_FINDER_COLUMN_UI_LC_RK_ROLEKEY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				if (bindLocationCode) {
					queryPos.add(locationCode);
				}

				if (bindRoleKey) {
					queryPos.add(roleKey);
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

	private static final String _FINDER_COLUMN_UI_LC_RK_USERID_2 =
		"userLocation.userId = ? AND ";

	private static final String _FINDER_COLUMN_UI_LC_RK_LOCATIONCODE_2 =
		"userLocation.locationCode = ? AND ";

	private static final String _FINDER_COLUMN_UI_LC_RK_LOCATIONCODE_3 =
		"(userLocation.locationCode IS NULL OR userLocation.locationCode = '') AND ";

	private static final String _FINDER_COLUMN_UI_LC_RK_ROLEKEY_2 =
		"userLocation.roleKey = ?";

	private static final String _FINDER_COLUMN_UI_LC_RK_ROLEKEY_3 =
		"(userLocation.roleKey IS NULL OR userLocation.roleKey = '')";

	private FinderPath _finderPathFetchByLocationId;
	private FinderPath _finderPathCountByLocationId;

	/**
	 * Returns the user location where locationId = &#63; or throws a <code>NoSuchUserLocationException</code> if it could not be found.
	 *
	 * @param locationId the location ID
	 * @return the matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	@Override
	public UserLocation findByLocationId(long locationId)
		throws NoSuchUserLocationException {

		UserLocation userLocation = fetchByLocationId(locationId);

		if (userLocation == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("locationId=");
			sb.append(locationId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchUserLocationException(sb.toString());
		}

		return userLocation;
	}

	/**
	 * Returns the user location where locationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param locationId the location ID
	 * @return the matching user location, or <code>null</code> if a matching user location could not be found
	 */
	@Override
	public UserLocation fetchByLocationId(long locationId) {
		return fetchByLocationId(locationId, true);
	}

	/**
	 * Returns the user location where locationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param locationId the location ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user location, or <code>null</code> if a matching user location could not be found
	 */
	@Override
	public UserLocation fetchByLocationId(
		long locationId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {locationId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByLocationId, finderArgs);
		}

		if (result instanceof UserLocation) {
			UserLocation userLocation = (UserLocation)result;

			if (locationId != userLocation.getLocationId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_USERLOCATION_WHERE);

			sb.append(_FINDER_COLUMN_LOCATIONID_LOCATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(locationId);

				List<UserLocation> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByLocationId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {locationId};
							}

							_log.warn(
								"UserLocationPersistenceImpl.fetchByLocationId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					UserLocation userLocation = list.get(0);

					result = userLocation;

					cacheResult(userLocation);
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
			return (UserLocation)result;
		}
	}

	/**
	 * Removes the user location where locationId = &#63; from the database.
	 *
	 * @param locationId the location ID
	 * @return the user location that was removed
	 */
	@Override
	public UserLocation removeByLocationId(long locationId)
		throws NoSuchUserLocationException {

		UserLocation userLocation = findByLocationId(locationId);

		return remove(userLocation);
	}

	/**
	 * Returns the number of user locations where locationId = &#63;.
	 *
	 * @param locationId the location ID
	 * @return the number of matching user locations
	 */
	@Override
	public int countByLocationId(long locationId) {
		FinderPath finderPath = _finderPathCountByLocationId;

		Object[] finderArgs = new Object[] {locationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_USERLOCATION_WHERE);

			sb.append(_FINDER_COLUMN_LOCATIONID_LOCATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(locationId);

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

	private static final String _FINDER_COLUMN_LOCATIONID_LOCATIONID_2 =
		"userLocation.locationId = ?";

	private FinderPath _finderPathFetchByRK_LC;
	private FinderPath _finderPathCountByRK_LC;

	/**
	 * Returns the user location where roleKey = &#63; and locationCode = &#63; or throws a <code>NoSuchUserLocationException</code> if it could not be found.
	 *
	 * @param roleKey the role key
	 * @param locationCode the location code
	 * @return the matching user location
	 * @throws NoSuchUserLocationException if a matching user location could not be found
	 */
	@Override
	public UserLocation findByRK_LC(String roleKey, String locationCode)
		throws NoSuchUserLocationException {

		UserLocation userLocation = fetchByRK_LC(roleKey, locationCode);

		if (userLocation == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("roleKey=");
			sb.append(roleKey);

			sb.append(", locationCode=");
			sb.append(locationCode);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchUserLocationException(sb.toString());
		}

		return userLocation;
	}

	/**
	 * Returns the user location where roleKey = &#63; and locationCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param roleKey the role key
	 * @param locationCode the location code
	 * @return the matching user location, or <code>null</code> if a matching user location could not be found
	 */
	@Override
	public UserLocation fetchByRK_LC(String roleKey, String locationCode) {
		return fetchByRK_LC(roleKey, locationCode, true);
	}

	/**
	 * Returns the user location where roleKey = &#63; and locationCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param roleKey the role key
	 * @param locationCode the location code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user location, or <code>null</code> if a matching user location could not be found
	 */
	@Override
	public UserLocation fetchByRK_LC(
		String roleKey, String locationCode, boolean useFinderCache) {

		roleKey = Objects.toString(roleKey, "");
		locationCode = Objects.toString(locationCode, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {roleKey, locationCode};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByRK_LC, finderArgs);
		}

		if (result instanceof UserLocation) {
			UserLocation userLocation = (UserLocation)result;

			if (!Objects.equals(roleKey, userLocation.getRoleKey()) ||
				!Objects.equals(locationCode, userLocation.getLocationCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_USERLOCATION_WHERE);

			boolean bindRoleKey = false;

			if (roleKey.isEmpty()) {
				sb.append(_FINDER_COLUMN_RK_LC_ROLEKEY_3);
			}
			else {
				bindRoleKey = true;

				sb.append(_FINDER_COLUMN_RK_LC_ROLEKEY_2);
			}

			boolean bindLocationCode = false;

			if (locationCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_RK_LC_LOCATIONCODE_3);
			}
			else {
				bindLocationCode = true;

				sb.append(_FINDER_COLUMN_RK_LC_LOCATIONCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRoleKey) {
					queryPos.add(roleKey);
				}

				if (bindLocationCode) {
					queryPos.add(locationCode);
				}

				List<UserLocation> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByRK_LC, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									roleKey, locationCode
								};
							}

							_log.warn(
								"UserLocationPersistenceImpl.fetchByRK_LC(String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					UserLocation userLocation = list.get(0);

					result = userLocation;

					cacheResult(userLocation);
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
			return (UserLocation)result;
		}
	}

	/**
	 * Removes the user location where roleKey = &#63; and locationCode = &#63; from the database.
	 *
	 * @param roleKey the role key
	 * @param locationCode the location code
	 * @return the user location that was removed
	 */
	@Override
	public UserLocation removeByRK_LC(String roleKey, String locationCode)
		throws NoSuchUserLocationException {

		UserLocation userLocation = findByRK_LC(roleKey, locationCode);

		return remove(userLocation);
	}

	/**
	 * Returns the number of user locations where roleKey = &#63; and locationCode = &#63;.
	 *
	 * @param roleKey the role key
	 * @param locationCode the location code
	 * @return the number of matching user locations
	 */
	@Override
	public int countByRK_LC(String roleKey, String locationCode) {
		roleKey = Objects.toString(roleKey, "");
		locationCode = Objects.toString(locationCode, "");

		FinderPath finderPath = _finderPathCountByRK_LC;

		Object[] finderArgs = new Object[] {roleKey, locationCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_USERLOCATION_WHERE);

			boolean bindRoleKey = false;

			if (roleKey.isEmpty()) {
				sb.append(_FINDER_COLUMN_RK_LC_ROLEKEY_3);
			}
			else {
				bindRoleKey = true;

				sb.append(_FINDER_COLUMN_RK_LC_ROLEKEY_2);
			}

			boolean bindLocationCode = false;

			if (locationCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_RK_LC_LOCATIONCODE_3);
			}
			else {
				bindLocationCode = true;

				sb.append(_FINDER_COLUMN_RK_LC_LOCATIONCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRoleKey) {
					queryPos.add(roleKey);
				}

				if (bindLocationCode) {
					queryPos.add(locationCode);
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

	private static final String _FINDER_COLUMN_RK_LC_ROLEKEY_2 =
		"userLocation.roleKey = ? AND ";

	private static final String _FINDER_COLUMN_RK_LC_ROLEKEY_3 =
		"(userLocation.roleKey IS NULL OR userLocation.roleKey = '') AND ";

	private static final String _FINDER_COLUMN_RK_LC_LOCATIONCODE_2 =
		"userLocation.locationCode = ?";

	private static final String _FINDER_COLUMN_RK_LC_LOCATIONCODE_3 =
		"(userLocation.locationCode IS NULL OR userLocation.locationCode = '')";

	public UserLocationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(UserLocation.class);

		setModelImplClass(UserLocationImpl.class);
		setModelPKClass(long.class);

		setTable(UserLocationTable.INSTANCE);
	}

	/**
	 * Caches the user location in the entity cache if it is enabled.
	 *
	 * @param userLocation the user location
	 */
	@Override
	public void cacheResult(UserLocation userLocation) {
		entityCache.putResult(
			UserLocationImpl.class, userLocation.getPrimaryKey(), userLocation);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {userLocation.getUuid(), userLocation.getGroupId()},
			userLocation);

		finderCache.putResult(
			_finderPathFetchByUI_LC,
			new Object[] {
				userLocation.getUserId(), userLocation.getLocationCode()
			},
			userLocation);

		finderCache.putResult(
			_finderPathFetchByUI_LC_RK,
			new Object[] {
				userLocation.getUserId(), userLocation.getLocationCode(),
				userLocation.getRoleKey()
			},
			userLocation);

		finderCache.putResult(
			_finderPathFetchByLocationId,
			new Object[] {userLocation.getLocationId()}, userLocation);

		finderCache.putResult(
			_finderPathFetchByRK_LC,
			new Object[] {
				userLocation.getRoleKey(), userLocation.getLocationCode()
			},
			userLocation);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the user locations in the entity cache if it is enabled.
	 *
	 * @param userLocations the user locations
	 */
	@Override
	public void cacheResult(List<UserLocation> userLocations) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (userLocations.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (UserLocation userLocation : userLocations) {
			if (entityCache.getResult(
					UserLocationImpl.class, userLocation.getPrimaryKey()) ==
						null) {

				cacheResult(userLocation);
			}
		}
	}

	/**
	 * Clears the cache for all user locations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserLocationImpl.class);

		finderCache.clearCache(UserLocationImpl.class);
	}

	/**
	 * Clears the cache for the user location.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserLocation userLocation) {
		entityCache.removeResult(UserLocationImpl.class, userLocation);
	}

	@Override
	public void clearCache(List<UserLocation> userLocations) {
		for (UserLocation userLocation : userLocations) {
			entityCache.removeResult(UserLocationImpl.class, userLocation);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(UserLocationImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(UserLocationImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		UserLocationModelImpl userLocationModelImpl) {

		Object[] args = new Object[] {
			userLocationModelImpl.getUuid(), userLocationModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, userLocationModelImpl);

		args = new Object[] {
			userLocationModelImpl.getUserId(),
			userLocationModelImpl.getLocationCode()
		};

		finderCache.putResult(_finderPathCountByUI_LC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUI_LC, args, userLocationModelImpl);

		args = new Object[] {
			userLocationModelImpl.getUserId(),
			userLocationModelImpl.getLocationCode(),
			userLocationModelImpl.getRoleKey()
		};

		finderCache.putResult(
			_finderPathCountByUI_LC_RK, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUI_LC_RK, args, userLocationModelImpl);

		args = new Object[] {userLocationModelImpl.getLocationId()};

		finderCache.putResult(
			_finderPathCountByLocationId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByLocationId, args, userLocationModelImpl);

		args = new Object[] {
			userLocationModelImpl.getRoleKey(),
			userLocationModelImpl.getLocationCode()
		};

		finderCache.putResult(_finderPathCountByRK_LC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByRK_LC, args, userLocationModelImpl);
	}

	/**
	 * Creates a new user location with the primary key. Does not add the user location to the database.
	 *
	 * @param userLocationId the primary key for the new user location
	 * @return the new user location
	 */
	@Override
	public UserLocation create(long userLocationId) {
		UserLocation userLocation = new UserLocationImpl();

		userLocation.setNew(true);
		userLocation.setPrimaryKey(userLocationId);

		String uuid = _portalUUID.generate();

		userLocation.setUuid(uuid);

		userLocation.setCompanyId(CompanyThreadLocal.getCompanyId());

		return userLocation;
	}

	/**
	 * Removes the user location with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userLocationId the primary key of the user location
	 * @return the user location that was removed
	 * @throws NoSuchUserLocationException if a user location with the primary key could not be found
	 */
	@Override
	public UserLocation remove(long userLocationId)
		throws NoSuchUserLocationException {

		return remove((Serializable)userLocationId);
	}

	/**
	 * Removes the user location with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user location
	 * @return the user location that was removed
	 * @throws NoSuchUserLocationException if a user location with the primary key could not be found
	 */
	@Override
	public UserLocation remove(Serializable primaryKey)
		throws NoSuchUserLocationException {

		Session session = null;

		try {
			session = openSession();

			UserLocation userLocation = (UserLocation)session.get(
				UserLocationImpl.class, primaryKey);

			if (userLocation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserLocationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(userLocation);
		}
		catch (NoSuchUserLocationException noSuchEntityException) {
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
	protected UserLocation removeImpl(UserLocation userLocation) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userLocation)) {
				userLocation = (UserLocation)session.get(
					UserLocationImpl.class, userLocation.getPrimaryKeyObj());
			}

			if (userLocation != null) {
				session.delete(userLocation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (userLocation != null) {
			clearCache(userLocation);
		}

		return userLocation;
	}

	@Override
	public UserLocation updateImpl(UserLocation userLocation) {
		boolean isNew = userLocation.isNew();

		if (!(userLocation instanceof UserLocationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(userLocation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					userLocation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in userLocation proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UserLocation implementation " +
					userLocation.getClass());
		}

		UserLocationModelImpl userLocationModelImpl =
			(UserLocationModelImpl)userLocation;

		if (Validator.isNull(userLocation.getUuid())) {
			String uuid = _portalUUID.generate();

			userLocation.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (userLocation.getCreateDate() == null)) {
			if (serviceContext == null) {
				userLocation.setCreateDate(date);
			}
			else {
				userLocation.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!userLocationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				userLocation.setModifiedDate(date);
			}
			else {
				userLocation.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(userLocation);
			}
			else {
				userLocation = (UserLocation)session.merge(userLocation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			UserLocationImpl.class, userLocationModelImpl, false, true);

		cacheUniqueFindersCache(userLocationModelImpl);

		if (isNew) {
			userLocation.setNew(false);
		}

		userLocation.resetOriginalValues();

		return userLocation;
	}

	/**
	 * Returns the user location with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user location
	 * @return the user location
	 * @throws NoSuchUserLocationException if a user location with the primary key could not be found
	 */
	@Override
	public UserLocation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserLocationException {

		UserLocation userLocation = fetchByPrimaryKey(primaryKey);

		if (userLocation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserLocationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return userLocation;
	}

	/**
	 * Returns the user location with the primary key or throws a <code>NoSuchUserLocationException</code> if it could not be found.
	 *
	 * @param userLocationId the primary key of the user location
	 * @return the user location
	 * @throws NoSuchUserLocationException if a user location with the primary key could not be found
	 */
	@Override
	public UserLocation findByPrimaryKey(long userLocationId)
		throws NoSuchUserLocationException {

		return findByPrimaryKey((Serializable)userLocationId);
	}

	/**
	 * Returns the user location with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userLocationId the primary key of the user location
	 * @return the user location, or <code>null</code> if a user location with the primary key could not be found
	 */
	@Override
	public UserLocation fetchByPrimaryKey(long userLocationId) {
		return fetchByPrimaryKey((Serializable)userLocationId);
	}

	/**
	 * Returns all the user locations.
	 *
	 * @return the user locations
	 */
	@Override
	public List<UserLocation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user locations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @return the range of user locations
	 */
	@Override
	public List<UserLocation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user locations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user locations
	 */
	@Override
	public List<UserLocation> findAll(
		int start, int end, OrderByComparator<UserLocation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user locations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLocationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user locations
	 * @param end the upper bound of the range of user locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user locations
	 */
	@Override
	public List<UserLocation> findAll(
		int start, int end, OrderByComparator<UserLocation> orderByComparator,
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

		List<UserLocation> list = null;

		if (useFinderCache) {
			list = (List<UserLocation>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_USERLOCATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_USERLOCATION;

				sql = sql.concat(UserLocationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<UserLocation>)QueryUtil.list(
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
	 * Removes all the user locations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserLocation userLocation : findAll()) {
			remove(userLocation);
		}
	}

	/**
	 * Returns the number of user locations.
	 *
	 * @return the number of user locations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_USERLOCATION);

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
		return "userLocationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_USERLOCATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UserLocationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user location persistence.
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

		_finderPathWithPaginationFindByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userId"}, true);

		_finderPathWithoutPaginationFindByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		_finderPathFetchByUI_LC = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUI_LC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"userId", "locationCode"}, true);

		_finderPathCountByUI_LC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUI_LC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"userId", "locationCode"}, false);

		_finderPathFetchByUI_LC_RK = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUI_LC_RK",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"userId", "locationCode", "roleKey"}, true);

		_finderPathCountByUI_LC_RK = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUI_LC_RK",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"userId", "locationCode", "roleKey"}, false);

		_finderPathFetchByLocationId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByLocationId",
			new String[] {Long.class.getName()}, new String[] {"locationId"},
			true);

		_finderPathCountByLocationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLocationId",
			new String[] {Long.class.getName()}, new String[] {"locationId"},
			false);

		_finderPathFetchByRK_LC = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByRK_LC",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"roleKey", "locationCode"}, true);

		_finderPathCountByRK_LC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRK_LC",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"roleKey", "locationCode"}, false);

		_setUserLocationUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setUserLocationUtilPersistence(null);

		entityCache.removeCache(UserLocationImpl.class.getName());
	}

	private void _setUserLocationUtilPersistence(
		UserLocationPersistence userLocationPersistence) {

		try {
			Field field = UserLocationUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, userLocationPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = PersistenceConstants.SERVICE_CONFIGURATION_FILTER, unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = PersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = PersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_USERLOCATION =
		"SELECT userLocation FROM UserLocation userLocation";

	private static final String _SQL_SELECT_USERLOCATION_WHERE =
		"SELECT userLocation FROM UserLocation userLocation WHERE ";

	private static final String _SQL_COUNT_USERLOCATION =
		"SELECT COUNT(userLocation) FROM UserLocation userLocation";

	private static final String _SQL_COUNT_USERLOCATION_WHERE =
		"SELECT COUNT(userLocation) FROM UserLocation userLocation WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "userLocation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UserLocation exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No UserLocation exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		UserLocationPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private UserLocationModelArgumentsResolver
		_userLocationModelArgumentsResolver;

}