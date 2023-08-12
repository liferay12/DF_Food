<%@ include file="/init.jsp" %>

<portlet:resourceURL id="/generatereport" var="generateReportURL"></portlet:resourceURL>

<aui:form cssClass="container-fluid-1280" method="post" name="fm">
	<input type="button" class="btn btn-primary" value="Print PDF Report" onClick="exportToPDF()"></input>
</aui:form>

<liferay-util:buffer var="onClickFn">
			 submitForm(document.hrefFm, '<%=generateReportURL + "&compress=0&etag=0&strip=0"%>');
</liferay-util:buffer>

<div class="row">
				<div class="col-md-12">
					<a  class="btn btn-info exportBtn" style="color: #ffffff;" onclick="<%=onClickFn%>">Export Excel</a>
				</div>	
</div>	
			
<script>
	function exportToPDF() {			
			$.ajax({
	            type: "POST",
	            url: "${generateReportURL}",
	            data: {
	            	
	            },
	            success: function(data) { 
	               var win = window.open("", "Report", "toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes,width=900,height=600,top="+(screen.height-400)+",left="+(screen.width-840));
	            	$(win.document.head).append('<link href="<%=request.getContextPath()%>/css/main.css" media = "all" rel="stylesheet" type="text/css"></link>');
					
					win.document.body.innerHTML = data;
	                setTimeout(function(){ 
	                	win.document.title = "Report";
						win.print();
						win.onafterprint = function(){ win.close()};
					},1000)
					
	            },
	            error: function(data) { }
	        });
	}
</script>


<portlet:resourceURL id="/generatereport/pdf" var="generatePDFReportURL"></portlet:resourceURL>

<div class="mb-5">
    <input type="button" class="btn btn-primary" value="Print License (English)" onClick="exportLicenseAsPDF('en_US', '123', 'food-grain-license')"></input>
    <input type="button" class="btn btn-primary" value="Print License (Bangla)" onClick="exportLicenseAsPDF('bn_BD', '123', 'food-grain-license')"></input>
</div>


<script>
function exportLicenseAsPDF(languageId, fgLicenseNumber, licenseType) {
	$.ajax({
        type: "POST",
        url: "${generatePDFReportURL}",
        data: {
        	<portlet:namespace />languageId: languageId,
        	<portlet:namespace />foodGrainLicenseNumber: fgLicenseNumber,
        	<portlet:namespace />licenseApplicationType: licenseType
        },
        success: function(data) { 
            var win = window.open("", "Contract", "toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes,width=900,height=600,top="+(screen.height-400)+",left="+(screen.width-840));
        	$(win.document.head).append('<link href="<%=request.getContextPath()%>/css/main.css" media = "all" rel="stylesheet" type="text/css"></link>');
			win.document.body.innerHTML = data;
            setTimeout(function(){ 
            	win.document.title = 'Food Grain License';
				win.print();
				win.onafterprint = function(){ win.close()};
			},1000)
        },
        error: function(data) { }
    });
}

</script>