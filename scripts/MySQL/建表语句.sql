

-- 人员表
DROP TABLE IF EXISTS t_person;
CREATE TABLE t_person (
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
	person_name VARCHAR(20) NOT NULL COMMENT '人员姓名',
	address VARCHAR(50) NULL COMMENT '地址'
) COMMENT '人员表';

INSERT INTO t_person(person_name) values ('张三'),('李四');


