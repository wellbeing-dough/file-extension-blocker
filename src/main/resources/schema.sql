DROP TABLE IF EXISTS danger_extensions;
DROP TABLE IF EXISTS safe_extensions;
DROP TABLE IF EXISTS extensions;
DROP TABLE IF EXISTS users;

create table extensions
(
    ID                               bigint auto_increment
        primary key,
    EXTENSION_NAME                   varchar(20) not null,
    REASON                           text not null,
    DELETED_AT                       timestamp null
);

create table safe_extensions
(
    ID                               bigint auto_increment
        primary key,
    EXTENSION_NAME                   varchar(20) not null,
    REASON                           text not null,
    ADD_COUNT                        int null,
    DELETED_AT                       timestamp null
);

create table danger_extensions
(
    ID                               bigint auto_increment
        primary key,
    EXTENSION_NAME                   varchar(20) not null,
    REASON                           text not null,
    DANGER_REASON                    text not null,
    ADD_COUNT                        int null,
    DELETED_AT                       timestamp null
);
