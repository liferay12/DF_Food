<%@include file="../../init.jsp"%>

<dgfood-ui:basic-fields nameFields="true" maritalStatusField="true"
		genderField="true" addressField="true" addressType="permanent" />
<dgfood-ui:basic-fields nameFields="false" maritalStatusField="false"
			genderField="false" addressField="true" addressType="present" />

<aui:button-row>
	<aui:button id="backToNidDetails" type="button" cssClass="btn"
		value="label-back" onClick="showNextOrPreviousStep('basic_details','nid_details', false, 'new-food-grain-license', 'application_step', 'application_step_hide', false);" />
	<aui:button id="nextToTradeBusiness" type="button" cssClass="btn btn-primary"
		value="label-next" onClick="showNextOrPreviousStep('basic_details','trade_business', true, 'new-food-grain-license', 'application_step', 'application_step_hide', true);" />
</aui:button-row>