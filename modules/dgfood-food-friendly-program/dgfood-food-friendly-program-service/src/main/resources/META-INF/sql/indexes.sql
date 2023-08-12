create index IX_58BF7346 on FFPB_Registration (beneficiaryId, dateOfBirth);
create index IX_7BCD77B1 on FFPB_Registration (cardNumber[$COLUMN_LENGTH:75$], dateOfBirth);
create index IX_B173E32D on FFPB_Registration (nationalId);
create index IX_56913680 on FFPB_Registration (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_B7F55D02 on FFPB_Registration (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_1FF1B870 on FFPB_RegistrationVersion (beneficiaryId, version);
create index IX_A878ADE on FFPB_RegistrationVersion (status);