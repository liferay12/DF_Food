package dgfood.headless.license.management.system.internal.jaxrs.exception.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.BaseExceptionMapper;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.Problem;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.common.util.validator.DataValidationException;

@Component(
	property = {
		"osgi.jaxrs.application.select=(osgi.jaxrs.name=DgfoodHeadlessLicenseManagementSystem)",
		"osgi.jaxrs.extension=true",
		"osgi.jaxrs.name=DgfoodHeadlessLicenseManagementSystem.DataValidationExceptionMapper",
	},
	service = ExceptionMapper.class
)
public class DataValidationExceptionMapper
	extends BaseExceptionMapper<DataValidationException> {

	@Override
	protected Problem getProblem(DataValidationException dataValidationException) {

		_log.info("Exception Mapper - "+dataValidationException.getMessage());
		
		return new Problem(null, Response.Status.BAD_REQUEST,
				dataValidationException.getMessage(),
				DataValidationException.class.getSimpleName());
	}
	
	private static final Log _log = LogFactoryUtil.getLog(
			ExceptionMapper.class);

}