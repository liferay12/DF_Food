<%@ include file="/ajax_search_container/init.jsp" %>

<%
	String formId = GetterUtil.getString((String) request.getAttribute("dgfood-ui:ajax-search-container:formId"));

	String containerId = GetterUtil.getString((String) request.getAttribute("dgfood-ui:ajax-search-container:containerId"));

	String resourceId = GetterUtil.getString((String) request.getAttribute("dgfood-ui:ajax-search-container:resourceId"));
	
	String buttonId = GetterUtil.getString((String) request.getAttribute("dgfood-ui:ajax-search-container:buttonId"));
	
    String checkboxId = GetterUtil.getString((String) request.getAttribute("dgfood-ui:ajax-search-container:checkboxId"));
	
	String searchContainerId = GetterUtil.getString((String) request.getAttribute("dgfood-ui:ajax-search-container:searchContainerId"));
%>

<aui:script require="metal-dom/src/all/dom as dom">

	var delegateHandler = dom.delegate(
		document.getElementById('<%=containerId %>'),
		'click',
		'.taglib-search-iterator-page-iterator-bottom li a',
		function (event) {
			event.preventDefault();
		    var uri = event.delegateTarget.getAttribute("href");
			 if (uri != 'javascript:;') {
				                
				uri = uri.replace(/p_p_lifecycle=0/i, 'p_p_lifecycle=2');        
				uri = Liferay.Util.addParams('p_p_resource_id=<%=resourceId %>', uri);
				doSearch(uri);
                   
			}
			
			
		}
	)
	
	document.getElementById('<%=buttonId %>').addEventListener('click', function (event){
	   event.preventDefault();
	   doSearch('<portlet:resourceURL id="<%=resourceId %>"></portlet:resourceURL>');
	})
	
	function doSearch(URI){
	   Liferay.Util.fetch(URI, {
					body: new FormData(document.getElementById('<%=formId %>')),
					method: 'POST',
				})
					.then(function (response) {
						return response.text();
					})
					.then(function (response) {
					    console.log('response...')
						document.getElementById('<%=containerId %>').innerHTML = response;
					    let parentcheckbox = document.getElementById('<%=checkboxId %>');
					    if(parentcheckbox && parentcheckbox.checked){
					       checkoruncheckAll(true);
					    }
					});
	}
	
var checkbox = document.getElementById('<%=checkboxId %>');

if(checkbox){

   checkbox.addEventListener('click', function (event){

      checkoruncheckAll(event.currentTarget.checked)

  })
}	

function checkoruncheckAll(checkboxStatus){

    var checkboxes = document.querySelectorAll('#<%=searchContainerId %> table input[type="checkbox"]');
    for (var checkbox of checkboxes) {
        checkbox.checked = checkboxStatus;
    }

}	
	
</aui:script>

