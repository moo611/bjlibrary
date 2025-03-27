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

 Date: 27/03/2025 14:24:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for lib_store
-- ----------------------------
DROP TABLE IF EXISTS `lib_store`;
CREATE TABLE `lib_store`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `book_id` int NULL DEFAULT NULL,
  `in_store_num` int NULL DEFAULT NULL COMMENT '入库数量',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '删除标识',
  `create_time` datetime NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lib_store
-- ----------------------------
INSERT INTO `lib_store` VALUES (1, 3, 10, '0', '2025-03-26 17:51:00', NULL, NULL, NULL);
INSERT INTO `lib_store` VALUES (2, 2, 5, '0', '2025-03-26 17:52:32', NULL, NULL, NULL);
INSERT INTO `lib_store` VALUES (3, 1, 20, '0', '2025-03-26 17:52:39', NULL, NULL, NULL);
INSERT INTO `lib_store` VALUES (4, 1, 5, '0', '2025-03-26 17:52:56', NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
