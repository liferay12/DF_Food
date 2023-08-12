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

import bd.gov.dgfood.common.services.exception.NoSuchUserDetailsException;
import bd.gov.dgfood.common.services.model.UserDetails;
import bd.gov.dgfood.common.services.model.UserDetailsTable;
import bd.gov.dgfood.common.services.model.impl.UserDetailsImpl;
import bd.gov.dgfood.common.services.model.impl.UserDetailsModelImpl;
import bd.gov.dgfood.common.services.service.persistence.UserDetailsPersistence;
import bd.gov.dgfood.common.services.service.persistence.UserDetailsUtil;
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
 * The persistence implementation for the user details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {UserDetailsPersistence.class, BasePersistence.class})
public class UserDetailsPersistenceImpl
	extends BasePersistenceImpl<UserDetails> implements UserDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UserDetailsUtil</code> to access the user details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UserDetailsImpl.class.getName();

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
	 * Returns the user details where nationalId = &#63; or throws a <code>NoSuchUserDetailsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching user details
	 * @throws NoSuchUserDetailsException if a matching user details could not be found
	 */
	@Override
	public UserDetails findByNationalId(String nationalId)
		throws NoSuchUserDetailsException {

		UserDetails userDetails = fetchByNationalId(nationalId);

		if (userDetails == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("nationalId=");
			sb.append(nationalId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchUserDetailsException(sb.toString());
		}

		return userDetails;
	}

	/**
	 * Returns the user details where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching user details, or <code>null</code> if a matching user details could not be found
	 */
	@Override
	public UserDetails fetchByNationalId(String nationalId) {
		return fetchByNationalId(nationalId, true);
	}

	/**
	 * Returns the user details where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user details, or <code>null</code> if a matching user details could not be found
	 */
	@Override
	public UserDetails fetchByNationalId(
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

		if (result instanceof UserDetails) {
			UserDetails userDetails = (UserDetails)result;

			if (!Objects.equals(nationalId, userDetails.getNationalId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_USERDETAILS_WHERE);

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

				List<UserDetails> list = query.list();

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
								"UserDetailsPersistenceImpl.fetchByNationalId(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					UserDetails userDetails = list.get(0);

					result = userDetails;

					cacheResult(userDetails);
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
			return (UserDetails)result;
		}
	}

	/**
	 * Removes the user details where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the user details that was removed
	 */
	@Override
	public UserDetails removeByNationalId(String nationalId)
		throws NoSuchUserDetailsException {

		UserDetails userDetails = findByNationalId(nationalId);

		return remove(userDetails);
	}

	/**
	 * Returns the number of user detailses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching user detailses
	 */
	@Override
	public int countByNationalId(String nationalId) {
		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = _finderPathCountByNationalId;

		Object[] finderArgs = new Object[] {nationalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_USERDETAILS_WHERE);

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
		"userDetails.nationalId = ?";

	private static final String _FINDER_COLUMN_NATIONALID_NATIONALID_3 =
		"(userDetails.nationalId IS NULL OR userDetails.nationalId = '')";

	public UserDetailsPersistenceImpl() {
		setModelClass(UserDetails.class);

		setModelImplClass(UserDetailsImpl.class);
		setModelPKClass(long.class);

		setTable(UserDetailsTable.INSTANCE);
	}

	/**
	 * Caches the user details in the entity cache if it is enabled.
	 *
	 * @param userDetails the user details
	 */
	@Override
	public void cacheResult(UserDetails userDetails) {
		entityCache.putResult(
			UserDetailsImpl.class, userDetails.getPrimaryKey(), userDetails);

		finderCache.putResult(
			_finderPathFetchByNationalId,
			new Object[] {userDetails.getNationalId()}, userDetails);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the user detailses in the entity cache if it is enabled.
	 *
	 * @param userDetailses the user detailses
	 */
	@Override
	public void cacheResult(List<UserDetails> userDetailses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (userDetailses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (UserDetails userDetails : userDetailses) {
			if (entityCache.getResult(
					UserDetailsImpl.class, userDetails.getPrimaryKey()) ==
						null) {

				cacheResult(userDetails);
			}
		}
	}

	/**
	 * Clears the cache for all user detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserDetailsImpl.class);

		finderCache.clearCache(UserDetailsImpl.class);
	}

	/**
	 * Clears the cache for the user details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserDetails userDetails) {
		entityCache.removeResult(UserDetailsImpl.class, userDetails);
	}

	@Override
	public void clearCache(List<UserDetails> userDetailses) {
		for (UserDetails userDetails : userDetailses) {
			entityCache.removeResult(UserDetailsImpl.class, userDetails);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(UserDetailsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(UserDetailsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		UserDetailsModelImpl userDetailsModelImpl) {

		Object[] args = new Object[] {userDetailsModelImpl.getNationalId()};

		finderCache.putResult(
			_finderPathCountByNationalId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByNationalId, args, userDetailsModelImpl);
	}

	/**
	 * Creates a new user details with the primary key. Does not add the user details to the database.
	 *
	 * @param userDetailsId the primary key for the new user details
	 * @return the new user details
	 */
	@Override
	public UserDetails create(long userDetailsId) {
		UserDetails userDetails = new UserDetailsImpl();

		userDetails.setNew(true);
		userDetails.setPrimaryKey(userDetailsId);

		return userDetails;
	}

	/**
	 * Removes the user details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userDetailsId the primary key of the user details
	 * @return the user details that was removed
	 * @throws NoSuchUserDetailsException if a user details with the primary key could not be found
	 */
	@Override
	public UserDetails remove(long userDetailsId)
		throws NoSuchUserDetailsException {

		return remove((Serializable)userDetailsId);
	}

	/**
	 * Removes the user details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user details
	 * @return the user details that was removed
	 * @throws NoSuchUserDetailsException if a user details with the primary key could not be found
	 */
	@Override
	public UserDetails remove(Serializable primaryKey)
		throws NoSuchUserDetailsException {

		Session session = null;

		try {
			session = openSession();

			UserDetails userDetails = (UserDetails)session.get(
				UserDetailsImpl.class, primaryKey);

			if (userDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(userDetails);
		}
		catch (NoSuchUserDetailsException noSuchEntityException) {
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
	protected UserDetails removeImpl(UserDetails userDetails) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userDetails)) {
				userDetails = (UserDetails)session.get(
					UserDetailsImpl.class, userDetails.getPrimaryKeyObj());
			}

			if (userDetails != null) {
				session.delete(userDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (userDetails != null) {
			clearCache(userDetails);
		}

		return userDetails;
	}

	@Override
	public UserDetails updateImpl(UserDetails userDetails) {
		boolean isNew = userDetails.isNew();

		if (!(userDetails instanceof UserDetailsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(userDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(userDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in userDetails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UserDetails implementation " +
					userDetails.getClass());
		}

		UserDetailsModelImpl userDetailsModelImpl =
			(UserDetailsModelImpl)userDetails;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(userDetails);
			}
			else {
				userDetails = (UserDetails)session.merge(userDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			UserDetailsImpl.class, userDetailsModelImpl, false, true);

		cacheUniqueFindersCache(userDetailsModelImpl);

		if (isNew) {
			userDetails.setNew(false);
		}

		userDetails.resetOriginalValues();

		return userDetails;
	}

	/**
	 * Returns the user details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user details
	 * @return the user details
	 * @throws NoSuchUserDetailsException if a user details with the primary key could not be found
	 */
	@Override
	public UserDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserDetailsException {

		UserDetails userDetails = fetchByPrimaryKey(primaryKey);

		if (userDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return userDetails;
	}

	/**
	 * Returns the user details with the primary key or throws a <code>NoSuchUserDetailsException</code> if it could not be found.
	 *
	 * @param userDetailsId the primary key of the user details
	 * @return the user details
	 * @throws NoSuchUserDetailsException if a user details with the primary key could not be found
	 */
	@Override
	public UserDetails findByPrimaryKey(long userDetailsId)
		throws NoSuchUserDetailsException {

		return findByPrimaryKey((Serializable)userDetailsId);
	}

	/**
	 * Returns the user details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userDetailsId the primary key of the user details
	 * @return the user details, or <code>null</code> if a user details with the primary key could not be found
	 */
	@Override
	public UserDetails fetchByPrimaryKey(long userDetailsId) {
		return fetchByPrimaryKey((Serializable)userDetailsId);
	}

	/**
	 * Returns all the user detailses.
	 *
	 * @return the user detailses
	 */
	@Override
	public List<UserDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user detailses
	 * @param end the upper bound of the range of user detailses (not inclusive)
	 * @return the range of user detailses
	 */
	@Override
	public List<UserDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user detailses
	 * @param end the upper bound of the range of user detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user detailses
	 */
	@Override
	public List<UserDetails> findAll(
		int start, int end, OrderByComparator<UserDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user detailses
	 * @param end the upper bound of the range of user detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user detailses
	 */
	@Override
	public List<UserDetails> findAll(
		int start, int end, OrderByComparator<UserDetails> orderByComparator,
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

		List<UserDetails> list = null;

		if (useFinderCache) {
			list = (List<UserDetails>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_USERDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_USERDETAILS;

				sql = sql.concat(UserDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<UserDetails>)QueryUtil.list(
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
	 * Removes all the user detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserDetails userDetails : findAll()) {
			remove(userDetails);
		}
	}

	/**
	 * Returns the number of user detailses.
	 *
	 * @return the number of user detailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_USERDETAILS);

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
		return "userDetailsId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_USERDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UserDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user details persistence.
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

		_setUserDetailsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setUserDetailsUtilPersistence(null);

		entityCache.removeCache(UserDetailsImpl.class.getName());
	}

	private void _setUserDetailsUtilPersistence(
		UserDetailsPersistence userDetailsPersistence) {

		try {
			Field field = UserDetailsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, userDetailsPersistence);
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

	private static final String _SQL_SELECT_USERDETAILS =
		"SELECT userDetails FROM UserDetails userDetails";

	private static final String _SQL_SELECT_USERDETAILS_WHERE =
		"SELECT userDetails FROM UserDetails userDetails WHERE ";

	private static final String _SQL_COUNT_USERDETAILS =
		"SELECT COUNT(userDetails) FROM UserDetails userDetails";

	private static final String _SQL_COUNT_USERDETAILS_WHERE =
		"SELECT COUNT(userDetails) FROM UserDetails userDetails WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "userDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UserDetails exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No UserDetails exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		UserDetailsPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private UserDetailsModelArgumentsResolver
		_userDetailsModelArgumentsResolver;

}