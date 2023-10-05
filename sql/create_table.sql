create table member
(
    id     bigint auto_increment comment 'id'
        primary key,
    name   varchar(64) null comment '用户名',
    pwd    char(32)    null comment '密码',
    mobile varchar(20) null comment '手机号',
    email  varchar(64) null comment '邮箱',
    gender tinyint     null comment '性别'
);