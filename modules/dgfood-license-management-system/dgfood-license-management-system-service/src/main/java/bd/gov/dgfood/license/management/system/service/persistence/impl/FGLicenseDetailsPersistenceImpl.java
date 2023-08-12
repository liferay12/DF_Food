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

import bd.gov.dgfood.license.management.system.exception.NoSuchFGLicenseDetailsException;
import bd.gov.dgfood.license.management.system.model.FGLicenseDetails;
import bd.gov.dgfood.license.management.system.model.FGLicenseDetailsTable;
import bd.gov.dgfood.license.management.system.model.impl.FGLicenseDetailsImpl;
import bd.gov.dgfood.license.management.system.model.impl.FGLicenseDetailsModelImpl;
import bd.gov.dgfood.license.management.system.service.persistence.FGLicenseDetailsPersistence;
import bd.gov.dgfood.license.management.system.service.persistence.FGLicenseDetailsUtil;
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
 * The persistence implementation for the fg license details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {FGLicenseDetailsPersistence.class, BasePersistence.class})
public class FGLicenseDetailsPersistenceImpl
	extends BasePersistenceImpl<FGLicenseDetails>
	implements FGLicenseDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FGLicenseDetailsUtil</code> to access the fg license details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FGLicenseDetailsImpl.class.getName();

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
	 * Returns all the fg license detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching fg license detailses
	 */
	@Override
	public List<FGLicenseDetails> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fg license detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fg license detailses
	 * @param end the upper bound of the range of fg license detailses (not inclusive)
	 * @return the range of matching fg license detailses
	 */
	@Override
	public List<FGLicenseDetails> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fg license detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fg license detailses
	 * @param end the upper bound of the range of fg license detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fg license detailses
	 */
	@Override
	public List<FGLicenseDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FGLicenseDetails> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the fg license detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fg license detailses
	 * @param end the upper bound of the range of fg license detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching fg license detailses
	 */
	@Override
	public List<FGLicenseDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FGLicenseDetails> orderByComparator,
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

		List<FGLicenseDetails> list = null;

		if (useFinderCache) {
			list = (List<FGLicenseDetails>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FGLicenseDetails fgLicenseDetails : list) {
					if (!uuid.equals(fgLicenseDetails.getUuid())) {
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

			sb.append(_SQL_SELECT_FGLICENSEDETAILS_WHERE);

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
				sb.append(FGLicenseDetailsModelImpl.ORDER_BY_JPQL);
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

				list = (List<FGLicenseDetails>)QueryUtil.list(
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
	 * Returns the first fg license details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fg license details
	 * @throws NoSuchFGLicenseDetailsException if a matching fg license details could not be found
	 */
	@Override
	public FGLicenseDetails findByUuid_First(
			String uuid, OrderByComparator<FGLicenseDetails> orderByComparator)
		throws NoSuchFGLicenseDetailsException {

		FGLicenseDetails fgLicenseDetails = fetchByUuid_First(
			uuid, orderByComparator);

		if (fgLicenseDetails != null) {
			return fgLicenseDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFGLicenseDetailsException(sb.toString());
	}

	/**
	 * Returns the first fg license details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fg license details, or <code>null</code> if a matching fg license details could not be found
	 */
	@Override
	public FGLicenseDetails fetchByUuid_First(
		String uuid, OrderByComparator<FGLicenseDetails> orderByComparator) {

		List<FGLicenseDetails> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fg license details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fg license details
	 * @throws NoSuchFGLicenseDetailsException if a matching fg license details could not be found
	 */
	@Override
	public FGLicenseDetails findByUuid_Last(
			String uuid, OrderByComparator<FGLicenseDetails> orderByComparator)
		throws NoSuchFGLicenseDetailsException {

		FGLicenseDetails fgLicenseDetails = fetchByUuid_Last(
			uuid, orderByComparator);

		if (fgLicenseDetails != null) {
			return fgLicenseDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFGLicenseDetailsException(sb.toString());
	}

	/**
	 * Returns the last fg license details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fg license details, or <code>null</code> if a matching fg license details could not be found
	 */
	@Override
	public FGLicenseDetails fetchByUuid_Last(
		String uuid, OrderByComparator<FGLicenseDetails> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<FGLicenseDetails> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fg license detailses before and after the current fg license details in the ordered set where uuid = &#63;.
	 *
	 * @param fgLicenseMasterId the primary key of the current fg license details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fg license details
	 * @throws NoSuchFGLicenseDetailsException if a fg license details with the primary key could not be found
	 */
	@Override
	public FGLicenseDetails[] findByUuid_PrevAndNext(
			long fgLicenseMasterId, String uuid,
			OrderByComparator<FGLicenseDetails> orderByComparator)
		throws NoSuchFGLicenseDetailsException {

		uuid = Objects.toString(uuid, "");

		FGLicenseDetails fgLicenseDetails = findByPrimaryKey(fgLicenseMasterId);

		Session session = null;

		try {
			session = openSession();

			FGLicenseDetails[] array = new FGLicenseDetailsImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, fgLicenseDetails, uuid, orderByComparator, true);

			array[1] = fgLicenseDetails;

			array[2] = getByUuid_PrevAndNext(
				session, fgLicenseDetails, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FGLicenseDetails getByUuid_PrevAndNext(
		Session session, FGLicenseDetails fgLicenseDetails, String uuid,
		OrderByComparator<FGLicenseDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_FGLICENSEDETAILS_WHERE);

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
			sb.append(FGLicenseDetailsModelImpl.ORDER_BY_JPQL);
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
						fgLicenseDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FGLicenseDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fg license detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (FGLicenseDetails fgLicenseDetails :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(fgLicenseDetails);
		}
	}

	/**
	 * Returns the number of fg license detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching fg license detailses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FGLICENSEDETAILS_WHERE);

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
		"fgLicenseDetails.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(fgLicenseDetails.uuid IS NULL OR fgLicenseDetails.uuid = '')";

	public FGLicenseDetailsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(FGLicenseDetails.class);

		setModelImplClass(FGLicenseDetailsImpl.class);
		setModelPKClass(long.class);

		setTable(FGLicenseDetailsTable.INSTANCE);
	}

	/**
	 * Caches the fg license details in the entity cache if it is enabled.
	 *
	 * @param fgLicenseDetails the fg license details
	 */
	@Override
	public void cacheResult(FGLicenseDetails fgLicenseDetails) {
		entityCache.putResult(
			FGLicenseDetailsImpl.class, fgLicenseDetails.getPrimaryKey(),
			fgLicenseDetails);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the fg license detailses in the entity cache if it is enabled.
	 *
	 * @param fgLicenseDetailses the fg license detailses
	 */
	@Override
	public void cacheResult(List<FGLicenseDetails> fgLicenseDetailses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (fgLicenseDetailses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FGLicenseDetails fgLicenseDetails : fgLicenseDetailses) {
			if (entityCache.getResult(
					FGLicenseDetailsImpl.class,
					fgLicenseDetails.getPrimaryKey()) == null) {

				cacheResult(fgLicenseDetails);
			}
		}
	}

	/**
	 * Clears the cache for all fg license detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FGLicenseDetailsImpl.class);

		finderCache.clearCache(FGLicenseDetailsImpl.class);
	}

	/**
	 * Clears the cache for the fg license details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FGLicenseDetails fgLicenseDetails) {
		entityCache.removeResult(FGLicenseDetailsImpl.class, fgLicenseDetails);
	}

	@Override
	public void clearCache(List<FGLicenseDetails> fgLicenseDetailses) {
		for (FGLicenseDetails fgLicenseDetails : fgLicenseDetailses) {
			entityCache.removeResult(
				FGLicenseDetailsImpl.class, fgLicenseDetails);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FGLicenseDetailsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FGLicenseDetailsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new fg license details with the primary key. Does not add the fg license details to the database.
	 *
	 * @param fgLicenseMasterId the primary key for the new fg license details
	 * @return the new fg license details
	 */
	@Override
	public FGLicenseDetails create(long fgLicenseMasterId) {
		FGLicenseDetails fgLicenseDetails = new FGLicenseDetailsImpl();

		fgLicenseDetails.setNew(true);
		fgLicenseDetails.setPrimaryKey(fgLicenseMasterId);

		String uuid = _portalUUID.generate();

		fgLicenseDetails.setUuid(uuid);

		return fgLicenseDetails;
	}

	/**
	 * Removes the fg license details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fgLicenseMasterId the primary key of the fg license details
	 * @return the fg license details that was removed
	 * @throws NoSuchFGLicenseDetailsException if a fg license details with the primary key could not be found
	 */
	@Override
	public FGLicenseDetails remove(long fgLicenseMasterId)
		throws NoSuchFGLicenseDetailsException {

		return remove((Serializable)fgLicenseMasterId);
	}

	/**
	 * Removes the fg license details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fg license details
	 * @return the fg license details that was removed
	 * @throws NoSuchFGLicenseDetailsException if a fg license details with the primary key could not be found
	 */
	@Override
	public FGLicenseDetails remove(Serializable primaryKey)
		throws NoSuchFGLicenseDetailsException {

		Session session = null;

		try {
			session = openSession();

			FGLicenseDetails fgLicenseDetails = (FGLicenseDetails)session.get(
				FGLicenseDetailsImpl.class, primaryKey);

			if (fgLicenseDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFGLicenseDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(fgLicenseDetails);
		}
		catch (NoSuchFGLicenseDetailsException noSuchEntityException) {
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
	protected FGLicenseDetails removeImpl(FGLicenseDetails fgLicenseDetails) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(fgLicenseDetails)) {
				fgLicenseDetails = (FGLicenseDetails)session.get(
					FGLicenseDetailsImpl.class,
					fgLicenseDetails.getPrimaryKeyObj());
			}

			if (fgLicenseDetails != null) {
				session.delete(fgLicenseDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (fgLicenseDetails != null) {
			clearCache(fgLicenseDetails);
		}

		return fgLicenseDetails;
	}

	@Override
	public FGLicenseDetails updateImpl(FGLicenseDetails fgLicenseDetails) {
		boolean isNew = fgLicenseDetails.isNew();

		if (!(fgLicenseDetails instanceof FGLicenseDetailsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(fgLicenseDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					fgLicenseDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in fgLicenseDetails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FGLicenseDetails implementation " +
					fgLicenseDetails.getClass());
		}

		FGLicenseDetailsModelImpl fgLicenseDetailsModelImpl =
			(FGLicenseDetailsModelImpl)fgLicenseDetails;

		if (Validator.isNull(fgLicenseDetails.getUuid())) {
			String uuid = _portalUUID.generate();

			fgLicenseDetails.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(fgLicenseDetails);
			}
			else {
				fgLicenseDetails = (FGLicenseDetails)session.merge(
					fgLicenseDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FGLicenseDetailsImpl.class, fgLicenseDetailsModelImpl, false, true);

		if (isNew) {
			fgLicenseDetails.setNew(false);
		}

		fgLicenseDetails.resetOriginalValues();

		return fgLicenseDetails;
	}

	/**
	 * Returns the fg license details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fg license details
	 * @return the fg license details
	 * @throws NoSuchFGLicenseDetailsException if a fg license details with the primary key could not be found
	 */
	@Override
	public FGLicenseDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFGLicenseDetailsException {

		FGLicenseDetails fgLicenseDetails = fetchByPrimaryKey(primaryKey);

		if (fgLicenseDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFGLicenseDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return fgLicenseDetails;
	}

	/**
	 * Returns the fg license details with the primary key or throws a <code>NoSuchFGLicenseDetailsException</code> if it could not be found.
	 *
	 * @param fgLicenseMasterId the primary key of the fg license details
	 * @return the fg license details
	 * @throws NoSuchFGLicenseDetailsException if a fg license details with the primary key could not be found
	 */
	@Override
	public FGLicenseDetails findByPrimaryKey(long fgLicenseMasterId)
		throws NoSuchFGLicenseDetailsException {

		return findByPrimaryKey((Serializable)fgLicenseMasterId);
	}

	/**
	 * Returns the fg license details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fgLicenseMasterId the primary key of the fg license details
	 * @return the fg license details, or <code>null</code> if a fg license details with the primary key could not be found
	 */
	@Override
	public FGLicenseDetails fetchByPrimaryKey(long fgLicenseMasterId) {
		return fetchByPrimaryKey((Serializable)fgLicenseMasterId);
	}

	/**
	 * Returns all the fg license detailses.
	 *
	 * @return the fg license detailses
	 */
	@Override
	public List<FGLicenseDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fg license detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fg license detailses
	 * @param end the upper bound of the range of fg license detailses (not inclusive)
	 * @return the range of fg license detailses
	 */
	@Override
	public List<FGLicenseDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fg license detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fg license detailses
	 * @param end the upper bound of the range of fg license detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fg license detailses
	 */
	@Override
	public List<FGLicenseDetails> findAll(
		int start, int end,
		OrderByComparator<FGLicenseDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the fg license detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fg license detailses
	 * @param end the upper bound of the range of fg license detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of fg license detailses
	 */
	@Override
	public List<FGLicenseDetails> findAll(
		int start, int end,
		OrderByComparator<FGLicenseDetails> orderByComparator,
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

		List<FGLicenseDetails> list = null;

		if (useFinderCache) {
			list = (List<FGLicenseDetails>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FGLICENSEDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FGLICENSEDETAILS;

				sql = sql.concat(FGLicenseDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FGLicenseDetails>)QueryUtil.list(
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
	 * Removes all the fg license detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FGLicenseDetails fgLicenseDetails : findAll()) {
			remove(fgLicenseDetails);
		}
	}

	/**
	 * Returns the number of fg license detailses.
	 *
	 * @return the number of fg license detailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FGLICENSEDETAILS);

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
		return "fgLicenseMasterId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FGLICENSEDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FGLicenseDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the fg license details persistence.
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

		_setFGLicenseDetailsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setFGLicenseDetailsUtilPersistence(null);

		entityCache.removeCache(FGLicenseDetailsImpl.class.getName());
	}

	private void _setFGLicenseDetailsUtilPersistence(
		FGLicenseDetailsPersistence fgLicenseDetailsPersistence) {

		try {
			Field field = FGLicenseDetailsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, fgLicenseDetailsPersistence);
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

	private static final String _SQL_SELECT_FGLICENSEDETAILS =
		"SELECT fgLicenseDetails FROM FGLicenseDetails fgLicenseDetails";

	private static final String _SQL_SELECT_FGLICENSEDETAILS_WHERE =
		"SELECT fgLicenseDetails FROM FGLicenseDetails fgLicenseDetails WHERE ";

	private static final String _SQL_COUNT_FGLICENSEDETAILS =
		"SELECT COUNT(fgLicenseDetails) FROM FGLicenseDetails fgLicenseDetails";

	private static final String _SQL_COUNT_FGLICENSEDETAILS_WHERE =
		"SELECT COUNT(fgLicenseDetails) FROM FGLicenseDetails fgLicenseDetails WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "fgLicenseDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FGLicenseDetails exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FGLicenseDetails exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FGLicenseDetailsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private FGLicenseDetailsModelArgumentsResolver
		_fgLicenseDetailsModelArgumentsResolver;

}