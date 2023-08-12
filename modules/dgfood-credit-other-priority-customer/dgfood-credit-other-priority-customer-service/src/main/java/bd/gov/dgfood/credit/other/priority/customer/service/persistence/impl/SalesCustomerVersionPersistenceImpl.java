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

package bd.gov.dgfood.credit.other.priority.customer.service.persistence.impl;

import bd.gov.dgfood.credit.other.priority.customer.exception.NoSuchSalesCustomerVersionException;
import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerVersion;
import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerVersionTable;
import bd.gov.dgfood.credit.other.priority.customer.model.impl.SalesCustomerVersionImpl;
import bd.gov.dgfood.credit.other.priority.customer.model.impl.SalesCustomerVersionModelImpl;
import bd.gov.dgfood.credit.other.priority.customer.service.persistence.SalesCustomerVersionPersistence;
import bd.gov.dgfood.credit.other.priority.customer.service.persistence.SalesCustomerVersionUtil;
import bd.gov.dgfood.credit.other.priority.customer.service.persistence.impl.constants.DGFOODPersistenceConstants;

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
 * The persistence implementation for the sales customer version service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {SalesCustomerVersionPersistence.class, BasePersistence.class}
)
public class SalesCustomerVersionPersistenceImpl
	extends BasePersistenceImpl<SalesCustomerVersion>
	implements SalesCustomerVersionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SalesCustomerVersionUtil</code> to access the sales customer version persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SalesCustomerVersionImpl.class.getName();

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
	 * Returns all the sales customer versions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sales customer versions
	 */
	@Override
	public List<SalesCustomerVersion> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sales customer versions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sales customer versions
	 * @param end the upper bound of the range of sales customer versions (not inclusive)
	 * @return the range of matching sales customer versions
	 */
	@Override
	public List<SalesCustomerVersion> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sales customer versions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sales customer versions
	 * @param end the upper bound of the range of sales customer versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sales customer versions
	 */
	@Override
	public List<SalesCustomerVersion> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SalesCustomerVersion> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sales customer versions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sales customer versions
	 * @param end the upper bound of the range of sales customer versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sales customer versions
	 */
	@Override
	public List<SalesCustomerVersion> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SalesCustomerVersion> orderByComparator,
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

		List<SalesCustomerVersion> list = null;

		if (useFinderCache) {
			list = (List<SalesCustomerVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SalesCustomerVersion salesCustomerVersion : list) {
					if (!uuid.equals(salesCustomerVersion.getUuid())) {
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

			sb.append(_SQL_SELECT_SALESCUSTOMERVERSION_WHERE);

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
				sb.append(SalesCustomerVersionModelImpl.ORDER_BY_JPQL);
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

				list = (List<SalesCustomerVersion>)QueryUtil.list(
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
	 * Returns the first sales customer version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a matching sales customer version could not be found
	 */
	@Override
	public SalesCustomerVersion findByUuid_First(
			String uuid,
			OrderByComparator<SalesCustomerVersion> orderByComparator)
		throws NoSuchSalesCustomerVersionException {

		SalesCustomerVersion salesCustomerVersion = fetchByUuid_First(
			uuid, orderByComparator);

		if (salesCustomerVersion != null) {
			return salesCustomerVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSalesCustomerVersionException(sb.toString());
	}

	/**
	 * Returns the first sales customer version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer version, or <code>null</code> if a matching sales customer version could not be found
	 */
	@Override
	public SalesCustomerVersion fetchByUuid_First(
		String uuid,
		OrderByComparator<SalesCustomerVersion> orderByComparator) {

		List<SalesCustomerVersion> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sales customer version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a matching sales customer version could not be found
	 */
	@Override
	public SalesCustomerVersion findByUuid_Last(
			String uuid,
			OrderByComparator<SalesCustomerVersion> orderByComparator)
		throws NoSuchSalesCustomerVersionException {

		SalesCustomerVersion salesCustomerVersion = fetchByUuid_Last(
			uuid, orderByComparator);

		if (salesCustomerVersion != null) {
			return salesCustomerVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSalesCustomerVersionException(sb.toString());
	}

	/**
	 * Returns the last sales customer version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer version, or <code>null</code> if a matching sales customer version could not be found
	 */
	@Override
	public SalesCustomerVersion fetchByUuid_Last(
		String uuid,
		OrderByComparator<SalesCustomerVersion> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SalesCustomerVersion> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sales customer versions before and after the current sales customer version in the ordered set where uuid = &#63;.
	 *
	 * @param salesCustomerVersionId the primary key of the current sales customer version
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a sales customer version with the primary key could not be found
	 */
	@Override
	public SalesCustomerVersion[] findByUuid_PrevAndNext(
			long salesCustomerVersionId, String uuid,
			OrderByComparator<SalesCustomerVersion> orderByComparator)
		throws NoSuchSalesCustomerVersionException {

		uuid = Objects.toString(uuid, "");

		SalesCustomerVersion salesCustomerVersion = findByPrimaryKey(
			salesCustomerVersionId);

		Session session = null;

		try {
			session = openSession();

			SalesCustomerVersion[] array = new SalesCustomerVersionImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, salesCustomerVersion, uuid, orderByComparator, true);

			array[1] = salesCustomerVersion;

			array[2] = getByUuid_PrevAndNext(
				session, salesCustomerVersion, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SalesCustomerVersion getByUuid_PrevAndNext(
		Session session, SalesCustomerVersion salesCustomerVersion, String uuid,
		OrderByComparator<SalesCustomerVersion> orderByComparator,
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

		sb.append(_SQL_SELECT_SALESCUSTOMERVERSION_WHERE);

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
			sb.append(SalesCustomerVersionModelImpl.ORDER_BY_JPQL);
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
						salesCustomerVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SalesCustomerVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sales customer versions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (SalesCustomerVersion salesCustomerVersion :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(salesCustomerVersion);
		}
	}

	/**
	 * Returns the number of sales customer versions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sales customer versions
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SALESCUSTOMERVERSION_WHERE);

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
		"salesCustomerVersion.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(salesCustomerVersion.uuid IS NULL OR salesCustomerVersion.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the sales customer version where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSalesCustomerVersionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a matching sales customer version could not be found
	 */
	@Override
	public SalesCustomerVersion findByUUID_G(String uuid, long groupId)
		throws NoSuchSalesCustomerVersionException {

		SalesCustomerVersion salesCustomerVersion = fetchByUUID_G(
			uuid, groupId);

		if (salesCustomerVersion == null) {
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

			throw new NoSuchSalesCustomerVersionException(sb.toString());
		}

		return salesCustomerVersion;
	}

	/**
	 * Returns the sales customer version where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sales customer version, or <code>null</code> if a matching sales customer version could not be found
	 */
	@Override
	public SalesCustomerVersion fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the sales customer version where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sales customer version, or <code>null</code> if a matching sales customer version could not be found
	 */
	@Override
	public SalesCustomerVersion fetchByUUID_G(
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

		if (result instanceof SalesCustomerVersion) {
			SalesCustomerVersion salesCustomerVersion =
				(SalesCustomerVersion)result;

			if (!Objects.equals(uuid, salesCustomerVersion.getUuid()) ||
				(groupId != salesCustomerVersion.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_SALESCUSTOMERVERSION_WHERE);

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

				List<SalesCustomerVersion> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					SalesCustomerVersion salesCustomerVersion = list.get(0);

					result = salesCustomerVersion;

					cacheResult(salesCustomerVersion);
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
			return (SalesCustomerVersion)result;
		}
	}

	/**
	 * Removes the sales customer version where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the sales customer version that was removed
	 */
	@Override
	public SalesCustomerVersion removeByUUID_G(String uuid, long groupId)
		throws NoSuchSalesCustomerVersionException {

		SalesCustomerVersion salesCustomerVersion = findByUUID_G(uuid, groupId);

		return remove(salesCustomerVersion);
	}

	/**
	 * Returns the number of sales customer versions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching sales customer versions
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SALESCUSTOMERVERSION_WHERE);

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
		"salesCustomerVersion.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(salesCustomerVersion.uuid IS NULL OR salesCustomerVersion.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"salesCustomerVersion.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the sales customer versions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching sales customer versions
	 */
	@Override
	public List<SalesCustomerVersion> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sales customer versions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sales customer versions
	 * @param end the upper bound of the range of sales customer versions (not inclusive)
	 * @return the range of matching sales customer versions
	 */
	@Override
	public List<SalesCustomerVersion> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sales customer versions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sales customer versions
	 * @param end the upper bound of the range of sales customer versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sales customer versions
	 */
	@Override
	public List<SalesCustomerVersion> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SalesCustomerVersion> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sales customer versions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sales customer versions
	 * @param end the upper bound of the range of sales customer versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sales customer versions
	 */
	@Override
	public List<SalesCustomerVersion> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SalesCustomerVersion> orderByComparator,
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

		List<SalesCustomerVersion> list = null;

		if (useFinderCache) {
			list = (List<SalesCustomerVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SalesCustomerVersion salesCustomerVersion : list) {
					if (!uuid.equals(salesCustomerVersion.getUuid()) ||
						(companyId != salesCustomerVersion.getCompanyId())) {

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

			sb.append(_SQL_SELECT_SALESCUSTOMERVERSION_WHERE);

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
				sb.append(SalesCustomerVersionModelImpl.ORDER_BY_JPQL);
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

				list = (List<SalesCustomerVersion>)QueryUtil.list(
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
	 * Returns the first sales customer version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a matching sales customer version could not be found
	 */
	@Override
	public SalesCustomerVersion findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<SalesCustomerVersion> orderByComparator)
		throws NoSuchSalesCustomerVersionException {

		SalesCustomerVersion salesCustomerVersion = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (salesCustomerVersion != null) {
			return salesCustomerVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSalesCustomerVersionException(sb.toString());
	}

	/**
	 * Returns the first sales customer version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer version, or <code>null</code> if a matching sales customer version could not be found
	 */
	@Override
	public SalesCustomerVersion fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<SalesCustomerVersion> orderByComparator) {

		List<SalesCustomerVersion> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sales customer version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a matching sales customer version could not be found
	 */
	@Override
	public SalesCustomerVersion findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<SalesCustomerVersion> orderByComparator)
		throws NoSuchSalesCustomerVersionException {

		SalesCustomerVersion salesCustomerVersion = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (salesCustomerVersion != null) {
			return salesCustomerVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSalesCustomerVersionException(sb.toString());
	}

	/**
	 * Returns the last sales customer version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer version, or <code>null</code> if a matching sales customer version could not be found
	 */
	@Override
	public SalesCustomerVersion fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<SalesCustomerVersion> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SalesCustomerVersion> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sales customer versions before and after the current sales customer version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param salesCustomerVersionId the primary key of the current sales customer version
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a sales customer version with the primary key could not be found
	 */
	@Override
	public SalesCustomerVersion[] findByUuid_C_PrevAndNext(
			long salesCustomerVersionId, String uuid, long companyId,
			OrderByComparator<SalesCustomerVersion> orderByComparator)
		throws NoSuchSalesCustomerVersionException {

		uuid = Objects.toString(uuid, "");

		SalesCustomerVersion salesCustomerVersion = findByPrimaryKey(
			salesCustomerVersionId);

		Session session = null;

		try {
			session = openSession();

			SalesCustomerVersion[] array = new SalesCustomerVersionImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, salesCustomerVersion, uuid, companyId,
				orderByComparator, true);

			array[1] = salesCustomerVersion;

			array[2] = getByUuid_C_PrevAndNext(
				session, salesCustomerVersion, uuid, companyId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SalesCustomerVersion getByUuid_C_PrevAndNext(
		Session session, SalesCustomerVersion salesCustomerVersion, String uuid,
		long companyId,
		OrderByComparator<SalesCustomerVersion> orderByComparator,
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

		sb.append(_SQL_SELECT_SALESCUSTOMERVERSION_WHERE);

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
			sb.append(SalesCustomerVersionModelImpl.ORDER_BY_JPQL);
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
						salesCustomerVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SalesCustomerVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sales customer versions where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (SalesCustomerVersion salesCustomerVersion :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(salesCustomerVersion);
		}
	}

	/**
	 * Returns the number of sales customer versions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching sales customer versions
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SALESCUSTOMERVERSION_WHERE);

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
		"salesCustomerVersion.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(salesCustomerVersion.uuid IS NULL OR salesCustomerVersion.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"salesCustomerVersion.companyId = ?";

	private FinderPath _finderPathFetchBySCI_V;
	private FinderPath _finderPathCountBySCI_V;

	/**
	 * Returns the sales customer version where salesCustomerId = &#63; and version = &#63; or throws a <code>NoSuchSalesCustomerVersionException</code> if it could not be found.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param version the version
	 * @return the matching sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a matching sales customer version could not be found
	 */
	@Override
	public SalesCustomerVersion findBySCI_V(
			long salesCustomerId, double version)
		throws NoSuchSalesCustomerVersionException {

		SalesCustomerVersion salesCustomerVersion = fetchBySCI_V(
			salesCustomerId, version);

		if (salesCustomerVersion == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("salesCustomerId=");
			sb.append(salesCustomerId);

			sb.append(", version=");
			sb.append(version);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchSalesCustomerVersionException(sb.toString());
		}

		return salesCustomerVersion;
	}

	/**
	 * Returns the sales customer version where salesCustomerId = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param version the version
	 * @return the matching sales customer version, or <code>null</code> if a matching sales customer version could not be found
	 */
	@Override
	public SalesCustomerVersion fetchBySCI_V(
		long salesCustomerId, double version) {

		return fetchBySCI_V(salesCustomerId, version, true);
	}

	/**
	 * Returns the sales customer version where salesCustomerId = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param version the version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sales customer version, or <code>null</code> if a matching sales customer version could not be found
	 */
	@Override
	public SalesCustomerVersion fetchBySCI_V(
		long salesCustomerId, double version, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {salesCustomerId, version};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchBySCI_V, finderArgs);
		}

		if (result instanceof SalesCustomerVersion) {
			SalesCustomerVersion salesCustomerVersion =
				(SalesCustomerVersion)result;

			if ((salesCustomerId !=
					salesCustomerVersion.getSalesCustomerId()) ||
				(version != salesCustomerVersion.getVersion())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_SALESCUSTOMERVERSION_WHERE);

			sb.append(_FINDER_COLUMN_SCI_V_SALESCUSTOMERID_2);

			sb.append(_FINDER_COLUMN_SCI_V_VERSION_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(salesCustomerId);

				queryPos.add(version);

				List<SalesCustomerVersion> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBySCI_V, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									salesCustomerId, version
								};
							}

							_log.warn(
								"SalesCustomerVersionPersistenceImpl.fetchBySCI_V(long, double, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					SalesCustomerVersion salesCustomerVersion = list.get(0);

					result = salesCustomerVersion;

					cacheResult(salesCustomerVersion);
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
			return (SalesCustomerVersion)result;
		}
	}

	/**
	 * Removes the sales customer version where salesCustomerId = &#63; and version = &#63; from the database.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param version the version
	 * @return the sales customer version that was removed
	 */
	@Override
	public SalesCustomerVersion removeBySCI_V(
			long salesCustomerId, double version)
		throws NoSuchSalesCustomerVersionException {

		SalesCustomerVersion salesCustomerVersion = findBySCI_V(
			salesCustomerId, version);

		return remove(salesCustomerVersion);
	}

	/**
	 * Returns the number of sales customer versions where salesCustomerId = &#63; and version = &#63;.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param version the version
	 * @return the number of matching sales customer versions
	 */
	@Override
	public int countBySCI_V(long salesCustomerId, double version) {
		FinderPath finderPath = _finderPathCountBySCI_V;

		Object[] finderArgs = new Object[] {salesCustomerId, version};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SALESCUSTOMERVERSION_WHERE);

			sb.append(_FINDER_COLUMN_SCI_V_SALESCUSTOMERID_2);

			sb.append(_FINDER_COLUMN_SCI_V_VERSION_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(salesCustomerId);

				queryPos.add(version);

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

	private static final String _FINDER_COLUMN_SCI_V_SALESCUSTOMERID_2 =
		"salesCustomerVersion.salesCustomerId = ? AND ";

	private static final String _FINDER_COLUMN_SCI_V_VERSION_2 =
		"salesCustomerVersion.version = ?";

	private FinderPath _finderPathWithPaginationFindBySalesCustomerId;
	private FinderPath _finderPathWithoutPaginationFindBySalesCustomerId;
	private FinderPath _finderPathCountBySalesCustomerId;

	/**
	 * Returns all the sales customer versions where salesCustomerId = &#63;.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @return the matching sales customer versions
	 */
	@Override
	public List<SalesCustomerVersion> findBySalesCustomerId(
		long salesCustomerId) {

		return findBySalesCustomerId(
			salesCustomerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sales customer versions where salesCustomerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerVersionModelImpl</code>.
	 * </p>
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param start the lower bound of the range of sales customer versions
	 * @param end the upper bound of the range of sales customer versions (not inclusive)
	 * @return the range of matching sales customer versions
	 */
	@Override
	public List<SalesCustomerVersion> findBySalesCustomerId(
		long salesCustomerId, int start, int end) {

		return findBySalesCustomerId(salesCustomerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sales customer versions where salesCustomerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerVersionModelImpl</code>.
	 * </p>
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param start the lower bound of the range of sales customer versions
	 * @param end the upper bound of the range of sales customer versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sales customer versions
	 */
	@Override
	public List<SalesCustomerVersion> findBySalesCustomerId(
		long salesCustomerId, int start, int end,
		OrderByComparator<SalesCustomerVersion> orderByComparator) {

		return findBySalesCustomerId(
			salesCustomerId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sales customer versions where salesCustomerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerVersionModelImpl</code>.
	 * </p>
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param start the lower bound of the range of sales customer versions
	 * @param end the upper bound of the range of sales customer versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sales customer versions
	 */
	@Override
	public List<SalesCustomerVersion> findBySalesCustomerId(
		long salesCustomerId, int start, int end,
		OrderByComparator<SalesCustomerVersion> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBySalesCustomerId;
				finderArgs = new Object[] {salesCustomerId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySalesCustomerId;
			finderArgs = new Object[] {
				salesCustomerId, start, end, orderByComparator
			};
		}

		List<SalesCustomerVersion> list = null;

		if (useFinderCache) {
			list = (List<SalesCustomerVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SalesCustomerVersion salesCustomerVersion : list) {
					if (salesCustomerId !=
							salesCustomerVersion.getSalesCustomerId()) {

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

			sb.append(_SQL_SELECT_SALESCUSTOMERVERSION_WHERE);

			sb.append(_FINDER_COLUMN_SALESCUSTOMERID_SALESCUSTOMERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SalesCustomerVersionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(salesCustomerId);

				list = (List<SalesCustomerVersion>)QueryUtil.list(
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
	 * Returns the first sales customer version in the ordered set where salesCustomerId = &#63;.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a matching sales customer version could not be found
	 */
	@Override
	public SalesCustomerVersion findBySalesCustomerId_First(
			long salesCustomerId,
			OrderByComparator<SalesCustomerVersion> orderByComparator)
		throws NoSuchSalesCustomerVersionException {

		SalesCustomerVersion salesCustomerVersion =
			fetchBySalesCustomerId_First(salesCustomerId, orderByComparator);

		if (salesCustomerVersion != null) {
			return salesCustomerVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("salesCustomerId=");
		sb.append(salesCustomerId);

		sb.append("}");

		throw new NoSuchSalesCustomerVersionException(sb.toString());
	}

	/**
	 * Returns the first sales customer version in the ordered set where salesCustomerId = &#63;.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer version, or <code>null</code> if a matching sales customer version could not be found
	 */
	@Override
	public SalesCustomerVersion fetchBySalesCustomerId_First(
		long salesCustomerId,
		OrderByComparator<SalesCustomerVersion> orderByComparator) {

		List<SalesCustomerVersion> list = findBySalesCustomerId(
			salesCustomerId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sales customer version in the ordered set where salesCustomerId = &#63;.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a matching sales customer version could not be found
	 */
	@Override
	public SalesCustomerVersion findBySalesCustomerId_Last(
			long salesCustomerId,
			OrderByComparator<SalesCustomerVersion> orderByComparator)
		throws NoSuchSalesCustomerVersionException {

		SalesCustomerVersion salesCustomerVersion = fetchBySalesCustomerId_Last(
			salesCustomerId, orderByComparator);

		if (salesCustomerVersion != null) {
			return salesCustomerVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("salesCustomerId=");
		sb.append(salesCustomerId);

		sb.append("}");

		throw new NoSuchSalesCustomerVersionException(sb.toString());
	}

	/**
	 * Returns the last sales customer version in the ordered set where salesCustomerId = &#63;.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer version, or <code>null</code> if a matching sales customer version could not be found
	 */
	@Override
	public SalesCustomerVersion fetchBySalesCustomerId_Last(
		long salesCustomerId,
		OrderByComparator<SalesCustomerVersion> orderByComparator) {

		int count = countBySalesCustomerId(salesCustomerId);

		if (count == 0) {
			return null;
		}

		List<SalesCustomerVersion> list = findBySalesCustomerId(
			salesCustomerId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sales customer versions before and after the current sales customer version in the ordered set where salesCustomerId = &#63;.
	 *
	 * @param salesCustomerVersionId the primary key of the current sales customer version
	 * @param salesCustomerId the sales customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a sales customer version with the primary key could not be found
	 */
	@Override
	public SalesCustomerVersion[] findBySalesCustomerId_PrevAndNext(
			long salesCustomerVersionId, long salesCustomerId,
			OrderByComparator<SalesCustomerVersion> orderByComparator)
		throws NoSuchSalesCustomerVersionException {

		SalesCustomerVersion salesCustomerVersion = findByPrimaryKey(
			salesCustomerVersionId);

		Session session = null;

		try {
			session = openSession();

			SalesCustomerVersion[] array = new SalesCustomerVersionImpl[3];

			array[0] = getBySalesCustomerId_PrevAndNext(
				session, salesCustomerVersion, salesCustomerId,
				orderByComparator, true);

			array[1] = salesCustomerVersion;

			array[2] = getBySalesCustomerId_PrevAndNext(
				session, salesCustomerVersion, salesCustomerId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SalesCustomerVersion getBySalesCustomerId_PrevAndNext(
		Session session, SalesCustomerVersion salesCustomerVersion,
		long salesCustomerId,
		OrderByComparator<SalesCustomerVersion> orderByComparator,
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

		sb.append(_SQL_SELECT_SALESCUSTOMERVERSION_WHERE);

		sb.append(_FINDER_COLUMN_SALESCUSTOMERID_SALESCUSTOMERID_2);

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
			sb.append(SalesCustomerVersionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(salesCustomerId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						salesCustomerVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SalesCustomerVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sales customer versions where salesCustomerId = &#63; from the database.
	 *
	 * @param salesCustomerId the sales customer ID
	 */
	@Override
	public void removeBySalesCustomerId(long salesCustomerId) {
		for (SalesCustomerVersion salesCustomerVersion :
				findBySalesCustomerId(
					salesCustomerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(salesCustomerVersion);
		}
	}

	/**
	 * Returns the number of sales customer versions where salesCustomerId = &#63;.
	 *
	 * @param salesCustomerId the sales customer ID
	 * @return the number of matching sales customer versions
	 */
	@Override
	public int countBySalesCustomerId(long salesCustomerId) {
		FinderPath finderPath = _finderPathCountBySalesCustomerId;

		Object[] finderArgs = new Object[] {salesCustomerId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SALESCUSTOMERVERSION_WHERE);

			sb.append(_FINDER_COLUMN_SALESCUSTOMERID_SALESCUSTOMERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(salesCustomerId);

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
		_FINDER_COLUMN_SALESCUSTOMERID_SALESCUSTOMERID_2 =
			"salesCustomerVersion.salesCustomerId = ?";

	public SalesCustomerVersionPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SalesCustomerVersion.class);

		setModelImplClass(SalesCustomerVersionImpl.class);
		setModelPKClass(long.class);

		setTable(SalesCustomerVersionTable.INSTANCE);
	}

	/**
	 * Caches the sales customer version in the entity cache if it is enabled.
	 *
	 * @param salesCustomerVersion the sales customer version
	 */
	@Override
	public void cacheResult(SalesCustomerVersion salesCustomerVersion) {
		entityCache.putResult(
			SalesCustomerVersionImpl.class,
			salesCustomerVersion.getPrimaryKey(), salesCustomerVersion);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				salesCustomerVersion.getUuid(),
				salesCustomerVersion.getGroupId()
			},
			salesCustomerVersion);

		finderCache.putResult(
			_finderPathFetchBySCI_V,
			new Object[] {
				salesCustomerVersion.getSalesCustomerId(),
				salesCustomerVersion.getVersion()
			},
			salesCustomerVersion);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the sales customer versions in the entity cache if it is enabled.
	 *
	 * @param salesCustomerVersions the sales customer versions
	 */
	@Override
	public void cacheResult(List<SalesCustomerVersion> salesCustomerVersions) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (salesCustomerVersions.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SalesCustomerVersion salesCustomerVersion :
				salesCustomerVersions) {

			if (entityCache.getResult(
					SalesCustomerVersionImpl.class,
					salesCustomerVersion.getPrimaryKey()) == null) {

				cacheResult(salesCustomerVersion);
			}
		}
	}

	/**
	 * Clears the cache for all sales customer versions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SalesCustomerVersionImpl.class);

		finderCache.clearCache(SalesCustomerVersionImpl.class);
	}

	/**
	 * Clears the cache for the sales customer version.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SalesCustomerVersion salesCustomerVersion) {
		entityCache.removeResult(
			SalesCustomerVersionImpl.class, salesCustomerVersion);
	}

	@Override
	public void clearCache(List<SalesCustomerVersion> salesCustomerVersions) {
		for (SalesCustomerVersion salesCustomerVersion :
				salesCustomerVersions) {

			entityCache.removeResult(
				SalesCustomerVersionImpl.class, salesCustomerVersion);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SalesCustomerVersionImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				SalesCustomerVersionImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		SalesCustomerVersionModelImpl salesCustomerVersionModelImpl) {

		Object[] args = new Object[] {
			salesCustomerVersionModelImpl.getUuid(),
			salesCustomerVersionModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, salesCustomerVersionModelImpl);

		args = new Object[] {
			salesCustomerVersionModelImpl.getSalesCustomerId(),
			salesCustomerVersionModelImpl.getVersion()
		};

		finderCache.putResult(_finderPathCountBySCI_V, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchBySCI_V, args, salesCustomerVersionModelImpl);
	}

	/**
	 * Creates a new sales customer version with the primary key. Does not add the sales customer version to the database.
	 *
	 * @param salesCustomerVersionId the primary key for the new sales customer version
	 * @return the new sales customer version
	 */
	@Override
	public SalesCustomerVersion create(long salesCustomerVersionId) {
		SalesCustomerVersion salesCustomerVersion =
			new SalesCustomerVersionImpl();

		salesCustomerVersion.setNew(true);
		salesCustomerVersion.setPrimaryKey(salesCustomerVersionId);

		String uuid = _portalUUID.generate();

		salesCustomerVersion.setUuid(uuid);

		salesCustomerVersion.setCompanyId(CompanyThreadLocal.getCompanyId());

		return salesCustomerVersion;
	}

	/**
	 * Removes the sales customer version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param salesCustomerVersionId the primary key of the sales customer version
	 * @return the sales customer version that was removed
	 * @throws NoSuchSalesCustomerVersionException if a sales customer version with the primary key could not be found
	 */
	@Override
	public SalesCustomerVersion remove(long salesCustomerVersionId)
		throws NoSuchSalesCustomerVersionException {

		return remove((Serializable)salesCustomerVersionId);
	}

	/**
	 * Removes the sales customer version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sales customer version
	 * @return the sales customer version that was removed
	 * @throws NoSuchSalesCustomerVersionException if a sales customer version with the primary key could not be found
	 */
	@Override
	public SalesCustomerVersion remove(Serializable primaryKey)
		throws NoSuchSalesCustomerVersionException {

		Session session = null;

		try {
			session = openSession();

			SalesCustomerVersion salesCustomerVersion =
				(SalesCustomerVersion)session.get(
					SalesCustomerVersionImpl.class, primaryKey);

			if (salesCustomerVersion == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSalesCustomerVersionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(salesCustomerVersion);
		}
		catch (NoSuchSalesCustomerVersionException noSuchEntityException) {
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
	protected SalesCustomerVersion removeImpl(
		SalesCustomerVersion salesCustomerVersion) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(salesCustomerVersion)) {
				salesCustomerVersion = (SalesCustomerVersion)session.get(
					SalesCustomerVersionImpl.class,
					salesCustomerVersion.getPrimaryKeyObj());
			}

			if (salesCustomerVersion != null) {
				session.delete(salesCustomerVersion);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (salesCustomerVersion != null) {
			clearCache(salesCustomerVersion);
		}

		return salesCustomerVersion;
	}

	@Override
	public SalesCustomerVersion updateImpl(
		SalesCustomerVersion salesCustomerVersion) {

		boolean isNew = salesCustomerVersion.isNew();

		if (!(salesCustomerVersion instanceof SalesCustomerVersionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(salesCustomerVersion.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					salesCustomerVersion);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in salesCustomerVersion proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SalesCustomerVersion implementation " +
					salesCustomerVersion.getClass());
		}

		SalesCustomerVersionModelImpl salesCustomerVersionModelImpl =
			(SalesCustomerVersionModelImpl)salesCustomerVersion;

		if (Validator.isNull(salesCustomerVersion.getUuid())) {
			String uuid = _portalUUID.generate();

			salesCustomerVersion.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (salesCustomerVersion.getCreateDate() == null)) {
			if (serviceContext == null) {
				salesCustomerVersion.setCreateDate(date);
			}
			else {
				salesCustomerVersion.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!salesCustomerVersionModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				salesCustomerVersion.setModifiedDate(date);
			}
			else {
				salesCustomerVersion.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(salesCustomerVersion);
			}
			else {
				salesCustomerVersion = (SalesCustomerVersion)session.merge(
					salesCustomerVersion);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SalesCustomerVersionImpl.class, salesCustomerVersionModelImpl,
			false, true);

		cacheUniqueFindersCache(salesCustomerVersionModelImpl);

		if (isNew) {
			salesCustomerVersion.setNew(false);
		}

		salesCustomerVersion.resetOriginalValues();

		return salesCustomerVersion;
	}

	/**
	 * Returns the sales customer version with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sales customer version
	 * @return the sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a sales customer version with the primary key could not be found
	 */
	@Override
	public SalesCustomerVersion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSalesCustomerVersionException {

		SalesCustomerVersion salesCustomerVersion = fetchByPrimaryKey(
			primaryKey);

		if (salesCustomerVersion == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSalesCustomerVersionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return salesCustomerVersion;
	}

	/**
	 * Returns the sales customer version with the primary key or throws a <code>NoSuchSalesCustomerVersionException</code> if it could not be found.
	 *
	 * @param salesCustomerVersionId the primary key of the sales customer version
	 * @return the sales customer version
	 * @throws NoSuchSalesCustomerVersionException if a sales customer version with the primary key could not be found
	 */
	@Override
	public SalesCustomerVersion findByPrimaryKey(long salesCustomerVersionId)
		throws NoSuchSalesCustomerVersionException {

		return findByPrimaryKey((Serializable)salesCustomerVersionId);
	}

	/**
	 * Returns the sales customer version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param salesCustomerVersionId the primary key of the sales customer version
	 * @return the sales customer version, or <code>null</code> if a sales customer version with the primary key could not be found
	 */
	@Override
	public SalesCustomerVersion fetchByPrimaryKey(long salesCustomerVersionId) {
		return fetchByPrimaryKey((Serializable)salesCustomerVersionId);
	}

	/**
	 * Returns all the sales customer versions.
	 *
	 * @return the sales customer versions
	 */
	@Override
	public List<SalesCustomerVersion> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sales customer versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sales customer versions
	 * @param end the upper bound of the range of sales customer versions (not inclusive)
	 * @return the range of sales customer versions
	 */
	@Override
	public List<SalesCustomerVersion> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sales customer versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sales customer versions
	 * @param end the upper bound of the range of sales customer versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sales customer versions
	 */
	@Override
	public List<SalesCustomerVersion> findAll(
		int start, int end,
		OrderByComparator<SalesCustomerVersion> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sales customer versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sales customer versions
	 * @param end the upper bound of the range of sales customer versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sales customer versions
	 */
	@Override
	public List<SalesCustomerVersion> findAll(
		int start, int end,
		OrderByComparator<SalesCustomerVersion> orderByComparator,
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

		List<SalesCustomerVersion> list = null;

		if (useFinderCache) {
			list = (List<SalesCustomerVersion>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SALESCUSTOMERVERSION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SALESCUSTOMERVERSION;

				sql = sql.concat(SalesCustomerVersionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SalesCustomerVersion>)QueryUtil.list(
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
	 * Removes all the sales customer versions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SalesCustomerVersion salesCustomerVersion : findAll()) {
			remove(salesCustomerVersion);
		}
	}

	/**
	 * Returns the number of sales customer versions.
	 *
	 * @return the number of sales customer versions
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
					_SQL_COUNT_SALESCUSTOMERVERSION);

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
		return "salesCustomerVersionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SALESCUSTOMERVERSION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SalesCustomerVersionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sales customer version persistence.
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

		_finderPathFetchBySCI_V = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBySCI_V",
			new String[] {Long.class.getName(), Double.class.getName()},
			new String[] {"salesCustomerId", "version"}, true);

		_finderPathCountBySCI_V = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySCI_V",
			new String[] {Long.class.getName(), Double.class.getName()},
			new String[] {"salesCustomerId", "version"}, false);

		_finderPathWithPaginationFindBySalesCustomerId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySalesCustomerId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"salesCustomerId"}, true);

		_finderPathWithoutPaginationFindBySalesCustomerId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySalesCustomerId",
			new String[] {Long.class.getName()},
			new String[] {"salesCustomerId"}, true);

		_finderPathCountBySalesCustomerId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySalesCustomerId",
			new String[] {Long.class.getName()},
			new String[] {"salesCustomerId"}, false);

		_setSalesCustomerVersionUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSalesCustomerVersionUtilPersistence(null);

		entityCache.removeCache(SalesCustomerVersionImpl.class.getName());
	}

	private void _setSalesCustomerVersionUtilPersistence(
		SalesCustomerVersionPersistence salesCustomerVersionPersistence) {

		try {
			Field field = SalesCustomerVersionUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, salesCustomerVersionPersistence);
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

	private static final String _SQL_SELECT_SALESCUSTOMERVERSION =
		"SELECT salesCustomerVersion FROM SalesCustomerVersion salesCustomerVersion";

	private static final String _SQL_SELECT_SALESCUSTOMERVERSION_WHERE =
		"SELECT salesCustomerVersion FROM SalesCustomerVersion salesCustomerVersion WHERE ";

	private static final String _SQL_COUNT_SALESCUSTOMERVERSION =
		"SELECT COUNT(salesCustomerVersion) FROM SalesCustomerVersion salesCustomerVersion";

	private static final String _SQL_COUNT_SALESCUSTOMERVERSION_WHERE =
		"SELECT COUNT(salesCustomerVersion) FROM SalesCustomerVersion salesCustomerVersion WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"salesCustomerVersion.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SalesCustomerVersion exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SalesCustomerVersion exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SalesCustomerVersionPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private SalesCustomerVersionModelArgumentsResolver
		_salesCustomerVersionModelArgumentsResolver;

}