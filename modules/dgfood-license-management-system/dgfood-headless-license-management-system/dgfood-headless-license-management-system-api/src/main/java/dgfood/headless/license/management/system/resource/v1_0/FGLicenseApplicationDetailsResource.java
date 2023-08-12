package dgfood.headless.license.management.system.resource.v1_0;

import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ResourceActionLocalService;
import com.liferay.portal.kernel.service.ResourcePermissionLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.odata.filter.ExpressionConvert;
import com.liferay.portal.odata.filter.FilterParserProvider;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.batch.engine.resource.VulcanBatchEngineImportTaskResource;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import dgfood.headless.license.management.system.dto.v1_0.FGLicenseApplicationDetails;
import dgfood.headless.license.management.system.dto.v1_0.FGLicenseApplicationStatus;
import dgfood.headless.license.management.system.dto.v1_0.FGLicenses;
import dgfood.headless.license.management.system.dto.v1_0.NewFGLicenseApplication;
import dgfood.headless.license.management.system.dto.v1_0.RenewalDuplicateFGLicenseApplication;
import dgfood.headless.license.management.system.dto.v1_0.ResponseDetails;
import dgfood.headless.license.management.system.dto.v1_0.ReviewFGLicenseApplication;
import dgfood.headless.license.management.system.dto.v1_0.TransitionFGLicenseApplication;
import dgfood.headless.license.management.system.dto.v1_0.UpdateFGLicenseApplication;
import dgfood.headless.license.management.system.dto.v1_0.UploadChallanFGLicenseApplication;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.annotation.versioning.ProviderType;

/**
 * To access this resource, run:
 *
 *     curl -u your@email.com:yourpassword -D - http://localhost:8080/o/dgfood-headless-license-management-system/v1.0
 *
 * @author Liferay
 * @generated
 */
@Generated("")
@ProviderType
public interface FGLicenseApplicationDetailsResource {

	public static Builder builder() {
		return FactoryHolder.factory.create();
	}

	public Page<FGLicenseApplicationDetails> getFglicenseAccountsPage(
			String keywords, Filter filter, Pagination pagination, Sort[] sorts)
		throws Exception;

	public ResponseDetails postFglicenseApplication(
			NewFGLicenseApplication newFGLicenseApplication)
		throws Exception;

	public FGLicenses getFglicenseApplicationsByNationalId(
			String nationalId, String foodGrainLicenseNumber)
		throws Exception;

	public ResponseDetails getFglicenseApplication(
			String applicationNumber, String foodGrainLicenseNumber,
			String tradeLicenseNumber, String applicationType)
		throws Exception;

	public FGLicenseApplicationStatus getFglicenseApplicationStatus(
			String nationalId, String applicationNumber, String dateOfBirth)
		throws Exception;

	public FGLicenseApplicationStatus getFglicenseRecentApplicationStatus(
			String foodGrainLicenseNumber, String applicationType)
		throws Exception;

	public FGLicenseApplicationDetails putFglicenseApplicationUpdate(
			String foodGrainLicenseNumber,
			UpdateFGLicenseApplication updateFGLicenseApplication)
		throws Exception;

	public FGLicenseApplicationDetails putFglicenseApplicationUploadChallan(
			String applicationNumber,
			UploadChallanFGLicenseApplication uploadChallanFGLicenseApplication)
		throws Exception;

	public FGLicenseApplicationDetails putFglicenseApplicationReview(
			String applicationNumber,
			ReviewFGLicenseApplication reviewFGLicenseApplication)
		throws Exception;

	public FGLicenseApplicationDetails putFglicenseApplicationRenewalDuplicate(
			String foodGrainLicenseNumber,
			RenewalDuplicateFGLicenseApplication
				renewalDuplicateFGLicenseApplication)
		throws Exception;

	public TransitionFGLicenseApplication getFglicenseApplicationTransition(
			String licenseType, String applicationNumber)
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

	public void setExpressionConvert(
		ExpressionConvert<Filter> expressionConvert);

	public void setFilterParserProvider(
		FilterParserProvider filterParserProvider);

	public void setGroupLocalService(GroupLocalService groupLocalService);

	public void setResourceActionLocalService(
		ResourceActionLocalService resourceActionLocalService);

	public void setResourcePermissionLocalService(
		ResourcePermissionLocalService resourcePermissionLocalService);

	public void setRoleLocalService(RoleLocalService roleLocalService);

	public void setVulcanBatchEngineImportTaskResource(
		VulcanBatchEngineImportTaskResource
			vulcanBatchEngineImportTaskResource);

	public default Filter toFilter(String filterString) {
		return toFilter(
			filterString, Collections.<String, List<String>>emptyMap());
	}

	public default Filter toFilter(
		String filterString, Map<String, List<String>> multivaluedMap) {

		return null;
	}

	public static class FactoryHolder {

		public static volatile Factory factory;

	}

	@ProviderType
	public interface Builder {

		public FGLicenseApplicationDetailsResource build();

		public Builder checkPermissions(boolean checkPermissions);

		public Builder httpServletRequest(
			HttpServletRequest httpServletRequest);

		public Builder httpServletResponse(
			HttpServletResponse httpServletResponse);

		public Builder preferredLocale(Locale preferredLocale);

		public Builder user(com.liferay.portal.kernel.model.User user);

	}

	@ProviderType
	public interface Factory {

		public Builder create();

	}

}