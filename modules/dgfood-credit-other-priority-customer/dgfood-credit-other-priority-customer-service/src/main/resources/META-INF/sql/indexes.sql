create index IX_50F46F8C on DGFOOD_SalesCustomer (userId);
create index IX_C421AC6 on DGFOOD_SalesCustomer (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_AFE9AC8 on DGFOOD_SalesCustomer (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_90AF08C6 on DGFOOD_SalesCustomerAllocation (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_8C392E5 on DGFOOD_SalesCustomerVersion (salesCustomerId, version);
create index IX_B14818E6 on DGFOOD_SalesCustomerVersion (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_1FADA0E8 on DGFOOD_SalesCustomerVersion (uuid_[$COLUMN_LENGTH:75$], groupId);