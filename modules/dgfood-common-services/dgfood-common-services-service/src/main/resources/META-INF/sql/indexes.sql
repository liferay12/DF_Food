create index IX_F4F8B6F0 on DGF_Address (classPK, className[$COLUMN_LENGTH:75$], addressType[$COLUMN_LENGTH:75$]);

create index IX_9A532216 on DGF_AddressVersion (classPK, className[$COLUMN_LENGTH:75$]);

create index IX_406DB9B5 on DGF_Attachment (classPK, className[$COLUMN_LENGTH:75$]);

create index IX_CCC8984F on DGF_AttachmentVersion (classPK, className[$COLUMN_LENGTH:75$]);

create index IX_DBEB4137 on DGF_BankAccountInformation (uuid_[$COLUMN_LENGTH:75$]);

create index IX_B7E699B8 on DGF_DeliveryOrder (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_75474DDC on DGF_Grievance (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_D8C19B5E on DGF_Grievance (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_6E3E06FD on DGF_Indent (allocationId);
create index IX_5F5710A2 on DGF_Indent (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_2F4F57A4 on DGF_Indent (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_954C02E2 on DGF_UserDetails (nationalId[$COLUMN_LENGTH:75$]);

create index IX_2CFDCB46 on DGF_UserLocation (locationId);
create index IX_C5B0958D on DGF_UserLocation (roleKey[$COLUMN_LENGTH:75$], locationCode[$COLUMN_LENGTH:75$]);
create index IX_9B5CB127 on DGF_UserLocation (userId, locationCode[$COLUMN_LENGTH:75$], roleKey[$COLUMN_LENGTH:75$]);
create index IX_AAA75596 on DGF_UserLocation (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_98144998 on DGF_UserLocation (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_D17CAE33 on DGF_Users (nationalId[$COLUMN_LENGTH:75$]);