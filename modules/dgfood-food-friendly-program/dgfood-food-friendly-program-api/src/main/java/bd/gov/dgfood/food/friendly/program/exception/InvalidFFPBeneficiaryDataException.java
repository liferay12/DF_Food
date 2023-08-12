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
package bd.gov.dgfood.food.friendly.program.exception;

import com.liferay.portal.kernel.exception.PortalException;

import javax.ws.rs.core.Response.Status;

/**
 * @author Brian Wing Shun Chan
 */
public class InvalidFFPBeneficiaryDataException extends PortalException {

	public InvalidFFPBeneficiaryDataException() {
	}

	public InvalidFFPBeneficiaryDataException(String msg) {
		super(msg);
	}

	public InvalidFFPBeneficiaryDataException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public InvalidFFPBeneficiaryDataException(Throwable throwable) {
		super(throwable);
	}

	public InvalidFFPBeneficiaryDataException(Status status, String msg) {
		super(msg);
		this.errorMsg = msg;
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	protected Status status;
	protected String errorMsg;

}