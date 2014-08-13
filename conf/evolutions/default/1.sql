# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table accessory (
  id                        bigint not null,
  tent_id                   bigint not null,
  item_id                   bigint,
  amount                    decimal(6,2),
  constraint pk_accessory primary key (id))
;

create table event_entry (
  id                        bigint not null,
  event_id                  varchar(255),
  event_type                integer,
  item_id                   bigint,
  amount                    decimal(6,2),
  constraint ck_event_entry_event_type check (event_type in (0,1,2,3)),
  constraint pk_event_entry primary key (id))
;

create table item (
  ITEM_TYPE                 varchar(31) not null,
  id                        bigint not null,
  name                      varchar(255),
  category                  integer,
  amount                    decimal(6,2),
  weight                    decimal(6,2),
  constraint ck_item_category check (category in (0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)),
  constraint pk_item primary key (id))
;

create sequence accessory_seq;

create sequence event_entry_seq;

create sequence item_seq;

alter table accessory add constraint fk_accessory_item_1 foreign key (tent_id) references item (id) on delete restrict on update restrict;
create index ix_accessory_item_1 on accessory (tent_id);
alter table accessory add constraint fk_accessory_item_2 foreign key (item_id) references item (id) on delete restrict on update restrict;
create index ix_accessory_item_2 on accessory (item_id);
alter table event_entry add constraint fk_event_entry_item_3 foreign key (item_id) references item (id) on delete restrict on update restrict;
create index ix_event_entry_item_3 on event_entry (item_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists accessory;

drop table if exists event_entry;

drop table if exists item;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists accessory_seq;

drop sequence if exists event_entry_seq;

drop sequence if exists item_seq;

