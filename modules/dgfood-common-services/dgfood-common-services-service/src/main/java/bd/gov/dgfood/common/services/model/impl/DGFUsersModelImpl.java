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

import bd.gov.dgfood.common.services.model.DGFUsers;
import bd.gov.dgfood.common.services.model.DGFUsersModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
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
 * The base model implementation for the DGFUsers service. Represents a row in the &quot;DGF_Users&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DGFUsersModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DGFUsersImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DGFUsersImpl
 * @generated
 */
@JSON(strict = true)
public class DGFUsersModelImpl
	extends BaseModelImpl<DGFUsers> implements DGFUsersModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dgf users model instance should use the <code>DGFUsers</code> interface instead.
	 */
	public static final String TABLE_NAME = "DGF_Users";

	public static final Object[][] TABLE_COLUMNS = {
		{"dgfUserId", Types.BIGINT}, {"nationalId", Types.VARCHAR},
		{"password_", Types.VARCHAR}, {"mobileNumber", Types.VARCHAR},
		{"email", Types.VARCHAR}, {"birthDate", Types.TIMESTAMP},
		{"maritalStatus", Types.VARCHAR}, {"userId", Types.BIGINT},
		{"presentAddressId", Types.BIGINT}, {"profileType", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("dgfUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("nationalId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("password_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("mobileNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("birthDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("maritalStatus", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("presentAddressId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("profileType", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table DGF_Users (dgfUserId LONG not null primary key,nationalId VARCHAR(75) null,password_ VARCHAR(75) null,mobileNumber VARCHAR(75) null,email VARCHAR(75) null,birthDate DATE null,maritalStatus VARCHAR(75) null,userId LONG,presentAddressId LONG,profileType VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table DGF_Users";

	public static final String ORDER_BY_JPQL =
		" ORDER BY dgfUsers.dgfUserId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY DGF_Users.dgfUserId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long NATIONALID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long DGFUSERID_COLUMN_BITMASK = 2L;

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

	public DGFUsersModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _dgfUserId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDgfUserId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dgfUserId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DGFUsers.class;
	}

	@Override
	public String getModelClassName() {
		return DGFUsers.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DGFUsers, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DGFUsers, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DGFUsers, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((DGFUsers)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DGFUsers, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DGFUsers, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DGFUsers)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DGFUsers, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DGFUsers, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<DGFUsers, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<DGFUsers, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<DGFUsers, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<DGFUsers, Object>>();
		Map<String, BiConsumer<DGFUsers, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<DGFUsers, ?>>();

		attributeGetterFunctions.put("dgfUserId", DGFUsers::getDgfUserId);
		attributeSetterBiConsumers.put(
			"dgfUserId", (BiConsumer<DGFUsers, Long>)DGFUsers::setDgfUserId);
		attributeGetterFunctions.put("nationalId", DGFUsers::getNationalId);
		attributeSetterBiConsumers.put(
			"nationalId",
			(BiConsumer<DGFUsers, String>)DGFUsers::setNationalId);
		attributeGetterFunctions.put("password", DGFUsers::getPassword);
		attributeSetterBiConsumers.put(
			"password", (BiConsumer<DGFUsers, String>)DGFUsers::setPassword);
		attributeGetterFunctions.put("mobileNumber", DGFUsers::getMobileNumber);
		attributeSetterBiConsumers.put(
			"mobileNumber",
			(BiConsumer<DGFUsers, String>)DGFUsers::setMobileNumber);
		attributeGetterFunctions.put("email", DGFUsers::getEmail);
		attributeSetterBiConsumers.put(
			"email", (BiConsumer<DGFUsers, String>)DGFUsers::setEmail);
		attributeGetterFunctions.put("birthDate", DGFUsers::getBirthDate);
		attributeSetterBiConsumers.put(
			"birthDate", (BiConsumer<DGFUsers, Date>)DGFUsers::setBirthDate);
		attributeGetterFunctions.put(
			"maritalStatus", DGFUsers::getMaritalStatus);
		attributeSetterBiConsumers.put(
			"maritalStatus",
			(BiConsumer<DGFUsers, String>)DGFUsers::setMaritalStatus);
		attributeGetterFunctions.put("userId", DGFUsers::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<DGFUsers, Long>)DGFUsers::setUserId);
		attributeGetterFunctions.put(
			"presentAddressId", DGFUsers::getPresentAddressId);
		attributeSetterBiConsumers.put(
			"presentAddressId",
			(BiConsumer<DGFUsers, Long>)DGFUsers::setPresentAddressId);
		attributeGetterFunctions.put("profileType", DGFUsers::getProfileType);
		attributeSetterBiConsumers.put(
			"profileType",
			(BiConsumer<DGFUsers, String>)DGFUsers::setProfileType);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getDgfUserId() {
		return _dgfUserId;
	}

	@Override
	public void setDgfUserId(long dgfUserId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dgfUserId = dgfUserId;
	}

	@Override
	public String getDgfUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getDgfUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setDgfUserUuid(String dgfUserUuid) {
	}

	@JSON
	@Override
	public String getNationalId() {
		if (_nationalId == null) {
			return "";
		}
		else {
			return _nationalId;
		}
	}

	@Override
	public void setNationalId(String nationalId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_nationalId = nationalId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalNationalId() {
		return getColumnOriginalValue("nationalId");
	}

	@JSON
	@Override
	public String getPassword() {
		if (_password == null) {
			return "";
		}
		else {
			return _password;
		}
	}

	@Override
	public void setPassword(String password) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_password = password;
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
	public String getEmail() {
		if (_email == null) {
			return "";
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_email = email;
	}

	@JSON
	@Override
	public Date getBirthDate() {
		return _birthDate;
	}

	@Override
	public void setBirthDate(Date birthDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_birthDate = birthDate;
	}

	@JSON
	@Override
	public String getMaritalStatus() {
		if (_maritalStatus == null) {
			return "";
		}
		else {
			return _maritalStatus;
		}
	}

	@Override
	public void setMaritalStatus(String maritalStatus) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_maritalStatus = maritalStatus;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public long getPresentAddressId() {
		return _presentAddressId;
	}

	@Override
	public void setPresentAddressId(long presentAddressId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_presentAddressId = presentAddressId;
	}

	@JSON
	@Override
	public String getProfileType() {
		if (_profileType == null) {
			return "";
		}
		else {
			return _profileType;
		}
	}

	@Override
	public void setProfileType(String profileType) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_profileType = profileType;
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
			0, DGFUsers.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DGFUsers toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, DGFUsers>
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
		DGFUsersImpl dgfUsersImpl = new DGFUsersImpl();

		dgfUsersImpl.setDgfUserId(getDgfUserId());
		dgfUsersImpl.setNationalId(getNationalId());
		dgfUsersImpl.setPassword(getPassword());
		dgfUsersImpl.setMobileNumber(getMobileNumber());
		dgfUsersImpl.setEmail(getEmail());
		dgfUsersImpl.setBirthDate(getBirthDate());
		dgfUsersImpl.setMaritalStatus(getMaritalStatus());
		dgfUsersImpl.setUserId(getUserId());
		dgfUsersImpl.setPresentAddressId(getPresentAddressId());
		dgfUsersImpl.setProfileType(getProfileType());

		dgfUsersImpl.resetOriginalValues();

		return dgfUsersImpl;
	}

	@Override
	public DGFUsers cloneWithOriginalValues() {
		DGFUsersImpl dgfUsersImpl = new DGFUsersImpl();

		dgfUsersImpl.setDgfUserId(
			this.<Long>getColumnOriginalValue("dgfUserId"));
		dgfUsersImpl.setNationalId(
			this.<String>getColumnOriginalValue("nationalId"));
		dgfUsersImpl.setPassword(
			this.<String>getColumnOriginalValue("password_"));
		dgfUsersImpl.setMobileNumber(
			this.<String>getColumnOriginalValue("mobileNumber"));
		dgfUsersImpl.setEmail(this.<String>getColumnOriginalValue("email"));
		dgfUsersImpl.setBirthDate(
			this.<Date>getColumnOriginalValue("birthDate"));
		dgfUsersImpl.setMaritalStatus(
			this.<String>getColumnOriginalValue("maritalStatus"));
		dgfUsersImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		dgfUsersImpl.setPresentAddressId(
			this.<Long>getColumnOriginalValue("presentAddressId"));
		dgfUsersImpl.setProfileType(
			this.<String>getColumnOriginalValue("profileType"));

		return dgfUsersImpl;
	}

	@Override
	public int compareTo(DGFUsers dgfUsers) {
		long primaryKey = dgfUsers.getPrimaryKey();

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

		if (!(object instanceof DGFUsers)) {
			return false;
		}

		DGFUsers dgfUsers = (DGFUsers)object;

		long primaryKey = dgfUsers.getPrimaryKey();

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
	public CacheModel<DGFUsers> toCacheModel() {
		DGFUsersCacheModel dgfUsersCacheModel = new DGFUsersCacheModel();

		dgfUsersCacheModel.dgfUserId = getDgfUserId();

		dgfUsersCacheModel.nationalId = getNationalId();

		String nationalId = dgfUsersCacheModel.nationalId;

		if ((nationalId != null) && (nationalId.length() == 0)) {
			dgfUsersCacheModel.nationalId = null;
		}

		dgfUsersCacheModel.password = getPassword();

		String password = dgfUsersCacheModel.password;

		if ((password != null) && (password.length() == 0)) {
			dgfUsersCacheModel.password = null;
		}

		dgfUsersCacheModel.mobileNumber = getMobileNumber();

		String mobileNumber = dgfUsersCacheModel.mobileNumber;

		if ((mobileNumber != null) && (mobileNumber.length() == 0)) {
			dgfUsersCacheModel.mobileNumber = null;
		}

		dgfUsersCacheModel.email = getEmail();

		String email = dgfUsersCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			dgfUsersCacheModel.email = null;
		}

		Date birthDate = getBirthDate();

		if (birthDate != null) {
			dgfUsersCacheModel.birthDate = birthDate.getTime();
		}
		else {
			dgfUsersCacheModel.birthDate = Long.MIN_VALUE;
		}

		dgfUsersCacheModel.maritalStatus = getMaritalStatus();

		String maritalStatus = dgfUsersCacheModel.maritalStatus;

		if ((maritalStatus != null) && (maritalStatus.length() == 0)) {
			dgfUsersCacheModel.maritalStatus = null;
		}

		dgfUsersCacheModel.userId = getUserId();

		dgfUsersCacheModel.presentAddressId = getPresentAddressId();

		dgfUsersCacheModel.profileType = getProfileType();

		String profileType = dgfUsersCacheModel.profileType;

		if ((profileType != null) && (profileType.length() == 0)) {
			dgfUsersCacheModel.profileType = null;
		}

		return dgfUsersCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DGFUsers, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DGFUsers, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DGFUsers, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((DGFUsers)this);

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
		Map<String, Function<DGFUsers, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<DGFUsers, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DGFUsers, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((DGFUsers)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, DGFUsers>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					DGFUsers.class, ModelWrapper.class);

	}

	private long _dgfUserId;
	private String _nationalId;
	private String _password;
	private String _mobileNumber;
	private String _email;
	private Date _birthDate;
	private String _maritalStatus;
	private long _userId;
	private long _presentAddressId;
	private String _profileType;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<DGFUsers, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((DGFUsers)this);
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

		_columnOriginalValues.put("dgfUserId", _dgfUserId);
		_columnOriginalValues.put("nationalId", _nationalId);
		_columnOriginalValues.put("password_", _password);
		_columnOriginalValues.put("mobileNumber", _mobileNumber);
		_columnOriginalValues.put("email", _email);
		_columnOriginalValues.put("birthDate", _birthDate);
		_columnOriginalValues.put("maritalStatus", _maritalStatus);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("presentAddressId", _presentAddressId);
		_columnOriginalValues.put("profileType", _profileType);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("password_", "password");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("dgfUserId", 1L);

		columnBitmasks.put("nationalId", 2L);

		columnBitmasks.put("password_", 4L);

		columnBitmasks.put("mobileNumber", 8L);

		columnBitmasks.put("email", 16L);

		columnBitmasks.put("birthDate", 32L);

		columnBitmasks.put("maritalStatus", 64L);

		columnBitmasks.put("userId", 128L);

		columnBitmasks.put("presentAddressId", 256L);

		columnBitmasks.put("profileType", 512L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private DGFUsers _escapedModel;

}