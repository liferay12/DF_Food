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

import bd.gov.dgfood.farmer.information.management.system.exception.NoSuchFarmerSalesProposalException;
import bd.gov.dgfood.farmer.information.management.system.model.FarmerSalesProposal;
import bd.gov.dgfood.farmer.information.management.system.model.FarmerSalesProposalTable;
import bd.gov.dgfood.farmer.information.management.system.model.impl.FarmerSalesProposalImpl;
import bd.gov.dgfood.farmer.information.management.system.model.impl.FarmerSalesProposalModelImpl;
import bd.gov.dgfood.farmer.information.management.system.service.persistence.FarmerSalesProposalPersistence;
import bd.gov.dgfood.farmer.information.management.system.service.persistence.FarmerSalesProposalUtil;
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
 * The persistence implementation for the farmer sales proposal service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {FarmerSalesProposalPersistence.class, BasePersistence.class}
)
public class FarmerSalesProposalPersistenceImpl
	extends BasePersistenceImpl<FarmerSalesProposal>
	implements FarmerSalesProposalPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FarmerSalesProposalUtil</code> to access the farmer sales proposal persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FarmerSalesProposalImpl.class.getName();

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
	 * Returns all the farmer sales proposals where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching farmer sales proposals
	 */
	@Override
	public List<FarmerSalesProposal> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the farmer sales proposals where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerSalesProposalModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of farmer sales proposals
	 * @param end the upper bound of the range of farmer sales proposals (not inclusive)
	 * @return the range of matching farmer sales proposals
	 */
	@Override
	public List<FarmerSalesProposal> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the farmer sales proposals where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerSalesProposalModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of farmer sales proposals
	 * @param end the upper bound of the range of farmer sales proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching farmer sales proposals
	 */
	@Override
	public List<FarmerSalesProposal> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FarmerSalesProposal> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the farmer sales proposals where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerSalesProposalModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of farmer sales proposals
	 * @param end the upper bound of the range of farmer sales proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching farmer sales proposals
	 */
	@Override
	public List<FarmerSalesProposal> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FarmerSalesProposal> orderByComparator,
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

		List<FarmerSalesProposal> list = null;

		if (useFinderCache) {
			list = (List<FarmerSalesProposal>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FarmerSalesProposal farmerSalesProposal : list) {
					if (!uuid.equals(farmerSalesProposal.getUuid())) {
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

			sb.append(_SQL_SELECT_FARMERSALESPROPOSAL_WHERE);

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
				sb.append(FarmerSalesProposalModelImpl.ORDER_BY_JPQL);
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

				list = (List<FarmerSalesProposal>)QueryUtil.list(
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
	 * Returns the first farmer sales proposal in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a matching farmer sales proposal could not be found
	 */
	@Override
	public FarmerSalesProposal findByUuid_First(
			String uuid,
			OrderByComparator<FarmerSalesProposal> orderByComparator)
		throws NoSuchFarmerSalesProposalException {

		FarmerSalesProposal farmerSalesProposal = fetchByUuid_First(
			uuid, orderByComparator);

		if (farmerSalesProposal != null) {
			return farmerSalesProposal;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFarmerSalesProposalException(sb.toString());
	}

	/**
	 * Returns the first farmer sales proposal in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer sales proposal, or <code>null</code> if a matching farmer sales proposal could not be found
	 */
	@Override
	public FarmerSalesProposal fetchByUuid_First(
		String uuid, OrderByComparator<FarmerSalesProposal> orderByComparator) {

		List<FarmerSalesProposal> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last farmer sales proposal in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a matching farmer sales proposal could not be found
	 */
	@Override
	public FarmerSalesProposal findByUuid_Last(
			String uuid,
			OrderByComparator<FarmerSalesProposal> orderByComparator)
		throws NoSuchFarmerSalesProposalException {

		FarmerSalesProposal farmerSalesProposal = fetchByUuid_Last(
			uuid, orderByComparator);

		if (farmerSalesProposal != null) {
			return farmerSalesProposal;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFarmerSalesProposalException(sb.toString());
	}

	/**
	 * Returns the last farmer sales proposal in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer sales proposal, or <code>null</code> if a matching farmer sales proposal could not be found
	 */
	@Override
	public FarmerSalesProposal fetchByUuid_Last(
		String uuid, OrderByComparator<FarmerSalesProposal> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<FarmerSalesProposal> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the farmer sales proposals before and after the current farmer sales proposal in the ordered set where uuid = &#63;.
	 *
	 * @param farmerSalesProposalId the primary key of the current farmer sales proposal
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a farmer sales proposal with the primary key could not be found
	 */
	@Override
	public FarmerSalesProposal[] findByUuid_PrevAndNext(
			long farmerSalesProposalId, String uuid,
			OrderByComparator<FarmerSalesProposal> orderByComparator)
		throws NoSuchFarmerSalesProposalException {

		uuid = Objects.toString(uuid, "");

		FarmerSalesProposal farmerSalesProposal = findByPrimaryKey(
			farmerSalesProposalId);

		Session session = null;

		try {
			session = openSession();

			FarmerSalesProposal[] array = new FarmerSalesProposalImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, farmerSalesProposal, uuid, orderByComparator, true);

			array[1] = farmerSalesProposal;

			array[2] = getByUuid_PrevAndNext(
				session, farmerSalesProposal, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FarmerSalesProposal getByUuid_PrevAndNext(
		Session session, FarmerSalesProposal farmerSalesProposal, String uuid,
		OrderByComparator<FarmerSalesProposal> orderByComparator,
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

		sb.append(_SQL_SELECT_FARMERSALESPROPOSAL_WHERE);

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
			sb.append(FarmerSalesProposalModelImpl.ORDER_BY_JPQL);
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
						farmerSalesProposal)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FarmerSalesProposal> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the farmer sales proposals where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (FarmerSalesProposal farmerSalesProposal :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(farmerSalesProposal);
		}
	}

	/**
	 * Returns the number of farmer sales proposals where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching farmer sales proposals
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FARMERSALESPROPOSAL_WHERE);

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
		"farmerSalesProposal.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(farmerSalesProposal.uuid IS NULL OR farmerSalesProposal.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the farmer sales proposal where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFarmerSalesProposalException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a matching farmer sales proposal could not be found
	 */
	@Override
	public FarmerSalesProposal findByUUID_G(String uuid, long groupId)
		throws NoSuchFarmerSalesProposalException {

		FarmerSalesProposal farmerSalesProposal = fetchByUUID_G(uuid, groupId);

		if (farmerSalesProposal == null) {
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

			throw new NoSuchFarmerSalesProposalException(sb.toString());
		}

		return farmerSalesProposal;
	}

	/**
	 * Returns the farmer sales proposal where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching farmer sales proposal, or <code>null</code> if a matching farmer sales proposal could not be found
	 */
	@Override
	public FarmerSalesProposal fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the farmer sales proposal where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer sales proposal, or <code>null</code> if a matching farmer sales proposal could not be found
	 */
	@Override
	public FarmerSalesProposal fetchByUUID_G(
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

		if (result instanceof FarmerSalesProposal) {
			FarmerSalesProposal farmerSalesProposal =
				(FarmerSalesProposal)result;

			if (!Objects.equals(uuid, farmerSalesProposal.getUuid()) ||
				(groupId != farmerSalesProposal.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_FARMERSALESPROPOSAL_WHERE);

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

				List<FarmerSalesProposal> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					FarmerSalesProposal farmerSalesProposal = list.get(0);

					result = farmerSalesProposal;

					cacheResult(farmerSalesProposal);
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
			return (FarmerSalesProposal)result;
		}
	}

	/**
	 * Removes the farmer sales proposal where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the farmer sales proposal that was removed
	 */
	@Override
	public FarmerSalesProposal removeByUUID_G(String uuid, long groupId)
		throws NoSuchFarmerSalesProposalException {

		FarmerSalesProposal farmerSalesProposal = findByUUID_G(uuid, groupId);

		return remove(farmerSalesProposal);
	}

	/**
	 * Returns the number of farmer sales proposals where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching farmer sales proposals
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FARMERSALESPROPOSAL_WHERE);

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
		"farmerSalesProposal.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(farmerSalesProposal.uuid IS NULL OR farmerSalesProposal.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"farmerSalesProposal.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the farmer sales proposals where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching farmer sales proposals
	 */
	@Override
	public List<FarmerSalesProposal> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the farmer sales proposals where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerSalesProposalModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of farmer sales proposals
	 * @param end the upper bound of the range of farmer sales proposals (not inclusive)
	 * @return the range of matching farmer sales proposals
	 */
	@Override
	public List<FarmerSalesProposal> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the farmer sales proposals where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerSalesProposalModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of farmer sales proposals
	 * @param end the upper bound of the range of farmer sales proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching farmer sales proposals
	 */
	@Override
	public List<FarmerSalesProposal> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FarmerSalesProposal> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the farmer sales proposals where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerSalesProposalModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of farmer sales proposals
	 * @param end the upper bound of the range of farmer sales proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching farmer sales proposals
	 */
	@Override
	public List<FarmerSalesProposal> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FarmerSalesProposal> orderByComparator,
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

		List<FarmerSalesProposal> list = null;

		if (useFinderCache) {
			list = (List<FarmerSalesProposal>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FarmerSalesProposal farmerSalesProposal : list) {
					if (!uuid.equals(farmerSalesProposal.getUuid()) ||
						(companyId != farmerSalesProposal.getCompanyId())) {

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

			sb.append(_SQL_SELECT_FARMERSALESPROPOSAL_WHERE);

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
				sb.append(FarmerSalesProposalModelImpl.ORDER_BY_JPQL);
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

				list = (List<FarmerSalesProposal>)QueryUtil.list(
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
	 * Returns the first farmer sales proposal in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a matching farmer sales proposal could not be found
	 */
	@Override
	public FarmerSalesProposal findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FarmerSalesProposal> orderByComparator)
		throws NoSuchFarmerSalesProposalException {

		FarmerSalesProposal farmerSalesProposal = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (farmerSalesProposal != null) {
			return farmerSalesProposal;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFarmerSalesProposalException(sb.toString());
	}

	/**
	 * Returns the first farmer sales proposal in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer sales proposal, or <code>null</code> if a matching farmer sales proposal could not be found
	 */
	@Override
	public FarmerSalesProposal fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FarmerSalesProposal> orderByComparator) {

		List<FarmerSalesProposal> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last farmer sales proposal in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a matching farmer sales proposal could not be found
	 */
	@Override
	public FarmerSalesProposal findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FarmerSalesProposal> orderByComparator)
		throws NoSuchFarmerSalesProposalException {

		FarmerSalesProposal farmerSalesProposal = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (farmerSalesProposal != null) {
			return farmerSalesProposal;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFarmerSalesProposalException(sb.toString());
	}

	/**
	 * Returns the last farmer sales proposal in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer sales proposal, or <code>null</code> if a matching farmer sales proposal could not be found
	 */
	@Override
	public FarmerSalesProposal fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FarmerSalesProposal> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<FarmerSalesProposal> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the farmer sales proposals before and after the current farmer sales proposal in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param farmerSalesProposalId the primary key of the current farmer sales proposal
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a farmer sales proposal with the primary key could not be found
	 */
	@Override
	public FarmerSalesProposal[] findByUuid_C_PrevAndNext(
			long farmerSalesProposalId, String uuid, long companyId,
			OrderByComparator<FarmerSalesProposal> orderByComparator)
		throws NoSuchFarmerSalesProposalException {

		uuid = Objects.toString(uuid, "");

		FarmerSalesProposal farmerSalesProposal = findByPrimaryKey(
			farmerSalesProposalId);

		Session session = null;

		try {
			session = openSession();

			FarmerSalesProposal[] array = new FarmerSalesProposalImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, farmerSalesProposal, uuid, companyId,
				orderByComparator, true);

			array[1] = farmerSalesProposal;

			array[2] = getByUuid_C_PrevAndNext(
				session, farmerSalesProposal, uuid, companyId,
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

	protected FarmerSalesProposal getByUuid_C_PrevAndNext(
		Session session, FarmerSalesProposal farmerSalesProposal, String uuid,
		long companyId,
		OrderByComparator<FarmerSalesProposal> orderByComparator,
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

		sb.append(_SQL_SELECT_FARMERSALESPROPOSAL_WHERE);

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
			sb.append(FarmerSalesProposalModelImpl.ORDER_BY_JPQL);
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
						farmerSalesProposal)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FarmerSalesProposal> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the farmer sales proposals where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (FarmerSalesProposal farmerSalesProposal :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(farmerSalesProposal);
		}
	}

	/**
	 * Returns the number of farmer sales proposals where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching farmer sales proposals
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FARMERSALESPROPOSAL_WHERE);

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
		"farmerSalesProposal.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(farmerSalesProposal.uuid IS NULL OR farmerSalesProposal.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"farmerSalesProposal.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByBusinessCode;
	private FinderPath _finderPathWithoutPaginationFindByBusinessCode;
	private FinderPath _finderPathCountByBusinessCode;

	/**
	 * Returns all the farmer sales proposals where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @return the matching farmer sales proposals
	 */
	@Override
	public List<FarmerSalesProposal> findByBusinessCode(String businessCode) {
		return findByBusinessCode(
			businessCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the farmer sales proposals where businessCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerSalesProposalModelImpl</code>.
	 * </p>
	 *
	 * @param businessCode the business code
	 * @param start the lower bound of the range of farmer sales proposals
	 * @param end the upper bound of the range of farmer sales proposals (not inclusive)
	 * @return the range of matching farmer sales proposals
	 */
	@Override
	public List<FarmerSalesProposal> findByBusinessCode(
		String businessCode, int start, int end) {

		return findByBusinessCode(businessCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the farmer sales proposals where businessCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerSalesProposalModelImpl</code>.
	 * </p>
	 *
	 * @param businessCode the business code
	 * @param start the lower bound of the range of farmer sales proposals
	 * @param end the upper bound of the range of farmer sales proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching farmer sales proposals
	 */
	@Override
	public List<FarmerSalesProposal> findByBusinessCode(
		String businessCode, int start, int end,
		OrderByComparator<FarmerSalesProposal> orderByComparator) {

		return findByBusinessCode(
			businessCode, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the farmer sales proposals where businessCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerSalesProposalModelImpl</code>.
	 * </p>
	 *
	 * @param businessCode the business code
	 * @param start the lower bound of the range of farmer sales proposals
	 * @param end the upper bound of the range of farmer sales proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching farmer sales proposals
	 */
	@Override
	public List<FarmerSalesProposal> findByBusinessCode(
		String businessCode, int start, int end,
		OrderByComparator<FarmerSalesProposal> orderByComparator,
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

		List<FarmerSalesProposal> list = null;

		if (useFinderCache) {
			list = (List<FarmerSalesProposal>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FarmerSalesProposal farmerSalesProposal : list) {
					if (!businessCode.equals(
							farmerSalesProposal.getBusinessCode())) {

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

			sb.append(_SQL_SELECT_FARMERSALESPROPOSAL_WHERE);

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
				sb.append(FarmerSalesProposalModelImpl.ORDER_BY_JPQL);
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

				list = (List<FarmerSalesProposal>)QueryUtil.list(
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
	 * Returns the first farmer sales proposal in the ordered set where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a matching farmer sales proposal could not be found
	 */
	@Override
	public FarmerSalesProposal findByBusinessCode_First(
			String businessCode,
			OrderByComparator<FarmerSalesProposal> orderByComparator)
		throws NoSuchFarmerSalesProposalException {

		FarmerSalesProposal farmerSalesProposal = fetchByBusinessCode_First(
			businessCode, orderByComparator);

		if (farmerSalesProposal != null) {
			return farmerSalesProposal;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessCode=");
		sb.append(businessCode);

		sb.append("}");

		throw new NoSuchFarmerSalesProposalException(sb.toString());
	}

	/**
	 * Returns the first farmer sales proposal in the ordered set where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching farmer sales proposal, or <code>null</code> if a matching farmer sales proposal could not be found
	 */
	@Override
	public FarmerSalesProposal fetchByBusinessCode_First(
		String businessCode,
		OrderByComparator<FarmerSalesProposal> orderByComparator) {

		List<FarmerSalesProposal> list = findByBusinessCode(
			businessCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last farmer sales proposal in the ordered set where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a matching farmer sales proposal could not be found
	 */
	@Override
	public FarmerSalesProposal findByBusinessCode_Last(
			String businessCode,
			OrderByComparator<FarmerSalesProposal> orderByComparator)
		throws NoSuchFarmerSalesProposalException {

		FarmerSalesProposal farmerSalesProposal = fetchByBusinessCode_Last(
			businessCode, orderByComparator);

		if (farmerSalesProposal != null) {
			return farmerSalesProposal;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessCode=");
		sb.append(businessCode);

		sb.append("}");

		throw new NoSuchFarmerSalesProposalException(sb.toString());
	}

	/**
	 * Returns the last farmer sales proposal in the ordered set where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching farmer sales proposal, or <code>null</code> if a matching farmer sales proposal could not be found
	 */
	@Override
	public FarmerSalesProposal fetchByBusinessCode_Last(
		String businessCode,
		OrderByComparator<FarmerSalesProposal> orderByComparator) {

		int count = countByBusinessCode(businessCode);

		if (count == 0) {
			return null;
		}

		List<FarmerSalesProposal> list = findByBusinessCode(
			businessCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the farmer sales proposals before and after the current farmer sales proposal in the ordered set where businessCode = &#63;.
	 *
	 * @param farmerSalesProposalId the primary key of the current farmer sales proposal
	 * @param businessCode the business code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a farmer sales proposal with the primary key could not be found
	 */
	@Override
	public FarmerSalesProposal[] findByBusinessCode_PrevAndNext(
			long farmerSalesProposalId, String businessCode,
			OrderByComparator<FarmerSalesProposal> orderByComparator)
		throws NoSuchFarmerSalesProposalException {

		businessCode = Objects.toString(businessCode, "");

		FarmerSalesProposal farmerSalesProposal = findByPrimaryKey(
			farmerSalesProposalId);

		Session session = null;

		try {
			session = openSession();

			FarmerSalesProposal[] array = new FarmerSalesProposalImpl[3];

			array[0] = getByBusinessCode_PrevAndNext(
				session, farmerSalesProposal, businessCode, orderByComparator,
				true);

			array[1] = farmerSalesProposal;

			array[2] = getByBusinessCode_PrevAndNext(
				session, farmerSalesProposal, businessCode, orderByComparator,
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

	protected FarmerSalesProposal getByBusinessCode_PrevAndNext(
		Session session, FarmerSalesProposal farmerSalesProposal,
		String businessCode,
		OrderByComparator<FarmerSalesProposal> orderByComparator,
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

		sb.append(_SQL_SELECT_FARMERSALESPROPOSAL_WHERE);

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
			sb.append(FarmerSalesProposalModelImpl.ORDER_BY_JPQL);
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
						farmerSalesProposal)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FarmerSalesProposal> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the farmer sales proposals where businessCode = &#63; from the database.
	 *
	 * @param businessCode the business code
	 */
	@Override
	public void removeByBusinessCode(String businessCode) {
		for (FarmerSalesProposal farmerSalesProposal :
				findByBusinessCode(
					businessCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(farmerSalesProposal);
		}
	}

	/**
	 * Returns the number of farmer sales proposals where businessCode = &#63;.
	 *
	 * @param businessCode the business code
	 * @return the number of matching farmer sales proposals
	 */
	@Override
	public int countByBusinessCode(String businessCode) {
		businessCode = Objects.toString(businessCode, "");

		FinderPath finderPath = _finderPathCountByBusinessCode;

		Object[] finderArgs = new Object[] {businessCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FARMERSALESPROPOSAL_WHERE);

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
		"farmerSalesProposal.businessCode = ?";

	private static final String _FINDER_COLUMN_BUSINESSCODE_BUSINESSCODE_3 =
		"(farmerSalesProposal.businessCode IS NULL OR farmerSalesProposal.businessCode = '')";

	private FinderPath _finderPathFetchByApplicationNumber;
	private FinderPath _finderPathCountByApplicationNumber;

	/**
	 * Returns the farmer sales proposal where applicationNumber = &#63; or throws a <code>NoSuchFarmerSalesProposalException</code> if it could not be found.
	 *
	 * @param applicationNumber the application number
	 * @return the matching farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a matching farmer sales proposal could not be found
	 */
	@Override
	public FarmerSalesProposal findByApplicationNumber(String applicationNumber)
		throws NoSuchFarmerSalesProposalException {

		FarmerSalesProposal farmerSalesProposal = fetchByApplicationNumber(
			applicationNumber);

		if (farmerSalesProposal == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("applicationNumber=");
			sb.append(applicationNumber);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFarmerSalesProposalException(sb.toString());
		}

		return farmerSalesProposal;
	}

	/**
	 * Returns the farmer sales proposal where applicationNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @return the matching farmer sales proposal, or <code>null</code> if a matching farmer sales proposal could not be found
	 */
	@Override
	public FarmerSalesProposal fetchByApplicationNumber(
		String applicationNumber) {

		return fetchByApplicationNumber(applicationNumber, true);
	}

	/**
	 * Returns the farmer sales proposal where applicationNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching farmer sales proposal, or <code>null</code> if a matching farmer sales proposal could not be found
	 */
	@Override
	public FarmerSalesProposal fetchByApplicationNumber(
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

		if (result instanceof FarmerSalesProposal) {
			FarmerSalesProposal farmerSalesProposal =
				(FarmerSalesProposal)result;

			if (!Objects.equals(
					applicationNumber,
					farmerSalesProposal.getApplicationNumber())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_FARMERSALESPROPOSAL_WHERE);

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

				List<FarmerSalesProposal> list = query.list();

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
								"FarmerSalesProposalPersistenceImpl.fetchByApplicationNumber(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					FarmerSalesProposal farmerSalesProposal = list.get(0);

					result = farmerSalesProposal;

					cacheResult(farmerSalesProposal);
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
			return (FarmerSalesProposal)result;
		}
	}

	/**
	 * Removes the farmer sales proposal where applicationNumber = &#63; from the database.
	 *
	 * @param applicationNumber the application number
	 * @return the farmer sales proposal that was removed
	 */
	@Override
	public FarmerSalesProposal removeByApplicationNumber(
			String applicationNumber)
		throws NoSuchFarmerSalesProposalException {

		FarmerSalesProposal farmerSalesProposal = findByApplicationNumber(
			applicationNumber);

		return remove(farmerSalesProposal);
	}

	/**
	 * Returns the number of farmer sales proposals where applicationNumber = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @return the number of matching farmer sales proposals
	 */
	@Override
	public int countByApplicationNumber(String applicationNumber) {
		applicationNumber = Objects.toString(applicationNumber, "");

		FinderPath finderPath = _finderPathCountByApplicationNumber;

		Object[] finderArgs = new Object[] {applicationNumber};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FARMERSALESPROPOSAL_WHERE);

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
			"farmerSalesProposal.applicationNumber = ?";

	private static final String
		_FINDER_COLUMN_APPLICATIONNUMBER_APPLICATIONNUMBER_3 =
			"(farmerSalesProposal.applicationNumber IS NULL OR farmerSalesProposal.applicationNumber = '')";

	public FarmerSalesProposalPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(FarmerSalesProposal.class);

		setModelImplClass(FarmerSalesProposalImpl.class);
		setModelPKClass(long.class);

		setTable(FarmerSalesProposalTable.INSTANCE);
	}

	/**
	 * Caches the farmer sales proposal in the entity cache if it is enabled.
	 *
	 * @param farmerSalesProposal the farmer sales proposal
	 */
	@Override
	public void cacheResult(FarmerSalesProposal farmerSalesProposal) {
		entityCache.putResult(
			FarmerSalesProposalImpl.class, farmerSalesProposal.getPrimaryKey(),
			farmerSalesProposal);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				farmerSalesProposal.getUuid(), farmerSalesProposal.getGroupId()
			},
			farmerSalesProposal);

		finderCache.putResult(
			_finderPathFetchByApplicationNumber,
			new Object[] {farmerSalesProposal.getApplicationNumber()},
			farmerSalesProposal);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the farmer sales proposals in the entity cache if it is enabled.
	 *
	 * @param farmerSalesProposals the farmer sales proposals
	 */
	@Override
	public void cacheResult(List<FarmerSalesProposal> farmerSalesProposals) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (farmerSalesProposals.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FarmerSalesProposal farmerSalesProposal : farmerSalesProposals) {
			if (entityCache.getResult(
					FarmerSalesProposalImpl.class,
					farmerSalesProposal.getPrimaryKey()) == null) {

				cacheResult(farmerSalesProposal);
			}
		}
	}

	/**
	 * Clears the cache for all farmer sales proposals.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FarmerSalesProposalImpl.class);

		finderCache.clearCache(FarmerSalesProposalImpl.class);
	}

	/**
	 * Clears the cache for the farmer sales proposal.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FarmerSalesProposal farmerSalesProposal) {
		entityCache.removeResult(
			FarmerSalesProposalImpl.class, farmerSalesProposal);
	}

	@Override
	public void clearCache(List<FarmerSalesProposal> farmerSalesProposals) {
		for (FarmerSalesProposal farmerSalesProposal : farmerSalesProposals) {
			entityCache.removeResult(
				FarmerSalesProposalImpl.class, farmerSalesProposal);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FarmerSalesProposalImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FarmerSalesProposalImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		FarmerSalesProposalModelImpl farmerSalesProposalModelImpl) {

		Object[] args = new Object[] {
			farmerSalesProposalModelImpl.getUuid(),
			farmerSalesProposalModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, farmerSalesProposalModelImpl);

		args = new Object[] {
			farmerSalesProposalModelImpl.getApplicationNumber()
		};

		finderCache.putResult(
			_finderPathCountByApplicationNumber, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByApplicationNumber, args,
			farmerSalesProposalModelImpl);
	}

	/**
	 * Creates a new farmer sales proposal with the primary key. Does not add the farmer sales proposal to the database.
	 *
	 * @param farmerSalesProposalId the primary key for the new farmer sales proposal
	 * @return the new farmer sales proposal
	 */
	@Override
	public FarmerSalesProposal create(long farmerSalesProposalId) {
		FarmerSalesProposal farmerSalesProposal = new FarmerSalesProposalImpl();

		farmerSalesProposal.setNew(true);
		farmerSalesProposal.setPrimaryKey(farmerSalesProposalId);

		String uuid = _portalUUID.generate();

		farmerSalesProposal.setUuid(uuid);

		farmerSalesProposal.setCompanyId(CompanyThreadLocal.getCompanyId());

		return farmerSalesProposal;
	}

	/**
	 * Removes the farmer sales proposal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param farmerSalesProposalId the primary key of the farmer sales proposal
	 * @return the farmer sales proposal that was removed
	 * @throws NoSuchFarmerSalesProposalException if a farmer sales proposal with the primary key could not be found
	 */
	@Override
	public FarmerSalesProposal remove(long farmerSalesProposalId)
		throws NoSuchFarmerSalesProposalException {

		return remove((Serializable)farmerSalesProposalId);
	}

	/**
	 * Removes the farmer sales proposal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the farmer sales proposal
	 * @return the farmer sales proposal that was removed
	 * @throws NoSuchFarmerSalesProposalException if a farmer sales proposal with the primary key could not be found
	 */
	@Override
	public FarmerSalesProposal remove(Serializable primaryKey)
		throws NoSuchFarmerSalesProposalException {

		Session session = null;

		try {
			session = openSession();

			FarmerSalesProposal farmerSalesProposal =
				(FarmerSalesProposal)session.get(
					FarmerSalesProposalImpl.class, primaryKey);

			if (farmerSalesProposal == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFarmerSalesProposalException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(farmerSalesProposal);
		}
		catch (NoSuchFarmerSalesProposalException noSuchEntityException) {
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
	protected FarmerSalesProposal removeImpl(
		FarmerSalesProposal farmerSalesProposal) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(farmerSalesProposal)) {
				farmerSalesProposal = (FarmerSalesProposal)session.get(
					FarmerSalesProposalImpl.class,
					farmerSalesProposal.getPrimaryKeyObj());
			}

			if (farmerSalesProposal != null) {
				session.delete(farmerSalesProposal);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (farmerSalesProposal != null) {
			clearCache(farmerSalesProposal);
		}

		return farmerSalesProposal;
	}

	@Override
	public FarmerSalesProposal updateImpl(
		FarmerSalesProposal farmerSalesProposal) {

		boolean isNew = farmerSalesProposal.isNew();

		if (!(farmerSalesProposal instanceof FarmerSalesProposalModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(farmerSalesProposal.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					farmerSalesProposal);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in farmerSalesProposal proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FarmerSalesProposal implementation " +
					farmerSalesProposal.getClass());
		}

		FarmerSalesProposalModelImpl farmerSalesProposalModelImpl =
			(FarmerSalesProposalModelImpl)farmerSalesProposal;

		if (Validator.isNull(farmerSalesProposal.getUuid())) {
			String uuid = _portalUUID.generate();

			farmerSalesProposal.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (farmerSalesProposal.getCreateDate() == null)) {
			if (serviceContext == null) {
				farmerSalesProposal.setCreateDate(date);
			}
			else {
				farmerSalesProposal.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!farmerSalesProposalModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				farmerSalesProposal.setModifiedDate(date);
			}
			else {
				farmerSalesProposal.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(farmerSalesProposal);
			}
			else {
				farmerSalesProposal = (FarmerSalesProposal)session.merge(
					farmerSalesProposal);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FarmerSalesProposalImpl.class, farmerSalesProposalModelImpl, false,
			true);

		cacheUniqueFindersCache(farmerSalesProposalModelImpl);

		if (isNew) {
			farmerSalesProposal.setNew(false);
		}

		farmerSalesProposal.resetOriginalValues();

		return farmerSalesProposal;
	}

	/**
	 * Returns the farmer sales proposal with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the farmer sales proposal
	 * @return the farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a farmer sales proposal with the primary key could not be found
	 */
	@Override
	public FarmerSalesProposal findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFarmerSalesProposalException {

		FarmerSalesProposal farmerSalesProposal = fetchByPrimaryKey(primaryKey);

		if (farmerSalesProposal == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFarmerSalesProposalException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return farmerSalesProposal;
	}

	/**
	 * Returns the farmer sales proposal with the primary key or throws a <code>NoSuchFarmerSalesProposalException</code> if it could not be found.
	 *
	 * @param farmerSalesProposalId the primary key of the farmer sales proposal
	 * @return the farmer sales proposal
	 * @throws NoSuchFarmerSalesProposalException if a farmer sales proposal with the primary key could not be found
	 */
	@Override
	public FarmerSalesProposal findByPrimaryKey(long farmerSalesProposalId)
		throws NoSuchFarmerSalesProposalException {

		return findByPrimaryKey((Serializable)farmerSalesProposalId);
	}

	/**
	 * Returns the farmer sales proposal with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param farmerSalesProposalId the primary key of the farmer sales proposal
	 * @return the farmer sales proposal, or <code>null</code> if a farmer sales proposal with the primary key could not be found
	 */
	@Override
	public FarmerSalesProposal fetchByPrimaryKey(long farmerSalesProposalId) {
		return fetchByPrimaryKey((Serializable)farmerSalesProposalId);
	}

	/**
	 * Returns all the farmer sales proposals.
	 *
	 * @return the farmer sales proposals
	 */
	@Override
	public List<FarmerSalesProposal> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the farmer sales proposals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerSalesProposalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of farmer sales proposals
	 * @param end the upper bound of the range of farmer sales proposals (not inclusive)
	 * @return the range of farmer sales proposals
	 */
	@Override
	public List<FarmerSalesProposal> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the farmer sales proposals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerSalesProposalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of farmer sales proposals
	 * @param end the upper bound of the range of farmer sales proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of farmer sales proposals
	 */
	@Override
	public List<FarmerSalesProposal> findAll(
		int start, int end,
		OrderByComparator<FarmerSalesProposal> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the farmer sales proposals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FarmerSalesProposalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of farmer sales proposals
	 * @param end the upper bound of the range of farmer sales proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of farmer sales proposals
	 */
	@Override
	public List<FarmerSalesProposal> findAll(
		int start, int end,
		OrderByComparator<FarmerSalesProposal> orderByComparator,
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

		List<FarmerSalesProposal> list = null;

		if (useFinderCache) {
			list = (List<FarmerSalesProposal>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FARMERSALESPROPOSAL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FARMERSALESPROPOSAL;

				sql = sql.concat(FarmerSalesProposalModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FarmerSalesProposal>)QueryUtil.list(
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
	 * Removes all the farmer sales proposals from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FarmerSalesProposal farmerSalesProposal : findAll()) {
			remove(farmerSalesProposal);
		}
	}

	/**
	 * Returns the number of farmer sales proposals.
	 *
	 * @return the number of farmer sales proposals
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
					_SQL_COUNT_FARMERSALESPROPOSAL);

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
		return "farmerSalesProposalId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FARMERSALESPROPOSAL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FarmerSalesProposalModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the farmer sales proposal persistence.
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

		_finderPathFetchByApplicationNumber = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByApplicationNumber",
			new String[] {String.class.getName()},
			new String[] {"applicationNumber"}, true);

		_finderPathCountByApplicationNumber = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByApplicationNumber", new String[] {String.class.getName()},
			new String[] {"applicationNumber"}, false);

		_setFarmerSalesProposalUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setFarmerSalesProposalUtilPersistence(null);

		entityCache.removeCache(FarmerSalesProposalImpl.class.getName());
	}

	private void _setFarmerSalesProposalUtilPersistence(
		FarmerSalesProposalPersistence farmerSalesProposalPersistence) {

		try {
			Field field = FarmerSalesProposalUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, farmerSalesProposalPersistence);
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

	private static final String _SQL_SELECT_FARMERSALESPROPOSAL =
		"SELECT farmerSalesProposal FROM FarmerSalesProposal farmerSalesProposal";

	private static final String _SQL_SELECT_FARMERSALESPROPOSAL_WHERE =
		"SELECT farmerSalesProposal FROM FarmerSalesProposal farmerSalesProposal WHERE ";

	private static final String _SQL_COUNT_FARMERSALESPROPOSAL =
		"SELECT COUNT(farmerSalesProposal) FROM FarmerSalesProposal farmerSalesProposal";

	private static final String _SQL_COUNT_FARMERSALESPROPOSAL_WHERE =
		"SELECT COUNT(farmerSalesProposal) FROM FarmerSalesProposal farmerSalesProposal WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "farmerSalesProposal.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FarmerSalesProposal exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FarmerSalesProposal exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FarmerSalesProposalPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private FarmerSalesProposalModelArgumentsResolver
		_farmerSalesProposalModelArgumentsResolver;

}