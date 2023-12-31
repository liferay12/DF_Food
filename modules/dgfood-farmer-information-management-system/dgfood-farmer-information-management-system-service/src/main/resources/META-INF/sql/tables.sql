create table DGFood_FarmerRegistration (
	uuid_ VARCHAR(75) null,
	farmerRegistrationId LONG not null primary key,
	applicationNumber VARCHAR(75) null,
	nationalId VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	mobileNumber VARCHAR(75) null,
	dateOfBirth DATE null,
	farmerName VARCHAR(75) null,
	fatherName VARCHAR(75) null,
	motherName VARCHAR(75) null,
	gender INTEGER,
	maritalStatus INTEGER,
	krishokCardNumber VARCHAR(75) null,
	cultivableLandSeason1 TEXT null,
	cultivableLandSeason2 TEXT null,
	cultivableLandSeason3 TEXT null,
	farmerCategory  VARCHAR(75) null,
	password  VARCHAR(75) null,
	remarks VARCHAR(75) null,
	businessCode VARCHAR(75) null,
	version DOUBLE,
	userId LONG,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	createdBy LONG,
	modifiedBy LONG,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);

create table DGFood_FarmerRegistrationVer (
	uuid_ VARCHAR(75) null,
	farmerRegistrationVersionId LONG not null primary key,
	applicationNumber VARCHAR(75) null,
	farmerRegistrationId LONG,
	nationalId VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	mobileNumber VARCHAR(75) null,
	dateOfBirth DATE null,
	farmerName VARCHAR(75) null,
	fatherName VARCHAR(75) null,
	motherName VARCHAR(75) null,
	gender INTEGER,
	maritalStatus INTEGER,
	krishokCardNumber VARCHAR(75) null,
	cultivableLandSeason1 TEXT null,
	cultivableLandSeason2 TEXT null,
	cultivableLandSeason3 TEXT null,
	farmerCategory  VARCHAR(75) null,
	password  VARCHAR(75) null,
	remarks VARCHAR(75) null,
	businessCode VARCHAR(75) null,
	version DOUBLE,
	userId VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	createdBy LONG,
	modifiedBy LONG,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);

create table DGFood_SalesProposal (
	uuid_ VARCHAR(75) null,
	farmerSalesProposalId LONG not null primary key,
	applicationNumber VARCHAR(75) null,
	farmerRegistrationId LONG,
	businessCode VARCHAR(75) null,
	currentSeason VARCHAR(75) null,
	foodGrainType VARCHAR(75) null,
	krishiCardNumber VARCHAR(75) null,
	pastProdDataSeason1 TEXT null,
	pastProdDataSeason2 TEXT null,
	pastProdDataSeason3 TEXT null,
	succeedingProdDataSeason1 TEXT null,
	succeedingProdDataSeason2 TEXT null,
	succeedingProdDataSeason3 TEXT null,
	grainProcuredInLast4Seasons  BOOLEAN,
	foodgranProcuredSeason1 TEXT null,
	foodgranProcuredSeason2 TEXT null,
	foodgranProcuredSeason3 TEXT null,
	foodgranProcuredSeason4 TEXT null,
	cultivableLandSeason1 TEXT null,
	cultivableLandSeason2 TEXT null,
	cultivableLandSeason3 TEXT null,
	foodgrainReceivedStatus INTEGER,
	receivedFoodgrainQty TEXT null,
	foodgrainReceivedDate DATE null,
	paymentStatus INTEGER,
	remarks VARCHAR(75) null,
	version DOUBLE,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	createdBy LONG,
	modifiedBy LONG,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);