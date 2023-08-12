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

package bd.gov.dgfood.common.services.service.impl;

import bd.gov.dgfood.common.services.model.BankAccountInformation;
import bd.gov.dgfood.common.services.service.base.BankAccountInformationLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the bank account information local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>bd.gov.dgfood.common.services.service.BankAccountInformationLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BankAccountInformationLocalServiceBaseImpl
 */
@Component(property = "model.class.name=bd.gov.dgfood.common.services.model.BankAccountInformation", service = AopService.class)
public class BankAccountInformationLocalServiceImpl extends BankAccountInformationLocalServiceBaseImpl {

	public BankAccountInformation addBankAccountInformation(String accountNumber, String bankName, String branchName,
			String className, long classPK, ServiceContext serviceContext) {
		BankAccountInformation bankAccountInformation = createBankAccountInformation(
				counterLocalService.increment(BankAccountInformation.class.getName()));

		bankAccountInformation.setAccountNumber(accountNumber);
		bankAccountInformation.setBankName(bankName);
		bankAccountInformation.setBranchName(branchName);
		bankAccountInformation.setClassName(className);
		bankAccountInformation.setClassPK(classPK);
		bankAccountInformation.setCreateDate(new Date());
		bankAccountInformation.setCreatedBy(serviceContext.getUserId());
		
		bankAccountInformation=addBankAccountInformation(bankAccountInformation);

		return bankAccountInformation;
	}
}