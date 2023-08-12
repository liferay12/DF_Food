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

import bd.gov.dgfood.common.services.exception.NoSuchAddressVersionException;
import bd.gov.dgfood.common.services.model.AddressVersion;
import bd.gov.dgfood.common.services.model.AddressVersionTable;
import bd.gov.dgfood.common.services.model.impl.AddressVersionImpl;
import bd.gov.dgfood.common.services.model.impl.AddressVersionModelImpl;
import bd.gov.dgfood.common.services.service.persistence.AddressVersionPersistence;
import bd.gov.dgfood.common.services.service.persistence.AddressVersionUtil;
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

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the address version service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {AddressVersionPersistence.class, BasePersistence.class})
public class AddressVersionPersistenceImpl
	extends BasePersistenceImpl<AddressVersion>
	implements AddressVersionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AddressVersionUtil</code> to access the address version persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AddressVersionImpl.class.getName();

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
	 * Returns all the address versions where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @return the matching address versions
	 */
	@Override
	public List<AddressVersion> findByCPK_CN(long classPK, String className) {
		return findByCPK_CN(
			classPK, className, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the address versions where classPK = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressVersionModelImpl</code>.
	 * </p>
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param start the lower bound of the range of address versions
	 * @param end the upper bound of the range of address versions (not inclusive)
	 * @return the range of matching address versions
	 */
	@Override
	public List<AddressVersion> findByCPK_CN(
		long classPK, String className, int start, int end) {

		return findByCPK_CN(classPK, className, start, end, null);
	}

	/**
	 * Returns an ordered range of all the address versions where classPK = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressVersionModelImpl</code>.
	 * </p>
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param start the lower bound of the range of address versions
	 * @param end the upper bound of the range of address versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching address versions
	 */
	@Override
	public List<AddressVersion> findByCPK_CN(
		long classPK, String className, int start, int end,
		OrderByComparator<AddressVersion> orderByComparator) {

		return findByCPK_CN(
			classPK, className, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the address versions where classPK = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressVersionModelImpl</code>.
	 * </p>
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param start the lower bound of the range of address versions
	 * @param end the upper bound of the range of address versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching address versions
	 */
	@Override
	public List<AddressVersion> findByCPK_CN(
		long classPK, String className, int start, int end,
		OrderByComparator<AddressVersion> orderByComparator,
		boolean useFinderCache) {

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

		List<AddressVersion> list = null;

		if (useFinderCache) {
			list = (List<AddressVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AddressVersion addressVersion : list) {
					if ((classPK != addressVersion.getClassPK()) ||
						!className.equals(addressVersion.getClassName())) {

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

			sb.append(_SQL_SELECT_ADDRESSVERSION_WHERE);

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
				sb.append(AddressVersionModelImpl.ORDER_BY_JPQL);
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

				list = (List<AddressVersion>)QueryUtil.list(
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
	 * Returns the first address version in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address version
	 * @throws NoSuchAddressVersionException if a matching address version could not be found
	 */
	@Override
	public AddressVersion findByCPK_CN_First(
			long classPK, String className,
			OrderByComparator<AddressVersion> orderByComparator)
		throws NoSuchAddressVersionException {

		AddressVersion addressVersion = fetchByCPK_CN_First(
			classPK, className, orderByComparator);

		if (addressVersion != null) {
			return addressVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("classPK=");
		sb.append(classPK);

		sb.append(", className=");
		sb.append(className);

		sb.append("}");

		throw new NoSuchAddressVersionException(sb.toString());
	}

	/**
	 * Returns the first address version in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address version, or <code>null</code> if a matching address version could not be found
	 */
	@Override
	public AddressVersion fetchByCPK_CN_First(
		long classPK, String className,
		OrderByComparator<AddressVersion> orderByComparator) {

		List<AddressVersion> list = findByCPK_CN(
			classPK, className, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last address version in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address version
	 * @throws NoSuchAddressVersionException if a matching address version could not be found
	 */
	@Override
	public AddressVersion findByCPK_CN_Last(
			long classPK, String className,
			OrderByComparator<AddressVersion> orderByComparator)
		throws NoSuchAddressVersionException {

		AddressVersion addressVersion = fetchByCPK_CN_Last(
			classPK, className, orderByComparator);

		if (addressVersion != null) {
			return addressVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("classPK=");
		sb.append(classPK);

		sb.append(", className=");
		sb.append(className);

		sb.append("}");

		throw new NoSuchAddressVersionException(sb.toString());
	}

	/**
	 * Returns the last address version in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address version, or <code>null</code> if a matching address version could not be found
	 */
	@Override
	public AddressVersion fetchByCPK_CN_Last(
		long classPK, String className,
		OrderByComparator<AddressVersion> orderByComparator) {

		int count = countByCPK_CN(classPK, className);

		if (count == 0) {
			return null;
		}

		List<AddressVersion> list = findByCPK_CN(
			classPK, className, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the address versions before and after the current address version in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param addressVersionId the primary key of the current address version
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next address version
	 * @throws NoSuchAddressVersionException if a address version with the primary key could not be found
	 */
	@Override
	public AddressVersion[] findByCPK_CN_PrevAndNext(
			long addressVersionId, long classPK, String className,
			OrderByComparator<AddressVersion> orderByComparator)
		throws NoSuchAddressVersionException {

		className = Objects.toString(className, "");

		AddressVersion addressVersion = findByPrimaryKey(addressVersionId);

		Session session = null;

		try {
			session = openSession();

			AddressVersion[] array = new AddressVersionImpl[3];

			array[0] = getByCPK_CN_PrevAndNext(
				session, addressVersion, classPK, className, orderByComparator,
				true);

			array[1] = addressVersion;

			array[2] = getByCPK_CN_PrevAndNext(
				session, addressVersion, classPK, className, orderByComparator,
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

	protected AddressVersion getByCPK_CN_PrevAndNext(
		Session session, AddressVersion addressVersion, long classPK,
		String className, OrderByComparator<AddressVersion> orderByComparator,
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

		sb.append(_SQL_SELECT_ADDRESSVERSION_WHERE);

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
			sb.append(AddressVersionModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						addressVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AddressVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the address versions where classPK = &#63; and className = &#63; from the database.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 */
	@Override
	public void removeByCPK_CN(long classPK, String className) {
		for (AddressVersion addressVersion :
				findByCPK_CN(
					classPK, className, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(addressVersion);
		}
	}

	/**
	 * Returns the number of address versions where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @return the number of matching address versions
	 */
	@Override
	public int countByCPK_CN(long classPK, String className) {
		className = Objects.toString(className, "");

		FinderPath finderPath = _finderPathCountByCPK_CN;

		Object[] finderArgs = new Object[] {classPK, className};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ADDRESSVERSION_WHERE);

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
		"addressVersion.classPK = ? AND ";

	private static final String _FINDER_COLUMN_CPK_CN_CLASSNAME_2 =
		"addressVersion.className = ?";

	private static final String _FINDER_COLUMN_CPK_CN_CLASSNAME_3 =
		"(addressVersion.className IS NULL OR addressVersion.className = '')";

	public AddressVersionPersistenceImpl() {
		setModelClass(AddressVersion.class);

		setModelImplClass(AddressVersionImpl.class);
		setModelPKClass(long.class);

		setTable(AddressVersionTable.INSTANCE);
	}

	/**
	 * Caches the address version in the entity cache if it is enabled.
	 *
	 * @param addressVersion the address version
	 */
	@Override
	public void cacheResult(AddressVersion addressVersion) {
		entityCache.putResult(
			AddressVersionImpl.class, addressVersion.getPrimaryKey(),
			addressVersion);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the address versions in the entity cache if it is enabled.
	 *
	 * @param addressVersions the address versions
	 */
	@Override
	public void cacheResult(List<AddressVersion> addressVersions) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (addressVersions.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AddressVersion addressVersion : addressVersions) {
			if (entityCache.getResult(
					AddressVersionImpl.class, addressVersion.getPrimaryKey()) ==
						null) {

				cacheResult(addressVersion);
			}
		}
	}

	/**
	 * Clears the cache for all address versions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AddressVersionImpl.class);

		finderCache.clearCache(AddressVersionImpl.class);
	}

	/**
	 * Clears the cache for the address version.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AddressVersion addressVersion) {
		entityCache.removeResult(AddressVersionImpl.class, addressVersion);
	}

	@Override
	public void clearCache(List<AddressVersion> addressVersions) {
		for (AddressVersion addressVersion : addressVersions) {
			entityCache.removeResult(AddressVersionImpl.class, addressVersion);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AddressVersionImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AddressVersionImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new address version with the primary key. Does not add the address version to the database.
	 *
	 * @param addressVersionId the primary key for the new address version
	 * @return the new address version
	 */
	@Override
	public AddressVersion create(long addressVersionId) {
		AddressVersion addressVersion = new AddressVersionImpl();

		addressVersion.setNew(true);
		addressVersion.setPrimaryKey(addressVersionId);

		return addressVersion;
	}

	/**
	 * Removes the address version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addressVersionId the primary key of the address version
	 * @return the address version that was removed
	 * @throws NoSuchAddressVersionException if a address version with the primary key could not be found
	 */
	@Override
	public AddressVersion remove(long addressVersionId)
		throws NoSuchAddressVersionException {

		return remove((Serializable)addressVersionId);
	}

	/**
	 * Removes the address version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the address version
	 * @return the address version that was removed
	 * @throws NoSuchAddressVersionException if a address version with the primary key could not be found
	 */
	@Override
	public AddressVersion remove(Serializable primaryKey)
		throws NoSuchAddressVersionException {

		Session session = null;

		try {
			session = openSession();

			AddressVersion addressVersion = (AddressVersion)session.get(
				AddressVersionImpl.class, primaryKey);

			if (addressVersion == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAddressVersionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(addressVersion);
		}
		catch (NoSuchAddressVersionException noSuchEntityException) {
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
	protected AddressVersion removeImpl(AddressVersion addressVersion) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(addressVersion)) {
				addressVersion = (AddressVersion)session.get(
					AddressVersionImpl.class,
					addressVersion.getPrimaryKeyObj());
			}

			if (addressVersion != null) {
				session.delete(addressVersion);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (addressVersion != null) {
			clearCache(addressVersion);
		}

		return addressVersion;
	}

	@Override
	public AddressVersion updateImpl(AddressVersion addressVersion) {
		boolean isNew = addressVersion.isNew();

		if (!(addressVersion instanceof AddressVersionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(addressVersion.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					addressVersion);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in addressVersion proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AddressVersion implementation " +
					addressVersion.getClass());
		}

		AddressVersionModelImpl addressVersionModelImpl =
			(AddressVersionModelImpl)addressVersion;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(addressVersion);
			}
			else {
				addressVersion = (AddressVersion)session.merge(addressVersion);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AddressVersionImpl.class, addressVersionModelImpl, false, true);

		if (isNew) {
			addressVersion.setNew(false);
		}

		addressVersion.resetOriginalValues();

		return addressVersion;
	}

	/**
	 * Returns the address version with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the address version
	 * @return the address version
	 * @throws NoSuchAddressVersionException if a address version with the primary key could not be found
	 */
	@Override
	public AddressVersion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAddressVersionException {

		AddressVersion addressVersion = fetchByPrimaryKey(primaryKey);

		if (addressVersion == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAddressVersionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return addressVersion;
	}

	/**
	 * Returns the address version with the primary key or throws a <code>NoSuchAddressVersionException</code> if it could not be found.
	 *
	 * @param addressVersionId the primary key of the address version
	 * @return the address version
	 * @throws NoSuchAddressVersionException if a address version with the primary key could not be found
	 */
	@Override
	public AddressVersion findByPrimaryKey(long addressVersionId)
		throws NoSuchAddressVersionException {

		return findByPrimaryKey((Serializable)addressVersionId);
	}

	/**
	 * Returns the address version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addressVersionId the primary key of the address version
	 * @return the address version, or <code>null</code> if a address version with the primary key could not be found
	 */
	@Override
	public AddressVersion fetchByPrimaryKey(long addressVersionId) {
		return fetchByPrimaryKey((Serializable)addressVersionId);
	}

	/**
	 * Returns all the address versions.
	 *
	 * @return the address versions
	 */
	@Override
	public List<AddressVersion> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the address versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of address versions
	 * @param end the upper bound of the range of address versions (not inclusive)
	 * @return the range of address versions
	 */
	@Override
	public List<AddressVersion> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the address versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of address versions
	 * @param end the upper bound of the range of address versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of address versions
	 */
	@Override
	public List<AddressVersion> findAll(
		int start, int end,
		OrderByComparator<AddressVersion> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the address versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of address versions
	 * @param end the upper bound of the range of address versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of address versions
	 */
	@Override
	public List<AddressVersion> findAll(
		int start, int end, OrderByComparator<AddressVersion> orderByComparator,
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

		List<AddressVersion> list = null;

		if (useFinderCache) {
			list = (List<AddressVersion>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ADDRESSVERSION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ADDRESSVERSION;

				sql = sql.concat(AddressVersionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AddressVersion>)QueryUtil.list(
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
	 * Removes all the address versions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AddressVersion addressVersion : findAll()) {
			remove(addressVersion);
		}
	}

	/**
	 * Returns the number of address versions.
	 *
	 * @return the number of address versions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ADDRESSVERSION);

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
		return "addressVersionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ADDRESSVERSION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AddressVersionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the address version persistence.
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

		_setAddressVersionUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAddressVersionUtilPersistence(null);

		entityCache.removeCache(AddressVersionImpl.class.getName());
	}

	private void _setAddressVersionUtilPersistence(
		AddressVersionPersistence addressVersionPersistence) {

		try {
			Field field = AddressVersionUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, addressVersionPersistence);
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

	private static final String _SQL_SELECT_ADDRESSVERSION =
		"SELECT addressVersion FROM AddressVersion addressVersion";

	private static final String _SQL_SELECT_ADDRESSVERSION_WHERE =
		"SELECT addressVersion FROM AddressVersion addressVersion WHERE ";

	private static final String _SQL_COUNT_ADDRESSVERSION =
		"SELECT COUNT(addressVersion) FROM AddressVersion addressVersion";

	private static final String _SQL_COUNT_ADDRESSVERSION_WHERE =
		"SELECT COUNT(addressVersion) FROM AddressVersion addressVersion WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "addressVersion.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AddressVersion exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AddressVersion exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AddressVersionPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private AddressVersionModelArgumentsResolver
		_addressVersionModelArgumentsResolver;

}