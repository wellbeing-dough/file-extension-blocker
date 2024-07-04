DROP TABLE IF EXISTS custom_file_extension;
DROP TABLE IF EXISTS file_extension;
DROP TABLE IF EXISTS member;

create table custom_file_extension
(
    ID                               bigint auto_increment
        primary key,
    MEMBER_ID                        bigint    not null,
    EXTENSION_NAME                   varchar(50) not null,
    DESCRIPTION                           text not null,
    CREATED_DATE                     timestamp not null,
    UPDATED_DATE                     timestamp not null,
    DELETED_AT                       timestamp null
);

create table file_extension
(
    ID                               bigint auto_increment
        primary key,
    EXTENSION_NAME                   varchar(50) not null,
    DESCRIPTION                           text not null,
    DANGER_REASON                    text null,
    ADD_COUNT                        int null,
    SAFETY_STATUS                    varchar(20) null,
    CREATED_DATE                     timestamp not null,
    UPDATED_DATE                     timestamp not null,
    DELETED_AT                       timestamp null
);

create table member
(
    ID                               bigint auto_increment
        primary key,
    NAME                             varchar(50) not null,
    CREATED_DATE                     timestamp not null,
    UPDATED_DATE                     timestamp not null,
    DELETED_AT                       timestamp null
);
