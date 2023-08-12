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

import bd.gov.dgfood.common.services.exception.NoSuchAddressException;
import bd.gov.dgfood.common.services.model.Address;
import bd.gov.dgfood.common.services.model.AddressTable;
import bd.gov.dgfood.common.services.model.impl.AddressImpl;
import bd.gov.dgfood.common.services.model.impl.AddressModelImpl;
import bd.gov.dgfood.common.services.service.persistence.AddressPersistence;
import bd.gov.dgfood.common.services.service.persistence.AddressUtil;
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
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the address service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {AddressPersistence.class, BasePersistence.class})
public class AddressPersistenceImpl
	extends BasePersistenceImpl<Address> implements AddressPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AddressUtil</code> to access the address persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AddressImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByCPK_CN;
	private FinderPath _finderPathWithoutPaginationFindByCPK_CN;
	private FinderPath _finderPathCountByCPK_CN;

	/**
	 * Returns all the addresses where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @return the matching addresses
	 */
	@Override
	public List<Address> findByCPK_CN(long classPK, String className) {
		return findByCPK_CN(
			classPK, className, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the addresses where classPK = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @return the range of matching addresses
	 */
	@Override
	public List<Address> findByCPK_CN(
		long classPK, String className, int start, int end) {

		return findByCPK_CN(classPK, className, start, end, null);
	}

	/**
	 * Returns an ordered range of all the addresses where classPK = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching addresses
	 */
	@Override
	public List<Address> findByCPK_CN(
		long classPK, String className, int start, int end,
		OrderByComparator<Address> orderByComparator) {

		return findByCPK_CN(
			classPK, className, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the addresses where classPK = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching addresses
	 */
	@Override
	public List<Address> findByCPK_CN(
		long classPK, String className, int start, int end,
		OrderByComparator<Address> orderByComparator, boolean useFinderCache) {

		className = Objects.toString(className, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCPK_CN;
				finderArgs = new Object[] {classPK, className};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCPK_CN;
			finderArgs = new Object[] {
				classPK, className, start, end, orderByComparator
			};
		}

		List<Address> list = null;

		if (useFinderCache) {
			list = (List<Address>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Address address : list) {
					if ((classPK != address.getClassPK()) ||
						!className.equals(address.getClassName())) {

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

			sb.append(_SQL_SELECT_ADDRESS_WHERE);

			sb.append(_FINDER_COLUMN_CPK_CN_CLASSPK_2);

			boolean bindClassName = false;

			if (className.isEmpty()) {
				sb.append(_FINDER_COLUMN_CPK_CN_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				sb.append(_FINDER_COLUMN_CPK_CN_CLASSNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AddressModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(classPK);

				if (bindClassName) {
					queryPos.add(className);
				}

				list = (List<Address>)QueryUtil.list(
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
	 * Returns the first address in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	@Override
	public Address findByCPK_CN_First(
			long classPK, String className,
			OrderByComparator<Address> orderByComparator)
		throws NoSuchAddressException {

		Address address = fetchByCPK_CN_First(
			classPK, className, orderByComparator);

		if (address != null) {
			return address;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("classPK=");
		sb.append(classPK);

		sb.append(", className=");
		sb.append(className);

		sb.append("}");

		throw new NoSuchAddressException(sb.toString());
	}

	/**
	 * Returns the first address in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address, or <code>null</code> if a matching address could not be found
	 */
	@Override
	public Address fetchByCPK_CN_First(
		long classPK, String className,
		OrderByComparator<Address> orderByComparator) {

		List<Address> list = findByCPK_CN(
			classPK, className, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last address in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	@Override
	public Address findByCPK_CN_Last(
			long classPK, String className,
			OrderByComparator<Address> orderByComparator)
		throws NoSuchAddressException {

		Address address = fetchByCPK_CN_Last(
			classPK, className, orderByComparator);

		if (address != null) {
			return address;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("classPK=");
		sb.append(classPK);

		sb.append(", className=");
		sb.append(className);

		sb.append("}");

		throw new NoSuchAddressException(sb.toString());
	}

	/**
	 * Returns the last address in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address, or <code>null</code> if a matching address could not be found
	 */
	@Override
	public Address fetchByCPK_CN_Last(
		long classPK, String className,
		OrderByComparator<Address> orderByComparator) {

		int count = countByCPK_CN(classPK, className);

		if (count == 0) {
			return null;
		}

		List<Address> list = findByCPK_CN(
			classPK, className, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the addresses before and after the current address in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param addressId the primary key of the current address
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next address
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	@Override
	public Address[] findByCPK_CN_PrevAndNext(
			long addressId, long classPK, String className,
			OrderByComparator<Address> orderByComparator)
		throws NoSuchAddressException {

		className = Objects.toString(className, "");

		Address address = findByPrimaryKey(addressId);

		Session session = null;

		try {
			session = openSession();

			Address[] array = new AddressImpl[3];

			array[0] = getByCPK_CN_PrevAndNext(
				session, address, classPK, className, orderByComparator, true);

			array[1] = address;

			array[2] = getByCPK_CN_PrevAndNext(
				session, address, classPK, className, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Address getByCPK_CN_PrevAndNext(
		Session session, Address address, long classPK, String className,
		OrderByComparator<Address> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_ADDRESS_WHERE);

		sb.append(_FINDER_COLUMN_CPK_CN_CLASSPK_2);

		boolean bindClassName = false;

		if (className.isEmpty()) {
			sb.append(_FINDER_COLUMN_CPK_CN_CLASSNAME_3);
		}
		else {
			bindClassName = true;

			sb.append(_FINDER_COLUMN_CPK_CN_CLASSNAME_2);
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
			sb.append(AddressModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(classPK);

		if (bindClassName) {
			queryPos.add(className);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(address)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Address> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the addresses where classPK = &#63; and className = &#63; from the database.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 */
	@Override
	public void removeByCPK_CN(long classPK, String className) {
		for (Address address :
				findByCPK_CN(
					classPK, className, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(address);
		}
	}

	/**
	 * Returns the number of addresses where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @return the number of matching addresses
	 */
	@Override
	public int countByCPK_CN(long classPK, String className) {
		className = Objects.toString(className, "");

		FinderPath finderPath = _finderPathCountByCPK_CN;

		Object[] finderArgs = new Object[] {classPK, className};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ADDRESS_WHERE);

			sb.append(_FINDER_COLUMN_CPK_CN_CLASSPK_2);

			boolean bindClassName = false;

			if (className.isEmpty()) {
				sb.append(_FINDER_COLUMN_CPK_CN_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				sb.append(_FINDER_COLUMN_CPK_CN_CLASSNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(classPK);

				if (bindClassName) {
					queryPos.add(className);
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

	private static final String _FINDER_COLUMN_CPK_CN_CLASSPK_2 =
		"address.classPK = ? AND ";

	private static final String _FINDER_COLUMN_CPK_CN_CLASSNAME_2 =
		"address.className = ?";

	private static final String _FINDER_COLUMN_CPK_CN_CLASSNAME_3 =
		"(address.className IS NULL OR address.className = '')";

	private FinderPath _finderPathFetchByCPK_CN_AT;
	private FinderPath _finderPathCountByCPK_CN_AT;

	/**
	 * Returns the address where classPK = &#63; and className = &#63; and addressType = &#63; or throws a <code>NoSuchAddressException</code> if it could not be found.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param addressType the address type
	 * @return the matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	@Override
	public Address findByCPK_CN_AT(
			long classPK, String className, String addressType)
		throws NoSuchAddressException {

		Address address = fetchByCPK_CN_AT(classPK, className, addressType);

		if (address == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("classPK=");
			sb.append(classPK);

			sb.append(", className=");
			sb.append(className);

			sb.append(", addressType=");
			sb.append(addressType);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAddressException(sb.toString());
		}

		return address;
	}

	/**
	 * Returns the address where classPK = &#63; and className = &#63; and addressType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param addressType the address type
	 * @return the matching address, or <code>null</code> if a matching address could not be found
	 */
	@Override
	public Address fetchByCPK_CN_AT(
		long classPK, String className, String addressType) {

		return fetchByCPK_CN_AT(classPK, className, addressType, true);
	}

	/**
	 * Returns the address where classPK = &#63; and className = &#63; and addressType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param addressType the address type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching address, or <code>null</code> if a matching address could not be found
	 */
	@Override
	public Address fetchByCPK_CN_AT(
		long classPK, String className, String addressType,
		boolean useFinderCache) {

		className = Objects.toString(className, "");
		addressType = Objects.toString(addressType, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {classPK, className, addressType};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByCPK_CN_AT, finderArgs);
		}

		if (result instanceof Address) {
			Address address = (Address)result;

			if ((classPK != address.getClassPK()) ||
				!Objects.equals(className, address.getClassName()) ||
				!Objects.equals(addressType, address.getAddressType())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_ADDRESS_WHERE);

			sb.append(_FINDER_COLUMN_CPK_CN_AT_CLASSPK_2);

			boolean bindClassName = false;

			if (className.isEmpty()) {
				sb.append(_FINDER_COLUMN_CPK_CN_AT_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				sb.append(_FINDER_COLUMN_CPK_CN_AT_CLASSNAME_2);
			}

			boolean bindAddressType = false;

			if (addressType.isEmpty()) {
				sb.append(_FINDER_COLUMN_CPK_CN_AT_ADDRESSTYPE_3);
			}
			else {
				bindAddressType = true;

				sb.append(_FINDER_COLUMN_CPK_CN_AT_ADDRESSTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(classPK);

				if (bindClassName) {
					queryPos.add(className);
				}

				if (bindAddressType) {
					queryPos.add(addressType);
				}

				List<Address> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByCPK_CN_AT, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									classPK, className, addressType
								};
							}

							_log.warn(
								"AddressPersistenceImpl.fetchByCPK_CN_AT(long, String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Address address = list.get(0);

					result = address;

					cacheResult(address);
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
			return (Address)result;
		}
	}

	/**
	 * Removes the address where classPK = &#63; and className = &#63; and addressType = &#63; from the database.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param addressType the address type
	 * @return the address that was removed
	 */
	@Override
	public Address removeByCPK_CN_AT(
			long classPK, String className, String addressType)
		throws NoSuchAddressException {

		Address address = findByCPK_CN_AT(classPK, className, addressType);

		return remove(address);
	}

	/**
	 * Returns the number of addresses where classPK = &#63; and className = &#63; and addressType = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param addressType the address type
	 * @return the number of matching addresses
	 */
	@Override
	public int countByCPK_CN_AT(
		long classPK, String className, String addressType) {

		className = Objects.toString(className, "");
		addressType = Objects.toString(addressType, "");

		FinderPath finderPath = _finderPathCountByCPK_CN_AT;

		Object[] finderArgs = new Object[] {classPK, className, addressType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_ADDRESS_WHERE);

			sb.append(_FINDER_COLUMN_CPK_CN_AT_CLASSPK_2);

			boolean bindClassName = false;

			if (className.isEmpty()) {
				sb.append(_FINDER_COLUMN_CPK_CN_AT_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				sb.append(_FINDER_COLUMN_CPK_CN_AT_CLASSNAME_2);
			}

			boolean bindAddressType = false;

			if (addressType.isEmpty()) {
				sb.append(_FINDER_COLUMN_CPK_CN_AT_ADDRESSTYPE_3);
			}
			else {
				bindAddressType = true;

				sb.append(_FINDER_COLUMN_CPK_CN_AT_ADDRESSTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(classPK);

				if (bindClassName) {
					queryPos.add(className);
				}

				if (bindAddressType) {
					queryPos.add(addressType);
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

	private static final String _FINDER_COLUMN_CPK_CN_AT_CLASSPK_2 =
		"address.classPK = ? AND ";

	private static final String _FINDER_COLUMN_CPK_CN_AT_CLASSNAME_2 =
		"address.className = ? AND ";

	private static final String _FINDER_COLUMN_CPK_CN_AT_CLASSNAME_3 =
		"(address.className IS NULL OR address.className = '') AND ";

	private static final String _FINDER_COLUMN_CPK_CN_AT_ADDRESSTYPE_2 =
		"address.addressType = ?";

	private static final String _FINDER_COLUMN_CPK_CN_AT_ADDRESSTYPE_3 =
		"(address.addressType IS NULL OR address.addressType = '')";

	public AddressPersistenceImpl() {
		setModelClass(Address.class);

		setModelImplClass(AddressImpl.class);
		setModelPKClass(long.class);

		setTable(AddressTable.INSTANCE);
	}

	/**
	 * Caches the address in the entity cache if it is enabled.
	 *
	 * @param address the address
	 */
	@Override
	public void cacheResult(Address address) {
		entityCache.putResult(
			AddressImpl.class, address.getPrimaryKey(), address);

		finderCache.putResult(
			_finderPathFetchByCPK_CN_AT,
			new Object[] {
				address.getClassPK(), address.getClassName(),
				address.getAddressType()
			},
			address);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the addresses in the entity cache if it is enabled.
	 *
	 * @param addresses the addresses
	 */
	@Override
	public void cacheResult(List<Address> addresses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (addresses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Address address : addresses) {
			if (entityCache.getResult(
					AddressImpl.class, address.getPrimaryKey()) == null) {

				cacheResult(address);
			}
		}
	}

	/**
	 * Clears the cache for all addresses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AddressImpl.class);

		finderCache.clearCache(AddressImpl.class);
	}

	/**
	 * Clears the cache for the address.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Address address) {
		entityCache.removeResult(AddressImpl.class, address);
	}

	@Override
	public void clearCache(List<Address> addresses) {
		for (Address address : addresses) {
			entityCache.removeResult(AddressImpl.class, address);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AddressImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AddressImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(AddressModelImpl addressModelImpl) {
		Object[] args = new Object[] {
			addressModelImpl.getClassPK(), addressModelImpl.getClassName(),
			addressModelImpl.getAddressType()
		};

		finderCache.putResult(
			_finderPathCountByCPK_CN_AT, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByCPK_CN_AT, args, addressModelImpl);
	}

	/**
	 * Creates a new address with the primary key. Does not add the address to the database.
	 *
	 * @param addressId the primary key for the new address
	 * @return the new address
	 */
	@Override
	public Address create(long addressId) {
		Address address = new AddressImpl();

		address.setNew(true);
		address.setPrimaryKey(addressId);

		return address;
	}

	/**
	 * Removes the address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addressId the primary key of the address
	 * @return the address that was removed
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	@Override
	public Address remove(long addressId) throws NoSuchAddressException {
		return remove((Serializable)addressId);
	}

	/**
	 * Removes the address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the address
	 * @return the address that was removed
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	@Override
	public Address remove(Serializable primaryKey)
		throws NoSuchAddressException {

		Session session = null;

		try {
			session = openSession();

			Address address = (Address)session.get(
				AddressImpl.class, primaryKey);

			if (address == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAddressException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(address);
		}
		catch (NoSuchAddressException noSuchEntityException) {
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
	protected Address removeImpl(Address address) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(address)) {
				address = (Address)session.get(
					AddressImpl.class, address.getPrimaryKeyObj());
			}

			if (address != null) {
				session.delete(address);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (address != null) {
			clearCache(address);
		}

		return address;
	}

	@Override
	public Address updateImpl(Address address) {
		boolean isNew = address.isNew();

		if (!(address instanceof AddressModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(address.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(address);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in address proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Address implementation " +
					address.getClass());
		}

		AddressModelImpl addressModelImpl = (AddressModelImpl)address;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(address);
			}
			else {
				address = (Address)session.merge(address);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(AddressImpl.class, addressModelImpl, false, true);

		cacheUniqueFindersCache(addressModelImpl);

		if (isNew) {
			address.setNew(false);
		}

		address.resetOriginalValues();

		return address;
	}

	/**
	 * Returns the address with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the address
	 * @return the address
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	@Override
	public Address findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAddressException {

		Address address = fetchByPrimaryKey(primaryKey);

		if (address == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAddressException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return address;
	}

	/**
	 * Returns the address with the primary key or throws a <code>NoSuchAddressException</code> if it could not be found.
	 *
	 * @param addressId the primary key of the address
	 * @return the address
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	@Override
	public Address findByPrimaryKey(long addressId)
		throws NoSuchAddressException {

		return findByPrimaryKey((Serializable)addressId);
	}

	/**
	 * Returns the address with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addressId the primary key of the address
	 * @return the address, or <code>null</code> if a address with the primary key could not be found
	 */
	@Override
	public Address fetchByPrimaryKey(long addressId) {
		return fetchByPrimaryKey((Serializable)addressId);
	}

	/**
	 * Returns all the addresses.
	 *
	 * @return the addresses
	 */
	@Override
	public List<Address> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @return the range of addresses
	 */
	@Override
	public List<Address> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of addresses
	 */
	@Override
	public List<Address> findAll(
		int start, int end, OrderByComparator<Address> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of addresses
	 */
	@Override
	public List<Address> findAll(
		int start, int end, OrderByComparator<Address> orderByComparator,
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

		List<Address> list = null;

		if (useFinderCache) {
			list = (List<Address>)finderCache.getResult(finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ADDRESS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ADDRESS;

				sql = sql.concat(AddressModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Address>)QueryUtil.list(
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
	 * Removes all the addresses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Address address : findAll()) {
			remove(address);
		}
	}

	/**
	 * Returns the number of addresses.
	 *
	 * @return the number of addresses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ADDRESS);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "addressId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ADDRESS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AddressModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the address persistence.
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

		_finderPathWithPaginationFindByCPK_CN = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCPK_CN",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"classPK", "className"}, true);

		_finderPathWithoutPaginationFindByCPK_CN = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCPK_CN",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"classPK", "className"}, true);

		_finderPathCountByCPK_CN = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCPK_CN",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"classPK", "className"}, false);

		_finderPathFetchByCPK_CN_AT = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByCPK_CN_AT",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"classPK", "className", "addressType"}, true);

		_finderPathCountByCPK_CN_AT = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCPK_CN_AT",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"classPK", "className", "addressType"}, false);

		_setAddressUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAddressUtilPersistence(null);

		entityCache.removeCache(AddressImpl.class.getName());
	}

	private void _setAddressUtilPersistence(
		AddressPersistence addressPersistence) {

		try {
			Field field = AddressUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, addressPersistence);
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

	private static final String _SQL_SELECT_ADDRESS =
		"SELECT address FROM Address address";

	private static final String _SQL_SELECT_ADDRESS_WHERE =
		"SELECT address FROM Address address WHERE ";

	private static final String _SQL_COUNT_ADDRESS =
		"SELECT COUNT(address) FROM Address address";

	private static final String _SQL_COUNT_ADDRESS_WHERE =
		"SELECT COUNT(address) FROM Address address WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "address.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Address exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Address exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AddressPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private AddressModelArgumentsResolver _addressModelArgumentsResolver;

}