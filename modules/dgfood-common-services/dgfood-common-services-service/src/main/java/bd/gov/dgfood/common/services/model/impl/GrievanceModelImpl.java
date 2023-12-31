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

package bd.gov.dgfood.common.services.model.impl;

import bd.gov.dgfood.common.services.model.Grievance;
import bd.gov.dgfood.common.services.model.GrievanceModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Grievance service. Represents a row in the &quot;DGF_Grievance&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>GrievanceModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link GrievanceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GrievanceImpl
 * @generated
 */
@JSON(strict = true)
public class GrievanceModelImpl
	extends BaseModelImpl<Grievance> implements GrievanceModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a grievance model instance should use the <code>Grievance</code> interface instead.
	 */
	public static final String TABLE_NAME = "DGF_Grievance";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"grievanceId", Types.BIGINT},
		{"grievanceNumber", Types.VARCHAR}, {"companyId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"grievanceCategory", Types.BIGINT},
		{"userType", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"userID", Types.BIGINT}, {"mobileNumber", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"complaintDetails", Types.VARCHAR},
		{"attachmentId", Types.BIGINT}, {"status", Types.INTEGER},
		{"responseDetails", Types.VARCHAR}, {"responseDate", Types.TIMESTAMP},
		{"responseBy", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("grievanceId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("grievanceNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("grievanceCategory", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userType", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("userID", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("mobileNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("complaintDetails", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("attachmentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("responseDetails", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("responseDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("responseBy", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table DGF_Grievance (uuid_ VARCHAR(75) null,grievanceId LONG not null primary key,grievanceNumber VARCHAR(75) null,companyId LONG,groupId LONG,grievanceCategory LONG,userType LONG,userName VARCHAR(75) null,userID LONG,mobileNumber VARCHAR(75) null,createDate DATE null,complaintDetails STRING null,attachmentId LONG,status INTEGER,responseDetails STRING null,responseDate DATE null,responseBy LONG)";

	public static final String TABLE_SQL_DROP = "drop table DGF_Grievance";

	public static final String ORDER_BY_JPQL =
		" ORDER BY grievance.grievanceId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY DGF_Grievance.grievanceId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GRIEVANCEID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public GrievanceModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _grievanceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGrievanceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _grievanceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Grievance.class;
	}

	@Override
	public String getModelClassName() {
		return Grievance.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Grievance, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Grievance, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Grievance, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Grievance)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Grievance, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Grievance, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Grievance)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Grievance, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Grievance, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Grievance, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Grievance, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Grievance, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Grievance, Object>>();
		Map<String, BiConsumer<Grievance, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Grievance, ?>>();

		attributeGetterFunctions.put("uuid", Grievance::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Grievance, String>)Grievance::setUuid);
		attributeGetterFunctions.put("grievanceId", Grievance::getGrievanceId);
		attributeSetterBiConsumers.put(
			"grievanceId",
			(BiConsumer<Grievance, Long>)Grievance::setGrievanceId);
		attributeGetterFunctions.put(
			"grievanceNumber", Grievance::getGrievanceNumber);
		attributeSetterBiConsumers.put(
			"grievanceNumber",
			(BiConsumer<Grievance, String>)Grievance::setGrievanceNumber);
		attributeGetterFunctions.put("companyId", Grievance::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Grievance, Long>)Grievance::setCompanyId);
		attributeGetterFunctions.put("groupId", Grievance::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Grievance, Long>)Grievance::setGroupId);
		attributeGetterFunctions.put(
			"grievanceCategory", Grievance::getGrievanceCategory);
		attributeSetterBiConsumers.put(
			"grievanceCategory",
			(BiConsumer<Grievance, Long>)Grievance::setGrievanceCategory);
		attributeGetterFunctions.put("userType", Grievance::getUserType);
		attributeSetterBiConsumers.put(
			"userType", (BiConsumer<Grievance, Long>)Grievance::setUserType);
		attributeGetterFunctions.put("userName", Grievance::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<Grievance, String>)Grievance::setUserName);
		attributeGetterFunctions.put("userID", Grievance::getUserID);
		attributeSetterBiConsumers.put(
			"userID", (BiConsumer<Grievance, Long>)Grievance::setUserID);
		attributeGetterFunctions.put(
			"mobileNumber", Grievance::getMobileNumber);
		attributeSetterBiConsumers.put(
			"mobileNumber",
			(BiConsumer<Grievance, String>)Grievance::setMobileNumber);
		attributeGetterFunctions.put("createDate", Grievance::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<Grievance, Date>)Grievance::setCreateDate);
		attributeGetterFunctions.put(
			"complaintDetails", Grievance::getComplaintDetails);
		attributeSetterBiConsumers.put(
			"complaintDetails",
			(BiConsumer<Grievance, String>)Grievance::setComplaintDetails);
		attributeGetterFunctions.put(
			"attachmentId", Grievance::getAttachmentId);
		attributeSetterBiConsumers.put(
			"attachmentId",
			(BiConsumer<Grievance, Long>)Grievance::setAttachmentId);
		attributeGetterFunctions.put("status", Grievance::getStatus);
		attributeSetterBiConsumers.put(
			"status", (BiConsumer<Grievance, Integer>)Grievance::setStatus);
		attributeGetterFunctions.put(
			"responseDetails", Grievance::getResponseDetails);
		attributeSetterBiConsumers.put(
			"responseDetails",
			(BiConsumer<Grievance, String>)Grievance::setResponseDetails);
		attributeGetterFunctions.put(
			"responseDate", Grievance::getResponseDate);
		attributeSetterBiConsumers.put(
			"responseDate",
			(BiConsumer<Grievance, Date>)Grievance::setResponseDate);
		attributeGetterFunctions.put("responseBy", Grievance::getResponseBy);
		attributeSetterBiConsumers.put(
			"responseBy",
			(BiConsumer<Grievance, Long>)Grievance::setResponseBy);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getGrievanceId() {
		return _grievanceId;
	}

	@Override
	public void setGrievanceId(long grievanceId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_grievanceId = grievanceId;
	}

	@JSON
	@Override
	public String getGrievanceNumber() {
		if (_grievanceNumber == null) {
			return "";
		}
		else {
			return _grievanceNumber;
		}
	}

	@Override
	public void setGrievanceNumber(String grievanceNumber) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_grievanceNumber = grievanceNumber;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@JSON
	@Override
	public long getGrievanceCategory() {
		return _grievanceCategory;
	}

	@Override
	public void setGrievanceCategory(long grievanceCategory) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_grievanceCategory = grievanceCategory;
	}

	@JSON
	@Override
	public long getUserType() {
		return _userType;
	}

	@Override
	public void setUserType(long userType) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userType = userType;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public long getUserID() {
		return _userID;
	}

	@Override
	public void setUserID(long userID) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userID = userID;
	}

	@JSON
	@Override
	public String getMobileNumber() {
		if (_mobileNumber == null) {
			return "";
		}
		else {
			return _mobileNumber;
		}
	}

	@Override
	public void setMobileNumber(String mobileNumber) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_mobileNumber = mobileNumber;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public String getComplaintDetails() {
		if (_complaintDetails == null) {
			return "";
		}
		else {
			return _complaintDetails;
		}
	}

	@Override
	public void setComplaintDetails(String complaintDetails) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_complaintDetails = complaintDetails;
	}

	@JSON
	@Override
	public long getAttachmentId() {
		return _attachmentId;
	}

	@Override
	public void setAttachmentId(long attachmentId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_attachmentId = attachmentId;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_status = status;
	}

	@JSON
	@Override
	public String getResponseDetails() {
		if (_responseDetails == null) {
			return "";
		}
		else {
			return _responseDetails;
		}
	}

	@Override
	public void setResponseDetails(String responseDetails) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_responseDetails = responseDetails;
	}

	@JSON
	@Override
	public Date getResponseDate() {
		return _responseDate;
	}

	@Override
	public void setResponseDate(Date responseDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_responseDate = responseDate;
	}

	@JSON
	@Override
	public long getResponseBy() {
		return _responseBy;
	}

	@Override
	public void setResponseBy(long responseBy) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_responseBy = responseBy;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Grievance.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Grievance toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Grievance>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		GrievanceImpl grievanceImpl = new GrievanceImpl();

		grievanceImpl.setUuid(getUuid());
		grievanceImpl.setGrievanceId(getGrievanceId());
		grievanceImpl.setGrievanceNumber(getGrievanceNumber());
		grievanceImpl.setCompanyId(getCompanyId());
		grievanceImpl.setGroupId(getGroupId());
		grievanceImpl.setGrievanceCategory(getGrievanceCategory());
		grievanceImpl.setUserType(getUserType());
		grievanceImpl.setUserName(getUserName());
		grievanceImpl.setUserID(getUserID());
		grievanceImpl.setMobileNumber(getMobileNumber());
		grievanceImpl.setCreateDate(getCreateDate());
		grievanceImpl.setComplaintDetails(getComplaintDetails());
		grievanceImpl.setAttachmentId(getAttachmentId());
		grievanceImpl.setStatus(getStatus());
		grievanceImpl.setResponseDetails(getResponseDetails());
		grievanceImpl.setResponseDate(getResponseDate());
		grievanceImpl.setResponseBy(getResponseBy());

		grievanceImpl.resetOriginalValues();

		return grievanceImpl;
	}

	@Override
	public Grievance cloneWithOriginalValues() {
		GrievanceImpl grievanceImpl = new GrievanceImpl();

		grievanceImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		grievanceImpl.setGrievanceId(
			this.<Long>getColumnOriginalValue("grievanceId"));
		grievanceImpl.setGrievanceNumber(
			this.<String>getColumnOriginalValue("grievanceNumber"));
		grievanceImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		grievanceImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		grievanceImpl.setGrievanceCategory(
			this.<Long>getColumnOriginalValue("grievanceCategory"));
		grievanceImpl.setUserType(
			this.<Long>getColumnOriginalValue("userType"));
		grievanceImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		grievanceImpl.setUserID(this.<Long>getColumnOriginalValue("userID"));
		grievanceImpl.setMobileNumber(
			this.<String>getColumnOriginalValue("mobileNumber"));
		grievanceImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		grievanceImpl.setComplaintDetails(
			this.<String>getColumnOriginalValue("complaintDetails"));
		grievanceImpl.setAttachmentId(
			this.<Long>getColumnOriginalValue("attachmentId"));
		grievanceImpl.setStatus(this.<Integer>getColumnOriginalValue("status"));
		grievanceImpl.setResponseDetails(
			this.<String>getColumnOriginalValue("responseDetails"));
		grievanceImpl.setResponseDate(
			this.<Date>getColumnOriginalValue("responseDate"));
		grievanceImpl.setResponseBy(
			this.<Long>getColumnOriginalValue("responseBy"));

		return grievanceImpl;
	}

	@Override
	public int compareTo(Grievance grievance) {
		long primaryKey = grievance.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Grievance)) {
			return false;
		}

		Grievance grievance = (Grievance)object;

		long primaryKey = grievance.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Grievance> toCacheModel() {
		GrievanceCacheModel grievanceCacheModel = new GrievanceCacheModel();

		grievanceCacheModel.uuid = getUuid();

		String uuid = grievanceCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			grievanceCacheModel.uuid = null;
		}

		grievanceCacheModel.grievanceId = getGrievanceId();

		grievanceCacheModel.grievanceNumber = getGrievanceNumber();

		String grievanceNumber = grievanceCacheModel.grievanceNumber;

		if ((grievanceNumber != null) && (grievanceNumber.length() == 0)) {
			grievanceCacheModel.grievanceNumber = null;
		}

		grievanceCacheModel.companyId = getCompanyId();

		grievanceCacheModel.groupId = getGroupId();

		grievanceCacheModel.grievanceCategory = getGrievanceCategory();

		grievanceCacheModel.userType = getUserType();

		grievanceCacheModel.userName = getUserName();

		String userName = grievanceCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			grievanceCacheModel.userName = null;
		}

		grievanceCacheModel.userID = getUserID();

		grievanceCacheModel.mobileNumber = getMobileNumber();

		String mobileNumber = grievanceCacheModel.mobileNumber;

		if ((mobileNumber != null) && (mobileNumber.length() == 0)) {
			grievanceCacheModel.mobileNumber = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			grievanceCacheModel.createDate = createDate.getTime();
		}
		else {
			grievanceCacheModel.createDate = Long.MIN_VALUE;
		}

		grievanceCacheModel.complaintDetails = getComplaintDetails();

		String complaintDetails = grievanceCacheModel.complaintDetails;

		if ((complaintDetails != null) && (complaintDetails.length() == 0)) {
			grievanceCacheModel.complaintDetails = null;
		}

		grievanceCacheModel.attachmentId = getAttachmentId();

		grievanceCacheModel.status = getStatus();

		grievanceCacheModel.responseDetails = getResponseDetails();

		String responseDetails = grievanceCacheModel.responseDetails;

		if ((responseDetails != null) && (responseDetails.length() == 0)) {
			grievanceCacheModel.responseDetails = null;
		}

		Date responseDate = getResponseDate();

		if (responseDate != null) {
			grievanceCacheModel.responseDate = responseDate.getTime();
		}
		else {
			grievanceCacheModel.responseDate = Long.MIN_VALUE;
		}

		grievanceCacheModel.responseBy = getResponseBy();

		return grievanceCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Grievance, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Grievance, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Grievance, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Grievance)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Grievance, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Grievance, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Grievance, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Grievance)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Grievance>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Grievance.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _grievanceId;
	private String _grievanceNumber;
	private long _companyId;
	private long _groupId;
	private long _grievanceCategory;
	private long _userType;
	private String _userName;
	private long _userID;
	private String _mobileNumber;
	private Date _createDate;
	private String _complaintDetails;
	private long _attachmentId;
	private int _status;
	private String _responseDetails;
	private Date _responseDate;
	private long _responseBy;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Grievance, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Grievance)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("grievanceId", _grievanceId);
		_columnOriginalValues.put("grievanceNumber", _grievanceNumber);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("grievanceCategory", _grievanceCategory);
		_columnOriginalValues.put("userType", _userType);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("userID", _userID);
		_columnOriginalValues.put("mobileNumber", _mobileNumber);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("complaintDetails", _complaintDetails);
		_columnOriginalValues.put("attachmentId", _attachmentId);
		_columnOriginalValues.put("status", _status);
		_columnOriginalValues.put("responseDetails", _responseDetails);
		_columnOriginalValues.put("responseDate", _responseDate);
		_columnOriginalValues.put("responseBy", _responseBy);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("grievanceId", 2L);

		columnBitmasks.put("grievanceNumber", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("groupId", 16L);

		columnBitmasks.put("grievanceCategory", 32L);

		columnBitmasks.put("userType", 64L);

		columnBitmasks.put("userName", 128L);

		columnBitmasks.put("userID", 256L);

		columnBitmasks.put("mobileNumber", 512L);

		columnBitmasks.put("createDate", 1024L);

		columnBitmasks.put("complaintDetails", 2048L);

		columnBitmasks.put("attachmentId", 4096L);

		columnBitmasks.put("status", 8192L);

		columnBitmasks.put("responseDetails", 16384L);

		columnBitmasks.put("responseDate", 32768L);

		columnBitmasks.put("responseBy", 65536L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Grievance _escapedModel;

}