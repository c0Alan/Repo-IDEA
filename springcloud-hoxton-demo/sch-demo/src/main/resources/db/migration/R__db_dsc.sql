drop TABLE if EXISTS t_user;
-- drop TABLE t_user;
CREATE TABLE `t_user` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `username` VARCHAR(255) DEFAULT NULL COMMENT '用户名',
  `age` int DEFAULT 0 COMMENT '年龄',
  PRIMARY KEY (`id`)
) ;

INSERT INTO t_user(username) VALUES('张三');
INSERT INTO t_user(username) VALUES('李四');
INSERT INTO t_user(username) VALUES('王五');
INSERT INTO t_user(username) VALUES('唐六');