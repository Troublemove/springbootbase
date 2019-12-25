/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2019-12-25 15:36:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123456', '13918891675', 'mmc@163.com', '男', '管理员');
INSERT INTO `user` VALUES ('2', 'lisi2', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('3', 'lisi3', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('4', 'lisi4', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('5', 'lisi5', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('6', 'lisi6', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('7', 'lisi7', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('8', 'lisi8', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('9', 'lisi9', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('10', 'lisi10', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('11', 'lisi11', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('12', 'lisi12', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('13', 'lisi13', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('14', 'lisi14', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
