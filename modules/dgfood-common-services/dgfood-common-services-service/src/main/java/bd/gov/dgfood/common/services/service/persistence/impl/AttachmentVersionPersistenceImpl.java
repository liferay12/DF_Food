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

import bd.gov.dgfood.common.services.exception.NoSuchAttachmentVersionException;
import bd.gov.dgfood.common.services.model.AttachmentVersion;
import bd.gov.dgfood.common.services.model.AttachmentVersionTable;
import bd.gov.dgfood.common.services.model.impl.AttachmentVersionImpl;
import bd.gov.dgfood.common.services.model.impl.AttachmentVersionModelImpl;
import bd.gov.dgfood.common.services.service.persistence.AttachmentVersionPersistence;
import bd.gov.dgfood.common.services.service.persistence.AttachmentVersionUtil;
import bd.gov.dgfood.common.services.service.persistence.impl.constants.PersistenceConstants;

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

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the attachment version service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {AttachmentVersionPersistence.class, BasePersistence.class}
)
public class AttachmentVersionPersistenceImpl
	extends BasePersistenceImpl<AttachmentVersion>
	implements AttachmentVersionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AttachmentVersionUtil</code> to access the attachment version persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AttachmentVersionImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByCPK_CN;
	private FinderPath _finderPathWithoutPaginationFindByCPK_CN;
	private FinderPath _finderPathCountByCPK_CN;

	/**
	 * Returns all the attachment versions where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @return the matching attachment versions
	 */
	@Override
	public List<AttachmentVersion> findByCPK_CN(
		long classPK, String className) {

		return findByCPK_CN(
			classPK, className, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the attachment versions where classPK = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentVersionModelImpl</code>.
	 * </p>
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param start the lower bound of the range of attachment versions
	 * @param end the upper bound of the range of attachment versions (not inclusive)
	 * @return the range of matching attachment versions
	 */
	@Override
	public List<AttachmentVersion> findByCPK_CN(
		long classPK, String className, int start, int end) {

		return findByCPK_CN(classPK, className, start, end, null);
	}

	/**
	 * Returns an ordered range of all the attachment versions where classPK = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentVersionModelImpl</code>.
	 * </p>
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param start the lower bound of the range of attachment versions
	 * @param end the upper bound of the range of attachment versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attachment versions
	 */
	@Override
	public List<AttachmentVersion> findByCPK_CN(
		long classPK, String className, int start, int end,
		OrderByComparator<AttachmentVersion> orderByComparator) {

		return findByCPK_CN(
			classPK, className, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the attachment versions where classPK = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentVersionModelImpl</code>.
	 * </p>
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param start the lower bound of the range of attachment versions
	 * @param end the upper bound of the range of attachment versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching attachment versions
	 */
	@Override
	public List<AttachmentVersion> findByCPK_CN(
		long classPK, String className, int start, int end,
		OrderByComparator<AttachmentVersion> orderByComparator,
		boolean useFinderCache) {

		className = Objects.toString(className, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCPK_CN;
				finderArgs = new Object[] {classPK, className};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCPK_CN;
			finderArgs = new Object[] {
				classPK, className, start, end, orderByComparator
			};
		}

		List<AttachmentVersion> list = null;

		if (useFinderCache) {
			list = (List<AttachmentVersion>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AttachmentVersion attachmentVersion : list) {
					if ((classPK != attachmentVersion.getClassPK()) ||
						!className.equals(attachmentVersion.getClassName())) {

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

			sb.append(_SQL_SELECT_ATTACHMENTVERSION_WHERE);

			sb.append(_FINDER_COLUMN_CPK_CN_CLASSPK_2);

			boolean bindClassName = false;

			if (className.isEmpty()) {
				sb.append(_FINDER_COLUMN_CPK_CN_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				sb.append(_FINDER_COLUMN_CPK_CN_CLASSNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AttachmentVersionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(classPK);

				if (bindClassName) {
					queryPos.add(className);
				}

				list = (List<AttachmentVersion>)QueryUtil.list(
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
	 * Returns the first attachment version in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment version
	 * @throws NoSuchAttachmentVersionException if a matching attachment version could not be found
	 */
	@Override
	public AttachmentVersion findByCPK_CN_First(
			long classPK, String className,
			OrderByComparator<AttachmentVersion> orderByComparator)
		throws NoSuchAttachmentVersionException {

		AttachmentVersion attachmentVersion = fetchByCPK_CN_First(
			classPK, className, orderByComparator);

		if (attachmentVersion != null) {
			return attachmentVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("classPK=");
		sb.append(classPK);

		sb.append(", className=");
		sb.append(className);

		sb.append("}");

		throw new NoSuchAttachmentVersionException(sb.toString());
	}

	/**
	 * Returns the first attachment version in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment version, or <code>null</code> if a matching attachment version could not be found
	 */
	@Override
	public AttachmentVersion fetchByCPK_CN_First(
		long classPK, String className,
		OrderByComparator<AttachmentVersion> orderByComparator) {

		List<AttachmentVersion> list = findByCPK_CN(
			classPK, className, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last attachment version in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment version
	 * @throws NoSuchAttachmentVersionException if a matching attachment version could not be found
	 */
	@Override
	public AttachmentVersion findByCPK_CN_Last(
			long classPK, String className,
			OrderByComparator<AttachmentVersion> orderByComparator)
		throws NoSuchAttachmentVersionException {

		AttachmentVersion attachmentVersion = fetchByCPK_CN_Last(
			classPK, className, orderByComparator);

		if (attachmentVersion != null) {
			return attachmentVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("classPK=");
		sb.append(classPK);

		sb.append(", className=");
		sb.append(className);

		sb.append("}");

		throw new NoSuchAttachmentVersionException(sb.toString());
	}

	/**
	 * Returns the last attachment version in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment version, or <code>null</code> if a matching attachment version could not be found
	 */
	@Override
	public AttachmentVersion fetchByCPK_CN_Last(
		long classPK, String className,
		OrderByComparator<AttachmentVersion> orderByComparator) {

		int count = countByCPK_CN(classPK, className);

		if (count == 0) {
			return null;
		}

		List<AttachmentVersion> list = findByCPK_CN(
			classPK, className, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the attachment versions before and after the current attachment version in the ordered set where classPK = &#63; and className = &#63;.
	 *
	 * @param attachmentVersionId the primary key of the current attachment version
	 * @param classPK the class pk
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attachment version
	 * @throws NoSuchAttachmentVersionException if a attachment version with the primary key could not be found
	 */
	@Override
	public AttachmentVersion[] findByCPK_CN_PrevAndNext(
			long attachmentVersionId, long classPK, String className,
			OrderByComparator<AttachmentVersion> orderByComparator)
		throws NoSuchAttachmentVersionException {

		className = Objects.toString(className, "");

		AttachmentVersion attachmentVersion = findByPrimaryKey(
			attachmentVersionId);

		Session session = null;

		try {
			session = openSession();

			AttachmentVersion[] array = new AttachmentVersionImpl[3];

			array[0] = getByCPK_CN_PrevAndNext(
				session, attachmentVersion, classPK, className,
				orderByComparator, true);

			array[1] = attachmentVersion;

			array[2] = getByCPK_CN_PrevAndNext(
				session, attachmentVersion, classPK, className,
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

	protected AttachmentVersion getByCPK_CN_PrevAndNext(
		Session session, AttachmentVersion attachmentVersion, long classPK,
		String className,
		OrderByComparator<AttachmentVersion> orderByComparator,
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

		sb.append(_SQL_SELECT_ATTACHMENTVERSION_WHERE);

		sb.append(_FINDER_COLUMN_CPK_CN_CLASSPK_2);

		boolean bindClassName = false;

		if (className.isEmpty()) {
			sb.append(_FINDER_COLUMN_CPK_CN_CLASSNAME_3);
		}
		else {
			bindClassName = true;

			sb.append(_FINDER_COLUMN_CPK_CN_CLASSNAME_2);
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
			sb.append(AttachmentVersionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(classPK);

		if (bindClassName) {
			queryPos.add(className);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						attachmentVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AttachmentVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the attachment versions where classPK = &#63; and className = &#63; from the database.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 */
	@Override
	public void removeByCPK_CN(long classPK, String className) {
		for (AttachmentVersion attachmentVersion :
				findByCPK_CN(
					classPK, className, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(attachmentVersion);
		}
	}

	/**
	 * Returns the number of attachment versions where classPK = &#63; and className = &#63;.
	 *
	 * @param classPK the class pk
	 * @param className the class name
	 * @return the number of matching attachment versions
	 */
	@Override
	public int countByCPK_CN(long classPK, String className) {
		className = Objects.toString(className, "");

		FinderPath finderPath = _finderPathCountByCPK_CN;

		Object[] finderArgs = new Object[] {classPK, className};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ATTACHMENTVERSION_WHERE);

			sb.append(_FINDER_COLUMN_CPK_CN_CLASSPK_2);

			boolean bindClassName = false;

			if (className.isEmpty()) {
				sb.append(_FINDER_COLUMN_CPK_CN_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				sb.append(_FINDER_COLUMN_CPK_CN_CLASSNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(classPK);

				if (bindClassName) {
					queryPos.add(className);
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

	private static final String _FINDER_COLUMN_CPK_CN_CLASSPK_2 =
		"attachmentVersion.classPK = ? AND ";

	private static final String _FINDER_COLUMN_CPK_CN_CLASSNAME_2 =
		"attachmentVersion.className = ?";

	private static final String _FINDER_COLUMN_CPK_CN_CLASSNAME_3 =
		"(attachmentVersion.className IS NULL OR attachmentVersion.className = '')";

	public AttachmentVersionPersistenceImpl() {
		setModelClass(AttachmentVersion.class);

		setModelImplClass(AttachmentVersionImpl.class);
		setModelPKClass(long.class);

		setTable(AttachmentVersionTable.INSTANCE);
	}

	/**
	 * Caches the attachment version in the entity cache if it is enabled.
	 *
	 * @param attachmentVersion the attachment version
	 */
	@Override
	public void cacheResult(AttachmentVersion attachmentVersion) {
		entityCache.putResult(
			AttachmentVersionImpl.class, attachmentVersion.getPrimaryKey(),
			attachmentVersion);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the attachment versions in the entity cache if it is enabled.
	 *
	 * @param attachmentVersions the attachment versions
	 */
	@Override
	public void cacheResult(List<AttachmentVersion> attachmentVersions) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (attachmentVersions.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AttachmentVersion attachmentVersion : attachmentVersions) {
			if (entityCache.getResult(
					AttachmentVersionImpl.class,
					attachmentVersion.getPrimaryKey()) == null) {

				cacheResult(attachmentVersion);
			}
		}
	}

	/**
	 * Clears the cache for all attachment versions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AttachmentVersionImpl.class);

		finderCache.clearCache(AttachmentVersionImpl.class);
	}

	/**
	 * Clears the cache for the attachment version.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AttachmentVersion attachmentVersion) {
		entityCache.removeResult(
			AttachmentVersionImpl.class, attachmentVersion);
	}

	@Override
	public void clearCache(List<AttachmentVersion> attachmentVersions) {
		for (AttachmentVersion attachmentVersion : attachmentVersions) {
			entityCache.removeResult(
				AttachmentVersionImpl.class, attachmentVersion);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AttachmentVersionImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AttachmentVersionImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new attachment version with the primary key. Does not add the attachment version to the database.
	 *
	 * @param attachmentVersionId the primary key for the new attachment version
	 * @return the new attachment version
	 */
	@Override
	public AttachmentVersion create(long attachmentVersionId) {
		AttachmentVersion attachmentVersion = new AttachmentVersionImpl();

		attachmentVersion.setNew(true);
		attachmentVersion.setPrimaryKey(attachmentVersionId);

		return attachmentVersion;
	}

	/**
	 * Removes the attachment version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentVersionId the primary key of the attachment version
	 * @return the attachment version that was removed
	 * @throws NoSuchAttachmentVersionException if a attachment version with the primary key could not be found
	 */
	@Override
	public AttachmentVersion remove(long attachmentVersionId)
		throws NoSuchAttachmentVersionException {

		return remove((Serializable)attachmentVersionId);
	}

	/**
	 * Removes the attachment version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the attachment version
	 * @return the attachment version that was removed
	 * @throws NoSuchAttachmentVersionException if a attachment version with the primary key could not be found
	 */
	@Override
	public AttachmentVersion remove(Serializable primaryKey)
		throws NoSuchAttachmentVersionException {

		Session session = null;

		try {
			session = openSession();

			AttachmentVersion attachmentVersion =
				(AttachmentVersion)session.get(
					AttachmentVersionImpl.class, primaryKey);

			if (attachmentVersion == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAttachmentVersionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(attachmentVersion);
		}
		catch (NoSuchAttachmentVersionException noSuchEntityException) {
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
	protected AttachmentVersion removeImpl(
		AttachmentVersion attachmentVersion) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(attachmentVersion)) {
				attachmentVersion = (AttachmentVersion)session.get(
					AttachmentVersionImpl.class,
					attachmentVersion.getPrimaryKeyObj());
			}

			if (attachmentVersion != null) {
				session.delete(attachmentVersion);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (attachmentVersion != null) {
			clearCache(attachmentVersion);
		}

		return attachmentVersion;
	}

	@Override
	public AttachmentVersion updateImpl(AttachmentVersion attachmentVersion) {
		boolean isNew = attachmentVersion.isNew();

		if (!(attachmentVersion instanceof AttachmentVersionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(attachmentVersion.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					attachmentVersion);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in attachmentVersion proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AttachmentVersion implementation " +
					attachmentVersion.getClass());
		}

		AttachmentVersionModelImpl attachmentVersionModelImpl =
			(AttachmentVersionModelImpl)attachmentVersion;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(attachmentVersion);
			}
			else {
				attachmentVersion = (AttachmentVersion)session.merge(
					attachmentVersion);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AttachmentVersionImpl.class, attachmentVersionModelImpl, false,
			true);

		if (isNew) {
			attachmentVersion.setNew(false);
		}

		attachmentVersion.resetOriginalValues();

		return attachmentVersion;
	}

	/**
	 * Returns the attachment version with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the attachment version
	 * @return the attachment version
	 * @throws NoSuchAttachmentVersionException if a attachment version with the primary key could not be found
	 */
	@Override
	public AttachmentVersion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAttachmentVersionException {

		AttachmentVersion attachmentVersion = fetchByPrimaryKey(primaryKey);

		if (attachmentVersion == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAttachmentVersionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return attachmentVersion;
	}

	/**
	 * Returns the attachment version with the primary key or throws a <code>NoSuchAttachmentVersionException</code> if it could not be found.
	 *
	 * @param attachmentVersionId the primary key of the attachment version
	 * @return the attachment version
	 * @throws NoSuchAttachmentVersionException if a attachment version with the primary key could not be found
	 */
	@Override
	public AttachmentVersion findByPrimaryKey(long attachmentVersionId)
		throws NoSuchAttachmentVersionException {

		return findByPrimaryKey((Serializable)attachmentVersionId);
	}

	/**
	 * Returns the attachment version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attachmentVersionId the primary key of the attachment version
	 * @return the attachment version, or <code>null</code> if a attachment version with the primary key could not be found
	 */
	@Override
	public AttachmentVersion fetchByPrimaryKey(long attachmentVersionId) {
		return fetchByPrimaryKey((Serializable)attachmentVersionId);
	}

	/**
	 * Returns all the attachment versions.
	 *
	 * @return the attachment versions
	 */
	@Override
	public List<AttachmentVersion> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the attachment versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attachment versions
	 * @param end the upper bound of the range of attachment versions (not inclusive)
	 * @return the range of attachment versions
	 */
	@Override
	public List<AttachmentVersion> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the attachment versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attachment versions
	 * @param end the upper bound of the range of attachment versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of attachment versions
	 */
	@Override
	public List<AttachmentVersion> findAll(
		int start, int end,
		OrderByComparator<AttachmentVersion> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the attachment versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attachment versions
	 * @param end the upper bound of the range of attachment versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of attachment versions
	 */
	@Override
	public List<AttachmentVersion> findAll(
		int start, int end,
		OrderByComparator<AttachmentVersion> orderByComparator,
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

		List<AttachmentVersion> list = null;

		if (useFinderCache) {
			list = (List<AttachmentVersion>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ATTACHMENTVERSION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ATTACHMENTVERSION;

				sql = sql.concat(AttachmentVersionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AttachmentVersion>)QueryUtil.list(
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
	 * Removes all the attachment versions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AttachmentVersion attachmentVersion : findAll()) {
			remove(attachmentVersion);
		}
	}

	/**
	 * Returns the number of attachment versions.
	 *
	 * @return the number of attachment versions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ATTACHMENTVERSION);

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
		return "attachmentVersionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ATTACHMENTVERSION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AttachmentVersionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the attachment version persistence.
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

		_finderPathWithPaginationFindByCPK_CN = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCPK_CN",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"classPK", "className"}, true);

		_finderPathWithoutPaginationFindByCPK_CN = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCPK_CN",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"classPK", "className"}, true);

		_finderPathCountByCPK_CN = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCPK_CN",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"classPK", "className"}, false);

		_setAttachmentVersionUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAttachmentVersionUtilPersistence(null);

		entityCache.removeCache(AttachmentVersionImpl.class.getName());
	}

	private void _setAttachmentVersionUtilPersistence(
		AttachmentVersionPersistence attachmentVersionPersistence) {

		try {
			Field field = AttachmentVersionUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, attachmentVersionPersistence);
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

	private static final String _SQL_SELECT_ATTACHMENTVERSION =
		"SELECT attachmentVersion FROM AttachmentVersion attachmentVersion";

	private static final String _SQL_SELECT_ATTACHMENTVERSION_WHERE =
		"SELECT attachmentVersion FROM AttachmentVersion attachmentVersion WHERE ";

	private static final String _SQL_COUNT_ATTACHMENTVERSION =
		"SELECT COUNT(attachmentVersion) FROM AttachmentVersion attachmentVersion";

	private static final String _SQL_COUNT_ATTACHMENTVERSION_WHERE =
		"SELECT COUNT(attachmentVersion) FROM AttachmentVersion attachmentVersion WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "attachmentVersion.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AttachmentVersion exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AttachmentVersion exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AttachmentVersionPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private AttachmentVersionModelArgumentsResolver
		_attachmentVersionModelArgumentsResolver;

}