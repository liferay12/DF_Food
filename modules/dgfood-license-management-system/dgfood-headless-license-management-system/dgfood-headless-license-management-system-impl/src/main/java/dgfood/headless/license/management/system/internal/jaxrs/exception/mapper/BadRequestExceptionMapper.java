package dgfood.headless.license.management.system.internal.jaxrs.exception.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.BaseExceptionMapper;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.Problem;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.osgi.service.component.annotations.Component;

@Component(
	property = {
		"osgi.jaxrs.application.select=(osgi.jaxrs.name=DgfoodHeadlessLicenseManagementSystem)",
		"osgi.jaxrs.extension=true",
		"osgi.jaxrs.name=DgfoodHeadlessLicenseManagementSystem.BadRequestExceptionMapper",
	},
	service = ExceptionMapper.class
)
public class BadRequestExceptionMapper
	extends BaseExceptionMapper<BadRequestException> {

	@Override
	protected Problem getProblem(BadRequestException badRequestException) {

		_log.info("Exception Mapper - "+badRequestException.getMessage());
		
		return new Problem(null, Response.Status.BAD_REQUEST,
				badRequestException.getMessage(),
				BadRequestException.class.getSimpleName());
	}
	
	private static final Log _log = LogFactoryUtil.getLog(
			ExceptionMapper.class);

}