/*
 Navicat Premium Data Transfer

 Source Server         : aa
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : orderfood

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 03/09/2021 19:59:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '地址编号',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '学生公寓10栋' COMMENT '地址',
  `userid` int(11) NOT NULL COMMENT '学生编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES (2, '学生公寓10栋313', 18);
INSERT INTO `address` VALUES (3, '学生公寓8栋302', 1);
INSERT INTO `address` VALUES (7, '学生公寓10栋308', 18);
INSERT INTO `address` VALUES (9, '学生公寓10栋322', 18);

-- ----------------------------
-- Table structure for complain
-- ----------------------------
DROP TABLE IF EXISTS `complain`;
CREATE TABLE `complain`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '投诉id',
  `orderid` int(11) NOT NULL COMMENT '投诉订单id',
  `userid` int(11) NOT NULL COMMENT '投诉用户id',
  `call` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户联系方式',
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '投诉内容',
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '未处理' COMMENT '投诉状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of complain
-- ----------------------------
INSERT INTO `complain` VALUES (1, 12, 18, '14322122312', '还没送到??饿死了', '已完成');
INSERT INTO `complain` VALUES (2, 13, 18, '123', '', '未处理');
INSERT INTO `complain` VALUES (3, 16, 18, '123', '', '未处理');
INSERT INTO `complain` VALUES (4, 26, 18, '15580542101', '太难吃了', '未处理');

-- ----------------------------
-- Table structure for detail
-- ----------------------------
DROP TABLE IF EXISTS `detail`;
CREATE TABLE `detail`  (
  `detailid` int(11) NOT NULL AUTO_INCREMENT,
  `orderid` int(11) NOT NULL,
  `foodid` int(11) NOT NULL,
  `number` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`detailid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of detail
-- ----------------------------
INSERT INTO `detail` VALUES (3, 5, 6, 2);
INSERT INTO `detail` VALUES (4, 6, 10, 2);
INSERT INTO `detail` VALUES (5, 7, 4, 3);
INSERT INTO `detail` VALUES (6, 8, 4, 2);
INSERT INTO `detail` VALUES (7, 9, 4, 2);
INSERT INTO `detail` VALUES (14, 13, 6, 1);
INSERT INTO `detail` VALUES (15, 13, 7, 1);
INSERT INTO `detail` VALUES (16, 13, 8, 1);
INSERT INTO `detail` VALUES (17, 14, 6, 4);
INSERT INTO `detail` VALUES (18, 14, 20, 3);
INSERT INTO `detail` VALUES (19, 14, 22, 5);
INSERT INTO `detail` VALUES (20, 15, 7, 4);
INSERT INTO `detail` VALUES (21, 16, 10, 1);
INSERT INTO `detail` VALUES (22, 16, 11, 1);
INSERT INTO `detail` VALUES (23, 17, 7, 2);
INSERT INTO `detail` VALUES (24, 18, 4, 2);
INSERT INTO `detail` VALUES (25, 19, 4, 1);
INSERT INTO `detail` VALUES (26, 20, 4, 1);
INSERT INTO `detail` VALUES (27, 21, 4, 1);
INSERT INTO `detail` VALUES (28, 22, 4, 3);
INSERT INTO `detail` VALUES (29, 23, 4, 3);
INSERT INTO `detail` VALUES (30, 24, 6, 1);
INSERT INTO `detail` VALUES (31, 25, 11, 2);
INSERT INTO `detail` VALUES (32, 26, 3, 3);
INSERT INTO `detail` VALUES (33, 26, 4, 1);

-- ----------------------------
-- Table structure for echarts
-- ----------------------------
DROP TABLE IF EXISTS `echarts`;
CREATE TABLE `echarts`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `foodid` int(11) NOT NULL COMMENT '菜品id',
  `foodname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜品名',
  `number` int(11) NOT NULL COMMENT '已销售总数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of echarts
-- ----------------------------

-- ----------------------------
-- Table structure for food
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food`  (
  `foodid` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜品id',
  `number` int(10) NOT NULL DEFAULT 5 COMMENT '菜品数量',
  `price` int(10) NOT NULL DEFAULT 5 COMMENT '菜品价格',
  `sort` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '炒菜' COMMENT '种类',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜品图片',
  `storeid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '一食堂' COMMENT '卖家信息',
  `foodname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜品名称',
  PRIMARY KEY (`foodid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of food
-- ----------------------------
INSERT INTO `food` VALUES (1, 20, 5, '快餐', '11cdbc6900344ab0b1382ce583c70b942.jpg', '一食堂', '汉堡');
INSERT INTO `food` VALUES (2, 5, 10, '炒菜', 'ad6365af953d4f6294999a6c3f9fe9b89159397d17ea4653a9996e7af2c79549_th.jpeg', '小炒部', '青椒炒蛋');
INSERT INTO `food` VALUES (3, 16, 5, '炒菜', '107c953a74dd4f0bbaddb662818badb620190706156240672958810169539.jpg', '二食堂', '黄瓜炒蛋');
INSERT INTO `food` VALUES (4, 77, 2, '饮品', 'e7a050e38fe14a978067a32c8f01e736201904060422061186641823_jpeg_350_300_56829.jpg', '饮料店', '矿泉水');
INSERT INTO `food` VALUES (5, 10, 5, '炒菜', 'c2422100bc6e4f1a865c3b84fe64cfad20190706156240672958810169539.jpg', '二食堂', '黄瓜炒火腿');
INSERT INTO `food` VALUES (6, 12, 90, '蒸菜', '5b36788c93204479b82bf3fe430d32e13.jpg', '蒸菜馆', '清蒸大闸蟹');
INSERT INTO `food` VALUES (7, 43, 10, '炒菜', '3a8bdd366585465c8111effa536238b4a608fyrhcqz1634729.jpg', '二食堂', '外婆菜');
INSERT INTO `food` VALUES (8, 19, 5, '饮品', 'b827d7af49334d268be615a183beaa0c6335c5ebaf164c9ebd95964b55f8d2da.jpeg', '饮料店', '脉动');
INSERT INTO `food` VALUES (9, 5, 5, '饮品', 'c76b59393be3478a9331f7353af84b646335c5ebaf164c9ebd95964b55f8d2da.jpeg', '超市', '乳酸菌');
INSERT INTO `food` VALUES (10, 9, 15, '饮品', '2400daf94b6d46408f200d21dbcca20e2009181174489_2.jpg', '奶茶店', '葡萄啵啵');
INSERT INTO `food` VALUES (11, 37, 5, '炒菜', 'c59c109ffff9446c97e5b296aaff0761center.jpg', '一食堂', '黄瓜炒火腿');
INSERT INTO `food` VALUES (12, 5, 5, '炒菜', '4b8ac7a7e82946fba7b344e0d71070e69159397d17ea4653a9996e7af2c79549_th.jpeg', '一食堂', '西红柿炒蛋');
INSERT INTO `food` VALUES (13, 5, 5, '炒菜', 'f773ea635b4a456ba41b6b577d7093eedc792d5d7d10540f0cd40966749849d3.jpg', '一食堂', '蒸蛋');
INSERT INTO `food` VALUES (14, 5, 5, '炒菜', 'bacf73281fd64eca8a97d88ff6102d770.jpg', '一食堂', '鸡腿');
INSERT INTO `food` VALUES (15, 5, 5, '炒菜', '74019d1e421d46a895253e3e2f2bf13a9e2598eeb4c34671b431f44ff0ca25f0.jpeg', '一食堂', '蛋饺');
INSERT INTO `food` VALUES (16, 30, 20, '饮品', '8fc5c3f696f64671a9227207dfc11161a7e05a53affe4b25a6aa6c8840f2def8.jpeg', '冷饮部', '杨枝甘露');
INSERT INTO `food` VALUES (19, 15, 30, '饮品', '4be02e6d2f3046ccac8561916d8aa189yinliao_3755500.jpg', '奶茶部', '蓝色妖姬');
INSERT INTO `food` VALUES (20, 2, 35, '水煮菜', '72ef3efe1b464a1794c321f051febbe67ece6cf169954ed08cc0a2c151e65860.jpeg', '一食堂', '酸菜鱼');
INSERT INTO `food` VALUES (21, 20, 55, '凉菜', 'a50312d108b94ed48b73a3e6068dcbe70.jpg', '二食堂', '手撕鸡');
INSERT INTO `food` VALUES (22, 45, 15, '炒菜', '23d2df290ba043d5a8fdf3010304a10d1250975975.jpeg', '小炒部', '可乐鸡翅');
INSERT INTO `food` VALUES (23, 20, 20, '饮品', 'f0519eeef0f84f5c8e1a02433e771cf756063350.jpg', '小卖部', '西瓜汁');
INSERT INTO `food` VALUES (24, 20, 10, '炒菜', '0e86c471874f41a2bb0a7caeb2b17caa2019070915626753556879702111.jpg', '小炒部', '辣椒炒火腿');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `orderid` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `userid` int(11) NOT NULL COMMENT '订餐人',
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '已接单' COMMENT '订单状态',
  `allprice` int(255) NOT NULL DEFAULT 0 COMMENT '总价格',
  `to` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订餐地址',
  `time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订餐时间',
  PRIMARY KEY (`orderid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (5, 18, '已完成', 180, '学生公寓10栋313', '2021-08-30 09:43:42');
INSERT INTO `order` VALUES (6, 18, '已完成', 30, '学生公寓10栋313', '2021-08-30 09:48:40');
INSERT INTO `order` VALUES (7, 18, '已完成', 6, '学生公寓10栋313', '2021-08-30 10:46:25');
INSERT INTO `order` VALUES (8, 18, '已完成', 4, '学生公寓10栋313', '2021-08-30 10:49:30');
INSERT INTO `order` VALUES (9, 18, '已完成', 4, '学生公寓10栋313', '2021-08-30 10:52:30');
INSERT INTO `order` VALUES (13, 18, '刚下单', 105, '学生公寓10栋308', '2021-08-31 20:03:35');
INSERT INTO `order` VALUES (14, 18, '刚下单', 540, '学生公寓10栋313', '2021-09-02 09:59:29');
INSERT INTO `order` VALUES (15, 18, '刚下单', 40, '学生公寓10栋313', '2021-09-02 10:13:58');
INSERT INTO `order` VALUES (16, 18, '刚下单', 20, '学生公寓10栋313', '2021-09-02 10:35:05');
INSERT INTO `order` VALUES (17, 18, '刚下单', 20, '学生公寓10栋308', '2021-09-02 10:48:44');
INSERT INTO `order` VALUES (18, 18, '刚下单', 4, '学生公寓10栋311', '2021-09-02 11:00:17');
INSERT INTO `order` VALUES (19, 18, '刚下单', 2, '学生公寓10栋313', '2021-09-02 11:03:09');
INSERT INTO `order` VALUES (20, 18, '刚下单', 2, '学生公寓10栋313', '2021-09-02 11:09:46');
INSERT INTO `order` VALUES (21, 18, '刚下单', 2, '学生公寓10栋313', '2021-09-02 11:15:07');
INSERT INTO `order` VALUES (22, 18, '刚下单', 6, '学生公寓10栋311', '2021-09-02 14:56:17');
INSERT INTO `order` VALUES (23, 18, '刚下单', 6, '学生公寓10栋311', '2021-09-02 15:02:25');
INSERT INTO `order` VALUES (24, 18, '刚下单', 90, '学生公寓10栋311', '2021-09-02 15:10:24');
INSERT INTO `order` VALUES (25, 18, '刚下单', 10, '学生公寓10栋311', '2021-09-03 17:00:37');
INSERT INTO `order` VALUES (26, 18, '刚下单', 17, '学生公寓10栋311', '2021-09-03 17:18:08');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userid` int(20) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `username` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '111111' COMMENT '密码',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户手机号',
  `email` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `gender` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '用户性别',
  `score` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '积分',
  `vip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'no' COMMENT '是否vip',
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin', NULL, NULL, '0', NULL, 'yes');
INSERT INTO `user` VALUES (2, 'qqq', '111111', NULL, NULL, '0', NULL, 'no');
INSERT INTO `user` VALUES (3, 'www', '111111', NULL, NULL, '0', NULL, 'no');
INSERT INTO `user` VALUES (4, 'eee', '111111', NULL, NULL, '0', NULL, 'no');
INSERT INTO `user` VALUES (18, 'andy', '111111', '15580542021', '277678@qq.com', '女', 0000000020, 'yes');
INSERT INTO `user` VALUES (19, 'anni', '111111', '15678227532', '2231@qq.com', '男', 0000000002, 'no');
INSERT INTO `user` VALUES (20, 'yunyun', '111111', '15580543023', 'din@163.com', '女', 0000000010, 'yes');
INSERT INTO `user` VALUES (21, 'ass', '111111', NULL, NULL, '男', NULL, 'no');
INSERT INTO `user` VALUES (22, 'andyuuu', '111111', '12345212321', NULL, NULL, NULL, 'no');
INSERT INTO `user` VALUES (24, 'b', '111111', NULL, NULL, '0', NULL, 'no');
INSERT INTO `user` VALUES (25, 'c', '111111', NULL, NULL, '0', NULL, 'no');
INSERT INTO `user` VALUES (26, 'd', '111111', NULL, NULL, '0', NULL, 'no');
INSERT INTO `user` VALUES (27, 'e', '111111', NULL, NULL, '0', NULL, 'no');
INSERT INTO `user` VALUES (28, 'f', '111111', NULL, NULL, '0', NULL, 'no');
INSERT INTO `user` VALUES (29, 'g', '111111', NULL, NULL, '0', NULL, 'no');
INSERT INTO `user` VALUES (30, 'h', '111111', NULL, NULL, '0', NULL, 'no');
INSERT INTO `user` VALUES (34, 'andway', '111111', '12312211213', '1111@qq.com', '男', NULL, 'no');
INSERT INTO `user` VALUES (36, 'hedi', '111111', '12322121121', '223212@qq.com', '男', NULL, 'no');
INSERT INTO `user` VALUES (37, 'addddd', '111111', '15580542321', '277678@qq.com', '男', NULL, 'no');

SET FOREIGN_KEY_CHECKS = 1;
