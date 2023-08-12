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

package bd.gov.dgfood.common.services.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DeliveryOrder}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DeliveryOrder
 * @generated
 */
public class DeliveryOrderWrapper
	extends BaseModelWrapper<DeliveryOrder>
	implements DeliveryOrder, ModelWrapper<DeliveryOrder> {

	public DeliveryOrderWrapper(DeliveryOrder deliveryOrder) {
		super(deliveryOrder);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("deliveryOrderId", getDeliveryOrderId());
		attributes.put("indentId", getIndentId());
		attributes.put("deliveryOrderNo", getDeliveryOrderNo());
		attributes.put("customerNo", getCustomerNo());
		attributes.put("name", getName());
		attributes.put("doDate", getDoDate());
		attributes.put("commodity", getCommodity());
		attributes.put("commodityDescription", getCommodityDescription());
		attributes.put("doQty", getDoQty());
		attributes.put("doQtyUnit", getDoQtyUnit());
		attributes.put("depo", getDepo());
		attributes.put("warehouseNo", getWarehouseNo());
		attributes.put("khamaalNo", getKhamaalNo());
		attributes.put("lUANo", getLUANo());
		attributes.put("lUADate", getLUADate());
		attributes.put("bagUnit", getBagUnit());
		attributes.put("vehicleNo", getVehicleNo());
		attributes.put("gateKeeper", getGateKeeper());
		attributes.put("goodsIssueDate", getGoodsIssueDate());
		attributes.put("shipToParty", getShipToParty());
		attributes.put("shipToPartyName", getShipToPartyName());
		attributes.put("deliveredQty", getDeliveredQty());
		attributes.put("deliveredQtyUnit", getDeliveredQtyUnit());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long deliveryOrderId = (Long)attributes.get("deliveryOrderId");

		if (deliveryOrderId != null) {
			setDeliveryOrderId(deliveryOrderId);
		}

		Long indentId = (Long)attributes.get("indentId");

		if (indentId != null) {
			setIndentId(indentId);
		}

		String deliveryOrderNo = (String)attributes.get("deliveryOrderNo");

		if (deliveryOrderNo != null) {
			setDeliveryOrderNo(deliveryOrderNo);
		}

		String customerNo = (String)attributes.get("customerNo");

		if (customerNo != null) {
			setCustomerNo(customerNo);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Date doDate = (Date)attributes.get("doDate");

		if (doDate != null) {
			setDoDate(doDate);
		}

		String commodity = (String)attributes.get("commodity");

		if (commodity != null) {
			setCommodity(commodity);
		}

		String commodityDescription = (String)attributes.get(
			"commodityDescription");

		if (commodityDescription != null) {
			setCommodityDescription(commodityDescription);
		}

		String doQty = (String)attributes.get("doQty");

		if (doQty != null) {
			setDoQty(doQty);
		}

		String doQtyUnit = (String)attributes.get("doQtyUnit");

		if (doQtyUnit != null) {
			setDoQtyUnit(doQtyUnit);
		}

		String depo = (String)attributes.get("depo");

		if (depo != null) {
			setDepo(depo);
		}

		String warehouseNo = (String)attributes.get("warehouseNo");

		if (warehouseNo != null) {
			setWarehouseNo(warehouseNo);
		}

		String khamaalNo = (String)attributes.get("khamaalNo");

		if (khamaalNo != null) {
			setKhamaalNo(khamaalNo);
		}

		String lUANo = (String)attributes.get("lUANo");

		if (lUANo != null) {
			setLUANo(lUANo);
		}

		Date lUADate = (Date)attributes.get("lUADate");

		if (lUADate != null) {
			setLUADate(lUADate);
		}

		String bagUnit = (String)attributes.get("bagUnit");

		if (bagUnit != null) {
			setBagUnit(bagUnit);
		}

		String vehicleNo = (String)attributes.get("vehicleNo");

		if (vehicleNo != null) {
			setVehicleNo(vehicleNo);
		}

		String gateKeeper = (String)attributes.get("gateKeeper");

		if (gateKeeper != null) {
			setGateKeeper(gateKeeper);
		}

		String goodsIssueDate = (String)attributes.get("goodsIssueDate");

		if (goodsIssueDate != null) {
			setGoodsIssueDate(goodsIssueDate);
		}

		String shipToParty = (String)attributes.get("shipToParty");

		if (shipToParty != null) {
			setShipToParty(shipToParty);
		}

		String shipToPartyName = (String)attributes.get("shipToPartyName");

		if (shipToPartyName != null) {
			setShipToPartyName(shipToPartyName);
		}

		String deliveredQty = (String)attributes.get("deliveredQty");

		if (deliveredQty != null) {
			setDeliveredQty(deliveredQty);
		}

		String deliveredQtyUnit = (String)attributes.get("deliveredQtyUnit");

		if (deliveredQtyUnit != null) {
			setDeliveredQtyUnit(deliveredQtyUnit);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public DeliveryOrder cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the bag unit of this delivery order.
	 *
	 * @return the bag unit of this delivery order
	 */
	@Override
	public String getBagUnit() {
		return model.getBagUnit();
	}

	/**
	 * Returns the localized bag unit of this delivery order in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized bag unit of this delivery order
	 */
	@Override
	public String getBagUnit(java.util.Locale locale) {
		return model.getBagUnit(locale);
	}

	/**
	 * Returns the localized bag unit of this delivery order in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized bag unit of this delivery order. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getBagUnit(java.util.Locale locale, boolean useDefault) {
		return model.getBagUnit(locale, useDefault);
	}

	/**
	 * Returns the localized bag unit of this delivery order in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized bag unit of this delivery order
	 */
	@Override
	public String getBagUnit(String languageId) {
		return model.getBagUnit(languageId);
	}

	/**
	 * Returns the localized bag unit of this delivery order in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized bag unit of this delivery order
	 */
	@Override
	public String getBagUnit(String languageId, boolean useDefault) {
		return model.getBagUnit(languageId, useDefault);
	}

	@Override
	public String getBagUnitCurrentLanguageId() {
		return model.getBagUnitCurrentLanguageId();
	}

	@Override
	public String getBagUnitCurrentValue() {
		return model.getBagUnitCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized bag units of this delivery order.
	 *
	 * @return the locales and localized bag units of this delivery order
	 */
	@Override
	public Map<java.util.Locale, String> getBagUnitMap() {
		return model.getBagUnitMap();
	}

	/**
	 * Returns the commodity of this delivery order.
	 *
	 * @return the commodity of this delivery order
	 */
	@Override
	public String getCommodity() {
		return model.getCommodity();
	}

	/**
	 * Returns the localized commodity of this delivery order in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized commodity of this delivery order
	 */
	@Override
	public String getCommodity(java.util.Locale locale) {
		return model.getCommodity(locale);
	}

	/**
	 * Returns the localized commodity of this delivery order in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized commodity of this delivery order. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getCommodity(java.util.Locale locale, boolean useDefault) {
		return model.getCommodity(locale, useDefault);
	}

	/**
	 * Returns the localized commodity of this delivery order in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized commodity of this delivery order
	 */
	@Override
	public String getCommodity(String languageId) {
		return model.getCommodity(languageId);
	}

	/**
	 * Returns the localized commodity of this delivery order in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized commodity of this delivery order
	 */
	@Override
	public String getCommodity(String languageId, boolean useDefault) {
		return model.getCommodity(languageId, useDefault);
	}

	@Override
	public String getCommodityCurrentLanguageId() {
		return model.getCommodityCurrentLanguageId();
	}

	@Override
	public String getCommodityCurrentValue() {
		return model.getCommodityCurrentValue();
	}

	/**
	 * Returns the commodity description of this delivery order.
	 *
	 * @return the commodity description of this delivery order
	 */
	@Override
	public String getCommodityDescription() {
		return model.getCommodityDescription();
	}

	/**
	 * Returns the localized commodity description of this delivery order in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized commodity description of this delivery order
	 */
	@Override
	public String getCommodityDescription(java.util.Locale locale) {
		return model.getCommodityDescription(locale);
	}

	/**
	 * Returns the localized commodity description of this delivery order in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized commodity description of this delivery order. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getCommodityDescription(
		java.util.Locale locale, boolean useDefault) {

		return model.getCommodityDescription(locale, useDefault);
	}

	/**
	 * Returns the localized commodity description of this delivery order in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized commodity description of this delivery order
	 */
	@Override
	public String getCommodityDescription(String languageId) {
		return model.getCommodityDescription(languageId);
	}

	/**
	 * Returns the localized commodity description of this delivery order in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized commodity description of this delivery order
	 */
	@Override
	public String getCommodityDescription(
		String languageId, boolean useDefault) {

		return model.getCommodityDescription(languageId, useDefault);
	}

	@Override
	public String getCommodityDescriptionCurrentLanguageId() {
		return model.getCommodityDescriptionCurrentLanguageId();
	}

	@Override
	public String getCommodityDescriptionCurrentValue() {
		return model.getCommodityDescriptionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized commodity descriptions of this delivery order.
	 *
	 * @return the locales and localized commodity descriptions of this delivery order
	 */
	@Override
	public Map<java.util.Locale, String> getCommodityDescriptionMap() {
		return model.getCommodityDescriptionMap();
	}

	/**
	 * Returns a map of the locales and localized commodities of this delivery order.
	 *
	 * @return the locales and localized commodities of this delivery order
	 */
	@Override
	public Map<java.util.Locale, String> getCommodityMap() {
		return model.getCommodityMap();
	}

	/**
	 * Returns the company ID of this delivery order.
	 *
	 * @return the company ID of this delivery order
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this delivery order.
	 *
	 * @return the create date of this delivery order
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the customer no of this delivery order.
	 *
	 * @return the customer no of this delivery order
	 */
	@Override
	public String getCustomerNo() {
		return model.getCustomerNo();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the delivered qty of this delivery order.
	 *
	 * @return the delivered qty of this delivery order
	 */
	@Override
	public String getDeliveredQty() {
		return model.getDeliveredQty();
	}

	/**
	 * Returns the localized delivered qty of this delivery order in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized delivered qty of this delivery order
	 */
	@Override
	public String getDeliveredQty(java.util.Locale locale) {
		return model.getDeliveredQty(locale);
	}

	/**
	 * Returns the localized delivered qty of this delivery order in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized delivered qty of this delivery order. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDeliveredQty(java.util.Locale locale, boolean useDefault) {
		return model.getDeliveredQty(locale, useDefault);
	}

	/**
	 * Returns the localized delivered qty of this delivery order in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized delivered qty of this delivery order
	 */
	@Override
	public String getDeliveredQty(String languageId) {
		return model.getDeliveredQty(languageId);
	}

	/**
	 * Returns the localized delivered qty of this delivery order in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized delivered qty of this delivery order
	 */
	@Override
	public String getDeliveredQty(String languageId, boolean useDefault) {
		return model.getDeliveredQty(languageId, useDefault);
	}

	@Override
	public String getDeliveredQtyCurrentLanguageId() {
		return model.getDeliveredQtyCurrentLanguageId();
	}

	@Override
	public String getDeliveredQtyCurrentValue() {
		return model.getDeliveredQtyCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized delivered qties of this delivery order.
	 *
	 * @return the locales and localized delivered qties of this delivery order
	 */
	@Override
	public Map<java.util.Locale, String> getDeliveredQtyMap() {
		return model.getDeliveredQtyMap();
	}

	/**
	 * Returns the delivered qty unit of this delivery order.
	 *
	 * @return the delivered qty unit of this delivery order
	 */
	@Override
	public String getDeliveredQtyUnit() {
		return model.getDeliveredQtyUnit();
	}

	/**
	 * Returns the localized delivered qty unit of this delivery order in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized delivered qty unit of this delivery order
	 */
	@Override
	public String getDeliveredQtyUnit(java.util.Locale locale) {
		return model.getDeliveredQtyUnit(locale);
	}

	/**
	 * Returns the localized delivered qty unit of this delivery order in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized delivered qty unit of this delivery order. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDeliveredQtyUnit(
		java.util.Locale locale, boolean useDefault) {

		return model.getDeliveredQtyUnit(locale, useDefault);
	}

	/**
	 * Returns the localized delivered qty unit of this delivery order in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized delivered qty unit of this delivery order
	 */
	@Override
	public String getDeliveredQtyUnit(String languageId) {
		return model.getDeliveredQtyUnit(languageId);
	}

	/**
	 * Returns the localized delivered qty unit of this delivery order in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized delivered qty unit of this delivery order
	 */
	@Override
	public String getDeliveredQtyUnit(String languageId, boolean useDefault) {
		return model.getDeliveredQtyUnit(languageId, useDefault);
	}

	@Override
	public String getDeliveredQtyUnitCurrentLanguageId() {
		return model.getDeliveredQtyUnitCurrentLanguageId();
	}

	@Override
	public String getDeliveredQtyUnitCurrentValue() {
		return model.getDeliveredQtyUnitCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized delivered qty units of this delivery order.
	 *
	 * @return the locales and localized delivered qty units of this delivery order
	 */
	@Override
	public Map<java.util.Locale, String> getDeliveredQtyUnitMap() {
		return model.getDeliveredQtyUnitMap();
	}

	/**
	 * Returns the delivery order ID of this delivery order.
	 *
	 * @return the delivery order ID of this delivery order
	 */
	@Override
	public long getDeliveryOrderId() {
		return model.getDeliveryOrderId();
	}

	/**
	 * Returns the delivery order no of this delivery order.
	 *
	 * @return the delivery order no of this delivery order
	 */
	@Override
	public String getDeliveryOrderNo() {
		return model.getDeliveryOrderNo();
	}

	/**
	 * Returns the depo of this delivery order.
	 *
	 * @return the depo of this delivery order
	 */
	@Override
	public String getDepo() {
		return model.getDepo();
	}

	/**
	 * Returns the localized depo of this delivery order in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized depo of this delivery order
	 */
	@Override
	public String getDepo(java.util.Locale locale) {
		return model.getDepo(locale);
	}

	/**
	 * Returns the localized depo of this delivery order in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized depo of this delivery order. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDepo(java.util.Locale locale, boolean useDefault) {
		return model.getDepo(locale, useDefault);
	}

	/**
	 * Returns the localized depo of this delivery order in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized depo of this delivery order
	 */
	@Override
	public String getDepo(String languageId) {
		return model.getDepo(languageId);
	}

	/**
	 * Returns the localized depo of this delivery order in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized depo of this delivery order
	 */
	@Override
	public String getDepo(String languageId, boolean useDefault) {
		return model.getDepo(languageId, useDefault);
	}

	@Override
	public String getDepoCurrentLanguageId() {
		return model.getDepoCurrentLanguageId();
	}

	@Override
	public String getDepoCurrentValue() {
		return model.getDepoCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized depos of this delivery order.
	 *
	 * @return the locales and localized depos of this delivery order
	 */
	@Override
	public Map<java.util.Locale, String> getDepoMap() {
		return model.getDepoMap();
	}

	/**
	 * Returns the do date of this delivery order.
	 *
	 * @return the do date of this delivery order
	 */
	@Override
	public Date getDoDate() {
		return model.getDoDate();
	}

	/**
	 * Returns the do qty of this delivery order.
	 *
	 * @return the do qty of this delivery order
	 */
	@Override
	public String getDoQty() {
		return model.getDoQty();
	}

	/**
	 * Returns the localized do qty of this delivery order in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized do qty of this delivery order
	 */
	@Override
	public String getDoQty(java.util.Locale locale) {
		return model.getDoQty(locale);
	}

	/**
	 * Returns the localized do qty of this delivery order in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized do qty of this delivery order. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDoQty(java.util.Locale locale, boolean useDefault) {
		return model.getDoQty(locale, useDefault);
	}

	/**
	 * Returns the localized do qty of this delivery order in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized do qty of this delivery order
	 */
	@Override
	public String getDoQty(String languageId) {
		return model.getDoQty(languageId);
	}

	/**
	 * Returns the localized do qty of this delivery order in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized do qty of this delivery order
	 */
	@Override
	public String getDoQty(String languageId, boolean useDefault) {
		return model.getDoQty(languageId, useDefault);
	}

	@Override
	public String getDoQtyCurrentLanguageId() {
		return model.getDoQtyCurrentLanguageId();
	}

	@Override
	public String getDoQtyCurrentValue() {
		return model.getDoQtyCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized do qties of this delivery order.
	 *
	 * @return the locales and localized do qties of this delivery order
	 */
	@Override
	public Map<java.util.Locale, String> getDoQtyMap() {
		return model.getDoQtyMap();
	}

	/**
	 * Returns the do qty unit of this delivery order.
	 *
	 * @return the do qty unit of this delivery order
	 */
	@Override
	public String getDoQtyUnit() {
		return model.getDoQtyUnit();
	}

	/**
	 * Returns the localized do qty unit of this delivery order in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized do qty unit of this delivery order
	 */
	@Override
	public String getDoQtyUnit(java.util.Locale locale) {
		return model.getDoQtyUnit(locale);
	}

	/**
	 * Returns the localized do qty unit of this delivery order in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized do qty unit of this delivery order. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDoQtyUnit(java.util.Locale locale, boolean useDefault) {
		return model.getDoQtyUnit(locale, useDefault);
	}

	/**
	 * Returns the localized do qty unit of this delivery order in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized do qty unit of this delivery order
	 */
	@Override
	public String getDoQtyUnit(String languageId) {
		return model.getDoQtyUnit(languageId);
	}

	/**
	 * Returns the localized do qty unit of this delivery order in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized do qty unit of this delivery order
	 */
	@Override
	public String getDoQtyUnit(String languageId, boolean useDefault) {
		return model.getDoQtyUnit(languageId, useDefault);
	}

	@Override
	public String getDoQtyUnitCurrentLanguageId() {
		return model.getDoQtyUnitCurrentLanguageId();
	}

	@Override
	public String getDoQtyUnitCurrentValue() {
		return model.getDoQtyUnitCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized do qty units of this delivery order.
	 *
	 * @return the locales and localized do qty units of this delivery order
	 */
	@Override
	public Map<java.util.Locale, String> getDoQtyUnitMap() {
		return model.getDoQtyUnitMap();
	}

	/**
	 * Returns the gate keeper of this delivery order.
	 *
	 * @return the gate keeper of this delivery order
	 */
	@Override
	public String getGateKeeper() {
		return model.getGateKeeper();
	}

	/**
	 * Returns the localized gate keeper of this delivery order in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized gate keeper of this delivery order
	 */
	@Override
	public String getGateKeeper(java.util.Locale locale) {
		return model.getGateKeeper(locale);
	}

	/**
	 * Returns the localized gate keeper of this delivery order in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized gate keeper of this delivery order. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getGateKeeper(java.util.Locale locale, boolean useDefault) {
		return model.getGateKeeper(locale, useDefault);
	}

	/**
	 * Returns the localized gate keeper of this delivery order in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized gate keeper of this delivery order
	 */
	@Override
	public String getGateKeeper(String languageId) {
		return model.getGateKeeper(languageId);
	}

	/**
	 * Returns the localized gate keeper of this delivery order in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized gate keeper of this delivery order
	 */
	@Override
	public String getGateKeeper(String languageId, boolean useDefault) {
		return model.getGateKeeper(languageId, useDefault);
	}

	@Override
	public String getGateKeeperCurrentLanguageId() {
		return model.getGateKeeperCurrentLanguageId();
	}

	@Override
	public String getGateKeeperCurrentValue() {
		return model.getGateKeeperCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized gate keepers of this delivery order.
	 *
	 * @return the locales and localized gate keepers of this delivery order
	 */
	@Override
	public Map<java.util.Locale, String> getGateKeeperMap() {
		return model.getGateKeeperMap();
	}

	/**
	 * Returns the goods issue date of this delivery order.
	 *
	 * @return the goods issue date of this delivery order
	 */
	@Override
	public String getGoodsIssueDate() {
		return model.getGoodsIssueDate();
	}

	/**
	 * Returns the indent ID of this delivery order.
	 *
	 * @return the indent ID of this delivery order
	 */
	@Override
	public long getIndentId() {
		return model.getIndentId();
	}

	/**
	 * Returns the khamaal no of this delivery order.
	 *
	 * @return the khamaal no of this delivery order
	 */
	@Override
	public String getKhamaalNo() {
		return model.getKhamaalNo();
	}

	/**
	 * Returns the l ua date of this delivery order.
	 *
	 * @return the l ua date of this delivery order
	 */
	@Override
	public Date getLUADate() {
		return model.getLUADate();
	}

	/**
	 * Returns the l ua no of this delivery order.
	 *
	 * @return the l ua no of this delivery order
	 */
	@Override
	public String getLUANo() {
		return model.getLUANo();
	}

	/**
	 * Returns the modified date of this delivery order.
	 *
	 * @return the modified date of this delivery order
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this delivery order.
	 *
	 * @return the name of this delivery order
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the localized name of this delivery order in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this delivery order
	 */
	@Override
	public String getName(java.util.Locale locale) {
		return model.getName(locale);
	}

	/**
	 * Returns the localized name of this delivery order in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this delivery order. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getName(java.util.Locale locale, boolean useDefault) {
		return model.getName(locale, useDefault);
	}

	/**
	 * Returns the localized name of this delivery order in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this delivery order
	 */
	@Override
	public String getName(String languageId) {
		return model.getName(languageId);
	}

	/**
	 * Returns the localized name of this delivery order in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this delivery order
	 */
	@Override
	public String getName(String languageId, boolean useDefault) {
		return model.getName(languageId, useDefault);
	}

	@Override
	public String getNameCurrentLanguageId() {
		return model.getNameCurrentLanguageId();
	}

	@Override
	public String getNameCurrentValue() {
		return model.getNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized names of this delivery order.
	 *
	 * @return the locales and localized names of this delivery order
	 */
	@Override
	public Map<java.util.Locale, String> getNameMap() {
		return model.getNameMap();
	}

	/**
	 * Returns the primary key of this delivery order.
	 *
	 * @return the primary key of this delivery order
	 */
	@Override
	public bd.gov.dgfood.common.services.service.persistence.DeliveryOrderPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the ship to party of this delivery order.
	 *
	 * @return the ship to party of this delivery order
	 */
	@Override
	public String getShipToParty() {
		return model.getShipToParty();
	}

	/**
	 * Returns the ship to party name of this delivery order.
	 *
	 * @return the ship to party name of this delivery order
	 */
	@Override
	public String getShipToPartyName() {
		return model.getShipToPartyName();
	}

	/**
	 * Returns the localized ship to party name of this delivery order in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized ship to party name of this delivery order
	 */
	@Override
	public String getShipToPartyName(java.util.Locale locale) {
		return model.getShipToPartyName(locale);
	}

	/**
	 * Returns the localized ship to party name of this delivery order in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized ship to party name of this delivery order. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getShipToPartyName(
		java.util.Locale locale, boolean useDefault) {

		return model.getShipToPartyName(locale, useDefault);
	}

	/**
	 * Returns the localized ship to party name of this delivery order in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized ship to party name of this delivery order
	 */
	@Override
	public String getShipToPartyName(String languageId) {
		return model.getShipToPartyName(languageId);
	}

	/**
	 * Returns the localized ship to party name of this delivery order in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized ship to party name of this delivery order
	 */
	@Override
	public String getShipToPartyName(String languageId, boolean useDefault) {
		return model.getShipToPartyName(languageId, useDefault);
	}

	@Override
	public String getShipToPartyNameCurrentLanguageId() {
		return model.getShipToPartyNameCurrentLanguageId();
	}

	@Override
	public String getShipToPartyNameCurrentValue() {
		return model.getShipToPartyNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized ship to party names of this delivery order.
	 *
	 * @return the locales and localized ship to party names of this delivery order
	 */
	@Override
	public Map<java.util.Locale, String> getShipToPartyNameMap() {
		return model.getShipToPartyNameMap();
	}

	/**
	 * Returns the status of this delivery order.
	 *
	 * @return the status of this delivery order
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the uuid of this delivery order.
	 *
	 * @return the uuid of this delivery order
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the vehicle no of this delivery order.
	 *
	 * @return the vehicle no of this delivery order
	 */
	@Override
	public String getVehicleNo() {
		return model.getVehicleNo();
	}

	/**
	 * Returns the warehouse no of this delivery order.
	 *
	 * @return the warehouse no of this delivery order
	 */
	@Override
	public String getWarehouseNo() {
		return model.getWarehouseNo();
	}

	@Override
	public void persist() {
		model.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
			java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	/**
	 * Sets the bag unit of this delivery order.
	 *
	 * @param bagUnit the bag unit of this delivery order
	 */
	@Override
	public void setBagUnit(String bagUnit) {
		model.setBagUnit(bagUnit);
	}

	/**
	 * Sets the localized bag unit of this delivery order in the language.
	 *
	 * @param bagUnit the localized bag unit of this delivery order
	 * @param locale the locale of the language
	 */
	@Override
	public void setBagUnit(String bagUnit, java.util.Locale locale) {
		model.setBagUnit(bagUnit, locale);
	}

	/**
	 * Sets the localized bag unit of this delivery order in the language, and sets the default locale.
	 *
	 * @param bagUnit the localized bag unit of this delivery order
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setBagUnit(
		String bagUnit, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setBagUnit(bagUnit, locale, defaultLocale);
	}

	@Override
	public void setBagUnitCurrentLanguageId(String languageId) {
		model.setBagUnitCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized bag units of this delivery order from the map of locales and localized bag units.
	 *
	 * @param bagUnitMap the locales and localized bag units of this delivery order
	 */
	@Override
	public void setBagUnitMap(Map<java.util.Locale, String> bagUnitMap) {
		model.setBagUnitMap(bagUnitMap);
	}

	/**
	 * Sets the localized bag units of this delivery order from the map of locales and localized bag units, and sets the default locale.
	 *
	 * @param bagUnitMap the locales and localized bag units of this delivery order
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setBagUnitMap(
		Map<java.util.Locale, String> bagUnitMap,
		java.util.Locale defaultLocale) {

		model.setBagUnitMap(bagUnitMap, defaultLocale);
	}

	/**
	 * Sets the commodity of this delivery order.
	 *
	 * @param commodity the commodity of this delivery order
	 */
	@Override
	public void setCommodity(String commodity) {
		model.setCommodity(commodity);
	}

	/**
	 * Sets the localized commodity of this delivery order in the language.
	 *
	 * @param commodity the localized commodity of this delivery order
	 * @param locale the locale of the language
	 */
	@Override
	public void setCommodity(String commodity, java.util.Locale locale) {
		model.setCommodity(commodity, locale);
	}

	/**
	 * Sets the localized commodity of this delivery order in the language, and sets the default locale.
	 *
	 * @param commodity the localized commodity of this delivery order
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setCommodity(
		String commodity, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setCommodity(commodity, locale, defaultLocale);
	}

	@Override
	public void setCommodityCurrentLanguageId(String languageId) {
		model.setCommodityCurrentLanguageId(languageId);
	}

	/**
	 * Sets the commodity description of this delivery order.
	 *
	 * @param commodityDescription the commodity description of this delivery order
	 */
	@Override
	public void setCommodityDescription(String commodityDescription) {
		model.setCommodityDescription(commodityDescription);
	}

	/**
	 * Sets the localized commodity description of this delivery order in the language.
	 *
	 * @param commodityDescription the localized commodity description of this delivery order
	 * @param locale the locale of the language
	 */
	@Override
	public void setCommodityDescription(
		String commodityDescription, java.util.Locale locale) {

		model.setCommodityDescription(commodityDescription, locale);
	}

	/**
	 * Sets the localized commodity description of this delivery order in the language, and sets the default locale.
	 *
	 * @param commodityDescription the localized commodity description of this delivery order
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setCommodityDescription(
		String commodityDescription, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setCommodityDescription(
			commodityDescription, locale, defaultLocale);
	}

	@Override
	public void setCommodityDescriptionCurrentLanguageId(String languageId) {
		model.setCommodityDescriptionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized commodity descriptions of this delivery order from the map of locales and localized commodity descriptions.
	 *
	 * @param commodityDescriptionMap the locales and localized commodity descriptions of this delivery order
	 */
	@Override
	public void setCommodityDescriptionMap(
		Map<java.util.Locale, String> commodityDescriptionMap) {

		model.setCommodityDescriptionMap(commodityDescriptionMap);
	}

	/**
	 * Sets the localized commodity descriptions of this delivery order from the map of locales and localized commodity descriptions, and sets the default locale.
	 *
	 * @param commodityDescriptionMap the locales and localized commodity descriptions of this delivery order
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setCommodityDescriptionMap(
		Map<java.util.Locale, String> commodityDescriptionMap,
		java.util.Locale defaultLocale) {

		model.setCommodityDescriptionMap(
			commodityDescriptionMap, defaultLocale);
	}

	/**
	 * Sets the localized commodities of this delivery order from the map of locales and localized commodities.
	 *
	 * @param commodityMap the locales and localized commodities of this delivery order
	 */
	@Override
	public void setCommodityMap(Map<java.util.Locale, String> commodityMap) {
		model.setCommodityMap(commodityMap);
	}

	/**
	 * Sets the localized commodities of this delivery order from the map of locales and localized commodities, and sets the default locale.
	 *
	 * @param commodityMap the locales and localized commodities of this delivery order
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setCommodityMap(
		Map<java.util.Locale, String> commodityMap,
		java.util.Locale defaultLocale) {

		model.setCommodityMap(commodityMap, defaultLocale);
	}

	/**
	 * Sets the company ID of this delivery order.
	 *
	 * @param companyId the company ID of this delivery order
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this delivery order.
	 *
	 * @param createDate the create date of this delivery order
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the customer no of this delivery order.
	 *
	 * @param customerNo the customer no of this delivery order
	 */
	@Override
	public void setCustomerNo(String customerNo) {
		model.setCustomerNo(customerNo);
	}

	/**
	 * Sets the delivered qty of this delivery order.
	 *
	 * @param deliveredQty the delivered qty of this delivery order
	 */
	@Override
	public void setDeliveredQty(String deliveredQty) {
		model.setDeliveredQty(deliveredQty);
	}

	/**
	 * Sets the localized delivered qty of this delivery order in the language.
	 *
	 * @param deliveredQty the localized delivered qty of this delivery order
	 * @param locale the locale of the language
	 */
	@Override
	public void setDeliveredQty(String deliveredQty, java.util.Locale locale) {
		model.setDeliveredQty(deliveredQty, locale);
	}

	/**
	 * Sets the localized delivered qty of this delivery order in the language, and sets the default locale.
	 *
	 * @param deliveredQty the localized delivered qty of this delivery order
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDeliveredQty(
		String deliveredQty, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setDeliveredQty(deliveredQty, locale, defaultLocale);
	}

	@Override
	public void setDeliveredQtyCurrentLanguageId(String languageId) {
		model.setDeliveredQtyCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized delivered qties of this delivery order from the map of locales and localized delivered qties.
	 *
	 * @param deliveredQtyMap the locales and localized delivered qties of this delivery order
	 */
	@Override
	public void setDeliveredQtyMap(
		Map<java.util.Locale, String> deliveredQtyMap) {

		model.setDeliveredQtyMap(deliveredQtyMap);
	}

	/**
	 * Sets the localized delivered qties of this delivery order from the map of locales and localized delivered qties, and sets the default locale.
	 *
	 * @param deliveredQtyMap the locales and localized delivered qties of this delivery order
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDeliveredQtyMap(
		Map<java.util.Locale, String> deliveredQtyMap,
		java.util.Locale defaultLocale) {

		model.setDeliveredQtyMap(deliveredQtyMap, defaultLocale);
	}

	/**
	 * Sets the delivered qty unit of this delivery order.
	 *
	 * @param deliveredQtyUnit the delivered qty unit of this delivery order
	 */
	@Override
	public void setDeliveredQtyUnit(String deliveredQtyUnit) {
		model.setDeliveredQtyUnit(deliveredQtyUnit);
	}

	/**
	 * Sets the localized delivered qty unit of this delivery order in the language.
	 *
	 * @param deliveredQtyUnit the localized delivered qty unit of this delivery order
	 * @param locale the locale of the language
	 */
	@Override
	public void setDeliveredQtyUnit(
		String deliveredQtyUnit, java.util.Locale locale) {

		model.setDeliveredQtyUnit(deliveredQtyUnit, locale);
	}

	/**
	 * Sets the localized delivered qty unit of this delivery order in the language, and sets the default locale.
	 *
	 * @param deliveredQtyUnit the localized delivered qty unit of this delivery order
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDeliveredQtyUnit(
		String deliveredQtyUnit, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setDeliveredQtyUnit(deliveredQtyUnit, locale, defaultLocale);
	}

	@Override
	public void setDeliveredQtyUnitCurrentLanguageId(String languageId) {
		model.setDeliveredQtyUnitCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized delivered qty units of this delivery order from the map of locales and localized delivered qty units.
	 *
	 * @param deliveredQtyUnitMap the locales and localized delivered qty units of this delivery order
	 */
	@Override
	public void setDeliveredQtyUnitMap(
		Map<java.util.Locale, String> deliveredQtyUnitMap) {

		model.setDeliveredQtyUnitMap(deliveredQtyUnitMap);
	}

	/**
	 * Sets the localized delivered qty units of this delivery order from the map of locales and localized delivered qty units, and sets the default locale.
	 *
	 * @param deliveredQtyUnitMap the locales and localized delivered qty units of this delivery order
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDeliveredQtyUnitMap(
		Map<java.util.Locale, String> deliveredQtyUnitMap,
		java.util.Locale defaultLocale) {

		model.setDeliveredQtyUnitMap(deliveredQtyUnitMap, defaultLocale);
	}

	/**
	 * Sets the delivery order ID of this delivery order.
	 *
	 * @param deliveryOrderId the delivery order ID of this delivery order
	 */
	@Override
	public void setDeliveryOrderId(long deliveryOrderId) {
		model.setDeliveryOrderId(deliveryOrderId);
	}

	/**
	 * Sets the delivery order no of this delivery order.
	 *
	 * @param deliveryOrderNo the delivery order no of this delivery order
	 */
	@Override
	public void setDeliveryOrderNo(String deliveryOrderNo) {
		model.setDeliveryOrderNo(deliveryOrderNo);
	}

	/**
	 * Sets the depo of this delivery order.
	 *
	 * @param depo the depo of this delivery order
	 */
	@Override
	public void setDepo(String depo) {
		model.setDepo(depo);
	}

	/**
	 * Sets the localized depo of this delivery order in the language.
	 *
	 * @param depo the localized depo of this delivery order
	 * @param locale the locale of the language
	 */
	@Override
	public void setDepo(String depo, java.util.Locale locale) {
		model.setDepo(depo, locale);
	}

	/**
	 * Sets the localized depo of this delivery order in the language, and sets the default locale.
	 *
	 * @param depo the localized depo of this delivery order
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDepo(
		String depo, java.util.Locale locale, java.util.Locale defaultLocale) {

		model.setDepo(depo, locale, defaultLocale);
	}

	@Override
	public void setDepoCurrentLanguageId(String languageId) {
		model.setDepoCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized depos of this delivery order from the map of locales and localized depos.
	 *
	 * @param depoMap the locales and localized depos of this delivery order
	 */
	@Override
	public void setDepoMap(Map<java.util.Locale, String> depoMap) {
		model.setDepoMap(depoMap);
	}

	/**
	 * Sets the localized depos of this delivery order from the map of locales and localized depos, and sets the default locale.
	 *
	 * @param depoMap the locales and localized depos of this delivery order
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDepoMap(
		Map<java.util.Locale, String> depoMap, java.util.Locale defaultLocale) {

		model.setDepoMap(depoMap, defaultLocale);
	}

	/**
	 * Sets the do date of this delivery order.
	 *
	 * @param doDate the do date of this delivery order
	 */
	@Override
	public void setDoDate(Date doDate) {
		model.setDoDate(doDate);
	}

	/**
	 * Sets the do qty of this delivery order.
	 *
	 * @param doQty the do qty of this delivery order
	 */
	@Override
	public void setDoQty(String doQty) {
		model.setDoQty(doQty);
	}

	/**
	 * Sets the localized do qty of this delivery order in the language.
	 *
	 * @param doQty the localized do qty of this delivery order
	 * @param locale the locale of the language
	 */
	@Override
	public void setDoQty(String doQty, java.util.Locale locale) {
		model.setDoQty(doQty, locale);
	}

	/**
	 * Sets the localized do qty of this delivery order in the language, and sets the default locale.
	 *
	 * @param doQty the localized do qty of this delivery order
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDoQty(
		String doQty, java.util.Locale locale, java.util.Locale defaultLocale) {

		model.setDoQty(doQty, locale, defaultLocale);
	}

	@Override
	public void setDoQtyCurrentLanguageId(String languageId) {
		model.setDoQtyCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized do qties of this delivery order from the map of locales and localized do qties.
	 *
	 * @param doQtyMap the locales and localized do qties of this delivery order
	 */
	@Override
	public void setDoQtyMap(Map<java.util.Locale, String> doQtyMap) {
		model.setDoQtyMap(doQtyMap);
	}

	/**
	 * Sets the localized do qties of this delivery order from the map of locales and localized do qties, and sets the default locale.
	 *
	 * @param doQtyMap the locales and localized do qties of this delivery order
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDoQtyMap(
		Map<java.util.Locale, String> doQtyMap,
		java.util.Locale defaultLocale) {

		model.setDoQtyMap(doQtyMap, defaultLocale);
	}

	/**
	 * Sets the do qty unit of this delivery order.
	 *
	 * @param doQtyUnit the do qty unit of this delivery order
	 */
	@Override
	public void setDoQtyUnit(String doQtyUnit) {
		model.setDoQtyUnit(doQtyUnit);
	}

	/**
	 * Sets the localized do qty unit of this delivery order in the language.
	 *
	 * @param doQtyUnit the localized do qty unit of this delivery order
	 * @param locale the locale of the language
	 */
	@Override
	public void setDoQtyUnit(String doQtyUnit, java.util.Locale locale) {
		model.setDoQtyUnit(doQtyUnit, locale);
	}

	/**
	 * Sets the localized do qty unit of this delivery order in the language, and sets the default locale.
	 *
	 * @param doQtyUnit the localized do qty unit of this delivery order
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDoQtyUnit(
		String doQtyUnit, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setDoQtyUnit(doQtyUnit, locale, defaultLocale);
	}

	@Override
	public void setDoQtyUnitCurrentLanguageId(String languageId) {
		model.setDoQtyUnitCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized do qty units of this delivery order from the map of locales and localized do qty units.
	 *
	 * @param doQtyUnitMap the locales and localized do qty units of this delivery order
	 */
	@Override
	public void setDoQtyUnitMap(Map<java.util.Locale, String> doQtyUnitMap) {
		model.setDoQtyUnitMap(doQtyUnitMap);
	}

	/**
	 * Sets the localized do qty units of this delivery order from the map of locales and localized do qty units, and sets the default locale.
	 *
	 * @param doQtyUnitMap the locales and localized do qty units of this delivery order
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDoQtyUnitMap(
		Map<java.util.Locale, String> doQtyUnitMap,
		java.util.Locale defaultLocale) {

		model.setDoQtyUnitMap(doQtyUnitMap, defaultLocale);
	}

	/**
	 * Sets the gate keeper of this delivery order.
	 *
	 * @param gateKeeper the gate keeper of this delivery order
	 */
	@Override
	public void setGateKeeper(String gateKeeper) {
		model.setGateKeeper(gateKeeper);
	}

	/**
	 * Sets the localized gate keeper of this delivery order in the language.
	 *
	 * @param gateKeeper the localized gate keeper of this delivery order
	 * @param locale the locale of the language
	 */
	@Override
	public void setGateKeeper(String gateKeeper, java.util.Locale locale) {
		model.setGateKeeper(gateKeeper, locale);
	}

	/**
	 * Sets the localized gate keeper of this delivery order in the language, and sets the default locale.
	 *
	 * @param gateKeeper the localized gate keeper of this delivery order
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setGateKeeper(
		String gateKeeper, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setGateKeeper(gateKeeper, locale, defaultLocale);
	}

	@Override
	public void setGateKeeperCurrentLanguageId(String languageId) {
		model.setGateKeeperCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized gate keepers of this delivery order from the map of locales and localized gate keepers.
	 *
	 * @param gateKeeperMap the locales and localized gate keepers of this delivery order
	 */
	@Override
	public void setGateKeeperMap(Map<java.util.Locale, String> gateKeeperMap) {
		model.setGateKeeperMap(gateKeeperMap);
	}

	/**
	 * Sets the localized gate keepers of this delivery order from the map of locales and localized gate keepers, and sets the default locale.
	 *
	 * @param gateKeeperMap the locales and localized gate keepers of this delivery order
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setGateKeeperMap(
		Map<java.util.Locale, String> gateKeeperMap,
		java.util.Locale defaultLocale) {

		model.setGateKeeperMap(gateKeeperMap, defaultLocale);
	}

	/**
	 * Sets the goods issue date of this delivery order.
	 *
	 * @param goodsIssueDate the goods issue date of this delivery order
	 */
	@Override
	public void setGoodsIssueDate(String goodsIssueDate) {
		model.setGoodsIssueDate(goodsIssueDate);
	}

	/**
	 * Sets the indent ID of this delivery order.
	 *
	 * @param indentId the indent ID of this delivery order
	 */
	@Override
	public void setIndentId(long indentId) {
		model.setIndentId(indentId);
	}

	/**
	 * Sets the khamaal no of this delivery order.
	 *
	 * @param khamaalNo the khamaal no of this delivery order
	 */
	@Override
	public void setKhamaalNo(String khamaalNo) {
		model.setKhamaalNo(khamaalNo);
	}

	/**
	 * Sets the l ua date of this delivery order.
	 *
	 * @param lUADate the l ua date of this delivery order
	 */
	@Override
	public void setLUADate(Date lUADate) {
		model.setLUADate(lUADate);
	}

	/**
	 * Sets the l ua no of this delivery order.
	 *
	 * @param lUANo the l ua no of this delivery order
	 */
	@Override
	public void setLUANo(String lUANo) {
		model.setLUANo(lUANo);
	}

	/**
	 * Sets the modified date of this delivery order.
	 *
	 * @param modifiedDate the modified date of this delivery order
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this delivery order.
	 *
	 * @param name the name of this delivery order
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the localized name of this delivery order in the language.
	 *
	 * @param name the localized name of this delivery order
	 * @param locale the locale of the language
	 */
	@Override
	public void setName(String name, java.util.Locale locale) {
		model.setName(name, locale);
	}

	/**
	 * Sets the localized name of this delivery order in the language, and sets the default locale.
	 *
	 * @param name the localized name of this delivery order
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setName(
		String name, java.util.Locale locale, java.util.Locale defaultLocale) {

		model.setName(name, locale, defaultLocale);
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		model.setNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized names of this delivery order from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this delivery order
	 */
	@Override
	public void setNameMap(Map<java.util.Locale, String> nameMap) {
		model.setNameMap(nameMap);
	}

	/**
	 * Sets the localized names of this delivery order from the map of locales and localized names, and sets the default locale.
	 *
	 * @param nameMap the locales and localized names of this delivery order
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setNameMap(
		Map<java.util.Locale, String> nameMap, java.util.Locale defaultLocale) {

		model.setNameMap(nameMap, defaultLocale);
	}

	/**
	 * Sets the primary key of this delivery order.
	 *
	 * @param primaryKey the primary key of this delivery order
	 */
	@Override
	public void setPrimaryKey(
		bd.gov.dgfood.common.services.service.persistence.DeliveryOrderPK
			primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the ship to party of this delivery order.
	 *
	 * @param shipToParty the ship to party of this delivery order
	 */
	@Override
	public void setShipToParty(String shipToParty) {
		model.setShipToParty(shipToParty);
	}

	/**
	 * Sets the ship to party name of this delivery order.
	 *
	 * @param shipToPartyName the ship to party name of this delivery order
	 */
	@Override
	public void setShipToPartyName(String shipToPartyName) {
		model.setShipToPartyName(shipToPartyName);
	}

	/**
	 * Sets the localized ship to party name of this delivery order in the language.
	 *
	 * @param shipToPartyName the localized ship to party name of this delivery order
	 * @param locale the locale of the language
	 */
	@Override
	public void setShipToPartyName(
		String shipToPartyName, java.util.Locale locale) {

		model.setShipToPartyName(shipToPartyName, locale);
	}

	/**
	 * Sets the localized ship to party name of this delivery order in the language, and sets the default locale.
	 *
	 * @param shipToPartyName the localized ship to party name of this delivery order
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setShipToPartyName(
		String shipToPartyName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setShipToPartyName(shipToPartyName, locale, defaultLocale);
	}

	@Override
	public void setShipToPartyNameCurrentLanguageId(String languageId) {
		model.setShipToPartyNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized ship to party names of this delivery order from the map of locales and localized ship to party names.
	 *
	 * @param shipToPartyNameMap the locales and localized ship to party names of this delivery order
	 */
	@Override
	public void setShipToPartyNameMap(
		Map<java.util.Locale, String> shipToPartyNameMap) {

		model.setShipToPartyNameMap(shipToPartyNameMap);
	}

	/**
	 * Sets the localized ship to party names of this delivery order from the map of locales and localized ship to party names, and sets the default locale.
	 *
	 * @param shipToPartyNameMap the locales and localized ship to party names of this delivery order
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setShipToPartyNameMap(
		Map<java.util.Locale, String> shipToPartyNameMap,
		java.util.Locale defaultLocale) {

		model.setShipToPartyNameMap(shipToPartyNameMap, defaultLocale);
	}

	/**
	 * Sets the status of this delivery order.
	 *
	 * @param status the status of this delivery order
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the uuid of this delivery order.
	 *
	 * @param uuid the uuid of this delivery order
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the vehicle no of this delivery order.
	 *
	 * @param vehicleNo the vehicle no of this delivery order
	 */
	@Override
	public void setVehicleNo(String vehicleNo) {
		model.setVehicleNo(vehicleNo);
	}

	/**
	 * Sets the warehouse no of this delivery order.
	 *
	 * @param warehouseNo the warehouse no of this delivery order
	 */
	@Override
	public void setWarehouseNo(String warehouseNo) {
		model.setWarehouseNo(warehouseNo);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected DeliveryOrderWrapper wrap(DeliveryOrder deliveryOrder) {
		return new DeliveryOrderWrapper(deliveryOrder);
	}

}