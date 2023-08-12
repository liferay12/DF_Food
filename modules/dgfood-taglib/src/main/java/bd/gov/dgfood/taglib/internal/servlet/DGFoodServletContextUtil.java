package bd.gov.dgfood.taglib.internal.servlet;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = {})
public class DGFoodServletContextUtil {

	public static final ServletContext getServletContext() {
		return _servletContext;
	}

	@Reference(target = "(osgi.web.symbolicname=bd.gov.dgfood.taglib)", unbind = "-")
	protected void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	private static ServletContext _servletContext;

}
