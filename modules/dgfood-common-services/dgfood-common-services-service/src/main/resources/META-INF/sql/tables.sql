create table DGF_APIAudit (
	apiAuditId LONG not null primary key,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	sender VARCHAR(75) null,
	receiver VARCHAR(75) null,
	requestPayload VARCHAR(75) null,
	responsePayload VARCHAR(75) null,
	requestClassName VARCHAR(75) null,
	requestClassPK LONG,
	bulkRequest BOOLEAN,
	requestTime DATE null,
	responseTime DATE null,
	userId LONG,
	createDate DATE null
);

create table DGF_Address (
	addressId LONG not null primary key,
	region LONG,
	district LONG,
	upazilla LONG,
	cityCorporationOrMunicipality LONG,
	unionOrWard LONG,
	zipCode LONG,
	postOffice VARCHAR(75) null,
	villageOrRoad VARCHAR(75) null,
	mouzaOrMoholla VARCHAR(75) null,
	address VARCHAR(75) null,
	addressType VARCHAR(75) null,
	classPK LONG,
	className VARCHAR(75) null
);

create table DGF_AddressVersion (
	addressVersionId LONG not null primary key,
	region LONG,
	district LONG,
	upazilla LONG,
	cityCorporationOrMunicipality LONG,
	unionOrWard LONG,
	zipCode LONG,
	postOffice VARCHAR(75) null,
	villageOrRoad VARCHAR(75) null,
	mouzaOrMoholla VARCHAR(75) null,
	address VARCHAR(75) null,
	addressType VARCHAR(75) null,
	classPK LONG,
	className VARCHAR(75) null
);

create table DGF_Attachment (
	attachmentId LONG not null primary key,
	title VARCHAR(75) null,
	category VARCHAR(75) null,
	fileEntryId LONG,
	openTextId LONG,
	metadata TEXT null,
	classPK LONG,
	className VARCHAR(75) null
);

create table DGF_AttachmentVersion (
	attachmentVersionId LONG not null primary key,
	title VARCHAR(75) null,
	category VARCHAR(75) null,
	fileEntryId LONG,
	openTextId LONG,
	metadata TEXT null,
	classPK LONG,
	className VARCHAR(75) null
);

create table DGF_BankAccountInformation (
	uuid_ VARCHAR(75) null,
	bankAccountInformationId LONG not null primary key,
	createdBy LONG,
	createDate DATE null,
	accountNumber VARCHAR(75) null,
	bankName VARCHAR(75) null,
	branchName VARCHAR(75) null,
	routingCode VARCHAR(75) null,
	status INTEGER,
	version VARCHAR(75) null,
	classPK LONG,
	classNameId LONG
);

create table DGF_DeliveryOrder (
	uuid_ VARCHAR(75) null,
	deliveryOrderId LONG not null,
	indentId LONG not null,
	deliveryOrderNo VARCHAR(75) null,
	customerNo VARCHAR(75) null,
	name STRING null,
	doDate DATE null,
	commodity STRING null,
	commodityDescription STRING null,
	doQty STRING null,
	doQtyUnit STRING null,
	depo STRING null,
	warehouseNo VARCHAR(75) null,
	khamaalNo VARCHAR(75) null,
	lUANo VARCHAR(75) null,
	lUADate DATE null,
	bagUnit STRING null,
	vehicleNo VARCHAR(75) null,
	gateKeeper STRING null,
	goodsIssueDate VARCHAR(75) null,
	shipToParty VARCHAR(75) null,
	shipToPartyName STRING null,
	deliveredQty STRING null,
	deliveredQtyUnit STRING null,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	primary key (deliveryOrderId, indentId)
);

create table DGF_Grievance (
	uuid_ VARCHAR(75) null,
	grievanceId LONG not null primary key,
	grievanceNumber VARCHAR(75) null,
	companyId LONG,
	groupId LONG,
	grievanceCategory LONG,
	userType LONG,
	userName VARCHAR(75) null,
	userID LONG,
	mobileNumber VARCHAR(75) null,
	createDate DATE null,
	complaintDetails STRING null,
	attachmentId LONG,
	status INTEGER,
	responseDetails STRING null,
	responseDate DATE null,
	responseBy LONG
);

create table DGF_Indent (
	uuid_ VARCHAR(75) null,
	indentId LONG not null primary key,
	allocationId LONG,
	commodity VARCHAR(75) null,
	commodityDescription VARCHAR(75) null,
	quantity DOUBLE,
	quantityUnit VARCHAR(75) null,
	requiredDeliveryDate DATE null,
	foodGrainissueDate DATE null,
	netPrice DOUBLE,
	netPriceCurrencyKey VARCHAR(75) null,
	netValue DOUBLE,
	netValueCurrencyKey VARCHAR(75) null,
	salesOffice VARCHAR(75) null,
	depo VARCHAR(75) null,
	repaymentTerms VARCHAR(75) null,
	deliveryTerms VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	reason INTEGER
);

create table DGF_MDMSyncStatus (
	mdmSyncStatusId LONG not null primary key,
	userType VARCHAR(75) null,
	className VARCHAR(75) null,
	classPk LONG,
	requestPayload VARCHAR(75) null,
	mdmEndPoint VARCHAR(75) null,
	userId LONG,
	createDate DATE null
);

create table DGF_UserDetails (
	userDetailsId LONG not null primary key,
	nationalId VARCHAR(75) null,
	applicantName VARCHAR(75) null,
	fatherName VARCHAR(75) null,
	motherName VARCHAR(75) null,
	gender VARCHAR(75) null,
	nidPhotoAttachmentId LONG,
	nidDivision VARCHAR(75) null,
	nidDistrict VARCHAR(75) null,
	nidUpzilla VARCHAR(75) null,
	nidUnion VARCHAR(75) null,
	nidVillage VARCHAR(75) null,
	nidWard VARCHAR(75) null,
	nidZipCode LONG,
	houseAddress VARCHAR(75) null
);

create table DGF_UserLocation (
	uuid_ VARCHAR(75) null,
	userLocationId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	locationName VARCHAR(75) null,
	locationCode VARCHAR(75) null,
	locationId LONG,
	locationType VARCHAR(75) null,
	userName VARCHAR(75) null,
	userId LONG,
	roleKey VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	createdBy LONG,
	modifiedBy LONG
);

create table DGF_Users (
	dgfUserId LONG not null primary key,
	nationalId VARCHAR(75) null,
	password_ VARCHAR(75) null,
	mobileNumber VARCHAR(75) null,
	email VARCHAR(75) null,
	birthDate DATE null,
	maritalStatus VARCHAR(75) null,
	userId LONG,
	presentAddressId LONG,
	profileType VARCHAR(75) null
);