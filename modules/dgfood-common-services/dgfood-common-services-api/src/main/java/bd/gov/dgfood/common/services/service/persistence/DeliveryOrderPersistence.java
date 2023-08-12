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

package bd.gov.dgfood.common.services.service.persistence;

import bd.gov.dgfood.common.services.exception.NoSuchDeliveryOrderException;
import bd.gov.dgfood.common.services.model.DeliveryOrder;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the delivery order service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DeliveryOrderUtil
 * @generated
 */
@ProviderType
public interface DeliveryOrderPersistence
	extends BasePersistence<DeliveryOrder> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DeliveryOrderUtil} to access the delivery order persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the delivery orders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching delivery orders
	 */
	public java.util.List<DeliveryOrder> findByUuid(String uuid);

	/**
	 * Returns a range of all the delivery orders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliveryOrderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of delivery orders
	 * @param end the upper bound of the range of delivery orders (not inclusive)
	 * @return the range of matching delivery orders
	 */
	public java.util.List<DeliveryOrder> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the delivery orders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliveryOrderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of delivery orders
	 * @param end the upper bound of the range of delivery orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching delivery orders
	 */
	public java.util.List<DeliveryOrder> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DeliveryOrder>
			orderByComparator);

	/**
	 * Returns an ordered range of all the delivery orders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliveryOrderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of delivery orders
	 * @param end the upper bound of the range of delivery orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching delivery orders
	 */
	public java.util.List<DeliveryOrder> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DeliveryOrder>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first delivery order in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delivery order
	 * @throws NoSuchDeliveryOrderException if a matching delivery order could not be found
	 */
	public DeliveryOrder findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DeliveryOrder>
				orderByComparator)
		throws NoSuchDeliveryOrderException;

	/**
	 * Returns the first delivery order in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delivery order, or <code>null</code> if a matching delivery order could not be found
	 */
	public DeliveryOrder fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DeliveryOrder>
			orderByComparator);

	/**
	 * Returns the last delivery order in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delivery order
	 * @throws NoSuchDeliveryOrderException if a matching delivery order could not be found
	 */
	public DeliveryOrder findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DeliveryOrder>
				orderByComparator)
		throws NoSuchDeliveryOrderException;

	/**
	 * Returns the last delivery order in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delivery order, or <code>null</code> if a matching delivery order could not be found
	 */
	public DeliveryOrder fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DeliveryOrder>
			orderByComparator);

	/**
	 * Returns the delivery orders before and after the current delivery order in the ordered set where uuid = &#63;.
	 *
	 * @param deliveryOrderPK the primary key of the current delivery order
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next delivery order
	 * @throws NoSuchDeliveryOrderException if a delivery order with the primary key could not be found
	 */
	public DeliveryOrder[] findByUuid_PrevAndNext(
			bd.gov.dgfood.common.services.service.persistence.DeliveryOrderPK
				deliveryOrderPK,
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DeliveryOrder>
				orderByComparator)
		throws NoSuchDeliveryOrderException;

	/**
	 * Removes all the delivery orders where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of delivery orders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching delivery orders
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the delivery orders where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching delivery orders
	 */
	public java.util.List<DeliveryOrder> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the delivery orders where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliveryOrderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of delivery orders
	 * @param end the upper bound of the range of delivery orders (not inclusive)
	 * @return the range of matching delivery orders
	 */
	public java.util.List<DeliveryOrder> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the delivery orders where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliveryOrderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of delivery orders
	 * @param end the upper bound of the range of delivery orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching delivery orders
	 */
	public java.util.List<DeliveryOrder> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DeliveryOrder>
			orderByComparator);

	/**
	 * Returns an ordered range of all the delivery orders where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliveryOrderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of delivery orders
	 * @param end the upper bound of the range of delivery orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching delivery orders
	 */
	public java.util.List<DeliveryOrder> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DeliveryOrder>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first delivery order in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delivery order
	 * @throws NoSuchDeliveryOrderException if a matching delivery order could not be found
	 */
	public DeliveryOrder findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DeliveryOrder>
				orderByComparator)
		throws NoSuchDeliveryOrderException;

	/**
	 * Returns the first delivery order in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching delivery order, or <code>null</code> if a matching delivery order could not be found
	 */
	public DeliveryOrder fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DeliveryOrder>
			orderByComparator);

	/**
	 * Returns the last delivery order in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delivery order
	 * @throws NoSuchDeliveryOrderException if a matching delivery order could not be found
	 */
	public DeliveryOrder findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DeliveryOrder>
				orderByComparator)
		throws NoSuchDeliveryOrderException;

	/**
	 * Returns the last delivery order in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching delivery order, or <code>null</code> if a matching delivery order could not be found
	 */
	public DeliveryOrder fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DeliveryOrder>
			orderByComparator);

	/**
	 * Returns the delivery orders before and after the current delivery order in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param deliveryOrderPK the primary key of the current delivery order
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next delivery order
	 * @throws NoSuchDeliveryOrderException if a delivery order with the primary key could not be found
	 */
	public DeliveryOrder[] findByUuid_C_PrevAndNext(
			bd.gov.dgfood.common.services.service.persistence.DeliveryOrderPK
				deliveryOrderPK,
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DeliveryOrder>
				orderByComparator)
		throws NoSuchDeliveryOrderException;

	/**
	 * Removes all the delivery orders where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of delivery orders where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching delivery orders
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the delivery order in the entity cache if it is enabled.
	 *
	 * @param deliveryOrder the delivery order
	 */
	public void cacheResult(DeliveryOrder deliveryOrder);

	/**
	 * Caches the delivery orders in the entity cache if it is enabled.
	 *
	 * @param deliveryOrders the delivery orders
	 */
	public void cacheResult(java.util.List<DeliveryOrder> deliveryOrders);

	/**
	 * Creates a new delivery order with the primary key. Does not add the delivery order to the database.
	 *
	 * @param deliveryOrderPK the primary key for the new delivery order
	 * @return the new delivery order
	 */
	public DeliveryOrder create(
		bd.gov.dgfood.common.services.service.persistence.DeliveryOrderPK
			deliveryOrderPK);

	/**
	 * Removes the delivery order with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param deliveryOrderPK the primary key of the delivery order
	 * @return the delivery order that was removed
	 * @throws NoSuchDeliveryOrderException if a delivery order with the primary key could not be found
	 */
	public DeliveryOrder remove(
			bd.gov.dgfood.common.services.service.persistence.DeliveryOrderPK
				deliveryOrderPK)
		throws NoSuchDeliveryOrderException;

	public DeliveryOrder updateImpl(DeliveryOrder deliveryOrder);

	/**
	 * Returns the delivery order with the primary key or throws a <code>NoSuchDeliveryOrderException</code> if it could not be found.
	 *
	 * @param deliveryOrderPK the primary key of the delivery order
	 * @return the delivery order
	 * @throws NoSuchDeliveryOrderException if a delivery order with the primary key could not be found
	 */
	public DeliveryOrder findByPrimaryKey(
			bd.gov.dgfood.common.services.service.persistence.DeliveryOrderPK
				deliveryOrderPK)
		throws NoSuchDeliveryOrderException;

	/**
	 * Returns the delivery order with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param deliveryOrderPK the primary key of the delivery order
	 * @return the delivery order, or <code>null</code> if a delivery order with the primary key could not be found
	 */
	public DeliveryOrder fetchByPrimaryKey(
		bd.gov.dgfood.common.services.service.persistence.DeliveryOrderPK
			deliveryOrderPK);

	/**
	 * Returns all the delivery orders.
	 *
	 * @return the delivery orders
	 */
	public java.util.List<DeliveryOrder> findAll();

	/**
	 * Returns a range of all the delivery orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliveryOrderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of delivery orders
	 * @param end the upper bound of the range of delivery orders (not inclusive)
	 * @return the range of delivery orders
	 */
	public java.util.List<DeliveryOrder> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the delivery orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliveryOrderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of delivery orders
	 * @param end the upper bound of the range of delivery orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of delivery orders
	 */
	public java.util.List<DeliveryOrder> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DeliveryOrder>
			orderByComparator);

	/**
	 * Returns an ordered range of all the delivery orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliveryOrderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of delivery orders
	 * @param end the upper bound of the range of delivery orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of delivery orders
	 */
	public java.util.List<DeliveryOrder> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DeliveryOrder>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the delivery orders from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of delivery orders.
	 *
	 * @return the number of delivery orders
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}