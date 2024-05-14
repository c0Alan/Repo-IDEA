/********************* 用户信息表,oauth2权限用户也是用的这张表 *********************/
DROP TABLE IF EXISTS account;
CREATE TABLE account
(
    id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
    username  varchar(32) NULL DEFAULT NULL COMMENT '用户名',
    money   DOUBLE NULL DEFAULT NULL COMMENT '余额',
    PRIMARY KEY (id) USING BTREE
) COMMENT='账户表';

