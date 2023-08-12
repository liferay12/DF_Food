<%@include file="../../init.jsp"%>
<%
	String acceptedImageExtensions = "image/*";
	String acceptedmagePDFExtensions = "image/*,application/pdf";
%>

<h3>
	<liferay-ui:message key="electricity-bill-information"></liferay-ui:message>
</h3>

<div class="row">
	<div class="col-6">
		<label for="electricityConnection"><liferay-ui:message key="electricity-connection-label"></liferay-ui:message><span
			class="txt-red">*</span></label>
		<aui:input name="electricityConnection" checked="true" type="radio" label="yes" value="1"></aui:input>
		<aui:input name="electricityConnection" type="radio" label="no" value="0"></aui:input>
	</div>
	
	<div class="col-6">
		<label for="electricityMeterNumber"><liferay-ui:message
				key="electricityMeterNumber-label"></liferay-ui:message></label>
		<aui:input name="electricityMeterNumber" cssClass="form-control"
			id="electricityMeterNumber" label="" type="text" placeholder="electricityMeterNumber-label"
			value="72832" maxLength="10" minLength="6">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">10</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">6</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	
	<div class="col-6">
		<label for="lastBillAmountInTaka"><liferay-ui:message
				key="lastBillAmountInTaka-label"></liferay-ui:message></label>
		<aui:input name="lastBillAmountInTaka" cssClass="form-control"
			id="lastBillAmountInTaka" label="" type="text" placeholder="lastBillAmountInTaka-label"
			value="20" maxLength="10" minLength="6">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">6</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	
	<div class="col-6">
		<label for="maximumLoadingCapacity"><liferay-ui:message
				key="maximumLoadingCapacity-label"></liferay-ui:message></label>
		<aui:input name="maximumLoadingCapacity" cssClass="form-control"
			id="maximumLoadingCapacity" label="" type="text" placeholder="maximumLoadingCapacity-label"
			value="500" maxLength="10" minLength="6">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">6</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	
	<div class="col-6">
		<label for="electricityConnectionDocument"><liferay-ui:message
				key="electricity-connection-document"></liferay-ui:message></label>
		<aui:input type="file" name="electricityConnectionDocument" multiple="true" label=""
			onchange="setUploadSize(this)">
			<aui:validator name="acceptFiles">'jpg,png,pdf,docx'</aui:validator>
			<aui:validator name="custom" errorMessage="file-size-error-label">
				function(val,node,junction){
					if(uploadSize==true){
						return true;
					}else{
						return false;
					}
				}
			</aui:validator>
		</aui:input>
	</div>
</div>

<h3>
	<liferay-ui:message key="boiler-information"></liferay-ui:message>
</h3>
<div class="row">
	
	<div class="col-6">
		<label for="boilerCount"><liferay-ui:message
				key="boilerCount-label"></liferay-ui:message></label>
		<aui:input name="boilerCount" cssClass="form-control"
			id="boilerCount" label="" type="text" placeholder="count-of-boilers-label"
			value="6" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">2</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	
	<div class="col-6">
		<label for="boilerSafety"><liferay-ui:message key="boiler-safety-label"></liferay-ui:message><span
			class="txt-red">*</span></label>
		<aui:input name="boilerSafety" checked="true" type="radio" label="yes" value="1"></aui:input>
		<aui:input name="boilerSafety" type="radio" label="no" value="0"></aui:input>
	</div>

	<div class="col-6">
		<label for="boilerPressureInstrumentAvailable"><liferay-ui:message key="boiler-pressure-instrument-available-label"></liferay-ui:message><span
			class="txt-red">*</span></label>
		<aui:input name="boilerPressureInstrumentAvailable" checked="true" type="radio" label="yes" value="1"></aui:input>
		<aui:input name="boilerPressureInstrumentAvailable" type="radio" label="no" value="0"></aui:input>
	</div>
</div>

<h3>
	<liferay-ui:message key="chimney-information"></liferay-ui:message>
</h3>

<div class="row">
	<div class="col-6">
		<label for="chimneyHeight"><liferay-ui:message
				key="chimneyHeight-label"></liferay-ui:message></label>
		<aui:input name="chimneyHeight" cssClass="form-control"
			id="chimneyHeight" label="" type="text" placeholder="chimneyHeight-label"
			value="30" maxLength="4" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
