<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@include file="/workflow_task/init.jsp" %>
 <%

String redirect = GetterUtil.getString((String)request.getAttribute("dgfood-ui:workflow-task:redirect"));
long classPK = GetterUtil.getLong((long)request.getAttribute("dgfood-ui:workflow-task:classPK"));
String className = GetterUtil.getString((String)request.getAttribute("dgfood-ui:workflow-task:className"));

WorkflowTask workflowTask = WorflowTaskSubmissionUtil.getWorkflowTask(classPK, className);

String randomId = StringUtil.randomId();

%>


<c:if test="<%=workflowTask != null && !workflowTask.isCompleted()%>">

	<c:choose>
		<c:when
			test="<%=WorflowTaskSubmissionUtil.isAssignedToUser(user.getUserId(),workflowTask)%>">
			
			
			<%
										List<String> transitionNames = WorflowTaskSubmissionUtil.getTransitionNames(workflowTask,themeDisplay);

											for (String transitionName : transitionNames) {
												String message = WorflowTaskSubmissionUtil.getTransitionMessage(transitionName);
									%>

					<liferay-portlet:actionURL copyCurrentRenderParameters="<%=false%>" name="completeWorkflowTask"  var="editURL">
						<portlet:param name="redirect" value="<%=redirect%>" />
						<portlet:param name="workflowTaskId" value="<%=String.valueOf(workflowTask.getWorkflowTaskId())%>" />
						<portlet:param name="assigneeUserId" value="<%=String.valueOf(workflowTask.getAssigneeUserId())%>" />

						<c:if test="<%=transitionName != null%>">
							<portlet:param name="transitionName" value="<%=transitionName%>" />
						</c:if>
					</liferay-portlet:actionURL>

					<aui:button
					    cssClass='<%="workflow-task-" + randomId + " task-change-status-link"%>'
						data="<%=HashMapBuilder.<String, Object>put("title", LanguageUtil.get(request, "label-confirm-"+transitionName)).put("transitionName", transitionName).put("randomid", randomId).build()%>"
						id='<%=randomId + HtmlUtil.escapeAttribute(transitionName) + "taskChangeStatusLink"%>'
						value="<%=HtmlUtil.escape(message)%>"
						href="<%= editURL%>"
					/>

				<%
					}
				%>			
		</c:when>
		<c:when
			test="<%=workflowTask != null && WorflowTaskSubmissionUtil.isAssignedToRole(user.getUserId(),workflowTask)%>">

				<aui:button
					value="assign-to-me"
					onClick='<%= "javascript:" + liferayPortletResponse.getNamespace() + "taskAssignToMe();" %>'
					
				/>
		</c:when>
		<c:otherwise>
		    <h3> <liferay-ui:message key="<%=LanguageUtil.get(request, "label-you-do-not-have-permission-to-review") %>"></liferay-ui:message> </h3>
		</c:otherwise>

	</c:choose>

</c:if>

<aui:form name='<%=randomId + "form"%>'>

    <div class="hide" id="<%=randomId%>updateReasons">
      <aui:select name="reason" label="<%=LanguageUtil.get(request, "label-please-select-reason-for-rejection") %>" required="true">
               <aui:option value="reason1">reason1</aui:option>
               <aui:option value="reason2">reason2</aui:option>
       </aui:select>
    
    </div>

	<div class="hide" id="<%=randomId%>updateComments">
		<aui:input cols="55" cssClass="task-content-comment" name="comment"  rows="1" type="textarea" label="<%=LanguageUtil.get(request, "label-comment") %>"/>
	</div>
</aui:form>

<liferay-portlet:resourceURL copyCurrentRenderParameters="<%= false %>" id="assignWorkflowTaskToUser" var="assignURL" />

