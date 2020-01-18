/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.5.49 : Database - lac
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lac` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `lac`;

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `menu_id` varchar(100) NOT NULL COMMENT '菜单id',
  `menu_name` varchar(200) DEFAULT NULL COMMENT '菜单名称',
  `menu_parent` varchar(100) DEFAULT NULL COMMENT '父菜单id',
  `menu_level` varchar(100) DEFAULT NULL COMMENT '菜单级别',
  `menu_url` varchar(200) DEFAULT NULL COMMENT '菜单url',
  `menu_state` varchar(100) DEFAULT NULL COMMENT '01 有效  02:无效',
  `menu_sort` int(11) DEFAULT NULL COMMENT '菜单排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单';

/*Data for the table `menu` */

insert  into `menu`(`menu_id`,`menu_name`,`menu_parent`,`menu_level`,`menu_url`,`menu_state`,`menu_sort`,`create_time`,`update_time`) values ('1','权限管理','0','1',NULL,'01',1,'2019-09-03 00:06:30',NULL),('2','菜单管理','1','2','/system/common?vid=2&clazz=Menu','01',1,'2019-09-03 01:07:38',NULL),('3','用户管理','1','2','/system/common?vid=3&clazz=User','01',2,'2019-09-03 01:07:40',NULL),('4','角色管理','1','2','/system/common?vid=4&clazz=Role','01',3,'2019-09-03 01:07:41',NULL);

/*Table structure for table `menu_resource` */

DROP TABLE IF EXISTS `menu_resource`;

CREATE TABLE `menu_resource` (
  `mr_id` varchar(100) NOT NULL,
  `menu_id` varchar(100) DEFAULT NULL,
  `resource_id` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`mr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `menu_resource` */

insert  into `menu_resource`(`mr_id`,`menu_id`,`resource_id`,`create_time`,`update_time`) values ('1','3','1','2020-01-09 13:32:58','2020-01-09 13:33:02'),('2','3','2','2020-01-09 13:33:08','2020-01-09 13:33:09'),('3','3','3','2020-01-09 14:58:37','2020-01-09 14:58:40'),('4','3','4','2020-01-09 14:58:38','2020-01-09 14:58:41'),('5','4','3','2020-01-09 15:10:10',NULL),('6','4','4','2020-01-09 15:10:11',NULL),('7','2','3','2020-01-09 15:17:02',NULL),('8','2','4','2020-01-09 15:17:04',NULL);

/*Table structure for table `resource` */

DROP TABLE IF EXISTS `resource`;

CREATE TABLE `resource` (
  `resource_id` varchar(100) NOT NULL,
  `resource_name` varchar(100) DEFAULT NULL,
  `resource_comment` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `resource` */

insert  into `resource`(`resource_id`,`resource_name`,`resource_comment`,`create_time`,`update_time`) values ('1','edit','修改','2020-01-09 13:32:08','2020-01-09 13:32:11'),('2','reset','重置密码','2020-01-09 13:32:24','2020-01-09 13:32:27'),('3','add','添加','2020-01-09 14:57:09','2020-01-09 14:57:10'),('4','search','搜索','2020-01-09 14:58:10','2020-01-09 14:58:11');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` varchar(100) NOT NULL,
  `role_name` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`role_id`,`role_name`,`create_time`,`update_time`) values ('1','系统管理员','2020-01-09 13:34:44','2020-01-09 13:34:46');

/*Table structure for table `role_menu` */

DROP TABLE IF EXISTS `role_menu`;

CREATE TABLE `role_menu` (
  `rm_id` varchar(100) NOT NULL,
  `role_id` varchar(100) DEFAULT NULL,
  `menu_id` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`rm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role_menu` */

insert  into `role_menu`(`rm_id`,`role_id`,`menu_id`,`create_time`,`update_time`) values ('1','1','1','2020-01-09 13:36:14','2020-01-09 13:36:16'),('2','1','2','2020-01-09 13:36:23','2020-01-09 13:36:25'),('3','1','3','2020-01-09 13:36:33','2020-01-09 13:36:35'),('4','1','4','2020-01-09 13:36:37','2020-01-09 13:36:39');

/*Table structure for table `role_menu_resource` */

DROP TABLE IF EXISTS `role_menu_resource`;

CREATE TABLE `role_menu_resource` (
  `rmr_id` varchar(100) NOT NULL,
  `role_id` varchar(100) DEFAULT NULL,
  `mr_id` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`rmr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role_menu_resource` */

insert  into `role_menu_resource`(`rmr_id`,`role_id`,`mr_id`,`create_time`,`update_time`) values ('1','1','1','2020-01-09 13:41:32','2020-01-09 13:41:33'),('2','1','2','2020-01-09 13:41:38','2020-01-09 13:41:40'),('3','1','3','2020-01-09 14:59:13','2020-01-09 14:59:16'),('4','1','4','2020-01-09 14:59:15','2020-01-09 14:59:18'),('5','1','5','2020-01-09 15:11:40',NULL),('6','1','6','2020-01-09 15:11:42',NULL),('7','1','7','2020-01-09 15:17:17',NULL),('8','1','8','2020-01-09 15:17:18',NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` varchar(100) COLLATE utf8_bin NOT NULL COMMENT 'id',
  `user_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '账号',
  `user_nick_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '名字',
  `user_pass` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `user_did` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '部门id',
  `user_state` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '01 有效  02:无效',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_name`,`user_nick_name`,`user_pass`,`user_did`,`user_state`,`create_time`,`update_time`) values ('1','admin','admin','1','1','01','2019-09-03 00:00:00',NULL),('11112','ccc',NULL,'123','1','01','2019-09-10 00:00:00',NULL),('11113','www',NULL,'123','1','01','2019-09-17 00:00:00',NULL),('11114','fff',NULL,'123','1','01','2019-09-24 00:00:00',NULL),('11115','mvc',NULL,'123','2','02','2019-09-06 00:00:00',NULL),('1167368641943961600','spring',NULL,'123','2','02','2019-09-13 00:00:00',NULL),('1167368777151545344','gc',NULL,'123','2','01','2019-09-20 00:00:00',NULL),('1167368780406325248','zhaoliu',NULL,'123','3','01','2019-09-27 00:00:00',NULL),('1167368783027765248','wangwu',NULL,'123','3','01','2019-09-01 00:00:00',NULL),('1167368785439490048','lisi',NULL,'1','4','01','2019-09-29 00:00:00',NULL);

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `ur_id` varchar(100) NOT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `role_id` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`ur_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`ur_id`,`user_id`,`role_id`,`create_time`,`update_time`) values ('1','1','1','2020-01-09 13:35:03','2020-01-09 13:35:04');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
