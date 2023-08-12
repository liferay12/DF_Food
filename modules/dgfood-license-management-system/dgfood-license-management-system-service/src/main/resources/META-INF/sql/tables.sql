create table fgl_master_details (
	uuid_ VARCHAR(75) null,
	fgLicenseMasterId LONG not null primary key,
	nationalId VARCHAR(75) null,
	applicationNumber VARCHAR(75) null,
	applicantName VARCHAR(75) null,
	tradeLicenseNumber VARCHAR(75) null,
	tradeLicenseExpiryDate DATE null,
	tradeLicenseIssuerCode VARCHAR(75) null,
	tradeLicenseIssuerCity VARCHAR(75) null,
	businessIdentificationNumber VARCHAR(75) null,
	taxIdentificationNumber VARCHAR(75) null,
	paymentChallanId LONG,
	tradeLicenseDocId LONG,
	businessIdentificationDocId LONG,
	taxIdentfctDocId LONG,
	bankStatementDocId LONG,
	reviewComments VARCHAR(75) null,
	comments VARCHAR(75) null,
	duplicateLicenseReasonId VARCHAR(75) null,
	applicationType VARCHAR(75) null
);

create table fgl_master_info (
	uuid_ VARCHAR(75) null,
	fgLicenseInfoId LONG not null primary key,
	fgLicenseMasterId LONG,
	fgLicenseMDMId LONG,
	nationalId VARCHAR(75) null,
	applicationNumber VARCHAR(75) null,
	applicantName VARCHAR(75) null,
	tradeLicenseNumber VARCHAR(75) null,
	foodgrainLicenseNumber VARCHAR(75) null,
	foodgrainLicenseIssueDate DATE null,
	foodgrainLicenseExpiryDate DATE null,
	businessName VARCHAR(75) null,
	businessType VARCHAR(75) null,
	businessAddressId LONG,
	version DOUBLE,
	applicationType VARCHAR(75) null,
	syncStatus BOOLEAN,
	isExpired BOOLEAN,
	paymentChallanId LONG,
	division VARCHAR(75) null,
	district VARCHAR(75) null,
	upazila VARCHAR(75) null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	modifiedBy LONG
);

create table fgl_mdm_data (
	uuid_ VARCHAR(75) null,
	fgLicenseMDMId LONG not null primary key,
	fgLicenseInfoId LONG,
	fgLicenseMasterId LONG,
	applicationMdmData VARCHAR(75) null
);