</div>

<h3>
	<liferay-ui:message key="chatal-information"></liferay-ui:message>
</h3>

<div class="row">
	
	<div class="col-6">
		<label for="chatalCount"><liferay-ui:message
				key="chatalCount-label"></liferay-ui:message></label>
		<aui:input name="chatalCount" cssClass="form-control"
			id="chatalCount" label="" type="text" placeholder="chatalCount-label"
			value="4" maxLength="4" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	
	<div class="col-6">
		<label for="chatalArea"><liferay-ui:message
				key="chatalArea-label"></liferay-ui:message></label>
		<aui:input name="chatalArea" cssClass="form-control"
			id="chatalArea" label="" type="text" placeholder="chatalArea-label"
			value="2000" maxLength="4" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	
	<div class="col-6">
		<label for="oldLicenseNumber"><liferay-ui:message
				key="oldLicenseNumber-label"></liferay-ui:message></label>
		<aui:input name="oldLicenseNumber" cssClass="form-control"
			id="oldLicenseNumber" label="" type="text"
			placeholder="oldLicenseNumber-label" value="123567" maxLength="30"
			minLength="1">
			<aui:validator name="alphanum"/>
			<aui:validator name="maxLength"
				errorMessage="maxlength-thirty-error-label">30</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-one-error-label">1</aui:validator>
		</aui:input>
	</div>
	
	<div class="col-6">
		<label for="chatalCapacityOfPaddyDried"><liferay-ui:message
				key="chatalCapacityOfPaddyDried-label"></liferay-ui:message></label>
		<aui:input name="chatalCapacityOfPaddyDried" cssClass="form-control"
			id="chatalCapacityOfPaddyDried" label="" type="text" placeholder="chatalCapacityOfPaddyDried-label"
			value="1000" maxLength="4" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
</div>

<h3>
	<liferay-ui:message key="striping-house-information"></liferay-ui:message>
</h3>

<div class="row">

	<div class="col-4">
		<label for="stripingHouseCount"><liferay-ui:message
				key="stripingHouseCount-label"></liferay-ui:message></label>
		<aui:input name="stripingHouseCount" cssClass="form-control"
			id="stripingHouseCount" label="" type="text" placeholder="stripingHouseCount-label"
			value="7" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-4">
		<label for="stripingHouseCapacity"><liferay-ui:message
				key="stripingHouseCapacity-label"></liferay-ui:message></label>
		<aui:input name="stripingHouseCapacity" cssClass="form-control"
			id="stripingHouseCapacity" label="" type="text" placeholder="stripingHouseCapacity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-4">
		<label for="stripingHousePaddyDippedCapacity"><liferay-ui:message
				key="stripingHousePaddyDippedCapacity-label"></liferay-ui:message></label>
		<aui:input name="stripingHousePaddyDippedCapacity" cssClass="form-control validate"
			id="stripingHousePaddyDippedCapacity" label="" type="text" placeholder="stripingHousePaddyDippedCapacity-label"
			value="1500" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
</div>

<h3>
	<liferay-ui:message key="mill-storage-information"></liferay-ui:message>
</h3>

<div class="row">
	
	<div class="col-6">
		<label for="godownsCount"><liferay-ui:message
				key="godownsCount-label"></liferay-ui:message></label>
		<aui:input name="godownsCount" cssClass="form-control"
			id="godownsCount" label="" type="text" placeholder="godownsCount-label"
			value="5" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	
	<div class="col-6">
		<label for="godownVolume"><liferay-ui:message
				key="godownVolume-label"></liferay-ui:message></label>
		<aui:input name="godownVolume" cssClass="form-control"
			id="godownVolume" label="" type="text" placeholder="godownVolume-label"
			value="2230" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	
	<div class="col-6">
		<label for="godownStorageCapacity"><liferay-ui:message
				key="godownStorageCapacity-label"></liferay-ui:message></label>
		<aui:input name="godownStorageCapacity" cssClass="form-control"
			id="godownStorageCapacity" label="" type="text" placeholder="godownStorageCapacity-label"
			value="3020" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
