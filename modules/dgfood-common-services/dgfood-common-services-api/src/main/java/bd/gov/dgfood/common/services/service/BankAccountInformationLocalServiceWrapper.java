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

package bd.gov.dgfood.common.services.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BankAccountInformationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BankAccountInformationLocalService
 * @generated
 */
public class BankAccountInformationLocalServiceWrapper
	implements BankAccountInformationLocalService,
			   ServiceWrapper<BankAccountInformationLocalService> {

	public BankAccountInformationLocalServiceWrapper() {
		this(null);
	}

	public BankAccountInformationLocalServiceWrapper(
		BankAccountInformationLocalService bankAccountInformationLocalService) {

		_bankAccountInformationLocalService =
			bankAccountInformationLocalService;
	}

	/**
	 * Adds the bank account information to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BankAccountInformationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bankAccountInformation the bank account information
	 * @return the bank account information that was added
	 */
	@Override
	public bd.gov.dgfood.common.services.model.BankAccountInformation
		addBankAccountInformation(
			bd.gov.dgfood.common.services.model.BankAccountInformation
				bankAccountInformation) {

		return _bankAccountInformationLocalService.addBankAccountInformation(
			bankAccountInformation);
	}

	@Override
	public bd.gov.dgfood.common.services.model.BankAccountInformation
		addBankAccountInformation(
			String accountNumber, String bankName, String branchName,
			String className, long classPK,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _bankAccountInformationLocalService.addBankAccountInformation(
			accountNumber, bankName, branchName, className, classPK,
			serviceContext);
	}

	/**
	 * Creates a new bank account information with the primary key. Does not add the bank account information to the database.
	 *
	 * @param bankAccountInformationId the primary key for the new bank account information
	 * @return the new bank account information
	 */
	@Override
	public bd.gov.dgfood.common.services.model.BankAccountInformation
		createBankAccountInformation(long bankAccountInformationId) {

		return _bankAccountInformationLocalService.createBankAccountInformation(
			bankAccountInformationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bankAccountInformationLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the bank account information from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BankAccountInformationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bankAccountInformation the bank account information
	 * @return the bank account information that was removed
	 */
	@Override
	public bd.gov.dgfood.common.services.model.BankAccountInformation
		deleteBankAccountInformation(
			bd.gov.dgfood.common.services.model.BankAccountInformation
				bankAccountInformation) {

		return _bankAccountInformationLocalService.deleteBankAccountInformation(
			bankAccountInformation);
	}

	/**
	 * Deletes the bank account information with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BankAccountInformationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bankAccountInformationId the primary key of the bank account information
	 * @return the bank account information that was removed
	 * @throws PortalException if a bank account information with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.common.services.model.BankAccountInformation
			deleteBankAccountInformation(long bankAccountInformationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bankAccountInformationLocalService.deleteBankAccountInformation(
			bankAccountInformationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bankAccountInformationLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _bankAccountInformationLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _bankAccountInformationLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bankAccountInformationLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _bankAccountInformationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.BankAccountInformationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _bankAccountInformationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.BankAccountInformationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _bankAccountInformationLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _bankAccountInformationLocalService.dynamicQueryCount(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _bankAccountInformationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.common.services.model.BankAccountInformation
		fetchBankAccountInformation(long bankAccountInformationId) {

		return _bankAccountInformationLocalService.fetchBankAccountInformation(
			bankAccountInformationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _bankAccountInformationLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the bank account information with the primary key.
	 *
	 * @param bankAccountInformationId the primary key of the bank account information
	 * @return the bank account information
	 * @throws PortalException if a bank account information with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.common.services.model.BankAccountInformation
			getBankAccountInformation(long bankAccountInformationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bankAccountInformationLocalService.getBankAccountInformation(
			bankAccountInformationId);
	}

	/**
	 * Returns a range of all the bank account informations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.common.services.model.impl.BankAccountInformationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bank account informations
	 * @param end the upper bound of the range of bank account informations (not inclusive)
	 * @return the range of bank account informations
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.common.services.model.BankAccountInformation>
			getBankAccountInformations(int start, int end) {

		return _bankAccountInformationLocalService.getBankAccountInformations(
			start, end);
	}

	/**
	 * Returns the number of bank account informations.
	 *
	 * @return the number of bank account informations
	 */
	@Override
	public int getBankAccountInformationsCount() {
		return _bankAccountInformationLocalService.
			getBankAccountInformationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _bankAccountInformationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bankAccountInformationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bankAccountInformationLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the bank account information in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BankAccountInformationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bankAccountInformation the bank account information
	 * @return the bank account information that was updated
	 */
	@Override
	public bd.gov.dgfood.common.services.model.BankAccountInformation
		updateBankAccountInformation(
			bd.gov.dgfood.common.services.model.BankAccountInformation
				bankAccountInformation) {

		return _bankAccountInformationLocalService.updateBankAccountInformation(
			bankAccountInformation);
	}

	@Override
	public BankAccountInformationLocalService getWrappedService() {
		return _bankAccountInformationLocalService;
	}

	@Override
	public void setWrappedService(
		BankAccountInformationLocalService bankAccountInformationLocalService) {

		_bankAccountInformationLocalService =
			bankAccountInformationLocalService;
	}

	private BankAccountInformationLocalService
		_bankAccountInformationLocalService;

}