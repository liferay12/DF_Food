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

package bd.gov.dgfood.farmer.information.management.system.service.persistence.impl;

import bd.gov.dgfood.farmer.information.management.system.exception.NoSuchFarmerRegistrationVersionException;
import bd.gov.dgfood.farmer.information.management.system.model.FarmerRegistrationVersion;
import bd.gov.dgfood.farmer.information.management.system.model.FarmerRegistrationVersionTable;
import bd.gov.dgfood.farmer.information.management.system.model.impl.FarmerRegistrationVersionImpl;
import bd.gov.dgfood.farmer.information.management.system.model.impl.FarmerRegistrationVersionModelImpl;
import bd.gov.dgfood.farmer.information.management.system.service.persistence.FarmerRegistrationVersionPersistence;
import bd.gov.dgfood.farmer.information.management.system.service.persistence.FarmerRegistrationVersionUtil;
import bd.gov.dgfood.farmer.information.management.system.service.persistence.impl.constants.DGFOODPersistenceConstants;

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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
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
 * The persistence implementation for the farmer registration version service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {
		FarmerRegistrationVersionPersistence.class, BasePersistence.class
	}
)
public class FarmerRegistrationVersionPersistenceImpl
	extends BasePersistenceImpl<FarmerRegistrationVersion>
	implements FarmerRegistrationVersionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FarmerRegistrationVersionUtil</code> to access the farmer registration version persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FarmerRegistrationVersionImpl.class.getName();

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
	 * Returns all the farmer registration versions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching farmer registration versions
	 */
	@Override
	public List<FarmerRegistrationVersion> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the farmer registration versions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @return the range of matching farmer registration versions
	 */
	@Override
	public List<FarmerRegistrationVersion> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the farmer registration versions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching farmer registration versions
	 */
	@Override
	public List<FarmerRegistrationVersion> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the farmer registration versions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching farmer registration versions
	 */
	@Override
	public List<FarmerRegistrationVersion> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator,
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

		List<FarmerRegistrationVersion> list = null;

		if (useFinderCache) {
			list = (List<FarmerRegistrationVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FarmerRegistrationVersion farmerRegistrationVersion :
						list) {

					if (!uuid.equals(farmerRegistrationVersion.getUuid())) {
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

			sb.append(_SQL_SELECT_FARMERREGISTRATIONVERSION_WHERE);

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
				sb.append(FarmerRegistrationVersionModelImpl.ORDER_BY_JPQL);
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

				list = (List<FarmerRegistrationVersion>)QueryUtil.list(
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
	 * Returns the first farmer registration version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	@Override
	public FarmerRegistrationVersion findByUuid_First(
			String uuid,
			OrderByComparator<FarmerRegistrationVersion> orderByComparator)
		throws NoSuchFarmerRegistrationVersionException {

		FarmerRegistrationVersion farmerRegistrationVersion = fetchByUuid_First(
			uuid, orderByComparator);

		if (farmerRegistrationVersion != null) {
			return farmerRegistrationVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFarmerRegistrationVersionException(sb.toString());
	}

	/**
	 * Returns the first farmer registration version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	@Override
	public FarmerRegistrationVersion fetchByUuid_First(
		String uuid,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		List<FarmerRegistrationVersion> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last farmer registration version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	@Override
	public FarmerRegistrationVersion findByUuid_Last(
			String uuid,
			OrderByComparator<FarmerRegistrationVersion> orderByComparator)
		throws NoSuchFarmerRegistrationVersionException {

		FarmerRegistrationVersion farmerRegistrationVersion = fetchByUuid_Last(
			uuid, orderByComparator);

		if (farmerRegistrationVersion != null) {
			return farmerRegistrationVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFarmerRegistrationVersionException(sb.toString());
	}

	/**
	 * Returns the last farmer registration version in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	@Override
	public FarmerRegistrationVersion fetchByUuid_Last(
		String uuid,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<FarmerRegistrationVersion> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the farmer registration versions before and after the current farmer registration version in the ordered set where uuid = &#63;.
	 *
	 * @param farmerRegistrationVersionId the primary key of the current farmer registration version
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a farmer registration version with the primary key could not be found
	 */
	@Override
	public FarmerRegistrationVersion[] findByUuid_PrevAndNext(
			long farmerRegistrationVersionId, String uuid,
			OrderByComparator<FarmerRegistrationVersion> orderByComparator)
		throws NoSuchFarmerRegistrationVersionException {

		uuid = Objects.toString(uuid, "");

		FarmerRegistrationVersion farmerRegistrationVersion = findByPrimaryKey(
			farmerRegistrationVersionId);

		Session session = null;

		try {
			session = openSession();

			FarmerRegistrationVersion[] array =
				new FarmerRegistrationVersionImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, farmerRegistrationVersion, uuid, orderByComparator,
				true);

			array[1] = farmerRegistrationVersion;

			array[2] = getByUuid_PrevAndNext(
				session, farmerRegistrationVersion, uuid, orderByComparator,
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

	protected FarmerRegistrationVersion getByUuid_PrevAndNext(
		Session session, FarmerRegistrationVersion farmerRegistrationVersion,
		String uuid,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator,
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

		sb.append(_SQL_SELECT_FARMERREGISTRATIONVERSION_WHERE);

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
			sb.append(FarmerRegistrationVersionModelImpl.ORDER_BY_JPQL);
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
						farmerRegistrationVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FarmerRegistrationVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the farmer registration versions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (FarmerRegistrationVersion farmerRegistrationVersion :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(farmerRegistrationVersion);
		}
	}

	/**
	 * Returns the number of farmer registration versions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching farmer registration versions
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FARMERREGISTRATIONVERSION_WHERE);

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
		"farmerRegistrationVersion.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(farmerRegistrationVersion.uuid IS NULL OR farmerRegistrationVersion.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the farmer registration version where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFarmerRegistrationVersionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	@Override
	public FarmerRegistrationVersion findByUUID_G(String uuid, long groupId)
		throws NoSuchFarmerRegistrationVersionException {

		FarmerRegistrationVersion farmerRegistrationVersion = fetchByUUID_G(
			uuid, groupId);

		if (farmerRegistrationVersion == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFarmerRegistrationVersionException(sb.toString());
		}

		return farmerRegistrationVersion;
	}

	/**
	 * Returns the farmer registration version where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	@Override
	public FarmerRegistrationVersion fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the farmer registration version where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	@Override
	public FarmerRegistrationVersion fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs);
		}

		if (result instanceof FarmerRegistrationVersion) {
			FarmerRegistrationVersion farmerRegistrationVersion =
				(FarmerRegistrationVersion)result;

			if (!Objects.equals(uuid, farmerRegistrationVersion.getUuid()) ||
				(groupId != farmerRegistrationVersion.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_FARMERREGISTRATIONVERSION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<FarmerRegistrationVersion> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					FarmerRegistrationVersion farmerRegistrationVersion =
						list.get(0);

					result = farmerRegistrationVersion;

					cacheResult(farmerRegistrationVersion);
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
			return (FarmerRegistrationVersion)result;
		}
	}

	/**
	 * Removes the farmer registration version where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the farmer registration version that was removed
	 */
	@Override
	public FarmerRegistrationVersion removeByUUID_G(String uuid, long groupId)
		throws NoSuchFarmerRegistrationVersionException {

		FarmerRegistrationVersion farmerRegistrationVersion = findByUUID_G(
			uuid, groupId);

		return remove(farmerRegistrationVersion);
	}

	/**
	 * Returns the number of farmer registration versions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching farmer registration versions
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FARMERREGISTRATIONVERSION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"farmerRegistrationVersion.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(farmerRegistrationVersion.uuid IS NULL OR farmerRegistrationVersion.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"farmerRegistrationVersion.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the farmer registration versions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching farmer registration versions
	 */
	@Override
	public List<FarmerRegistrationVersion> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the farmer registration versions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @return the range of matching farmer registration versions
	 */
	@Override
	public List<FarmerRegistrationVersion> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the farmer registration versions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching farmer registration versions
	 */
	@Override
	public List<FarmerRegistrationVersion> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the farmer registration versions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching farmer registration versions
	 */
	@Override
	public List<FarmerRegistrationVersion> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<FarmerRegistrationVersion> list = null;

		if (useFinderCache) {
			list = (List<FarmerRegistrationVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FarmerRegistrationVersion farmerRegistrationVersion :
						list) {

					if (!uuid.equals(farmerRegistrationVersion.getUuid()) ||
						(companyId !=
							farmerRegistrationVersion.getCompanyId())) {

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

			sb.append(_SQL_SELECT_FARMERREGISTRATIONVERSION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FarmerRegistrationVersionModelImpl.ORDER_BY_JPQL);
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

				queryPos.add(companyId);

				list = (List<FarmerRegistrationVersion>)QueryUtil.list(
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
	 * Returns the first farmer registration version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	@Override
	public FarmerRegistrationVersion findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FarmerRegistrationVersion> orderByComparator)
		throws NoSuchFarmerRegistrationVersionException {

		FarmerRegistrationVersion farmerRegistrationVersion =
			fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (farmerRegistrationVersion != null) {
			return farmerRegistrationVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFarmerRegistrationVersionException(sb.toString());
	}

	/**
	 * Returns the first farmer registration version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	@Override
	public FarmerRegistrationVersion fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		List<FarmerRegistrationVersion> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last farmer registration version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	@Override
	public FarmerRegistrationVersion findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FarmerRegistrationVersion> orderByComparator)
		throws NoSuchFarmerRegistrationVersionException {

		FarmerRegistrationVersion farmerRegistrationVersion =
			fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (farmerRegistrationVersion != null) {
			return farmerRegistrationVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFarmerRegistrationVersionException(sb.toString());
	}

	/**
	 * Returns the last farmer registration version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	@Override
	public FarmerRegistrationVersion fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<FarmerRegistrationVersion> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the farmer registration versions before and after the current farmer registration version in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param farmerRegistrationVersionId the primary key of the current farmer registration version
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a farmer registration version with the primary key could not be found
	 */
	@Override
	public FarmerRegistrationVersion[] findByUuid_C_PrevAndNext(
			long farmerRegistrationVersionId, String uuid, long companyId,
			OrderByComparator<FarmerRegistrationVersion> orderByComparator)
		throws NoSuchFarmerRegistrationVersionException {

		uuid = Objects.toString(uuid, "");

		FarmerRegistrationVersion farmerRegistrationVersion = findByPrimaryKey(
			farmerRegistrationVersionId);

		Session session = null;

		try {
			session = openSession();

			FarmerRegistrationVersion[] array =
				new FarmerRegistrationVersionImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, farmerRegistrationVersion, uuid, companyId,
				orderByComparator, true);

			array[1] = farmerRegistrationVersion;

			array[2] = getByUuid_C_PrevAndNext(
				session, farmerRegistrationVersion, uuid, companyId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FarmerRegistrationVersion getByUuid_C_PrevAndNext(
		Session session, FarmerRegistrationVersion farmerRegistrationVersion,
		String uuid, long companyId,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator,
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

		sb.append(_SQL_SELECT_FARMERREGISTRATIONVERSION_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			sb.append(FarmerRegistrationVersionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						farmerRegistrationVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FarmerRegistrationVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the farmer registration versions where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (FarmerRegistrationVersion farmerRegistrationVersion :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(farmerRegistrationVersion);
		}
	}

	/**
	 * Returns the number of farmer registration versions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching farmer registration versions
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FARMERREGISTRATIONVERSION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"farmerRegistrationVersion.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(farmerRegistrationVersion.uuid IS NULL OR farmerRegistrationVersion.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"farmerRegistrationVersion.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByNationalId;
	private FinderPath _finderPathWithoutPaginationFindByNationalId;
	private FinderPath _finderPathCountByNationalId;

	/**
	 * Returns all the farmer registration versions where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching farmer registration versions
	 */
	@Override
	public List<FarmerRegistrationVersion> findByNationalId(String nationalId) {
		return findByNationalId(
			nationalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the farmer registration versions where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @return the range of matching farmer registration versions
	 */
	@Override
	public List<FarmerRegistrationVersion> findByNationalId(
		String nationalId, int start, int end) {

		return findByNationalId(nationalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the farmer registration versions where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching farmer registration versions
	 */
	@Override
	public List<FarmerRegistrationVersion> findByNationalId(
		String nationalId, int start, int end,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		return findByNationalId(
			nationalId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the farmer registration versions where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching farmer registration versions
	 */
	@Override
	public List<FarmerRegistrationVersion> findByNationalId(
		String nationalId, int start, int end,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator,
		boolean useFinderCache) {

		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByNationalId;
				finderArgs = new Object[] {nationalId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByNationalId;
			finderArgs = new Object[] {
				nationalId, start, end, orderByComparator
			};
		}

		List<FarmerRegistrationVersion> list = null;

		if (useFinderCache) {
			list = (List<FarmerRegistrationVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FarmerRegistrationVersion farmerRegistrationVersion :
						list) {

					if (!nationalId.equals(
							farmerRegistrationVersion.getNationalId())) {

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

			sb.append(_SQL_SELECT_FARMERREGISTRATIONVERSION_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_NATIONALID_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(_FINDER_COLUMN_NATIONALID_NATIONALID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FarmerRegistrationVersionModelImpl.ORDER_BY_JPQL);
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

				list = (List<FarmerRegistrationVersion>)QueryUtil.list(
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
	 * Returns the first farmer registration version in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	@Override
	public FarmerRegistrationVersion findByNationalId_First(
			String nationalId,
			OrderByComparator<FarmerRegistrationVersion> orderByComparator)
		throws NoSuchFarmerRegistrationVersionException {

		FarmerRegistrationVersion farmerRegistrationVersion =
			fetchByNationalId_First(nationalId, orderByComparator);

		if (farmerRegistrationVersion != null) {
			return farmerRegistrationVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationalId=");
		sb.append(nationalId);

		sb.append("}");

		throw new NoSuchFarmerRegistrationVersionException(sb.toString());
	}

	/**
	 * Returns the first farmer registration version in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	@Override
	public FarmerRegistrationVersion fetchByNationalId_First(
		String nationalId,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		List<FarmerRegistrationVersion> list = findByNationalId(
			nationalId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last farmer registration version in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	@Override
	public FarmerRegistrationVersion findByNationalId_Last(
			String nationalId,
			OrderByComparator<FarmerRegistrationVersion> orderByComparator)
		throws NoSuchFarmerRegistrationVersionException {

		FarmerRegistrationVersion farmerRegistrationVersion =
			fetchByNationalId_Last(nationalId, orderByComparator);

		if (farmerRegistrationVersion != null) {
			return farmerRegistrationVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationalId=");
		sb.append(nationalId);

		sb.append("}");

		throw new NoSuchFarmerRegistrationVersionException(sb.toString());
	}

	/**
	 * Returns the last farmer registration version in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	@Override
	public FarmerRegistrationVersion fetchByNationalId_Last(
		String nationalId,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		int count = countByNationalId(nationalId);

		if (count == 0) {
			return null;
		}

		List<FarmerRegistrationVersion> list = findByNationalId(
			nationalId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the farmer registration versions before and after the current farmer registration version in the ordered set where nationalId = &#63;.
	 *
	 * @param farmerRegistrationVersionId the primary key of the current farmer registration version
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a farmer registration version with the primary key could not be found
	 */
	@Override
	public FarmerRegistrationVersion[] findByNationalId_PrevAndNext(
			long farmerRegistrationVersionId, String nationalId,
			OrderByComparator<FarmerRegistrationVersion> orderByComparator)
		throws NoSuchFarmerRegistrationVersionException {

		nationalId = Objects.toString(nationalId, "");

		FarmerRegistrationVersion farmerRegistrationVersion = findByPrimaryKey(
			farmerRegistrationVersionId);

		Session session = null;

		try {
			session = openSession();

			FarmerRegistrationVersion[] array =
				new FarmerRegistrationVersionImpl[3];

			array[0] = getByNationalId_PrevAndNext(
				session, farmerRegistrationVersion, nationalId,
				orderByComparator, true);

			array[1] = farmerRegistrationVersion;

			array[2] = getByNationalId_PrevAndNext(
				session, farmerRegistrationVersion, nationalId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FarmerRegistrationVersion getByNationalId_PrevAndNext(
		Session session, FarmerRegistrationVersion farmerRegistrationVersion,
		String nationalId,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator,
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

		sb.append(_SQL_SELECT_FARMERREGISTRATIONVERSION_WHERE);

		boolean bindNationalId = false;

		if (nationalId.isEmpty()) {
			sb.append(_FINDER_COLUMN_NATIONALID_NATIONALID_3);
		}
		else {
			bindNationalId = true;

			sb.append(_FINDER_COLUMN_NATIONALID_NATIONALID_2);
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
			sb.append(FarmerRegistrationVersionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindNationalId) {
			queryPos.add(nationalId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						farmerRegistrationVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FarmerRegistrationVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the farmer registration versions where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	@Override
	public void removeByNationalId(String nationalId) {
		for (FarmerRegistrationVersion farmerRegistrationVersion :
				findByNationalId(
					nationalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(farmerRegistrationVersion);
		}
	}

	/**
	 * Returns the number of farmer registration versions where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching farmer registration versions
	 */
	@Override
	public int countByNationalId(String nationalId) {
		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = _finderPathCountByNationalId;

		Object[] finderArgs = new Object[] {nationalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FARMERREGISTRATIONVERSION_WHERE);

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
		"farmerRegistrationVersion.nationalId = ?";

	private static final String _FINDER_COLUMN_NATIONALID_NATIONALID_3 =
		"(farmerRegistrationVersion.nationalId IS NULL OR farmerRegistrationVersion.nationalId = '')";

	private FinderPath _finderPathWithPaginationFindByApplicationNumber;
	private FinderPath _finderPathWithoutPaginationFindByApplicationNumber;
	private FinderPath _finderPathCountByApplicationNumber;

	/**
	 * Returns all the farmer registration versions where applicationNumber = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @return the matching farmer registration versions
	 */
	@Override
	public List<FarmerRegistrationVersion> findByApplicationNumber(
		String applicationNumber) {

		return findByApplicationNumber(
			applicationNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the farmer registration versions where applicationNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param applicationNumber the application number
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @return the range of matching farmer registration versions
	 */
	@Override
	public List<FarmerRegistrationVersion> findByApplicationNumber(
		String applicationNumber, int start, int end) {

		return findByApplicationNumber(applicationNumber, start, end, null);
	}

	/**
	 * Returns an ordered range of all the farmer registration versions where applicationNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param applicationNumber the application number
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching farmer registration versions
	 */
	@Override
	public List<FarmerRegistrationVersion> findByApplicationNumber(
		String applicationNumber, int start, int end,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		return findByApplicationNumber(
			applicationNumber, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the farmer registration versions where applicationNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param applicationNumber the application number
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching farmer registration versions
	 */
	@Override
	public List<FarmerRegistrationVersion> findByApplicationNumber(
		String applicationNumber, int start, int end,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator,
		boolean useFinderCache) {

		applicationNumber = Objects.toString(applicationNumber, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByApplicationNumber;
				finderArgs = new Object[] {applicationNumber};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByApplicationNumber;
			finderArgs = new Object[] {
				applicationNumber, start, end, orderByComparator
			};
		}

		List<FarmerRegistrationVersion> list = null;

		if (useFinderCache) {
			list = (List<FarmerRegistrationVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FarmerRegistrationVersion farmerRegistrationVersion :
						list) {

					if (!applicationNumber.equals(
							farmerRegistrationVersion.getApplicationNumber())) {

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

			sb.append(_SQL_SELECT_FARMERREGISTRATIONVERSION_WHERE);

			boolean bindApplicationNumber = false;

			if (applicationNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPLICATIONNUMBER_APPLICATIONNUMBER_3);
			}
			else {
				bindApplicationNumber = true;

				sb.append(_FINDER_COLUMN_APPLICATIONNUMBER_APPLICATIONNUMBER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FarmerRegistrationVersionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindApplicationNumber) {
					queryPos.add(applicationNumber);
				}

				list = (List<FarmerRegistrationVersion>)QueryUtil.list(
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
	 * Returns the first farmer registration version in the ordered set where applicationNumber = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	@Override
	public FarmerRegistrationVersion findByApplicationNumber_First(
			String applicationNumber,
			OrderByComparator<FarmerRegistrationVersion> orderByComparator)
		throws NoSuchFarmerRegistrationVersionException {

		FarmerRegistrationVersion farmerRegistrationVersion =
			fetchByApplicationNumber_First(
				applicationNumber, orderByComparator);

		if (farmerRegistrationVersion != null) {
			return farmerRegistrationVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("applicationNumber=");
		sb.append(applicationNumber);

		sb.append("}");

		throw new NoSuchFarmerRegistrationVersionException(sb.toString());
	}

	/**
	 * Returns the first farmer registration version in the ordered set where applicationNumber = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	@Override
	public FarmerRegistrationVersion fetchByApplicationNumber_First(
		String applicationNumber,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		List<FarmerRegistrationVersion> list = findByApplicationNumber(
			applicationNumber, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last farmer registration version in the ordered set where applicationNumber = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	@Override
	public FarmerRegistrationVersion findByApplicationNumber_Last(
			String applicationNumber,
			OrderByComparator<FarmerRegistrationVersion> orderByComparator)
		throws NoSuchFarmerRegistrationVersionException {

		FarmerRegistrationVersion farmerRegistrationVersion =
			fetchByApplicationNumber_Last(applicationNumber, orderByComparator);

		if (farmerRegistrationVersion != null) {
			return farmerRegistrationVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("applicationNumber=");
		sb.append(applicationNumber);

		sb.append("}");

		throw new NoSuchFarmerRegistrationVersionException(sb.toString());
	}

	/**
	 * Returns the last farmer registration version in the ordered set where applicationNumber = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	@Override
	public FarmerRegistrationVersion fetchByApplicationNumber_Last(
		String applicationNumber,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		int count = countByApplicationNumber(applicationNumber);

		if (count == 0) {
			return null;
		}

		List<FarmerRegistrationVersion> list = findByApplicationNumber(
			applicationNumber, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the farmer registration versions before and after the current farmer registration version in the ordered set where applicationNumber = &#63;.
	 *
	 * @param farmerRegistrationVersionId the primary key of the current farmer registration version
	 * @param applicationNumber the application number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a farmer registration version with the primary key could not be found
	 */
	@Override
	public FarmerRegistrationVersion[] findByApplicationNumber_PrevAndNext(
			long farmerRegistrationVersionId, String applicationNumber,
			OrderByComparator<FarmerRegistrationVersion> orderByComparator)
		throws NoSuchFarmerRegistrationVersionException {

		applicationNumber = Objects.toString(applicationNumber, "");

		FarmerRegistrationVersion farmerRegistrationVersion = findByPrimaryKey(
			farmerRegistrationVersionId);

		Session session = null;

		try {
			session = openSession();

			FarmerRegistrationVersion[] array =
				new FarmerRegistrationVersionImpl[3];

			array[0] = getByApplicationNumber_PrevAndNext(
				session, farmerRegistrationVersion, applicationNumber,
				orderByComparator, true);

			array[1] = farmerRegistrationVersion;

			array[2] = getByApplicationNumber_PrevAndNext(
				session, farmerRegistrationVersion, applicationNumber,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FarmerRegistrationVersion getByApplicationNumber_PrevAndNext(
		Session session, FarmerRegistrationVersion farmerRegistrationVersion,
		String applicationNumber,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator,
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

		sb.append(_SQL_SELECT_FARMERREGISTRATIONVERSION_WHERE);

		boolean bindApplicationNumber = false;

		if (applicationNumber.isEmpty()) {
			sb.append(_FINDER_COLUMN_APPLICATIONNUMBER_APPLICATIONNUMBER_3);
		}
		else {
			bindApplicationNumber = true;

			sb.append(_FINDER_COLUMN_APPLICATIONNUMBER_APPLICATIONNUMBER_2);
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
			sb.append(FarmerRegistrationVersionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindApplicationNumber) {
			queryPos.add(applicationNumber);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						farmerRegistrationVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FarmerRegistrationVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the farmer registration versions where applicationNumber = &#63; from the database.
	 *
	 * @param applicationNumber the application number
	 */
	@Override
	public void removeByApplicationNumber(String applicationNumber) {
		for (FarmerRegistrationVersion farmerRegistrationVersion :
				findByApplicationNumber(
					applicationNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(farmerRegistrationVersion);
		}
	}

	/**
	 * Returns the number of farmer registration versions where applicationNumber = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @return the number of matching farmer registration versions
	 */
	@Override
	public int countByApplicationNumber(String applicationNumber) {
		applicationNumber = Objects.toString(applicationNumber, "");

		FinderPath finderPath = _finderPathCountByApplicationNumber;

		Object[] finderArgs = new Object[] {applicationNumber};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FARMERREGISTRATIONVERSION_WHERE);

			boolean bindApplicationNumber = false;

			if (applicationNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPLICATIONNUMBER_APPLICATIONNUMBER_3);
			}
			else {
				bindApplicationNumber = true;

				sb.append(_FINDER_COLUMN_APPLICATIONNUMBER_APPLICATIONNUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindApplicationNumber) {
					queryPos.add(applicationNumber);
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

	private static final String
		_FINDER_COLUMN_APPLICATIONNUMBER_APPLICATIONNUMBER_2 =
			"farmerRegistrationVersion.applicationNumber = ?";

	private static final String
		_FINDER_COLUMN_APPLICATIONNUMBER_APPLICATIONNUMBER_3 =
			"(farmerRegistrationVersion.applicationNumber IS NULL OR farmerRegistrationVersion.applicationNumber = '')";

	private FinderPath _finderPathWithPaginationFindByBusinessCode;
	private FinderPath _finderPathWithoutPaginationFindByBusinessCode;
	private FinderPath _finderPathCountByBusinessCode;

	/**
	 * Returns all the farmer registration versions where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @return the matching farmer registration versions
	 */
	@Override
	public List<FarmerRegistrationVersion> findByBusinessCode(
		String businessCode) {

		return findByBusinessCode(
			businessCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the farmer registration versions where businessCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param businessCode the business code
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @return the range of matching farmer registration versions
	 */
	@Override
	public List<FarmerRegistrationVersion> findByBusinessCode(
		String businessCode, int start, int end) {

		return findByBusinessCode(businessCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the farmer registration versions where businessCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param businessCode the business code
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching farmer registration versions
	 */
	@Override
	public List<FarmerRegistrationVersion> findByBusinessCode(
		String businessCode, int start, int end,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		return findByBusinessCode(
			businessCode, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the farmer registration versions where businessCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param businessCode the business code
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching farmer registration versions
	 */
	@Override
	public List<FarmerRegistrationVersion> findByBusinessCode(
		String businessCode, int start, int end,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator,
		boolean useFinderCache) {

		businessCode = Objects.toString(businessCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByBusinessCode;
				finderArgs = new Object[] {businessCode};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByBusinessCode;
			finderArgs = new Object[] {
				businessCode, start, end, orderByComparator
			};
		}

		List<FarmerRegistrationVersion> list = null;

		if (useFinderCache) {
			list = (List<FarmerRegistrationVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FarmerRegistrationVersion farmerRegistrationVersion :
						list) {

					if (!businessCode.equals(
							farmerRegistrationVersion.getBusinessCode())) {

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

			sb.append(_SQL_SELECT_FARMERREGISTRATIONVERSION_WHERE);

			boolean bindBusinessCode = false;

			if (businessCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_BUSINESSCODE_BUSINESSCODE_3);
			}
			else {
				bindBusinessCode = true;

				sb.append(_FINDER_COLUMN_BUSINESSCODE_BUSINESSCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FarmerRegistrationVersionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindBusinessCode) {
					queryPos.add(businessCode);
				}

				list = (List<FarmerRegistrationVersion>)QueryUtil.list(
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
	 * Returns the first farmer registration version in the ordered set where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	@Override
	public FarmerRegistrationVersion findByBusinessCode_First(
			String businessCode,
			OrderByComparator<FarmerRegistrationVersion> orderByComparator)
		throws NoSuchFarmerRegistrationVersionException {

		FarmerRegistrationVersion farmerRegistrationVersion =
			fetchByBusinessCode_First(businessCode, orderByComparator);

		if (farmerRegistrationVersion != null) {
			return farmerRegistrationVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessCode=");
		sb.append(businessCode);

		sb.append("}");

		throw new NoSuchFarmerRegistrationVersionException(sb.toString());
	}

	/**
	 * Returns the first farmer registration version in the ordered set where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	@Override
	public FarmerRegistrationVersion fetchByBusinessCode_First(
		String businessCode,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		List<FarmerRegistrationVersion> list = findByBusinessCode(
			businessCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last farmer registration version in the ordered set where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	@Override
	public FarmerRegistrationVersion findByBusinessCode_Last(
			String businessCode,
			OrderByComparator<FarmerRegistrationVersion> orderByComparator)
		throws NoSuchFarmerRegistrationVersionException {

		FarmerRegistrationVersion farmerRegistrationVersion =
			fetchByBusinessCode_Last(businessCode, orderByComparator);

		if (farmerRegistrationVersion != null) {
			return farmerRegistrationVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessCode=");
		sb.append(businessCode);

		sb.append("}");

		throw new NoSuchFarmerRegistrationVersionException(sb.toString());
	}

	/**
	 * Returns the last farmer registration version in the ordered set where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	@Override
	public FarmerRegistrationVersion fetchByBusinessCode_Last(
		String businessCode,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		int count = countByBusinessCode(businessCode);

		if (count == 0) {
			return null;
		}

		List<FarmerRegistrationVersion> list = findByBusinessCode(
			businessCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the farmer registration versions before and after the current farmer registration version in the ordered set where businessCode = &#63;.
	 *
	 * @param farmerRegistrationVersionId the primary key of the current farmer registration version
	 * @param businessCode the business code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a farmer registration version with the primary key could not be found
	 */
	@Override
	public FarmerRegistrationVersion[] findByBusinessCode_PrevAndNext(
			long farmerRegistrationVersionId, String businessCode,
			OrderByComparator<FarmerRegistrationVersion> orderByComparator)
		throws NoSuchFarmerRegistrationVersionException {

		businessCode = Objects.toString(businessCode, "");

		FarmerRegistrationVersion farmerRegistrationVersion = findByPrimaryKey(
			farmerRegistrationVersionId);

		Session session = null;

		try {
			session = openSession();

			FarmerRegistrationVersion[] array =
				new FarmerRegistrationVersionImpl[3];

			array[0] = getByBusinessCode_PrevAndNext(
				session, farmerRegistrationVersion, businessCode,
				orderByComparator, true);

			array[1] = farmerRegistrationVersion;

			array[2] = getByBusinessCode_PrevAndNext(
				session, farmerRegistrationVersion, businessCode,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FarmerRegistrationVersion getByBusinessCode_PrevAndNext(
		Session session, FarmerRegistrationVersion farmerRegistrationVersion,
		String businessCode,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator,
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

		sb.append(_SQL_SELECT_FARMERREGISTRATIONVERSION_WHERE);

		boolean bindBusinessCode = false;

		if (businessCode.isEmpty()) {
			sb.append(_FINDER_COLUMN_BUSINESSCODE_BUSINESSCODE_3);
		}
		else {
			bindBusinessCode = true;

			sb.append(_FINDER_COLUMN_BUSINESSCODE_BUSINESSCODE_2);
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
			sb.append(FarmerRegistrationVersionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindBusinessCode) {
			queryPos.add(businessCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						farmerRegistrationVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FarmerRegistrationVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the farmer registration versions where businessCode = &#63; from the database.
	 *
	 * @param businessCode the business code
	 */
	@Override
	public void removeByBusinessCode(String businessCode) {
		for (FarmerRegistrationVersion farmerRegistrationVersion :
				findByBusinessCode(
					businessCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(farmerRegistrationVersion);
		}
	}

	/**
	 * Returns the number of farmer registration versions where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @return the number of matching farmer registration versions
	 */
	@Override
	public int countByBusinessCode(String businessCode) {
		businessCode = Objects.toString(businessCode, "");

		FinderPath finderPath = _finderPathCountByBusinessCode;

		Object[] finderArgs = new Object[] {businessCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FARMERREGISTRATIONVERSION_WHERE);

			boolean bindBusinessCode = false;

			if (businessCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_BUSINESSCODE_BUSINESSCODE_3);
			}
			else {
				bindBusinessCode = true;

				sb.append(_FINDER_COLUMN_BUSINESSCODE_BUSINESSCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindBusinessCode) {
					queryPos.add(businessCode);
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

	private static final String _FINDER_COLUMN_BUSINESSCODE_BUSINESSCODE_2 =
		"farmerRegistrationVersion.businessCode = ?";

	private static final String _FINDER_COLUMN_BUSINESSCODE_BUSINESSCODE_3 =
		"(farmerRegistrationVersion.businessCode IS NULL OR farmerRegistrationVersion.businessCode = '')";

	private FinderPath _finderPathFetchByFarmerRegistrationId;
	private FinderPath _finderPathCountByFarmerRegistrationId;

	/**
	 * Returns the farmer registration version where farmerRegistrationId = &#63; and version = &#63; or throws a <code>NoSuchFarmerRegistrationVersionException</code> if it could not be found.
	 *
	 * @param farmerRegistrationId the farmer registration ID
	 * @param version the version
	 * @return the matching farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a matching farmer registration version could not be found
	 */
	@Override
	public FarmerRegistrationVersion findByFarmerRegistrationId(
			long farmerRegistrationId, double version)
		throws NoSuchFarmerRegistrationVersionException {

		FarmerRegistrationVersion farmerRegistrationVersion =
			fetchByFarmerRegistrationId(farmerRegistrationId, version);

		if (farmerRegistrationVersion == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("farmerRegistrationId=");
			sb.append(farmerRegistrationId);

			sb.append(", version=");
			sb.append(version);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFarmerRegistrationVersionException(sb.toString());
		}

		return farmerRegistrationVersion;
	}

	/**
	 * Returns the farmer registration version where farmerRegistrationId = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param farmerRegistrationId the farmer registration ID
	 * @param version the version
	 * @return the matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	@Override
	public FarmerRegistrationVersion fetchByFarmerRegistrationId(
		long farmerRegistrationId, double version) {

		return fetchByFarmerRegistrationId(farmerRegistrationId, version, true);
	}

	/**
	 * Returns the farmer registration version where farmerRegistrationId = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param farmerRegistrationId the farmer registration ID
	 * @param version the version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer registration version, or <code>null</code> if a matching farmer registration version could not be found
	 */
	@Override
	public FarmerRegistrationVersion fetchByFarmerRegistrationId(
		long farmerRegistrationId, double version, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {farmerRegistrationId, version};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByFarmerRegistrationId, finderArgs);
		}

		if (result instanceof FarmerRegistrationVersion) {
			FarmerRegistrationVersion farmerRegistrationVersion =
				(FarmerRegistrationVersion)result;

			if ((farmerRegistrationId !=
					farmerRegistrationVersion.getFarmerRegistrationId()) ||
				(version != farmerRegistrationVersion.getVersion())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_FARMERREGISTRATIONVERSION_WHERE);

			sb.append(
				_FINDER_COLUMN_FARMERREGISTRATIONID_FARMERREGISTRATIONID_2);

			sb.append(_FINDER_COLUMN_FARMERREGISTRATIONID_VERSION_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(farmerRegistrationId);

				queryPos.add(version);

				List<FarmerRegistrationVersion> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByFarmerRegistrationId, finderArgs,
							list);
					}
				}
				else {
					FarmerRegistrationVersion farmerRegistrationVersion =
						list.get(0);

					result = farmerRegistrationVersion;

					cacheResult(farmerRegistrationVersion);
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
			return (FarmerRegistrationVersion)result;
		}
	}

	/**
	 * Removes the farmer registration version where farmerRegistrationId = &#63; and version = &#63; from the database.
	 *
	 * @param farmerRegistrationId the farmer registration ID
	 * @param version the version
	 * @return the farmer registration version that was removed
	 */
	@Override
	public FarmerRegistrationVersion removeByFarmerRegistrationId(
			long farmerRegistrationId, double version)
		throws NoSuchFarmerRegistrationVersionException {

		FarmerRegistrationVersion farmerRegistrationVersion =
			findByFarmerRegistrationId(farmerRegistrationId, version);

		return remove(farmerRegistrationVersion);
	}

	/**
	 * Returns the number of farmer registration versions where farmerRegistrationId = &#63; and version = &#63;.
	 *
	 * @param farmerRegistrationId the farmer registration ID
	 * @param version the version
	 * @return the number of matching farmer registration versions
	 */
	@Override
	public int countByFarmerRegistrationId(
		long farmerRegistrationId, double version) {

		FinderPath finderPath = _finderPathCountByFarmerRegistrationId;

		Object[] finderArgs = new Object[] {farmerRegistrationId, version};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FARMERREGISTRATIONVERSION_WHERE);

			sb.append(
				_FINDER_COLUMN_FARMERREGISTRATIONID_FARMERREGISTRATIONID_2);

			sb.append(_FINDER_COLUMN_FARMERREGISTRATIONID_VERSION_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(farmerRegistrationId);

				queryPos.add(version);

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

	private static final String
		_FINDER_COLUMN_FARMERREGISTRATIONID_FARMERREGISTRATIONID_2 =
			"farmerRegistrationVersion.farmerRegistrationId = ? AND ";

	private static final String _FINDER_COLUMN_FARMERREGISTRATIONID_VERSION_2 =
		"farmerRegistrationVersion.version = ?";

	public FarmerRegistrationVersionPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(FarmerRegistrationVersion.class);

		setModelImplClass(FarmerRegistrationVersionImpl.class);
		setModelPKClass(long.class);

		setTable(FarmerRegistrationVersionTable.INSTANCE);
	}

	/**
	 * Caches the farmer registration version in the entity cache if it is enabled.
	 *
	 * @param farmerRegistrationVersion the farmer registration version
	 */
	@Override
	public void cacheResult(
		FarmerRegistrationVersion farmerRegistrationVersion) {

		entityCache.putResult(
			FarmerRegistrationVersionImpl.class,
			farmerRegistrationVersion.getPrimaryKey(),
			farmerRegistrationVersion);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				farmerRegistrationVersion.getUuid(),
				farmerRegistrationVersion.getGroupId()
			},
			farmerRegistrationVersion);

		finderCache.putResult(
			_finderPathFetchByFarmerRegistrationId,
			new Object[] {
				farmerRegistrationVersion.getFarmerRegistrationId(),
				farmerRegistrationVersion.getVersion()
			},
			farmerRegistrationVersion);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the farmer registration versions in the entity cache if it is enabled.
	 *
	 * @param farmerRegistrationVersions the farmer registration versions
	 */
	@Override
	public void cacheResult(
		List<FarmerRegistrationVersion> farmerRegistrationVersions) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (farmerRegistrationVersions.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FarmerRegistrationVersion farmerRegistrationVersion :
				farmerRegistrationVersions) {

			if (entityCache.getResult(
					FarmerRegistrationVersionImpl.class,
					farmerRegistrationVersion.getPrimaryKey()) == null) {

				cacheResult(farmerRegistrationVersion);
			}
		}
	}

	/**
	 * Clears the cache for all farmer registration versions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FarmerRegistrationVersionImpl.class);

		finderCache.clearCache(FarmerRegistrationVersionImpl.class);
	}

	/**
	 * Clears the cache for the farmer registration version.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		FarmerRegistrationVersion farmerRegistrationVersion) {

		entityCache.removeResult(
			FarmerRegistrationVersionImpl.class, farmerRegistrationVersion);
	}

	@Override
	public void clearCache(
		List<FarmerRegistrationVersion> farmerRegistrationVersions) {

		for (FarmerRegistrationVersion farmerRegistrationVersion :
				farmerRegistrationVersions) {

			entityCache.removeResult(
				FarmerRegistrationVersionImpl.class, farmerRegistrationVersion);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FarmerRegistrationVersionImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				FarmerRegistrationVersionImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		FarmerRegistrationVersionModelImpl farmerRegistrationVersionModelImpl) {

		Object[] args = new Object[] {
			farmerRegistrationVersionModelImpl.getUuid(),
			farmerRegistrationVersionModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, farmerRegistrationVersionModelImpl);

		args = new Object[] {
			farmerRegistrationVersionModelImpl.getFarmerRegistrationId(),
			farmerRegistrationVersionModelImpl.getVersion()
		};

		finderCache.putResult(
			_finderPathCountByFarmerRegistrationId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByFarmerRegistrationId, args,
			farmerRegistrationVersionModelImpl);
	}

	/**
	 * Creates a new farmer registration version with the primary key. Does not add the farmer registration version to the database.
	 *
	 * @param farmerRegistrationVersionId the primary key for the new farmer registration version
	 * @return the new farmer registration version
	 */
	@Override
	public FarmerRegistrationVersion create(long farmerRegistrationVersionId) {
		FarmerRegistrationVersion farmerRegistrationVersion =
			new FarmerRegistrationVersionImpl();

		farmerRegistrationVersion.setNew(true);
		farmerRegistrationVersion.setPrimaryKey(farmerRegistrationVersionId);

		String uuid = _portalUUID.generate();

		farmerRegistrationVersion.setUuid(uuid);

		farmerRegistrationVersion.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return farmerRegistrationVersion;
	}

	/**
	 * Removes the farmer registration version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param farmerRegistrationVersionId the primary key of the farmer registration version
	 * @return the farmer registration version that was removed
	 * @throws NoSuchFarmerRegistrationVersionException if a farmer registration version with the primary key could not be found
	 */
	@Override
	public FarmerRegistrationVersion remove(long farmerRegistrationVersionId)
		throws NoSuchFarmerRegistrationVersionException {

		return remove((Serializable)farmerRegistrationVersionId);
	}

	/**
	 * Removes the farmer registration version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the farmer registration version
	 * @return the farmer registration version that was removed
	 * @throws NoSuchFarmerRegistrationVersionException if a farmer registration version with the primary key could not be found
	 */
	@Override
	public FarmerRegistrationVersion remove(Serializable primaryKey)
		throws NoSuchFarmerRegistrationVersionException {

		Session session = null;

		try {
			session = openSession();

			FarmerRegistrationVersion farmerRegistrationVersion =
				(FarmerRegistrationVersion)session.get(
					FarmerRegistrationVersionImpl.class, primaryKey);

			if (farmerRegistrationVersion == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFarmerRegistrationVersionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(farmerRegistrationVersion);
		}
		catch (NoSuchFarmerRegistrationVersionException noSuchEntityException) {
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
	protected FarmerRegistrationVersion removeImpl(
		FarmerRegistrationVersion farmerRegistrationVersion) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(farmerRegistrationVersion)) {
				farmerRegistrationVersion =
					(FarmerRegistrationVersion)session.get(
						FarmerRegistrationVersionImpl.class,
						farmerRegistrationVersion.getPrimaryKeyObj());
			}

			if (farmerRegistrationVersion != null) {
				session.delete(farmerRegistrationVersion);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (farmerRegistrationVersion != null) {
			clearCache(farmerRegistrationVersion);
		}

		return farmerRegistrationVersion;
	}

	@Override
	public FarmerRegistrationVersion updateImpl(
		FarmerRegistrationVersion farmerRegistrationVersion) {

		boolean isNew = farmerRegistrationVersion.isNew();

		if (!(farmerRegistrationVersion instanceof
				FarmerRegistrationVersionModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(farmerRegistrationVersion.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					farmerRegistrationVersion);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in farmerRegistrationVersion proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FarmerRegistrationVersion implementation " +
					farmerRegistrationVersion.getClass());
		}

		FarmerRegistrationVersionModelImpl farmerRegistrationVersionModelImpl =
			(FarmerRegistrationVersionModelImpl)farmerRegistrationVersion;

		if (Validator.isNull(farmerRegistrationVersion.getUuid())) {
			String uuid = _portalUUID.generate();

			farmerRegistrationVersion.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (farmerRegistrationVersion.getCreateDate() == null)) {
			if (serviceContext == null) {
				farmerRegistrationVersion.setCreateDate(date);
			}
			else {
				farmerRegistrationVersion.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!farmerRegistrationVersionModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				farmerRegistrationVersion.setModifiedDate(date);
			}
			else {
				farmerRegistrationVersion.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(farmerRegistrationVersion);
			}
			else {
				farmerRegistrationVersion =
					(FarmerRegistrationVersion)session.merge(
						farmerRegistrationVersion);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FarmerRegistrationVersionImpl.class,
			farmerRegistrationVersionModelImpl, false, true);

		cacheUniqueFindersCache(farmerRegistrationVersionModelImpl);

		if (isNew) {
			farmerRegistrationVersion.setNew(false);
		}

		farmerRegistrationVersion.resetOriginalValues();

		return farmerRegistrationVersion;
	}

	/**
	 * Returns the farmer registration version with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the farmer registration version
	 * @return the farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a farmer registration version with the primary key could not be found
	 */
	@Override
	public FarmerRegistrationVersion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFarmerRegistrationVersionException {

		FarmerRegistrationVersion farmerRegistrationVersion = fetchByPrimaryKey(
			primaryKey);

		if (farmerRegistrationVersion == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFarmerRegistrationVersionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return farmerRegistrationVersion;
	}

	/**
	 * Returns the farmer registration version with the primary key or throws a <code>NoSuchFarmerRegistrationVersionException</code> if it could not be found.
	 *
	 * @param farmerRegistrationVersionId the primary key of the farmer registration version
	 * @return the farmer registration version
	 * @throws NoSuchFarmerRegistrationVersionException if a farmer registration version with the primary key could not be found
	 */
	@Override
	public FarmerRegistrationVersion findByPrimaryKey(
			long farmerRegistrationVersionId)
		throws NoSuchFarmerRegistrationVersionException {

		return findByPrimaryKey((Serializable)farmerRegistrationVersionId);
	}

	/**
	 * Returns the farmer registration version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param farmerRegistrationVersionId the primary key of the farmer registration version
	 * @return the farmer registration version, or <code>null</code> if a farmer registration version with the primary key could not be found
	 */
	@Override
	public FarmerRegistrationVersion fetchByPrimaryKey(
		long farmerRegistrationVersionId) {

		return fetchByPrimaryKey((Serializable)farmerRegistrationVersionId);
	}

	/**
	 * Returns all the farmer registration versions.
	 *
	 * @return the farmer registration versions
	 */
	@Override
	public List<FarmerRegistrationVersion> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the farmer registration versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @return the range of farmer registration versions
	 */
	@Override
	public List<FarmerRegistrationVersion> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the farmer registration versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of farmer registration versions
	 */
	@Override
	public List<FarmerRegistrationVersion> findAll(
		int start, int end,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the farmer registration versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerRegistrationVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of farmer registration versions
	 * @param end the upper bound of the range of farmer registration versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of farmer registration versions
	 */
	@Override
	public List<FarmerRegistrationVersion> findAll(
		int start, int end,
		OrderByComparator<FarmerRegistrationVersion> orderByComparator,
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

		List<FarmerRegistrationVersion> list = null;

		if (useFinderCache) {
			list = (List<FarmerRegistrationVersion>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FARMERREGISTRATIONVERSION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FARMERREGISTRATIONVERSION;

				sql = sql.concat(
					FarmerRegistrationVersionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FarmerRegistrationVersion>)QueryUtil.list(
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
	 * Removes all the farmer registration versions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FarmerRegistrationVersion farmerRegistrationVersion : findAll()) {
			remove(farmerRegistrationVersion);
		}
	}

	/**
	 * Returns the number of farmer registration versions.
	 *
	 * @return the number of farmer registration versions
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
					_SQL_COUNT_FARMERREGISTRATIONVERSION);

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
		return "farmerRegistrationVersionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FARMERREGISTRATIONVERSION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FarmerRegistrationVersionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the farmer registration version persistence.
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

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByNationalId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNationalId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"nationalId"}, true);

		_finderPathWithoutPaginationFindByNationalId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNationalId",
			new String[] {String.class.getName()}, new String[] {"nationalId"},
			true);

		_finderPathCountByNationalId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNationalId",
			new String[] {String.class.getName()}, new String[] {"nationalId"},
			false);

		_finderPathWithPaginationFindByApplicationNumber = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByApplicationNumber",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"applicationNumber"}, true);

		_finderPathWithoutPaginationFindByApplicationNumber = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByApplicationNumber", new String[] {String.class.getName()},
			new String[] {"applicationNumber"}, true);

		_finderPathCountByApplicationNumber = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByApplicationNumber", new String[] {String.class.getName()},
			new String[] {"applicationNumber"}, false);

		_finderPathWithPaginationFindByBusinessCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBusinessCode",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"businessCode"}, true);

		_finderPathWithoutPaginationFindByBusinessCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBusinessCode",
			new String[] {String.class.getName()},
			new String[] {"businessCode"}, true);

		_finderPathCountByBusinessCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBusinessCode",
			new String[] {String.class.getName()},
			new String[] {"businessCode"}, false);

		_finderPathFetchByFarmerRegistrationId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByFarmerRegistrationId",
			new String[] {Long.class.getName(), Double.class.getName()},
			new String[] {"farmerRegistrationId", "version"}, true);

		_finderPathCountByFarmerRegistrationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFarmerRegistrationId",
			new String[] {Long.class.getName(), Double.class.getName()},
			new String[] {"farmerRegistrationId", "version"}, false);

		_setFarmerRegistrationVersionUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setFarmerRegistrationVersionUtilPersistence(null);

		entityCache.removeCache(FarmerRegistrationVersionImpl.class.getName());
	}

	private void _setFarmerRegistrationVersionUtilPersistence(
		FarmerRegistrationVersionPersistence
			farmerRegistrationVersionPersistence) {

		try {
			Field field = FarmerRegistrationVersionUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, farmerRegistrationVersionPersistence);
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

	private static final String _SQL_SELECT_FARMERREGISTRATIONVERSION =
		"SELECT farmerRegistrationVersion FROM FarmerRegistrationVersion farmerRegistrationVersion";

	private static final String _SQL_SELECT_FARMERREGISTRATIONVERSION_WHERE =
		"SELECT farmerRegistrationVersion FROM FarmerRegistrationVersion farmerRegistrationVersion WHERE ";

	private static final String _SQL_COUNT_FARMERREGISTRATIONVERSION =
		"SELECT COUNT(farmerRegistrationVersion) FROM FarmerRegistrationVersion farmerRegistrationVersion";

	private static final String _SQL_COUNT_FARMERREGISTRATIONVERSION_WHERE =
		"SELECT COUNT(farmerRegistrationVersion) FROM FarmerRegistrationVersion farmerRegistrationVersion WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"farmerRegistrationVersion.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FarmerRegistrationVersion exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FarmerRegistrationVersion exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FarmerRegistrationVersionPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private FarmerRegistrationVersionModelArgumentsResolver
		_farmerRegistrationVersionModelArgumentsResolver;

}