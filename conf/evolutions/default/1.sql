# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table accessory (
  id                        bigint auto_increment not null,
  tent_id                   bigint not null,
  item_id                   bigint,
  amount                    integer,
  constraint pk_accessory primary key (id))
;

create table stored_item (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  category                  integer,
  amount                    decimal(6,2),
  weight                    decimal(6,2),
  constraint ck_stored_item_category check (category in (0,1,2,3,4,5,6,7,8,9,10,11,12,13,14)),
  constraint pk_stored_item primary key (id))
;

create table tent (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  constraint pk_tent primary key (id))
;

alter table accessory add constraint fk_accessory_tent_1 foreign key (tent_id) references tent (id) on delete restrict on update restrict;
create index ix_accessory_tent_1 on accessory (tent_id);
alter table accessory add constraint fk_accessory_item_2 foreign key (item_id) references stored_item (id) on delete restrict on update restrict;
create index ix_accessory_item_2 on accessory (item_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table accessory;

drop table stored_item;

drop table tent;

SET FOREIGN_KEY_CHECKS=1;

