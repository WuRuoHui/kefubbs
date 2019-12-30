create table bbs_user
(
    id int auto_increment,
    username varchar(50) null,
    password varchar(50) null,
    gmt_create bigint null,
    gmt_modified bigint null,
    avatar_url varchar(100) null,
    constraint bbs_user_pk
        primary key (id)
);