<div class="task-action hide">
	<aui:form action="<%= assignURL %>" method="post" name="assignFm">
		<div class="modal-body task-action-content">
		<c:if test="<%=workflowTask != null %>">
			<aui:input name="workflowTaskId" type="hidden" value="<%= String.valueOf(workflowTask.getWorkflowTaskId()) %>" />
		</c:if>

			<aui:input name="assigneeUserId" type="hidden" value="<%= String.valueOf(user.getUserId()) %>" />
            
			   <aui:input cols="55" cssClass="task-action-comment" name="assignTaskComment" label="<%=LanguageUtil.get(request, "label-comment") %>" rows="1" type="textarea" onkeyup="addComment(event.target.value)"/>
           
		</div>

	</aui:form>
</div>


<aui:script use="liferay-workflow-tasks">
//	var onTaskClickFn = A.rbind(
//		'onTaskClick',
//		Liferay.WorkflowTasks,
//		'<%=randomId%>'
//	);

var globComments={};
var globReasons={};
var onTaskClickFn = function(event){
    let height = 350;
    
	event.preventDefault();
	
	var icon = event.currentTarget;
	
	var data = Liferay.Util.getAttributes(icon,'data-')
	
	var form = A.Node.create('<form />');

	form.setAttribute('action', icon.attr('href'));
	form.setAttribute('method', 'POST');
	form.setAttribute('id', '<portlet:namespace />' + data.randomid + 'form');
	var comments = A.one('#' + data.randomid + 'updateComments');
	var reasons = A.one('#' + data.randomid + 'updateReasons');
	
	if (comments && !globComments[data.randomid]) {
		globComments[data.randomid] = comments;
	}
	else if (!comments && globComments[data.randomid]) {
		comments = globComments[data.randomid];
	}
	
	if (reasons && !globReasons[data.randomid]) {
		globReasons[data.randomid] = reasons;
	}
	else if (!reasons && globReasons[data.randomid]) {
		reasons = globReasons[data.randomid];
	}
	
	if (reasons && data.transitionname.includes('reject')) {
		form.append(reasons);
		reasons.show();
		height = 450;
	 }
	

	if (comments) {
		form.append(comments);
		comments.show();
	 }
	 
	 showPopup(form, height, data.title);

}

function showPopup(form, height, title){
 var dialog = Liferay.Util.Window.getWindow({
					dialog: {
						bodyContent: form,
						destroyOnHide: true,
						height,
						resizable: false,
						toolbars: {
							footer: [
								{
									cssClass:
										'btn btn-secondary task-action-button',
									discardDefaultButtonCssClasses: true,
									label: Liferay.Language.get('cancel'),
									on: {
										click() {
											if (form) {
												form.reset();
											}

											dialog.destroy();
										},
									},
								},
								{
									cssClass:
										'btn btn-primary task-action-button',
									discardDefaultButtonCssClasses: true,
									label: Liferay.Language.get('done'),
									on: {
										click() {
											if (form) {
												var hasErrors = false;

												var liferayForm = Liferay.Form.get(
													form.attr('id')
												);

												if (liferayForm) {
													var validator =
														liferayForm.formValidator;

													if (validator) {
														validator.validate();
													}
												}
												
												var reason = form.one('#<portlet:namespace />reason');

												if(reason && reason.val() === ''){
												    hasErrors = true;
												}
														
												if (!hasErrors) {
													submitForm(form);
                                                    
													dialog.hide();

												}
											}
										},
									},
								},
							],
							header: [
								{
									cssClass: 'close',
									discardDefaultButtonCssClasses: true,
									labelHTML:
										'<svg class="lexicon-icon lexicon-icon-times" focusable="false" role="presentation" viewBox="0 0 512 512"><path class="lexicon-icon-outline" d="M295.781 256l205.205-205.205c10.998-10.998 10.998-28.814 0-39.781-10.998-10.998-28.815-10.998-39.781 0l-205.205 205.205-205.205-205.238c-10.966-10.998-28.814-10.998-39.781 0-10.998 10.998-10.998 28.814 0 39.781l205.205 205.238-205.205 205.205c-10.998 10.998-10.998 28.815 0 39.781 5.467 5.531 12.671 8.265 19.874 8.265s14.407-2.734 19.907-8.233l205.205-205.238 205.205 205.205c5.5 5.5 12.703 8.233 19.906 8.233s14.407-2.734 19.906-8.233c10.998-10.998 10.998-28.815 0-39.781l-205.238-205.205z"></path></svg>',
									on: {
										click() {
											if (form) {
												form.reset();
											}

											dialog.destroy();
										},
									},
									title: Liferay.Language.get('close'),
								},
							],
						},
						width: 896,
					},
					title,
				});

}








	<c:if test="<%=workflowTask !=null && !workflowTask.isCompleted() && WorflowTaskSubmissionUtil.isAssignedToUser(themeDisplay.getUserId(),workflowTask)%>">

		<%
			List<String> transitionNames = WorflowTaskSubmissionUtil.getTransitionNames(workflowTask,themeDisplay);

				for (String transitionName : transitionNames) {
			String message = WorflowTaskSubmissionUtil.getTransitionMessage(transitionName);
		%>

			Liferay.delegateClick(
				'<portlet:namespace /><%= randomId + HtmlUtil.escapeJS(transitionName) %>taskChangeStatusLink',
				onTaskClickFn
			);

		<%
		}
		%>

	</c:if>
