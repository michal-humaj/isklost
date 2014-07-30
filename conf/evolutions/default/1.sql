# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table stored_item (
  id                        bigint not null,
  name                      varchar(255),
  category                  integer,
  amount                    integer,
  weight                    integer,
  constraint ck_stored_item_category check (category in (0,1,2,3,4,5,6,7,8,9,10,11,12,13,14)),
  constraint pk_stored_item primary key (id))
;

create sequence stored_item_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists stored_item;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists stored_item_seq;

