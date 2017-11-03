/*
leaf-club-server 所涉及到的表
*/

SET FOREIGN_KEY_CHECKS=0;#

USE leafclub;

--创建用户表users
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
    `id` INT(10) NOT NULL AUTO_INCREMENT,
    `user_name` VARCHAR(63) NOT NULL unique COMMENT '用户名，值唯一',
    `user_registered_time` BIGINT(20) DEFAULT NULL COMMENT '用户注册时间',
    `user_img` VARCHAR(10230) DEFAULT NULL COMMENT '用户头像',
    `user_email` VARCHAR(63) DEFAULT NULL COMMENT '用户邮箱',
    `user_phone` VARCHAR(15) DEFAULT NULL COMMENT '用户手机号',
    `user_age` INT(2) DEFAULT NULL COMMENT '用户年龄',
    `user_sex` INT DEFAULT '2' COMMENT '用户性别，0：女，1：男，2：未知',
    `user_status` INT DEFAULT NULL COMMENT '用户状态',
    `user_nickname` VARCHAR(63) NOT NULL COMMENT '用户昵称，默认为用户名',
    `user_address` VARCHAR(200) DEFAULT NULL COMMENT '用户地址',
    `user_ip` VARCHAR(50) DEFAULT NULL COMMENT '用户的url',
    `extra` VARCHAR(255) DEFAULT NULL COMMENT '保留字段',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--创建用户授权表users_auth
