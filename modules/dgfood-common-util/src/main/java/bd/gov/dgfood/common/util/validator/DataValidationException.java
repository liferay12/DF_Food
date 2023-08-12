package bd.gov.dgfood.common.util.validator;

import com.liferay.portal.kernel.exception.PortalException;

public class DataValidationException extends PortalException {

	public DataValidationException() {
	}

	public DataValidationException(String msg) {
		super(msg);
	}

	public DataValidationException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public DataValidationException(Throwable throwable) {
		super(throwable);
	}


}
