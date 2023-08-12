create unique index IX_8CF8AD89 on DGFood_FarmerRegistration (applicationNumber[$COLUMN_LENGTH:75$]);
create unique index IX_658E3321 on DGFood_FarmerRegistration (businessCode[$COLUMN_LENGTH:75$]);
create unique index IX_94CE4CBC on DGFood_FarmerRegistration (krishokCardNumber[$COLUMN_LENGTH:75$]);
create unique index IX_71700441 on DGFood_FarmerRegistration (nationalId[$COLUMN_LENGTH:75$]);
create index IX_9D85D6DA on DGFood_FarmerRegistration (userId);
create index IX_F92D3894 on DGFood_FarmerRegistration (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_EC12D416 on DGFood_FarmerRegistration (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_B7B6265A on DGFood_FarmerRegistrationVer (applicationNumber[$COLUMN_LENGTH:75$]);
create index IX_8B6ABBB0 on DGFood_FarmerRegistrationVer (businessCode[$COLUMN_LENGTH:75$]);
create unique index IX_9D6A6AEE on DGFood_FarmerRegistrationVer (farmerRegistrationId, version);
create index IX_16A36490 on DGFood_FarmerRegistrationVer (nationalId[$COLUMN_LENGTH:75$]);
create index IX_5564E1A3 on DGFood_FarmerRegistrationVer (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_CEF74E5 on DGFood_FarmerRegistrationVer (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_F5C7AAE3 on DGFood_SalesProposal (applicationNumber[$COLUMN_LENGTH:75$]);
create index IX_A498C587 on DGFood_SalesProposal (businessCode[$COLUMN_LENGTH:75$]);
create index IX_B23C27FA on DGFood_SalesProposal (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_92C264FC on DGFood_SalesProposal (uuid_[$COLUMN_LENGTH:75$], groupId);