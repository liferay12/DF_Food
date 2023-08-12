<%@page import="bd.gov.dgfood.food.friendly.program.constants.FoodFriendlyProgramConstants"%>
<%@include file="/ffpb_registration/init.jsp"%>


<style>
.ffpb_reg_step_hide {
	display: none
}
</style>

<c:choose>
	<c:when  test='<%= FoodFriendlyProgramPermission.contains(permissionChecker, scopeGroupId, FoodFriendlyProgramConstants.ADD_BENEFICIARY) %>'>



<portlet:actionURL name="/ffpb_registration/add_entry" var="addFFPBURL">

</portlet:actionURL>


<aui:form action="${addFFPBURL }" method="post" name="fm">

	<clay:row>

		<clay:col md="6" sm="6">

			<div id="<portlet:namespace />errorMsg"></div>

		</clay:col>
	</clay:row>



	<aui:input name="<%=Constants.CMD%>" type="hidden" value="<%=Constants.ADD%>"></aui:input>

<%-- 	<div class="ffpb_reg_step" id='<portlet:namespace/>nid_details'>
		<liferay-util:include page="/ffpb_registration/steps/nid_details.jsp" servletContext="<%=application%>" />
	</div>

	<div class=" ffpb_reg_step" id='<portlet:namespace/>basic_info'>
		<liferay-util:include page="/ffpb_registration/steps/basic_info.jsp" servletContext="<%=application%>" />
	</div> --%>
	<aui:button-row>
	<aui:button value='back' onClick="showNextOrPreviousStep('upload');"></aui:button>
	<aui:button value='back' type='submit'></aui:button>
	<!-- <aui:button onClick='<%= liferayPortletResponse.getNamespace() + "onClick();" %>' primary="<%= true %>" value="submit" /> -->
</aui:button-row>
	
	<div class=" ffpb_reg_step" id='<portlet:namespace/>upload'>
		<liferay-util:include page="/ffpb_registration/steps/upload.jsp" servletContext="<%=application%>" />
	</div> 
	
<%-- 	<div class=" ffpb_reg_step" id='<portlet:namespace/>preview'> --%>
<%-- 		<liferay-util:include page="/ffpb_registration/steps/preview.jsp" servletContext="<%=application%>" /> --%>
<!-- 	</div> -->

</aui:form>

<aui:script>



//============================Navigation Next & Previous Code========================//
//Will be used to go to Next Step or Previous Step

function showNextOrPreviousStep(id){

   const list = document.querySelectorAll('.ffpb_reg_step');
  
   Array.prototype.forEach.call(list,(e)=>{   
        e.classList.add('ffpb_reg_step_hide');       
   })
   
   document.getElementById('<portlet:namespace />'+id).classList.remove('ffpb_reg_step_hide');
}


//============================Field Validation Code========================//
//Will be used to Validate the Form Fields

function validateFields(currentDivId, nextDivId) {
   console.log('validate')
	var currentDiv = $("#<portlet:namespace />" + currentDivId);
	 
	var currentInputList = currentDiv.find(".validate");
	console.log("currentInputList",currentInputList)
	var validDiv = true;
	var currentFormValidator = Liferay.Form
			.get("<portlet:namespace />" + "fm").formValidator;
	for (i = 0; i < currentInputList.length; i++) {
		var currentInput = currentInputList[i];
		currentFormValidator.validateField(currentInput.id);
	}
	if (currentFormValidator.hasErrors()) {
		currentFormValidator.focusInvalidField();
	} else {
			showNextOrPreviousStep(nextDivId);
	}
}



</aui:script>

	</c:when>
	<c:otherwise>
		<div class="alert alert-danger text-center">
			<div>
				<liferay-ui:message
					key="access-denied" />
			</div>
	</c:otherwise>
</c:choose>