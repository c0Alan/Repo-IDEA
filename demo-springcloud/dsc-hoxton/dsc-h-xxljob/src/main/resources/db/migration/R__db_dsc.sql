drop TABLE if EXISTS t_user;
-- drop TABLE t_user;
CREATE TABLE `t_user` (
`id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
`dept_id` INT(11) DEFAULT NULL COMMENT '部门id',
`username` VARCHAR(255) DEFAULT NULL COMMENT '用户名',
`age` int DEFAULT 0 COMMENT '年龄',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '用户表';

INSERT INTO t_user(username) VALUES('张三');
INSERT INTO t_user(username) VALUES('李四');
INSERT INTO t_user(username) VALUES('王五');

drop TABLE if EXISTS t_dept;
-- drop TABLE t_user;
CREATE TABLE `t_dept` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `deptname` VARCHAR(255) DEFAULT NULL COMMENT '部门名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '部门表';
INSERT INTO t_dept(id,deptname) VALUES(1,'开发部');
INSERT INTO t_dept(id,deptname) VALUES(2,'销售部');
INSERT INTO t_dept(id,deptname) VALUES(3,'管理部');