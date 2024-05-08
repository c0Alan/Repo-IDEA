
/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
    `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
    `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
    `menu_vice_name` varchar(50) NOT NULL COMMENT '菜单副名称',
    `parent_id` bigint(20) DEFAULT '0' COMMENT '父菜单ID',
    `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
    `url` varchar(200) DEFAULT '#' COMMENT '请求地址',
    `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
    `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
    `perms` varchar(100) DEFAULT NULL COMMENT '权限标识',
    `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
    `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1091 DEFAULT CHARSET=utf8 COMMENT='菜单权限表';

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`menu_id`,`menu_name`,`menu_vice_name`,`parent_id`,`order_num`,`url`,`menu_type`,`visible`,`perms`,`icon`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'首页','普通用户首页',0,0,'/index','M','0',NULL,'icon-home','',NULL,'',NULL,''),(2,'系统设置','超级管理员-系统设置',0,1,'system','M','0',NULL,'icon-setting','',NULL,'',NULL,''),(3,'单位管理','超级管理员和普通管理员-单位管理',0,2,'/system/menu','M','0',NULL,'icon-setting','',NULL,'',NULL,''),(4,'菜单管理','菜单管理',2,3,'/system/menu','C','0',NULL,'','',NULL,'',NULL,''),(5,'权限管理','权限管理',2,4,'/system/role','C','0',NULL,'','',NULL,'',NULL,''),(6,'科目代码','科目代码',2,5,'#','C','0',NULL,'','',NULL,'',NULL,''),(7,'用户管理','用户管理',3,6,'/system/user','C','0',NULL,'','',NULL,'',NULL,''),(8,'单位管理','单位管理',3,7,'/system/organization','C','0',NULL,'','',NULL,'',NULL,''),(9,'银行账户','银行账户',3,8,'#','C','0',NULL,'','',NULL,'',NULL,'');

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
    `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
    `role_name` varchar(30) NOT NULL COMMENT '角色名称',
    `role_key` varchar(100) NOT NULL COMMENT '角色权限字符串',
    `role_sort` int(4) NOT NULL COMMENT '显示顺序',
    `status` char(1) NOT NULL COMMENT '角色状态（0正常 1停用 2删除）',
    `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `remark` varchar(500) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='角色信息表';

/*Data for the table `sys_role` */

insert  into `sys_role`(`role_id`,`role_name`,`role_key`,`role_sort`,`status`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'普通用户','putongyonghu',0,'0','',NULL,'',NULL,NULL),(2,'普通管理','putongguanli',1,'0','',NULL,'',NULL,NULL),(3,'超级管理员','chaojiguanliyuan',2,'0','',NULL,'',NULL,NULL);

/*Table structure for table `sys_role_menu` */

DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
         `role_id` bigint(20) NOT NULL COMMENT '角色ID',
         `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
         PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

/*Data for the table `sys_role_menu` */

insert  into `sys_role_menu`(`role_id`,`menu_id`) values (3,1),(3,2),(3,3),(3,4),(3,5),(3,6),(3,7),(3,8),(3,9);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
    `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
    `login_name` varchar(30) NOT NULL COMMENT '登录名称',
    `user_name` varchar(30) DEFAULT NULL COMMENT '用户名称',
    `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
    `phone` varchar(11) DEFAULT '' COMMENT '手机号码',
    `telephone` varchar(12) DEFAULT '' COMMENT '座机号码',
    `duty` varchar(30) DEFAULT '' COMMENT '职务',
    `sex` char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
    `avatar` varchar(100) DEFAULT '' COMMENT '头像路径',
    `password` varchar(100) DEFAULT '' COMMENT '密码',
    `salt` varchar(20) DEFAULT '' COMMENT '盐加密',
    `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用 2删除）',
    `login_ip` varchar(50) DEFAULT '' COMMENT '最后登陆IP',
    `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
    `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `remark` varchar(500) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`user_id`,`dept_id`,`login_name`,`user_name`,`email`,`phone`,`telephone`,`duty`,`sex`,`avatar`,`password`,`salt`,`status`,`login_ip`,`login_date`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,1,'admin','admin','admin@sina.cn','','','','0','','c9961f4af206bf47d20de56df275127bc10442ab021938f19cbf89aaa1baef66','111','0','10.96.217.201','2021-02-25 11:15:51','',NULL,'',NULL,NULL);

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
         `user_id` bigint(20) NOT NULL COMMENT '用户ID',
         `role_id` bigint(20) NOT NULL COMMENT '角色ID',
         PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户和角色关联表';

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`user_id`,`role_id`) values (1,3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
