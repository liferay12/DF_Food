<aui:script>


document.body.addEventListener('click', function(e){

const el = e.target;
//console.log(el.tagName.toLowerCase())
let label = document.getElementById("<portlet:namespace/>locationName");
if(label &&!label.isEqualNode(e.target) && el.tagName.toLowerCase() !== 'li' && el.tagName.toLowerCase() !== 'ul' && el.tagName.toLowerCase() !== 'span'){
      var ul = document.getElementById("list").style.display = "none";
}

}, true); 




Liferay.provide(
			window,
			'<portlet:namespace />submitLocationEntry',
			() => {
		
		var form = Liferay.Form.get('<portlet:namespace />fm');
		var formValidator = form.formValidator;
		formValidator.validate();
		if (!formValidator.hasErrors()) {
			validateLocation();
		}

								
});


function validateLocation(){

var locationType = document.getElementById("<portlet:namespace/>locationType").value;
			let dvUrl = '<%= locationUrlConfiguration.divisionUrl()%>';
			let dsUrl = '<%= locationUrlConfiguration.districtUrl()%>';
			let upUrl = '<%= locationUrlConfiguration.upazilaUrl()%>';
			let unUrl = '<%= locationUrlConfiguration.unionUrl()%>';
			
			let url;
			let locationId = document.getElementById('<portlet:namespace />locationId').value;
			
			if(locationType === 'district'){
				url = dsUrl + locationId;
			}else if(locationType === 'upazila'){
				url = upUrl + locationId;
			}else if(locationType === 'union'){
				url = unUrl + locationId;
			}else{
			   url = dvUrl + locationId;
			}
					
			Liferay.Util.fetch(url)
               .then((response) => {
                         if (response.status === 401) {
										window.location.reload();
									}
									else if (response.ok) {
									
									response.json().then((payload) => {
									
									 document.getElementById('<portlet:namespace />locationCode').value = payload.code;
									 //console.log('payload..',payload);
									 
									 submitForm(document.<portlet:namespace />fm);

									})

									}
									else {
										return response.json();
									}               
               }).then((response) => {
						if (response && response.title) {
						
						Liferay.Util.openToast({
							autoClose: 10000,
							container: document.querySelector('#<portlet:namespace />errorMsg'),
							message: '<liferay-ui:message key="invalid-location-selection" />',
							title: '<liferay-ui:message key="error" />:',
							type: 'danger',
						});

						}
				});	


}


function showList() { 

if(!locList || locList.length <= 0 ){
  getDropdownList();
}else{
  buildDropdown(locList);
}


}



function filterList(val) { 

var ul = document.getElementById("list");
//console.log('list....',locList)

if(val === ''){
	buildDropdown(locList)
}else{
    document.getElementById('<portlet:namespace />locationId').value = '';
	var array = locList && locList.filter(function(item)
	 {
	     return val != '' && item.name.toLowerCase().includes(val.toLowerCase());
	 });
	
	   buildDropdown(array)
}


}


 document.getElementById('<portlet:namespace/>locationType').addEventListener('change',function(e){
 	document.getElementById('<portlet:namespace/>locationName').value = '';
 	document.getElementById('<portlet:namespace />locationId').value = '';
 	var ul = document.getElementById("list");
 	ul.innerHTML = '';
	ul.style.display = "none";
	//console.log('list....',locList)
	getDropdownList();
 })


function setValue(event){

function whichTag(el) {
  return el && el.tagName && el.tagName.toLowerCase();
}

var cur = whichTag(event.target);

var par = whichTag(event.target.parentElement);

if(cur == 'strong' || cur == 'a' || cur =='li'){
  document.getElementById('<portlet:namespace/>locationName').value = event.target.dataset.label;
  document.getElementById('<portlet:namespace/>locationId').value = event.target.dataset.id;
  //document.getElementById('<portlet:namespace/>locationName').focus();

}else if(cur == 'strong' || par == 'a' || par =='li'){
  document.getElementById('<portlet:namespace/>locationName').value = event.target.parentElement.dataset.label;
  document.getElementById('<portlet:namespace/>locationId').value = event.target.dataset.id;
  //document.getElementById('<portlet:namespace/>locationName').focus();
}
var ul = document.getElementById("list").style.display = "none";
		
}


function getDropdownList(){

let dvUrl = '<%= locationUrlConfiguration.divisionUrl()%>';
let dsUrl = '<%= locationUrlConfiguration.districtUrl()%>';
let upUrl = '<%= locationUrlConfiguration.upazilaUrl()%>';
let unUrl = '<%= locationUrlConfiguration.unionUrl()%>';
const locationName = document.getElementById('<portlet:namespace/>locationName');
const locationTypeNode = document.getElementById('<portlet:namespace/>locationType');
const locationType = locationTypeNode.value;
let url;

if(locationType === 'district'){
	url = dsUrl;
}else if(locationType === 'upazila'){
	url = upUrl;
	locationName.disabled = true;
	locationTypeNode.disabled = true;
}else if(locationType === 'union'){
	url = unUrl;
	locationName.disabled = true;
	locationTypeNode.disabled = true;
}else{
   url = dvUrl;
}

const loader = document.querySelector('.loading-animation.loading-animation-sm');
loader.style.display = 'block';

Liferay.Util.fetch(url)
.then((response) => {
  if (response.status === 401) {
		window.location.reload();
   }
   
   else if (response.ok) {
   
   loader.style.display = 'none';
   locationName.disabled = false;
   locationTypeNode.disabled = false;
   response.json().then((payload) => {
   
   locList = payload.items;
    buildDropdown(payload.items);
    
   })
   }else {
		return response.json();
	}
	
 })
.then((response) => {
		if (response && response.title) {
			Liferay.Util.openToast({
				message: response.title,
				type: 'danger',
			});
		}
	});


}


function buildDropdown(arr){


var ul = document.getElementById("list");

 //console.log('arr..',arr);  
 
			ul.innerHTML = '';
			ul.style.display = "block";
			if(arr && arr.length > 0){
			
						arr.forEach(function(item){
			
			     var li = document.createElement("li");
			     li.dataset.label = item.name;
			     li.dataset.id = item.id;
			     li.onclick = setValue;
			     
			     var a = document.createElement("a");
			     a.className = "dropdown-item";
			     a.dataset.label = item.name;
			     a.dataset.id = item.id;
			     
			     var strong = document.createElement("strong");
			     strong.dataset.label = item.name;
			     strong.dataset.id = item.id;
			     strong.appendChild(document.createTextNode(item.name));
			     
			      a.appendChild(strong);
			      li.appendChild(a);    
			      ul.appendChild(li);
			
			});
			
			}else{
			
			 ul.innerHTML = '<li role="presentation"><span class="dropdown-item disabled" disabled="disabled" role="menuitem" tabindex="-1"><liferay-ui:message key="no-results-found" /></span></li>';
			
			}
			


}

var locList = [];

</aui:script>


