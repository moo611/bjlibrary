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

 Date: 27/03/2025 14:24:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for lib_user
-- ----------------------------
DROP TABLE IF EXISTS `lib_user`;
CREATE TABLE `lib_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '昵称',
  `role` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '删除标识',
  `create_time` datetime NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lib_user
-- ----------------------------
INSERT INTO `lib_user` VALUES (1, 'admin', '$2a$10$TgxXAaRt8m9Vr1NO/G/IP.NZsp0PTnB3.Muixg48dMabV73JCEKpS', '管理员', '0', '0', '2025-03-26 15:37:06', NULL, NULL, NULL);
INSERT INTO `lib_user` VALUES (2, 'user1', '$2a$10$JugLMZA2MK5gNzezKNeQ1O5.ycC0mvWgGgU5oRcYND0.Wapy/7BN6', '小王', '1', '0', '2025-03-27 11:27:26', NULL, NULL, NULL);
INSERT INTO `lib_user` VALUES (3, 'user2', '$2a$10$KFMAOLDr8teHFwf7JJcLOuddbuNzTl.V0irj5PEzJZKwKTYXDZyUa', '小李', '1', '0', '2025-03-27 13:57:06', NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
