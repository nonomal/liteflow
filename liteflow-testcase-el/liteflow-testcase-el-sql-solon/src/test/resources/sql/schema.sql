create table IF NOT EXISTS `EL_TABLE`
(
    `id`         bigint        NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    `application_name` varchar(32) NOT NULL,
    `chain_name` varchar(32)   NOT NULL,
    `el_data`    varchar(1024) NOT NULL,
    `route`     varchar(1024),
    `namespace` varchar(32),
    PRIMARY KEY (`id`)
);

create table IF NOT EXISTS `script_node_table`
(
    `id`                   bigint        NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    `application_name`     varchar(32)   NOT NULL,
    `script_node_id`       varchar(32)   NOT NULL,
    `script_node_name`     varchar(32)   NOT NULL,
    `script_node_type`     varchar(32)   NOT NULL,
    `script_node_data`     varchar(1024) NOT NULL,
    `script_language`     varchar(1024) NOT NULL,
    PRIMARY KEY (`id`)
);