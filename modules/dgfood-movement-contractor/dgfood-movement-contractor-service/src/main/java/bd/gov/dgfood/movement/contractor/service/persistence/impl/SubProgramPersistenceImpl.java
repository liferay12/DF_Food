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

package bd.gov.dgfood.movement.contractor.service.persistence.impl;

import bd.gov.dgfood.movement.contractor.exception.NoSuchSubProgramException;
import bd.gov.dgfood.movement.contractor.model.SubProgram;
import bd.gov.dgfood.movement.contractor.model.SubProgramTable;
import bd.gov.dgfood.movement.contractor.model.impl.SubProgramImpl;
import bd.gov.dgfood.movement.contractor.model.impl.SubProgramModelImpl;
import bd.gov.dgfood.movement.contractor.service.persistence.SubProgramPersistence;
import bd.gov.dgfood.movement.contractor.service.persistence.SubProgramUtil;
import bd.gov.dgfood.movement.contractor.service.persistence.impl.constants.DGFOODPersistenceConstants;

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
 * The persistence implementation for the sub program service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {SubProgramPersistence.class, BasePersistence.class})
public class SubProgramPersistenceImpl
	extends BasePersistenceImpl<SubProgram> implements SubProgramPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SubProgramUtil</code> to access the sub program persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SubProgramImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public SubProgramPersistenceImpl() {
		setModelClass(SubProgram.class);

		setModelImplClass(SubProgramImpl.class);
		setModelPKClass(long.class);

		setTable(SubProgramTable.INSTANCE);
	}

	/**
	 * Caches the sub program in the entity cache if it is enabled.
	 *
	 * @param subProgram the sub program
	 */
	@Override
	public void cacheResult(SubProgram subProgram) {
		entityCache.putResult(
			SubProgramImpl.class, subProgram.getPrimaryKey(), subProgram);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the sub programs in the entity cache if it is enabled.
	 *
	 * @param subPrograms the sub programs
	 */
	@Override
	public void cacheResult(List<SubProgram> subPrograms) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (subPrograms.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SubProgram subProgram : subPrograms) {
			if (entityCache.getResult(
					SubProgramImpl.class, subProgram.getPrimaryKey()) == null) {

				cacheResult(subProgram);
			}
		}
	}

	/**
	 * Clears the cache for all sub programs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SubProgramImpl.class);

		finderCache.clearCache(SubProgramImpl.class);
	}

	/**
	 * Clears the cache for the sub program.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SubProgram subProgram) {
		entityCache.removeResult(SubProgramImpl.class, subProgram);
	}

	@Override
	public void clearCache(List<SubProgram> subPrograms) {
		for (SubProgram subProgram : subPrograms) {
			entityCache.removeResult(SubProgramImpl.class, subProgram);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SubProgramImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SubProgramImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new sub program with the primary key. Does not add the sub program to the database.
	 *
	 * @param subProgramId the primary key for the new sub program
	 * @return the new sub program
	 */
	@Override
	public SubProgram create(long subProgramId) {
		SubProgram subProgram = new SubProgramImpl();

		subProgram.setNew(true);
		subProgram.setPrimaryKey(subProgramId);

		return subProgram;
	}

	/**
	 * Removes the sub program with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subProgramId the primary key of the sub program
	 * @return the sub program that was removed
	 * @throws NoSuchSubProgramException if a sub program with the primary key could not be found
	 */
	@Override
	public SubProgram remove(long subProgramId)
		throws NoSuchSubProgramException {

		return remove((Serializable)subProgramId);
	}

	/**
	 * Removes the sub program with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sub program
	 * @return the sub program that was removed
	 * @throws NoSuchSubProgramException if a sub program with the primary key could not be found
	 */
	@Override
	public SubProgram remove(Serializable primaryKey)
		throws NoSuchSubProgramException {

		Session session = null;

		try {
			session = openSession();

			SubProgram subProgram = (SubProgram)session.get(
				SubProgramImpl.class, primaryKey);

			if (subProgram == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSubProgramException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(subProgram);
		}
		catch (NoSuchSubProgramException noSuchEntityException) {
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
	protected SubProgram removeImpl(SubProgram subProgram) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(subProgram)) {
				subProgram = (SubProgram)session.get(
					SubProgramImpl.class, subProgram.getPrimaryKeyObj());
			}

			if (subProgram != null) {
				session.delete(subProgram);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (subProgram != null) {
			clearCache(subProgram);
		}

		return subProgram;
	}

	@Override
	public SubProgram updateImpl(SubProgram subProgram) {
		boolean isNew = subProgram.isNew();

		if (!(subProgram instanceof SubProgramModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(subProgram.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(subProgram);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in subProgram proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SubProgram implementation " +
					subProgram.getClass());
		}

		SubProgramModelImpl subProgramModelImpl =
			(SubProgramModelImpl)subProgram;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (subProgram.getCreateDate() == null)) {
			if (serviceContext == null) {
				subProgram.setCreateDate(date);
			}
			else {
				subProgram.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!subProgramModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				subProgram.setModifiedDate(date);
			}
			else {
				subProgram.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(subProgram);
			}
			else {
				subProgram = (SubProgram)session.merge(subProgram);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(SubProgramImpl.class, subProgram, false, true);

		if (isNew) {
			subProgram.setNew(false);
		}

		subProgram.resetOriginalValues();

		return subProgram;
	}

	/**
	 * Returns the sub program with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sub program
	 * @return the sub program
	 * @throws NoSuchSubProgramException if a sub program with the primary key could not be found
	 */
	@Override
	public SubProgram findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSubProgramException {

		SubProgram subProgram = fetchByPrimaryKey(primaryKey);

		if (subProgram == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSubProgramException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return subProgram;
	}

	/**
	 * Returns the sub program with the primary key or throws a <code>NoSuchSubProgramException</code> if it could not be found.
	 *
	 * @param subProgramId the primary key of the sub program
	 * @return the sub program
	 * @throws NoSuchSubProgramException if a sub program with the primary key could not be found
	 */
	@Override
	public SubProgram findByPrimaryKey(long subProgramId)
		throws NoSuchSubProgramException {

		return findByPrimaryKey((Serializable)subProgramId);
	}

	/**
	 * Returns the sub program with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param subProgramId the primary key of the sub program
	 * @return the sub program, or <code>null</code> if a sub program with the primary key could not be found
	 */
	@Override
	public SubProgram fetchByPrimaryKey(long subProgramId) {
		return fetchByPrimaryKey((Serializable)subProgramId);
	}

	/**
	 * Returns all the sub programs.
	 *
	 * @return the sub programs
	 */
	@Override
	public List<SubProgram> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sub programs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubProgramModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sub programs
	 * @param end the upper bound of the range of sub programs (not inclusive)
	 * @return the range of sub programs
	 */
	@Override
	public List<SubProgram> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sub programs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubProgramModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sub programs
	 * @param end the upper bound of the range of sub programs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sub programs
	 */
	@Override
	public List<SubProgram> findAll(
		int start, int end, OrderByComparator<SubProgram> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sub programs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubProgramModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sub programs
	 * @param end the upper bound of the range of sub programs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sub programs
	 */
	@Override
	public List<SubProgram> findAll(
		int start, int end, OrderByComparator<SubProgram> orderByComparator,
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

		List<SubProgram> list = null;

		if (useFinderCache) {
			list = (List<SubProgram>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SUBPROGRAM);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SUBPROGRAM;

				sql = sql.concat(SubProgramModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SubProgram>)QueryUtil.list(
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
	 * Removes all the sub programs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SubProgram subProgram : findAll()) {
			remove(subProgram);
		}
	}

	/**
	 * Returns the number of sub programs.
	 *
	 * @return the number of sub programs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SUBPROGRAM);

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
		return "subProgramId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SUBPROGRAM;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SubProgramModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sub program persistence.
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

		_setSubProgramUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSubProgramUtilPersistence(null);

		entityCache.removeCache(SubProgramImpl.class.getName());
	}

	private void _setSubProgramUtilPersistence(
		SubProgramPersistence subProgramPersistence) {

		try {
			Field field = SubProgramUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, subProgramPersistence);
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

	private static final String _SQL_SELECT_SUBPROGRAM =
		"SELECT subProgram FROM SubProgram subProgram";

	private static final String _SQL_COUNT_SUBPROGRAM =
		"SELECT COUNT(subProgram) FROM SubProgram subProgram";

	private static final String _ORDER_BY_ENTITY_ALIAS = "subProgram.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SubProgram exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		SubProgramPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private SubProgramModelArgumentsResolver _subProgramModelArgumentsResolver;

}