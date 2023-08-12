<%@ include file="../init.jsp"%>

<style>
.ffpb-screen {
	margin-left: auto;
	margin-right: auto;
	display: block;
	width: 40%;
}

.ffpb-title {
	padding-bottom: 20px;
	margin-left: auto;
	margin-right: auto;
	display: block;
	width: 40%;
}

.alert-dismissible {
	margin-top: 20px;
}
</style>


<portlet:renderURL var="ffpbDetailsURL">
	<portlet:param name="mvcRenderCommandName"
		value="/application/status_details" />
</portlet:renderURL>


<clay:row>

	<clay:col md="5" sm="6">

		<div class="card">
			<div class="card-body">
				<h5 class="card-title ffpb-title">
					<liferay-ui:message key="ffpb-application-status" />
				</h5>
				<aui:form action="${ffpbDetailsURL}" name="fm">

					<aui:row>
						<aui:col width="80" cssClass="ffpb-screen">
							<aui:input name="applplicationNumber" type="text" required="true"
								label="application-number" />
							<aui:input name="statusDateOfBirth" type="Date" required="true"
								label="date-of-birth" />
							<aui:input name="<%=Constants.CMD%>" type="hidden"
								value="status" />
							<aui:button type="submit" value="submit" />
						</aui:col>
					</aui:row>

				</aui:form>
                <c:choose>
              <c:when test="${not empty alert && not empty message}">
					<div class="alert alert-dismissible ${alert}" role="alert">
						<strong class="lead"><liferay-ui:message key="${message}" arguments="${cardno}"/></strong>
					</div>
			 </c:when>
             <c:when test="${not empty applicationError && not empty args }">
                <div class="alert alert-dismissible alert-info" role="alert">
                    <strong class="lead"><liferay-ui:message key="${applicationError}" arguments='${args}'/></strong>
                </div>
             </c:when>
            </c:choose>
                
			</div>

		</div>


	</clay:col>
	<clay:col md="5" sm="6">
		<div class="card">
			<div class="card-body">
				<h5 class="card-title ffpb-title">
					<liferay-ui:message key="ffpb-details" />
				</h5>
				<aui:form action="${ffpbDetailsURL}" name="fm1">

					<aui:row>
						<aui:col width="80" cssClass="ffpb-screen">
							<aui:input name="ffpCardNumber" type="text" required="true"
								label="ffp-card-number" />
							<aui:input name="detailsDateOfBirth" type="Date" required="true"
								label="date-of-birth" />
							<aui:input name="<%=Constants.CMD%>" type="hidden"
								value="details" />
							<aui:button type="submit" value="submit" />
						</aui:col>
					</aui:row>
				</aui:form>

                <c:if test="${not empty error && not empty args }">
                    <div class="alert alert-dismissible alert-info" role="alert">
                        <strong class="lead"><liferay-ui:message key="${error}" arguments='${args}'/></strong>
                    </div>
                 </c:if>

			</div>
		</div>
	</clay:col>
</clay:row>

<h1>Hello</h1>