DROP TABLE IF EXISTS `users_auth`;
CREATE TABLE `users_auth` (
    `id` INT(10) NOT NULL AUTO_INCREMENT,
    `user_id` INT(10) DEFAULT NULL COMMENT '关联用户表users的id',
    `identity_type` VARCHAR(15) DEFAULT NULL COMMENT '表示微信登录还是qq登录',
    `access_token` VARCHAR(512) NOT NULL COMMENT '登录所需的token',
    `expires_in` INT(10) DEFAULT '0' COMMENT 'token过期时间',
    `openid` VARCHAR(255) DEFAULT NULL,
    `scope` VARCHAR(255) DEFAULT NULL,
    `extra` VARCHAR(255) DEFAULT NULL COMMENT '保留字段',
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`) REFERENCES users (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--创建博文表blogs
DROP TABLE IF EXISTS `blogs`;
CREATE TABLE `blogs` (
    `id` INT(10) NOT NULL AUTO_INCREMENT,
    `blog_author_id` INT(10) NOT NULL COMMENT '关联用户表users的id',
    `blog_create_time` BIGINT(20) NOT NULL COMMENT '用户创建博文时间',
    `blog_title` VARCHAR(255) NOT NULL COMMENT '博文标题',
    `blog_excerpt` TEXT DEFAULT NULL COMMENT '博文摘要',
    `blog_content` MEDIUMTEXT DEFAULT NULL COMMENT '博文内容',
    `blog_source` MEDIUMTEXT DEFAULT NULL COMMENT '博文源码',
    `blog_file_url` VARCHAR(255) DEFAULT NULL COMMENT '博客存放在文件系统对应的url',
    `blog_type` INT(2) NOT NULL COMMENT '博文对应的类型',
    `blog_type_name` VARCHAR(31) NOT NULL COMMENT '博文所对应类型的名称，如类型0对应前端，类型1对应后端',
    `blog_tag` VARCHAR(63) DEFAULT NULL COMMENT '博文的标签',
    `blog_describe` VARCHAR(255) DEFAULT NULL COMMENT '博文的描述',
    `blog_status` INT DEFAULT '0' COMMENT '博文的状态',
    `blog_comment_count` INT(10) DEFAULT '0' COMMENT '博文的评论数',
    `blog_praise_count` INT(10) DEFAULT '0' COMMENT '博文的点赞数',
    `blog_favorites_count` INT(10) DEFAULT '0' COMMENT '博文收藏数',
    `blog_read_count` INT(10) DEFAULT '0' COMMENT '博文的阅读数',
    `blog_update_time` BIGINT DEFAULT NULL COMMENT '博文的更新时间',
    `extra` VARCHAR(255) DEFAULT NULL COMMENT '保留字段',
    PRIMARY KEY (`id`),
    FOREIGN KEY (`blog_author_id`) REFERENCES users (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--创建博客评论表blog_comments
DROP TABLE IF EXISTS `blog_comments`;
CREATE TABLE `blog_comments` (
    `id` INT(10) NOT NULL AUTO_INCREMENT,
    `comment_blog_id` INT(10) DEFAULT NULL COMMENT '关联博文表blogs的id',
    `comment_user_id` INT(10) DEFAULT NULL COMMENT '关联用户表users的id',
    `comment_time` BIGINT NOT NULL COMMENT '评论时间',
    `comment_praise_count` INT(10) DEFAULT '0' COMMENT '评论点赞数',
    `comment_content` VARCHAR(2047) NOT NULL COMMENT '评论的内容',
    `extra` VARCHAR(255) DEFAULT NULL COMMENT '保留字段',
    PRIMARY KEY (`id`),
    FOREIGN KEY (`comment_blog_id`) REFERENCES blogs (`id`) ON DELETE SET NULL ,
    FOREIGN KEY (`comment_user_id`) REFERENCES blogs (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#评论回复表
DROP TABLE IF EXISTS `blog_replies`;
CREATE TABLE `blog_replies` (
    `id` INT(10) NOT NULL AUTO_INCREMENT,
    `reply_comment_id` INT(10) DEFAULT NULL COMMENT '关联博客评论表blog_comments的id，表示回复是在这条评论下',
    `reply_user_id` INT(10) NOT NULL COMMENT '回复的人，关联用户表users的id',
    `replied_user_id` INT(10) NOT NULL COMMENT '被回复的人，关联用户表users的id',
    `reply_praise_count` INT(10) DEFAULT '0' COMMENT '回复点赞数',
    `reply_content` VARCHAR(2047) NOT NULL COMMENT '回复的内容',
    `reply_time` BIGINT NOT NULL COMMENT '回复的时间',
    `extra` VARCHAR(255) DEFAULT NULL COMMENT '保留字段',
    PRIMARY KEY (`id`),
    FOREIGN KEY (`reply_comment_id`) REFERENCES blog_comments (`id`) ON DELETE SET NULL ,
    FOREIGN KEY (`reply_user_id`) REFERENCES users (`id`),
    FOREIGN KEY (`replied_user_id`) REFERENCES users (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--创建作品表works
DROP TABLE IF EXISTS `works`;
CREATE TABLE `works` (
    `id` INT(10) NOT NULL AUTO_INCREMENT,
    `work_author_id` INT(10) NOT NULL COMMENT '关联用户表users的id',
    `work_create_time` BIGINT NOT NULL COMMENT '作品的上传时间',
    `work_url` VARCHAR(255) NOT NULL COMMENT '作品的url',
    `work_title` VARCHAR(255) DEFAULT NULL COMMENT '作品的标题',
    `work_describe` VARCHAR(2047) DEFAULT NULL COMMENT '作品描述',
    `thumbnail` TEXT DEFAULT  NULL COMMENT '作品缩略图',
    `work_type` INT(2) NOT NULL COMMENT '作品类型',
    `work_type_name` VARCHAR(31) NOT NULL COMMENT '作品类型对应的名称，如0对应前端，1对应后端',
    `work_tag` VARCHAR(63) DEFAULT NULL COMMENT '作品标签',
    `work_status` INT DEFAULT '0' COMMENT '作品的状态',
    `work_comment_count` INT(10) DEFAULT '0' COMMENT '作品的评论数',
    `work_praise_count` INT(10) DEFAULT '0' COMMENT '作品的点赞数',
    `work_favorite_count` INT(10) DEFAULT '0' COMMENT '作品的收藏数',
    `work_read_count` INT(10) DEFAULT '0' COMMENT '作品的阅读量',
    `work_update_time` BIGINT DEFAULT NULL COMMENT '作品的更新时间',
    `extra` VARCHAR(255) DEFAULT NULL COMMENT '保留字段',
    PRIMARY KEY (`id`),
    FOREIGN KEY (`work_author_id`) REFERENCES users (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--创建作品评论表work_comments
DROP TABLE IF EXISTS `work_comments`;
CREATE TABLE `work_comments` (
    `id` INT(10) NOT NULL AUTO_INCREMENT, 
    `comment_work_id` INT(10) DEFAULT NULL COMMENT '关联作品表works的id',
    `comment_user_id` INT(10) NOT NULL COMMENT '关联用户表users的id',
    `comment_time` BIGINT NOT NULL COMMENT '评论的时间',
    `comment_praise_count` INT(10) DEFAULT '0' COMMENT '评论点赞数',
    `comment_content` VARCHAR(2047) NOT NULL COMMENT '评论的内容',
    `extra` VARCHAR(255) DEFAULT NULL COMMENT '保留字段',
    PRIMARY KEY (`id`),
    FOREIGN KEY (`comment_work_id`) REFERENCES works (`id`) ON DELETE SET NULL ,
    FOREIGN KEY (`comment_user_id`) REFERENCES users (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--创建作品评论回复表work_replies
DROP TABLE IF EXISTS `work_replies`;
CREATE TABLE `work_replies` (
    `id` INT(10) NOT NULL AUTO_INCREMENT,
    `reply_comment_id` INT(10) DEFAULT NULL COMMENT '关联作品评论表work_comments的id，表示回复是在这条评论下的',
    `reply_user_id` INT(10) NOT NULL COMMENT '回复的人，关联用户表users的id',
    `replied_user_id` INT(10) NOT NULL COMMENT '被回复的人，关联用户表users的id', 
    `reply_praise_count` INT(10) DEFAULT '0' COMMENT '回复点赞数',
    `reply_content` VARCHAR(2047) NOT NULL COMMENT '回复的内容',
    `reply_time` BIGINT NOT NULL COMMENT '回复的时间',
    `extra` VARCHAR(255) DEFAULT NULL COMMENT '保留字段',
    PRIMARY KEY (`id`),
    FOREIGN KEY (`reply_comment_id`) REFERENCES work_comments (`id`) ON DELETE SET NULL ,
    FOREIGN KEY (`reply_user_id`) REFERENCES users (`id`),
    FOREIGN KEY (`replied_user_id`) REFERENCES users (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--创建用户收藏博文表user_favorites_blogs
DROP TABLE IF EXISTS `user_favorites_blogs`;
CREATE TABLE `user_favorites_blogs` (
    `id` INT(10) NOT NULL AUTO_INCREMENT,
    `user_id` INT(10) NOT NULL COMMENT '关联用户表users的id',
    `favorite_blog_id` INT(10) DEFAULT NULL COMMENT '关联blogs表的id',
    `extra` VARCHAR(255) DEFAULT NULL COMMENT '保留字段',
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`) REFERENCES users (`id`),
    FOREIGN KEY (`favorite_blog_id`) REFERENCES blogs (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--创建用户收藏作品表user_favorites_works
DROP TABLE IF EXISTS `user_favorites_works`;
CREATE TABLE `user_favorites_works` (
    `id` INT(10) NOT NULL AUTO_INCREMENT,
    `user_id` INT(10) NOT NULL COMMENT '关联用户表users的id',
    `favorite_work_id` INT(10) DEFAULT NULL COMMENT '关联works表的id',
    `extra` VARCHAR(255) DEFAULT NULL COMMENT '保留字段',
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`) REFERENCES users (`id`),
    FOREIGN KEY (`favorite_work_id`) REFERENCES works (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--首页展示表index_show
DROP TABLE IF EXISTS `index_show`;
CREATE TABLE `index_show` (
    `id` INT(10) NOT NULL AUTO_INCREMENT,
    `columns` VARCHAR(15) NOT NULL COMMENT '首页展示的栏目',
    `content` TEXT DEFAULT NULL COMMENT '首页的推荐博文或作品',
    `extra` VARCHAR(255) DEFAULT NULL COMMENT '保留字段',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


SET FOREIGN_KEY_CHECKS=1;
