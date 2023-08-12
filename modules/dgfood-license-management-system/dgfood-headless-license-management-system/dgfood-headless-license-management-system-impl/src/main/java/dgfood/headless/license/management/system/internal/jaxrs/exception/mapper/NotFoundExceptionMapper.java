package dgfood.headless.license.management.system.internal.jaxrs.exception.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.BaseExceptionMapper;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.Problem;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.osgi.service.component.annotations.Component;

@Component(
	property = {
		"osgi.jaxrs.application.select=(osgi.jaxrs.name=DgfoodHeadlessLicenseManagementSystem)",
		"osgi.jaxrs.extension=true",
		"osgi.jaxrs.name=DgfoodHeadlessLicenseManagementSystem.NotFoundExceptionMapper",
	},
	service = ExceptionMapper.class
)
public class NotFoundExceptionMapper
	extends BaseExceptionMapper<NotFoundException> {

	@Override
	protected Problem getProblem(NotFoundException notFoundException) {

		_log.info("Exception Mapper - "+notFoundException.getMessage());
		
		return new Problem(null, Response.Status.NOT_FOUND,
				notFoundException.getMessage(),
				NotFoundException.class.getSimpleName());
	}
	
//	@Override
//	public Response toResponse(NotFoundException exception) {
//
//		_log.info("Exception Mapper - "+exception.getMessage());
//		
//		return Response.status(Response.Status.NOT_FOUND)
//					   .type(MediaType.TEXT_PLAIN)
//					   .entity(exception.getMessage()).build();
//		}
	
	private static final Log _log = LogFactoryUtil.getLog(
			ExceptionMapper.class);

}