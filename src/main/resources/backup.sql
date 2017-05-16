-- h2建表
DROP table if exists user;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `userId` varchar(32) NOT NULL COMMENT '用户唯一标识',
  `nickname` varchar(32) NOT NULL COMMENT '昵称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_user_id` (`userId`)
);

-- mysql建表
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `userId` varchar(32) NOT NULL COMMENT '用户唯一标识',
  `nickname` varchar(32) NOT NULL COMMENT '昵称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_user_id` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户表';

