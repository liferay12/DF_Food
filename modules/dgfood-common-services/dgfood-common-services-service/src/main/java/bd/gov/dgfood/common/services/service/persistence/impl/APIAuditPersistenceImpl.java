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

import bd.gov.dgfood.common.services.exception.NoSuchAPIAuditException;
import bd.gov.dgfood.common.services.model.APIAudit;
import bd.gov.dgfood.common.services.model.APIAuditTable;
import bd.gov.dgfood.common.services.model.impl.APIAuditImpl;
import bd.gov.dgfood.common.services.model.impl.APIAuditModelImpl;
import bd.gov.dgfood.common.services.service.persistence.APIAuditPersistence;
import bd.gov.dgfood.common.services.service.persistence.APIAuditUtil;
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
 * The persistence implementation for the api audit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {APIAuditPersistence.class, BasePersistence.class})
public class APIAuditPersistenceImpl
	extends BasePersistenceImpl<APIAudit> implements APIAuditPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>APIAuditUtil</code> to access the api audit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		APIAuditImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public APIAuditPersistenceImpl() {
		setModelClass(APIAudit.class);

		setModelImplClass(APIAuditImpl.class);
		setModelPKClass(long.class);

		setTable(APIAuditTable.INSTANCE);
	}

	/**
	 * Caches the api audit in the entity cache if it is enabled.
	 *
	 * @param apiAudit the api audit
	 */
	@Override
	public void cacheResult(APIAudit apiAudit) {
		entityCache.putResult(
			APIAuditImpl.class, apiAudit.getPrimaryKey(), apiAudit);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the api audits in the entity cache if it is enabled.
	 *
	 * @param apiAudits the api audits
	 */
	@Override
	public void cacheResult(List<APIAudit> apiAudits) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (apiAudits.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (APIAudit apiAudit : apiAudits) {
			if (entityCache.getResult(
					APIAuditImpl.class, apiAudit.getPrimaryKey()) == null) {

				cacheResult(apiAudit);
			}
		}
	}

	/**
	 * Clears the cache for all api audits.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(APIAuditImpl.class);

		finderCache.clearCache(APIAuditImpl.class);
	}

	/**
	 * Clears the cache for the api audit.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(APIAudit apiAudit) {
		entityCache.removeResult(APIAuditImpl.class, apiAudit);
	}

	@Override
	public void clearCache(List<APIAudit> apiAudits) {
		for (APIAudit apiAudit : apiAudits) {
			entityCache.removeResult(APIAuditImpl.class, apiAudit);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(APIAuditImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(APIAuditImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new api audit with the primary key. Does not add the api audit to the database.
	 *
	 * @param apiAuditId the primary key for the new api audit
	 * @return the new api audit
	 */
	@Override
	public APIAudit create(long apiAuditId) {
		APIAudit apiAudit = new APIAuditImpl();

		apiAudit.setNew(true);
		apiAudit.setPrimaryKey(apiAuditId);

		return apiAudit;
	}

	/**
	 * Removes the api audit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param apiAuditId the primary key of the api audit
	 * @return the api audit that was removed
	 * @throws NoSuchAPIAuditException if a api audit with the primary key could not be found
	 */
	@Override
	public APIAudit remove(long apiAuditId) throws NoSuchAPIAuditException {
		return remove((Serializable)apiAuditId);
	}

	/**
	 * Removes the api audit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the api audit
	 * @return the api audit that was removed
	 * @throws NoSuchAPIAuditException if a api audit with the primary key could not be found
	 */
	@Override
	public APIAudit remove(Serializable primaryKey)
		throws NoSuchAPIAuditException {

		Session session = null;

		try {
			session = openSession();

			APIAudit apiAudit = (APIAudit)session.get(
				APIAuditImpl.class, primaryKey);

			if (apiAudit == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAPIAuditException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(apiAudit);
		}
		catch (NoSuchAPIAuditException noSuchEntityException) {
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
	protected APIAudit removeImpl(APIAudit apiAudit) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(apiAudit)) {
				apiAudit = (APIAudit)session.get(
					APIAuditImpl.class, apiAudit.getPrimaryKeyObj());
			}

			if (apiAudit != null) {
				session.delete(apiAudit);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (apiAudit != null) {
			clearCache(apiAudit);
		}

		return apiAudit;
	}

	@Override
	public APIAudit updateImpl(APIAudit apiAudit) {
		boolean isNew = apiAudit.isNew();

		if (!(apiAudit instanceof APIAuditModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(apiAudit.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(apiAudit);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in apiAudit proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom APIAudit implementation " +
					apiAudit.getClass());
		}

		APIAuditModelImpl apiAuditModelImpl = (APIAuditModelImpl)apiAudit;

		if (isNew && (apiAudit.getCreateDate() == null)) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				apiAudit.setCreateDate(date);
			}
			else {
				apiAudit.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(apiAudit);
			}
			else {
				apiAudit = (APIAudit)session.merge(apiAudit);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(APIAuditImpl.class, apiAudit, false, true);

		if (isNew) {
			apiAudit.setNew(false);
		}

		apiAudit.resetOriginalValues();

		return apiAudit;
	}

	/**
	 * Returns the api audit with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the api audit
	 * @return the api audit
	 * @throws NoSuchAPIAuditException if a api audit with the primary key could not be found
	 */
	@Override
	public APIAudit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAPIAuditException {

		APIAudit apiAudit = fetchByPrimaryKey(primaryKey);

		if (apiAudit == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAPIAuditException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return apiAudit;
	}

	/**
	 * Returns the api audit with the primary key or throws a <code>NoSuchAPIAuditException</code> if it could not be found.
	 *
	 * @param apiAuditId the primary key of the api audit
	 * @return the api audit
	 * @throws NoSuchAPIAuditException if a api audit with the primary key could not be found
	 */
	@Override
	public APIAudit findByPrimaryKey(long apiAuditId)
		throws NoSuchAPIAuditException {

		return findByPrimaryKey((Serializable)apiAuditId);
	}

	/**
	 * Returns the api audit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param apiAuditId the primary key of the api audit
	 * @return the api audit, or <code>null</code> if a api audit with the primary key could not be found
	 */
	@Override
	public APIAudit fetchByPrimaryKey(long apiAuditId) {
		return fetchByPrimaryKey((Serializable)apiAuditId);
	}

	/**
	 * Returns all the api audits.
	 *
	 * @return the api audits
	 */
	@Override
	public List<APIAudit> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the api audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>APIAuditModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of api audits
	 * @param end the upper bound of the range of api audits (not inclusive)
	 * @return the range of api audits
	 */
	@Override
	public List<APIAudit> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the api audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>APIAuditModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of api audits
	 * @param end the upper bound of the range of api audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of api audits
	 */
	@Override
	public List<APIAudit> findAll(
		int start, int end, OrderByComparator<APIAudit> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the api audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>APIAuditModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of api audits
	 * @param end the upper bound of the range of api audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of api audits
	 */
	@Override
	public List<APIAudit> findAll(
		int start, int end, OrderByComparator<APIAudit> orderByComparator,
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

		List<APIAudit> list = null;

		if (useFinderCache) {
			list = (List<APIAudit>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_APIAUDIT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_APIAUDIT;

				sql = sql.concat(APIAuditModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<APIAudit>)QueryUtil.list(
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
	 * Removes all the api audits from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (APIAudit apiAudit : findAll()) {
			remove(apiAudit);
		}
	}

	/**
	 * Returns the number of api audits.
	 *
	 * @return the number of api audits
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_APIAUDIT);

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
		return "apiAuditId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_APIAUDIT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return APIAuditModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the api audit persistence.
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

		_setAPIAuditUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAPIAuditUtilPersistence(null);

		entityCache.removeCache(APIAuditImpl.class.getName());
	}

	private void _setAPIAuditUtilPersistence(
		APIAuditPersistence apiAuditPersistence) {

		try {
			Field field = APIAuditUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, apiAuditPersistence);
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

	private static final String _SQL_SELECT_APIAUDIT =
		"SELECT apiAudit FROM APIAudit apiAudit";

	private static final String _SQL_COUNT_APIAUDIT =
		"SELECT COUNT(apiAudit) FROM APIAudit apiAudit";

	private static final String _ORDER_BY_ENTITY_ALIAS = "apiAudit.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No APIAudit exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		APIAuditPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private APIAuditModelArgumentsResolver _apiAuditModelArgumentsResolver;

}