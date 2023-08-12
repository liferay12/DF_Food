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

import bd.gov.dgfood.movement.contractor.exception.NoSuchVInvoiceException;
import bd.gov.dgfood.movement.contractor.model.VInvoice;
import bd.gov.dgfood.movement.contractor.model.VInvoiceTable;
import bd.gov.dgfood.movement.contractor.model.impl.VInvoiceImpl;
import bd.gov.dgfood.movement.contractor.model.impl.VInvoiceModelImpl;
import bd.gov.dgfood.movement.contractor.service.persistence.VInvoicePersistence;
import bd.gov.dgfood.movement.contractor.service.persistence.VInvoiceUtil;
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
 * The persistence implementation for the v invoice service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {VInvoicePersistence.class, BasePersistence.class})
public class VInvoicePersistenceImpl
	extends BasePersistenceImpl<VInvoice> implements VInvoicePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>VInvoiceUtil</code> to access the v invoice persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		VInvoiceImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public VInvoicePersistenceImpl() {
		setModelClass(VInvoice.class);

		setModelImplClass(VInvoiceImpl.class);
		setModelPKClass(long.class);

		setTable(VInvoiceTable.INSTANCE);
	}

	/**
	 * Caches the v invoice in the entity cache if it is enabled.
	 *
	 * @param vInvoice the v invoice
	 */
	@Override
	public void cacheResult(VInvoice vInvoice) {
		entityCache.putResult(
			VInvoiceImpl.class, vInvoice.getPrimaryKey(), vInvoice);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the v invoices in the entity cache if it is enabled.
	 *
	 * @param vInvoices the v invoices
	 */
	@Override
	public void cacheResult(List<VInvoice> vInvoices) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (vInvoices.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (VInvoice vInvoice : vInvoices) {
			if (entityCache.getResult(
					VInvoiceImpl.class, vInvoice.getPrimaryKey()) == null) {

				cacheResult(vInvoice);
			}
		}
	}

	/**
	 * Clears the cache for all v invoices.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(VInvoiceImpl.class);

		finderCache.clearCache(VInvoiceImpl.class);
	}

	/**
	 * Clears the cache for the v invoice.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VInvoice vInvoice) {
		entityCache.removeResult(VInvoiceImpl.class, vInvoice);
	}

	@Override
	public void clearCache(List<VInvoice> vInvoices) {
		for (VInvoice vInvoice : vInvoices) {
			entityCache.removeResult(VInvoiceImpl.class, vInvoice);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(VInvoiceImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(VInvoiceImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new v invoice with the primary key. Does not add the v invoice to the database.
	 *
	 * @param vInvoiceId the primary key for the new v invoice
	 * @return the new v invoice
	 */
	@Override
	public VInvoice create(long vInvoiceId) {
		VInvoice vInvoice = new VInvoiceImpl();

		vInvoice.setNew(true);
		vInvoice.setPrimaryKey(vInvoiceId);

		return vInvoice;
	}

	/**
	 * Removes the v invoice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vInvoiceId the primary key of the v invoice
	 * @return the v invoice that was removed
	 * @throws NoSuchVInvoiceException if a v invoice with the primary key could not be found
	 */
	@Override
	public VInvoice remove(long vInvoiceId) throws NoSuchVInvoiceException {
		return remove((Serializable)vInvoiceId);
	}

	/**
	 * Removes the v invoice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the v invoice
	 * @return the v invoice that was removed
	 * @throws NoSuchVInvoiceException if a v invoice with the primary key could not be found
	 */
	@Override
	public VInvoice remove(Serializable primaryKey)
		throws NoSuchVInvoiceException {

		Session session = null;

		try {
			session = openSession();

			VInvoice vInvoice = (VInvoice)session.get(
				VInvoiceImpl.class, primaryKey);

			if (vInvoice == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVInvoiceException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(vInvoice);
		}
		catch (NoSuchVInvoiceException noSuchEntityException) {
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
	protected VInvoice removeImpl(VInvoice vInvoice) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vInvoice)) {
				vInvoice = (VInvoice)session.get(
					VInvoiceImpl.class, vInvoice.getPrimaryKeyObj());
			}

			if (vInvoice != null) {
				session.delete(vInvoice);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (vInvoice != null) {
			clearCache(vInvoice);
		}

		return vInvoice;
	}

	@Override
	public VInvoice updateImpl(VInvoice vInvoice) {
		boolean isNew = vInvoice.isNew();

		if (!(vInvoice instanceof VInvoiceModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(vInvoice.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(vInvoice);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in vInvoice proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom VInvoice implementation " +
					vInvoice.getClass());
		}

		VInvoiceModelImpl vInvoiceModelImpl = (VInvoiceModelImpl)vInvoice;

		if (isNew && (vInvoice.getCreateDate() == null)) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				vInvoice.setCreateDate(date);
			}
			else {
				vInvoice.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(vInvoice);
			}
			else {
				vInvoice = (VInvoice)session.merge(vInvoice);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(VInvoiceImpl.class, vInvoice, false, true);

		if (isNew) {
			vInvoice.setNew(false);
		}

		vInvoice.resetOriginalValues();

		return vInvoice;
	}

	/**
	 * Returns the v invoice with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the v invoice
	 * @return the v invoice
	 * @throws NoSuchVInvoiceException if a v invoice with the primary key could not be found
	 */
	@Override
	public VInvoice findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVInvoiceException {

		VInvoice vInvoice = fetchByPrimaryKey(primaryKey);

		if (vInvoice == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVInvoiceException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return vInvoice;
	}

	/**
	 * Returns the v invoice with the primary key or throws a <code>NoSuchVInvoiceException</code> if it could not be found.
	 *
	 * @param vInvoiceId the primary key of the v invoice
	 * @return the v invoice
	 * @throws NoSuchVInvoiceException if a v invoice with the primary key could not be found
	 */
	@Override
	public VInvoice findByPrimaryKey(long vInvoiceId)
		throws NoSuchVInvoiceException {

		return findByPrimaryKey((Serializable)vInvoiceId);
	}

	/**
	 * Returns the v invoice with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param vInvoiceId the primary key of the v invoice
	 * @return the v invoice, or <code>null</code> if a v invoice with the primary key could not be found
	 */
	@Override
	public VInvoice fetchByPrimaryKey(long vInvoiceId) {
		return fetchByPrimaryKey((Serializable)vInvoiceId);
	}

	/**
	 * Returns all the v invoices.
	 *
	 * @return the v invoices
	 */
	@Override
	public List<VInvoice> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v invoices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of v invoices
	 * @param end the upper bound of the range of v invoices (not inclusive)
	 * @return the range of v invoices
	 */
	@Override
	public List<VInvoice> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the v invoices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of v invoices
	 * @param end the upper bound of the range of v invoices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of v invoices
	 */
	@Override
	public List<VInvoice> findAll(
		int start, int end, OrderByComparator<VInvoice> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the v invoices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of v invoices
	 * @param end the upper bound of the range of v invoices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of v invoices
	 */
	@Override
	public List<VInvoice> findAll(
		int start, int end, OrderByComparator<VInvoice> orderByComparator,
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

		List<VInvoice> list = null;

		if (useFinderCache) {
			list = (List<VInvoice>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_VINVOICE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_VINVOICE;

				sql = sql.concat(VInvoiceModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<VInvoice>)QueryUtil.list(
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
	 * Removes all the v invoices from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (VInvoice vInvoice : findAll()) {
			remove(vInvoice);
		}
	}

	/**
	 * Returns the number of v invoices.
	 *
	 * @return the number of v invoices
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_VINVOICE);

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
		return "vInvoiceId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_VINVOICE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return VInvoiceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the v invoice persistence.
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

		_setVInvoiceUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setVInvoiceUtilPersistence(null);

		entityCache.removeCache(VInvoiceImpl.class.getName());
	}

	private void _setVInvoiceUtilPersistence(
		VInvoicePersistence vInvoicePersistence) {

		try {
			Field field = VInvoiceUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, vInvoicePersistence);
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

	private static final String _SQL_SELECT_VINVOICE =
		"SELECT vInvoice FROM VInvoice vInvoice";

	private static final String _SQL_COUNT_VINVOICE =
		"SELECT COUNT(vInvoice) FROM VInvoice vInvoice";

	private static final String _ORDER_BY_ENTITY_ALIAS = "vInvoice.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No VInvoice exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		VInvoicePersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private VInvoiceModelArgumentsResolver _vInvoiceModelArgumentsResolver;

}