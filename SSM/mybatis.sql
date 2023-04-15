/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80024
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 80024
File Encoding         : 65001

Date: 2023-04-15 12:39:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `money` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'zhangsan', '900');
INSERT INTO `account` VALUES ('2', 'lisi', '1100');
INSERT INTO `account` VALUES ('3', 'wangwu', '3000');

-- ----------------------------
-- Table structure for account_log
-- ----------------------------
DROP TABLE IF EXISTS `account_log`;
CREATE TABLE `account_log` (
  `id` int NOT NULL AUTO_INCREMENT,
  `info` varchar(255) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of account_log
-- ----------------------------
INSERT INTO `account_log` VALUES ('5', '转账操作由zhangsan到lisi,金额：100.0', '2022-08-07 18:58:24');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '计算机理论', 'Spring实战 第5版', 'Spring入门经典教程，深入理解Spring原理技术内幕.');
INSERT INTO `book` VALUES ('2', '计算机理论', 'Spring 5核心原理与30个类手写实战', '十年沉淀之作，手写Spring精华思想');
INSERT INTO `book` VALUES ('3', '计算机理论', 'Spring 5 设计模式', '深入Spring源码剖析Spring源码中蕴含的10大设计模式');
INSERT INTO `book` VALUES ('4', '计算机理论', 'Spring MVC+MyBatis开发从入门到项目实战', '全方位解析面向Web应用的轻量级框架，带你成为Spring MVC开发高手');
INSERT INTO `book` VALUES ('5', '计算机理论', '轻量级Java Web企业应用实战', '源码级剖析Spring框架，适合已掌握Java基础的读者');
INSERT INTO `book` VALUES ('6', '计算机理论', 'Java核心技术 卷I 基础知识（原书第11版）', 'Core Java 第11版，Jolt大奖获奖作品，针对Java SE9、10、11全面更新');
INSERT INTO `book` VALUES ('7', '计算机理论', '深入理解Java虚拟机', '5个维度全面剖析JVM，大厂面试知识点全覆盖');
INSERT INTO `book` VALUES ('8', '计算机理论', 'Java编程思想（第4版）', 'Java学习必读经典,殿堂级著作！赢得了全球程序员的广泛赞誉');
INSERT INTO `book` VALUES ('9', '计算机理论', '零基础学Java（全彩版）', '零基础自学编程的入门图书，由浅入深，详解Java语言的编程思想和核心技术');
INSERT INTO `book` VALUES ('10', '市场营销', '直播就该这么做：主播高效沟通实战指南', '李子柒、李佳琦、薇娅成长为网红的秘密都在书中');
INSERT INTO `book` VALUES ('11', '市场营销', '直播销讲实战一本通', '和秋叶一起学系列网络营销书籍');
INSERT INTO `book` VALUES ('13', '20', '1', 'ok');
INSERT INTO `book` VALUES ('30', '1', '2', '3');

-- ----------------------------
-- Table structure for mybatis_plus_product
-- ----------------------------
DROP TABLE IF EXISTS `mybatis_plus_product`;
CREATE TABLE `mybatis_plus_product` (
  `id` bigint NOT NULL COMMENT '主键ID',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '商品名称',
  `price` int DEFAULT '0' COMMENT '价格',
  `version` int DEFAULT '0' COMMENT '乐观锁版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of mybatis_plus_product
-- ----------------------------
INSERT INTO `mybatis_plus_product` VALUES ('1', '外星人笔记本', '120', '4');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'admin', '123456');
INSERT INTO `tb_user` VALUES ('2', 'test_name1', 'test_password2');
INSERT INTO `tb_user` VALUES ('5', 'ww', '123456789');
INSERT INTO `tb_user` VALUES ('6', '1', '2');
INSERT INTO `tb_user` VALUES ('7', '1', '2');
INSERT INTO `tb_user` VALUES ('8', 'zs', '666');
INSERT INTO `tb_user` VALUES ('9', 'zs', '666');

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book` (
  `book_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `book_name` varchar(20) DEFAULT NULL COMMENT '图书名称',
  `price` int DEFAULT NULL COMMENT '价格',
  `stock` int unsigned DEFAULT NULL COMMENT '库存（无符号）',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES ('1', '斗破苍\r\n穹', '80', '99');
INSERT INTO `t_book` VALUES ('2', '斗罗大陆', '50', '100');

-- ----------------------------
-- Table structure for t_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept` (
  `dept_id` int NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_dept
-- ----------------------------
INSERT INTO `t_dept` VALUES ('1', 'A');
INSERT INTO `t_dept` VALUES ('2', 'B');
INSERT INTO `t_dept` VALUES ('3', 'C');

-- ----------------------------
-- Table structure for t_emp
-- ----------------------------
DROP TABLE IF EXISTS `t_emp`;
CREATE TABLE `t_emp` (
  `emp_id` int NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(20) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `dept_id` int DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_emp
-- ----------------------------
INSERT INTO `t_emp` VALUES ('1', 'zs', '20', '11', 'zs@qq.com');
INSERT INTO `t_emp` VALUES ('2', 'ls', '23', '2', 'ls@fmail.com');
INSERT INTO `t_emp` VALUES ('3', 'ww', '22', '3', 'ww?@163.com');
INSERT INTO `t_emp` VALUES ('4', 'zl', '20', '11', 'zl@qq.com');
INSERT INTO `t_emp` VALUES ('5', 'update', '10', '11', 'new@qq.com');
INSERT INTO `t_emp` VALUES ('8', '小红', '25', null, 'undefined');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `balance` int unsigned DEFAULT NULL COMMENT '余额（无符号）',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '0');

-- ----------------------------
-- Table structure for user_mybatis_plus
-- ----------------------------
DROP TABLE IF EXISTS `user_mybatis_plus`;
CREATE TABLE `user_mybatis_plus` (
  `id` bigint NOT NULL COMMENT '主键ID',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `age` int DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `sex` int DEFAULT NULL COMMENT ' 1 2表示性别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user_mybatis_plus
-- ----------------------------
INSERT INTO `user_mybatis_plus` VALUES ('2', 'Sandy', '200', 'update', '1');
INSERT INTO `user_mybatis_plus` VALUES ('3', 'zs', '200', 'update', '1');
INSERT INTO `user_mybatis_plus` VALUES ('5', 'Billie', '200', 'update', '1');
INSERT INTO `user_mybatis_plus` VALUES ('1640653530477686785', 'name0', '200', 'update', '1');
INSERT INTO `user_mybatis_plus` VALUES ('1640653530586738689', 'name1', '200', 'update', '1');
INSERT INTO `user_mybatis_plus` VALUES ('1640653530586738690', 'name2', '200', 'update', '1');
INSERT INTO `user_mybatis_plus` VALUES ('1640653530586738691', 'name3', '200', 'update', '1');
INSERT INTO `user_mybatis_plus` VALUES ('1640653530586738692', 'name4', '200', 'update', '1');
INSERT INTO `user_mybatis_plus` VALUES ('1641075536146771969', 'new index', '200', 'update', '2');
