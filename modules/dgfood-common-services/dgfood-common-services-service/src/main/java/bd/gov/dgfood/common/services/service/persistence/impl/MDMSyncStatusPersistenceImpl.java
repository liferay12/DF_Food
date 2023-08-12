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

import bd.gov.dgfood.common.services.exception.NoSuchMDMSyncStatusException;
import bd.gov.dgfood.common.services.model.MDMSyncStatus;
import bd.gov.dgfood.common.services.model.MDMSyncStatusTable;
import bd.gov.dgfood.common.services.model.impl.MDMSyncStatusImpl;
import bd.gov.dgfood.common.services.model.impl.MDMSyncStatusModelImpl;
import bd.gov.dgfood.common.services.service.persistence.MDMSyncStatusPersistence;
import bd.gov.dgfood.common.services.service.persistence.MDMSyncStatusUtil;
import bd.gov.dgfood.common.services.service.persistence.impl.constants.PersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the mdm sync status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {MDMSyncStatusPersistence.class, BasePersistence.class})
public class MDMSyncStatusPersistenceImpl
	extends BasePersistenceImpl<MDMSyncStatus>
	implements MDMSyncStatusPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MDMSyncStatusUtil</code> to access the mdm sync status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MDMSyncStatusImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public MDMSyncStatusPersistenceImpl() {
		setModelClass(MDMSyncStatus.class);

		setModelImplClass(MDMSyncStatusImpl.class);
		setModelPKClass(long.class);

		setTable(MDMSyncStatusTable.INSTANCE);
	}

	/**
	 * Caches the mdm sync status in the entity cache if it is enabled.
	 *
	 * @param mdmSyncStatus the mdm sync status
	 */
	@Override
	public void cacheResult(MDMSyncStatus mdmSyncStatus) {
		entityCache.putResult(
			MDMSyncStatusImpl.class, mdmSyncStatus.getPrimaryKey(),
			mdmSyncStatus);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the mdm sync statuses in the entity cache if it is enabled.
	 *
	 * @param mdmSyncStatuses the mdm sync statuses
	 */
	@Override
	public void cacheResult(List<MDMSyncStatus> mdmSyncStatuses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (mdmSyncStatuses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (MDMSyncStatus mdmSyncStatus : mdmSyncStatuses) {
			if (entityCache.getResult(
					MDMSyncStatusImpl.class, mdmSyncStatus.getPrimaryKey()) ==
						null) {

				cacheResult(mdmSyncStatus);
			}
		}
	}

	/**
	 * Clears the cache for all mdm sync statuses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MDMSyncStatusImpl.class);

		finderCache.clearCache(MDMSyncStatusImpl.class);
	}

	/**
	 * Clears the cache for the mdm sync status.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MDMSyncStatus mdmSyncStatus) {
		entityCache.removeResult(MDMSyncStatusImpl.class, mdmSyncStatus);
	}

	@Override
	public void clearCache(List<MDMSyncStatus> mdmSyncStatuses) {
		for (MDMSyncStatus mdmSyncStatus : mdmSyncStatuses) {
			entityCache.removeResult(MDMSyncStatusImpl.class, mdmSyncStatus);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(MDMSyncStatusImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(MDMSyncStatusImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new mdm sync status with the primary key. Does not add the mdm sync status to the database.
	 *
	 * @param mdmSyncStatusId the primary key for the new mdm sync status
	 * @return the new mdm sync status
	 */
	@Override
	public MDMSyncStatus create(long mdmSyncStatusId) {
		MDMSyncStatus mdmSyncStatus = new MDMSyncStatusImpl();

		mdmSyncStatus.setNew(true);
		mdmSyncStatus.setPrimaryKey(mdmSyncStatusId);

		return mdmSyncStatus;
	}

	/**
	 * Removes the mdm sync status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mdmSyncStatusId the primary key of the mdm sync status
	 * @return the mdm sync status that was removed
	 * @throws NoSuchMDMSyncStatusException if a mdm sync status with the primary key could not be found
	 */
	@Override
	public MDMSyncStatus remove(long mdmSyncStatusId)
		throws NoSuchMDMSyncStatusException {

		return remove((Serializable)mdmSyncStatusId);
	}

	/**
	 * Removes the mdm sync status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the mdm sync status
	 * @return the mdm sync status that was removed
	 * @throws NoSuchMDMSyncStatusException if a mdm sync status with the primary key could not be found
	 */
	@Override
	public MDMSyncStatus remove(Serializable primaryKey)
		throws NoSuchMDMSyncStatusException {

		Session session = null;

		try {
			session = openSession();

			MDMSyncStatus mdmSyncStatus = (MDMSyncStatus)session.get(
				MDMSyncStatusImpl.class, primaryKey);

			if (mdmSyncStatus == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMDMSyncStatusException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(mdmSyncStatus);
		}
		catch (NoSuchMDMSyncStatusException noSuchEntityException) {
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
	protected MDMSyncStatus removeImpl(MDMSyncStatus mdmSyncStatus) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(mdmSyncStatus)) {
				mdmSyncStatus = (MDMSyncStatus)session.get(
					MDMSyncStatusImpl.class, mdmSyncStatus.getPrimaryKeyObj());
			}

			if (mdmSyncStatus != null) {
				session.delete(mdmSyncStatus);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (mdmSyncStatus != null) {
			clearCache(mdmSyncStatus);
		}

		return mdmSyncStatus;
	}

	@Override
	public MDMSyncStatus updateImpl(MDMSyncStatus mdmSyncStatus) {
		boolean isNew = mdmSyncStatus.isNew();

		if (!(mdmSyncStatus instanceof MDMSyncStatusModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(mdmSyncStatus.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					mdmSyncStatus);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in mdmSyncStatus proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MDMSyncStatus implementation " +
					mdmSyncStatus.getClass());
		}

		MDMSyncStatusModelImpl mdmSyncStatusModelImpl =
			(MDMSyncStatusModelImpl)mdmSyncStatus;

		if (isNew && (mdmSyncStatus.getCreateDate() == null)) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				mdmSyncStatus.setCreateDate(date);
			}
			else {
				mdmSyncStatus.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(mdmSyncStatus);
			}
			else {
				mdmSyncStatus = (MDMSyncStatus)session.merge(mdmSyncStatus);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			MDMSyncStatusImpl.class, mdmSyncStatus, false, true);

		if (isNew) {
			mdmSyncStatus.setNew(false);
		}

		mdmSyncStatus.resetOriginalValues();

		return mdmSyncStatus;
	}

	/**
	 * Returns the mdm sync status with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the mdm sync status
	 * @return the mdm sync status
	 * @throws NoSuchMDMSyncStatusException if a mdm sync status with the primary key could not be found
	 */
	@Override
	public MDMSyncStatus findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMDMSyncStatusException {

		MDMSyncStatus mdmSyncStatus = fetchByPrimaryKey(primaryKey);

		if (mdmSyncStatus == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMDMSyncStatusException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return mdmSyncStatus;
	}

	/**
	 * Returns the mdm sync status with the primary key or throws a <code>NoSuchMDMSyncStatusException</code> if it could not be found.
	 *
	 * @param mdmSyncStatusId the primary key of the mdm sync status
	 * @return the mdm sync status
	 * @throws NoSuchMDMSyncStatusException if a mdm sync status with the primary key could not be found
	 */
	@Override
	public MDMSyncStatus findByPrimaryKey(long mdmSyncStatusId)
		throws NoSuchMDMSyncStatusException {

		return findByPrimaryKey((Serializable)mdmSyncStatusId);
	}

	/**
	 * Returns the mdm sync status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mdmSyncStatusId the primary key of the mdm sync status
	 * @return the mdm sync status, or <code>null</code> if a mdm sync status with the primary key could not be found
	 */
	@Override
	public MDMSyncStatus fetchByPrimaryKey(long mdmSyncStatusId) {
		return fetchByPrimaryKey((Serializable)mdmSyncStatusId);
	}

	/**
	 * Returns all the mdm sync statuses.
	 *
	 * @return the mdm sync statuses
	 */
	@Override
	public List<MDMSyncStatus> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the mdm sync statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MDMSyncStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mdm sync statuses
	 * @param end the upper bound of the range of mdm sync statuses (not inclusive)
	 * @return the range of mdm sync statuses
	 */
	@Override
	public List<MDMSyncStatus> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the mdm sync statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MDMSyncStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mdm sync statuses
	 * @param end the upper bound of the range of mdm sync statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of mdm sync statuses
	 */
	@Override
	public List<MDMSyncStatus> findAll(
		int start, int end,
		OrderByComparator<MDMSyncStatus> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the mdm sync statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MDMSyncStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mdm sync statuses
	 * @param end the upper bound of the range of mdm sync statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of mdm sync statuses
	 */
	@Override
	public List<MDMSyncStatus> findAll(
		int start, int end, OrderByComparator<MDMSyncStatus> orderByComparator,
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

		List<MDMSyncStatus> list = null;

		if (useFinderCache) {
			list = (List<MDMSyncStatus>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MDMSYNCSTATUS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MDMSYNCSTATUS;

				sql = sql.concat(MDMSyncStatusModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MDMSyncStatus>)QueryUtil.list(
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
	 * Removes all the mdm sync statuses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MDMSyncStatus mdmSyncStatus : findAll()) {
			remove(mdmSyncStatus);
		}
	}

	/**
	 * Returns the number of mdm sync statuses.
	 *
	 * @return the number of mdm sync statuses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MDMSYNCSTATUS);

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
		return "mdmSyncStatusId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MDMSYNCSTATUS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MDMSyncStatusModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the mdm sync status persistence.
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

		_setMDMSyncStatusUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setMDMSyncStatusUtilPersistence(null);

		entityCache.removeCache(MDMSyncStatusImpl.class.getName());
	}

	private void _setMDMSyncStatusUtilPersistence(
		MDMSyncStatusPersistence mdmSyncStatusPersistence) {

		try {
			Field field = MDMSyncStatusUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, mdmSyncStatusPersistence);
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

	private static final String _SQL_SELECT_MDMSYNCSTATUS =
		"SELECT mdmSyncStatus FROM MDMSyncStatus mdmSyncStatus";

	private static final String _SQL_COUNT_MDMSYNCSTATUS =
		"SELECT COUNT(mdmSyncStatus) FROM MDMSyncStatus mdmSyncStatus";

	private static final String _ORDER_BY_ENTITY_ALIAS = "mdmSyncStatus.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MDMSyncStatus exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		MDMSyncStatusPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private MDMSyncStatusModelArgumentsResolver
		_mdmSyncStatusModelArgumentsResolver;

}