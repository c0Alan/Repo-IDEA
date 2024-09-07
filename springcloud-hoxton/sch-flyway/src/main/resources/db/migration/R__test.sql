DROP TABLE IF EXISTS test_user;
CREATE TABLE test_user (
    id int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
    username varchar(32) DEFAULT NULL COMMENT '用户名',
    password varchar(64) DEFAULT NULL COMMENT '密码',
    telephone varchar(11) DEFAULT NULL COMMENT '手机号',
    enabled int(11) DEFAULT '1' COMMENT '默认1  1有效 0 无效',
    age tinyint(3) unsigned DEFAULT NULL COMMENT '年龄',
    PRIMARY KEY (id) USING BTREE
) COMMENT='测试-用户信息表';

INSERT INTO test_user (id, username, password, telephone, enabled, age) VALUES ('1', '张三', '$2a$10$rCNJoo6tg1Jb278KJJREk.XIAEHoArojMVGOW3ehjtW3Rb7ayhAZu', '12345678998', '1', NULL);
INSERT INTO test_user (id, username, password, telephone, enabled, age) VALUES ('2', '李四', '$2a$10$dIEID4LCcsWS2lXJLO2VCO.yTow70YIuPfM9sy9c8HtEArEokgpTm', '12345678999', '1', NULL);
INSERT INTO test_user (id, username, password, telephone, enabled, age) VALUES ('3', '王五', '$2a$10$dIEID4LCcsWS2lXJLO2VCO.yTow70YIuPfM9sy9c8HtEArEokgpTm', '12345678999', '1', NULL);


DROP TABLE IF EXISTS test_storage;
CREATE TABLE test_storage (
     id int(11) NOT NULL AUTO_INCREMENT,
     commodity_code varchar(255) DEFAULT NULL,
     count int(11) DEFAULT 0,
     PRIMARY KEY (id),
     UNIQUE KEY (commodity_code)
) COMMENT ='仓库表';


DROP TABLE IF EXISTS test_order;
CREATE TABLE test_order (
   id int(11) NOT NULL AUTO_INCREMENT,
   user_id varchar(255) DEFAULT NULL,
   commodity_code varchar(255) DEFAULT NULL,
   count int(11) DEFAULT 0,
   money int(11) DEFAULT 0,
   PRIMARY KEY (id)
) COMMENT ='订单表';


DROP TABLE IF EXISTS test_account;
CREATE TABLE test_account (
     id int(11) NOT NULL AUTO_INCREMENT,
     user_id varchar(255) DEFAULT NULL,
     username  varchar(32) NULL DEFAULT NULL COMMENT '用户名',
     money int(11) DEFAULT 0,
     PRIMARY KEY (id)
) COMMENT ='账户表';