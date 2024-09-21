DROP TABLE IF EXISTS test_user;
CREATE TABLE test_user (
    id int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
    usercode varchar(32) DEFAULT NULL COMMENT '用户编码',
    username varchar(32) DEFAULT NULL COMMENT '用户名',
    password varchar(64) DEFAULT NULL COMMENT '密码',
    telephone varchar(11) DEFAULT NULL COMMENT '手机号',
    enabled int(11) DEFAULT '1' COMMENT '默认1  1有效 0 无效',
    age tinyint(3) unsigned DEFAULT NULL COMMENT '年龄',
    PRIMARY KEY (id) USING BTREE,
    UNIQUE KEY (usercode)
) COMMENT='测试-用户信息表';

INSERT INTO test_user (id, usercode, username, password, telephone, enabled, age) VALUES ('1', 'zhangsan', '张三', '$2a$10$rCNJoo6tg1Jb278KJJREk.XIAEHoArojMVGOW3ehjtW3Rb7ayhAZu', '12345678998', '1', NULL);
INSERT INTO test_user (id, usercode, username, password, telephone, enabled, age) VALUES ('2', 'lisi', '李四', '$2a$10$dIEID4LCcsWS2lXJLO2VCO.yTow70YIuPfM9sy9c8HtEArEokgpTm', '12345678999', '1', NULL);
INSERT INTO test_user (id, usercode, username, password, telephone, enabled, age) VALUES ('3', 'wangwu', '王五', '$2a$10$dIEID4LCcsWS2lXJLO2VCO.yTow70YIuPfM9sy9c8HtEArEokgpTm', '12345678999', '1', NULL);


DROP TABLE IF EXISTS test_warehouse;
CREATE TABLE test_warehouse (
     id int(11) NOT NULL AUTO_INCREMENT,
     commodity_code varchar(32) DEFAULT NULL COMMENT '商品编码',
     commodity_name varchar(32) DEFAULT NULL COMMENT '商品名称',
     count int(11) DEFAULT 0,
     PRIMARY KEY (id),
     UNIQUE KEY (commodity_code)
) COMMENT ='仓库表';


DROP TABLE IF EXISTS test_order;
CREATE TABLE test_order (
   id int(11) NOT NULL AUTO_INCREMENT,
   usercode varchar(32) DEFAULT NULL COMMENT '用户编码',
   commodity_code varchar(32) DEFAULT NULL COMMENT '商品编码',
   count int(11) DEFAULT 0 COMMENT '数量',
   money int(11) DEFAULT 0 COMMENT '总金额',
   PRIMARY KEY (id)
) COMMENT ='订单表';


DROP TABLE IF EXISTS test_account;
CREATE TABLE test_account (
     id int(11) NOT NULL AUTO_INCREMENT,
     usercode varchar(32) DEFAULT NULL COMMENT '用户编码',
     username  varchar(32) NULL DEFAULT NULL COMMENT '用户名',
     money int(11) DEFAULT 0 COMMENT '账户余额',
     PRIMARY KEY (id)
) COMMENT ='账户表';

INSERT INTO test_account (id, usercode, username, money) VALUES ('1', 'zhangsan', '张三', '100');
INSERT INTO test_account (id, usercode, username, money) VALUES ('2', 'lisi', '李四', '300');
INSERT INTO test_account (id, usercode, username, money) VALUES ('3', 'wangwu', '王五', '500');

DROP TABLE IF EXISTS  test_student ;
CREATE TABLE  test_student  (
   id  int(11) NOT NULL AUTO_INCREMENT,
   name  varchar(100) DEFAULT NULL COMMENT '姓名',
   sex  tinyint DEFAULT NULL COMMENT '性别, 0:女, 1:男',
   birthday  date DEFAULT NULL COMMENT '出生日期',
   remark varchar(255) DEFAULT NULL COMMENT '备注',
   create_time  datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   update_time  datetime DEFAULT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
   PRIMARY KEY ( id )
) COMMENT ='学生表';

DROP TABLE IF EXISTS  test_student_education;
CREATE TABLE  test_student_education  (
    id  int(11) NOT NULL AUTO_INCREMENT,
    student_id  int(11) DEFAULT NULL COMMENT '学生ID',
    class_id  int(11) DEFAULT NULL COMMENT '班级ID',
    grade_id  int(11) DEFAULT NULL COMMENT '年级ID',
    admission_date  date DEFAULT NULL COMMENT '就读日期',
    status tinyint DEFAULT NULL COMMENT '状态, 0:在读, 1:毕业',
    remark varchar(255) DEFAULT NULL COMMENT '备注',
    create_time  datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time  datetime DEFAULT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY ( id )
) COMMENT ='学生学历表';
