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

import bd.gov.dgfood.credit.other.priority.customer.exception.NoSuchSalesCustomerException;
import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer;
import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerTable;
import bd.gov.dgfood.credit.other.priority.customer.model.impl.SalesCustomerImpl;
import bd.gov.dgfood.credit.other.priority.customer.model.impl.SalesCustomerModelImpl;
import bd.gov.dgfood.credit.other.priority.customer.service.persistence.SalesCustomerPersistence;
import bd.gov.dgfood.credit.other.priority.customer.service.persistence.SalesCustomerUtil;
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
 * The persistence implementation for the sales customer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {SalesCustomerPersistence.class, BasePersistence.class})
public class SalesCustomerPersistenceImpl
	extends BasePersistenceImpl<SalesCustomer>
	implements SalesCustomerPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SalesCustomerUtil</code> to access the sales customer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SalesCustomerImpl.class.getName();

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
	 * Returns all the sales customers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sales customers
	 */
	@Override
	public List<SalesCustomer> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sales customers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sales customers
	 * @param end the upper bound of the range of sales customers (not inclusive)
	 * @return the range of matching sales customers
	 */
	@Override
	public List<SalesCustomer> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sales customers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sales customers
	 * @param end the upper bound of the range of sales customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sales customers
	 */
	@Override
	public List<SalesCustomer> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SalesCustomer> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sales customers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sales customers
	 * @param end the upper bound of the range of sales customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sales customers
	 */
	@Override
	public List<SalesCustomer> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SalesCustomer> orderByComparator,
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

		List<SalesCustomer> list = null;

		if (useFinderCache) {
			list = (List<SalesCustomer>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SalesCustomer salesCustomer : list) {
					if (!uuid.equals(salesCustomer.getUuid())) {
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

			sb.append(_SQL_SELECT_SALESCUSTOMER_WHERE);

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
				sb.append(SalesCustomerModelImpl.ORDER_BY_JPQL);
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

				list = (List<SalesCustomer>)QueryUtil.list(
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
	 * Returns the first sales customer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer
	 * @throws NoSuchSalesCustomerException if a matching sales customer could not be found
	 */
	@Override
	public SalesCustomer findByUuid_First(
			String uuid, OrderByComparator<SalesCustomer> orderByComparator)
		throws NoSuchSalesCustomerException {

		SalesCustomer salesCustomer = fetchByUuid_First(
			uuid, orderByComparator);

		if (salesCustomer != null) {
			return salesCustomer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSalesCustomerException(sb.toString());
	}

	/**
	 * Returns the first sales customer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer, or <code>null</code> if a matching sales customer could not be found
	 */
	@Override
	public SalesCustomer fetchByUuid_First(
		String uuid, OrderByComparator<SalesCustomer> orderByComparator) {

		List<SalesCustomer> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sales customer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer
	 * @throws NoSuchSalesCustomerException if a matching sales customer could not be found
	 */
	@Override
	public SalesCustomer findByUuid_Last(
			String uuid, OrderByComparator<SalesCustomer> orderByComparator)
		throws NoSuchSalesCustomerException {

		SalesCustomer salesCustomer = fetchByUuid_Last(uuid, orderByComparator);

		if (salesCustomer != null) {
			return salesCustomer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSalesCustomerException(sb.toString());
	}

	/**
	 * Returns the last sales customer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer, or <code>null</code> if a matching sales customer could not be found
	 */
	@Override
	public SalesCustomer fetchByUuid_Last(
		String uuid, OrderByComparator<SalesCustomer> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SalesCustomer> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sales customers before and after the current sales customer in the ordered set where uuid = &#63;.
	 *
	 * @param salesCustomerId the primary key of the current sales customer
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sales customer
	 * @throws NoSuchSalesCustomerException if a sales customer with the primary key could not be found
	 */
	@Override
	public SalesCustomer[] findByUuid_PrevAndNext(
			long salesCustomerId, String uuid,
			OrderByComparator<SalesCustomer> orderByComparator)
		throws NoSuchSalesCustomerException {

		uuid = Objects.toString(uuid, "");

		SalesCustomer salesCustomer = findByPrimaryKey(salesCustomerId);

		Session session = null;

		try {
			session = openSession();

			SalesCustomer[] array = new SalesCustomerImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, salesCustomer, uuid, orderByComparator, true);

			array[1] = salesCustomer;

			array[2] = getByUuid_PrevAndNext(
				session, salesCustomer, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SalesCustomer getByUuid_PrevAndNext(
		Session session, SalesCustomer salesCustomer, String uuid,
		OrderByComparator<SalesCustomer> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SALESCUSTOMER_WHERE);

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
			sb.append(SalesCustomerModelImpl.ORDER_BY_JPQL);
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
						salesCustomer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SalesCustomer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sales customers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (SalesCustomer salesCustomer :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(salesCustomer);
		}
	}

	/**
	 * Returns the number of sales customers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sales customers
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SALESCUSTOMER_WHERE);

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
		"salesCustomer.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(salesCustomer.uuid IS NULL OR salesCustomer.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the sales customer where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSalesCustomerException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sales customer
	 * @throws NoSuchSalesCustomerException if a matching sales customer could not be found
	 */
	@Override
	public SalesCustomer findByUUID_G(String uuid, long groupId)
		throws NoSuchSalesCustomerException {

		SalesCustomer salesCustomer = fetchByUUID_G(uuid, groupId);

		if (salesCustomer == null) {
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

			throw new NoSuchSalesCustomerException(sb.toString());
		}

		return salesCustomer;
	}

	/**
	 * Returns the sales customer where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sales customer, or <code>null</code> if a matching sales customer could not be found
	 */
	@Override
	public SalesCustomer fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the sales customer where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sales customer, or <code>null</code> if a matching sales customer could not be found
	 */
	@Override
	public SalesCustomer fetchByUUID_G(
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

		if (result instanceof SalesCustomer) {
			SalesCustomer salesCustomer = (SalesCustomer)result;

			if (!Objects.equals(uuid, salesCustomer.getUuid()) ||
				(groupId != salesCustomer.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_SALESCUSTOMER_WHERE);

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

				List<SalesCustomer> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					SalesCustomer salesCustomer = list.get(0);

					result = salesCustomer;

					cacheResult(salesCustomer);
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
			return (SalesCustomer)result;
		}
	}

	/**
	 * Removes the sales customer where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the sales customer that was removed
	 */
	@Override
	public SalesCustomer removeByUUID_G(String uuid, long groupId)
		throws NoSuchSalesCustomerException {

		SalesCustomer salesCustomer = findByUUID_G(uuid, groupId);

		return remove(salesCustomer);
	}

	/**
	 * Returns the number of sales customers where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching sales customers
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SALESCUSTOMER_WHERE);

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
		"salesCustomer.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(salesCustomer.uuid IS NULL OR salesCustomer.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"salesCustomer.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the sales customers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching sales customers
	 */
	@Override
	public List<SalesCustomer> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sales customers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sales customers
	 * @param end the upper bound of the range of sales customers (not inclusive)
	 * @return the range of matching sales customers
	 */
	@Override
	public List<SalesCustomer> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sales customers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sales customers
	 * @param end the upper bound of the range of sales customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sales customers
	 */
	@Override
	public List<SalesCustomer> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SalesCustomer> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sales customers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sales customers
	 * @param end the upper bound of the range of sales customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sales customers
	 */
	@Override
	public List<SalesCustomer> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SalesCustomer> orderByComparator,
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

		List<SalesCustomer> list = null;

		if (useFinderCache) {
			list = (List<SalesCustomer>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SalesCustomer salesCustomer : list) {
					if (!uuid.equals(salesCustomer.getUuid()) ||
						(companyId != salesCustomer.getCompanyId())) {

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

			sb.append(_SQL_SELECT_SALESCUSTOMER_WHERE);

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
				sb.append(SalesCustomerModelImpl.ORDER_BY_JPQL);
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

				list = (List<SalesCustomer>)QueryUtil.list(
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
	 * Returns the first sales customer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer
	 * @throws NoSuchSalesCustomerException if a matching sales customer could not be found
	 */
	@Override
	public SalesCustomer findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<SalesCustomer> orderByComparator)
		throws NoSuchSalesCustomerException {

		SalesCustomer salesCustomer = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (salesCustomer != null) {
			return salesCustomer;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSalesCustomerException(sb.toString());
	}

	/**
	 * Returns the first sales customer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer, or <code>null</code> if a matching sales customer could not be found
	 */
	@Override
	public SalesCustomer fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<SalesCustomer> orderByComparator) {

		List<SalesCustomer> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sales customer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer
	 * @throws NoSuchSalesCustomerException if a matching sales customer could not be found
	 */
	@Override
	public SalesCustomer findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<SalesCustomer> orderByComparator)
		throws NoSuchSalesCustomerException {

		SalesCustomer salesCustomer = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (salesCustomer != null) {
			return salesCustomer;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSalesCustomerException(sb.toString());
	}

	/**
	 * Returns the last sales customer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer, or <code>null</code> if a matching sales customer could not be found
	 */
	@Override
	public SalesCustomer fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<SalesCustomer> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SalesCustomer> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sales customers before and after the current sales customer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param salesCustomerId the primary key of the current sales customer
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sales customer
	 * @throws NoSuchSalesCustomerException if a sales customer with the primary key could not be found
	 */
	@Override
	public SalesCustomer[] findByUuid_C_PrevAndNext(
			long salesCustomerId, String uuid, long companyId,
			OrderByComparator<SalesCustomer> orderByComparator)
		throws NoSuchSalesCustomerException {

		uuid = Objects.toString(uuid, "");

		SalesCustomer salesCustomer = findByPrimaryKey(salesCustomerId);

		Session session = null;

		try {
			session = openSession();

			SalesCustomer[] array = new SalesCustomerImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, salesCustomer, uuid, companyId, orderByComparator,
				true);

			array[1] = salesCustomer;

			array[2] = getByUuid_C_PrevAndNext(
				session, salesCustomer, uuid, companyId, orderByComparator,
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

	protected SalesCustomer getByUuid_C_PrevAndNext(
		Session session, SalesCustomer salesCustomer, String uuid,
		long companyId, OrderByComparator<SalesCustomer> orderByComparator,
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

		sb.append(_SQL_SELECT_SALESCUSTOMER_WHERE);

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
			sb.append(SalesCustomerModelImpl.ORDER_BY_JPQL);
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
						salesCustomer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SalesCustomer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sales customers where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (SalesCustomer salesCustomer :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(salesCustomer);
		}
	}

	/**
	 * Returns the number of sales customers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching sales customers
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SALESCUSTOMER_WHERE);

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
		"salesCustomer.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(salesCustomer.uuid IS NULL OR salesCustomer.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"salesCustomer.companyId = ?";

	private FinderPath _finderPathFetchByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns the sales customer where userId = &#63; or throws a <code>NoSuchSalesCustomerException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching sales customer
	 * @throws NoSuchSalesCustomerException if a matching sales customer could not be found
	 */
	@Override
	public SalesCustomer findByUserId(long userId)
		throws NoSuchSalesCustomerException {

		SalesCustomer salesCustomer = fetchByUserId(userId);

		if (salesCustomer == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("userId=");
			sb.append(userId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchSalesCustomerException(sb.toString());
		}

		return salesCustomer;
	}

	/**
	 * Returns the sales customer where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching sales customer, or <code>null</code> if a matching sales customer could not be found
	 */
	@Override
	public SalesCustomer fetchByUserId(long userId) {
		return fetchByUserId(userId, true);
	}

	/**
	 * Returns the sales customer where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sales customer, or <code>null</code> if a matching sales customer could not be found
	 */
	@Override
	public SalesCustomer fetchByUserId(long userId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {userId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUserId, finderArgs);
		}

		if (result instanceof SalesCustomer) {
			SalesCustomer salesCustomer = (SalesCustomer)result;

			if (userId != salesCustomer.getUserId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_SALESCUSTOMER_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				List<SalesCustomer> list = query.list();

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
								"SalesCustomerPersistenceImpl.fetchByUserId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					SalesCustomer salesCustomer = list.get(0);

					result = salesCustomer;

					cacheResult(salesCustomer);
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
			return (SalesCustomer)result;
		}
	}

	/**
	 * Removes the sales customer where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the sales customer that was removed
	 */
	@Override
	public SalesCustomer removeByUserId(long userId)
		throws NoSuchSalesCustomerException {

		SalesCustomer salesCustomer = findByUserId(userId);

		return remove(salesCustomer);
	}

	/**
	 * Returns the number of sales customers where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching sales customers
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SALESCUSTOMER_WHERE);

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
		"salesCustomer.userId = ?";

	public SalesCustomerPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SalesCustomer.class);

		setModelImplClass(SalesCustomerImpl.class);
		setModelPKClass(long.class);

		setTable(SalesCustomerTable.INSTANCE);
	}

	/**
	 * Caches the sales customer in the entity cache if it is enabled.
	 *
	 * @param salesCustomer the sales customer
	 */
	@Override
	public void cacheResult(SalesCustomer salesCustomer) {
		entityCache.putResult(
			SalesCustomerImpl.class, salesCustomer.getPrimaryKey(),
			salesCustomer);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {salesCustomer.getUuid(), salesCustomer.getGroupId()},
			salesCustomer);

		finderCache.putResult(
			_finderPathFetchByUserId, new Object[] {salesCustomer.getUserId()},
			salesCustomer);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the sales customers in the entity cache if it is enabled.
	 *
	 * @param salesCustomers the sales customers
	 */
	@Override
	public void cacheResult(List<SalesCustomer> salesCustomers) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (salesCustomers.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SalesCustomer salesCustomer : salesCustomers) {
			if (entityCache.getResult(
					SalesCustomerImpl.class, salesCustomer.getPrimaryKey()) ==
						null) {

				cacheResult(salesCustomer);
			}
		}
	}

	/**
	 * Clears the cache for all sales customers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SalesCustomerImpl.class);

		finderCache.clearCache(SalesCustomerImpl.class);
	}

	/**
	 * Clears the cache for the sales customer.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SalesCustomer salesCustomer) {
		entityCache.removeResult(SalesCustomerImpl.class, salesCustomer);
	}

	@Override
	public void clearCache(List<SalesCustomer> salesCustomers) {
		for (SalesCustomer salesCustomer : salesCustomers) {
			entityCache.removeResult(SalesCustomerImpl.class, salesCustomer);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SalesCustomerImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SalesCustomerImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		SalesCustomerModelImpl salesCustomerModelImpl) {

		Object[] args = new Object[] {
			salesCustomerModelImpl.getUuid(),
			salesCustomerModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, salesCustomerModelImpl);

		args = new Object[] {salesCustomerModelImpl.getUserId()};

		finderCache.putResult(_finderPathCountByUserId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUserId, args, salesCustomerModelImpl);
	}

	/**
	 * Creates a new sales customer with the primary key. Does not add the sales customer to the database.
	 *
	 * @param salesCustomerId the primary key for the new sales customer
	 * @return the new sales customer
	 */
	@Override
	public SalesCustomer create(long salesCustomerId) {
		SalesCustomer salesCustomer = new SalesCustomerImpl();

		salesCustomer.setNew(true);
		salesCustomer.setPrimaryKey(salesCustomerId);

		String uuid = _portalUUID.generate();

		salesCustomer.setUuid(uuid);

		salesCustomer.setCompanyId(CompanyThreadLocal.getCompanyId());

		return salesCustomer;
	}

	/**
	 * Removes the sales customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param salesCustomerId the primary key of the sales customer
	 * @return the sales customer that was removed
	 * @throws NoSuchSalesCustomerException if a sales customer with the primary key could not be found
	 */
	@Override
	public SalesCustomer remove(long salesCustomerId)
		throws NoSuchSalesCustomerException {

		return remove((Serializable)salesCustomerId);
	}

	/**
	 * Removes the sales customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sales customer
	 * @return the sales customer that was removed
	 * @throws NoSuchSalesCustomerException if a sales customer with the primary key could not be found
	 */
	@Override
	public SalesCustomer remove(Serializable primaryKey)
		throws NoSuchSalesCustomerException {

		Session session = null;

		try {
			session = openSession();

			SalesCustomer salesCustomer = (SalesCustomer)session.get(
				SalesCustomerImpl.class, primaryKey);

			if (salesCustomer == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSalesCustomerException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(salesCustomer);
		}
		catch (NoSuchSalesCustomerException noSuchEntityException) {
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
	protected SalesCustomer removeImpl(SalesCustomer salesCustomer) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(salesCustomer)) {
				salesCustomer = (SalesCustomer)session.get(
					SalesCustomerImpl.class, salesCustomer.getPrimaryKeyObj());
			}

			if (salesCustomer != null) {
				session.delete(salesCustomer);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (salesCustomer != null) {
			clearCache(salesCustomer);
		}

		return salesCustomer;
	}

	@Override
	public SalesCustomer updateImpl(SalesCustomer salesCustomer) {
		boolean isNew = salesCustomer.isNew();

		if (!(salesCustomer instanceof SalesCustomerModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(salesCustomer.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					salesCustomer);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in salesCustomer proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SalesCustomer implementation " +
					salesCustomer.getClass());
		}

		SalesCustomerModelImpl salesCustomerModelImpl =
			(SalesCustomerModelImpl)salesCustomer;

		if (Validator.isNull(salesCustomer.getUuid())) {
			String uuid = _portalUUID.generate();

			salesCustomer.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (salesCustomer.getCreateDate() == null)) {
			if (serviceContext == null) {
				salesCustomer.setCreateDate(date);
			}
			else {
				salesCustomer.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!salesCustomerModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				salesCustomer.setModifiedDate(date);
			}
			else {
				salesCustomer.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(salesCustomer);
			}
			else {
				salesCustomer = (SalesCustomer)session.merge(salesCustomer);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SalesCustomerImpl.class, salesCustomerModelImpl, false, true);

		cacheUniqueFindersCache(salesCustomerModelImpl);

		if (isNew) {
			salesCustomer.setNew(false);
		}

		salesCustomer.resetOriginalValues();

		return salesCustomer;
	}

	/**
	 * Returns the sales customer with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sales customer
	 * @return the sales customer
	 * @throws NoSuchSalesCustomerException if a sales customer with the primary key could not be found
	 */
	@Override
	public SalesCustomer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSalesCustomerException {

		SalesCustomer salesCustomer = fetchByPrimaryKey(primaryKey);

		if (salesCustomer == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSalesCustomerException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return salesCustomer;
	}

	/**
	 * Returns the sales customer with the primary key or throws a <code>NoSuchSalesCustomerException</code> if it could not be found.
	 *
	 * @param salesCustomerId the primary key of the sales customer
	 * @return the sales customer
	 * @throws NoSuchSalesCustomerException if a sales customer with the primary key could not be found
	 */
	@Override
	public SalesCustomer findByPrimaryKey(long salesCustomerId)
		throws NoSuchSalesCustomerException {

		return findByPrimaryKey((Serializable)salesCustomerId);
	}

	/**
	 * Returns the sales customer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param salesCustomerId the primary key of the sales customer
	 * @return the sales customer, or <code>null</code> if a sales customer with the primary key could not be found
	 */
	@Override
	public SalesCustomer fetchByPrimaryKey(long salesCustomerId) {
		return fetchByPrimaryKey((Serializable)salesCustomerId);
	}

	/**
	 * Returns all the sales customers.
	 *
	 * @return the sales customers
	 */
	@Override
	public List<SalesCustomer> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sales customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sales customers
	 * @param end the upper bound of the range of sales customers (not inclusive)
	 * @return the range of sales customers
	 */
	@Override
	public List<SalesCustomer> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sales customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sales customers
	 * @param end the upper bound of the range of sales customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sales customers
	 */
	@Override
	public List<SalesCustomer> findAll(
		int start, int end,
		OrderByComparator<SalesCustomer> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sales customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sales customers
	 * @param end the upper bound of the range of sales customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sales customers
	 */
	@Override
	public List<SalesCustomer> findAll(
		int start, int end, OrderByComparator<SalesCustomer> orderByComparator,
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

		List<SalesCustomer> list = null;

		if (useFinderCache) {
			list = (List<SalesCustomer>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SALESCUSTOMER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SALESCUSTOMER;

				sql = sql.concat(SalesCustomerModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SalesCustomer>)QueryUtil.list(
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
	 * Removes all the sales customers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SalesCustomer salesCustomer : findAll()) {
			remove(salesCustomer);
		}
	}

	/**
	 * Returns the number of sales customers.
	 *
	 * @return the number of sales customers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SALESCUSTOMER);

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
		return "salesCustomerId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SALESCUSTOMER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SalesCustomerModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sales customer persistence.
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

		_finderPathFetchByUserId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		_setSalesCustomerUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSalesCustomerUtilPersistence(null);

		entityCache.removeCache(SalesCustomerImpl.class.getName());
	}

	private void _setSalesCustomerUtilPersistence(
		SalesCustomerPersistence salesCustomerPersistence) {

		try {
			Field field = SalesCustomerUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, salesCustomerPersistence);
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

	private static final String _SQL_SELECT_SALESCUSTOMER =
		"SELECT salesCustomer FROM SalesCustomer salesCustomer";

	private static final String _SQL_SELECT_SALESCUSTOMER_WHERE =
		"SELECT salesCustomer FROM SalesCustomer salesCustomer WHERE ";

	private static final String _SQL_COUNT_SALESCUSTOMER =
		"SELECT COUNT(salesCustomer) FROM SalesCustomer salesCustomer";

	private static final String _SQL_COUNT_SALESCUSTOMER_WHERE =
		"SELECT COUNT(salesCustomer) FROM SalesCustomer salesCustomer WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "salesCustomer.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SalesCustomer exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SalesCustomer exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SalesCustomerPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private SalesCustomerModelArgumentsResolver
		_salesCustomerModelArgumentsResolver;

}