</div>

<h3><liferay-ui:message key="motors-information"></liferay-ui:message></h3>

<div class="row">
	
	<div class="col-6">
		<label for="motorsCount"><liferay-ui:message
				key="motorsCount-label"></liferay-ui:message></label>
		<aui:input name="motorsCount" cssClass="form-control"
			id="motorsCount" label="" type="text" placeholder="motorsCount-label"
			value="5" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	
	<div class="col-6">
		<label for="totalHuskingCapacity"><liferay-ui:message
				key="totalHuskingCapacity-label"></liferay-ui:message></label>
		<aui:input name="totalHuskingCapacity" cssClass="form-control"
			id="totalHuskingCapacity" label="" type="text" placeholder="totalHuskingCapacity-label"
			value="2012" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	
	<div class="col-6">
		<label for="avgHuskingCapacity"><liferay-ui:message
				key="avgHuskingCapacity-label"></liferay-ui:message></label>
		<aui:input name="avgHuskingCapacity" cssClass="form-control"
			id="avgHuskingCapacity" label="" type="text" placeholder="avgHuskingCapacity-label"
			value="1650" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
</div>

<h3>
	<liferay-ui:message key="milling-capacity-information"></liferay-ui:message>
</h3>

<div class="row">
	<div class="col-6">
		<label for="transformerCapacity"><liferay-ui:message
				key="transformerCapacity-label"></liferay-ui:message></label>
		<aui:input name="transformerCapacity" cssClass="form-control"
			id="transformerCapacity" label="" type="text" placeholder="transformerCapacity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="transformerQuantity"><liferay-ui:message
				key="transformerQuantity-label"></liferay-ui:message></label>
		<aui:input name="transformerQuantity" cssClass="form-control"
			id="transformerQuantity" label="" type="text" placeholder="transformerQuantity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="sanctionLoadCapacity"><liferay-ui:message
				key="sanctionLoadCapacity-label"></liferay-ui:message></label>
		<aui:input name="sanctionLoadCapacity" cssClass="form-control"
			id="sanctionLoadCapacity" label="" type="text" placeholder="sanctionLoadCapacity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="sanctionLoadQuantity"><liferay-ui:message
				key="sanctionLoadQuantity-label"></liferay-ui:message></label>
		<aui:input name="sanctionLoadQuantity" cssClass="form-control"
			id="sanctionLoadQuantity" label="" type="text" placeholder="sanctionLoadQuantity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="boilerCapacity"><liferay-ui:message
				key="boilerCapacity-label"></liferay-ui:message></label>
		<aui:input name="boilerCapacity" cssClass="form-control"
			id="boilerCapacity" label="" type="text" placeholder="boilerCapacity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="boilerQuantity"><liferay-ui:message
				key="boilerQuantity-label"></liferay-ui:message></label>
		<aui:input name="boilerQuantity" cssClass="form-control"
			id="boilerQuantity" label="" type="text" placeholder="boilerQuantity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="warehouseStorageCapacity"><liferay-ui:message
				key="warehouseStorageCapacity-label"></liferay-ui:message></label>
		<aui:input name="warehouseStorageCapacity" cssClass="form-control"
			id="warehouseStorageCapacity" label="" type="text" placeholder="warehouseStorageCapacity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="warehouseStorageCapacityQuantity"><liferay-ui:message
				key="warehouseStorageCapacityQuantity-label"></liferay-ui:message></label>
		<aui:input name="warehouseStorageCapacityQuantity" cssClass="form-control"
			id="warehouseStorageCapacityQuantity" label="" type="text" placeholder="warehouseStorageCapacityQuantity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="paddyStorageBinCapacity"><liferay-ui:message
				key="paddyStorageBinCapacity-label"></liferay-ui:message></label>
		<aui:input name="paddyStorageBinCapacity" cssClass="form-control"
			id="paddyStorageBinCapacity" label="" type="text" placeholder="paddyStorageBinCapacity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="paddyStorageBinCapacityQuantity"><liferay-ui:message
				key="paddyStorageBinCapacityQuantity-label"></liferay-ui:message></label>
		<aui:input name="paddyStorageBinCapacityQuantity" cssClass="form-control"
			id="paddyStorageBinCapacityQuantity" label="" type="text" placeholder="paddyStorageBinCapacityQuantity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="parBoilingUnitContainerCapacity"><liferay-ui:message
				key="parBoilingUnitContainerCapacity-label"></liferay-ui:message></label>
		<aui:input name="parBoilingUnitContainerCapacity" cssClass="form-control"
			id="parBoilingUnitContainerCapacity" label="" type="text" placeholder="parBoilingUnitContainerCapacity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="parBoilingUnitContainerQuantity"><liferay-ui:message
				key="parBoilingUnitContainerQuantity-label"></liferay-ui:message></label>
		<aui:input name="parBoilingUnitContainerQuantity" cssClass="form-control"
			id="parBoilingUnitContainerQuantity" label="" type="text" placeholder="parBoilingUnitContainerQuantity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="dryerCapacity"><liferay-ui:message
				key="dryerCapacity-label"></liferay-ui:message></label>
		<aui:input name="dryerCapacity" cssClass="form-control"
			id="dryerCapacity" label="" type="text" placeholder="dryerCapacity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="dryerQuantity"><liferay-ui:message
				key="dryerQuantity-label"></liferay-ui:message></label>
		<aui:input name="dryerQuantity" cssClass="form-control"
			id="dryerQuantity" label="" type="text" placeholder="dryerQuantity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="cleanerUnitSeriesCapacity"><liferay-ui:message
				key="cleanerUnitSeriesCapacity-label"></liferay-ui:message></label>
		<aui:input name="cleanerUnitSeriesCapacity" cssClass="form-control"
			id="cleanerUnitSeriesCapacity" label="" type="text" placeholder="cleanerUnitSeriesCapacity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="cleanerUnitSeriesQuantity"><liferay-ui:message
				key="cleanerUnitSeriesQuantity-label"></liferay-ui:message></label>
		<aui:input name="cleanerUnitSeriesQuantity" cssClass="form-control"
			id="cleanerUnitSeriesQuantity" label="" type="text" placeholder="cleanerUnitSeriesQuantity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="distonerCapacity"><liferay-ui:message
				key="distonerCapacity-label"></liferay-ui:message></label>
		<aui:input name="distonerCapacity" cssClass="form-control"
			id="distonerCapacity" label="" type="text" placeholder="distonerCapacity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="distonerQuantity"><liferay-ui:message
				key="distonerQuantity-label"></liferay-ui:message></label>
		<aui:input name="distonerQuantity" cssClass="form-control"
			id="distonerQuantity" label="" type="text" placeholder="distonerQuantity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="shellerCapacity"><liferay-ui:message
				key="shellerCapacity-label"></liferay-ui:message></label>
		<aui:input name="shellerCapacity" cssClass="form-control"
			id="shellerCapacity" label="" type="text" placeholder="shellerCapacity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="shellerQuantity"><liferay-ui:message
				key="shellerQuantity-label"></liferay-ui:message></label>
		<aui:input name="shellerQuantity" cssClass="form-control"
			id="shellerQuantity" label="" type="text" placeholder="shellerQuantity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="paddySeparatorCapacity"><liferay-ui:message
				key="paddySeparatorCapacity-label"></liferay-ui:message></label>
		<aui:input name="paddySeparatorCapacity" cssClass="form-control"
			id="paddySeparatorCapacity" label="" type="text" placeholder="paddySeparatorCapacity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="paddySeparatorQuantity"><liferay-ui:message
				key="paddySeparatorQuantity-label"></liferay-ui:message></label>
		<aui:input name="paddySeparatorQuantity" cssClass="form-control"
			id="paddySeparatorQuantity" label="" type="text" placeholder="paddySeparatorQuantity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="riceWhitenerCapacity"><liferay-ui:message
				key="riceWhitenerCapacity-label"></liferay-ui:message></label>
		<aui:input name="riceWhitenerCapacity" cssClass="form-control"
			id="riceWhitenerCapacity" label="" type="text" placeholder="riceWhitenerCapacity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="riceWhitenerQuantity"><liferay-ui:message
				key="riceWhitenerQuantity-label"></liferay-ui:message></label>
		<aui:input name="riceWhitenerQuantity" cssClass="form-control"
			id="riceWhitenerQuantity" label="" type="text" placeholder="riceWhitenerQuantity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="riceGraderCapacity"><liferay-ui:message
				key="riceGraderCapacity-label"></liferay-ui:message></label>
		<aui:input name="riceGraderCapacity" cssClass="form-control"
			id="riceGraderCapacity" label="" type="text" placeholder="riceGraderCapacity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="riceGraderQuantity"><liferay-ui:message
				key="riceGraderQuantity-label"></liferay-ui:message></label>
		<aui:input name="riceGraderQuantity" cssClass="form-control"
			id="riceGraderQuantity" label="" type="text" placeholder="riceGraderQuantity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="riceSmoothingUnitCapacity"><liferay-ui:message
				key="riceSmoothingUnitCapacity-label"></liferay-ui:message></label>
		<aui:input name="riceSmoothingUnitCapacity" cssClass="form-control"
			id="riceSmoothingUnitCapacity" label="" type="text" placeholder="riceSmoothingUnitCapacity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="riceSmoothingUnitQuantity"><liferay-ui:message
				key="riceSmoothingUnitQuantity-label"></liferay-ui:message></label>
		<aui:input name="riceSmoothingUnitQuantity" cssClass="form-control"
			id="riceSmoothingUnitQuantity" label="" type="text" placeholder="riceSmoothingUnitQuantity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="colorSorterUnitCapacity"><liferay-ui:message
				key="colorSorterUnitCapacity-label"></liferay-ui:message></label>
		<aui:input name="colorSorterUnitCapacity" cssClass="form-control"
			id="colorSorterUnitCapacity" label="" type="text" placeholder="colorSorterUnitCapacity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="colorSorterUnitQuantity"><liferay-ui:message
				key="colorSorterUnitQuantity-label"></liferay-ui:message></label>
		<aui:input name="colorSorterUnitQuantity" cssClass="form-control"
			id="colorSorterUnitQuantity" label="" type="text" placeholder="colorSorterUnitQuantity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="thicknessGraderUnitCapacity"><liferay-ui:message
				key="thicknessGraderUnitCapacity-label"></liferay-ui:message></label>
		<aui:input name="thicknessGraderUnitCapacity" cssClass="form-control"
			id="thicknessGraderUnitCapacity" label="" type="text" placeholder="thicknessGraderUnitCapacity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="thicknessGraderUnitQuantity"><liferay-ui:message
				key="thicknessGraderUnitQuantity-label"></liferay-ui:message></label>
		<aui:input name="thicknessGraderUnitQuantity" cssClass="form-control"
			id="thicknessGraderUnitQuantity" label="" type="text" placeholder="thicknessGraderUnitQuantity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="gunnyBagPackingCapacity"><liferay-ui:message
				key="gunnyBagPackingCapacity-label"></liferay-ui:message></label>
		<aui:input name="gunnyBagPackingCapacity" cssClass="form-control"
			id="gunnyBagPackingCapacity" label="" type="text" placeholder="gunnyBagPackingCapacity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-6">
		<label for="gunnyBagPackingQuantity"><liferay-ui:message
				key="gunnyBagPackingQuantity-label"></liferay-ui:message></label>
		<aui:input name="gunnyBagPackingQuantity" cssClass="form-control"
			id="gunnyBagPackingQuantity" label="" type="text" placeholder="gunnyBagPackingQuantity-label"
			value="2000" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
