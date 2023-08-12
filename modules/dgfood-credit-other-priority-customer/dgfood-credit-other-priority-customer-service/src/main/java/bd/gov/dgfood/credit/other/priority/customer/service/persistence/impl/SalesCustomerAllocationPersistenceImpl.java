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

import bd.gov.dgfood.credit.other.priority.customer.exception.NoSuchSalesCustomerAllocationException;
import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerAllocation;
import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerAllocationTable;
import bd.gov.dgfood.credit.other.priority.customer.model.impl.SalesCustomerAllocationImpl;
import bd.gov.dgfood.credit.other.priority.customer.model.impl.SalesCustomerAllocationModelImpl;
import bd.gov.dgfood.credit.other.priority.customer.service.persistence.SalesCustomerAllocationPersistence;
import bd.gov.dgfood.credit.other.priority.customer.service.persistence.SalesCustomerAllocationUtil;
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
 * The persistence implementation for the sales customer allocation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {SalesCustomerAllocationPersistence.class, BasePersistence.class}
)
public class SalesCustomerAllocationPersistenceImpl
	extends BasePersistenceImpl<SalesCustomerAllocation>
	implements SalesCustomerAllocationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SalesCustomerAllocationUtil</code> to access the sales customer allocation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SalesCustomerAllocationImpl.class.getName();

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
	 * Returns all the sales customer allocations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sales customer allocations
	 */
	@Override
	public List<SalesCustomerAllocation> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sales customer allocations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerAllocationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sales customer allocations
	 * @param end the upper bound of the range of sales customer allocations (not inclusive)
	 * @return the range of matching sales customer allocations
	 */
	@Override
	public List<SalesCustomerAllocation> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sales customer allocations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerAllocationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sales customer allocations
	 * @param end the upper bound of the range of sales customer allocations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sales customer allocations
	 */
	@Override
	public List<SalesCustomerAllocation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SalesCustomerAllocation> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sales customer allocations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerAllocationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sales customer allocations
	 * @param end the upper bound of the range of sales customer allocations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sales customer allocations
	 */
	@Override
	public List<SalesCustomerAllocation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SalesCustomerAllocation> orderByComparator,
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

		List<SalesCustomerAllocation> list = null;

		if (useFinderCache) {
			list = (List<SalesCustomerAllocation>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SalesCustomerAllocation salesCustomerAllocation : list) {
					if (!uuid.equals(salesCustomerAllocation.getUuid())) {
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

			sb.append(_SQL_SELECT_SALESCUSTOMERALLOCATION_WHERE);

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
				sb.append(SalesCustomerAllocationModelImpl.ORDER_BY_JPQL);
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

				list = (List<SalesCustomerAllocation>)QueryUtil.list(
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
	 * Returns the first sales customer allocation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer allocation
	 * @throws NoSuchSalesCustomerAllocationException if a matching sales customer allocation could not be found
	 */
	@Override
	public SalesCustomerAllocation findByUuid_First(
			String uuid,
			OrderByComparator<SalesCustomerAllocation> orderByComparator)
		throws NoSuchSalesCustomerAllocationException {

		SalesCustomerAllocation salesCustomerAllocation = fetchByUuid_First(
			uuid, orderByComparator);

		if (salesCustomerAllocation != null) {
			return salesCustomerAllocation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSalesCustomerAllocationException(sb.toString());
	}

	/**
	 * Returns the first sales customer allocation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer allocation, or <code>null</code> if a matching sales customer allocation could not be found
	 */
	@Override
	public SalesCustomerAllocation fetchByUuid_First(
		String uuid,
		OrderByComparator<SalesCustomerAllocation> orderByComparator) {

		List<SalesCustomerAllocation> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sales customer allocation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer allocation
	 * @throws NoSuchSalesCustomerAllocationException if a matching sales customer allocation could not be found
	 */
	@Override
	public SalesCustomerAllocation findByUuid_Last(
			String uuid,
			OrderByComparator<SalesCustomerAllocation> orderByComparator)
		throws NoSuchSalesCustomerAllocationException {

		SalesCustomerAllocation salesCustomerAllocation = fetchByUuid_Last(
			uuid, orderByComparator);

		if (salesCustomerAllocation != null) {
			return salesCustomerAllocation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSalesCustomerAllocationException(sb.toString());
	}

	/**
	 * Returns the last sales customer allocation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer allocation, or <code>null</code> if a matching sales customer allocation could not be found
	 */
	@Override
	public SalesCustomerAllocation fetchByUuid_Last(
		String uuid,
		OrderByComparator<SalesCustomerAllocation> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SalesCustomerAllocation> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sales customer allocations before and after the current sales customer allocation in the ordered set where uuid = &#63;.
	 *
	 * @param salesCustomerAllocationId the primary key of the current sales customer allocation
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sales customer allocation
	 * @throws NoSuchSalesCustomerAllocationException if a sales customer allocation with the primary key could not be found
	 */
	@Override
	public SalesCustomerAllocation[] findByUuid_PrevAndNext(
			long salesCustomerAllocationId, String uuid,
			OrderByComparator<SalesCustomerAllocation> orderByComparator)
		throws NoSuchSalesCustomerAllocationException {

		uuid = Objects.toString(uuid, "");

		SalesCustomerAllocation salesCustomerAllocation = findByPrimaryKey(
			salesCustomerAllocationId);

		Session session = null;

		try {
			session = openSession();

			SalesCustomerAllocation[] array =
				new SalesCustomerAllocationImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, salesCustomerAllocation, uuid, orderByComparator,
				true);

			array[1] = salesCustomerAllocation;

			array[2] = getByUuid_PrevAndNext(
				session, salesCustomerAllocation, uuid, orderByComparator,
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

	protected SalesCustomerAllocation getByUuid_PrevAndNext(
		Session session, SalesCustomerAllocation salesCustomerAllocation,
		String uuid,
		OrderByComparator<SalesCustomerAllocation> orderByComparator,
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

		sb.append(_SQL_SELECT_SALESCUSTOMERALLOCATION_WHERE);

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
			sb.append(SalesCustomerAllocationModelImpl.ORDER_BY_JPQL);
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
						salesCustomerAllocation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SalesCustomerAllocation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sales customer allocations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (SalesCustomerAllocation salesCustomerAllocation :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(salesCustomerAllocation);
		}
	}

	/**
	 * Returns the number of sales customer allocations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sales customer allocations
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SALESCUSTOMERALLOCATION_WHERE);

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
		"salesCustomerAllocation.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(salesCustomerAllocation.uuid IS NULL OR salesCustomerAllocation.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the sales customer allocations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching sales customer allocations
	 */
	@Override
	public List<SalesCustomerAllocation> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sales customer allocations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerAllocationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sales customer allocations
	 * @param end the upper bound of the range of sales customer allocations (not inclusive)
	 * @return the range of matching sales customer allocations
	 */
	@Override
	public List<SalesCustomerAllocation> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sales customer allocations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerAllocationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sales customer allocations
	 * @param end the upper bound of the range of sales customer allocations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sales customer allocations
	 */
	@Override
	public List<SalesCustomerAllocation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SalesCustomerAllocation> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sales customer allocations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerAllocationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sales customer allocations
	 * @param end the upper bound of the range of sales customer allocations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sales customer allocations
	 */
	@Override
	public List<SalesCustomerAllocation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SalesCustomerAllocation> orderByComparator,
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

		List<SalesCustomerAllocation> list = null;

		if (useFinderCache) {
			list = (List<SalesCustomerAllocation>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SalesCustomerAllocation salesCustomerAllocation : list) {
					if (!uuid.equals(salesCustomerAllocation.getUuid()) ||
						(companyId != salesCustomerAllocation.getCompanyId())) {

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

			sb.append(_SQL_SELECT_SALESCUSTOMERALLOCATION_WHERE);

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
				sb.append(SalesCustomerAllocationModelImpl.ORDER_BY_JPQL);
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

				list = (List<SalesCustomerAllocation>)QueryUtil.list(
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
	 * Returns the first sales customer allocation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer allocation
	 * @throws NoSuchSalesCustomerAllocationException if a matching sales customer allocation could not be found
	 */
	@Override
	public SalesCustomerAllocation findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<SalesCustomerAllocation> orderByComparator)
		throws NoSuchSalesCustomerAllocationException {

		SalesCustomerAllocation salesCustomerAllocation = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (salesCustomerAllocation != null) {
			return salesCustomerAllocation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSalesCustomerAllocationException(sb.toString());
	}

	/**
	 * Returns the first sales customer allocation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales customer allocation, or <code>null</code> if a matching sales customer allocation could not be found
	 */
	@Override
	public SalesCustomerAllocation fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<SalesCustomerAllocation> orderByComparator) {

		List<SalesCustomerAllocation> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sales customer allocation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer allocation
	 * @throws NoSuchSalesCustomerAllocationException if a matching sales customer allocation could not be found
	 */
	@Override
	public SalesCustomerAllocation findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<SalesCustomerAllocation> orderByComparator)
		throws NoSuchSalesCustomerAllocationException {

		SalesCustomerAllocation salesCustomerAllocation = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (salesCustomerAllocation != null) {
			return salesCustomerAllocation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSalesCustomerAllocationException(sb.toString());
	}

	/**
	 * Returns the last sales customer allocation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales customer allocation, or <code>null</code> if a matching sales customer allocation could not be found
	 */
	@Override
	public SalesCustomerAllocation fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<SalesCustomerAllocation> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SalesCustomerAllocation> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sales customer allocations before and after the current sales customer allocation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param salesCustomerAllocationId the primary key of the current sales customer allocation
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sales customer allocation
	 * @throws NoSuchSalesCustomerAllocationException if a sales customer allocation with the primary key could not be found
	 */
	@Override
	public SalesCustomerAllocation[] findByUuid_C_PrevAndNext(
			long salesCustomerAllocationId, String uuid, long companyId,
			OrderByComparator<SalesCustomerAllocation> orderByComparator)
		throws NoSuchSalesCustomerAllocationException {

		uuid = Objects.toString(uuid, "");

		SalesCustomerAllocation salesCustomerAllocation = findByPrimaryKey(
			salesCustomerAllocationId);

		Session session = null;

		try {
			session = openSession();

			SalesCustomerAllocation[] array =
				new SalesCustomerAllocationImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, salesCustomerAllocation, uuid, companyId,
				orderByComparator, true);

			array[1] = salesCustomerAllocation;

			array[2] = getByUuid_C_PrevAndNext(
				session, salesCustomerAllocation, uuid, companyId,
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

	protected SalesCustomerAllocation getByUuid_C_PrevAndNext(
		Session session, SalesCustomerAllocation salesCustomerAllocation,
		String uuid, long companyId,
		OrderByComparator<SalesCustomerAllocation> orderByComparator,
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

		sb.append(_SQL_SELECT_SALESCUSTOMERALLOCATION_WHERE);

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
			sb.append(SalesCustomerAllocationModelImpl.ORDER_BY_JPQL);
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
						salesCustomerAllocation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SalesCustomerAllocation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sales customer allocations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (SalesCustomerAllocation salesCustomerAllocation :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(salesCustomerAllocation);
		}
	}

	/**
	 * Returns the number of sales customer allocations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching sales customer allocations
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SALESCUSTOMERALLOCATION_WHERE);

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
		"salesCustomerAllocation.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(salesCustomerAllocation.uuid IS NULL OR salesCustomerAllocation.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"salesCustomerAllocation.companyId = ?";

	public SalesCustomerAllocationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SalesCustomerAllocation.class);

		setModelImplClass(SalesCustomerAllocationImpl.class);
		setModelPKClass(long.class);

		setTable(SalesCustomerAllocationTable.INSTANCE);
	}

	/**
	 * Caches the sales customer allocation in the entity cache if it is enabled.
	 *
	 * @param salesCustomerAllocation the sales customer allocation
	 */
	@Override
	public void cacheResult(SalesCustomerAllocation salesCustomerAllocation) {
		entityCache.putResult(
			SalesCustomerAllocationImpl.class,
			salesCustomerAllocation.getPrimaryKey(), salesCustomerAllocation);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the sales customer allocations in the entity cache if it is enabled.
	 *
	 * @param salesCustomerAllocations the sales customer allocations
	 */
	@Override
	public void cacheResult(
		List<SalesCustomerAllocation> salesCustomerAllocations) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (salesCustomerAllocations.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SalesCustomerAllocation salesCustomerAllocation :
				salesCustomerAllocations) {

			if (entityCache.getResult(
					SalesCustomerAllocationImpl.class,
					salesCustomerAllocation.getPrimaryKey()) == null) {

				cacheResult(salesCustomerAllocation);
			}
		}
	}

	/**
	 * Clears the cache for all sales customer allocations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SalesCustomerAllocationImpl.class);

		finderCache.clearCache(SalesCustomerAllocationImpl.class);
	}

	/**
	 * Clears the cache for the sales customer allocation.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SalesCustomerAllocation salesCustomerAllocation) {
		entityCache.removeResult(
			SalesCustomerAllocationImpl.class, salesCustomerAllocation);
	}

	@Override
	public void clearCache(
		List<SalesCustomerAllocation> salesCustomerAllocations) {

		for (SalesCustomerAllocation salesCustomerAllocation :
				salesCustomerAllocations) {

			entityCache.removeResult(
				SalesCustomerAllocationImpl.class, salesCustomerAllocation);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SalesCustomerAllocationImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				SalesCustomerAllocationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new sales customer allocation with the primary key. Does not add the sales customer allocation to the database.
	 *
	 * @param salesCustomerAllocationId the primary key for the new sales customer allocation
	 * @return the new sales customer allocation
	 */
	@Override
	public SalesCustomerAllocation create(long salesCustomerAllocationId) {
		SalesCustomerAllocation salesCustomerAllocation =
			new SalesCustomerAllocationImpl();

		salesCustomerAllocation.setNew(true);
		salesCustomerAllocation.setPrimaryKey(salesCustomerAllocationId);

		String uuid = _portalUUID.generate();

		salesCustomerAllocation.setUuid(uuid);

		salesCustomerAllocation.setCompanyId(CompanyThreadLocal.getCompanyId());

		return salesCustomerAllocation;
	}

	/**
	 * Removes the sales customer allocation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param salesCustomerAllocationId the primary key of the sales customer allocation
	 * @return the sales customer allocation that was removed
	 * @throws NoSuchSalesCustomerAllocationException if a sales customer allocation with the primary key could not be found
	 */
	@Override
	public SalesCustomerAllocation remove(long salesCustomerAllocationId)
		throws NoSuchSalesCustomerAllocationException {

		return remove((Serializable)salesCustomerAllocationId);
	}

	/**
	 * Removes the sales customer allocation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sales customer allocation
	 * @return the sales customer allocation that was removed
	 * @throws NoSuchSalesCustomerAllocationException if a sales customer allocation with the primary key could not be found
	 */
	@Override
	public SalesCustomerAllocation remove(Serializable primaryKey)
		throws NoSuchSalesCustomerAllocationException {

		Session session = null;

		try {
			session = openSession();

			SalesCustomerAllocation salesCustomerAllocation =
				(SalesCustomerAllocation)session.get(
					SalesCustomerAllocationImpl.class, primaryKey);

			if (salesCustomerAllocation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSalesCustomerAllocationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(salesCustomerAllocation);
		}
		catch (NoSuchSalesCustomerAllocationException noSuchEntityException) {
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
	protected SalesCustomerAllocation removeImpl(
		SalesCustomerAllocation salesCustomerAllocation) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(salesCustomerAllocation)) {
				salesCustomerAllocation = (SalesCustomerAllocation)session.get(
					SalesCustomerAllocationImpl.class,
					salesCustomerAllocation.getPrimaryKeyObj());
			}

			if (salesCustomerAllocation != null) {
				session.delete(salesCustomerAllocation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (salesCustomerAllocation != null) {
			clearCache(salesCustomerAllocation);
		}

		return salesCustomerAllocation;
	}

	@Override
	public SalesCustomerAllocation updateImpl(
		SalesCustomerAllocation salesCustomerAllocation) {

		boolean isNew = salesCustomerAllocation.isNew();

		if (!(salesCustomerAllocation instanceof
				SalesCustomerAllocationModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(salesCustomerAllocation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					salesCustomerAllocation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in salesCustomerAllocation proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SalesCustomerAllocation implementation " +
					salesCustomerAllocation.getClass());
		}

		SalesCustomerAllocationModelImpl salesCustomerAllocationModelImpl =
			(SalesCustomerAllocationModelImpl)salesCustomerAllocation;

		if (Validator.isNull(salesCustomerAllocation.getUuid())) {
			String uuid = _portalUUID.generate();

			salesCustomerAllocation.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (salesCustomerAllocation.getCreateDate() == null)) {
			if (serviceContext == null) {
				salesCustomerAllocation.setCreateDate(date);
			}
			else {
				salesCustomerAllocation.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!salesCustomerAllocationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				salesCustomerAllocation.setModifiedDate(date);
			}
			else {
				salesCustomerAllocation.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(salesCustomerAllocation);
			}
			else {
				salesCustomerAllocation =
					(SalesCustomerAllocation)session.merge(
						salesCustomerAllocation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SalesCustomerAllocationImpl.class, salesCustomerAllocationModelImpl,
			false, true);

		if (isNew) {
			salesCustomerAllocation.setNew(false);
		}

		salesCustomerAllocation.resetOriginalValues();

		return salesCustomerAllocation;
	}

	/**
	 * Returns the sales customer allocation with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sales customer allocation
	 * @return the sales customer allocation
	 * @throws NoSuchSalesCustomerAllocationException if a sales customer allocation with the primary key could not be found
	 */
	@Override
	public SalesCustomerAllocation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSalesCustomerAllocationException {

		SalesCustomerAllocation salesCustomerAllocation = fetchByPrimaryKey(
			primaryKey);

		if (salesCustomerAllocation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSalesCustomerAllocationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return salesCustomerAllocation;
	}

	/**
	 * Returns the sales customer allocation with the primary key or throws a <code>NoSuchSalesCustomerAllocationException</code> if it could not be found.
	 *
	 * @param salesCustomerAllocationId the primary key of the sales customer allocation
	 * @return the sales customer allocation
	 * @throws NoSuchSalesCustomerAllocationException if a sales customer allocation with the primary key could not be found
	 */
	@Override
	public SalesCustomerAllocation findByPrimaryKey(
			long salesCustomerAllocationId)
		throws NoSuchSalesCustomerAllocationException {

		return findByPrimaryKey((Serializable)salesCustomerAllocationId);
	}

	/**
	 * Returns the sales customer allocation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param salesCustomerAllocationId the primary key of the sales customer allocation
	 * @return the sales customer allocation, or <code>null</code> if a sales customer allocation with the primary key could not be found
	 */
	@Override
	public SalesCustomerAllocation fetchByPrimaryKey(
		long salesCustomerAllocationId) {

		return fetchByPrimaryKey((Serializable)salesCustomerAllocationId);
	}

	/**
	 * Returns all the sales customer allocations.
	 *
	 * @return the sales customer allocations
	 */
	@Override
	public List<SalesCustomerAllocation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sales customer allocations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerAllocationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sales customer allocations
	 * @param end the upper bound of the range of sales customer allocations (not inclusive)
	 * @return the range of sales customer allocations
	 */
	@Override
	public List<SalesCustomerAllocation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sales customer allocations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerAllocationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sales customer allocations
	 * @param end the upper bound of the range of sales customer allocations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sales customer allocations
	 */
	@Override
	public List<SalesCustomerAllocation> findAll(
		int start, int end,
		OrderByComparator<SalesCustomerAllocation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sales customer allocations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesCustomerAllocationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sales customer allocations
	 * @param end the upper bound of the range of sales customer allocations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sales customer allocations
	 */
	@Override
	public List<SalesCustomerAllocation> findAll(
		int start, int end,
		OrderByComparator<SalesCustomerAllocation> orderByComparator,
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

		List<SalesCustomerAllocation> list = null;

		if (useFinderCache) {
			list = (List<SalesCustomerAllocation>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SALESCUSTOMERALLOCATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SALESCUSTOMERALLOCATION;

				sql = sql.concat(
					SalesCustomerAllocationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SalesCustomerAllocation>)QueryUtil.list(
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
	 * Removes all the sales customer allocations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SalesCustomerAllocation salesCustomerAllocation : findAll()) {
			remove(salesCustomerAllocation);
		}
	}

	/**
	 * Returns the number of sales customer allocations.
	 *
	 * @return the number of sales customer allocations
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
					_SQL_COUNT_SALESCUSTOMERALLOCATION);

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
		return "salesCustomerAllocationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SALESCUSTOMERALLOCATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SalesCustomerAllocationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sales customer allocation persistence.
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

		_setSalesCustomerAllocationUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSalesCustomerAllocationUtilPersistence(null);

		entityCache.removeCache(SalesCustomerAllocationImpl.class.getName());
	}

	private void _setSalesCustomerAllocationUtilPersistence(
		SalesCustomerAllocationPersistence salesCustomerAllocationPersistence) {

		try {
			Field field = SalesCustomerAllocationUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, salesCustomerAllocationPersistence);
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

	private static final String _SQL_SELECT_SALESCUSTOMERALLOCATION =
		"SELECT salesCustomerAllocation FROM SalesCustomerAllocation salesCustomerAllocation";

	private static final String _SQL_SELECT_SALESCUSTOMERALLOCATION_WHERE =
		"SELECT salesCustomerAllocation FROM SalesCustomerAllocation salesCustomerAllocation WHERE ";

	private static final String _SQL_COUNT_SALESCUSTOMERALLOCATION =
		"SELECT COUNT(salesCustomerAllocation) FROM SalesCustomerAllocation salesCustomerAllocation";

	private static final String _SQL_COUNT_SALESCUSTOMERALLOCATION_WHERE =
		"SELECT COUNT(salesCustomerAllocation) FROM SalesCustomerAllocation salesCustomerAllocation WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"salesCustomerAllocation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SalesCustomerAllocation exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SalesCustomerAllocation exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SalesCustomerAllocationPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private SalesCustomerAllocationModelArgumentsResolver
		_salesCustomerAllocationModelArgumentsResolver;

}