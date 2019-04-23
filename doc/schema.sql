CREATE TABLE `alex_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键, 用户id',
  `account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户名',
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机号码',
  `user_tel` varchar(15) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `passwd` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户密码',
  `group_name` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '所属组织',
  `created` datetime DEFAULT NULL COMMENT '创建日期',
  `modified` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户信息表'