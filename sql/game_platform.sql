/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50714
Source Host           : 127.0.0.1:3306
Source Database       : game_platform

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2017-05-25 20:07:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for agent
-- ----------------------------
DROP TABLE IF EXISTS `agent`;
CREATE TABLE `agent` (
  `id` bigint(21) NOT NULL COMMENT 'id',
  `type` int(11) unsigned DEFAULT '0' COMMENT '代理类型(总代理,一级经销,二级经销,三级经销)',
  `roomCards` int(11) unsigned DEFAULT '0' COMMENT '房卡数量',
  `subordinateAgentId` text COMMENT '下属代理id是一个id集合',
  `createTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `inviterName` varchar(255) DEFAULT NULL COMMENT '邀请人',
  `inviteCode` varchar(255) DEFAULT NULL COMMENT '邀请码',
  `openName` varchar(255) DEFAULT NULL COMMENT '微信号等第三方账号名称',
  `phone` bigint(20) DEFAULT '0' COMMENT '电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of agent
-- ----------------------------
INSERT INTO `agent` VALUES ('1', null, null, null, null, null, null, null, '0');

-- ----------------------------
-- Table structure for invite_code
-- ----------------------------
DROP TABLE IF EXISTS `invite_code`;
CREATE TABLE `invite_code` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL COMMENT '邀请码',
  `agentId` bigint(20) DEFAULT NULL COMMENT '代理id',
  `isUse` tinyint(4) DEFAULT NULL COMMENT '是否使用,使用为1',
  `createTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  KEY `agentId` (`agentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of invite_code
-- ----------------------------

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` bigint(21) NOT NULL COMMENT 'id',
  `createTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `content` longtext COMMENT '公告内容',
  `userId` bigint(20) DEFAULT NULL COMMENT '用户id',
  `title` varchar(255) DEFAULT NULL COMMENT '公告标题',
  `isSend` tinyint(4) NOT NULL COMMENT '是否已发送',
  `runCount` int(11) NOT NULL DEFAULT '0' COMMENT '运行次数',
  `type` tinyint(4) NOT NULL COMMENT '公告类型,1大厅',
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of notice
-- ----------------------------

-- ----------------------------
-- Table structure for sell_cards
-- ----------------------------
DROP TABLE IF EXISTS `sell_cards`;
CREATE TABLE `sell_cards` (
  `id` bigint(11) NOT NULL DEFAULT '0' COMMENT 'id',
  `createTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `buyOpenId` varchar(255) DEFAULT NULL COMMENT '买的玩家账号',
  `sellOpenId` varchar(255) DEFAULT NULL COMMENT '卖房卡玩家的账号',
  `roomCards` int(11) DEFAULT '0' COMMENT '销售的房卡',
  `remainCards` int(11) DEFAULT '0' COMMENT '房卡剩余数量',
  `sellType` int(11) DEFAULT '0' COMMENT '出售类型1房卡',
  `orderId` varchar(255) DEFAULT NULL COMMENT '订单号',
  PRIMARY KEY (`id`),
  KEY `buyOpenId` (`buyOpenId`),
  KEY `sellOpenId` (`sellOpenId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sell_cards
-- ----------------------------

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `id` bigint(20) NOT NULL,
  `createTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `shopName` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `price` float(11,0) DEFAULT NULL COMMENT '单价(人民币)',
  `num` int(11) DEFAULT NULL COMMENT '充值量',
  `presentNum` int(11) DEFAULT NULL COMMENT '赠送数量',
  `discount` int(11) DEFAULT NULL COMMENT '折扣(0和100表示原价,)',
  `sellAgentType` int(11) DEFAULT NULL COMMENT '售理代理类型',
  `itemOn` tinyint(4) DEFAULT NULL COMMENT '上架为1',
  `type` int(11) DEFAULT NULL COMMENT '商品类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of shop
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `userName` varchar(255) NOT NULL COMMENT '用户名称',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `channelId` int(11) unsigned DEFAULT '0' COMMENT '默认为0,渠道号',
  `createTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建账号时间',
  `lastLoginTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后登录时间',
  `status` tinyint(4) unsigned DEFAULT '1' COMMENT '正常为1,禁用为0',
  `passport` varchar(255) NOT NULL COMMENT '平台通行证',
  `phone` bigint(20) unsigned DEFAULT NULL COMMENT '电话号码',
  `version` int(11) unsigned DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`),
  KEY `passport` (`passport`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '超级管理员', '123456', '0', '2017-05-23 11:13:25', '2017-05-23 11:13:29', '1', 'admin', '9696960', null);

-- ----------------------------
-- Table structure for user_pay
-- ----------------------------
DROP TABLE IF EXISTS `user_pay`;
CREATE TABLE `user_pay` (
  `id` bigint(20) NOT NULL,
  `userId` bigint(20) NOT NULL COMMENT '玩家id',
  `pay_before_num` int(11) NOT NULL DEFAULT '0' COMMENT '充值前的数量',
  `payNum` int(11) NOT NULL DEFAULT '0' COMMENT '充值数量',
  `payAfterNum` int(11) unsigned zerofill NOT NULL DEFAULT '00000000000' COMMENT '充值后的数量',
  `createTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '生成时间',
  `orderId` varchar(255) DEFAULT NULL COMMENT '订单号',
  `paySucess` tinyint(4) unsigned zerofill DEFAULT '0000' COMMENT '充值是否成功,成功为1',
  `payType` int(11) DEFAULT NULL COMMENT '充值类型1,人民币',
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user_pay
-- ----------------------------
