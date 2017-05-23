/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50714
Source Host           : 127.0.0.1:3306
Source Database       : game_platform

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2017-05-23 20:09:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `userName` varchar(255) NOT NULL COMMENT '用户名称',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `channelId` int(11) unsigned zerofill DEFAULT '00000000000' COMMENT '默认为0,渠道号',
  `createTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建账号时间',
  `lastLoginTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后登录时间',
  `status` tinyint(4) unsigned zerofill DEFAULT '0001' COMMENT '正常为1,禁用为0',
  `passport` varchar(255) NOT NULL COMMENT '平台通行证',
  `phone` bigint(20) unsigned zerofill DEFAULT NULL COMMENT '电话号码',
  `version` int(11) unsigned zerofill DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`),
  KEY `passport` (`passport`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '超级管理员', '123456', '00000000000', '2017-05-23 11:13:25', '2017-05-23 11:13:29', '0001', 'admin', '00000000000009696960', null);
