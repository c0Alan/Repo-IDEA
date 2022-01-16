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
`id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id，100000以下为系统内置字典，100000以上为外部添加字典',
`parent_id` INT(11) UNSIGNED COMMENT '父节点id',
`dict_level` tinyint unsigned DEFAULT NULL COMMENT '字典层级, 0:字典类型',
`dict_type_code` VARCHAR(255) DEFAULT NULL COMMENT '字典类型编码',
`dict_type_name` VARCHAR(255) DEFAULT NULL COMMENT '字典类型名称',
`dict_data_code` VARCHAR(255) DEFAULT NULL COMMENT '字典数据编码',
`dict_data_name` VARCHAR(255) DEFAULT NULL COMMENT '字典数据名称',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '字典表';
alter table t_dict auto_increment=100000;

INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('1', NULL, '0', 'xzqh', '行政区划', NULL, NULL);
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('2', '1', '1', 'xzqh', '行政区划', '440000', '广东省');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('3', '2', '2', 'xzqh', '行政区划', '440100', '广州市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('4', '3', '3', 'xzqh', '行政区划', '440101', '市辖区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('5', '3', '3', 'xzqh', '行政区划', '440103', '荔湾区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('6', '3', '3', 'xzqh', '行政区划', '440104', '越秀区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('7', '3', '3', 'xzqh', '行政区划', '440105', '海珠区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('8', '3', '3', 'xzqh', '行政区划', '440106', '天河区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('9', '3', '3', 'xzqh', '行政区划', '440111', '白云区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('10', '3', '3', 'xzqh', '行政区划', '440112', '黄埔区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('11', '3', '3', 'xzqh', '行政区划', '440113', '番禺区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('12', '3', '3', 'xzqh', '行政区划', '440114', '花都区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('13', '3', '3', 'xzqh', '行政区划', '440115', '南沙区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('14', '3', '3', 'xzqh', '行政区划', '440116', '萝岗区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('15', '3', '3', 'xzqh', '行政区划', '440117', '从化区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('16', '3', '3', 'xzqh', '行政区划', '440118', '增城区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('17', '2', '2', 'xzqh', '行政区划', '440200', '韶关市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('18', '17', '3', 'xzqh', '行政区划', '440201', '市辖区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('19', '17', '3', 'xzqh', '行政区划', '440203', '武江区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('20', '17', '3', 'xzqh', '行政区划', '440204', '浈江区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('21', '17', '3', 'xzqh', '行政区划', '440205', '曲江区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('22', '17', '3', 'xzqh', '行政区划', '440222', '始兴县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('23', '17', '3', 'xzqh', '行政区划', '440224', '仁化县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('24', '17', '3', 'xzqh', '行政区划', '440229', '翁源县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('25', '17', '3', 'xzqh', '行政区划', '440232', '乳源瑶族自治县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('26', '17', '3', 'xzqh', '行政区划', '440233', '新丰县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('27', '17', '3', 'xzqh', '行政区划', '440281', '乐昌市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('28', '17', '3', 'xzqh', '行政区划', '440282', '南雄市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('29', '2', '2', 'xzqh', '行政区划', '440300', '深圳市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('30', '29', '3', 'xzqh', '行政区划', '440301', '市辖区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('31', '29', '3', 'xzqh', '行政区划', '440303', '罗湖区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('32', '29', '3', 'xzqh', '行政区划', '440304', '福田区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('33', '29', '3', 'xzqh', '行政区划', '440305', '南山区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('34', '29', '3', 'xzqh', '行政区划', '440306', '宝安区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('35', '29', '3', 'xzqh', '行政区划', '440307', '龙岗区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('36', '29', '3', 'xzqh', '行政区划', '440308', '盐田区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('37', '2', '2', 'xzqh', '行政区划', '440400', '珠海市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('38', '37', '3', 'xzqh', '行政区划', '440401', '市辖区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('39', '37', '3', 'xzqh', '行政区划', '440402', '香洲区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('40', '37', '3', 'xzqh', '行政区划', '440403', '斗门区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('41', '37', '3', 'xzqh', '行政区划', '440404', '金湾区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('42', '2', '2', 'xzqh', '行政区划', '440500', '汕头市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('43', '42', '3', 'xzqh', '行政区划', '440501', '市辖区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('44', '42', '3', 'xzqh', '行政区划', '440507', '龙湖区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('45', '42', '3', 'xzqh', '行政区划', '440511', '金平区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('46', '42', '3', 'xzqh', '行政区划', '440512', '濠江区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('47', '42', '3', 'xzqh', '行政区划', '440513', '潮阳区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('48', '42', '3', 'xzqh', '行政区划', '440514', '潮南区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('49', '42', '3', 'xzqh', '行政区划', '440515', '澄海区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('50', '42', '3', 'xzqh', '行政区划', '440523', '南澳县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('51', '2', '2', 'xzqh', '行政区划', '440600', '佛山市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('52', '51', '3', 'xzqh', '行政区划', '440601', '市辖区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('53', '51', '3', 'xzqh', '行政区划', '440604', '禅城区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('54', '51', '3', 'xzqh', '行政区划', '440605', '南海区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('55', '51', '3', 'xzqh', '行政区划', '440606', '顺德区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('56', '51', '3', 'xzqh', '行政区划', '440607', '三水区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('57', '51', '3', 'xzqh', '行政区划', '440608', '高明区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('58', '2', '2', 'xzqh', '行政区划', '440700', '江门市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('59', '58', '3', 'xzqh', '行政区划', '440701', '市辖区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('60', '58', '3', 'xzqh', '行政区划', '440703', '蓬江区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('61', '58', '3', 'xzqh', '行政区划', '440704', '江海区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('62', '58', '3', 'xzqh', '行政区划', '440705', '新会区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('63', '58', '3', 'xzqh', '行政区划', '440781', '台山市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('64', '58', '3', 'xzqh', '行政区划', '440783', '开平市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('65', '58', '3', 'xzqh', '行政区划', '440784', '鹤山市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('66', '58', '3', 'xzqh', '行政区划', '440785', '恩平市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('67', '2', '2', 'xzqh', '行政区划', '440800', '湛江市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('68', '67', '3', 'xzqh', '行政区划', '440801', '市辖区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('69', '67', '3', 'xzqh', '行政区划', '440802', '赤坎区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('70', '67', '3', 'xzqh', '行政区划', '440803', '霞山区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('71', '67', '3', 'xzqh', '行政区划', '440804', '坡头区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('72', '67', '3', 'xzqh', '行政区划', '440811', '麻章区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('73', '67', '3', 'xzqh', '行政区划', '440823', '遂溪县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('74', '67', '3', 'xzqh', '行政区划', '440825', '徐闻县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('75', '67', '3', 'xzqh', '行政区划', '440881', '廉江市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('76', '67', '3', 'xzqh', '行政区划', '440882', '雷州市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('77', '67', '3', 'xzqh', '行政区划', '440883', '吴川市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('78', '2', '2', 'xzqh', '行政区划', '440900', '茂名市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('79', '78', '3', 'xzqh', '行政区划', '440901', '市辖区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('80', '78', '3', 'xzqh', '行政区划', '440902', '茂南区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('81', '78', '3', 'xzqh', '行政区划', '440903', '茂港区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('82', '78', '3', 'xzqh', '行政区划', '440923', '电白县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('83', '78', '3', 'xzqh', '行政区划', '440981', '高州市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('84', '78', '3', 'xzqh', '行政区划', '440982', '化州市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('85', '78', '3', 'xzqh', '行政区划', '440983', '信宜市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('86', '2', '2', 'xzqh', '行政区划', '441200', '肇庆市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('87', '86', '3', 'xzqh', '行政区划', '441201', '市辖区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('88', '86', '3', 'xzqh', '行政区划', '441202', '端州区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('89', '86', '3', 'xzqh', '行政区划', '441203', '鼎湖区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('90', '86', '3', 'xzqh', '行政区划', '441223', '广宁县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('91', '86', '3', 'xzqh', '行政区划', '441224', '怀集县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('92', '86', '3', 'xzqh', '行政区划', '441225', '封开县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('93', '86', '3', 'xzqh', '行政区划', '441226', '德庆县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('94', '86', '3', 'xzqh', '行政区划', '441283', '高要市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('95', '86', '3', 'xzqh', '行政区划', '441284', '四会市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('96', '2', '2', 'xzqh', '行政区划', '441300', '惠州市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('97', '96', '3', 'xzqh', '行政区划', '441301', '市辖区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('98', '96', '3', 'xzqh', '行政区划', '441302', '惠城区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('99', '96', '3', 'xzqh', '行政区划', '441303', '惠阳区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('100', '96', '3', 'xzqh', '行政区划', '441322', '博罗县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('101', '96', '3', 'xzqh', '行政区划', '441323', '惠东县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('102', '96', '3', 'xzqh', '行政区划', '441324', '龙门县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('103', '2', '2', 'xzqh', '行政区划', '441400', '梅州市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('104', '103', '3', 'xzqh', '行政区划', '441401', '市辖区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('105', '103', '3', 'xzqh', '行政区划', '441402', '梅江区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('106', '103', '3', 'xzqh', '行政区划', '441421', '梅县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('107', '103', '3', 'xzqh', '行政区划', '441422', '大埔县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('108', '103', '3', 'xzqh', '行政区划', '441423', '丰顺县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('109', '103', '3', 'xzqh', '行政区划', '441424', '五华县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('110', '103', '3', 'xzqh', '行政区划', '441426', '平远县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('111', '103', '3', 'xzqh', '行政区划', '441427', '蕉岭县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('112', '103', '3', 'xzqh', '行政区划', '441481', '兴宁市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('113', '2', '2', 'xzqh', '行政区划', '441500', '汕尾市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('114', '113', '3', 'xzqh', '行政区划', '441501', '市辖区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('115', '113', '3', 'xzqh', '行政区划', '441502', '城区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('116', '113', '3', 'xzqh', '行政区划', '441521', '海丰县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('117', '113', '3', 'xzqh', '行政区划', '441523', '陆河县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('118', '113', '3', 'xzqh', '行政区划', '441581', '陆丰市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('119', '2', '2', 'xzqh', '行政区划', '441600', '河源市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('120', '119', '3', 'xzqh', '行政区划', '441601', '市辖区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('121', '119', '3', 'xzqh', '行政区划', '441602', '源城区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('122', '119', '3', 'xzqh', '行政区划', '441621', '紫金县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('123', '119', '3', 'xzqh', '行政区划', '441622', '龙川县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('124', '119', '3', 'xzqh', '行政区划', '441623', '连平县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('125', '119', '3', 'xzqh', '行政区划', '441624', '和平县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('126', '119', '3', 'xzqh', '行政区划', '441625', '东源县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('127', '2', '2', 'xzqh', '行政区划', '441700', '阳江市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('128', '127', '3', 'xzqh', '行政区划', '441701', '市辖区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('129', '127', '3', 'xzqh', '行政区划', '441702', '江城区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('130', '127', '3', 'xzqh', '行政区划', '441721', '阳西县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('131', '127', '3', 'xzqh', '行政区划', '441723', '阳东县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('132', '127', '3', 'xzqh', '行政区划', '441781', '阳春市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('133', '2', '2', 'xzqh', '行政区划', '441800', '清远市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('134', '133', '3', 'xzqh', '行政区划', '441801', '市辖区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('135', '133', '3', 'xzqh', '行政区划', '441802', '清城区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('136', '133', '3', 'xzqh', '行政区划', '441821', '佛冈县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('137', '133', '3', 'xzqh', '行政区划', '441823', '阳山县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('138', '133', '3', 'xzqh', '行政区划', '441825', '连山壮族瑶族自治县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('139', '133', '3', 'xzqh', '行政区划', '441826', '连南瑶族自治县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('140', '133', '3', 'xzqh', '行政区划', '441827', '清新县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('141', '133', '3', 'xzqh', '行政区划', '441881', '英德市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('142', '133', '3', 'xzqh', '行政区划', '441882', '连州市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('143', '2', '2', 'xzqh', '行政区划', '441900', '东莞市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('144', '2', '2', 'xzqh', '行政区划', '442000', '中山市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('145', '2', '2', 'xzqh', '行政区划', '445100', '潮州市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('146', '145', '3', 'xzqh', '行政区划', '445101', '市辖区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('147', '145', '3', 'xzqh', '行政区划', '445102', '湘桥区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('148', '145', '3', 'xzqh', '行政区划', '445121', '潮安县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('149', '145', '3', 'xzqh', '行政区划', '445122', '饶平县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('150', '2', '2', 'xzqh', '行政区划', '445200', '揭阳市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('151', '150', '3', 'xzqh', '行政区划', '445201', '市辖区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('152', '150', '3', 'xzqh', '行政区划', '445202', '榕城区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('153', '150', '3', 'xzqh', '行政区划', '445221', '揭东县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('154', '150', '3', 'xzqh', '行政区划', '445222', '揭西县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('155', '150', '3', 'xzqh', '行政区划', '445224', '惠来县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('156', '150', '3', 'xzqh', '行政区划', '445281', '普宁市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('157', '2', '2', 'xzqh', '行政区划', '445300', '云浮市');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('158', '157', '3', 'xzqh', '行政区划', '445301', '市辖区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('159', '157', '3', 'xzqh', '行政区划', '445302', '云城区');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('160', '157', '3', 'xzqh', '行政区划', '445321', '新兴县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('161', '157', '3', 'xzqh', '行政区划', '445322', '郁南县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('162', '157', '3', 'xzqh', '行政区划', '445323', '云安县');
INSERT INTO `t_dict` (`id`, `parent_id`, `dict_level`, `dict_type_code`, `dict_type_name`, `dict_data_code`, `dict_data_name`) VALUES ('163', '157', '3', 'xzqh', '行政区划', '445381', '罗定市');