</div>

<aui:button-row>
	<aui:button id="backToNidInfo" value='back'
		onClick="showNextOrPreviousStep('mill_info_one');"></aui:button>
	<aui:button id="nextToPreviewInfo" value='next'
		onClick="previewDataAndShowNextPage('mill_info_two','preview_info');"></aui:button>
</aui:button-row>

<script>
function previewDataAndShowNextPage(currentDivId, nextDivId) {
	//Call to validate fields and the go to Next Step
	validateFields(currentDivId, nextDivId);
	
	//To Remove old data in the preview
	$("#<portlet:namespace/>preview_foodGrainLicenseNumber").text('');
	$("#<portlet:namespace/>preview_foodGrainLicenseIssueDate").text('');
	$("#<portlet:namespace/>preview_foodGrainLicenseValidity").text('');
	$("#<portlet:namespace/>preview_maritalStatus").text('');
	$("#<portlet:namespace/>preview_spouseName").text('');
	$("#<portlet:namespace/>preview_spouseFatherName").text('');
	$("#<portlet:namespace/>preview_spouseNationalId").text('');
	$("#<portlet:namespace/>preview_spouseDateOfBirth").text('');
	
	$("#<portlet:namespace/>preview_ownMillOperates").text('');
	$("#<portlet:namespace/>preview_millerThirdParty").text('');
	$("#<portlet:namespace/>preview_operatorName").text('');
	$("#<portlet:namespace/>preview_operatorNationalId").text('');
	$("#<portlet:namespace/>preview_operatorRunningBusinessFromYears").text('');
	$("#<portlet:namespace/>preview_publicRepresentative").text('');
	$("#<portlet:namespace/>preview_workInGovt").text('');
	
	$("#<portlet:namespace/>preview_millName").text('');
	$("#<portlet:namespace/>preview_millLength").text('');
	$("#<portlet:namespace/>preview_millHeight").text('');
	$("#<portlet:namespace/>preview_millWidth").text('');
	$("#<portlet:namespace/>preview_millStorage").text('');
	$("#<portlet:namespace/>preview_typeOfMill").text('');
	$("#<portlet:namespace/>preview_millFloorPaved").text('');
	$("#<portlet:namespace/>preview_typeOfRice").text('');
	
	$("#<portlet:namespace/>preview_millRegion").text('');
	$("#<portlet:namespace/>preview_millZilla").text('');
	$("#<portlet:namespace/>preview_millUpazilla").text('');
	$("#<portlet:namespace/>preview_millUnion").text('');
	$("#<portlet:namespace/>preview_millVillage").text('');
	$("#<portlet:namespace/>preview_millWard").text('');
	$("#<portlet:namespace/>preview_millZipCode").text('');
	$("#<portlet:namespace/>preview_millPostOffice").text('');
	$("#<portlet:namespace/>preview_millAddress").text('');
	
	$("#<portlet:namespace/>preview_bankAccountNumber").text('');
	$("#<portlet:namespace/>preview_bankAccountHolderName").text('');
	$("#<portlet:namespace/>preview_bankName").text('');
	$("#<portlet:namespace/>preview_bankBranchNameAndAddress").text('');
	
	$("#<portlet:namespace/>preview_electricityConnection").text('');
	$("#<portlet:namespace/>preview_electricityMeterNumber").text('');
	$("#<portlet:namespace/>preview_lastBillAmountInTaka").text('');
	$("#<portlet:namespace/>preview_maximumLoadingCapacity").text('');

	$("#<portlet:namespace/>preview_countOfBoilers").text('');
	$("#<portlet:namespace/>preview_boilerSafety").text('');
	$("#<portlet:namespace/>preview_boilerPressureInstrument").text('');
	
	$("#<portlet:namespace/>preview_chimneyHeight").text('');
	
	$("#<portlet:namespace/>preview_chatalCount").text('');
	$("#<portlet:namespace/>preview_chatalArea").text('');
	$("#<portlet:namespace/>preview_oldLicenseNumber").text('');
	$("#<portlet:namespace/>preview_capacityOfPaddyDried").text('');
	
	$("#<portlet:namespace/>preview_stripingHouseCount").text('');
	$("#<portlet:namespace/>preview_stripingHouseCapacity").text('');
	$("#<portlet:namespace/>preview_dippedCapacityOfPaddyInStriping").text('');
	
	$("#<portlet:namespace/>preview_godownsCount").text('');
	$("#<portlet:namespace/>preview_godownVolume").text('');
	$("#<portlet:namespace/>preview_godownStorageCapacity").text('');
	
	$("#<portlet:namespace/>preview_motorsCount").text('');
	$("#<portlet:namespace/>preview_totalHuskingCapacity").text('');
	$("#<portlet:namespace/>preview_avgHuskingCapacity").text('');

	//To assign values in the preview
	
	$("#<portlet:namespace/>preview_foodGrainLicenseNumber").text($("#<portlet:namespace/>foodGrainLicenseNumber").val());
	$("#<portlet:namespace/>preview_foodGrainLicenseIssueDate").text($("#<portlet:namespace/>foodGrainLicenseIssueDate").val());
	$("#<portlet:namespace/>preview_foodGrainLicenseValidity").text($("#<portlet:namespace/>foodGrainLicenseValidity").val());
	var maritalStatus = $("input[name='<portlet:namespace/>maritalStatus']:checked").val();
	console.log("maritalStatus - "+maritalStatus);
	if(maritalStatus == "0"){
		$("#<portlet:namespace/>preview_maritalStatus").text("Unmarried");
	}else if(maritalStatus == "1"){
		$("#<portlet:namespace/>preview_maritalStatus").text("Married");
	}else if(maritalStatus == "2"){
		$("#<portlet:namespace/>preview_maritalStatus").text("Divorced");
	}else if(maritalStatus == "3"){
		$("#<portlet:namespace/>preview_maritalStatus").text("Widow");
	}else{
		$("#<portlet:namespace/>preview_maritalStatus").text("Widower");
	}
	$("#<portlet:namespace/>preview_spouseName").text($("#<portlet:namespace/>spouseName").val());
	$("#<portlet:namespace/>preview_spouseFatherName").text($("#<portlet:namespace/>spouseFatherName").val());
	$("#<portlet:namespace/>preview_spouseNationalId").text($("#<portlet:namespace/>spouseNationalId").val());
	$("#<portlet:namespace/>preview_spouseDateOfBirth").text($("#<portlet:namespace/>spouseDateOfBirth").val());
	
	$("#<portlet:namespace/>preview_ownMillOperates").text($("input[name='<portlet:namespace/>ownMillOperates']:checked").val());
	$("#<portlet:namespace/>preview_millerThirdParty").text($("input[name='<portlet:namespace/>millerThirdParty']:checked").val());
	$("#<portlet:namespace/>preview_operatorName").text($("#<portlet:namespace/>operatorName").val());
	$("#<portlet:namespace/>preview_operatorNationalId").text($("#<portlet:namespace/>operatorNationalId").val());
	$("#<portlet:namespace/>preview_operatorRunningBusinessFromYears").text($("#<portlet:namespace/>operatorRunningBusinessFromYears").val());
	$("#<portlet:namespace/>preview_publicRepresentative").text($("input[name='<portlet:namespace/>publicRepresentative']:checked").val());
	$("#<portlet:namespace/>preview_workInGovt").text($("input[name='<portlet:namespace/>workInGovt']:checked").val());
	
	$("#<portlet:namespace/>preview_millName").text($("#<portlet:namespace/>millName").val());
	$("#<portlet:namespace/>preview_millLength").text($("#<portlet:namespace/>millLength").val());
	$("#<portlet:namespace/>preview_millHeight").text($("#<portlet:namespace/>millHeight").val());
	$("#<portlet:namespace/>preview_millWidth").text($("#<portlet:namespace/>millWidth").val());
	$("#<portlet:namespace/>preview_millStorage").text($("#<portlet:namespace/>millStorage").val());
	$("#<portlet:namespace/>preview_typeOfMill").text($("input[name='<portlet:namespace/>typeOfMill']:checked").val());
	$("#<portlet:namespace/>preview_millFloorPaved").text($("input[name='<portlet:namespace/>millFloorPaved']:checked").val());
	$("#<portlet:namespace/>preview_typeOfRice").text($("input[name='<portlet:namespace/>typeOfRice']:checked").val());
	
	$("#<portlet:namespace/>preview_millRegion").text($("#<portlet:namespace/>millRegion").find('option:selected').text());
	$("#<portlet:namespace/>preview_millZilla").text($("#<portlet:namespace/>millZilla").find('option:selected').text());
	$("#<portlet:namespace/>preview_millUpazilla").text($("#<portlet:namespace/>millUpazilla").find('option:selected').text());
	$("#<portlet:namespace/>preview_millUnion").text($("#<portlet:namespace/>millUnion").find('option:selected').text());
	$("#<portlet:namespace/>preview_millVillage").text($("#<portlet:namespace/>millVillage").val());
	$("#<portlet:namespace/>preview_millWard").text($("#<portlet:namespace/>millWard").find('option:selected').text());
	$("#<portlet:namespace/>preview_millZipCode").text($("#<portlet:namespace/>millZipCode").val());
	$("#<portlet:namespace/>preview_millPostOffice").text($("#<portlet:namespace/>millPostOffice").text());
	$("#<portlet:namespace/>preview_millAddress").text($("#<portlet:namespace/>millAddress").val());
	
	$("#<portlet:namespace/>preview_bankAccountNumber").text($("#<portlet:namespace/>bankAccountNumber").val());
	$("#<portlet:namespace/>preview_bankAccountHolderName").text($("#<portlet:namespace/>bankAccountHolderName").val());
	$("#<portlet:namespace/>preview_bankName").text($("#<portlet:namespace/>bankName").val());
	$("#<portlet:namespace/>preview_bankBranchNameAndAddress").text($("#<portlet:namespace/>bankBranchNameAndAddress").val());
	
	$("#<portlet:namespace/>preview_electricityConnection").text($("input[name='<portlet:namespace/>electricityConnection']:checked").val());
	$("#<portlet:namespace/>preview_electricityMeterNumber").text($("#<portlet:namespace/>electricityMeterNumber").val());
	$("#<portlet:namespace/>preview_lastBillAmountInTaka").text($("#<portlet:namespace/>lastBillAmountInTaka").val());
	$("#<portlet:namespace/>preview_maximumLoadingCapacity").text($("#<portlet:namespace/>maximumLoadingCapacity").val());

	$("#<portlet:namespace/>preview_countOfBoilers").text($("#<portlet:namespace/>countOfBoilers").val());
	$("#<portlet:namespace/>preview_boilerSafety").text($("input[name='<portlet:namespace/>boilerSafety']:checked").val());
	$("#<portlet:namespace/>preview_boilerPressureInstrument").text($("input[name='<portlet:namespace/>boilerPressureInstrument']:checked").val());
	
	$("#<portlet:namespace/>preview_chimneyHeight").text($("#<portlet:namespace/>chimneyHeight").val());
	
	$("#<portlet:namespace/>preview_chatalCount").text($("#<portlet:namespace/>chatalCount").val());
	$("#<portlet:namespace/>preview_chatalArea").text($("#<portlet:namespace/>chatalArea").val());
	$("#<portlet:namespace/>preview_oldLicenseNumber").text($("#<portlet:namespace/>oldLicenseNumber").val());
	$("#<portlet:namespace/>preview_capacityOfPaddyDried").text($("#<portlet:namespace/>capacityOfPaddyDried").val());
	
	$("#<portlet:namespace/>preview_stripingHouseCount").text($("#<portlet:namespace/>stripingHouseCount").val());
	$("#<portlet:namespace/>preview_stripingHouseCapacity").text($("#<portlet:namespace/>stripingHouseCapacity").val());
	$("#<portlet:namespace/>preview_dippedCapacityOfPaddyInStriping").text($("#<portlet:namespace/>dippedCapacityOfPaddyInStriping").val());
	
	$("#<portlet:namespace/>preview_godownsCount").text($("#<portlet:namespace/>godownsCount").val());
	$("#<portlet:namespace/>preview_godownVolume").text($("#<portlet:namespace/>godownVolume").val());
	$("#<portlet:namespace/>preview_godownStorageCapacity").text($("#<portlet:namespace/>godownStorageCapacity").val());
	
	$("#<portlet:namespace/>preview_motorsCount").text($("#<portlet:namespace/>motorsCount").val());
	$("#<portlet:namespace/>preview_totalHuskingCapacity").text($("#<portlet:namespace/>totalHuskingCapacity").val());
	$("#<portlet:namespace/>preview_avgHuskingCapacity").text($("#<portlet:namespace/>avgHuskingCapacity").val());
	
}
</script>