drop TABLE if EXISTS t_user;
-- drop TABLE t_user;
CREATE TABLE `t_user` (
`id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
`username` VARCHAR(255) DEFAULT NULL COMMENT '用户名',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO t_user(username) VALUES('张三');
INSERT INTO t_user(username) VALUES('李四');
