create table DGFOOD_MovementContractor (
	uuid_ VARCHAR(75) null,
	movementContractorId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	name VARCHAR(75) null,
	mobileNumber VARCHAR(75) null,
	nationalId LONG,
	emailAddress VARCHAR(75) null,
	dateOfBirth DATE null,
	gender INTEGER,
	fatherName VARCHAR(75) null,
	motherName VARCHAR(75) null,
	maritalStatus INTEGER,
	type_ VARCHAR(75) null,
	organizationName VARCHAR(75) null,
	tradeLicenseNumber VARCHAR(75) null,
	tradeLicenseExpiryDate DATE null,
	vehicle VARCHAR(75) null,
	vehicleCount INTEGER,
	vehicleCapacity TEXT null,
	userId LONG,
	password_ VARCHAR(75) null,
	applicationNumber LONG,
	businessCode LONG,
	version DOUBLE,
	status INTEGER,
	statusByUserId LONG,
	statusDate DATE null,
	createdBy LONG,
	createDate DATE null,
	modifiedBy LONG,
	modifiedDate DATE null
);

create table DGFOOD_SubProgram (
	subProgramId LONG not null primary key,
	deliveryNo VARCHAR(75) null,
	memoNo VARCHAR(75) null,
	sendingDepot VARCHAR(75) null,
	sendingPlantDesc VARCHAR(75) null,
	receivingDepot VARCHAR(75) null,
	receivingPlantDesc VARCHAR(75) null,
	product VARCHAR(75) null,
	quantity TEXT null,
	deliveryDate DATE null,
	requestedDate DATE null,
	forwardingAgent VARCHAR(75) null,
	vehicleSendDate DATE null,
	status INTEGER,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table DGFOOD_VInvoice (
	vInvoiceId LONG not null primary key,
	vInvoiceNo VARCHAR(75) null,
	deliveryNo VARCHAR(75) null,
	sendingPlant VARCHAR(75) null,
	sendingPlantDesc VARCHAR(75) null,
	receivingPlant VARCHAR(75) null,
	receivingPlantDesc VARCHAR(75) null,
	userName VARCHAR(75) null,
	departureDate DATE null,
	materialNo VARCHAR(75) null,
	materialDescription VARCHAR(75) null,
	quantity TEXT null,
	bagQuantity DOUBLE,
	grossWeight DOUBLE,
	netWeight DOUBLE,
	storageLocation VARCHAR(75) null,
	storageBin VARCHAR(75) null,
	carrier VARCHAR(75) null,
	transportationMode VARCHAR(75) null,
	meansOfTransport VARCHAR(75) null,
	createDate DATE null
);