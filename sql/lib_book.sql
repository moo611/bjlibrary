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

 Date: 27/03/2025 14:23:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for lib_book
-- ----------------------------
DROP TABLE IF EXISTS `lib_book`;
CREATE TABLE `lib_book`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '名称',
  `category` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '类别',
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '作者',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '内容',
  `store_num` int NULL DEFAULT 0 COMMENT '库存',
  `image_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '删除标识',
  `create_time` datetime NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lib_book
-- ----------------------------
INSERT INTO `lib_book` VALUES (1, '百年孤独', '0', '加西亚·马尔克斯', '多年以后，奥雷里亚诺·布恩迪亚上校面对行刑队时，将会想起父亲带他见识冰块的那个遥远的下午', 25, 'https://ssyttest.oss-cn-hangzhou.aliyuncs.com/avatar/cb741c42-d370-4d07-9e91-ff86be17275f_bngd.jpg', '0', '2025-03-26 17:30:54', NULL, NULL, NULL);
INSERT INTO `lib_book` VALUES (2, '人类简史', '1', '尤瓦尔·赫拉利', '人类以为自己驯化了小麦，但其实是小麦驯化了人类。农业革命后，人类被迫定居耕作，腰椎间盘突出和阶级压迫随之而来', 5, 'https://ssyttest.oss-cn-hangzhou.aliyuncs.com/avatar/c13e4474-3f6b-47e9-bb0f-9917690e0373_rljs.jpg', '0', '2025-03-26 17:32:50', NULL, NULL, NULL);
INSERT INTO `lib_book` VALUES (3, '时间简史', '2', '霍金', '宇宙最初是一个奇点，时间和空间在此处失去意义。大爆炸后的10^-43秒内，物理法则尚未诞生。', 10, 'https://ssyttest.oss-cn-hangzhou.aliyuncs.com/avatar/d35b1bb0-45b4-4ef2-85e2-07ef089e1788_sjjs.jpg', '0', '2025-03-26 17:34:01', NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
