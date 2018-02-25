$ su - postgres

postgres=# CREATE DATABASE sd OWNER postgres;
postgres=# create schema springdemo;

create table t_sys_permission(
	n_id numeric(6) PRIMARY KEY,
	n_valid numeric(2), 
	c_name varchar(300),
	n_parent_id numeric(6),
	c_parent_ids varchar(300),
	c_permission varchar(300),
	c_resource_type varchar(300),
	c_url varchar(300)
);

INSERT INTO t_sys_permission (n_id,n_valid,c_name,n_parent_id,c_parent_ids,c_permission,c_resource_type,c_url) VALUES (1,0,'用户管理',0,'0/','userInfo:view','menu','userInfo/userList');

INSERT INTO t_sys_permission (n_id,n_valid,c_name,n_parent_id,c_parent_ids,c_permission,c_resource_type,c_url) VALUES (2,0,'用户添加',1,'0/1','userInfo:add','button','userInfo/userAdd');

INSERT INTO t_sys_permission (n_id,n_valid,c_name,n_parent_id,c_parent_ids,c_permission,c_resource_type,c_url) VALUES (3,0,'用户删除',1,'0/1','userInfo:del','button','userInfo/userDel');

create table t_user(
	n_id numeric(6) PRIMARY KEY,
	c_name varchar(300),
	n_sex numeric(2), 
	n_age numeric(3), 
	c_address varchar(300),
	c_loginid varchar(300),
	c_password varchar(300),
	c_salt varchar(300),
	n_state numeric(2)
);

INSERT INTO t_user (n_id,c_loginid,c_name,c_password,c_salt,n_state) VALUES ('1', 'admin', '管理员', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', 0);

create table t_sys_user_role(
	n_role_id numeric(6),
	n_user_id numeric(6)
);

INSERT INTO t_sys_user_role (n_role_id,n_user_id) VALUES (1,1);

create table t_sys_role_permission(
	n_permission_id numeric(6),
	n_role_id numeric(6)
);

INSERT INTO t_sys_role_permission (n_permission_id,n_role_id) VALUES (1,1);
INSERT INTO t_sys_role_permission (n_permission_id,n_role_id) VALUES (2,1);
INSERT INTO t_sys_role_permission (n_permission_id,n_role_id) VALUES (3,2);

create table t_sys_role(
	n_id numeric(6) PRIMARY KEY,
	n_valid numeric(2), 
	c_description varchar(300),
	c_role varchar(300)
);

INSERT INTO t_sys_role (n_id,n_valid,c_description,c_role) VALUES (1,0,'管理员','admin');
INSERT INTO t_sys_role (n_id,n_valid,c_description,c_role) VALUES (2,0,'VIP会员','vip');
INSERT INTO t_sys_role (n_id,n_valid,c_description,c_role) VALUES (3,1,'test','test');





