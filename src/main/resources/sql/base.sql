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
INSERT INTO `user` VALUES ('15', 'lisi15', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('16', 'lisi16', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('17', 'lisi17', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('18', 'lisi18', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('19', 'lisi19', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('20', 'lisi20', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('21', 'lisi21', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('22', 'lisi22', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('23', 'lisi23', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('24', 'lisi24', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('25', 'lisi25', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('26', 'lisi26', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('27', 'lisi27', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('28', 'lisi28', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('29', 'lisi29', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('30', 'lisi30', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('31', 'lisi31', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('32', 'lisi32', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('33', 'lisi33', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('34', 'lisi34', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('35', 'lisi35', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('36', 'lisi36', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('37', 'lisi37', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('38', 'lisi38', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('39', 'lisi39', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('40', 'lisi40', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('41', 'lisi41', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('42', 'lisi42', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('43', 'lisi43', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
INSERT INTO `user` VALUES ('44', 'lisi44', '123456', '13918891675', 'mmc@163.com', 'm', 'lisi1');
