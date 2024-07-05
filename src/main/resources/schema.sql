DROP TABLE IF EXISTS file_extension;
DROP TABLE IF EXISTS custom_block_file_extension;

create table file_extension
(
    ID                               bigint auto_increment
        primary key,
    EXTENSION_NAME                   varchar(50) not null,
    DESCRIPTION                      text not null,
    EXTENSION_STATUS                 varchar(20) null,
    BLOCKED_COUNT                    bigint    not null,
    CREATED_DATE                     timestamp not null,
    UPDATED_DATE                     timestamp not null,
    DELETED_AT                       timestamp null
);

create table custom_block_file_extension
(
    ID                               bigint auto_increment
        primary key,
    FILE_EXTENSION_ID                bigint    not null,
    CREATED_DATE                     timestamp not null,
    UPDATED_DATE                     timestamp not null,
    DELETED_AT                       timestamp null
)