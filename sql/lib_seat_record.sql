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

 Date: 27/03/2025 14:24:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for lib_seat_record
-- ----------------------------
DROP TABLE IF EXISTS `lib_seat_record`;
CREATE TABLE `lib_seat_record`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `seat_id` int NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '预约人',
  `start_time` datetime NULL DEFAULT NULL,
  `end_time` datetime NULL DEFAULT NULL,
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '删除标识',
  `create_time` datetime NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '座位号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lib_seat_record
-- ----------------------------
INSERT INTO `lib_seat_record` VALUES (1, NULL, 'user1', '2025-03-27 00:00:00', '2025-03-28 00:00:00', '2', '2025-03-27 13:42:46', NULL, '2025-03-27 13:56:42', NULL, '1');
INSERT INTO `lib_seat_record` VALUES (2, NULL, 'user2', '2025-03-26 00:00:00', '2025-03-27 00:00:00', '2', '2025-03-27 14:02:41', NULL, NULL, NULL, '1');
INSERT INTO `lib_seat_record` VALUES (3, NULL, 'user2', '2025-03-27 00:00:00', '2025-03-28 00:00:00', '2', '2025-03-27 14:14:54', NULL, NULL, NULL, '1');
INSERT INTO `lib_seat_record` VALUES (4, NULL, 'user2', '2025-03-27 00:00:00', '2025-03-28 00:00:00', '0', '2025-03-27 14:15:08', NULL, NULL, NULL, '2');
INSERT INTO `lib_seat_record` VALUES (5, NULL, 'user1', '2025-03-26 00:00:00', '2025-03-28 00:00:00', '0', '2025-03-27 14:15:26', NULL, NULL, NULL, '1');

SET FOREIGN_KEY_CHECKS = 1;
