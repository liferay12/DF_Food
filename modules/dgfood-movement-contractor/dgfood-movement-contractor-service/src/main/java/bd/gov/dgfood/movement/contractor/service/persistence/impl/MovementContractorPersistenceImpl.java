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

package bd.gov.dgfood.movement.contractor.service.persistence.impl;

import bd.gov.dgfood.movement.contractor.exception.NoSuchMovementContractorException;
import bd.gov.dgfood.movement.contractor.model.MovementContractor;
import bd.gov.dgfood.movement.contractor.model.MovementContractorTable;
import bd.gov.dgfood.movement.contractor.model.impl.MovementContractorImpl;
import bd.gov.dgfood.movement.contractor.model.impl.MovementContractorModelImpl;
import bd.gov.dgfood.movement.contractor.service.persistence.MovementContractorPersistence;
import bd.gov.dgfood.movement.contractor.service.persistence.MovementContractorUtil;
import bd.gov.dgfood.movement.contractor.service.persistence.impl.constants.DGFOODPersistenceConstants;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the movement contractor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {MovementContractorPersistence.class, BasePersistence.class}
)
public class MovementContractorPersistenceImpl
	extends BasePersistenceImpl<MovementContractor>
	implements MovementContractorPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MovementContractorUtil</code> to access the movement contractor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MovementContractorImpl.class.getName();

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
	 * Returns all the movement contractors where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching movement contractors
	 */
	@Override
	public List<MovementContractor> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the movement contractors where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovementContractorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of movement contractors
	 * @param end the upper bound of the range of movement contractors (not inclusive)
	 * @return the range of matching movement contractors
	 */
	@Override
	public List<MovementContractor> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the movement contractors where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovementContractorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of movement contractors
	 * @param end the upper bound of the range of movement contractors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching movement contractors
	 */
	@Override
	public List<MovementContractor> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MovementContractor> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the movement contractors where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovementContractorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of movement contractors
	 * @param end the upper bound of the range of movement contractors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching movement contractors
	 */
	@Override
	public List<MovementContractor> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MovementContractor> orderByComparator,
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

		List<MovementContractor> list = null;

		if (useFinderCache) {
			list = (List<MovementContractor>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (MovementContractor movementContractor : list) {
					if (!uuid.equals(movementContractor.getUuid())) {
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

			sb.append(_SQL_SELECT_MOVEMENTCONTRACTOR_WHERE);

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
				sb.append(MovementContractorModelImpl.ORDER_BY_JPQL);
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

				list = (List<MovementContractor>)QueryUtil.list(
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
	 * Returns the first movement contractor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching movement contractor
	 * @throws NoSuchMovementContractorException if a matching movement contractor could not be found
	 */
	@Override
	public MovementContractor findByUuid_First(
			String uuid,
			OrderByComparator<MovementContractor> orderByComparator)
		throws NoSuchMovementContractorException {

		MovementContractor movementContractor = fetchByUuid_First(
			uuid, orderByComparator);

		if (movementContractor != null) {
			return movementContractor;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchMovementContractorException(sb.toString());
	}

	/**
	 * Returns the first movement contractor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching movement contractor, or <code>null</code> if a matching movement contractor could not be found
	 */
	@Override
	public MovementContractor fetchByUuid_First(
		String uuid, OrderByComparator<MovementContractor> orderByComparator) {

		List<MovementContractor> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last movement contractor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching movement contractor
	 * @throws NoSuchMovementContractorException if a matching movement contractor could not be found
	 */
	@Override
	public MovementContractor findByUuid_Last(
			String uuid,
			OrderByComparator<MovementContractor> orderByComparator)
		throws NoSuchMovementContractorException {

		MovementContractor movementContractor = fetchByUuid_Last(
			uuid, orderByComparator);

		if (movementContractor != null) {
			return movementContractor;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchMovementContractorException(sb.toString());
	}

	/**
	 * Returns the last movement contractor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching movement contractor, or <code>null</code> if a matching movement contractor could not be found
	 */
	@Override
	public MovementContractor fetchByUuid_Last(
		String uuid, OrderByComparator<MovementContractor> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<MovementContractor> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the movement contractors before and after the current movement contractor in the ordered set where uuid = &#63;.
	 *
	 * @param movementContractorId the primary key of the current movement contractor
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next movement contractor
	 * @throws NoSuchMovementContractorException if a movement contractor with the primary key could not be found
	 */
	@Override
	public MovementContractor[] findByUuid_PrevAndNext(
			long movementContractorId, String uuid,
			OrderByComparator<MovementContractor> orderByComparator)
		throws NoSuchMovementContractorException {

		uuid = Objects.toString(uuid, "");

		MovementContractor movementContractor = findByPrimaryKey(
			movementContractorId);

		Session session = null;

		try {
			session = openSession();

			MovementContractor[] array = new MovementContractorImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, movementContractor, uuid, orderByComparator, true);

			array[1] = movementContractor;

			array[2] = getByUuid_PrevAndNext(
				session, movementContractor, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MovementContractor getByUuid_PrevAndNext(
		Session session, MovementContractor movementContractor, String uuid,
		OrderByComparator<MovementContractor> orderByComparator,
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

		sb.append(_SQL_SELECT_MOVEMENTCONTRACTOR_WHERE);

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
			sb.append(MovementContractorModelImpl.ORDER_BY_JPQL);
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
						movementContractor)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MovementContractor> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the movement contractors where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (MovementContractor movementContractor :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(movementContractor);
		}
	}

	/**
	 * Returns the number of movement contractors where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching movement contractors
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOVEMENTCONTRACTOR_WHERE);

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
		"movementContractor.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(movementContractor.uuid IS NULL OR movementContractor.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the movement contractor where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchMovementContractorException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching movement contractor
	 * @throws NoSuchMovementContractorException if a matching movement contractor could not be found
	 */
	@Override
	public MovementContractor findByUUID_G(String uuid, long groupId)
		throws NoSuchMovementContractorException {

		MovementContractor movementContractor = fetchByUUID_G(uuid, groupId);

		if (movementContractor == null) {
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

			throw new NoSuchMovementContractorException(sb.toString());
		}

		return movementContractor;
	}

	/**
	 * Returns the movement contractor where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching movement contractor, or <code>null</code> if a matching movement contractor could not be found
	 */
	@Override
	public MovementContractor fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the movement contractor where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching movement contractor, or <code>null</code> if a matching movement contractor could not be found
	 */
	@Override
	public MovementContractor fetchByUUID_G(
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

		if (result instanceof MovementContractor) {
			MovementContractor movementContractor = (MovementContractor)result;

			if (!Objects.equals(uuid, movementContractor.getUuid()) ||
				(groupId != movementContractor.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_MOVEMENTCONTRACTOR_WHERE);

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

				List<MovementContractor> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					MovementContractor movementContractor = list.get(0);

					result = movementContractor;

					cacheResult(movementContractor);
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
			return (MovementContractor)result;
		}
	}

	/**
	 * Removes the movement contractor where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the movement contractor that was removed
	 */
	@Override
	public MovementContractor removeByUUID_G(String uuid, long groupId)
		throws NoSuchMovementContractorException {

		MovementContractor movementContractor = findByUUID_G(uuid, groupId);

		return remove(movementContractor);
	}

	/**
	 * Returns the number of movement contractors where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching movement contractors
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MOVEMENTCONTRACTOR_WHERE);

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
		"movementContractor.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(movementContractor.uuid IS NULL OR movementContractor.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"movementContractor.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the movement contractors where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching movement contractors
	 */
	@Override
	public List<MovementContractor> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the movement contractors where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovementContractorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of movement contractors
	 * @param end the upper bound of the range of movement contractors (not inclusive)
	 * @return the range of matching movement contractors
	 */
	@Override
	public List<MovementContractor> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the movement contractors where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovementContractorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of movement contractors
	 * @param end the upper bound of the range of movement contractors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching movement contractors
	 */
	@Override
	public List<MovementContractor> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MovementContractor> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the movement contractors where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovementContractorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of movement contractors
	 * @param end the upper bound of the range of movement contractors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching movement contractors
	 */
	@Override
	public List<MovementContractor> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MovementContractor> orderByComparator,
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

		List<MovementContractor> list = null;

		if (useFinderCache) {
			list = (List<MovementContractor>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (MovementContractor movementContractor : list) {
					if (!uuid.equals(movementContractor.getUuid()) ||
						(companyId != movementContractor.getCompanyId())) {

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

			sb.append(_SQL_SELECT_MOVEMENTCONTRACTOR_WHERE);

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
				sb.append(MovementContractorModelImpl.ORDER_BY_JPQL);
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

				list = (List<MovementContractor>)QueryUtil.list(
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
	 * Returns the first movement contractor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching movement contractor
	 * @throws NoSuchMovementContractorException if a matching movement contractor could not be found
	 */
	@Override
	public MovementContractor findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<MovementContractor> orderByComparator)
		throws NoSuchMovementContractorException {

		MovementContractor movementContractor = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (movementContractor != null) {
			return movementContractor;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchMovementContractorException(sb.toString());
	}

	/**
	 * Returns the first movement contractor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching movement contractor, or <code>null</code> if a matching movement contractor could not be found
	 */
	@Override
	public MovementContractor fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<MovementContractor> orderByComparator) {

		List<MovementContractor> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last movement contractor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching movement contractor
	 * @throws NoSuchMovementContractorException if a matching movement contractor could not be found
	 */
	@Override
	public MovementContractor findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<MovementContractor> orderByComparator)
		throws NoSuchMovementContractorException {

		MovementContractor movementContractor = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (movementContractor != null) {
			return movementContractor;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchMovementContractorException(sb.toString());
	}

	/**
	 * Returns the last movement contractor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching movement contractor, or <code>null</code> if a matching movement contractor could not be found
	 */
	@Override
	public MovementContractor fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<MovementContractor> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<MovementContractor> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the movement contractors before and after the current movement contractor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param movementContractorId the primary key of the current movement contractor
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next movement contractor
	 * @throws NoSuchMovementContractorException if a movement contractor with the primary key could not be found
	 */
	@Override
	public MovementContractor[] findByUuid_C_PrevAndNext(
			long movementContractorId, String uuid, long companyId,
			OrderByComparator<MovementContractor> orderByComparator)
		throws NoSuchMovementContractorException {

		uuid = Objects.toString(uuid, "");

		MovementContractor movementContractor = findByPrimaryKey(
			movementContractorId);

		Session session = null;

		try {
			session = openSession();

			MovementContractor[] array = new MovementContractorImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, movementContractor, uuid, companyId, orderByComparator,
				true);

			array[1] = movementContractor;

			array[2] = getByUuid_C_PrevAndNext(
				session, movementContractor, uuid, companyId, orderByComparator,
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

	protected MovementContractor getByUuid_C_PrevAndNext(
		Session session, MovementContractor movementContractor, String uuid,
		long companyId, OrderByComparator<MovementContractor> orderByComparator,
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

		sb.append(_SQL_SELECT_MOVEMENTCONTRACTOR_WHERE);

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
			sb.append(MovementContractorModelImpl.ORDER_BY_JPQL);
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
						movementContractor)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MovementContractor> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the movement contractors where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (MovementContractor movementContractor :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(movementContractor);
		}
	}

	/**
	 * Returns the number of movement contractors where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching movement contractors
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MOVEMENTCONTRACTOR_WHERE);

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
		"movementContractor.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(movementContractor.uuid IS NULL OR movementContractor.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"movementContractor.companyId = ?";

	public MovementContractorPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("type", "type_");
		dbColumnNames.put("password", "password_");

		setDBColumnNames(dbColumnNames);

		setModelClass(MovementContractor.class);

		setModelImplClass(MovementContractorImpl.class);
		setModelPKClass(long.class);

		setTable(MovementContractorTable.INSTANCE);
	}

	/**
	 * Caches the movement contractor in the entity cache if it is enabled.
	 *
	 * @param movementContractor the movement contractor
	 */
	@Override
	public void cacheResult(MovementContractor movementContractor) {
		entityCache.putResult(
			MovementContractorImpl.class, movementContractor.getPrimaryKey(),
			movementContractor);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				movementContractor.getUuid(), movementContractor.getGroupId()
			},
			movementContractor);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the movement contractors in the entity cache if it is enabled.
	 *
	 * @param movementContractors the movement contractors
	 */
	@Override
	public void cacheResult(List<MovementContractor> movementContractors) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (movementContractors.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (MovementContractor movementContractor : movementContractors) {
			if (entityCache.getResult(
					MovementContractorImpl.class,
					movementContractor.getPrimaryKey()) == null) {

				cacheResult(movementContractor);
			}
		}
	}

	/**
	 * Clears the cache for all movement contractors.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MovementContractorImpl.class);

		finderCache.clearCache(MovementContractorImpl.class);
	}

	/**
	 * Clears the cache for the movement contractor.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MovementContractor movementContractor) {
		entityCache.removeResult(
			MovementContractorImpl.class, movementContractor);
	}

	@Override
	public void clearCache(List<MovementContractor> movementContractors) {
		for (MovementContractor movementContractor : movementContractors) {
			entityCache.removeResult(
				MovementContractorImpl.class, movementContractor);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(MovementContractorImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(MovementContractorImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		MovementContractorModelImpl movementContractorModelImpl) {

		Object[] args = new Object[] {
			movementContractorModelImpl.getUuid(),
			movementContractorModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, movementContractorModelImpl);
	}

	/**
	 * Creates a new movement contractor with the primary key. Does not add the movement contractor to the database.
	 *
	 * @param movementContractorId the primary key for the new movement contractor
	 * @return the new movement contractor
	 */
	@Override
	public MovementContractor create(long movementContractorId) {
		MovementContractor movementContractor = new MovementContractorImpl();

		movementContractor.setNew(true);
		movementContractor.setPrimaryKey(movementContractorId);

		String uuid = _portalUUID.generate();

		movementContractor.setUuid(uuid);

		movementContractor.setCompanyId(CompanyThreadLocal.getCompanyId());

		return movementContractor;
	}

	/**
	 * Removes the movement contractor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param movementContractorId the primary key of the movement contractor
	 * @return the movement contractor that was removed
	 * @throws NoSuchMovementContractorException if a movement contractor with the primary key could not be found
	 */
	@Override
	public MovementContractor remove(long movementContractorId)
		throws NoSuchMovementContractorException {

		return remove((Serializable)movementContractorId);
	}

	/**
	 * Removes the movement contractor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the movement contractor
	 * @return the movement contractor that was removed
	 * @throws NoSuchMovementContractorException if a movement contractor with the primary key could not be found
	 */
	@Override
	public MovementContractor remove(Serializable primaryKey)
		throws NoSuchMovementContractorException {

		Session session = null;

		try {
			session = openSession();

			MovementContractor movementContractor =
				(MovementContractor)session.get(
					MovementContractorImpl.class, primaryKey);

			if (movementContractor == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMovementContractorException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(movementContractor);
		}
		catch (NoSuchMovementContractorException noSuchEntityException) {
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
	protected MovementContractor removeImpl(
		MovementContractor movementContractor) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(movementContractor)) {
				movementContractor = (MovementContractor)session.get(
					MovementContractorImpl.class,
					movementContractor.getPrimaryKeyObj());
			}

			if (movementContractor != null) {
				session.delete(movementContractor);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (movementContractor != null) {
			clearCache(movementContractor);
		}

		return movementContractor;
	}

	@Override
	public MovementContractor updateImpl(
		MovementContractor movementContractor) {

		boolean isNew = movementContractor.isNew();

		if (!(movementContractor instanceof MovementContractorModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(movementContractor.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					movementContractor);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in movementContractor proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MovementContractor implementation " +
					movementContractor.getClass());
		}

		MovementContractorModelImpl movementContractorModelImpl =
			(MovementContractorModelImpl)movementContractor;

		if (Validator.isNull(movementContractor.getUuid())) {
			String uuid = _portalUUID.generate();

			movementContractor.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (movementContractor.getCreateDate() == null)) {
			if (serviceContext == null) {
				movementContractor.setCreateDate(date);
			}
			else {
				movementContractor.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!movementContractorModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				movementContractor.setModifiedDate(date);
			}
			else {
				movementContractor.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(movementContractor);
			}
			else {
				movementContractor = (MovementContractor)session.merge(
					movementContractor);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			MovementContractorImpl.class, movementContractorModelImpl, false,
			true);

		cacheUniqueFindersCache(movementContractorModelImpl);

		if (isNew) {
			movementContractor.setNew(false);
		}

		movementContractor.resetOriginalValues();

		return movementContractor;
	}

	/**
	 * Returns the movement contractor with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the movement contractor
	 * @return the movement contractor
	 * @throws NoSuchMovementContractorException if a movement contractor with the primary key could not be found
	 */
	@Override
	public MovementContractor findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMovementContractorException {

		MovementContractor movementContractor = fetchByPrimaryKey(primaryKey);

		if (movementContractor == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMovementContractorException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return movementContractor;
	}

	/**
	 * Returns the movement contractor with the primary key or throws a <code>NoSuchMovementContractorException</code> if it could not be found.
	 *
	 * @param movementContractorId the primary key of the movement contractor
	 * @return the movement contractor
	 * @throws NoSuchMovementContractorException if a movement contractor with the primary key could not be found
	 */
	@Override
	public MovementContractor findByPrimaryKey(long movementContractorId)
		throws NoSuchMovementContractorException {

		return findByPrimaryKey((Serializable)movementContractorId);
	}

	/**
	 * Returns the movement contractor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param movementContractorId the primary key of the movement contractor
	 * @return the movement contractor, or <code>null</code> if a movement contractor with the primary key could not be found
	 */
	@Override
	public MovementContractor fetchByPrimaryKey(long movementContractorId) {
		return fetchByPrimaryKey((Serializable)movementContractorId);
	}

	/**
	 * Returns all the movement contractors.
	 *
	 * @return the movement contractors
	 */
	@Override
	public List<MovementContractor> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the movement contractors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovementContractorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of movement contractors
	 * @param end the upper bound of the range of movement contractors (not inclusive)
	 * @return the range of movement contractors
	 */
	@Override
	public List<MovementContractor> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the movement contractors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovementContractorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of movement contractors
	 * @param end the upper bound of the range of movement contractors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of movement contractors
	 */
	@Override
	public List<MovementContractor> findAll(
		int start, int end,
		OrderByComparator<MovementContractor> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the movement contractors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovementContractorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of movement contractors
	 * @param end the upper bound of the range of movement contractors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of movement contractors
	 */
	@Override
	public List<MovementContractor> findAll(
		int start, int end,
		OrderByComparator<MovementContractor> orderByComparator,
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

		List<MovementContractor> list = null;

		if (useFinderCache) {
			list = (List<MovementContractor>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MOVEMENTCONTRACTOR);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MOVEMENTCONTRACTOR;

				sql = sql.concat(MovementContractorModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MovementContractor>)QueryUtil.list(
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
	 * Removes all the movement contractors from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MovementContractor movementContractor : findAll()) {
			remove(movementContractor);
		}
	}

	/**
	 * Returns the number of movement contractors.
	 *
	 * @return the number of movement contractors
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
					_SQL_COUNT_MOVEMENTCONTRACTOR);

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
		return "movementContractorId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MOVEMENTCONTRACTOR;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MovementContractorModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the movement contractor persistence.
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

		_setMovementContractorUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setMovementContractorUtilPersistence(null);

		entityCache.removeCache(MovementContractorImpl.class.getName());
	}

	private void _setMovementContractorUtilPersistence(
		MovementContractorPersistence movementContractorPersistence) {

		try {
			Field field = MovementContractorUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, movementContractorPersistence);
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

	private static final String _SQL_SELECT_MOVEMENTCONTRACTOR =
		"SELECT movementContractor FROM MovementContractor movementContractor";

	private static final String _SQL_SELECT_MOVEMENTCONTRACTOR_WHERE =
		"SELECT movementContractor FROM MovementContractor movementContractor WHERE ";

	private static final String _SQL_COUNT_MOVEMENTCONTRACTOR =
		"SELECT COUNT(movementContractor) FROM MovementContractor movementContractor";

	private static final String _SQL_COUNT_MOVEMENTCONTRACTOR_WHERE =
		"SELECT COUNT(movementContractor) FROM MovementContractor movementContractor WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "movementContractor.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MovementContractor exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MovementContractor exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MovementContractorPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "type", "password"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private MovementContractorModelArgumentsResolver
		_movementContractorModelArgumentsResolver;

}