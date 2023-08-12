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

import bd.gov.dgfood.common.services.exception.NoSuchDeliveryOrderException;
import bd.gov.dgfood.common.services.model.DeliveryOrder;
import bd.gov.dgfood.common.services.model.DeliveryOrderTable;
import bd.gov.dgfood.common.services.model.impl.DeliveryOrderImpl;
import bd.gov.dgfood.common.services.model.impl.DeliveryOrderModelImpl;
import bd.gov.dgfood.common.services.service.persistence.DeliveryOrderPK;
import bd.gov.dgfood.common.services.service.persistence.DeliveryOrderPersistence;
import bd.gov.dgfood.common.services.service.persistence.DeliveryOrderUtil;
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
 * The persistence implementation for the delivery order service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {DeliveryOrderPersistence.class, BasePersistence.class})
public class DeliveryOrderPersistenceImpl
	extends BasePersistenceImpl<DeliveryOrder>
	implements DeliveryOrderPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DeliveryOrderUtil</code> to access the delivery order persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DeliveryOrderImpl.class.getName();

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
	 * Returns all the delivery orders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching delivery orders
	 */
	@Override
	public List<DeliveryOrder> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the delivery orders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliveryOrderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of delivery orders
	 * @param end the upper bound of the range of delivery orders (not inclusive)
	 * @return the range of matching delivery orders
	 */
	@Override
	public List<DeliveryOrder> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the delivery orders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliveryOrderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of delivery orders
	 * @param end the upper bound of the range of delivery orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching delivery orders
	 */
	@Override
	public List<DeliveryOrder> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DeliveryOrder> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the delivery orders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliveryOrderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of delivery orders
	 * @param end the upper bound of the range of delivery orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching delivery orders
	 */
	@Override
	public List<DeliveryOrder> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DeliveryOrder> orderByComparator,
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

		List<DeliveryOrder> list = null;

		if (useFinderCache) {
			list = (List<DeliveryOrder>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DeliveryOrder deliveryOrder : list) {
					if (!uuid.equals(deliveryOrder.getUuid())) {
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

			sb.append(_SQL_SELECT_DELIVERYORDER_WHERE);

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
				sb.append(DeliveryOrderModelImpl.ORDER_BY_JPQL);
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

				list = (List<DeliveryOrder>)QueryUtil.list(
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
	 * Returns the first delivery order in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delivery order
	 * @throws NoSuchDeliveryOrderException if a matching delivery order could not be found
	 */
	@Override
	public DeliveryOrder findByUuid_First(
			String uuid, OrderByComparator<DeliveryOrder> orderByComparator)
		throws NoSuchDeliveryOrderException {

		DeliveryOrder deliveryOrder = fetchByUuid_First(
			uuid, orderByComparator);

		if (deliveryOrder != null) {
			return deliveryOrder;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDeliveryOrderException(sb.toString());
	}

	/**
	 * Returns the first delivery order in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delivery order, or <code>null</code> if a matching delivery order could not be found
	 */
	@Override
	public DeliveryOrder fetchByUuid_First(
		String uuid, OrderByComparator<DeliveryOrder> orderByComparator) {

		List<DeliveryOrder> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last delivery order in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delivery order
	 * @throws NoSuchDeliveryOrderException if a matching delivery order could not be found
	 */
	@Override
	public DeliveryOrder findByUuid_Last(
			String uuid, OrderByComparator<DeliveryOrder> orderByComparator)
		throws NoSuchDeliveryOrderException {

		DeliveryOrder deliveryOrder = fetchByUuid_Last(uuid, orderByComparator);

		if (deliveryOrder != null) {
			return deliveryOrder;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDeliveryOrderException(sb.toString());
	}

	/**
	 * Returns the last delivery order in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delivery order, or <code>null</code> if a matching delivery order could not be found
	 */
	@Override
	public DeliveryOrder fetchByUuid_Last(
		String uuid, OrderByComparator<DeliveryOrder> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DeliveryOrder> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the delivery orders before and after the current delivery order in the ordered set where uuid = &#63;.
	 *
	 * @param deliveryOrderPK the primary key of the current delivery order
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next delivery order
	 * @throws NoSuchDeliveryOrderException if a delivery order with the primary key could not be found
	 */
	@Override
	public DeliveryOrder[] findByUuid_PrevAndNext(
			DeliveryOrderPK deliveryOrderPK, String uuid,
			OrderByComparator<DeliveryOrder> orderByComparator)
		throws NoSuchDeliveryOrderException {

		uuid = Objects.toString(uuid, "");

		DeliveryOrder deliveryOrder = findByPrimaryKey(deliveryOrderPK);

		Session session = null;

		try {
			session = openSession();

			DeliveryOrder[] array = new DeliveryOrderImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, deliveryOrder, uuid, orderByComparator, true);

			array[1] = deliveryOrder;

			array[2] = getByUuid_PrevAndNext(
				session, deliveryOrder, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DeliveryOrder getByUuid_PrevAndNext(
		Session session, DeliveryOrder deliveryOrder, String uuid,
		OrderByComparator<DeliveryOrder> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DELIVERYORDER_WHERE);

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
			sb.append(DeliveryOrderModelImpl.ORDER_BY_JPQL);
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
						deliveryOrder)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DeliveryOrder> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the delivery orders where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DeliveryOrder deliveryOrder :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(deliveryOrder);
		}
	}

	/**
	 * Returns the number of delivery orders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching delivery orders
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DELIVERYORDER_WHERE);

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
		"deliveryOrder.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(deliveryOrder.uuid IS NULL OR deliveryOrder.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the delivery orders where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching delivery orders
	 */
	@Override
	public List<DeliveryOrder> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the delivery orders where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliveryOrderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of delivery orders
	 * @param end the upper bound of the range of delivery orders (not inclusive)
	 * @return the range of matching delivery orders
	 */
	@Override
	public List<DeliveryOrder> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the delivery orders where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliveryOrderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of delivery orders
	 * @param end the upper bound of the range of delivery orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching delivery orders
	 */
	@Override
	public List<DeliveryOrder> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DeliveryOrder> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the delivery orders where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliveryOrderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of delivery orders
	 * @param end the upper bound of the range of delivery orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching delivery orders
	 */
	@Override
	public List<DeliveryOrder> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DeliveryOrder> orderByComparator,
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

		List<DeliveryOrder> list = null;

		if (useFinderCache) {
			list = (List<DeliveryOrder>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DeliveryOrder deliveryOrder : list) {
					if (!uuid.equals(deliveryOrder.getUuid()) ||
						(companyId != deliveryOrder.getCompanyId())) {

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

			sb.append(_SQL_SELECT_DELIVERYORDER_WHERE);

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
				sb.append(DeliveryOrderModelImpl.ORDER_BY_JPQL);
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

				list = (List<DeliveryOrder>)QueryUtil.list(
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
	 * Returns the first delivery order in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delivery order
	 * @throws NoSuchDeliveryOrderException if a matching delivery order could not be found
	 */
	@Override
	public DeliveryOrder findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DeliveryOrder> orderByComparator)
		throws NoSuchDeliveryOrderException {

		DeliveryOrder deliveryOrder = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (deliveryOrder != null) {
			return deliveryOrder;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDeliveryOrderException(sb.toString());
	}

	/**
	 * Returns the first delivery order in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delivery order, or <code>null</code> if a matching delivery order could not be found
	 */
	@Override
	public DeliveryOrder fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DeliveryOrder> orderByComparator) {

		List<DeliveryOrder> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last delivery order in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delivery order
	 * @throws NoSuchDeliveryOrderException if a matching delivery order could not be found
	 */
	@Override
	public DeliveryOrder findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DeliveryOrder> orderByComparator)
		throws NoSuchDeliveryOrderException {

		DeliveryOrder deliveryOrder = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (deliveryOrder != null) {
			return deliveryOrder;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDeliveryOrderException(sb.toString());
	}

	/**
	 * Returns the last delivery order in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delivery order, or <code>null</code> if a matching delivery order could not be found
	 */
	@Override
	public DeliveryOrder fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DeliveryOrder> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<DeliveryOrder> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the delivery orders before and after the current delivery order in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param deliveryOrderPK the primary key of the current delivery order
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next delivery order
	 * @throws NoSuchDeliveryOrderException if a delivery order with the primary key could not be found
	 */
	@Override
	public DeliveryOrder[] findByUuid_C_PrevAndNext(
			DeliveryOrderPK deliveryOrderPK, String uuid, long companyId,
			OrderByComparator<DeliveryOrder> orderByComparator)
		throws NoSuchDeliveryOrderException {

		uuid = Objects.toString(uuid, "");

		DeliveryOrder deliveryOrder = findByPrimaryKey(deliveryOrderPK);

		Session session = null;

		try {
			session = openSession();

			DeliveryOrder[] array = new DeliveryOrderImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, deliveryOrder, uuid, companyId, orderByComparator,
				true);

			array[1] = deliveryOrder;

			array[2] = getByUuid_C_PrevAndNext(
				session, deliveryOrder, uuid, companyId, orderByComparator,
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

	protected DeliveryOrder getByUuid_C_PrevAndNext(
		Session session, DeliveryOrder deliveryOrder, String uuid,
		long companyId, OrderByComparator<DeliveryOrder> orderByComparator,
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

		sb.append(_SQL_SELECT_DELIVERYORDER_WHERE);

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
			sb.append(DeliveryOrderModelImpl.ORDER_BY_JPQL);
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
						deliveryOrder)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DeliveryOrder> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the delivery orders where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (DeliveryOrder deliveryOrder :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(deliveryOrder);
		}
	}

	/**
	 * Returns the number of delivery orders where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching delivery orders
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DELIVERYORDER_WHERE);

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
		"deliveryOrder.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(deliveryOrder.uuid IS NULL OR deliveryOrder.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"deliveryOrder.companyId = ?";

	public DeliveryOrderPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DeliveryOrder.class);

		setModelImplClass(DeliveryOrderImpl.class);
		setModelPKClass(DeliveryOrderPK.class);

		setTable(DeliveryOrderTable.INSTANCE);
	}

	/**
	 * Caches the delivery order in the entity cache if it is enabled.
	 *
	 * @param deliveryOrder the delivery order
	 */
	@Override
	public void cacheResult(DeliveryOrder deliveryOrder) {
		entityCache.putResult(
			DeliveryOrderImpl.class, deliveryOrder.getPrimaryKey(),
			deliveryOrder);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the delivery orders in the entity cache if it is enabled.
	 *
	 * @param deliveryOrders the delivery orders
	 */
	@Override
	public void cacheResult(List<DeliveryOrder> deliveryOrders) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (deliveryOrders.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DeliveryOrder deliveryOrder : deliveryOrders) {
			if (entityCache.getResult(
					DeliveryOrderImpl.class, deliveryOrder.getPrimaryKey()) ==
						null) {

				cacheResult(deliveryOrder);
			}
		}
	}

	/**
	 * Clears the cache for all delivery orders.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DeliveryOrderImpl.class);

		finderCache.clearCache(DeliveryOrderImpl.class);
	}

	/**
	 * Clears the cache for the delivery order.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DeliveryOrder deliveryOrder) {
		entityCache.removeResult(DeliveryOrderImpl.class, deliveryOrder);
	}

	@Override
	public void clearCache(List<DeliveryOrder> deliveryOrders) {
		for (DeliveryOrder deliveryOrder : deliveryOrders) {
			entityCache.removeResult(DeliveryOrderImpl.class, deliveryOrder);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DeliveryOrderImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DeliveryOrderImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new delivery order with the primary key. Does not add the delivery order to the database.
	 *
	 * @param deliveryOrderPK the primary key for the new delivery order
	 * @return the new delivery order
	 */
	@Override
	public DeliveryOrder create(DeliveryOrderPK deliveryOrderPK) {
		DeliveryOrder deliveryOrder = new DeliveryOrderImpl();

		deliveryOrder.setNew(true);
		deliveryOrder.setPrimaryKey(deliveryOrderPK);

		String uuid = _portalUUID.generate();

		deliveryOrder.setUuid(uuid);

		deliveryOrder.setCompanyId(CompanyThreadLocal.getCompanyId());

		return deliveryOrder;
	}

	/**
	 * Removes the delivery order with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param deliveryOrderPK the primary key of the delivery order
	 * @return the delivery order that was removed
	 * @throws NoSuchDeliveryOrderException if a delivery order with the primary key could not be found
	 */
	@Override
	public DeliveryOrder remove(DeliveryOrderPK deliveryOrderPK)
		throws NoSuchDeliveryOrderException {

		return remove((Serializable)deliveryOrderPK);
	}

	/**
	 * Removes the delivery order with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the delivery order
	 * @return the delivery order that was removed
	 * @throws NoSuchDeliveryOrderException if a delivery order with the primary key could not be found
	 */
	@Override
	public DeliveryOrder remove(Serializable primaryKey)
		throws NoSuchDeliveryOrderException {

		Session session = null;

		try {
			session = openSession();

			DeliveryOrder deliveryOrder = (DeliveryOrder)session.get(
				DeliveryOrderImpl.class, primaryKey);

			if (deliveryOrder == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDeliveryOrderException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(deliveryOrder);
		}
		catch (NoSuchDeliveryOrderException noSuchEntityException) {
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
	protected DeliveryOrder removeImpl(DeliveryOrder deliveryOrder) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(deliveryOrder)) {
				deliveryOrder = (DeliveryOrder)session.get(
					DeliveryOrderImpl.class, deliveryOrder.getPrimaryKeyObj());
			}

			if (deliveryOrder != null) {
				session.delete(deliveryOrder);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (deliveryOrder != null) {
			clearCache(deliveryOrder);
		}

		return deliveryOrder;
	}

	@Override
	public DeliveryOrder updateImpl(DeliveryOrder deliveryOrder) {
		boolean isNew = deliveryOrder.isNew();

		if (!(deliveryOrder instanceof DeliveryOrderModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(deliveryOrder.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					deliveryOrder);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in deliveryOrder proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DeliveryOrder implementation " +
					deliveryOrder.getClass());
		}

		DeliveryOrderModelImpl deliveryOrderModelImpl =
			(DeliveryOrderModelImpl)deliveryOrder;

		if (Validator.isNull(deliveryOrder.getUuid())) {
			String uuid = _portalUUID.generate();

			deliveryOrder.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (deliveryOrder.getCreateDate() == null)) {
			if (serviceContext == null) {
				deliveryOrder.setCreateDate(date);
			}
			else {
				deliveryOrder.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!deliveryOrderModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				deliveryOrder.setModifiedDate(date);
			}
			else {
				deliveryOrder.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(deliveryOrder);
			}
			else {
				deliveryOrder = (DeliveryOrder)session.merge(deliveryOrder);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DeliveryOrderImpl.class, deliveryOrderModelImpl, false, true);

		if (isNew) {
			deliveryOrder.setNew(false);
		}

		deliveryOrder.resetOriginalValues();

		return deliveryOrder;
	}

	/**
	 * Returns the delivery order with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the delivery order
	 * @return the delivery order
	 * @throws NoSuchDeliveryOrderException if a delivery order with the primary key could not be found
	 */
	@Override
	public DeliveryOrder findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDeliveryOrderException {

		DeliveryOrder deliveryOrder = fetchByPrimaryKey(primaryKey);

		if (deliveryOrder == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDeliveryOrderException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return deliveryOrder;
	}

	/**
	 * Returns the delivery order with the primary key or throws a <code>NoSuchDeliveryOrderException</code> if it could not be found.
	 *
	 * @param deliveryOrderPK the primary key of the delivery order
	 * @return the delivery order
	 * @throws NoSuchDeliveryOrderException if a delivery order with the primary key could not be found
	 */
	@Override
	public DeliveryOrder findByPrimaryKey(DeliveryOrderPK deliveryOrderPK)
		throws NoSuchDeliveryOrderException {

		return findByPrimaryKey((Serializable)deliveryOrderPK);
	}

	/**
	 * Returns the delivery order with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param deliveryOrderPK the primary key of the delivery order
	 * @return the delivery order, or <code>null</code> if a delivery order with the primary key could not be found
	 */
	@Override
	public DeliveryOrder fetchByPrimaryKey(DeliveryOrderPK deliveryOrderPK) {
		return fetchByPrimaryKey((Serializable)deliveryOrderPK);
	}

	/**
	 * Returns all the delivery orders.
	 *
	 * @return the delivery orders
	 */
	@Override
	public List<DeliveryOrder> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the delivery orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliveryOrderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of delivery orders
	 * @param end the upper bound of the range of delivery orders (not inclusive)
	 * @return the range of delivery orders
	 */
	@Override
	public List<DeliveryOrder> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the delivery orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliveryOrderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of delivery orders
	 * @param end the upper bound of the range of delivery orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of delivery orders
	 */
	@Override
	public List<DeliveryOrder> findAll(
		int start, int end,
		OrderByComparator<DeliveryOrder> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the delivery orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliveryOrderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of delivery orders
	 * @param end the upper bound of the range of delivery orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of delivery orders
	 */
	@Override
	public List<DeliveryOrder> findAll(
		int start, int end, OrderByComparator<DeliveryOrder> orderByComparator,
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

		List<DeliveryOrder> list = null;

		if (useFinderCache) {
			list = (List<DeliveryOrder>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DELIVERYORDER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DELIVERYORDER;

				sql = sql.concat(DeliveryOrderModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DeliveryOrder>)QueryUtil.list(
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
	 * Removes all the delivery orders from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DeliveryOrder deliveryOrder : findAll()) {
			remove(deliveryOrder);
		}
	}

	/**
	 * Returns the number of delivery orders.
	 *
	 * @return the number of delivery orders
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DELIVERYORDER);

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
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "deliveryOrderPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DELIVERYORDER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DeliveryOrderModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the delivery order persistence.
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

		_setDeliveryOrderUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDeliveryOrderUtilPersistence(null);

		entityCache.removeCache(DeliveryOrderImpl.class.getName());
	}

	private void _setDeliveryOrderUtilPersistence(
		DeliveryOrderPersistence deliveryOrderPersistence) {

		try {
			Field field = DeliveryOrderUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, deliveryOrderPersistence);
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

	private static final String _SQL_SELECT_DELIVERYORDER =
		"SELECT deliveryOrder FROM DeliveryOrder deliveryOrder";

	private static final String _SQL_SELECT_DELIVERYORDER_WHERE =
		"SELECT deliveryOrder FROM DeliveryOrder deliveryOrder WHERE ";

	private static final String _SQL_COUNT_DELIVERYORDER =
		"SELECT COUNT(deliveryOrder) FROM DeliveryOrder deliveryOrder";

	private static final String _SQL_COUNT_DELIVERYORDER_WHERE =
		"SELECT COUNT(deliveryOrder) FROM DeliveryOrder deliveryOrder WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "deliveryOrder.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DeliveryOrder exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DeliveryOrder exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DeliveryOrderPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"deliveryOrderId", "indentId"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private DeliveryOrderModelArgumentsResolver
		_deliveryOrderModelArgumentsResolver;

}