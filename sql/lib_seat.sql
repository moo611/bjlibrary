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

 Date: 27/03/2025 14:24:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for lib_seat
-- ----------------------------
DROP TABLE IF EXISTS `lib_seat`;
CREATE TABLE `lib_seat`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '座位号',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '0、空闲1、占用',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '删除标识',
  `create_time` datetime NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lib_seat
-- ----------------------------
INSERT INTO `lib_seat` VALUES (1, '1', '1', '0', '2025-03-27 13:39:23', NULL, NULL, NULL);
INSERT INTO `lib_seat` VALUES (2, '2', '1', '0', '2025-03-27 13:40:11', NULL, NULL, NULL);
INSERT INTO `lib_seat` VALUES (3, '3', '0', '0', '2025-03-27 13:40:13', NULL, NULL, NULL);
INSERT INTO `lib_seat` VALUES (4, '4', '0', '0', '2025-03-27 13:40:15', NULL, NULL, NULL);
INSERT INTO `lib_seat` VALUES (5, '5', '0', '0', '2025-03-27 13:40:18', NULL, NULL, NULL);
INSERT INTO `lib_seat` VALUES (6, '6', '0', '0', '2025-03-27 13:40:20', NULL, NULL, NULL);
INSERT INTO `lib_seat` VALUES (7, '7', '0', '0', '2025-03-27 13:40:23', NULL, NULL, NULL);
INSERT INTO `lib_seat` VALUES (8, '8', '0', '0', '2025-03-27 13:40:26', NULL, NULL, NULL);
INSERT INTO `lib_seat` VALUES (9, '9', '0', '0', '2025-03-27 13:40:28', NULL, NULL, NULL);
INSERT INTO `lib_seat` VALUES (10, '10', '0', '0', '2025-03-27 13:40:31', NULL, NULL, NULL);
INSERT INTO `lib_seat` VALUES (11, '11', '0', '0', '2025-03-27 13:41:24', NULL, NULL, NULL);
INSERT INTO `lib_seat` VALUES (12, '12', '0', '0', '2025-03-27 13:41:56', NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
