
DROP TABLE IF EXISTS t_storage;
CREATE TABLE t_storage (
     id int(11) NOT NULL AUTO_INCREMENT,
     commodity_code varchar(255) DEFAULT NULL,
     count int(11) DEFAULT 0,
     PRIMARY KEY (id),
     UNIQUE KEY (commodity_code)
) COMMENT ='仓库表';


DROP TABLE IF EXISTS t_order;
CREATE TABLE t_order (
   id int(11) NOT NULL AUTO_INCREMENT,
   user_id varchar(255) DEFAULT NULL,
   commodity_code varchar(255) DEFAULT NULL,
   count int(11) DEFAULT 0,
   money int(11) DEFAULT 0,
   PRIMARY KEY (id)
) COMMENT ='订单表';


DROP TABLE IF EXISTS t_account;
CREATE TABLE t_account (
     id int(11) NOT NULL AUTO_INCREMENT,
     user_id varchar(255) DEFAULT NULL,
     username  varchar(32) NULL DEFAULT NULL COMMENT '用户名',
     money int(11) DEFAULT 0,
     PRIMARY KEY (id)
) COMMENT ='账户表';