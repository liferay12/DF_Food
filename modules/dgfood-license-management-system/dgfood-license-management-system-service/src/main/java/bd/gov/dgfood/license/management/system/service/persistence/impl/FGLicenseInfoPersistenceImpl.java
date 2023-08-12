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

import bd.gov.dgfood.license.management.system.exception.NoSuchFGLicenseInfoException;
import bd.gov.dgfood.license.management.system.model.FGLicenseInfo;
import bd.gov.dgfood.license.management.system.model.FGLicenseInfoTable;
import bd.gov.dgfood.license.management.system.model.impl.FGLicenseInfoImpl;
import bd.gov.dgfood.license.management.system.model.impl.FGLicenseInfoModelImpl;
import bd.gov.dgfood.license.management.system.service.persistence.FGLicenseInfoPersistence;
import bd.gov.dgfood.license.management.system.service.persistence.FGLicenseInfoUtil;
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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the fg license info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {FGLicenseInfoPersistence.class, BasePersistence.class})
public class FGLicenseInfoPersistenceImpl
	extends BasePersistenceImpl<FGLicenseInfo>
	implements FGLicenseInfoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FGLicenseInfoUtil</code> to access the fg license info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FGLicenseInfoImpl.class.getName();

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
	 * Returns all the fg license infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching fg license infos
	 */
	@Override
	public List<FGLicenseInfo> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fg license infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fg license infos
	 * @param end the upper bound of the range of fg license infos (not inclusive)
	 * @return the range of matching fg license infos
	 */
	@Override
	public List<FGLicenseInfo> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fg license infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fg license infos
	 * @param end the upper bound of the range of fg license infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fg license infos
	 */
	@Override
	public List<FGLicenseInfo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FGLicenseInfo> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the fg license infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fg license infos
	 * @param end the upper bound of the range of fg license infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching fg license infos
	 */
	@Override
	public List<FGLicenseInfo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FGLicenseInfo> orderByComparator,
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

		List<FGLicenseInfo> list = null;

		if (useFinderCache) {
			list = (List<FGLicenseInfo>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FGLicenseInfo fgLicenseInfo : list) {
					if (!uuid.equals(fgLicenseInfo.getUuid())) {
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

			sb.append(_SQL_SELECT_FGLICENSEINFO_WHERE);

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
				sb.append(FGLicenseInfoModelImpl.ORDER_BY_JPQL);
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

				list = (List<FGLicenseInfo>)QueryUtil.list(
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
	 * Returns the first fg license info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fg license info
	 * @throws NoSuchFGLicenseInfoException if a matching fg license info could not be found
	 */
	@Override
	public FGLicenseInfo findByUuid_First(
			String uuid, OrderByComparator<FGLicenseInfo> orderByComparator)
		throws NoSuchFGLicenseInfoException {

		FGLicenseInfo fgLicenseInfo = fetchByUuid_First(
			uuid, orderByComparator);

		if (fgLicenseInfo != null) {
			return fgLicenseInfo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFGLicenseInfoException(sb.toString());
	}

	/**
	 * Returns the first fg license info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	@Override
	public FGLicenseInfo fetchByUuid_First(
		String uuid, OrderByComparator<FGLicenseInfo> orderByComparator) {

		List<FGLicenseInfo> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fg license info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fg license info
	 * @throws NoSuchFGLicenseInfoException if a matching fg license info could not be found
	 */
	@Override
	public FGLicenseInfo findByUuid_Last(
			String uuid, OrderByComparator<FGLicenseInfo> orderByComparator)
		throws NoSuchFGLicenseInfoException {

		FGLicenseInfo fgLicenseInfo = fetchByUuid_Last(uuid, orderByComparator);

		if (fgLicenseInfo != null) {
			return fgLicenseInfo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFGLicenseInfoException(sb.toString());
	}

	/**
	 * Returns the last fg license info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	@Override
	public FGLicenseInfo fetchByUuid_Last(
		String uuid, OrderByComparator<FGLicenseInfo> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<FGLicenseInfo> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fg license infos before and after the current fg license info in the ordered set where uuid = &#63;.
	 *
	 * @param fgLicenseInfoId the primary key of the current fg license info
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fg license info
	 * @throws NoSuchFGLicenseInfoException if a fg license info with the primary key could not be found
	 */
	@Override
	public FGLicenseInfo[] findByUuid_PrevAndNext(
			long fgLicenseInfoId, String uuid,
			OrderByComparator<FGLicenseInfo> orderByComparator)
		throws NoSuchFGLicenseInfoException {

		uuid = Objects.toString(uuid, "");

		FGLicenseInfo fgLicenseInfo = findByPrimaryKey(fgLicenseInfoId);

		Session session = null;

		try {
			session = openSession();

			FGLicenseInfo[] array = new FGLicenseInfoImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, fgLicenseInfo, uuid, orderByComparator, true);

			array[1] = fgLicenseInfo;

			array[2] = getByUuid_PrevAndNext(
				session, fgLicenseInfo, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FGLicenseInfo getByUuid_PrevAndNext(
		Session session, FGLicenseInfo fgLicenseInfo, String uuid,
		OrderByComparator<FGLicenseInfo> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FGLICENSEINFO_WHERE);

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
			sb.append(FGLicenseInfoModelImpl.ORDER_BY_JPQL);
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
						fgLicenseInfo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FGLicenseInfo> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fg license infos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (FGLicenseInfo fgLicenseInfo :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(fgLicenseInfo);
		}
	}

	/**
	 * Returns the number of fg license infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching fg license infos
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FGLICENSEINFO_WHERE);

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
		"fgLicenseInfo.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(fgLicenseInfo.uuid IS NULL OR fgLicenseInfo.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the fg license info where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFGLicenseInfoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching fg license info
	 * @throws NoSuchFGLicenseInfoException if a matching fg license info could not be found
	 */
	@Override
	public FGLicenseInfo findByUUID_G(String uuid, long groupId)
		throws NoSuchFGLicenseInfoException {

		FGLicenseInfo fgLicenseInfo = fetchByUUID_G(uuid, groupId);

		if (fgLicenseInfo == null) {
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

			throw new NoSuchFGLicenseInfoException(sb.toString());
		}

		return fgLicenseInfo;
	}

	/**
	 * Returns the fg license info where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	@Override
	public FGLicenseInfo fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the fg license info where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	@Override
	public FGLicenseInfo fetchByUUID_G(
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

		if (result instanceof FGLicenseInfo) {
			FGLicenseInfo fgLicenseInfo = (FGLicenseInfo)result;

			if (!Objects.equals(uuid, fgLicenseInfo.getUuid()) ||
				(groupId != fgLicenseInfo.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_FGLICENSEINFO_WHERE);

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

				List<FGLicenseInfo> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					FGLicenseInfo fgLicenseInfo = list.get(0);

					result = fgLicenseInfo;

					cacheResult(fgLicenseInfo);
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
			return (FGLicenseInfo)result;
		}
	}

	/**
	 * Removes the fg license info where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the fg license info that was removed
	 */
	@Override
	public FGLicenseInfo removeByUUID_G(String uuid, long groupId)
		throws NoSuchFGLicenseInfoException {

		FGLicenseInfo fgLicenseInfo = findByUUID_G(uuid, groupId);

		return remove(fgLicenseInfo);
	}

	/**
	 * Returns the number of fg license infos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching fg license infos
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FGLICENSEINFO_WHERE);

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
		"fgLicenseInfo.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(fgLicenseInfo.uuid IS NULL OR fgLicenseInfo.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"fgLicenseInfo.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the fg license infos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching fg license infos
	 */
	@Override
	public List<FGLicenseInfo> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fg license infos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of fg license infos
	 * @param end the upper bound of the range of fg license infos (not inclusive)
	 * @return the range of matching fg license infos
	 */
	@Override
	public List<FGLicenseInfo> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fg license infos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of fg license infos
	 * @param end the upper bound of the range of fg license infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fg license infos
	 */
	@Override
	public List<FGLicenseInfo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FGLicenseInfo> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the fg license infos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of fg license infos
	 * @param end the upper bound of the range of fg license infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching fg license infos
	 */
	@Override
	public List<FGLicenseInfo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FGLicenseInfo> orderByComparator,
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

		List<FGLicenseInfo> list = null;

		if (useFinderCache) {
			list = (List<FGLicenseInfo>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FGLicenseInfo fgLicenseInfo : list) {
					if (!uuid.equals(fgLicenseInfo.getUuid()) ||
						(companyId != fgLicenseInfo.getCompanyId())) {

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

			sb.append(_SQL_SELECT_FGLICENSEINFO_WHERE);

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
				sb.append(FGLicenseInfoModelImpl.ORDER_BY_JPQL);
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

				list = (List<FGLicenseInfo>)QueryUtil.list(
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
	 * Returns the first fg license info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fg license info
	 * @throws NoSuchFGLicenseInfoException if a matching fg license info could not be found
	 */
	@Override
	public FGLicenseInfo findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FGLicenseInfo> orderByComparator)
		throws NoSuchFGLicenseInfoException {

		FGLicenseInfo fgLicenseInfo = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (fgLicenseInfo != null) {
			return fgLicenseInfo;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFGLicenseInfoException(sb.toString());
	}

	/**
	 * Returns the first fg license info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	@Override
	public FGLicenseInfo fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FGLicenseInfo> orderByComparator) {

		List<FGLicenseInfo> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fg license info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fg license info
	 * @throws NoSuchFGLicenseInfoException if a matching fg license info could not be found
	 */
	@Override
	public FGLicenseInfo findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FGLicenseInfo> orderByComparator)
		throws NoSuchFGLicenseInfoException {

		FGLicenseInfo fgLicenseInfo = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (fgLicenseInfo != null) {
			return fgLicenseInfo;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFGLicenseInfoException(sb.toString());
	}

	/**
	 * Returns the last fg license info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	@Override
	public FGLicenseInfo fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FGLicenseInfo> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<FGLicenseInfo> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fg license infos before and after the current fg license info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param fgLicenseInfoId the primary key of the current fg license info
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fg license info
	 * @throws NoSuchFGLicenseInfoException if a fg license info with the primary key could not be found
	 */
	@Override
	public FGLicenseInfo[] findByUuid_C_PrevAndNext(
			long fgLicenseInfoId, String uuid, long companyId,
			OrderByComparator<FGLicenseInfo> orderByComparator)
		throws NoSuchFGLicenseInfoException {

		uuid = Objects.toString(uuid, "");

		FGLicenseInfo fgLicenseInfo = findByPrimaryKey(fgLicenseInfoId);

		Session session = null;

		try {
			session = openSession();

			FGLicenseInfo[] array = new FGLicenseInfoImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, fgLicenseInfo, uuid, companyId, orderByComparator,
				true);

			array[1] = fgLicenseInfo;

			array[2] = getByUuid_C_PrevAndNext(
				session, fgLicenseInfo, uuid, companyId, orderByComparator,
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

	protected FGLicenseInfo getByUuid_C_PrevAndNext(
		Session session, FGLicenseInfo fgLicenseInfo, String uuid,
		long companyId, OrderByComparator<FGLicenseInfo> orderByComparator,
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

		sb.append(_SQL_SELECT_FGLICENSEINFO_WHERE);

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
			sb.append(FGLicenseInfoModelImpl.ORDER_BY_JPQL);
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
						fgLicenseInfo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FGLicenseInfo> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fg license infos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (FGLicenseInfo fgLicenseInfo :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(fgLicenseInfo);
		}
	}

	/**
	 * Returns the number of fg license infos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching fg license infos
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FGLICENSEINFO_WHERE);

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
		"fgLicenseInfo.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(fgLicenseInfo.uuid IS NULL OR fgLicenseInfo.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"fgLicenseInfo.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByNationalIdAndStatus;
	private FinderPath _finderPathWithoutPaginationFindByNationalIdAndStatus;
	private FinderPath _finderPathCountByNationalIdAndStatus;

	/**
	 * Returns all the fg license infos where nationalId = &#63; and status = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param status the status
	 * @return the matching fg license infos
	 */
	@Override
	public List<FGLicenseInfo> findByNationalIdAndStatus(
		String nationalId, int status) {

		return findByNationalIdAndStatus(
			nationalId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fg license infos where nationalId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseInfoModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param status the status
	 * @param start the lower bound of the range of fg license infos
	 * @param end the upper bound of the range of fg license infos (not inclusive)
	 * @return the range of matching fg license infos
	 */
	@Override
	public List<FGLicenseInfo> findByNationalIdAndStatus(
		String nationalId, int status, int start, int end) {

		return findByNationalIdAndStatus(nationalId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fg license infos where nationalId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseInfoModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param status the status
	 * @param start the lower bound of the range of fg license infos
	 * @param end the upper bound of the range of fg license infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fg license infos
	 */
	@Override
	public List<FGLicenseInfo> findByNationalIdAndStatus(
		String nationalId, int status, int start, int end,
		OrderByComparator<FGLicenseInfo> orderByComparator) {

		return findByNationalIdAndStatus(
			nationalId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the fg license infos where nationalId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseInfoModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param status the status
	 * @param start the lower bound of the range of fg license infos
	 * @param end the upper bound of the range of fg license infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching fg license infos
	 */
	@Override
	public List<FGLicenseInfo> findByNationalIdAndStatus(
		String nationalId, int status, int start, int end,
		OrderByComparator<FGLicenseInfo> orderByComparator,
		boolean useFinderCache) {

		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByNationalIdAndStatus;
				finderArgs = new Object[] {nationalId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByNationalIdAndStatus;
			finderArgs = new Object[] {
				nationalId, status, start, end, orderByComparator
			};
		}

		List<FGLicenseInfo> list = null;

		if (useFinderCache) {
			list = (List<FGLicenseInfo>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FGLicenseInfo fgLicenseInfo : list) {
					if (!nationalId.equals(fgLicenseInfo.getNationalId()) ||
						(status != fgLicenseInfo.getStatus())) {

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

			sb.append(_SQL_SELECT_FGLICENSEINFO_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_NATIONALIDANDSTATUS_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(_FINDER_COLUMN_NATIONALIDANDSTATUS_NATIONALID_2);
			}

			sb.append(_FINDER_COLUMN_NATIONALIDANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FGLicenseInfoModelImpl.ORDER_BY_JPQL);
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

				queryPos.add(status);

				list = (List<FGLicenseInfo>)QueryUtil.list(
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
	 * Returns the first fg license info in the ordered set where nationalId = &#63; and status = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fg license info
	 * @throws NoSuchFGLicenseInfoException if a matching fg license info could not be found
	 */
	@Override
	public FGLicenseInfo findByNationalIdAndStatus_First(
			String nationalId, int status,
			OrderByComparator<FGLicenseInfo> orderByComparator)
		throws NoSuchFGLicenseInfoException {

		FGLicenseInfo fgLicenseInfo = fetchByNationalIdAndStatus_First(
			nationalId, status, orderByComparator);

		if (fgLicenseInfo != null) {
			return fgLicenseInfo;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationalId=");
		sb.append(nationalId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchFGLicenseInfoException(sb.toString());
	}

	/**
	 * Returns the first fg license info in the ordered set where nationalId = &#63; and status = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	@Override
	public FGLicenseInfo fetchByNationalIdAndStatus_First(
		String nationalId, int status,
		OrderByComparator<FGLicenseInfo> orderByComparator) {

		List<FGLicenseInfo> list = findByNationalIdAndStatus(
			nationalId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fg license info in the ordered set where nationalId = &#63; and status = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fg license info
	 * @throws NoSuchFGLicenseInfoException if a matching fg license info could not be found
	 */
	@Override
	public FGLicenseInfo findByNationalIdAndStatus_Last(
			String nationalId, int status,
			OrderByComparator<FGLicenseInfo> orderByComparator)
		throws NoSuchFGLicenseInfoException {

		FGLicenseInfo fgLicenseInfo = fetchByNationalIdAndStatus_Last(
			nationalId, status, orderByComparator);

		if (fgLicenseInfo != null) {
			return fgLicenseInfo;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationalId=");
		sb.append(nationalId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchFGLicenseInfoException(sb.toString());
	}

	/**
	 * Returns the last fg license info in the ordered set where nationalId = &#63; and status = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	@Override
	public FGLicenseInfo fetchByNationalIdAndStatus_Last(
		String nationalId, int status,
		OrderByComparator<FGLicenseInfo> orderByComparator) {

		int count = countByNationalIdAndStatus(nationalId, status);

		if (count == 0) {
			return null;
		}

		List<FGLicenseInfo> list = findByNationalIdAndStatus(
			nationalId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fg license infos before and after the current fg license info in the ordered set where nationalId = &#63; and status = &#63;.
	 *
	 * @param fgLicenseInfoId the primary key of the current fg license info
	 * @param nationalId the national ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fg license info
	 * @throws NoSuchFGLicenseInfoException if a fg license info with the primary key could not be found
	 */
	@Override
	public FGLicenseInfo[] findByNationalIdAndStatus_PrevAndNext(
			long fgLicenseInfoId, String nationalId, int status,
			OrderByComparator<FGLicenseInfo> orderByComparator)
		throws NoSuchFGLicenseInfoException {

		nationalId = Objects.toString(nationalId, "");

		FGLicenseInfo fgLicenseInfo = findByPrimaryKey(fgLicenseInfoId);

		Session session = null;

		try {
			session = openSession();

			FGLicenseInfo[] array = new FGLicenseInfoImpl[3];

			array[0] = getByNationalIdAndStatus_PrevAndNext(
				session, fgLicenseInfo, nationalId, status, orderByComparator,
				true);

			array[1] = fgLicenseInfo;

			array[2] = getByNationalIdAndStatus_PrevAndNext(
				session, fgLicenseInfo, nationalId, status, orderByComparator,
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

	protected FGLicenseInfo getByNationalIdAndStatus_PrevAndNext(
		Session session, FGLicenseInfo fgLicenseInfo, String nationalId,
		int status, OrderByComparator<FGLicenseInfo> orderByComparator,
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

		sb.append(_SQL_SELECT_FGLICENSEINFO_WHERE);

		boolean bindNationalId = false;

		if (nationalId.isEmpty()) {
			sb.append(_FINDER_COLUMN_NATIONALIDANDSTATUS_NATIONALID_3);
		}
		else {
			bindNationalId = true;

			sb.append(_FINDER_COLUMN_NATIONALIDANDSTATUS_NATIONALID_2);
		}

		sb.append(_FINDER_COLUMN_NATIONALIDANDSTATUS_STATUS_2);

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
			sb.append(FGLicenseInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindNationalId) {
			queryPos.add(nationalId);
		}

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						fgLicenseInfo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FGLicenseInfo> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fg license infos where nationalId = &#63; and status = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @param status the status
	 */
	@Override
	public void removeByNationalIdAndStatus(String nationalId, int status) {
		for (FGLicenseInfo fgLicenseInfo :
				findByNationalIdAndStatus(
					nationalId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(fgLicenseInfo);
		}
	}

	/**
	 * Returns the number of fg license infos where nationalId = &#63; and status = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param status the status
	 * @return the number of matching fg license infos
	 */
	@Override
	public int countByNationalIdAndStatus(String nationalId, int status) {
		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = _finderPathCountByNationalIdAndStatus;

		Object[] finderArgs = new Object[] {nationalId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FGLICENSEINFO_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_NATIONALIDANDSTATUS_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(_FINDER_COLUMN_NATIONALIDANDSTATUS_NATIONALID_2);
			}

			sb.append(_FINDER_COLUMN_NATIONALIDANDSTATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNationalId) {
					queryPos.add(nationalId);
				}

				queryPos.add(status);

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
		_FINDER_COLUMN_NATIONALIDANDSTATUS_NATIONALID_2 =
			"fgLicenseInfo.nationalId = ? AND ";

	private static final String
		_FINDER_COLUMN_NATIONALIDANDSTATUS_NATIONALID_3 =
			"(fgLicenseInfo.nationalId IS NULL OR fgLicenseInfo.nationalId = '') AND ";

	private static final String _FINDER_COLUMN_NATIONALIDANDSTATUS_STATUS_2 =
		"fgLicenseInfo.status = ?";

	private FinderPath _finderPathFetchByApplicationNumberNIDDateOfBirth;
	private FinderPath _finderPathCountByApplicationNumberNIDDateOfBirth;

	/**
	 * Returns the fg license info where applicationNumber = &#63; and nationalId = &#63; or throws a <code>NoSuchFGLicenseInfoException</code> if it could not be found.
	 *
	 * @param applicationNumber the application number
	 * @param nationalId the national ID
	 * @return the matching fg license info
	 * @throws NoSuchFGLicenseInfoException if a matching fg license info could not be found
	 */
	@Override
	public FGLicenseInfo findByApplicationNumberNIDDateOfBirth(
			String applicationNumber, String nationalId)
		throws NoSuchFGLicenseInfoException {

		FGLicenseInfo fgLicenseInfo = fetchByApplicationNumberNIDDateOfBirth(
			applicationNumber, nationalId);

		if (fgLicenseInfo == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("applicationNumber=");
			sb.append(applicationNumber);

			sb.append(", nationalId=");
			sb.append(nationalId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFGLicenseInfoException(sb.toString());
		}

		return fgLicenseInfo;
	}

	/**
	 * Returns the fg license info where applicationNumber = &#63; and nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @param nationalId the national ID
	 * @return the matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	@Override
	public FGLicenseInfo fetchByApplicationNumberNIDDateOfBirth(
		String applicationNumber, String nationalId) {

		return fetchByApplicationNumberNIDDateOfBirth(
			applicationNumber, nationalId, true);
	}

	/**
	 * Returns the fg license info where applicationNumber = &#63; and nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	@Override
	public FGLicenseInfo fetchByApplicationNumberNIDDateOfBirth(
		String applicationNumber, String nationalId, boolean useFinderCache) {

		applicationNumber = Objects.toString(applicationNumber, "");
		nationalId = Objects.toString(nationalId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {applicationNumber, nationalId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByApplicationNumberNIDDateOfBirth, finderArgs);
		}

		if (result instanceof FGLicenseInfo) {
			FGLicenseInfo fgLicenseInfo = (FGLicenseInfo)result;

			if (!Objects.equals(
					applicationNumber, fgLicenseInfo.getApplicationNumber()) ||
				!Objects.equals(nationalId, fgLicenseInfo.getNationalId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_FGLICENSEINFO_WHERE);

			boolean bindApplicationNumber = false;

			if (applicationNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_APPLICATIONNUMBERNIDDATEOFBIRTH_APPLICATIONNUMBER_3);
			}
			else {
				bindApplicationNumber = true;

				sb.append(
					_FINDER_COLUMN_APPLICATIONNUMBERNIDDATEOFBIRTH_APPLICATIONNUMBER_2);
			}

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_APPLICATIONNUMBERNIDDATEOFBIRTH_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(
					_FINDER_COLUMN_APPLICATIONNUMBERNIDDATEOFBIRTH_NATIONALID_2);
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

				if (bindNationalId) {
					queryPos.add(nationalId);
				}

				List<FGLicenseInfo> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByApplicationNumberNIDDateOfBirth,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									applicationNumber, nationalId
								};
							}

							_log.warn(
								"FGLicenseInfoPersistenceImpl.fetchByApplicationNumberNIDDateOfBirth(String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					FGLicenseInfo fgLicenseInfo = list.get(0);

					result = fgLicenseInfo;

					cacheResult(fgLicenseInfo);
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
			return (FGLicenseInfo)result;
		}
	}

	/**
	 * Removes the fg license info where applicationNumber = &#63; and nationalId = &#63; from the database.
	 *
	 * @param applicationNumber the application number
	 * @param nationalId the national ID
	 * @return the fg license info that was removed
	 */
	@Override
	public FGLicenseInfo removeByApplicationNumberNIDDateOfBirth(
			String applicationNumber, String nationalId)
		throws NoSuchFGLicenseInfoException {

		FGLicenseInfo fgLicenseInfo = findByApplicationNumberNIDDateOfBirth(
			applicationNumber, nationalId);

		return remove(fgLicenseInfo);
	}

	/**
	 * Returns the number of fg license infos where applicationNumber = &#63; and nationalId = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @param nationalId the national ID
	 * @return the number of matching fg license infos
	 */
	@Override
	public int countByApplicationNumberNIDDateOfBirth(
		String applicationNumber, String nationalId) {

		applicationNumber = Objects.toString(applicationNumber, "");
		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath =
			_finderPathCountByApplicationNumberNIDDateOfBirth;

		Object[] finderArgs = new Object[] {applicationNumber, nationalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FGLICENSEINFO_WHERE);

			boolean bindApplicationNumber = false;

			if (applicationNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_APPLICATIONNUMBERNIDDATEOFBIRTH_APPLICATIONNUMBER_3);
			}
			else {
				bindApplicationNumber = true;

				sb.append(
					_FINDER_COLUMN_APPLICATIONNUMBERNIDDATEOFBIRTH_APPLICATIONNUMBER_2);
			}

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_APPLICATIONNUMBERNIDDATEOFBIRTH_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(
					_FINDER_COLUMN_APPLICATIONNUMBERNIDDATEOFBIRTH_NATIONALID_2);
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

	private static final String
		_FINDER_COLUMN_APPLICATIONNUMBERNIDDATEOFBIRTH_APPLICATIONNUMBER_2 =
			"fgLicenseInfo.applicationNumber = ? AND ";

	private static final String
		_FINDER_COLUMN_APPLICATIONNUMBERNIDDATEOFBIRTH_APPLICATIONNUMBER_3 =
			"(fgLicenseInfo.applicationNumber IS NULL OR fgLicenseInfo.applicationNumber = '') AND ";

	private static final String
		_FINDER_COLUMN_APPLICATIONNUMBERNIDDATEOFBIRTH_NATIONALID_2 =
			"fgLicenseInfo.nationalId = ?";

	private static final String
		_FINDER_COLUMN_APPLICATIONNUMBERNIDDATEOFBIRTH_NATIONALID_3 =
			"(fgLicenseInfo.nationalId IS NULL OR fgLicenseInfo.nationalId = '')";

	private FinderPath _finderPathFetchByApplicationNumber;
	private FinderPath _finderPathCountByApplicationNumber;

	/**
	 * Returns the fg license info where applicationNumber = &#63; or throws a <code>NoSuchFGLicenseInfoException</code> if it could not be found.
	 *
	 * @param applicationNumber the application number
	 * @return the matching fg license info
	 * @throws NoSuchFGLicenseInfoException if a matching fg license info could not be found
	 */
	@Override
	public FGLicenseInfo findByApplicationNumber(String applicationNumber)
		throws NoSuchFGLicenseInfoException {

		FGLicenseInfo fgLicenseInfo = fetchByApplicationNumber(
			applicationNumber);

		if (fgLicenseInfo == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("applicationNumber=");
			sb.append(applicationNumber);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFGLicenseInfoException(sb.toString());
		}

		return fgLicenseInfo;
	}

	/**
	 * Returns the fg license info where applicationNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @return the matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	@Override
	public FGLicenseInfo fetchByApplicationNumber(String applicationNumber) {
		return fetchByApplicationNumber(applicationNumber, true);
	}

	/**
	 * Returns the fg license info where applicationNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	@Override
	public FGLicenseInfo fetchByApplicationNumber(
		String applicationNumber, boolean useFinderCache) {

		applicationNumber = Objects.toString(applicationNumber, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {applicationNumber};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByApplicationNumber, finderArgs);
		}

		if (result instanceof FGLicenseInfo) {
			FGLicenseInfo fgLicenseInfo = (FGLicenseInfo)result;

			if (!Objects.equals(
					applicationNumber, fgLicenseInfo.getApplicationNumber())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_FGLICENSEINFO_WHERE);

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

				List<FGLicenseInfo> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByApplicationNumber, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {applicationNumber};
							}

							_log.warn(
								"FGLicenseInfoPersistenceImpl.fetchByApplicationNumber(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					FGLicenseInfo fgLicenseInfo = list.get(0);

					result = fgLicenseInfo;

					cacheResult(fgLicenseInfo);
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
			return (FGLicenseInfo)result;
		}
	}

	/**
	 * Removes the fg license info where applicationNumber = &#63; from the database.
	 *
	 * @param applicationNumber the application number
	 * @return the fg license info that was removed
	 */
	@Override
	public FGLicenseInfo removeByApplicationNumber(String applicationNumber)
		throws NoSuchFGLicenseInfoException {

		FGLicenseInfo fgLicenseInfo = findByApplicationNumber(
			applicationNumber);

		return remove(fgLicenseInfo);
	}

	/**
	 * Returns the number of fg license infos where applicationNumber = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @return the number of matching fg license infos
	 */
	@Override
	public int countByApplicationNumber(String applicationNumber) {
		applicationNumber = Objects.toString(applicationNumber, "");

		FinderPath finderPath = _finderPathCountByApplicationNumber;

		Object[] finderArgs = new Object[] {applicationNumber};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FGLICENSEINFO_WHERE);

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
			"fgLicenseInfo.applicationNumber = ?";

	private static final String
		_FINDER_COLUMN_APPLICATIONNUMBER_APPLICATIONNUMBER_3 =
			"(fgLicenseInfo.applicationNumber IS NULL OR fgLicenseInfo.applicationNumber = '')";

	private FinderPath _finderPathFetchByFoodgrainLicenseNumber;
	private FinderPath _finderPathCountByFoodgrainLicenseNumber;

	/**
	 * Returns the fg license info where foodgrainLicenseNumber = &#63; or throws a <code>NoSuchFGLicenseInfoException</code> if it could not be found.
	 *
	 * @param foodgrainLicenseNumber the foodgrain license number
	 * @return the matching fg license info
	 * @throws NoSuchFGLicenseInfoException if a matching fg license info could not be found
	 */
	@Override
	public FGLicenseInfo findByFoodgrainLicenseNumber(
			String foodgrainLicenseNumber)
		throws NoSuchFGLicenseInfoException {

		FGLicenseInfo fgLicenseInfo = fetchByFoodgrainLicenseNumber(
			foodgrainLicenseNumber);

		if (fgLicenseInfo == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("foodgrainLicenseNumber=");
			sb.append(foodgrainLicenseNumber);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFGLicenseInfoException(sb.toString());
		}

		return fgLicenseInfo;
	}

	/**
	 * Returns the fg license info where foodgrainLicenseNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param foodgrainLicenseNumber the foodgrain license number
	 * @return the matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	@Override
	public FGLicenseInfo fetchByFoodgrainLicenseNumber(
		String foodgrainLicenseNumber) {

		return fetchByFoodgrainLicenseNumber(foodgrainLicenseNumber, true);
	}

	/**
	 * Returns the fg license info where foodgrainLicenseNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param foodgrainLicenseNumber the foodgrain license number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching fg license info, or <code>null</code> if a matching fg license info could not be found
	 */
	@Override
	public FGLicenseInfo fetchByFoodgrainLicenseNumber(
		String foodgrainLicenseNumber, boolean useFinderCache) {

		foodgrainLicenseNumber = Objects.toString(foodgrainLicenseNumber, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {foodgrainLicenseNumber};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByFoodgrainLicenseNumber, finderArgs);
		}

		if (result instanceof FGLicenseInfo) {
			FGLicenseInfo fgLicenseInfo = (FGLicenseInfo)result;

			if (!Objects.equals(
					foodgrainLicenseNumber,
					fgLicenseInfo.getFoodgrainLicenseNumber())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_FGLICENSEINFO_WHERE);

			boolean bindFoodgrainLicenseNumber = false;

			if (foodgrainLicenseNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_FOODGRAINLICENSENUMBER_FOODGRAINLICENSENUMBER_3);
			}
			else {
				bindFoodgrainLicenseNumber = true;

				sb.append(
					_FINDER_COLUMN_FOODGRAINLICENSENUMBER_FOODGRAINLICENSENUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFoodgrainLicenseNumber) {
					queryPos.add(foodgrainLicenseNumber);
				}

				List<FGLicenseInfo> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByFoodgrainLicenseNumber,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									foodgrainLicenseNumber
								};
							}

							_log.warn(
								"FGLicenseInfoPersistenceImpl.fetchByFoodgrainLicenseNumber(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					FGLicenseInfo fgLicenseInfo = list.get(0);

					result = fgLicenseInfo;

					cacheResult(fgLicenseInfo);
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
			return (FGLicenseInfo)result;
		}
	}

	/**
	 * Removes the fg license info where foodgrainLicenseNumber = &#63; from the database.
	 *
	 * @param foodgrainLicenseNumber the foodgrain license number
	 * @return the fg license info that was removed
	 */
	@Override
	public FGLicenseInfo removeByFoodgrainLicenseNumber(
			String foodgrainLicenseNumber)
		throws NoSuchFGLicenseInfoException {

		FGLicenseInfo fgLicenseInfo = findByFoodgrainLicenseNumber(
			foodgrainLicenseNumber);

		return remove(fgLicenseInfo);
	}

	/**
	 * Returns the number of fg license infos where foodgrainLicenseNumber = &#63;.
	 *
	 * @param foodgrainLicenseNumber the foodgrain license number
	 * @return the number of matching fg license infos
	 */
	@Override
	public int countByFoodgrainLicenseNumber(String foodgrainLicenseNumber) {
		foodgrainLicenseNumber = Objects.toString(foodgrainLicenseNumber, "");

		FinderPath finderPath = _finderPathCountByFoodgrainLicenseNumber;

		Object[] finderArgs = new Object[] {foodgrainLicenseNumber};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FGLICENSEINFO_WHERE);

			boolean bindFoodgrainLicenseNumber = false;

			if (foodgrainLicenseNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_FOODGRAINLICENSENUMBER_FOODGRAINLICENSENUMBER_3);
			}
			else {
				bindFoodgrainLicenseNumber = true;

				sb.append(
					_FINDER_COLUMN_FOODGRAINLICENSENUMBER_FOODGRAINLICENSENUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFoodgrainLicenseNumber) {
					queryPos.add(foodgrainLicenseNumber);
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
		_FINDER_COLUMN_FOODGRAINLICENSENUMBER_FOODGRAINLICENSENUMBER_2 =
			"fgLicenseInfo.foodgrainLicenseNumber = ?";

	private static final String
		_FINDER_COLUMN_FOODGRAINLICENSENUMBER_FOODGRAINLICENSENUMBER_3 =
			"(fgLicenseInfo.foodgrainLicenseNumber IS NULL OR fgLicenseInfo.foodgrainLicenseNumber = '')";

	public FGLicenseInfoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(FGLicenseInfo.class);

		setModelImplClass(FGLicenseInfoImpl.class);
		setModelPKClass(long.class);

		setTable(FGLicenseInfoTable.INSTANCE);
	}

	/**
	 * Caches the fg license info in the entity cache if it is enabled.
	 *
	 * @param fgLicenseInfo the fg license info
	 */
	@Override
	public void cacheResult(FGLicenseInfo fgLicenseInfo) {
		entityCache.putResult(
			FGLicenseInfoImpl.class, fgLicenseInfo.getPrimaryKey(),
			fgLicenseInfo);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {fgLicenseInfo.getUuid(), fgLicenseInfo.getGroupId()},
			fgLicenseInfo);

		finderCache.putResult(
			_finderPathFetchByApplicationNumberNIDDateOfBirth,
			new Object[] {
				fgLicenseInfo.getApplicationNumber(),
				fgLicenseInfo.getNationalId()
			},
			fgLicenseInfo);

		finderCache.putResult(
			_finderPathFetchByApplicationNumber,
			new Object[] {fgLicenseInfo.getApplicationNumber()}, fgLicenseInfo);

		finderCache.putResult(
			_finderPathFetchByFoodgrainLicenseNumber,
			new Object[] {fgLicenseInfo.getFoodgrainLicenseNumber()},
			fgLicenseInfo);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the fg license infos in the entity cache if it is enabled.
	 *
	 * @param fgLicenseInfos the fg license infos
	 */
	@Override
	public void cacheResult(List<FGLicenseInfo> fgLicenseInfos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (fgLicenseInfos.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FGLicenseInfo fgLicenseInfo : fgLicenseInfos) {
			if (entityCache.getResult(
					FGLicenseInfoImpl.class, fgLicenseInfo.getPrimaryKey()) ==
						null) {

				cacheResult(fgLicenseInfo);
			}
		}
	}

	/**
	 * Clears the cache for all fg license infos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FGLicenseInfoImpl.class);

		finderCache.clearCache(FGLicenseInfoImpl.class);
	}

	/**
	 * Clears the cache for the fg license info.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FGLicenseInfo fgLicenseInfo) {
		entityCache.removeResult(FGLicenseInfoImpl.class, fgLicenseInfo);
	}

	@Override
	public void clearCache(List<FGLicenseInfo> fgLicenseInfos) {
		for (FGLicenseInfo fgLicenseInfo : fgLicenseInfos) {
			entityCache.removeResult(FGLicenseInfoImpl.class, fgLicenseInfo);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FGLicenseInfoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FGLicenseInfoImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		FGLicenseInfoModelImpl fgLicenseInfoModelImpl) {

		Object[] args = new Object[] {
			fgLicenseInfoModelImpl.getUuid(),
			fgLicenseInfoModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, fgLicenseInfoModelImpl);

		args = new Object[] {
			fgLicenseInfoModelImpl.getApplicationNumber(),
			fgLicenseInfoModelImpl.getNationalId()
		};

		finderCache.putResult(
			_finderPathCountByApplicationNumberNIDDateOfBirth, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByApplicationNumberNIDDateOfBirth, args,
			fgLicenseInfoModelImpl);

		args = new Object[] {fgLicenseInfoModelImpl.getApplicationNumber()};

		finderCache.putResult(
			_finderPathCountByApplicationNumber, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByApplicationNumber, args, fgLicenseInfoModelImpl);

		args = new Object[] {
			fgLicenseInfoModelImpl.getFoodgrainLicenseNumber()
		};

		finderCache.putResult(
			_finderPathCountByFoodgrainLicenseNumber, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByFoodgrainLicenseNumber, args,
			fgLicenseInfoModelImpl);
	}

	/**
	 * Creates a new fg license info with the primary key. Does not add the fg license info to the database.
	 *
	 * @param fgLicenseInfoId the primary key for the new fg license info
	 * @return the new fg license info
	 */
	@Override
	public FGLicenseInfo create(long fgLicenseInfoId) {
		FGLicenseInfo fgLicenseInfo = new FGLicenseInfoImpl();

		fgLicenseInfo.setNew(true);
		fgLicenseInfo.setPrimaryKey(fgLicenseInfoId);

		String uuid = _portalUUID.generate();

		fgLicenseInfo.setUuid(uuid);

		fgLicenseInfo.setCompanyId(CompanyThreadLocal.getCompanyId());

		return fgLicenseInfo;
	}

	/**
	 * Removes the fg license info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fgLicenseInfoId the primary key of the fg license info
	 * @return the fg license info that was removed
	 * @throws NoSuchFGLicenseInfoException if a fg license info with the primary key could not be found
	 */
	@Override
	public FGLicenseInfo remove(long fgLicenseInfoId)
		throws NoSuchFGLicenseInfoException {

		return remove((Serializable)fgLicenseInfoId);
	}

	/**
	 * Removes the fg license info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fg license info
	 * @return the fg license info that was removed
	 * @throws NoSuchFGLicenseInfoException if a fg license info with the primary key could not be found
	 */
	@Override
	public FGLicenseInfo remove(Serializable primaryKey)
		throws NoSuchFGLicenseInfoException {

		Session session = null;

		try {
			session = openSession();

			FGLicenseInfo fgLicenseInfo = (FGLicenseInfo)session.get(
				FGLicenseInfoImpl.class, primaryKey);

			if (fgLicenseInfo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFGLicenseInfoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(fgLicenseInfo);
		}
		catch (NoSuchFGLicenseInfoException noSuchEntityException) {
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
	protected FGLicenseInfo removeImpl(FGLicenseInfo fgLicenseInfo) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(fgLicenseInfo)) {
				fgLicenseInfo = (FGLicenseInfo)session.get(
					FGLicenseInfoImpl.class, fgLicenseInfo.getPrimaryKeyObj());
			}

			if (fgLicenseInfo != null) {
				session.delete(fgLicenseInfo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (fgLicenseInfo != null) {
			clearCache(fgLicenseInfo);
		}

		return fgLicenseInfo;
	}

	@Override
	public FGLicenseInfo updateImpl(FGLicenseInfo fgLicenseInfo) {
		boolean isNew = fgLicenseInfo.isNew();

		if (!(fgLicenseInfo instanceof FGLicenseInfoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(fgLicenseInfo.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					fgLicenseInfo);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in fgLicenseInfo proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FGLicenseInfo implementation " +
					fgLicenseInfo.getClass());
		}

		FGLicenseInfoModelImpl fgLicenseInfoModelImpl =
			(FGLicenseInfoModelImpl)fgLicenseInfo;

		if (Validator.isNull(fgLicenseInfo.getUuid())) {
			String uuid = _portalUUID.generate();

			fgLicenseInfo.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (fgLicenseInfo.getCreateDate() == null)) {
			if (serviceContext == null) {
				fgLicenseInfo.setCreateDate(date);
			}
			else {
				fgLicenseInfo.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!fgLicenseInfoModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				fgLicenseInfo.setModifiedDate(date);
			}
			else {
				fgLicenseInfo.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(fgLicenseInfo);
			}
			else {
				fgLicenseInfo = (FGLicenseInfo)session.merge(fgLicenseInfo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FGLicenseInfoImpl.class, fgLicenseInfoModelImpl, false, true);

		cacheUniqueFindersCache(fgLicenseInfoModelImpl);

		if (isNew) {
			fgLicenseInfo.setNew(false);
		}

		fgLicenseInfo.resetOriginalValues();

		return fgLicenseInfo;
	}

	/**
	 * Returns the fg license info with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fg license info
	 * @return the fg license info
	 * @throws NoSuchFGLicenseInfoException if a fg license info with the primary key could not be found
	 */
	@Override
	public FGLicenseInfo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFGLicenseInfoException {

		FGLicenseInfo fgLicenseInfo = fetchByPrimaryKey(primaryKey);

		if (fgLicenseInfo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFGLicenseInfoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return fgLicenseInfo;
	}

	/**
	 * Returns the fg license info with the primary key or throws a <code>NoSuchFGLicenseInfoException</code> if it could not be found.
	 *
	 * @param fgLicenseInfoId the primary key of the fg license info
	 * @return the fg license info
	 * @throws NoSuchFGLicenseInfoException if a fg license info with the primary key could not be found
	 */
	@Override
	public FGLicenseInfo findByPrimaryKey(long fgLicenseInfoId)
		throws NoSuchFGLicenseInfoException {

		return findByPrimaryKey((Serializable)fgLicenseInfoId);
	}

	/**
	 * Returns the fg license info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fgLicenseInfoId the primary key of the fg license info
	 * @return the fg license info, or <code>null</code> if a fg license info with the primary key could not be found
	 */
	@Override
	public FGLicenseInfo fetchByPrimaryKey(long fgLicenseInfoId) {
		return fetchByPrimaryKey((Serializable)fgLicenseInfoId);
	}

	/**
	 * Returns all the fg license infos.
	 *
	 * @return the fg license infos
	 */
	@Override
	public List<FGLicenseInfo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fg license infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fg license infos
	 * @param end the upper bound of the range of fg license infos (not inclusive)
	 * @return the range of fg license infos
	 */
	@Override
	public List<FGLicenseInfo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fg license infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fg license infos
	 * @param end the upper bound of the range of fg license infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fg license infos
	 */
	@Override
	public List<FGLicenseInfo> findAll(
		int start, int end,
		OrderByComparator<FGLicenseInfo> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the fg license infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FGLicenseInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fg license infos
	 * @param end the upper bound of the range of fg license infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of fg license infos
	 */
	@Override
	public List<FGLicenseInfo> findAll(
		int start, int end, OrderByComparator<FGLicenseInfo> orderByComparator,
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

		List<FGLicenseInfo> list = null;

		if (useFinderCache) {
			list = (List<FGLicenseInfo>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FGLICENSEINFO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FGLICENSEINFO;

				sql = sql.concat(FGLicenseInfoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FGLicenseInfo>)QueryUtil.list(
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
	 * Removes all the fg license infos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FGLicenseInfo fgLicenseInfo : findAll()) {
			remove(fgLicenseInfo);
		}
	}

	/**
	 * Returns the number of fg license infos.
	 *
	 * @return the number of fg license infos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FGLICENSEINFO);

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
		return "fgLicenseInfoId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FGLICENSEINFO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FGLicenseInfoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the fg license info persistence.
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

		_finderPathWithPaginationFindByNationalIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNationalIdAndStatus",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"nationalId", "status"}, true);

		_finderPathWithoutPaginationFindByNationalIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByNationalIdAndStatus",
			new String[] {String.class.getName(), Integer.class.getName()},
			new String[] {"nationalId", "status"}, true);

		_finderPathCountByNationalIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByNationalIdAndStatus",
			new String[] {String.class.getName(), Integer.class.getName()},
			new String[] {"nationalId", "status"}, false);

		_finderPathFetchByApplicationNumberNIDDateOfBirth = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByApplicationNumberNIDDateOfBirth",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"applicationNumber", "nationalId"}, true);

		_finderPathCountByApplicationNumberNIDDateOfBirth = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByApplicationNumberNIDDateOfBirth",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"applicationNumber", "nationalId"}, false);

		_finderPathFetchByApplicationNumber = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByApplicationNumber",
			new String[] {String.class.getName()},
			new String[] {"applicationNumber"}, true);

		_finderPathCountByApplicationNumber = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByApplicationNumber", new String[] {String.class.getName()},
			new String[] {"applicationNumber"}, false);

		_finderPathFetchByFoodgrainLicenseNumber = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByFoodgrainLicenseNumber",
			new String[] {String.class.getName()},
			new String[] {"foodgrainLicenseNumber"}, true);

		_finderPathCountByFoodgrainLicenseNumber = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFoodgrainLicenseNumber",
			new String[] {String.class.getName()},
			new String[] {"foodgrainLicenseNumber"}, false);

		_setFGLicenseInfoUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setFGLicenseInfoUtilPersistence(null);

		entityCache.removeCache(FGLicenseInfoImpl.class.getName());
	}

	private void _setFGLicenseInfoUtilPersistence(
		FGLicenseInfoPersistence fgLicenseInfoPersistence) {

		try {
			Field field = FGLicenseInfoUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, fgLicenseInfoPersistence);
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

	private static final String _SQL_SELECT_FGLICENSEINFO =
		"SELECT fgLicenseInfo FROM FGLicenseInfo fgLicenseInfo";

	private static final String _SQL_SELECT_FGLICENSEINFO_WHERE =
		"SELECT fgLicenseInfo FROM FGLicenseInfo fgLicenseInfo WHERE ";

	private static final String _SQL_COUNT_FGLICENSEINFO =
		"SELECT COUNT(fgLicenseInfo) FROM FGLicenseInfo fgLicenseInfo";

	private static final String _SQL_COUNT_FGLICENSEINFO_WHERE =
		"SELECT COUNT(fgLicenseInfo) FROM FGLicenseInfo fgLicenseInfo WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "fgLicenseInfo.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FGLicenseInfo exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FGLicenseInfo exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FGLicenseInfoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private FGLicenseInfoModelArgumentsResolver
		_fgLicenseInfoModelArgumentsResolver;

}