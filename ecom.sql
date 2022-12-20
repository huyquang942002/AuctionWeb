/*
 Navicat Premium Data Transfer

 Source Server         : trung
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : ecom

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 20/12/2022 20:57:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `category` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT 'book',
  `winner_id` int NULL DEFAULT NULL,
  `max_price` decimal(10, 2) NOT NULL DEFAULT 0.00,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `introduce` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `picture` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `state` int NOT NULL DEFAULT 1 COMMENT '1：表示未卖出\\n2：已卖出',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES (1, 1, 'book', 1, 3200.00, 2999.00, 'Leloup,Roger - Dessin original(1983)', 'img/book/book11.jpg', '2023-02-01 23:42:21', 1);
INSERT INTO `t_book` VALUES (2, 1, 'book', 1, 0.00, 2300.00, 'Blake&Mortimer T4(2017)', 'img/book/book12.jpg', '2023-02-01 23:42:21', 1);
INSERT INTO `t_book` VALUES (3, 1, 'book', 1, 0.00, 5423.00, 'Barbe Rouge T2 - Le Roi des septs mers(1962)', 'img/book/book13.jpg', '2023-02-01 23:42:21', 1);
INSERT INTO `t_book` VALUES (4, 1, 'book', 1, 3702.00, 3700.00, 'Asterix T2 - La Serpe(1962)', 'img/book/book14.jpg', '2023-02-01 23:42:21', 1);
INSERT INTO `t_book` VALUES (5, 1, 'book', 1, 0.00, 587.00, 'Evelyn Paul, D.G. Rossetti - Stories from Dante - 1910', 'img/book/book15.jpg', '2023-02-01 23:42:21', 1);
INSERT INTO `t_book` VALUES (6, 1, 'book', 1, 0.00, 373.00, 'Tintin T23 - Tintin et les Picaros - Tirage Cocktail', 'img/book/book16.jpg', '2023-02-01 23:42:21', 1);

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category`  (
  `id` int NOT NULL,
  `type` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `describe` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES (1, 'book', '书籍漫画');
INSERT INTO `t_category` VALUES (2, 'watch', '手表');
INSERT INTO `t_category` VALUES (3, 'stamp', '邮票及钱币');
INSERT INTO `t_category` VALUES (4, 'wine', '葡萄酒及威士忌');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `commodity_id` int NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `winner_id` int NULL DEFAULT NULL,
  `user_id` int NULL DEFAULT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `category` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `date`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_stamp
-- ----------------------------
DROP TABLE IF EXISTS `t_stamp`;
CREATE TABLE `t_stamp`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `category` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT 'stamp',
  `winner_id` int NULL DEFAULT NULL,
  `max_price` decimal(10, 2) NOT NULL DEFAULT 0.00,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `introduce` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `picture` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `state` int NOT NULL DEFAULT 1 COMMENT '1：表示未卖出\\n2：已卖出',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_stamp
-- ----------------------------
INSERT INTO `t_stamp` VALUES (1, 1, 'stamp', 1, 0.00, 3560.00, 'Tem đẹp', 'img/stamp/tem1.jpg', '2023-01-04 00:58:41', 1);
INSERT INTO `t_stamp` VALUES (2, 1, 'stamp', 1, 0.00, 605.00, 'Tem đẹp', 'img/stamp/tem2.jpg', '2022-12-21 01:34:09', 1);
INSERT INTO `t_stamp` VALUES (3, 1, 'stamp', 1, 0.00, 85.00, 'Tem đẹp', 'img/stamp/tem3.jpg', '2022-12-21 01:36:31', 1);
INSERT INTO `t_stamp` VALUES (4, 1, 'stamp', 1, 0.00, 56.00, 'Tem đẹp', 'img/stamp/tem4.jpg', '2022-12-21 01:37:32', 1);
INSERT INTO `t_stamp` VALUES (5, 1, 'stamp', 1, 0.00, 47.00, 'Tem đẹp', 'img/stamp/tem5.jpg', '2022-12-23 01:39:07', 1);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `password` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `address` varchar(300) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `bought_number` int NOT NULL DEFAULT 0,
  `auction_number` int NOT NULL DEFAULT 0,
  `admin` int NOT NULL DEFAULT 1 COMMENT '0为管理员，1为普通用户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'huy', '1234', '18681698888', '54A tân lập 1 , hiệp phú , Q9', 1, 6, 0);
INSERT INTO `t_user` VALUES (2, 'huy1', '123', '18681690000', 'Thủ đức', 0, 3, 1);

-- ----------------------------
-- Table structure for t_watch
-- ----------------------------
DROP TABLE IF EXISTS `t_watch`;
CREATE TABLE `t_watch`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '1',
  `user_id` int NOT NULL,
  `category` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT 'watch',
  `winner_id` int NULL DEFAULT NULL,
  `max_price` decimal(10, 2) NOT NULL DEFAULT 0.00,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `introduce` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `picture` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `state` int NOT NULL DEFAULT 1 COMMENT '1：表示未卖出\\\\n2：表示卖出，默认为1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_watch
-- ----------------------------
INSERT INTO `t_watch` VALUES (2, 1, 'watch', 0, 0.00, 2300.00, 'OysterDate Precision - 6694- 1960-1969', 'img/watch/app1.jpg', '2023-06-04 15:30:29', 1);
INSERT INTO `t_watch` VALUES (3, 3, 'watch', 0, 0.00, 459.00, 'Eterna - Artena Lady - 2510.41.45.0273 - 女士 - 2011至现在', 'img/watch/app2.jpg', '2022-06-05 15:30:29', 1);
INSERT INTO `t_watch` VALUES (4, 3, 'watch', 0, 0.00, 2068.00, 'Rapport London - Paramount Nine Watch Winder - W409 - 中性 - 2011至现在', 'img/watch/app3.jpg', '2022-12-20 15:30:29', 1);
INSERT INTO `t_watch` VALUES (5, 2, 'watch', 0, 0.00, 2681.00, 'Chopard - St Moritz Gold/Steel - 8024 - 女士 - 2000-2010', 'img/watch/app4.jpg', '2022-12-20 15:30:29', 1);

-- ----------------------------
-- Table structure for t_wine
-- ----------------------------
DROP TABLE IF EXISTS `t_wine`;
CREATE TABLE `t_wine`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `category` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT 'wine',
  `winner_id` int NULL DEFAULT NULL,
  `max_price` decimal(10, 2) NOT NULL DEFAULT 0.00,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `introduce` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `picture` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `state` int NOT NULL DEFAULT 1 COMMENT '1：表示未卖出\\n2：已卖出',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_wine
-- ----------------------------
INSERT INTO `t_wine` VALUES (1, 1, 'wine', 1, 0.00, 10000.00, 'asd', 'img/wine/wine1.jpg', '2022-12-18 00:51:51', 1);
INSERT INTO `t_wine` VALUES (2, 1, 'wine', 1, 0.00, 100000.00, 'kh có gì', 'img/wine/wine2.jpg', '2022-12-18 03:18:42', 1);
INSERT INTO `t_wine` VALUES (3, 1, 'wine', 1, 0.00, 99999999.99, 'rượu ngon', 'img/wine/wine3.jpg', '2022-12-18 03:19:45', 1);
INSERT INTO `t_wine` VALUES (4, 1, 'wine', 1, 0.00, 99999999.99, 'good', 'img/wine/wine4.jpg', '2022-12-18 03:20:15', 1);

SET FOREIGN_KEY_CHECKS = 1;
