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

package bd.gov.dgfood.food.friendly.program.service.persistence.impl;

import bd.gov.dgfood.food.friendly.program.exception.NoSuchFFPBeneficiaryException;
import bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary;
import bd.gov.dgfood.food.friendly.program.model.FFPBeneficiaryTable;
import bd.gov.dgfood.food.friendly.program.model.impl.FFPBeneficiaryImpl;
import bd.gov.dgfood.food.friendly.program.model.impl.FFPBeneficiaryModelImpl;
import bd.gov.dgfood.food.friendly.program.service.persistence.FFPBeneficiaryPersistence;
import bd.gov.dgfood.food.friendly.program.service.persistence.FFPBeneficiaryUtil;
import bd.gov.dgfood.food.friendly.program.service.persistence.impl.constants.DG_FOODPersistenceConstants;

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

import java.sql.Timestamp;

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
 * The persistence implementation for the ffp beneficiary service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {FFPBeneficiaryPersistence.class, BasePersistence.class})
public class FFPBeneficiaryPersistenceImpl
	extends BasePersistenceImpl<FFPBeneficiary>
	implements FFPBeneficiaryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FFPBeneficiaryUtil</code> to access the ffp beneficiary persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FFPBeneficiaryImpl.class.getName();

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
	 * Returns all the ffp beneficiaries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ffp beneficiaries
	 */
	@Override
	public List<FFPBeneficiary> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ffp beneficiaries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ffp beneficiaries
	 * @param end the upper bound of the range of ffp beneficiaries (not inclusive)
	 * @return the range of matching ffp beneficiaries
	 */
	@Override
	public List<FFPBeneficiary> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ffp beneficiaries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ffp beneficiaries
	 * @param end the upper bound of the range of ffp beneficiaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ffp beneficiaries
	 */
	@Override
	public List<FFPBeneficiary> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FFPBeneficiary> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ffp beneficiaries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ffp beneficiaries
	 * @param end the upper bound of the range of ffp beneficiaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ffp beneficiaries
	 */
	@Override
	public List<FFPBeneficiary> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FFPBeneficiary> orderByComparator,
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

		List<FFPBeneficiary> list = null;

		if (useFinderCache) {
			list = (List<FFPBeneficiary>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FFPBeneficiary ffpBeneficiary : list) {
					if (!uuid.equals(ffpBeneficiary.getUuid())) {
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

			sb.append(_SQL_SELECT_FFPBENEFICIARY_WHERE);

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
				sb.append(FFPBeneficiaryModelImpl.ORDER_BY_JPQL);
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

				list = (List<FFPBeneficiary>)QueryUtil.list(
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
	 * Returns the first ffp beneficiary in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a matching ffp beneficiary could not be found
	 */
	@Override
	public FFPBeneficiary findByUuid_First(
			String uuid, OrderByComparator<FFPBeneficiary> orderByComparator)
		throws NoSuchFFPBeneficiaryException {

		FFPBeneficiary ffpBeneficiary = fetchByUuid_First(
			uuid, orderByComparator);

		if (ffpBeneficiary != null) {
			return ffpBeneficiary;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFFPBeneficiaryException(sb.toString());
	}

	/**
	 * Returns the first ffp beneficiary in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	@Override
	public FFPBeneficiary fetchByUuid_First(
		String uuid, OrderByComparator<FFPBeneficiary> orderByComparator) {

		List<FFPBeneficiary> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ffp beneficiary in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a matching ffp beneficiary could not be found
	 */
	@Override
	public FFPBeneficiary findByUuid_Last(
			String uuid, OrderByComparator<FFPBeneficiary> orderByComparator)
		throws NoSuchFFPBeneficiaryException {

		FFPBeneficiary ffpBeneficiary = fetchByUuid_Last(
			uuid, orderByComparator);

		if (ffpBeneficiary != null) {
			return ffpBeneficiary;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFFPBeneficiaryException(sb.toString());
	}

	/**
	 * Returns the last ffp beneficiary in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	@Override
	public FFPBeneficiary fetchByUuid_Last(
		String uuid, OrderByComparator<FFPBeneficiary> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<FFPBeneficiary> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ffp beneficiaries before and after the current ffp beneficiary in the ordered set where uuid = &#63;.
	 *
	 * @param beneficiaryId the primary key of the current ffp beneficiary
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a ffp beneficiary with the primary key could not be found
	 */
	@Override
	public FFPBeneficiary[] findByUuid_PrevAndNext(
			long beneficiaryId, String uuid,
			OrderByComparator<FFPBeneficiary> orderByComparator)
		throws NoSuchFFPBeneficiaryException {

		uuid = Objects.toString(uuid, "");

		FFPBeneficiary ffpBeneficiary = findByPrimaryKey(beneficiaryId);

		Session session = null;

		try {
			session = openSession();

			FFPBeneficiary[] array = new FFPBeneficiaryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, ffpBeneficiary, uuid, orderByComparator, true);

			array[1] = ffpBeneficiary;

			array[2] = getByUuid_PrevAndNext(
				session, ffpBeneficiary, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FFPBeneficiary getByUuid_PrevAndNext(
		Session session, FFPBeneficiary ffpBeneficiary, String uuid,
		OrderByComparator<FFPBeneficiary> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FFPBENEFICIARY_WHERE);

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
			sb.append(FFPBeneficiaryModelImpl.ORDER_BY_JPQL);
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
						ffpBeneficiary)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FFPBeneficiary> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ffp beneficiaries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (FFPBeneficiary ffpBeneficiary :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ffpBeneficiary);
		}
	}

	/**
	 * Returns the number of ffp beneficiaries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ffp beneficiaries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FFPBENEFICIARY_WHERE);

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
		"ffpBeneficiary.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(ffpBeneficiary.uuid IS NULL OR ffpBeneficiary.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the ffp beneficiary where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFFPBeneficiaryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a matching ffp beneficiary could not be found
	 */
	@Override
	public FFPBeneficiary findByUUID_G(String uuid, long groupId)
		throws NoSuchFFPBeneficiaryException {

		FFPBeneficiary ffpBeneficiary = fetchByUUID_G(uuid, groupId);

		if (ffpBeneficiary == null) {
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

			throw new NoSuchFFPBeneficiaryException(sb.toString());
		}

		return ffpBeneficiary;
	}

	/**
	 * Returns the ffp beneficiary where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	@Override
	public FFPBeneficiary fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the ffp beneficiary where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	@Override
	public FFPBeneficiary fetchByUUID_G(
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

		if (result instanceof FFPBeneficiary) {
			FFPBeneficiary ffpBeneficiary = (FFPBeneficiary)result;

			if (!Objects.equals(uuid, ffpBeneficiary.getUuid()) ||
				(groupId != ffpBeneficiary.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_FFPBENEFICIARY_WHERE);

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

				List<FFPBeneficiary> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					FFPBeneficiary ffpBeneficiary = list.get(0);

					result = ffpBeneficiary;

					cacheResult(ffpBeneficiary);
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
			return (FFPBeneficiary)result;
		}
	}

	/**
	 * Removes the ffp beneficiary where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ffp beneficiary that was removed
	 */
	@Override
	public FFPBeneficiary removeByUUID_G(String uuid, long groupId)
		throws NoSuchFFPBeneficiaryException {

		FFPBeneficiary ffpBeneficiary = findByUUID_G(uuid, groupId);

		return remove(ffpBeneficiary);
	}

	/**
	 * Returns the number of ffp beneficiaries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ffp beneficiaries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FFPBENEFICIARY_WHERE);

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
		"ffpBeneficiary.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(ffpBeneficiary.uuid IS NULL OR ffpBeneficiary.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"ffpBeneficiary.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the ffp beneficiaries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ffp beneficiaries
	 */
	@Override
	public List<FFPBeneficiary> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ffp beneficiaries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ffp beneficiaries
	 * @param end the upper bound of the range of ffp beneficiaries (not inclusive)
	 * @return the range of matching ffp beneficiaries
	 */
	@Override
	public List<FFPBeneficiary> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ffp beneficiaries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ffp beneficiaries
	 * @param end the upper bound of the range of ffp beneficiaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ffp beneficiaries
	 */
	@Override
	public List<FFPBeneficiary> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FFPBeneficiary> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ffp beneficiaries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ffp beneficiaries
	 * @param end the upper bound of the range of ffp beneficiaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ffp beneficiaries
	 */
	@Override
	public List<FFPBeneficiary> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FFPBeneficiary> orderByComparator,
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

		List<FFPBeneficiary> list = null;

		if (useFinderCache) {
			list = (List<FFPBeneficiary>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FFPBeneficiary ffpBeneficiary : list) {
					if (!uuid.equals(ffpBeneficiary.getUuid()) ||
						(companyId != ffpBeneficiary.getCompanyId())) {

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

			sb.append(_SQL_SELECT_FFPBENEFICIARY_WHERE);

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
				sb.append(FFPBeneficiaryModelImpl.ORDER_BY_JPQL);
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

				list = (List<FFPBeneficiary>)QueryUtil.list(
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
	 * Returns the first ffp beneficiary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a matching ffp beneficiary could not be found
	 */
	@Override
	public FFPBeneficiary findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FFPBeneficiary> orderByComparator)
		throws NoSuchFFPBeneficiaryException {

		FFPBeneficiary ffpBeneficiary = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (ffpBeneficiary != null) {
			return ffpBeneficiary;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFFPBeneficiaryException(sb.toString());
	}

	/**
	 * Returns the first ffp beneficiary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	@Override
	public FFPBeneficiary fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FFPBeneficiary> orderByComparator) {

		List<FFPBeneficiary> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ffp beneficiary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a matching ffp beneficiary could not be found
	 */
	@Override
	public FFPBeneficiary findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FFPBeneficiary> orderByComparator)
		throws NoSuchFFPBeneficiaryException {

		FFPBeneficiary ffpBeneficiary = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (ffpBeneficiary != null) {
			return ffpBeneficiary;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFFPBeneficiaryException(sb.toString());
	}

	/**
	 * Returns the last ffp beneficiary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	@Override
	public FFPBeneficiary fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FFPBeneficiary> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<FFPBeneficiary> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ffp beneficiaries before and after the current ffp beneficiary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param beneficiaryId the primary key of the current ffp beneficiary
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a ffp beneficiary with the primary key could not be found
	 */
	@Override
	public FFPBeneficiary[] findByUuid_C_PrevAndNext(
			long beneficiaryId, String uuid, long companyId,
			OrderByComparator<FFPBeneficiary> orderByComparator)
		throws NoSuchFFPBeneficiaryException {

		uuid = Objects.toString(uuid, "");

		FFPBeneficiary ffpBeneficiary = findByPrimaryKey(beneficiaryId);

		Session session = null;

		try {
			session = openSession();

			FFPBeneficiary[] array = new FFPBeneficiaryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, ffpBeneficiary, uuid, companyId, orderByComparator,
				true);

			array[1] = ffpBeneficiary;

			array[2] = getByUuid_C_PrevAndNext(
				session, ffpBeneficiary, uuid, companyId, orderByComparator,
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

	protected FFPBeneficiary getByUuid_C_PrevAndNext(
		Session session, FFPBeneficiary ffpBeneficiary, String uuid,
		long companyId, OrderByComparator<FFPBeneficiary> orderByComparator,
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

		sb.append(_SQL_SELECT_FFPBENEFICIARY_WHERE);

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
			sb.append(FFPBeneficiaryModelImpl.ORDER_BY_JPQL);
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
						ffpBeneficiary)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FFPBeneficiary> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ffp beneficiaries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (FFPBeneficiary ffpBeneficiary :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(ffpBeneficiary);
		}
	}

	/**
	 * Returns the number of ffp beneficiaries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ffp beneficiaries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FFPBENEFICIARY_WHERE);

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
		"ffpBeneficiary.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(ffpBeneficiary.uuid IS NULL OR ffpBeneficiary.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"ffpBeneficiary.companyId = ?";

	private FinderPath _finderPathFetchByNationalId;
	private FinderPath _finderPathCountByNationalId;

	/**
	 * Returns the ffp beneficiary where nationalId = &#63; or throws a <code>NoSuchFFPBeneficiaryException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a matching ffp beneficiary could not be found
	 */
	@Override
	public FFPBeneficiary findByNationalId(long nationalId)
		throws NoSuchFFPBeneficiaryException {

		FFPBeneficiary ffpBeneficiary = fetchByNationalId(nationalId);

		if (ffpBeneficiary == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("nationalId=");
			sb.append(nationalId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFFPBeneficiaryException(sb.toString());
		}

		return ffpBeneficiary;
	}

	/**
	 * Returns the ffp beneficiary where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	@Override
	public FFPBeneficiary fetchByNationalId(long nationalId) {
		return fetchByNationalId(nationalId, true);
	}

	/**
	 * Returns the ffp beneficiary where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	@Override
	public FFPBeneficiary fetchByNationalId(
		long nationalId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {nationalId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByNationalId, finderArgs);
		}

		if (result instanceof FFPBeneficiary) {
			FFPBeneficiary ffpBeneficiary = (FFPBeneficiary)result;

			if (nationalId != ffpBeneficiary.getNationalId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_FFPBENEFICIARY_WHERE);

			sb.append(_FINDER_COLUMN_NATIONALID_NATIONALID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(nationalId);

				List<FFPBeneficiary> list = query.list();

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
								"FFPBeneficiaryPersistenceImpl.fetchByNationalId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					FFPBeneficiary ffpBeneficiary = list.get(0);

					result = ffpBeneficiary;

					cacheResult(ffpBeneficiary);
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
			return (FFPBeneficiary)result;
		}
	}

	/**
	 * Removes the ffp beneficiary where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the ffp beneficiary that was removed
	 */
	@Override
	public FFPBeneficiary removeByNationalId(long nationalId)
		throws NoSuchFFPBeneficiaryException {

		FFPBeneficiary ffpBeneficiary = findByNationalId(nationalId);

		return remove(ffpBeneficiary);
	}

	/**
	 * Returns the number of ffp beneficiaries where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching ffp beneficiaries
	 */
	@Override
	public int countByNationalId(long nationalId) {
		FinderPath finderPath = _finderPathCountByNationalId;

		Object[] finderArgs = new Object[] {nationalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FFPBENEFICIARY_WHERE);

			sb.append(_FINDER_COLUMN_NATIONALID_NATIONALID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(nationalId);

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
		"ffpBeneficiary.nationalId = ?";

	private FinderPath _finderPathFetchByCard_Dob;
	private FinderPath _finderPathCountByCard_Dob;

	/**
	 * Returns the ffp beneficiary where cardNumber = &#63; and dateOfBirth = &#63; or throws a <code>NoSuchFFPBeneficiaryException</code> if it could not be found.
	 *
	 * @param cardNumber the card number
	 * @param dateOfBirth the date of birth
	 * @return the matching ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a matching ffp beneficiary could not be found
	 */
	@Override
	public FFPBeneficiary findByCard_Dob(String cardNumber, Date dateOfBirth)
		throws NoSuchFFPBeneficiaryException {

		FFPBeneficiary ffpBeneficiary = fetchByCard_Dob(
			cardNumber, dateOfBirth);

		if (ffpBeneficiary == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("cardNumber=");
			sb.append(cardNumber);

			sb.append(", dateOfBirth=");
			sb.append(dateOfBirth);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFFPBeneficiaryException(sb.toString());
		}

		return ffpBeneficiary;
	}

	/**
	 * Returns the ffp beneficiary where cardNumber = &#63; and dateOfBirth = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cardNumber the card number
	 * @param dateOfBirth the date of birth
	 * @return the matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	@Override
	public FFPBeneficiary fetchByCard_Dob(String cardNumber, Date dateOfBirth) {
		return fetchByCard_Dob(cardNumber, dateOfBirth, true);
	}

	/**
	 * Returns the ffp beneficiary where cardNumber = &#63; and dateOfBirth = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cardNumber the card number
	 * @param dateOfBirth the date of birth
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	@Override
	public FFPBeneficiary fetchByCard_Dob(
		String cardNumber, Date dateOfBirth, boolean useFinderCache) {

		cardNumber = Objects.toString(cardNumber, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {cardNumber, _getTime(dateOfBirth)};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByCard_Dob, finderArgs);
		}

		if (result instanceof FFPBeneficiary) {
			FFPBeneficiary ffpBeneficiary = (FFPBeneficiary)result;

			if (!Objects.equals(cardNumber, ffpBeneficiary.getCardNumber()) ||
				!Objects.equals(dateOfBirth, ffpBeneficiary.getDateOfBirth())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_FFPBENEFICIARY_WHERE);

			boolean bindCardNumber = false;

			if (cardNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_CARD_DOB_CARDNUMBER_3);
			}
			else {
				bindCardNumber = true;

				sb.append(_FINDER_COLUMN_CARD_DOB_CARDNUMBER_2);
			}

			boolean bindDateOfBirth = false;

			if (dateOfBirth == null) {
				sb.append(_FINDER_COLUMN_CARD_DOB_DATEOFBIRTH_1);
			}
			else {
				bindDateOfBirth = true;

				sb.append(_FINDER_COLUMN_CARD_DOB_DATEOFBIRTH_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCardNumber) {
					queryPos.add(cardNumber);
				}

				if (bindDateOfBirth) {
					queryPos.add(new Timestamp(dateOfBirth.getTime()));
				}

				List<FFPBeneficiary> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByCard_Dob, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									cardNumber, _getTime(dateOfBirth)
								};
							}

							_log.warn(
								"FFPBeneficiaryPersistenceImpl.fetchByCard_Dob(String, Date, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					FFPBeneficiary ffpBeneficiary = list.get(0);

					result = ffpBeneficiary;

					cacheResult(ffpBeneficiary);
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
			return (FFPBeneficiary)result;
		}
	}

	/**
	 * Removes the ffp beneficiary where cardNumber = &#63; and dateOfBirth = &#63; from the database.
	 *
	 * @param cardNumber the card number
	 * @param dateOfBirth the date of birth
	 * @return the ffp beneficiary that was removed
	 */
	@Override
	public FFPBeneficiary removeByCard_Dob(String cardNumber, Date dateOfBirth)
		throws NoSuchFFPBeneficiaryException {

		FFPBeneficiary ffpBeneficiary = findByCard_Dob(cardNumber, dateOfBirth);

		return remove(ffpBeneficiary);
	}

	/**
	 * Returns the number of ffp beneficiaries where cardNumber = &#63; and dateOfBirth = &#63;.
	 *
	 * @param cardNumber the card number
	 * @param dateOfBirth the date of birth
	 * @return the number of matching ffp beneficiaries
	 */
	@Override
	public int countByCard_Dob(String cardNumber, Date dateOfBirth) {
		cardNumber = Objects.toString(cardNumber, "");

		FinderPath finderPath = _finderPathCountByCard_Dob;

		Object[] finderArgs = new Object[] {cardNumber, _getTime(dateOfBirth)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FFPBENEFICIARY_WHERE);

			boolean bindCardNumber = false;

			if (cardNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_CARD_DOB_CARDNUMBER_3);
			}
			else {
				bindCardNumber = true;

				sb.append(_FINDER_COLUMN_CARD_DOB_CARDNUMBER_2);
			}

			boolean bindDateOfBirth = false;

			if (dateOfBirth == null) {
				sb.append(_FINDER_COLUMN_CARD_DOB_DATEOFBIRTH_1);
			}
			else {
				bindDateOfBirth = true;

				sb.append(_FINDER_COLUMN_CARD_DOB_DATEOFBIRTH_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCardNumber) {
					queryPos.add(cardNumber);
				}

				if (bindDateOfBirth) {
					queryPos.add(new Timestamp(dateOfBirth.getTime()));
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

	private static final String _FINDER_COLUMN_CARD_DOB_CARDNUMBER_2 =
		"ffpBeneficiary.cardNumber = ? AND ";

	private static final String _FINDER_COLUMN_CARD_DOB_CARDNUMBER_3 =
		"(ffpBeneficiary.cardNumber IS NULL OR ffpBeneficiary.cardNumber = '') AND ";

	private static final String _FINDER_COLUMN_CARD_DOB_DATEOFBIRTH_1 =
		"ffpBeneficiary.dateOfBirth IS NULL";

	private static final String _FINDER_COLUMN_CARD_DOB_DATEOFBIRTH_2 =
		"ffpBeneficiary.dateOfBirth = ?";

	private FinderPath _finderPathFetchById_Dob;
	private FinderPath _finderPathCountById_Dob;

	/**
	 * Returns the ffp beneficiary where beneficiaryId = &#63; and dateOfBirth = &#63; or throws a <code>NoSuchFFPBeneficiaryException</code> if it could not be found.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param dateOfBirth the date of birth
	 * @return the matching ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a matching ffp beneficiary could not be found
	 */
	@Override
	public FFPBeneficiary findById_Dob(long beneficiaryId, Date dateOfBirth)
		throws NoSuchFFPBeneficiaryException {

		FFPBeneficiary ffpBeneficiary = fetchById_Dob(
			beneficiaryId, dateOfBirth);

		if (ffpBeneficiary == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("beneficiaryId=");
			sb.append(beneficiaryId);

			sb.append(", dateOfBirth=");
			sb.append(dateOfBirth);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFFPBeneficiaryException(sb.toString());
		}

		return ffpBeneficiary;
	}

	/**
	 * Returns the ffp beneficiary where beneficiaryId = &#63; and dateOfBirth = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param dateOfBirth the date of birth
	 * @return the matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	@Override
	public FFPBeneficiary fetchById_Dob(long beneficiaryId, Date dateOfBirth) {
		return fetchById_Dob(beneficiaryId, dateOfBirth, true);
	}

	/**
	 * Returns the ffp beneficiary where beneficiaryId = &#63; and dateOfBirth = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param dateOfBirth the date of birth
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ffp beneficiary, or <code>null</code> if a matching ffp beneficiary could not be found
	 */
	@Override
	public FFPBeneficiary fetchById_Dob(
		long beneficiaryId, Date dateOfBirth, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {beneficiaryId, _getTime(dateOfBirth)};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchById_Dob, finderArgs);
		}

		if (result instanceof FFPBeneficiary) {
			FFPBeneficiary ffpBeneficiary = (FFPBeneficiary)result;

			if ((beneficiaryId != ffpBeneficiary.getBeneficiaryId()) ||
				!Objects.equals(dateOfBirth, ffpBeneficiary.getDateOfBirth())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_FFPBENEFICIARY_WHERE);

			sb.append(_FINDER_COLUMN_ID_DOB_BENEFICIARYID_2);

			boolean bindDateOfBirth = false;

			if (dateOfBirth == null) {
				sb.append(_FINDER_COLUMN_ID_DOB_DATEOFBIRTH_1);
			}
			else {
				bindDateOfBirth = true;

				sb.append(_FINDER_COLUMN_ID_DOB_DATEOFBIRTH_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(beneficiaryId);

				if (bindDateOfBirth) {
					queryPos.add(new Timestamp(dateOfBirth.getTime()));
				}

				List<FFPBeneficiary> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchById_Dob, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									beneficiaryId, _getTime(dateOfBirth)
								};
							}

							_log.warn(
								"FFPBeneficiaryPersistenceImpl.fetchById_Dob(long, Date, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					FFPBeneficiary ffpBeneficiary = list.get(0);

					result = ffpBeneficiary;

					cacheResult(ffpBeneficiary);
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
			return (FFPBeneficiary)result;
		}
	}

	/**
	 * Removes the ffp beneficiary where beneficiaryId = &#63; and dateOfBirth = &#63; from the database.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param dateOfBirth the date of birth
	 * @return the ffp beneficiary that was removed
	 */
	@Override
	public FFPBeneficiary removeById_Dob(long beneficiaryId, Date dateOfBirth)
		throws NoSuchFFPBeneficiaryException {

		FFPBeneficiary ffpBeneficiary = findById_Dob(
			beneficiaryId, dateOfBirth);

		return remove(ffpBeneficiary);
	}

	/**
	 * Returns the number of ffp beneficiaries where beneficiaryId = &#63; and dateOfBirth = &#63;.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param dateOfBirth the date of birth
	 * @return the number of matching ffp beneficiaries
	 */
	@Override
	public int countById_Dob(long beneficiaryId, Date dateOfBirth) {
		FinderPath finderPath = _finderPathCountById_Dob;

		Object[] finderArgs = new Object[] {
			beneficiaryId, _getTime(dateOfBirth)
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FFPBENEFICIARY_WHERE);

			sb.append(_FINDER_COLUMN_ID_DOB_BENEFICIARYID_2);

			boolean bindDateOfBirth = false;

			if (dateOfBirth == null) {
				sb.append(_FINDER_COLUMN_ID_DOB_DATEOFBIRTH_1);
			}
			else {
				bindDateOfBirth = true;

				sb.append(_FINDER_COLUMN_ID_DOB_DATEOFBIRTH_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(beneficiaryId);

				if (bindDateOfBirth) {
					queryPos.add(new Timestamp(dateOfBirth.getTime()));
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

	private static final String _FINDER_COLUMN_ID_DOB_BENEFICIARYID_2 =
		"ffpBeneficiary.beneficiaryId = ? AND ";

	private static final String _FINDER_COLUMN_ID_DOB_DATEOFBIRTH_1 =
		"ffpBeneficiary.dateOfBirth IS NULL";

	private static final String _FINDER_COLUMN_ID_DOB_DATEOFBIRTH_2 =
		"ffpBeneficiary.dateOfBirth = ?";

	public FFPBeneficiaryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(FFPBeneficiary.class);

		setModelImplClass(FFPBeneficiaryImpl.class);
		setModelPKClass(long.class);

		setTable(FFPBeneficiaryTable.INSTANCE);
	}

	/**
	 * Caches the ffp beneficiary in the entity cache if it is enabled.
	 *
	 * @param ffpBeneficiary the ffp beneficiary
	 */
	@Override
	public void cacheResult(FFPBeneficiary ffpBeneficiary) {
		entityCache.putResult(
			FFPBeneficiaryImpl.class, ffpBeneficiary.getPrimaryKey(),
			ffpBeneficiary);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				ffpBeneficiary.getUuid(), ffpBeneficiary.getGroupId()
			},
			ffpBeneficiary);

		finderCache.putResult(
			_finderPathFetchByNationalId,
			new Object[] {ffpBeneficiary.getNationalId()}, ffpBeneficiary);

		finderCache.putResult(
			_finderPathFetchByCard_Dob,
			new Object[] {
				ffpBeneficiary.getCardNumber(), ffpBeneficiary.getDateOfBirth()
			},
			ffpBeneficiary);

		finderCache.putResult(
			_finderPathFetchById_Dob,
			new Object[] {
				ffpBeneficiary.getBeneficiaryId(),
				ffpBeneficiary.getDateOfBirth()
			},
			ffpBeneficiary);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the ffp beneficiaries in the entity cache if it is enabled.
	 *
	 * @param ffpBeneficiaries the ffp beneficiaries
	 */
	@Override
	public void cacheResult(List<FFPBeneficiary> ffpBeneficiaries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (ffpBeneficiaries.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FFPBeneficiary ffpBeneficiary : ffpBeneficiaries) {
			if (entityCache.getResult(
					FFPBeneficiaryImpl.class, ffpBeneficiary.getPrimaryKey()) ==
						null) {

				cacheResult(ffpBeneficiary);
			}
		}
	}

	/**
	 * Clears the cache for all ffp beneficiaries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FFPBeneficiaryImpl.class);

		finderCache.clearCache(FFPBeneficiaryImpl.class);
	}

	/**
	 * Clears the cache for the ffp beneficiary.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FFPBeneficiary ffpBeneficiary) {
		entityCache.removeResult(FFPBeneficiaryImpl.class, ffpBeneficiary);
	}

	@Override
	public void clearCache(List<FFPBeneficiary> ffpBeneficiaries) {
		for (FFPBeneficiary ffpBeneficiary : ffpBeneficiaries) {
			entityCache.removeResult(FFPBeneficiaryImpl.class, ffpBeneficiary);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FFPBeneficiaryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FFPBeneficiaryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		FFPBeneficiaryModelImpl ffpBeneficiaryModelImpl) {

		Object[] args = new Object[] {
			ffpBeneficiaryModelImpl.getUuid(),
			ffpBeneficiaryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, ffpBeneficiaryModelImpl);

		args = new Object[] {ffpBeneficiaryModelImpl.getNationalId()};

		finderCache.putResult(
			_finderPathCountByNationalId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByNationalId, args, ffpBeneficiaryModelImpl);

		args = new Object[] {
			ffpBeneficiaryModelImpl.getCardNumber(),
			_getTime(ffpBeneficiaryModelImpl.getDateOfBirth())
		};

		finderCache.putResult(
			_finderPathCountByCard_Dob, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByCard_Dob, args, ffpBeneficiaryModelImpl);

		args = new Object[] {
			ffpBeneficiaryModelImpl.getBeneficiaryId(),
			_getTime(ffpBeneficiaryModelImpl.getDateOfBirth())
		};

		finderCache.putResult(_finderPathCountById_Dob, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchById_Dob, args, ffpBeneficiaryModelImpl);
	}

	/**
	 * Creates a new ffp beneficiary with the primary key. Does not add the ffp beneficiary to the database.
	 *
	 * @param beneficiaryId the primary key for the new ffp beneficiary
	 * @return the new ffp beneficiary
	 */
	@Override
	public FFPBeneficiary create(long beneficiaryId) {
		FFPBeneficiary ffpBeneficiary = new FFPBeneficiaryImpl();

		ffpBeneficiary.setNew(true);
		ffpBeneficiary.setPrimaryKey(beneficiaryId);

		String uuid = _portalUUID.generate();

		ffpBeneficiary.setUuid(uuid);

		ffpBeneficiary.setCompanyId(CompanyThreadLocal.getCompanyId());

		return ffpBeneficiary;
	}

	/**
	 * Removes the ffp beneficiary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param beneficiaryId the primary key of the ffp beneficiary
	 * @return the ffp beneficiary that was removed
	 * @throws NoSuchFFPBeneficiaryException if a ffp beneficiary with the primary key could not be found
	 */
	@Override
	public FFPBeneficiary remove(long beneficiaryId)
		throws NoSuchFFPBeneficiaryException {

		return remove((Serializable)beneficiaryId);
	}

	/**
	 * Removes the ffp beneficiary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ffp beneficiary
	 * @return the ffp beneficiary that was removed
	 * @throws NoSuchFFPBeneficiaryException if a ffp beneficiary with the primary key could not be found
	 */
	@Override
	public FFPBeneficiary remove(Serializable primaryKey)
		throws NoSuchFFPBeneficiaryException {

		Session session = null;

		try {
			session = openSession();

			FFPBeneficiary ffpBeneficiary = (FFPBeneficiary)session.get(
				FFPBeneficiaryImpl.class, primaryKey);

			if (ffpBeneficiary == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFFPBeneficiaryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ffpBeneficiary);
		}
		catch (NoSuchFFPBeneficiaryException noSuchEntityException) {
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
	protected FFPBeneficiary removeImpl(FFPBeneficiary ffpBeneficiary) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ffpBeneficiary)) {
				ffpBeneficiary = (FFPBeneficiary)session.get(
					FFPBeneficiaryImpl.class,
					ffpBeneficiary.getPrimaryKeyObj());
			}

			if (ffpBeneficiary != null) {
				session.delete(ffpBeneficiary);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (ffpBeneficiary != null) {
			clearCache(ffpBeneficiary);
		}

		return ffpBeneficiary;
	}

	@Override
	public FFPBeneficiary updateImpl(FFPBeneficiary ffpBeneficiary) {
		boolean isNew = ffpBeneficiary.isNew();

		if (!(ffpBeneficiary instanceof FFPBeneficiaryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ffpBeneficiary.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					ffpBeneficiary);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ffpBeneficiary proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FFPBeneficiary implementation " +
					ffpBeneficiary.getClass());
		}

		FFPBeneficiaryModelImpl ffpBeneficiaryModelImpl =
			(FFPBeneficiaryModelImpl)ffpBeneficiary;

		if (Validator.isNull(ffpBeneficiary.getUuid())) {
			String uuid = _portalUUID.generate();

			ffpBeneficiary.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (ffpBeneficiary.getCreateDate() == null)) {
			if (serviceContext == null) {
				ffpBeneficiary.setCreateDate(date);
			}
			else {
				ffpBeneficiary.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!ffpBeneficiaryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				ffpBeneficiary.setModifiedDate(date);
			}
			else {
				ffpBeneficiary.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(ffpBeneficiary);
			}
			else {
				ffpBeneficiary = (FFPBeneficiary)session.merge(ffpBeneficiary);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FFPBeneficiaryImpl.class, ffpBeneficiaryModelImpl, false, true);

		cacheUniqueFindersCache(ffpBeneficiaryModelImpl);

		if (isNew) {
			ffpBeneficiary.setNew(false);
		}

		ffpBeneficiary.resetOriginalValues();

		return ffpBeneficiary;
	}

	/**
	 * Returns the ffp beneficiary with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ffp beneficiary
	 * @return the ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a ffp beneficiary with the primary key could not be found
	 */
	@Override
	public FFPBeneficiary findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFFPBeneficiaryException {

		FFPBeneficiary ffpBeneficiary = fetchByPrimaryKey(primaryKey);

		if (ffpBeneficiary == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFFPBeneficiaryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ffpBeneficiary;
	}

	/**
	 * Returns the ffp beneficiary with the primary key or throws a <code>NoSuchFFPBeneficiaryException</code> if it could not be found.
	 *
	 * @param beneficiaryId the primary key of the ffp beneficiary
	 * @return the ffp beneficiary
	 * @throws NoSuchFFPBeneficiaryException if a ffp beneficiary with the primary key could not be found
	 */
	@Override
	public FFPBeneficiary findByPrimaryKey(long beneficiaryId)
		throws NoSuchFFPBeneficiaryException {

		return findByPrimaryKey((Serializable)beneficiaryId);
	}

	/**
	 * Returns the ffp beneficiary with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param beneficiaryId the primary key of the ffp beneficiary
	 * @return the ffp beneficiary, or <code>null</code> if a ffp beneficiary with the primary key could not be found
	 */
	@Override
	public FFPBeneficiary fetchByPrimaryKey(long beneficiaryId) {
		return fetchByPrimaryKey((Serializable)beneficiaryId);
	}

	/**
	 * Returns all the ffp beneficiaries.
	 *
	 * @return the ffp beneficiaries
	 */
	@Override
	public List<FFPBeneficiary> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ffp beneficiaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ffp beneficiaries
	 * @param end the upper bound of the range of ffp beneficiaries (not inclusive)
	 * @return the range of ffp beneficiaries
	 */
	@Override
	public List<FFPBeneficiary> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ffp beneficiaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ffp beneficiaries
	 * @param end the upper bound of the range of ffp beneficiaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ffp beneficiaries
	 */
	@Override
	public List<FFPBeneficiary> findAll(
		int start, int end,
		OrderByComparator<FFPBeneficiary> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ffp beneficiaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ffp beneficiaries
	 * @param end the upper bound of the range of ffp beneficiaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ffp beneficiaries
	 */
	@Override
	public List<FFPBeneficiary> findAll(
		int start, int end, OrderByComparator<FFPBeneficiary> orderByComparator,
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

		List<FFPBeneficiary> list = null;

		if (useFinderCache) {
			list = (List<FFPBeneficiary>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FFPBENEFICIARY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FFPBENEFICIARY;

				sql = sql.concat(FFPBeneficiaryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FFPBeneficiary>)QueryUtil.list(
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
	 * Removes all the ffp beneficiaries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FFPBeneficiary ffpBeneficiary : findAll()) {
			remove(ffpBeneficiary);
		}
	}

	/**
	 * Returns the number of ffp beneficiaries.
	 *
	 * @return the number of ffp beneficiaries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FFPBENEFICIARY);

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
		return "beneficiaryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FFPBENEFICIARY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FFPBeneficiaryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ffp beneficiary persistence.
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

		_finderPathFetchByNationalId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByNationalId",
			new String[] {Long.class.getName()}, new String[] {"nationalId"},
			true);

		_finderPathCountByNationalId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNationalId",
			new String[] {Long.class.getName()}, new String[] {"nationalId"},
			false);

		_finderPathFetchByCard_Dob = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByCard_Dob",
			new String[] {String.class.getName(), Date.class.getName()},
			new String[] {"cardNumber", "dateOfBirth"}, true);

		_finderPathCountByCard_Dob = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCard_Dob",
			new String[] {String.class.getName(), Date.class.getName()},
			new String[] {"cardNumber", "dateOfBirth"}, false);

		_finderPathFetchById_Dob = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchById_Dob",
			new String[] {Long.class.getName(), Date.class.getName()},
			new String[] {"beneficiaryId", "dateOfBirth"}, true);

		_finderPathCountById_Dob = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countById_Dob",
			new String[] {Long.class.getName(), Date.class.getName()},
			new String[] {"beneficiaryId", "dateOfBirth"}, false);

		_setFFPBeneficiaryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setFFPBeneficiaryUtilPersistence(null);

		entityCache.removeCache(FFPBeneficiaryImpl.class.getName());
	}

	private void _setFFPBeneficiaryUtilPersistence(
		FFPBeneficiaryPersistence ffpBeneficiaryPersistence) {

		try {
			Field field = FFPBeneficiaryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, ffpBeneficiaryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = DG_FOODPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = DG_FOODPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = DG_FOODPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_FFPBENEFICIARY =
		"SELECT ffpBeneficiary FROM FFPBeneficiary ffpBeneficiary";

	private static final String _SQL_SELECT_FFPBENEFICIARY_WHERE =
		"SELECT ffpBeneficiary FROM FFPBeneficiary ffpBeneficiary WHERE ";

	private static final String _SQL_COUNT_FFPBENEFICIARY =
		"SELECT COUNT(ffpBeneficiary) FROM FFPBeneficiary ffpBeneficiary";

	private static final String _SQL_COUNT_FFPBENEFICIARY_WHERE =
		"SELECT COUNT(ffpBeneficiary) FROM FFPBeneficiary ffpBeneficiary WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ffpBeneficiary.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FFPBeneficiary exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FFPBeneficiary exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FFPBeneficiaryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private FFPBeneficiaryModelArgumentsResolver
		_ffpBeneficiaryModelArgumentsResolver;

}