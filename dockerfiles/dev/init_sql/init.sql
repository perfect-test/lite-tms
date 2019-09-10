CREATE DATABASE lite_tms;

CREATE USER 'tms'@'%'
  IDENTIFIED BY 'secret';
GRANT ALL ON `lite_tms`.* TO 'tms'@'%';
FLUSH PRIVILEGES;

CREATE USER 'tms'@'localhost'
  IDENTIFIED BY 'secret';
GRANT ALL ON `lite_tms`.* TO 'tms'@'localhost';
FLUSH PRIVILEGES;

USE lite_tms;

CREATE TABLE `projects` (
  `id`                INT(10) UNSIGNED NOT NULL              AUTO_INCREMENT,
  `create_time`       TIMESTAMP        NULL                  DEFAULT NULL,
  `update_time`       TIMESTAMP        NULL                  DEFAULT NULL,
  `user_id`           INT(10)                                DEFAULT NULL,
  `name`              VARCHAR(255)                           DEFAULT NULL,
  `short_description` VARCHAR(255)                           DEFAULT NULL,
  `description`       VARCHAR(2000)                          DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE `users` (
  `id`                 INT(10) UNSIGNED NOT NULL              AUTO_INCREMENT,
  `user_name`          VARCHAR(255)                           DEFAULT NULL,
  `available_projects` VARCHAR(255)                           DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE `suites` (
  `id`                INT(10) UNSIGNED NOT NULL              AUTO_INCREMENT,
  `create_time`       TIMESTAMP        NULL                  DEFAULT NULL,
  `update_time`       TIMESTAMP        NULL                  DEFAULT NULL,
  `create_user_id`    INT(10)                                DEFAULT NULL,
  `update_user_id`    INT(10)                                DEFAULT NULL,
  `name`              VARCHAR(255)                           DEFAULT NULL,
  `short_description` VARCHAR(255)                           DEFAULT NULL,
  `description`       VARCHAR(2000)                          DEFAULT NULL,
  `project_id`        INT(10)                                DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE `cases` (
  `id`             INT(10) UNSIGNED NOT NULL              AUTO_INCREMENT,
  `create_time`    TIMESTAMP        NULL                  DEFAULT NULL,
  `update_time`    TIMESTAMP        NULL                  DEFAULT NULL,
  `create_user_id` INT(10)                                DEFAULT NULL,
  `update_user_id` INT(10)                                DEFAULT NULL,
  `name`           VARCHAR(255)                           DEFAULT NULL,
  `preconditions`  VARCHAR(2000)                          DEFAULT NULL,
  `description`    VARCHAR(2000)                          DEFAULT NULL,
  `steps`          VARCHAR(2000)                          DEFAULT NULL,
  `references`     VARCHAR(2000)                          DEFAULT NULL,
  `priority`       VARCHAR(255)                           DEFAULT NULL,
  `type`           VARCHAR(255)                           DEFAULT NULL,
  `suite_id`       INT(10)                                DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
