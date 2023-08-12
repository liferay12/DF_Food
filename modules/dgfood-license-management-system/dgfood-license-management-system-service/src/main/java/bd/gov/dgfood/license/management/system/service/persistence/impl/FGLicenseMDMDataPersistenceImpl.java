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

package bd.gov.dgfood.license.management.system.service.persistence.impl;

import bd.gov.dgfood.license.management.system.exception.NoSuchFGLicenseMDMDataException;
import bd.gov.dgfood.license.management.system.model.FGLicenseMDMData;
import bd.gov.dgfood.license.management.system.model.FGLicenseMDMDataTable;
import bd.gov.dgfood.license.management.system.model.impl.FGLicenseMDMDataImpl;
import bd.gov.dgfood.license.management.system.model.impl.FGLicenseMDMDataModelImpl;
import bd.gov.dgfood.license.management.system.service.persistence.FGLicenseMDMDataPersistence;
import bd.gov.dgfood.license.management.system.service.persistence.FGLicenseMDMDataUtil;
import bd.gov.dgfood.license.management.system.service.persistence.impl.constants.PersistenceConstants;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the fg license mdm data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {FGLicenseMDMDataPersistence.class, BasePersistence.class})
public class FGLicenseMDMDataPersistenceImpl
	extends BasePersistenceImpl<FGLicenseMDMData>
	implements FGLicenseMDMDataPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FGLicenseMDMDataUtil</code> to access the fg license mdm data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FGLicenseMDMDataImpl.class.getName();

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
	 * Returns all the fg license mdm datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching fg license mdm datas
	 */
	@Override
	public List<FGLicenseMDMData> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fg license mdm datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseMDMDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fg license mdm datas
	 * @param end the upper bound of the range of fg license mdm datas (not inclusive)
	 * @return the range of matching fg license mdm datas
	 */
	@Override
	public List<FGLicenseMDMData> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fg license mdm datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseMDMDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fg license mdm datas
	 * @param end the upper bound of the range of fg license mdm datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fg license mdm datas
	 */
	@Override
	public List<FGLicenseMDMData> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FGLicenseMDMData> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the fg license mdm datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseMDMDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fg license mdm datas
	 * @param end the upper bound of the range of fg license mdm datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching fg license mdm datas
	 */
	@Override
	public List<FGLicenseMDMData> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FGLicenseMDMData> orderByComparator,
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

		List<FGLicenseMDMData> list = null;

		if (useFinderCache) {
			list = (List<FGLicenseMDMData>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FGLicenseMDMData fgLicenseMDMData : list) {
					if (!uuid.equals(fgLicenseMDMData.getUuid())) {
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

			sb.append(_SQL_SELECT_FGLICENSEMDMDATA_WHERE);

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
				sb.append(FGLicenseMDMDataModelImpl.ORDER_BY_JPQL);
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

				list = (List<FGLicenseMDMData>)QueryUtil.list(
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
	 * Returns the first fg license mdm data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fg license mdm data
	 * @throws NoSuchFGLicenseMDMDataException if a matching fg license mdm data could not be found
	 */
	@Override
	public FGLicenseMDMData findByUuid_First(
			String uuid, OrderByComparator<FGLicenseMDMData> orderByComparator)
		throws NoSuchFGLicenseMDMDataException {

		FGLicenseMDMData fgLicenseMDMData = fetchByUuid_First(
			uuid, orderByComparator);

		if (fgLicenseMDMData != null) {
			return fgLicenseMDMData;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFGLicenseMDMDataException(sb.toString());
	}

	/**
	 * Returns the first fg license mdm data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fg license mdm data, or <code>null</code> if a matching fg license mdm data could not be found
	 */
	@Override
	public FGLicenseMDMData fetchByUuid_First(
		String uuid, OrderByComparator<FGLicenseMDMData> orderByComparator) {

		List<FGLicenseMDMData> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fg license mdm data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fg license mdm data
	 * @throws NoSuchFGLicenseMDMDataException if a matching fg license mdm data could not be found
	 */
	@Override
	public FGLicenseMDMData findByUuid_Last(
			String uuid, OrderByComparator<FGLicenseMDMData> orderByComparator)
		throws NoSuchFGLicenseMDMDataException {

		FGLicenseMDMData fgLicenseMDMData = fetchByUuid_Last(
			uuid, orderByComparator);

		if (fgLicenseMDMData != null) {
			return fgLicenseMDMData;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFGLicenseMDMDataException(sb.toString());
	}

	/**
	 * Returns the last fg license mdm data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fg license mdm data, or <code>null</code> if a matching fg license mdm data could not be found
	 */
	@Override
	public FGLicenseMDMData fetchByUuid_Last(
		String uuid, OrderByComparator<FGLicenseMDMData> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<FGLicenseMDMData> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fg license mdm datas before and after the current fg license mdm data in the ordered set where uuid = &#63;.
	 *
	 * @param fgLicenseMDMId the primary key of the current fg license mdm data
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fg license mdm data
	 * @throws NoSuchFGLicenseMDMDataException if a fg license mdm data with the primary key could not be found
	 */
	@Override
	public FGLicenseMDMData[] findByUuid_PrevAndNext(
			long fgLicenseMDMId, String uuid,
			OrderByComparator<FGLicenseMDMData> orderByComparator)
		throws NoSuchFGLicenseMDMDataException {

		uuid = Objects.toString(uuid, "");

		FGLicenseMDMData fgLicenseMDMData = findByPrimaryKey(fgLicenseMDMId);

		Session session = null;

		try {
			session = openSession();

			FGLicenseMDMData[] array = new FGLicenseMDMDataImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, fgLicenseMDMData, uuid, orderByComparator, true);

			array[1] = fgLicenseMDMData;

			array[2] = getByUuid_PrevAndNext(
				session, fgLicenseMDMData, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FGLicenseMDMData getByUuid_PrevAndNext(
		Session session, FGLicenseMDMData fgLicenseMDMData, String uuid,
		OrderByComparator<FGLicenseMDMData> orderByComparator,
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

		sb.append(_SQL_SELECT_FGLICENSEMDMDATA_WHERE);

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
			sb.append(FGLicenseMDMDataModelImpl.ORDER_BY_JPQL);
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
						fgLicenseMDMData)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FGLicenseMDMData> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fg license mdm datas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (FGLicenseMDMData fgLicenseMDMData :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(fgLicenseMDMData);
		}
	}

	/**
	 * Returns the number of fg license mdm datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching fg license mdm datas
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FGLICENSEMDMDATA_WHERE);

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
		"fgLicenseMDMData.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(fgLicenseMDMData.uuid IS NULL OR fgLicenseMDMData.uuid = '')";

	public FGLicenseMDMDataPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(FGLicenseMDMData.class);

		setModelImplClass(FGLicenseMDMDataImpl.class);
		setModelPKClass(long.class);

		setTable(FGLicenseMDMDataTable.INSTANCE);
	}

	/**
	 * Caches the fg license mdm data in the entity cache if it is enabled.
	 *
	 * @param fgLicenseMDMData the fg license mdm data
	 */
	@Override
	public void cacheResult(FGLicenseMDMData fgLicenseMDMData) {
		entityCache.putResult(
			FGLicenseMDMDataImpl.class, fgLicenseMDMData.getPrimaryKey(),
			fgLicenseMDMData);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the fg license mdm datas in the entity cache if it is enabled.
	 *
	 * @param fgLicenseMDMDatas the fg license mdm datas
	 */
	@Override
	public void cacheResult(List<FGLicenseMDMData> fgLicenseMDMDatas) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (fgLicenseMDMDatas.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FGLicenseMDMData fgLicenseMDMData : fgLicenseMDMDatas) {
			if (entityCache.getResult(
					FGLicenseMDMDataImpl.class,
					fgLicenseMDMData.getPrimaryKey()) == null) {

				cacheResult(fgLicenseMDMData);
			}
		}
	}

	/**
	 * Clears the cache for all fg license mdm datas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FGLicenseMDMDataImpl.class);

		finderCache.clearCache(FGLicenseMDMDataImpl.class);
	}

	/**
	 * Clears the cache for the fg license mdm data.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FGLicenseMDMData fgLicenseMDMData) {
		entityCache.removeResult(FGLicenseMDMDataImpl.class, fgLicenseMDMData);
	}

	@Override
	public void clearCache(List<FGLicenseMDMData> fgLicenseMDMDatas) {
		for (FGLicenseMDMData fgLicenseMDMData : fgLicenseMDMDatas) {
			entityCache.removeResult(
				FGLicenseMDMDataImpl.class, fgLicenseMDMData);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FGLicenseMDMDataImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FGLicenseMDMDataImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new fg license mdm data with the primary key. Does not add the fg license mdm data to the database.
	 *
	 * @param fgLicenseMDMId the primary key for the new fg license mdm data
	 * @return the new fg license mdm data
	 */
	@Override
	public FGLicenseMDMData create(long fgLicenseMDMId) {
		FGLicenseMDMData fgLicenseMDMData = new FGLicenseMDMDataImpl();

		fgLicenseMDMData.setNew(true);
		fgLicenseMDMData.setPrimaryKey(fgLicenseMDMId);

		String uuid = _portalUUID.generate();

		fgLicenseMDMData.setUuid(uuid);

		return fgLicenseMDMData;
	}

	/**
	 * Removes the fg license mdm data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fgLicenseMDMId the primary key of the fg license mdm data
	 * @return the fg license mdm data that was removed
	 * @throws NoSuchFGLicenseMDMDataException if a fg license mdm data with the primary key could not be found
	 */
	@Override
	public FGLicenseMDMData remove(long fgLicenseMDMId)
		throws NoSuchFGLicenseMDMDataException {

		return remove((Serializable)fgLicenseMDMId);
	}

	/**
	 * Removes the fg license mdm data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fg license mdm data
	 * @return the fg license mdm data that was removed
	 * @throws NoSuchFGLicenseMDMDataException if a fg license mdm data with the primary key could not be found
	 */
	@Override
	public FGLicenseMDMData remove(Serializable primaryKey)
		throws NoSuchFGLicenseMDMDataException {

		Session session = null;

		try {
			session = openSession();

			FGLicenseMDMData fgLicenseMDMData = (FGLicenseMDMData)session.get(
				FGLicenseMDMDataImpl.class, primaryKey);

			if (fgLicenseMDMData == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFGLicenseMDMDataException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(fgLicenseMDMData);
		}
		catch (NoSuchFGLicenseMDMDataException noSuchEntityException) {
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
	protected FGLicenseMDMData removeImpl(FGLicenseMDMData fgLicenseMDMData) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(fgLicenseMDMData)) {
				fgLicenseMDMData = (FGLicenseMDMData)session.get(
					FGLicenseMDMDataImpl.class,
					fgLicenseMDMData.getPrimaryKeyObj());
			}

			if (fgLicenseMDMData != null) {
				session.delete(fgLicenseMDMData);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (fgLicenseMDMData != null) {
			clearCache(fgLicenseMDMData);
		}

		return fgLicenseMDMData;
	}

	@Override
	public FGLicenseMDMData updateImpl(FGLicenseMDMData fgLicenseMDMData) {
		boolean isNew = fgLicenseMDMData.isNew();

		if (!(fgLicenseMDMData instanceof FGLicenseMDMDataModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(fgLicenseMDMData.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					fgLicenseMDMData);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in fgLicenseMDMData proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FGLicenseMDMData implementation " +
					fgLicenseMDMData.getClass());
		}

		FGLicenseMDMDataModelImpl fgLicenseMDMDataModelImpl =
			(FGLicenseMDMDataModelImpl)fgLicenseMDMData;

		if (Validator.isNull(fgLicenseMDMData.getUuid())) {
			String uuid = _portalUUID.generate();

			fgLicenseMDMData.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(fgLicenseMDMData);
			}
			else {
				fgLicenseMDMData = (FGLicenseMDMData)session.merge(
					fgLicenseMDMData);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FGLicenseMDMDataImpl.class, fgLicenseMDMDataModelImpl, false, true);

		if (isNew) {
			fgLicenseMDMData.setNew(false);
		}

		fgLicenseMDMData.resetOriginalValues();

		return fgLicenseMDMData;
	}

	/**
	 * Returns the fg license mdm data with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fg license mdm data
	 * @return the fg license mdm data
	 * @throws NoSuchFGLicenseMDMDataException if a fg license mdm data with the primary key could not be found
	 */
	@Override
	public FGLicenseMDMData findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFGLicenseMDMDataException {

		FGLicenseMDMData fgLicenseMDMData = fetchByPrimaryKey(primaryKey);

		if (fgLicenseMDMData == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFGLicenseMDMDataException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return fgLicenseMDMData;
	}

	/**
	 * Returns the fg license mdm data with the primary key or throws a <code>NoSuchFGLicenseMDMDataException</code> if it could not be found.
	 *
	 * @param fgLicenseMDMId the primary key of the fg license mdm data
	 * @return the fg license mdm data
	 * @throws NoSuchFGLicenseMDMDataException if a fg license mdm data with the primary key could not be found
	 */
	@Override
	public FGLicenseMDMData findByPrimaryKey(long fgLicenseMDMId)
		throws NoSuchFGLicenseMDMDataException {

		return findByPrimaryKey((Serializable)fgLicenseMDMId);
	}

	/**
	 * Returns the fg license mdm data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fgLicenseMDMId the primary key of the fg license mdm data
	 * @return the fg license mdm data, or <code>null</code> if a fg license mdm data with the primary key could not be found
	 */
	@Override
	public FGLicenseMDMData fetchByPrimaryKey(long fgLicenseMDMId) {
		return fetchByPrimaryKey((Serializable)fgLicenseMDMId);
	}

	/**
	 * Returns all the fg license mdm datas.
	 *
	 * @return the fg license mdm datas
	 */
	@Override
	public List<FGLicenseMDMData> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fg license mdm datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseMDMDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fg license mdm datas
	 * @param end the upper bound of the range of fg license mdm datas (not inclusive)
	 * @return the range of fg license mdm datas
	 */
	@Override
	public List<FGLicenseMDMData> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fg license mdm datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseMDMDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fg license mdm datas
	 * @param end the upper bound of the range of fg license mdm datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fg license mdm datas
	 */
	@Override
	public List<FGLicenseMDMData> findAll(
		int start, int end,
		OrderByComparator<FGLicenseMDMData> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the fg license mdm datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseMDMDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fg license mdm datas
	 * @param end the upper bound of the range of fg license mdm datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of fg license mdm datas
	 */
	@Override
	public List<FGLicenseMDMData> findAll(
		int start, int end,
		OrderByComparator<FGLicenseMDMData> orderByComparator,
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

		List<FGLicenseMDMData> list = null;

		if (useFinderCache) {
			list = (List<FGLicenseMDMData>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FGLICENSEMDMDATA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FGLICENSEMDMDATA;

				sql = sql.concat(FGLicenseMDMDataModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FGLicenseMDMData>)QueryUtil.list(
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
	 * Removes all the fg license mdm datas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FGLicenseMDMData fgLicenseMDMData : findAll()) {
			remove(fgLicenseMDMData);
		}
	}

	/**
	 * Returns the number of fg license mdm datas.
	 *
	 * @return the number of fg license mdm datas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FGLICENSEMDMDATA);

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
		return "fgLicenseMDMId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FGLICENSEMDMDATA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FGLicenseMDMDataModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the fg license mdm data persistence.
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

		_setFGLicenseMDMDataUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setFGLicenseMDMDataUtilPersistence(null);

		entityCache.removeCache(FGLicenseMDMDataImpl.class.getName());
	}

	private void _setFGLicenseMDMDataUtilPersistence(
		FGLicenseMDMDataPersistence fgLicenseMDMDataPersistence) {

		try {
			Field field = FGLicenseMDMDataUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, fgLicenseMDMDataPersistence);
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

	private static final String _SQL_SELECT_FGLICENSEMDMDATA =
		"SELECT fgLicenseMDMData FROM FGLicenseMDMData fgLicenseMDMData";

	private static final String _SQL_SELECT_FGLICENSEMDMDATA_WHERE =
		"SELECT fgLicenseMDMData FROM FGLicenseMDMData fgLicenseMDMData WHERE ";

	private static final String _SQL_COUNT_FGLICENSEMDMDATA =
		"SELECT COUNT(fgLicenseMDMData) FROM FGLicenseMDMData fgLicenseMDMData";

	private static final String _SQL_COUNT_FGLICENSEMDMDATA_WHERE =
		"SELECT COUNT(fgLicenseMDMData) FROM FGLicenseMDMData fgLicenseMDMData WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "fgLicenseMDMData.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FGLicenseMDMData exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FGLicenseMDMData exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FGLicenseMDMDataPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private FGLicenseMDMDataModelArgumentsResolver
		_fgLicenseMDMDataModelArgumentsResolver;

}