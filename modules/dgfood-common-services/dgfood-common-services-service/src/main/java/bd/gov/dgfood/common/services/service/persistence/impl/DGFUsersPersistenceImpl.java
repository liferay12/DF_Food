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

import bd.gov.dgfood.common.services.exception.NoSuchDGFUsersException;
import bd.gov.dgfood.common.services.model.DGFUsers;
import bd.gov.dgfood.common.services.model.DGFUsersTable;
import bd.gov.dgfood.common.services.model.impl.DGFUsersImpl;
import bd.gov.dgfood.common.services.model.impl.DGFUsersModelImpl;
import bd.gov.dgfood.common.services.service.persistence.DGFUsersPersistence;
import bd.gov.dgfood.common.services.service.persistence.DGFUsersUtil;
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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the dgf users service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {DGFUsersPersistence.class, BasePersistence.class})
public class DGFUsersPersistenceImpl
	extends BasePersistenceImpl<DGFUsers> implements DGFUsersPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DGFUsersUtil</code> to access the dgf users persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DGFUsersImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByNationalId;
	private FinderPath _finderPathCountByNationalId;

	/**
	 * Returns the dgf users where nationalId = &#63; or throws a <code>NoSuchDGFUsersException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf users
	 * @throws NoSuchDGFUsersException if a matching dgf users could not be found
	 */
	@Override
	public DGFUsers findByNationalId(String nationalId)
		throws NoSuchDGFUsersException {

		DGFUsers dgfUsers = fetchByNationalId(nationalId);

		if (dgfUsers == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("nationalId=");
			sb.append(nationalId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDGFUsersException(sb.toString());
		}

		return dgfUsers;
	}

	/**
	 * Returns the dgf users where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf users, or <code>null</code> if a matching dgf users could not be found
	 */
	@Override
	public DGFUsers fetchByNationalId(String nationalId) {
		return fetchByNationalId(nationalId, true);
	}

	/**
	 * Returns the dgf users where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf users, or <code>null</code> if a matching dgf users could not be found
	 */
	@Override
	public DGFUsers fetchByNationalId(
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

		if (result instanceof DGFUsers) {
			DGFUsers dgfUsers = (DGFUsers)result;

			if (!Objects.equals(nationalId, dgfUsers.getNationalId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DGFUSERS_WHERE);

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

				List<DGFUsers> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByNationalId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {nationalId};
							}

							_log.warn(
								"DGFUsersPersistenceImpl.fetchByNationalId(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DGFUsers dgfUsers = list.get(0);

					result = dgfUsers;

					cacheResult(dgfUsers);
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
			return (DGFUsers)result;
		}
	}

	/**
	 * Removes the dgf users where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the dgf users that was removed
	 */
	@Override
	public DGFUsers removeByNationalId(String nationalId)
		throws NoSuchDGFUsersException {

		DGFUsers dgfUsers = findByNationalId(nationalId);

		return remove(dgfUsers);
	}

	/**
	 * Returns the number of dgf userses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf userses
	 */
	@Override
	public int countByNationalId(String nationalId) {
		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = _finderPathCountByNationalId;

		Object[] finderArgs = new Object[] {nationalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFUSERS_WHERE);

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
		"dgfUsers.nationalId = ?";

	private static final String _FINDER_COLUMN_NATIONALID_NATIONALID_3 =
		"(dgfUsers.nationalId IS NULL OR dgfUsers.nationalId = '')";

	public DGFUsersPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("password", "password_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DGFUsers.class);

		setModelImplClass(DGFUsersImpl.class);
		setModelPKClass(long.class);

		setTable(DGFUsersTable.INSTANCE);
	}

	/**
	 * Caches the dgf users in the entity cache if it is enabled.
	 *
	 * @param dgfUsers the dgf users
	 */
	@Override
	public void cacheResult(DGFUsers dgfUsers) {
		entityCache.putResult(
			DGFUsersImpl.class, dgfUsers.getPrimaryKey(), dgfUsers);

		finderCache.putResult(
			_finderPathFetchByNationalId,
			new Object[] {dgfUsers.getNationalId()}, dgfUsers);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dgf userses in the entity cache if it is enabled.
	 *
	 * @param dgfUserses the dgf userses
	 */
	@Override
	public void cacheResult(List<DGFUsers> dgfUserses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgfUserses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DGFUsers dgfUsers : dgfUserses) {
			if (entityCache.getResult(
					DGFUsersImpl.class, dgfUsers.getPrimaryKey()) == null) {

				cacheResult(dgfUsers);
			}
		}
	}

	/**
	 * Clears the cache for all dgf userses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DGFUsersImpl.class);

		finderCache.clearCache(DGFUsersImpl.class);
	}

	/**
	 * Clears the cache for the dgf users.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DGFUsers dgfUsers) {
		entityCache.removeResult(DGFUsersImpl.class, dgfUsers);
	}

	@Override
	public void clearCache(List<DGFUsers> dgfUserses) {
		for (DGFUsers dgfUsers : dgfUserses) {
			entityCache.removeResult(DGFUsersImpl.class, dgfUsers);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DGFUsersImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DGFUsersImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DGFUsersModelImpl dgfUsersModelImpl) {

		Object[] args = new Object[] {dgfUsersModelImpl.getNationalId()};

		finderCache.putResult(
			_finderPathCountByNationalId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByNationalId, args, dgfUsersModelImpl);
	}

	/**
	 * Creates a new dgf users with the primary key. Does not add the dgf users to the database.
	 *
	 * @param dgfUserId the primary key for the new dgf users
	 * @return the new dgf users
	 */
	@Override
	public DGFUsers create(long dgfUserId) {
		DGFUsers dgfUsers = new DGFUsersImpl();

		dgfUsers.setNew(true);
		dgfUsers.setPrimaryKey(dgfUserId);

		return dgfUsers;
	}

	/**
	 * Removes the dgf users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dgfUserId the primary key of the dgf users
	 * @return the dgf users that was removed
	 * @throws NoSuchDGFUsersException if a dgf users with the primary key could not be found
	 */
	@Override
	public DGFUsers remove(long dgfUserId) throws NoSuchDGFUsersException {
		return remove((Serializable)dgfUserId);
	}

	/**
	 * Removes the dgf users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dgf users
	 * @return the dgf users that was removed
	 * @throws NoSuchDGFUsersException if a dgf users with the primary key could not be found
	 */
	@Override
	public DGFUsers remove(Serializable primaryKey)
		throws NoSuchDGFUsersException {

		Session session = null;

		try {
			session = openSession();

			DGFUsers dgfUsers = (DGFUsers)session.get(
				DGFUsersImpl.class, primaryKey);

			if (dgfUsers == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDGFUsersException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgfUsers);
		}
		catch (NoSuchDGFUsersException noSuchEntityException) {
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
	protected DGFUsers removeImpl(DGFUsers dgfUsers) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgfUsers)) {
				dgfUsers = (DGFUsers)session.get(
					DGFUsersImpl.class, dgfUsers.getPrimaryKeyObj());
			}

			if (dgfUsers != null) {
				session.delete(dgfUsers);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgfUsers != null) {
			clearCache(dgfUsers);
		}

		return dgfUsers;
	}

	@Override
	public DGFUsers updateImpl(DGFUsers dgfUsers) {
		boolean isNew = dgfUsers.isNew();

		if (!(dgfUsers instanceof DGFUsersModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dgfUsers.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(dgfUsers);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dgfUsers proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DGFUsers implementation " +
					dgfUsers.getClass());
		}

		DGFUsersModelImpl dgfUsersModelImpl = (DGFUsersModelImpl)dgfUsers;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgfUsers);
			}
			else {
				dgfUsers = (DGFUsers)session.merge(dgfUsers);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DGFUsersImpl.class, dgfUsersModelImpl, false, true);

		cacheUniqueFindersCache(dgfUsersModelImpl);

		if (isNew) {
			dgfUsers.setNew(false);
		}

		dgfUsers.resetOriginalValues();

		return dgfUsers;
	}

	/**
	 * Returns the dgf users with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dgf users
	 * @return the dgf users
	 * @throws NoSuchDGFUsersException if a dgf users with the primary key could not be found
	 */
	@Override
	public DGFUsers findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDGFUsersException {

		DGFUsers dgfUsers = fetchByPrimaryKey(primaryKey);

		if (dgfUsers == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDGFUsersException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgfUsers;
	}

	/**
	 * Returns the dgf users with the primary key or throws a <code>NoSuchDGFUsersException</code> if it could not be found.
	 *
	 * @param dgfUserId the primary key of the dgf users
	 * @return the dgf users
	 * @throws NoSuchDGFUsersException if a dgf users with the primary key could not be found
	 */
	@Override
	public DGFUsers findByPrimaryKey(long dgfUserId)
		throws NoSuchDGFUsersException {

		return findByPrimaryKey((Serializable)dgfUserId);
	}

	/**
	 * Returns the dgf users with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dgfUserId the primary key of the dgf users
	 * @return the dgf users, or <code>null</code> if a dgf users with the primary key could not be found
	 */
	@Override
	public DGFUsers fetchByPrimaryKey(long dgfUserId) {
		return fetchByPrimaryKey((Serializable)dgfUserId);
	}

	/**
	 * Returns all the dgf userses.
	 *
	 * @return the dgf userses
	 */
	@Override
	public List<DGFUsers> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @return the range of dgf userses
	 */
	@Override
	public List<DGFUsers> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf userses
	 */
	@Override
	public List<DGFUsers> findAll(
		int start, int end, OrderByComparator<DGFUsers> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf userses
	 */
	@Override
	public List<DGFUsers> findAll(
		int start, int end, OrderByComparator<DGFUsers> orderByComparator,
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

		List<DGFUsers> list = null;

		if (useFinderCache) {
			list = (List<DGFUsers>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFUSERS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFUSERS;

				sql = sql.concat(DGFUsersModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DGFUsers>)QueryUtil.list(
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
	 * Removes all the dgf userses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DGFUsers dgfUsers : findAll()) {
			remove(dgfUsers);
		}
	}

	/**
	 * Returns the number of dgf userses.
	 *
	 * @return the number of dgf userses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DGFUSERS);

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
		return "dgfUserId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DGFUSERS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DGFUsersModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dgf users persistence.
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

		_finderPathFetchByNationalId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByNationalId",
			new String[] {String.class.getName()}, new String[] {"nationalId"},
			true);

		_finderPathCountByNationalId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNationalId",
			new String[] {String.class.getName()}, new String[] {"nationalId"},
			false);

		_setDGFUsersUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDGFUsersUtilPersistence(null);

		entityCache.removeCache(DGFUsersImpl.class.getName());
	}

	private void _setDGFUsersUtilPersistence(
		DGFUsersPersistence dgfUsersPersistence) {

		try {
			Field field = DGFUsersUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, dgfUsersPersistence);
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

	private static final String _SQL_SELECT_DGFUSERS =
		"SELECT dgfUsers FROM DGFUsers dgfUsers";

	private static final String _SQL_SELECT_DGFUSERS_WHERE =
		"SELECT dgfUsers FROM DGFUsers dgfUsers WHERE ";

	private static final String _SQL_COUNT_DGFUSERS =
		"SELECT COUNT(dgfUsers) FROM DGFUsers dgfUsers";

	private static final String _SQL_COUNT_DGFUSERS_WHERE =
		"SELECT COUNT(dgfUsers) FROM DGFUsers dgfUsers WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dgfUsers.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DGFUsers exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DGFUsers exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DGFUsersPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"password"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private DGFUsersModelArgumentsResolver _dgfUsersModelArgumentsResolver;

}