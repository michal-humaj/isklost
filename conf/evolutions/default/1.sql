# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table accessory (
  id                        bigint not null,
  tent_id                   bigint not null,
  item_id                   bigint,
  amount                    integer,
  constraint pk_accessory primary key (id))
;

create table stored_item (
  id                        bigint not null,
  name                      varchar(255),
  category                  integer,
  amount                    decimal(6,2),
  weight                    decimal(6,2),
  constraint ck_stored_item_category check (category in (0,1,2,3,4,5,6,7,8,9,10,11,12,13,14)),
  constraint pk_stored_item primary key (id))
;

create table tent (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_tent primary key (id))
;

create sequence accessory_seq;

create sequence stored_item_seq;

create sequence tent_seq;

alter table accessory add constraint fk_accessory_tent_1 foreign key (tent_id) references tent (id) on delete restrict on update restrict;
create index ix_accessory_tent_1 on accessory (tent_id);
alter table accessory add constraint fk_accessory_item_2 foreign key (item_id) references stored_item (id) on delete restrict on update restrict;
create index ix_accessory_item_2 on accessory (item_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists accessory;

drop table if exists stored_item;

drop table if exists tent;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists accessory_seq;

drop sequence if exists stored_item_seq;

drop sequence if exists tent_seq;

