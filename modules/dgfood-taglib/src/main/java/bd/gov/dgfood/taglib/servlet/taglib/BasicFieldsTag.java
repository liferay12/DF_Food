package bd.gov.dgfood.taglib.servlet.taglib;

import com.liferay.taglib.util.IncludeTag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import bd.gov.dgfood.taglib.internal.servlet.DGFoodServletContextUtil;

public class BasicFieldsTag extends IncludeTag {

	boolean _nameFields;
	boolean _genderField;
	boolean _maritalStatusField;
	boolean _addressField;
	String _addressType;
	boolean _isDisabled;
	BasicInformation _value;

	public BasicInformation getValue() {
		return _value;
	}

	public void setValue(BasicInformation _value) {
		this._value = _value;
	}

	public boolean getNameFields() {
		return _nameFields;
	}

	public void setNameFields(boolean nameFields) {
		this._nameFields = nameFields;
	}

	public boolean getGenderField() {
		return _genderField;
	}

	public void setGenderField(boolean genderField) {
		this._genderField = genderField;
	}

	public boolean getMaritalStatusField() {
		return _maritalStatusField;
	}

	public void setMaritalStatusField(boolean maritalStatusField) {
		this._maritalStatusField = maritalStatusField;
	}

	public boolean getAddressField() {
		return _addressField;
	}

	public void setAddressField(boolean addressField) {
		this._addressField = addressField;
	}

	public String getAddressType() {
		return _addressType;
	}

	public void setAddressType(String addressType) {
		this._addressType = addressType;
	}

	public boolean getIsDisabled() {
		return _isDisabled;
	}

	public void setIsDisabled(boolean _isDisabled) {
		this._isDisabled = _isDisabled;
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);

		setServletContext(DGFoodServletContextUtil.getServletContext());
	}

	@Override
	protected void setAttributes(HttpServletRequest httpServletRequest) {

		System.out.println("Inside set attributes...");
		try {

			System.out.println("nameFields : " + getNameFields() + " genderField : " + getGenderField()
					+ " maritalStatusField : " + getMaritalStatusField() + " addressFelds : " + getAddressField()
					+ " addressType : " + getAddressType());

			boolean pageAccess = true;
			httpServletRequest.setAttribute("dgfood-ui:nameFields", getNameFields());
			httpServletRequest.setAttribute("dgfood-ui:genderField", getGenderField());
			httpServletRequest.setAttribute("dgfood-ui:maritalStatusField", getMaritalStatusField());
			httpServletRequest.setAttribute("dgfood-ui:addressField", getAddressField());
			httpServletRequest.setAttribute("dgfood-ui:addressType", getAddressType());
			httpServletRequest.setAttribute("dgfood-ui:page-access-status-verifier:showAlertMessage", pageAccess);
			httpServletRequest.setAttribute("dgfood-ui:page-access-status-verifier:isPageAccessable", pageAccess);
			httpServletRequest.setAttribute("dgfood-ui:isDisabled", getIsDisabled());
			httpServletRequest.setAttribute("dgfood-ui:basicInformation", getValue());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected String getPage() {
		return _PAGE;
	}

	/***
	 * create the folders <portal
	 * home>/tomcat-9.0.17/webapps/ROOT/html/dgfood/ui/basic-fields and page the
	 * page.jsp in basic-fields folder
	 ***/
	private static final String _PAGE = "/basic_fields/page.jsp";

}
