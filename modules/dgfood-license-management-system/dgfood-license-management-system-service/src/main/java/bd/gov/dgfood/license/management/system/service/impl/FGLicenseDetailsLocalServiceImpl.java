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

package bd.gov.dgfood.license.management.system.service.impl;

import com.liferay.portal.aop.AopService;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.license.management.system.model.FGLicenseDetails;
import bd.gov.dgfood.license.management.system.service.base.FGLicenseDetailsLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=bd.gov.dgfood.license.management.system.model.FGLicenseDetails", service = AopService.class)
public class FGLicenseDetailsLocalServiceImpl extends FGLicenseDetailsLocalServiceBaseImpl {

	/**
	 * Create a new FG Licensee details record for the submitted FG License form.
	 * Complete form data will be stored in this table
	 */
	public FGLicenseDetails addFGLicenseDetails(String nationalId, String applicationNumber, String applicantName,
			String tradeLicenseNumber, Date tradeLicenseExpiryDate, String tradeLicenseIssuerCode,
			String tradeLicenseIssuerCity, String businessIdentificationNumber, String taxIdentificationNumber,
			long tradeLicenseDocId, long businessIdentificationDocId, long taxIdentfctDocId, long bankStatementDocId,
			String applicationType) {

		FGLicenseDetails fgLicenseDetails = createFGLicenseDetails(
				counterLocalService.increment(FGLicenseDetails.class.getName()));
		fgLicenseDetails.setApplicationNumber(applicationNumber);

		// Form Data
		fgLicenseDetails.setNationalId(nationalId);
		fgLicenseDetails.setApplicantName(applicantName);
		fgLicenseDetails.setApplicationType(applicationType);

		fgLicenseDetails.setTradeLicenseNumber(tradeLicenseNumber);
		fgLicenseDetails.setTradeLicenseExpiryDate(tradeLicenseExpiryDate);
		fgLicenseDetails.setTradeLicenseIssuerCode(tradeLicenseIssuerCode);
		fgLicenseDetails.setTradeLicenseIssuerCity(tradeLicenseIssuerCity);

		fgLicenseDetails.setBusinessIdentificationNumber(businessIdentificationNumber);
		fgLicenseDetails.setTaxIdentificationNumber(taxIdentificationNumber);

		fgLicenseDetails.setTradeLicenseDocId(tradeLicenseDocId);
		fgLicenseDetails.setBusinessIdentificationDocId(businessIdentificationDocId);
		fgLicenseDetails.setTaxIdentfctDocId(taxIdentfctDocId);
		fgLicenseDetails.setBankStatementDocId(bankStatementDocId);

		return super.addFGLicenseDetails(fgLicenseDetails);

	}
}