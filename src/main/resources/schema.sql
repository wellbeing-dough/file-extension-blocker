DROP TABLE IF EXISTS danger_extension;
DROP TABLE IF EXISTS safe_extension;
DROP TABLE IF EXISTS extension;
DROP TABLE IF EXISTS member;

create table custom_extension
(
    ID                               bigint auto_increment
        primary key,
    EXTENSION_NAME                   varchar(20) not null,
    DESCRIPTION                           text not null,
    DELETED_AT                       timestamp null
);

create table safe_extension
(
    ID                               bigint auto_increment
        primary key,
    EXTENSION_NAME                   varchar(20) not null,
    DESCRIPTION                           text not null,
    ADD_COUNT                        int null,
    CREATED_DATE                     timestamp not null,
    UPDATED_DATE                     timestamp not null,
    DELETED_AT                       timestamp null
);

create table danger_extension
(
    ID                               bigint auto_increment
        primary key,
    EXTENSION_NAME                   varchar(20) not null,
    DESCRIPTION                           text not null,
    DANGER_REASON                    text not null,
    ADD_COUNT                        int null,
    CREATED_DATE                     timestamp not null,
    UPDATED_DATE                     timestamp not null,
    DELETED_AT                       timestamp null
);

create table member
(
    ID                               bigint auto_increment
        primary key,
    NAME                             varchar(20) not null,
    CUSTOM_EXTENSION_ID              bigint    not null,
    CREATED_DATE                     timestamp not null,
    UPDATED_DATE                     timestamp not null,
    DELETED_AT                       timestamp null
);
