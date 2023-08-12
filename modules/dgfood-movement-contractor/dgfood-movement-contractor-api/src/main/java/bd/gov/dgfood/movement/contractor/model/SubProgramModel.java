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

package bd.gov.dgfood.movement.contractor.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.io.Serializable;

import java.util.Date;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the SubProgram service. Represents a row in the &quot;DGFOOD_SubProgram&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>bd.gov.dgfood.movement.contractor.model.impl.SubProgramModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>bd.gov.dgfood.movement.contractor.model.impl.SubProgramImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubProgram
 * @generated
 */
@ProviderType
public interface SubProgramModel extends BaseModel<SubProgram> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a sub program model instance should use the {@link SubProgram} interface instead.
	 */

	/**
	 * Returns the primary key of this sub program.
	 *
	 * @return the primary key of this sub program
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this sub program.
	 *
	 * @param primaryKey the primary key of this sub program
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the sub program ID of this sub program.
	 *
	 * @return the sub program ID of this sub program
	 */
	public long getSubProgramId();

	/**
	 * Sets the sub program ID of this sub program.
	 *
	 * @param subProgramId the sub program ID of this sub program
	 */
	public void setSubProgramId(long subProgramId);

	/**
	 * Returns the delivery no of this sub program.
	 *
	 * @return the delivery no of this sub program
	 */
	@AutoEscape
	public String getDeliveryNo();

	/**
	 * Sets the delivery no of this sub program.
	 *
	 * @param deliveryNo the delivery no of this sub program
	 */
	public void setDeliveryNo(String deliveryNo);

	/**
	 * Returns the memo no of this sub program.
	 *
	 * @return the memo no of this sub program
	 */
	@AutoEscape
	public String getMemoNo();

	/**
	 * Sets the memo no of this sub program.
	 *
	 * @param memoNo the memo no of this sub program
	 */
	public void setMemoNo(String memoNo);

	/**
	 * Returns the sending depot of this sub program.
	 *
	 * @return the sending depot of this sub program
	 */
	@AutoEscape
	public String getSendingDepot();

	/**
	 * Sets the sending depot of this sub program.
	 *
	 * @param sendingDepot the sending depot of this sub program
	 */
	public void setSendingDepot(String sendingDepot);

	/**
	 * Returns the sending plant desc of this sub program.
	 *
	 * @return the sending plant desc of this sub program
	 */
	@AutoEscape
	public String getSendingPlantDesc();

	/**
	 * Sets the sending plant desc of this sub program.
	 *
	 * @param sendingPlantDesc the sending plant desc of this sub program
	 */
	public void setSendingPlantDesc(String sendingPlantDesc);

	/**
	 * Returns the receiving depot of this sub program.
	 *
	 * @return the receiving depot of this sub program
	 */
	@AutoEscape
	public String getReceivingDepot();

	/**
	 * Sets the receiving depot of this sub program.
	 *
	 * @param receivingDepot the receiving depot of this sub program
	 */
	public void setReceivingDepot(String receivingDepot);

	/**
	 * Returns the receiving plant desc of this sub program.
	 *
	 * @return the receiving plant desc of this sub program
	 */
	@AutoEscape
	public String getReceivingPlantDesc();

	/**
	 * Sets the receiving plant desc of this sub program.
	 *
	 * @param receivingPlantDesc the receiving plant desc of this sub program
	 */
	public void setReceivingPlantDesc(String receivingPlantDesc);

	/**
	 * Returns the product of this sub program.
	 *
	 * @return the product of this sub program
	 */
	@AutoEscape
	public String getProduct();

	/**
	 * Sets the product of this sub program.
	 *
	 * @param product the product of this sub program
	 */
	public void setProduct(String product);

	/**
	 * Returns the quantity of this sub program.
	 *
	 * @return the quantity of this sub program
	 */
	public Map<String, Serializable> getQuantity();

	/**
	 * Sets the quantity of this sub program.
	 *
	 * @param quantity the quantity of this sub program
	 */
	public void setQuantity(Map<String, Serializable> quantity);

	/**
	 * Returns the delivery date of this sub program.
	 *
	 * @return the delivery date of this sub program
	 */
	public Date getDeliveryDate();

	/**
	 * Sets the delivery date of this sub program.
	 *
	 * @param deliveryDate the delivery date of this sub program
	 */
	public void setDeliveryDate(Date deliveryDate);

	/**
	 * Returns the requested date of this sub program.
	 *
	 * @return the requested date of this sub program
	 */
	public Date getRequestedDate();

	/**
	 * Sets the requested date of this sub program.
	 *
	 * @param requestedDate the requested date of this sub program
	 */
	public void setRequestedDate(Date requestedDate);

	/**
	 * Returns the forwarding agent of this sub program.
	 *
	 * @return the forwarding agent of this sub program
	 */
	@AutoEscape
	public String getForwardingAgent();

	/**
	 * Sets the forwarding agent of this sub program.
	 *
	 * @param forwardingAgent the forwarding agent of this sub program
	 */
	public void setForwardingAgent(String forwardingAgent);

	/**
	 * Returns the vehicle send date of this sub program.
	 *
	 * @return the vehicle send date of this sub program
	 */
	public Date getVehicleSendDate();

	/**
	 * Sets the vehicle send date of this sub program.
	 *
	 * @param vehicleSendDate the vehicle send date of this sub program
	 */
	public void setVehicleSendDate(Date vehicleSendDate);

	/**
	 * Returns the status of this sub program.
	 *
	 * @return the status of this sub program
	 */
	public int getStatus();

	/**
	 * Sets the status of this sub program.
	 *
	 * @param status the status of this sub program
	 */
	public void setStatus(int status);

	/**
	 * Returns the user ID of this sub program.
	 *
	 * @return the user ID of this sub program
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this sub program.
	 *
	 * @param userId the user ID of this sub program
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this sub program.
	 *
	 * @return the user uuid of this sub program
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this sub program.
	 *
	 * @param userUuid the user uuid of this sub program
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this sub program.
	 *
	 * @return the create date of this sub program
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this sub program.
	 *
	 * @param createDate the create date of this sub program
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this sub program.
	 *
	 * @return the modified date of this sub program
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this sub program.
	 *
	 * @param modifiedDate the modified date of this sub program
	 */
	public void setModifiedDate(Date modifiedDate);

	@Override
	public SubProgram cloneWithOriginalValues();

}