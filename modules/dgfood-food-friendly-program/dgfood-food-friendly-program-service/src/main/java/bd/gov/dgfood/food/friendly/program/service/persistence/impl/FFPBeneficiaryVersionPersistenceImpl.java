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

import bd.gov.dgfood.food.friendly.program.exception.NoSuchFFPBeneficiaryVersionException;
import bd.gov.dgfood.food.friendly.program.model.FFPBeneficiaryVersion;
import bd.gov.dgfood.food.friendly.program.model.FFPBeneficiaryVersionTable;
import bd.gov.dgfood.food.friendly.program.model.impl.FFPBeneficiaryVersionImpl;
import bd.gov.dgfood.food.friendly.program.model.impl.FFPBeneficiaryVersionModelImpl;
import bd.gov.dgfood.food.friendly.program.service.persistence.FFPBeneficiaryVersionPersistence;
import bd.gov.dgfood.food.friendly.program.service.persistence.FFPBeneficiaryVersionUtil;
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
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the ffp beneficiary version service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {FFPBeneficiaryVersionPersistence.class, BasePersistence.class}
)
public class FFPBeneficiaryVersionPersistenceImpl
	extends BasePersistenceImpl<FFPBeneficiaryVersion>
	implements FFPBeneficiaryVersionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FFPBeneficiaryVersionUtil</code> to access the ffp beneficiary version persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FFPBeneficiaryVersionImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByBeneficiaryId;
	private FinderPath _finderPathWithoutPaginationFindByBeneficiaryId;
	private FinderPath _finderPathCountByBeneficiaryId;

	/**
	 * Returns all the ffp beneficiary versions where beneficiaryId = &#63;.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @return the matching ffp beneficiary versions
	 */
	@Override
	public List<FFPBeneficiaryVersion> findByBeneficiaryId(long beneficiaryId) {
		return findByBeneficiaryId(
			beneficiaryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ffp beneficiary versions where beneficiaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param start the lower bound of the range of ffp beneficiary versions
	 * @param end the upper bound of the range of ffp beneficiary versions (not inclusive)
	 * @return the range of matching ffp beneficiary versions
	 */
	@Override
	public List<FFPBeneficiaryVersion> findByBeneficiaryId(
		long beneficiaryId, int start, int end) {

		return findByBeneficiaryId(beneficiaryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ffp beneficiary versions where beneficiaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param start the lower bound of the range of ffp beneficiary versions
	 * @param end the upper bound of the range of ffp beneficiary versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ffp beneficiary versions
	 */
	@Override
	public List<FFPBeneficiaryVersion> findByBeneficiaryId(
		long beneficiaryId, int start, int end,
		OrderByComparator<FFPBeneficiaryVersion> orderByComparator) {

		return findByBeneficiaryId(
			beneficiaryId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ffp beneficiary versions where beneficiaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param start the lower bound of the range of ffp beneficiary versions
	 * @param end the upper bound of the range of ffp beneficiary versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ffp beneficiary versions
	 */
	@Override
	public List<FFPBeneficiaryVersion> findByBeneficiaryId(
		long beneficiaryId, int start, int end,
		OrderByComparator<FFPBeneficiaryVersion> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByBeneficiaryId;
				finderArgs = new Object[] {beneficiaryId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByBeneficiaryId;
			finderArgs = new Object[] {
				beneficiaryId, start, end, orderByComparator
			};
		}

		List<FFPBeneficiaryVersion> list = null;

		if (useFinderCache) {
			list = (List<FFPBeneficiaryVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FFPBeneficiaryVersion ffpBeneficiaryVersion : list) {
					if (beneficiaryId !=
							ffpBeneficiaryVersion.getBeneficiaryId()) {

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

			sb.append(_SQL_SELECT_FFPBENEFICIARYVERSION_WHERE);

			sb.append(_FINDER_COLUMN_BENEFICIARYID_BENEFICIARYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FFPBeneficiaryVersionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(beneficiaryId);

				list = (List<FFPBeneficiaryVersion>)QueryUtil.list(
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
	 * Returns the first ffp beneficiary version in the ordered set where beneficiaryId = &#63;.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ffp beneficiary version
	 * @throws NoSuchFFPBeneficiaryVersionException if a matching ffp beneficiary version could not be found
	 */
	@Override
	public FFPBeneficiaryVersion findByBeneficiaryId_First(
			long beneficiaryId,
			OrderByComparator<FFPBeneficiaryVersion> orderByComparator)
		throws NoSuchFFPBeneficiaryVersionException {

		FFPBeneficiaryVersion ffpBeneficiaryVersion =
			fetchByBeneficiaryId_First(beneficiaryId, orderByComparator);

		if (ffpBeneficiaryVersion != null) {
			return ffpBeneficiaryVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("beneficiaryId=");
		sb.append(beneficiaryId);

		sb.append("}");

		throw new NoSuchFFPBeneficiaryVersionException(sb.toString());
	}

	/**
	 * Returns the first ffp beneficiary version in the ordered set where beneficiaryId = &#63;.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ffp beneficiary version, or <code>null</code> if a matching ffp beneficiary version could not be found
	 */
	@Override
	public FFPBeneficiaryVersion fetchByBeneficiaryId_First(
		long beneficiaryId,
		OrderByComparator<FFPBeneficiaryVersion> orderByComparator) {

		List<FFPBeneficiaryVersion> list = findByBeneficiaryId(
			beneficiaryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ffp beneficiary version in the ordered set where beneficiaryId = &#63;.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ffp beneficiary version
	 * @throws NoSuchFFPBeneficiaryVersionException if a matching ffp beneficiary version could not be found
	 */
	@Override
	public FFPBeneficiaryVersion findByBeneficiaryId_Last(
			long beneficiaryId,
			OrderByComparator<FFPBeneficiaryVersion> orderByComparator)
		throws NoSuchFFPBeneficiaryVersionException {

		FFPBeneficiaryVersion ffpBeneficiaryVersion = fetchByBeneficiaryId_Last(
			beneficiaryId, orderByComparator);

		if (ffpBeneficiaryVersion != null) {
			return ffpBeneficiaryVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("beneficiaryId=");
		sb.append(beneficiaryId);

		sb.append("}");

		throw new NoSuchFFPBeneficiaryVersionException(sb.toString());
	}

	/**
	 * Returns the last ffp beneficiary version in the ordered set where beneficiaryId = &#63;.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ffp beneficiary version, or <code>null</code> if a matching ffp beneficiary version could not be found
	 */
	@Override
	public FFPBeneficiaryVersion fetchByBeneficiaryId_Last(
		long beneficiaryId,
		OrderByComparator<FFPBeneficiaryVersion> orderByComparator) {

		int count = countByBeneficiaryId(beneficiaryId);

		if (count == 0) {
			return null;
		}

		List<FFPBeneficiaryVersion> list = findByBeneficiaryId(
			beneficiaryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ffp beneficiary versions before and after the current ffp beneficiary version in the ordered set where beneficiaryId = &#63;.
	 *
	 * @param beneficiaryVersionId the primary key of the current ffp beneficiary version
	 * @param beneficiaryId the beneficiary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ffp beneficiary version
	 * @throws NoSuchFFPBeneficiaryVersionException if a ffp beneficiary version with the primary key could not be found
	 */
	@Override
	public FFPBeneficiaryVersion[] findByBeneficiaryId_PrevAndNext(
			long beneficiaryVersionId, long beneficiaryId,
			OrderByComparator<FFPBeneficiaryVersion> orderByComparator)
		throws NoSuchFFPBeneficiaryVersionException {

		FFPBeneficiaryVersion ffpBeneficiaryVersion = findByPrimaryKey(
			beneficiaryVersionId);

		Session session = null;

		try {
			session = openSession();

			FFPBeneficiaryVersion[] array = new FFPBeneficiaryVersionImpl[3];

			array[0] = getByBeneficiaryId_PrevAndNext(
				session, ffpBeneficiaryVersion, beneficiaryId,
				orderByComparator, true);

			array[1] = ffpBeneficiaryVersion;

			array[2] = getByBeneficiaryId_PrevAndNext(
				session, ffpBeneficiaryVersion, beneficiaryId,
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

	protected FFPBeneficiaryVersion getByBeneficiaryId_PrevAndNext(
		Session session, FFPBeneficiaryVersion ffpBeneficiaryVersion,
		long beneficiaryId,
		OrderByComparator<FFPBeneficiaryVersion> orderByComparator,
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

		sb.append(_SQL_SELECT_FFPBENEFICIARYVERSION_WHERE);

		sb.append(_FINDER_COLUMN_BENEFICIARYID_BENEFICIARYID_2);

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
			sb.append(FFPBeneficiaryVersionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(beneficiaryId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						ffpBeneficiaryVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FFPBeneficiaryVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ffp beneficiary versions where beneficiaryId = &#63; from the database.
	 *
	 * @param beneficiaryId the beneficiary ID
	 */
	@Override
	public void removeByBeneficiaryId(long beneficiaryId) {
		for (FFPBeneficiaryVersion ffpBeneficiaryVersion :
				findByBeneficiaryId(
					beneficiaryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(ffpBeneficiaryVersion);
		}
	}

	/**
	 * Returns the number of ffp beneficiary versions where beneficiaryId = &#63;.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @return the number of matching ffp beneficiary versions
	 */
	@Override
	public int countByBeneficiaryId(long beneficiaryId) {
		FinderPath finderPath = _finderPathCountByBeneficiaryId;

		Object[] finderArgs = new Object[] {beneficiaryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FFPBENEFICIARYVERSION_WHERE);

			sb.append(_FINDER_COLUMN_BENEFICIARYID_BENEFICIARYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(beneficiaryId);

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

	private static final String _FINDER_COLUMN_BENEFICIARYID_BENEFICIARYID_2 =
		"ffpBeneficiaryVersion.beneficiaryId = ?";

	private FinderPath _finderPathFetchById_Version;
	private FinderPath _finderPathCountById_Version;

	/**
	 * Returns the ffp beneficiary version where beneficiaryId = &#63; and version = &#63; or throws a <code>NoSuchFFPBeneficiaryVersionException</code> if it could not be found.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param version the version
	 * @return the matching ffp beneficiary version
	 * @throws NoSuchFFPBeneficiaryVersionException if a matching ffp beneficiary version could not be found
	 */
	@Override
	public FFPBeneficiaryVersion findById_Version(
			long beneficiaryId, double version)
		throws NoSuchFFPBeneficiaryVersionException {

		FFPBeneficiaryVersion ffpBeneficiaryVersion = fetchById_Version(
			beneficiaryId, version);

		if (ffpBeneficiaryVersion == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("beneficiaryId=");
			sb.append(beneficiaryId);

			sb.append(", version=");
			sb.append(version);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFFPBeneficiaryVersionException(sb.toString());
		}

		return ffpBeneficiaryVersion;
	}

	/**
	 * Returns the ffp beneficiary version where beneficiaryId = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param version the version
	 * @return the matching ffp beneficiary version, or <code>null</code> if a matching ffp beneficiary version could not be found
	 */
	@Override
	public FFPBeneficiaryVersion fetchById_Version(
		long beneficiaryId, double version) {

		return fetchById_Version(beneficiaryId, version, true);
	}

	/**
	 * Returns the ffp beneficiary version where beneficiaryId = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param version the version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ffp beneficiary version, or <code>null</code> if a matching ffp beneficiary version could not be found
	 */
	@Override
	public FFPBeneficiaryVersion fetchById_Version(
		long beneficiaryId, double version, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {beneficiaryId, version};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchById_Version, finderArgs);
		}

		if (result instanceof FFPBeneficiaryVersion) {
			FFPBeneficiaryVersion ffpBeneficiaryVersion =
				(FFPBeneficiaryVersion)result;

			if ((beneficiaryId != ffpBeneficiaryVersion.getBeneficiaryId()) ||
				(version != ffpBeneficiaryVersion.getVersion())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_FFPBENEFICIARYVERSION_WHERE);

			sb.append(_FINDER_COLUMN_ID_VERSION_BENEFICIARYID_2);

			sb.append(_FINDER_COLUMN_ID_VERSION_VERSION_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(beneficiaryId);

				queryPos.add(version);

				List<FFPBeneficiaryVersion> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchById_Version, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									beneficiaryId, version
								};
							}

							_log.warn(
								"FFPBeneficiaryVersionPersistenceImpl.fetchById_Version(long, double, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					FFPBeneficiaryVersion ffpBeneficiaryVersion = list.get(0);

					result = ffpBeneficiaryVersion;

					cacheResult(ffpBeneficiaryVersion);
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
			return (FFPBeneficiaryVersion)result;
		}
	}

	/**
	 * Removes the ffp beneficiary version where beneficiaryId = &#63; and version = &#63; from the database.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param version the version
	 * @return the ffp beneficiary version that was removed
	 */
	@Override
	public FFPBeneficiaryVersion removeById_Version(
			long beneficiaryId, double version)
		throws NoSuchFFPBeneficiaryVersionException {

		FFPBeneficiaryVersion ffpBeneficiaryVersion = findById_Version(
			beneficiaryId, version);

		return remove(ffpBeneficiaryVersion);
	}

	/**
	 * Returns the number of ffp beneficiary versions where beneficiaryId = &#63; and version = &#63;.
	 *
	 * @param beneficiaryId the beneficiary ID
	 * @param version the version
	 * @return the number of matching ffp beneficiary versions
	 */
	@Override
	public int countById_Version(long beneficiaryId, double version) {
		FinderPath finderPath = _finderPathCountById_Version;

		Object[] finderArgs = new Object[] {beneficiaryId, version};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FFPBENEFICIARYVERSION_WHERE);

			sb.append(_FINDER_COLUMN_ID_VERSION_BENEFICIARYID_2);

			sb.append(_FINDER_COLUMN_ID_VERSION_VERSION_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(beneficiaryId);

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

	private static final String _FINDER_COLUMN_ID_VERSION_BENEFICIARYID_2 =
		"ffpBeneficiaryVersion.beneficiaryId = ? AND ";

	private static final String _FINDER_COLUMN_ID_VERSION_VERSION_2 =
		"ffpBeneficiaryVersion.version = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the ffp beneficiary versions where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching ffp beneficiary versions
	 */
	@Override
	public List<FFPBeneficiaryVersion> findByStatus(int status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ffp beneficiary versions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of ffp beneficiary versions
	 * @param end the upper bound of the range of ffp beneficiary versions (not inclusive)
	 * @return the range of matching ffp beneficiary versions
	 */
	@Override
	public List<FFPBeneficiaryVersion> findByStatus(
		int status, int start, int end) {

		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ffp beneficiary versions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of ffp beneficiary versions
	 * @param end the upper bound of the range of ffp beneficiary versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ffp beneficiary versions
	 */
	@Override
	public List<FFPBeneficiaryVersion> findByStatus(
		int status, int start, int end,
		OrderByComparator<FFPBeneficiaryVersion> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ffp beneficiary versions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of ffp beneficiary versions
	 * @param end the upper bound of the range of ffp beneficiary versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ffp beneficiary versions
	 */
	@Override
	public List<FFPBeneficiaryVersion> findByStatus(
		int status, int start, int end,
		OrderByComparator<FFPBeneficiaryVersion> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatus;
				finderArgs = new Object[] {status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatus;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<FFPBeneficiaryVersion> list = null;

		if (useFinderCache) {
			list = (List<FFPBeneficiaryVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FFPBeneficiaryVersion ffpBeneficiaryVersion : list) {
					if (status != ffpBeneficiaryVersion.getStatus()) {
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

			sb.append(_SQL_SELECT_FFPBENEFICIARYVERSION_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FFPBeneficiaryVersionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<FFPBeneficiaryVersion>)QueryUtil.list(
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
	 * Returns the first ffp beneficiary version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ffp beneficiary version
	 * @throws NoSuchFFPBeneficiaryVersionException if a matching ffp beneficiary version could not be found
	 */
	@Override
	public FFPBeneficiaryVersion findByStatus_First(
			int status,
			OrderByComparator<FFPBeneficiaryVersion> orderByComparator)
		throws NoSuchFFPBeneficiaryVersionException {

		FFPBeneficiaryVersion ffpBeneficiaryVersion = fetchByStatus_First(
			status, orderByComparator);

		if (ffpBeneficiaryVersion != null) {
			return ffpBeneficiaryVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchFFPBeneficiaryVersionException(sb.toString());
	}

	/**
	 * Returns the first ffp beneficiary version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ffp beneficiary version, or <code>null</code> if a matching ffp beneficiary version could not be found
	 */
	@Override
	public FFPBeneficiaryVersion fetchByStatus_First(
		int status,
		OrderByComparator<FFPBeneficiaryVersion> orderByComparator) {

		List<FFPBeneficiaryVersion> list = findByStatus(
			status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ffp beneficiary version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ffp beneficiary version
	 * @throws NoSuchFFPBeneficiaryVersionException if a matching ffp beneficiary version could not be found
	 */
	@Override
	public FFPBeneficiaryVersion findByStatus_Last(
			int status,
			OrderByComparator<FFPBeneficiaryVersion> orderByComparator)
		throws NoSuchFFPBeneficiaryVersionException {

		FFPBeneficiaryVersion ffpBeneficiaryVersion = fetchByStatus_Last(
			status, orderByComparator);

		if (ffpBeneficiaryVersion != null) {
			return ffpBeneficiaryVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchFFPBeneficiaryVersionException(sb.toString());
	}

	/**
	 * Returns the last ffp beneficiary version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ffp beneficiary version, or <code>null</code> if a matching ffp beneficiary version could not be found
	 */
	@Override
	public FFPBeneficiaryVersion fetchByStatus_Last(
		int status,
		OrderByComparator<FFPBeneficiaryVersion> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<FFPBeneficiaryVersion> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ffp beneficiary versions before and after the current ffp beneficiary version in the ordered set where status = &#63;.
	 *
	 * @param beneficiaryVersionId the primary key of the current ffp beneficiary version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ffp beneficiary version
	 * @throws NoSuchFFPBeneficiaryVersionException if a ffp beneficiary version with the primary key could not be found
	 */
	@Override
	public FFPBeneficiaryVersion[] findByStatus_PrevAndNext(
			long beneficiaryVersionId, int status,
			OrderByComparator<FFPBeneficiaryVersion> orderByComparator)
		throws NoSuchFFPBeneficiaryVersionException {

		FFPBeneficiaryVersion ffpBeneficiaryVersion = findByPrimaryKey(
			beneficiaryVersionId);

		Session session = null;

		try {
			session = openSession();

			FFPBeneficiaryVersion[] array = new FFPBeneficiaryVersionImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, ffpBeneficiaryVersion, status, orderByComparator,
				true);

			array[1] = ffpBeneficiaryVersion;

			array[2] = getByStatus_PrevAndNext(
				session, ffpBeneficiaryVersion, status, orderByComparator,
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

	protected FFPBeneficiaryVersion getByStatus_PrevAndNext(
		Session session, FFPBeneficiaryVersion ffpBeneficiaryVersion,
		int status, OrderByComparator<FFPBeneficiaryVersion> orderByComparator,
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

		sb.append(_SQL_SELECT_FFPBENEFICIARYVERSION_WHERE);

		sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			sb.append(FFPBeneficiaryVersionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						ffpBeneficiaryVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FFPBeneficiaryVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ffp beneficiary versions where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(int status) {
		for (FFPBeneficiaryVersion ffpBeneficiaryVersion :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ffpBeneficiaryVersion);
		}
	}

	/**
	 * Returns the number of ffp beneficiary versions where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching ffp beneficiary versions
	 */
	@Override
	public int countByStatus(int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FFPBENEFICIARYVERSION_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"ffpBeneficiaryVersion.status = ?";

	public FFPBeneficiaryVersionPersistenceImpl() {
		setModelClass(FFPBeneficiaryVersion.class);

		setModelImplClass(FFPBeneficiaryVersionImpl.class);
		setModelPKClass(long.class);

		setTable(FFPBeneficiaryVersionTable.INSTANCE);
	}

	/**
	 * Caches the ffp beneficiary version in the entity cache if it is enabled.
	 *
	 * @param ffpBeneficiaryVersion the ffp beneficiary version
	 */
	@Override
	public void cacheResult(FFPBeneficiaryVersion ffpBeneficiaryVersion) {
		entityCache.putResult(
			FFPBeneficiaryVersionImpl.class,
			ffpBeneficiaryVersion.getPrimaryKey(), ffpBeneficiaryVersion);

		finderCache.putResult(
			_finderPathFetchById_Version,
			new Object[] {
				ffpBeneficiaryVersion.getBeneficiaryId(),
				ffpBeneficiaryVersion.getVersion()
			},
			ffpBeneficiaryVersion);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the ffp beneficiary versions in the entity cache if it is enabled.
	 *
	 * @param ffpBeneficiaryVersions the ffp beneficiary versions
	 */
	@Override
	public void cacheResult(
		List<FFPBeneficiaryVersion> ffpBeneficiaryVersions) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (ffpBeneficiaryVersions.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FFPBeneficiaryVersion ffpBeneficiaryVersion :
				ffpBeneficiaryVersions) {

			if (entityCache.getResult(
					FFPBeneficiaryVersionImpl.class,
					ffpBeneficiaryVersion.getPrimaryKey()) == null) {

				cacheResult(ffpBeneficiaryVersion);
			}
		}
	}

	/**
	 * Clears the cache for all ffp beneficiary versions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FFPBeneficiaryVersionImpl.class);

		finderCache.clearCache(FFPBeneficiaryVersionImpl.class);
	}

	/**
	 * Clears the cache for the ffp beneficiary version.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FFPBeneficiaryVersion ffpBeneficiaryVersion) {
		entityCache.removeResult(
			FFPBeneficiaryVersionImpl.class, ffpBeneficiaryVersion);
	}

	@Override
	public void clearCache(List<FFPBeneficiaryVersion> ffpBeneficiaryVersions) {
		for (FFPBeneficiaryVersion ffpBeneficiaryVersion :
				ffpBeneficiaryVersions) {

			entityCache.removeResult(
				FFPBeneficiaryVersionImpl.class, ffpBeneficiaryVersion);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FFPBeneficiaryVersionImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				FFPBeneficiaryVersionImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		FFPBeneficiaryVersionModelImpl ffpBeneficiaryVersionModelImpl) {

		Object[] args = new Object[] {
			ffpBeneficiaryVersionModelImpl.getBeneficiaryId(),
			ffpBeneficiaryVersionModelImpl.getVersion()
		};

		finderCache.putResult(
			_finderPathCountById_Version, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchById_Version, args, ffpBeneficiaryVersionModelImpl);
	}

	/**
	 * Creates a new ffp beneficiary version with the primary key. Does not add the ffp beneficiary version to the database.
	 *
	 * @param beneficiaryVersionId the primary key for the new ffp beneficiary version
	 * @return the new ffp beneficiary version
	 */
	@Override
	public FFPBeneficiaryVersion create(long beneficiaryVersionId) {
		FFPBeneficiaryVersion ffpBeneficiaryVersion =
			new FFPBeneficiaryVersionImpl();

		ffpBeneficiaryVersion.setNew(true);
		ffpBeneficiaryVersion.setPrimaryKey(beneficiaryVersionId);

		ffpBeneficiaryVersion.setCompanyId(CompanyThreadLocal.getCompanyId());

		return ffpBeneficiaryVersion;
	}

	/**
	 * Removes the ffp beneficiary version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param beneficiaryVersionId the primary key of the ffp beneficiary version
	 * @return the ffp beneficiary version that was removed
	 * @throws NoSuchFFPBeneficiaryVersionException if a ffp beneficiary version with the primary key could not be found
	 */
	@Override
	public FFPBeneficiaryVersion remove(long beneficiaryVersionId)
		throws NoSuchFFPBeneficiaryVersionException {

		return remove((Serializable)beneficiaryVersionId);
	}

	/**
	 * Removes the ffp beneficiary version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ffp beneficiary version
	 * @return the ffp beneficiary version that was removed
	 * @throws NoSuchFFPBeneficiaryVersionException if a ffp beneficiary version with the primary key could not be found
	 */
	@Override
	public FFPBeneficiaryVersion remove(Serializable primaryKey)
		throws NoSuchFFPBeneficiaryVersionException {

		Session session = null;

		try {
			session = openSession();

			FFPBeneficiaryVersion ffpBeneficiaryVersion =
				(FFPBeneficiaryVersion)session.get(
					FFPBeneficiaryVersionImpl.class, primaryKey);

			if (ffpBeneficiaryVersion == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFFPBeneficiaryVersionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ffpBeneficiaryVersion);
		}
		catch (NoSuchFFPBeneficiaryVersionException noSuchEntityException) {
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
	protected FFPBeneficiaryVersion removeImpl(
		FFPBeneficiaryVersion ffpBeneficiaryVersion) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ffpBeneficiaryVersion)) {
				ffpBeneficiaryVersion = (FFPBeneficiaryVersion)session.get(
					FFPBeneficiaryVersionImpl.class,
					ffpBeneficiaryVersion.getPrimaryKeyObj());
			}

			if (ffpBeneficiaryVersion != null) {
				session.delete(ffpBeneficiaryVersion);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (ffpBeneficiaryVersion != null) {
			clearCache(ffpBeneficiaryVersion);
		}

		return ffpBeneficiaryVersion;
	}

	@Override
	public FFPBeneficiaryVersion updateImpl(
		FFPBeneficiaryVersion ffpBeneficiaryVersion) {

		boolean isNew = ffpBeneficiaryVersion.isNew();

		if (!(ffpBeneficiaryVersion instanceof
				FFPBeneficiaryVersionModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ffpBeneficiaryVersion.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					ffpBeneficiaryVersion);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ffpBeneficiaryVersion proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FFPBeneficiaryVersion implementation " +
					ffpBeneficiaryVersion.getClass());
		}

		FFPBeneficiaryVersionModelImpl ffpBeneficiaryVersionModelImpl =
			(FFPBeneficiaryVersionModelImpl)ffpBeneficiaryVersion;

		if (isNew && (ffpBeneficiaryVersion.getCreateDate() == null)) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				ffpBeneficiaryVersion.setCreateDate(date);
			}
			else {
				ffpBeneficiaryVersion.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(ffpBeneficiaryVersion);
			}
			else {
				ffpBeneficiaryVersion = (FFPBeneficiaryVersion)session.merge(
					ffpBeneficiaryVersion);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FFPBeneficiaryVersionImpl.class, ffpBeneficiaryVersionModelImpl,
			false, true);

		cacheUniqueFindersCache(ffpBeneficiaryVersionModelImpl);

		if (isNew) {
			ffpBeneficiaryVersion.setNew(false);
		}

		ffpBeneficiaryVersion.resetOriginalValues();

		return ffpBeneficiaryVersion;
	}

	/**
	 * Returns the ffp beneficiary version with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ffp beneficiary version
	 * @return the ffp beneficiary version
	 * @throws NoSuchFFPBeneficiaryVersionException if a ffp beneficiary version with the primary key could not be found
	 */
	@Override
	public FFPBeneficiaryVersion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFFPBeneficiaryVersionException {

		FFPBeneficiaryVersion ffpBeneficiaryVersion = fetchByPrimaryKey(
			primaryKey);

		if (ffpBeneficiaryVersion == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFFPBeneficiaryVersionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ffpBeneficiaryVersion;
	}

	/**
	 * Returns the ffp beneficiary version with the primary key or throws a <code>NoSuchFFPBeneficiaryVersionException</code> if it could not be found.
	 *
	 * @param beneficiaryVersionId the primary key of the ffp beneficiary version
	 * @return the ffp beneficiary version
	 * @throws NoSuchFFPBeneficiaryVersionException if a ffp beneficiary version with the primary key could not be found
	 */
	@Override
	public FFPBeneficiaryVersion findByPrimaryKey(long beneficiaryVersionId)
		throws NoSuchFFPBeneficiaryVersionException {

		return findByPrimaryKey((Serializable)beneficiaryVersionId);
	}

	/**
	 * Returns the ffp beneficiary version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param beneficiaryVersionId the primary key of the ffp beneficiary version
	 * @return the ffp beneficiary version, or <code>null</code> if a ffp beneficiary version with the primary key could not be found
	 */
	@Override
	public FFPBeneficiaryVersion fetchByPrimaryKey(long beneficiaryVersionId) {
		return fetchByPrimaryKey((Serializable)beneficiaryVersionId);
	}

	/**
	 * Returns all the ffp beneficiary versions.
	 *
	 * @return the ffp beneficiary versions
	 */
	@Override
	public List<FFPBeneficiaryVersion> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ffp beneficiary versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ffp beneficiary versions
	 * @param end the upper bound of the range of ffp beneficiary versions (not inclusive)
	 * @return the range of ffp beneficiary versions
	 */
	@Override
	public List<FFPBeneficiaryVersion> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ffp beneficiary versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ffp beneficiary versions
	 * @param end the upper bound of the range of ffp beneficiary versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ffp beneficiary versions
	 */
	@Override
	public List<FFPBeneficiaryVersion> findAll(
		int start, int end,
		OrderByComparator<FFPBeneficiaryVersion> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ffp beneficiary versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FFPBeneficiaryVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ffp beneficiary versions
	 * @param end the upper bound of the range of ffp beneficiary versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ffp beneficiary versions
	 */
	@Override
	public List<FFPBeneficiaryVersion> findAll(
		int start, int end,
		OrderByComparator<FFPBeneficiaryVersion> orderByComparator,
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

		List<FFPBeneficiaryVersion> list = null;

		if (useFinderCache) {
			list = (List<FFPBeneficiaryVersion>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FFPBENEFICIARYVERSION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FFPBENEFICIARYVERSION;

				sql = sql.concat(FFPBeneficiaryVersionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FFPBeneficiaryVersion>)QueryUtil.list(
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
	 * Removes all the ffp beneficiary versions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FFPBeneficiaryVersion ffpBeneficiaryVersion : findAll()) {
			remove(ffpBeneficiaryVersion);
		}
	}

	/**
	 * Returns the number of ffp beneficiary versions.
	 *
	 * @return the number of ffp beneficiary versions
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
					_SQL_COUNT_FFPBENEFICIARYVERSION);

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
		return "beneficiaryVersionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FFPBENEFICIARYVERSION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FFPBeneficiaryVersionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ffp beneficiary version persistence.
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

		_finderPathWithPaginationFindByBeneficiaryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBeneficiaryId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"beneficiaryId"}, true);

		_finderPathWithoutPaginationFindByBeneficiaryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBeneficiaryId",
			new String[] {Long.class.getName()}, new String[] {"beneficiaryId"},
			true);

		_finderPathCountByBeneficiaryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBeneficiaryId",
			new String[] {Long.class.getName()}, new String[] {"beneficiaryId"},
			false);

		_finderPathFetchById_Version = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchById_Version",
			new String[] {Long.class.getName(), Double.class.getName()},
			new String[] {"beneficiaryId", "version"}, true);

		_finderPathCountById_Version = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countById_Version",
			new String[] {Long.class.getName(), Double.class.getName()},
			new String[] {"beneficiaryId", "version"}, false);

		_finderPathWithPaginationFindByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"status"}, true);

		_finderPathWithoutPaginationFindByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {Integer.class.getName()}, new String[] {"status"},
			true);

		_finderPathCountByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {Integer.class.getName()}, new String[] {"status"},
			false);

		_setFFPBeneficiaryVersionUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setFFPBeneficiaryVersionUtilPersistence(null);

		entityCache.removeCache(FFPBeneficiaryVersionImpl.class.getName());
	}

	private void _setFFPBeneficiaryVersionUtilPersistence(
		FFPBeneficiaryVersionPersistence ffpBeneficiaryVersionPersistence) {

		try {
			Field field = FFPBeneficiaryVersionUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, ffpBeneficiaryVersionPersistence);
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

	private static final String _SQL_SELECT_FFPBENEFICIARYVERSION =
		"SELECT ffpBeneficiaryVersion FROM FFPBeneficiaryVersion ffpBeneficiaryVersion";

	private static final String _SQL_SELECT_FFPBENEFICIARYVERSION_WHERE =
		"SELECT ffpBeneficiaryVersion FROM FFPBeneficiaryVersion ffpBeneficiaryVersion WHERE ";

	private static final String _SQL_COUNT_FFPBENEFICIARYVERSION =
		"SELECT COUNT(ffpBeneficiaryVersion) FROM FFPBeneficiaryVersion ffpBeneficiaryVersion";

	private static final String _SQL_COUNT_FFPBENEFICIARYVERSION_WHERE =
		"SELECT COUNT(ffpBeneficiaryVersion) FROM FFPBeneficiaryVersion ffpBeneficiaryVersion WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"ffpBeneficiaryVersion.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FFPBeneficiaryVersion exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FFPBeneficiaryVersion exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FFPBeneficiaryVersionPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private FFPBeneficiaryVersionModelArgumentsResolver
		_ffpBeneficiaryVersionModelArgumentsResolver;

}