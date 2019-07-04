-- Drop TABLE if exists USER;
create table if not exists User (
USERID varchar(150) not null primary key,
USERNAME varchar(100),
USERSEX varchar(32),
USERAGE NUMBER(3),
USERNO VARCHAR(18),
USERPHONENUM VARCHAR(11),
CREATETIME DATE,
MODIFYTIME DATE,
USERSTATE VARCHAR(32));