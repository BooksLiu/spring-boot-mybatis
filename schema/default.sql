CREATE TABLE `user` (
  `id` bigint(50) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';