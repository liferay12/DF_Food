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

import bd.gov.dgfood.common.services.exception.NoSuchBankAccountInformationException;
import bd.gov.dgfood.common.services.model.BankAccountInformation;
import bd.gov.dgfood.common.services.model.BankAccountInformationTable;
import bd.gov.dgfood.common.services.model.impl.BankAccountInformationImpl;
import bd.gov.dgfood.common.services.model.impl.BankAccountInformationModelImpl;
import bd.gov.dgfood.common.services.service.persistence.BankAccountInformationPersistence;
import bd.gov.dgfood.common.services.service.persistence.BankAccountInformationUtil;
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
 * The persistence implementation for the bank account information service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {BankAccountInformationPersistence.class, BasePersistence.class}
)
public class BankAccountInformationPersistenceImpl
	extends BasePersistenceImpl<BankAccountInformation>
	implements BankAccountInformationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BankAccountInformationUtil</code> to access the bank account information persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BankAccountInformationImpl.class.getName();

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
	 * Returns all the bank account informations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching bank account informations
	 */
	@Override
	public List<BankAccountInformation> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bank account informations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankAccountInformationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bank account informations
	 * @param end the upper bound of the range of bank account informations (not inclusive)
	 * @return the range of matching bank account informations
	 */
	@Override
	public List<BankAccountInformation> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bank account informations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankAccountInformationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bank account informations
	 * @param end the upper bound of the range of bank account informations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bank account informations
	 */
	@Override
	public List<BankAccountInformation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BankAccountInformation> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bank account informations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankAccountInformationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bank account informations
	 * @param end the upper bound of the range of bank account informations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bank account informations
	 */
	@Override
	public List<BankAccountInformation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BankAccountInformation> orderByComparator,
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

		List<BankAccountInformation> list = null;

		if (useFinderCache) {
			list = (List<BankAccountInformation>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (BankAccountInformation bankAccountInformation : list) {
					if (!uuid.equals(bankAccountInformation.getUuid())) {
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

			sb.append(_SQL_SELECT_BANKACCOUNTINFORMATION_WHERE);

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
				sb.append(BankAccountInformationModelImpl.ORDER_BY_JPQL);
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

				list = (List<BankAccountInformation>)QueryUtil.list(
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
	 * Returns the first bank account information in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank account information
	 * @throws NoSuchBankAccountInformationException if a matching bank account information could not be found
	 */
	@Override
	public BankAccountInformation findByUuid_First(
			String uuid,
			OrderByComparator<BankAccountInformation> orderByComparator)
		throws NoSuchBankAccountInformationException {

		BankAccountInformation bankAccountInformation = fetchByUuid_First(
			uuid, orderByComparator);

		if (bankAccountInformation != null) {
			return bankAccountInformation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBankAccountInformationException(sb.toString());
	}

	/**
	 * Returns the first bank account information in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank account information, or <code>null</code> if a matching bank account information could not be found
	 */
	@Override
	public BankAccountInformation fetchByUuid_First(
		String uuid,
		OrderByComparator<BankAccountInformation> orderByComparator) {

		List<BankAccountInformation> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bank account information in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank account information
	 * @throws NoSuchBankAccountInformationException if a matching bank account information could not be found
	 */
	@Override
	public BankAccountInformation findByUuid_Last(
			String uuid,
			OrderByComparator<BankAccountInformation> orderByComparator)
		throws NoSuchBankAccountInformationException {

		BankAccountInformation bankAccountInformation = fetchByUuid_Last(
			uuid, orderByComparator);

		if (bankAccountInformation != null) {
			return bankAccountInformation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBankAccountInformationException(sb.toString());
	}

	/**
	 * Returns the last bank account information in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank account information, or <code>null</code> if a matching bank account information could not be found
	 */
	@Override
	public BankAccountInformation fetchByUuid_Last(
		String uuid,
		OrderByComparator<BankAccountInformation> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<BankAccountInformation> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bank account informations before and after the current bank account information in the ordered set where uuid = &#63;.
	 *
	 * @param bankAccountInformationId the primary key of the current bank account information
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bank account information
	 * @throws NoSuchBankAccountInformationException if a bank account information with the primary key could not be found
	 */
	@Override
	public BankAccountInformation[] findByUuid_PrevAndNext(
			long bankAccountInformationId, String uuid,
			OrderByComparator<BankAccountInformation> orderByComparator)
		throws NoSuchBankAccountInformationException {

		uuid = Objects.toString(uuid, "");

		BankAccountInformation bankAccountInformation = findByPrimaryKey(
			bankAccountInformationId);

		Session session = null;

		try {
			session = openSession();

			BankAccountInformation[] array = new BankAccountInformationImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, bankAccountInformation, uuid, orderByComparator, true);

			array[1] = bankAccountInformation;

			array[2] = getByUuid_PrevAndNext(
				session, bankAccountInformation, uuid, orderByComparator,
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

	protected BankAccountInformation getByUuid_PrevAndNext(
		Session session, BankAccountInformation bankAccountInformation,
		String uuid,
		OrderByComparator<BankAccountInformation> orderByComparator,
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

		sb.append(_SQL_SELECT_BANKACCOUNTINFORMATION_WHERE);

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
			sb.append(BankAccountInformationModelImpl.ORDER_BY_JPQL);
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
						bankAccountInformation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BankAccountInformation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bank account informations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (BankAccountInformation bankAccountInformation :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(bankAccountInformation);
		}
	}

	/**
	 * Returns the number of bank account informations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching bank account informations
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BANKACCOUNTINFORMATION_WHERE);

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
		"bankAccountInformation.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(bankAccountInformation.uuid IS NULL OR bankAccountInformation.uuid = '')";

	public BankAccountInformationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(BankAccountInformation.class);

		setModelImplClass(BankAccountInformationImpl.class);
		setModelPKClass(long.class);

		setTable(BankAccountInformationTable.INSTANCE);
	}

	/**
	 * Caches the bank account information in the entity cache if it is enabled.
	 *
	 * @param bankAccountInformation the bank account information
	 */
	@Override
	public void cacheResult(BankAccountInformation bankAccountInformation) {
		entityCache.putResult(
			BankAccountInformationImpl.class,
			bankAccountInformation.getPrimaryKey(), bankAccountInformation);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the bank account informations in the entity cache if it is enabled.
	 *
	 * @param bankAccountInformations the bank account informations
	 */
	@Override
	public void cacheResult(
		List<BankAccountInformation> bankAccountInformations) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (bankAccountInformations.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (BankAccountInformation bankAccountInformation :
				bankAccountInformations) {

			if (entityCache.getResult(
					BankAccountInformationImpl.class,
					bankAccountInformation.getPrimaryKey()) == null) {

				cacheResult(bankAccountInformation);
			}
		}
	}

	/**
	 * Clears the cache for all bank account informations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BankAccountInformationImpl.class);

		finderCache.clearCache(BankAccountInformationImpl.class);
	}

	/**
	 * Clears the cache for the bank account information.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BankAccountInformation bankAccountInformation) {
		entityCache.removeResult(
			BankAccountInformationImpl.class, bankAccountInformation);
	}

	@Override
	public void clearCache(
		List<BankAccountInformation> bankAccountInformations) {

		for (BankAccountInformation bankAccountInformation :
				bankAccountInformations) {

			entityCache.removeResult(
				BankAccountInformationImpl.class, bankAccountInformation);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(BankAccountInformationImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				BankAccountInformationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new bank account information with the primary key. Does not add the bank account information to the database.
	 *
	 * @param bankAccountInformationId the primary key for the new bank account information
	 * @return the new bank account information
	 */
	@Override
	public BankAccountInformation create(long bankAccountInformationId) {
		BankAccountInformation bankAccountInformation =
			new BankAccountInformationImpl();

		bankAccountInformation.setNew(true);
		bankAccountInformation.setPrimaryKey(bankAccountInformationId);

		String uuid = _portalUUID.generate();

		bankAccountInformation.setUuid(uuid);

		return bankAccountInformation;
	}

	/**
	 * Removes the bank account information with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bankAccountInformationId the primary key of the bank account information
	 * @return the bank account information that was removed
	 * @throws NoSuchBankAccountInformationException if a bank account information with the primary key could not be found
	 */
	@Override
	public BankAccountInformation remove(long bankAccountInformationId)
		throws NoSuchBankAccountInformationException {

		return remove((Serializable)bankAccountInformationId);
	}

	/**
	 * Removes the bank account information with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bank account information
	 * @return the bank account information that was removed
	 * @throws NoSuchBankAccountInformationException if a bank account information with the primary key could not be found
	 */
	@Override
	public BankAccountInformation remove(Serializable primaryKey)
		throws NoSuchBankAccountInformationException {

		Session session = null;

		try {
			session = openSession();

			BankAccountInformation bankAccountInformation =
				(BankAccountInformation)session.get(
					BankAccountInformationImpl.class, primaryKey);

			if (bankAccountInformation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBankAccountInformationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(bankAccountInformation);
		}
		catch (NoSuchBankAccountInformationException noSuchEntityException) {
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
	protected BankAccountInformation removeImpl(
		BankAccountInformation bankAccountInformation) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bankAccountInformation)) {
				bankAccountInformation = (BankAccountInformation)session.get(
					BankAccountInformationImpl.class,
					bankAccountInformation.getPrimaryKeyObj());
			}

			if (bankAccountInformation != null) {
				session.delete(bankAccountInformation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (bankAccountInformation != null) {
			clearCache(bankAccountInformation);
		}

		return bankAccountInformation;
	}

	@Override
	public BankAccountInformation updateImpl(
		BankAccountInformation bankAccountInformation) {

		boolean isNew = bankAccountInformation.isNew();

		if (!(bankAccountInformation instanceof
				BankAccountInformationModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(bankAccountInformation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					bankAccountInformation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in bankAccountInformation proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BankAccountInformation implementation " +
					bankAccountInformation.getClass());
		}

		BankAccountInformationModelImpl bankAccountInformationModelImpl =
			(BankAccountInformationModelImpl)bankAccountInformation;

		if (Validator.isNull(bankAccountInformation.getUuid())) {
			String uuid = _portalUUID.generate();

			bankAccountInformation.setUuid(uuid);
		}

		if (isNew && (bankAccountInformation.getCreateDate() == null)) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				bankAccountInformation.setCreateDate(date);
			}
			else {
				bankAccountInformation.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(bankAccountInformation);
			}
			else {
				bankAccountInformation = (BankAccountInformation)session.merge(
					bankAccountInformation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			BankAccountInformationImpl.class, bankAccountInformationModelImpl,
			false, true);

		if (isNew) {
			bankAccountInformation.setNew(false);
		}

		bankAccountInformation.resetOriginalValues();

		return bankAccountInformation;
	}

	/**
	 * Returns the bank account information with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bank account information
	 * @return the bank account information
	 * @throws NoSuchBankAccountInformationException if a bank account information with the primary key could not be found
	 */
	@Override
	public BankAccountInformation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBankAccountInformationException {

		BankAccountInformation bankAccountInformation = fetchByPrimaryKey(
			primaryKey);

		if (bankAccountInformation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBankAccountInformationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return bankAccountInformation;
	}

	/**
	 * Returns the bank account information with the primary key or throws a <code>NoSuchBankAccountInformationException</code> if it could not be found.
	 *
	 * @param bankAccountInformationId the primary key of the bank account information
	 * @return the bank account information
	 * @throws NoSuchBankAccountInformationException if a bank account information with the primary key could not be found
	 */
	@Override
	public BankAccountInformation findByPrimaryKey(
			long bankAccountInformationId)
		throws NoSuchBankAccountInformationException {

		return findByPrimaryKey((Serializable)bankAccountInformationId);
	}

	/**
	 * Returns the bank account information with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bankAccountInformationId the primary key of the bank account information
	 * @return the bank account information, or <code>null</code> if a bank account information with the primary key could not be found
	 */
	@Override
	public BankAccountInformation fetchByPrimaryKey(
		long bankAccountInformationId) {

		return fetchByPrimaryKey((Serializable)bankAccountInformationId);
	}

	/**
	 * Returns all the bank account informations.
	 *
	 * @return the bank account informations
	 */
	@Override
	public List<BankAccountInformation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bank account informations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankAccountInformationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bank account informations
	 * @param end the upper bound of the range of bank account informations (not inclusive)
	 * @return the range of bank account informations
	 */
	@Override
	public List<BankAccountInformation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bank account informations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankAccountInformationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bank account informations
	 * @param end the upper bound of the range of bank account informations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bank account informations
	 */
	@Override
	public List<BankAccountInformation> findAll(
		int start, int end,
		OrderByComparator<BankAccountInformation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bank account informations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankAccountInformationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bank account informations
	 * @param end the upper bound of the range of bank account informations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of bank account informations
	 */
	@Override
	public List<BankAccountInformation> findAll(
		int start, int end,
		OrderByComparator<BankAccountInformation> orderByComparator,
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

		List<BankAccountInformation> list = null;

		if (useFinderCache) {
			list = (List<BankAccountInformation>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BANKACCOUNTINFORMATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BANKACCOUNTINFORMATION;

				sql = sql.concat(BankAccountInformationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<BankAccountInformation>)QueryUtil.list(
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
	 * Removes all the bank account informations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BankAccountInformation bankAccountInformation : findAll()) {
			remove(bankAccountInformation);
		}
	}

	/**
	 * Returns the number of bank account informations.
	 *
	 * @return the number of bank account informations
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
					_SQL_COUNT_BANKACCOUNTINFORMATION);

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
		return "bankAccountInformationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BANKACCOUNTINFORMATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BankAccountInformationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the bank account information persistence.
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

		_setBankAccountInformationUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setBankAccountInformationUtilPersistence(null);

		entityCache.removeCache(BankAccountInformationImpl.class.getName());
	}

	private void _setBankAccountInformationUtilPersistence(
		BankAccountInformationPersistence bankAccountInformationPersistence) {

		try {
			Field field = BankAccountInformationUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, bankAccountInformationPersistence);
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

	private static final String _SQL_SELECT_BANKACCOUNTINFORMATION =
		"SELECT bankAccountInformation FROM BankAccountInformation bankAccountInformation";

	private static final String _SQL_SELECT_BANKACCOUNTINFORMATION_WHERE =
		"SELECT bankAccountInformation FROM BankAccountInformation bankAccountInformation WHERE ";

	private static final String _SQL_COUNT_BANKACCOUNTINFORMATION =
		"SELECT COUNT(bankAccountInformation) FROM BankAccountInformation bankAccountInformation";

	private static final String _SQL_COUNT_BANKACCOUNTINFORMATION_WHERE =
		"SELECT COUNT(bankAccountInformation) FROM BankAccountInformation bankAccountInformation WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"bankAccountInformation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BankAccountInformation exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No BankAccountInformation exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BankAccountInformationPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private BankAccountInformationModelArgumentsResolver
		_bankAccountInformationModelArgumentsResolver;

}