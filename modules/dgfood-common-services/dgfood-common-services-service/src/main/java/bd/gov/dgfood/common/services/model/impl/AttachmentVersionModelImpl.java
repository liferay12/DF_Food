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

import bd.gov.dgfood.common.services.model.AttachmentVersion;
import bd.gov.dgfood.common.services.model.AttachmentVersionModel;

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
 * The base model implementation for the AttachmentVersion service. Represents a row in the &quot;DGF_AttachmentVersion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>AttachmentVersionModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AttachmentVersionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentVersionImpl
 * @generated
 */
@JSON(strict = true)
public class AttachmentVersionModelImpl
	extends BaseModelImpl<AttachmentVersion> implements AttachmentVersionModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a attachment version model instance should use the <code>AttachmentVersion</code> interface instead.
	 */
	public static final String TABLE_NAME = "DGF_AttachmentVersion";

	public static final Object[][] TABLE_COLUMNS = {
		{"attachmentVersionId", Types.BIGINT}, {"title", Types.VARCHAR},
		{"category", Types.VARCHAR}, {"fileEntryId", Types.BIGINT},
		{"openTextId", Types.BIGINT}, {"metadata", Types.CLOB},
		{"classPK", Types.BIGINT}, {"className", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("attachmentVersionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("category", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fileEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("openTextId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("metadata", Types.CLOB);
		TABLE_COLUMNS_MAP.put("classPK", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("className", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table DGF_AttachmentVersion (attachmentVersionId LONG not null primary key,title VARCHAR(75) null,category VARCHAR(75) null,fileEntryId LONG,openTextId LONG,metadata TEXT null,classPK LONG,className VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table DGF_AttachmentVersion";

	public static final String ORDER_BY_JPQL =
		" ORDER BY attachmentVersion.attachmentVersionId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY DGF_AttachmentVersion.attachmentVersionId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CLASSNAME_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CLASSPK_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ATTACHMENTVERSIONID_COLUMN_BITMASK = 4L;

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

	public AttachmentVersionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _attachmentVersionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAttachmentVersionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _attachmentVersionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return AttachmentVersion.class;
	}

	@Override
	public String getModelClassName() {
		return AttachmentVersion.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<AttachmentVersion, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<AttachmentVersion, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AttachmentVersion, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((AttachmentVersion)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<AttachmentVersion, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<AttachmentVersion, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(AttachmentVersion)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<AttachmentVersion, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<AttachmentVersion, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<AttachmentVersion, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<AttachmentVersion, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<AttachmentVersion, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<AttachmentVersion, Object>>();
		Map<String, BiConsumer<AttachmentVersion, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<AttachmentVersion, ?>>();

		attributeGetterFunctions.put(
			"attachmentVersionId", AttachmentVersion::getAttachmentVersionId);
		attributeSetterBiConsumers.put(
			"attachmentVersionId",
			(BiConsumer<AttachmentVersion, Long>)
				AttachmentVersion::setAttachmentVersionId);
		attributeGetterFunctions.put("title", AttachmentVersion::getTitle);
		attributeSetterBiConsumers.put(
			"title",
			(BiConsumer<AttachmentVersion, String>)AttachmentVersion::setTitle);
		attributeGetterFunctions.put(
			"category", AttachmentVersion::getCategory);
		attributeSetterBiConsumers.put(
			"category",
			(BiConsumer<AttachmentVersion, String>)
				AttachmentVersion::setCategory);
		attributeGetterFunctions.put(
			"fileEntryId", AttachmentVersion::getFileEntryId);
		attributeSetterBiConsumers.put(
			"fileEntryId",
			(BiConsumer<AttachmentVersion, Long>)
				AttachmentVersion::setFileEntryId);
		attributeGetterFunctions.put(
			"openTextId", AttachmentVersion::getOpenTextId);
		attributeSetterBiConsumers.put(
			"openTextId",
			(BiConsumer<AttachmentVersion, Long>)
				AttachmentVersion::setOpenTextId);
		attributeGetterFunctions.put(
			"metadata", AttachmentVersion::getMetadata);
		attributeSetterBiConsumers.put(
			"metadata",
			(BiConsumer<AttachmentVersion, Map<String, Serializable>>)
				AttachmentVersion::setMetadata);
		attributeGetterFunctions.put("classPK", AttachmentVersion::getClassPK);
		attributeSetterBiConsumers.put(
			"classPK",
			(BiConsumer<AttachmentVersion, Long>)AttachmentVersion::setClassPK);
		attributeGetterFunctions.put(
			"className", AttachmentVersion::getClassName);
		attributeSetterBiConsumers.put(
			"className",
			(BiConsumer<AttachmentVersion, String>)
				AttachmentVersion::setClassName);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getAttachmentVersionId() {
		return _attachmentVersionId;
	}

	@Override
	public void setAttachmentVersionId(long attachmentVersionId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_attachmentVersionId = attachmentVersionId;
	}

	@JSON
	@Override
	public String getTitle() {
		if (_title == null) {
			return "";
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_title = title;
	}

	@JSON
	@Override
	public String getCategory() {
		if (_category == null) {
			return "";
		}
		else {
			return _category;
		}
	}

	@Override
	public void setCategory(String category) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_category = category;
	}

	@JSON
	@Override
	public long getFileEntryId() {
		return _fileEntryId;
	}

	@Override
	public void setFileEntryId(long fileEntryId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fileEntryId = fileEntryId;
	}

	@JSON
	@Override
	public long getOpenTextId() {
		return _openTextId;
	}

	@Override
	public void setOpenTextId(long openTextId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_openTextId = openTextId;
	}

	@JSON
	@Override
	public Map<String, Serializable> getMetadata() {
		return _metadata;
	}

	@Override
	public void setMetadata(Map<String, Serializable> metadata) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_metadata = metadata;
	}

	@JSON
	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_classPK = classPK;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalClassPK() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("classPK"));
	}

	@JSON
	@Override
	public String getClassName() {
		if (_className == null) {
			return "";
		}
		else {
			return _className;
		}
	}

	@Override
	public void setClassName(String className) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_className = className;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalClassName() {
		return getColumnOriginalValue("className");
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
			0, AttachmentVersion.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AttachmentVersion toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, AttachmentVersion>
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
		AttachmentVersionImpl attachmentVersionImpl =
			new AttachmentVersionImpl();

		attachmentVersionImpl.setAttachmentVersionId(getAttachmentVersionId());
		attachmentVersionImpl.setTitle(getTitle());
		attachmentVersionImpl.setCategory(getCategory());
		attachmentVersionImpl.setFileEntryId(getFileEntryId());
		attachmentVersionImpl.setOpenTextId(getOpenTextId());
		attachmentVersionImpl.setMetadata(getMetadata());
		attachmentVersionImpl.setClassPK(getClassPK());
		attachmentVersionImpl.setClassName(getClassName());

		attachmentVersionImpl.resetOriginalValues();

		return attachmentVersionImpl;
	}

	@Override
	public AttachmentVersion cloneWithOriginalValues() {
		AttachmentVersionImpl attachmentVersionImpl =
			new AttachmentVersionImpl();

		attachmentVersionImpl.setAttachmentVersionId(
			this.<Long>getColumnOriginalValue("attachmentVersionId"));
		attachmentVersionImpl.setTitle(
			this.<String>getColumnOriginalValue("title"));
		attachmentVersionImpl.setCategory(
			this.<String>getColumnOriginalValue("category"));
		attachmentVersionImpl.setFileEntryId(
			this.<Long>getColumnOriginalValue("fileEntryId"));
		attachmentVersionImpl.setOpenTextId(
			this.<Long>getColumnOriginalValue("openTextId"));
		attachmentVersionImpl.setMetadata(
			this.<Map>getColumnOriginalValue("metadata"));
		attachmentVersionImpl.setClassPK(
			this.<Long>getColumnOriginalValue("classPK"));
		attachmentVersionImpl.setClassName(
			this.<String>getColumnOriginalValue("className"));

		return attachmentVersionImpl;
	}

	@Override
	public int compareTo(AttachmentVersion attachmentVersion) {
		long primaryKey = attachmentVersion.getPrimaryKey();

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

		if (!(object instanceof AttachmentVersion)) {
			return false;
		}

		AttachmentVersion attachmentVersion = (AttachmentVersion)object;

		long primaryKey = attachmentVersion.getPrimaryKey();

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
	public CacheModel<AttachmentVersion> toCacheModel() {
		AttachmentVersionCacheModel attachmentVersionCacheModel =
			new AttachmentVersionCacheModel();

		attachmentVersionCacheModel.attachmentVersionId =
			getAttachmentVersionId();

		attachmentVersionCacheModel.title = getTitle();

		String title = attachmentVersionCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			attachmentVersionCacheModel.title = null;
		}

		attachmentVersionCacheModel.category = getCategory();

		String category = attachmentVersionCacheModel.category;

		if ((category != null) && (category.length() == 0)) {
			attachmentVersionCacheModel.category = null;
		}

		attachmentVersionCacheModel.fileEntryId = getFileEntryId();

		attachmentVersionCacheModel.openTextId = getOpenTextId();

		attachmentVersionCacheModel.metadata = getMetadata();

		attachmentVersionCacheModel.classPK = getClassPK();

		attachmentVersionCacheModel.className = getClassName();

		String className = attachmentVersionCacheModel.className;

		if ((className != null) && (className.length() == 0)) {
			attachmentVersionCacheModel.className = null;
		}

		return attachmentVersionCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<AttachmentVersion, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<AttachmentVersion, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AttachmentVersion, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(AttachmentVersion)this);

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
		Map<String, Function<AttachmentVersion, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<AttachmentVersion, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AttachmentVersion, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((AttachmentVersion)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, AttachmentVersion>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					AttachmentVersion.class, ModelWrapper.class);

	}

	private long _attachmentVersionId;
	private String _title;
	private String _category;
	private long _fileEntryId;
	private long _openTextId;
	private Map<String, Serializable> _metadata;
	private long _classPK;
	private String _className;

	public <T> T getColumnValue(String columnName) {
		Function<AttachmentVersion, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((AttachmentVersion)this);
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

		_columnOriginalValues.put("attachmentVersionId", _attachmentVersionId);
		_columnOriginalValues.put("title", _title);
		_columnOriginalValues.put("category", _category);
		_columnOriginalValues.put("fileEntryId", _fileEntryId);
		_columnOriginalValues.put("openTextId", _openTextId);
		_columnOriginalValues.put("metadata", _metadata);
		_columnOriginalValues.put("classPK", _classPK);
		_columnOriginalValues.put("className", _className);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("attachmentVersionId", 1L);

		columnBitmasks.put("title", 2L);

		columnBitmasks.put("category", 4L);

		columnBitmasks.put("fileEntryId", 8L);

		columnBitmasks.put("openTextId", 16L);

		columnBitmasks.put("metadata", 32L);

		columnBitmasks.put("classPK", 64L);

		columnBitmasks.put("className", 128L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private AttachmentVersion _escapedModel;

}