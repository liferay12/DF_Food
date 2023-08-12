package bd.gov.dgfood.headless.food.friendly.program.resource.v1_0;

import bd.gov.dgfood.headless.food.friendly.program.dto.v1_0.FFPBeneficiaryAccount;

import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.Locale;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.annotation.versioning.ProviderType;

/**
 * To access this resource, run:
 *
 *     curl -u your@email.com:yourpassword -D - http://localhost:8080/o/dgfood-headless-food-friendly-program/v1.0
 *
 * @author krishna
 * @generated
 */
@Generated("")
@ProviderType
public interface FFPBeneficiaryAccountResource {

	public static Builder builder() {
		return FactoryHolder.factory.create();
	}

	public Page<FFPBeneficiaryAccount> getFFPBeneficiaryAccountsPage(
			String keywords, Filter filter, Pagination pagination, Sort[] sorts)
		throws Exception;

	public FFPBeneficiaryAccount postFFPBeneficiaryAccount(
			FFPBeneficiaryAccount ffpBeneficiaryAccount)
		throws Exception;

	public Response postFFPBeneficiaryAccountBatch(
			FFPBeneficiaryAccount ffpBeneficiaryAccount, String callbackURL,
			Object object)
		throws Exception;

	public FFPBeneficiaryAccount getFFPBeneficiaryAccount(
			Long ffpBeneficiaryAccountId)
		throws Exception;

	public FFPBeneficiaryAccount putFFPBeneficiaryAccount(
			Long ffpBeneficiaryAccountId,
			FFPBeneficiaryAccount ffpBeneficiaryAccount)
		throws Exception;

	public Response putFFPBeneficiaryAccountBatch(
			Long ffpBeneficiaryAccountId,
			FFPBeneficiaryAccount ffpBeneficiaryAccount, String callbackURL,
			Object object)
		throws Exception;

	public default void setContextAcceptLanguage(
		AcceptLanguage contextAcceptLanguage) {
	}

	public void setContextCompany(
		com.liferay.portal.kernel.model.Company contextCompany);

	public default void setContextHttpServletRequest(
		HttpServletRequest contextHttpServletRequest) {
	}

	public default void setContextHttpServletResponse(
		HttpServletResponse contextHttpServletResponse) {
	}

	public default void setContextUriInfo(UriInfo contextUriInfo) {
	}

	public void setContextUser(
		com.liferay.portal.kernel.model.User contextUser);

	public void setGroupLocalService(GroupLocalService groupLocalService);

	public void setRoleLocalService(RoleLocalService roleLocalService);

	public static class FactoryHolder {

		public static volatile Factory factory;

	}

	@ProviderType
	public interface Builder {

		public FFPBeneficiaryAccountResource build();

		public Builder checkPermissions(boolean checkPermissions);

		public Builder httpServletRequest(
			HttpServletRequest httpServletRequest);

		public Builder preferredLocale(Locale preferredLocale);

		public Builder user(com.liferay.portal.kernel.model.User user);

	}

	@ProviderType
	public interface Factory {

		public Builder create();

	}

}