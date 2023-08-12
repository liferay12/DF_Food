create index IX_64599AF5 on fgl_master_details (uuid_[$COLUMN_LENGTH:75$]);

create index IX_56D21CAD on fgl_master_info (applicationNumber[$COLUMN_LENGTH:75$], nationalId[$COLUMN_LENGTH:75$]);
create index IX_8E64143E on fgl_master_info (foodgrainLicenseNumber[$COLUMN_LENGTH:75$]);
create index IX_B3491704 on fgl_master_info (nationalId[$COLUMN_LENGTH:75$], status);
create index IX_E5D970B1 on fgl_master_info (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_2BB86F73 on fgl_master_info (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_51A20487 on fgl_mdm_data (uuid_[$COLUMN_LENGTH:75$]);