</aui:script> 


<aui:script>

function addComment(value){
       console.log('value',value);
       document.querySelector('#<portlet:namespace />assignTaskComment').value = value;
}

	function <portlet:namespace />taskAssignToMe() {
	
	var elem = document.querySelector('.task-action');

	
	var html = elem.innerHTML;
	
	
	var dialog = Liferay.Util.Window.getWindow({
					dialog: {
						bodyContent: html,
						destroyOnHide: true,
						height: 350,
						resizable: false,
						toolbars: {
							footer: [
								{
									cssClass:
										'btn btn-secondary task-action-button',
									discardDefaultButtonCssClasses: true,
									label: Liferay.Language.get('cancel'),
									on: {
										click() {
											html = '';

											dialog.destroy();
										},
									},
								},
								{
									cssClass:
										'btn btn-primary task-action-button',
									discardDefaultButtonCssClasses: true,
									label: Liferay.Language.get('done'),
									on: {
										click() {
											 var data = new FormData(document.querySelector('#<portlet:namespace />assignFm'));

			                                  Liferay.Util.fetch('<%= assignURL.toString() %>', {
				                                                  body: data,
				                                                  method: 'POST',
			                                  }).then(function (response) {
			                                  
			                                     console.log('response',response);
			                                     dialog.hide();
			                                     Liferay.Util.getOpener().<portlet:namespace />refreshPortlet(
					                                      '<%= PortalUtil.escapeRedirect(currentURL) %>'
			                                   	);
				                                 

			                                   });
										},
									},
								},
							],
							header: [
								{
									cssClass: 'close',
									discardDefaultButtonCssClasses: true,
									labelHTML:
										'<svg class="lexicon-icon lexicon-icon-times" focusable="false" role="presentation" viewBox="0 0 512 512"><path class="lexicon-icon-outline" d="M295.781 256l205.205-205.205c10.998-10.998 10.998-28.814 0-39.781-10.998-10.998-28.815-10.998-39.781 0l-205.205 205.205-205.205-205.238c-10.966-10.998-28.814-10.998-39.781 0-10.998 10.998-10.998 28.814 0 39.781l205.205 205.238-205.205 205.205c-10.998 10.998-10.998 28.815 0 39.781 5.467 5.531 12.671 8.265 19.874 8.265s14.407-2.734 19.907-8.233l205.205-205.238 205.205 205.205c5.5 5.5 12.703 8.233 19.906 8.233s14.407-2.734 19.906-8.233c10.998-10.998 10.998-28.815 0-39.781l-205.238-205.205z"></path></svg>',
									on: {
										click() {
                                            html = '';
											dialog.destroy();
										},
									title: Liferay.Language.get('close'),
										
									},
								},
							],
						},
						width: 896,
					},
					title: '<liferay-ui:message key="<%=LanguageUtil.get(request, "assign-to-me") %>" />',
				});

	}

	function <portlet:namespace />refreshPortlet(uri) {
		location.href = uri;
	}

</aui:script>


