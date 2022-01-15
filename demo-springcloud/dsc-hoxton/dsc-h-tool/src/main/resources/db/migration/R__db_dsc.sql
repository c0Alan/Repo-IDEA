drop TABLE if EXISTS t_user;
-- drop TABLE t_user;
CREATE TABLE `t_user` (
`id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
`dept_id` INT(11) DEFAULT NULL COMMENT '部门id',
`deptname` VARCHAR(255) DEFAULT NULL COMMENT '部门名称',
`username` VARCHAR(255) DEFAULT NULL COMMENT '用户名',
`age` int DEFAULT 0 COMMENT '年龄',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '用户表';

INSERT INTO t_user(username) VALUES('张三');
INSERT INTO t_user(username) VALUES('李四');
INSERT INTO t_user(username) VALUES('王五');

drop TABLE if EXISTS t_dept;
CREATE TABLE `t_dept` (
`id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
`deptname` VARCHAR(255) DEFAULT NULL COMMENT '部门名称',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '部门表';
INSERT INTO t_dept(id,deptname) VALUES(1,'开发部');
INSERT INTO t_dept(id,deptname) VALUES(2,'销售部');
INSERT INTO t_dept(id,deptname) VALUES(3,'管理部');

drop TABLE if EXISTS t_address;
CREATE TABLE `t_address` (
`id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
`province` VARCHAR(255) DEFAULT NULL COMMENT '省',
`city` VARCHAR(255) DEFAULT NULL COMMENT '市',
`district` VARCHAR(255) DEFAULT NULL COMMENT '区',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '地址表';

drop TABLE if EXISTS t_dict;
CREATE TABLE `t_dict` (
 `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id，1000以下为系统内置字典，1000以上为外部添加字典',
 `data_type` tinyint unsigned DEFAULT NULL COMMENT '数据类型, 0:字典类型, 1:字典数据',
 `dict_type_code` VARCHAR(255) DEFAULT NULL COMMENT '字典类型编码',
 `dict_type_name` VARCHAR(255) DEFAULT NULL COMMENT '字典类型名称',
 `dict_data_code` VARCHAR(255) DEFAULT NULL COMMENT '字典数据编码',
 `dict_data_name` VARCHAR(255) DEFAULT NULL COMMENT '字典数据名称',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '字典表';
alter table t_dict auto_increment=1000;
