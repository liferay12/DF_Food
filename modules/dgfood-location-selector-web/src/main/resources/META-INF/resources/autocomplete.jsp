
<div class="form-group">
	<div class="input-group">
		<div class="input-group-item">
			<div class="dropdown">
			
			 <aui:input type="text"  label="location-name" name="locationName" onkeyup="filterList(event.target.value)" wrappedField="true" onfocus="showList()"
					placeholder="location-search" value="<%= (userLocation != null) ? userLocation.getLocationName() : StringPool.BLANK%>">
					<aui:validator name="required" errorMessage="this-filed-is-required"></aui:validator>
					<aui:validator name="custom" errorMessage="please-select-a-location-from-the-drop-down">
					  function(){

						    if(Number(document.getElementById('<portlet:namespace />locationId').value) > 0){
						         return true;
						    }else{
						      return false;
						    }
					   }
					    
					</aui:validator>
			</aui:input>
			
			
				<ul class="autocomplete-dropdown-menu dropdown-menu show"  style="display: none;" id="list">
				</ul>
			</div>
		</div>
	</div>
</div>

