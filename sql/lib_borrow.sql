/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : ry-vue

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 27/03/2025 14:23:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for lib_borrow
-- ----------------------------
DROP TABLE IF EXISTS `lib_borrow`;
CREATE TABLE `lib_borrow`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `book_id` int NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '借阅人',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '0、借阅中1、已归还',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '删除标识',
  `create_time` datetime NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lib_borrow
-- ----------------------------
INSERT INTO `lib_borrow` VALUES (1, 3, 'user1', '1', '0', '2025-03-27 11:31:21', NULL, '2025-03-27 11:51:15', NULL);
INSERT INTO `lib_borrow` VALUES (2, 2, 'user1', '1', '0', '2025-03-27 11:31:46', NULL, '2025-03-27 14:17:13', NULL);
INSERT INTO `lib_borrow` VALUES (3, 2, 'user2', '1', '0', '2025-03-27 14:00:07', NULL, '2025-03-27 14:17:35', NULL);

SET FOREIGN_KEY_CHECKS = 1;
